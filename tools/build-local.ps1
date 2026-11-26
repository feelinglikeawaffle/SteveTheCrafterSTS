param(
    [string]$GameDir = ""
)
$ErrorActionPreference = "Stop"
$root = Split-Path -Parent $PSScriptRoot
Set-Location $root

# Resolve the real 32-bit Program Files folder safely; directly expanding
# $env:ProgramFiles(x86) can accidentally drop the space before (x86).
$programFilesX86 = [Environment]::GetFolderPath([Environment+SpecialFolder]::ProgramFilesX86)
if ([string]::IsNullOrWhiteSpace($GameDir)) {
    $GameDir = Join-Path $programFilesX86 "Steam\steamapps\common\SlayTheSpire"
}
$workshopDir = Join-Path $programFilesX86 "Steam\steamapps\workshop\content"

Write-Host "Steve the Crafter - automatic Windows build" -ForegroundColor Cyan
if (-not (Test-Path $GameDir)) {
    throw "Slay the Spire folder not found: $GameDir. If Steam is installed elsewhere, rerun with the actual game folder path."
}

$lib = Join-Path $root "lib"
New-Item -ItemType Directory -Force -Path $lib | Out-Null

function Find-RequiredJar([string]$Name, [string[]]$Roots) {
    foreach ($searchRoot in $Roots) {
        if (Test-Path $searchRoot) {
            $found = Get-ChildItem -Path $searchRoot -Filter $Name -File -Recurse -ErrorAction SilentlyContinue | Select-Object -First 1
            if ($found) { return $found.FullName }
        }
    }
    return $null
}

$searchRoots = @($GameDir, $workshopDir)
$jarMap = @{
    "desktop-1.0.jar" = @($GameDir)
    "ModTheSpire.jar" = $searchRoots
    "BaseMod.jar" = $searchRoots
}
foreach ($name in $jarMap.Keys) {
    $source = Find-RequiredJar $name $jarMap[$name]

    # Steam's current "Play with Mods" setup may use mts-launcher.jar in
    # the game folder instead of ModTheSpire.jar. Use it as the compile-time
    # ModTheSpire dependency when the original jar is not present.
    if (-not $source -and $name -eq "ModTheSpire.jar") {
        $launcherJar = Join-Path $GameDir "mts-launcher.jar"
        if (Test-Path $launcherJar) {
            $source = $launcherJar
            Write-Host "Using mts-launcher.jar as the ModTheSpire dependency"
        }
    }

    if (-not $source) {
        throw "Could not find $name. Confirm ModTheSpire and BaseMod are installed. Expected to find it under: $($jarMap[$name] -join ', ')"
    }
    Copy-Item -LiteralPath $source -Destination (Join-Path $lib $name) -Force
    Write-Host "Found $name"
}

$gradleVersion = "8.7"
$toolsDir = Join-Path $env:LOCALAPPDATA "SteveTheCrafterBuildTools"
$gradleHome = Join-Path $toolsDir "gradle-$gradleVersion"
$zip = Join-Path $toolsDir "gradle-$gradleVersion-bin.zip"
New-Item -ItemType Directory -Force -Path $toolsDir | Out-Null

if (-not (Test-Path (Join-Path $gradleHome "bin\gradle.bat"))) {
    Write-Host "Downloading Gradle $gradleVersion (one-time setup)..."
    Invoke-WebRequest "https://services.gradle.org/distributions/gradle-$gradleVersion-bin.zip" -OutFile $zip
    Expand-Archive -LiteralPath $zip -DestinationPath $toolsDir -Force
}
$gradle = Join-Path $gradleHome "bin\gradle.bat"
& $gradle --no-daemon clean jar
if ($LASTEXITCODE -ne 0) { throw "Gradle build failed with exit code $LASTEXITCODE" }

Write-Host ""
Write-Host "SUCCESS: build\libs\SteveTheCrafterSTS-0.1.0.jar" -ForegroundColor Green

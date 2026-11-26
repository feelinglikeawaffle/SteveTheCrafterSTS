param(
    [string]$GameDir = "$env:ProgramFiles(x86)\Steam\steamapps\common\SlayTheSpire"
)
$ErrorActionPreference = "Stop"
$root = Split-Path -Parent $PSScriptRoot
Set-Location $root

Write-Host "Steve the Crafter - automatic Windows build" -ForegroundColor Cyan
if (-not (Test-Path $GameDir)) {
    throw "Slay the Spire folder not found: $GameDir"
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

$searchRoots = @($GameDir, (Join-Path $env:ProgramFiles(x86) "Steam\steamapps\workshop\content"))
$jarMap = @{
    "desktop-1.0.jar" = @($GameDir)
    "ModTheSpire.jar" = @($GameDir)
    "BaseMod.jar" = $searchRoots
}
foreach ($name in $jarMap.Keys) {
    $source = Find-RequiredJar $name $jarMap[$name]
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

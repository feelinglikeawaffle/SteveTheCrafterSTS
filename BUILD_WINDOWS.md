# Build Steve the Crafter on Windows

This repository contains the mod's source code and original art. It does **not** include Slay the Spire, ModTheSpire, or BaseMod game libraries. Keep those libraries on your PC; do not upload them to this public repository.

## 1. Install the build tools

1. Install a Java 8 JDK (not just a JRE). Slay the Spire's original mod ecosystem targets Java 8.
2. Install Gradle 7.6.4 or another Gradle 7.x release compatible with Java 8.
3. In Steam, install Slay the Spire, ModTheSpire, and BaseMod.

## 2. Download the build branch

Open the repository's **build/compile-ready** branch on GitHub and choose **Code → Download ZIP**. Extract it somewhere simple, for example:

`C:\Games\SteveTheCrafterSTS`

This is a separate copy from the backup branch and from `main`.

## 3. Gather your local mod libraries

Inside the extracted project, create a folder named `lib`.

From your Slay the Spire installation folder, copy:
- `desktop-1.0.jar`

From your installed ModTheSpire and BaseMod folders, copy:
- `ModTheSpire.jar`
- `BaseMod.jar`

Also copy the game's required library JARs from the game's `lib` folder into the project's `lib` folder. Keep the original files in place. The project ignores `lib/*.jar`, so these local files won't be committed by Git.

The game folder is easy to find in Steam: **Library → Slay the Spire → gear icon → Manage → Browse local files**. For ModTheSpire/BaseMod, use their Workshop install locations or the folders created by their installers. If the filenames differ on your setup, use the actual filenames and tell me what you see before renaming anything.

## 4. Build

Open Command Prompt or PowerShell in the extracted project folder and run:

```powershell
gradle clean build
```

If it succeeds, the mod JAR will be in:

`build\libs\SteveTheCrafterSTS-0.1.0.jar`

## 5. Install the JAR

Copy that JAR into the Slay the Spire `mods` folder (the folder used by ModTheSpire), alongside BaseMod. Start the game through **Play with Mods**, then enable BaseMod and Steve the Crafter.

## Troubleshooting

- **Missing package / cannot find symbol:** one or more game or mod framework JARs are missing from `lib`.
- **Java version error:** make sure Gradle is running with a Java 8 JDK.
- **Build succeeds but Steve doesn't appear:** check the ModTheSpire log for a mod ID, metadata, or resource-path error.
- **Animation looks misplaced or crashes:** the sprite animation needs an in-game test; successful compilation alone does not validate its drawing position or texture loading.

Do not upload the game JARs to GitHub. If the build fails, send me the full error text or a screenshot of the first compiler error.

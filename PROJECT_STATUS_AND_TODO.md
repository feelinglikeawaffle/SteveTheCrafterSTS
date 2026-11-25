# Steve the Crafter — Project Status & Remaining Work

Last updated: 2026-11-25  
Repository: https://github.com/feelinglikeawaffle/SteveTheCrafterSTS  
Branch: `main`

This is the hand-off document for continuing the mod. It records what is already in the repository, what has only been prepared outside the repository, and what still needs to be implemented or verified. **“Done” means present in the source/repository; it does not mean compiled or tested in-game.**

## 1. Completed / already present in the repository

### Project scaffold
- [x] Java Gradle project structure exists.
- [x] ModTheSpire metadata exists at `src/main/resources/ModTheSpire.json`.
- [x] Steve character class and custom player/card enum identifiers exist.
- [x] BaseMod card registration is present.
- [x] Character art resource paths are established.
- [x] Shared card-art path is established.
- [x] Asset checking scripts and upload instructions exist.

### Character and resource foundation
- [x] Steve — The Crafter character framework exists.
- [x] Character resource fields and gain/read methods exist.
- [x] Resource enum includes Coal, Copper, Iron, Gold, Redstone, Lapis, Diamond, Emerald, and Ancient Debris.
- [x] Resource gain action exists.
- [x] Starter relic class `SteveInventory` exists and grants starting resources at battle start.

### Card classes currently in source
- [x] Wooden Sword
- [x] Wooden Pickaxe
- [x] Wooden Shield
- [x] Mine Coal
- [x] Make Torch
- [x] Stone Sword
- [x] Mine Copper
- [x] Mine Redstone
- [x] TNT!
- [x] Lapis Enchant

These classes are registered, but this does not yet mean every card has been balanced, tested, or given unique artwork.

### Existing repository art
- [x] Character selection image: `src/main/resources/stevethecrafter/images/char/charSelect.png`
- [x] Character portrait: `src/main/resources/stevethecrafter/images/char/portrait.png`
- [x] Shoulder image 1: `src/main/resources/stevethecrafter/images/char/shoulder1.png`
- [x] Shoulder image 2: `src/main/resources/stevethecrafter/images/char/shoulder2.png`
- [x] Corpse image: `src/main/resources/stevethecrafter/images/char/corpse.png`
- [x] Shared card placeholder: `src/main/resources/stevethecrafter/images/cards/card_placeholder.png`

These are first-pass art assets. They should be reviewed in-game for transparency, cropping, scale, and visual consistency.

### Documentation and helper files
- [x] `README.md`
- [x] `DESIGN.md`
- [x] `ASSETS_NEEDED.md`
- [x] `ASSET_IMPORT_GUIDE.md`
- [x] `scripts/check_assets.py`
- [x] `PRE_TEXTURE_READINESS_AUDIT.md`
- [x] This project status file.

## 2. Imported animation/art pack and current integration

- [x] The imported pixel-art pack is present in the original `character/`, `icons/`, and `rooms/` folders.
- [x] The same image blobs are mirrored into `src/main/resources/stevethecrafter/images/` at runtime paths; original files were kept.
- [x] The 6×8 Steve animation atlas and eight individual strips are imported.
- [x] `SteveSpriteAnimation` reads the atlas through BaseMod's `AbstractAnimation` sprite-rendering path.
- [x] Attack, mining, block, and craft cards request matching animation clips.
- [x] Missing custom orb-layer references were replaced with BaseMod's default orb.
- [ ] Compile and visually verify animation scale, baseline, flip, and timing in-game.
- [ ] Connect walk, hurt, and death clips to relevant gameplay lifecycle events.

The atlas is a sprite-sheet animation, not a Spine skeleton export. Source integration is committed but is not marked tested until built and launched with the local game JARs.

## 3. Remaining implementation work (not textures)

### Build and compatibility
- [ ] Obtain/confirm the exact local Slay the Spire, ModTheSpire, and BaseMod JAR versions.
- [ ] Confirm the expected JAR filenames and dependencies in `build.gradle`.
- [ ] Add a Gradle wrapper or otherwise document a reproducible build command.
- [ ] Compile the project and fix all Java/API errors.
- [ ] Package the mod JAR and verify its resource paths.
- [ ] Launch Slay the Spire with ModTheSpire and BaseMod and check for startup errors.

### Gameplay systems
- [ ] Finish the resource economy: decide where resources persist, how they are spent, and whether they reset between combats/acts/runs.
- [ ] Implement resource spending and crafting recipes (the current resource system mainly stores and grants resources).
- [ ] Add the player-facing inventory/resource UI.
- [ ] Implement actual equipment/crafting effects, including how crafted gear is gained, equipped, upgraded, and removed.
- [ ] Expand the card pool with the planned tools, weapons, armor, enchantments, potions, summons, TNT/explosives, and ore/material cards.
- [ ] Add and implement additional relics with distinct mechanics; currently only the starter relic class is present.
- [ ] Decide whether to add custom events, a crafting station, or other run-map interactions; implement only after the core loop works.
- [ ] Review card/relic rarity, costs, numbers, upgrades, and balance.
- [ ] Test resource gain/spending, card targeting, multi-enemy damage, upgrades, copies, save/load, and run transitions.

### Character animation
- [x] Implement a custom sprite-sheet animation renderer and connect it to SteveCharacter.
- [x] Connect sword, mining, block, and crafting card plays to matching clips.
- [ ] Connect walk, hurt, and death clips to gameplay lifecycle events.
- [ ] Test animation timing, positioning, scale, looping, and transitions in combat.

## 4. Remaining texture/art work

Keep the visual direction consistent: **2D toon / Paper Minecraft-inspired pixel art**, chunky block forms, crisp outlines, readable silhouettes, and distinct ore/tool colors. Avoid relying on one generic image for every card.

### Character textures
Folder: `src/main/resources/stevethecrafter/images/char/`

- [ ] Review/refine `charSelect.png` (256×256).
- [ ] Review/refine `portrait.png` (1000×1000).
- [ ] Review/refine `shoulder1.png` (256×256, transparent).
- [ ] Review/refine `shoulder2.png` (256×256, transparent).
- [ ] Review/refine `corpse.png` (256×256, transparent).

### Unique card art
Folder: `src/main/resources/stevethecrafter/images/cards/`

Create a distinct 512×512 PNG for each card and update that card's constructor to load its matching filename.

- [ ] `wooden_sword.png`
- [ ] `wooden_pickaxe.png`
- [ ] `wooden_shield.png`
- [ ] `mine_coal.png`
- [ ] `make_torch.png`
- [ ] `stone_sword.png`
- [ ] `mine_copper.png`
- [ ] `mine_redstone.png`
- [ ] `tnt.png`
- [ ] `lapis_enchant.png`

### Relic art
Folder to create: `src/main/resources/stevethecrafter/images/relics/`

- [ ] Create `steve_inventory.png` (suggested 128×128).
- [ ] Change `SteveInventory` from the temporary vanilla relic texture to its custom art.
- [ ] Create a separate image for every additional relic added to the mod.

### Other art, if required by the final implementation
- [ ] Ore/material icons for the inventory UI.
- [ ] Tool/equipment icons for crafting and equipment UI.
- [ ] Any custom UI panels/buttons and crafting station/event art.
- [ ] Animation texture pages/sprite frames required by the chosen animation route.

## 5. Final verification checklist

- [ ] Run `python tools/check_assets.py` and fix all missing/wrong-size files (update the checker as new required art is added).
- [ ] Build the JAR successfully from a clean checkout.
- [ ] Confirm all card, relic, character, and animation textures load with no missing-resource errors.
- [ ] Verify Steve appears correctly on the character select screen.
- [ ] Start a run and verify starting deck, starter relic, health, energy, and resource values.
- [ ] Play every card and verify its effects and upgrade.
- [ ] Verify every relic effect.
- [ ] Verify crafting/resource spending and UI.
- [ ] Verify animation loops and transitions in combat.
- [ ] Complete at least one full test run or a documented combat smoke-test pass.
- [ ] Update the README with installation/build instructions and known limitations.

## 6. What is actually blocking the next milestone?

**The project is not yet at “only waiting for textures.”** The code has a foundation and a small initial card/resource set, but it still needs a reproducible build, compilation/API fixes, the complete crafting/resource loop, more gameplay content, custom relic implementation, and a working Steve animation integration.

The texture phase can proceed in parallel. Once the implementation tasks are complete and the project builds/runs with temporary art, the remaining work can be narrowed to replacing the placeholder textures and doing final visual checks.

## 7. Working rules for future updates

- Mark an item complete only after the file/code is actually in the repository.
- Mark build/test tasks complete only after a successful build or in-game check.
- Keep this file updated whenever a task is completed or new scope is agreed.
- Do not describe the mod as playable or texture-only-ready until the final verification checklist supports that claim.

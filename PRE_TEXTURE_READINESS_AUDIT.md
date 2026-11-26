# Pre-texture readiness audit

Last checked: 2026-11-25

This document is the hand-off checklist for the next art pass. It intentionally distinguishes texture work from code/runtime work so the project is not described as playable before it has been built and tested.

## Current repository state

- Steve's character class and 10 card classes are registered in the source.
- Nine run materials and a basic resource-gain action exist.
- One starter relic class exists: `SteveInventory`.
- The five character PNGs and one shared card placeholder PNG are present in the repository.
- All ten card constructors currently point to the same `card_placeholder.png`.
- `SteveInventory` uses the bundled `images/relics/steves_inventory.png` texture.
- The imported animation atlas and all eight strips are mirrored into the mod runtime resource folder.
- Steve now uses a custom sprite-sheet AbstractAnimation renderer; attack, mining, block, and craft cards request their matching clips.
- Hurt and death clips are hooked after player damage; walk is available for future movement transitions. Sprite scale, baseline, and timing remain unverified in-game.
- No custom card-background or energy-orb layers are registered. Steve uses the game's built-in BLUE card frames and orb, avoiding the previously missing texture paths.
- The 12 material, 12 relic, 6 potion, and 4 room icons are mirrored into runtime resources but are not yet wired to custom UI.
- `build.gradle` expects local Slay the Spire, ModTheSpire, and BaseMod JARs in `lib/`. Those JARs are not committed; there is no Gradle wrapper or configured CI build in this repository.
- The latest card-color fallback and per-card image-path changes have not yet been compiled or tested in-game.

## Texture filenames to prepare

Keep these names stable so the next art pass can replace the temporary shared textures without changing card/relic logic.

### Character art

Folder: `src/main/resources/stevethecrafter/images/char/`

| File | Size |
|---|---:|
| `charSelect.png` | 256x256 |
| `portrait.png` | 1000x1000 |
| `shoulder1.png` | 256x256 |
| `shoulder2.png` | 256x256 |
| `corpse.png` | 256x256 |

### Cards

Folder: `src/main/resources/stevethecrafter/images/cards/`

| File | Suggested size | Card |
|---|---:|---|
| `wooden_sword.png` | 512x512 | Wooden Sword |
| `wooden_pickaxe.png` | 512x512 | Wooden Pickaxe |
| `wooden_shield.png` | 512x512 | Wooden Shield |
| `mine_coal.png` | 512x512 | Mine Coal |
| `make_torch.png` | 512x512 | Make Torch |
| `stone_sword.png` | 512x512 | Stone Sword |
| `mine_copper.png` | 512x512 | Mine Copper |
| `mine_redstone.png` | 512x512 | Mine Redstone |
| `tnt.png` | 512x512 | TNT! |
| `lapis_enchant.png` | 512x512 | Lapis Enchant |

### Relics

Folder: `src/main/resources/stevethecrafter/images/relics/`

| File | Suggested size | Relic |
|---|---:|---|
| `steve_inventory.png` | 128x128 | Steve's Inventory |

The relic folder and custom relic art are not yet implemented in code. The current relic uses the game's Burning Blood image as a temporary texture.

### Character animation

Current source runtime: custom `SteveSpriteAnimation` renderer using the imported 6x8 PNG atlas (96x128 frames). The renderer is connected to SteveCharacter and the card classes trigger sword, mining, block, and craft clips. It is a sprite-sheet animation, not a Spine rig.

The atlas and individual strips are mirrored into `src/main/resources/stevethecrafter/images/char/animation/`. The checker now includes their paths and dimensions. Walk, hurt, and death clips still need lifecycle hooks. The renderer has not yet been compiled or visually verified in-game, so scale, baseline, flip direction, and transitions remain open smoke-test items.

## Non-texture work still required

These are not solved by adding PNGs:

1. Verify/fix compilation against the user's exact Slay the Spire, ModTheSpire, and BaseMod JAR versions.
2. Add a visible inventory/resource UI and resource spending/crafting behavior. The current resources are stored and gained but do not yet form a complete crafting loop.
3. Expand the relic pool and implement relic-specific effects; only the starter relic exists.
4. Implement the rest of the intended card pool and balance/test it.
5. Add a walk transition if a future movement/transition hook is needed; verify hurt/death and all clip transitions in combat.
6. Run the asset checker, build the JAR, launch the game, and verify character selection, combat, cards, relics, and animation.

## Definition of ready for final textures

The project can be called “waiting only for textures” only after items 1–6 above are complete or explicitly scoped out, the card/relic classes reference their final stable texture filenames, and the build plus in-game smoke test pass with temporary textures in place.

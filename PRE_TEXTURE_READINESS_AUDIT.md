# Pre-texture readiness audit

Last checked: 2026-11-25

This document is the hand-off checklist for the next art pass. It intentionally distinguishes texture work from code/runtime work so the project is not described as playable before it has been built and tested.

## Current repository state

- Steve's character class and 10 card classes are registered in the source.
- Nine run materials and a basic resource-gain action exist.
- One starter relic class exists: `SteveInventory`.
- The five character PNGs and one shared card placeholder PNG are present in the repository.
- All ten card constructors currently point to the same `card_placeholder.png`.
- `SteveInventory` currently reuses the vanilla Burning Blood relic texture.
- Steve's combat animation still points to the vanilla Ironclad Spine animation.
- A separate animation placeholder ZIP was generated for planning, but its PNG strips are not imported into this repository and are not wired into the game runtime.
- `build.gradle` expects local Slay the Spire, ModTheSpire, and BaseMod JARs in `lib/`. Those JARs are not committed; there is no Gradle wrapper or configured CI build in this repository.
- The code has not yet been compiled or tested in-game.

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

Current runtime: vanilla Ironclad Spine animation. This is a temporary compatibility fallback, not Steve's final animation.

The previously generated 128x128 frame strips (idle, walk, attack, mine, hurt, death) are concept/blockout assets only. A PNG strip cannot be loaded by the current `SpineAnimation` constructor. Before replacing the runtime animation, choose and implement one supported route:
1. Export a Spine skeleton + atlas + texture page compatible with the exact Spine runtime bundled with the target Slay the Spire/BaseMod version; or
2. Implement and test a custom `AbstractAnimation` renderer that plays the frame strips.

Do not rename the PNG strips to Spine filenames; the required skeleton/atlas data must match.

## Non-texture work still required

These are not solved by adding PNGs:

1. Verify/fix compilation against the user's exact Slay the Spire, ModTheSpire, and BaseMod JAR versions.
2. Add a visible inventory/resource UI and resource spending/crafting behavior. The current resources are stored and gained but do not yet form a complete crafting loop.
3. Expand the relic pool and implement relic-specific effects; only the starter relic exists.
4. Implement the rest of the intended card pool and balance/test it.
5. Implement custom Steve combat animation using one of the compatible routes above.
6. Run the asset checker, build the JAR, launch the game, and verify character selection, combat, cards, relics, and animation.

## Definition of ready for final textures

The project can be called “waiting only for textures” only after items 1–6 above are complete or explicitly scoped out, the card/relic classes reference their final stable texture filenames, and the build plus in-game smoke test pass with temporary textures in place.

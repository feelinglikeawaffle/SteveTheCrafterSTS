# Steve the Crafter — asset checklist

This document describes the assets currently wired into the mod. It distinguishes the temporary, safe card-rendering setup from the later high-resolution art pass.

## Character art

Folder: `src/main/resources/stevethecrafter/images/char/`

- `charSelect.png` — 256×256
- `portrait.png` — 1000×1000
- `shoulder1.png` — 256×256
- `shoulder2.png` — 256×256
- `corpse.png` — 256×256

## Current card appearance

Steve now has a dedicated **STEVE** card colour and matching card-library type, so his reward screen can draw from his own card pool instead of offering Defect's blue cards. The build extracts the game's known-good card frames/orbs from the locally installed `desktop-1.0.jar`, bundles them under Steve's resource namespace, and shifts blue accents toward teal. This avoids the old missing-texture crash while keeping the custom character pool separate.

The ten cards no longer all point to the same placeholder. They currently use existing, themed art from the imported resource pack:

| Card | Current art resource |
|---|---|
| Wooden Sword | `images/relics/diamond_sword.png` |
| Wooden Pickaxe | `images/relics/iron_pickaxe.png` |
| Wooden Shield | `images/relics/shield.png` |
| Mine Coal | `images/materials/coal.png` |
| Make a Torch | `images/relics/redstone_torch.png` |
| Stone Sword | `images/relics/diamond_sword.png` |
| Mine Copper | `images/materials/copper.png` |
| Redstone Circuit | `images/materials/redstone.png` |
| TNT! | `images/rooms/nether_portal.png` |
| Lapis Enchantment | `images/relics/enchanted_book.png` |

The Gradle build now converts each source icon into a correctly proportioned 250×190 card illustration and a 500×380 inspect portrait. It preserves the pixel-art style with nearest-neighbour scaling and transparent padding rather than stretching or cropping the icon. These are distinct, correctly sized interim illustrations, not final hand-painted card art. The build currently derives Steve's teal frames/orbs from the game's own card textures. Their final visual polish still needs an in-game screenshot review.

## Imported Steve animation

Runtime folder: `src/main/resources/stevethecrafter/images/char/animation/`

- `steve_animation_atlas.png` — 576×1024 (6 columns × 8 rows; 96×128 frames)
- `idle_strip.png`, `walk_strip.png`, `mine_strip.png`, `sword_strip.png`
- `block_strip.png`, `hurt_strip.png`, `death_strip.png`, `craft_strip.png`
- `animation_frames.json`

The custom sprite-sheet animation renderer is connected to the character. Animation scale, baseline, and timing still require in-game verification.

## Other imported assets

- `images/materials/` — 12 icons, 32×32
- `images/relics/` — 12 icons, 64×64
- `images/potions/` — 6 icons, 32×40
- `images/rooms/` — 4 illustrations, 256×256

These files are available as mod resources. Not all of them are connected to custom gameplay UI yet.

## Verify the import

From the repository root:

```bash
python tools/check_assets.py
```

This checks the source character/card assets and, after a build, all twenty generated card-art PNGs at 250×190 and 500×380. The project still needs an in-game smoke test after each change.


## Expanded card pool art

The current pool now contains 22 cards. The build generates a dedicated 250×190 hand illustration and 500×380 inspect portrait for each card from its corresponding themed source icon. Newly added card art sources are:

- Iron Axe — diamond sword icon
- Cobblestone Guard — shield icon
- Smelt Ore — iron icon
- Forge Strike — Nether Star icon
- Redstone Pulse — redstone icon
- TNT Crate — Nether Portal illustration
- Diamond Edge — diamond icon
- Enchanted Armor — enchanted book icon
- Golden Apple — golden apple icon
- Emerald Trade — emerald icon
- Lapis Focus — lapis icon
- Netherite Hammer — ancient debris icon

The new portraits are functional interim art. A separate painterly illustration pass is still needed for a closer match to the game's hand-painted card art.


## Dedicated Steve card colour textures

The build expects these source textures inside the locally installed `lib/desktop-1.0.jar`, then copies and teal-tints them into the mod JAR:

- `images/512/cardui/card_bg_attack.png`
- `images/512/cardui/card_bg_skill.png`
- `images/512/cardui/card_bg_power.png`
- `images/512/cardui/card_orb.png`
- `images/512/cardui/card_small_orb.png`
- matching 1024× card backgrounds and orb

The generated textures live under `stevethecrafter/images/...` in the final JAR. If a source entry is absent, the build stops with the exact missing path instead of producing a mod that crashes later.

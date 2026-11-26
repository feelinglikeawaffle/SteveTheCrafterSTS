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

Steve currently uses the game's built-in **BLUE** card colour. This is intentional: the previous `BaseMod.addColor` registration referenced custom background/orb PNGs that were not actually in the JAR. Those null textures caused the combat hand-render crash. Using the built-in colour gives BaseMod valid game-owned card backgrounds and energy orbs while the custom teal texture pack is prepared.

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

These are functional interim illustrations, not final card paintings. The imported material/relic icons are small pixel-art assets (32×32 or 64×64), so a later art pass should replace them with dedicated card portraits at 250×190 and matching inspect portraits at 500×380. The game will use the existing base-game frames/orbs until a complete, verified custom card-colour texture set is added.

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

This checks the current character art and all image files referenced by Steve's ten card constructors. The project still needs a local build and in-game smoke test after each change.

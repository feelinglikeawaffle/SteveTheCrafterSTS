# Steve the Crafter — Asset Import & Verification

The complete first-pass pixel-art pack has been imported into the repository and mirrored into the mod's runtime resources. Original top-level art folders remain as source/archive copies.

## Runtime asset folders

All runtime files are under `src/main/resources/stevethecrafter/images/`.

| Folder | Contents |
|---|---|
| `char/` | Character-select, portrait, shoulders, and corpse art |
| `char/animation/` | Steve's 6×8 animation atlas, individual strips, and frame metadata |
| `materials/` | 12 Minecraft material icons |
| `relics/` | 12 relic icons |
| `potions/` | 6 potion icons |
| `rooms/` | 4 room illustrations |
| `cards/` | Shared card placeholder (still used by all 10 current cards) |

The runtime copies use the same Git blob contents as the imported art-pack files in `character/`, `icons/`, and `rooms/`; the original copies were not deleted.

## Steve's animation

The character now uses the custom `SteveSpriteAnimation` renderer and loads:

`stevethecrafter/images/char/animation/steve_animation_atlas.png`

Atlas layout: 6 columns × 8 rows, 96×128 pixels per frame.

- Idle loops by default.
- Attack cards play the sword swing.
- Pickaxe/mining cards play the mining animation.
- Shield cards play the block animation.
- Torch/enchant cards play the crafting animation.
- Walk is included for future movement transitions. Hurt and death now trigger from Steve's player-damage patch; their in-game timing/position still need verification.

The renderer uses a sprite sheet, not a Spine skeleton. You do not need to draw or export a Spine rig.

## Energy orb

The custom orb layer images were not present. Steve now uses BaseMod's built-in default energy orb instead of referencing missing files. This is a safe fallback; custom teal orb art can be added later.

## Check the import

From the repository root:

```bash
python scripts/check_assets.py
```

The checker validates paths and PNG dimensions for character art, all animation sheets, 12 materials, 12 relics, 6 potions, and 4 rooms. It also checks animation metadata.

## Current limitation

Asset paths and the renderer are in source, but the mod has not yet been compiled or launched in Slay the Spire here. The first in-game run should check Steve's size, baseline, flip direction, and clip timing. Material/relic/potion/room art is available as runtime resources but is not yet connected to custom inventory or other UI.

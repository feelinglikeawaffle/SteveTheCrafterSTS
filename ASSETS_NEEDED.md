# Steve the Crafter — asset checklist

The first-pass art pack is already imported into GitHub and mirrored into the mod's runtime resource folder. The original art folders are kept as backups/source copies.

Repository: https://github.com/feelinglikeawaffle/SteveTheCrafterSTS

## Existing character art

Folder: `src/main/resources/stevethecrafter/images/char/`

- `charSelect.png` — 256×256
- `portrait.png` — 1000×1000
- `shoulder1.png` — 256×256
- `shoulder2.png` — 256×256
- `corpse.png` — 256×256

## Existing card art

Folder: `src/main/resources/stevethecrafter/images/cards/`

- `card_placeholder.png` — 512×512

All 10 current cards still use this shared placeholder. Unique card art can be added later without changing the animation import.

## Imported Steve animation

Runtime folder: `src/main/resources/stevethecrafter/images/char/animation/`

- `steve_animation_atlas.png` — 576×1024 (6 columns × 8 rows; 96×128 frames)
- `idle_strip.png`, `walk_strip.png`, `mine_strip.png`, `sword_strip.png`
- `block_strip.png`, `hurt_strip.png`, `death_strip.png`, `craft_strip.png`
- `animation_frames.json`

The custom `SteveSpriteAnimation` renderer is now connected to the character. Idle loops; card plays trigger sword, mining, block, and craft clips. Walk/hurt/death are included but still need lifecycle hooks and in-game testing.

## Imported icons and room art

These files are also mirrored to runtime paths:

- `images/materials/` — 12 icons, 32×32
- `images/relics/` — 12 icons, 64×64
- `images/potions/` — 6 icons, 32×40
- `images/rooms/` — 4 illustrations, 256×256

They are available as mod resources, but aren't yet connected to a custom inventory, relic, potion, or room UI.

## Energy orb

No custom orb layers are required right now. Steve uses BaseMod's built-in default orb because the custom layer files weren't included. This avoids missing-resource paths.

## Verify the import

From the repository root:

```bash
python scripts/check_assets.py
```

The checker now verifies the runtime file paths and expected dimensions for the full art pack. The source integration has not yet been compiled or tested in Slay the Spire; the first run should verify character positioning and animation timing.

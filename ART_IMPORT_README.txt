STEVE THE CRAFTER — PIXEL ART PACK
Clean, blocky pixel art with transparent character frames and icons.

The original top-level art folders are retained. The images are also copied into mod runtime resources:
- character/* -> src/main/resources/stevethecrafter/images/char/animation/
- icons/materials/* -> src/main/resources/stevethecrafter/images/materials/
- icons/relics/* -> src/main/resources/stevethecrafter/images/relics/
- icons/potions/* -> src/main/resources/stevethecrafter/images/potions/
- rooms/* -> src/main/resources/stevethecrafter/images/rooms/

CHARACTER ANIMATION
- character/steve_animation_atlas.png: 6 columns x 8 rows, each frame 96x128.
- character/*_strip.png: one animation per strip.
- character/animation_frames.json: frame counts, row order and timing.
Rows: idle, walk, mine, sword, block, hurt, death, craft.

SteveSpriteAnimation now reads the atlas through BaseMod's AbstractAnimation sprite renderer. Idle loops by default; card plays trigger sword, mining, block, and craft clips. Walk, hurt, and death are included but still need gameplay lifecycle hooks and in-game verification. This is a sprite-sheet animation, not a Spine skeleton export.

ENERGY ORB
No custom orb layers were supplied. Steve uses BaseMod's built-in default orb for now, so no missing custom orb paths are referenced.

OTHER ART
- icons/materials: 32x32 transparent resource icons.
- icons/relics: 64x64 transparent relic icons.
- icons/potions: 32x40 transparent potion icons.
- rooms: 256x256 pixel illustrations for future room/event screens.

Run python scripts/check_assets.py from the repo root to verify runtime paths and dimensions. Build and launch the mod to check animation scale, baseline, flip, and timing.

STEVE THE CRAFTER — PIXEL ART PACK
Clean, simple, blocky pixel art; transparent character frames and icons.

CHARACTER ANIMATION
- character/steve_animation_atlas.png: 6 columns x 8 rows, each frame 96x128.
- character/*_strip.png: one animation per strip.
- character/animation_frames.json: frame counts, row order and suggested timing.
Rows: idle, walk, mine, sword, block, hurt, death, craft.

IMPORTANT: The current Slay the Spire scaffold uses Spine. These PNG strips are animation art/reference assets, not a Spine skeleton+atlas export. They cannot be loaded by the existing SpineAnimation constructor directly.
To animate Steve in-game, either rig/export compatible Spine data using the game's runtime version, or implement a sprite-sheet animation renderer and hook it into the character render/update lifecycle. Do not rename these PNGs to Spine filenames.

OTHER ART
- icons/materials: 32x32 transparent resource icons.
- icons/relics: 64x64 transparent relic icons.
- icons/potions: 32x40 transparent potion icons.
- rooms: 256x256 pixel illustrations for event/room screens.

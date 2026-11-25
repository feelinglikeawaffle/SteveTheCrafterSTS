# Steve character assets — exact checklist

Steve's initial Java character class and character registration have been added. The game still needs image assets before it can load the character. Upload assets to this repository, keeping filenames and folders exactly as listed.

Repository: https://github.com/feelinglikeawaffle/SteveTheCrafterSTS

## How to upload a PNG on GitHub (phone or computer)

1. Open the repository link above and make sure you are on the **main** branch.
2. Tap/click **Add file** → **Upload files**.
3. Select the PNG from your device.
4. If the target folder does not exist yet, use **Add file** → **Create new file**, type the folder path plus a filename like `src/main/resources/stevethecrafter/images/char/KEEP.txt`, and commit it. Then upload the image into that folder.
5. Commit the upload. Send me a message saying which assets you uploaded; I'll wire/check them in the mod.

For creating artwork, use any drawing app you already have. Export as PNG. Transparent background is preferred for the character cutouts.

## First assets to make/upload

Folder: `src/main/resources/stevethecrafter/images/char/`

- `charSelect.png` — Steve's small character-select button artwork. Full-body, recognizable silhouette, centered. 256×256 PNG, transparent.
- `portrait.png` — larger character select portrait, Steve from waist/chest up with a simple Minecraft-themed background. 1000×1000 PNG.
- `shoulder1.png` — combat shoulder portrait, Steve facing inward toward the screen. 256×256 PNG, transparent.
- `shoulder2.png` — alternate combat shoulder portrait, similar pose facing inward. 256×256 PNG, transparent.
- `corpse.png` — defeated Steve portrait. 256×256 PNG, transparent.

**Art direction:** Minecraft Live / Mob Vote-inspired 2D illustration: chunky blocky proportions, recognizable Steve face, expressive pose, clean illustrated shading, consistent colors. Keep Steve's face, hair, shirt, and pants consistent across all five images. Use original fan art, not ripped official art.

## Energy orb textures

Folder: `src/main/resources/stevethecrafter/images/char/orb/`

Transparent PNG files required by the current code:
- `layer1.png`, `layer2.png`, `layer3.png`, `layer4.png`, `layer5.png`, `layer6.png`
- `layer1d.png`, `layer2d.png`, `layer3d.png`, `layer4d.png`, `layer5d.png`
- `vfx.png`

Suggested size: 128×128 each, same center/alignment. These are layered circular energy orb textures, not pictures of Steve. I can give you a simpler visual template later; don't spend time on these before the first character art.

## Character animation

The current Java class uses a Spriter animation file:
`src/main/resources/stevethecrafter/images/char/animation.scml`

It must reference its animation sprite PNGs. A valid Spriter file is a specialized asset; **do not try to hand-write this**. If you don't already have Spriter, tell me and I'll change the character animation approach / provide a simpler placeholder plan.

## Card-frame assets (required for Steve's custom card color)

Folders:
- `src/main/resources/stevethecrafter/images/card/512/`
- `src/main/resources/stevethecrafter/images/card/1024/`

The custom color registration expects:
- 512: `bg_attack.png`, `bg_skill.png`, `bg_power.png`, `card_orb.png`, `card_small_orb.png`
- 1024: `bg_attack.png`, `bg_skill.png`, `bg_power.png`, `card_orb.png`

These are Slay the Spire card frame/background textures. We can postpone custom frames and temporarily use an existing card color while the first playable build is made; I will adjust registration if you prefer not to create these yourself.

## Card illustrations later

No individual card illustrations are needed yet. Once Steve's first cards are implemented, I'll provide a separate list with each card's exact filename, what to draw, and its recommended canvas.

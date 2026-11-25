# Steve character assets — exact checklist

The character class is now wired to these paths. **Steve will not launch until the required assets exist.** Please upload the files to this GitHub repository, keeping names and folder paths exactly as written.

Repository: https://github.com/feelinglikeawaffle/SteveTheCrafterSTS

## Where to upload

Open the repository on GitHub. For PNG files, choose **Add file → Upload files**. Upload into the specified folder path; GitHub will create the folder if needed. For text files, use **Add file → Create new file**.

## Character artwork

Folder: src/main/resources/stevethecrafter/images/char/

- charSelect.png — character selection button, full-body Steve; 256×256 PNG, transparent background.
- portrait.png — large character selection portrait; 1000×1000 PNG.
- shoulder1.png — combat shoulder art; 256×256 PNG, transparent.
- shoulder2.png — alternate combat shoulder art; 256×256 PNG, transparent.
- corpse.png — defeated Steve image; 256×256 PNG, transparent.

Style: Minecraft Live / Mob Vote-inspired 2D illustration. Chunky recognizable Minecraft proportions, expressive face, clean stylized shading, blocky clothes/tools. Keep all art consistent. Make original fan art rather than extracting official promotional artwork.

## Animation and energy orb

The current code expects a Spriter animation file at:
src/main/resources/stevethecrafter/images/char/animation.scml

The SCML must reference its sprite PNGs in the same character folder (or its own referenced relative paths). It needs a looping idle and appropriate animation states. If you do not have Spriter, tell me; we can change to a simpler animation approach instead of making you install software.

Orb folder: src/main/resources/stevethecrafter/images/char/orb/

Required transparent PNGs: layer1.png through layer6.png; layer1d.png through layer5d.png; and vfx.png. Suggested source canvas 128×128 per layer, centered and aligned.

## Cards later

We do not need card art yet. I will provide a separate exact checklist when we add the first custom cards.

## If you want me to generate art

Start with the character-select button and portrait. I can help create the illustrations, but the image files must then be uploaded to the exact folders above so the mod can load them.

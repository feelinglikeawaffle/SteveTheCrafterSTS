# Steve the Crafter — asset checklist (easy mode)

**You do not need to draw every card.** We'll use clean placeholder card art until the character and first playable cards work. The important thing is to upload the files with the exact names and folders below.

Repository: https://github.com/feelinglikeawaffle/SteveTheCrafterSTS

## Uploading from your phone

1. Open the repository link. Tap **Add file → Upload files**.
2. Pick the PNG files from your phone. Keep their names exactly as written.
3. Upload them into the matching folder. If GitHub won't let you upload into a folder that doesn't exist, create that folder with **Add file → Create new file**, enter a path ending in `README.md`, type `assets go here`, and commit it.
4. Scroll down and commit the upload to the **main** branch.
5. Send me “uploaded the character images” and I can check the filenames and wire them in.

If you are drawing on a phone, use any drawing app that can export PNG with transparency. For best consistency, make one Steve reference drawing first and use it for every pose. Art should be original Minecraft Live / Mob Vote-inspired illustration: blocky silhouette, expressive face, illustrated shading, no copied official promotional image.

## Phase 1 — five character images (start here)

Put these in `src/main/resources/stevethecrafter/images/char/`.

| Exact filename | Canvas | What to draw |
|---|---:|---|
| `charSelect.png` | 256×256 | Full-body Steve, centered, transparent background, holding a pickaxe |
| `portrait.png` | 1000×1000 | Chest-up Steve, friendly/confident expression, simple cave/crafting background |
| `shoulder1.png` | 256×256 | Steve upper body looking inward/right toward the cards |
| `shoulder2.png` | 256×256 | Same Steve upper body looking inward/left; matching style |
| `corpse.png` | 256×256 | Steve knocked down/defeated, readable silhouette, transparent background |

Use the same face, hair, turquoise shirt, blue pants, and proportions in every image. Transparent background is required for `charSelect`, shoulders, and corpse; portrait may have a background.

## Phase 2 — energy orb (only after Phase 1)

Folder: `src/main/resources/stevethecrafter/images/char/orb/`

Files: `layer1.png` through `layer6.png`, `layer1d.png` through `layer5d.png`, and `vfx.png`.

Each is a 128×128 transparent PNG. These are aligned circular teal energy-orb layers, **not Steve drawings**. Keep the circle centered in every file. I can generate/provide a simple matching template when we're ready; don't spend time drawing 12 separate complicated images now.

## Phase 3 — character animation (don't make this yourself yet)

The current Java shell points to `animation.scml`, a Spriter animation file. This is specialized and should not be hand-written. **Do not create it yourself.** Before we try to package a playable build, I should replace this dependency with a simpler supported animation or a valid placeholder. The shoulders and character-select art are still needed.

## Phase 4 — card art (later, optional)

You do not need a separate picture for every card to start testing. First make the cards work with placeholder art. Later, if you want custom illustrations, I'll provide one exact list with each card filename, canvas size, and a short drawing prompt. We can make a reusable set of Minecraft-themed card icons instead of asking you to draw 75 images.

## Important current limitation

The repository is still an early code scaffold, not a finished/compiled mod. The character shell currently references animation, orb, and custom card-frame assets that are not in the repository yet. I need to simplify those dependencies and implement/test the custom cards, resource system, relic, and rooms before I can honestly call it playable. Don't spend time making the orb layers or card frames until I confirm the code no longer requires placeholder assets at startup.

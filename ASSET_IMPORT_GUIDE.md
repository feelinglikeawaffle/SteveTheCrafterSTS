# Asset import guide

This project keeps art in one predictable place. You can upload PNGs through GitHub's website; you do not need to edit Java to replace an image that already has a registered path.

## 1. Upload the starter character art

Open the repository on GitHub, choose **Add file → Upload files**, and upload these files to:

`src/main/resources/stevethecrafter/images/char/`

| Filename | Suggested size | Purpose |
|---|---:|---|
| `charSelect.png` | 256 × 256 | Full-body Steve for the character selection screen |
| `portrait.png` | 1000 × 1000 | Character portrait |
| `shoulder1.png` | 256 × 256 | Combat-side shoulder art |
| `shoulder2.png` | 256 × 256 | Opposite combat-side shoulder art |
| `corpse.png` | 256 × 256 | Defeated character image |

Use PNG. Keep transparent backgrounds on the shoulder and corpse images. These are suggested canvas sizes; keep the important subject centered with some padding.

## 2. Upload card art

Upload `card_placeholder.png` to:

`src/main/resources/stevethecrafter/images/cards/`

Use a 512 × 512 PNG. The five starter cards currently share this one image, so you only need one card illustration to begin. Individual card images can be added later and assigned in their card classes.

## 3. What about animations?

The current character class temporarily uses Slay the Spire's built-in Ironclad Spine animation. That means **you do not need to upload an animation to get the current character scaffold running**.

A custom animated Steve is a separate asset task. It needs a Spine export compatible with the game's bundled Spine runtime (skeleton data, atlas, and referenced texture pages). A GIF or ordinary MP4 cannot be dropped in as the in-combat character animation. Do not rename an unrelated animation to make it fit; the skeleton and atlas must match.

When a compatible Steve Spine export is ready, put its files in:

`src/main/resources/stevethecrafter/images/char/animation/`

Then the Java animation loader can be switched from the temporary Ironclad animation to Steve's export. The exact filenames and loader call will be documented once the export format/runtime version is confirmed.

## 4. Check your files before building

From the repository root, run:

```bash
python scripts/check_assets.py
```

The checker reports missing files and incorrect PNG dimensions. It does not modify or resize your art.

## 5. Commit and verify

1. Commit the uploaded files to the `main` branch.
2. Run the asset checker.
3. Build and launch the mod to verify that transparent edges, scale, and positioning look right in-game.

For the complete starter-art checklist, see [ASSETS_NEEDED.md](ASSETS_NEEDED.md).

# Steve the Crafter — asset checklist (easy mode)

The mod now reuses Slay the Spire's built-in energy orb, character animation, and card frames. **You do not need to draw orb layers, card frames, or a Spriter animation.** We only need Steve's character art and one temporary shared card illustration to start.

Repository: https://github.com/feelinglikeawaffle/SteveTheCrafterSTS

## Upload from your phone

1. Open the repository link and switch to the **main** branch.
2. Tap **Add file → Upload files**.
3. Select the PNGs from your phone and upload them into the exact folder below.
4. If the folder doesn't exist, tap **Add file → Create new file**, enter a path ending in `README.md`, type `assets go here`, and commit. Then upload the PNGs.
5. Commit to main. Tell me “uploaded the Steve assets” and I can check the exact paths.

Use any drawing app that exports PNG. Art direction: original Minecraft Live / Mob Vote-inspired illustration—blocky proportions, expressive face, clean illustrated shading. Do not copy official promotional art. Draw one Steve reference first and keep his face, hair, turquoise shirt, blue pants, and proportions consistent.

## Required character art

Folder: `src/main/resources/stevethecrafter/images/char/`

| Exact filename | Canvas | What it should show |
|---|---:|---|
| `charSelect.png` | 256×256 | Full-body Steve holding a pickaxe; transparent background |
| `portrait.png` | 1000×1000 | Chest-up Steve, confident/friendly expression, simple cave or crafting background |
| `shoulder1.png` | 256×256 | Steve upper body facing inward/right toward the cards; transparent |
| `shoulder2.png` | 256×256 | Matching upper body facing inward/left; transparent |
| `corpse.png` | 256×256 | Defeated Steve pose, clear silhouette; transparent |

Transparent background is important for the character-select button, shoulders, and corpse. Keep Steve's face large enough to read at small size.

## One temporary card image

Folder: `src/main/resources/stevethecrafter/images/cards/`

- `card_placeholder.png` — 512×512 PNG. A simple Minecraft-themed illustration (Steve with a wooden pickaxe, crafting table, or ore) on a square canvas. **The first five starter cards all use this same temporary image**, so you only need to make one card image now. Later, I can replace it with individual card art.

## No need to create these

The code uses the game's built-in assets for:
- energy orb layers and orb effects
- character animation (temporary Ironclad animation skeleton; Steve's shoulder art still displays)
- custom card frames and card orbs

You do **not** need `animation.scml`, 12 orb PNGs, or the 9 card-frame textures listed in the older guide.

## What is implemented vs. what is next

The repository has the design blueprint and the first five custom starter-card classes plus a capped resource storage/action system. This is still an early scaffold and has **not been compiled or tested in Slay the Spire yet**. The next implementation work is the visible inventory UI, Steve's Inventory starter relic, the rest of the card pool, and the Crafting Table/event rooms. I will not call it playable until the build and in-game checks pass.

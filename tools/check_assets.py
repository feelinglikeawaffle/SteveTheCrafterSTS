#!/usr/bin/env python3
"""Check that Steve the Crafter's referenced art files exist and are valid PNGs.

Run from the repository root:
    python tools/check_assets.py
No third-party Python packages are required.
"""
from pathlib import Path
import struct
import sys

ROOT = Path(__file__).resolve().parents[1]
ASSETS = [
    ("src/main/resources/stevethecrafter/images/char/charSelect.png", (256, 256)),
    ("src/main/resources/stevethecrafter/images/char/portrait.png", (1000, 1000)),
    ("src/main/resources/stevethecrafter/images/char/shoulder1.png", (256, 256)),
    ("src/main/resources/stevethecrafter/images/char/shoulder2.png", (256, 256)),
    ("src/main/resources/stevethecrafter/images/char/corpse.png", (256, 256)),
    # Card illustrations currently reuse the imported pixel-art inventory icons.
    ("src/main/resources/stevethecrafter/images/relics/diamond_sword.png", (64, 64)),
    ("src/main/resources/stevethecrafter/images/relics/iron_pickaxe.png", (64, 64)),
    ("src/main/resources/stevethecrafter/images/relics/shield.png", (64, 64)),
    ("src/main/resources/stevethecrafter/images/materials/coal.png", (32, 32)),
    ("src/main/resources/stevethecrafter/images/relics/redstone_torch.png", (64, 64)),
    ("src/main/resources/stevethecrafter/images/materials/stone.png", (32, 32)),
    ("src/main/resources/stevethecrafter/images/materials/copper.png", (32, 32)),
    ("src/main/resources/stevethecrafter/images/materials/redstone.png", (32, 32)),
    ("src/main/resources/stevethecrafter/images/rooms/nether_portal.png", (256, 256)),
    ("src/main/resources/stevethecrafter/images/relics/enchanted_book.png", (64, 64)),
    ("src/main/resources/stevethecrafter/images/relics/nether_star.png", (64, 64)),
    ("src/main/resources/stevethecrafter/images/materials/iron.png", (32, 32)),
    ("src/main/resources/stevethecrafter/images/materials/diamond.png", (32, 32)),
    ("src/main/resources/stevethecrafter/images/relics/golden_apple.png", (64, 64)),
    ("src/main/resources/stevethecrafter/images/materials/emerald.png", (32, 32)),
    ("src/main/resources/stevethecrafter/images/materials/lapis.png", (32, 32)),
    ("src/main/resources/stevethecrafter/images/materials/ancient_debris.png", (32, 32)),
]
PNG_SIGNATURE = b"\x89PNG\r\n\x1a\n"


def png_size(path):
    with path.open("rb") as file:
        header = file.read(24)
    if len(header) < 24 or header[:8] != PNG_SIGNATURE or header[12:16] != b"IHDR":
        return None
    return struct.unpack(">II", header[16:24])


def main():
    missing = []
    wrong_size = []
    invalid = []
    print("Steve the Crafter — art asset check\n")
    for relative, expected in ASSETS:
        path = ROOT / relative
        if not path.is_file():
            missing.append(relative)
            print(f"MISSING   {relative}")
            continue
        actual = png_size(path)
        if actual is None:
            invalid.append(relative)
            print(f"NOT PNG   {relative}")
        elif actual != expected:
            wrong_size.append((relative, actual, expected))
            print(f"SIZE      {relative}: found {actual[0]}x{actual[1]}, expected {expected[0]}x{expected[1]}")
        else:
            print(f"OK        {relative} ({actual[0]}x{actual[1]})")

    # The Gradle build generates correctly sized hand and inspect portraits.
    generated_root = ROOT / "build/resources/main/stevethecrafter/images/cards"
    generated = []
    for stem in ("wooden_sword", "wooden_pickaxe", "wooden_shield", "mine_coal",
                 "make_torch", "stone_sword", "mine_copper", "mine_redstone",
                 "tnt", "lapis_enchant", "iron_axe", "cobblestone_guard", "smelt_ore",
                 "forge_strike", "redstone_pulse", "tnt_crate", "diamond_edge",
                 "enchanted_armor", "golden_apple", "emerald_trade", "lapis_focus",
                 "netherite_hammer"):
        generated.append((generated_root / (stem + ".png"), (250, 190)))
        generated.append((generated_root / (stem + "_p.png"), (500, 380)))

    if generated_root.exists():
        for path, expected in generated:
            if not path.is_file():
                missing.append(str(path.relative_to(ROOT)))
                print(f"MISSING   {path.relative_to(ROOT)}")
                continue
            actual = png_size(path)
            if actual is None:
                invalid.append(str(path.relative_to(ROOT)))
                print(f"NOT PNG   {path.relative_to(ROOT)}")
            elif actual != expected:
                wrong_size.append((str(path.relative_to(ROOT)), actual, expected))
                print(f"SIZE      {path.relative_to(ROOT)}: found {actual[0]}x{actual[1]}, expected {expected[0]}x{expected[1]}")
            else:
                print(f"OK        {path.relative_to(ROOT)} ({actual[0]}x{actual[1]})")
    else:
        print("NOTE      Run the Gradle build to generate and check 250x190 / 500x380 card portraits.")

    print()
    if missing or wrong_size or invalid:
        print(f"Needs attention: {len(missing)} missing, {len(wrong_size)} wrong-size, {len(invalid)} invalid.")
        return 1
    print("All source assets and generated card-art PNGs are present at their expected dimensions.")
    return 0


if __name__ == "__main__":
    sys.exit(main())

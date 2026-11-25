#!/usr/bin/env python3
"""Validate all imported Steve character, animation, icon, and room PNG assets.

Run from the repository root: python scripts/check_assets.py
This script uses only the Python standard library and never edits images.
"""
from pathlib import Path
import json
import struct
import sys

ROOT = Path(__file__).resolve().parents[1]
RESOURCE = ROOT / "src/main/resources/stevethecrafter/images"

REQUIRED = {
    "char/charSelect.png": (256, 256),
    "char/portrait.png": (1000, 1000),
    "char/shoulder1.png": (256, 256),
    "char/shoulder2.png": (256, 256),
    "char/corpse.png": (256, 256),
    "cards/card_placeholder.png": (512, 512),
    "char/animation/steve_animation_atlas.png": (576, 1024),
}

ANIMATION_FRAMES = {
    "idle": 6, "walk": 6, "mine": 6, "sword": 6,
    "block": 4, "hurt": 3, "death": 6, "craft": 4,
}
for name, frames in ANIMATION_FRAMES.items():
    REQUIRED[f"char/animation/{name}_strip.png"] = (frames * 96, 128)

MATERIALS = (
    "ancient_debris coal copper diamond emerald gold iron lapis "
    "obsidian redstone stone wood"
).split()
RELICS = (
    "crafting_table diamond_sword elytra enchanted_book ender_pearl "
    "golden_apple iron_pickaxe nether_star redstone_torch shield "
    "steves_inventory totem"
).split()
POTIONS = "block enchanting energy healing mining strength".split()
ROOMS = "abandoned_mine crafting_table nether_portal village".split()

for name in MATERIALS:
    REQUIRED[f"materials/{name}.png"] = (32, 32)
for name in RELICS:
    REQUIRED[f"relics/{name}.png"] = (64, 64)
for name in POTIONS:
    REQUIRED[f"potions/{name}.png"] = (32, 40)
for name in ROOMS:
    REQUIRED[f"rooms/{name}.png"] = (256, 256)

REQUIRED_FILES = ("char/animation/animation_frames.json",)


def png_size(path: Path):
    with path.open("rb") as image:
        header = image.read(24)
    if len(header) < 24 or header[:8] != b"\x89PNG\r\n\x1a\n" or header[12:16] != b"IHDR":
        raise ValueError("not a valid PNG file")
    return struct.unpack(">II", header[16:24])


def main() -> int:
    missing = []
    problems = []
    for relative, expected in REQUIRED.items():
        path = RESOURCE / relative
        if not path.is_file():
            missing.append(relative)
            print(f"MISSING  {relative}")
            continue
        try:
            actual = png_size(path)
        except (OSError, ValueError) as error:
            problems.append(relative)
            print(f"INVALID  {relative}: {error}")
            continue
        if actual != expected:
            problems.append(relative)
            print(f"SIZE     {relative}: found {actual[0]}x{actual[1]}, expected {expected[0]}x{expected[1]}")
        else:
            print(f"OK       {relative} ({actual[0]}x{actual[1]})")

    for relative in REQUIRED_FILES:
        if not (RESOURCE / relative).is_file():
            missing.append(relative)
            print(f"MISSING  {relative}")
        else:
            print(f"OK       {relative}")

    metadata_path = RESOURCE / "char/animation/animation_frames.json"
    if metadata_path.is_file():
        try:
            metadata = json.loads(metadata_path.read_text(encoding="utf-8"))
            if metadata.get("frame_size") != [96, 128]:
                problems.append("char/animation/animation_frames.json")
                print("META     animation frame_size should be [96, 128]")
            if metadata.get("atlas_columns") != 6 or len(metadata.get("animations", [])) != 8:
                problems.append("char/animation/animation_frames.json")
                print("META     expected a 6-column atlas with 8 animation rows")
        except (OSError, ValueError) as error:
            problems.append("char/animation/animation_frames.json")
            print(f"INVALID  animation metadata: {error}")

    print()
    if missing or problems:
        print(f"Asset check needs attention: {len(missing)} missing, {len(problems)} invalid.")
        print("See ASSET_IMPORT_GUIDE.md for paths and expected dimensions.")
        return 1
    print(f"All {len(REQUIRED)} PNG assets and animation metadata are present and dimension-checked.")
    print("Sprite animation is wired in source; compile and in-game verification are still required.")
    return 0


if __name__ == "__main__":
    sys.exit(main())

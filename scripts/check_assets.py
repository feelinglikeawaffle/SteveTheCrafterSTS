#!/usr/bin/env python3
"""Check that the starter Steve mod art files exist and have expected PNG sizes.

Run from the repository root: python scripts/check_assets.py
This script uses only the Python standard library and never edits your images.
"""
from pathlib import Path
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
}


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

    print()
    if missing or problems:
        print(f"Asset check needs attention: {len(missing)} missing, {len(problems)} invalid.")
        print("See ASSET_IMPORT_GUIDE.md for upload paths and animation notes.")
        return 1
    print("All starter image assets are present and have the expected dimensions.")
    print("Custom Steve Spine animation is optional; the scaffold currently uses the built-in Ironclad animation.")
    return 0


if __name__ == "__main__":
    sys.exit(main())

#!/usr/bin/env python3
"""Check that Steve the Crafter's starter art files exist and are valid PNGs.

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
    ("src/main/resources/stevethecrafter/images/cards/card_placeholder.png", (512, 512)),
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

    print()
    if missing or wrong_size or invalid:
        print(f"Needs attention: {len(missing)} missing, {len(wrong_size)} wrong-size, {len(invalid)} invalid.")
        print("See ASSETS_NEEDED.md for upload locations and art guidance.")
        return 1
    print("All starter art files are present and have the expected PNG dimensions.")
    return 0


if __name__ == "__main__":
    sys.exit(main())

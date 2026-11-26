# Steve the Crafter — Slay the Spire Mod

A Minecraft-inspired custom character concept for **Slay the Spire (2017)**. Steve's run revolves around mining resources, crafting equipment, and turning early investment into powerful late-run payoffs. Art direction: Minecraft Live / Mob Vote-inspired 2D illustration, with a consistent visual style across Steve, cards, relics, and the Crafting Table room.

## Current prototype status\n\nThe current build branch contains Steve's character registration, a 10-card prototype, a starting relic, run-resource counters, and original character/card/relic/potion/room art. The sprite atlas and action-triggered clips are connected in code. This is an early playable-prototype target, **not** the planned full 75-card character: the Crafting Table special room, full card pool, balance pass, and in-game animation testing are still unfinished.\n\nThe art import checker passes, but the Java project has not yet been compiled against your local Slay the Spire / ModTheSpire / BaseMod libraries. Do not treat this branch as a tested release yet.

## Current design pillars

- Gathering resources should be **worth the card and energy investment**.
- Most mining is deterministic for planning; some cards generate random resources for discovery and excitement.
- Resources persist through a run and are spent in combat and at special Crafting Table rooms.
- Equipment and enchantments create multiple build paths.
- Start with modest wooden gear; scale toward diamond and Netherite-level payoffs.
- Preserve a coherent illustrated Minecraft Live-inspired visual style.

## Planned resources

| Resource | Role |
|---|---|
| Coal | Fuel, fire, explosives |
| Iron | Main crafting material |
| Gold | Special recipes and lucky effects |
| Diamonds | High-tier equipment |
| Emeralds | Trading and special effects |
| Ancient Debris | Netherite progression |

## Planned character content

- Steve character and starting relic / deck
- Mining, crafting, equipment, enchantment, survival, and explosive card archetypes
- Approximately 75-card pool (final balance to be playtested)
- 10–12 character relics and character-specific potions
- Crafting Table special room with a recipe interface
- Minecraft Live / Mob Vote-inspired 2D art for all character assets

## Build setup

This mod targets the original Slay the Spire, not Slay the Spire 2. It will use Java and the community ModTheSpire + BaseMod ecosystem.

The game and modding framework JARs are not included. Do not distribute the game's files. Once the implementation is ready, place the required local framework/game libraries in `lib/` as described by the build instructions that will be added with the first compilable milestone.

## Roadmap

1. Confirm mod framework versions and create a clean buildable BaseMod project.
2. Register Steve with a working character selection and starting deck.
3. Implement persistent run resources and resource UI.
4. Add starter cards and the first mining / crafting synergies.
5. Add equipment, enchantments, relics, and the full card pool.
6. Implement the Crafting Table room and recipe UI.
7. Add and polish the consistent illustrated art set; test and balance in-game.

## Art note

The visual direction is inspired by Minecraft's official 2D promotional / Minecraft Live character art. Assets should be original fan-made illustrations, not extracted official game or promotional artwork.

# Steve the Crafter — gameplay blueprint

This is the source of truth for the first playable version. The goal is a polished, readable character with a real resource engine—not a pile of weak mining cards. Balance numbers are starting values and will be playtested.

## Character identity

**Steve — The Crafter** (Ironclad-style strength and survival, but built around gathering and spending materials).

- 72 starting HP, 3 energy, 5 cards drawn per turn.
- **Starting relic — Steve's Inventory:** At the start of each combat, gain 1 Coal and 1 Iron.
- **Resource system:** Coal, Iron, Gold, Diamond, Emerald, Ancient Debris. Resources persist through the run, including between combats. They are not cards and do not occupy hand space.
- **Resource cap:** 99 of each resource. A card that would exceed the cap simply grants up to the cap; show a small “Inventory full” message.
- **Mining rule:** Mining cards give resources immediately when played. Mining is meant to pay off through crafting and tool synergies. Avoid making basic mining require a random roll.
- **Fortune:** Increases bonus drops from mining; it does not change deterministic base yields.
- **Tools:** Tool cards are powers or temporary combat buffs. They improve mining and/or combat for the current fight unless a card explicitly says otherwise.
- **Crafting:** Crafting cards spend resources and create a strong immediate effect. Special Crafting Table rooms offer permanent run choices and card/relic rewards.

### Starter deck (10 cards)

- 4× Wooden Sword — 6 damage.
- 2× Wooden Pickaxe — gain 2 Iron.
- 2× Wooden Shield — gain 5 Block.
- 1× Mine Coal — gain 2 Coal.
- 1× Make a Torch — gain 5 Block; gain 1 Coal.

Starter relic: Steve's Inventory. These replace the temporary vanilla Strike/Defend/Burning Blood placeholders once custom card/relic registration is implemented.

## Core card pool (first release target: 75 cards)

Card text below is a gameplay spec, not a claim that every card is already coded. Costs and numbers are tuning targets. Use the card type and rarity stated; use standard STS upgrade conventions unless a card has a specific upgrade.

### Basic / starter (10)
| Card | Type / Cost | Effect |
|---|---|---|
| Wooden Sword | Attack 1 | Deal 6 damage |
| Wooden Pickaxe | Skill 1 | Gain 2 Iron |
| Wooden Shield | Skill 1 | Gain 5 Block |
| Mine Coal | Skill 1 | Gain 2 Coal |
| Make a Torch | Skill 1 | Gain 5 Block; gain 1 Coal |
| Stone Sword | Attack 1 | Deal 9 damage |
| Stone Pickaxe | Skill 1 | Gain 3 Iron |
| Stone Shield | Skill 1 | Gain 8 Block |
| Crafting Table | Skill 1 | Gain 1 Iron and 1 Coal; draw 1 |
| Bread | Skill 1 | Heal 3 HP (combat only) |

### Mining and exploration (12)
| Card | Type / Cost | Effect |
|---|---|---|
| Vein Miner | Skill 1 | Gain 4 Iron |
| Coal Seam | Skill 0 | Gain 2 Coal; Exhaust |
| Gold Rush | Skill 1 | Gain 2 Gold |
| Deep Mine | Skill 1 | Gain 1 Iron and 1 Gold; draw 1 |
| Diamond Finder | Skill 2 | Gain 1 Diamond |
| Cave Expedition | Skill 1 | Gain 2 random resources from Coal/Iron/Gold |
| Abandoned Shaft | Skill 1 | Gain 3 Iron; 25% chance gain 1 extra Gold |
| Strip Mine | Skill 2 | Gain 6 Iron; lose 3 HP |
| Fortune III | Power 1 | The first 2 times you gain resources each turn, gain 1 extra resource of that type |
| Efficient Mining | Power 1 | Whenever you play a Mining card, gain 1 Block |
| TNT Mining | Skill 1 | Lose 2 HP; gain 1 Diamond and 2 Iron; Exhaust |
| Ancient Debris | Skill 2 | Gain 1 Ancient Debris; Exhaust |

### Weapons and combat (15)
| Card | Type / Cost | Effect |
|---|---|---|
| Iron Sword | Attack 1 | Deal 9 damage |
| Iron Axe | Attack 2 | Deal 14 damage; apply 1 Weak |
| Diamond Sword | Attack 2 | Deal 18 damage |
| Netherite Sword | Attack 3 | Deal 28 damage; Exhaust |
| Bow | Attack 1 | Deal 7 damage twice |
| Crossbow | Attack 2 | Deal 16 damage; if target is Vulnerable, draw 1 |
| Shield Bash | Attack 1 | Deal damage equal to your Block (max 18) |
| Sweep | Attack 1 | Deal 7 damage to ALL enemies |
| Critical Hit | Attack 1 | Deal 8 damage; spend 1 Gold to deal 8 more |
| Sharpness I | Power 1 | Attacks deal 2 additional damage |
| Smite | Attack 2 | Deal 16 damage; deal 8 more to an enemy with Artifact |
| Axe Throw | Attack 1 | Deal 10 damage; discard 1 card |
| Flint and Steel | Attack 1 | Deal 6 damage; apply 2 Vulnerable |
| Ender Pearl | Skill 0 | Gain 6 Block; Exhaust; spend 1 Emerald to draw 2 |
| Nether Blast | Attack 2 | Deal 12 damage to ALL enemies; gain 1 Coal |

### Armor, food, and survival (10)
| Card | Type / Cost | Effect |
|---|---|---|
| Iron Armor | Skill 1 | Gain 10 Block |
| Diamond Armor | Skill 2 | Gain 18 Block |
| Netherite Armor | Skill 3 | Gain 25 Block; gain 1 Metallicize |
| Cooked Porkchop | Skill 1 | Heal 5 HP |
| Golden Apple | Skill 2 | Heal 8 HP; gain 1 Artifact |
| Totem of Undying | Skill 2 | If you would die this combat, instead heal 12 HP; Exhaust |
| Water Bucket | Skill 1 | Gain 8 Block; remove 1 Burn/Poison from yourself |
| Protection IV | Power 2 | Gain 4 Block at start of each turn |
| Unbreaking | Power 1 | The first time you lose Block each turn, gain 3 Block |
| Elytra | Skill 1 | Gain 7 Block; draw 2; Exhaust |

### Crafting and equipment (10)
| Card | Type / Cost | Effect |
|---|---|---|
| Craft Iron Gear | Skill 1 | Spend 3 Iron: gain 12 Block and 1 Strength this turn |
| Forge a Blade | Skill 1 | Spend 2 Iron and 1 Coal: deal 16 damage |
| Diamond Upgrade | Skill 2 | Spend 1 Diamond: deal 20 damage and gain 8 Block |
| Emerald Trade | Skill 1 | Spend 2 Emerald: gain 2 energy |
| Anvil | Power 2 | Whenever you spend Iron, gain 2 Block |
| Furnace | Power 1 | At end of turn, convert 2 Coal into 1 Strength next turn (once per combat) |
| Smithing Table | Skill 1 | Spend 1 Gold: upgrade a random card in your hand for this combat |
| Repair | Skill 1 | Spend 2 Iron: gain 10 Block; remove 1 Frail |
| Crafting Master | Power 2 | The first crafted card each turn costs 0 |
| Beacon | Skill 2 | Spend 1 Diamond and 2 Iron: gain 2 Strength and 2 Dexterity |

### Enchantments and advanced (8)
| Card | Type / Cost | Effect |
|---|---|---|
| Efficiency V | Power 1 | First Mining card each turn costs 0 |
| Fortune III (Advanced) | Power 2 | Mining cards have a 50% chance to double their base resource yield |
| Mending | Power 1 | Whenever you gain 5 or more Block, heal 1 HP (max 4 per combat) |
| Fire Aspect | Power 1 | Attacks apply 2 Burn (use Vulnerable/Poison-compatible custom Burn only if implemented; otherwise apply 1 Weak) |
| Knockback | Attack 1 | Deal 8 damage; push enemy intent back 1 turn if supported, otherwise apply 2 Weak |
| Haste | Power 1 | Gain 1 energy at the start of your next 2 turns |
| Curse of Binding | Skill 0 | Gain 12 Block; Exhaust; add a Wound to your discard pile |
| Experience Orb | Skill 1 | Gain 1 energy; draw 1; Exhaust |

### Nether / End / rare (10)
| Card | Type / Cost | Effect |
|---|---|---|
| Obsidian | Skill 1 | Gain 12 Block; gain 1 Ancient Debris |
| Nether Portal | Skill 2 | Gain 2 energy; Exhaust; spend 1 Diamond |
| Ghast Fireball | Attack 2 | Deal 15 damage to ALL enemies; apply 2 Weak |
| Blaze Rod | Attack 1 | Deal 9 damage; gain 1 energy if it kills |
| Wither Skeleton | Attack 2 | Deal 18 damage; apply 2 Vulnerable |
| End Crystal | Skill 2 | Deal 20 damage to ALL enemies; lose 5 HP; Exhaust |
| Dragon Breath | Power 2 | At start of turn, deal 5 damage to ALL enemies |
| Elytra Dive | Attack 2 | Deal 18 damage; gain 10 Block |
| Dragon Egg | Skill 3 | Gain 3 Strength; Exhaust; spend 1 Diamond and 2 Ancient Debris |
| The End | Power 3 | At start of each turn, gain 1 energy and 1 Diamond; Exhaust after 3 turns |

**Implementation note:** 75-card target includes the 10 starter/basic cards above plus 65 pool cards. Cards should be implemented in small batches, with localized descriptions and upgrade text. Any effect not supported by the game API should use a clear vanilla fallback rather than an unstable custom mechanic.

## Relic targets (12)

1. Steve's Inventory (starter): start combat with 1 Coal + 1 Iron.
2. Stone Pickaxe: first Mining card each combat gains +1 Iron.
3. Iron Furnace: whenever you spend Coal, gain 1 Block.
4. Fortune Charm: first resource gained each turn has a 25% chance to double.
5. Golden Apple: at the start of each Act, heal 10 HP.
6. Enchanted Book: first Power played each combat costs 0.
7. Anvil: gain 1 Strength after spending 4 Iron in a combat.
8. Emerald: shop prices reduced by 15%.
9. Diamond: gain 1 energy on the first turn of Elite combats.
10. Netherite Scrap: gain 1 Metallicize.
11. Totem: once per run, revive at 15 HP.
12. Ender Chest: retain up to 3 resources between acts (all resources already persist within a run).

## Potion concepts (6)

- Coal Dust: gain 2 Coal.
- Iron Ingot: gain 2 Iron.
- Gold Ingot: gain 2 Gold.
- Diamond: gain 1 Diamond.
- Enchanted Apple: gain 12 Block and 1 Artifact.
- TNT: deal 20 damage to ALL enemies.

## Special rooms and events

### Crafting Table room (signature room)
- Appears as an uncommon special room, roughly 1 per Act; never force it to appear if the map cannot support it.
- Shows resource inventory, recipe costs, and a preview before purchase. No hidden costs.
- Offer 3 recipe choices; allow one craft for free per visit, with optional second craft for a small Gold cost.
- Recipes are deterministic and do not reroll for resources the player cannot afford.
- Initial recipes: Iron Gear (3 Iron → uncommon Skill/relic-style combat reward); Diamond Tool (1 Diamond + 2 Iron → choose 1 of 3 cards, one upgraded); Enchanted Book (2 Gold + 1 Emerald → choose one temporary combat enchantment); Netherite Upgrade (1 Ancient Debris + 1 Gold → upgrade one card and gain 1 Strength next combat); Repair Kit (2 Iron → heal 15% max HP).
- If custom room UI is too large for the first milestone, implement a normal event with clear buttons first, then improve it into a custom screen. Don't ship a broken room.

### Abandoned Mine event
Choose one:
- Carefully mine: gain 3 Iron.
- Push deeper: lose 8 HP, gain 1 Diamond and 2 Gold.
- Leave: no effect.

### Village Trading Post event
Choose one:
- Trade 3 Iron for 1 Emerald.
- Spend 30 Gold to remove a card.
- Take a free common card.

### Nether Portal event
Choose one:
- Enter: lose 10 HP, gain 1 Ancient Debris and a rare card.
- Stabilize: spend 1 Diamond, gain 2 relic choices.
- Close it: gain 50 Gold.

## Quality and balance checklist

- No mining card should feel like a dead draw; basic deterministic mining gives useful guaranteed value.
- Resource costs are always visible before play; no spending below zero.
- Resource gains are capped safely; no negative resources or overflow.
- All card descriptions match the actual effect, including upgrades and multi-enemy behavior.
- Use standard STS effects when possible; avoid custom intent manipulation or new status mechanics in the first release.
- Starter deck has a real attack, block, and resource plan and should be able to beat Act 1 without relying on rare resources.
- Test low-resource, high-resource, no-rare-drop, and resource-cap cases.
- Keep card pool progression spread across Common / Uncommon / Rare and ensure no single infinite-energy loop.

package stevethecrafter.cards;

import basemod.abstracts.CustomCard;
import stevethecrafter.SteveTheCrafterMod;
import stevethecrafter.patches.SteveEnums;

/** Shared base for Steve's cards. */
public abstract class AbstractSteveCard extends CustomCard {
    protected AbstractSteveCard(String id, String name, String image, int cost, String description,
                               CardType type, CardRarity rarity, CardTarget target) {
        super(id, name, SteveTheCrafterMod.makePath("images/cards/" + image), cost, description,
                type, SteveEnums.STEVE_COLOR, rarity, target);
    }
}

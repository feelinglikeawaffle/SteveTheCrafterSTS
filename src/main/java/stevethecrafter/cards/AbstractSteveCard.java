package stevethecrafter.cards;

import basemod.abstracts.CustomCard;
import stevethecrafter.SteveTheCrafterMod;
import stevethecrafter.characters.SteveCharacter;
import stevethecrafter.characters.SteveSpriteAnimation;
import stevethecrafter.patches.SteveEnums;

/** Shared base for Steve's cards. */
public abstract class AbstractSteveCard extends CustomCard {
    protected final void animateAttack() { SteveCharacter.playAnimation(SteveSpriteAnimation.Clip.SWORD); }
    protected final void animateMine() { SteveCharacter.playAnimation(SteveSpriteAnimation.Clip.MINE); }
    protected final void animateBlock() { SteveCharacter.playAnimation(SteveSpriteAnimation.Clip.BLOCK); }
    protected final void animateCraft() { SteveCharacter.playAnimation(SteveSpriteAnimation.Clip.CRAFT); }

    /** image is a resource path relative to the stevethecrafter resource folder. */
    protected AbstractSteveCard(String id, String name, String image, int cost, String description,
                               CardType type, CardRarity rarity, CardTarget target) {
        super(id, name, SteveTheCrafterMod.makePath(image), cost, description,
                type, SteveEnums.STEVE_COLOR, rarity, target);
    }
}

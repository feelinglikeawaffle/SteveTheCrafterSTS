package stevethecrafter.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;

/** Steve's character ID and a supported built-in card color. */
public class SteveEnums {
    @SpireEnum(name = "STEVE")
    public static AbstractPlayer.PlayerClass STEVE;

    // Use the game's built-in blue textures until Steve's complete custom card
    // texture set is bundled. A custom CardColor without registered textures
    // causes null card backgrounds/orbs during combat rendering.
    public static final AbstractCard.CardColor STEVE_COLOR = AbstractCard.CardColor.BLUE;
}

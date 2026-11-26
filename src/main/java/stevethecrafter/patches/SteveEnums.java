package stevethecrafter.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.helpers.CardLibrary;

/** Steve's character, card colour, and card-library IDs. */
public class SteveEnums {
    @SpireEnum(name = "STEVE")
    public static AbstractPlayer.PlayerClass STEVE;

    @SpireEnum(name = "STEVE")
    public static AbstractCard.CardColor STEVE_COLOR;

    // BaseMod requires a matching LibraryType so card rewards stay in Steve's pool.
    @SpireEnum(name = "STEVE")
    public static CardLibrary.LibraryType STEVE_LIBRARY_COLOR;
}

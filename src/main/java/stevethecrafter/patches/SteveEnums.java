package stevethecrafter.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.helpers.CardLibrary;

/** Custom class, card color, and card-library IDs used by Steve. */
public class SteveEnums {
    @SpireEnum(name = "STEVE")
    public static AbstractPlayer.PlayerClass STEVE;

    @SpireEnum(name = "STEVE")
    public static AbstractCard.CardColor STEVE_COLOR;

    // BaseMod's custom color tab looks up a LibraryType with the same enum name.
    @SpireEnum(name = "STEVE")
    public static CardLibrary.LibraryType STEVE_LIBRARY_COLOR;
}

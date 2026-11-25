package stevethecrafter;

import basemod.BaseMod;
import basemod.interfaces.EditCharactersSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.localization.CardStrings;

/** Initial registration point for Steve the Crafter. */
@SpireInitializer
public class SteveTheCrafterMod implements EditCharactersSubscriber {
    public static final String MOD_ID = "stevethecrafter";

    public SteveTheCrafterMod() {
        BaseMod.subscribe(this);
    }

    public static void initialize() {
        new SteveTheCrafterMod();
    }

    @Override
    public void receiveEditCharacters() {
        // Character registration will be added once the matching character
        // assets and framework-compatible character class are in place.
    }
}

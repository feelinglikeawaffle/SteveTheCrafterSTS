package stevethecrafter;

import basemod.BaseMod;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditCardsSubscriber;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import stevethecrafter.characters.SteveCharacter;
import stevethecrafter.patches.SteveEnums;
import stevethecrafter.cards.WoodenSword;
import stevethecrafter.cards.WoodenPickaxe;
import stevethecrafter.cards.WoodenShield;
import stevethecrafter.cards.MineCoal;
import stevethecrafter.cards.MakeTorch;

/** Mod entry point and Steve character registration. */
@SpireInitializer
public class SteveTheCrafterMod implements EditCharactersSubscriber, EditCardsSubscriber {
    public static final String MOD_ID = "stevethecrafter";
    private static final Color STEVE_TEAL = new Color(0.20F, 0.68F, 0.62F, 1.0F);

    public SteveTheCrafterMod() {
        BaseMod.subscribe(this);
        BaseMod.addColor(SteveEnums.STEVE_COLOR,
                STEVE_TEAL, STEVE_TEAL, STEVE_TEAL, STEVE_TEAL, STEVE_TEAL, STEVE_TEAL, STEVE_TEAL,
                makePath("images/card/512/bg_attack.png"),
                makePath("images/card/512/bg_skill.png"),
                makePath("images/card/512/bg_power.png"),
                makePath("images/card/512/card_orb.png"),
                makePath("images/card/1024/bg_attack.png"),
                makePath("images/card/1024/bg_skill.png"),
                makePath("images/card/1024/bg_power.png"),
                makePath("images/card/1024/card_orb.png"),
                makePath("images/card/512/card_small_orb.png"));
    }

    public static void initialize() {
        new SteveTheCrafterMod();
    }

    public static String makePath(String resource) {
        return MOD_ID + "/" + resource;
    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new SteveCharacter("Steve"),
                makePath("images/char/charSelect.png"),
                makePath("images/char/portrait.png"),
                SteveEnums.STEVE);
    }
}

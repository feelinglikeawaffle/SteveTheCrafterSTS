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
                "images/512/cardui/card_bg_attack.png",
                "images/512/cardui/card_bg_skill.png",
                "images/512/cardui/card_bg_power.png",
                "images/512/cardui/card_orb.png",
                "images/1024/cardui/card_bg_attack.png",
                "images/1024/cardui/card_bg_skill.png",
                "images/1024/cardui/card_bg_power.png",
                "images/1024/cardui/card_orb.png",
                "images/512/cardui/card_small_orb.png");
    }

    public static void initialize() {
        new SteveTheCrafterMod();
    }

    public static String makePath(String resource) {
        return MOD_ID + "/" + resource;
    }

    @Override
    public void receiveEditCards() {
        BaseMod.addCard(new WoodenSword());
        BaseMod.addCard(new WoodenPickaxe());
        BaseMod.addCard(new WoodenShield());
        BaseMod.addCard(new MineCoal());
        BaseMod.addCard(new MakeTorch());
    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new SteveCharacter("Steve"),
                makePath("images/char/charSelect.png"),
                makePath("images/char/portrait.png"),
                SteveEnums.STEVE);
    }
}

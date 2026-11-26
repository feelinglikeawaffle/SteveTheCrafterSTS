package stevethecrafter;

import basemod.BaseMod;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.localization.RelicStrings;
import stevethecrafter.characters.SteveCharacter;
import stevethecrafter.patches.SteveEnums;
import stevethecrafter.cards.WoodenSword;
import stevethecrafter.cards.WoodenPickaxe;
import stevethecrafter.cards.WoodenShield;
import stevethecrafter.cards.MineCoal;
import stevethecrafter.cards.MakeTorch;
import stevethecrafter.cards.StoneSword;
import stevethecrafter.cards.MineCopper;
import stevethecrafter.cards.MineRedstone;
import stevethecrafter.cards.TNT;
import stevethecrafter.cards.LapisEnchant;
import stevethecrafter.relics.SteveInventory;

/** Mod entry point and Steve character registration. */
@SpireInitializer
public class SteveTheCrafterMod implements EditCharactersSubscriber, EditCardsSubscriber, EditRelicsSubscriber {
    public static final String MOD_ID = "stevethecrafter";
    private static final Color STEVE_TEAL = new Color(0.20F, 0.68F, 0.62F, 1.0F);

    public SteveTheCrafterMod() {
        BaseMod.subscribe(this);

        // Load custom relic names/descriptions before AbstractRelic instances are created.
        BaseMod.loadCustomStringsFile(RelicStrings.class,
                makePath("localization/eng/RelicStrings.json"));

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
        BaseMod.addCard(new StoneSword());
        BaseMod.addCard(new MineCopper());
        BaseMod.addCard(new MineRedstone());
        BaseMod.addCard(new TNT());
        BaseMod.addCard(new LapisEnchant());
    }

    @Override
    public void receiveEditRelics() {
        BaseMod.addRelicToCustomPool(new SteveInventory(), SteveEnums.STEVE_COLOR);
    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new SteveCharacter("Steve"),
                makePath("images/char/charSelect.png"),
                makePath("images/char/portrait.png"),
                SteveEnums.STEVE);
    }
}

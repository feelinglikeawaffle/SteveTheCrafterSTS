package stevethecrafter;

import basemod.BaseMod;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.badlogic.gdx.graphics.Color;
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
import stevethecrafter.cards.IronAxe;
import stevethecrafter.cards.CobblestoneGuard;
import stevethecrafter.cards.SmeltOre;
import stevethecrafter.cards.ForgeStrike;
import stevethecrafter.cards.RedstonePulse;
import stevethecrafter.cards.TNTCrate;
import stevethecrafter.cards.DiamondEdge;
import stevethecrafter.cards.EnchantedArmor;
import stevethecrafter.cards.GoldenApple;
import stevethecrafter.cards.EmeraldTrade;
import stevethecrafter.cards.LapisFocus;
import stevethecrafter.cards.NetheriteHammer;
import stevethecrafter.relics.SteveInventory;

/** Mod entry point and Steve character registration. */
@SpireInitializer
public class SteveTheCrafterMod implements EditCharactersSubscriber, EditCardsSubscriber, EditRelicsSubscriber, EditStringsSubscriber {
    public static final String MOD_ID = "stevethecrafter";
    private static final Color STEVE_TEAL = new Color(0.20F, 0.68F, 0.62F, 1.0F);

    public SteveTheCrafterMod() {
        BaseMod.subscribe(this);
        // A dedicated colour keeps vanilla blue cards out of Steve's reward pool.
        // The build bundles source textures under this mod's own resource namespace.
        BaseMod.addColor(SteveEnums.STEVE_COLOR,
                STEVE_TEAL, STEVE_TEAL, STEVE_TEAL, STEVE_TEAL, STEVE_TEAL, STEVE_TEAL, STEVE_TEAL,
                makePath("images/512/cardui/card_bg_attack.png"),
                makePath("images/512/cardui/card_bg_skill.png"),
                makePath("images/512/cardui/card_bg_power.png"),
                makePath("images/512/cardui/card_orb.png"),
                makePath("images/1024/cardui/card_bg_attack.png"),
                makePath("images/1024/cardui/card_bg_skill.png"),
                makePath("images/1024/cardui/card_bg_power.png"),
                makePath("images/1024/cardui/card_orb.png"),
                makePath("images/512/cardui/card_small_orb.png"));
    }

    public static void initialize() {
        new SteveTheCrafterMod();
    }

    public static String makePath(String resource) {
        return MOD_ID + "/" + resource;
    }

    @Override
    public void receiveEditStrings() {
        BaseMod.loadCustomStringsFile(com.megacrit.cardcrawl.localization.RelicStrings.class,
                makePath("localization/eng/RelicStrings.json"));
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
        BaseMod.addCard(new IronAxe());
        BaseMod.addCard(new CobblestoneGuard());
        BaseMod.addCard(new SmeltOre());
        BaseMod.addCard(new ForgeStrike());
        BaseMod.addCard(new RedstonePulse());
        BaseMod.addCard(new TNTCrate());
        BaseMod.addCard(new DiamondEdge());
        BaseMod.addCard(new EnchantedArmor());
        BaseMod.addCard(new GoldenApple());
        BaseMod.addCard(new EmeraldTrade());
        BaseMod.addCard(new LapisFocus());
        BaseMod.addCard(new NetheriteHammer());
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

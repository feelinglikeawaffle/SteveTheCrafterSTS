package stevethecrafter.characters;

import basemod.abstracts.CustomPlayer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.ExhaustAllEtherealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.megacrit.cardcrawl.powers.AbstractPower;
import stevethecrafter.SteveTheCrafterMod;
import stevethecrafter.patches.SteveEnums;
import stevethecrafter.resources.SteveResource;
import stevethecrafter.relics.SteveInventory;

import java.util.ArrayList;

/** Steve's selectable character shell. */
public class SteveCharacter extends CustomPlayer {
    public static final int ENERGY_PER_TURN = 3;
    private static final Color STEVE_COLOR = new Color(0.20F, 0.68F, 0.62F, 1.0F);
    private static final int RESOURCE_CAP = 99;
    public int coal, copper, iron, gold, redstone, lapis, diamond, emerald, ancientDebris;

    /** Plays one of Steve's frame-based clips when Steve is the active character. */
    public static void playAnimation(SteveSpriteAnimation.Clip clip) {
        if (AbstractDungeon.player instanceof SteveCharacter) {
            SteveCharacter steve = (SteveCharacter) AbstractDungeon.player;
            if (steve.animation instanceof SteveSpriteAnimation) {
                ((SteveSpriteAnimation) steve.animation).play(clip);
            }
        }
    }

    /** Adds a material to Steve's capped run inventory. */
    public void gainResource(SteveResource resource, int amount) {
        int next = Math.max(0, amount);
        switch (resource) {
            case COAL: coal = Math.min(RESOURCE_CAP, coal + next); break;
            case COPPER: copper = Math.min(RESOURCE_CAP, copper + next); break;
            case IRON: iron = Math.min(RESOURCE_CAP, iron + next); break;
            case GOLD: gold = Math.min(RESOURCE_CAP, gold + next); break;
            case REDSTONE: redstone = Math.min(RESOURCE_CAP, redstone + next); break;
            case LAPIS: lapis = Math.min(RESOURCE_CAP, lapis + next); break;
            case DIAMOND: diamond = Math.min(RESOURCE_CAP, diamond + next); break;
            case EMERALD: emerald = Math.min(RESOURCE_CAP, emerald + next); break;
            case ANCIENT_DEBRIS: ancientDebris = Math.min(RESOURCE_CAP, ancientDebris + next); break;
            default: break;
        }
    }

    /** Returns the current amount of a material in Steve's inventory. */
    public int getResource(SteveResource resource) {
        switch (resource) {
            case COAL: return coal;
            case COPPER: return copper;
            case IRON: return iron;
            case GOLD: return gold;
            case REDSTONE: return redstone;
            case LAPIS: return lapis;
            case DIAMOND: return diamond;
            case EMERALD: return emerald;
            case ANCIENT_DEBRIS: return ancientDebris;
            default: return 0;
        }
    }

    public SteveCharacter(String name) {
        super(name, SteveEnums.STEVE, null, null, new SteveSpriteAnimation());

        initializeClass(null,
                SteveTheCrafterMod.makePath("images/char/shoulder2.png"),
                SteveTheCrafterMod.makePath("images/char/shoulder1.png"),
                SteveTheCrafterMod.makePath("images/char/corpse.png"),
                getLoadout(), 0.0F, 0.0F, 220.0F, 290.0F,
                new EnergyManager(ENERGY_PER_TURN));
    }

    @Override public ArrayList<String> getStartingDeck() {
        ArrayList<String> deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) deck.add("stevethecrafter:WoodenSword");
        for (int i = 0; i < 2; i++) deck.add("stevethecrafter:WoodenPickaxe");
        for (int i = 0; i < 2; i++) deck.add("stevethecrafter:WoodenShield");
        deck.add("stevethecrafter:MineCoal");
        deck.add("stevethecrafter:MakeTorch");
        return deck;
    }

    @Override public ArrayList<String> getStartingRelics() {
        ArrayList<String> relics = new ArrayList<>();
        relics.add(SteveInventory.ID);
        UnlockTracker.markRelicAsSeen(SteveInventory.ID);
        return relics;
    }

    @Override public CharSelectInfo getLoadout() {
        return new CharSelectInfo("Steve the Crafter",
                "A resourceful builder who mines materials, crafts equipment, and grows stronger throughout the run.",
                72, 72, 0, 99, 5, this, getStartingRelics(), getStartingDeck(), false);
    }
    @Override public String getTitle(AbstractPlayer.PlayerClass playerClass) { return "Steve the Crafter"; }
    @Override public AbstractCard getStartCardForEvent() { return null; }
    @Override public AbstractCard.CardColor getCardColor() { return SteveEnums.STEVE_COLOR; }
    @Override public Color getCardTrailColor() { return STEVE_COLOR.cpy(); }
    @Override public Color getCardRenderColor() { return STEVE_COLOR.cpy(); }
    @Override public Color getSlashAttackColor() { return STEVE_COLOR.cpy(); }
    @Override public String getSpireHeartText() { return "You approach the Heart with your tools ready..."; }
    @Override public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[] { AbstractGameAction.AttackEffect.SLASH_HEAVY };
    }
    @Override public String getVampireText() { return "Would you like to trade some supplies for a taste of immortality?"; }
    @Override public AbstractPlayer newInstance() { return new SteveCharacter(name); }
    @Override public String getCustomModeCharacterButtonSoundKey() { return "UNLOCK_PING"; }
    @Override public String getLocalizedCharacterName() { return "Steve the Crafter"; }
    @Override public int getAscensionMaxHPLoss() { return 5; }
    @Override public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.sound.playA("UNLOCK_PING", MathUtils.random(-0.15F, 0.15F));
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.LOW, ScreenShake.ShakeDur.SHORT, false);
    }
    @Override public BitmapFont getEnergyNumFont() { return FontHelper.energyNumFontBlue; }
    @Override public void applyEndOfTurnTriggers() {
        for (AbstractPower power : this.powers) power.atEndOfTurn(true);
        AbstractDungeon.actionManager.addToBottom(new ExhaustAllEtherealAction());
    }
}

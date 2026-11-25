package stevethecrafter.characters;

import basemod.abstracts.CustomPlayer;
import basemod.animations.SpriterAnimation;
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

import java.util.ArrayList;

/** Steve's selectable character shell. */
public class SteveCharacter extends CustomPlayer {
    public static final int ENERGY_PER_TURN = 3;
    private static final Color STEVE_COLOR = new Color(0.20F, 0.68F, 0.62F, 1.0F);

    public SteveCharacter(String name) {
        super(name, SteveEnums.STEVE,
                new String[] {
                    SteveTheCrafterMod.makePath("images/char/orb/layer1.png"),
                    SteveTheCrafterMod.makePath("images/char/orb/layer2.png"),
                    SteveTheCrafterMod.makePath("images/char/orb/layer3.png"),
                    SteveTheCrafterMod.makePath("images/char/orb/layer4.png"),
                    SteveTheCrafterMod.makePath("images/char/orb/layer5.png"),
                    SteveTheCrafterMod.makePath("images/char/orb/layer6.png"),
                    SteveTheCrafterMod.makePath("images/char/orb/layer1d.png"),
                    SteveTheCrafterMod.makePath("images/char/orb/layer2d.png"),
                    SteveTheCrafterMod.makePath("images/char/orb/layer3d.png"),
                    SteveTheCrafterMod.makePath("images/char/orb/layer4d.png"),
                    SteveTheCrafterMod.makePath("images/char/orb/layer5d.png")
                },
                SteveTheCrafterMod.makePath("images/char/orb/vfx.png"),
                new SpriterAnimation(SteveTheCrafterMod.makePath("images/char/animation.scml")));

        initializeClass(null,
                SteveTheCrafterMod.makePath("images/char/shoulder2.png"),
                SteveTheCrafterMod.makePath("images/char/shoulder1.png"),
                SteveTheCrafterMod.makePath("images/char/corpse.png"),
                getLoadout(), 0.0F, 0.0F, 220.0F, 290.0F,
                new EnergyManager(ENERGY_PER_TURN));
    }

    @Override public ArrayList<String> getStartingDeck() {
        ArrayList<String> deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) deck.add("Strike_P");
        for (int i = 0; i < 4; i++) deck.add("Defend_P");
        // Temporary vanilla starter until Steve's custom cards are registered.
        deck.add("Strike_P");
        deck.add("Defend_P");
        return deck;
    }

    @Override public ArrayList<String> getStartingRelics() {
        ArrayList<String> relics = new ArrayList<>();
        // Steve's Inventory will replace this placeholder in the next milestone.
        relics.add("Burning Blood");
        UnlockTracker.markRelicAsSeen("Burning Blood");
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

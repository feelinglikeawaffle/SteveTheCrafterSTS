package stevethecrafter.relics;

import basemod.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import stevethecrafter.actions.GainResourceAction;
import stevethecrafter.resources.SteveResource;
import stevethecrafter.SteveTheCrafterMod;

/** Steve's run-defining starter relic. */
public class SteveInventory extends CustomRelic {
    public static final String ID = "stevethecrafter:SteveInventory";

    public SteveInventory() {
        // Use a guaranteed vanilla texture for the first startup test.
        // The custom Steve inventory art can be restored once its loading path is verified.
        super(ID, ImageMaster.loadImage("images/relics/burning_blood.png"),
                RelicTier.STARTER, LandingSound.CLINK);
    }

    @Override
    public void atBattleStart() {
        addToBot(new GainResourceAction(SteveResource.COAL, 1));
        addToBot(new GainResourceAction(SteveResource.IRON, 1));
    }

    @Override public String getUpdatedDescription() {
        return "At the start of each combat, gain 1 Coal and 1 Iron.";
    }

    @Override public AbstractRelic makeCopy() { return new SteveInventory(); }
}

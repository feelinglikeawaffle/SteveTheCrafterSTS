package stevethecrafter.relics;

import basemod.abstracts.CustomRelic;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import stevethecrafter.SteveTheCrafterMod;
import stevethecrafter.actions.GainResourceAction;
import stevethecrafter.resources.SteveResource;

/** Steve's run-defining starter relic. */
public class SteveInventory extends CustomRelic {
    public static final String ID = "stevethecrafter:SteveInventory";

    public SteveInventory() {
        // This texture is bundled inside the mod JAR at this exact path.
        super(ID, ImageMaster.loadImage(SteveTheCrafterMod.makePath("images/relics/steves_inventory.png")),
                RelicTier.STARTER, LandingSound.CLINK);
    }

    @Override
    public void atBattleStart() {
        addToBot(new GainResourceAction(SteveResource.COAL, 1));
        addToBot(new GainResourceAction(SteveResource.IRON, 1));
    }

    @Override
    public String getUpdatedDescription() {
        return "At the start of each combat, gain 1 Coal and 1 Iron.";
    }

    @Override
    public AbstractRelic makeCopy() {
        return new SteveInventory();
    }
}

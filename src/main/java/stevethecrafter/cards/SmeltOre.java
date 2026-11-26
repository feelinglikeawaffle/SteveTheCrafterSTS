package stevethecrafter.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import stevethecrafter.actions.GainResourceAction;
import stevethecrafter.resources.SteveResource;

public class SmeltOre extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:SmeltOre";
    public SmeltOre() {
        super(ID, "Smelt Ore", "images/cards/smelt_ore.png", 1, "Gain 2 Iron and 1 Coal.", CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        animateCraft();
        addToBot(new GainResourceAction(SteveResource.IRON, upgraded ? 3 : 2));
        addToBot(new GainResourceAction(SteveResource.COAL, 1));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); rawDescription = "Gain 3 Iron and 1 Coal."; initializeDescription(); } }
    @Override public AbstractSteveCard makeCopy() { return new SmeltOre(); }
}

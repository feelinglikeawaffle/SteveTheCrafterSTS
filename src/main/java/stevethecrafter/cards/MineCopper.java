package stevethecrafter.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import stevethecrafter.actions.GainResourceAction;
import stevethecrafter.resources.SteveResource;

public class MineCopper extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:MineCopper";
    public MineCopper() {
        super(ID, "Mine Copper", "images/materials/copper.png", 1, "Gain 2 Copper.", CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        animateMine();
        addToBot(new GainResourceAction(SteveResource.COPPER, upgraded ? 3 : 2));
    }
    @Override public void upgrade() {
        if (!upgraded) { upgradeName(); rawDescription = "Gain 3 Copper."; initializeDescription(); }
    }
    @Override public AbstractSteveCard makeCopy() { return new MineCopper(); }
}

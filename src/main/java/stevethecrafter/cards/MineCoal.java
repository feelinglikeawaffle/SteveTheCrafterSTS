package stevethecrafter.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import stevethecrafter.actions.GainResourceAction;
import stevethecrafter.resources.SteveResource;

public class MineCoal extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:MineCoal";
    public MineCoal() {
        super(ID, "Mine Coal", "mine_coal.png", 1, "Gain 2 Coal.", CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) { addToBot(new GainResourceAction(SteveResource.COAL, upgraded ? 3 : 2)); }
    @Override public void upgrade() { if (!upgraded) upgradeName(); }
    @Override public AbstractSteveCard makeCopy() { return new MineCoal(); }
}

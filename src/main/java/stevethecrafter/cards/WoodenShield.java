package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class WoodenShield extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:WoodenShield";
    public WoodenShield() {
        super(ID, "Wooden Shield", "wooden_shield.png", 1, "Gain !B! Block.", CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        baseBlock = 5;
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) { addToBot(new GainBlockAction(p, p, block)); }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); upgradeBlock(3); } }
    @Override public AbstractSteveCard makeCopy() { return new WoodenShield(); }
}

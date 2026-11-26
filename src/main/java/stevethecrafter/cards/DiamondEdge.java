package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class DiamondEdge extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:DiamondEdge";
    public DiamondEdge() {
        super(ID, "Diamond Edge", "images/cards/diamond_edge.png", 2, "Deal !D! damage.", CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 18;
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        animateAttack();
        addToBot(new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HEAVY));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); upgradeDamage(6); } }
    @Override public AbstractSteveCard makeCopy() { return new DiamondEdge(); }
}

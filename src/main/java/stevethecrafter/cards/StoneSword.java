package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class StoneSword extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:StoneSword";
    public StoneSword() {
        super(ID, "Stone Sword", "card_placeholder.png", 1, "Deal 8 damage.", CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 8;
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        animateAttack();
        addToBot(new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); upgradeDamage(3); } }
    @Override public AbstractSteveCard makeCopy() { return new StoneSword(); }
}

package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class TNT extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:TNT";
    public TNT() {
        super(ID, "TNT!", "images/rooms/nether_portal.png", 2, "Deal 10 damage to ALL enemies.", CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        baseDamage = 10;
        isMultiDamage = true;
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        animateAttack();
        addToBot(new DamageAllEnemiesAction(p, multiDamage, DamageInfo.DamageType.NORMAL, AbstractGameAction.AttackEffect.FIRE));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); upgradeDamage(4); } }
    @Override public AbstractSteveCard makeCopy() { return new TNT(); }
}

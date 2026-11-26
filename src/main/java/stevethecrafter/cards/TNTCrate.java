package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class TNTCrate extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:TNTCrate";
    public TNTCrate() {
        super(ID, "TNT Crate", "images/cards/tnt_crate.png", 2, "Deal !D! damage to ALL enemies. Exhaust.", CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        baseDamage = 12;
        isMultiDamage = true;
        exhaust = true;
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        animateAttack();
        addToBot(new DamageAllEnemiesAction(p, multiDamage, DamageInfo.DamageType.NORMAL, AbstractGameAction.AttackEffect.FIRE));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); upgradeDamage(5); } }
    @Override public AbstractSteveCard makeCopy() { return new TNTCrate(); }
}

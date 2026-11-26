package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class ForgeStrike extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:ForgeStrike";
    public ForgeStrike() {
        super(ID, "Forge Strike", "images/cards/forge_strike.png", 2, "Deal !D! damage.", CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 15;
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        animateAttack();
        addToBot(new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.FIRE));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); upgradeDamage(5); } }
    @Override public AbstractSteveCard makeCopy() { return new ForgeStrike(); }
}

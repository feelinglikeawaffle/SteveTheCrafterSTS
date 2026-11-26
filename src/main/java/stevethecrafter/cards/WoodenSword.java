package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class WoodenSword extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:WoodenSword";
    public WoodenSword() {
        super(ID, "Wooden Sword", "images/cards/wooden_sword.png", 1, "Deal !D! damage.", CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY);
        baseDamage = 6;
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        animateAttack();
        addToBot(new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); upgradeDamage(3); } }
    @Override public AbstractSteveCard makeCopy() { return new WoodenSword(); }
}

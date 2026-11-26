package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import stevethecrafter.actions.GainResourceAction;
import stevethecrafter.resources.SteveResource;

public class IronAxe extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:IronAxe";
    public IronAxe() {
        super(ID, "Iron Axe", "images/cards/iron_axe.png", 1, "Deal !D! damage. Gain 1 Iron.", CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 9;
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        animateAttack();
        addToBot(new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HEAVY));
        addToBot(new GainResourceAction(SteveResource.IRON, 1));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); upgradeDamage(3); } }
    @Override public AbstractSteveCard makeCopy() { return new IronAxe(); }
}

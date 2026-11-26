package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import stevethecrafter.actions.GainResourceAction;
import stevethecrafter.resources.SteveResource;

public class NetheriteHammer extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:NetheriteHammer";
    public NetheriteHammer() {
        super(ID, "Netherite Hammer", "images/cards/netherite_hammer.png", 3, "Deal !D! damage. Gain 2 Ancient Debris.", CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 26;
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        animateAttack();
        addToBot(new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        addToBot(new GainResourceAction(SteveResource.ANCIENT_DEBRIS, 2));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); upgradeDamage(8); } }
    @Override public AbstractSteveCard makeCopy() { return new NetheriteHammer(); }
}

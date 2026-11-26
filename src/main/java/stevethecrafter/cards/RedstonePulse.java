package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import stevethecrafter.actions.GainResourceAction;
import stevethecrafter.resources.SteveResource;

public class RedstonePulse extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:RedstonePulse";
    public RedstonePulse() {
        super(ID, "Redstone Pulse", "images/cards/redstone_pulse.png", 1, "Deal !D! damage to ALL enemies. Gain 1 Redstone.", CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        baseDamage = 5;
        isMultiDamage = true;
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        animateCraft();
        addToBot(new DamageAllEnemiesAction(p, multiDamage, DamageInfo.DamageType.NORMAL, AbstractGameAction.AttackEffect.LIGHTNING));
        addToBot(new GainResourceAction(SteveResource.REDSTONE, 1));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); upgradeDamage(2); } }
    @Override public AbstractSteveCard makeCopy() { return new RedstonePulse(); }
}

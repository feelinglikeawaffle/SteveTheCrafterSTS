package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import stevethecrafter.actions.GainResourceAction;
import stevethecrafter.resources.SteveResource;

public class LapisFocus extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:LapisFocus";
    public LapisFocus() {
        super(ID, "Lapis Focus", "images/cards/lapis_focus.png", 1, "Gain 1 Lapis. Draw 1 card.", CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainResourceAction(SteveResource.LAPIS, 1));
        addToBot(new DrawCardAction(p, upgraded ? 2 : 1));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); rawDescription = "Gain 1 Lapis. Draw 2 cards."; initializeDescription(); } }
    @Override public AbstractSteveCard makeCopy() { return new LapisFocus(); }
}

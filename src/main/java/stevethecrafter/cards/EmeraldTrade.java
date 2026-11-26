package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import stevethecrafter.actions.GainResourceAction;
import stevethecrafter.resources.SteveResource;

public class EmeraldTrade extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:EmeraldTrade";
    public EmeraldTrade() {
        super(ID, "Emerald Trade", "images/cards/emerald_trade.png", 0, "Gain 2 Gold. Draw 1 card.", CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainResourceAction(SteveResource.GOLD, upgraded ? 3 : 2));
        addToBot(new DrawCardAction(p, 1));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); rawDescription = "Gain 3 Gold. Draw 1 card."; initializeDescription(); } }
    @Override public AbstractSteveCard makeCopy() { return new EmeraldTrade(); }
}

package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import stevethecrafter.actions.GainResourceAction;
import stevethecrafter.resources.SteveResource;

public class LapisEnchant extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:LapisEnchant";
    public LapisEnchant() {
        super(ID, "Lapis Enchantment", "images/relics/enchanted_book.png", 1, "Gain 1 Lapis. Draw 1 card.", CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        animateCraft();
        addToBot(new GainResourceAction(SteveResource.LAPIS, upgraded ? 2 : 1));
        addToBot(new DrawCardAction(p, 1));
    }
    @Override public void upgrade() {
        if (!upgraded) { upgradeName(); rawDescription = "Gain 2 Lapis. Draw 1 card."; initializeDescription(); }
    }
    @Override public AbstractSteveCard makeCopy() { return new LapisEnchant(); }
}

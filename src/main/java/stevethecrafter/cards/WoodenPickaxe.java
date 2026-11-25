package stevethecrafter.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import stevethecrafter.actions.GainResourceAction;
import stevethecrafter.resources.SteveResource;

public class WoodenPickaxe extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:WoodenPickaxe";
    public WoodenPickaxe() {
        super(ID, "Wooden Pickaxe", "wooden_pickaxe.png", 1, "Gain 2 Iron.", CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) { addToBot(new GainResourceAction(SteveResource.IRON, upgraded ? 3 : 2)); }
    @Override public void upgrade() { if (!upgraded) upgradeName(); }
    @Override public AbstractSteveCard makeCopy() { return new WoodenPickaxe(); }
}

package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import stevethecrafter.actions.GainResourceAction;
import stevethecrafter.resources.SteveResource;

public class CobblestoneGuard extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:CobblestoneGuard";
    public CobblestoneGuard() {
        super(ID, "Cobblestone Guard", "images/cards/cobblestone_guard.png", 1, "Gain !B! Block. Gain 1 Coal.", CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = 8;
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        animateBlock();
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new GainResourceAction(SteveResource.COAL, 1));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); upgradeBlock(3); } }
    @Override public AbstractSteveCard makeCopy() { return new CobblestoneGuard(); }
}

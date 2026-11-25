package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import stevethecrafter.actions.GainResourceAction;
import stevethecrafter.resources.SteveResource;

public class MineRedstone extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:MineRedstone";
    public MineRedstone() {
        super(ID, "Redstone Circuit", "card_placeholder.png", 1, "Gain 4 Block and 1 Redstone.", CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = 4;
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new GainResourceAction(SteveResource.REDSTONE, 1));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); upgradeBlock(3); } }
    @Override public AbstractSteveCard makeCopy() { return new MineRedstone(); }
}

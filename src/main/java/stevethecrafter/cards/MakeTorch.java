package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import stevethecrafter.actions.GainResourceAction;
import stevethecrafter.resources.SteveResource;

public class MakeTorch extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:MakeTorch";
    public MakeTorch() {
        super(ID, "Make a Torch", "images/relics/redstone_torch.png", 1, "Gain !B! Block. Gain 1 Coal.", CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        baseBlock = 5;
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        animateCraft();
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new GainResourceAction(SteveResource.COAL, 1));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); upgradeBlock(3); } }
    @Override public AbstractSteveCard makeCopy() { return new MakeTorch(); }
}

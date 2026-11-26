package stevethecrafter.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;

public class EnchantedArmor extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:EnchantedArmor";
    public EnchantedArmor() {
        super(ID, "Enchanted Armor", "images/cards/enchanted_armor.png", 1, "Gain !B! Block. Gain 1 Dexterity.", CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 7;
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        animateBlock();
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, 1), 1));
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); upgradeBlock(3); } }
    @Override public AbstractSteveCard makeCopy() { return new EnchantedArmor(); }
}

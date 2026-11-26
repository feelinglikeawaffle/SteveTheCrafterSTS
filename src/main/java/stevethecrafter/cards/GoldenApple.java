package stevethecrafter.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class GoldenApple extends AbstractSteveCard {
    public static final String ID = "stevethecrafter:GoldenApple";
    public GoldenApple() {
        super(ID, "Golden Apple", "images/cards/golden_apple.png", 1, "Heal 5 HP.", CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        exhaust = true;
    }
    @Override public void use(AbstractPlayer p, AbstractMonster m) {
        p.heal(upgraded ? 8 : 5);
    }
    @Override public void upgrade() { if (!upgraded) { upgradeName(); rawDescription = "Heal 8 HP."; initializeDescription(); } }
    @Override public AbstractSteveCard makeCopy() { return new GoldenApple(); }
}

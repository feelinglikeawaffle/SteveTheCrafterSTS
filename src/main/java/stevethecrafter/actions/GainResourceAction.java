package stevethecrafter.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import stevethecrafter.characters.SteveCharacter;
import stevethecrafter.resources.SteveResource;

/** Adds run resources safely; non-Steve characters are ignored. */
public class GainResourceAction extends AbstractGameAction {
    private final SteveResource resource;
    private final int amount;
    public GainResourceAction(SteveResource resource, int amount) {
        this.resource = resource;
        this.amount = Math.max(0, amount);
        this.actionType = ActionType.SPECIAL;
    }
    @Override public void update() {
        if (AbstractDungeon.player instanceof SteveCharacter) {
            ((SteveCharacter) AbstractDungeon.player).gainResource(resource, amount);
        }
        isDone = true;
    }
}

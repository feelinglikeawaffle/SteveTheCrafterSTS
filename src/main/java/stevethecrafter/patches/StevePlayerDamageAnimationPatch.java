package stevethecrafter.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import stevethecrafter.characters.SteveCharacter;
import stevethecrafter.characters.SteveSpriteAnimation;

/** Play Steve's hurt/death sprite clips after player damage resolves. */
@SpirePatch(clz = AbstractPlayer.class, method = "damage", paramtypez = {DamageInfo.class})
public class StevePlayerDamageAnimationPatch {
    @SpirePostfixPatch
    public static void Postfix(AbstractPlayer __instance, DamageInfo info) {
        if (!(__instance instanceof SteveCharacter)) return;
        if (__instance.currentHealth <= 0) {
            SteveCharacter.playAnimation(SteveSpriteAnimation.Clip.DEATH);
        } else {
            SteveCharacter.playAnimation(SteveSpriteAnimation.Clip.HURT);
        }
    }
}

package stevethecrafter.characters;

import basemod.animations.AbstractAnimation;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.core.Settings;
import stevethecrafter.SteveTheCrafterMod;

/** Pixel-art animation renderer backed by Steve's imported 6x8 atlas. */
public final class SteveSpriteAnimation extends AbstractAnimation {
    public enum Clip {
        IDLE(0, 6, 150, true, false),
        WALK(1, 6, 110, true, false),
        MINE(2, 6, 100, false, false),
        SWORD(3, 6, 90, false, false),
        BLOCK(4, 4, 120, false, false),
        HURT(5, 3, 90, false, false),
        DEATH(6, 6, 130, false, true),
        CRAFT(7, 4, 120, false, false);

        final int row, frames, frameDurationMs;
        final boolean loop, holdLast;
        Clip(int row, int frames, int frameDurationMs, boolean loop, boolean holdLast) {
            this.row = row;
            this.frames = frames;
            this.frameDurationMs = frameDurationMs;
            this.loop = loop;
            this.holdLast = holdLast;
        }
    }

    private static final int FRAME_WIDTH = 96;
    private static final int FRAME_HEIGHT = 128;
    private static final float DRAW_WIDTH = 192.0F;
    private static final float DRAW_HEIGHT = 256.0F;
    private static Texture atlas;

    private Clip clip = Clip.IDLE;
    private float elapsed;
    private boolean flipX, flipY;

    @Override public Type type() { return Type.SPRITE; }

    /** Restarts one-shot clips; looping clips keep their current phase if requested again. */
    public void play(Clip next) {
        if (next == null) return;
        if (next != clip || !next.loop) {
            clip = next;
            elapsed = 0.0F;
        }
    }

    @Override public void setFlip(boolean horizontal, boolean vertical) {
        flipX = horizontal;
        flipY = vertical;
    }

    private static Texture getAtlas() {
        if (atlas == null) {
            atlas = new Texture(Gdx.files.internal(
                    SteveTheCrafterMod.makePath("images/char/animation/steve_animation_atlas.png")));
            atlas.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        }
        return atlas;
    }

    @Override public void renderSprite(SpriteBatch batch, float x, float y) {
        elapsed += Gdx.graphics.getDeltaTime();
        int frame = (int) (elapsed * 1000.0F / clip.frameDurationMs);
        if (clip.loop) {
            frame %= clip.frames;
        } else if (frame >= clip.frames) {
            if (clip.holdLast) {
                frame = clip.frames - 1;
            } else {
                clip = Clip.IDLE;
                elapsed = 0.0F;
                frame = 0;
            }
        }

        float scale = Settings.scale;
        float width = DRAW_WIDTH * scale;
        float height = DRAW_HEIGHT * scale;
        float drawX = x - width * 0.5F;
        float drawY = y - height + 8.0F * scale;
        Color oldColor = batch.getColor().cpy();
        batch.setColor(Color.WHITE);
        batch.draw(getAtlas(), drawX, drawY, width, height,
                frame * FRAME_WIDTH, clip.row * FRAME_HEIGHT,
                FRAME_WIDTH, FRAME_HEIGHT, flipX, flipY);
        batch.setColor(oldColor);
    }
}

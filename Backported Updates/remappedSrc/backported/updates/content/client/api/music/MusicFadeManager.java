/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1113
 *  net.minecraft.class_1140
 *  net.minecraft.class_1142
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_4235$class_4236
 *  net.minecraft.class_6880
 *  net.minecraft.class_746
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.client.api.music;

import backported.updates.content.common.registries.ModBiomes;
import backported_updates.mixin.access.SoundEngineAccessor;
import backported_updates.mixin.access.SoundManagerAccessor;
import net.minecraft.class_1113;
import net.minecraft.class_1140;
import net.minecraft.class_1142;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4235;
import net.minecraft.class_6880;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;

public class MusicFadeManager {
    private static final float FADE_OUT_FACTOR = 0.97f;
    private static final float FADE_IN_MIN_STEP = 5.0E-4f;
    private static final float FADE_IN_MAX_STEP = 0.005f;
    private static final float VOLUME_THRESHOLD = 1.0E-4f;
    private final class_1142 manager;
    private final class_310 minecraft;
    private float currentGain = 1.0f;

    public MusicFadeManager(class_1142 manager) {
        this.manager = manager;
        this.minecraft = class_310.method_1551();
    }

    public static boolean isFeatureEnabled() {
        return true;
    }

    public boolean onTick(@Nullable class_1113 currentMusic) {
        if (!MusicFadeManager.isFeatureEnabled()) {
            return false;
        }
        if (currentMusic == null) {
            return false;
        }
        float targetVolume = this.getBackgroundMusicVolume();
        return this.currentGain != targetVolume && this.fadePlaying(targetVolume, currentMusic);
    }

    public boolean preventPlayingInPaleGarden() {
        if (!MusicFadeManager.isFeatureEnabled()) {
            return false;
        }
        if (this.minecraft.field_1724 == null) {
            return false;
        }
        class_6880 biome = this.minecraft.field_1724.method_37908().method_23753(this.minecraft.field_1724.method_24515());
        return biome.method_40225(ModBiomes.PALE_GARDEN);
    }

    public void updateVolume(@Nullable class_1113 currentMusic) {
        if (!MusicFadeManager.isFeatureEnabled()) {
            return;
        }
        if (currentMusic != null) {
            class_1140 engine = ((SoundManagerAccessor)this.minecraft.method_1483()).getSoundEngine();
            this.setVolume(engine, currentMusic, this.getBackgroundMusicVolume());
        }
    }

    public void onStartPlaying() {
        if (!MusicFadeManager.isFeatureEnabled()) {
            return;
        }
        this.currentGain = this.getBackgroundMusicVolume();
    }

    private boolean fadePlaying(float targetVolume, class_1113 currentMusic) {
        if (this.currentGain == targetVolume) {
            return true;
        }
        this.updateCurrentGain(targetVolume);
        if (this.currentGain <= 1.0E-4f) {
            this.manager.method_4859();
            return false;
        }
        class_1140 engine = ((SoundManagerAccessor)this.minecraft.method_1483()).getSoundEngine();
        this.setVolume(engine, currentMusic, this.currentGain);
        return true;
    }

    private void updateCurrentGain(float targetVolume) {
        if (this.currentGain < targetVolume) {
            this.fadeIn(targetVolume);
        } else {
            this.fadeOut(targetVolume);
        }
        this.currentGain = class_3532.method_15363((float)this.currentGain, (float)0.0f, (float)1.0f);
    }

    private void fadeIn(float targetVolume) {
        float step = class_3532.method_15363((float)this.currentGain, (float)5.0E-4f, (float)0.005f);
        this.currentGain = Math.min(this.currentGain + step, targetVolume);
    }

    private void fadeOut(float targetVolume) {
        this.currentGain = 0.97f * this.currentGain + 0.029999971f * targetVolume;
        if (Math.abs(this.currentGain - targetVolume) < 1.0E-4f) {
            this.currentGain = targetVolume;
        }
    }

    private float getBackgroundMusicVolume() {
        class_746 player = this.minecraft.field_1724;
        if (player == null) {
            return 1.0f;
        }
        class_6880 biome = player.method_37908().method_23753(player.method_24515());
        return biome.method_40225(ModBiomes.PALE_GARDEN) ? 0.0f : 1.0f;
    }

    private void setVolume(class_1140 engine, class_1113 instance, float volume) {
        SoundEngineAccessor accessor = (SoundEngineAccessor)engine;
        if (!accessor.isLoaded()) {
            return;
        }
        class_4235.class_4236 handle = accessor.getInstanceToChannel().get(instance);
        if (handle != null) {
            handle.method_19735(channel -> channel.method_19647(volume * accessor.callCalculateVolume(instance)));
        }
    }
}


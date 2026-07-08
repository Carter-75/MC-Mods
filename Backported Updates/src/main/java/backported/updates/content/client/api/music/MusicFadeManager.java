/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.sound.SoundInstance
 *  net.minecraft.client.sound.SoundSystem
 *  net.minecraft.client.sound.MusicTracker
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.client.sound.Channel$SourceManager
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.client.network.ClientPlayerEntity
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.client.api.music;

import backported.updates.content.common.registries.ModBiomes;
import backported_updates.mixin.access.SoundEngineAccessor;
import backported_updates.mixin.access.SoundManagerAccessor;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundSystem;
import net.minecraft.client.sound.MusicTracker;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.sound.Channel;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.client.network.ClientPlayerEntity;
import org.jetbrains.annotations.Nullable;

public class MusicFadeManager {
    private static final float FADE_OUT_FACTOR = 0.97f;
    private static final float FADE_IN_MIN_STEP = 5.0E-4f;
    private static final float FADE_IN_MAX_STEP = 0.005f;
    private static final float VOLUME_THRESHOLD = 1.0E-4f;
    private final MusicTracker manager;
    private final MinecraftClient minecraft;
    private float currentGain = 1.0f;

    public MusicFadeManager(MusicTracker manager) {
        this.manager = manager;
        this.minecraft = MinecraftClient.getInstance();
    }

    public static boolean isFeatureEnabled() {
        return true;
    }

    public boolean onTick(@Nullable SoundInstance currentMusic) {
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
        if (this.minecraft.player == null) {
            return false;
        }
        RegistryEntry biome = this.minecraft.player.getWorld().getBiome(this.minecraft.player.getBlockPos());
        return biome.matchesKey(ModBiomes.PALE_GARDEN);
    }

    public void updateVolume(@Nullable SoundInstance currentMusic) {
        if (!MusicFadeManager.isFeatureEnabled()) {
            return;
        }
        if (currentMusic != null) {
        SoundSystem engine = ((SoundManagerAccessor)this.minecraft.getSoundManager()).getSoundSystem();
            this.setVolume(engine, currentMusic, this.getBackgroundMusicVolume());
        }
    }

    public void onStartPlaying() {
        if (!MusicFadeManager.isFeatureEnabled()) {
            return;
        }
        this.currentGain = this.getBackgroundMusicVolume();
    }

    private boolean fadePlaying(float targetVolume, SoundInstance currentMusic) {
        if (this.currentGain == targetVolume) {
            return true;
        }
        this.updateCurrentGain(targetVolume);
        if (this.currentGain <= 1.0E-4f) {
            this.manager.stop();
            return false;
        }
        SoundSystem engine = ((SoundManagerAccessor)this.minecraft.getSoundManager()).getSoundSystem();
        this.setVolume(engine, currentMusic, this.currentGain);
        return true;
    }

    private void updateCurrentGain(float targetVolume) {
        if (this.currentGain < targetVolume) {
            this.fadeIn(targetVolume);
        } else {
            this.fadeOut(targetVolume);
        }
        this.currentGain = MathHelper.clamp((float)this.currentGain, (float)0.0f, (float)1.0f);
    }

    private void fadeIn(float targetVolume) {
        float step = MathHelper.clamp((float)this.currentGain, (float)5.0E-4f, (float)0.005f);
        this.currentGain = Math.min(this.currentGain + step, targetVolume);
    }

    private void fadeOut(float targetVolume) {
        this.currentGain = 0.97f * this.currentGain + 0.029999971f * targetVolume;
        if (Math.abs(this.currentGain - targetVolume) < 1.0E-4f) {
            this.currentGain = targetVolume;
        }
    }

    private float getBackgroundMusicVolume() {
        ClientPlayerEntity player = this.minecraft.player;
        if (player == null) {
            return 1.0f;
        }
        RegistryEntry biome = player.getWorld().getBiome(player.getBlockPos());
        return biome.matchesKey(ModBiomes.PALE_GARDEN) ? 0.0f : 1.0f;
    }

    private void setVolume(SoundSystem engine, SoundInstance instance, float volume) {
        SoundEngineAccessor accessor = (SoundEngineAccessor)engine;
        if (!accessor.isStarted()) {
            return;
        }
        Channel.SourceManager handle = accessor.getSources().get(instance);
        if (handle != null) {
            handle.run(channel -> channel.setVolume(volume * accessor.callGetAdjustedVolume(instance)));
        }
    }
}


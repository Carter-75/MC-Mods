/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.sound.SoundInstance
 *  net.minecraft.client.sound.MusicTracker
 *  net.minecraft.sound.MusicSound
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.client;

import backported.updates.content.client.api.music.MusicFadeManager;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.MusicTracker;
import net.minecraft.sound.MusicSound;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={MusicTracker.class})
public abstract class MusicManagerMixin {
    @Shadow
    @Nullable
    private SoundInstance current;
    @Unique
    private MusicFadeManager fadeManager;

    @Unique
    private MusicFadeManager getFadeManager() {
        if (this.fadeManager == null) {
            this.fadeManager = new MusicFadeManager((MusicTracker)(Object)this);
        }
        return this.fadeManager;
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")}, cancellable=true)
    private void onTick(CallbackInfo ci) {
        if (this.getFadeManager().onTick(this.current)) {
            ci.cancel();
        }
    }

    @Inject(method={"play"}, at={@At(value="HEAD")}, cancellable=true)
    private void preventPlayingInPaleGarden(MusicSound selector, CallbackInfo ci) {
        if (this.getFadeManager().preventPlayingInPaleGarden()) {
            ci.cancel();
        }
    }

    @Inject(method={"play"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/sound/SoundManager;play(Lnet/minecraft/client/sound/SoundInstance;)V")})
    private void updateVolume(MusicSound selector, CallbackInfo ci) {
        this.getFadeManager().updateVolume(this.current);
    }

    @Inject(method={"play"}, at={@At(value="TAIL")})
    private void onStartPlaying(MusicSound selector, CallbackInfo ci) {
        this.getFadeManager().onStartPlaying();
    }
}


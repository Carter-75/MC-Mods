/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1113
 *  net.minecraft.class_1142
 *  net.minecraft.class_5195
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
import net.minecraft.class_1113;
import net.minecraft.class_1142;
import net.minecraft.class_5195;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1142.class})
public abstract class MusicManagerMixin {
    @Shadow
    @Nullable
    private class_1113 field_5574;
    @Unique
    private MusicFadeManager fadeManager;

    @Unique
    private MusicFadeManager getFadeManager() {
        if (this.fadeManager == null) {
            this.fadeManager = new MusicFadeManager((class_1142)this);
        }
        return this.fadeManager;
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")}, cancellable=true)
    private void onTick(CallbackInfo ci) {
        if (this.getFadeManager().onTick(this.field_5574)) {
            ci.cancel();
        }
    }

    @Inject(method={"startPlaying"}, at={@At(value="HEAD")}, cancellable=true)
    private void preventPlayingInPaleGarden(class_5195 selector, CallbackInfo ci) {
        if (this.getFadeManager().preventPlayingInPaleGarden()) {
            ci.cancel();
        }
    }

    @Inject(method={"startPlaying"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/sounds/SoundManager;play(Lnet/minecraft/client/resources/sounds/SoundInstance;)V")})
    private void updateVolume(class_5195 selector, CallbackInfo ci) {
        this.getFadeManager().updateVolume(this.field_5574);
    }

    @Inject(method={"startPlaying"}, at={@At(value="TAIL")})
    private void onStartPlaying(class_5195 selector, CallbackInfo ci) {
        this.getFadeManager().onStartPlaying();
    }
}


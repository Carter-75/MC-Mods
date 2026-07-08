/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.client.event.screen.HudRendering;
import backported.updates.foundation.client.event.screen.api.ScreenAccess;
import backported.updates.foundation.client.event.screen.api.ScreenAccessImpl;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Screen.class})
public class ScreenMixin {
    @Shadow
    @Nullable
    protected MinecraftClient client;
    @Unique
    private ScreenAccessImpl access;

    @Unique
    private ScreenAccess screenAccess() {
        if (this.access == null) {
            this.access = new ScreenAccessImpl((Screen)(Object)this);
        }
        this.access.setScreen((Screen)(Object)this);
        return this.access;
    }

    @Inject(method={"clearAndInit"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$onScreenPreInitialize(CallbackInfo ci) {
        if (HudRendering.PRE_INITIALIZE.invoker().onInitialize(this.client, (Screen)(Object)this, this.screenAccess()).isCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method={"init(Lnet/minecraft/client/MinecraftClient;II)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/Screen;init()V", shift=At.Shift.AFTER)})
    private void platform$onScreenPostInitialize(MinecraftClient minecraft, int width, int height, CallbackInfo ci) {
        HudRendering.POST_INITIALIZE.invoker().onInitialize(minecraft, (Screen)(Object)this, this.screenAccess());
    }

    @Inject(method={"clearAndInit"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/Screen;init()V")}, cancellable=true)
    private void platform$onScreenPreInitializeWidgets(CallbackInfo ci) {
        if (HudRendering.PRE_INITIALIZE.invoker().onInitialize(MinecraftClient.getInstance(), (Screen)(Object)this, this.screenAccess()).isCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method={"clearAndInit"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/Screen;init()V", shift=At.Shift.AFTER)})
    private void platform$onScreenPostInitializeWidgets(CallbackInfo ci) {
        HudRendering.POST_INITIALIZE.invoker().onInitialize(MinecraftClient.getInstance(), (Screen)(Object)this, this.screenAccess());
    }
}


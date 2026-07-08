/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_437
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
import net.minecraft.class_310;
import net.minecraft.class_437;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_437.class})
public class ScreenMixin {
    @Shadow
    @Nullable
    protected class_310 field_22787;
    @Unique
    private ScreenAccessImpl access;

    @Unique
    private ScreenAccess screenAccess() {
        if (this.access == null) {
            this.access = new ScreenAccessImpl((class_437)this);
        }
        this.access.setScreen((class_437)this);
        return this.access;
    }

    @Inject(method={"rebuildWidgets"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$onScreenPreInitialize(CallbackInfo ci) {
        if (HudRendering.PRE_INITIALIZE.invoker().onInitialize(this.field_22787, (class_437)this, this.screenAccess()).isCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method={"init(Lnet/minecraft/client/Minecraft;II)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screens/Screen;init()V", shift=At.Shift.AFTER)})
    private void platform$onScreenPostInitialize(class_310 minecraft, int width, int height, CallbackInfo ci) {
        HudRendering.POST_INITIALIZE.invoker().onInitialize(minecraft, (class_437)this, this.screenAccess());
    }

    @Inject(method={"rebuildWidgets"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screens/Screen;init()V")}, cancellable=true)
    private void platform$onScreenPreInitializeWidgets(CallbackInfo ci) {
        if (HudRendering.PRE_INITIALIZE.invoker().onInitialize(class_310.method_1551(), (class_437)this, this.screenAccess()).isCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method={"rebuildWidgets"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screens/Screen;init()V", shift=At.Shift.AFTER)})
    private void platform$onScreenPostInitializeWidgets(CallbackInfo ci) {
        HudRendering.POST_INITIALIZE.invoker().onInitialize(class_310.method_1551(), (class_437)this, this.screenAccess());
    }
}


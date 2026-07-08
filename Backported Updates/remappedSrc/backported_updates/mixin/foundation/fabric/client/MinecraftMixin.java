/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_746
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.client.event.LocalPlayerEvents;
import backported.updates.foundation.client.event.screen.HudRendering;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_310.class})
public class MinecraftMixin {
    @Shadow
    @Nullable
    public class_746 field_1724;

    @Inject(method={"clearClientLevel"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/GameNarrator;clear()V")})
    private void platform$onLogout(class_437 screen, CallbackInfo ci) {
        LocalPlayerEvents.ON_LOGOUT.invoker().onLogout(this.field_1724);
    }

    @Inject(method={"setScreen"}, at={@At(value="FIELD", target="Lnet/minecraft/client/Minecraft;screen:Lnet/minecraft/client/gui/screens/Screen;", opcode=181)})
    private void platform$onScreenOpen(class_437 screen, CallbackInfo ci) {
        HudRendering.OPEN_CONTAINER.invoker().onOpen((class_310)this, screen);
    }

    @Inject(method={"setScreen"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screens/Screen;removed()V")})
    private void platform$onScreenClose(class_437 screen, CallbackInfo ci) {
        class_310 minecraft = (class_310)this;
        HudRendering.CLOSE_CONTAINER.invoker().onClose(minecraft, minecraft.field_1755);
    }
}


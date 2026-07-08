/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.network.ClientPlayerEntity
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
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={MinecraftClient.class})
public class MinecraftMixin {
    @Shadow
    @Nullable
    public ClientPlayerEntity player;

    @Inject(method={"reset"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/util/NarratorManager;clear()V")})
    private void platform$onLogout(Screen screen, CallbackInfo ci) {
        LocalPlayerEvents.ON_LOGOUT.invoker().onLogout(this.player);
    }

    @Inject(method={"setScreen"}, at={@At(value="FIELD", target="Lnet/minecraft/client/MinecraftClient;currentScreen:Lnet/minecraft/client/gui/screen/Screen;", opcode=181)})
    private void platform$onScreenOpen(Screen screen, CallbackInfo ci) {
        HudRendering.OPEN_CONTAINER.invoker().onOpen((MinecraftClient)(Object)this, screen);
    }

    @Inject(method={"setScreen"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/Screen;removed()V")})
    private void platform$onScreenClose(Screen screen, CallbackInfo ci) {
        MinecraftClient minecraft = (MinecraftClient)(Object)this;
        HudRendering.CLOSE_CONTAINER.invoker().onClose(minecraft, minecraft.currentScreen);
    }
}


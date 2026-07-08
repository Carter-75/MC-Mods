/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.util.Window
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.GameRenderer
 *  net.minecraft.client.render.RenderTickCounter
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fStack
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.LocalCapture
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.client.event.screen.HudRendering;
import net.minecraft.client.util.Window;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderTickCounter;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value={GameRenderer.class}, priority=1100)
public class GameRendererMixin {
    @Shadow
    @Final
    MinecraftClient client;

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/Screen;renderWithTooltip(Lnet/minecraft/client/gui/DrawContext;IIF)V", ordinal=0)}, locals=LocalCapture.CAPTURE_FAILHARD, cancellable=true)
    public void renderScreenPre(RenderTickCounter tickDelta, boolean renderLevel, CallbackInfo ci, boolean gameLoaded, int mouseX, int mouseY, Window window, Matrix4f matrix, Matrix4fStack matrices, DrawContext graphics) {
        if (HudRendering.PRE_RENDERING.invoker().onRender(this.client, this.client.currentScreen, graphics, mouseX, mouseY, tickDelta).isCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/Screen;renderWithTooltip(Lnet/minecraft/client/gui/DrawContext;IIF)V", shift=At.Shift.AFTER, ordinal=0)}, locals=LocalCapture.CAPTURE_FAILHARD)
    public void renderScreenPost(RenderTickCounter tickDelta, boolean renderLevel, CallbackInfo ci, boolean gameLoaded, int mouseX, int mouseY, Window window, Matrix4f matrix, Matrix4fStack matrices, DrawContext graphics) {
        HudRendering.POST_RENDERING.invoker().onRender(this.client, this.client.currentScreen, graphics, mouseX, mouseY, tickDelta);
    }
}


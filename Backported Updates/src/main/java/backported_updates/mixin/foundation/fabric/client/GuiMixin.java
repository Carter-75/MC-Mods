/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.util.Window
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.hud.InGameHud
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.RenderTickCounter
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.client.event.HudRenderEvent;
import net.minecraft.client.util.Window;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={InGameHud.class})
public class GuiMixin {
    @Shadow
    @Final
    private MinecraftClient client;

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/LayeredDrawer;render(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V")})
    private void render(final DrawContext guiGraphics, RenderTickCounter deltaTracker, CallbackInfo ci) {
        HudRenderEvent.RenderContext context = new HudRenderEvent.RenderContext(){

            @Override
            public Window window() {
                return GuiMixin.this.client.getWindow();
            }

            @Override
            public int screenWidth() {
                return guiGraphics.getScaledWindowWidth();
            }

            @Override
            public int screenHeight() {
                return guiGraphics.getScaledWindowHeight();
            }
        };
        HudRenderEvent.RENDER_HUD.invoker().render(guiGraphics, deltaTracker.getLastFrameDuration(), HudRenderEvent.ElementType.FIRST_PERSON, context);
    }
}


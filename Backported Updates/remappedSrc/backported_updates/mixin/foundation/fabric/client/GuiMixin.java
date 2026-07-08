/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_329
 *  net.minecraft.class_332
 *  net.minecraft.class_9779
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.client.event.HudRenderEvent;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.class_9779;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_329.class})
public class GuiMixin {
    @Shadow
    @Final
    private class_310 field_2035;

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/LayeredDraw;render(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/client/DeltaTracker;)V")})
    private void render(final class_332 guiGraphics, class_9779 deltaTracker, CallbackInfo ci) {
        HudRenderEvent.RenderContext context = new HudRenderEvent.RenderContext(){

            @Override
            public class_1041 window() {
                return GuiMixin.this.field_2035.method_22683();
            }

            @Override
            public int screenWidth() {
                return guiGraphics.method_51421();
            }

            @Override
            public int screenHeight() {
                return guiGraphics.method_51443();
            }
        };
        HudRenderEvent.RENDER_HUD.invoker().render(guiGraphics, deltaTracker.method_60636(), HudRenderEvent.ElementType.FIRST_PERSON, context);
    }
}


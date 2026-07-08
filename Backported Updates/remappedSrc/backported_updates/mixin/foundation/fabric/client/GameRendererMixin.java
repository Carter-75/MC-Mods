/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1041
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_757
 *  net.minecraft.class_9779
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
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_757;
import net.minecraft.class_9779;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value={class_757.class}, priority=1100)
public class GameRendererMixin {
    @Shadow
    @Final
    class_310 field_4015;

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screens/Screen;renderWithTooltip(Lnet/minecraft/client/gui/GuiGraphics;IIF)V", ordinal=0)}, locals=LocalCapture.CAPTURE_FAILHARD, cancellable=true)
    public void renderScreenPre(class_9779 tickDelta, boolean renderLevel, CallbackInfo ci, boolean gameLoaded, int mouseX, int mouseY, class_1041 window, Matrix4f matrix, Matrix4fStack matrices, class_332 graphics) {
        if (HudRendering.PRE_RENDERING.invoker().onRender(this.field_4015, this.field_4015.field_1755, graphics, mouseX, mouseY, tickDelta).isCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screens/Screen;renderWithTooltip(Lnet/minecraft/client/gui/GuiGraphics;IIF)V", shift=At.Shift.AFTER, ordinal=0)}, locals=LocalCapture.CAPTURE_FAILHARD)
    public void renderScreenPost(class_9779 tickDelta, boolean renderLevel, CallbackInfo ci, boolean gameLoaded, int mouseX, int mouseY, class_1041 window, Matrix4f matrix, Matrix4fStack matrices, class_332 graphics) {
        HudRendering.POST_RENDERING.invoker().onRender(this.field_4015, this.field_4015.field_1755, graphics, mouseX, mouseY, tickDelta);
    }
}


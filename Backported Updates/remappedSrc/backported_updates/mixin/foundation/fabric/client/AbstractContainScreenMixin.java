/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.client.event.screen.HudRendering;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_465;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_465.class})
public class AbstractContainScreenMixin
extends class_437 {
    protected AbstractContainScreenMixin(class_2561 title) {
        super(title);
    }

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screens/Screen;render(Lnet/minecraft/client/gui/GuiGraphics;IIF)V", ordinal=0, shift=At.Shift.AFTER)})
    public void renderBackground(class_332 graphics, int mouseX, int mouseY, float tickDelta, CallbackInfo ci) {
        HudRendering.RENDER_BACKGROUND.invoker().onRender(this.field_22787, (class_465)this, graphics, mouseX, mouseY, class_310.method_1551().method_60646());
    }

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;renderLabels(Lnet/minecraft/client/gui/GuiGraphics;II)V", ordinal=0, shift=At.Shift.AFTER)})
    public void renderForeground(class_332 graphics, int mouseX, int mouseY, float tickDelta, CallbackInfo ci) {
        HudRendering.RENDER_FOREGROUND.invoker().onRender(this.field_22787, (class_465)this, graphics, mouseX, mouseY, class_310.method_1551().method_60646());
    }
}


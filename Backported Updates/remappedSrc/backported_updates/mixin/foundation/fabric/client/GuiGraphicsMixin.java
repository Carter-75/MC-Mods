/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_5684
 *  net.minecraft.class_8000
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.client.event.screen.TooltipEvents;
import java.util.List;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_5684;
import net.minecraft.class_8000;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_332.class})
public class GuiGraphicsMixin {
    @Inject(method={"renderTooltipInternal"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$onRenderTooltipInternal(class_327 font, List<class_5684> components, int mouseX, int mouseY, class_8000 tooltipPositioner, CallbackInfo ci) {
        if (!components.isEmpty() && TooltipEvents.RENDER_TOOLTIP.invoker().onRendering((class_332)this, components, mouseX, mouseY).isCancelled()) {
            ci.cancel();
        }
    }
}


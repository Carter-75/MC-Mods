/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.font.TextRenderer
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.tooltip.TooltipComponent
 *  net.minecraft.client.gui.tooltip.TooltipPositioner
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.client.event.screen.TooltipEvents;
import java.util.List;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.client.gui.tooltip.TooltipPositioner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={DrawContext.class})
public class GuiGraphicsMixin {
    @Inject(method={"drawTooltip"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$onRenderTooltipInternal(TextRenderer font, List<TooltipComponent> components, int mouseX, int mouseY, TooltipPositioner tooltipPositioner, CallbackInfo ci) {
        if (!components.isEmpty() && TooltipEvents.RENDER_TOOLTIP.invoker().onRendering((DrawContext)(Object)this, components, mouseX, mouseY).isCancelled()) {
            ci.cancel();
        }
    }
}


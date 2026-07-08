/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback
 *  net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
 *  net.minecraft.class_310
 */
package backported.updates.foundation.fabric;

import backported.updates.foundation.client.event.HudRenderEvent;
import backported.updates.foundation.client.event.screen.HudRendering;
import backported.updates.foundation.client.event.screen.TooltipEvents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.class_310;

@Environment(value=EnvType.CLIENT)
public class FabricClientEvents {
    public static void bootstrap() {
        FabricClientEvents.renderHudEvent();
        FabricClientEvents.renderTooltipEvent();
    }

    private static void renderTooltipEvent() {
        ItemTooltipCallback.EVENT.register(TooltipEvents.ITEM_SETUP.invoker()::registerTooltip);
        HudRenderCallback.EVENT.register((graphics, tickDelta) -> HudRendering.RENDERING.invoker().onRender(class_310.method_1551(), graphics, tickDelta));
    }

    private static void renderHudEvent() {
        HudRenderCallback.EVENT.register((matrices, deltaTracker) -> {
            float tickDelta = deltaTracker.method_60636();
            class_310 minecraft = class_310.method_1551();
            HudRenderEvent.RenderContext context = new HudRenderEvent.RenderContext(){};
            if (class_310.method_1517()) {
                HudRenderEvent.RENDER_HUD.invoker().render(matrices, tickDelta, HudRenderEvent.ElementType.VIGNETTE, context);
            }
            if (minecraft.field_1761.method_2908()) {
                HudRenderEvent.RENDER_HUD.invoker().render(matrices, tickDelta, HudRenderEvent.ElementType.HEALTH, context);
            }
            if (minecraft.field_1761.method_2913()) {
                HudRenderEvent.RENDER_HUD.invoker().render(matrices, tickDelta, HudRenderEvent.ElementType.EXPERIENCE, context);
            }
            if (minecraft.field_1690.method_31044().method_31034()) {
                HudRenderEvent.RENDER_HUD.invoker().render(matrices, tickDelta, HudRenderEvent.ElementType.FIRST_PERSON, context);
            }
            HudRenderEvent.RENDER_HUD.invoker().render(matrices, tickDelta, HudRenderEvent.ElementType.DEFAULT, context);
        });
    }
}


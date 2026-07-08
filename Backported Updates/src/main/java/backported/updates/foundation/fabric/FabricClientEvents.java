/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback
 *  net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
 *  net.minecraft.client.MinecraftClient
 */
package backported.updates.foundation.fabric;

import backported.updates.foundation.client.event.HudRenderEvent;
import backported.updates.foundation.client.event.screen.HudRendering;
import backported.updates.foundation.client.event.screen.TooltipEvents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

@Environment(value=EnvType.CLIENT)
public class FabricClientEvents {
    public static void bootstrap() {
        FabricClientEvents.renderHudEvent();
        FabricClientEvents.renderTooltipEvent();
    }

    private static void renderTooltipEvent() {
        ItemTooltipCallback.EVENT.register(TooltipEvents.ITEM_SETUP.invoker()::registerTooltip);
        HudRenderCallback.EVENT.register((graphics, tickDelta) -> HudRendering.RENDERING.invoker().onRender(MinecraftClient.getInstance(), graphics, tickDelta));
    }

    private static void renderHudEvent() {
        HudRenderCallback.EVENT.register((matrices, deltaTracker) -> {
            float tickDelta = deltaTracker.getLastFrameDuration();
            MinecraftClient minecraft = MinecraftClient.getInstance();
            HudRenderEvent.RenderContext context = new HudRenderEvent.RenderContext(){};
            if (MinecraftClient.isFancyGraphicsOrBetter()) {
                HudRenderEvent.RENDER_HUD.invoker().render(matrices, tickDelta, HudRenderEvent.ElementType.VIGNETTE, context);
            }
            if (minecraft.interactionManager.hasStatusBars()) {
                HudRenderEvent.RENDER_HUD.invoker().render(matrices, tickDelta, HudRenderEvent.ElementType.HEALTH, context);
            }
            if (minecraft.interactionManager.hasExperienceBar()) {
                HudRenderEvent.RENDER_HUD.invoker().render(matrices, tickDelta, HudRenderEvent.ElementType.EXPERIENCE, context);
            }
            if (minecraft.options.getPerspective().isFirstPerson()) {
                HudRenderEvent.RENDER_HUD.invoker().render(matrices, tickDelta, HudRenderEvent.ElementType.FIRST_PERSON, context);
            }
            HudRenderEvent.RENDER_HUD.invoker().render(matrices, tickDelta, HudRenderEvent.ElementType.DEFAULT, context);
        });
    }
}


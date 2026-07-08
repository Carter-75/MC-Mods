/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.render.RenderTickCounter
 */
package backported.updates.foundation.client.event.screen;

import backported.updates.foundation.client.event.screen.api.ScreenAccess;
import backported.updates.foundation.core.util.event.CancellableResult;
import backported.updates.foundation.core.util.event.Event;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderTickCounter;

@Environment(value=EnvType.CLIENT)
public interface HudRendering {
    public static final Event<Rendering> RENDERING = Event.create(Rendering.class);
    public static final Event<ScreenPreInitialization> PRE_INITIALIZE = Event.cancellable(ScreenPreInitialization.class);
    public static final Event<ScreenPostInitialization> POST_INITIALIZE = Event.create(ScreenPostInitialization.class);
    public static final Event<ScreenPreRendering> PRE_RENDERING = Event.cancellable(ScreenPreRendering.class);
    public static final Event<ScreenPostRendering> POST_RENDERING = Event.create(ScreenPostRendering.class);
    public static final Event<ContainerRenderBackground> RENDER_BACKGROUND = Event.create(ContainerRenderBackground.class);
    public static final Event<ContainerRenderForeground> RENDER_FOREGROUND = Event.create(ContainerRenderForeground.class);
    public static final Event<OpenContainer> OPEN_CONTAINER = Event.create(OpenContainer.class);
    public static final Event<CloseContainer> CLOSE_CONTAINER = Event.create(CloseContainer.class);

    public static interface Rendering {
        public void onRender(MinecraftClient var1, DrawContext var2, RenderTickCounter var3);
    }

    public static interface ScreenPreInitialization {
        public CancellableResult onInitialize(MinecraftClient var1, Screen var2, ScreenAccess var3);
    }

    public static interface ScreenPostInitialization {
        public void onInitialize(MinecraftClient var1, Screen var2, ScreenAccess var3);
    }

    public static interface ScreenPreRendering {
        public CancellableResult onRender(MinecraftClient var1, Screen var2, DrawContext var3, int var4, int var5, RenderTickCounter var6);
    }

    public static interface ScreenPostRendering {
        public void onRender(MinecraftClient var1, Screen var2, DrawContext var3, int var4, int var5, RenderTickCounter var6);
    }

    public static interface ContainerRenderBackground {
        public void onRender(MinecraftClient var1, HandledScreen<?> var2, DrawContext var3, int var4, int var5, RenderTickCounter var6);
    }

    public static interface ContainerRenderForeground {
        public void onRender(MinecraftClient var1, HandledScreen<?> var2, DrawContext var3, int var4, int var5, RenderTickCounter var6);
    }

    public static interface OpenContainer {
        public void onOpen(MinecraftClient var1, Screen var2);
    }

    public static interface CloseContainer {
        public void onClose(MinecraftClient var1, Screen var2);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_9779
 */
package backported.updates.foundation.client.event.screen;

import backported.updates.foundation.client.event.screen.api.ScreenAccess;
import backported.updates.foundation.core.util.event.CancellableResult;
import backported.updates.foundation.core.util.event.Event;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_9779;

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
        public void onRender(class_310 var1, class_332 var2, class_9779 var3);
    }

    public static interface ScreenPreInitialization {
        public CancellableResult onInitialize(class_310 var1, class_437 var2, ScreenAccess var3);
    }

    public static interface ScreenPostInitialization {
        public void onInitialize(class_310 var1, class_437 var2, ScreenAccess var3);
    }

    public static interface ScreenPreRendering {
        public CancellableResult onRender(class_310 var1, class_437 var2, class_332 var3, int var4, int var5, class_9779 var6);
    }

    public static interface ScreenPostRendering {
        public void onRender(class_310 var1, class_437 var2, class_332 var3, int var4, int var5, class_9779 var6);
    }

    public static interface ContainerRenderBackground {
        public void onRender(class_310 var1, class_465<?> var2, class_332 var3, int var4, int var5, class_9779 var6);
    }

    public static interface ContainerRenderForeground {
        public void onRender(class_310 var1, class_465<?> var2, class_332 var3, int var4, int var5, class_9779 var6);
    }

    public static interface OpenContainer {
        public void onOpen(class_310 var1, class_437 var2);
    }

    public static interface CloseContainer {
        public void onClose(class_310 var1, class_437 var2);
    }
}


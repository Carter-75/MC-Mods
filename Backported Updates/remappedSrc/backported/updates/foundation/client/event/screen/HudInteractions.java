/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 */
package backported.updates.foundation.client.event.screen;

import backported.updates.foundation.core.util.event.CancellableResult;
import backported.updates.foundation.core.util.event.Event;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_465;

@Environment(value=EnvType.CLIENT)
public interface HudInteractions {
    public static final Event<MouseScroll> SCROLLING_PRE = Event.cancellable(MouseScroll.class);
    public static final Event<MouseScroll> SCROLLING_POST = Event.cancellable(MouseScroll.class);
    public static final Event<MouseClick> CLICKING_PRE = Event.cancellable(MouseClick.class);
    public static final Event<MouseClick> CLICKING_POST = Event.cancellable(MouseClick.class);
    public static final Event<MouseRelease> RELEASING_PRE = Event.cancellable(MouseRelease.class);
    public static final Event<MouseRelease> RELEASING_POST = Event.cancellable(MouseRelease.class);
    public static final Event<SlotClicked> SLOT_CLICK = Event.create(SlotClicked.class);
    public static final Event<StopHovering> STOP_HOVERING = Event.create(StopHovering.class);

    public static interface MouseScroll {
        public CancellableResult onScrolling(class_310 var1, class_437 var2, double var3, double var5, double var7, double var9);
    }

    public static interface MouseClick {
        public CancellableResult onClicking(class_310 var1, class_437 var2, double var3, double var5, int var7);
    }

    public static interface MouseRelease {
        public CancellableResult onReleasing(class_310 var1, class_437 var2, double var3, double var5, int var7);
    }

    public static interface SlotClicked {
        public void onMouseClick(class_310 var1, class_465<?> var2, class_1735 var3, class_1713 var4);
    }

    public static interface StopHovering {
        public void onStopHovering(class_310 var1, class_465<?> var2, class_1735 var3);
    }
}


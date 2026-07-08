/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 */
package backported.updates.foundation.client.event.screen;

import backported.updates.foundation.core.util.event.CancellableResult;
import backported.updates.foundation.core.util.event.Event;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;

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
        public CancellableResult onScrolling(MinecraftClient var1, Screen var2, double var3, double var5, double var7, double var9);
    }

    public static interface MouseClick {
        public CancellableResult onClicking(MinecraftClient var1, Screen var2, double var3, double var5, int var7);
    }

    public static interface MouseRelease {
        public CancellableResult onReleasing(MinecraftClient var1, Screen var2, double var3, double var5, int var7);
    }

    public static interface SlotClicked {
        public void onMouseClick(MinecraftClient var1, HandledScreen<?> var2, Slot var3, SlotActionType var4);
    }

    public static interface StopHovering {
        public void onStopHovering(MinecraftClient var1, HandledScreen<?> var2, Slot var3);
    }
}


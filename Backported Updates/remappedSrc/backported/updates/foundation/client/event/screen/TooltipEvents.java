/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1792$class_9635
 *  net.minecraft.class_1799
 *  net.minecraft.class_1836
 *  net.minecraft.class_2561
 *  net.minecraft.class_332
 *  net.minecraft.class_5684
 */
package backported.updates.foundation.client.event.screen;

import backported.updates.foundation.core.util.event.CancellableResult;
import backported.updates.foundation.core.util.event.Event;
import java.util.List;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_5684;

@Environment(value=EnvType.CLIENT)
public interface TooltipEvents {
    public static final Event<Item> ITEM_SETUP = Event.create(Item.class);
    public static final Event<RenderTooltip> RENDER_TOOLTIP = Event.cancellable(RenderTooltip.class);

    public static interface Item {
        public void registerTooltip(class_1799 var1, class_1792.class_9635 var2, class_1836 var3, List<class_2561> var4);
    }

    public static interface RenderTooltip {
        public CancellableResult onRendering(class_332 var1, List<? extends class_5684> var2, int var3, int var4);
    }
}


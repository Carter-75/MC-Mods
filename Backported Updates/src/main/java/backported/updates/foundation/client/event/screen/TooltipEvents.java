/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.item.Item$TooltipContext
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.tooltip.TooltipType
 *  net.minecraft.text.Text
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.tooltip.TooltipComponent
 */
package backported.updates.foundation.client.event.screen;

import backported.updates.foundation.core.util.event.CancellableResult;
import backported.updates.foundation.core.util.event.Event;
import java.util.List;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.tooltip.TooltipComponent;

@Environment(value=EnvType.CLIENT)
public interface TooltipEvents {
    public static final Event<Item> ITEM_SETUP = Event.create(Item.class);
    public static final Event<RenderTooltip> RENDER_TOOLTIP = Event.cancellable(RenderTooltip.class);

    public static interface Item {
        public void registerTooltip(ItemStack var1, net.minecraft.item.Item.TooltipContext var2, TooltipType var3, List<Text> var4);
    }

    public static interface RenderTooltip {
        public CancellableResult onRendering(DrawContext var1, List<? extends TooltipComponent> var2, int var3, int var4);
    }
}


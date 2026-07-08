/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.item.ItemStack
 */
package backported.updates.content.client.api.bundle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.item.ItemStack;

@Environment(value=EnvType.CLIENT)
public interface ItemSlotMouseAction {
    public boolean matches(Slot var1);

    public boolean onMouseScrolled(double var1, int var3, ItemStack var4);

    public void onStopHovering(Slot var1);

    public void onSlotClicked(Slot var1, SlotActionType var2);
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 */
package backported.updates.content.client.api.bundle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1799;

@Environment(value=EnvType.CLIENT)
public interface ItemSlotMouseAction {
    public boolean matches(class_1735 var1);

    public boolean onMouseScrolled(double var1, int var3, class_1799 var4);

    public void onStopHovering(class_1735 var1);

    public void onSlotClicked(class_1735 var1, class_1713 var2);
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 */
package backported.updates.copper.compat;

import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2680;

public interface IChestHandler {
    public boolean canHandle(class_2680 var1);

    public void setOpen(class_1937 var1, class_2338 var2, class_2680 var3, boolean var4);

    default public boolean isOpen(class_1937 level, class_2338 pos, class_2680 state) {
        return false;
    }
}


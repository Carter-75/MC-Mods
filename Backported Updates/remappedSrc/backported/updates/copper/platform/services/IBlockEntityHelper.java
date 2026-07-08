/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 */
package backported.updates.copper.platform.services;

import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;

public interface IBlockEntityHelper {
    public <T extends class_2586> class_2591<T> createBlockEntityType(BlockEntityFactory<T> var1, class_2248 ... var2);

    @FunctionalInterface
    public static interface BlockEntityFactory<T extends class_2586> {
        public T create(class_2338 var1, class_2680 var2);
    }
}


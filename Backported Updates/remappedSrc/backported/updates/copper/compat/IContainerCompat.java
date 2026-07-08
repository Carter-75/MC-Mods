/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1263
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.compat;

import backported.updates.copper.compat.IChestHandler;
import net.minecraft.class_1263;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import org.jetbrains.annotations.Nullable;

public interface IContainerCompat
extends IChestHandler {
    public boolean isValidContainer(class_2680 var1);

    @Nullable
    default public class_1263 getContainer(class_2586 blockEntity, class_1937 level, class_2338 pos) {
        if (blockEntity instanceof class_1263) {
            class_1263 container = (class_1263)blockEntity;
            return container;
        }
        return null;
    }
}


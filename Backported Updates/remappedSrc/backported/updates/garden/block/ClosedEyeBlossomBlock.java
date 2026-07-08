/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_2338
 *  net.minecraft.class_2356
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 *  net.minecraft.class_6880
 */
package backported.updates.garden.block;

import backported.updates.garden.Init;
import net.minecraft.class_1291;
import net.minecraft.class_2338;
import net.minecraft.class_2356;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import net.minecraft.class_6880;

public class ClosedEyeBlossomBlock
extends class_2356 {
    public ClosedEyeBlossomBlock(class_6880<class_1291> stewEffect, float effectLengthInSeconds, class_4970.class_2251 settings) {
        super(stewEffect, effectLengthInSeconds, settings);
    }

    protected void method_9514(class_2680 state, class_3218 world, class_2338 pos, class_5819 random) {
        if (world.method_23886()) {
            world.method_8501(pos, Init.OPEN_EYE_BLOSSOM_BLOCK.method_9564());
        }
        super.method_9514(state, world, pos, random);
    }
}


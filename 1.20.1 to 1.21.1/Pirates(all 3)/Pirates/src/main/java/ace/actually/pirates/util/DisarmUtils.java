/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 */
package ace.actually.pirates.util;

import ace.actually.pirates.Pirates;
import ace.actually.pirates.blocks.CannonPrimingBlock;
import ace.actually.pirates.blocks.MotionInvokingBlock;
import java.util.Objects;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2769;

public class DisarmUtils {
    public static void disarm(class_1937 world, class_2338 blockToDisable) {
        if (!Objects.equals(blockToDisable, new class_2338(0, 0, 0))) {
            if (world.method_8320(blockToDisable).method_27852((class_2248)Pirates.CANNON_PRIMING_BLOCK.get())) {
                CannonPrimingBlock.disarm(world, blockToDisable);
            } else if (world.method_8320(blockToDisable).method_27852((class_2248)Pirates.MOTION_INVOKING_BLOCK.get())) {
                MotionInvokingBlock.disarm(world, blockToDisable);
            }
        }
    }

    public static void rearm(class_1937 world, class_2338 blockToDisable) {
        if (!blockToDisable.equals((Object)class_2338.field_10980)) {
            if (world.method_8320(blockToDisable).method_27852((class_2248)Pirates.CANNON_PRIMING_BLOCK.get())) {
                world.method_8501(blockToDisable, (class_2680)world.method_8320(blockToDisable).method_11657((class_2769)CannonPrimingBlock.DISARMED, (Comparable)Boolean.valueOf(false)));
            } else if (world.method_8320(blockToDisable).method_27852((class_2248)Pirates.MOTION_INVOKING_BLOCK.get())) {
                world.method_8501(blockToDisable, (class_2680)world.method_8320(blockToDisable).method_11657((class_2769)MotionInvokingBlock.ARMED, (Comparable)Boolean.valueOf(true)));
            }
        }
    }
}


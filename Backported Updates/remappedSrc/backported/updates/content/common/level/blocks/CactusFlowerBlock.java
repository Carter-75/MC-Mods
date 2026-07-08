/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_1922
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2261
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3726
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5431
 */
package backported.updates.content.common.level.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.class_1922;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2261;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import net.minecraft.class_4970;
import net.minecraft.class_5431;

public class CactusFlowerBlock
extends class_2261 {
    public static final MapCodec<CactusFlowerBlock> CODEC = CactusFlowerBlock.method_54094(CactusFlowerBlock::new);
    private static final class_265 SHAPE = class_2248.method_9541((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)12.0, (double)15.0);

    public CactusFlowerBlock(class_4970.class_2251 properties) {
        super(properties);
    }

    protected MapCodec<? extends class_2261> method_53969() {
        return CODEC;
    }

    public class_265 method_9530(class_2680 state, class_1922 level, class_2338 pos, class_3726 context) {
        return SHAPE;
    }

    protected boolean method_9695(class_2680 state, class_1922 level, class_2338 pos) {
        class_2680 below = level.method_8320(pos);
        return below.method_27852(class_2246.field_10029) || below.method_27852(class_2246.field_10362) || below.method_30368(level, pos, class_2350.field_11036, class_5431.field_25823);
    }
}


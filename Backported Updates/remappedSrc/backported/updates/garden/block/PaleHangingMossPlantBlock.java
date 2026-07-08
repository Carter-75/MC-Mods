/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_2248
 *  net.minecraft.class_2350
 *  net.minecraft.class_265
 *  net.minecraft.class_4864
 *  net.minecraft.class_4865
 *  net.minecraft.class_4951
 *  net.minecraft.class_4970$class_2251
 */
package backported.updates.garden.block;

import backported.updates.garden.Init;
import com.mojang.serialization.MapCodec;
import net.minecraft.class_2248;
import net.minecraft.class_2350;
import net.minecraft.class_265;
import net.minecraft.class_4864;
import net.minecraft.class_4865;
import net.minecraft.class_4951;
import net.minecraft.class_4970;

public class PaleHangingMossPlantBlock
extends class_4864 {
    public static final MapCodec<class_4951> CODEC = PaleHangingMossPlantBlock.method_54094(class_4951::new);
    public static final class_265 SHAPE = class_2248.method_9541((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)16.0, (double)15.0);

    public PaleHangingMossPlantBlock(class_4970.class_2251 settings) {
        super(settings, class_2350.field_11033, SHAPE, false);
    }

    public MapCodec<class_4951> method_53969() {
        return CODEC;
    }

    protected class_4865 method_24945() {
        return (class_4865)Init.PALE_HANGING_MOSS;
    }
}


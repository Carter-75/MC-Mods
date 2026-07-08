/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_4538
 *  net.minecraft.class_4776
 *  net.minecraft.class_4865
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 */
package backported.updates.garden.block;

import backported.updates.garden.Init;
import com.mojang.serialization.MapCodec;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_4538;
import net.minecraft.class_4776;
import net.minecraft.class_4865;
import net.minecraft.class_4970;
import net.minecraft.class_5819;

public class PaleHangingMossBlock
extends class_4865 {
    public static final MapCodec<class_4776> CODEC = PaleHangingMossBlock.method_54094(class_4776::new);
    protected static final class_265 SHAPE = class_2248.method_9541((double)4.0, (double)9.0, (double)4.0, (double)12.0, (double)16.0, (double)12.0);

    public PaleHangingMossBlock(class_4970.class_2251 settings) {
        super(settings, class_2350.field_11033, SHAPE, false, 0.1);
    }

    protected class_2248 method_24946() {
        return Init.PALE_HANGING_MOSS_PLANT;
    }

    protected MapCodec<? extends class_4865> method_53969() {
        return CODEC;
    }

    protected int method_26376(class_5819 random) {
        return 0;
    }

    protected boolean method_24949(class_2680 state) {
        return false;
    }

    protected boolean method_9558(class_2680 state, class_4538 world, class_2338 pos) {
        class_2248 block = world.method_8320(pos.method_10084()).method_26204();
        return block == Init.PALE_OAK_LEAVES || block == Init.PALE_HANGING_MOSS_PLANT || super.method_9558(state, world, pos);
    }
}


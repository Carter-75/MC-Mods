/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2261
 *  net.minecraft.class_2338
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_3726
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.common.api.block.SpreadableBonemealableBlock;
import com.mojang.serialization.MapCodec;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2261;
import net.minecraft.class_2338;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3726;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5819;

public class ActualBushBlock
extends class_2261
implements SpreadableBonemealableBlock {
    public static final MapCodec<ActualBushBlock> CODEC = ActualBushBlock.method_54094(ActualBushBlock::new);
    private static final class_265 SHAPE = class_2248.method_9541((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)13.0, (double)16.0);

    public ActualBushBlock(class_4970.class_2251 properties) {
        super(properties);
    }

    protected MapCodec<? extends class_2261> method_53969() {
        return CODEC;
    }

    public class_265 method_9530(class_2680 state, class_1922 level, class_2338 pos, class_3726 context) {
        return SHAPE;
    }

    public boolean method_9651(class_4538 level, class_2338 pos, class_2680 state) {
        return SpreadableBonemealableBlock.hasSpreadableNeighbourPos(level, pos, state);
    }

    public boolean method_9650(class_1937 level, class_5819 random, class_2338 pos, class_2680 state) {
        return true;
    }

    public void method_9652(class_3218 level, class_5819 random, class_2338 pos, class_2680 state) {
        SpreadableBonemealableBlock.findSpreadableNeighbourPos((class_1937)level, pos, state).ifPresent(newPos -> level.method_8501(newPos, this.method_9564()));
    }
}


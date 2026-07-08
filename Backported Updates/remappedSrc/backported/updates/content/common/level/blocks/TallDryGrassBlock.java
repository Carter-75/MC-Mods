/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2311
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

import backported.updates.content.client.level.sound.AmbientDesertBlockSoundsPlayer;
import backported.updates.content.common.api.block.SpreadableBonemealableBlock;
import backported.updates.content.common.registries.ModBlocks;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2311;
import net.minecraft.class_2338;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3726;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5819;

public class TallDryGrassBlock
extends class_2311
implements SpreadableBonemealableBlock {
    private static final class_265 SHAPE = class_2248.method_9541((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)16.0, (double)15.0);

    public TallDryGrassBlock(class_4970.class_2251 properties) {
        super(properties);
    }

    public class_265 method_9530(class_2680 state, class_1922 level, class_2338 pos, class_3726 context) {
        return SHAPE;
    }

    public void method_9496(class_2680 state, class_1937 level, class_2338 pos, class_5819 random) {
        AmbientDesertBlockSoundsPlayer.playAmbientDryGrassSounds(level, pos, random);
    }

    public boolean method_9651(class_4538 level, class_2338 pos, class_2680 state) {
        return SpreadableBonemealableBlock.hasSpreadableNeighbourPos(level, pos, ModBlocks.SHORT_DRY_GRASS.get().method_9564());
    }

    public boolean method_9650(class_1937 level, class_5819 random, class_2338 pos, class_2680 state) {
        return true;
    }

    public void method_9652(class_3218 level, class_5819 random, class_2338 pos, class_2680 state) {
        SpreadableBonemealableBlock.findSpreadableNeighbourPos((class_1937)level, pos, ModBlocks.SHORT_DRY_GRASS.get().method_9564()).ifPresent(newPos -> level.method_8501(newPos, ModBlocks.SHORT_DRY_GRASS.get().method_9564()));
    }
}


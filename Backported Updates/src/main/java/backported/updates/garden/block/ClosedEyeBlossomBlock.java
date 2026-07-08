/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.effect.StatusEffect
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.FlowerBlock
 *  net.minecraft.block.BlockState
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.registry.entry.RegistryEntry
 */
package backported.updates.garden.block;

import backported.updates.garden.Init;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;
import net.minecraft.registry.entry.RegistryEntry;

public class ClosedEyeBlossomBlock
extends FlowerBlock {
    public ClosedEyeBlossomBlock(RegistryEntry<StatusEffect> stewEffect, float effectLengthInSeconds, AbstractBlock.Settings settings) {
        super(stewEffect, effectLengthInSeconds, settings);
    }

    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.isNight()) {
            world.setBlockState(pos, Init.OPEN_EYE_BLOSSOM_BLOCK.getDefaultState());
        }
        super.randomTick(state, world, pos, random);
    }
}


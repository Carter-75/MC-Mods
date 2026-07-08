/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  net.minecraft.block.Fertilizable
 *  net.minecraft.block.DeadBushBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.world.WorldView
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.util.math.random.Random
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.client.level.sound.AmbientDesertBlockSoundsPlayer;
import backported.updates.content.common.registries.ModBlocks;
import net.minecraft.world.World;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.DeadBushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.WorldView;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;

public class ShortDryGrassBlock
extends DeadBushBlock
implements Fertilizable {
    public ShortDryGrassBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random random) {
        AmbientDesertBlockSoundsPlayer.playAmbientDryGrassSounds(level, pos, random);
    }

    public boolean isFertilizable(WorldView level, BlockPos pos, BlockState state) {
        return true;
    }

    public boolean canGrow(World level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld level, Random random, BlockPos pos, BlockState state) {
        level.setBlockState(pos, ModBlocks.TALL_DRY_GRASS.get().getDefaultState());
    }
}


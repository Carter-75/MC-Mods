/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.util.math.random.Random
 */
package backported.updates.copper.util;

import java.util.Optional;
import java.util.function.Function;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;

public class WeatheringHelper {
    public static final float OXIDATION_CHANCE = 0.05688889f;

    public static boolean tryWeather(BlockState state, ServerWorld level, BlockPos pos, Random random, Function<Block, Optional<Block>> getNextBlock) {
        Optional<Block> nextBlock = getNextBlock.apply(state.getBlock());
        if (nextBlock.isPresent() && random.nextFloat() < 0.05688889f) {
            BlockState newState = nextBlock.get().getStateWithProperties(state);
            level.setBlockState(pos, newState);
            return true;
        }
        return false;
    }

    public static boolean canWeather(BlockState state, Function<Block, Optional<Block>> getNextBlock) {
        return getNextBlock.apply(state.getBlock()).isPresent();
    }
}


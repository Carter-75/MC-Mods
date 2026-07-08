/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  net.minecraft.block.Fertilizable
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Type
 *  net.minecraft.block.BlockState
 *  net.minecraft.world.WorldView
 */
package backported.updates.content.common.api.block;

import java.util.List;
import java.util.Optional;
import net.minecraft.world.World;
import net.minecraft.block.Fertilizable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.world.WorldView;

public interface SpreadableBonemealableBlock
extends Fertilizable {
    public static boolean hasSpreadableNeighbourPos(WorldView level, BlockPos pos, BlockState state) {
        return SpreadableBonemealableBlock.getSpreadableNeighbourPos(Direction.Type.HORIZONTAL.stream().toList(), level, pos, state).isPresent();
    }

    public static Optional<BlockPos> findSpreadableNeighbourPos(World level, BlockPos pos, BlockState state) {
        return SpreadableBonemealableBlock.getSpreadableNeighbourPos(Direction.Type.HORIZONTAL.getShuffled(level.random), (WorldView)level, pos, state);
    }

    private static Optional<BlockPos> getSpreadableNeighbourPos(List<Direction> directions, WorldView level, BlockPos pos, BlockState state) {
        for (Direction direction : directions) {
            BlockPos offset = pos.offset(direction);
            if (!level.isAir(offset) || !state.canPlaceAt(level, offset)) continue;
            return Optional.of(offset);
        }
        return Optional.empty();
    }
}


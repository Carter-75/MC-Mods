/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.WorldAccess
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.BlockState
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.registry.tag.BlockTags
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.entity.SpawnReason
 *  net.minecraft.world.WorldView
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.entity.LargeEntitySpawnHelper$Requirements
 */
package backported.updates.content.core.util;

import java.util.Optional;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.WorldView;
import net.minecraft.util.math.random.Random;
import net.minecraft.entity.LargeEntitySpawnHelper;

public class SpawnExtras {
    public static final LargeEntitySpawnHelper.Requirements ON_TOP_OF_COLLIDER_NO_LEAVES = (level, pos, target, mutable, state) -> state.getCollisionShape((BlockView)level, mutable).isEmpty() && !target.isIn(BlockTags.LEAVES) && Block.isFaceFullSquare((VoxelShape)target.getCollisionShape((BlockView)level, pos), (Direction)Direction.UP);

    public static <T extends MobEntity> Optional<T> trySpawnMob(EntityType<T> entityType, SpawnReason spawnType, ServerWorld level, BlockPos pos, int attempts, int spread, int yOffset, LargeEntitySpawnHelper.Requirements strategy, boolean checkForCollisions) {
        BlockPos.Mutable mutable = pos.mutableCopy();
        for (int i = 0; i < attempts; ++i) {
            T mob;
            int xOffset = MathHelper.nextBetween(level.random, (int)(-spread), (int)spread);
            int zOffset = MathHelper.nextBetween(level.random, (int)(-spread), (int)spread);
            mutable.set((Vec3i)pos, xOffset, yOffset, zOffset);
            if (!level.getWorldBorder().contains((BlockPos)mutable) || !SpawnExtras.moveToPossibleSpawnPosition(level, yOffset, mutable, strategy) || checkForCollisions && !level.isSpaceEmpty(entityType.getSpawnBox((double)mutable.getX() + 0.5, (double)mutable.getY(), (double)mutable.getZ() + 0.5)) || (mob = entityType.create(level, null, (BlockPos)mutable, spawnType, false, false)) == null) continue;
            if (mob.canSpawn((WorldAccess)level, spawnType) && mob.canSpawn((WorldView)level)) {
                level.spawnEntityAndPassengers((Entity)mob);
                mob.playAmbientSound();
                return Optional.of(mob);
            }
            mob.discard();
        }
        return Optional.empty();
    }

    private static boolean moveToPossibleSpawnPosition(ServerWorld level, int yOffset, BlockPos.Mutable pos, LargeEntitySpawnHelper.Requirements strategy) {
        BlockPos.Mutable mutable = new BlockPos.Mutable().set((Vec3i)pos);
        BlockState state = level.getBlockState((BlockPos)mutable);
        for (int i = yOffset; i >= -yOffset; --i) {
            pos.move(Direction.DOWN);
            mutable.set((Vec3i)pos, Direction.UP);
            BlockState target = level.getBlockState((BlockPos)pos);
            if (strategy.canSpawnOn(level, (BlockPos)pos, target, (BlockPos)mutable, state)) {
                pos.move(Direction.UP);
                return true;
            }
            state = target;
        }
        return false;
    }
}


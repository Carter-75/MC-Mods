/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.World
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.block.BlockState
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.block.Oxidizable
 *  net.minecraft.block.Oxidizable$OxidationLevel
 */
package backported.updates.copper.event;

import backported.updates.copper.ModMemoryTypes;
import backported.updates.copper.ModTags;
import backported.updates.copper.block.CopperChestBlock;
import backported.updates.copper.config.CommonConfig;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.registry.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.block.Oxidizable;

public final class CopperGolemSpawnLogic {
    private CopperGolemSpawnLogic() {
    }

    public static void handleBlockPlaced(World level, BlockPos pos, BlockState placedState, Direction playerDirection) {
        Direction effectiveDirection;
        if (!(level instanceof ServerWorld)) {
            return;
        }
        ServerWorld serverLevel = (ServerWorld)level;
        if (!CommonConfig.golemBuildSpawning()) {
            return;
        }
        Direction class_23502 = effectiveDirection = playerDirection != null ? playerDirection : Direction.NORTH;
        if (placedState.isOf(Blocks.CARVED_PUMPKIN)) {
            CopperGolemSpawnLogic.trySpawnCopperGolem(serverLevel, pos, effectiveDirection);
        }
    }

    private static void trySpawnCopperGolem(ServerWorld level, BlockPos pumpkinPos, Direction playerDirection) {
        BlockPos copperPos = pumpkinPos.down();
        BlockState copperState = level.getBlockState(copperPos);
        if (copperState.isIn(ModTags.Blocks.COPPER)) {
            Direction direction = playerDirection.getOpposite();
            level.syncWorldEvent(2001, pumpkinPos, Block.getRawIdFromState(Blocks.CARVED_PUMPKIN.getDefaultState()));
            level.syncWorldEvent(2001, copperPos, Block.getRawIdFromState(copperState));
            level.setBlockState(pumpkinPos, Blocks.AIR.getDefaultState(), 2);
            Block copperBlock = copperState.getBlock();
            BlockState chestState = CopperChestBlock.getFromCopperBlock(copperBlock, direction, (World)level, copperPos);
            level.setBlockState(copperPos, chestState, 2);
            CopperGolemEntity copperGolem = (CopperGolemEntity)ModEntities.COPPER_GOLEM.get().create((World)level);
            if (copperGolem != null) {
                float yaw = direction.asRotation();
                copperGolem.refreshPositionAndAngles((double)copperPos.getX() + 0.5, (double)copperPos.getY() + 1.0, (double)copperPos.getZ() + 0.5, yaw, 0.0f);
                copperGolem.setYaw(yaw);
                copperGolem.prevYaw = yaw;
                copperGolem.setBodyYaw(yaw);
                copperGolem.prevBodyYaw = yaw;
                copperGolem.setHeadYaw(yaw);
                copperGolem.prevHeadYaw = yaw;
                Oxidizable.OxidationLevel weatherState = CopperGolemSpawnLogic.getWeatherStateFromBlock(copperState.getBlock());
                copperGolem.spawn(weatherState);
                copperGolem.getBrain().remember(ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get(), 140);
                level.spawnEntity((Entity)copperGolem);
                for (ServerPlayerEntity class_32222 : level.getNonSpectatingEntities(ServerPlayerEntity.class, copperGolem.getBoundingBox().expand(5.0))) {
                }
                level.updateNeighborsAlways(copperPos, chestState.getBlock());
                level.updateNeighborsAlways(pumpkinPos, Blocks.AIR);
            }
        }
    }

    private static Oxidizable.OxidationLevel getWeatherStateFromBlock(Block block) {
        if (block instanceof Oxidizable) {
            Oxidizable weatheringCopper = (Oxidizable)block;
            return (Oxidizable.OxidationLevel)weatheringCopper.getDegradationLevel();
        }
        if (block == Blocks.WAXED_COPPER_BLOCK) {
            return Oxidizable.OxidationLevel.UNAFFECTED;
        }
        if (block == Blocks.WAXED_EXPOSED_COPPER) {
            return Oxidizable.OxidationLevel.EXPOSED;
        }
        if (block == Blocks.WAXED_WEATHERED_COPPER) {
            return Oxidizable.OxidationLevel.WEATHERED;
        }
        if (block == Blocks.WAXED_OXIDIZED_COPPER) {
            return Oxidizable.OxidationLevel.OXIDIZED;
        }
        return Oxidizable.OxidationLevel.UNAFFECTED;
    }
}


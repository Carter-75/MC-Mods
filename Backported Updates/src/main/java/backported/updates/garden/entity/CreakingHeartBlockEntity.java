/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.ItemEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.world.World
 *  net.minecraft.block.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.BlockEntityType
 *  net.minecraft.block.BlockState
 *  net.minecraft.Property
 */
package backported.updates.garden.entity;

import backported.updates.garden.Init;
import backported.updates.garden.block.CreakingHeartBlock;
import backported.updates.garden.entity.CreakingEntity;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemConvertible;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;

public class CreakingHeartBlockEntity
extends BlockEntity {
    public CreakingEntity creakingEntity = null;
    public int timing = 100;

    public CreakingHeartBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, CreakingHeartBlockEntity blockEntity) {
        if (((Boolean)state.get(CreakingHeartBlock.ACTIVATED)).booleanValue()) {
            blockEntity.checkAndSpawnCreaking(world, pos);
            if (state.getBlock() instanceof CreakingHeartBlock && blockEntity.timing <= 100) {
                ++blockEntity.timing;
            }
        }
    }

    public BlockPos findAirBlockPos() {
        int[][] offsets;
        BlockPos basePos = this.getPos();
        for (int[] offset : offsets = new int[][]{{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}}) {
            try {
                BlockPos pos = basePos.add(offset[0], offset[1], offset[2]);
                if (this.world.getBlockState(pos).getBlock() != Blocks.AIR) continue;
                return pos;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return null;
    }

    public void trySpawnResin() {
        if (this.timing >= 100) {
            World world = this.getWorld();
            ItemStack itemStack = new ItemStack((ItemConvertible)Init.RESIN_CLUMP);
            itemStack.setCount(ThreadLocalRandom.current().nextInt(1, 4));
            BlockPos blockPos = this.getPos();
            BlockPos blockPos2 = this.findAirBlockPos();
            if (blockPos2 != null) {
                blockPos = blockPos2;
            }
            try {
                world.spawnEntity((Entity)new ItemEntity(world, (double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ(), itemStack));
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.timing = 0;
        }
    }

    private void checkAndSpawnCreaking(World world, BlockPos pos) {
        boolean creakingExists;
        boolean bl = creakingExists = this.creakingEntity != null && this.creakingEntity.isAlive();
        if (!creakingExists && world.isNight()) {
            CreakingEntity creaking = new CreakingEntity(Init.CREAKING, world);
            creaking.boundHeart = this.getPos();
            creaking.isHeartSpawn = true;
            this.creakingEntity = creaking;
            for (int x = -2; x <= 2; ++x) {
                for (int y = -2; y <= 2; ++y) {
                    for (int z = -2; z <= 2; ++z) {
                        BlockPos airPos = pos.add(x, y, z);
                        if (!world.isAir(airPos)) continue;
                        creaking.refreshPositionAndAngles(airPos.getX(), airPos.getY(), airPos.getZ(), 0.0f, 0.0f);
                        world.spawnEntity((Entity)creaking);
                        return;
                    }
                }
            }
        }
    }
}


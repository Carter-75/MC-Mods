/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  net.minecraft.block.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Type
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.block.BlockState
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.registry.tag.BlockTags
 *  net.minecraft.util.math.random.Random
 */
package backported.updates.content.client.level.sound;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.core.data.tags.ModBlockTags;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.block.BlockState;
import net.minecraft.world.Heightmap;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.random.Random;

public class AmbientDesertBlockSoundsPlayer {
    private static final int IDLE_SOUND_CHANCE = 2100;
    private static final int DRY_GRASS_SOUND_CHANCE = 200;
    private static final int DEAD_BUSH_SOUND_CHANCE = 130;
    private static final int DEAD_BUSH_SOUND_BADLANDS_DECREASED_CHANCE = 3;
    private static final int SURROUNDING_BLOCKS_PLAY_SOUND_THRESHOLD = 3;
    private static final int SURROUNDING_BLOCKS_DISTANCE_HORIZONTAL_CHECK = 8;
    private static final int SURROUNDING_BLOCKS_DISTANCE_VERTICAL_CHECK = 5;
    private static final int HORIZONTAL_DIRECTIONS = 4;

    public static void playAmbientSandSounds(World level, BlockPos pos, Random random) {
        if (!level.getBlockState(pos).isIn(BlockTags.SAND)) {
            return;
        }
        if (level.getBlockState(pos.up()).isOf(Blocks.AIR) && random.nextInt(2100) == 0 && AmbientDesertBlockSoundsPlayer.shouldPlayAmbientSandSound(level, pos)) {
            level.playSound((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), ModSoundEvents.SAND_IDLE.get(), SoundCategory.AMBIENT, 1.0f, 1.0f, false);
        }
    }

    public static void playAmbientDryGrassSounds(World level, BlockPos pos, Random random) {
        if (random.nextInt(200) == 0 && AmbientDesertBlockSoundsPlayer.shouldPlayDesertDryVegetationBlockSounds(level, pos.down())) {
            level.playSound((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), ModSoundEvents.DRY_GRASS.get(), SoundCategory.AMBIENT, 1.0f, 1.0f, false);
        }
    }

    public static void playAmbientDeadBushSounds(World level, BlockPos pos, Random random) {
        if (random.nextInt(130) == 0) {
            BlockState state = level.getBlockState(pos.down());
            if ((state.isOf(Blocks.RED_SAND) || state.isIn(BlockTags.TERRACOTTA)) && random.nextInt(3) != 0) {
                return;
            }
            if (AmbientDesertBlockSoundsPlayer.shouldPlayDesertDryVegetationBlockSounds(level, pos.down())) {
                level.playSound((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), ModSoundEvents.DEAD_BUSH_IDLE.get(), SoundCategory.AMBIENT, 1.0f, 1.0f, false);
            }
        }
    }

    public static boolean shouldPlayDesertDryVegetationBlockSounds(World level, BlockPos pos) {
        return level.getBlockState(pos).isIn(ModBlockTags.TRIGGERS_AMBIENT_DESERT_DRY_VEGETATION_BLOCK_SOUNDS) && level.getBlockState(pos.down()).isIn(ModBlockTags.TRIGGERS_AMBIENT_DESERT_DRY_VEGETATION_BLOCK_SOUNDS);
    }

    private static boolean shouldPlayAmbientSandSound(World level, BlockPos pos) {
        int found = 0;
        int checked = 0;
        BlockPos.Mutable mutable = pos.mutableCopy();
        for (Direction direction : Direction.Type.HORIZONTAL) {
            int remaining;
            int possible;
            mutable.set((Vec3i)pos).move(direction, 8);
            if (AmbientDesertBlockSoundsPlayer.columnContainsTriggeringBlock(level, mutable) && found++ >= 3) {
                return true;
            }
            if ((possible = (remaining = 4 - ++checked) + found) >= 3) continue;
            return false;
        }
        return false;
    }

    private static boolean columnContainsTriggeringBlock(World level, BlockPos.Mutable mutable) {
        int surfaceY = level.getTopY(Heightmap.Type.WORLD_SURFACE, mutable.getX(), mutable.getZ()) - 1;
        if (Math.abs(surfaceY - mutable.getY()) > 5) {
            mutable.move(Direction.UP, 6);
            BlockState state = level.getBlockState((BlockPos)mutable);
            mutable.move(Direction.DOWN);
            for (int i = 0; i < 10; ++i) {
                BlockState localState = level.getBlockState((BlockPos)mutable);
                if (state.isAir() && AmbientDesertBlockSoundsPlayer.canTriggerAmbientDesertSandSounds(localState)) {
                    return true;
                }
                state = localState;
                mutable.move(Direction.DOWN);
            }
            return false;
        }
        boolean hasAirAbove = level.getBlockState((BlockPos)mutable.setY(surfaceY + 1)).isAir();
        return hasAirAbove && AmbientDesertBlockSoundsPlayer.canTriggerAmbientDesertSandSounds(level.getBlockState((BlockPos)mutable.setY(surfaceY)));
    }

    private static boolean canTriggerAmbientDesertSandSounds(BlockState state) {
        return state.isIn(ModBlockTags.TRIGGERS_AMBIENT_DESERT_SAND_BLOCK_SOUNDS);
    }
}


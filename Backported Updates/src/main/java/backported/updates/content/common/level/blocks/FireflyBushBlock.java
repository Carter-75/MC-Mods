/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.world.World
 *  net.minecraft.block.PlantBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.block.BlockState
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.world.WorldView
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.util.math.random.Random
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.client.registries.ModParticles;
import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.api.block.SpreadableBonemealableBlock;
import backported.updates.content.core.util.LevelUtils;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.World;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.block.BlockState;
import net.minecraft.world.Heightmap;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.WorldView;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;

public class FireflyBushBlock
extends PlantBlock
implements SpreadableBonemealableBlock {
    public static final MapCodec<FireflyBushBlock> CODEC = FireflyBushBlock.createCodec(FireflyBushBlock::new);
    private static final double FIREFLY_CHANCE_PER_TICK = 0.7;
    private static final double FIREFLY_HORIZONTAL_RANGE = 10.0;
    private static final double FIREFLY_VERTICAL_RANGE = 5.0;
    private static final int FIREFLY_SPAWN_MAX_BRIGHTNESS_LEVEL = 13;
    private static final int FIREFLY_AMBIENT_SOUND_CHANCE_ONE_IN = 30;

    public FireflyBushBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    protected MapCodec<? extends PlantBlock> getCodec() {
        return CODEC;
    }

    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random random) {
        if (random.nextInt(30) == 0 && LevelUtils.isMoonVisible(level) && level.getTopY(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, pos.getX(), pos.getZ()) <= pos.getY()) {
            level.playSoundAtBlockCenter(pos, ModSoundEvents.FIREFLY_BUSH_IDLE.get(), SoundCategory.AMBIENT, 1.0f, 1.0f, false);
        }
        if ((LevelUtils.isMoonVisible(level) || level.getLightLevel(pos) <= 13) && random.nextDouble() <= 0.7) {
            double x = (double)pos.getX() + random.nextDouble() * 10.0 - 5.0;
            double y = (double)pos.getY() + random.nextDouble() * 5.0;
            double z = (double)pos.getZ() + random.nextDouble() * 10.0 - 5.0;
            level.addParticle((ParticleEffect)ModParticles.FIREFLY.get(), x, y, z, 0.0, 0.0, 0.0);
        }
    }

    public boolean isFertilizable(WorldView level, BlockPos pos, BlockState state) {
        return SpreadableBonemealableBlock.hasSpreadableNeighbourPos(level, pos, state);
    }

    public boolean canGrow(World level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld level, Random random, BlockPos pos, BlockState state) {
        SpreadableBonemealableBlock.findSpreadableNeighbourPos((World)level, pos, state).ifPresent(newPos -> level.setBlockState(newPos, this.getDefaultState()));
    }
}


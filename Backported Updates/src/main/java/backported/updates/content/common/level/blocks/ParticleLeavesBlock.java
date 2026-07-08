/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.block.LeavesBlock
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.particle.ParticleUtil
 */
package backported.updates.content.common.level.blocks;

import java.util.function.Supplier;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;
import net.minecraft.particle.ParticleUtil;

public class ParticleLeavesBlock
extends LeavesBlock {
    private final Supplier<? extends ParticleEffect> particle;
    private final int chance;

    public ParticleLeavesBlock(int chance, Supplier<? extends ParticleEffect> particle, AbstractBlock.Settings properties) {
        super(properties);
        this.chance = chance;
        this.particle = particle;
    }

    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random random) {
        BlockPos below;
        BlockState belowState;
        super.randomDisplayTick(state, level, pos, random);
        if (random.nextInt(this.chance) == 0 && !ParticleLeavesBlock.isFaceFullSquare((VoxelShape)(belowState = level.getBlockState(below = pos.down())).getCollisionShape((BlockView)level, below), (Direction)Direction.UP)) {
            ParticleUtil.spawnParticle((World)level, (BlockPos)pos, random, (ParticleEffect)this.particle.get());
        }
    }
}


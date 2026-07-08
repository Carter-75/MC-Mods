/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.particle.ParticleType
 *  net.minecraft.util.shape.VoxelShape
 *  net.minecraft.block.BlockState
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.particle.ParticleUtil
 *  net.minecraft.particle.EntityEffectParticleEffect
 */
package backported.updates.content.common.api;

import backported.updates.content.client.api.color.LeafColors;
import backported.updates.content.client.registries.ModParticles;
import backported.updates.content.core.VanillaBackport;
import backported.updates.content.core.data.tags.ModBlockTags;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.random.Random;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.particle.EntityEffectParticleEffect;

@Environment(value=EnvType.CLIENT)
public class FallingLeavesModule {
    public void makeFallingLeavesParticles(World level, BlockPos pos, Random random, BlockState state, BlockPos offset) {
        if ((double)random.nextFloat() < VanillaBackport.CLIENT_CONFIG.fallingLeavesFrequency.get() && !Block.isFaceFullSquare((VoxelShape)state.getCollisionShape((BlockView)level, offset), (Direction)Direction.UP)) {
            this.spawnFallingLeavesParticle(level, pos, random);
        }
    }

    private void spawnFallingLeavesParticle(World level, BlockPos pos, Random random) {
        BlockState state = level.getBlockState(pos);
        if (VanillaBackport.CLIENT_CONFIG.hasFallingLeaves.get().booleanValue()) {
            ParticleType<EntityEffectParticleEffect> particle = null;
            if (state.isIn(ModBlockTags.SPAWN_FALLING_LEAVES)) {
                particle = ModParticles.TINTED_LEAVES.get();
            } else if (state.isIn(ModBlockTags.SPAWN_FALLING_NEEDLES)) {
                particle = ModParticles.TINTED_NEEDLES.get();
            }
            if (particle != null) {
                EntityEffectParticleEffect option = EntityEffectParticleEffect.create(particle, (int)LeafColors.getClientLeafTintColor(pos));
                ParticleUtil.spawnParticle((World)level, (BlockPos)pos, random, (ParticleEffect)option);
            }
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.particle.ParticleTypes
 *  net.minecraft.block.TorchBlock
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.util.math.random.Random
 */
package backported.updates.copper.block;

import backported.updates.copper.registry.ModParticles;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;

public class CopperTorchBlock
extends TorchBlock {
    public CopperTorchBlock(AbstractBlock.Settings properties) {
        super(ParticleTypes.FLAME, properties);
    }

    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random random) {
        double x = (double)pos.getX() + 0.5;
        double y = (double)pos.getY() + 0.7;
        double z = (double)pos.getZ() + 0.5;
        level.addParticle((ParticleEffect)ParticleTypes.SMOKE, x, y, z, 0.0, 0.0, 0.0);
        level.addParticle((ParticleEffect)ModParticles.COPPER_FIRE_FLAME.get(), x, y, z, 0.0, 0.0, 0.0);
    }
}


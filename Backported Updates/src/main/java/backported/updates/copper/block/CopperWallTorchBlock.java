/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.particle.ParticleTypes
 *  net.minecraft.block.WallTorchBlock
 *  net.minecraft.block.BlockState
 *  net.minecraft.Property
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.util.math.random.Random
 */
package backported.updates.copper.block;

import backported.updates.copper.registry.ModParticles;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;

public class CopperWallTorchBlock
extends WallTorchBlock {
    public CopperWallTorchBlock(AbstractBlock.Settings properties) {
        super(ParticleTypes.FLAME, properties);
    }

    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random random) {
        Direction direction = (Direction)state.get(FACING);
        double x = (double)pos.getX() + 0.5;
        double y = (double)pos.getY() + 0.7;
        double z = (double)pos.getZ() + 0.5;
        double offsetX = 0.27;
        double offsetY = 0.22;
        Direction direction1 = direction.getOpposite();
        level.addParticle((ParticleEffect)ParticleTypes.SMOKE, x + offsetX * (double)direction1.getOffsetX(), y + offsetY, z + offsetX * (double)direction1.getOffsetZ(), 0.0, 0.0, 0.0);
        level.addParticle((ParticleEffect)ModParticles.COPPER_FIRE_FLAME.get(), x + offsetX * (double)direction1.getOffsetX(), y + offsetY, z + offsetX * (double)direction1.getOffsetZ(), 0.0, 0.0, 0.0);
    }
}


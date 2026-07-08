/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.block.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.block.BlockState
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.world.gen.feature.Feature
 *  net.minecraft.world.gen.feature.DefaultFeatureConfig
 *  net.minecraft.world.WorldView
 *  net.minecraft.world.StructureWorldAccess
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.world.gen.feature.util.FeatureContext
 */
package backported.updates.content.common.level.features;

import backported.updates.content.common.registries.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.WorldView;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class CactusFlowerFeature
extends Feature<DefaultFeatureConfig> {
    public CactusFlowerFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess level = context.getWorld();
        BlockPos origin = context.getOrigin();
        Random random = context.getRandom();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int xRange = 0; xRange < 16; ++xRange) {
            if ((double)random.nextFloat() > 0.25) continue;
            for (int zRange = 0; zRange < 16; ++zRange) {
                if ((double)random.nextFloat() > 0.25) continue;
                int x = origin.getX() + xRange;
                int z = origin.getZ() + zRange;
                mutable.set(x, level.getTopY(Heightmap.Type.MOTION_BLOCKING, x, z) - 1, z);
                if (!level.getBlockState((BlockPos)mutable).isOf(Blocks.CACTUS)) continue;
                mutable.set(x, level.getTopY(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, x, z), z);
                BlockState state = ModBlocks.CACTUS_FLOWER.get().getDefaultState();
                if (level.getBlockState((BlockPos)mutable).isOf(ModBlocks.CACTUS_FLOWER.get()) || !level.getBlockState((BlockPos)mutable).isAir() || !state.canPlaceAt((WorldView)level, (BlockPos)mutable)) continue;
                level.setBlockState((BlockPos)mutable, state, 1);
            }
        }
        return true;
    }
}


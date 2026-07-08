/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.block.BlockState
 *  net.minecraft.util.Identifier
 *  net.minecraft.world.gen.feature.Feature
 *  net.minecraft.registry.tag.BlockTags
 *  net.minecraft.world.StructureWorldAccess
 *  net.minecraft.world.gen.feature.util.FeatureContext
 *  net.minecraft.registry.Registries
 */
package backported.updates.garden.feature.pale_short_grass_feature;

import backported.updates.garden.feature.pale_short_grass_feature.PaleShortGrassPatchConfig;
import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.registry.Registries;

public class PaleShortGrassFeature
extends Feature<PaleShortGrassPatchConfig> {
    public PaleShortGrassFeature(Codec<PaleShortGrassPatchConfig> configCodec) {
        super(configCodec);
    }

    public boolean generate(FeatureContext<PaleShortGrassPatchConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        PaleShortGrassPatchConfig config = (PaleShortGrassPatchConfig)context.getConfig();
        int number = config.number();
        Identifier blockId = config.blockId();
        BlockState blockState = ((Block)Registries.BLOCK.get(blockId)).getDefaultState();
        if (blockState == null) {
            throw new IllegalStateException(String.valueOf(blockId) + " could not be parsed to a valid block identifier!");
        }
        BlockPos testPos = new BlockPos((Vec3i)origin);
        for (int y = 0; y < world.getHeight(); ++y) {
            if (!world.getBlockState(testPos = testPos.up()).isIn(BlockTags.DIRT) || !world.getBlockState(testPos.up()).isOf(Blocks.AIR)) continue;
            for (int i = 0; i < number; ++i) {
                world.setBlockState(testPos, blockState, 16);
                testPos = testPos.up();
                if (testPos.getY() >= world.getTopY()) break;
            }
            return true;
        }
        return false;
    }
}


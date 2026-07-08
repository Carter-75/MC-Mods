/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.block.Fertilizable
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 *  net.minecraft.world.gen.feature.ConfiguredFeature
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.world.WorldView
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.world.StructureWorldAccess
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.common.worldgen.features.TheGardenAwakensFeatures;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.Fertilizable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.WorldView;
import net.minecraft.block.AbstractBlock;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.util.math.random.Random;
import net.minecraft.registry.RegistryKeys;

public class PaleMossBlock
extends Block
implements Fertilizable {
    public static final MapCodec<PaleMossBlock> CODEC = PaleMossBlock.createCodec(PaleMossBlock::new);

    public PaleMossBlock(AbstractBlock.Settings properties) {
        super(properties);
    }

    protected MapCodec<? extends Block> getCodec() {
        return CODEC;
    }

    public boolean isFertilizable(WorldView level, BlockPos pos, BlockState state) {
        return level.getBlockState(pos.up()).isAir();
    }

    public boolean canGrow(World level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld level, Random random, BlockPos pos, BlockState state) {
        level.getRegistryManager().getOptional(RegistryKeys.CONFIGURED_FEATURE).flatMap(registry -> registry.getEntry(TheGardenAwakensFeatures.PALE_MOSS_PATCH_BONEMEAL)).ifPresent(reference -> ((ConfiguredFeature)reference.value()).generate((StructureWorldAccess)level, level.getChunkManager().getChunkGenerator(), random, pos.up()));
    }
}


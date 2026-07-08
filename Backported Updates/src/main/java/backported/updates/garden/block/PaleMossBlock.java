/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 *  net.minecraft.world.gen.feature.ConfiguredFeature
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.world.StructureWorldAccess
 *  net.minecraft.block.MossBlock
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.garden.block;

import backported.updates.garden.Init;
import com.mojang.serialization.MapCodec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.block.AbstractBlock;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.block.MossBlock;
import net.minecraft.util.math.random.Random;
import net.minecraft.registry.RegistryKeys;

public class PaleMossBlock
extends MossBlock {
    public static final MapCodec<MossBlock> CODEC = PaleMossBlock.createCodec(PaleMossBlock::new);

    public MapCodec<MossBlock> getCodec() {
        return CODEC;
    }

    public PaleMossBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.getRegistryManager().getOptional(RegistryKeys.CONFIGURED_FEATURE).flatMap(key -> key.getEntry(Init.PALE_MOSS_PATCH_BONEMEAL_FEATURE_ID)).ifPresent(entry -> ((ConfiguredFeature)entry.value()).generate((StructureWorldAccess)world, world.getChunkManager().getChunkGenerator(), random, pos.up()));
    }
}


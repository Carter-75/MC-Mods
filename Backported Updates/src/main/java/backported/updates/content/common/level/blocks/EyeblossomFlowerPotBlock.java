/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.FlowerPotBlock
 *  net.minecraft.block.BlockState
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.util.math.random.Random
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.common.level.blocks.CreakingHeartBlock;
import backported.updates.content.common.level.blocks.EyeblossomBlock;
import backported.updates.content.common.registries.ModBlocks;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;

public class EyeblossomFlowerPotBlock
extends FlowerPotBlock {
    public EyeblossomFlowerPotBlock(Block content, AbstractBlock.Settings properties) {
        super(content, properties);
    }

    public void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        boolean isNaturalNight;
        boolean hasOpenEyeblossom;
        if (this.hasRandomTicks(state) && level.getDimension().natural() && (hasOpenEyeblossom = this.getContent() == ModBlocks.OPEN_EYEBLOSSOM.get()) != (isNaturalNight = CreakingHeartBlock.isNaturalNight((World)level))) {
            level.setBlockState(pos, this.opposite(state), 3);
            EyeblossomBlock.Type type = EyeblossomBlock.Type.fromBoolean(hasOpenEyeblossom).transform();
            type.spawnTransformParticle(level, pos, random);
            level.playSound(null, pos, type.longSwitchSound(), SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        super.randomTick(state, level, pos, random);
    }

    public boolean hasRandomTicks(BlockState state) {
        return state.isOf(ModBlocks.POTTED_OPEN_EYEBLOSSOM.get()) || state.isOf(ModBlocks.POTTED_CLOSED_EYEBLOSSOM.get());
    }

    private BlockState opposite(BlockState state) {
        if (state.isOf(ModBlocks.POTTED_OPEN_EYEBLOSSOM.get())) {
            return ModBlocks.POTTED_CLOSED_EYEBLOSSOM.get().getDefaultState();
        }
        return state.isOf(ModBlocks.POTTED_CLOSED_EYEBLOSSOM.get()) ? ModBlocks.POTTED_OPEN_EYEBLOSSOM.get().getDefaultState() : state;
    }
}


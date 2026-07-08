/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.block.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.TestableWorld
 *  net.minecraft.world.gen.treedecorator.TreeDecorator
 *  net.minecraft.world.gen.treedecorator.TreeDecorator$Generator
 *  net.minecraft.world.gen.treedecorator.TreeDecoratorType
 *  net.minecraft.block.AbstractBlock$AbstractBlockState
 *  net.minecraft.util.math.random.Random
 */
package backported.updates.garden.decorator;

import backported.updates.garden.Init;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.random.Random;

public class CreakingHeartDecorator
extends TreeDecorator {
    public static final MapCodec<CreakingHeartDecorator> CODEC = Codec.floatRange((float)0.0f, (float)1.0f).fieldOf("probability").xmap(CreakingHeartDecorator::new, decorator -> Float.valueOf(decorator.probability));
    private final float probability;

    public CreakingHeartDecorator(float probability) {
        this.probability = probability;
    }

    protected TreeDecoratorType<?> getType() {
        return null;
    }

    public void generate(TreeDecorator.Generator generator) {
        Random random = generator.getRandom();
        TestableWorld testableWorld = generator.getWorld();
        float floatRandom = random.nextFloat();
        if (floatRandom <= this.probability) {
            ObjectArrayList<BlockPos> logPositions = generator.getLogPositions();
            ObjectArrayList<BlockPos> filteredLogPositions = new ObjectArrayList<>();
            logPositions.forEach(blockPos -> {
                if ((testableWorld.testBlockState(blockPos.north(), AbstractBlock.AbstractBlockState::isAir) || testableWorld.testBlockState(blockPos.east(), AbstractBlock.AbstractBlockState::isAir) || testableWorld.testBlockState(blockPos.south(), AbstractBlock.AbstractBlockState::isAir) || testableWorld.testBlockState(blockPos.west(), AbstractBlock.AbstractBlockState::isAir)) && (testableWorld.testBlockState(blockPos.down(2), state -> state.isOf(Blocks.DIRT)) || testableWorld.testBlockState(blockPos.down(3), state -> state.isOf(Blocks.DIRT)))) {
                    filteredLogPositions.add(blockPos);
                }
            });
            BlockPos creakingPosition = filteredLogPositions.get(random.nextInt(filteredLogPositions.size()));
            generator.replace(creakingPosition, Init.CREAKING_HEART.getDefaultState());
        }
    }
}


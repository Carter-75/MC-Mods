/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.util.Util
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.block.BlockState
 *  net.minecraft.Property
 *  net.minecraft.registry.tag.BlockTags
 *  net.minecraft.world.gen.treedecorator.TreeDecorator
 *  net.minecraft.world.gen.treedecorator.TreeDecorator$Generator
 *  net.minecraft.world.gen.treedecorator.TreeDecoratorType
 *  net.minecraft.util.math.random.Random
 */
package backported.updates.content.common.worldgen.treedecorators;

import backported.updates.content.common.level.blocks.CreakingHeartBlock;
import backported.updates.content.common.level.blocks.blockstates.CreakingHeartState;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModTreeDecorators;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.ArrayList;
import java.util.Optional;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.util.math.random.Random;

public class CreakingHeartDecorator
extends TreeDecorator {
    public static final MapCodec<CreakingHeartDecorator> CODEC = Codec.floatRange((float)0.0f, (float)1.0f).fieldOf("probability").xmap(CreakingHeartDecorator::new, decorator -> Float.valueOf(decorator.probability));
    private final float probability;

    public CreakingHeartDecorator(float probability) {
        this.probability = probability;
    }

    protected TreeDecoratorType<?> getType() {
        return ModTreeDecorators.CREAKING_HEART.get();
    }

    public void generate(TreeDecorator.Generator context) {
        Random random = context.getRandom();
        ObjectArrayList<BlockPos> logs = context.getLogPositions();
        if (!logs.isEmpty() && random.nextFloat() < this.probability) {
            ArrayList<BlockPos> heartPlacements = new ArrayList<>(context.getLogPositions());
            Util.shuffle(heartPlacements, random);
            Optional<BlockPos> targetPos = heartPlacements.stream().filter(pos -> {
                for (Direction dir : Direction.values()) {
                    if (context.getWorld().testBlockState(pos.offset(dir), state -> state.isIn(BlockTags.LOGS))) continue;
                    return false;
                }
                return true;
            }).findFirst();
            targetPos.ifPresent(pos -> context.replace(pos, (ModBlocks.CREAKING_HEART.get().getDefaultState().with(CreakingHeartBlock.STATE, (CreakingHeartState.DORMANT))).with(CreakingHeartBlock.NATURAL, Boolean.valueOf(true))));
        }
    }
}


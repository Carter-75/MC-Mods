/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.util.Util
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.world.gen.stateprovider.BlockStateProvider
 *  net.minecraft.world.gen.treedecorator.TreeDecorator
 *  net.minecraft.world.gen.treedecorator.TreeDecorator$Generator
 *  net.minecraft.world.gen.treedecorator.TreeDecoratorType
 *  net.minecraft.util.dynamic.Codecs
 *  net.minecraft.util.math.random.Random
 */
package backported.updates.content.common.worldgen.treedecorators;

import backported.updates.content.common.registries.ModTreeDecorators;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.random.Random;

public class AttachedToLogsDecorator
extends TreeDecorator {
    public static final MapCodec<AttachedToLogsDecorator> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.floatRange((float)0.0f, (float)1.0f).fieldOf("probability").forGetter(decorator -> Float.valueOf(decorator.probability)), BlockStateProvider.TYPE_CODEC.fieldOf("block_provider").forGetter(decorator -> decorator.blockProvider), Codecs.nonEmptyList(Direction.CODEC.listOf()).fieldOf("directions").forGetter(decorator -> decorator.directions)).apply(instance, AttachedToLogsDecorator::new));
    private final float probability;
    private final BlockStateProvider blockProvider;
    private final List<Direction> directions;

    public AttachedToLogsDecorator(float probability, BlockStateProvider blockProvider, List<Direction> directions) {
        this.probability = probability;
        this.blockProvider = blockProvider;
        this.directions = directions;
    }

    public void generate(TreeDecorator.Generator context) {
        Random random = context.getRandom();
        for (Object posObj : Util.copyShuffled((ObjectArrayList<BlockPos>)context.getLogPositions(), random)) {
            BlockPos pos = (BlockPos)posObj;
            Direction direction = (Direction)Util.getRandom(this.directions, random);
            BlockPos offset = pos.offset(direction);
            if (!(random.nextFloat() <= this.probability) || !context.isAir(offset)) continue;
            context.replace(offset, this.blockProvider.get(random, offset));
        }
    }

    protected TreeDecoratorType<?> getType() {
        return ModTreeDecorators.ATTACHED_TO_LOGS.get();
    }
}


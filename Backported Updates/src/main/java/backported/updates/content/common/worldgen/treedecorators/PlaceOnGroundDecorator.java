/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.world.BlockView
 *  net.minecraft.block.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.util.math.BlockBox
 *  net.minecraft.world.gen.stateprovider.BlockStateProvider
 *  net.minecraft.world.gen.treedecorator.TreeDecorator
 *  net.minecraft.world.gen.treedecorator.TreeDecorator$Generator
 *  net.minecraft.world.gen.treedecorator.TreeDecoratorType
 *  net.minecraft.util.dynamic.Codecs
 *  net.minecraft.util.math.random.Random
 */
package backported.updates.content.common.worldgen.treedecorators;

import backported.updates.content.common.registries.ModTreeDecorators;
import com.google.common.collect.Lists;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.ArrayList;
import net.minecraft.world.BlockView;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.util.math.BlockBox;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.random.Random;

public class PlaceOnGroundDecorator
extends TreeDecorator {
    public static final MapCodec<PlaceOnGroundDecorator> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codecs.POSITIVE_INT.fieldOf("tries").orElse(128).forGetter(decorator -> decorator.tries), Codecs.NONNEGATIVE_INT.fieldOf("radius").orElse(2).forGetter(decorator -> decorator.radius), Codecs.NONNEGATIVE_INT.fieldOf("height").orElse(1).forGetter(decorator -> decorator.height), BlockStateProvider.TYPE_CODEC.fieldOf("block_state_provider").forGetter(decorator -> decorator.blockStateProvider)).apply(instance, PlaceOnGroundDecorator::new));
    private final int tries;
    private final int radius;
    private final int height;
    private final BlockStateProvider blockStateProvider;

    public PlaceOnGroundDecorator(int tries, int radius, int height, BlockStateProvider blockStateProvider) {
        this.tries = tries;
        this.radius = radius;
        this.height = height;
        this.blockStateProvider = blockStateProvider;
    }

    protected TreeDecoratorType<?> getType() {
        return ModTreeDecorators.PLACE_ON_GROUND.get();
    }

    public void generate(TreeDecorator.Generator context) {
        ArrayList<BlockPos> list = Lists.newArrayList();
        ObjectArrayList<BlockPos> list2 = context.getRootPositions();
        ObjectArrayList<BlockPos> list3 = context.getLogPositions();
        if (list2.isEmpty()) {
            list.addAll(list3);
        } else if (!list3.isEmpty() && ((BlockPos)list2.get(0)).getY() == ((BlockPos)list3.get(0)).getY()) {
            list.addAll(list3);
            list.addAll(list2);
        } else {
            list.addAll(list2);
        }
        if (!list.isEmpty()) {
            BlockPos blockPos = (BlockPos)list.get(0);
            int i = blockPos.getY();
            int j = blockPos.getX();
            int k = blockPos.getX();
            int l = blockPos.getZ();
            int m = blockPos.getZ();
            for (BlockPos blockPos2 : list) {
                if (blockPos2.getY() != i) continue;
                j = Math.min(j, blockPos2.getX());
                k = Math.max(k, blockPos2.getX());
                l = Math.min(l, blockPos2.getZ());
                m = Math.max(m, blockPos2.getZ());
            }
            Random randomSource = context.getRandom();
            BlockBox base = new BlockBox(j, i, l, k, i, m);
            BlockBox boundingBox = new BlockBox(base.getMinX() - this.radius, base.getMinY() - this.height, base.getMinZ() - this.radius, base.getMaxX() + this.radius, base.getMaxY() + this.height, base.getMaxZ() + this.radius);
            BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable();
            for (int n = 0; n < this.tries; ++n) {
                mutableBlockPos.set(randomSource.nextBetween(boundingBox.getMinX(), boundingBox.getMaxX()), randomSource.nextBetween(boundingBox.getMinY(), boundingBox.getMaxY()), randomSource.nextBetween(boundingBox.getMinZ(), boundingBox.getMaxZ()));
                this.attemptToPlaceBlockAbove(context, (BlockPos)mutableBlockPos);
            }
        }
    }

    private void attemptToPlaceBlockAbove(TreeDecorator.Generator context, BlockPos pos) {
        BlockPos above = pos.up();
        if (context.getWorld().testBlockState(above, state -> state.isAir() || state.isOf(Blocks.VINE)) && context.getWorld().testBlockState(pos, state -> state.isOpaqueFullCube((BlockView)context.getWorld(), pos)) && context.getWorld().getTopPosition(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, pos).getY() <= above.getY()) {
            context.replace(above, this.blockStateProvider.get(context.getRandom(), above));
        }
    }
}


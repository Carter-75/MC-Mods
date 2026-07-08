/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.WorldAccess
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Type
 *  net.minecraft.block.PillarBlock
 *  net.minecraft.block.BlockState
 *  net.minecraft.Property
 *  net.minecraft.world.gen.feature.TreeFeature
 *  net.minecraft.world.gen.feature.Feature
 *  net.minecraft.world.TestableWorld
 *  net.minecraft.world.gen.treedecorator.TreeDecorator
 *  net.minecraft.world.gen.treedecorator.TreeDecorator$Generator
 *  net.minecraft.world.StructureWorldAccess
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.world.gen.feature.util.FeatureContext
 */
package backported.updates.content.common.level.features;

import backported.updates.content.common.level.features.FallenTreeConfiguration;
import com.mojang.serialization.Codec;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class FallenTreeFeature
extends Feature<FallenTreeConfiguration> {
    public FallenTreeFeature(Codec<FallenTreeConfiguration> codec) {
        super(codec);
    }

    public boolean generate(FeatureContext<FallenTreeConfiguration> context) {
        this.placeFallenTree((FallenTreeConfiguration)context.getConfig(), context.getOrigin(), context.getWorld(), context.getRandom());
        return true;
    }

    private void placeFallenTree(FallenTreeConfiguration config, BlockPos pos, StructureWorldAccess level, Random random) {
        this.placeStump(config, level, random, pos.mutableCopy());
        Direction direction = Direction.Type.HORIZONTAL.random(random);
        int length = config.logLength.get(random) - 2;
        BlockPos.Mutable mutable = pos.offset(direction, 2 + random.nextInt(2)).mutableCopy();
        this.setGroundHeightForFallenLogStartPos(level, mutable);
        if (this.canPlaceEntireFallenLog(level, length, mutable, direction)) {
            this.placeFallenLog(config, level, random, length, mutable, direction);
        }
    }

    private void setGroundHeightForFallenLogStartPos(StructureWorldAccess level, BlockPos.Mutable mutable) {
        mutable.move(Direction.UP, 1);
        for (int i = 0; i < 6; ++i) {
            if (this.mayPlaceOn((WorldAccess)level, (BlockPos)mutable)) {
                return;
            }
            mutable.move(Direction.DOWN);
        }
    }

    private void placeStump(FallenTreeConfiguration config, StructureWorldAccess level, Random random, BlockPos.Mutable mutable) {
        BlockPos origin = this.placeLogBlock(config, level, random, mutable, Function.identity());
        this.decorateLogs(level, random, Set.of(origin), config.stumpDecorators);
    }

    private boolean canPlaceEntireFallenLog(StructureWorldAccess level, int length, BlockPos.Mutable mutable, Direction direction) {
        int gaps = 0;
        for (int k = 0; k < length; ++k) {
            if (!TreeFeature.canReplace((TestableWorld)level, (BlockPos)mutable)) {
                return false;
            }
            if (!this.isOverSolidGround((WorldAccess)level, (BlockPos)mutable)) {
                if (gaps++ > 2) {
                    return false;
                }
            } else {
                gaps = 0;
            }
            mutable.move(direction);
        }
        mutable.move(direction.getOpposite(), length);
        return true;
    }

    private void placeFallenLog(FallenTreeConfiguration config, StructureWorldAccess level, Random random, int length, BlockPos.Mutable mutable, Direction direction) {
        HashSet<BlockPos> positions = new HashSet<BlockPos>();
        for (int i = 0; i < length; ++i) {
            positions.add(this.placeLogBlock(config, level, random, mutable, FallenTreeFeature.getSidewaysStateModifier(direction)));
            mutable.move(direction);
        }
        this.decorateLogs(level, random, positions, config.logDecorators);
    }

    private boolean mayPlaceOn(WorldAccess level, BlockPos pos) {
        return TreeFeature.canReplace((TestableWorld)level, (BlockPos)pos) && this.isOverSolidGround(level, pos);
    }

    private boolean isOverSolidGround(WorldAccess level, BlockPos pos) {
        return level.getBlockState(pos.down()).isSideSolidFullSquare((BlockView)level, pos, Direction.UP);
    }

    private BlockPos placeLogBlock(FallenTreeConfiguration config, StructureWorldAccess level, Random random, BlockPos.Mutable mutable, Function<BlockState, BlockState> factory) {
        level.setBlockState((BlockPos)mutable, factory.apply(config.trunkProvider.get(random, (BlockPos)mutable)), 3);
        this.markBlocksAboveForPostProcessing(level, (BlockPos)mutable);
        return mutable.toImmutable();
    }

    private void decorateLogs(StructureWorldAccess level, Random random, Set<BlockPos> positions, List<TreeDecorator> decorators) {
        if (!decorators.isEmpty()) {
            TreeDecorator.Generator context = new TreeDecorator.Generator((TestableWorld)level, this.getDecorationSetter(level), random, positions, Set.of(), Set.of());
            decorators.forEach(decorator -> decorator.generate(context));
        }
    }

    private BiConsumer<BlockPos, BlockState> getDecorationSetter(StructureWorldAccess level) {
        return (pos, state) -> level.setBlockState(pos, state, 19);
    }

    private static Function<BlockState, BlockState> getSidewaysStateModifier(Direction direction) {
        return state -> state.withIfExists(PillarBlock.AXIS, direction.getAxis());
    }
}


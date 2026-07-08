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
 *  net.minecraft.block.BlockState
 *  net.minecraft.Property
 *  net.minecraft.world.gen.feature.ConfiguredFeature
 *  net.minecraft.world.gen.treedecorator.TreeDecorator
 *  net.minecraft.world.gen.treedecorator.TreeDecorator$Generator
 *  net.minecraft.world.gen.treedecorator.TreeDecoratorType
 *  net.minecraft.world.StructureWorldAccess
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.registry.RegistryKeys
 *  org.apache.commons.lang3.mutable.Mutable
 *  org.apache.commons.lang3.mutable.MutableObject
 */
package backported.updates.content.common.worldgen.treedecorators;

import backported.updates.content.common.level.blocks.HangingMossBlock;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModTreeDecorators;
import backported.updates.content.common.worldgen.features.TheGardenAwakensFeatures;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Property;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.util.math.random.Random;
import net.minecraft.registry.RegistryKeys;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;

public class PaleMossDecorator
extends TreeDecorator {
    public static final MapCodec<PaleMossDecorator> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.floatRange((float)0.0f, (float)1.0f).fieldOf("leaves_probability").forGetter(decorator -> Float.valueOf(decorator.leavesProbability)), Codec.floatRange((float)0.0f, (float)1.0f).fieldOf("trunk_probability").forGetter(decorator -> Float.valueOf(decorator.trunkProbability)), Codec.floatRange((float)0.0f, (float)1.0f).fieldOf("ground_probability").forGetter(decorator -> Float.valueOf(decorator.groundProbability))).apply(instance, PaleMossDecorator::new));
    private final float leavesProbability;
    private final float trunkProbability;
    private final float groundProbability;

    public PaleMossDecorator(float leavesProbability, float trunkProbability, float groundProbability) {
        this.leavesProbability = leavesProbability;
        this.trunkProbability = trunkProbability;
        this.groundProbability = groundProbability;
    }

    protected TreeDecoratorType<?> getType() {
        return ModTreeDecorators.PALE_MOSS.get();
    }

    public void generate(TreeDecorator.Generator context) {
        Random random = context.getRandom();
        StructureWorldAccess level = (StructureWorldAccess)context.getWorld();
        List<BlockPos> positions = Util.copyShuffled((ObjectArrayList<BlockPos>)context.getLogPositions(), random);
        if (!positions.isEmpty()) {
            MutableObject<BlockPos> mutable = new MutableObject<>((BlockPos)positions.getFirst());
            positions.forEach(arg_0 -> PaleMossDecorator.lambda$place$4((Mutable)mutable, arg_0));
            BlockPos position = (BlockPos)mutable.getValue();
            if (random.nextFloat() < this.groundProbability) {
                level.getRegistryManager().getOptionalWrapper(RegistryKeys.CONFIGURED_FEATURE).flatMap(registry -> registry.getOptional(TheGardenAwakensFeatures.PALE_MOSS_PATCH)).ifPresent(reference -> ((ConfiguredFeature)reference.value()).generate(level, level.toServerWorld().getChunkManager().getChunkGenerator(), random, position.up()));
            }
            context.getLogPositions().forEach(pos -> {
                BlockPos below;
                if (random.nextFloat() < this.trunkProbability && context.isAir(below = pos.down())) {
                    PaleMossDecorator.addMossHanger(below, context);
                }
            });
            context.getLeavesPositions().forEach(pos -> {
                BlockPos below;
                if (random.nextFloat() < this.leavesProbability && context.isAir(below = pos.down())) {
                    PaleMossDecorator.addMossHanger(below, context);
                }
            });
        }
    }

    private static void addMossHanger(BlockPos pos, TreeDecorator.Generator context) {
        while (context.isAir(pos.down()) && context.getRandom().nextFloat() >= 0.5f) {
            context.replace(pos, ModBlocks.PALE_HANGING_MOSS.get().getDefaultState().with(HangingMossBlock.TIP, Boolean.valueOf(false)));
            pos = pos.down();
        }
        context.replace(pos, ModBlocks.PALE_HANGING_MOSS.get().getDefaultState().with(HangingMossBlock.TIP, Boolean.valueOf(true)));
    }

    private static /* synthetic */ void lambda$place$4(Mutable mutable, BlockPos pos) {
        if (pos.getY() < ((BlockPos)mutable.getValue()).getY()) {
            mutable.setValue(pos);
        }
    }
}


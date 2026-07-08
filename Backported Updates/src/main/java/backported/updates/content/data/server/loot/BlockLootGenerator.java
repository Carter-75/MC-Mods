/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
 *  net.minecraft.loot.function.LimitCountLootFunction
 *  net.minecraft.loot.function.LootFunctionConsumingBuilder
 *  net.minecraft.loot.function.LootFunction$Builder
 *  net.minecraft.loot.function.SetCountLootFunction
 *  net.minecraft.enchantment.Enchantments
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.loot.condition.BlockStatePropertyLootCondition
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.Direction
 *  net.minecraft.Property
 *  net.minecraft.loot.operator.BoundedIntUnaryOperator
 *  net.minecraft.loot.provider.number.ConstantLootNumberProvider
 *  net.minecraft.predicate.StatePredicate$Builder
 *  net.minecraft.loot.LootTable
 *  net.minecraft.loot.LootTable$Builder
 *  net.minecraft.loot.condition.LootCondition$Builder
 *  net.minecraft.loot.LootPool
 *  net.minecraft.loot.provider.number.LootNumberProvider
 *  net.minecraft.loot.provider.number.UniformLootNumberProvider
 *  net.minecraft.block.MultifaceGrowthBlock
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.RegistryWrapper$Impl
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  net.minecraft.loot.entry.ItemEntry
 *  net.minecraft.loot.entry.LootPoolEntry$Builder
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.loot.entry.LeafEntry$Builder
 *  net.minecraft.loot.function.ApplyBonusLootFunction
 */
package backported.updates.content.data.server.loot;

import backported.updates.content.common.level.blocks.MossyCarpetBlock;
import backported.updates.content.common.registries.ModBlocks;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.function.LimitCountLootFunction;
import net.minecraft.loot.function.LootFunctionConsumingBuilder;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.block.Block;
import net.minecraft.util.math.Direction;
import net.minecraft.state.property.Property;
import net.minecraft.loot.operator.BoundedIntUnaryOperator;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.block.MultifaceGrowthBlock;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;

public class BlockLootGenerator
extends FabricBlockLootTableProvider {
    public BlockLootGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public void generate() {
        RegistryWrapper.Impl enchantments = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        this.addDrop(ModBlocks.PALE_OAK_PLANKS.get());
        this.addDrop(ModBlocks.PALE_OAK_SAPLING.get());
        this.addDrop(ModBlocks.PALE_OAK_LOG.get());
        this.addDrop(ModBlocks.STRIPPED_PALE_OAK_LOG.get());
        this.addDrop(ModBlocks.PALE_OAK_WOOD.get());
        this.addDrop(ModBlocks.STRIPPED_PALE_OAK_WOOD.get());
        this.addDrop((Block)((Supplier)ModBlocks.PALE_OAK_SIGN.getFirst()).get());
        this.addDrop((Block)((Supplier)ModBlocks.PALE_OAK_HANGING_SIGN.getFirst()).get());
        this.addDrop(ModBlocks.PALE_OAK_PRESSURE_PLATE.get());
        this.addDrop(ModBlocks.PALE_OAK_TRAPDOOR.get());
        this.addDrop(ModBlocks.PALE_OAK_BUTTON.get());
        this.addDrop(ModBlocks.PALE_OAK_STAIRS.get());
        this.addDrop(ModBlocks.PALE_OAK_FENCE_GATE.get());
        this.addDrop(ModBlocks.PALE_OAK_FENCE.get());
        this.addDrop(ModBlocks.PALE_OAK_SLAB.get(), arg_0 -> ((BlockLootGenerator)this).slabDrops(arg_0));
        this.addDrop(ModBlocks.PALE_OAK_DOOR.get(), arg_0 -> ((BlockLootGenerator)this).doorDrops(arg_0));
        this.addDrop(ModBlocks.PALE_OAK_LEAVES.get(), block -> this.leavesDrops((Block)block, ModBlocks.PALE_OAK_SAPLING.get(), SAPLING_DROP_CHANCE));
        this.addDrop(ModBlocks.OPEN_EYEBLOSSOM.get());
        this.addDrop(ModBlocks.CLOSED_EYEBLOSSOM.get());
        this.addDrop(ModBlocks.PALE_MOSS_CARPET.get(), this::createMossyCarpetBlockDrops);
        this.addDrop(ModBlocks.PALE_HANGING_MOSS.get(), this::createShearsOrSilkTouchOnlyDrop);
        this.addDrop(ModBlocks.PALE_MOSS_BLOCK.get());
        this.addPottedPlantDrops(ModBlocks.POTTED_PALE_OAK_SAPLING.get());
        this.addPottedPlantDrops(ModBlocks.POTTED_OPEN_EYEBLOSSOM.get());
        this.addPottedPlantDrops(ModBlocks.POTTED_CLOSED_EYEBLOSSOM.get());
        this.addDrop(ModBlocks.RESIN_BLOCK.get());
        this.addDrop(ModBlocks.RESIN_BRICKS.get());
        this.addDrop(ModBlocks.RESIN_BRICK_WALL.get());
        this.addDrop(ModBlocks.RESIN_BRICK_STAIRS.get());
        this.addDrop(ModBlocks.CHISELED_RESIN_BRICKS.get());
        this.addDrop(ModBlocks.RESIN_BRICK_SLAB.get(), arg_0 -> ((BlockLootGenerator)this).slabDrops(arg_0));
        this.addDrop(ModBlocks.RESIN_CLUMP.get(), this::createMultifaceBlockDrops);
        this.addDrop(ModBlocks.CREAKING_HEART.get(), block -> this.dropsWithSilkTouch((Block)block, (LootPoolEntry.Builder)this.applyExplosionDecay((ItemConvertible)block, (LootFunctionConsumingBuilder)ItemEntry.builder((ItemConvertible)((ItemConvertible)ModBlocks.RESIN_CLUMP.get())).apply((LootFunction.Builder)SetCountLootFunction.builder((LootNumberProvider)UniformLootNumberProvider.create((float)1.0f, (float)3.0f))).apply((LootFunction.Builder)ApplyBonusLootFunction.uniformBonusCount((RegistryEntry)enchantments.getOrThrow(Enchantments.FORTUNE))).apply((LootFunction.Builder)LimitCountLootFunction.builder((BoundedIntUnaryOperator)BoundedIntUnaryOperator.createMax((int)9))))));
        this.addDrop(ModBlocks.DRIED_GHAST.get());
        this.addDrop(ModBlocks.FIREFLY_BUSH.get());
        this.addDrop(ModBlocks.BUSH.get(), this::createShearsOrSilkTouchOnlyDrop);
        this.addDrop(ModBlocks.WILDFLOWERS.get(), this.flowerbedDrops(ModBlocks.WILDFLOWERS.get()));
        this.addDrop(ModBlocks.LEAF_LITTER.get(), this.flowerbedDrops(ModBlocks.LEAF_LITTER.get()));
        this.addDrop(ModBlocks.CACTUS_FLOWER.get());
        this.addDrop(ModBlocks.SHORT_DRY_GRASS.get(), this::createShearsOrSilkTouchOnlyDrop);
        this.addDrop(ModBlocks.TALL_DRY_GRASS.get(), this::createShearsOrSilkTouchOnlyDrop);
    }

    protected LootTable.Builder createMultifaceBlockDrops(Block block) {
        return LootTable.builder().pool(LootPool.builder().with((LootPoolEntry.Builder)this.applyExplosionDecay((ItemConvertible)block, (LootFunctionConsumingBuilder)((LeafEntry.Builder)ItemEntry.builder((ItemConvertible)block).apply((Object[])Direction.values(), direction -> SetCountLootFunction.builder((LootNumberProvider)ConstantLootNumberProvider.create((float)1.0f), (boolean)true).conditionally((LootCondition.Builder)BlockStatePropertyLootCondition.builder((Block)block).properties(StatePredicate.Builder.create().exactMatch(MultifaceGrowthBlock.getProperty((Direction)direction), true))))).apply((LootFunction.Builder)SetCountLootFunction.builder((LootNumberProvider)ConstantLootNumberProvider.create((float)-1.0f), (boolean)true)))));
    }

    protected LootTable.Builder createMossyCarpetBlockDrops(Block block) {
        return LootTable.builder().pool(LootPool.builder().with((LootPoolEntry.Builder)this.applyExplosionDecay((ItemConvertible)block, (LootFunctionConsumingBuilder)ItemEntry.builder((ItemConvertible)block).conditionally((LootCondition.Builder)BlockStatePropertyLootCondition.builder((Block)block).properties(StatePredicate.Builder.create().exactMatch(MossyCarpetBlock.BASE, true))))));
    }

    protected LootTable.Builder createShearsOrSilkTouchOnlyDrop(ItemConvertible itemLike) {
        return LootTable.builder().pool(LootPool.builder().rolls((LootNumberProvider)ConstantLootNumberProvider.create((float)1.0f)).conditionally(this.createWithShearsOrSilkTouchCondition()).with((LootPoolEntry.Builder)ItemEntry.builder((ItemConvertible)itemLike)));
    }
}


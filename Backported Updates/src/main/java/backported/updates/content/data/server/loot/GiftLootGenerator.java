/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider
 *  net.minecraft.loot.context.LootContextTypes
 *  net.minecraft.item.Items
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.predicate.entity.EntityPredicate$Builder
 *  net.minecraft.predicate.NbtPredicate
 *  net.minecraft.loot.condition.EntityPropertiesLootCondition
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.util.Identifier
 *  net.minecraft.loot.provider.number.ConstantLootNumberProvider
 *  net.minecraft.loot.context.LootContext$EntityTarget
 *  net.minecraft.loot.LootTable
 *  net.minecraft.loot.LootTable$Builder
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.loot.LootPool
 *  net.minecraft.loot.provider.number.LootNumberProvider
 *  net.minecraft.loot.entry.AlternativeEntry
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  net.minecraft.loot.entry.ItemEntry
 *  net.minecraft.loot.entry.LootPoolEntry$Builder
 */
package backported.updates.content.data.server.loot;

import backported.updates.content.common.level.entities.animal.ChickenVariants;
import backported.updates.content.common.registries.ModItems;
import backported.updates.content.core.registries.ModBuiltInLootTables;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.item.Items;
import net.minecraft.item.ItemConvertible;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.NbtPredicate;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;

public class GiftLootGenerator
extends SimpleFabricLootTableProvider {
    public GiftLootGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> lookup) {
        super(output, lookup, LootContextTypes.GIFT);
    }

    private static NbtPredicate variantNbt(Identifier variantId) {
        NbtCompound tag = new NbtCompound();
        tag.putString("variant", variantId.toString());
        return new NbtPredicate(tag);
    }

    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> output) {
        output.accept(ModBuiltInLootTables.CHICKEN_LAY, LootTable.builder().pool(LootPool.builder().rolls((LootNumberProvider)ConstantLootNumberProvider.create((float)1.0f)).with((LootPoolEntry.Builder)AlternativeEntry.builder((LootPoolEntry.Builder[])new LootPoolEntry.Builder[]{ItemEntry.builder((ItemConvertible)Items.EGG).conditionally(EntityPropertiesLootCondition.builder((LootContext.EntityTarget)LootContext.EntityTarget.THIS, (EntityPredicate.Builder)EntityPredicate.Builder.create().nbt(GiftLootGenerator.variantNbt(ChickenVariants.TEMPERATE.getValue())))), ItemEntry.builder((ItemConvertible)((ItemConvertible)ModItems.BROWN_EGG.get())).conditionally(EntityPropertiesLootCondition.builder((LootContext.EntityTarget)LootContext.EntityTarget.THIS, (EntityPredicate.Builder)EntityPredicate.Builder.create().nbt(GiftLootGenerator.variantNbt(ChickenVariants.WARM.getValue())))), ItemEntry.builder((ItemConvertible)((ItemConvertible)ModItems.BLUE_EGG.get())).conditionally(EntityPropertiesLootCondition.builder((LootContext.EntityTarget)LootContext.EntityTarget.THIS, (EntityPredicate.Builder)EntityPredicate.Builder.create().nbt(GiftLootGenerator.variantNbt(ChickenVariants.COLD.getValue()))))}))));
    }
}


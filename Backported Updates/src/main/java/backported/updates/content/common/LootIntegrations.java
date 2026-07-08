/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.loot.function.LootFunction$Builder
 *  net.minecraft.entity.EntityType
 *  net.minecraft.loot.function.SetCountLootFunction
 *  net.minecraft.item.Items
 *  net.minecraft.loot.condition.DamageSourcePropertiesLootCondition
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.predicate.entity.DamageSourcePredicate$Builder
 *  net.minecraft.predicate.entity.EntityFlagsPredicate$Builder
 *  net.minecraft.predicate.entity.EntityPredicate$Builder
 *  net.minecraft.loot.condition.EntityPropertiesLootCondition
 *  net.minecraft.loot.condition.KilledByPlayerLootCondition
 *  net.minecraft.loot.LootTables
 *  net.minecraft.loot.provider.number.ConstantLootNumberProvider
 *  net.minecraft.loot.context.LootContext$EntityTarget
 *  net.minecraft.loot.LootTable
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.loot.LootPool
 *  net.minecraft.loot.provider.number.LootNumberProvider
 *  net.minecraft.loot.provider.number.UniformLootNumberProvider
 *  net.minecraft.registry.tag.TagKey
 *  net.minecraft.loot.entry.EmptyEntry
 *  net.minecraft.loot.entry.ItemEntry
 *  net.minecraft.loot.entry.LootPoolEntry$Builder
 *  net.minecraft.registry.tag.DamageTypeTags
 *  net.minecraft.predicate.TagPredicate
 */
package backported.updates.content.common;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModItems;
import backported.updates.content.core.VanillaBackport;
import backported.updates.foundation.common.data.LootModifier;
import java.util.List;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.DamageSourcePropertiesLootCondition;
import net.minecraft.item.ItemConvertible;
import net.minecraft.predicate.entity.DamageSourcePredicate;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.predicate.TagPredicate;

public class LootIntegrations
implements LootModifier.LootTableModifier {
    private static final List<RegistryKey<LootTable>> CONTAIN_BUNDLE = List.of(LootTables.VILLAGE_WEAPONSMITH_CHEST, LootTables.VILLAGE_CARTOGRAPHER_CHEST, LootTables.VILLAGE_TANNERY_CHEST, LootTables.VILLAGE_PLAINS_CHEST, LootTables.VILLAGE_TAIGA_HOUSE_CHEST, LootTables.VILLAGE_SAVANNA_HOUSE_CHEST, LootTables.VILLAGE_SNOWY_HOUSE_CHEST, LootTables.VILLAGE_DESERT_HOUSE_CHEST);

    @Override
    public void modify(RegistryKey<LootTable> key, LootModifier.LootTableContext context, boolean builtin) {
        if (key.equals(EntityType.GHAST.getLootTableId()) && VanillaBackport.COMMON_CONFIG.hasTearsMusicDisc.get().booleanValue()) {
            context.addPool(LootPool.builder().rolls((LootNumberProvider)ConstantLootNumberProvider.create((float)1.0f)).with((LootPoolEntry.Builder)ItemEntry.builder((ItemConvertible)((ItemConvertible)ModItems.MUSIC_DISC_TEARS.get()))).apply((LootFunction.Builder)SetCountLootFunction.builder((LootNumberProvider)ConstantLootNumberProvider.create((float)1.0f))).conditionally(DamageSourcePropertiesLootCondition.builder((DamageSourcePredicate.Builder)DamageSourcePredicate.Builder.create().tag(TagPredicate.expected((TagKey)DamageTypeTags.IS_PROJECTILE)).directEntity(EntityPredicate.Builder.create().type(EntityType.FIREBALL)))).conditionally(KilledByPlayerLootCondition.builder()));
        }
        if (key.equals(LootTables.PIGLIN_BARTERING_GAMEPLAY) && VanillaBackport.COMMON_CONFIG.hasDriedGhasts.get().booleanValue()) {
            context.addToPool(ItemEntry.builder((ItemConvertible)((ItemConvertible)ModBlocks.DRIED_GHAST.get())).weight(10).apply((LootFunction.Builder)SetCountLootFunction.builder((LootNumberProvider)ConstantLootNumberProvider.create((float)1.0f))).build());
        }
        if (key.equals(EntityType.ZOMBIE.getLootTableId())) {
            context.addPool(LootPool.builder().with((LootPoolEntry.Builder)ItemEntry.builder((ItemConvertible)((ItemConvertible)ModItems.MUSIC_DISC_LAVA_CHICKEN.get()))).conditionally(KilledByPlayerLootCondition.builder()).conditionally(EntityPropertiesLootCondition.builder((LootContext.EntityTarget)LootContext.EntityTarget.THIS, (EntityPredicate.Builder)EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().isBaby(Boolean.valueOf(true))).vehicle(EntityPredicate.Builder.create().type(EntityType.CHICKEN)))));
        }
        if (key.equals(LootTables.WOODLAND_MANSION_CHEST) && VanillaBackport.COMMON_CONFIG.hasResinLoot.get().booleanValue()) {
            context.addToPool(1, ItemEntry.builder((ItemConvertible)((ItemConvertible)ModBlocks.RESIN_CLUMP.get())).weight(50).apply((LootFunction.Builder)SetCountLootFunction.builder((LootNumberProvider)UniformLootNumberProvider.create((float)2.0f, (float)4.0f))).build());
        }
        if (CONTAIN_BUNDLE.contains(key) && VanillaBackport.COMMON_CONFIG.hadBundleLoot.get().booleanValue()) {
            context.addPool(LootPool.builder().rolls((LootNumberProvider)ConstantLootNumberProvider.create((float)1.0f)).with((LootPoolEntry.Builder)ItemEntry.builder((ItemConvertible)Items.BUNDLE).weight(1).apply((LootFunction.Builder)SetCountLootFunction.builder((LootNumberProvider)ConstantLootNumberProvider.create((float)1.0f)))).with((LootPoolEntry.Builder)EmptyEntry.builder().weight(2)));
        }
        if (key.equals(LootTables.RUINED_PORTAL_CHEST) && VanillaBackport.COMMON_CONFIG.hasLodestoneLoot.get().booleanValue()) {
            context.addPool(LootPool.builder().rolls((LootNumberProvider)ConstantLootNumberProvider.create((float)1.0f)).with((LootPoolEntry.Builder)ItemEntry.builder((ItemConvertible)Items.LODESTONE).weight(2).apply((LootFunction.Builder)SetCountLootFunction.builder((LootNumberProvider)UniformLootNumberProvider.create((float)1.0f, (float)2.0f)))).with((LootPoolEntry.Builder)EmptyEntry.builder().weight(1)));
        }
    }
}


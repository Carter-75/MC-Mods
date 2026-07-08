/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.loot.v3.LootTableEvents
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.util.Identifier
 *  net.minecraft.loot.provider.number.ConstantLootNumberProvider
 *  net.minecraft.loot.LootPool
 *  net.minecraft.loot.LootPool$Builder
 *  net.minecraft.loot.provider.number.LootNumberProvider
 *  net.minecraft.loot.entry.EmptyEntry
 *  net.minecraft.loot.entry.ItemEntry
 *  net.minecraft.loot.entry.LootPoolEntry$Builder
 */
package backported.updates.copper.fabric.loot;

import backported.updates.copper.loot.CopperHorseArmorLoot;
import backported.updates.copper.registry.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;

public class FabricLootTableModifier {
    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (!source.isBuiltin()) {
                return;
            }
            Identifier lootTableId = key.getValue();
            if (CopperHorseArmorLoot.shouldModifyLootTable(lootTableId)) {
                int[] weights = FabricLootTableModifier.getSpawnChanceWeights(lootTableId);
                int itemWeight = weights[0];
                int emptyWeight = weights[1];
                LootPool.Builder poolBuilder = LootPool.builder().rolls((LootNumberProvider)ConstantLootNumberProvider.create((float)1.0f)).with((LootPoolEntry.Builder)ItemEntry.builder((ItemConvertible)((ItemConvertible)ModItems.COPPER_HORSE_ARMOR.get())).weight(itemWeight)).with((LootPoolEntry.Builder)EmptyEntry.builder().weight(emptyWeight));
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }

    private static int[] getSpawnChanceWeights(Identifier lootTableId) {
        String path = lootTableId.getPath();
        if (path.equals("chests/simple_dungeon")) {
            return new int[]{194, 806};
        }
        if (path.equals("chests/desert_pyramid")) {
            return new int[]{170, 830};
        }
        if (path.equals("chests/nether_bridge")) {
            return new int[]{179, 821};
        }
        if (path.equals("chests/jungle_temple")) {
            return new int[]{44, 956};
        }
        if (path.equals("chests/end_city_treasure")) {
            return new int[]{46, 954};
        }
        if (path.equals("chests/stronghold_corridor")) {
            return new int[]{25, 975};
        }
        if (path.equals("chests/village/village_weaponsmith")) {
            return new int[]{56, 944};
        }
        return new int[]{50, 950};
    }
}


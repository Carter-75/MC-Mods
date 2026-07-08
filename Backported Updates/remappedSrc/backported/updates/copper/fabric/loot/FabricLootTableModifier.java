/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.loot.v3.LootTableEvents
 *  net.minecraft.class_1935
 *  net.minecraft.class_2960
 *  net.minecraft.class_44
 *  net.minecraft.class_55
 *  net.minecraft.class_55$class_56
 *  net.minecraft.class_5658
 *  net.minecraft.class_73
 *  net.minecraft.class_77
 *  net.minecraft.class_79$class_80
 */
package backported.updates.copper.fabric.loot;

import backported.updates.copper.loot.CopperHorseArmorLoot;
import backported.updates.copper.registry.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.class_1935;
import net.minecraft.class_2960;
import net.minecraft.class_44;
import net.minecraft.class_55;
import net.minecraft.class_5658;
import net.minecraft.class_73;
import net.minecraft.class_77;
import net.minecraft.class_79;

public class FabricLootTableModifier {
    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (!source.isBuiltin()) {
                return;
            }
            class_2960 lootTableId = key.method_29177();
            if (CopperHorseArmorLoot.shouldModifyLootTable(lootTableId)) {
                int[] weights = FabricLootTableModifier.getSpawnChanceWeights(lootTableId);
                int itemWeight = weights[0];
                int emptyWeight = weights[1];
                class_55.class_56 poolBuilder = class_55.method_347().method_352((class_5658)class_44.method_32448((float)1.0f)).method_351((class_79.class_80)class_77.method_411((class_1935)((class_1935)ModItems.COPPER_HORSE_ARMOR.get())).method_437(itemWeight)).method_351((class_79.class_80)class_73.method_401().method_437(emptyWeight));
                tableBuilder.pool(poolBuilder.method_355());
            }
        });
    }

    private static int[] getSpawnChanceWeights(class_2960 lootTableId) {
        String path = lootTableId.method_12832();
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


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 */
package backported.updates.copper.loot;

import java.util.Set;
import net.minecraft.class_2960;

public class CopperHorseArmorLoot {
    private static final Set<class_2960> TARGET_LOOT_TABLES = Set.of(class_2960.method_60656((String)"chests/simple_dungeon"), class_2960.method_60656((String)"chests/desert_pyramid"), class_2960.method_60656((String)"chests/nether_bridge"), class_2960.method_60656((String)"chests/jungle_temple"), class_2960.method_60656((String)"chests/stronghold_corridor"), class_2960.method_60656((String)"chests/end_city_treasure"), class_2960.method_60656((String)"chests/village/village_weaponsmith"));

    public static boolean shouldModifyLootTable(class_2960 lootTableId) {
        return TARGET_LOOT_TABLES.contains(lootTableId);
    }
}


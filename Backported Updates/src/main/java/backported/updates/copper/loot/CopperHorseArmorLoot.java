/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 */
package backported.updates.copper.loot;

import java.util.Set;
import net.minecraft.util.Identifier;

public class CopperHorseArmorLoot {
    private static final Set<Identifier> TARGET_LOOT_TABLES = Set.of(Identifier.ofVanilla((String)"chests/simple_dungeon"), Identifier.ofVanilla((String)"chests/desert_pyramid"), Identifier.ofVanilla((String)"chests/nether_bridge"), Identifier.ofVanilla((String)"chests/jungle_temple"), Identifier.ofVanilla((String)"chests/stronghold_corridor"), Identifier.ofVanilla((String)"chests/end_city_treasure"), Identifier.ofVanilla((String)"chests/village/village_weaponsmith"));

    public static boolean shouldModifyLootTable(Identifier lootTableId) {
        return TARGET_LOOT_TABLES.contains(lootTableId);
    }
}


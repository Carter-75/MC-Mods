/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 *  net.minecraft.loot.LootTable
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.core.registries;

import net.minecraft.util.Identifier;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModBuiltInLootTables {
    public static final RegistryKey<LootTable> CHICKEN_LAY = RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.ofVanilla((String)"gameplay/chicken_lay"));
}


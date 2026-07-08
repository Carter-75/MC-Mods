/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableList$Builder
 *  net.fabricmc.fabric.api.loot.v3.LootTableEvents
 *  net.minecraft.loot.LootTable
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.loot.LootPool
 *  net.minecraft.loot.LootPool$Builder
 *  net.minecraft.loot.entry.LootPoolEntry
 */
package backported.updates.foundation.common.data.fabric;

import backported.updates.foundation.Platform;
import backported.updates.foundation.common.data.LootModifier;
import backported.updates.foundation.common.data.fabric.LootPoolAccess;
import backported_updates.mixin.foundation.fabric.loot.LootTableBuilderAccessor;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.LootPoolEntry;

public class LootModifierImpl {
    public static void modify(LootModifier.LootTableModifier modifier) {
        LootTableEvents.MODIFY.register((key, table, source, provider) -> modifier.modify((RegistryKey<LootTable>)key, new LootModifier.LootTableContext(){

            @Override
            public void addPool(LootPool.Builder pool) {
                table.pool(pool);
            }

            @Override
            public boolean addToPool(int index, ArrayList<LootPoolEntry> content) {
                try {
                    ImmutableList.Builder<LootPool> pools = ((LootTableBuilderAccessor)table).getPools();
                    ImmutableList local = pools.build();
                    if (local.size() <= index) {
                        Platform.LOGGER.error("Failed to add content to loot pool at index {}: No pools found", index);
                        return false;
                    }
                    LootPool pool = (LootPool)local.get(index);
                    LootPool modifiedPool = ((LootPoolAccess)pool).mergeEntries(content);
                    ImmutableList.Builder builder = ImmutableList.builder();
                    for (int i = 0; i < local.size(); ++i) {
                        builder.add((i == index ? modifiedPool : (LootPool)local.get(i)));
                    }
                    ((LootTableBuilderAccessor)table).setPools((ImmutableList.Builder<LootPool>)builder);
                    return true;
                }
                catch (Throwable t) {
                    Platform.LOGGER.error("Failed to add content to loot pool at index {}: {}", index, t.getMessage(), t);
                    return false;
                }
            }
        }, source.isBuiltin()));
    }
}


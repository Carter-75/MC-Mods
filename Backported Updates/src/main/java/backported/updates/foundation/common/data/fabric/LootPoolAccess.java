/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.loot.LootPool
 *  net.minecraft.loot.entry.LootPoolEntry
 */
package backported.updates.foundation.common.data.fabric;

import java.util.List;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.LootPoolEntry;

public interface LootPoolAccess {
    public LootPool mergeEntries(List<LootPoolEntry> var1);
}


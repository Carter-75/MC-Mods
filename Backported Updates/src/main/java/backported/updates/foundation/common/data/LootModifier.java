/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.loot.LootTable
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.loot.LootPool$Builder
 *  net.minecraft.loot.entry.LootPoolEntry
 */
package backported.updates.foundation.common.data;

import backported.updates.foundation.common.data.fabric.LootModifierImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.LootPoolEntry;

public class LootModifier {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void modify(LootTableModifier modifier) {
        LootModifierImpl.modify(modifier);
    }

    public static interface LootTableContext {
        public void addPool(LootPool.Builder var1);

        public boolean addToPool(int var1, ArrayList<LootPoolEntry> var2);

        default public boolean addToPool(ArrayList<LootPoolEntry> content) {
            return this.addToPool(0, content);
        }

        default public boolean addToPool(int index, LootPoolEntry ... content) {
            ArrayList<LootPoolEntry> entries = new ArrayList<LootPoolEntry>();
            Collections.addAll(entries, content);
            return this.addToPool(index, entries);
        }

        default public boolean addToPool(LootPoolEntry ... content) {
            return this.addToPool(0, content);
        }
    }

    public static interface LootTableModifier {
        public void modify(RegistryKey<LootTable> var1, LootTableContext var2, boolean var3);
    }
}


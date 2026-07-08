/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableList$Builder
 *  net.fabricmc.fabric.api.loot.v3.LootTableEvents
 *  net.minecraft.class_52
 *  net.minecraft.class_5321
 *  net.minecraft.class_55
 *  net.minecraft.class_55$class_56
 *  net.minecraft.class_79
 */
package backported.updates.foundation.common.data.fabric;

import backported.updates.foundation.Platform;
import backported.updates.foundation.common.data.LootModifier;
import backported.updates.foundation.common.data.fabric.LootPoolAccess;
import backported_updates.mixin.foundation.fabric.loot.LootTableBuilderAccessor;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.class_52;
import net.minecraft.class_5321;
import net.minecraft.class_55;
import net.minecraft.class_79;

public class LootModifierImpl {
    public static void modify(LootModifier.LootTableModifier modifier) {
        LootTableEvents.MODIFY.register((key, table, source, provider) -> modifier.modify((class_5321<class_52>)key, new LootModifier.LootTableContext(){

            @Override
            public void addPool(class_55.class_56 pool) {
                table.method_336(pool);
            }

            @Override
            public boolean addToPool(int index, ArrayList<class_79> content) {
                try {
                    ImmutableList.Builder<class_55> pools = ((LootTableBuilderAccessor)table).getPools();
                    ImmutableList local = pools.build();
                    if (local.size() <= index) {
                        Platform.LOGGER.error("Failed to add content to loot pool at index {}: No pools found", (Object)index);
                        return false;
                    }
                    class_55 pool = (class_55)local.get(index);
                    class_55 modifiedPool = ((LootPoolAccess)pool).mergeEntries(content);
                    ImmutableList.Builder builder = ImmutableList.builder();
                    for (int i = 0; i < local.size(); ++i) {
                        builder.add((Object)(i == index ? modifiedPool : (class_55)local.get(i)));
                    }
                    ((LootTableBuilderAccessor)table).setPools((ImmutableList.Builder<class_55>)builder);
                    return true;
                }
                catch (Throwable t) {
                    Platform.LOGGER.error("Failed to add content to loot pool at index {}: {}", (Object)index, (Object)t.getMessage(), (Object)t);
                    return false;
                }
            }
        }, source.isBuiltin()));
    }
}


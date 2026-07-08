/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
 *  net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
 *  net.minecraft.item.ItemGroup
 *  net.minecraft.item.ItemGroup$StackVisibility
 *  net.minecraft.item.ItemGroup$Builder
 *  net.minecraft.item.ItemStack
 *  net.minecraft.registry.RegistryKey
 */
package backported.updates.foundation.common.fabric;

import backported.updates.foundation.common.CreativeTabs;
import java.util.List;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;

public class CreativeTabsImpl {
    public static ItemGroup create(Consumer<ItemGroup.Builder> consumer) {
        ItemGroup.Builder builder = FabricItemGroup.builder();
        consumer.accept(builder);
        return builder.build();
    }

    public static void modify(RegistryKey<ItemGroup> key, CreativeTabs.Modifier modifier) {
        ItemGroupEvents.modifyEntriesEvent(key).register(entries -> modifier.accept(entries.getEnabledFeatures(), new CreativeTabs.Output(){

            @Override
            public void addAfter(ItemStack target, ItemStack stack, ItemGroup.StackVisibility visibility) {
                if (target.isEmpty()) {
                    entries.add(stack, visibility);
                } else {
                    entries.addAfter(target, List.of(stack), visibility);
                }
            }

            @Override
            public void addBefore(ItemStack target, ItemStack stack, ItemGroup.StackVisibility visibility) {
                if (target.isEmpty()) {
                    entries.add(stack, visibility);
                } else {
                    entries.addBefore(target, List.of(stack), visibility);
                }
            }
        }, entries.shouldShowOpRestrictedItems()));
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemGroup
 *  net.minecraft.item.ItemGroup$Entries
 *  net.minecraft.item.ItemGroup$Row
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.text.Text
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.client.registries;

import backported.updates.content.client.api.tabs.BundledTabs;
import backported.updates.content.client.registries.ModBundledTabs;
import backported.updates.foundation.core.CoreRegistry;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ItemConvertible;
import net.minecraft.text.Text;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryKeys;

public interface ModCreativeTabs {
    public static final CoreRegistry<ItemGroup> TABS = CoreRegistry.create(RegistryKeys.ITEM_GROUP, "vanillabackport");
    public static final Supplier<ItemGroup> VANILLA_BACKPORT = TABS.register("vanilla_backport", () -> ItemGroup.create((ItemGroup.Row)ItemGroup.Row.TOP, (int)3).displayName((Text)Text.literal((String)"Vanilla Backport")).icon(() -> new ItemStack((ItemConvertible)Items.BUNDLE)).entries((parameters, output) -> {
        RegistryWrapper.WrapperLookup provider = parameters.lookup();
        List<BundledTabs> tabs = ModBundledTabs.getTabs();
        tabs.forEach(tab -> tab.populate(provider));
        tabs.stream().flatMap(tab -> tab.getDisplayItems().stream()).forEach(arg_0 -> ((ItemGroup.Entries)output).add(arg_0));
    }).build());
}


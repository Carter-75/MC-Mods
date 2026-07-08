/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1761
 *  net.minecraft.class_1761$class_7704
 *  net.minecraft.class_1761$class_7915
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_2561
 *  net.minecraft.class_7225$class_7874
 *  net.minecraft.class_7924
 */
package backported.updates.content.client.registries;

import backported.updates.content.client.api.tabs.BundledTabs;
import backported.updates.content.client.registries.ModBundledTabs;
import backported.updates.foundation.core.CoreRegistry;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.class_1761;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2561;
import net.minecraft.class_7225;
import net.minecraft.class_7924;

public interface ModCreativeTabs {
    public static final CoreRegistry<class_1761> TABS = CoreRegistry.create(class_7924.field_44688, "vanillabackport");
    public static final Supplier<class_1761> VANILLA_BACKPORT = TABS.register("vanilla_backport", () -> class_1761.method_47307((class_1761.class_7915)class_1761.class_7915.field_41049, (int)3).method_47321((class_2561)class_2561.method_43470((String)"Vanilla Backport")).method_47320(() -> new class_1799((class_1935)class_1802.field_27023)).method_47317((parameters, output) -> {
        class_7225.class_7874 provider = parameters.comp_1253();
        List<BundledTabs> tabs = ModBundledTabs.getTabs();
        tabs.forEach(tab -> tab.populate(provider));
        tabs.stream().flatMap(tab -> tab.getDisplayItems().stream()).forEach(arg_0 -> ((class_1761.class_7704)output).method_45420(arg_0));
    }).method_47324());
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
 *  net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
 *  net.minecraft.class_1761
 *  net.minecraft.class_1761$class_7705
 *  net.minecraft.class_1761$class_7913
 *  net.minecraft.class_1799
 *  net.minecraft.class_5321
 */
package backported.updates.foundation.common.fabric;

import backported.updates.foundation.common.CreativeTabs;
import java.util.List;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.class_1761;
import net.minecraft.class_1799;
import net.minecraft.class_5321;

public class CreativeTabsImpl {
    public static class_1761 create(Consumer<class_1761.class_7913> consumer) {
        class_1761.class_7913 builder = FabricItemGroup.builder();
        consumer.accept(builder);
        return builder.method_47324();
    }

    public static void modify(class_5321<class_1761> key, CreativeTabs.Modifier modifier) {
        ItemGroupEvents.modifyEntriesEvent(key).register(entries -> modifier.accept(entries.getEnabledFeatures(), new CreativeTabs.Output(){

            @Override
            public void addAfter(class_1799 target, class_1799 stack, class_1761.class_7705 visibility) {
                if (target.method_7960()) {
                    entries.method_45417(stack, visibility);
                } else {
                    entries.addAfter(target, List.of(stack), visibility);
                }
            }

            @Override
            public void addBefore(class_1799 target, class_1799 stack, class_1761.class_7705 visibility) {
                if (target.method_7960()) {
                    entries.method_45417(stack, visibility);
                } else {
                    entries.addBefore(target, List.of(stack), visibility);
                }
            }
        }, entries.shouldShowOpRestrictedItems()));
    }
}


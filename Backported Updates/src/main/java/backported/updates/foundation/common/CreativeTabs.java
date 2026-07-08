/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.item.ItemGroup
 *  net.minecraft.item.ItemGroup$Entries
 *  net.minecraft.item.ItemGroup$StackVisibility
 *  net.minecraft.item.ItemGroup$Builder
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.resource.featuretoggle.FeatureSet
 */
package backported.updates.foundation.common;

import backported.updates.foundation.common.fabric.CreativeTabsImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.RegistryKey;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CreativeTabs {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static ItemGroup create(Consumer<ItemGroup.Builder> consumer) {
        return CreativeTabsImpl.create(consumer);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void modify(RegistryKey<ItemGroup> key, Modifier modifier) {
        CreativeTabsImpl.modify(key, modifier);
    }

    public static interface Output
    extends ItemGroup.Entries {
        default public void add(ItemStack stack, ItemGroup.StackVisibility tabVisibility) {
            this.addAfter(ItemStack.EMPTY, stack, tabVisibility);
        }

        public void addAfter(ItemStack var1, ItemStack var2, ItemGroup.StackVisibility var3);

        default public void addAfter(ItemStack target, ItemStack stack) {
            this.addAfter(target, stack, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
        }

        default public void addAfter(ItemConvertible target, ItemConvertible stack) {
            this.addAfter(target.asItem().getDefaultStack(), stack.asItem().getDefaultStack(), ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
        }

        default public void addAllAfter(ItemStack target, Collection<ItemStack> stacks, ItemGroup.StackVisibility visibility) {
            List<ItemStack> list = List.copyOf(stacks);
            for (int i = list.size() - 1; i >= 0; --i) {
                this.addAfter(target, list.get(i), visibility);
            }
        }

        default public void addAllAfter(ItemStack target, Collection<ItemStack> stacks) {
            List<ItemStack> list = List.copyOf(stacks);
            for (int i = list.size() - 1; i >= 0; --i) {
                this.addAfter(target, list.get(i));
            }
        }

        default public void addAllAfter(ItemConvertible target, Collection<ItemConvertible> stacks) {
            List<ItemConvertible> list = List.copyOf(stacks);
            for (int i = list.size() - 1; i >= 0; --i) {
                this.addAfter(target, list.get(i));
            }
        }

        public void addBefore(ItemStack var1, ItemStack var2, ItemGroup.StackVisibility var3);

        default public void addBefore(ItemStack target, ItemStack stack) {
            this.addBefore(target, stack, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
        }

        default public void addBefore(ItemConvertible target, ItemConvertible stack) {
            this.addBefore(target.asItem().getDefaultStack(), stack.asItem().getDefaultStack(), ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
        }

        default public void addAllBefore(ItemStack target, Collection<ItemStack> stacks, ItemGroup.StackVisibility visibility) {
            List<ItemStack> list = List.copyOf(stacks);
            for (int i = list.size() - 1; i >= 0; --i) {
                this.addBefore(target, list.get(i), visibility);
            }
        }

        default public void addAllBefore(ItemStack target, Collection<ItemStack> stacks) {
            List<ItemStack> list = List.copyOf(stacks);
            for (int i = list.size() - 1; i >= 0; --i) {
                this.addBefore(target, list.get(i));
            }
        }

        default public void addAllBefore(ItemConvertible target, Collection<ItemConvertible> stacks) {
            List<ItemConvertible> list = List.copyOf(stacks);
            for (int i = list.size() - 1; i >= 0; --i) {
                this.addBefore(target, list.get(i));
            }
        }
    }

    public static interface Modifier {
        public void accept(FeatureSet var1, Output var2, boolean var3);
    }
}


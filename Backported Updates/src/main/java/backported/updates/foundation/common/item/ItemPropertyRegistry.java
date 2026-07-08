/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.client.item.ModelPredicateProvider
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.item.ModelPredicateProviderRegistry
 *  net.minecraft.client.item.ClampedModelPredicateProvider
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.foundation.common.item;

import backported.updates.foundation.common.item.fabric.ItemPropertyRegistryImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.client.item.ModelPredicateProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.item.ClampedModelPredicateProvider;
import org.jetbrains.annotations.Nullable;

public class ItemPropertyRegistry {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static ClampedModelPredicateProvider registerGeneric(Identifier name, ClampedModelPredicateProvider property) {
        return ItemPropertyRegistryImpl.registerGeneric(name, property);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static ModelPredicateProvider registerGeneric(Identifier name, ModelPredicateProvider property) {
        return ItemPropertyRegistryImpl.registerGeneric(name, property);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerCustomModelData(ModelPredicateProvider property) {
        ItemPropertyRegistryImpl.registerCustomModelData(property);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void register(Item item, Identifier name, ClampedModelPredicateProvider property) {
        ItemPropertyRegistryImpl.register(item, name, property);
    }

    @Nullable
    public static ModelPredicateProvider getProperty(Item item, Identifier name) {
        return ModelPredicateProviderRegistry.get((ItemStack)new ItemStack((ItemConvertible)item), name);
    }
}


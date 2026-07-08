/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.client.item.ModelPredicateProvider
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.item.ModelPredicateProviderRegistry
 *  net.minecraft.client.item.ClampedModelPredicateProvider
 */
package backported.updates.foundation.common.item.fabric;

import backported_updates.mixin.foundation.access.ItemPropertiesAccessor;
import net.minecraft.item.Item;
import net.minecraft.client.item.ModelPredicateProvider;
import net.minecraft.util.Identifier;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.item.ClampedModelPredicateProvider;

public class ItemPropertyRegistryImpl {
    public static ClampedModelPredicateProvider registerGeneric(Identifier name, ClampedModelPredicateProvider property) {
        return ModelPredicateProviderRegistry.register(name, (ClampedModelPredicateProvider)property);
    }

    public static ModelPredicateProvider registerGeneric(Identifier name, ModelPredicateProvider property) {
        ItemPropertiesAccessor.getGLOBAL().put(name, property);
        return property;
    }

    public static void registerCustomModelData(ModelPredicateProvider property) {
        ModelPredicateProviderRegistry.registerCustomModelData((ModelPredicateProvider)property);
    }

    public static void register(Item item, Identifier name, ClampedModelPredicateProvider property) {
        ModelPredicateProviderRegistry.register((Item)item, name, (ClampedModelPredicateProvider)property);
    }
}


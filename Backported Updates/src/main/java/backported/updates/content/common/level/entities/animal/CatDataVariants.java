/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 */
package backported.updates.content.common.level.entities.animal;

import backported.updates.content.common.api.variant.ClientAsset;
import backported.updates.content.common.api.variant.spawn.SpawnPrioritySelectors;
import backported.updates.content.common.level.entities.animal.CatDataVariant;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;

public class CatDataVariants {
    public static final BuiltInCoreRegistry<CatDataVariant> REGISTRY = ModBuiltinRegistries.CAT_VARIANTS;

    private static RegistryKey<CatDataVariant> register(String key) {
        return CatDataVariants.register(key, SpawnPrioritySelectors.fallback(0));
    }

    private static RegistryKey<CatDataVariant> register(String key, SpawnPrioritySelectors selectors) {
        Identifier texture = Identifier.ofVanilla((String)("entity/cat/" + key));
        return REGISTRY.resource(key, new CatDataVariant(new ClientAsset(texture), selectors));
    }
}


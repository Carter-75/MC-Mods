/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.tag.TagKey
 */
package backported.updates.content.common.level.entities.animal;

import backported.updates.content.common.api.variant.ClientAsset;
import backported.updates.content.common.api.variant.spawn.SpawnPrioritySelectors;
import backported.updates.content.common.api.variant.spawn.check.raw.RawBiomeCheck;
import backported.updates.content.common.level.entities.animal.FrogDataVariant;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;

public class FrogDataVariants {
    public static final BuiltInCoreRegistry<FrogDataVariant> REGISTRY = ModBuiltinRegistries.FROG_VARIANTS;

    private static RegistryKey<FrogDataVariant> register(String key, TagKey<Biome> biome) {
        return FrogDataVariants.register(key, SpawnPrioritySelectors.single(new RawBiomeCheck(biome), 1));
    }

    private static RegistryKey<FrogDataVariant> register(String key, SpawnPrioritySelectors selectors) {
        Identifier texture = Identifier.ofVanilla((String)("entity/frog/" + key + "_frog"));
        return REGISTRY.resource(key, new FrogDataVariant(new ClientAsset(texture), selectors));
    }
}


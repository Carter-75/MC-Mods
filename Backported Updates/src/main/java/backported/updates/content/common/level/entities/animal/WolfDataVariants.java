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
import backported.updates.content.common.level.entities.animal.WolfDataVariant;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;

public class WolfDataVariants {
    public static final BuiltInCoreRegistry<WolfDataVariant> REGISTRY = ModBuiltinRegistries.WOLF_VARIANTS;

    private static RegistryKey<WolfDataVariant> register(String key, String assetId, TagKey<Biome> tag) {
        return WolfDataVariants.register(key, assetId, SpawnPrioritySelectors.single(new RawBiomeCheck(tag), 1));
    }

    private static RegistryKey<WolfDataVariant> register(String key, String assetId, SpawnPrioritySelectors selectors) {
        Identifier wild = Identifier.ofVanilla((String)("entity/wolf/" + assetId));
        Identifier tame = Identifier.ofVanilla((String)("entity/wolf/" + assetId + "_tame"));
        Identifier angry = Identifier.ofVanilla((String)("entity/wolf/" + assetId + "_angry"));
        return REGISTRY.resource(key, new WolfDataVariant(new WolfDataVariant.AssetInfo(new ClientAsset(wild), new ClientAsset(tame), new ClientAsset(angry)), selectors));
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.world.gen.feature.PlacedFeature
 *  net.minecraft.registry.RegistryEntryLookup
 *  net.minecraft.registry.Registerable
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.worldgen.biomes.TheGardenAwakensBiomes;
import backported.updates.foundation.common.worldgen.WorldGenRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;

public class ModBiomes {
    public static final WorldGenRegistry<Biome> BIOMES = WorldGenRegistry.of(RegistryKeys.BIOME, "minecraft");
    public static final RegistryKey<Biome> PALE_GARDEN = BIOMES.create("pale_garden");

    public static void bootstrap(Registerable<Biome> context) {
        RegistryEntryLookup features = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntryLookup carvers = context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
        context.register(PALE_GARDEN, TheGardenAwakensBiomes.paleGarden((RegistryEntryLookup<PlacedFeature>)features, carvers));
    }
}


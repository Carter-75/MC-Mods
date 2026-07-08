/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.registry.Registry
 *  net.minecraft.util.Identifier
 *  net.minecraft.world.gen.feature.ConfiguredFeature
 *  net.minecraft.world.gen.feature.Feature
 *  net.minecraft.world.gen.feature.FeatureConfig
 *  net.minecraft.world.gen.feature.DefaultFeatureConfig
 *  net.minecraft.util.math.noise.DoublePerlinNoiseSampler$NoiseParameters
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.world.gen.feature.PlacedFeature
 *  net.minecraft.world.gen.placementmodifier.PlacementModifier
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.Registerable
 */
package backported.updates.foundation.common.worldgen;

import java.util.List;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.Registerable;

public class WorldGenRegistry<T> {
    protected final String modId;
    protected final RegistryKey<? extends Registry<T>> registry;

    private WorldGenRegistry(RegistryKey<? extends Registry<T>> registry, String modId) {
        this.registry = registry;
        this.modId = modId;
    }

    public static <T> WorldGenRegistry<T> of(RegistryKey<? extends Registry<T>> registry, String modId) {
        return new WorldGenRegistry<T>(registry, modId);
    }

    public RegistryKey<T> create(String name) {
        return RegistryKey.of(this.registry, Identifier.of((String)this.modId, (String)name));
    }

    public void register(Registerable<T> context, RegistryKey<T> key, T entry) {
        context.register(key, entry);
    }

    public <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature(feature, configuration));
    }

    public void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, Feature<DefaultFeatureConfig> feature) {
        this.register(context, key, feature, FeatureConfig.DEFAULT);
    }

    public void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placements) {
        context.register(key, new PlacedFeature(feature, List.copyOf(placements)));
    }

    public void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> feature, PlacementModifier ... placements) {
        this.register(context, key, feature, List.of(placements));
    }

    public void register(Registerable<DoublePerlinNoiseSampler.NoiseParameters> context, RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> key, int firstOctave, double firstAmplitude, double ... amplitudes) {
        context.register(key, new DoublePerlinNoiseSampler.NoiseParameters(firstOctave, firstAmplitude, amplitudes));
    }

    public void register() {
    }
}


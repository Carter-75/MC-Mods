/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil$NoiseHypercube
 *  net.minecraft.world.biome.source.util.MultiNoiseUtil$ParameterRange
 */
package backported.updates.foundation.common.worldgen.placement;

import backported.updates.foundation.common.worldgen.placement.Placement;
import backported.updates.foundation.common.worldgen.placement.parameters.Depth;
import backported.updates.foundation.common.worldgen.placement.parameters.Weirdness;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import java.util.List;
import net.minecraft.world.biome.Biome;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;

public class BiomeSpawnPlacement {
    public static final List<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> BIOME_ENTRIES = Lists.newArrayList();

    public static void add(Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>> mapper) {
        BIOME_ENTRIES.add(mapper);
    }

    public static void addBiome(MultiNoiseUtil.ParameterRange temperature, MultiNoiseUtil.ParameterRange humidity, MultiNoiseUtil.ParameterRange continentalness, MultiNoiseUtil.ParameterRange erosion, MultiNoiseUtil.ParameterRange depth, MultiNoiseUtil.ParameterRange weirdness, float offset, RegistryKey<Biome> key) {
        BiomeSpawnPlacement.add((Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>)Pair.of(MultiNoiseUtil.createNoiseHypercube((MultiNoiseUtil.ParameterRange)temperature, (MultiNoiseUtil.ParameterRange)humidity, (MultiNoiseUtil.ParameterRange)continentalness, (MultiNoiseUtil.ParameterRange)erosion, (MultiNoiseUtil.ParameterRange)depth, (MultiNoiseUtil.ParameterRange)weirdness, (float)offset), key));
    }

    public static void addSurfaceBiome(MultiNoiseUtil.ParameterRange temperature, MultiNoiseUtil.ParameterRange humidity, MultiNoiseUtil.ParameterRange continentalness, MultiNoiseUtil.ParameterRange erosion, MultiNoiseUtil.ParameterRange weirdness, float offset, RegistryKey<Biome> key) {
        BiomeSpawnPlacement.addBiome(temperature, humidity, continentalness, erosion, Depth.SURFACE.parameter(), weirdness, offset, key);
        BiomeSpawnPlacement.addBiome(temperature, humidity, continentalness, erosion, Depth.FLOOR.parameter(), weirdness, offset, key);
    }

    public static void addUndergroundBiome(MultiNoiseUtil.ParameterRange temperature, MultiNoiseUtil.ParameterRange humidity, MultiNoiseUtil.ParameterRange continentalness, MultiNoiseUtil.ParameterRange erosion, MultiNoiseUtil.ParameterRange weirdness, float offset, RegistryKey<Biome> key) {
        BiomeSpawnPlacement.addBiome(temperature, humidity, continentalness, erosion, Depth.UNDERGROUND.parameter(), weirdness, offset, key);
    }

    public static void addBottomBiome(MultiNoiseUtil.ParameterRange temperature, MultiNoiseUtil.ParameterRange humidity, MultiNoiseUtil.ParameterRange continentalness, MultiNoiseUtil.ParameterRange erosion, MultiNoiseUtil.ParameterRange weirdness, float offset, RegistryKey<Biome> key) {
        BiomeSpawnPlacement.addBiome(temperature, humidity, continentalness, erosion, Depth.FLOOR.parameter(), weirdness, offset, key);
    }

    public static void addSurfaceBiome(Placement placement, MultiNoiseUtil.ParameterRange temperature, MultiNoiseUtil.ParameterRange humidity, MultiNoiseUtil.ParameterRange continentalness, MultiNoiseUtil.ParameterRange erosion, float offset, RegistryKey<Biome> key) {
        for (Weirdness weirdness : placement.getWeirdnesses()) {
            BiomeSpawnPlacement.addSurfaceBiome(temperature, humidity, continentalness, erosion, weirdness.parameter(), offset, key);
        }
    }
}


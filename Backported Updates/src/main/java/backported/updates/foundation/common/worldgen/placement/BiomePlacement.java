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
import java.util.function.Consumer;
import net.minecraft.world.biome.Biome;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;

public class BiomePlacement {
    public static final List<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> BIOME_PLACEMENTS = Lists.newArrayList();

    public static void registerBiomePlacements(Consumer<Event> listener) {
        listener.accept(BIOME_PLACEMENTS::add);
    }

    public static interface Event {
        public void add(Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>> var1);

        default public void addBiome(MultiNoiseUtil.ParameterRange temperature, MultiNoiseUtil.ParameterRange humidity, MultiNoiseUtil.ParameterRange continentalness, MultiNoiseUtil.ParameterRange erosion, MultiNoiseUtil.ParameterRange depth, MultiNoiseUtil.ParameterRange weirdness, float offset, RegistryKey<Biome> biome) {
            this.add((Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>)Pair.of(MultiNoiseUtil.createNoiseHypercube((MultiNoiseUtil.ParameterRange)temperature, (MultiNoiseUtil.ParameterRange)humidity, (MultiNoiseUtil.ParameterRange)continentalness, (MultiNoiseUtil.ParameterRange)erosion, (MultiNoiseUtil.ParameterRange)depth, (MultiNoiseUtil.ParameterRange)weirdness, (float)MultiNoiseUtil.toLong((float)offset)), biome));
        }

        default public void addSurfaceBiome(MultiNoiseUtil.ParameterRange temperature, MultiNoiseUtil.ParameterRange humidity, MultiNoiseUtil.ParameterRange continentalness, MultiNoiseUtil.ParameterRange erosion, MultiNoiseUtil.ParameterRange weirdness, float offset, RegistryKey<Biome> biome) {
            this.addBiome(temperature, humidity, continentalness, erosion, Depth.SURFACE.parameter(), weirdness, offset, biome);
            this.addBiome(temperature, humidity, continentalness, erosion, Depth.FLOOR.parameter(), weirdness, offset, biome);
        }

        default public void addUndergroundBiome(MultiNoiseUtil.ParameterRange temperature, MultiNoiseUtil.ParameterRange humidity, MultiNoiseUtil.ParameterRange continentalness, MultiNoiseUtil.ParameterRange erosion, MultiNoiseUtil.ParameterRange weirdness, float offset, RegistryKey<Biome> biome) {
            this.addBiome(temperature, humidity, continentalness, erosion, Depth.UNDERGROUND.parameter(), weirdness, offset, biome);
        }

        default public void addBottomBiome(MultiNoiseUtil.ParameterRange temperature, MultiNoiseUtil.ParameterRange humidity, MultiNoiseUtil.ParameterRange continentalness, MultiNoiseUtil.ParameterRange erosion, MultiNoiseUtil.ParameterRange weirdness, float offset, RegistryKey<Biome> biome) {
            this.addBiome(temperature, humidity, continentalness, erosion, Depth.FLOOR.parameter(), weirdness, offset, biome);
        }

        default public void addSurfaceBiome(Placement placement, MultiNoiseUtil.ParameterRange temperature, MultiNoiseUtil.ParameterRange humidity, MultiNoiseUtil.ParameterRange continentalness, MultiNoiseUtil.ParameterRange erosion, float offset, RegistryKey<Biome> biome) {
            for (Weirdness weirdness : placement.getWeirdnesses()) {
                this.addSurfaceBiome(temperature, humidity, continentalness, erosion, weirdness.parameter(), offset, biome);
            }
        }
    }
}


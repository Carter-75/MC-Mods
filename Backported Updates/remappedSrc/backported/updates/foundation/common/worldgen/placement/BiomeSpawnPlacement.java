/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.class_1959
 *  net.minecraft.class_5321
 *  net.minecraft.class_6544
 *  net.minecraft.class_6544$class_4762
 *  net.minecraft.class_6544$class_6546
 */
package backported.updates.foundation.common.worldgen.placement;

import backported.updates.foundation.common.worldgen.placement.Placement;
import backported.updates.foundation.common.worldgen.placement.parameters.Depth;
import backported.updates.foundation.common.worldgen.placement.parameters.Weirdness;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import java.util.List;
import net.minecraft.class_1959;
import net.minecraft.class_5321;
import net.minecraft.class_6544;

public class BiomeSpawnPlacement {
    public static final List<Pair<class_6544.class_4762, class_5321<class_1959>>> BIOME_ENTRIES = Lists.newArrayList();

    public static void add(Pair<class_6544.class_4762, class_5321<class_1959>> mapper) {
        BIOME_ENTRIES.add(mapper);
    }

    public static void addBiome(class_6544.class_6546 temperature, class_6544.class_6546 humidity, class_6544.class_6546 continentalness, class_6544.class_6546 erosion, class_6544.class_6546 depth, class_6544.class_6546 weirdness, float offset, class_5321<class_1959> key) {
        BiomeSpawnPlacement.add((Pair<class_6544.class_4762, class_5321<class_1959>>)Pair.of((Object)class_6544.method_38118((class_6544.class_6546)temperature, (class_6544.class_6546)humidity, (class_6544.class_6546)continentalness, (class_6544.class_6546)erosion, (class_6544.class_6546)depth, (class_6544.class_6546)weirdness, (float)offset), key));
    }

    public static void addSurfaceBiome(class_6544.class_6546 temperature, class_6544.class_6546 humidity, class_6544.class_6546 continentalness, class_6544.class_6546 erosion, class_6544.class_6546 weirdness, float offset, class_5321<class_1959> key) {
        BiomeSpawnPlacement.addBiome(temperature, humidity, continentalness, erosion, Depth.SURFACE.parameter(), weirdness, offset, key);
        BiomeSpawnPlacement.addBiome(temperature, humidity, continentalness, erosion, Depth.FLOOR.parameter(), weirdness, offset, key);
    }

    public static void addUndergroundBiome(class_6544.class_6546 temperature, class_6544.class_6546 humidity, class_6544.class_6546 continentalness, class_6544.class_6546 erosion, class_6544.class_6546 weirdness, float offset, class_5321<class_1959> key) {
        BiomeSpawnPlacement.addBiome(temperature, humidity, continentalness, erosion, Depth.UNDERGROUND.parameter(), weirdness, offset, key);
    }

    public static void addBottomBiome(class_6544.class_6546 temperature, class_6544.class_6546 humidity, class_6544.class_6546 continentalness, class_6544.class_6546 erosion, class_6544.class_6546 weirdness, float offset, class_5321<class_1959> key) {
        BiomeSpawnPlacement.addBiome(temperature, humidity, continentalness, erosion, Depth.FLOOR.parameter(), weirdness, offset, key);
    }

    public static void addSurfaceBiome(Placement placement, class_6544.class_6546 temperature, class_6544.class_6546 humidity, class_6544.class_6546 continentalness, class_6544.class_6546 erosion, float offset, class_5321<class_1959> key) {
        for (Weirdness weirdness : placement.getWeirdnesses()) {
            BiomeSpawnPlacement.addSurfaceBiome(temperature, humidity, continentalness, erosion, weirdness.parameter(), offset, key);
        }
    }
}


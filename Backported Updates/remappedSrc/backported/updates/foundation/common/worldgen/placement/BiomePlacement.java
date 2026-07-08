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
import java.util.function.Consumer;
import net.minecraft.class_1959;
import net.minecraft.class_5321;
import net.minecraft.class_6544;

public class BiomePlacement {
    public static final List<Pair<class_6544.class_4762, class_5321<class_1959>>> BIOME_PLACEMENTS = Lists.newArrayList();

    public static void registerBiomePlacements(Consumer<Event> listener) {
        listener.accept(BIOME_PLACEMENTS::add);
    }

    public static interface Event {
        public void add(Pair<class_6544.class_4762, class_5321<class_1959>> var1);

        default public void addBiome(class_6544.class_6546 temperature, class_6544.class_6546 humidity, class_6544.class_6546 continentalness, class_6544.class_6546 erosion, class_6544.class_6546 depth, class_6544.class_6546 weirdness, float offset, class_5321<class_1959> biome) {
            this.add((Pair<class_6544.class_4762, class_5321<class_1959>>)Pair.of((Object)class_6544.method_38118((class_6544.class_6546)temperature, (class_6544.class_6546)humidity, (class_6544.class_6546)continentalness, (class_6544.class_6546)erosion, (class_6544.class_6546)depth, (class_6544.class_6546)weirdness, (float)class_6544.method_38665((float)offset)), biome));
        }

        default public void addSurfaceBiome(class_6544.class_6546 temperature, class_6544.class_6546 humidity, class_6544.class_6546 continentalness, class_6544.class_6546 erosion, class_6544.class_6546 weirdness, float offset, class_5321<class_1959> biome) {
            this.addBiome(temperature, humidity, continentalness, erosion, Depth.SURFACE.parameter(), weirdness, offset, biome);
            this.addBiome(temperature, humidity, continentalness, erosion, Depth.FLOOR.parameter(), weirdness, offset, biome);
        }

        default public void addUndergroundBiome(class_6544.class_6546 temperature, class_6544.class_6546 humidity, class_6544.class_6546 continentalness, class_6544.class_6546 erosion, class_6544.class_6546 weirdness, float offset, class_5321<class_1959> biome) {
            this.addBiome(temperature, humidity, continentalness, erosion, Depth.UNDERGROUND.parameter(), weirdness, offset, biome);
        }

        default public void addBottomBiome(class_6544.class_6546 temperature, class_6544.class_6546 humidity, class_6544.class_6546 continentalness, class_6544.class_6546 erosion, class_6544.class_6546 weirdness, float offset, class_5321<class_1959> biome) {
            this.addBiome(temperature, humidity, continentalness, erosion, Depth.FLOOR.parameter(), weirdness, offset, biome);
        }

        default public void addSurfaceBiome(Placement placement, class_6544.class_6546 temperature, class_6544.class_6546 humidity, class_6544.class_6546 continentalness, class_6544.class_6546 erosion, float offset, class_5321<class_1959> biome) {
            for (Weirdness weirdness : placement.getWeirdnesses()) {
                this.addSurfaceBiome(temperature, humidity, continentalness, erosion, weirdness.parameter(), offset, biome);
            }
        }
    }
}


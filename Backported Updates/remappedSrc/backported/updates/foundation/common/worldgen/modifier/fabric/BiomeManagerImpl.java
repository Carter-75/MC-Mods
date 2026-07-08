/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.biome.v1.BiomeModificationContext
 *  net.fabricmc.fabric.api.biome.v1.BiomeModifications
 *  net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext
 *  net.fabricmc.fabric.api.biome.v1.ModificationPhase
 *  net.minecraft.class_1299
 *  net.minecraft.class_1311
 *  net.minecraft.class_1959
 *  net.minecraft.class_2893$class_2894
 *  net.minecraft.class_2893$class_2895
 *  net.minecraft.class_2922
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_5483$class_1964
 *  net.minecraft.class_6796
 *  net.minecraft.class_6862
 */
package backported.updates.foundation.common.worldgen.modifier.fabric;

import backported.updates.foundation.common.worldgen.modifier.BiomeContext;
import backported.updates.foundation.common.worldgen.modifier.BiomeManager;
import backported.updates.foundation.common.worldgen.modifier.BiomeWriter;
import java.util.function.Predicate;
import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_1959;
import net.minecraft.class_2893;
import net.minecraft.class_2922;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_5483;
import net.minecraft.class_6796;
import net.minecraft.class_6862;

public class BiomeManagerImpl {
    public static void bootstrap() {
        BiomeModifications.create((class_2960)class_2960.method_60655((String)"platform", (String)"biome_modifier")).add(ModificationPhase.ADDITIONS, context -> true, (selector, modifier) -> BiomeManager.INSTANCE.register(new FabricBiomeWriter((BiomeSelectionContext)selector, (BiomeModificationContext)modifier)));
    }

    static class FabricBiomeWriter
    extends BiomeWriter {
        private final BiomeSelectionContext selector;
        private final BiomeModificationContext modifier;

        FabricBiomeWriter(BiomeSelectionContext selector, BiomeModificationContext modifier) {
            this.selector = selector;
            this.modifier = modifier;
        }

        @Override
        public class_2960 name() {
            return this.selector.getBiomeKey().method_29177();
        }

        @Override
        public BiomeContext context() {
            return new BiomeContext(){

                @Override
                public class_5321<class_1959> resource() {
                    return selector.getBiomeKey();
                }

                @Override
                public class_1959 biome() {
                    return selector.getBiome();
                }

                @Override
                public boolean is(class_6862<class_1959> tag) {
                    return selector.hasTag(tag);
                }

                @Override
                public boolean is(class_5321<class_1959> biome) {
                    return this.resource() == biome;
                }

                @Override
                public boolean is(Predicate<BiomeContext> context) {
                    return context.test(this);
                }

                @Override
                public boolean hasFeature(class_5321<class_6796> feature) {
                    return selector.hasPlacedFeature(feature);
                }
            };
        }

        @Override
        public void addFeature(class_2893.class_2895 decoration, class_5321<class_6796> feature) {
            this.modifier.getGenerationSettings().addFeature(decoration, feature);
        }

        @Override
        public void removeFeature(class_2893.class_2895 decoration, class_5321<class_6796> feature) {
            this.modifier.getGenerationSettings().removeFeature(decoration, feature);
        }

        @Override
        public void addSpawn(class_1311 category, class_5483.class_1964 data) {
            this.modifier.getSpawnSettings().addSpawn(category, data);
        }

        @Override
        public void removeSpawn(class_1299<?> entity) {
            this.modifier.getSpawnSettings().removeSpawnsOfEntityType(entity);
        }

        @Override
        public void addCarver(class_2893.class_2894 carving, class_5321<class_2922<?>> carver) {
            this.modifier.getGenerationSettings().addCarver(carving, carver);
        }

        @Override
        public void removeCarver(class_2893.class_2894 carving, class_5321<class_2922<?>> carver) {
            this.modifier.getGenerationSettings().removeCarver(carving, carver);
        }
    }
}


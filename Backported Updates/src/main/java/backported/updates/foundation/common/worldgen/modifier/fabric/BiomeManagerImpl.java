/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.biome.v1.BiomeModificationContext
 *  net.fabricmc.fabric.api.biome.v1.BiomeModifications
 *  net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext
 *  net.fabricmc.fabric.api.biome.v1.ModificationPhase
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.SpawnGroup
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.world.gen.GenerationStep$Carver
 *  net.minecraft.world.gen.GenerationStep$Feature
 *  net.minecraft.world.gen.carver.ConfiguredCarver
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.world.biome.SpawnSettings$SpawnEntry
 *  net.minecraft.world.gen.feature.PlacedFeature
 *  net.minecraft.registry.tag.TagKey
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
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.registry.tag.TagKey;

public class BiomeManagerImpl {
    public static void bootstrap() {
        BiomeModifications.create(Identifier.of((String)"platform", (String)"biome_modifier")).add(ModificationPhase.ADDITIONS, context -> true, (selector, modifier) -> BiomeManager.INSTANCE.register(new FabricBiomeWriter((BiomeSelectionContext)selector, (BiomeModificationContext)modifier)));
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
        public Identifier name() {
            return this.selector.getBiomeKey().getValue();
        }

        @Override
        public BiomeContext context() {
            return new BiomeContext(){

                @Override
                public RegistryKey<Biome> resource() {
                    return selector.getBiomeKey();
                }

                @Override
                public Biome biome() {
                    return selector.getBiome();
                }

                @Override
                public boolean is(TagKey<Biome> tag) {
                    return selector.hasTag(tag);
                }

                @Override
                public boolean is(RegistryKey<Biome> biome) {
                    return this.resource() == biome;
                }

                @Override
                public boolean is(Predicate<BiomeContext> context) {
                    return context.test(this);
                }

                @Override
                public boolean hasFeature(RegistryKey<PlacedFeature> feature) {
                    return selector.hasPlacedFeature(feature);
                }
            };
        }

        @Override
        public void addFeature(GenerationStep.Feature decoration, RegistryKey<PlacedFeature> feature) {
            this.modifier.getGenerationSettings().addFeature(decoration, feature);
        }

        @Override
        public void removeFeature(GenerationStep.Feature decoration, RegistryKey<PlacedFeature> feature) {
            this.modifier.getGenerationSettings().removeFeature(decoration, feature);
        }

        @Override
        public void addSpawn(SpawnGroup category, SpawnSettings.SpawnEntry data) {
            this.modifier.getSpawnSettings().addSpawn(category, data);
        }

        @Override
        public void removeSpawn(EntityType<?> entity) {
            this.modifier.getSpawnSettings().removeSpawnsOfEntityType(entity);
        }

        @Override
        public void addCarver(GenerationStep.Carver carving, RegistryKey<ConfiguredCarver<?>> carver) {
            this.modifier.getGenerationSettings().addCarver(carving, carver);
        }

        @Override
        public void removeCarver(GenerationStep.Carver carving, RegistryKey<ConfiguredCarver<?>> carver) {
            this.modifier.getGenerationSettings().removeCarver(carving, carver);
        }
    }
}


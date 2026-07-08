/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.world.biome.Biome$Builder
 *  net.minecraft.world.gen.GenerationStep$Feature
 *  net.minecraft.world.gen.carver.ConfiguredCarver
 *  net.minecraft.world.gen.feature.DefaultBiomeFeatures
 *  net.minecraft.world.biome.BiomeEffects$Builder
 *  net.minecraft.sound.BiomeMoodSound
 *  net.minecraft.world.biome.SpawnSettings$Builder
 *  net.minecraft.world.biome.GenerationSettings$LookupBackedBuilder
 *  net.minecraft.world.gen.feature.PlacedFeature
 *  net.minecraft.registry.RegistryEntryLookup
 */
package backported.updates.content.common.worldgen.biomes;

import backported.updates.content.common.worldgen.placements.TheGardenAwakensPlacements;
import backported_updates.mixin.access.OverworldBiomesAccessor;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.registry.RegistryEntryLookup;

public class TheGardenAwakensBiomes {
    public static Biome paleGarden(RegistryEntryLookup<PlacedFeature> features, RegistryEntryLookup<ConfiguredCarver<?>> carvers) {
        SpawnSettings.Builder spawns = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addBatsAndMonsters((SpawnSettings.Builder)spawns);
        GenerationSettings.LookupBackedBuilder generation = new GenerationSettings.LookupBackedBuilder(features, carvers);
        OverworldBiomesAccessor.callAddBasicFeatures(generation);
        generation.feature(GenerationStep.Feature.VEGETAL_DECORATION, TheGardenAwakensPlacements.PALE_GARDEN_VEGETATION);
        generation.feature(GenerationStep.Feature.VEGETAL_DECORATION, TheGardenAwakensPlacements.PALE_MOSS_PATCH);
        generation.feature(GenerationStep.Feature.VEGETAL_DECORATION, TheGardenAwakensPlacements.PALE_GARDEN_FLOWERS);
        DefaultBiomeFeatures.addDefaultOres((GenerationSettings.LookupBackedBuilder)generation);
        DefaultBiomeFeatures.addDefaultDisks((GenerationSettings.LookupBackedBuilder)generation);
        generation.feature(GenerationStep.Feature.VEGETAL_DECORATION, TheGardenAwakensPlacements.FLOWER_PALE_GARDEN);
        DefaultBiomeFeatures.addForestGrass((GenerationSettings.LookupBackedBuilder)generation);
        DefaultBiomeFeatures.addDefaultVegetation((GenerationSettings.LookupBackedBuilder)generation);
        return new Biome.Builder().precipitation(true).temperature(0.7f).downfall(0.8f).effects(new BiomeEffects.Builder().waterColor(7768221).waterFogColor(5597568).fogColor(8484720).skyColor(0xB9B9B9).grassColor(0x778272).foliageColor(8883574).moodSound(BiomeMoodSound.CAVE).build()).spawnSettings(spawns.build()).generationSettings(generation.build()).build();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.world.gen.feature.ConfiguredFeature
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.world.gen.placementmodifier.SquarePlacementModifier
 *  net.minecraft.world.gen.placementmodifier.HeightmapPlacementModifier
 *  net.minecraft.world.gen.placementmodifier.SurfaceWaterDepthFilterPlacementModifier
 *  net.minecraft.world.gen.placementmodifier.BiomePlacementModifier
 *  net.minecraft.world.gen.placementmodifier.CountPlacementModifier
 *  net.minecraft.world.gen.feature.PlacedFeature
 *  net.minecraft.world.gen.placementmodifier.PlacementModifier
 *  net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier
 *  net.minecraft.world.gen.feature.PlacedFeatures
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.RegistryEntryLookup
 *  net.minecraft.registry.Registerable
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.common.worldgen.placements;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.worldgen.features.TheGardenAwakensFeatures;
import backported.updates.foundation.common.worldgen.WorldGenRegistry;
import net.minecraft.block.Block;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightmapPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SurfaceWaterDepthFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;

public class TheGardenAwakensPlacements {
    public static final WorldGenRegistry<PlacedFeature> FEATURES = WorldGenRegistry.of(RegistryKeys.PLACED_FEATURE, "backported_updates");
    public static final RegistryKey<PlacedFeature> PALE_OAK_CHECKED = FEATURES.create("pale_oak_checked");
    public static final RegistryKey<PlacedFeature> PALE_OAK_CREAKING_CHECKED = FEATURES.create("pale_oak_creaking_checked");
    public static final RegistryKey<PlacedFeature> FLOWER_PALE_GARDEN = FEATURES.create("flower_pale_garden");
    public static final RegistryKey<PlacedFeature> PALE_GARDEN_VEGETATION = FEATURES.create("pale_garden_vegetation");
    public static final RegistryKey<PlacedFeature> PALE_GARDEN_FLOWERS = FEATURES.create("pale_garden_flowers");
    public static final RegistryKey<PlacedFeature> PALE_MOSS_PATCH = FEATURES.create("pale_moss_patch");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup features = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        FEATURES.register(context, PALE_OAK_CHECKED, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(TheGardenAwakensFeatures.PALE_OAK), new PlacementModifier[]{PlacedFeatures.wouldSurvive((Block)ModBlocks.PALE_OAK_SAPLING.get())});
        FEATURES.register(context, PALE_OAK_CREAKING_CHECKED, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(TheGardenAwakensFeatures.PALE_OAK_CREAKING), new PlacementModifier[]{PlacedFeatures.wouldSurvive((Block)ModBlocks.PALE_OAK_SAPLING.get())});
        FEATURES.register(context, FLOWER_PALE_GARDEN, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(TheGardenAwakensFeatures.FLOWER_PALE_GARDEN), new PlacementModifier[]{RarityFilterPlacementModifier.of((int)32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});
        FEATURES.register(context, PALE_GARDEN_VEGETATION, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(TheGardenAwakensFeatures.PALE_GARDEN_VEGETATION), new PlacementModifier[]{CountPlacementModifier.of((int)16), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of((int)0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of()});
        FEATURES.register(context, PALE_GARDEN_FLOWERS, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(TheGardenAwakensFeatures.PALE_GARDEN_FLOWERS), new PlacementModifier[]{RarityFilterPlacementModifier.of((int)8), SquarePlacementModifier.of(), HeightmapPlacementModifier.of((Heightmap.Type)Heightmap.Type.MOTION_BLOCKING_NO_LEAVES), BiomePlacementModifier.of()});
        FEATURES.register(context, PALE_MOSS_PATCH, (RegistryEntry<ConfiguredFeature<?, ?>>)features.getOrThrow(TheGardenAwakensFeatures.PALE_MOSS_PATCH), new PlacementModifier[]{CountPlacementModifier.of((int)1), SquarePlacementModifier.of(), HeightmapPlacementModifier.of((Heightmap.Type)Heightmap.Type.MOTION_BLOCKING_NO_LEAVES), BiomePlacementModifier.of()});
    }
}


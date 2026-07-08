/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider$Entries
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.world.gen.feature.PlacedFeature
 *  net.minecraft.registry.RegistryWrapper$Impl
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.data.server.builder;

import backported.updates.content.common.worldgen.placements.SpringToLifePlacements;
import backported.updates.content.common.worldgen.placements.TheGardenAwakensPlacements;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryKeys;

public class PlacedFeatureGenerator
extends FabricDynamicRegistryProvider {
    public PlacedFeatureGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup provider, FabricDynamicRegistryProvider.Entries entries) {
        this.add(provider, entries, TheGardenAwakensPlacements.PALE_OAK_CHECKED);
        this.add(provider, entries, TheGardenAwakensPlacements.PALE_OAK_CREAKING_CHECKED);
        this.add(provider, entries, TheGardenAwakensPlacements.FLOWER_PALE_GARDEN);
        this.add(provider, entries, TheGardenAwakensPlacements.PALE_GARDEN_VEGETATION);
        this.add(provider, entries, TheGardenAwakensPlacements.PALE_GARDEN_FLOWERS);
        this.add(provider, entries, TheGardenAwakensPlacements.PALE_MOSS_PATCH);
        this.add(provider, entries, SpringToLifePlacements.PATCH_BUSH);
        this.add(provider, entries, SpringToLifePlacements.PATCH_FIREFLY_BUSH_NEAR_WATER);
        this.add(provider, entries, SpringToLifePlacements.PATCH_FIREFLY_BUSH_NEAR_WATER_SWAMP);
        this.add(provider, entries, SpringToLifePlacements.PATCH_FIREFLY_BUSH_SWAMP);
        this.add(provider, entries, SpringToLifePlacements.WILDFLOWERS_BIRCH_FOREST);
        this.add(provider, entries, SpringToLifePlacements.WILDFLOWERS_MEADOW);
        this.add(provider, entries, SpringToLifePlacements.PATCH_DRY_GRASS_BADLANDS);
        this.add(provider, entries, SpringToLifePlacements.PATCH_DRY_GRASS_DESERT);
        this.add(provider, entries, SpringToLifePlacements.PATCH_LEAF_LITTER);
        this.add(provider, entries, SpringToLifePlacements.LEAF_LITTER);
        this.add(provider, entries, SpringToLifePlacements.CACTUS_FLOWER);
        this.add(provider, entries, SpringToLifePlacements.FALLEN_OAK_TREE);
        this.add(provider, entries, SpringToLifePlacements.FALLEN_BIRCH_TREE);
        this.add(provider, entries, SpringToLifePlacements.FALLEN_SUPER_BIRCH_TREE);
        this.add(provider, entries, SpringToLifePlacements.FALLEN_JUNGLE_TREE);
        this.add(provider, entries, SpringToLifePlacements.FALLEN_SPRUCE_TREE);
        this.add(provider, entries, SpringToLifePlacements.PLACED_FALLEN_OAK_TREE);
        this.add(provider, entries, SpringToLifePlacements.PLACED_RARE_FALLEN_BIRCH_TREE);
        this.add(provider, entries, SpringToLifePlacements.PLACED_FALLEN_BIRCH_TREE);
        this.add(provider, entries, SpringToLifePlacements.PLACED_FALLEN_SUPER_BIRCH_TREE);
        this.add(provider, entries, SpringToLifePlacements.PLACED_FALLEN_JUNGLE_TREE);
        this.add(provider, entries, SpringToLifePlacements.PLACED_FALLEN_SPRUCE_TREE);
        this.add(provider, entries, SpringToLifePlacements.PLACED_RARE_FALLEN_SPRUCE_TREE);
    }

    private void add(RegistryWrapper.WrapperLookup provider, FabricDynamicRegistryProvider.Entries entries, RegistryKey<PlacedFeature> key) {
        RegistryWrapper.Impl registry = provider.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE);
        entries.add(key, ((PlacedFeature)registry.getOrThrow(key).value()));
    }

    public String getName() {
        return "worldgen/placed_feature";
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider$Entries
 *  net.minecraft.class_5321
 *  net.minecraft.class_6796
 *  net.minecraft.class_7225$class_7226
 *  net.minecraft.class_7225$class_7874
 *  net.minecraft.class_7924
 */
package backported.updates.content.data.server.builder;

import backported.updates.content.common.worldgen.placements.SpringToLifePlacements;
import backported.updates.content.common.worldgen.placements.TheGardenAwakensPlacements;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.class_5321;
import net.minecraft.class_6796;
import net.minecraft.class_7225;
import net.minecraft.class_7924;

public class PlacedFeatureGenerator
extends FabricDynamicRegistryProvider {
    public PlacedFeatureGenerator(FabricDataOutput output, CompletableFuture<class_7225.class_7874> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void configure(class_7225.class_7874 provider, FabricDynamicRegistryProvider.Entries entries) {
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

    private void add(class_7225.class_7874 provider, FabricDynamicRegistryProvider.Entries entries, class_5321<class_6796> key) {
        class_7225.class_7226 registry = provider.method_46762(class_7924.field_41245);
        entries.add(key, (Object)((class_6796)registry.method_46747(key).comp_349()));
    }

    public String method_10321() {
        return "worldgen/placed_feature";
    }
}


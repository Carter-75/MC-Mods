/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider$Entries
 *  net.minecraft.class_2975
 *  net.minecraft.class_5321
 *  net.minecraft.class_7225$class_7226
 *  net.minecraft.class_7225$class_7874
 *  net.minecraft.class_7924
 */
package backported.updates.content.data.server.builder;

import backported.updates.content.common.worldgen.features.SpringToLifeFeatures;
import backported.updates.content.common.worldgen.features.TheGardenAwakensFeatures;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.class_2975;
import net.minecraft.class_5321;
import net.minecraft.class_7225;
import net.minecraft.class_7924;

public class ConfiguredFeatureGenerator
extends FabricDynamicRegistryProvider {
    public ConfiguredFeatureGenerator(FabricDataOutput output, CompletableFuture<class_7225.class_7874> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void configure(class_7225.class_7874 provider, FabricDynamicRegistryProvider.Entries entries) {
        this.add(provider, entries, TheGardenAwakensFeatures.PALE_OAK);
        this.add(provider, entries, TheGardenAwakensFeatures.PALE_OAK_BONEMEAL);
        this.add(provider, entries, TheGardenAwakensFeatures.PALE_OAK_CREAKING);
        this.add(provider, entries, TheGardenAwakensFeatures.FLOWER_PALE_GARDEN);
        this.add(provider, entries, TheGardenAwakensFeatures.PALE_GARDEN_FLOWERS);
        this.add(provider, entries, TheGardenAwakensFeatures.PALE_GARDEN_VEGETATION);
        this.add(provider, entries, TheGardenAwakensFeatures.PALE_MOSS_VEGETATION);
        this.add(provider, entries, TheGardenAwakensFeatures.PALE_MOSS_PATCH);
        this.add(provider, entries, TheGardenAwakensFeatures.PALE_MOSS_PATCH_BONEMEAL);
        this.add(provider, entries, SpringToLifeFeatures.PATCH_BUSH);
        this.add(provider, entries, SpringToLifeFeatures.PATCH_FIREFLY_BUSH);
        this.add(provider, entries, SpringToLifeFeatures.WILDFLOWERS_BIRCH_FOREST);
        this.add(provider, entries, SpringToLifeFeatures.WILDFLOWERS_MEADOW);
        this.add(provider, entries, SpringToLifeFeatures.PATCH_DRY_GRASS);
        this.add(provider, entries, SpringToLifeFeatures.PATCH_LEAF_LITTER);
        this.add(provider, entries, SpringToLifeFeatures.LEAF_LITTER);
        this.add(provider, entries, SpringToLifeFeatures.CACTUS_FLOWER);
        this.add(provider, entries, SpringToLifeFeatures.FALLEN_OAK_TREE);
        this.add(provider, entries, SpringToLifeFeatures.FALLEN_BIRCH_TREE);
        this.add(provider, entries, SpringToLifeFeatures.FALLEN_SUPER_BIRCH_TREE);
        this.add(provider, entries, SpringToLifeFeatures.FALLEN_JUNGLE_TREE);
        this.add(provider, entries, SpringToLifeFeatures.FALLEN_SPRUCE_TREE);
    }

    private void add(class_7225.class_7874 provider, FabricDynamicRegistryProvider.Entries entries, class_5321<class_2975<?, ?>> key) {
        class_7225.class_7226 registry = provider.method_46762(class_7924.field_41239);
        entries.add(key, (Object)((class_2975)registry.method_46747(key).comp_349()));
    }

    public String method_10321() {
        return "worldgen/configured_feature";
    }
}


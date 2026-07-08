/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider$Entries
 *  net.minecraft.world.gen.feature.ConfiguredFeature
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.RegistryWrapper$Impl
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.data.server.builder;

import backported.updates.content.common.worldgen.features.SpringToLifeFeatures;
import backported.updates.content.common.worldgen.features.TheGardenAwakensFeatures;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryKeys;

public class ConfiguredFeatureGenerator
extends FabricDynamicRegistryProvider {
    public ConfiguredFeatureGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup provider, FabricDynamicRegistryProvider.Entries entries) {
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

    private void add(RegistryWrapper.WrapperLookup provider, FabricDynamicRegistryProvider.Entries entries, RegistryKey<ConfiguredFeature<?, ?>> key) {
        RegistryWrapper.Impl registry = provider.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE);
        entries.add(key, ((ConfiguredFeature)registry.getOrThrow(key).value()));
    }

    public String getName() {
        return "worldgen/configured_feature";
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator$Pack
 *  net.minecraft.registry.RegistryBuilder
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.data;

import backported.updates.content.common.registries.ModBiomes;
import backported.updates.content.common.registries.ModJukeboxSongs;
import backported.updates.content.common.registries.ModPaintingVariants;
import backported.updates.content.common.registries.ModTrimMaterials;
import backported.updates.content.common.worldgen.features.SpringToLifeFeatures;
import backported.updates.content.common.worldgen.features.TheGardenAwakensFeatures;
import backported.updates.content.common.worldgen.placements.SpringToLifePlacements;
import backported.updates.content.common.worldgen.placements.TheGardenAwakensPlacements;
import backported.updates.content.data.client.LangGenerator;
import backported.updates.content.data.client.ModelGenerator;
import backported.updates.content.data.client.colors.LeafColorGenerator;
import backported.updates.content.data.server.builder.BiomeGenerator;
import backported.updates.content.data.server.builder.ConfiguredFeatureGenerator;
import backported.updates.content.data.server.builder.JukeboxSongGenerator;
import backported.updates.content.data.server.builder.PaintVariantsGenerator;
import backported.updates.content.data.server.builder.PlacedFeatureGenerator;
import backported.updates.content.data.server.builder.TrimMaterialGenerator;
import backported.updates.content.data.server.loot.BlockLootGenerator;
import backported.updates.content.data.server.loot.GiftLootGenerator;
import backported.updates.content.data.server.recipe.RecipeGenerator;
import backported.updates.content.data.server.tags.BiomeTagGenerator;
import backported.updates.content.data.server.tags.BlockTagGenerator;
import backported.updates.content.data.server.tags.EntityTypeTagGenerator;
import backported.updates.content.data.server.tags.ItemTagGenerator;
import backported.updates.content.data.server.tags.PaintingVariantTagGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class DataGenerator
implements DataGeneratorEntrypoint {
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(ModelGenerator::new);
        pack.addProvider(LangGenerator::new);
        pack.addProvider(LeafColorGenerator::new);
        pack.addProvider(BlockLootGenerator::new);
        pack.addProvider(GiftLootGenerator::new);
        pack.addProvider(RecipeGenerator::new);
        pack.addProvider(BiomeTagGenerator::new);
        pack.addProvider(BlockTagGenerator::new);
        pack.addProvider(ItemTagGenerator::new);
        pack.addProvider(EntityTypeTagGenerator::new);
        pack.addProvider(PaintingVariantTagGenerator::new);
        pack.addProvider(PaintVariantsGenerator::new);
        pack.addProvider(TrimMaterialGenerator::new);
        pack.addProvider(BiomeGenerator::new);
        pack.addProvider(ConfiguredFeatureGenerator::new);
        pack.addProvider(PlacedFeatureGenerator::new);
        pack.addProvider(JukeboxSongGenerator::new);
    }

    public void buildRegistry(RegistryBuilder builder) {
        builder.addRegistry(RegistryKeys.PAINTING_VARIANT, ModPaintingVariants::bootstrap);
        builder.addRegistry(RegistryKeys.TRIM_MATERIAL, ModTrimMaterials::bootstrap);
        builder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootstrap);
        builder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, TheGardenAwakensFeatures::bootstrap);
        builder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, SpringToLifeFeatures::bootstrap);
        builder.addRegistry(RegistryKeys.PLACED_FEATURE, TheGardenAwakensPlacements::bootstrap);
        builder.addRegistry(RegistryKeys.PLACED_FEATURE, SpringToLifePlacements::bootstrap);
        builder.addRegistry(RegistryKeys.JUKEBOX_SONG, ModJukeboxSongs::bootstrap);
    }
}


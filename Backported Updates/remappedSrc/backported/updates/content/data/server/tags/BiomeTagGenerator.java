/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
 *  net.minecraft.class_1959
 *  net.minecraft.class_1972
 *  net.minecraft.class_5321
 *  net.minecraft.class_6908
 *  net.minecraft.class_7225$class_7874
 *  net.minecraft.class_7924
 */
package backported.updates.content.data.server.tags;

import backported.updates.content.common.registries.ModBiomes;
import backported.updates.content.core.data.tags.ModBiomeTags;
import backported.updates.content.core.data.tags.fabric.FabricBiomeTags;
import backported.updates.content.core.data.tags.forge.ForgeBiomeTags;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.class_1959;
import net.minecraft.class_1972;
import net.minecraft.class_5321;
import net.minecraft.class_6908;
import net.minecraft.class_7225;
import net.minecraft.class_7924;

public class BiomeTagGenerator
extends FabricTagProvider<class_1959> {
    public BiomeTagGenerator(FabricDataOutput output, CompletableFuture<class_7225.class_7874> lookupProvider) {
        super(output, class_7924.field_41236, lookupProvider);
    }

    protected void method_10514(class_7225.class_7874 provider) {
        this.addEntityPlacementTags(provider);
        this.addFeaturePlacementTags(provider);
        this.getOrCreateTagBuilder(class_6908.field_36517).add(ModBiomes.PALE_GARDEN);
        this.getOrCreateTagBuilder(class_6908.field_37393).add(ModBiomes.PALE_GARDEN);
        this.getOrCreateTagBuilder(class_6908.field_36501).add(ModBiomes.PALE_GARDEN);
        this.getOrCreateTagBuilder(class_6908.field_37395).add(ModBiomes.PALE_GARDEN);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS).add(class_1972.field_35117).add(class_1972.field_9453).add(class_1972.field_35115).add(class_1972.field_34474).add(class_1972.field_34472).add(class_1972.field_9435).add(class_1972.field_9418).add(class_1972.field_34471).add(class_1972.field_37543).add(class_1972.field_9463).add(class_1972.field_9454).add(class_1972.field_9478).add(class_1972.field_9467).add(class_1972.field_9470).add(class_1972.field_35119).add(class_1972.field_35113).add(class_1972.field_9420).add(class_1972.field_35120).add(class_1972.field_35111).add(class_1972.field_34475).forceAddTag(class_6908.field_37394).addOptionalTag(ForgeBiomeTags.IS_COLD).addOptionalTag(ForgeBiomeTags.IS_SNOWY).addOptionalTag(FabricBiomeTags.CLIMATE_COLD).addOptionalTag(FabricBiomeTags.SNOWY).addOptionalTag(FabricBiomeTags.ICY);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS).add(class_1972.field_9424).add(class_1972.field_9408).add(class_1972.field_38748).add(class_1972.field_9439).add(class_1972.field_9441).forceAddTag(class_6908.field_36518).forceAddTag(class_6908.field_37392).forceAddTag(class_6908.field_36516).forceAddTag(class_6908.field_36513).addOptionalTag(ForgeBiomeTags.IS_HOT).addOptionalTag(FabricBiomeTags.CLIMATE_HOT);
    }

    protected void addEntityPlacementTags(class_7225.class_7874 provider) {
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_CAMELS).addOptionalTag(FabricBiomeTags.DESERT).addOptionalTag(ForgeBiomeTags.IS_DESERT);
    }

    protected void addFeaturePlacementTags(class_7225.class_7874 provider) {
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_BUSHES).forceAddTag(class_6908.field_36514).forceAddTag(class_6908.field_36511).add(class_1972.field_9409).add(class_1972.field_9412).add(class_1972.field_35112).addOptionalTag(ForgeBiomeTags.IS_PLAINS).addOptionalTag(FabricBiomeTags.PLAINS);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FIREFLY_BUSHES).forceAddTag(class_6908.field_36510).forceAddTag(class_6908.field_36511).forceAddTag(class_6908.field_36515).forceAddTag(class_6908.field_36517).forceAddTag(class_6908.field_36509).forceAddTag(class_6908.field_37392).forceAddTag(class_6908.field_36514).forceAddTag(class_6908.field_36516).forceAddTag(class_6908.field_36513).addOptionalTag(ForgeBiomeTags.IS_PLAINS).addOptionalTag(FabricBiomeTags.PLAINS).addOptionalTag(ForgeBiomeTags.IS_MUSHROOM).addOptionalTag(FabricBiomeTags.MUSHROOM).add(class_1972.field_38748);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FIREFLY_BUSHES_SWAMP).addOptionalTag(ForgeBiomeTags.IS_SWAMP).addOptionalTag(FabricBiomeTags.SWAMP);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_WILDFLOWERS).add(class_1972.field_9412).add(class_1972.field_35112).addOptionalTag(FabricBiomeTags.BIRCH_FOREST);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_NOISE_BASED_WILDFLOWERS).add(class_1972.field_34470);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_DRY_GRASS).addOptionalTag(FabricBiomeTags.DESERT).addOptionalTag(ForgeBiomeTags.IS_DESERT);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_DRY_GRASS_RARELY).forceAddTag(class_6908.field_36513);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FALLEN_OAK_TREES).add(class_1972.field_9475).forceAddTag(class_6908.field_36513).forceAddTag(class_6908.field_37392).forceAddTag(class_6908.field_36514).add(class_1972.field_9409).add(class_1972.field_9414).addOptionalTag(FabricBiomeTags.PLAINS).addOptionalTag(ForgeBiomeTags.IS_PLAINS);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FALLEN_BIRCH_TREES_RARELY).forceAddTag(class_6908.field_36517);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FALLEN_BIRCH_TREES).add(class_1972.field_9412).add(class_1972.field_35112).addOptionalTag(FabricBiomeTags.BIRCH_FOREST);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FALLEN_SUPER_BIRCH_TREES).add(class_1972.field_35112);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FALLEN_JUNGLE_TREES).forceAddTag(class_6908.field_36516);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FALLEN_SPRUCE_TREES).forceAddTag(class_6908.field_36515);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_FALLEN_SPRUCE_TREES_RARELY).forceAddTag(class_6908.field_36514);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_LEAF_LITTER_PATCHES).add(class_1972.field_9475);
        this.getOrCreateTagBuilder(ModBiomeTags.SPAWNS_LEAF_LITTER).add(new class_5321[]{class_1972.field_9409, class_1972.field_9475, class_1972.field_35110});
        this.getOrCreateTagBuilder(ModBiomeTags.HAS_DARK_LEAF_LITTER).add(new class_5321[]{class_1972.field_9475, class_1972.field_9471, class_1972.field_38748});
        this.getOrCreateTagBuilder(ModBiomeTags.HAS_PALE_LEAF_LITTER).add(ModBiomes.PALE_GARDEN);
    }
}


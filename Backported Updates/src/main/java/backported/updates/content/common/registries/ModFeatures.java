/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.world.gen.feature.Feature
 *  net.minecraft.world.gen.feature.DefaultFeatureConfig
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.level.features.CactusFlowerFeature;
import backported.updates.content.common.level.features.FallenTreeConfiguration;
import backported.updates.content.common.level.features.FallenTreeFeature;
import backported.updates.content.common.level.features.LeafLitterFeature;
import backported.updates.foundation.core.CoreRegistry;
import com.mojang.serialization.Codec;
import java.util.function.Supplier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.registry.RegistryKeys;

public class ModFeatures {
    public static final CoreRegistry<Feature<?>> FEATURES = CoreRegistry.create(RegistryKeys.FEATURE, "minecraft");
    public static final Supplier<Feature<FallenTreeConfiguration>> FALLEN_TREE = FEATURES.register("fallen_tree", () -> new FallenTreeFeature(FallenTreeConfiguration.CODEC));
    public static final Supplier<Feature<DefaultFeatureConfig>> LEAF_LITTER = FEATURES.register("leaf_litter", () -> new LeafLitterFeature((Codec<DefaultFeatureConfig>)DefaultFeatureConfig.CODEC));
    public static final Supplier<Feature<DefaultFeatureConfig>> CACTUS_FLOWER = FEATURES.register("cactus_flower", () -> new CactusFlowerFeature((Codec<DefaultFeatureConfig>)DefaultFeatureConfig.CODEC));
}


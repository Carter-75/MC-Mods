/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.logging.LogUtils
 *  net.minecraft.util.Identifier
 *  org.slf4j.Logger
 */
package backported.updates.content.core;

import backported.updates.content.client.ClientConfig;
import backported.updates.content.client.ClientSetup;
import backported.updates.content.client.registries.ModCreativeTabs;
import backported.updates.content.client.registries.ModParticles;
import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.client.registries.ModSoundTypes;
import backported.updates.content.common.CommonConfig;
import backported.updates.content.common.CommonSetup;
import backported.updates.content.common.api.variant.spawn.SpawnConditions;
import backported.updates.content.common.level.entities.animal.CatDataVariants;
import backported.updates.content.common.level.entities.animal.ChickenVariants;
import backported.updates.content.common.level.entities.animal.CowVariants;
import backported.updates.content.common.level.entities.animal.FrogDataVariants;
import backported.updates.content.common.level.entities.animal.PigVariants;
import backported.updates.content.common.level.entities.animal.WolfDataVariants;
import backported.updates.content.common.registries.ModBiomes;
import backported.updates.content.common.registries.ModBlockEntities;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModDataComponents;
import backported.updates.content.common.registries.ModEntities;
import backported.updates.content.common.registries.ModFeatures;
import backported.updates.content.common.registries.ModItems;
import backported.updates.content.common.registries.ModRecipeSerializers;
import backported.updates.content.common.registries.ModSensorTypes;
import backported.updates.content.common.registries.ModTreeDecorators;
import backported.updates.content.common.worldgen.features.SpringToLifeFeatures;
import backported.updates.content.common.worldgen.features.TheGardenAwakensFeatures;
import backported.updates.content.common.worldgen.placements.SpringToLifePlacements;
import backported.updates.content.common.worldgen.placements.TheGardenAwakensPlacements;
import backported.updates.content.core.data.DataTransformation;
import backported.updates.content.core.data.tags.ModBiomeTags;
import backported.updates.content.core.data.tags.ModBlockTags;
import backported.updates.content.core.data.tags.ModEntityTypeTags;
import backported.updates.content.core.data.tags.ModItemTags;
import backported.updates.content.core.network.ServerboundSelectBundleItemPacket;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.core.Environment;
import backported.updates.foundation.core.ModInstance;
import backported.updates.foundation.core.networking.Networking;
import backported.updates.foundation.core.util.config.ConfigLoader;
import backported.updates.foundation.core.util.config.ModConfig;
import com.mojang.logging.LogUtils;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

public final class VanillaBackport {
    public static final String MOD_ID = "vanillabackport";
    public static final String NAMESPACE = "minecraft";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final ClientConfig CLIENT_CONFIG = Environment.registerSafeConfig("vanillabackport", ModConfig.Type.CLIENT, ClientConfig::new);
    public static final CommonConfig COMMON_CONFIG = Environment.registerSafeConfig("vanillabackport", ModConfig.Type.COMMON, CommonConfig::new);
    public static final ModInstance INSTANCE = ModInstance.create("vanillabackport").client(ClientSetup::setup).postClient(ClientSetup::asyncSetup).common(CommonSetup::setup).postCommon(CommonSetup::asyncSetup).build();

    public static void bootstrap() {
        INSTANCE.bootstrap();
        ConfigLoader.bootstrap();
        ModBlockTags.TAGS.register();
        ModItemTags.TAGS.register();
        ModBiomeTags.TAGS.register();
        ModEntityTypeTags.TAGS.register();
        ModParticles.PARTICLES.register();
        ModDataComponents.COMPONENTS.register();
        ModBlocks.BLOCKS.register();
        ModItems.ITEMS.register();
        ModBlockEntities.BLOCK_ENTITIES.register();
        ModEntities.ENTITIES.register();
        ModSensorTypes.SENSOR_TYPES.register();
        ModSoundEvents.SOUNDS.register();
        ModSoundTypes.SOUNDS.register();
        ModRecipeSerializers.SERIALIZERS.register();
        ModCreativeTabs.TABS.register();
        ModBuiltinRegistries.WOLF_SOUND_VARIANTS.register();
        CowVariants.REGISTRY.register();
        ChickenVariants.REGISTRY.register();
        PigVariants.REGISTRY.register();
        WolfDataVariants.REGISTRY.register();
        CatDataVariants.REGISTRY.register();
        FrogDataVariants.REGISTRY.register();
        SpawnConditions.CONDITIONS.register();
        ModBiomes.BIOMES.register();
        ModFeatures.FEATURES.register();
        ModTreeDecorators.DECORATORS.register();
        SpringToLifeFeatures.FEATURES.register();
        TheGardenAwakensFeatures.FEATURES.register();
        SpringToLifePlacements.FEATURES.register();
        TheGardenAwakensPlacements.FEATURES.register();
        Networking.register(registrar -> registrar.registerToServer(ServerboundSelectBundleItemPacket.TYPE, ServerboundSelectBundleItemPacket.STREAM_CODEC, ServerboundSelectBundleItemPacket::handler));
        DataTransformation.bootstrap();
    }

    public static Identifier resource(String path) {
        return Identifier.of((String)MOD_ID, (String)path);
    }

    public static Identifier vanilla(String path) {
        return Identifier.ofVanilla((String)path);
    }
}


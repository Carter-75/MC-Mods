/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ModInitializer
 *  net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry
 *  net.fabricmc.fabric.api.registry.StrippableBlockRegistry
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.class_1291
 *  net.minecraft.class_1294
 *  net.minecraft.class_1299
 *  net.minecraft.class_1299$class_1300
 *  net.minecraft.class_1311
 *  net.minecraft.class_1761
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1826
 *  net.minecraft.class_1935
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2269
 *  net.minecraft.class_2323
 *  net.minecraft.class_2349
 *  net.minecraft.class_2354
 *  net.minecraft.class_2378
 *  net.minecraft.class_2397
 *  net.minecraft.class_2440
 *  net.minecraft.class_2465
 *  net.minecraft.class_2473
 *  net.minecraft.class_2482
 *  net.minecraft.class_2498
 *  net.minecraft.class_2510
 *  net.minecraft.class_2526
 *  net.minecraft.class_2533
 *  net.minecraft.class_2544
 *  net.minecraft.class_2561
 *  net.minecraft.class_2577
 *  net.minecraft.class_2766
 *  net.minecraft.class_2960
 *  net.minecraft.class_3619
 *  net.minecraft.class_3620
 *  net.minecraft.class_3962
 *  net.minecraft.class_4663
 *  net.minecraft.class_4719
 *  net.minecraft.class_4970
 *  net.minecraft.class_4970$class_2250
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_6880
 *  net.minecraft.class_7923
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package backported.updates.garden;

import backported.updates.garden.ModBlockSetType;
import backported.updates.garden.ModRegistry;
import backported.updates.garden.Util;
import backported.updates.garden.block.ClosedEyeBlossomBlock;
import backported.updates.garden.block.CreakingHeartBlock;
import backported.updates.garden.block.OpenEyeBlossomBlock;
import backported.updates.garden.block.PaleHangingMossBlock;
import backported.updates.garden.block.PaleHangingMossPlantBlock;
import backported.updates.garden.block.PaleMossBlock;
import backported.updates.garden.compat.WilderWildCompat;
import backported.updates.garden.decorator.CreakingHeartDecorator;
import backported.updates.garden.entity.CreakingBlockEntityTypes;
import backported.updates.garden.entity.CreakingEntity;
import backported.updates.garden.feature.pale_moss_ceiling_feature.PaleMossPatchCeilingConfig;
import backported.updates.garden.feature.pale_moss_ceiling_feature.PaleMossPatchCeilingFeature;
import backported.updates.garden.feature.pale_moss_feature.PaleMossPatchConfig;
import backported.updates.garden.feature.pale_moss_feature.PaleMossPatchFeature;
import backported.updates.garden.feature.pale_moss_patch_bonemeal.PaleMossPatchBonemealConfig;
import backported.updates.garden.feature.pale_moss_patch_bonemeal.PaleMossPatchBonemealFeature;
import backported.updates.garden.feature.pale_oak_tree.PaleOakSapling;
import backported.updates.garden.feature.pale_oak_tree.PaleOakTreeFeature;
import backported.updates.garden.feature.pale_oak_tree.PaleOakTreeFeatureConfig;
import backported.updates.garden.feature.pale_short_grass_feature.PaleShortGrassFeature;
import backported.updates.garden.feature.pale_short_grass_feature.PaleShortGrassPatchConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_1291;
import net.minecraft.class_1294;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_1761;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1826;
import net.minecraft.class_1935;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2269;
import net.minecraft.class_2323;
import net.minecraft.class_2349;
import net.minecraft.class_2354;
import net.minecraft.class_2378;
import net.minecraft.class_2397;
import net.minecraft.class_2440;
import net.minecraft.class_2465;
import net.minecraft.class_2473;
import net.minecraft.class_2482;
import net.minecraft.class_2498;
import net.minecraft.class_2510;
import net.minecraft.class_2526;
import net.minecraft.class_2533;
import net.minecraft.class_2544;
import net.minecraft.class_2561;
import net.minecraft.class_2577;
import net.minecraft.class_2766;
import net.minecraft.class_2960;
import net.minecraft.class_3619;
import net.minecraft.class_3620;
import net.minecraft.class_3962;
import net.minecraft.class_4663;
import net.minecraft.class_4719;
import net.minecraft.class_4970;
import net.minecraft.class_5132;
import net.minecraft.class_6880;
import net.minecraft.class_7923;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Init
implements ModInitializer {
    public static final class_1299<CreakingEntity> CREAKING = (class_1299)class_2378.method_10230((class_2378)class_7923.field_41177, (class_2960)class_2960.method_60655((String)"iwie", (String)"creaking"), (Object)class_1299.class_1300.method_5903(CreakingEntity::new, (class_1311)class_1311.field_6302).method_17687(1.0f, 2.9f).method_5905(null));
    public static final Logger LOGGER = LoggerFactory.getLogger((String)"iwie");
    public static final class_2248 PALE_OAK_LOG = Util.createLogBlock(class_3620.field_15986, class_3620.field_15978);
    public static final class_2248 STRIPPED_PALE_OAK_LOG = Util.createLogBlock(class_3620.field_15986, class_3620.field_15978);
    public static final class_2248 PALE_OAK_WOOD = new class_2465(class_4970.class_2251.method_9637().method_31710(class_3620.field_15978).method_51368(class_2766.field_12651).method_9632(2.0f).method_9626(class_2498.field_11547).method_50013());
    public static final class_2248 STRIPPED_PALE_OAK_WOOD = new class_2465(class_4970.class_2251.method_9637().method_31710(class_3620.field_15978).method_51368(class_2766.field_12651).method_9632(2.0f).method_9626(class_2498.field_11547).method_50013());
    public static final class_2248 PALE_SHORT_GRASS = new class_2526(class_4970.class_2251.method_9637().method_31710(class_3620.field_15986).method_51371().method_9634().method_9618().method_9626(class_2498.field_11535).method_49229(class_4970.class_2250.field_10655).method_50013().method_50012(class_3619.field_15971));
    public static final class_2248 PALE_MOSS_BLOCK = new PaleMossBlock(class_4970.class_2251.method_9637().method_31710(class_3620.field_15986).method_9632(0.1f).method_9626(class_2498.field_28697).method_50012(class_3619.field_15971));
    public static final class_2248 PALE_MOSS_CARPET = new class_2577(class_4970.class_2251.method_9637().method_31710(class_3620.field_15986).method_9632(0.1f).method_9626(class_2498.field_28697).method_50012(class_3619.field_15971));
    public static final class_2248 PALE_OAK_PLANKS = new class_2248(class_4970.class_2251.method_9637().method_31710(class_3620.field_15986).method_51368(class_2766.field_12651).method_9629(2.0f, 3.0f).method_9626(class_2498.field_11547).method_50013());
    public static final class_2248 PALE_OAK_STRAIRS = new class_2510(PALE_OAK_PLANKS.method_9564(), class_4970.class_2251.method_9630((class_4970)PALE_OAK_PLANKS));
    public static final class_2248 PALE_OAK_SLAB = new class_2482(class_4970.class_2251.method_9637().method_31710(class_3620.field_15986).method_51368(class_2766.field_12651).method_9629(2.0f, 3.0f).method_9626(class_2498.field_11547).method_50013());
    public static final class_2248 PALE_OAK_FENCE = new class_2354(class_4970.class_2251.method_9637().method_31710(PALE_OAK_PLANKS.method_26403()).method_51369().method_51368(class_2766.field_12651).method_9629(2.0f, 3.0f).method_9626(class_2498.field_11547).method_50013());
    public static final class_2248 PALE_OAK_FENCE_GATE = new class_2349(class_4719.field_21676, class_4970.class_2251.method_9637().method_31710(PALE_OAK_PLANKS.method_26403()).method_51369().method_51368(class_2766.field_12651).method_9629(2.0f, 3.0f).method_50013());
    public static final class_2248 PALE_OAK_SAPLING = new class_2473(PaleOakSapling.PALE, class_4970.class_2251.method_9637().method_31710(class_3620.field_15986).method_9640().method_9634().method_9618().method_9626(class_2498.field_11535).method_49229(class_4970.class_2250.field_10655).method_50013().method_50012(class_3619.field_15971));
    public static final class_2248 PALE_OAK_LEAVES = new class_2397(class_4970.class_2251.method_9637().method_31710(class_3620.field_16004).method_9632(0.2f).method_9640().method_9626(class_2498.field_11535).method_22488().method_26235(class_2246::method_26126).method_26243(class_2246::method_26122).method_26245(class_2246::method_26122).method_50013().method_50012(class_3619.field_15971).method_26236(class_2246::method_26122));
    public static final class_2248 PALE_OAK_BUTTON = new class_2269(ModBlockSetType.PALE, 30, class_4970.class_2251.method_9637().method_9634().method_9632(0.5f).method_50012(class_3619.field_15971));
    public static final class_2248 PALE_OAK_PRESSURE_PLATE = new class_2440(ModBlockSetType.PALE, class_4970.class_2251.method_9637().method_31710(PALE_OAK_PLANKS.method_26403()).method_51369().method_51368(class_2766.field_12651).method_9634().method_9632(0.5f).method_50013().method_50012(class_3619.field_15971));
    public static final class_2248 CREAKING_HEART = new CreakingHeartBlock(class_4970.class_2251.method_9637().method_31710(class_3620.field_15986).method_9632(2.1f).method_9626(class_2498.field_28697));
    public static final class_1792 CREAKING_SPAWN_EGG = new class_1826(CREAKING, 0xC4C4C4, 0xADADAD, new class_1792.class_1793());
    public static final class_2248 CLOSED_EYE_BLOSSOM_BLOCK = new ClosedEyeBlossomBlock((class_6880<class_1291>)class_1294.field_5916, 7.0f, class_4970.class_2251.method_9637().method_31710(class_3620.field_16004).method_9634().method_9618().method_9626(class_2498.field_11535).method_49229(class_4970.class_2250.field_10657).method_50012(class_3619.field_15971).method_9640());
    public static final class_2248 OPEN_EYE_BLOSSOM_BLOCK = new OpenEyeBlossomBlock((class_6880<class_1291>)class_1294.field_5919, 11.0f, class_4970.class_2251.method_9637().method_31710(class_3620.field_25706).method_9634().method_9618().method_9626(class_2498.field_11535).method_49229(class_4970.class_2250.field_10657).method_50012(class_3619.field_15971).method_9640());
    public static final class_2248 PALE_OAK_DOOR = new class_2323(ModBlockSetType.PALE, class_4970.class_2251.method_9637().method_31710(PALE_OAK_PLANKS.method_26403()).method_51368(class_2766.field_12651).method_9632(3.0f).method_22488().method_50013().method_50012(class_3619.field_15971));
    public static final class_2248 PALE_OAK_TRAPDOOR = new class_2533(ModBlockSetType.PALE, class_4970.class_2251.method_9637().method_31710(PALE_OAK_PLANKS.method_26403()).method_51368(class_2766.field_12651).method_9632(3.0f).method_22488().method_26235(class_2246::method_26114).method_50013());
    public static final class_2248 RESIN_BLOCK = new class_2248(class_4970.class_2251.method_9637().method_36557(0.0f));
    public static final class_2248 RESIN_BRICKS = new class_2248(class_4970.class_2251.method_9637().method_36557(1.5f));
    public static final class_2248 CHISELED_RESIN_BRICK = new class_2248(class_4970.class_2251.method_9637().method_36557(1.5f));
    public static final class_2248 RESIN_BRICK_SLAB = new class_2482(class_4970.class_2251.method_9630((class_4970)RESIN_BRICKS).method_36557(1.5f));
    public static final class_2248 RESIN_BRICK_STAIRS = new class_2510(RESIN_BRICKS.method_9564(), class_4970.class_2251.method_9630((class_4970)RESIN_BRICKS).method_36557(1.5f));
    public static final class_2248 RESIN_BRICK_WALL = new class_2544(class_4970.class_2251.method_9630((class_4970)RESIN_BRICKS).method_51369().method_36557(1.5f));
    public static final class_2248 POTTED_PALE_OAK_SAPLING = class_2246.method_50000((class_2248)PALE_OAK_SAPLING);
    public static final class_2248 POTTED_CLOSED_EYE_BLOSSOM = class_2246.method_50000((class_2248)CLOSED_EYE_BLOSSOM_BLOCK);
    public static final class_2248 POTTED_OPEN_EYE_BLOSSOM = class_2246.method_50000((class_2248)OPEN_EYE_BLOSSOM_BLOCK);
    public static final class_1792 RESIN_CLUMP = new class_1792(new class_1792.class_1793());
    public static final class_1792 RESIN_BRICK = new class_1792(new class_1792.class_1793());
    public static final class_2248 PALE_HANGING_MOSS = new PaleHangingMossBlock(class_4970.class_2251.method_9637().method_31710(class_3620.field_15986).method_9632(0.1f).method_9626(class_2498.field_28697).method_50012(class_3619.field_15971));
    public static final class_2248 PALE_HANGING_MOSS_PLANT = new PaleHangingMossPlantBlock(class_4970.class_2251.method_9637().method_31710(class_3620.field_15986).method_9632(0.1f).method_9626(class_2498.field_28697).method_50012(class_3619.field_15971));
    public static final class_2960 PALE_OAK_TREE_FEATURE_ID = class_2960.method_60655((String)"iwie", (String)"pale_oak_tree");
    public static final PaleOakTreeFeature PALE_FEATURE = new PaleOakTreeFeature(PaleOakTreeFeatureConfig.CODEC);
    public static final class_2960 PALE_MOSS_PATCH_FEATURE_ID = class_2960.method_60655((String)"iwie", (String)"pale_moss_patch");
    public static final PaleMossPatchFeature PALE_MOSS_PATCH_FEATURE = new PaleMossPatchFeature(PaleMossPatchConfig.CODEC);
    public static final class_2960 PALE_MOSS_PATCH_CEILING_FEATURE_ID = class_2960.method_60655((String)"iwie", (String)"pale_moss_patch_ceiling");
    public static final PaleMossPatchCeilingFeature PALE_MOSS_PATCH_CEILING_FEATURE = new PaleMossPatchCeilingFeature(PaleMossPatchCeilingConfig.CODEC);
    public static final class_2960 PALE_SHORT_GRASS_PATCH_FEATURE_ID = class_2960.method_60655((String)"iwie", (String)"pale_short_grass_patch");
    public static final PaleShortGrassFeature PALE_SHORT_GRASS_FEATURE = new PaleShortGrassFeature(PaleShortGrassPatchConfig.CODEC);
    public static final class_2960 PALE_MOSS_PATCH_BONEMEAL_FEATURE_ID = class_2960.method_60655((String)"iwie", (String)"pale_moss_patch_bonemeal");
    public static final PaleMossPatchBonemealFeature PALE_MOSS_PATCH_BONEMEAL_FEATURE = new PaleMossPatchBonemealFeature(PaleMossPatchBonemealConfig.CODEC);
    public static final class_4663<CreakingHeartDecorator> CREAKING_HEART_DECORATOR_TREE_DECORATOR_TYPE = new class_4663(CreakingHeartDecorator.CODEC);
    private static final class_1761 IWIE = FabricItemGroup.builder().method_47320(() -> new class_1799((class_1935)PALE_OAK_LOG)).method_47321((class_2561)class_2561.method_43471((String)"itemGroup.iwie.main")).method_47317((context, entries) -> {
        entries.method_45421((class_1935)PALE_OAK_LOG);
        entries.method_45421((class_1935)PALE_SHORT_GRASS);
        entries.method_45421((class_1935)PALE_MOSS_BLOCK);
        entries.method_45421((class_1935)PALE_MOSS_CARPET);
        entries.method_45421((class_1935)PALE_OAK_PLANKS);
        entries.method_45421((class_1935)PALE_OAK_STRAIRS);
        entries.method_45421((class_1935)PALE_OAK_SLAB);
        entries.method_45421((class_1935)PALE_OAK_FENCE);
        entries.method_45421((class_1935)PALE_OAK_FENCE_GATE);
        entries.method_45421((class_1935)PALE_OAK_SAPLING);
        entries.method_45421((class_1935)CLOSED_EYE_BLOSSOM_BLOCK);
        entries.method_45421((class_1935)OPEN_EYE_BLOSSOM_BLOCK);
        entries.method_45421((class_1935)PALE_OAK_DOOR);
        entries.method_45421((class_1935)PALE_OAK_LEAVES);
        entries.method_45421((class_1935)PALE_OAK_BUTTON);
        entries.method_45421((class_1935)PALE_OAK_PRESSURE_PLATE);
        entries.method_45421((class_1935)PALE_HANGING_MOSS);
        entries.method_45421((class_1935)STRIPPED_PALE_OAK_LOG);
        entries.method_45421((class_1935)PALE_OAK_WOOD);
        entries.method_45421((class_1935)STRIPPED_PALE_OAK_WOOD);
        entries.method_45421((class_1935)CREAKING_SPAWN_EGG);
        entries.method_45421((class_1935)CREAKING_HEART);
        entries.method_45421((class_1935)RESIN_BLOCK);
        entries.method_45421((class_1935)RESIN_BRICKS);
        entries.method_45421((class_1935)RESIN_BRICK_SLAB);
        entries.method_45421((class_1935)RESIN_BRICK_STAIRS);
        entries.method_45421((class_1935)RESIN_BRICK_WALL);
        entries.method_45421((class_1935)RESIN_CLUMP);
        entries.method_45421((class_1935)RESIN_BRICK);
    }).method_47324();

    public void onInitialize() {
        LOGGER.info("Initializing items and blocks from 1.22 update!");
        class_2378.method_10230((class_2378)class_7923.field_41144, (class_2960)PALE_OAK_TREE_FEATURE_ID, (Object)((Object)PALE_FEATURE));
        class_2378.method_10230((class_2378)class_7923.field_41144, (class_2960)PALE_MOSS_PATCH_FEATURE_ID, (Object)((Object)PALE_MOSS_PATCH_FEATURE));
        class_2378.method_10230((class_2378)class_7923.field_41144, (class_2960)PALE_MOSS_PATCH_CEILING_FEATURE_ID, (Object)((Object)PALE_MOSS_PATCH_CEILING_FEATURE));
        class_2378.method_10230((class_2378)class_7923.field_41144, (class_2960)PALE_SHORT_GRASS_PATCH_FEATURE_ID, (Object)((Object)PALE_SHORT_GRASS_FEATURE));
        class_2378.method_10230((class_2378)class_7923.field_41144, (class_2960)PALE_MOSS_PATCH_BONEMEAL_FEATURE_ID, (Object)((Object)PALE_MOSS_PATCH_BONEMEAL_FEATURE));
        class_2378.method_10230((class_2378)class_7923.field_41153, (class_2960)class_2960.method_60655((String)"iwie", (String)"creaking_heart"), CREAKING_HEART_DECORATOR_TREE_DECORATOR_TYPE);
        CreakingBlockEntityTypes.initialize();
        ModRegistry.registerBlocks();
        ModRegistry.registerItems();
        ModRegistry.registerFuel();
        class_2378.method_10230((class_2378)class_7923.field_44687, (class_2960)class_2960.method_60655((String)"iwie", (String)"main"), (Object)IWIE);
        class_3962.field_17566.put((Object)PALE_MOSS_BLOCK.method_8389(), 0.65f);
        class_3962.field_17566.put((Object)OPEN_EYE_BLOSSOM_BLOCK.method_8389(), 0.65f);
        class_3962.field_17566.put((Object)CLOSED_EYE_BLOSSOM_BLOCK.method_8389(), 0.65f);
        class_3962.field_17566.put((Object)PALE_MOSS_CARPET.method_8389(), 0.3f);
        class_3962.field_17566.put((Object)PALE_OAK_LEAVES.method_8389(), 0.3f);
        class_3962.field_17566.put((Object)PALE_OAK_SAPLING.method_8389(), 0.3f);
        class_3962.field_17566.put((Object)PALE_SHORT_GRASS.method_8389(), 0.3f);
        class_3962.field_17566.put((Object)PALE_HANGING_MOSS.method_8389(), 0.3f);
        FabricDefaultAttributeRegistry.register(CREAKING, (class_5132.class_5133)CreakingEntity.createMobAttributes());
        if (FabricLoader.getInstance().isModLoaded("wilderwild")) {
            LOGGER.info("Wilder Wild mod is present, initializing compatibility features!");
            WilderWildCompat.init();
        }
        StrippableBlockRegistry.register((class_2248)PALE_OAK_LOG, (class_2248)STRIPPED_PALE_OAK_LOG);
        StrippableBlockRegistry.register((class_2248)PALE_OAK_WOOD, (class_2248)STRIPPED_PALE_OAK_WOOD);
    }
}


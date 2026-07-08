/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ModInitializer
 *  net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry
 *  net.fabricmc.fabric.api.registry.StrippableBlockRegistry
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.entity.effect.StatusEffect
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.EntityType$Builder
 *  net.minecraft.entity.SpawnGroup
 *  net.minecraft.item.ItemGroup
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Settings
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.SpawnEggItem
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.block.ButtonBlock
 *  net.minecraft.block.DoorBlock
 *  net.minecraft.block.FenceGateBlock
 *  net.minecraft.block.FenceBlock
 *  net.minecraft.registry.Registry
 *  net.minecraft.block.LeavesBlock
 *  net.minecraft.block.PressurePlateBlock
 *  net.minecraft.block.PillarBlock
 *  net.minecraft.block.SaplingBlock
 *  net.minecraft.block.SlabBlock
 *  net.minecraft.sound.BlockSoundGroup
 *  net.minecraft.block.StairsBlock
 *  net.minecraft.block.ShortPlantBlock
 *  net.minecraft.block.TrapdoorBlock
 *  net.minecraft.block.WallBlock
 *  net.minecraft.text.Text
 *  net.minecraft.block.CarpetBlock
 *  net.minecraft.block.enums.NoteBlockInstrument
 *  net.minecraft.util.Identifier
 *  net.minecraft.block.piston.PistonBehavior
 *  net.minecraft.block.MapColor
 *  net.minecraft.block.ComposterBlock
 *  net.minecraft.world.gen.treedecorator.TreeDecoratorType
 *  net.minecraft.block.WoodType
 *  net.minecraft.block.AbstractBlock
 *  net.minecraft.block.AbstractBlock$OffsetType
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.entity.attribute.DefaultAttributeContainer$Builder
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.Registries
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
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemConvertible;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.registry.Registry;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.ShortPlantBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.text.Text;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.util.Identifier;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.block.MapColor;
import net.minecraft.block.ComposterBlock;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.block.WoodType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.Registries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Init
implements ModInitializer {
    public static final EntityType<CreakingEntity> CREAKING = (EntityType)Registry.register((Registry)Registries.ENTITY_TYPE, Identifier.of((String)"iwie", (String)"creaking"), EntityType.Builder.create(CreakingEntity::new, (SpawnGroup)SpawnGroup.MONSTER).dimensions(1.0f, 2.9f).build(null));
    public static final Logger LOGGER = LoggerFactory.getLogger((String)"iwie");
    public static final Block PALE_OAK_LOG = Util.createLogBlock(MapColor.PALE_YELLOW, MapColor.GRAY);
    public static final Block STRIPPED_PALE_OAK_LOG = Util.createLogBlock(MapColor.PALE_YELLOW, MapColor.GRAY);
    public static final Block PALE_OAK_WOOD = new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0f).sounds(BlockSoundGroup.WOOD).burnable());
    public static final Block STRIPPED_PALE_OAK_WOOD = new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0f).sounds(BlockSoundGroup.WOOD).burnable());
    public static final Block PALE_SHORT_GRASS = new ShortPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ).burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static final Block PALE_MOSS_BLOCK = new PaleMossBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(0.1f).sounds(BlockSoundGroup.MOSS_BLOCK).pistonBehavior(PistonBehavior.DESTROY));
    public static final Block PALE_MOSS_CARPET = new CarpetBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(0.1f).sounds(BlockSoundGroup.MOSS_BLOCK).pistonBehavior(PistonBehavior.DESTROY));
    public static final Block PALE_OAK_PLANKS = new Block(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable());
    public static final Block PALE_OAK_STRAIRS = new StairsBlock(PALE_OAK_PLANKS.getDefaultState(), AbstractBlock.Settings.copy((AbstractBlock)PALE_OAK_PLANKS));
    public static final Block PALE_OAK_SLAB = new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable());
    public static final Block PALE_OAK_FENCE = new FenceBlock(AbstractBlock.Settings.create().mapColor(PALE_OAK_PLANKS.getDefaultMapColor()).solid().instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable());
    public static final Block PALE_OAK_FENCE_GATE = new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.create().mapColor(PALE_OAK_PLANKS.getDefaultMapColor()).solid().instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).burnable());
    public static final Block PALE_OAK_SAPLING = new SaplingBlock(PaleOakSapling.PALE, AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ).burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static final Block PALE_OAK_LEAVES = new LeavesBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never));
    public static final Block PALE_OAK_BUTTON = new ButtonBlock(ModBlockSetType.PALE, 30, AbstractBlock.Settings.create().noCollision().strength(0.5f).pistonBehavior(PistonBehavior.DESTROY));
    public static final Block PALE_OAK_PRESSURE_PLATE = new PressurePlateBlock(ModBlockSetType.PALE, AbstractBlock.Settings.create().mapColor(PALE_OAK_PLANKS.getDefaultMapColor()).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5f).burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static final Block CREAKING_HEART = new CreakingHeartBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(2.1f).sounds(BlockSoundGroup.MOSS_BLOCK));
    public static final Item CREAKING_SPAWN_EGG = new SpawnEggItem(CREAKING, 0xC4C4C4, 0xADADAD, new Item.Settings());
    public static final Block CLOSED_EYE_BLOSSOM_BLOCK = new ClosedEyeBlossomBlock((RegistryEntry<StatusEffect>)StatusEffects.NAUSEA, 7.0f, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).ticksRandomly());
    public static final Block OPEN_EYE_BLOSSOM_BLOCK = new OpenEyeBlossomBlock((RegistryEntry<StatusEffect>)StatusEffects.BLINDNESS, 11.0f, AbstractBlock.Settings.create().mapColor(MapColor.DARK_AQUA).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).ticksRandomly());
    public static final Block PALE_OAK_DOOR = new DoorBlock(ModBlockSetType.PALE, AbstractBlock.Settings.create().mapColor(PALE_OAK_PLANKS.getDefaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static final Block PALE_OAK_TRAPDOOR = new TrapdoorBlock(ModBlockSetType.PALE, AbstractBlock.Settings.create().mapColor(PALE_OAK_PLANKS.getDefaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0f).nonOpaque().allowsSpawning(Blocks::never).burnable());
    public static final Block RESIN_BLOCK = new Block(AbstractBlock.Settings.create().hardness(0.0f));
    public static final Block RESIN_BRICKS = new Block(AbstractBlock.Settings.create().hardness(1.5f));
    public static final Block CHISELED_RESIN_BRICK = new Block(AbstractBlock.Settings.create().hardness(1.5f));
    public static final Block RESIN_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy((AbstractBlock)RESIN_BRICKS).hardness(1.5f));
    public static final Block RESIN_BRICK_STAIRS = new StairsBlock(RESIN_BRICKS.getDefaultState(), AbstractBlock.Settings.copy((AbstractBlock)RESIN_BRICKS).hardness(1.5f));
    public static final Block RESIN_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy((AbstractBlock)RESIN_BRICKS).solid().hardness(1.5f));
    public static final Block POTTED_PALE_OAK_SAPLING = Blocks.createFlowerPotBlock((Block)PALE_OAK_SAPLING);
    public static final Block POTTED_CLOSED_EYE_BLOSSOM = Blocks.createFlowerPotBlock((Block)CLOSED_EYE_BLOSSOM_BLOCK);
    public static final Block POTTED_OPEN_EYE_BLOSSOM = Blocks.createFlowerPotBlock((Block)OPEN_EYE_BLOSSOM_BLOCK);
    public static final Item RESIN_CLUMP = new Item(new Item.Settings());
    public static final Item RESIN_BRICK = new Item(new Item.Settings());
    public static final Block PALE_HANGING_MOSS = new PaleHangingMossBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(0.1f).sounds(BlockSoundGroup.MOSS_BLOCK).pistonBehavior(PistonBehavior.DESTROY));
    public static final Block PALE_HANGING_MOSS_PLANT = new PaleHangingMossPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).strength(0.1f).sounds(BlockSoundGroup.MOSS_BLOCK).pistonBehavior(PistonBehavior.DESTROY));
    public static final Identifier PALE_OAK_TREE_FEATURE_ID = Identifier.of((String)"iwie", (String)"pale_oak_tree");
    public static final PaleOakTreeFeature PALE_FEATURE = new PaleOakTreeFeature(PaleOakTreeFeatureConfig.CODEC);
    public static final Identifier PALE_MOSS_PATCH_FEATURE_ID = Identifier.of((String)"iwie", (String)"pale_moss_patch");
    public static final PaleMossPatchFeature PALE_MOSS_PATCH_FEATURE = new PaleMossPatchFeature(PaleMossPatchConfig.CODEC);
    public static final Identifier PALE_MOSS_PATCH_CEILING_FEATURE_ID = Identifier.of((String)"iwie", (String)"pale_moss_patch_ceiling");
    public static final PaleMossPatchCeilingFeature PALE_MOSS_PATCH_CEILING_FEATURE = new PaleMossPatchCeilingFeature(PaleMossPatchCeilingConfig.CODEC);
    public static final Identifier PALE_SHORT_GRASS_PATCH_FEATURE_ID = Identifier.of((String)"iwie", (String)"pale_short_grass_patch");
    public static final PaleShortGrassFeature PALE_SHORT_GRASS_FEATURE = new PaleShortGrassFeature(PaleShortGrassPatchConfig.CODEC);
    public static final Identifier PALE_MOSS_PATCH_BONEMEAL_FEATURE_ID = Identifier.of((String)"iwie", (String)"pale_moss_patch_bonemeal");
    public static final PaleMossPatchBonemealFeature PALE_MOSS_PATCH_BONEMEAL_FEATURE = new PaleMossPatchBonemealFeature(PaleMossPatchBonemealConfig.CODEC);
    public static final TreeDecoratorType<CreakingHeartDecorator> CREAKING_HEART_DECORATOR_TREE_DECORATOR_TYPE = new TreeDecoratorType(CreakingHeartDecorator.CODEC);
    private static final ItemGroup IWIE = FabricItemGroup.builder().icon(() -> new ItemStack((ItemConvertible)PALE_OAK_LOG)).displayName((Text)Text.translatable((String)"itemGroup.iwie.main")).entries((context, entries) -> {
        entries.add((ItemConvertible)PALE_OAK_LOG);
        entries.add((ItemConvertible)PALE_SHORT_GRASS);
        entries.add((ItemConvertible)PALE_MOSS_BLOCK);
        entries.add((ItemConvertible)PALE_MOSS_CARPET);
        entries.add((ItemConvertible)PALE_OAK_PLANKS);
        entries.add((ItemConvertible)PALE_OAK_STRAIRS);
        entries.add((ItemConvertible)PALE_OAK_SLAB);
        entries.add((ItemConvertible)PALE_OAK_FENCE);
        entries.add((ItemConvertible)PALE_OAK_FENCE_GATE);
        entries.add((ItemConvertible)PALE_OAK_SAPLING);
        entries.add((ItemConvertible)CLOSED_EYE_BLOSSOM_BLOCK);
        entries.add((ItemConvertible)OPEN_EYE_BLOSSOM_BLOCK);
        entries.add((ItemConvertible)PALE_OAK_DOOR);
        entries.add((ItemConvertible)PALE_OAK_LEAVES);
        entries.add((ItemConvertible)PALE_OAK_BUTTON);
        entries.add((ItemConvertible)PALE_OAK_PRESSURE_PLATE);
        entries.add((ItemConvertible)PALE_HANGING_MOSS);
        entries.add((ItemConvertible)STRIPPED_PALE_OAK_LOG);
        entries.add((ItemConvertible)PALE_OAK_WOOD);
        entries.add((ItemConvertible)STRIPPED_PALE_OAK_WOOD);
        entries.add((ItemConvertible)CREAKING_SPAWN_EGG);
        entries.add((ItemConvertible)CREAKING_HEART);
        entries.add((ItemConvertible)RESIN_BLOCK);
        entries.add((ItemConvertible)RESIN_BRICKS);
        entries.add((ItemConvertible)RESIN_BRICK_SLAB);
        entries.add((ItemConvertible)RESIN_BRICK_STAIRS);
        entries.add((ItemConvertible)RESIN_BRICK_WALL);
        entries.add((ItemConvertible)RESIN_CLUMP);
        entries.add((ItemConvertible)RESIN_BRICK);
    }).build();

    public void onInitialize() {
        LOGGER.info("Initializing items and blocks from 1.22 update!");
        Registry.register((Registry)Registries.FEATURE, PALE_OAK_TREE_FEATURE_ID, (PALE_FEATURE));
        Registry.register((Registry)Registries.FEATURE, PALE_MOSS_PATCH_FEATURE_ID, (PALE_MOSS_PATCH_FEATURE));
        Registry.register((Registry)Registries.FEATURE, PALE_MOSS_PATCH_CEILING_FEATURE_ID, (PALE_MOSS_PATCH_CEILING_FEATURE));
        Registry.register((Registry)Registries.FEATURE, PALE_SHORT_GRASS_PATCH_FEATURE_ID, (PALE_SHORT_GRASS_FEATURE));
        Registry.register((Registry)Registries.FEATURE, PALE_MOSS_PATCH_BONEMEAL_FEATURE_ID, (PALE_MOSS_PATCH_BONEMEAL_FEATURE));
        Registry.register((Registry)Registries.TREE_DECORATOR_TYPE, Identifier.of((String)"iwie", (String)"creaking_heart"), CREAKING_HEART_DECORATOR_TREE_DECORATOR_TYPE);
        CreakingBlockEntityTypes.initialize();
        ModRegistry.registerBlocks();
        ModRegistry.registerItems();
        ModRegistry.registerFuel();
        Registry.register((Registry)Registries.ITEM_GROUP, Identifier.of((String)"iwie", (String)"main"), IWIE);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PALE_MOSS_BLOCK.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(OPEN_EYE_BLOSSOM_BLOCK.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(CLOSED_EYE_BLOSSOM_BLOCK.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PALE_MOSS_CARPET.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PALE_OAK_LEAVES.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PALE_OAK_SAPLING.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PALE_SHORT_GRASS.asItem(), 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(PALE_HANGING_MOSS.asItem(), 0.3f);
        FabricDefaultAttributeRegistry.register(CREAKING, (DefaultAttributeContainer.Builder)CreakingEntity.createMobAttributes());
        if (FabricLoader.getInstance().isModLoaded("wilderwild")) {
            LOGGER.info("Wilder Wild mod is present, initializing compatibility features!");
            WilderWildCompat.init();
        }
        StrippableBlockRegistry.register((Block)PALE_OAK_LOG, (Block)STRIPPED_PALE_OAK_LOG);
        StrippableBlockRegistry.register((Block)PALE_OAK_WOOD, (Block)STRIPPED_PALE_OAK_WOOD);
    }
}


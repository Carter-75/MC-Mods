/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.item.Item$Settings
 *  net.minecraft.item.SignItem
 *  net.minecraft.block.Block
 *  net.minecraft.block.ButtonBlock
 *  net.minecraft.block.DoorBlock
 *  net.minecraft.block.FenceGateBlock
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.block.FenceBlock
 *  net.minecraft.block.FlowerPotBlock
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.block.PressurePlateBlock
 *  net.minecraft.block.PillarBlock
 *  net.minecraft.block.SaplingBlock
 *  net.minecraft.block.SlabBlock
 *  net.minecraft.sound.BlockSoundGroup
 *  net.minecraft.block.SignBlock
 *  net.minecraft.block.StairsBlock
 *  net.minecraft.block.TrapdoorBlock
 *  net.minecraft.block.WallBlock
 *  net.minecraft.block.WallSignBlock
 *  net.minecraft.block.enums.NoteBlockInstrument
 *  net.minecraft.Property
 *  net.minecraft.block.piston.PistonBehavior
 *  net.minecraft.block.MapColor
 *  net.minecraft.block.WoodType
 *  net.minecraft.block.AbstractBlock$OffsetType
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.item.HangingSignItem
 *  net.minecraft.block.HangingSignBlock
 *  net.minecraft.block.WallHangingSignBlock
 *  net.minecraft.block.FlowerbedBlock
 *  net.minecraft.block.SaplingGenerator
 */
package backported.updates.content.common.registries;

import backported.updates.content.client.registries.ModParticles;
import backported.updates.content.client.registries.ModSoundTypes;
import backported.updates.content.common.level.blocks.ActualBushBlock;
import backported.updates.content.common.level.blocks.CactusFlowerBlock;
import backported.updates.content.common.level.blocks.CreakingHeartBlock;
import backported.updates.content.common.level.blocks.DriedGhastBlock;
import backported.updates.content.common.level.blocks.EyeblossomBlock;
import backported.updates.content.common.level.blocks.EyeblossomFlowerPotBlock;
import backported.updates.content.common.level.blocks.FireflyBushBlock;
import backported.updates.content.common.level.blocks.HangingMossBlock;
import backported.updates.content.common.level.blocks.LeafLitterBlock;
import backported.updates.content.common.level.blocks.MossyCarpetBlock;
import backported.updates.content.common.level.blocks.PaleMossBlock;
import backported.updates.content.common.level.blocks.ParticleLeavesBlock;
import backported.updates.content.common.level.blocks.ResinClumpBlock;
import backported.updates.content.common.level.blocks.ShortDryGrassBlock;
import backported.updates.content.common.level.blocks.TallDryGrassBlock;
import backported.updates.content.common.registries.ModBlockSetTypes;
import backported.updates.content.common.registries.ModWoodTypes;
import backported.updates.content.common.worldgen.features.TheGardenAwakensFeatures;
import backported.updates.content.core.FeatureFlag;
import backported.updates.foundation.core.helper.BlockRegistry;
import com.mojang.datafixers.util.Pair;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.block.Block;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.util.math.Direction;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.SignBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.state.property.Property;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.block.MapColor;
import net.minecraft.block.WoodType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.HangingSignItem;
import net.minecraft.block.HangingSignBlock;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.block.SaplingGenerator;

public class ModBlocks {
    public static final BlockRegistry BLOCKS = BlockRegistry.create("backported_updates");
    public static final Supplier<Block> PALE_OAK_LEAVES = BLOCKS.register("pale_oak_leaves", properties -> new ParticleLeavesBlock(50, (Supplier<? extends ParticleEffect>)ModParticles.PALE_OAK_LEAVES, (AbstractBlock.Settings)properties), AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_GREEN).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(BLOCKS::ocelotOrParrot).suffocates(BLOCKS::never).blockVision(BLOCKS::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(BLOCKS::never));
    public static final Supplier<Block> PALE_OAK_PLANKS = BLOCKS.register("pale_oak_planks", AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable());
    public static final Supplier<Block> PALE_OAK_STAIRS = BLOCKS.register("pale_oak_stairs", properties -> new StairsBlock(PALE_OAK_PLANKS.get().getDefaultState(), properties), AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable());
    public static final Supplier<Block> PALE_OAK_SLAB = BLOCKS.register("pale_oak_slab", SlabBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable());
    public static final Supplier<Block> PALE_OAK_FENCE = BLOCKS.register("pale_oak_fence", FenceBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).burnable());
    public static final Supplier<Block> PALE_OAK_FENCE_GATE = BLOCKS.register("pale_oak_fence_gate", properties -> new FenceGateBlock(ModWoodTypes.PALE_OAK, properties), AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).solid().instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).burnable());
    public static final Supplier<Block> PALE_OAK_DOOR = BLOCKS.register("pale_oak_door", properties -> new DoorBlock(ModBlockSetTypes.PALE_OAK, properties), AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).instrument(NoteBlockInstrument.BASS).strength(3.0f).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static final Supplier<Block> PALE_OAK_WOOD = BLOCKS.register("pale_oak_wood", PillarBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0f).sounds(BlockSoundGroup.WOOD).burnable());
    public static final Supplier<Block> PALE_OAK_LOG = BLOCKS.register("pale_oak_log", PillarBlock::new, ModBlocks.logProperties(MapColor.OFF_WHITE, MapColor.STONE_GRAY, BlockSoundGroup.WOOD));
    public static final Supplier<Block> STRIPPED_PALE_OAK_WOOD = BLOCKS.register("stripped_pale_oak_wood", PillarBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).instrument(NoteBlockInstrument.BASS).strength(2.0f).sounds(BlockSoundGroup.WOOD).burnable());
    public static final Supplier<Block> STRIPPED_PALE_OAK_LOG = BLOCKS.register("stripped_pale_oak_log", PillarBlock::new, ModBlocks.logProperties(MapColor.OFF_WHITE, MapColor.OFF_WHITE, BlockSoundGroup.WOOD));
    public static final Supplier<Block> PALE_MOSS_BLOCK = BLOCKS.register("pale_moss_block", PaleMossBlock::new, AbstractBlock.Settings.create().burnable().mapColor(MapColor.LIGHT_GRAY).strength(0.1f).sounds(BlockSoundGroup.MOSS_BLOCK).pistonBehavior(PistonBehavior.DESTROY));
    public static final Supplier<Block> PALE_MOSS_CARPET = BLOCKS.register("pale_moss_carpet", MossyCarpetBlock::new, AbstractBlock.Settings.create().burnable().mapColor(MapColor.LIGHT_GRAY).strength(0.1f).sounds(BlockSoundGroup.MOSS_BLOCK).pistonBehavior(PistonBehavior.DESTROY));
    public static final Supplier<Block> PALE_HANGING_MOSS = BLOCKS.register("pale_hanging_moss", HangingMossBlock::new, AbstractBlock.Settings.create().burnable().mapColor(MapColor.LIGHT_GRAY).noCollision().sounds(BlockSoundGroup.MOSS_CARPET).pistonBehavior(PistonBehavior.DESTROY));
    public static final Supplier<Block> OPEN_EYEBLOSSOM = BLOCKS.register("open_eyeblossom", properties -> new EyeblossomBlock(EyeblossomBlock.Type.OPEN, (AbstractBlock.Settings)properties), AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).ticksRandomly());
    public static final Supplier<Block> CLOSED_EYEBLOSSOM = BLOCKS.register("closed_eyeblossom", properties -> new EyeblossomBlock(EyeblossomBlock.Type.CLOSED, (AbstractBlock.Settings)properties), AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_GRAY).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).ticksRandomly());
    public static final Supplier<Block> PALE_OAK_SAPLING = BLOCKS.register("pale_oak_sapling", properties -> new SaplingBlock(new SaplingGenerator("pale_oak", Optional.of(TheGardenAwakensFeatures.PALE_OAK_BONEMEAL), Optional.empty(), Optional.empty()), properties), AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_GRAY).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY));
    public static final Supplier<Block> POTTED_OPEN_EYEBLOSSOM = BLOCKS.registerNoItem("potted_open_eyeblossom", properties -> new EyeblossomFlowerPotBlock(OPEN_EYEBLOSSOM.get(), (AbstractBlock.Settings)properties), ModBlocks.flowerPotProperties().ticksRandomly());
    public static final Supplier<Block> POTTED_CLOSED_EYEBLOSSOM = BLOCKS.registerNoItem("potted_closed_eyeblossom", properties -> new EyeblossomFlowerPotBlock(CLOSED_EYEBLOSSOM.get(), (AbstractBlock.Settings)properties), ModBlocks.flowerPotProperties().ticksRandomly());
    public static final Supplier<Block> POTTED_PALE_OAK_SAPLING = BLOCKS.registerNoItem("potted_pale_oak_sapling", properties -> new FlowerPotBlock(PALE_OAK_SAPLING.get(), properties), ModBlocks.flowerPotProperties());
    public static final Supplier<Block> CREAKING_HEART = BLOCKS.register("creaking_heart", CreakingHeartBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).instrument(NoteBlockInstrument.BASEDRUM).strength(10.0f).sounds(ModSoundTypes.CREAKING_HEART));
    public static final Pair<Supplier<Block>, Supplier<Block>> PALE_OAK_SIGN = ModBlocks.sign("pale_oak", ModWoodTypes.PALE_OAK, MapColor.OFF_WHITE);
    public static final Pair<Supplier<Block>, Supplier<Block>> PALE_OAK_HANGING_SIGN = ModBlocks.hangingSign("pale_oak", ModWoodTypes.PALE_OAK, MapColor.OFF_WHITE);
    public static final Supplier<Block> PALE_OAK_PRESSURE_PLATE = BLOCKS.register("pale_oak_pressure_plate", properties -> new PressurePlateBlock(ModBlockSetTypes.PALE_OAK, properties), AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5f).burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static final Supplier<Block> PALE_OAK_TRAPDOOR = BLOCKS.register("pale_oak_trapdoor", properties -> new TrapdoorBlock(ModBlockSetTypes.PALE_OAK, properties), AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).instrument(NoteBlockInstrument.BASS).strength(3.0f).nonOpaque().allowsSpawning(BLOCKS::never).burnable());
    public static final Supplier<Block> PALE_OAK_BUTTON = BLOCKS.register("pale_oak_button", properties -> new ButtonBlock(ModBlockSetTypes.PALE_OAK, 30, properties), ModBlocks.buttonProperties());
    public static final Supplier<Block> RESIN_CLUMP = BLOCKS.register("resin_clump", ResinClumpBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_ORANGE).replaceable().noCollision().sounds(ModSoundTypes.RESIN).burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static final Supplier<Block> RESIN_BLOCK = BLOCKS.register("resin_block", AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).sounds(ModSoundTypes.RESIN));
    public static final Supplier<Block> RESIN_BRICKS = BLOCKS.register("resin_bricks", AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().sounds(ModSoundTypes.RESIN_BRICKS).strength(1.5f, 6.0f));
    public static final Supplier<Block> RESIN_BRICK_STAIRS = BLOCKS.register("resin_brick_stairs", properties -> new StairsBlock(RESIN_BRICKS.get().getDefaultState(), properties), AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().sounds(ModSoundTypes.RESIN_BRICKS).strength(1.5f, 6.0f));
    public static final Supplier<Block> RESIN_BRICK_SLAB = BLOCKS.register("resin_brick_slab", SlabBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().sounds(ModSoundTypes.RESIN_BRICKS).strength(1.5f, 6.0f));
    public static final Supplier<Block> RESIN_BRICK_WALL = BLOCKS.register("resin_brick_wall", WallBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().sounds(ModSoundTypes.RESIN_BRICKS).strength(1.5f, 6.0f));
    public static final Supplier<Block> CHISELED_RESIN_BRICKS = BLOCKS.register("chiseled_resin_bricks", AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().sounds(ModSoundTypes.RESIN_BRICKS).strength(1.5f, 6.0f));
    public static final Supplier<Block> DRIED_GHAST = BLOCKS.register("dried_ghast", DriedGhastBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.GRAY).breakInstantly().sounds(ModSoundTypes.DRIED_GHAST).nonOpaque().ticksRandomly());
    public static final Supplier<Block> BUSH = BLOCKS.register("bush", ActualBushBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static final Supplier<Block> FIREFLY_BUSH = BLOCKS.register("firefly_bush", FireflyBushBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).burnable().luminance(state -> 2).noCollision().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY));
    public static final Supplier<Block> WILDFLOWERS = BLOCKS.register("wildflowers", FlowerbedBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().sounds(BlockSoundGroup.PINK_PETALS).pistonBehavior(PistonBehavior.DESTROY));
    public static final Supplier<Block> LEAF_LITTER = BLOCKS.register("leaf_litter", LeafLitterBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.BROWN).replaceable().noCollision().sounds(ModSoundTypes.LEAF_LITTER).pistonBehavior(PistonBehavior.DESTROY));
    public static final Supplier<Block> CACTUS_FLOWER = BLOCKS.register("cactus_flower", CactusFlowerBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.PINK).noCollision().breakInstantly().burnable().sounds(ModSoundTypes.CACTUS_FLOWER).pistonBehavior(PistonBehavior.DESTROY));
    public static final Supplier<Block> SHORT_DRY_GRASS = BLOCKS.register("short_dry_grass", ShortDryGrassBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).burnable().offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY));
    public static final Supplier<Block> TALL_DRY_GRASS = BLOCKS.register("tall_dry_grass", TallDryGrassBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).burnable().offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY));

    private static Optional<Supplier<Block>> conditional(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings properties, FeatureFlag flag) {
        if (flag.isEnabled()) {
            return Optional.of(BLOCKS.register(name, factory, properties));
        }
        return Optional.empty();
    }

    private static AbstractBlock.Settings logProperties(MapColor topColor, MapColor sideColor, BlockSoundGroup sound) {
        return AbstractBlock.Settings.create().mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor).instrument(NoteBlockInstrument.BASS).strength(2.0f).sounds(sound).burnable();
    }

    private static AbstractBlock.Settings buttonProperties() {
        return AbstractBlock.Settings.create().noCollision().strength(0.5f).pistonBehavior(PistonBehavior.DESTROY);
    }

    private static AbstractBlock.Settings flowerPotProperties() {
        return AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY);
    }

    public static Pair<Supplier<Block>, Supplier<Block>> sign(String name, WoodType woodType, MapColor color) {
        AbstractBlock.Settings properties = AbstractBlock.Settings.create().mapColor(color).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0f).burnable();
        Supplier<Block> standing = BLOCKS.registerNoItem(name + "_sign", () -> new SignBlock(woodType, properties));
        Supplier<Block> wall = BLOCKS.registerNoItem(name + "_wall_sign", () -> new WallSignBlock(woodType, properties.dropsLike((Block)standing.get())));
        BLOCKS.registerItem(name + "_sign", () -> new SignItem(new Item.Settings().maxCount(16), (Block)standing.get(), (Block)wall.get()));
        return new Pair(standing, wall);
    }

    public static Pair<Supplier<Block>, Supplier<Block>> hangingSign(String name, WoodType woodType, MapColor color) {
        AbstractBlock.Settings properties = AbstractBlock.Settings.create().mapColor(color).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0f).burnable();
        Supplier<Block> ceiling = BLOCKS.registerNoItem(name + "_hanging_sign", () -> new HangingSignBlock(woodType, properties));
        Supplier<Block> wall = BLOCKS.registerNoItem(name + "_wall_hanging_sign", () -> new WallHangingSignBlock(woodType, properties.dropsLike((Block)ceiling.get())));
        BLOCKS.registerItem(name + "_hanging_sign", () -> new HangingSignItem((Block)ceiling.get(), (Block)wall.get(), new Item.Settings().maxCount(16)));
        return new Pair(ceiling, wall);
    }
}


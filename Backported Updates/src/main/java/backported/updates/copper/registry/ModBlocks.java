/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.sound.BlockSoundGroup
 *  net.minecraft.block.piston.PistonBehavior
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.block.Oxidizable$OxidationLevel
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.copper.registry;

import backported.updates.copper.Constants;
import backported.updates.copper.ModSoundTypes;
import backported.updates.copper.block.CopperBarsBlock;
import backported.updates.copper.block.CopperButtonBlock;
import backported.updates.copper.block.CopperChainBlock;
import backported.updates.copper.block.CopperChestBlock;
import backported.updates.copper.block.CopperLanternBlock;
import backported.updates.copper.block.CopperTorchBlock;
import backported.updates.copper.block.CopperWallTorchBlock;
import backported.updates.copper.block.WaxedCopperButtonBlock;
import backported.updates.copper.block.WaxedCopperGolemStatueBlock;
import backported.updates.copper.block.WaxedCopperLightningRodBlock;
import backported.updates.copper.block.WeatheringCopperBarsBlock;
import backported.updates.copper.block.WeatheringCopperChainBlock;
import backported.updates.copper.block.WeatheringCopperChestBlock;
import backported.updates.copper.block.WeatheringCopperGolemStatueBlock;
import backported.updates.copper.block.WeatheringCopperLanternBlock;
import backported.updates.copper.block.WeatheringCopperLightningRodBlock;
import backported.updates.copper.block.shelf.ShelfBlock;
import backported.updates.copper.registry.RegistryHelper;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.registry.RegistryKeys;

public class ModBlocks {
    public static Supplier<WeatheringCopperChestBlock> COPPER_CHEST;
    public static Supplier<WeatheringCopperChestBlock> EXPOSED_COPPER_CHEST;
    public static Supplier<WeatheringCopperChestBlock> WEATHERED_COPPER_CHEST;
    public static Supplier<WeatheringCopperChestBlock> OXIDIZED_COPPER_CHEST;
    public static Supplier<CopperChestBlock> WAXED_COPPER_CHEST;
    public static Supplier<CopperChestBlock> WAXED_EXPOSED_COPPER_CHEST;
    public static Supplier<CopperChestBlock> WAXED_WEATHERED_COPPER_CHEST;
    public static Supplier<CopperChestBlock> WAXED_OXIDIZED_COPPER_CHEST;
    public static Supplier<CopperButtonBlock> COPPER_BUTTON;
    public static Supplier<CopperButtonBlock> EXPOSED_COPPER_BUTTON;
    public static Supplier<CopperButtonBlock> WEATHERED_COPPER_BUTTON;
    public static Supplier<CopperButtonBlock> OXIDIZED_COPPER_BUTTON;
    public static Supplier<WaxedCopperButtonBlock> WAXED_COPPER_BUTTON;
    public static Supplier<WaxedCopperButtonBlock> WAXED_EXPOSED_COPPER_BUTTON;
    public static Supplier<WaxedCopperButtonBlock> WAXED_WEATHERED_COPPER_BUTTON;
    public static Supplier<WaxedCopperButtonBlock> WAXED_OXIDIZED_COPPER_BUTTON;
    public static Supplier<WeatheringCopperGolemStatueBlock> COPPER_GOLEM_STATUE;
    public static Supplier<WeatheringCopperGolemStatueBlock> EXPOSED_COPPER_GOLEM_STATUE;
    public static Supplier<WeatheringCopperGolemStatueBlock> WEATHERED_COPPER_GOLEM_STATUE;
    public static Supplier<WeatheringCopperGolemStatueBlock> OXIDIZED_COPPER_GOLEM_STATUE;
    public static Supplier<WaxedCopperGolemStatueBlock> WAXED_COPPER_GOLEM_STATUE;
    public static Supplier<WaxedCopperGolemStatueBlock> WAXED_EXPOSED_COPPER_GOLEM_STATUE;
    public static Supplier<WaxedCopperGolemStatueBlock> WAXED_WEATHERED_COPPER_GOLEM_STATUE;
    public static Supplier<WaxedCopperGolemStatueBlock> WAXED_OXIDIZED_COPPER_GOLEM_STATUE;
    public static Supplier<ShelfBlock> OAK_SHELF;
    public static Supplier<ShelfBlock> SPRUCE_SHELF;
    public static Supplier<ShelfBlock> BIRCH_SHELF;
    public static Supplier<ShelfBlock> JUNGLE_SHELF;
    public static Supplier<ShelfBlock> ACACIA_SHELF;
    public static Supplier<ShelfBlock> DARK_OAK_SHELF;
    public static Supplier<ShelfBlock> MANGROVE_SHELF;
    public static Supplier<ShelfBlock> CHERRY_SHELF;
    public static Supplier<ShelfBlock> BAMBOO_SHELF;
    public static Supplier<ShelfBlock> CRIMSON_SHELF;
    public static Supplier<ShelfBlock> WARPED_SHELF;
    public static Supplier<ShelfBlock> PALE_OAK_SHELF;
    public static Supplier<CopperTorchBlock> COPPER_TORCH;
    public static Supplier<CopperWallTorchBlock> COPPER_WALL_TORCH;
    public static Supplier<WeatheringCopperLanternBlock> COPPER_LANTERN;
    public static Supplier<WeatheringCopperLanternBlock> EXPOSED_COPPER_LANTERN;
    public static Supplier<WeatheringCopperLanternBlock> WEATHERED_COPPER_LANTERN;
    public static Supplier<WeatheringCopperLanternBlock> OXIDIZED_COPPER_LANTERN;
    public static Supplier<CopperLanternBlock> WAXED_COPPER_LANTERN;
    public static Supplier<CopperLanternBlock> WAXED_EXPOSED_COPPER_LANTERN;
    public static Supplier<CopperLanternBlock> WAXED_WEATHERED_COPPER_LANTERN;
    public static Supplier<CopperLanternBlock> WAXED_OXIDIZED_COPPER_LANTERN;
    public static Supplier<WeatheringCopperChainBlock> COPPER_CHAIN;
    public static Supplier<WeatheringCopperChainBlock> EXPOSED_COPPER_CHAIN;
    public static Supplier<WeatheringCopperChainBlock> WEATHERED_COPPER_CHAIN;
    public static Supplier<WeatheringCopperChainBlock> OXIDIZED_COPPER_CHAIN;
    public static Supplier<CopperChainBlock> WAXED_COPPER_CHAIN;
    public static Supplier<CopperChainBlock> WAXED_EXPOSED_COPPER_CHAIN;
    public static Supplier<CopperChainBlock> WAXED_WEATHERED_COPPER_CHAIN;
    public static Supplier<CopperChainBlock> WAXED_OXIDIZED_COPPER_CHAIN;
    public static Supplier<WeatheringCopperBarsBlock> COPPER_BARS;
    public static Supplier<WeatheringCopperBarsBlock> EXPOSED_COPPER_BARS;
    public static Supplier<WeatheringCopperBarsBlock> WEATHERED_COPPER_BARS;
    public static Supplier<WeatheringCopperBarsBlock> OXIDIZED_COPPER_BARS;
    public static Supplier<CopperBarsBlock> WAXED_COPPER_BARS;
    public static Supplier<CopperBarsBlock> WAXED_EXPOSED_COPPER_BARS;
    public static Supplier<CopperBarsBlock> WAXED_WEATHERED_COPPER_BARS;
    public static Supplier<CopperBarsBlock> WAXED_OXIDIZED_COPPER_BARS;
    public static Supplier<WeatheringCopperLightningRodBlock> EXPOSED_LIGHTNING_ROD;
    public static Supplier<WeatheringCopperLightningRodBlock> WEATHERED_LIGHTNING_ROD;
    public static Supplier<WeatheringCopperLightningRodBlock> OXIDIZED_LIGHTNING_ROD;
    public static Supplier<WaxedCopperLightningRodBlock> WAXED_LIGHTNING_ROD;
    public static Supplier<WaxedCopperLightningRodBlock> WAXED_EXPOSED_LIGHTNING_ROD;
    public static Supplier<WaxedCopperLightningRodBlock> WAXED_WEATHERED_LIGHTNING_ROD;
    public static Supplier<WaxedCopperLightningRodBlock> WAXED_OXIDIZED_LIGHTNING_ROD;

    public static void register() {
        Constants.LOG.info("Registering blocks for {}", "Copper-Age-Backport");
        RegistryHelper helper = RegistryHelper.getInstance();
        COPPER_CHEST = helper.registerAuto(RegistryKeys.BLOCK, "copper_chest", () -> new WeatheringCopperChestBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).requiresTool().ticksRandomly()));
        EXPOSED_COPPER_CHEST = helper.registerAuto(RegistryKeys.BLOCK, "exposed_copper_chest", () -> new WeatheringCopperChestBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).requiresTool().ticksRandomly()));
        WEATHERED_COPPER_CHEST = helper.registerAuto(RegistryKeys.BLOCK, "weathered_copper_chest", () -> new WeatheringCopperChestBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).requiresTool().ticksRandomly()));
        OXIDIZED_COPPER_CHEST = helper.registerAuto(RegistryKeys.BLOCK, "oxidized_copper_chest", () -> new WeatheringCopperChestBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).requiresTool().ticksRandomly()));
        WAXED_COPPER_CHEST = helper.registerAuto(RegistryKeys.BLOCK, "waxed_copper_chest", () -> new CopperChestBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).requiresTool()));
        WAXED_EXPOSED_COPPER_CHEST = helper.registerAuto(RegistryKeys.BLOCK, "waxed_exposed_copper_chest", () -> new CopperChestBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).requiresTool()));
        WAXED_WEATHERED_COPPER_CHEST = helper.registerAuto(RegistryKeys.BLOCK, "waxed_weathered_copper_chest", () -> new CopperChestBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).requiresTool()));
        WAXED_OXIDIZED_COPPER_CHEST = helper.registerAuto(RegistryKeys.BLOCK, "waxed_oxidized_copper_chest", () -> new CopperChestBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).requiresTool()));
        COPPER_BUTTON = helper.register(RegistryKeys.BLOCK, "copper_button", () -> new CopperButtonBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().noCollision().strength(0.5f).sounds(BlockSoundGroup.COPPER)));
        EXPOSED_COPPER_BUTTON = helper.register(RegistryKeys.BLOCK, "exposed_copper_button", () -> new CopperButtonBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().noCollision().strength(0.5f).sounds(BlockSoundGroup.COPPER)));
        WEATHERED_COPPER_BUTTON = helper.register(RegistryKeys.BLOCK, "weathered_copper_button", () -> new CopperButtonBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().noCollision().strength(0.5f).sounds(BlockSoundGroup.COPPER)));
        OXIDIZED_COPPER_BUTTON = helper.register(RegistryKeys.BLOCK, "oxidized_copper_button", () -> new CopperButtonBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().noCollision().strength(0.5f).sounds(BlockSoundGroup.COPPER)));
        WAXED_COPPER_BUTTON = helper.register(RegistryKeys.BLOCK, "waxed_copper_button", () -> new WaxedCopperButtonBlock(Oxidizable.OxidationLevel.UNAFFECTED, COPPER_BUTTON, AbstractBlock.Settings.create().noCollision().strength(0.5f).sounds(BlockSoundGroup.COPPER)));
        WAXED_EXPOSED_COPPER_BUTTON = helper.register(RegistryKeys.BLOCK, "waxed_exposed_copper_button", () -> new WaxedCopperButtonBlock(Oxidizable.OxidationLevel.EXPOSED, EXPOSED_COPPER_BUTTON, AbstractBlock.Settings.create().noCollision().strength(0.5f).sounds(BlockSoundGroup.COPPER)));
        WAXED_WEATHERED_COPPER_BUTTON = helper.register(RegistryKeys.BLOCK, "waxed_weathered_copper_button", () -> new WaxedCopperButtonBlock(Oxidizable.OxidationLevel.WEATHERED, WEATHERED_COPPER_BUTTON, AbstractBlock.Settings.create().noCollision().strength(0.5f).sounds(BlockSoundGroup.COPPER)));
        WAXED_OXIDIZED_COPPER_BUTTON = helper.register(RegistryKeys.BLOCK, "waxed_oxidized_copper_button", () -> new WaxedCopperButtonBlock(Oxidizable.OxidationLevel.OXIDIZED, OXIDIZED_COPPER_BUTTON, AbstractBlock.Settings.create().noCollision().strength(0.5f).sounds(BlockSoundGroup.COPPER)));
        COPPER_GOLEM_STATUE = helper.registerAuto(RegistryKeys.BLOCK, "copper_golem_statue", () -> new WeatheringCopperGolemStatueBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(ModSoundTypes.COPPER_STATUE).requiresTool().ticksRandomly().nonOpaque()));
        EXPOSED_COPPER_GOLEM_STATUE = helper.registerAuto(RegistryKeys.BLOCK, "exposed_copper_golem_statue", () -> new WeatheringCopperGolemStatueBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(ModSoundTypes.COPPER_STATUE).requiresTool().ticksRandomly().nonOpaque()));
        WEATHERED_COPPER_GOLEM_STATUE = helper.registerAuto(RegistryKeys.BLOCK, "weathered_copper_golem_statue", () -> new WeatheringCopperGolemStatueBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(ModSoundTypes.COPPER_STATUE).requiresTool().ticksRandomly().nonOpaque()));
        OXIDIZED_COPPER_GOLEM_STATUE = helper.registerAuto(RegistryKeys.BLOCK, "oxidized_copper_golem_statue", () -> new WeatheringCopperGolemStatueBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(ModSoundTypes.COPPER_STATUE).requiresTool().ticksRandomly().nonOpaque()));
        WAXED_COPPER_GOLEM_STATUE = helper.registerAuto(RegistryKeys.BLOCK, "waxed_copper_golem_statue", () -> new WaxedCopperGolemStatueBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(ModSoundTypes.COPPER_STATUE).requiresTool().nonOpaque()));
        WAXED_EXPOSED_COPPER_GOLEM_STATUE = helper.registerAuto(RegistryKeys.BLOCK, "waxed_exposed_copper_golem_statue", () -> new WaxedCopperGolemStatueBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(ModSoundTypes.COPPER_STATUE).requiresTool().nonOpaque()));
        WAXED_WEATHERED_COPPER_GOLEM_STATUE = helper.registerAuto(RegistryKeys.BLOCK, "waxed_weathered_copper_golem_statue", () -> new WaxedCopperGolemStatueBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(ModSoundTypes.COPPER_STATUE).requiresTool().nonOpaque()));
        WAXED_OXIDIZED_COPPER_GOLEM_STATUE = helper.registerAuto(RegistryKeys.BLOCK, "waxed_oxidized_copper_golem_statue", () -> new WaxedCopperGolemStatueBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(ModSoundTypes.COPPER_STATUE).requiresTool().nonOpaque()));
        OAK_SHELF = helper.registerAuto(RegistryKeys.BLOCK, "oak_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        SPRUCE_SHELF = helper.registerAuto(RegistryKeys.BLOCK, "spruce_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        BIRCH_SHELF = helper.registerAuto(RegistryKeys.BLOCK, "birch_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        JUNGLE_SHELF = helper.registerAuto(RegistryKeys.BLOCK, "jungle_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        ACACIA_SHELF = helper.registerAuto(RegistryKeys.BLOCK, "acacia_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        DARK_OAK_SHELF = helper.registerAuto(RegistryKeys.BLOCK, "dark_oak_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        MANGROVE_SHELF = helper.registerAuto(RegistryKeys.BLOCK, "mangrove_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        CHERRY_SHELF = helper.registerAuto(RegistryKeys.BLOCK, "cherry_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        BAMBOO_SHELF = helper.registerAuto(RegistryKeys.BLOCK, "bamboo_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        CRIMSON_SHELF = helper.registerAuto(RegistryKeys.BLOCK, "crimson_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        WARPED_SHELF = helper.registerAuto(RegistryKeys.BLOCK, "warped_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        PALE_OAK_SHELF = helper.registerAuto(RegistryKeys.BLOCK, "pale_oak_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        COPPER_TORCH = helper.registerAuto(RegistryKeys.BLOCK, "copper_torch", () -> new CopperTorchBlock(AbstractBlock.Settings.create().noCollision().breakInstantly().luminance(p -> 14).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)));
        COPPER_WALL_TORCH = helper.registerAuto(RegistryKeys.BLOCK, "copper_wall_torch", () -> new CopperWallTorchBlock(AbstractBlock.Settings.create().noCollision().breakInstantly().luminance(p -> 14).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY).dropsLike((Block)COPPER_TORCH.get())));
        COPPER_LANTERN = helper.registerAuto(RegistryKeys.BLOCK, "copper_lantern", () -> new WeatheringCopperLanternBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance(state -> 15).nonOpaque().pistonBehavior(PistonBehavior.DESTROY).ticksRandomly()));
        EXPOSED_COPPER_LANTERN = helper.registerAuto(RegistryKeys.BLOCK, "exposed_copper_lantern", () -> new WeatheringCopperLanternBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance(state -> 15).nonOpaque().pistonBehavior(PistonBehavior.DESTROY).ticksRandomly()));
        WEATHERED_COPPER_LANTERN = helper.registerAuto(RegistryKeys.BLOCK, "weathered_copper_lantern", () -> new WeatheringCopperLanternBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance(state -> 15).nonOpaque().pistonBehavior(PistonBehavior.DESTROY).ticksRandomly()));
        OXIDIZED_COPPER_LANTERN = helper.registerAuto(RegistryKeys.BLOCK, "oxidized_copper_lantern", () -> new WeatheringCopperLanternBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance(state -> 15).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
        WAXED_COPPER_LANTERN = helper.registerAuto(RegistryKeys.BLOCK, "waxed_copper_lantern", () -> new CopperLanternBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance(state -> 15).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
        WAXED_EXPOSED_COPPER_LANTERN = helper.registerAuto(RegistryKeys.BLOCK, "waxed_exposed_copper_lantern", () -> new CopperLanternBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance(state -> 15).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
        WAXED_WEATHERED_COPPER_LANTERN = helper.registerAuto(RegistryKeys.BLOCK, "waxed_weathered_copper_lantern", () -> new CopperLanternBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance(state -> 15).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
        WAXED_OXIDIZED_COPPER_LANTERN = helper.registerAuto(RegistryKeys.BLOCK, "waxed_oxidized_copper_lantern", () -> new CopperLanternBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance(state -> 15).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
        COPPER_CHAIN = helper.registerAuto(RegistryKeys.BLOCK, "copper_chain", () -> new WeatheringCopperChainBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.CHAIN).nonOpaque().requiresTool().solid().ticksRandomly()));
        EXPOSED_COPPER_CHAIN = helper.registerAuto(RegistryKeys.BLOCK, "exposed_copper_chain", () -> new WeatheringCopperChainBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.CHAIN).nonOpaque().requiresTool().solid().ticksRandomly()));
        WEATHERED_COPPER_CHAIN = helper.registerAuto(RegistryKeys.BLOCK, "weathered_copper_chain", () -> new WeatheringCopperChainBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.CHAIN).nonOpaque().requiresTool().solid().ticksRandomly()));
        OXIDIZED_COPPER_CHAIN = helper.registerAuto(RegistryKeys.BLOCK, "oxidized_copper_chain", () -> new WeatheringCopperChainBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.CHAIN).nonOpaque().requiresTool().solid()));
        WAXED_COPPER_CHAIN = helper.registerAuto(RegistryKeys.BLOCK, "waxed_copper_chain", () -> new CopperChainBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.CHAIN).nonOpaque().requiresTool().solid()));
        WAXED_EXPOSED_COPPER_CHAIN = helper.registerAuto(RegistryKeys.BLOCK, "waxed_exposed_copper_chain", () -> new CopperChainBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.CHAIN).nonOpaque().requiresTool().solid()));
        WAXED_WEATHERED_COPPER_CHAIN = helper.registerAuto(RegistryKeys.BLOCK, "waxed_weathered_copper_chain", () -> new CopperChainBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.CHAIN).nonOpaque().requiresTool().solid()));
        WAXED_OXIDIZED_COPPER_CHAIN = helper.registerAuto(RegistryKeys.BLOCK, "waxed_oxidized_copper_chain", () -> new CopperChainBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.CHAIN).nonOpaque().requiresTool().solid()));
        COPPER_BARS = helper.registerAuto(RegistryKeys.BLOCK, "copper_bars", () -> new WeatheringCopperBarsBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool().ticksRandomly()));
        EXPOSED_COPPER_BARS = helper.registerAuto(RegistryKeys.BLOCK, "exposed_copper_bars", () -> new WeatheringCopperBarsBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool().ticksRandomly()));
        WEATHERED_COPPER_BARS = helper.registerAuto(RegistryKeys.BLOCK, "weathered_copper_bars", () -> new WeatheringCopperBarsBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool().ticksRandomly()));
        OXIDIZED_COPPER_BARS = helper.registerAuto(RegistryKeys.BLOCK, "oxidized_copper_bars", () -> new WeatheringCopperBarsBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool()));
        WAXED_COPPER_BARS = helper.registerAuto(RegistryKeys.BLOCK, "waxed_copper_bars", () -> new CopperBarsBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool()));
        WAXED_EXPOSED_COPPER_BARS = helper.registerAuto(RegistryKeys.BLOCK, "waxed_exposed_copper_bars", () -> new CopperBarsBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool()));
        WAXED_WEATHERED_COPPER_BARS = helper.registerAuto(RegistryKeys.BLOCK, "waxed_weathered_copper_bars", () -> new CopperBarsBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool()));
        WAXED_OXIDIZED_COPPER_BARS = helper.registerAuto(RegistryKeys.BLOCK, "waxed_oxidized_copper_bars", () -> new CopperBarsBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().strength(5.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool()));
        EXPOSED_LIGHTNING_ROD = helper.registerAuto(RegistryKeys.BLOCK, "exposed_lightning_rod", () -> new WeatheringCopperLightningRodBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool().ticksRandomly()));
        WEATHERED_LIGHTNING_ROD = helper.registerAuto(RegistryKeys.BLOCK, "weathered_lightning_rod", () -> new WeatheringCopperLightningRodBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool().ticksRandomly()));
        OXIDIZED_LIGHTNING_ROD = helper.registerAuto(RegistryKeys.BLOCK, "oxidized_lightning_rod", () -> new WeatheringCopperLightningRodBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool()));
        WAXED_LIGHTNING_ROD = helper.registerAuto(RegistryKeys.BLOCK, "waxed_lightning_rod", () -> new WaxedCopperLightningRodBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool()));
        WAXED_EXPOSED_LIGHTNING_ROD = helper.registerAuto(RegistryKeys.BLOCK, "waxed_exposed_lightning_rod", () -> new WaxedCopperLightningRodBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool()));
        WAXED_WEATHERED_LIGHTNING_ROD = helper.registerAuto(RegistryKeys.BLOCK, "waxed_weathered_lightning_rod", () -> new WaxedCopperLightningRodBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool()));
        WAXED_OXIDIZED_LIGHTNING_ROD = helper.registerAuto(RegistryKeys.BLOCK, "waxed_oxidized_lightning_rod", () -> new WaxedCopperLightningRodBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().strength(3.0f, 6.0f).sounds(BlockSoundGroup.COPPER).nonOpaque().requiresTool()));
        helper.onRegisterComplete(() -> {
            COPPER_BUTTON.get().setWaxedButton(WAXED_COPPER_BUTTON);
            EXPOSED_COPPER_BUTTON.get().setWaxedButton(WAXED_EXPOSED_COPPER_BUTTON);
            WEATHERED_COPPER_BUTTON.get().setWaxedButton(WAXED_WEATHERED_COPPER_BUTTON);
            OXIDIZED_COPPER_BUTTON.get().setWaxedButton(WAXED_OXIDIZED_COPPER_BUTTON);
        });
    }

    private static AbstractBlock.Settings shelfProperties() {
        return AbstractBlock.Settings.create().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD).nonOpaque();
    }
}


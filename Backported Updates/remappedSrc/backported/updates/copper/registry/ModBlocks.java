/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2498
 *  net.minecraft.class_3619
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5955$class_5811
 *  net.minecraft.class_7924
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
import net.minecraft.class_2248;
import net.minecraft.class_2498;
import net.minecraft.class_3619;
import net.minecraft.class_4970;
import net.minecraft.class_5955;
import net.minecraft.class_7924;

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
        Constants.LOG.info("Registering blocks for {}", (Object)"Copper-Age-Backport");
        RegistryHelper helper = RegistryHelper.getInstance();
        COPPER_CHEST = helper.registerAuto(class_7924.field_41254, "copper_chest", () -> new WeatheringCopperChestBlock(class_5955.class_5811.field_28704, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(class_2498.field_27204).method_29292().method_9640()));
        EXPOSED_COPPER_CHEST = helper.registerAuto(class_7924.field_41254, "exposed_copper_chest", () -> new WeatheringCopperChestBlock(class_5955.class_5811.field_28705, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(class_2498.field_27204).method_29292().method_9640()));
        WEATHERED_COPPER_CHEST = helper.registerAuto(class_7924.field_41254, "weathered_copper_chest", () -> new WeatheringCopperChestBlock(class_5955.class_5811.field_28706, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(class_2498.field_27204).method_29292().method_9640()));
        OXIDIZED_COPPER_CHEST = helper.registerAuto(class_7924.field_41254, "oxidized_copper_chest", () -> new WeatheringCopperChestBlock(class_5955.class_5811.field_28707, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(class_2498.field_27204).method_29292().method_9640()));
        WAXED_COPPER_CHEST = helper.registerAuto(class_7924.field_41254, "waxed_copper_chest", () -> new CopperChestBlock(class_5955.class_5811.field_28704, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(class_2498.field_27204).method_29292()));
        WAXED_EXPOSED_COPPER_CHEST = helper.registerAuto(class_7924.field_41254, "waxed_exposed_copper_chest", () -> new CopperChestBlock(class_5955.class_5811.field_28705, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(class_2498.field_27204).method_29292()));
        WAXED_WEATHERED_COPPER_CHEST = helper.registerAuto(class_7924.field_41254, "waxed_weathered_copper_chest", () -> new CopperChestBlock(class_5955.class_5811.field_28706, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(class_2498.field_27204).method_29292()));
        WAXED_OXIDIZED_COPPER_CHEST = helper.registerAuto(class_7924.field_41254, "waxed_oxidized_copper_chest", () -> new CopperChestBlock(class_5955.class_5811.field_28707, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(class_2498.field_27204).method_29292()));
        COPPER_BUTTON = helper.register(class_7924.field_41254, "copper_button", () -> new CopperButtonBlock(class_5955.class_5811.field_28704, class_4970.class_2251.method_9637().method_9634().method_9632(0.5f).method_9626(class_2498.field_27204)));
        EXPOSED_COPPER_BUTTON = helper.register(class_7924.field_41254, "exposed_copper_button", () -> new CopperButtonBlock(class_5955.class_5811.field_28705, class_4970.class_2251.method_9637().method_9634().method_9632(0.5f).method_9626(class_2498.field_27204)));
        WEATHERED_COPPER_BUTTON = helper.register(class_7924.field_41254, "weathered_copper_button", () -> new CopperButtonBlock(class_5955.class_5811.field_28706, class_4970.class_2251.method_9637().method_9634().method_9632(0.5f).method_9626(class_2498.field_27204)));
        OXIDIZED_COPPER_BUTTON = helper.register(class_7924.field_41254, "oxidized_copper_button", () -> new CopperButtonBlock(class_5955.class_5811.field_28707, class_4970.class_2251.method_9637().method_9634().method_9632(0.5f).method_9626(class_2498.field_27204)));
        WAXED_COPPER_BUTTON = helper.register(class_7924.field_41254, "waxed_copper_button", () -> new WaxedCopperButtonBlock(class_5955.class_5811.field_28704, COPPER_BUTTON, class_4970.class_2251.method_9637().method_9634().method_9632(0.5f).method_9626(class_2498.field_27204)));
        WAXED_EXPOSED_COPPER_BUTTON = helper.register(class_7924.field_41254, "waxed_exposed_copper_button", () -> new WaxedCopperButtonBlock(class_5955.class_5811.field_28705, EXPOSED_COPPER_BUTTON, class_4970.class_2251.method_9637().method_9634().method_9632(0.5f).method_9626(class_2498.field_27204)));
        WAXED_WEATHERED_COPPER_BUTTON = helper.register(class_7924.field_41254, "waxed_weathered_copper_button", () -> new WaxedCopperButtonBlock(class_5955.class_5811.field_28706, WEATHERED_COPPER_BUTTON, class_4970.class_2251.method_9637().method_9634().method_9632(0.5f).method_9626(class_2498.field_27204)));
        WAXED_OXIDIZED_COPPER_BUTTON = helper.register(class_7924.field_41254, "waxed_oxidized_copper_button", () -> new WaxedCopperButtonBlock(class_5955.class_5811.field_28707, OXIDIZED_COPPER_BUTTON, class_4970.class_2251.method_9637().method_9634().method_9632(0.5f).method_9626(class_2498.field_27204)));
        COPPER_GOLEM_STATUE = helper.registerAuto(class_7924.field_41254, "copper_golem_statue", () -> new WeatheringCopperGolemStatueBlock(class_5955.class_5811.field_28704, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(ModSoundTypes.COPPER_STATUE).method_29292().method_9640().method_22488()));
        EXPOSED_COPPER_GOLEM_STATUE = helper.registerAuto(class_7924.field_41254, "exposed_copper_golem_statue", () -> new WeatheringCopperGolemStatueBlock(class_5955.class_5811.field_28705, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(ModSoundTypes.COPPER_STATUE).method_29292().method_9640().method_22488()));
        WEATHERED_COPPER_GOLEM_STATUE = helper.registerAuto(class_7924.field_41254, "weathered_copper_golem_statue", () -> new WeatheringCopperGolemStatueBlock(class_5955.class_5811.field_28706, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(ModSoundTypes.COPPER_STATUE).method_29292().method_9640().method_22488()));
        OXIDIZED_COPPER_GOLEM_STATUE = helper.registerAuto(class_7924.field_41254, "oxidized_copper_golem_statue", () -> new WeatheringCopperGolemStatueBlock(class_5955.class_5811.field_28707, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(ModSoundTypes.COPPER_STATUE).method_29292().method_9640().method_22488()));
        WAXED_COPPER_GOLEM_STATUE = helper.registerAuto(class_7924.field_41254, "waxed_copper_golem_statue", () -> new WaxedCopperGolemStatueBlock(class_5955.class_5811.field_28704, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(ModSoundTypes.COPPER_STATUE).method_29292().method_22488()));
        WAXED_EXPOSED_COPPER_GOLEM_STATUE = helper.registerAuto(class_7924.field_41254, "waxed_exposed_copper_golem_statue", () -> new WaxedCopperGolemStatueBlock(class_5955.class_5811.field_28705, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(ModSoundTypes.COPPER_STATUE).method_29292().method_22488()));
        WAXED_WEATHERED_COPPER_GOLEM_STATUE = helper.registerAuto(class_7924.field_41254, "waxed_weathered_copper_golem_statue", () -> new WaxedCopperGolemStatueBlock(class_5955.class_5811.field_28706, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(ModSoundTypes.COPPER_STATUE).method_29292().method_22488()));
        WAXED_OXIDIZED_COPPER_GOLEM_STATUE = helper.registerAuto(class_7924.field_41254, "waxed_oxidized_copper_golem_statue", () -> new WaxedCopperGolemStatueBlock(class_5955.class_5811.field_28707, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(ModSoundTypes.COPPER_STATUE).method_29292().method_22488()));
        OAK_SHELF = helper.registerAuto(class_7924.field_41254, "oak_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        SPRUCE_SHELF = helper.registerAuto(class_7924.field_41254, "spruce_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        BIRCH_SHELF = helper.registerAuto(class_7924.field_41254, "birch_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        JUNGLE_SHELF = helper.registerAuto(class_7924.field_41254, "jungle_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        ACACIA_SHELF = helper.registerAuto(class_7924.field_41254, "acacia_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        DARK_OAK_SHELF = helper.registerAuto(class_7924.field_41254, "dark_oak_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        MANGROVE_SHELF = helper.registerAuto(class_7924.field_41254, "mangrove_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        CHERRY_SHELF = helper.registerAuto(class_7924.field_41254, "cherry_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        BAMBOO_SHELF = helper.registerAuto(class_7924.field_41254, "bamboo_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        CRIMSON_SHELF = helper.registerAuto(class_7924.field_41254, "crimson_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        WARPED_SHELF = helper.registerAuto(class_7924.field_41254, "warped_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        PALE_OAK_SHELF = helper.registerAuto(class_7924.field_41254, "pale_oak_shelf", () -> new ShelfBlock(ModBlocks.shelfProperties()));
        COPPER_TORCH = helper.registerAuto(class_7924.field_41254, "copper_torch", () -> new CopperTorchBlock(class_4970.class_2251.method_9637().method_9634().method_9618().method_9631(p -> 14).method_9626(class_2498.field_11547).method_50012(class_3619.field_15971)));
        COPPER_WALL_TORCH = helper.registerAuto(class_7924.field_41254, "copper_wall_torch", () -> new CopperWallTorchBlock(class_4970.class_2251.method_9637().method_9634().method_9618().method_9631(p -> 14).method_9626(class_2498.field_11547).method_50012(class_3619.field_15971).method_16228((class_2248)COPPER_TORCH.get())));
        COPPER_LANTERN = helper.registerAuto(class_7924.field_41254, "copper_lantern", () -> new WeatheringCopperLanternBlock(class_5955.class_5811.field_28704, class_4970.class_2251.method_9637().method_9632(3.5f).method_9626(class_2498.field_17734).method_9631(state -> 15).method_22488().method_50012(class_3619.field_15971).method_9640()));
        EXPOSED_COPPER_LANTERN = helper.registerAuto(class_7924.field_41254, "exposed_copper_lantern", () -> new WeatheringCopperLanternBlock(class_5955.class_5811.field_28705, class_4970.class_2251.method_9637().method_9632(3.5f).method_9626(class_2498.field_17734).method_9631(state -> 15).method_22488().method_50012(class_3619.field_15971).method_9640()));
        WEATHERED_COPPER_LANTERN = helper.registerAuto(class_7924.field_41254, "weathered_copper_lantern", () -> new WeatheringCopperLanternBlock(class_5955.class_5811.field_28706, class_4970.class_2251.method_9637().method_9632(3.5f).method_9626(class_2498.field_17734).method_9631(state -> 15).method_22488().method_50012(class_3619.field_15971).method_9640()));
        OXIDIZED_COPPER_LANTERN = helper.registerAuto(class_7924.field_41254, "oxidized_copper_lantern", () -> new WeatheringCopperLanternBlock(class_5955.class_5811.field_28707, class_4970.class_2251.method_9637().method_9632(3.5f).method_9626(class_2498.field_17734).method_9631(state -> 15).method_22488().method_50012(class_3619.field_15971)));
        WAXED_COPPER_LANTERN = helper.registerAuto(class_7924.field_41254, "waxed_copper_lantern", () -> new CopperLanternBlock(class_5955.class_5811.field_28704, class_4970.class_2251.method_9637().method_9632(3.5f).method_9626(class_2498.field_17734).method_9631(state -> 15).method_22488().method_50012(class_3619.field_15971)));
        WAXED_EXPOSED_COPPER_LANTERN = helper.registerAuto(class_7924.field_41254, "waxed_exposed_copper_lantern", () -> new CopperLanternBlock(class_5955.class_5811.field_28705, class_4970.class_2251.method_9637().method_9632(3.5f).method_9626(class_2498.field_17734).method_9631(state -> 15).method_22488().method_50012(class_3619.field_15971)));
        WAXED_WEATHERED_COPPER_LANTERN = helper.registerAuto(class_7924.field_41254, "waxed_weathered_copper_lantern", () -> new CopperLanternBlock(class_5955.class_5811.field_28706, class_4970.class_2251.method_9637().method_9632(3.5f).method_9626(class_2498.field_17734).method_9631(state -> 15).method_22488().method_50012(class_3619.field_15971)));
        WAXED_OXIDIZED_COPPER_LANTERN = helper.registerAuto(class_7924.field_41254, "waxed_oxidized_copper_lantern", () -> new CopperLanternBlock(class_5955.class_5811.field_28707, class_4970.class_2251.method_9637().method_9632(3.5f).method_9626(class_2498.field_17734).method_9631(state -> 15).method_22488().method_50012(class_3619.field_15971)));
        COPPER_CHAIN = helper.registerAuto(class_7924.field_41254, "copper_chain", () -> new WeatheringCopperChainBlock(class_5955.class_5811.field_28704, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_24119).method_22488().method_29292().method_51369().method_9640()));
        EXPOSED_COPPER_CHAIN = helper.registerAuto(class_7924.field_41254, "exposed_copper_chain", () -> new WeatheringCopperChainBlock(class_5955.class_5811.field_28705, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_24119).method_22488().method_29292().method_51369().method_9640()));
        WEATHERED_COPPER_CHAIN = helper.registerAuto(class_7924.field_41254, "weathered_copper_chain", () -> new WeatheringCopperChainBlock(class_5955.class_5811.field_28706, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_24119).method_22488().method_29292().method_51369().method_9640()));
        OXIDIZED_COPPER_CHAIN = helper.registerAuto(class_7924.field_41254, "oxidized_copper_chain", () -> new WeatheringCopperChainBlock(class_5955.class_5811.field_28707, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_24119).method_22488().method_29292().method_51369()));
        WAXED_COPPER_CHAIN = helper.registerAuto(class_7924.field_41254, "waxed_copper_chain", () -> new CopperChainBlock(class_5955.class_5811.field_28704, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_24119).method_22488().method_29292().method_51369()));
        WAXED_EXPOSED_COPPER_CHAIN = helper.registerAuto(class_7924.field_41254, "waxed_exposed_copper_chain", () -> new CopperChainBlock(class_5955.class_5811.field_28705, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_24119).method_22488().method_29292().method_51369()));
        WAXED_WEATHERED_COPPER_CHAIN = helper.registerAuto(class_7924.field_41254, "waxed_weathered_copper_chain", () -> new CopperChainBlock(class_5955.class_5811.field_28706, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_24119).method_22488().method_29292().method_51369()));
        WAXED_OXIDIZED_COPPER_CHAIN = helper.registerAuto(class_7924.field_41254, "waxed_oxidized_copper_chain", () -> new CopperChainBlock(class_5955.class_5811.field_28707, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_24119).method_22488().method_29292().method_51369()));
        COPPER_BARS = helper.registerAuto(class_7924.field_41254, "copper_bars", () -> new WeatheringCopperBarsBlock(class_5955.class_5811.field_28704, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_27204).method_22488().method_29292().method_9640()));
        EXPOSED_COPPER_BARS = helper.registerAuto(class_7924.field_41254, "exposed_copper_bars", () -> new WeatheringCopperBarsBlock(class_5955.class_5811.field_28705, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_27204).method_22488().method_29292().method_9640()));
        WEATHERED_COPPER_BARS = helper.registerAuto(class_7924.field_41254, "weathered_copper_bars", () -> new WeatheringCopperBarsBlock(class_5955.class_5811.field_28706, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_27204).method_22488().method_29292().method_9640()));
        OXIDIZED_COPPER_BARS = helper.registerAuto(class_7924.field_41254, "oxidized_copper_bars", () -> new WeatheringCopperBarsBlock(class_5955.class_5811.field_28707, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_27204).method_22488().method_29292()));
        WAXED_COPPER_BARS = helper.registerAuto(class_7924.field_41254, "waxed_copper_bars", () -> new CopperBarsBlock(class_5955.class_5811.field_28704, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_27204).method_22488().method_29292()));
        WAXED_EXPOSED_COPPER_BARS = helper.registerAuto(class_7924.field_41254, "waxed_exposed_copper_bars", () -> new CopperBarsBlock(class_5955.class_5811.field_28705, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_27204).method_22488().method_29292()));
        WAXED_WEATHERED_COPPER_BARS = helper.registerAuto(class_7924.field_41254, "waxed_weathered_copper_bars", () -> new CopperBarsBlock(class_5955.class_5811.field_28706, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_27204).method_22488().method_29292()));
        WAXED_OXIDIZED_COPPER_BARS = helper.registerAuto(class_7924.field_41254, "waxed_oxidized_copper_bars", () -> new CopperBarsBlock(class_5955.class_5811.field_28707, class_4970.class_2251.method_9637().method_9629(5.0f, 6.0f).method_9626(class_2498.field_27204).method_22488().method_29292()));
        EXPOSED_LIGHTNING_ROD = helper.registerAuto(class_7924.field_41254, "exposed_lightning_rod", () -> new WeatheringCopperLightningRodBlock(class_5955.class_5811.field_28705, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(class_2498.field_27204).method_22488().method_29292().method_9640()));
        WEATHERED_LIGHTNING_ROD = helper.registerAuto(class_7924.field_41254, "weathered_lightning_rod", () -> new WeatheringCopperLightningRodBlock(class_5955.class_5811.field_28706, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(class_2498.field_27204).method_22488().method_29292().method_9640()));
        OXIDIZED_LIGHTNING_ROD = helper.registerAuto(class_7924.field_41254, "oxidized_lightning_rod", () -> new WeatheringCopperLightningRodBlock(class_5955.class_5811.field_28707, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(class_2498.field_27204).method_22488().method_29292()));
        WAXED_LIGHTNING_ROD = helper.registerAuto(class_7924.field_41254, "waxed_lightning_rod", () -> new WaxedCopperLightningRodBlock(class_5955.class_5811.field_28704, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(class_2498.field_27204).method_22488().method_29292()));
        WAXED_EXPOSED_LIGHTNING_ROD = helper.registerAuto(class_7924.field_41254, "waxed_exposed_lightning_rod", () -> new WaxedCopperLightningRodBlock(class_5955.class_5811.field_28705, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(class_2498.field_27204).method_22488().method_29292()));
        WAXED_WEATHERED_LIGHTNING_ROD = helper.registerAuto(class_7924.field_41254, "waxed_weathered_lightning_rod", () -> new WaxedCopperLightningRodBlock(class_5955.class_5811.field_28706, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(class_2498.field_27204).method_22488().method_29292()));
        WAXED_OXIDIZED_LIGHTNING_ROD = helper.registerAuto(class_7924.field_41254, "waxed_oxidized_lightning_rod", () -> new WaxedCopperLightningRodBlock(class_5955.class_5811.field_28707, class_4970.class_2251.method_9637().method_9629(3.0f, 6.0f).method_9626(class_2498.field_27204).method_22488().method_29292()));
        helper.onRegisterComplete(() -> {
            COPPER_BUTTON.get().setWaxedButton(WAXED_COPPER_BUTTON);
            EXPOSED_COPPER_BUTTON.get().setWaxedButton(WAXED_EXPOSED_COPPER_BUTTON);
            WEATHERED_COPPER_BUTTON.get().setWaxedButton(WAXED_WEATHERED_COPPER_BUTTON);
            OXIDIZED_COPPER_BUTTON.get().setWaxedButton(WAXED_OXIDIZED_COPPER_BUTTON);
        });
    }

    private static class_4970.class_2251 shelfProperties() {
        return class_4970.class_2251.method_9637().method_9629(2.0f, 3.0f).method_9626(class_2498.field_11547).method_22488();
    }
}


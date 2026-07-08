/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1738
 *  net.minecraft.class_1738$class_8051
 *  net.minecraft.class_1743
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1794
 *  net.minecraft.class_1810
 *  net.minecraft.class_1821
 *  net.minecraft.class_1827
 *  net.minecraft.class_1829
 *  net.minecraft.class_1832
 *  net.minecraft.class_2248
 *  net.minecraft.class_2350
 *  net.minecraft.class_4059
 *  net.minecraft.class_4059$class_9076
 *  net.minecraft.class_7924
 */
package backported.updates.copper.registry;

import backported.updates.copper.Constants;
import backported.updates.copper.item.armor.CopperArmorMaterial;
import backported.updates.copper.item.tools.CopperTier;
import backported.updates.copper.registry.ModBlocks;
import backported.updates.copper.registry.ModItemHelper;
import backported.updates.copper.registry.RegistryHelper;
import java.util.function.Supplier;
import net.minecraft.class_1738;
import net.minecraft.class_1743;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1794;
import net.minecraft.class_1810;
import net.minecraft.class_1821;
import net.minecraft.class_1827;
import net.minecraft.class_1829;
import net.minecraft.class_1832;
import net.minecraft.class_2248;
import net.minecraft.class_2350;
import net.minecraft.class_4059;
import net.minecraft.class_7924;

public class ModItems {
    public static Supplier<class_1792> COPPER_GOLEM_SPAWN_EGG;
    public static Supplier<class_1743> COPPER_AXE;
    public static Supplier<class_1810> COPPER_PICKAXE;
    public static Supplier<class_1821> COPPER_SHOVEL;
    public static Supplier<class_1794> COPPER_HOE;
    public static Supplier<class_1829> COPPER_SWORD;
    public static Supplier<class_1792> COPPER_NUGGET;
    public static Supplier<class_1738> COPPER_HELMET;
    public static Supplier<class_1738> COPPER_CHESTPLATE;
    public static Supplier<class_1738> COPPER_LEGGINGS;
    public static Supplier<class_1738> COPPER_BOOTS;
    public static Supplier<class_1792> COPPER_HORSE_ARMOR;
    public static Supplier<class_1747> COPPER_CHEST_ITEM;
    public static Supplier<class_1747> EXPOSED_COPPER_CHEST_ITEM;
    public static Supplier<class_1747> WEATHERED_COPPER_CHEST_ITEM;
    public static Supplier<class_1747> OXIDIZED_COPPER_CHEST_ITEM;
    public static Supplier<class_1747> WAXED_COPPER_CHEST_ITEM;
    public static Supplier<class_1747> WAXED_EXPOSED_COPPER_CHEST_ITEM;
    public static Supplier<class_1747> WAXED_WEATHERED_COPPER_CHEST_ITEM;
    public static Supplier<class_1747> WAXED_OXIDIZED_COPPER_CHEST_ITEM;
    public static Supplier<class_1747> COPPER_BUTTON_ITEM;
    public static Supplier<class_1747> EXPOSED_COPPER_BUTTON_ITEM;
    public static Supplier<class_1747> WEATHERED_COPPER_BUTTON_ITEM;
    public static Supplier<class_1747> OXIDIZED_COPPER_BUTTON_ITEM;
    public static Supplier<class_1747> WAXED_COPPER_BUTTON_ITEM;
    public static Supplier<class_1747> WAXED_EXPOSED_COPPER_BUTTON_ITEM;
    public static Supplier<class_1747> WAXED_WEATHERED_COPPER_BUTTON_ITEM;
    public static Supplier<class_1747> WAXED_OXIDIZED_COPPER_BUTTON_ITEM;
    public static Supplier<class_1747> COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<class_1747> EXPOSED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<class_1747> WEATHERED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<class_1747> OXIDIZED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<class_1747> WAXED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<class_1747> WAXED_EXPOSED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<class_1747> WAXED_WEATHERED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<class_1747> WAXED_OXIDIZED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<class_1747> OAK_SHELF_ITEM;
    public static Supplier<class_1747> BIRCH_SHELF_ITEM;
    public static Supplier<class_1747> SPRUCE_SHELF_ITEM;
    public static Supplier<class_1747> JUNGLE_SHELF_ITEM;
    public static Supplier<class_1747> ACACIA_SHELF_ITEM;
    public static Supplier<class_1747> DARK_OAK_SHELF_ITEM;
    public static Supplier<class_1747> MANGROVE_SHELF_ITEM;
    public static Supplier<class_1747> CHERRY_SHELF_ITEM;
    public static Supplier<class_1747> BAMBOO_SHELF_ITEM;
    public static Supplier<class_1747> CRIMSON_SHELF_ITEM;
    public static Supplier<class_1747> WARPED_SHELF_ITEM;
    public static Supplier<class_1747> PALE_OAK_SHELF_ITEM;
    public static Supplier<class_1827> COPPER_TORCH_ITEM;
    public static Supplier<class_1747> COPPER_LANTERN_ITEM;
    public static Supplier<class_1747> EXPOSED_COPPER_LANTERN_ITEM;
    public static Supplier<class_1747> WEATHERED_COPPER_LANTERN_ITEM;
    public static Supplier<class_1747> OXIDIZED_COPPER_LANTERN_ITEM;
    public static Supplier<class_1747> WAXED_COPPER_LANTERN_ITEM;
    public static Supplier<class_1747> WAXED_EXPOSED_COPPER_LANTERN_ITEM;
    public static Supplier<class_1747> WAXED_WEATHERED_COPPER_LANTERN_ITEM;
    public static Supplier<class_1747> WAXED_OXIDIZED_COPPER_LANTERN_ITEM;
    public static Supplier<class_1747> COPPER_CHAIN_ITEM;
    public static Supplier<class_1747> EXPOSED_COPPER_CHAIN_ITEM;
    public static Supplier<class_1747> WEATHERED_COPPER_CHAIN_ITEM;
    public static Supplier<class_1747> OXIDIZED_COPPER_CHAIN_ITEM;
    public static Supplier<class_1747> WAXED_COPPER_CHAIN_ITEM;
    public static Supplier<class_1747> WAXED_EXPOSED_COPPER_CHAIN_ITEM;
    public static Supplier<class_1747> WAXED_WEATHERED_COPPER_CHAIN_ITEM;
    public static Supplier<class_1747> WAXED_OXIDIZED_COPPER_CHAIN_ITEM;
    public static Supplier<class_1747> COPPER_BARS_ITEM;
    public static Supplier<class_1747> EXPOSED_COPPER_BARS_ITEM;
    public static Supplier<class_1747> WEATHERED_COPPER_BARS_ITEM;
    public static Supplier<class_1747> OXIDIZED_COPPER_BARS_ITEM;
    public static Supplier<class_1747> WAXED_COPPER_BARS_ITEM;
    public static Supplier<class_1747> WAXED_EXPOSED_COPPER_BARS_ITEM;
    public static Supplier<class_1747> WAXED_WEATHERED_COPPER_BARS_ITEM;
    public static Supplier<class_1747> WAXED_OXIDIZED_COPPER_BARS_ITEM;
    public static Supplier<class_1747> EXPOSED_LIGHTNING_ROD_ITEM;
    public static Supplier<class_1747> WEATHERED_LIGHTNING_ROD_ITEM;
    public static Supplier<class_1747> OXIDIZED_LIGHTNING_ROD_ITEM;
    public static Supplier<class_1747> WAXED_LIGHTNING_ROD_ITEM;
    public static Supplier<class_1747> WAXED_EXPOSED_LIGHTNING_ROD_ITEM;
    public static Supplier<class_1747> WAXED_WEATHERED_LIGHTNING_ROD_ITEM;
    public static Supplier<class_1747> WAXED_OXIDIZED_LIGHTNING_ROD_ITEM;

    public static void register() {
        Constants.LOG.info("Registering items for {}", (Object)"Copper-Age-Backport");
        RegistryHelper helper = RegistryHelper.getInstance();
        COPPER_GOLEM_SPAWN_EGG = helper.registerAuto(class_7924.field_41197, "copper_golem_spawn_egg", ModItemHelper::createSpawnEggItem);
        COPPER_CHEST_ITEM = helper.registerAuto(class_7924.field_41197, "copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.COPPER_CHEST.get(), new class_1792.class_1793()));
        EXPOSED_COPPER_CHEST_ITEM = helper.registerAuto(class_7924.field_41197, "exposed_copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.EXPOSED_COPPER_CHEST.get(), new class_1792.class_1793()));
        WEATHERED_COPPER_CHEST_ITEM = helper.registerAuto(class_7924.field_41197, "weathered_copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.WEATHERED_COPPER_CHEST.get(), new class_1792.class_1793()));
        OXIDIZED_COPPER_CHEST_ITEM = helper.registerAuto(class_7924.field_41197, "oxidized_copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.OXIDIZED_COPPER_CHEST.get(), new class_1792.class_1793()));
        WAXED_COPPER_CHEST_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.WAXED_COPPER_CHEST.get(), new class_1792.class_1793()));
        WAXED_EXPOSED_COPPER_CHEST_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_exposed_copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get(), new class_1792.class_1793()));
        WAXED_WEATHERED_COPPER_CHEST_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_weathered_copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get(), new class_1792.class_1793()));
        WAXED_OXIDIZED_COPPER_CHEST_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_oxidized_copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get(), new class_1792.class_1793()));
        COPPER_BUTTON_ITEM = helper.register(class_7924.field_41197, "copper_button", () -> new class_1747((class_2248)ModBlocks.COPPER_BUTTON.get(), new class_1792.class_1793()));
        EXPOSED_COPPER_BUTTON_ITEM = helper.register(class_7924.field_41197, "exposed_copper_button", () -> new class_1747((class_2248)ModBlocks.EXPOSED_COPPER_BUTTON.get(), new class_1792.class_1793()));
        WEATHERED_COPPER_BUTTON_ITEM = helper.register(class_7924.field_41197, "weathered_copper_button", () -> new class_1747((class_2248)ModBlocks.WEATHERED_COPPER_BUTTON.get(), new class_1792.class_1793()));
        OXIDIZED_COPPER_BUTTON_ITEM = helper.register(class_7924.field_41197, "oxidized_copper_button", () -> new class_1747((class_2248)ModBlocks.OXIDIZED_COPPER_BUTTON.get(), new class_1792.class_1793()));
        WAXED_COPPER_BUTTON_ITEM = helper.register(class_7924.field_41197, "waxed_copper_button", () -> new class_1747((class_2248)ModBlocks.WAXED_COPPER_BUTTON.get(), new class_1792.class_1793()));
        WAXED_EXPOSED_COPPER_BUTTON_ITEM = helper.register(class_7924.field_41197, "waxed_exposed_copper_button", () -> new class_1747((class_2248)ModBlocks.WAXED_EXPOSED_COPPER_BUTTON.get(), new class_1792.class_1793()));
        WAXED_WEATHERED_COPPER_BUTTON_ITEM = helper.register(class_7924.field_41197, "waxed_weathered_copper_button", () -> new class_1747((class_2248)ModBlocks.WAXED_WEATHERED_COPPER_BUTTON.get(), new class_1792.class_1793()));
        WAXED_OXIDIZED_COPPER_BUTTON_ITEM = helper.register(class_7924.field_41197, "waxed_oxidized_copper_button", () -> new class_1747((class_2248)ModBlocks.WAXED_OXIDIZED_COPPER_BUTTON.get(), new class_1792.class_1793()));
        COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(class_7924.field_41197, "copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.COPPER_GOLEM_STATUE.get(), new class_1792.class_1793()));
        EXPOSED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(class_7924.field_41197, "exposed_copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.EXPOSED_COPPER_GOLEM_STATUE.get(), new class_1792.class_1793()));
        WEATHERED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(class_7924.field_41197, "weathered_copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.WEATHERED_COPPER_GOLEM_STATUE.get(), new class_1792.class_1793()));
        OXIDIZED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(class_7924.field_41197, "oxidized_copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.OXIDIZED_COPPER_GOLEM_STATUE.get(), new class_1792.class_1793()));
        WAXED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.WAXED_COPPER_GOLEM_STATUE.get(), new class_1792.class_1793()));
        WAXED_EXPOSED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_exposed_copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.WAXED_EXPOSED_COPPER_GOLEM_STATUE.get(), new class_1792.class_1793()));
        WAXED_WEATHERED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_weathered_copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.WAXED_WEATHERED_COPPER_GOLEM_STATUE.get(), new class_1792.class_1793()));
        WAXED_OXIDIZED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_oxidized_copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((class_2248)ModBlocks.WAXED_OXIDIZED_COPPER_GOLEM_STATUE.get(), new class_1792.class_1793()));
        OAK_SHELF_ITEM = helper.registerAuto(class_7924.field_41197, "oak_shelf", () -> new class_1747((class_2248)ModBlocks.OAK_SHELF.get(), new class_1792.class_1793()));
        BIRCH_SHELF_ITEM = helper.registerAuto(class_7924.field_41197, "birch_shelf", () -> new class_1747((class_2248)ModBlocks.BIRCH_SHELF.get(), new class_1792.class_1793()));
        SPRUCE_SHELF_ITEM = helper.registerAuto(class_7924.field_41197, "spruce_shelf", () -> new class_1747((class_2248)ModBlocks.SPRUCE_SHELF.get(), new class_1792.class_1793()));
        JUNGLE_SHELF_ITEM = helper.registerAuto(class_7924.field_41197, "jungle_shelf", () -> new class_1747((class_2248)ModBlocks.JUNGLE_SHELF.get(), new class_1792.class_1793()));
        ACACIA_SHELF_ITEM = helper.registerAuto(class_7924.field_41197, "acacia_shelf", () -> new class_1747((class_2248)ModBlocks.ACACIA_SHELF.get(), new class_1792.class_1793()));
        DARK_OAK_SHELF_ITEM = helper.registerAuto(class_7924.field_41197, "dark_oak_shelf", () -> new class_1747((class_2248)ModBlocks.DARK_OAK_SHELF.get(), new class_1792.class_1793()));
        MANGROVE_SHELF_ITEM = helper.registerAuto(class_7924.field_41197, "mangrove_shelf", () -> new class_1747((class_2248)ModBlocks.MANGROVE_SHELF.get(), new class_1792.class_1793()));
        CHERRY_SHELF_ITEM = helper.registerAuto(class_7924.field_41197, "cherry_shelf", () -> new class_1747((class_2248)ModBlocks.CHERRY_SHELF.get(), new class_1792.class_1793()));
        BAMBOO_SHELF_ITEM = helper.registerAuto(class_7924.field_41197, "bamboo_shelf", () -> new class_1747((class_2248)ModBlocks.BAMBOO_SHELF.get(), new class_1792.class_1793()));
        CRIMSON_SHELF_ITEM = helper.registerAuto(class_7924.field_41197, "crimson_shelf", () -> new class_1747((class_2248)ModBlocks.CRIMSON_SHELF.get(), new class_1792.class_1793()));
        WARPED_SHELF_ITEM = helper.registerAuto(class_7924.field_41197, "warped_shelf", () -> new class_1747((class_2248)ModBlocks.WARPED_SHELF.get(), new class_1792.class_1793()));
        PALE_OAK_SHELF_ITEM = helper.registerAuto(class_7924.field_41197, "pale_oak_shelf", () -> new class_1747((class_2248)ModBlocks.PALE_OAK_SHELF.get(), new class_1792.class_1793()));
        COPPER_TORCH_ITEM = helper.registerAuto(class_7924.field_41197, "copper_torch", () -> new class_1827((class_2248)ModBlocks.COPPER_TORCH.get(), (class_2248)ModBlocks.COPPER_WALL_TORCH.get(), new class_1792.class_1793(), class_2350.field_11033));
        COPPER_LANTERN_ITEM = helper.registerAuto(class_7924.field_41197, "copper_lantern", () -> new class_1747((class_2248)ModBlocks.COPPER_LANTERN.get(), new class_1792.class_1793()));
        EXPOSED_COPPER_LANTERN_ITEM = helper.registerAuto(class_7924.field_41197, "exposed_copper_lantern", () -> new class_1747((class_2248)ModBlocks.EXPOSED_COPPER_LANTERN.get(), new class_1792.class_1793()));
        WEATHERED_COPPER_LANTERN_ITEM = helper.registerAuto(class_7924.field_41197, "weathered_copper_lantern", () -> new class_1747((class_2248)ModBlocks.WEATHERED_COPPER_LANTERN.get(), new class_1792.class_1793()));
        OXIDIZED_COPPER_LANTERN_ITEM = helper.registerAuto(class_7924.field_41197, "oxidized_copper_lantern", () -> new class_1747((class_2248)ModBlocks.OXIDIZED_COPPER_LANTERN.get(), new class_1792.class_1793()));
        WAXED_COPPER_LANTERN_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_copper_lantern", () -> new class_1747((class_2248)ModBlocks.WAXED_COPPER_LANTERN.get(), new class_1792.class_1793()));
        WAXED_EXPOSED_COPPER_LANTERN_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_exposed_copper_lantern", () -> new class_1747((class_2248)ModBlocks.WAXED_EXPOSED_COPPER_LANTERN.get(), new class_1792.class_1793()));
        WAXED_WEATHERED_COPPER_LANTERN_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_weathered_copper_lantern", () -> new class_1747((class_2248)ModBlocks.WAXED_WEATHERED_COPPER_LANTERN.get(), new class_1792.class_1793()));
        WAXED_OXIDIZED_COPPER_LANTERN_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_oxidized_copper_lantern", () -> new class_1747((class_2248)ModBlocks.WAXED_OXIDIZED_COPPER_LANTERN.get(), new class_1792.class_1793()));
        COPPER_CHAIN_ITEM = helper.registerAuto(class_7924.field_41197, "copper_chain", () -> new class_1747((class_2248)ModBlocks.COPPER_CHAIN.get(), new class_1792.class_1793()));
        EXPOSED_COPPER_CHAIN_ITEM = helper.registerAuto(class_7924.field_41197, "exposed_copper_chain", () -> new class_1747((class_2248)ModBlocks.EXPOSED_COPPER_CHAIN.get(), new class_1792.class_1793()));
        WEATHERED_COPPER_CHAIN_ITEM = helper.registerAuto(class_7924.field_41197, "weathered_copper_chain", () -> new class_1747((class_2248)ModBlocks.WEATHERED_COPPER_CHAIN.get(), new class_1792.class_1793()));
        OXIDIZED_COPPER_CHAIN_ITEM = helper.registerAuto(class_7924.field_41197, "oxidized_copper_chain", () -> new class_1747((class_2248)ModBlocks.OXIDIZED_COPPER_CHAIN.get(), new class_1792.class_1793()));
        WAXED_COPPER_CHAIN_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_copper_chain", () -> new class_1747((class_2248)ModBlocks.WAXED_COPPER_CHAIN.get(), new class_1792.class_1793()));
        WAXED_EXPOSED_COPPER_CHAIN_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_exposed_copper_chain", () -> new class_1747((class_2248)ModBlocks.WAXED_EXPOSED_COPPER_CHAIN.get(), new class_1792.class_1793()));
        WAXED_WEATHERED_COPPER_CHAIN_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_weathered_copper_chain", () -> new class_1747((class_2248)ModBlocks.WAXED_WEATHERED_COPPER_CHAIN.get(), new class_1792.class_1793()));
        WAXED_OXIDIZED_COPPER_CHAIN_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_oxidized_copper_chain", () -> new class_1747((class_2248)ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get(), new class_1792.class_1793()));
        COPPER_BARS_ITEM = helper.registerAuto(class_7924.field_41197, "copper_bars", () -> new class_1747((class_2248)ModBlocks.COPPER_BARS.get(), new class_1792.class_1793()));
        EXPOSED_COPPER_BARS_ITEM = helper.registerAuto(class_7924.field_41197, "exposed_copper_bars", () -> new class_1747((class_2248)ModBlocks.EXPOSED_COPPER_BARS.get(), new class_1792.class_1793()));
        WEATHERED_COPPER_BARS_ITEM = helper.registerAuto(class_7924.field_41197, "weathered_copper_bars", () -> new class_1747((class_2248)ModBlocks.WEATHERED_COPPER_BARS.get(), new class_1792.class_1793()));
        OXIDIZED_COPPER_BARS_ITEM = helper.registerAuto(class_7924.field_41197, "oxidized_copper_bars", () -> new class_1747((class_2248)ModBlocks.OXIDIZED_COPPER_BARS.get(), new class_1792.class_1793()));
        WAXED_COPPER_BARS_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_copper_bars", () -> new class_1747((class_2248)ModBlocks.WAXED_COPPER_BARS.get(), new class_1792.class_1793()));
        WAXED_EXPOSED_COPPER_BARS_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_exposed_copper_bars", () -> new class_1747((class_2248)ModBlocks.WAXED_EXPOSED_COPPER_BARS.get(), new class_1792.class_1793()));
        WAXED_WEATHERED_COPPER_BARS_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_weathered_copper_bars", () -> new class_1747((class_2248)ModBlocks.WAXED_WEATHERED_COPPER_BARS.get(), new class_1792.class_1793()));
        WAXED_OXIDIZED_COPPER_BARS_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_oxidized_copper_bars", () -> new class_1747((class_2248)ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get(), new class_1792.class_1793()));
        EXPOSED_LIGHTNING_ROD_ITEM = helper.registerAuto(class_7924.field_41197, "exposed_lightning_rod", () -> new class_1747((class_2248)ModBlocks.EXPOSED_LIGHTNING_ROD.get(), new class_1792.class_1793()));
        WEATHERED_LIGHTNING_ROD_ITEM = helper.registerAuto(class_7924.field_41197, "weathered_lightning_rod", () -> new class_1747((class_2248)ModBlocks.WEATHERED_LIGHTNING_ROD.get(), new class_1792.class_1793()));
        OXIDIZED_LIGHTNING_ROD_ITEM = helper.registerAuto(class_7924.field_41197, "oxidized_lightning_rod", () -> new class_1747((class_2248)ModBlocks.OXIDIZED_LIGHTNING_ROD.get(), new class_1792.class_1793()));
        WAXED_LIGHTNING_ROD_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_lightning_rod", () -> new class_1747((class_2248)ModBlocks.WAXED_LIGHTNING_ROD.get(), new class_1792.class_1793()));
        WAXED_EXPOSED_LIGHTNING_ROD_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_exposed_lightning_rod", () -> new class_1747((class_2248)ModBlocks.WAXED_EXPOSED_LIGHTNING_ROD.get(), new class_1792.class_1793()));
        WAXED_WEATHERED_LIGHTNING_ROD_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_weathered_lightning_rod", () -> new class_1747((class_2248)ModBlocks.WAXED_WEATHERED_LIGHTNING_ROD.get(), new class_1792.class_1793()));
        WAXED_OXIDIZED_LIGHTNING_ROD_ITEM = helper.registerAuto(class_7924.field_41197, "waxed_oxidized_lightning_rod", () -> new class_1747((class_2248)ModBlocks.WAXED_OXIDIZED_LIGHTNING_ROD.get(), new class_1792.class_1793()));
        COPPER_AXE = helper.registerAuto(class_7924.field_41197, "copper_axe", () -> new class_1743((class_1832)CopperTier.INSTANCE, new class_1792.class_1793().method_7889(1).method_57348(class_1743.method_57346((class_1832)CopperTier.INSTANCE, (float)7.0f, (float)-3.2f))));
        COPPER_PICKAXE = helper.registerAuto(class_7924.field_41197, "copper_pickaxe", () -> new class_1810((class_1832)CopperTier.INSTANCE, new class_1792.class_1793().method_7889(1).method_57348(class_1810.method_57346((class_1832)CopperTier.INSTANCE, (float)1.0f, (float)-2.8f))));
        COPPER_SHOVEL = helper.registerAuto(class_7924.field_41197, "copper_shovel", () -> new class_1821((class_1832)CopperTier.INSTANCE, new class_1792.class_1793().method_7889(1).method_57348(class_1821.method_57346((class_1832)CopperTier.INSTANCE, (float)1.5f, (float)-3.0f))));
        COPPER_HOE = helper.registerAuto(class_7924.field_41197, "copper_hoe", () -> new class_1794((class_1832)CopperTier.INSTANCE, new class_1792.class_1793().method_7889(1).method_57348(class_1794.method_57346((class_1832)CopperTier.INSTANCE, (float)-1.0f, (float)-2.0f))));
        COPPER_SWORD = helper.registerAuto(class_7924.field_41197, "copper_sword", () -> new class_1829((class_1832)CopperTier.INSTANCE, new class_1792.class_1793().method_7889(1).method_57348(class_1829.method_57394((class_1832)CopperTier.INSTANCE, (int)3, (float)-2.4f))));
        COPPER_NUGGET = helper.registerAuto(class_7924.field_41197, "copper_nugget", () -> new class_1792(new class_1792.class_1793()));
        COPPER_HELMET = helper.registerAuto(class_7924.field_41197, "copper_helmet", () -> new class_1738(CopperArmorMaterial.COPPER.get(), class_1738.class_8051.field_41934, new class_1792.class_1793().method_7889(1)));
        COPPER_CHESTPLATE = helper.registerAuto(class_7924.field_41197, "copper_chestplate", () -> new class_1738(CopperArmorMaterial.COPPER.get(), class_1738.class_8051.field_41935, new class_1792.class_1793().method_7889(1)));
        COPPER_LEGGINGS = helper.registerAuto(class_7924.field_41197, "copper_leggings", () -> new class_1738(CopperArmorMaterial.COPPER.get(), class_1738.class_8051.field_41936, new class_1792.class_1793().method_7889(1)));
        COPPER_BOOTS = helper.registerAuto(class_7924.field_41197, "copper_boots", () -> new class_1738(CopperArmorMaterial.COPPER.get(), class_1738.class_8051.field_41937, new class_1792.class_1793().method_7889(1)));
        COPPER_HORSE_ARMOR = helper.registerAuto(class_7924.field_41197, "copper_horse_armor", () -> new class_4059(CopperArmorMaterial.COPPER.get(), class_4059.class_9076.field_47825, false, new class_1792.class_1793().method_7889(1)));
    }
}


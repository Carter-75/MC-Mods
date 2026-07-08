/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ArmorItem
 *  net.minecraft.item.ArmorItem$Type
 *  net.minecraft.item.AxeItem
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Settings
 *  net.minecraft.item.HoeItem
 *  net.minecraft.item.PickaxeItem
 *  net.minecraft.item.ShovelItem
 *  net.minecraft.item.VerticallyAttachableBlockItem
 *  net.minecraft.item.SwordItem
 *  net.minecraft.item.ToolMaterial
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.Direction
 *  net.minecraft.item.AnimalArmorItem
 *  net.minecraft.item.AnimalArmorItem$Type
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.copper.registry;

import backported.updates.copper.Constants;
import backported.updates.copper.item.armor.CopperArmorMaterial;
import backported.updates.copper.item.tools.CopperTier;
import backported.updates.copper.registry.ModBlocks;
import backported.updates.copper.registry.ModItemHelper;
import backported.updates.copper.registry.RegistryHelper;
import java.util.function.Supplier;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.HoeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.block.Block;
import net.minecraft.util.math.Direction;
import net.minecraft.item.AnimalArmorItem;
import net.minecraft.registry.RegistryKeys;

public class ModItems {
    public static Supplier<Item> COPPER_GOLEM_SPAWN_EGG;
    public static Supplier<AxeItem> COPPER_AXE;
    public static Supplier<PickaxeItem> COPPER_PICKAXE;
    public static Supplier<ShovelItem> COPPER_SHOVEL;
    public static Supplier<HoeItem> COPPER_HOE;
    public static Supplier<SwordItem> COPPER_SWORD;
    public static Supplier<Item> COPPER_NUGGET;
    public static Supplier<ArmorItem> COPPER_HELMET;
    public static Supplier<ArmorItem> COPPER_CHESTPLATE;
    public static Supplier<ArmorItem> COPPER_LEGGINGS;
    public static Supplier<ArmorItem> COPPER_BOOTS;
    public static Supplier<Item> COPPER_HORSE_ARMOR;
    public static Supplier<BlockItem> COPPER_CHEST_ITEM;
    public static Supplier<BlockItem> EXPOSED_COPPER_CHEST_ITEM;
    public static Supplier<BlockItem> WEATHERED_COPPER_CHEST_ITEM;
    public static Supplier<BlockItem> OXIDIZED_COPPER_CHEST_ITEM;
    public static Supplier<BlockItem> WAXED_COPPER_CHEST_ITEM;
    public static Supplier<BlockItem> WAXED_EXPOSED_COPPER_CHEST_ITEM;
    public static Supplier<BlockItem> WAXED_WEATHERED_COPPER_CHEST_ITEM;
    public static Supplier<BlockItem> WAXED_OXIDIZED_COPPER_CHEST_ITEM;
    public static Supplier<BlockItem> COPPER_BUTTON_ITEM;
    public static Supplier<BlockItem> EXPOSED_COPPER_BUTTON_ITEM;
    public static Supplier<BlockItem> WEATHERED_COPPER_BUTTON_ITEM;
    public static Supplier<BlockItem> OXIDIZED_COPPER_BUTTON_ITEM;
    public static Supplier<BlockItem> WAXED_COPPER_BUTTON_ITEM;
    public static Supplier<BlockItem> WAXED_EXPOSED_COPPER_BUTTON_ITEM;
    public static Supplier<BlockItem> WAXED_WEATHERED_COPPER_BUTTON_ITEM;
    public static Supplier<BlockItem> WAXED_OXIDIZED_COPPER_BUTTON_ITEM;
    public static Supplier<BlockItem> COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<BlockItem> EXPOSED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<BlockItem> WEATHERED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<BlockItem> OXIDIZED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<BlockItem> WAXED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<BlockItem> WAXED_EXPOSED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<BlockItem> WAXED_WEATHERED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<BlockItem> WAXED_OXIDIZED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<BlockItem> OAK_SHELF_ITEM;
    public static Supplier<BlockItem> BIRCH_SHELF_ITEM;
    public static Supplier<BlockItem> SPRUCE_SHELF_ITEM;
    public static Supplier<BlockItem> JUNGLE_SHELF_ITEM;
    public static Supplier<BlockItem> ACACIA_SHELF_ITEM;
    public static Supplier<BlockItem> DARK_OAK_SHELF_ITEM;
    public static Supplier<BlockItem> MANGROVE_SHELF_ITEM;
    public static Supplier<BlockItem> CHERRY_SHELF_ITEM;
    public static Supplier<BlockItem> BAMBOO_SHELF_ITEM;
    public static Supplier<BlockItem> CRIMSON_SHELF_ITEM;
    public static Supplier<BlockItem> WARPED_SHELF_ITEM;
    public static Supplier<BlockItem> PALE_OAK_SHELF_ITEM;
    public static Supplier<VerticallyAttachableBlockItem> COPPER_TORCH_ITEM;
    public static Supplier<BlockItem> COPPER_LANTERN_ITEM;
    public static Supplier<BlockItem> EXPOSED_COPPER_LANTERN_ITEM;
    public static Supplier<BlockItem> WEATHERED_COPPER_LANTERN_ITEM;
    public static Supplier<BlockItem> OXIDIZED_COPPER_LANTERN_ITEM;
    public static Supplier<BlockItem> WAXED_COPPER_LANTERN_ITEM;
    public static Supplier<BlockItem> WAXED_EXPOSED_COPPER_LANTERN_ITEM;
    public static Supplier<BlockItem> WAXED_WEATHERED_COPPER_LANTERN_ITEM;
    public static Supplier<BlockItem> WAXED_OXIDIZED_COPPER_LANTERN_ITEM;
    public static Supplier<BlockItem> COPPER_CHAIN_ITEM;
    public static Supplier<BlockItem> EXPOSED_COPPER_CHAIN_ITEM;
    public static Supplier<BlockItem> WEATHERED_COPPER_CHAIN_ITEM;
    public static Supplier<BlockItem> OXIDIZED_COPPER_CHAIN_ITEM;
    public static Supplier<BlockItem> WAXED_COPPER_CHAIN_ITEM;
    public static Supplier<BlockItem> WAXED_EXPOSED_COPPER_CHAIN_ITEM;
    public static Supplier<BlockItem> WAXED_WEATHERED_COPPER_CHAIN_ITEM;
    public static Supplier<BlockItem> WAXED_OXIDIZED_COPPER_CHAIN_ITEM;
    public static Supplier<BlockItem> COPPER_BARS_ITEM;
    public static Supplier<BlockItem> EXPOSED_COPPER_BARS_ITEM;
    public static Supplier<BlockItem> WEATHERED_COPPER_BARS_ITEM;
    public static Supplier<BlockItem> OXIDIZED_COPPER_BARS_ITEM;
    public static Supplier<BlockItem> WAXED_COPPER_BARS_ITEM;
    public static Supplier<BlockItem> WAXED_EXPOSED_COPPER_BARS_ITEM;
    public static Supplier<BlockItem> WAXED_WEATHERED_COPPER_BARS_ITEM;
    public static Supplier<BlockItem> WAXED_OXIDIZED_COPPER_BARS_ITEM;
    public static Supplier<BlockItem> EXPOSED_LIGHTNING_ROD_ITEM;
    public static Supplier<BlockItem> WEATHERED_LIGHTNING_ROD_ITEM;
    public static Supplier<BlockItem> OXIDIZED_LIGHTNING_ROD_ITEM;
    public static Supplier<BlockItem> WAXED_LIGHTNING_ROD_ITEM;
    public static Supplier<BlockItem> WAXED_EXPOSED_LIGHTNING_ROD_ITEM;
    public static Supplier<BlockItem> WAXED_WEATHERED_LIGHTNING_ROD_ITEM;
    public static Supplier<BlockItem> WAXED_OXIDIZED_LIGHTNING_ROD_ITEM;

    public static void register() {
        Constants.LOG.info("Registering items for {}", "Copper-Age-Backport");
        RegistryHelper helper = RegistryHelper.getInstance();
        COPPER_GOLEM_SPAWN_EGG = helper.registerAuto(RegistryKeys.ITEM, "copper_golem_spawn_egg", ModItemHelper::createSpawnEggItem);
        COPPER_CHEST_ITEM = helper.registerAuto(RegistryKeys.ITEM, "copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.COPPER_CHEST.get(), new Item.Settings()));
        EXPOSED_COPPER_CHEST_ITEM = helper.registerAuto(RegistryKeys.ITEM, "exposed_copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.EXPOSED_COPPER_CHEST.get(), new Item.Settings()));
        WEATHERED_COPPER_CHEST_ITEM = helper.registerAuto(RegistryKeys.ITEM, "weathered_copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.WEATHERED_COPPER_CHEST.get(), new Item.Settings()));
        OXIDIZED_COPPER_CHEST_ITEM = helper.registerAuto(RegistryKeys.ITEM, "oxidized_copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.OXIDIZED_COPPER_CHEST.get(), new Item.Settings()));
        WAXED_COPPER_CHEST_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.WAXED_COPPER_CHEST.get(), new Item.Settings()));
        WAXED_EXPOSED_COPPER_CHEST_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_exposed_copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get(), new Item.Settings()));
        WAXED_WEATHERED_COPPER_CHEST_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_weathered_copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get(), new Item.Settings()));
        WAXED_OXIDIZED_COPPER_CHEST_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_oxidized_copper_chest", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get(), new Item.Settings()));
        COPPER_BUTTON_ITEM = helper.register(RegistryKeys.ITEM, "copper_button", () -> new BlockItem((Block)ModBlocks.COPPER_BUTTON.get(), new Item.Settings()));
        EXPOSED_COPPER_BUTTON_ITEM = helper.register(RegistryKeys.ITEM, "exposed_copper_button", () -> new BlockItem((Block)ModBlocks.EXPOSED_COPPER_BUTTON.get(), new Item.Settings()));
        WEATHERED_COPPER_BUTTON_ITEM = helper.register(RegistryKeys.ITEM, "weathered_copper_button", () -> new BlockItem((Block)ModBlocks.WEATHERED_COPPER_BUTTON.get(), new Item.Settings()));
        OXIDIZED_COPPER_BUTTON_ITEM = helper.register(RegistryKeys.ITEM, "oxidized_copper_button", () -> new BlockItem((Block)ModBlocks.OXIDIZED_COPPER_BUTTON.get(), new Item.Settings()));
        WAXED_COPPER_BUTTON_ITEM = helper.register(RegistryKeys.ITEM, "waxed_copper_button", () -> new BlockItem((Block)ModBlocks.WAXED_COPPER_BUTTON.get(), new Item.Settings()));
        WAXED_EXPOSED_COPPER_BUTTON_ITEM = helper.register(RegistryKeys.ITEM, "waxed_exposed_copper_button", () -> new BlockItem((Block)ModBlocks.WAXED_EXPOSED_COPPER_BUTTON.get(), new Item.Settings()));
        WAXED_WEATHERED_COPPER_BUTTON_ITEM = helper.register(RegistryKeys.ITEM, "waxed_weathered_copper_button", () -> new BlockItem((Block)ModBlocks.WAXED_WEATHERED_COPPER_BUTTON.get(), new Item.Settings()));
        WAXED_OXIDIZED_COPPER_BUTTON_ITEM = helper.register(RegistryKeys.ITEM, "waxed_oxidized_copper_button", () -> new BlockItem((Block)ModBlocks.WAXED_OXIDIZED_COPPER_BUTTON.get(), new Item.Settings()));
        COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(RegistryKeys.ITEM, "copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.COPPER_GOLEM_STATUE.get(), new Item.Settings()));
        EXPOSED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(RegistryKeys.ITEM, "exposed_copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.EXPOSED_COPPER_GOLEM_STATUE.get(), new Item.Settings()));
        WEATHERED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(RegistryKeys.ITEM, "weathered_copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.WEATHERED_COPPER_GOLEM_STATUE.get(), new Item.Settings()));
        OXIDIZED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(RegistryKeys.ITEM, "oxidized_copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.OXIDIZED_COPPER_GOLEM_STATUE.get(), new Item.Settings()));
        WAXED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.WAXED_COPPER_GOLEM_STATUE.get(), new Item.Settings()));
        WAXED_EXPOSED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_exposed_copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.WAXED_EXPOSED_COPPER_GOLEM_STATUE.get(), new Item.Settings()));
        WAXED_WEATHERED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_weathered_copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.WAXED_WEATHERED_COPPER_GOLEM_STATUE.get(), new Item.Settings()));
        WAXED_OXIDIZED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_oxidized_copper_golem_statue", () -> ModItemHelper.create3DBlockItemForPlatform((Block)ModBlocks.WAXED_OXIDIZED_COPPER_GOLEM_STATUE.get(), new Item.Settings()));
        OAK_SHELF_ITEM = helper.registerAuto(RegistryKeys.ITEM, "oak_shelf", () -> new BlockItem((Block)ModBlocks.OAK_SHELF.get(), new Item.Settings()));
        BIRCH_SHELF_ITEM = helper.registerAuto(RegistryKeys.ITEM, "birch_shelf", () -> new BlockItem((Block)ModBlocks.BIRCH_SHELF.get(), new Item.Settings()));
        SPRUCE_SHELF_ITEM = helper.registerAuto(RegistryKeys.ITEM, "spruce_shelf", () -> new BlockItem((Block)ModBlocks.SPRUCE_SHELF.get(), new Item.Settings()));
        JUNGLE_SHELF_ITEM = helper.registerAuto(RegistryKeys.ITEM, "jungle_shelf", () -> new BlockItem((Block)ModBlocks.JUNGLE_SHELF.get(), new Item.Settings()));
        ACACIA_SHELF_ITEM = helper.registerAuto(RegistryKeys.ITEM, "acacia_shelf", () -> new BlockItem((Block)ModBlocks.ACACIA_SHELF.get(), new Item.Settings()));
        DARK_OAK_SHELF_ITEM = helper.registerAuto(RegistryKeys.ITEM, "dark_oak_shelf", () -> new BlockItem((Block)ModBlocks.DARK_OAK_SHELF.get(), new Item.Settings()));
        MANGROVE_SHELF_ITEM = helper.registerAuto(RegistryKeys.ITEM, "mangrove_shelf", () -> new BlockItem((Block)ModBlocks.MANGROVE_SHELF.get(), new Item.Settings()));
        CHERRY_SHELF_ITEM = helper.registerAuto(RegistryKeys.ITEM, "cherry_shelf", () -> new BlockItem((Block)ModBlocks.CHERRY_SHELF.get(), new Item.Settings()));
        BAMBOO_SHELF_ITEM = helper.registerAuto(RegistryKeys.ITEM, "bamboo_shelf", () -> new BlockItem((Block)ModBlocks.BAMBOO_SHELF.get(), new Item.Settings()));
        CRIMSON_SHELF_ITEM = helper.registerAuto(RegistryKeys.ITEM, "crimson_shelf", () -> new BlockItem((Block)ModBlocks.CRIMSON_SHELF.get(), new Item.Settings()));
        WARPED_SHELF_ITEM = helper.registerAuto(RegistryKeys.ITEM, "warped_shelf", () -> new BlockItem((Block)ModBlocks.WARPED_SHELF.get(), new Item.Settings()));
        PALE_OAK_SHELF_ITEM = helper.registerAuto(RegistryKeys.ITEM, "pale_oak_shelf", () -> new BlockItem((Block)ModBlocks.PALE_OAK_SHELF.get(), new Item.Settings()));
        COPPER_TORCH_ITEM = helper.registerAuto(RegistryKeys.ITEM, "copper_torch", () -> new VerticallyAttachableBlockItem((Block)ModBlocks.COPPER_TORCH.get(), (Block)ModBlocks.COPPER_WALL_TORCH.get(), new Item.Settings(), Direction.DOWN));
        COPPER_LANTERN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "copper_lantern", () -> new BlockItem((Block)ModBlocks.COPPER_LANTERN.get(), new Item.Settings()));
        EXPOSED_COPPER_LANTERN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "exposed_copper_lantern", () -> new BlockItem((Block)ModBlocks.EXPOSED_COPPER_LANTERN.get(), new Item.Settings()));
        WEATHERED_COPPER_LANTERN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "weathered_copper_lantern", () -> new BlockItem((Block)ModBlocks.WEATHERED_COPPER_LANTERN.get(), new Item.Settings()));
        OXIDIZED_COPPER_LANTERN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "oxidized_copper_lantern", () -> new BlockItem((Block)ModBlocks.OXIDIZED_COPPER_LANTERN.get(), new Item.Settings()));
        WAXED_COPPER_LANTERN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_copper_lantern", () -> new BlockItem((Block)ModBlocks.WAXED_COPPER_LANTERN.get(), new Item.Settings()));
        WAXED_EXPOSED_COPPER_LANTERN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_exposed_copper_lantern", () -> new BlockItem((Block)ModBlocks.WAXED_EXPOSED_COPPER_LANTERN.get(), new Item.Settings()));
        WAXED_WEATHERED_COPPER_LANTERN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_weathered_copper_lantern", () -> new BlockItem((Block)ModBlocks.WAXED_WEATHERED_COPPER_LANTERN.get(), new Item.Settings()));
        WAXED_OXIDIZED_COPPER_LANTERN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_oxidized_copper_lantern", () -> new BlockItem((Block)ModBlocks.WAXED_OXIDIZED_COPPER_LANTERN.get(), new Item.Settings()));
        COPPER_CHAIN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "copper_chain", () -> new BlockItem((Block)ModBlocks.COPPER_CHAIN.get(), new Item.Settings()));
        EXPOSED_COPPER_CHAIN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "exposed_copper_chain", () -> new BlockItem((Block)ModBlocks.EXPOSED_COPPER_CHAIN.get(), new Item.Settings()));
        WEATHERED_COPPER_CHAIN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "weathered_copper_chain", () -> new BlockItem((Block)ModBlocks.WEATHERED_COPPER_CHAIN.get(), new Item.Settings()));
        OXIDIZED_COPPER_CHAIN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "oxidized_copper_chain", () -> new BlockItem((Block)ModBlocks.OXIDIZED_COPPER_CHAIN.get(), new Item.Settings()));
        WAXED_COPPER_CHAIN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_copper_chain", () -> new BlockItem((Block)ModBlocks.WAXED_COPPER_CHAIN.get(), new Item.Settings()));
        WAXED_EXPOSED_COPPER_CHAIN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_exposed_copper_chain", () -> new BlockItem((Block)ModBlocks.WAXED_EXPOSED_COPPER_CHAIN.get(), new Item.Settings()));
        WAXED_WEATHERED_COPPER_CHAIN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_weathered_copper_chain", () -> new BlockItem((Block)ModBlocks.WAXED_WEATHERED_COPPER_CHAIN.get(), new Item.Settings()));
        WAXED_OXIDIZED_COPPER_CHAIN_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_oxidized_copper_chain", () -> new BlockItem((Block)ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get(), new Item.Settings()));
        COPPER_BARS_ITEM = helper.registerAuto(RegistryKeys.ITEM, "copper_bars", () -> new BlockItem((Block)ModBlocks.COPPER_BARS.get(), new Item.Settings()));
        EXPOSED_COPPER_BARS_ITEM = helper.registerAuto(RegistryKeys.ITEM, "exposed_copper_bars", () -> new BlockItem((Block)ModBlocks.EXPOSED_COPPER_BARS.get(), new Item.Settings()));
        WEATHERED_COPPER_BARS_ITEM = helper.registerAuto(RegistryKeys.ITEM, "weathered_copper_bars", () -> new BlockItem((Block)ModBlocks.WEATHERED_COPPER_BARS.get(), new Item.Settings()));
        OXIDIZED_COPPER_BARS_ITEM = helper.registerAuto(RegistryKeys.ITEM, "oxidized_copper_bars", () -> new BlockItem((Block)ModBlocks.OXIDIZED_COPPER_BARS.get(), new Item.Settings()));
        WAXED_COPPER_BARS_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_copper_bars", () -> new BlockItem((Block)ModBlocks.WAXED_COPPER_BARS.get(), new Item.Settings()));
        WAXED_EXPOSED_COPPER_BARS_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_exposed_copper_bars", () -> new BlockItem((Block)ModBlocks.WAXED_EXPOSED_COPPER_BARS.get(), new Item.Settings()));
        WAXED_WEATHERED_COPPER_BARS_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_weathered_copper_bars", () -> new BlockItem((Block)ModBlocks.WAXED_WEATHERED_COPPER_BARS.get(), new Item.Settings()));
        WAXED_OXIDIZED_COPPER_BARS_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_oxidized_copper_bars", () -> new BlockItem((Block)ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get(), new Item.Settings()));
        EXPOSED_LIGHTNING_ROD_ITEM = helper.registerAuto(RegistryKeys.ITEM, "exposed_lightning_rod", () -> new BlockItem((Block)ModBlocks.EXPOSED_LIGHTNING_ROD.get(), new Item.Settings()));
        WEATHERED_LIGHTNING_ROD_ITEM = helper.registerAuto(RegistryKeys.ITEM, "weathered_lightning_rod", () -> new BlockItem((Block)ModBlocks.WEATHERED_LIGHTNING_ROD.get(), new Item.Settings()));
        OXIDIZED_LIGHTNING_ROD_ITEM = helper.registerAuto(RegistryKeys.ITEM, "oxidized_lightning_rod", () -> new BlockItem((Block)ModBlocks.OXIDIZED_LIGHTNING_ROD.get(), new Item.Settings()));
        WAXED_LIGHTNING_ROD_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_lightning_rod", () -> new BlockItem((Block)ModBlocks.WAXED_LIGHTNING_ROD.get(), new Item.Settings()));
        WAXED_EXPOSED_LIGHTNING_ROD_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_exposed_lightning_rod", () -> new BlockItem((Block)ModBlocks.WAXED_EXPOSED_LIGHTNING_ROD.get(), new Item.Settings()));
        WAXED_WEATHERED_LIGHTNING_ROD_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_weathered_lightning_rod", () -> new BlockItem((Block)ModBlocks.WAXED_WEATHERED_LIGHTNING_ROD.get(), new Item.Settings()));
        WAXED_OXIDIZED_LIGHTNING_ROD_ITEM = helper.registerAuto(RegistryKeys.ITEM, "waxed_oxidized_lightning_rod", () -> new BlockItem((Block)ModBlocks.WAXED_OXIDIZED_LIGHTNING_ROD.get(), new Item.Settings()));
        COPPER_AXE = helper.registerAuto(RegistryKeys.ITEM, "copper_axe", () -> new AxeItem((ToolMaterial)CopperTier.INSTANCE, new Item.Settings().maxCount(1).attributeModifiers(AxeItem.createAttributeModifiers((ToolMaterial)CopperTier.INSTANCE, (float)7.0f, (float)-3.2f))));
        COPPER_PICKAXE = helper.registerAuto(RegistryKeys.ITEM, "copper_pickaxe", () -> new PickaxeItem((ToolMaterial)CopperTier.INSTANCE, new Item.Settings().maxCount(1).attributeModifiers(PickaxeItem.createAttributeModifiers((ToolMaterial)CopperTier.INSTANCE, (float)1.0f, (float)-2.8f))));
        COPPER_SHOVEL = helper.registerAuto(RegistryKeys.ITEM, "copper_shovel", () -> new ShovelItem((ToolMaterial)CopperTier.INSTANCE, new Item.Settings().maxCount(1).attributeModifiers(ShovelItem.createAttributeModifiers((ToolMaterial)CopperTier.INSTANCE, (float)1.5f, (float)-3.0f))));
        COPPER_HOE = helper.registerAuto(RegistryKeys.ITEM, "copper_hoe", () -> new HoeItem((ToolMaterial)CopperTier.INSTANCE, new Item.Settings().maxCount(1).attributeModifiers(HoeItem.createAttributeModifiers((ToolMaterial)CopperTier.INSTANCE, (float)-1.0f, (float)-2.0f))));
        COPPER_SWORD = helper.registerAuto(RegistryKeys.ITEM, "copper_sword", () -> new SwordItem((ToolMaterial)CopperTier.INSTANCE, new Item.Settings().maxCount(1).attributeModifiers(SwordItem.createAttributeModifiers((ToolMaterial)CopperTier.INSTANCE, (int)3, (float)-2.4f))));
        COPPER_NUGGET = helper.registerAuto(RegistryKeys.ITEM, "copper_nugget", () -> new Item(new Item.Settings()));
        COPPER_HELMET = helper.registerAuto(RegistryKeys.ITEM, "copper_helmet", () -> new ArmorItem(CopperArmorMaterial.COPPER.get(), ArmorItem.Type.HELMET, new Item.Settings().maxCount(1)));
        COPPER_CHESTPLATE = helper.registerAuto(RegistryKeys.ITEM, "copper_chestplate", () -> new ArmorItem(CopperArmorMaterial.COPPER.get(), ArmorItem.Type.CHESTPLATE, new Item.Settings().maxCount(1)));
        COPPER_LEGGINGS = helper.registerAuto(RegistryKeys.ITEM, "copper_leggings", () -> new ArmorItem(CopperArmorMaterial.COPPER.get(), ArmorItem.Type.LEGGINGS, new Item.Settings().maxCount(1)));
        COPPER_BOOTS = helper.registerAuto(RegistryKeys.ITEM, "copper_boots", () -> new ArmorItem(CopperArmorMaterial.COPPER.get(), ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1)));
        COPPER_HORSE_ARMOR = helper.registerAuto(RegistryKeys.ITEM, "copper_horse_armor", () -> new AnimalArmorItem(CopperArmorMaterial.COPPER.get(), AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    }
}


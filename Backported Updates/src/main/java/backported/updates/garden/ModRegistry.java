/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.registry.FuelRegistry
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.Item$Settings
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.registry.Registry
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.Registries
 */
package backported.updates.garden;

import backported.updates.garden.Init;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;

public class ModRegistry {
    public static void registerItems() {
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_oak_log"), new BlockItem(Init.PALE_OAK_LOG, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_short_grass"), new BlockItem(Init.PALE_SHORT_GRASS, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_moss_block"), new BlockItem(Init.PALE_MOSS_BLOCK, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_moss_carpet"), new BlockItem(Init.PALE_MOSS_CARPET, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_oak_planks"), new BlockItem(Init.PALE_OAK_PLANKS, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_oak_stairs"), new BlockItem(Init.PALE_OAK_STRAIRS, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_oak_slab"), new BlockItem(Init.PALE_OAK_SLAB, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_oak_fence"), new BlockItem(Init.PALE_OAK_FENCE, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_oak_fence_gate"), new BlockItem(Init.PALE_OAK_FENCE_GATE, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_oak_sapling"), new BlockItem(Init.PALE_OAK_SAPLING, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_oak_leaves"), new BlockItem(Init.PALE_OAK_LEAVES, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_oak_button"), new BlockItem(Init.PALE_OAK_BUTTON, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_oak_pressure_plate"), new BlockItem(Init.PALE_OAK_PRESSURE_PLATE, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_oak_door"), new BlockItem(Init.PALE_OAK_DOOR, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_oak_trapdoor"), new BlockItem(Init.PALE_OAK_TRAPDOOR, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_hanging_moss"), new BlockItem(Init.PALE_HANGING_MOSS, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"stripped_pale_oak_log"), new BlockItem(Init.STRIPPED_PALE_OAK_LOG, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"pale_oak_wood"), new BlockItem(Init.PALE_OAK_WOOD, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"stripped_pale_oak_wood"), new BlockItem(Init.STRIPPED_PALE_OAK_WOOD, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"creaking_spawn_egg"), Init.CREAKING_SPAWN_EGG);
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"closed_eyeblossom"), new BlockItem(Init.CLOSED_EYE_BLOSSOM_BLOCK, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"open_eyeblossom"), new BlockItem(Init.OPEN_EYE_BLOSSOM_BLOCK, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"creaking_heart"), new BlockItem(Init.CREAKING_HEART, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"resin_block"), new BlockItem(Init.RESIN_BLOCK, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"resin_bricks"), new BlockItem(Init.RESIN_BRICKS, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"chiseled_resin_bricks"), new BlockItem(Init.CHISELED_RESIN_BRICK, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"resin_brick_slab"), new BlockItem(Init.RESIN_BRICK_SLAB, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"resin_brick_stairs"), new BlockItem(Init.RESIN_BRICK_STAIRS, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"resin_brick_wall"), new BlockItem(Init.RESIN_BRICK_WALL, new Item.Settings()));
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"resin_clump"), Init.RESIN_CLUMP);
        Registry.register((Registry)Registries.ITEM, Identifier.of((String)"iwie", (String)"resin_brick"), Init.RESIN_BRICK);
    }

    public static void registerBlocks() {
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_oak_log"), Init.PALE_OAK_LOG);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_short_grass"), Init.PALE_SHORT_GRASS);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_moss_block"), Init.PALE_MOSS_BLOCK);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_moss_carpet"), Init.PALE_MOSS_CARPET);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_oak_planks"), Init.PALE_OAK_PLANKS);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_oak_stairs"), Init.PALE_OAK_STRAIRS);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_oak_slab"), Init.PALE_OAK_SLAB);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_oak_fence"), Init.PALE_OAK_FENCE);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_oak_fence_gate"), Init.PALE_OAK_FENCE_GATE);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_oak_sapling"), Init.PALE_OAK_SAPLING);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_oak_leaves"), Init.PALE_OAK_LEAVES);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_oak_button"), Init.PALE_OAK_BUTTON);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"potted_pale_oak_sapling"), Init.POTTED_PALE_OAK_SAPLING);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"potted_closed_eyeblossom"), Init.POTTED_CLOSED_EYE_BLOSSOM);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"potted_open_eyeblossom"), Init.POTTED_OPEN_EYE_BLOSSOM);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_oak_pressure_plate"), Init.PALE_OAK_PRESSURE_PLATE);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_oak_door"), Init.PALE_OAK_DOOR);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_oak_trapdoor"), Init.PALE_OAK_TRAPDOOR);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_hanging_moss"), Init.PALE_HANGING_MOSS);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_hanging_moss_plant"), Init.PALE_HANGING_MOSS_PLANT);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"stripped_pale_oak_log"), Init.STRIPPED_PALE_OAK_LOG);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"pale_oak_wood"), Init.PALE_OAK_WOOD);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"stripped_pale_oak_wood"), Init.STRIPPED_PALE_OAK_WOOD);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"creaking_heart"), Init.CREAKING_HEART);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"closed_eyeblossom"), Init.CLOSED_EYE_BLOSSOM_BLOCK);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"open_eyeblossom"), Init.OPEN_EYE_BLOSSOM_BLOCK);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"resin_block"), Init.RESIN_BLOCK);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"resin_bricks"), Init.RESIN_BRICKS);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"chiseled_resin_bricks"), Init.CHISELED_RESIN_BRICK);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"resin_brick_slab"), Init.RESIN_BRICK_SLAB);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"resin_brick_stairs"), Init.RESIN_BRICK_STAIRS);
        Registry.register((Registry)Registries.BLOCK, Identifier.of((String)"iwie", (String)"resin_brick_wall"), Init.RESIN_BRICK_WALL);
    }

    public static void registerFuel() {
        FuelRegistry.INSTANCE.add((ItemConvertible)Init.PALE_OAK_LOG, 300);
        FuelRegistry.INSTANCE.add((ItemConvertible)Init.PALE_OAK_PLANKS, 300);
        FuelRegistry.INSTANCE.add((ItemConvertible)Init.PALE_OAK_STRAIRS, 150);
        FuelRegistry.INSTANCE.add((ItemConvertible)Init.PALE_OAK_SLAB, 150);
        FuelRegistry.INSTANCE.add((ItemConvertible)Init.PALE_OAK_FENCE, 300);
        FuelRegistry.INSTANCE.add((ItemConvertible)Init.PALE_OAK_FENCE_GATE, 300);
        FuelRegistry.INSTANCE.add((ItemConvertible)Init.PALE_OAK_WOOD, 300);
        FuelRegistry.INSTANCE.add((ItemConvertible)Init.STRIPPED_PALE_OAK_LOG, 300);
        FuelRegistry.INSTANCE.add((ItemConvertible)Init.STRIPPED_PALE_OAK_WOOD, 300);
    }
}


package com.itemuncrafting;

import com.itemuncrafting.block.UncraftedCrateBlock;
import com.itemuncrafting.block.entity.UncraftedCrateBlockEntity;
import com.itemuncrafting.component.UncraftedItems;
import com.itemuncrafting.item.UncraftedCrateItem;
import com.itemuncrafting.recipe.UncraftingRecipe;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemUncrafting implements ModInitializer {
    public static final String MOD_ID = "item_uncrafting";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Component
    public static final DataComponentType<UncraftedItems> UNCRAFTED_ITEMS = Registry.register(
        BuiltInRegistries.DATA_COMPONENT_TYPE,
        Identifier.fromNamespaceAndPath(MOD_ID, "uncrafted_items"),
        DataComponentType.<UncraftedItems>builder()
            .persistent(UncraftedItems.CODEC)
            .networkSynchronized(UncraftedItems.STREAM_CODEC)
            .build()
    );

    public static final Identifier UNCRAFTED_CRATE_ID = Identifier.fromNamespaceAndPath(MOD_ID, "uncrafted_crate");

    // Block
    public static final Block UNCRAFTED_CRATE_BLOCK = Registry.register(
        BuiltInRegistries.BLOCK,
        UNCRAFTED_CRATE_ID,
        new UncraftedCrateBlock(BlockBehaviour.Properties.of()
            .setId(net.minecraft.resources.ResourceKey.create(net.minecraft.core.registries.Registries.BLOCK, UNCRAFTED_CRATE_ID))
            .strength(1.5f, 6.0f))
    );

    // BlockEntity
    public static final BlockEntityType<UncraftedCrateBlockEntity> UNCRAFTED_CRATE_BLOCK_ENTITY = Registry.register(
        BuiltInRegistries.BLOCK_ENTITY_TYPE,
        UNCRAFTED_CRATE_ID,
        new BlockEntityType<>(UncraftedCrateBlockEntity::new, java.util.Set.of(UNCRAFTED_CRATE_BLOCK))
    );

    // Item
    public static final Item UNCRAFTED_CRATE_ITEM = Registry.register(
        BuiltInRegistries.ITEM,
        UNCRAFTED_CRATE_ID,
        new UncraftedCrateItem(UNCRAFTED_CRATE_BLOCK, new Item.Properties()
            .setId(net.minecraft.resources.ResourceKey.create(net.minecraft.core.registries.Registries.ITEM, UNCRAFTED_CRATE_ID))
            .stacksTo(64))
    );

    // Recipe Serializer
    public static final RecipeSerializer<UncraftingRecipe> UNCRAFTING_RECIPE_SERIALIZER = Registry.register(
        BuiltInRegistries.RECIPE_SERIALIZER,
        Identifier.fromNamespaceAndPath(MOD_ID, "uncrafting"),
        new RecipeSerializer<>(UncraftingRecipe.CODEC, UncraftingRecipe.STREAM_CODEC)
    );

    @Override
    public void onInitialize() {
        LOGGER.info("Item Uncrafting Mod initialized.");
    }
}

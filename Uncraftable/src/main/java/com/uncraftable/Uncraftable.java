package com.uncraftable;

import com.uncraftable.block.UncraftableCrateBlock;
import com.uncraftable.block.entity.UncraftableCrateBlockEntity;
import com.uncraftable.component.UncraftableItems;
import com.uncraftable.item.UncraftableCrateItem;
import com.uncraftable.recipe.UncraftingRecipe;
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

public class Uncraftable implements ModInitializer {
    public static final String MOD_ID = "uncraftable";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Component
    public static final DataComponentType<UncraftableItems> UNCRAFTABLE_ITEMS = Registry.register(
        BuiltInRegistries.DATA_COMPONENT_TYPE,
        Identifier.fromNamespaceAndPath(MOD_ID, "uncraftable_items"),
        DataComponentType.<UncraftableItems>builder()
            .persistent(UncraftableItems.CODEC)
            .networkSynchronized(UncraftableItems.STREAM_CODEC)
            .build()
    );

    public static final Identifier UNCRAFTABLE_CRATE_ID = Identifier.fromNamespaceAndPath(MOD_ID, "uncraftable_crate");

    // Block
    public static final Block UNCRAFTABLE_CRATE_BLOCK = Registry.register(
        BuiltInRegistries.BLOCK,
        UNCRAFTABLE_CRATE_ID,
        new UncraftableCrateBlock(BlockBehaviour.Properties.of()
            .sound(net.minecraft.world.level.block.SoundType.STONE)
            .strength(1.5f, 6.0f)
            .setId(net.minecraft.resources.ResourceKey.create(net.minecraft.core.registries.Registries.BLOCK, UNCRAFTABLE_CRATE_ID)))
    );

    // BlockEntity
    public static final BlockEntityType<UncraftableCrateBlockEntity> UNCRAFTABLE_CRATE_BLOCK_ENTITY = Registry.register(
        BuiltInRegistries.BLOCK_ENTITY_TYPE,
        UNCRAFTABLE_CRATE_ID,
        new BlockEntityType<>(UncraftableCrateBlockEntity::new, java.util.Set.of(UNCRAFTABLE_CRATE_BLOCK))
    );

    // Item
    public static final Item UNCRAFTABLE_CRATE_ITEM = Registry.register(
        BuiltInRegistries.ITEM,
        UNCRAFTABLE_CRATE_ID,
        new UncraftableCrateItem(UNCRAFTABLE_CRATE_BLOCK, new Item.Properties()
            .stacksTo(64)
            .setId(net.minecraft.resources.ResourceKey.create(net.minecraft.core.registries.Registries.ITEM, UNCRAFTABLE_CRATE_ID)))
    );

    // Recipe Serializer
    public static final RecipeSerializer<UncraftingRecipe> UNCRAFTING_RECIPE_SERIALIZER = Registry.register(
        BuiltInRegistries.RECIPE_SERIALIZER,
        Identifier.fromNamespaceAndPath(MOD_ID, "uncrafting"),
        new RecipeSerializer<>(UncraftingRecipe.CODEC, UncraftingRecipe.STREAM_CODEC)
    );

    @Override
    public void onInitialize() {
        LOGGER.info("Uncraftable Mod initialized.");
    }
}

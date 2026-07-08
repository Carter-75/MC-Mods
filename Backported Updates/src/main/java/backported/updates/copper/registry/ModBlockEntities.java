/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.entity.BlockEntityType
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.copper.registry;

import backported.updates.copper.Constants;
import backported.updates.copper.block.entity.CopperChestBlockEntity;
import backported.updates.copper.block.entity.CopperGolemStatueBlockEntity;
import backported.updates.copper.block.shelf.ShelfBlockEntity;
import backported.updates.copper.platform.Services;
import backported.updates.copper.registry.ModBlocks;
import backported.updates.copper.registry.RegistryHelper;
import java.util.ArrayList;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.RegistryKeys;

public class ModBlockEntities {
    public static Supplier<BlockEntityType<CopperChestBlockEntity>> COPPER_CHEST_BLOCK_ENTITY;
    public static Supplier<BlockEntityType<CopperGolemStatueBlockEntity>> COPPER_GOLEM_STATUE_BLOCK_ENTITY;
    public static Supplier<BlockEntityType<ShelfBlockEntity>> SHELF_BLOCK_ENTITY;

    public static void register() {
        Constants.LOG.info("Registering block entities for {}", "Copper-Age-Backport");
        RegistryHelper helper = RegistryHelper.getInstance();
        COPPER_CHEST_BLOCK_ENTITY = helper.registerAuto(RegistryKeys.BLOCK_ENTITY_TYPE, "copper_chest", () -> Services.BLOCK_ENTITY.createBlockEntityType(CopperChestBlockEntity::new, (Block)ModBlocks.COPPER_CHEST.get(), (Block)ModBlocks.EXPOSED_COPPER_CHEST.get(), (Block)ModBlocks.WEATHERED_COPPER_CHEST.get(), (Block)ModBlocks.OXIDIZED_COPPER_CHEST.get(), (Block)ModBlocks.WAXED_COPPER_CHEST.get(), (Block)ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get(), (Block)ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get(), (Block)ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get()));
        COPPER_GOLEM_STATUE_BLOCK_ENTITY = helper.registerAuto(RegistryKeys.BLOCK_ENTITY_TYPE, "copper_golem_statue", () -> Services.BLOCK_ENTITY.createBlockEntityType(CopperGolemStatueBlockEntity::new, (Block)ModBlocks.COPPER_GOLEM_STATUE.get(), (Block)ModBlocks.EXPOSED_COPPER_GOLEM_STATUE.get(), (Block)ModBlocks.WEATHERED_COPPER_GOLEM_STATUE.get(), (Block)ModBlocks.OXIDIZED_COPPER_GOLEM_STATUE.get(), (Block)ModBlocks.WAXED_COPPER_GOLEM_STATUE.get(), (Block)ModBlocks.WAXED_EXPOSED_COPPER_GOLEM_STATUE.get(), (Block)ModBlocks.WAXED_WEATHERED_COPPER_GOLEM_STATUE.get(), (Block)ModBlocks.WAXED_OXIDIZED_COPPER_GOLEM_STATUE.get()));
        SHELF_BLOCK_ENTITY = helper.registerAuto(RegistryKeys.BLOCK_ENTITY_TYPE, "shelf", () -> {
            ArrayList<Block> shelfBlocks = new ArrayList<Block>();
            shelfBlocks.add((Block)ModBlocks.OAK_SHELF.get());
            shelfBlocks.add((Block)ModBlocks.SPRUCE_SHELF.get());
            shelfBlocks.add((Block)ModBlocks.BIRCH_SHELF.get());
            shelfBlocks.add((Block)ModBlocks.JUNGLE_SHELF.get());
            shelfBlocks.add((Block)ModBlocks.ACACIA_SHELF.get());
            shelfBlocks.add((Block)ModBlocks.DARK_OAK_SHELF.get());
            shelfBlocks.add((Block)ModBlocks.MANGROVE_SHELF.get());
            shelfBlocks.add((Block)ModBlocks.CHERRY_SHELF.get());
            shelfBlocks.add((Block)ModBlocks.BAMBOO_SHELF.get());
            shelfBlocks.add((Block)ModBlocks.CRIMSON_SHELF.get());
            shelfBlocks.add((Block)ModBlocks.WARPED_SHELF.get());
            if (ModBlocks.PALE_OAK_SHELF != null) {
                shelfBlocks.add((Block)ModBlocks.PALE_OAK_SHELF.get());
            }
            return Services.BLOCK_ENTITY.createBlockEntityType(ShelfBlockEntity::new, shelfBlocks.toArray(new Block[0]));
        });
    }
}


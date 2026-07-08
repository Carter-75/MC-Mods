/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2591
 *  net.minecraft.class_7924
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
import net.minecraft.class_2248;
import net.minecraft.class_2591;
import net.minecraft.class_7924;

public class ModBlockEntities {
    public static Supplier<class_2591<CopperChestBlockEntity>> COPPER_CHEST_BLOCK_ENTITY;
    public static Supplier<class_2591<CopperGolemStatueBlockEntity>> COPPER_GOLEM_STATUE_BLOCK_ENTITY;
    public static Supplier<class_2591<ShelfBlockEntity>> SHELF_BLOCK_ENTITY;

    public static void register() {
        Constants.LOG.info("Registering block entities for {}", (Object)"Copper-Age-Backport");
        RegistryHelper helper = RegistryHelper.getInstance();
        COPPER_CHEST_BLOCK_ENTITY = helper.registerAuto(class_7924.field_41255, "copper_chest", () -> Services.BLOCK_ENTITY.createBlockEntityType(CopperChestBlockEntity::new, (class_2248)ModBlocks.COPPER_CHEST.get(), (class_2248)ModBlocks.EXPOSED_COPPER_CHEST.get(), (class_2248)ModBlocks.WEATHERED_COPPER_CHEST.get(), (class_2248)ModBlocks.OXIDIZED_COPPER_CHEST.get(), (class_2248)ModBlocks.WAXED_COPPER_CHEST.get(), (class_2248)ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get(), (class_2248)ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get(), (class_2248)ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get()));
        COPPER_GOLEM_STATUE_BLOCK_ENTITY = helper.registerAuto(class_7924.field_41255, "copper_golem_statue", () -> Services.BLOCK_ENTITY.createBlockEntityType(CopperGolemStatueBlockEntity::new, (class_2248)ModBlocks.COPPER_GOLEM_STATUE.get(), (class_2248)ModBlocks.EXPOSED_COPPER_GOLEM_STATUE.get(), (class_2248)ModBlocks.WEATHERED_COPPER_GOLEM_STATUE.get(), (class_2248)ModBlocks.OXIDIZED_COPPER_GOLEM_STATUE.get(), (class_2248)ModBlocks.WAXED_COPPER_GOLEM_STATUE.get(), (class_2248)ModBlocks.WAXED_EXPOSED_COPPER_GOLEM_STATUE.get(), (class_2248)ModBlocks.WAXED_WEATHERED_COPPER_GOLEM_STATUE.get(), (class_2248)ModBlocks.WAXED_OXIDIZED_COPPER_GOLEM_STATUE.get()));
        SHELF_BLOCK_ENTITY = helper.registerAuto(class_7924.field_41255, "shelf", () -> {
            ArrayList<class_2248> shelfBlocks = new ArrayList<class_2248>();
            shelfBlocks.add((class_2248)ModBlocks.OAK_SHELF.get());
            shelfBlocks.add((class_2248)ModBlocks.SPRUCE_SHELF.get());
            shelfBlocks.add((class_2248)ModBlocks.BIRCH_SHELF.get());
            shelfBlocks.add((class_2248)ModBlocks.JUNGLE_SHELF.get());
            shelfBlocks.add((class_2248)ModBlocks.ACACIA_SHELF.get());
            shelfBlocks.add((class_2248)ModBlocks.DARK_OAK_SHELF.get());
            shelfBlocks.add((class_2248)ModBlocks.MANGROVE_SHELF.get());
            shelfBlocks.add((class_2248)ModBlocks.CHERRY_SHELF.get());
            shelfBlocks.add((class_2248)ModBlocks.BAMBOO_SHELF.get());
            shelfBlocks.add((class_2248)ModBlocks.CRIMSON_SHELF.get());
            shelfBlocks.add((class_2248)ModBlocks.WARPED_SHELF.get());
            if (ModBlocks.PALE_OAK_SHELF != null) {
                shelfBlocks.add((class_2248)ModBlocks.PALE_OAK_SHELF.get());
            }
            return Services.BLOCK_ENTITY.createBlockEntityType(ShelfBlockEntity::new, shelfBlocks.toArray(new class_2248[0]));
        });
    }
}


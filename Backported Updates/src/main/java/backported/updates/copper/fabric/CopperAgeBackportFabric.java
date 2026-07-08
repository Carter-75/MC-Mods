/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ModInitializer
 *  net.fabricmc.fabric.api.event.player.UseBlockCallback
 *  net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.util.ActionResult
 *  net.minecraft.item.ItemPlacementContext
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.world.World
 *  net.minecraft.block.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.block.BlockState
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.entity.attribute.DefaultAttributeContainer$Builder
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.item.ItemGroups
 */
package backported.updates.copper.fabric;

import backported.updates.copper.CommonClass;
import backported.updates.copper.config.CommonConfig;
import backported.updates.copper.event.CopperGolemSpawnLogic;
import backported.updates.copper.event.PlayerJoinHandler;
import backported.updates.copper.fabric.loot.FabricLootTableModifier;
import backported.updates.copper.fabric.platform.FabricRegistryHelper;
import backported.updates.copper.registry.ModEntities;
import backported.updates.copper.registry.ModItems;
import backported.updates.copper.registry.RegistryHelper;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ItemConvertible;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.registry.RegistryKey;
import net.minecraft.item.ItemGroups;

public class CopperAgeBackportFabric
implements ModInitializer {
    public void onInitialize() {
        CommonConfig.init(FabricLoader.getInstance().getConfigDir());
        RegistryHelper.setInstance(new FabricRegistryHelper());
        CommonClass.init();
        this.registerEvents();
        this.registerCreativeTabs();
        this.registerEntityAttributes();
        FabricLootTableModifier.register();
        RegistryHelper.getInstance().flushRegistrationCallbacks();
    }

    private void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.COPPER_GOLEM.get(), (DefaultAttributeContainer.Builder)CommonClass.getCopperGolemAttributes());
    }

    private void registerEvents() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> PlayerJoinHandler.onPlayerJoin(handler.getPlayer()));
        UseBlockCallback.EVENT.register((player, level, hand, hitResult) -> {
            if (player == null || level.isClient()) {
                return ActionResult.PASS;
            }
            ItemStack stack = player.getStackInHand(hand);
            if (!stack.isOf(Items.CARVED_PUMPKIN)) {
                return ActionResult.PASS;
            }
            if (!(level instanceof ServerWorld)) {
                return ActionResult.PASS;
            }
            ServerWorld serverLevel = (ServerWorld)level;
            ItemPlacementContext context = new ItemPlacementContext(level, player, hand, stack, hitResult);
            BlockPos placePos = context.getBlockPos();
            Direction direction = Direction.fromRotation((double)player.getYaw());
            serverLevel.getServer().execute(() -> {
                if (!serverLevel.canSetBlock(placePos)) {
                    return;
                }
                BlockState placedState = serverLevel.getBlockState(placePos);
                if (!placedState.isOf(Blocks.CARVED_PUMPKIN)) {
                    return;
                }
                CopperGolemSpawnLogic.handleBlockPlaced((World)serverLevel, placePos, placedState, direction);
            });
            return ActionResult.PASS;
        });
    }

    private void registerCreativeTabs() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.add((ItemConvertible)ModItems.COPPER_GOLEM_SPAWN_EGG.get()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter((ItemConvertible)Items.CHEST, new ItemConvertible[]{(ItemConvertible)ModItems.COPPER_CHEST_ITEM.get(), (ItemConvertible)ModItems.EXPOSED_COPPER_CHEST_ITEM.get(), (ItemConvertible)ModItems.WEATHERED_COPPER_CHEST_ITEM.get(), (ItemConvertible)ModItems.OXIDIZED_COPPER_CHEST_ITEM.get(), (ItemConvertible)ModItems.WAXED_COPPER_CHEST_ITEM.get(), (ItemConvertible)ModItems.WAXED_EXPOSED_COPPER_CHEST_ITEM.get(), (ItemConvertible)ModItems.WAXED_WEATHERED_COPPER_CHEST_ITEM.get(), (ItemConvertible)ModItems.WAXED_OXIDIZED_COPPER_CHEST_ITEM.get()});
            entries.addAfter((ItemConvertible)Items.LIGHTNING_ROD, new ItemConvertible[]{(ItemConvertible)ModItems.EXPOSED_LIGHTNING_ROD_ITEM.get(), (ItemConvertible)ModItems.WEATHERED_LIGHTNING_ROD_ITEM.get(), (ItemConvertible)ModItems.OXIDIZED_LIGHTNING_ROD_ITEM.get(), (ItemConvertible)ModItems.WAXED_LIGHTNING_ROD_ITEM.get(), (ItemConvertible)ModItems.WAXED_EXPOSED_LIGHTNING_ROD_ITEM.get(), (ItemConvertible)ModItems.WAXED_WEATHERED_LIGHTNING_ROD_ITEM.get(), (ItemConvertible)ModItems.WAXED_OXIDIZED_LIGHTNING_ROD_ITEM.get()});
            entries.add((ItemConvertible)ModItems.COPPER_GOLEM_STATUE_ITEM.get());
            entries.add((ItemConvertible)ModItems.EXPOSED_COPPER_GOLEM_STATUE_ITEM.get());
            entries.add((ItemConvertible)ModItems.WEATHERED_COPPER_GOLEM_STATUE_ITEM.get());
            entries.add((ItemConvertible)ModItems.OXIDIZED_COPPER_GOLEM_STATUE_ITEM.get());
            entries.add((ItemConvertible)ModItems.WAXED_COPPER_GOLEM_STATUE_ITEM.get());
            entries.add((ItemConvertible)ModItems.WAXED_EXPOSED_COPPER_GOLEM_STATUE_ITEM.get());
            entries.add((ItemConvertible)ModItems.WAXED_WEATHERED_COPPER_GOLEM_STATUE_ITEM.get());
            entries.add((ItemConvertible)ModItems.WAXED_OXIDIZED_COPPER_GOLEM_STATUE_ITEM.get());
            entries.addAfter((ItemConvertible)Items.SOUL_LANTERN, new ItemConvertible[]{(ItemConvertible)ModItems.COPPER_LANTERN_ITEM.get(), (ItemConvertible)ModItems.EXPOSED_COPPER_LANTERN_ITEM.get(), (ItemConvertible)ModItems.WEATHERED_COPPER_LANTERN_ITEM.get(), (ItemConvertible)ModItems.OXIDIZED_COPPER_LANTERN_ITEM.get(), (ItemConvertible)ModItems.WAXED_COPPER_LANTERN_ITEM.get(), (ItemConvertible)ModItems.WAXED_EXPOSED_COPPER_LANTERN_ITEM.get(), (ItemConvertible)ModItems.WAXED_WEATHERED_COPPER_LANTERN_ITEM.get(), (ItemConvertible)ModItems.WAXED_OXIDIZED_COPPER_LANTERN_ITEM.get()});
            entries.addAfter((ItemConvertible)Items.SOUL_TORCH, new ItemConvertible[]{(ItemConvertible)ModItems.COPPER_TORCH_ITEM.get()});
            entries.addAfter((ItemConvertible)Items.CHISELED_BOOKSHELF, new ItemConvertible[]{(ItemConvertible)ModItems.OAK_SHELF_ITEM.get(), (ItemConvertible)ModItems.SPRUCE_SHELF_ITEM.get(), (ItemConvertible)ModItems.BIRCH_SHELF_ITEM.get(), (ItemConvertible)ModItems.JUNGLE_SHELF_ITEM.get(), (ItemConvertible)ModItems.ACACIA_SHELF_ITEM.get(), (ItemConvertible)ModItems.DARK_OAK_SHELF_ITEM.get(), (ItemConvertible)ModItems.MANGROVE_SHELF_ITEM.get(), (ItemConvertible)ModItems.CHERRY_SHELF_ITEM.get(), (ItemConvertible)ModItems.BAMBOO_SHELF_ITEM.get(), (ItemConvertible)ModItems.CRIMSON_SHELF_ITEM.get(), (ItemConvertible)ModItems.WARPED_SHELF_ITEM.get()});
            if (ModItems.PALE_OAK_SHELF_ITEM != null) {
                entries.addAfter((ItemConvertible)ModItems.WARPED_SHELF_ITEM.get(), new ItemConvertible[]{(ItemConvertible)ModItems.PALE_OAK_SHELF_ITEM.get()});
            }
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> entries.addAfter((ItemConvertible)Items.STONE_BUTTON, new ItemConvertible[]{(ItemConvertible)ModItems.COPPER_BUTTON_ITEM.get(), (ItemConvertible)ModItems.EXPOSED_COPPER_BUTTON_ITEM.get(), (ItemConvertible)ModItems.WEATHERED_COPPER_BUTTON_ITEM.get(), (ItemConvertible)ModItems.OXIDIZED_COPPER_BUTTON_ITEM.get(), (ItemConvertible)ModItems.WAXED_COPPER_BUTTON_ITEM.get(), (ItemConvertible)ModItems.WAXED_EXPOSED_COPPER_BUTTON_ITEM.get(), (ItemConvertible)ModItems.WAXED_WEATHERED_COPPER_BUTTON_ITEM.get(), (ItemConvertible)ModItems.WAXED_OXIDIZED_COPPER_BUTTON_ITEM.get()}));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.addAfter((ItemConvertible)Items.STONE_HOE, new ItemConvertible[]{(ItemConvertible)ModItems.COPPER_SHOVEL.get(), (ItemConvertible)ModItems.COPPER_PICKAXE.get(), (ItemConvertible)ModItems.COPPER_AXE.get(), (ItemConvertible)ModItems.COPPER_HOE.get()}));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.addAfter((ItemConvertible)Items.STONE_SWORD, new ItemConvertible[]{(ItemConvertible)ModItems.COPPER_SWORD.get()});
            entries.addAfter((ItemConvertible)Items.CHAINMAIL_BOOTS, new ItemConvertible[]{(ItemConvertible)ModItems.COPPER_HELMET.get(), (ItemConvertible)ModItems.COPPER_CHESTPLATE.get(), (ItemConvertible)ModItems.COPPER_LEGGINGS.get(), (ItemConvertible)ModItems.COPPER_BOOTS.get()});
            entries.addAfter((ItemConvertible)Items.LEATHER_HORSE_ARMOR, new ItemConvertible[]{(ItemConvertible)ModItems.COPPER_HORSE_ARMOR.get()});
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.addAfter((ItemConvertible)Items.IRON_NUGGET, new ItemConvertible[]{(ItemConvertible)ModItems.COPPER_NUGGET.get()}));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter((ItemConvertible)Items.CUT_COPPER_SLAB, new ItemConvertible[]{(ItemConvertible)ModItems.COPPER_BARS_ITEM.get(), (ItemConvertible)ModItems.COPPER_CHAIN_ITEM.get()});
            entries.addAfter((ItemConvertible)Items.EXPOSED_CUT_COPPER_SLAB, new ItemConvertible[]{(ItemConvertible)ModItems.EXPOSED_COPPER_BARS_ITEM.get(), (ItemConvertible)ModItems.EXPOSED_COPPER_CHAIN_ITEM.get()});
            entries.addAfter((ItemConvertible)Items.WEATHERED_CUT_COPPER_SLAB, new ItemConvertible[]{(ItemConvertible)ModItems.WEATHERED_COPPER_BARS_ITEM.get(), (ItemConvertible)ModItems.WEATHERED_COPPER_CHAIN_ITEM.get()});
            entries.addAfter((ItemConvertible)Items.OXIDIZED_CUT_COPPER_SLAB, new ItemConvertible[]{(ItemConvertible)ModItems.OXIDIZED_COPPER_BARS_ITEM.get(), (ItemConvertible)ModItems.OXIDIZED_COPPER_CHAIN_ITEM.get()});
            entries.addAfter((ItemConvertible)Items.WAXED_CUT_COPPER_SLAB, new ItemConvertible[]{(ItemConvertible)ModItems.WAXED_COPPER_BARS_ITEM.get(), (ItemConvertible)ModItems.WAXED_COPPER_CHAIN_ITEM.get()});
            entries.addAfter((ItemConvertible)Items.WAXED_EXPOSED_CUT_COPPER_SLAB, new ItemConvertible[]{(ItemConvertible)ModItems.WAXED_EXPOSED_COPPER_BARS_ITEM.get(), (ItemConvertible)ModItems.WAXED_EXPOSED_COPPER_CHAIN_ITEM.get()});
            entries.addAfter((ItemConvertible)Items.WAXED_WEATHERED_CUT_COPPER_SLAB, new ItemConvertible[]{(ItemConvertible)ModItems.WAXED_WEATHERED_COPPER_BARS_ITEM.get(), (ItemConvertible)ModItems.WAXED_WEATHERED_COPPER_CHAIN_ITEM.get()});
            entries.addAfter((ItemConvertible)Items.WAXED_OXIDIZED_CUT_COPPER_SLAB, new ItemConvertible[]{(ItemConvertible)ModItems.WAXED_OXIDIZED_COPPER_BARS_ITEM.get(), (ItemConvertible)ModItems.WAXED_OXIDIZED_COPPER_CHAIN_ITEM.get()});
        });
    }
}


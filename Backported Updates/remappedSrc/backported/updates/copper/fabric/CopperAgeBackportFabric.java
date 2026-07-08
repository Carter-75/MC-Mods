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
 *  net.minecraft.class_1269
 *  net.minecraft.class_1750
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5321
 *  net.minecraft.class_7706
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
import net.minecraft.class_1269;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_5132;
import net.minecraft.class_5321;
import net.minecraft.class_7706;

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
        FabricDefaultAttributeRegistry.register(ModEntities.COPPER_GOLEM.get(), (class_5132.class_5133)CommonClass.getCopperGolemAttributes());
    }

    private void registerEvents() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> PlayerJoinHandler.onPlayerJoin(handler.method_32311()));
        UseBlockCallback.EVENT.register((player, level, hand, hitResult) -> {
            if (player == null || level.method_8608()) {
                return class_1269.field_5811;
            }
            class_1799 stack = player.method_5998(hand);
            if (!stack.method_31574(class_1802.field_17519)) {
                return class_1269.field_5811;
            }
            if (!(level instanceof class_3218)) {
                return class_1269.field_5811;
            }
            class_3218 serverLevel = (class_3218)level;
            class_1750 context = new class_1750(level, player, hand, stack, hitResult);
            class_2338 placePos = context.method_8037();
            class_2350 direction = class_2350.method_10150((double)player.method_36454());
            serverLevel.method_8503().execute(() -> {
                if (!serverLevel.method_8477(placePos)) {
                    return;
                }
                class_2680 placedState = serverLevel.method_8320(placePos);
                if (!placedState.method_27852(class_2246.field_10147)) {
                    return;
                }
                CopperGolemSpawnLogic.handleBlockPlaced((class_1937)serverLevel, placePos, placedState, direction);
            });
            return class_1269.field_5811;
        });
    }

    private void registerCreativeTabs() {
        ItemGroupEvents.modifyEntriesEvent((class_5321)class_7706.field_40205).register(entries -> entries.method_45421((class_1935)ModItems.COPPER_GOLEM_SPAWN_EGG.get()));
        ItemGroupEvents.modifyEntriesEvent((class_5321)class_7706.field_40197).register(entries -> {
            entries.addAfter((class_1935)class_1802.field_8106, new class_1935[]{(class_1935)ModItems.COPPER_CHEST_ITEM.get(), (class_1935)ModItems.EXPOSED_COPPER_CHEST_ITEM.get(), (class_1935)ModItems.WEATHERED_COPPER_CHEST_ITEM.get(), (class_1935)ModItems.OXIDIZED_COPPER_CHEST_ITEM.get(), (class_1935)ModItems.WAXED_COPPER_CHEST_ITEM.get(), (class_1935)ModItems.WAXED_EXPOSED_COPPER_CHEST_ITEM.get(), (class_1935)ModItems.WAXED_WEATHERED_COPPER_CHEST_ITEM.get(), (class_1935)ModItems.WAXED_OXIDIZED_COPPER_CHEST_ITEM.get()});
            entries.addAfter((class_1935)class_1802.field_27051, new class_1935[]{(class_1935)ModItems.EXPOSED_LIGHTNING_ROD_ITEM.get(), (class_1935)ModItems.WEATHERED_LIGHTNING_ROD_ITEM.get(), (class_1935)ModItems.OXIDIZED_LIGHTNING_ROD_ITEM.get(), (class_1935)ModItems.WAXED_LIGHTNING_ROD_ITEM.get(), (class_1935)ModItems.WAXED_EXPOSED_LIGHTNING_ROD_ITEM.get(), (class_1935)ModItems.WAXED_WEATHERED_LIGHTNING_ROD_ITEM.get(), (class_1935)ModItems.WAXED_OXIDIZED_LIGHTNING_ROD_ITEM.get()});
            entries.method_45421((class_1935)ModItems.COPPER_GOLEM_STATUE_ITEM.get());
            entries.method_45421((class_1935)ModItems.EXPOSED_COPPER_GOLEM_STATUE_ITEM.get());
            entries.method_45421((class_1935)ModItems.WEATHERED_COPPER_GOLEM_STATUE_ITEM.get());
            entries.method_45421((class_1935)ModItems.OXIDIZED_COPPER_GOLEM_STATUE_ITEM.get());
            entries.method_45421((class_1935)ModItems.WAXED_COPPER_GOLEM_STATUE_ITEM.get());
            entries.method_45421((class_1935)ModItems.WAXED_EXPOSED_COPPER_GOLEM_STATUE_ITEM.get());
            entries.method_45421((class_1935)ModItems.WAXED_WEATHERED_COPPER_GOLEM_STATUE_ITEM.get());
            entries.method_45421((class_1935)ModItems.WAXED_OXIDIZED_COPPER_GOLEM_STATUE_ITEM.get());
            entries.addAfter((class_1935)class_1802.field_22016, new class_1935[]{(class_1935)ModItems.COPPER_LANTERN_ITEM.get(), (class_1935)ModItems.EXPOSED_COPPER_LANTERN_ITEM.get(), (class_1935)ModItems.WEATHERED_COPPER_LANTERN_ITEM.get(), (class_1935)ModItems.OXIDIZED_COPPER_LANTERN_ITEM.get(), (class_1935)ModItems.WAXED_COPPER_LANTERN_ITEM.get(), (class_1935)ModItems.WAXED_EXPOSED_COPPER_LANTERN_ITEM.get(), (class_1935)ModItems.WAXED_WEATHERED_COPPER_LANTERN_ITEM.get(), (class_1935)ModItems.WAXED_OXIDIZED_COPPER_LANTERN_ITEM.get()});
            entries.addAfter((class_1935)class_1802.field_22001, new class_1935[]{(class_1935)ModItems.COPPER_TORCH_ITEM.get()});
            entries.addAfter((class_1935)class_1802.field_40215, new class_1935[]{(class_1935)ModItems.OAK_SHELF_ITEM.get(), (class_1935)ModItems.SPRUCE_SHELF_ITEM.get(), (class_1935)ModItems.BIRCH_SHELF_ITEM.get(), (class_1935)ModItems.JUNGLE_SHELF_ITEM.get(), (class_1935)ModItems.ACACIA_SHELF_ITEM.get(), (class_1935)ModItems.DARK_OAK_SHELF_ITEM.get(), (class_1935)ModItems.MANGROVE_SHELF_ITEM.get(), (class_1935)ModItems.CHERRY_SHELF_ITEM.get(), (class_1935)ModItems.BAMBOO_SHELF_ITEM.get(), (class_1935)ModItems.CRIMSON_SHELF_ITEM.get(), (class_1935)ModItems.WARPED_SHELF_ITEM.get()});
            if (ModItems.PALE_OAK_SHELF_ITEM != null) {
                entries.addAfter((class_1935)ModItems.WARPED_SHELF_ITEM.get(), new class_1935[]{(class_1935)ModItems.PALE_OAK_SHELF_ITEM.get()});
            }
        });
        ItemGroupEvents.modifyEntriesEvent((class_5321)class_7706.field_40198).register(entries -> entries.addAfter((class_1935)class_1802.field_8781, new class_1935[]{(class_1935)ModItems.COPPER_BUTTON_ITEM.get(), (class_1935)ModItems.EXPOSED_COPPER_BUTTON_ITEM.get(), (class_1935)ModItems.WEATHERED_COPPER_BUTTON_ITEM.get(), (class_1935)ModItems.OXIDIZED_COPPER_BUTTON_ITEM.get(), (class_1935)ModItems.WAXED_COPPER_BUTTON_ITEM.get(), (class_1935)ModItems.WAXED_EXPOSED_COPPER_BUTTON_ITEM.get(), (class_1935)ModItems.WAXED_WEATHERED_COPPER_BUTTON_ITEM.get(), (class_1935)ModItems.WAXED_OXIDIZED_COPPER_BUTTON_ITEM.get()}));
        ItemGroupEvents.modifyEntriesEvent((class_5321)class_7706.field_41060).register(entries -> entries.addAfter((class_1935)class_1802.field_8431, new class_1935[]{(class_1935)ModItems.COPPER_SHOVEL.get(), (class_1935)ModItems.COPPER_PICKAXE.get(), (class_1935)ModItems.COPPER_AXE.get(), (class_1935)ModItems.COPPER_HOE.get()}));
        ItemGroupEvents.modifyEntriesEvent((class_5321)class_7706.field_40202).register(entries -> {
            entries.addAfter((class_1935)class_1802.field_8528, new class_1935[]{(class_1935)ModItems.COPPER_SWORD.get()});
            entries.addAfter((class_1935)class_1802.field_8313, new class_1935[]{(class_1935)ModItems.COPPER_HELMET.get(), (class_1935)ModItems.COPPER_CHESTPLATE.get(), (class_1935)ModItems.COPPER_LEGGINGS.get(), (class_1935)ModItems.COPPER_BOOTS.get()});
            entries.addAfter((class_1935)class_1802.field_18138, new class_1935[]{(class_1935)ModItems.COPPER_HORSE_ARMOR.get()});
        });
        ItemGroupEvents.modifyEntriesEvent((class_5321)class_7706.field_41062).register(entries -> entries.addAfter((class_1935)class_1802.field_8675, new class_1935[]{(class_1935)ModItems.COPPER_NUGGET.get()}));
        ItemGroupEvents.modifyEntriesEvent((class_5321)class_7706.field_40195).register(entries -> {
            entries.addAfter((class_1935)class_1802.field_27035, new class_1935[]{(class_1935)ModItems.COPPER_BARS_ITEM.get(), (class_1935)ModItems.COPPER_CHAIN_ITEM.get()});
            entries.addAfter((class_1935)class_1802.field_27036, new class_1935[]{(class_1935)ModItems.EXPOSED_COPPER_BARS_ITEM.get(), (class_1935)ModItems.EXPOSED_COPPER_CHAIN_ITEM.get()});
            entries.addAfter((class_1935)class_1802.field_27037, new class_1935[]{(class_1935)ModItems.WEATHERED_COPPER_BARS_ITEM.get(), (class_1935)ModItems.WEATHERED_COPPER_CHAIN_ITEM.get()});
            entries.addAfter((class_1935)class_1802.field_27038, new class_1935[]{(class_1935)ModItems.OXIDIZED_COPPER_BARS_ITEM.get(), (class_1935)ModItems.OXIDIZED_COPPER_CHAIN_ITEM.get()});
            entries.addAfter((class_1935)class_1802.field_27048, new class_1935[]{(class_1935)ModItems.WAXED_COPPER_BARS_ITEM.get(), (class_1935)ModItems.WAXED_COPPER_CHAIN_ITEM.get()});
            entries.addAfter((class_1935)class_1802.field_27049, new class_1935[]{(class_1935)ModItems.WAXED_EXPOSED_COPPER_BARS_ITEM.get(), (class_1935)ModItems.WAXED_EXPOSED_COPPER_CHAIN_ITEM.get()});
            entries.addAfter((class_1935)class_1802.field_27050, new class_1935[]{(class_1935)ModItems.WAXED_WEATHERED_COPPER_BARS_ITEM.get(), (class_1935)ModItems.WAXED_WEATHERED_COPPER_CHAIN_ITEM.get()});
            entries.addAfter((class_1935)class_1802.field_33406, new class_1935[]{(class_1935)ModItems.WAXED_OXIDIZED_COPPER_BARS_ITEM.get(), (class_1935)ModItems.WAXED_OXIDIZED_COPPER_CHAIN_ITEM.get()});
        });
    }
}


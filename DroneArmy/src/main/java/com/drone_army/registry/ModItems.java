package com.drone_army.registry;

import com.drone_army.registry.ModEntities;
import net.minecraft.item.SpawnEggItem;
import com.drone_army.DroneArmyMod;
import com.drone_army.item.ControllerItem;
import com.drone_army.item.EssenceItem;
import com.drone_army.item.BoxedRobotItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
        public static final Item ESSENCE = registerItem("essence", new EssenceItem(new Item.Settings()));

        // Controllers
        public static final Item CONTROLLER_TIER_1 = registerItem("controller_tier_1",
                        new ControllerItem(1, new Item.Settings().maxCount(1)));
        public static final Item CONTROLLER_TIER_2 = registerItem("controller_tier_2",
                        new ControllerItem(2, new Item.Settings().maxCount(1)));
        public static final Item CONTROLLER_TIER_3 = registerItem("controller_tier_3",
                        new ControllerItem(3, new Item.Settings().maxCount(1)));
        public static final Item CONTROLLER_TIER_4 = registerItem("controller_tier_4",
                        new ControllerItem(4, new Item.Settings().maxCount(1)));
        public static final Item CONTROLLER_TIER_5 = registerItem("controller_tier_5",
                        new ControllerItem(5, new Item.Settings().maxCount(1)));
        public static final Item CONTROLLER_TIER_6 = registerItem("controller_tier_6",
                        new ControllerItem(6, new Item.Settings().maxCount(1)));
        public static final Item CONTROLLER_TIER_7 = registerItem("controller_tier_7",
                        new ControllerItem(7, new Item.Settings().maxCount(1)));
        public static final Item CONTROLLER_TIER_8 = registerItem("controller_tier_8",
                        new ControllerItem(8, new Item.Settings().maxCount(1)));
        public static final Item CONTROLLER_TIER_9 = registerItem("controller_tier_9",
                        new ControllerItem(9, new Item.Settings().maxCount(1)));
        public static final Item CONTROLLER_TIER_10 = registerItem("controller_tier_10",
                        new ControllerItem(10, new Item.Settings().maxCount(1)));

        // Crafting Items
        public static final Item ROBOT_CORE = registerItem("robot_core", new Item(new Item.Settings()));
        public static final Item CONTROLLER_UPGRADE = registerItem("controller_upgrade", new Item(new Item.Settings()));

        // Spawn Eggs
        public static final Item COMBAT_DRONE_SPAWN_EGG = registerItem("combat_drone_spawn_egg",
                        new SpawnEggItem(ModEntities.COMBAT_DRONE, 0x555555, 0xFF0000, new Item.Settings()));
        public static final Item SENTINEL_SPAWN_EGG = registerItem("sentinel_spawn_egg",
                        new SpawnEggItem(ModEntities.SENTINEL, 0x333333, 0x00FF00, new Item.Settings()));
        public static final Item ARTILLERY_SPAWN_EGG = registerItem("artillery_spawn_egg",
                        new SpawnEggItem(ModEntities.ARTILLERY, 0x666666, 0x0000FF, new Item.Settings()));

        // Boxed Items (For Survival Crafting)
        public static final Item BOXED_COMBAT_DRONE = registerItem("boxed_combat_drone",
                        new BoxedRobotItem(ModEntities.COMBAT_DRONE, new Item.Settings()));
        public static final Item BOXED_SENTINEL = registerItem("boxed_sentinel",
                        new BoxedRobotItem(ModEntities.SENTINEL, new Item.Settings()));
        public static final Item BOXED_ARTILLERY = registerItem("boxed_artillery",
                        new BoxedRobotItem(ModEntities.ARTILLERY, new Item.Settings()));

        private static Item registerItem(String name, Item item) {
                return Registry.register(Registries.ITEM, Identifier.of(DroneArmyMod.MOD_ID, name), item);
        }

        public static void registerModItems() {
                DroneArmyMod.LOGGER.info("Registering Mod Items for " + DroneArmyMod.MOD_ID);

                ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
                        entries.add(ESSENCE);
                        entries.add(ROBOT_CORE);
                        entries.add(CONTROLLER_UPGRADE);
                        entries.add(BOXED_COMBAT_DRONE);
                        entries.add(BOXED_SENTINEL);
                        entries.add(BOXED_ARTILLERY);
                });

                ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
                        entries.add(COMBAT_DRONE_SPAWN_EGG);
                        entries.add(SENTINEL_SPAWN_EGG);
                        entries.add(ARTILLERY_SPAWN_EGG);
                });

                ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
                        entries.add(CONTROLLER_TIER_1);
                        entries.add(CONTROLLER_TIER_2);
                        entries.add(CONTROLLER_TIER_3);
                        entries.add(CONTROLLER_TIER_4);
                        entries.add(CONTROLLER_TIER_5);
                        entries.add(CONTROLLER_TIER_6);
                        entries.add(CONTROLLER_TIER_7);
                        entries.add(CONTROLLER_TIER_8);
                        entries.add(CONTROLLER_TIER_9);
                        entries.add(CONTROLLER_TIER_10);
                });
        }
}

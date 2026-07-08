package com.drone_army;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drone_army.registry.ModEntities;
import com.drone_army.registry.ModItems;
import com.drone_army.registry.ModRecipes;
import com.drone_army.registry.ModScreenHandlers;

public class DroneArmyMod implements ModInitializer {
    public static final String MOD_ID = "dronearmy";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("DroneArmy Initializing...");
        ModEntities.registerModEntities();
        ModItems.registerModItems();
        ModRecipes.registerRecipes();
        ModScreenHandlers.registerScreenHandlers();
        com.drone_army.registry.ModSounds.registerSounds();
    }
}

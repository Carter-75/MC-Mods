package com.drone_army.registry;

import com.drone_army.DroneArmyMod;
import com.drone_army.client.gui.ControllerScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<ControllerScreenHandler> CONTROLLER_SCREEN_HANDLER = Registry.register(
            Registries.SCREEN_HANDLER,
            Identifier.of(DroneArmyMod.MOD_ID, "controller"),
            ControllerScreenHandler.TYPE);

    public static void registerScreenHandlers() {
        DroneArmyMod.LOGGER.info("Registering Screen Handlers for " + DroneArmyMod.MOD_ID);
    }
}

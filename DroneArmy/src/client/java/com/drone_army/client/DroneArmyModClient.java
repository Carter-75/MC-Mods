package com.drone_army.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import com.drone_army.registry.ModScreenHandlers;
import com.drone_army.client.gui.ControllerScreen;

import com.drone_army.registry.ModEntities;
import com.drone_army.client.renderer.RobotEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class DroneArmyModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Register Renderers
        EntityRendererRegistry.register(ModEntities.COMBAT_DRONE,
                (ctx) -> new RobotEntityRenderer(ctx, "combat_drone"));
        EntityRendererRegistry.register(ModEntities.SENTINEL, (ctx) -> new RobotEntityRenderer(ctx, "sentinel"));
        EntityRendererRegistry.register(ModEntities.ARTILLERY, (ctx) -> new RobotEntityRenderer(ctx, "artillery"));
        HandledScreens.register(ModScreenHandlers.CONTROLLER_SCREEN_HANDLER, ControllerScreen::new);
    }
}

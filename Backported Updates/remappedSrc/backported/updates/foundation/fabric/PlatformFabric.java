/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ModInitializer
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.foundation.fabric;

import backported.updates.foundation.Platform;
import backported.updates.foundation.core.Environment;
import backported.updates.foundation.core.events.fabric.ServerLifecycle;
import backported.updates.foundation.fabric.FabricClientEvents;
import backported.updates.foundation.fabric.FabricCommonEvents;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.Nullable;

public class PlatformFabric
implements ModInitializer {
    private static MinecraftServer server;

    public void onInitialize() {
        Platform.bootstrap();
        this.registerServerLifecycleEvents();
        if (Environment.isClientSide()) {
            FabricClientEvents.bootstrap();
        }
        FabricCommonEvents.bootstrap();
        ServerLifecycle.bootstrap();
    }

    private void registerServerLifecycleEvents() {
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            PlatformFabric.server = server;
        });
        ServerLifecycleEvents.SERVER_STOPPED.register(server -> {
            PlatformFabric.server = null;
        });
    }

    @Nullable
    public static MinecraftServer getServer() {
        return server;
    }
}


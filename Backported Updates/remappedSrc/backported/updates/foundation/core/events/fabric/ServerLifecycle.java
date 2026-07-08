/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
 */
package backported.updates.foundation.core.events.fabric;

import backported.updates.foundation.core.events.DataLifecycleEvents;
import backported.updates.foundation.core.events.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents;

public class ServerLifecycle {
    public static void bootstrap() {
        CommonLifecycleEvents.TAGS_LOADED.register(DataLifecycleEvents.DATA_RELOAD.invoker()::onReload);
        net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.SERVER_STARTING.register(server -> ServerLifecycleEvents.STARTING.invoker().onLifecycle(server));
        net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.SERVER_STARTED.register(server -> ServerLifecycleEvents.STARTED.invoker().onLifecycle(server));
        net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.SERVER_STOPPING.register(server -> ServerLifecycleEvents.STOPPING.invoker().onLifecycle(server));
        net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.SERVER_STOPPED.register(server -> ServerLifecycleEvents.STOPPED.invoker().onLifecycle(server));
    }
}


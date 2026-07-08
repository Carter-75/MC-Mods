/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.MinecraftServer
 */
package backported.updates.foundation.core.events;

import backported.updates.foundation.core.util.event.Event;
import net.minecraft.server.MinecraftServer;

public interface ServerLifecycleEvents {
    public static final Event<ServerLifecycleEvents> STARTING = Event.create(ServerLifecycleEvents.class);
    public static final Event<ServerLifecycleEvents> STARTED = Event.create(ServerLifecycleEvents.class);
    public static final Event<ServerLifecycleEvents> STOPPING = Event.create(ServerLifecycleEvents.class);
    public static final Event<ServerLifecycleEvents> STOPPED = Event.create(ServerLifecycleEvents.class);

    public void onLifecycle(MinecraftServer var1);
}


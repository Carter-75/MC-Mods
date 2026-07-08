/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3244
 *  net.minecraft.server.MinecraftServer
 */
package backported.updates.foundation.core.networking;

import backported.updates.foundation.core.util.event.Event;
import net.minecraft.class_3244;
import net.minecraft.server.MinecraftServer;

public interface ServerListenerEvents {
    public static final Event<ServerListenerEvents> JOIN = Event.create(ServerListenerEvents.class);

    public void listener(class_3244 var1, MinecraftServer var2);
}


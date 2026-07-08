/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.network.ServerPlayerEntity
 */
package backported.updates.foundation.core.events;

import backported.updates.foundation.core.util.event.Event;
import net.minecraft.server.network.ServerPlayerEntity;

public interface DatapackSyncEvents {
    public static final Event<DatapackSyncEvents> EVENT = Event.create(DatapackSyncEvents.class);

    public void onSync(ServerPlayerEntity var1);
}


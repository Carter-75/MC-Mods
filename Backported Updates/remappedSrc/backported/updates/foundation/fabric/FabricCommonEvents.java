/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
 */
package backported.updates.foundation.fabric;

import backported.updates.foundation.core.events.DatapackSyncEvents;
import backported.updates.foundation.core.networking.ServerListenerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

public class FabricCommonEvents {
    public static void bootstrap() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> ServerListenerEvents.JOIN.invoker().listener(handler, server));
        ServerLifecycleEvents.SYNC_DATA_PACK_CONTENTS.register((player, joined) -> DatapackSyncEvents.EVENT.invoker().onSync(player));
    }
}


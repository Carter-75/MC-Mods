/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3222
 */
package backported.updates.foundation.core.events;

import backported.updates.foundation.core.util.event.Event;
import net.minecraft.class_3222;

public interface DatapackSyncEvents {
    public static final Event<DatapackSyncEvents> EVENT = Event.create(DatapackSyncEvents.class);

    public void onSync(class_3222 var1);
}


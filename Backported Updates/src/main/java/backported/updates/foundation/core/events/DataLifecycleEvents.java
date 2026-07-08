/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.registry.DynamicRegistryManager
 */
package backported.updates.foundation.core.events;

import backported.updates.foundation.core.util.event.Event;
import net.minecraft.registry.DynamicRegistryManager;

public interface DataLifecycleEvents {
    public static final Event<DataLifecycleEvents> DATA_RELOAD = Event.create(DataLifecycleEvents.class);

    public void onReload(DynamicRegistryManager var1, boolean var2);
}


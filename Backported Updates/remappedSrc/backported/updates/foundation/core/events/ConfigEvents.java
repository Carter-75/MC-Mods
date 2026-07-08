/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.core.events;

import backported.updates.foundation.core.util.config.ModConfig;
import backported.updates.foundation.core.util.event.Event;

public interface ConfigEvents {
    public static final Event<ConfigEvents> LOADING = Event.create(ConfigEvents.class);
    public static final Event<ConfigEvents> RELOADING = Event.create(ConfigEvents.class);

    public void onModConfig(ModConfig var1);
}


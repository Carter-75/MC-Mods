/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.common;

import backported.updates.foundation.Platform;
import backported.updates.foundation.core.events.DataLifecycleEvents;

public class CommonSetup {
    public static void setup() {
        DataLifecycleEvents.DATA_RELOAD.register(Platform::afterDataReload);
    }
}


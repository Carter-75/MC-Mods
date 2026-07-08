/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.core;

import backported.updates.foundation.nightconfig.core.Config;
import backported.updates.foundation.nightconfig.core.ConfigSpec;

public class ConcurrentConfigSpec
extends ConfigSpec {
    public ConcurrentConfigSpec() {
        super(Config.inMemoryUniversalConcurrent());
    }
}


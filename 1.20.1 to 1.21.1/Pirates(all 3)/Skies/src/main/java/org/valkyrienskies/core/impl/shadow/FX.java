/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.valkyrienskies.core.impl.shadow.FW;

public final class FX {
    public static final FW a() {
        return FW.INSTANCE;
    }

    public static final Logger a(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Logger logger = LogManager.getLogger((String)object);
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"");
        object = logger;
        Intrinsics.checkNotNullParameter((Object)logger, (String)"");
        return object;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.mod.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.util.ClassLogger;
import org.valkyrienskies.mod.util.DelegateLogger;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0001\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0001\u0010\u0002\u001a\u0015\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0001\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lorg/valkyrienskies/mod/util/DelegateLogger;", "logger", "()Lorg/valkyrienskies/mod/util/DelegateLogger;", "", "name", "Lorg/valkyrienskies/mod/util/ClassLogger;", "(Ljava/lang/String;)Lorg/apache/logging/log4j/Logger;", "valkyrienskies-120"})
public final class LoggingKt {
    @NotNull
    public static final DelegateLogger logger() {
        return DelegateLogger.INSTANCE;
    }

    @NotNull
    public static final Logger logger(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Logger logger = LogManager.getLogger(name);
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(...)");
        return ClassLogger.constructor-impl(logger);
    }
}


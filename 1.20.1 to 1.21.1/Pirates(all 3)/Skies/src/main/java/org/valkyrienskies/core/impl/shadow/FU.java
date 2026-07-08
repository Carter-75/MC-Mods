/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.Logger;

@JvmInline
public final class FU {
    private final Logger a;

    private Logger a() {
        return this.a;
    }

    public static final Logger a(Logger logger, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, (String)"");
        return logger;
    }

    private static String b(Logger logger) {
        return "ClassLogger(logger=" + logger + ")";
    }

    public final String toString() {
        Logger logger = this.a;
        return "ClassLogger(logger=" + logger + ")";
    }

    private static int c(Logger logger) {
        return logger.hashCode();
    }

    public final int hashCode() {
        Logger logger = this.a;
        return logger.hashCode();
    }

    private static boolean a(Logger logger, Object object) {
        if (!(object instanceof FU)) {
            return false;
        }
        object = (FU)object;
        return Intrinsics.areEqual((Object)logger, (Object)((FU)object).a);
    }

    public final boolean equals(Object other) {
        Logger logger;
        FU fU = logger;
        logger = this.a;
        if (!(fU instanceof FU)) {
            return false;
        }
        fU = fU;
        return Intrinsics.areEqual((Object)logger, (Object)fU.a);
    }

    private /* synthetic */ FU(Logger logger) {
        this.a = logger;
    }

    public static Logger a(Logger logger) {
        Intrinsics.checkNotNullParameter((Object)logger, (String)"");
        return logger;
    }

    private static /* synthetic */ FU d(Logger logger) {
        return new FU(logger);
    }

    private /* synthetic */ Logger b() {
        return this.a;
    }

    private static boolean a(Logger logger, Logger logger2) {
        return Intrinsics.areEqual((Object)logger, (Object)logger2);
    }
}


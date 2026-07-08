/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.mod.util;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@JvmInline
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\b\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0086\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u0088\u0001\u0016\u0092\u0001\u00020\u0005\u00a8\u0006\u001c"}, d2={"Lorg/valkyrienskies/mod/util/ClassLogger;", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "Lorg/apache/logging/log4j/Logger;", "getValue-impl", "(Lorg/apache/logging/log4j/Logger;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Lorg/apache/logging/log4j/Logger;", "getValue", "other", "", "equals-impl", "(Lorg/apache/logging/log4j/Logger;Ljava/lang/Object;)Z", "equals", "", "hashCode-impl", "(Lorg/apache/logging/log4j/Logger;)I", "hashCode", "", "toString-impl", "(Lorg/apache/logging/log4j/Logger;)Ljava/lang/String;", "toString", "logger", "Lorg/apache/logging/log4j/Logger;", "getLogger", "()Lorg/apache/logging/log4j/Logger;", "constructor-impl", "(Lorg/apache/logging/log4j/Logger;)Lorg/apache/logging/log4j/Logger;", "valkyrienskies-120"})
public final class ClassLogger {
    @NotNull
    private final Logger logger;

    @NotNull
    public final Logger getLogger() {
        return this.logger;
    }

    @NotNull
    public static final Logger getValue-impl(Logger arg0, @Nullable Object thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, (String)"property");
        return arg0;
    }

    public static String toString-impl(Logger arg0) {
        return "ClassLogger(logger=" + arg0 + ")";
    }

    public String toString() {
        return ClassLogger.toString-impl(this.logger);
    }

    public static int hashCode-impl(Logger arg0) {
        return arg0.hashCode();
    }

    public int hashCode() {
        return ClassLogger.hashCode-impl(this.logger);
    }

    public static boolean equals-impl(Logger arg0, Object other) {
        if (!(other instanceof ClassLogger)) {
            return false;
        }
        return Intrinsics.areEqual((Object)arg0, (Object)((ClassLogger)other).unbox-impl());
    }

    public boolean equals(Object other) {
        return ClassLogger.equals-impl(this.logger, other);
    }

    private /* synthetic */ ClassLogger(Logger logger) {
        this.logger = logger;
    }

    @NotNull
    public static Logger constructor-impl(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter((Object)logger, (String)"logger");
        return logger;
    }

    public static final /* synthetic */ ClassLogger box-impl(Logger v) {
        return new ClassLogger(v);
    }

    public final /* synthetic */ Logger unbox-impl() {
        return this.logger;
    }

    public static final boolean equals-impl0(Logger p1, Logger p2) {
        return Intrinsics.areEqual((Object)p1, (Object)p2);
    }
}


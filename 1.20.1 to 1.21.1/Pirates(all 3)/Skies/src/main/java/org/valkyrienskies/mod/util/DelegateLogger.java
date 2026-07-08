/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.mod.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.util.ClassLogger;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\b\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0086\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2={"Lorg/valkyrienskies/mod/util/DelegateLogger;", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "Lorg/valkyrienskies/mod/util/ClassLogger;", "provideDelegate-j8jxBIw", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Lorg/apache/logging/log4j/Logger;", "provideDelegate", "<init>", "()V", "valkyrienskies-120"})
public final class DelegateLogger {
    @NotNull
    public static final DelegateLogger INSTANCE = new DelegateLogger();

    private DelegateLogger() {
    }

    @NotNull
    public final Logger provideDelegate-j8jxBIw(@NotNull Object thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter((Object)thisRef, (String)"thisRef");
        Intrinsics.checkNotNullParameter(property, (String)"property");
        Logger logger = LogManager.getLogger(Reflection.getOrCreateKotlinClass(thisRef.getClass()).isCompanion() ? thisRef.getClass().getDeclaringClass() : thisRef.getClass());
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(...)");
        return ClassLogger.constructor-impl(logger);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ'\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001"}, d2={"Lorg/valkyrienskies/core/impl/shadow/FW;", "", "p0", "Lkotlin/reflect/KProperty;", "p1", "Lorg/valkyrienskies/core/impl/shadow/FU;", "a", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Lorg/apache/logging/log4j/Logger;", "<init>", "()V"})
public final class FW {
    public static final FW INSTANCE = new FW();

    private FW() {
    }

    public static Logger a(Object object, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter(kProperty, (String)"");
        Logger logger = LogManager.getLogger(Reflection.getOrCreateKotlinClass(object.getClass()).isCompanion() ? object.getClass().getDeclaringClass() : object.getClass());
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"");
        object = logger;
        Intrinsics.checkNotNullParameter((Object)logger, (String)"");
        return object;
    }
}


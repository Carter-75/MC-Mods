/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class CL {
    final Class<?> a;
    final Class<?> b;
    final Function1<Object, Object> c;

    public CL(Class<?> clazz, Class<?> clazz2, Function1<Object, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        Intrinsics.checkNotNullParameter(clazz2, (String)"");
        Intrinsics.checkNotNullParameter(function1, (String)"");
        this.a = clazz;
        this.b = clazz2;
        this.c = function1;
    }

    public final Class<?> a() {
        return this.a;
    }

    public final Class<?> b() {
        return this.b;
    }

    public final Function1<Object, Object> c() {
        return this.c;
    }
}


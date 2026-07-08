/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.ge_0;
import org.valkyrienskies.core.impl.shadow.gf_0;
import org.valkyrienskies.core.impl.shadow.gg_0;
import org.valkyrienskies.core.impl.shadow.gq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gh
 */
public final class gh_0 {
    private static <S> ge_0<S> a(S s, gq_0<S> ... gq_0Array) {
        Intrinsics.checkNotNullParameter(gq_0Array, (String)"");
        return new gg_0(s, ArraysKt.asList((Object[])gq_0Array), false, false, null, 24, null);
    }

    public static final <S> ge_0<S> a(S object, Function1<? super gf_0<S>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"");
        object = new gf_0<S>(object);
        function1.invoke(object);
        return ((gf_0)object).c();
    }
}


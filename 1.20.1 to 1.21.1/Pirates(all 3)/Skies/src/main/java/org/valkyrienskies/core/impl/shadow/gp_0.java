/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import java.util.function.Predicate;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.gq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gp
 */
public final class gp_0<S>
implements gq_0<S> {
    private final Predicate<Thread> b;
    private final S[] c;

    public gp_0(Predicate<Thread> object, S ... SArray) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        Intrinsics.checkNotNullParameter(SArray, (String)"");
        this.b = object;
        this.c = SArray;
        if (!(!(this.c.length == 0))) {
            object = "Failed requirement.";
            throw new IllegalArgumentException(object.toString());
        }
    }

    @Override
    public final String a(List<? extends S> list, boolean bl) {
        Intrinsics.checkNotNullParameter(list, (String)"");
        if (ArraysKt.contains((Object[])this.c, (Object)CollectionsKt.last(list)) && !this.b.test(Thread.currentThread())) {
            return "Stages " + this.c + " require a different thread. Current thread: " + Thread.currentThread();
        }
        return null;
    }
}


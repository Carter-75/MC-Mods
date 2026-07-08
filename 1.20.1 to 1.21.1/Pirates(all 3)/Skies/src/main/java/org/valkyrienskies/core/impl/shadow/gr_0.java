/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.gt_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gr
 */
public final class gr_0<S>
implements gt_0<S> {
    private final Set<S> b;

    public gr_0(S ... SArray) {
        Intrinsics.checkNotNullParameter(SArray, (String)"");
        this.b = ArraysKt.toSet((Object[])SArray);
    }

    @Override
    public final boolean a(S s) {
        return this.b.contains(s);
    }

    public final String toString() {
        return "oneOf" + this.b;
    }
}


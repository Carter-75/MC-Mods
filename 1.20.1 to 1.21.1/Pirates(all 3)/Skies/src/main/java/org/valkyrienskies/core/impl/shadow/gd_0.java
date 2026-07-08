/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.valkyrienskies.core.impl.shadow.Gt$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.Gt;
import org.valkyrienskies.core.impl.shadow.gt_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gd
 */
public final class gd_0<S> {
    public final ArrayList<gt_0<S>> a = new ArrayList();

    private void a(gt_0<S> gt_02) {
        Intrinsics.checkNotNullParameter(gt_02, (String)"");
        this.a.add(gt_02);
    }

    public final void a(S s) {
        this.a.add(Gt.a.a(s));
    }

    public final void a(S ... SArray) {
        Intrinsics.checkNotNullParameter(SArray, (String)"");
        this.a.add(Gt.a.a((Object[])Arrays.copyOf(SArray, SArray.length)));
    }

    public final List<gt_0<S>> a() {
        return CollectionsKt.toList((Iterable)this.a);
    }
}


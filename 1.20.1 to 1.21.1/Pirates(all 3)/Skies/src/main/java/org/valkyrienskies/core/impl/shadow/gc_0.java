/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.valkyrienskies.core.impl.shadow.Gq
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.Gq;
import org.valkyrienskies.core.impl.shadow.gd_0;
import org.valkyrienskies.core.impl.shadow.gq_0;
import org.valkyrienskies.core.impl.shadow.gt_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gc
 */
public class gc_0<S> {
    public final ArrayList<gq_0<S>> a = new ArrayList();

    private void a(gq_0<S> gq_02) {
        Intrinsics.checkNotNullParameter(gq_02, (String)"");
        this.a.add(gq_02);
    }

    private void b(S ... SArray) {
        Intrinsics.checkNotNullParameter(SArray, (String)"");
        this.a.add(gq_0.a.a(Arrays.copyOf(SArray, SArray.length)));
    }

    public final void a(S ... SArray) {
        Intrinsics.checkNotNullParameter(SArray, (String)"");
        this.a.add(gq_0.a.b(Arrays.copyOf(SArray, SArray.length)));
    }

    public final void b(S ... SArray) {
        Intrinsics.checkNotNullParameter(SArray, (String)"");
        this.a.add(gq_0.a.c(Arrays.copyOf(SArray, SArray.length)));
    }

    private void a(gt_0<S> ... gt_0Array) {
        Intrinsics.checkNotNullParameter(gt_0Array, (String)"");
        this.a.add(gq_0.a.a(Arrays.copyOf(gt_0Array, gt_0Array.length)));
    }

    public final void a(Function1<? super gd_0<S>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"");
        this.a.add(Gq.a.a(function1));
    }

    private void c(S ... SArray) {
        Intrinsics.checkNotNullParameter(SArray, (String)"");
        this.a.add(gq_0.a.d(Arrays.copyOf(SArray, SArray.length)));
    }

    private void d(S ... SArray) {
        Intrinsics.checkNotNullParameter(SArray, (String)"");
        this.a.add(gq_0.a.e(Arrays.copyOf(SArray, SArray.length)));
    }

    public final void a(S ... SArray) {
        Intrinsics.checkNotNullParameter(SArray, (String)"");
        this.a.add(Gq.a.f(Arrays.copyOf(SArray, SArray.length)));
    }

    private void e(S ... object) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        S[] SArray = Arrays.copyOf(object, ((S[])object).length);
        object = Gq.a;
        Intrinsics.checkNotNullParameter(SArray, (String)"");
        Gq[] gqArray = new Gq[2];
        object = gqArray;
        gqArray[0] = gq_0.a.c(Arrays.copyOf(SArray, SArray.length));
        object[1] = gq_0.a.d(Arrays.copyOf(SArray, SArray.length));
        this.a.add(gq_0.a.a(object));
    }

    private void a(Predicate<Thread> predicate, S ... SArray) {
        Intrinsics.checkNotNullParameter(predicate, (String)"");
        Intrinsics.checkNotNullParameter(SArray, (String)"");
        this.a.add(gq_0.a.a(predicate, Arrays.copyOf(SArray, SArray.length)));
    }

    public final List<gq_0<S>> a() {
        return this.a;
    }
}


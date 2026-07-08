/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicLong;
import org.valkyrienskies.core.impl.shadow.lL;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.tW;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.uc_0;
import org.valkyrienskies.core.impl.shadow.ud_0;
import org.valkyrienskies.core.impl.shadow.ue_0;
import org.valkyrienskies.core.impl.shadow.ug_0;
import org.valkyrienskies.core.impl.shadow.uk_0;
import org.valkyrienskies.core.impl.shadow.um_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.uj
 */
public final class uj_0
implements ug_0 {
    final tW a;
    final uk_0 b;
    final um_0 c;
    final AtomicLong d = new AtomicLong(0L);

    private uj_0(tW tW2, uk_0 uk_02, um_0 um_02) {
        this.a = tW2;
        this.b = uk_02;
        this.c = um_02;
    }

    public final void a(ud_0 ud_02, double[] dArray) {
        long l2 = this.d.incrementAndGet() - 1L;
        double d2 = this.b.a(l2);
        ue_0 ue_02 = this.a(ud_02, dArray, d2);
        int n2 = this.c.a(l2);
        lL lL2 = new lL(d2, 0.0, n2);
        if (n2 > 0) {
            Collection<ue_0> collection = new HashSet<ue_0>();
            collection.add(ue_02);
            HashSet<ue_0> hashSet = new HashSet<ue_0>();
            hashSet.add(ue_02);
            int n3 = 1;
            do {
                collection = ud_02.a(collection, hashSet);
                for (ue_0 ue_03 : collection) {
                    this.b(ue_03, dArray, lL2.a(n3));
                }
                hashSet.addAll(collection);
            } while (++n3 <= n2);
        }
    }

    private long a() {
        return this.d.get();
    }

    boolean a(ue_0 ue_02, double[] dArray, double d2) {
        double[] dArray2 = ue_02.c();
        dArray = uj_0.a(dArray2, dArray, d2);
        return ue_02.a(dArray2, dArray);
    }

    private void b(ue_0 ue_02, double[] dArray, double d2) {
        while (!this.a(ue_02, dArray, d2)) {
        }
    }

    private ue_0 a(ud_0 ud_02, double[] dArray, double d2) {
        ue_0 ue_02;
        while (!this.a(ue_02 = uc_0.a(dArray, (Iterable<ue_0>)ud_02, this.a), dArray, d2)) {
        }
        return ue_02;
    }

    private static double[] a(double[] object, double[] object2, double d2) {
        object = new sA((double[])object, false);
        sA sA2 = new sA((double[])object2, false);
        object2 = sA2;
        return ((tu_0)((Object)sA2.a((tu_0)object))).c(d2).l((tu_0)object).g();
    }
}


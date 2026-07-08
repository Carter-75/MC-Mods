/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.lL;
import org.valkyrienskies.core.impl.shadow.uc_0;
import org.valkyrienskies.core.impl.shadow.ud_0;
import org.valkyrienskies.core.impl.shadow.ue_0;
import org.valkyrienskies.core.impl.shadow.uj_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.ui
 */
public final class ui_0
implements Runnable {
    private final ud_0 a;
    private final Iterator<double[]> b;
    private final uj_0 c;

    private ui_0(ud_0 ud_02, Iterator<double[]> iterator2, uj_0 uj_02) {
        this.a = ud_02;
        this.b = iterator2;
        this.c = uj_02;
    }

    @Override
    public final void run() {
        while (this.b.hasNext()) {
            ue_0 ue_02;
            double d2;
            double[] dArray = this.b.next();
            ud_0 ud_02 = this.a;
            uj_0 uj_02 = this.c;
            long l2 = uj_02.d.incrementAndGet() - 1L;
            double d3 = d2 = uj_02.b.a(l2);
            double[] dArray2 = dArray;
            Serializable serializable = ud_02;
            uj_0 uj_03 = uj_02;
            while (!uj_03.a(ue_02 = uc_0.a(dArray2, (Iterable<ue_0>)((Object)serializable), uj_03.a), dArray2, d3)) {
            }
            int n2 = uj_02.c.a(l2);
            lL lL2 = new lL(d2, 0.0, n2);
            if (n2 <= 0) continue;
            Collection<ue_0> collection = new HashSet<ue_0>();
            collection.add(ue_02);
            HashSet<ue_0> hashSet = new HashSet<ue_0>();
            hashSet.add(ue_02);
            int n3 = 1;
            do {
                collection = ud_02.a(collection, hashSet);
                for (ue_0 ue_03 : collection) {
                    d3 = lL2.a(n3);
                    dArray2 = dArray;
                    serializable = ue_03;
                    uj_0 uj_04 = uj_02;
                    while (!uj_04.a((ue_0)serializable, dArray2, d3)) {
                    }
                }
                hashSet.addAll(collection);
            } while (++n3 <= n2);
        }
    }
}


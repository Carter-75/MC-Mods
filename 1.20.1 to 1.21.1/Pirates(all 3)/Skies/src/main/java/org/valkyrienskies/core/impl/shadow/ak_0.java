/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.aj_0;
import org.valkyrienskies.core.impl.shadow.bp_0;
import org.valkyrienskies.core.impl.shadow.bq_0;
import org.valkyrienskies.core.impl.shadow.br_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sD;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Ak
 */
public final class ak_0 {
    private final tq_0 a;
    private final br_0 b;
    private final aj_0 c;

    public ak_0() {
        this(new bq_0());
    }

    private ak_0(bq_0 bq_02) {
        this.a = null;
        this.b = bq_02;
        this.c = null;
    }

    private ak_0(tq_0 tq_02) {
        this(tq_02, new bq_0());
    }

    private ak_0(tq_0 tq_02, bq_0 bq_02) {
        this.b = bq_02;
        this.a = this.a(tq_02);
        this.c = new aj_0(this.a);
    }

    private tq_0 a() {
        aj_0 aj_02 = this.c;
        return aj_02.a;
    }

    private aj_0 b() {
        return this.c;
    }

    private tq_0 a(sD tq_02) {
        tq_02 = this.a(tq_02);
        return new aj_0().a(tq_02);
    }

    private tq_0 a(double[][] object) {
        ak_0 ak_02 = this;
        sD sD2 = new sD((double[][])object);
        object = ak_02;
        object = ak_02.a((tq_0)sD2);
        return new aj_0().a((tq_0)object);
    }

    private double a(double[] dArray, double[] dArray2) {
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        if (dArray.length < 2) {
            throw new oV(px_0.INSUFFICIENT_DIMENSION, dArray.length, 2);
        }
        double[] dArray3 = dArray;
        Object object = dArray2;
        if (this.b instanceof bq_0) {
            bq_0 bq_02 = (bq_0)this.b;
            if (bp_0.REMOVED == bq_02.a) {
                HashSet<Integer> hashSet = new HashSet<Integer>();
                object = hashSet;
                hashSet.addAll(ak_0.a(dArray));
                object.addAll(ak_0.a(dArray2));
                dArray3 = ak_0.a(dArray, (Set<Integer>)object);
                object = ak_0.a(dArray2, (Set<Integer>)object);
            }
        }
        new aj_0();
        return aj_0.a(this.b.a(dArray3), this.b.a((double[])object));
    }

    private tq_0 a(tq_0 tq_02) {
        sv_0 sv_02 = null;
        if (this.b instanceof bq_0) {
            Object object = (bq_0)this.b;
            if (((bq_0)object).a == bp_0.REMOVED) {
                int n2;
                object = new HashSet();
                for (n2 = 0; n2 < tq_02.g(); ++n2) {
                    object.addAll(ak_0.a(tq_02.g(n2)));
                }
                if (!object.isEmpty()) {
                    sv_02 = new sD(tq_02.f() - object.size(), tq_02.g());
                    for (n2 = 0; n2 < sv_02.g(); ++n2) {
                        sv_02.b(n2, ak_0.a(tq_02.g(n2), (Set<Integer>)object));
                    }
                }
            }
        }
        if (sv_02 == null) {
            sv_02 = tq_02.i();
        }
        for (int i2 = 0; i2 < sv_02.g(); ++i2) {
            sv_02.b(i2, this.b.a(sv_02.g(i2)));
        }
        return sv_02;
    }

    private static List<Integer> a(double[] dArray) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (!Double.isNaN(dArray[i2])) continue;
            arrayList.add(i2);
        }
        return arrayList;
    }

    private static double[] a(double[] dArray, Set<Integer> set) {
        if (set.isEmpty()) {
            return dArray;
        }
        double[] dArray2 = new double[dArray.length - set.size()];
        int n2 = 0;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            if (set.contains(i2)) continue;
            dArray2[n2++] = dArray[i2];
        }
        return dArray2;
    }
}


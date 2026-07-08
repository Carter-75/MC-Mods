/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.zN;

@Deprecated
public final class mQ
implements kW {
    private final int a;
    private final List<a> b;
    private final double c;
    private final Map<tu_0, Double> d;

    public mQ(double[][] dArray, double[] dArray2, int n2, int n3, zN zN2) {
        if (dArray == null || dArray2 == null) {
            throw new pl_0();
        }
        if (dArray.length == 0) {
            throw new pf_0();
        }
        if (dArray.length != dArray2.length) {
            throw new oS(dArray.length, dArray2.length);
        }
        if (dArray[0] == null) {
            throw new pl_0();
        }
        this.a = dArray[0].length;
        this.c = n2;
        this.d = new HashMap<tu_0, Double>(dArray2.length);
        for (n2 = 0; n2 < dArray.length; ++n2) {
            double[] dArray3 = dArray[n2];
            if (dArray3 == null) {
                throw new pl_0();
            }
            if (dArray3.length != this.a) {
                throw new oS(dArray3.length, this.a);
            }
            this.d.put((tu_0)((Object)new sA(dArray3)), dArray2[n2]);
        }
        this.b = new ArrayList<a>(n3);
        for (n2 = 0; n2 < n3; ++n2) {
            this.b.add(new a(zN2.a()));
        }
    }

    public final double a(double[] object) {
        Object object2;
        Object object3;
        object = new sA((double[])object);
        for (a object4 : this.b) {
            object3 = object4;
            object4.b = 0.0;
            ((a)object3).c = null;
        }
        for (Map.Entry entry : this.d.entrySet()) {
            double d2;
            tu_0 tu_02 = ((tu_0)entry.getKey()).k((tu_0)object);
            double d3 = tu_02.c();
            if (BY.w(d2) < BY.x(1.0)) {
                return (Double)entry.getValue();
            }
            object2 = this.b.iterator();
            while (object2.hasNext()) {
                Object d8 = (a)object2.next();
                double d4 = BY.a(d3, -this.c);
                Object object4 = object3 = d8;
                sA sA2 = ((a)object3).a;
                object3 = tu_02;
                d8 = entry;
                double d5 = ((tu_0)object3).b((tu_0)((Object)sA2)) / (((tu_0)object3).c() * ((tu_0)((Object)sA2)).c()) * d4;
                object3 = object4;
                if (!(d5 > ((a)object3).b)) continue;
                ((a)object3).b = d5;
                ((a)object3).c = d8;
            }
        }
        double d6 = 0.0;
        double d7 = 0.0;
        Iterator<a> iterator2 = this.b.iterator();
        while (iterator2.hasNext()) {
            object3 = object2 = iterator2.next();
            double d8 = ((a)object2).b;
            object3 = object2;
            Map.Entry<tu_0, Double> entry = ((a)object3).c;
            if (entry == null) continue;
            d6 += d8 * entry.getValue();
            d7 += d8;
        }
        return d6 / d7;
    }

    private static double a(tu_0 tu_02, tu_0 tu_03) {
        return tu_02.b(tu_03) / (tu_02.c() * tu_03.c());
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class a {
        final sA a;
        double b;
        Map.Entry<tu_0, Double> c;

        a(double[] dArray) {
            this.a = new sA(dArray);
        }

        final tu_0 a() {
            return this.a;
        }

        final void b() {
            this.b = 0.0;
            this.c = null;
        }

        final void a(double d2, Map.Entry<tu_0, Double> entry) {
            if (d2 > this.b) {
                this.b = d2;
                this.c = entry;
            }
        }

        final double c() {
            return this.b;
        }

        final Map.Entry<tu_0, Double> d() {
            return this.c;
        }
    }
}


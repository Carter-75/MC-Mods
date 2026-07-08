/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.tW;
import org.valkyrienskies.core.impl.shadow.ud_0;
import org.valkyrienskies.core.impl.shadow.ue_0;
import org.valkyrienskies.core.impl.shadow.uq_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.uc
 */
public final class uc_0 {
    private uc_0() {
    }

    public static ue_0 a(double[] dArray, Iterable<ue_0> object, tW tW2) {
        ue_0 ue_02 = null;
        double d2 = Double.POSITIVE_INFINITY;
        object = object.iterator();
        while (object.hasNext()) {
            double d3;
            ue_0 ue_03 = (ue_0)object.next();
            double d4 = tW2.a(ue_03.c(), dArray);
            if (!(d3 < d2)) continue;
            d2 = d4;
            ue_02 = ue_03;
        }
        return ue_02;
    }

    public static co_0<ue_0, ue_0> b(double[] dArray, Iterable<ue_0> object, tW tW2) {
        ue_0[] ue_0Array = new ue_0[]{null, null};
        double[] dArray2 = new double[]{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        object = object.iterator();
        while (object.hasNext()) {
            double d2;
            ue_0 ue_02 = (ue_0)object.next();
            double d3 = tW2.a(ue_02.c(), dArray);
            if (d2 < dArray2[0]) {
                dArray2[1] = dArray2[0];
                ue_0Array[1] = ue_0Array[0];
                dArray2[0] = d3;
                ue_0Array[0] = ue_02;
                continue;
            }
            if (!(d3 < dArray2[1])) continue;
            dArray2[1] = d3;
            ue_0Array[1] = ue_02;
        }
        return new co_0<ue_0, ue_0>(ue_0Array[0], ue_0Array[1]);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static ue_0[] a(double[] object, ud_0 object2, tW tW2) {
        ue_0[] ue_0Array;
        ArrayList<a> arrayList = new ArrayList<a>();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            ue_0Array = (ue_0[])object2.next();
            double d2 = tW2.a(ue_0Array.c(), (double[])object);
            arrayList.add(new a((ue_0)ue_0Array, d2));
        }
        Collections.sort(arrayList, a.a);
        int n2 = arrayList.size();
        ue_0Array = new ue_0[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            a a2 = (a)arrayList.get(i2);
            object = a2;
            ue_0Array[i2] = a2.b;
        }
        return ue_0Array;
    }

    private static double[][] a(uq_0 uq_02, tW tW2) {
        Object object = uq_02;
        int n2 = ((uq_0)object).b;
        object = uq_02;
        int n3 = ((uq_0)object).c;
        double[][] dArray = new double[n2][n3];
        object = uq_02;
        ud_0 ud_02 = ((uq_0)object).a;
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                Object object2 = uq_02.a(i2, i3);
                ue_0 ue_02 = object2;
                object = ud_02;
                object = ((ud_0)object).a(ue_02, (Iterable<ue_0>)null);
                object2 = ((ue_0)object2).c();
                double d2 = 0.0;
                int n4 = 0;
                object = object.iterator();
                while (object.hasNext()) {
                    ue_0 ue_03 = (ue_0)object.next();
                    ++n4;
                    d2 += tW2.a((double[])object2, ue_03.c());
                }
                dArray[i2][i3] = d2 / (double)n4;
            }
        }
        return dArray;
    }

    private static int[][] a(Iterable<double[]> object, uq_0 uq_02, tW tW2) {
        Object object2;
        HashMap<Object, Integer> hashMap = new HashMap<Object, Integer>();
        Serializable serializable = uq_02;
        serializable = ((uq_0)serializable).a;
        object = object.iterator();
        while (object.hasNext()) {
            double[] dArray = (double[])object.next();
            object2 = uc_0.a(dArray, (Iterable<ue_0>)((Object)serializable), tW2);
            Integer n2 = (Integer)hashMap.get(object2);
            if (n2 == null) {
                hashMap.put(object2, 1);
                continue;
            }
            hashMap.put(object2, n2 + 1);
        }
        serializable = uq_02;
        int n3 = ((uq_0)serializable).b;
        serializable = uq_02;
        int n4 = ((uq_0)serializable).c;
        object2 = new int[n3][n4];
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = 0; i3 < n4; ++i3) {
                serializable = uq_02.a(i2, i3);
                object2[i2][i3] = (serializable = (Integer)hashMap.get(serializable)) == null ? (Object)false : (Object)((Integer)serializable);
            }
        }
        return object2;
    }

    private static double a(Iterable<double[]> object, Iterable<ue_0> iterable, tW tW2) {
        double d2 = 0.0;
        int n2 = 0;
        object = object.iterator();
        while (object.hasNext()) {
            double[] dArray = (double[])object.next();
            ++n2;
            d2 += tW2.a(dArray, uc_0.a(dArray, iterable, tW2).c());
        }
        if (n2 == 0) {
            throw new pf_0();
        }
        return d2 / (double)n2;
    }

    private static double a(Iterable<double[]> object, ud_0 ud_02, tW tW2) {
        int n2 = 0;
        int n3 = 0;
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = (double[])object.next();
            ++n3;
            object2 = uc_0.b(object2, ud_02, tW2);
            ud_0 ud_03 = ud_02;
            Object object3 = object2;
            ue_0 ue_02 = (ue_0)object2.a;
            object3 = ud_03;
            object3 = object2;
            if (ud_03.a(ue_02, (Iterable<ue_0>)null).contains(object2.b)) continue;
            ++n2;
        }
        if (n3 == 0) {
            throw new pf_0();
        }
        return (double)n2 / (double)n3;
    }

    public static final class a {
        public static final Comparator<a> a = new Comparator<a>(){

            private static int a(a a2, a a3) {
                return Double.compare(a2.c, a3.c);
            }

            @Override
            public final /* synthetic */ int compare(Object object, Object object2) {
                object2 = (a)object2;
                object = (a)object;
                return Double.compare(((a)object).c, ((a)object2).c);
            }
        };
        public final ue_0 b;
        private final double c;

        public a(ue_0 ue_02, double d2) {
            this.b = ue_02;
            this.c = d2;
        }

        public final ue_0 a() {
            return this.b;
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oc_0;
import org.valkyrienskies.core.impl.shadow.ok_0;
import org.valkyrienskies.core.impl.shadow.zR;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.ol
 */
public final class ol_0
extends oc_0 {
    private static final long b = 20130308L;
    private ok_0<Integer> c;

    private ol_0(int[] nArray, double[] dArray) {
        this(new zR(), nArray, dArray);
    }

    private ol_0(zR zR2, int[] nArray, double[] dArray) {
        super(zR2);
        this.c = new ok_0(zR2, ol_0.a(nArray, dArray));
    }

    private ol_0(zR zR2, int[] nArray) {
        super(zR2);
        Object object;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int[] nArray2 = nArray;
        int n2 = nArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = nArray2[i2];
            object = (Integer)hashMap.get(n3);
            if (object == null) {
                object = 0;
            }
            hashMap.put(n3, (Integer)object + 1);
        }
        int n4 = hashMap.size();
        double d2 = nArray.length;
        int[] nArray3 = new int[n4];
        object = new double[n4];
        int n5 = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            nArray3[n5] = (Integer)entry.getKey();
            object[n5] = (double)((Integer)entry.getValue()).intValue() / d2;
            ++n5;
        }
        this.c = new ok_0(zR2, ol_0.a(nArray3, (double[])object));
    }

    private ol_0(int[] nArray) {
        this(new zR(), nArray);
    }

    private static List<co_0<Integer, Double>> a(int[] nArray, double[] dArray) {
        if (nArray.length != dArray.length) {
            throw new oS(dArray.length, nArray.length);
        }
        ArrayList<co_0<Integer, Double>> arrayList = new ArrayList<co_0<Integer, Double>>(nArray.length);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            arrayList.add(new co_0<Integer, Double>(nArray[i2], dArray[i2]));
        }
        return arrayList;
    }

    @Override
    public final double c(int n2) {
        return this.c.a((Integer)n2);
    }

    @Override
    public final double d(int n2) {
        double d2 = 0.0;
        Iterator<co_0<Integer, Double>> iterator2 = this.c.a().iterator();
        while (iterator2.hasNext()) {
            co_0<Integer, Double> co_02;
            co_0<Integer, Double> co_03 = co_02 = iterator2.next();
            if ((Integer)co_02.a > n2) continue;
            d2 += co_02.c().doubleValue();
        }
        return d2;
    }

    @Override
    public final double b() {
        double d2 = 0.0;
        Iterator<co_0<Integer, Double>> iterator2 = this.c.a().iterator();
        while (iterator2.hasNext()) {
            co_0<Integer, Double> co_02;
            co_0<Integer, Double> co_03 = co_02 = iterator2.next();
            d2 += co_02.c() * (double)((Integer)co_03.a).intValue();
        }
        return d2;
    }

    @Override
    public final double c() {
        double d2 = 0.0;
        double d3 = 0.0;
        Iterator<co_0<Integer, Double>> iterator2 = this.c.a().iterator();
        while (iterator2.hasNext()) {
            co_0<Integer, Double> co_02;
            co_0<Integer, Double> co_03 = co_02 = iterator2.next();
            d2 += co_02.c() * (double)((Integer)co_03.a).intValue();
            co_0<Integer, Double> co_04 = co_02;
            co_03 = co_04;
            co_03 = co_02;
            d3 += co_02.c() * (double)((Integer)co_04.a).intValue() * (double)((Integer)co_03.a).intValue();
        }
        double d4 = d2;
        return d3 - d4 * d4;
    }

    @Override
    public final int d() {
        int n2 = Integer.MAX_VALUE;
        Iterator<co_0<Integer, Double>> iterator2 = this.c.a().iterator();
        while (iterator2.hasNext()) {
            co_0<Integer, Double> co_02;
            co_0<Integer, Double> co_03 = co_02 = iterator2.next();
            if ((Integer)co_02.a >= n2 || !(co_02.c() > 0.0)) continue;
            co_03 = co_02;
            n2 = (Integer)co_03.a;
        }
        return n2;
    }

    @Override
    public final int e() {
        int n2 = Integer.MIN_VALUE;
        Iterator<co_0<Integer, Double>> iterator2 = this.c.a().iterator();
        while (iterator2.hasNext()) {
            co_0<Integer, Double> co_02;
            co_0<Integer, Double> co_03 = co_02 = iterator2.next();
            if ((Integer)co_02.a <= n2 || !(co_02.c() > 0.0)) continue;
            co_03 = co_02;
            n2 = (Integer)co_03.a;
        }
        return n2;
    }

    @Override
    public final boolean f() {
        return true;
    }

    @Override
    public final int a() {
        return this.c.b();
    }
}


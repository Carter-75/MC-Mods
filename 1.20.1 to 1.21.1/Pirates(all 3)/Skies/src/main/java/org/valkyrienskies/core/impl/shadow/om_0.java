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
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.ok_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.om
 */
public final class om_0
extends oe_0 {
    private static final long b = 20130308L;
    private ok_0<Double> c;

    private om_0(double[] dArray, double[] dArray2) {
        this(new zR(), dArray, dArray2);
    }

    private om_0(zR zR2, double[] dArray, double[] dArray2) {
        super(zR2);
        this.c = new ok_0(zR2, om_0.a(dArray, dArray2));
    }

    public om_0(zF zF2, double[] object) {
        super(zF2);
        Object object2 = new HashMap<Double, Integer>();
        double[] dArray = object;
        int n2 = ((double[])object).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            double d2 = dArray[i2];
            Integer n3 = (Integer)object2.get(d2);
            if (n3 == null) {
                n3 = 0;
            }
            object2.put(d2, n3 + 1);
        }
        int n4 = object2.size();
        double d3 = ((double[])object).length;
        double[] dArray2 = new double[n4];
        double[] dArray3 = new double[n4];
        int n5 = 0;
        object = object2.entrySet().iterator();
        while (object.hasNext()) {
            object2 = (Map.Entry)object.next();
            dArray2[n5] = (Double)object2.getKey();
            dArray3[n5] = (double)((Integer)object2.getValue()).intValue() / d3;
            ++n5;
        }
        this.c = new ok_0(zF2, om_0.a(dArray2, dArray3));
    }

    private om_0(double[] dArray) {
        this(new zR(), dArray);
    }

    private static List<co_0<Double, Double>> a(double[] dArray, double[] dArray2) {
        if (dArray.length != dArray2.length) {
            throw new oS(dArray2.length, dArray.length);
        }
        ArrayList<co_0<Double, Double>> arrayList = new ArrayList<co_0<Double, Double>>(dArray.length);
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            arrayList.add(new co_0<Double, Double>(dArray[i2], dArray2[i2]));
        }
        return arrayList;
    }

    @Override
    public final double b(double d2) {
        return this.c.a(d2);
    }

    @Override
    public final double d(double d2) {
        double d3 = d2;
        om_0 om_02 = this;
        return om_02.c.a(d3);
    }

    @Override
    public final double e(double d2) {
        double d3 = 0.0;
        Iterator<co_0<Double, Double>> iterator2 = this.c.a().iterator();
        while (iterator2.hasNext()) {
            co_0<Double, Double> co_02;
            co_0<Double, Double> co_03;
            co_0<Double, Double> co_04 = co_03 = iterator2.next();
            if (!((Double)co_02.a <= d2)) continue;
            d3 += co_03.c().doubleValue();
        }
        return d3;
    }

    @Override
    public final double a(double d2) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        double d3 = 0.0;
        double d4 = this.e();
        for (co_0<Double, Double> co_02 : this.c.a()) {
            if (co_02.c() == 0.0) continue;
            co_0<Double, Double> co_03 = co_02;
            d4 = (Double)co_03.a;
            if (!((d3 += co_02.c().doubleValue()) >= d2)) continue;
        }
        return d4;
    }

    @Override
    public final double c() {
        double d2 = 0.0;
        Iterator<co_0<Double, Double>> iterator2 = this.c.a().iterator();
        while (iterator2.hasNext()) {
            co_0<Double, Double> co_02;
            co_0<Double, Double> co_03 = co_02 = iterator2.next();
            d2 += co_02.c() * (Double)co_03.a;
        }
        return d2;
    }

    @Override
    public final double d() {
        double d2 = 0.0;
        double d3 = 0.0;
        Iterator<co_0<Double, Double>> iterator2 = this.c.a().iterator();
        while (iterator2.hasNext()) {
            co_0<Double, Double> co_02;
            co_0<Double, Double> co_03 = co_02 = iterator2.next();
            d2 += co_02.c() * (Double)co_03.a;
            co_0<Double, Double> co_04 = co_02;
            co_03 = co_04;
            co_03 = co_02;
            d3 += co_02.c() * (Double)co_04.a * (Double)co_03.a;
        }
        double d4 = d2;
        return d3 - d4 * d4;
    }

    @Override
    public final double e() {
        double d2 = Double.POSITIVE_INFINITY;
        Iterator<co_0<Double, Double>> iterator2 = this.c.a().iterator();
        while (iterator2.hasNext()) {
            co_0<Double, Double> co_02;
            co_0<Double, Double> co_03;
            co_0<Double, Double> co_04 = co_03 = iterator2.next();
            if (!((Double)co_02.a < d2) || !(co_03.c() > 0.0)) continue;
            co_04 = co_03;
            d2 = (Double)co_04.a;
        }
        return d2;
    }

    @Override
    public final double f() {
        double d2 = Double.NEGATIVE_INFINITY;
        Iterator<co_0<Double, Double>> iterator2 = this.c.a().iterator();
        while (iterator2.hasNext()) {
            co_0<Double, Double> co_02;
            co_0<Double, Double> co_03;
            co_0<Double, Double> co_04 = co_03 = iterator2.next();
            if (!((Double)co_02.a > d2) || !(co_03.c() > 0.0)) continue;
            co_04 = co_03;
            d2 = (Double)co_04.a;
        }
        return d2;
    }

    @Override
    public final boolean g() {
        return true;
    }

    @Override
    public final boolean h() {
        return true;
    }

    @Override
    public final boolean i() {
        return true;
    }

    @Override
    public final double b() {
        return this.c.b();
    }
}


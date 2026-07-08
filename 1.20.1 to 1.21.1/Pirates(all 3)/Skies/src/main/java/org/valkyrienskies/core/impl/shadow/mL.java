/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.BR;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.lp_0;
import org.valkyrienskies.core.impl.shadow.ni_0;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pr_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class mL
implements lp_0 {
    private final List<Double> a = new ArrayList<Double>();
    private final List<double[]> b = new ArrayList<double[]>();
    private final List<double[]> c = new ArrayList<double[]>();

    private void a(double d2, double[] ... dArray) {
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            int n2;
            double[] dArray2 = (double[])dArray[i2].clone();
            if (i2 > 1) {
                double d3 = 1.0 / (double)BR.a(i2);
                n2 = 0;
                while (n2 < dArray2.length) {
                    int n3 = n2++;
                    dArray2[n3] = dArray2[n3] * d3;
                }
            }
            int n4 = this.a.size();
            this.c.add(n4 - i2, dArray2);
            double[] dArray3 = dArray2;
            for (n2 = i2; n2 < n4; ++n2) {
                double[] dArray4 = this.c.get(n4 - (n2 + 1));
                double d4 = 1.0 / (d2 - this.a.get(n4 - (n2 + 1)));
                if (Double.isInfinite(d4)) {
                    throw new pr_0(px_0.DUPLICATED_ABSCISSA_DIVISION_BY_ZERO, d2);
                }
                for (int i3 = 0; i3 < dArray2.length; ++i3) {
                    dArray4[i3] = d4 * (dArray3[i3] - dArray4[i3]);
                }
                dArray3 = dArray4;
            }
            this.b.add((double[])dArray3.clone());
            this.a.add(d2);
        }
    }

    private ni_0[] a() {
        this.b();
        ni_0 ni_02 = mL.a(0.0);
        ni_0[] ni_0Array = new ni_0[this.b.get(0).length];
        for (int i2 = 0; i2 < ni_0Array.length; ++i2) {
            ni_0Array[i2] = ni_02;
        }
        ni_0 ni_03 = mL.a(1.0);
        for (int i3 = 0; i3 < this.b.size(); ++i3) {
            double[] dArray = this.b.get(i3);
            for (int i4 = 0; i4 < ni_0Array.length; ++i4) {
                ni_0 ni_04 = ni_03.b(mL.a(dArray[i4]));
                ni_0 ni_05 = ni_0Array[i4];
                int n2 = BY.a(ni_05.a.length, ni_04.a.length);
                int n3 = BY.b(ni_05.a.length, ni_04.a.length);
                double[] dArray2 = new double[n3];
                for (int i5 = 0; i5 < n2; ++i5) {
                    dArray2[i5] = ni_05.a[i5] + ni_04.a[i5];
                }
                System.arraycopy(ni_05.a.length < ni_04.a.length ? ni_04.a : ni_05.a, n2, dArray2, n2, n3 - n2);
                ni_0Array[i4] = new ni_0(dArray2);
            }
            ni_03 = ni_03.b(mL.a(-this.a.get(i3).doubleValue(), 1.0));
        }
        return ni_0Array;
    }

    public final double[] a(double d2) {
        this.b();
        double[] dArray = new double[this.b.get(0).length];
        double d3 = 1.0;
        for (int i2 = 0; i2 < this.b.size(); ++i2) {
            double[] dArray2 = this.b.get(i2);
            for (int i3 = 0; i3 < dArray.length; ++i3) {
                int n2 = i3;
                dArray[n2] = dArray[n2] + dArray2[i3] * d3;
            }
            double d4 = d2 - this.a.get(i2);
            d3 *= d4;
        }
        return dArray;
    }

    public final lg_0[] a(lg_0 lg_02) {
        this.b();
        Object[] objectArray = new lg_0[this.b.get(0).length];
        Arrays.fill(objectArray, lg_02.c().a());
        lg_0 lg_03 = lg_02.c().b();
        for (int i2 = 0; i2 < this.b.size(); ++i2) {
            Object object = this.b.get(i2);
            for (int i3 = 0; i3 < objectArray.length; ++i3) {
                objectArray[i3] = ((lg_0)objectArray[i3]).a(lg_03.j(object[i3]));
            }
            lg_0 lg_04 = lg_02;
            double d2 = this.a.get(i2);
            object = lg_04;
            lg_0 lg_05 = lg_04.h(-d2);
            lg_03 = lg_03.b(lg_05);
        }
        return objectArray;
    }

    private void b() {
        if (this.a.isEmpty()) {
            throw new pf_0(px_0.EMPTY_INTERPOLATION_SAMPLE);
        }
    }

    private static ni_0 a(double ... dArray) {
        return new ni_0(dArray);
    }
}


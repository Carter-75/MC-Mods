/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ao
 */
public abstract class ao_0
implements AA {
    private double[] a;

    public void c(double[] dArray) {
        this.a = dArray == null ? null : (double[])dArray.clone();
    }

    private double[] f() {
        if (this.a == null) {
            return null;
        }
        return (double[])this.a.clone();
    }

    public final double[] e() {
        return this.a;
    }

    public void c(double[] dArray, int n2, int n3) {
        if (dArray == null) {
            throw new pl_0(px_0.INPUT_ARRAY, new Object[0]);
        }
        if (n2 < 0) {
            throw new pj_0(px_0.START_POSITION, n2);
        }
        if (n3 < 0) {
            throw new pj_0(px_0.LENGTH, n3);
        }
        if (n2 + n3 > dArray.length) {
            throw new pm_0(px_0.SUBARRAY_ENDS_AFTER_ARRAY_END, (Number)(n2 + n3), dArray.length, true);
        }
        this.a = new double[n3];
        System.arraycopy(dArray, n2, this.a, 0, n3);
    }

    private double g() {
        ao_0 ao_02 = this;
        return ao_02.a(ao_02.a);
    }

    public double a(double[] dArray) {
        int n2 = 0;
        int n3 = 0;
        double[] dArray2 = dArray;
        ch_0.a(dArray, n3, n2, false);
        return this.a(dArray, 0, dArray.length);
    }

    public abstract double a(double[] var1, int var2, int var3);

    public abstract AA d();

    protected static boolean d(double[] dArray, int n2, int n3) {
        return ch_0.a(dArray, n2, n3, false);
    }

    protected static boolean a(double[] dArray, int n2, int n3, boolean bl) {
        return ch_0.a(dArray, n2, n3, true);
    }

    protected static boolean a_(double[] dArray, double[] dArray2, int n2, int n3) {
        return ch_0.a(dArray, dArray2, n2, n3, false);
    }

    protected static boolean a(double[] dArray, double[] dArray2, int n2, int n3, boolean bl) {
        return ch_0.a(dArray, dArray2, n2, n3, true);
    }
}


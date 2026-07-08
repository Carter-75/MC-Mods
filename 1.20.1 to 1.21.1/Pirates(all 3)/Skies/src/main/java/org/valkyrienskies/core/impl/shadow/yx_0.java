/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pr_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.yI;
import org.valkyrienskies.core.impl.shadow.yo_0;
import org.valkyrienskies.core.impl.shadow.yp_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.yx
 */
@Deprecated
public abstract class yx_0
implements yo_0 {
    yp_0[] a;
    double[][] b;
    final int c;

    private yx_0(int n2) {
        this(n2, 1.0);
    }

    protected yx_0(int n2, double d2) {
        this(yx_0.a(n2, d2));
    }

    protected yx_0(double[] dArray) {
        if (dArray == null) {
            throw new pl_0();
        }
        if (dArray.length == 0) {
            throw new pr_0();
        }
        this.c = dArray.length;
        this.b = new double[this.c][this.c];
        for (int i2 = 0; i2 < this.c; ++i2) {
            double[] dArray2 = this.b[i2];
            for (int i3 = 0; i3 < i2 + 1; ++i3) {
                if (dArray[i3] == 0.0) {
                    throw new pr_0(px_0.EQUAL_VERTICES_IN_SIMPLEX, new Object[0]);
                }
                System.arraycopy(dArray, 0, dArray2, 0, i3 + 1);
            }
        }
    }

    protected yx_0(double[][] dArray) {
        if (dArray.length <= 0) {
            throw new pk_0(px_0.SIMPLEX_NEED_ONE_POINT, dArray.length);
        }
        this.c = dArray.length - 1;
        this.b = new double[this.c][this.c];
        double[] dArray2 = dArray[0];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            double[] dArray3 = dArray[i2];
            if (dArray3.length != this.c) {
                throw new oS(dArray3.length, this.c);
            }
            for (int i3 = 0; i3 < i2; ++i3) {
                double[] dArray4 = dArray[i3];
                boolean bl = true;
                for (int i4 = 0; i4 < this.c; ++i4) {
                    if (dArray3[i4] == dArray4[i4]) continue;
                    bl = false;
                    break;
                }
                if (!bl) continue;
                throw new oV(px_0.EQUAL_VERTICES_IN_SIMPLEX, i2, i3);
            }
            if (i2 <= 0) continue;
            double[] dArray5 = this.b[i2 - 1];
            for (int i5 = 0; i5 < this.c; ++i5) {
                dArray5[i5] = dArray3[i5] - dArray2[i5];
            }
        }
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.a.length;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public abstract void a(yI.1 var1, yI.2 var2);

    public final void a(double[] dArray) {
        if (this.c != dArray.length) {
            throw new oS(this.c, dArray.length);
        }
        this.a = new yp_0[this.c + 1];
        this.a[0] = new yp_0(dArray, Double.NaN);
        for (int i2 = 0; i2 < this.c; ++i2) {
            double[] dArray2 = this.b[i2];
            double[] dArray3 = new double[this.c];
            for (int i3 = 0; i3 < this.c; ++i3) {
                dArray3[i3] = dArray[i3] + dArray2[i3];
            }
            this.a[i2 + 1] = new yp_0(dArray3, Double.NaN);
        }
    }

    public final void a(kW kW2, Comparator<yp_0> comparator) {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            yp_0 yp_02 = this.a[i2];
            Object object = yp_02;
            object = yp_02;
            object = (double[])yp_02.a;
            if (!Double.isNaN((Double)yp_02.c())) continue;
            this.a[i2] = new yp_0((double[])object, kW2.a((double[])object), false);
        }
        Arrays.sort(this.a, comparator);
    }

    protected final void a(yp_0 yp_02, Comparator<yp_0> comparator) {
        for (int i2 = 0; i2 < this.c; ++i2) {
            if (comparator.compare(this.a[i2], yp_02) <= 0) continue;
            yp_0 yp_03 = this.a[i2];
            this.a[i2] = yp_02;
            yp_02 = yp_03;
        }
        this.a[this.c] = yp_02;
    }

    public final yp_0[] c() {
        yp_0[] yp_0Array = new yp_0[this.a.length];
        System.arraycopy(this.a, 0, yp_0Array, 0, this.a.length);
        return yp_0Array;
    }

    public final yp_0 a(int n2) {
        if (n2 < 0 || n2 >= this.a.length) {
            throw new po_0(n2, (Number)0, this.a.length - 1);
        }
        return this.a[n2];
    }

    protected final void a(int n2, yp_0 yp_02) {
        if (n2 < 0 || n2 >= this.a.length) {
            throw new po_0(n2, (Number)0, this.a.length - 1);
        }
        this.a[n2] = yp_02;
    }

    protected final void a(yp_0[] yp_0Array) {
        if (yp_0Array.length != this.a.length) {
            throw new oS(yp_0Array.length, this.a.length);
        }
        this.a = yp_0Array;
    }

    private static double[] a(int n2, double d2) {
        double[] dArray = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = d2;
        }
        return dArray;
    }
}


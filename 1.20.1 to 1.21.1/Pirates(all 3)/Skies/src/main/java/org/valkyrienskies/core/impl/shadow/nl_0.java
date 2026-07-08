/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kS;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.ln_0;
import org.valkyrienskies.core.impl.shadow.ni_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.nl
 */
public final class nl_0
implements kS,
ln_0 {
    private final double[] a;
    private final ni_0[] b;
    private final int c;

    public nl_0(double[] dArray, ni_0[] ni_0Array) {
        if (dArray == null) {
            throw new pl_0();
        }
        if (dArray.length < 2) {
            throw new pn_0((pw_0)px_0.NOT_ENOUGH_POINTS_IN_SPLINE_PARTITION, (Number)2, dArray.length, false);
        }
        if (dArray.length - 1 != ni_0Array.length) {
            throw new oS(ni_0Array.length, dArray.length);
        }
        ch_0.a(dArray);
        this.c = dArray.length - 1;
        this.a = new double[this.c + 1];
        System.arraycopy(dArray, 0, this.a, 0, this.c + 1);
        this.b = new ni_0[this.c];
        System.arraycopy(ni_0Array, 0, this.b, 0, this.c);
    }

    public final double a(double d2) {
        if (d2 < this.a[0] || d2 > this.a[this.c]) {
            throw new po_0(d2, (Number)this.a[0], this.a[this.c]);
        }
        int n2 = Arrays.binarySearch(this.a, d2);
        if (n2 < 0) {
            n2 = -n2 - 2;
        }
        if (n2 >= this.b.length) {
            --n2;
        }
        return this.b[n2].a(d2 - this.a[n2]);
    }

    public final lc_0 a() {
        return this.b();
    }

    private nl_0 b() {
        ni_0[] ni_0Array = new ni_0[this.c];
        for (int i2 = 0; i2 < this.c; ++i2) {
            ni_0Array[i2] = this.b[i2].c();
        }
        return new nl_0(this.a, ni_0Array);
    }

    public final lg_0 a(lg_0 lg_02) {
        lg_0 lg_03 = lg_02;
        double d2 = lg_03.b[0];
        if (d2 < this.a[0] || d2 > this.a[this.c]) {
            throw new po_0(d2, (Number)this.a[0], this.a[this.c]);
        }
        int n2 = Arrays.binarySearch(this.a, d2);
        if (n2 < 0) {
            n2 = -n2 - 2;
        }
        if (n2 >= this.b.length) {
            --n2;
        }
        double d3 = this.a[n2];
        lg_0 lg_04 = lg_02;
        return this.b[n2].a(lg_04.h(-d3));
    }

    private int c() {
        return this.c;
    }

    private ni_0[] d() {
        ni_0[] ni_0Array = new ni_0[this.c];
        System.arraycopy(this.b, 0, ni_0Array, 0, this.c);
        return ni_0Array;
    }

    private double[] e() {
        double[] dArray = new double[this.c + 1];
        System.arraycopy(this.a, 0, dArray, 0, this.c + 1);
        return dArray;
    }

    private boolean b(double d2) {
        return !(d2 < this.a[0]) && !(d2 > this.a[this.c]);
    }
}


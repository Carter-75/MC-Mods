/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oJ;
import org.valkyrienskies.core.impl.shadow.oc_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.os
 */
public final class os_0
extends oc_0 {
    private static final long b = -436928820673516179L;
    private final int c;
    private final int d;
    private final int e;
    private double f = Double.NaN;
    private boolean g = false;

    private os_0(int n2, int n3, int n4) {
        this(new zR(), n2, n3, n4);
    }

    public os_0(zF zF2, int n2, int n3, int n4) {
        super(zF2);
        if (n2 <= 0) {
            throw new pk_0(px_0.POPULATION_SIZE, n2);
        }
        if (n3 < 0) {
            throw new pj_0(px_0.NUMBER_OF_SUCCESSES, n3);
        }
        if (n4 < 0) {
            throw new pj_0(px_0.NUMBER_OF_SAMPLES, n4);
        }
        if (n3 > n2) {
            throw new pm_0(px_0.NUMBER_OF_SUCCESS_LARGER_THAN_POPULATION_SIZE, (Number)n3, n2, true);
        }
        if (n4 > n2) {
            throw new pm_0(px_0.SAMPLE_SIZE_LARGER_THAN_POPULATION_SIZE, (Number)n4, n2, true);
        }
        this.c = n3;
        this.d = n2;
        this.e = n4;
    }

    public final double d(int n2) {
        os_0 os_02 = this;
        int[] nArray = os_02.a(os_02.d, this.c, this.e);
        double d2 = n2 < nArray[0] ? 0.0 : (n2 >= nArray[1] ? 1.0 : this.c(nArray[0], n2, 1));
        return d2;
    }

    private int[] a(int n2, int n3, int n4) {
        int[] nArray = new int[2];
        nArray[0] = os_0.b(n2, n3, n4);
        int n5 = n3;
        n3 = n4;
        n2 = n5;
        nArray[1] = BY.a(n3, n2);
        return nArray;
    }

    private static int b(int n2, int n3, int n4) {
        return BY.b(0, n3 - (n2 - n4));
    }

    private int g() {
        return this.c;
    }

    private int h() {
        return this.d;
    }

    private int i() {
        return this.e;
    }

    private static int b(int n2, int n3) {
        return BY.a(n3, n2);
    }

    public final double c(int n2) {
        double d2 = ((oc_0)this).b(n2);
        if (d2 == Double.NEGATIVE_INFINITY) {
            return 0.0;
        }
        return BY.i(d2);
    }

    public final double b(int n2) {
        double d2;
        os_0 os_02 = this;
        int[] nArray = os_02.a(os_02.d, this.c, this.e);
        if (n2 < nArray[0] || n2 > nArray[1]) {
            d2 = Double.NEGATIVE_INFINITY;
        } else {
            double d3 = (double)this.e / (double)this.d;
            double d4 = (double)(this.d - this.e) / (double)this.d;
            double d5 = oJ.a(n2, this.c, d3, d4);
            double d6 = oJ.a(this.e - n2, this.d - this.c, d3, d4);
            double d7 = oJ.a(this.e, this.d, d3, d4);
            d2 = d5 + d6 - d7;
        }
        return d2;
    }

    private double e(int n2) {
        os_0 os_02 = this;
        int[] nArray = os_02.a(os_02.d, this.c, this.e);
        double d2 = n2 <= nArray[0] ? 1.0 : (n2 > nArray[1] ? 0.0 : this.c(nArray[1], n2, -1));
        return d2;
    }

    private double c(int n2, int n3, int n4) {
        double d2 = this.c(n2);
        while (n2 != n3) {
            d2 += this.c(n2 += n4);
        }
        return d2;
    }

    public final double b() {
        os_0 os_02 = this;
        os_0 os_03 = os_02;
        os_0 os_04 = this;
        os_03 = os_04;
        os_03 = this;
        return (double)os_02.e * ((double)os_04.c / (double)os_03.d);
    }

    public final double c() {
        if (!this.g) {
            os_0 os_02;
            os_0 os_03 = os_02 = this;
            double d2 = os_02.d;
            os_03 = os_02;
            double d3 = os_03.c;
            os_03 = os_02;
            double d4 = os_03.e;
            double d5 = d2;
            os_02.f = d4 * d3 * (d2 - d4) * (d2 - d3) / (d5 * d5 * (d2 - 1.0));
            this.g = true;
        }
        return this.f;
    }

    private double j() {
        os_0 os_02 = this;
        double d2 = os_02.d;
        os_02 = this;
        double d3 = os_02.c;
        os_02 = this;
        double d4 = os_02.e;
        double d5 = d2;
        return d4 * d3 * (d2 - d4) * (d2 - d3) / (d5 * d5 * (d2 - 1.0));
    }

    public final int d() {
        os_0 os_02 = this;
        os_0 os_03 = os_02;
        os_0 os_04 = this;
        os_03 = os_04;
        os_03 = this;
        return BY.b(0, os_02.e + os_04.c - os_03.d);
    }

    public final int e() {
        os_0 os_02 = this;
        os_0 os_03 = os_02;
        os_03 = this;
        return BY.a(os_02.c, os_03.e);
    }

    public final boolean f() {
        return true;
    }
}


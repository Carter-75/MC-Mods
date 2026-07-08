/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pr_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class nU
implements Serializable {
    private static nU a;
    private static nU b;
    private static nU c;
    private static nU d;
    private static nU e;
    private static final long f = 20092012L;
    private final double g;
    private final double h;
    private final double i;
    private final double j;

    private nU(double d2, double d3, double d4, double d5) {
        this.g = d2;
        this.h = d3;
        this.i = d4;
        this.j = d5;
    }

    private nU(double d2, double[] dArray) {
        if (dArray.length != 3) {
            throw new oS(dArray.length, 3);
        }
        this.g = 0.0;
        this.h = dArray[0];
        this.i = dArray[1];
        this.j = dArray[2];
    }

    private nU(double[] dArray) {
        this(0.0, dArray);
    }

    private nU a() {
        return new nU(this.g, -this.h, -this.i, -this.j);
    }

    private static nU a(nU nU2, nU nU3) {
        nU nU4 = nU2;
        double d2 = nU4.g;
        nU4 = nU2;
        double d3 = nU4.h;
        nU4 = nU2;
        double d4 = nU4.i;
        nU4 = nU2;
        double d5 = nU4.j;
        nU4 = nU3;
        double d6 = nU4.g;
        nU4 = nU3;
        double d7 = nU4.h;
        nU4 = nU3;
        double d8 = nU4.i;
        nU4 = nU3;
        double d9 = nU4.j;
        double d10 = d2 * d6 - d3 * d7 - d4 * d8 - d5 * d9;
        double d11 = d2 * d7 + d3 * d6 + d4 * d9 - d5 * d8;
        double d12 = d2 * d8 - d3 * d9 + d4 * d6 + d5 * d7;
        double d13 = d2 * d9 + d3 * d8 - d4 * d7 + d5 * d6;
        return new nU(d10, d11, d12, d13);
    }

    private nU a(nU nU2) {
        nU nU3 = nU2;
        nU nU4 = nU2 = this;
        double d2 = nU2.g;
        nU4 = nU2;
        double d3 = nU4.h;
        nU4 = nU2;
        double d4 = nU4.i;
        nU4 = nU2;
        double d5 = nU4.j;
        nU4 = nU3;
        double d6 = nU4.g;
        nU4 = nU3;
        double d7 = nU4.h;
        nU4 = nU3;
        double d8 = nU4.i;
        nU4 = nU3;
        double d9 = nU4.j;
        double d10 = d2 * d6 - d3 * d7 - d4 * d8 - d5 * d9;
        double d11 = d2 * d7 + d3 * d6 + d4 * d9 - d5 * d8;
        double d12 = d2 * d8 - d3 * d9 + d4 * d6 + d5 * d7;
        double d13 = d2 * d9 + d3 * d8 - d4 * d7 + d5 * d6;
        return new nU(d10, d11, d12, d13);
    }

    private static nU b(nU nU2, nU nU3) {
        nU nU4 = nU2;
        nU nU5 = nU4;
        nU nU6 = nU3;
        nU5 = nU6;
        nU nU7 = nU2;
        nU5 = nU7;
        nU nU8 = nU3;
        nU5 = nU8;
        nU nU9 = nU2;
        nU5 = nU9;
        nU nU10 = nU3;
        nU5 = nU10;
        nU nU11 = nU2;
        nU5 = nU11;
        nU5 = nU3;
        return new nU(nU4.g + nU6.g, nU7.h + nU8.h, nU9.i + nU10.i, nU11.j + nU5.j);
    }

    private nU b(nU nU2) {
        nU nU3 = nU2;
        nU nU4 = nU2 = this;
        nU nU5 = nU4;
        nU nU6 = nU3;
        nU5 = nU6;
        nU nU7 = nU2;
        nU5 = nU7;
        nU nU8 = nU3;
        nU5 = nU8;
        nU nU9 = nU2;
        nU5 = nU9;
        nU nU10 = nU3;
        nU5 = nU10;
        nU nU11 = nU2;
        nU5 = nU11;
        nU5 = nU3;
        return new nU(nU4.g + nU6.g, nU7.h + nU8.h, nU9.i + nU10.i, nU11.j + nU5.j);
    }

    private static nU c(nU nU2, nU nU3) {
        nU nU4 = nU2;
        nU nU5 = nU4;
        nU nU6 = nU3;
        nU5 = nU6;
        nU nU7 = nU2;
        nU5 = nU7;
        nU nU8 = nU3;
        nU5 = nU8;
        nU nU9 = nU2;
        nU5 = nU9;
        nU nU10 = nU3;
        nU5 = nU10;
        nU nU11 = nU2;
        nU5 = nU11;
        nU5 = nU3;
        return new nU(nU4.g - nU6.g, nU7.h - nU8.h, nU9.i - nU10.i, nU11.j - nU5.j);
    }

    private nU c(nU nU2) {
        nU nU3 = nU2;
        nU nU4 = nU2 = this;
        nU nU5 = nU4;
        nU nU6 = nU3;
        nU5 = nU6;
        nU nU7 = nU2;
        nU5 = nU7;
        nU nU8 = nU3;
        nU5 = nU8;
        nU nU9 = nU2;
        nU5 = nU9;
        nU nU10 = nU3;
        nU5 = nU10;
        nU nU11 = nU2;
        nU5 = nU11;
        nU5 = nU3;
        return new nU(nU4.g - nU6.g, nU7.h - nU8.h, nU9.i - nU10.i, nU11.j - nU5.j);
    }

    private static double d(nU nU2, nU nU3) {
        nU nU4 = nU2;
        nU nU5 = nU4;
        nU nU6 = nU3;
        nU5 = nU6;
        nU nU7 = nU2;
        nU5 = nU7;
        nU nU8 = nU3;
        nU5 = nU8;
        nU nU9 = nU2;
        nU5 = nU9;
        nU nU10 = nU3;
        nU5 = nU10;
        nU nU11 = nU2;
        nU5 = nU11;
        nU5 = nU3;
        return nU4.g * nU6.g + nU7.h * nU8.h + nU9.i * nU10.i + nU11.j * nU5.j;
    }

    private double d(nU nU2) {
        nU nU3 = nU2;
        nU nU4 = nU2 = this;
        nU nU5 = nU3;
        nU4 = nU5;
        nU nU6 = nU2;
        nU4 = nU6;
        nU nU7 = nU3;
        nU4 = nU7;
        nU nU8 = nU2;
        nU4 = nU8;
        nU nU9 = nU3;
        nU4 = nU9;
        nU nU10 = nU2;
        nU4 = nU10;
        nU4 = nU3;
        return nU2.g * nU5.g + nU6.h * nU7.h + nU8.i * nU9.i + nU10.j * nU4.j;
    }

    private double b() {
        return BY.a(this.g * this.g + this.h * this.h + this.i * this.i + this.j * this.j);
    }

    private nU c() {
        double d2;
        double d3 = this.b();
        if (d2 < cq_0.b) {
            throw new pr_0(px_0.NORM, d3);
        }
        return new nU(this.g / d3, this.h / d3, this.i / d3, this.j / d3);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof nU) {
            nU nU2;
            nU nU3 = nU2 = (nU)nU2;
            if (this.g == nU3.g) {
                nU3 = nU2;
                if (this.h == nU3.h) {
                    nU3 = nU2;
                    if (this.i == nU3.i) {
                        nU3 = nU2;
                        if (this.j == nU3.j) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int n2 = 17;
        double[] dArray = new double[]{this.g, this.h, this.i, this.j};
        int cfr_ignored_0 = dArray.length;
        for (int i2 = 0; i2 < 4; ++i2) {
            double d2 = dArray[i2];
            int n3 = ci_0.a(d2);
            n2 = n2 * 31 + n3;
        }
        return n2;
    }

    private boolean a(nU nU2, double d2) {
        nU nU3 = nU2;
        if (cq_0.b(this.g, nU3.g, d2)) {
            nU3 = nU2;
            if (cq_0.b(this.h, nU3.h, d2)) {
                nU3 = nU2;
                if (cq_0.b(this.i, nU3.i, d2)) {
                    nU3 = nU2;
                    if (cq_0.b(this.j, nU3.j, d2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean a(double d2) {
        return cq_0.b(this.b(), 1.0, d2);
    }

    private boolean b(double d2) {
        nU nU2;
        nU nU3 = this;
        return BY.w(nU2.g) <= d2;
    }

    private nU d() {
        nU nU2;
        nU nU3 = this;
        if (nU2.g < 0.0) {
            nU nU4;
            nU nU5 = nU4 = this.c();
            nU3 = nU5;
            nU nU6 = nU4;
            nU3 = nU6;
            nU nU7 = nU4;
            nU3 = nU7;
            nU3 = nU4;
            return new nU(-nU5.g, -nU6.h, -nU7.i, -nU3.j);
        }
        return this.c();
    }

    private nU e() {
        double d2;
        double d3 = this.g * this.g + this.h * this.h + this.i * this.i + this.j * this.j;
        if (d2 < cq_0.b) {
            throw new pr_0(px_0.NORM, d3);
        }
        return new nU(this.g / d3, -this.h / d3, -this.i / d3, -this.j / d3);
    }

    private double f() {
        return this.g;
    }

    private double g() {
        return this.h;
    }

    private double h() {
        return this.i;
    }

    private double i() {
        return this.j;
    }

    private double j() {
        nU nU2 = this;
        return nU2.g;
    }

    private double[] k() {
        double[] dArray = new double[3];
        nU nU2 = this;
        dArray[0] = nU2.h;
        nU2 = this;
        dArray[1] = nU2.i;
        nU2 = this;
        dArray[2] = nU2.j;
        return dArray;
    }

    private nU c(double d2) {
        return new nU(d2 * this.g, d2 * this.h, d2 * this.i, d2 * this.j);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append(this.g).append(" ").append(this.h).append(" ").append(this.i).append(" ").append(this.j).append("]");
        return stringBuilder.toString();
    }

    static {
        new nU(1.0, 0.0, 0.0, 0.0);
        new nU(0.0, 0.0, 0.0, 0.0);
        new nU(0.0, 1.0, 0.0, 0.0);
        new nU(0.0, 0.0, 1.0, 0.0);
        new nU(0.0, 0.0, 0.0, 1.0);
    }
}


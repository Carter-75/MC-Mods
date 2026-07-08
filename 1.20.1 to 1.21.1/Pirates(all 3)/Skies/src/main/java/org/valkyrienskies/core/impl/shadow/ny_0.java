/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.ny$1
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.nP;
import org.valkyrienskies.core.impl.shadow.nq_0;
import org.valkyrienskies.core.impl.shadow.nr_0;
import org.valkyrienskies.core.impl.shadow.nx_0;
import org.valkyrienskies.core.impl.shadow.ny;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.pe_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.vi_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.ny
 */
public final class ny_0
extends nq_0
implements nx_0<lc_0> {
    private static final double d = 1.0E-6;
    private static final int e = 5;
    private static final int f = 2;
    private static final double g = 0.0625;
    private final int h;
    private int i;

    public ny_0() {
        this(1.0E-6, 5);
    }

    public ny_0(double d2, int n2) {
        super(d2);
        this.h = 5;
        this.i = nr_0.ANY_SIDE$37d0779;
    }

    private ny_0(double d2, double d3, int n2) {
        super(d2, d3);
        if (n2 < 2) {
            throw new pn_0(n2, (Number)2, true);
        }
        this.h = n2;
        this.i = nr_0.ANY_SIDE$37d0779;
    }

    private ny_0(double d2, double d3, double d4, int n2) {
        super(d2, d3, d4);
        if (n2 < 2) {
            throw new pn_0(n2, (Number)2, true);
        }
        this.h = n2;
        this.i = nr_0.ANY_SIDE$37d0779;
    }

    private int a() {
        return this.h;
    }

    @Override
    protected final double j() {
        int n2;
        int n3;
        double[] dArray = new double[this.h + 1];
        double[] dArray2 = new double[this.h + 1];
        dArray[0] = this.d();
        dArray[1] = this.f();
        dArray[2] = this.e();
        double d2 = dArray[2];
        double d3 = dArray[1];
        double d4 = dArray[0];
        nP.b(d4, d3, d2);
        dArray2[1] = this.b(dArray[1]);
        if (cq_0.b(dArray2[1], 0.0, 1)) {
            return dArray[1];
        }
        dArray2[0] = this.b(dArray[0]);
        if (cq_0.b(dArray2[0], 0.0, 1)) {
            return dArray[0];
        }
        if (dArray2[0] * dArray2[1] < 0.0) {
            n3 = 2;
            n2 = 1;
        } else {
            dArray2[2] = this.b(dArray[2]);
            if (cq_0.b(dArray2[2], 0.0, 1)) {
                return dArray[2];
            }
            if (dArray2[1] * dArray2[2] < 0.0) {
                n3 = 3;
                n2 = 2;
            } else {
                throw new pe_0(dArray[0], dArray[2], dArray2[0], dArray2[2]);
            }
        }
        double[] dArray3 = new double[dArray.length];
        double d5 = dArray[n2 - 1];
        double d6 = dArray2[n2 - 1];
        double d7 = BY.w(d6);
        int n4 = 0;
        double d8 = dArray[n2];
        double d9 = dArray2[n2];
        double d10 = BY.w(d9);
        int n5 = 0;
        while (true) {
            double d11;
            double d12;
            double d13;
            int n6;
            double d14;
            if (d8 - d5 <= (d14 = this.g() + this.h() * BY.e(BY.w(d5), BY.w(d8))) || BY.e(d7, d10) < this.i()) {
                switch (ny.1.a[this.i - 1]) {
                    case 1: {
                        if (d7 < d10) {
                            return d5;
                        }
                        return d8;
                    }
                    case 2: {
                        return d5;
                    }
                    case 3: {
                        return d8;
                    }
                    case 4: {
                        if (d6 <= 0.0) {
                            return d5;
                        }
                        return d8;
                    }
                    case 5: {
                        if (d6 < 0.0) {
                            return d8;
                        }
                        return d5;
                    }
                }
                throw new oY();
            }
            if (n4 >= 2) {
                n6 = n4 - 2;
                double d15 = (1 << n6) - 1;
                double d16 = n6 + 1;
                d13 = (d15 * d6 - d16 * 0.0625 * d9) / (d15 + d16);
            } else if (n5 >= 2) {
                int n7 = n5 - 2;
                double d17 = n7 + 1;
                double d18 = (1 << n7) - 1;
                d13 = (d18 * d9 - d17 * 0.0625 * d6) / (d17 + d18);
            } else {
                d13 = 0.0;
            }
            int n8 = 0;
            int n9 = n3;
            do {
                double d19;
                int n10;
                System.arraycopy(dArray, n8, dArray3, n8, n9 - n8);
                int n11 = n9;
                n6 = n8;
                double[] dArray4 = dArray2;
                double[] dArray5 = dArray3;
                double d20 = d13;
                for (int i2 = n6; i2 < n11 - 1; ++i2) {
                    int n12 = i2 + 1 - n6;
                    for (n10 = n11 - 1; n10 > i2; --n10) {
                        dArray5[n10] = (dArray5[n10] - dArray5[n10 - 1]) / (dArray4[n10] - dArray4[n10 - n12]);
                    }
                }
                double d21 = 0.0;
                for (n10 = n11 - 1; n10 >= n6; --n10) {
                    d21 = dArray5[n10] + d21 * (d20 - dArray4[n10]);
                }
                d12 = d21;
                if (d19 > d5 && d12 < d8) continue;
                if (n2 - n8 >= n9 - n2) {
                    ++n8;
                } else {
                    --n9;
                }
                d12 = Double.NaN;
            } while (Double.isNaN(d12) && n9 - n8 > 1);
            if (Double.isNaN(d12)) {
                d12 = d5 + 0.5 * (d8 - d5);
                n8 = n2 - 1;
                n9 = n2;
            }
            if (cq_0.b(d11 = this.b(d12), 0.0, 1)) {
                return d12;
            }
            if (n3 > 2 && n9 - n8 != n3) {
                n3 = n9 - n8;
                System.arraycopy(dArray, n8, dArray, 0, n3);
                System.arraycopy(dArray2, n8, dArray2, 0, n3);
                n2 -= n8;
            } else if (n3 == dArray.length) {
                --n3;
                if (n2 >= (dArray.length + 1) / 2) {
                    System.arraycopy(dArray, 1, dArray, 0, n3);
                    System.arraycopy(dArray2, 1, dArray2, 0, n3);
                    --n2;
                }
            }
            System.arraycopy(dArray, n2, dArray, n2 + 1, n3 - n2);
            dArray[n2] = d12;
            System.arraycopy(dArray2, n2, dArray2, n2 + 1, n3 - n2);
            dArray2[n2] = d11;
            ++n3;
            if (d11 * d6 <= 0.0) {
                d8 = d12;
                d9 = d11;
                d10 = BY.w(d9);
                ++n4;
                n5 = 0;
                continue;
            }
            d5 = d12;
            d6 = d11;
            d7 = BY.w(d6);
            n4 = 0;
            ++n5;
            ++n2;
        }
    }

    private static double a(double d2, double[] dArray, double[] dArray2, int n2, int n3) {
        int n4;
        for (int i2 = n2; i2 < n3 - 1; ++i2) {
            int n5 = i2 + 1 - n2;
            for (n4 = n3 - 1; n4 > i2; --n4) {
                dArray[n4] = (dArray[n4] - dArray[n4 - 1]) / (dArray2[n4] - dArray2[n4 - n5]);
            }
        }
        double d3 = 0.0;
        for (n4 = n3 - 1; n4 >= n2; --n4) {
            d3 = dArray[n4] + d3 * (d2 - dArray2[n4]);
        }
        return d3;
    }

    @Override
    public final double a(int n2, vi_0.1 var2_2, double d2, double d3, int n3) {
        this.i = n3;
        return super.a(n2, var2_2, d2, d3);
    }

    @Override
    public final double a(int n2, lc_0 lc_02, double d2, double d3, double d4, int n3) {
        this.i = n3;
        return super.b(n2, lc_02, d2, d3, d4);
    }
}


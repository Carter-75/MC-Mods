/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.th_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

final class tI {
    final double[][] a;
    final double[] b;
    final double[] c;
    tq_0 d;
    tq_0 e;
    private tq_0 f;

    tI(tq_0 object) {
        if (!object.e()) {
            throw new th_0(object.f(), object.g());
        }
        int n2 = object.f();
        this.a = object.a();
        this.b = new double[n2];
        this.c = new double[n2 - 1];
        this.d = null;
        this.e = null;
        this.f = null;
        object = this;
        n2 = ((tI)object).a.length;
        double[] dArray = new double[n2];
        for (int i2 = 0; i2 < n2 - 1; ++i2) {
            int n3;
            double d2;
            double[] dArray2 = ((tI)object).a[i2];
            ((tI)object).b[i2] = dArray2[i2];
            double d3 = 0.0;
            for (int i3 = i2 + 1; i3 < n2; ++i3) {
                double d4;
                double d5 = d4 = dArray2[i3];
                d3 += d5 * d5;
            }
            ((tI)object).c[i2] = d2 = dArray2[i2 + 1] > 0.0 ? -BY.a(d3) : BY.a(d3);
            if (d2 == 0.0) continue;
            int n4 = i2 + 1;
            dArray2[n4] = dArray2[n4] - d2;
            double d6 = -1.0 / (d2 * dArray2[i2 + 1]);
            Arrays.fill(dArray, i2 + 1, n2, 0.0);
            for (int i4 = i2 + 1; i4 < n2; ++i4) {
                double[] dArray3 = ((tI)object).a[i4];
                double d7 = dArray2[i4];
                double d8 = dArray3[i4] * d7;
                int n5 = i4 + 1;
                while (n5 < n2) {
                    double d9 = dArray3[n5];
                    d8 += d9 * dArray2[n5];
                    int n6 = n5++;
                    dArray[n6] = dArray[n6] + d9 * d7;
                }
                dArray[i4] = d6 * (dArray[i4] + d8);
            }
            double d10 = 0.0;
            for (n3 = i2 + 1; n3 < n2; ++n3) {
                d10 += dArray[n3] * dArray2[n3];
            }
            d10 *= d6 / 2.0;
            for (n3 = i2 + 1; n3 < n2; ++n3) {
                int n7 = n3;
                dArray[n7] = dArray[n7] - d10 * dArray2[n3];
            }
            for (n3 = i2 + 1; n3 < n2; ++n3) {
                double[] dArray4 = ((tI)object).a[n3];
                for (int i5 = n3; i5 < n2; ++i5) {
                    int n8 = i5;
                    dArray4[n8] = dArray4[n8] - (dArray2[n3] * dArray[i5] + dArray[n3] * dArray2[i5]);
                }
            }
        }
        ((tI)object).b[n2 - 1] = ((tI)object).a[n2 - 1][n2 - 1];
    }

    public final tq_0 a() {
        if (this.d == null) {
            this.d = this.d().d();
        }
        return this.d;
    }

    private tq_0 d() {
        if (this.e == null) {
            int n2 = this.a.length;
            double[][] dArray = new double[n2][n2];
            for (int i2 = n2 - 1; i2 > 0; --i2) {
                int n3;
                double[] dArray2 = this.a[i2 - 1];
                dArray[i2][i2] = 1.0;
                if (dArray2[i2] == 0.0) continue;
                double d2 = 1.0 / (this.c[i2 - 1] * dArray2[i2]);
                double d3 = 1.0 / this.c[i2 - 1];
                dArray[i2][i2] = 1.0 + d3 * dArray2[i2];
                for (n3 = i2 + 1; n3 < n2; ++n3) {
                    dArray[i2][n3] = d3 * dArray2[n3];
                }
                for (n3 = i2 + 1; n3 < n2; ++n3) {
                    int n4;
                    d3 = 0.0;
                    for (n4 = i2 + 1; n4 < n2; ++n4) {
                        d3 += dArray[n3][n4] * dArray2[n4];
                    }
                    dArray[n3][i2] = (d3 *= d2) * dArray2[i2];
                    for (n4 = i2 + 1; n4 < n2; ++n4) {
                        double[] dArray3 = dArray[n3];
                        int n5 = n4;
                        dArray3[n5] = dArray3[n5] + d3 * dArray2[n4];
                    }
                }
            }
            dArray[0][0] = 1.0;
            this.e = td_0.a(dArray);
        }
        return this.e;
    }

    private tq_0 e() {
        if (this.f == null) {
            int n2 = this.b.length;
            double[][] dArray = new double[n2][n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                dArray[i2][i2] = this.b[i2];
                if (i2 > 0) {
                    dArray[i2][i2 - 1] = this.c[i2 - 1];
                }
                if (i2 >= this.b.length - 1) continue;
                dArray[i2][i2 + 1] = this.c[i2];
            }
            this.f = td_0.a(dArray);
        }
        return this.f;
    }

    private double[][] f() {
        return this.a;
    }

    final double[] b() {
        return this.b;
    }

    final double[] c() {
        return this.c;
    }

    private void g() {
        int n2 = this.a.length;
        double[] dArray = new double[n2];
        for (int i2 = 0; i2 < n2 - 1; ++i2) {
            int n3;
            double d2;
            double[] dArray2 = this.a[i2];
            this.b[i2] = dArray2[i2];
            double d3 = 0.0;
            for (int i3 = i2 + 1; i3 < n2; ++i3) {
                double d4;
                double d5 = d4 = dArray2[i3];
                d3 += d5 * d5;
            }
            this.c[i2] = d2 = dArray2[i2 + 1] > 0.0 ? -BY.a(d3) : BY.a(d3);
            if (d2 == 0.0) continue;
            int n4 = i2 + 1;
            dArray2[n4] = dArray2[n4] - d2;
            double d6 = -1.0 / (d2 * dArray2[i2 + 1]);
            Arrays.fill(dArray, i2 + 1, n2, 0.0);
            for (int i4 = i2 + 1; i4 < n2; ++i4) {
                double[] dArray3 = this.a[i4];
                double d7 = dArray2[i4];
                double d8 = dArray3[i4] * d7;
                int n5 = i4 + 1;
                while (n5 < n2) {
                    double d9 = dArray3[n5];
                    d8 += d9 * dArray2[n5];
                    int n6 = n5++;
                    dArray[n6] = dArray[n6] + d9 * d7;
                }
                dArray[i4] = d6 * (dArray[i4] + d8);
            }
            double d10 = 0.0;
            for (n3 = i2 + 1; n3 < n2; ++n3) {
                d10 += dArray[n3] * dArray2[n3];
            }
            d10 *= d6 / 2.0;
            for (n3 = i2 + 1; n3 < n2; ++n3) {
                int n7 = n3;
                dArray[n7] = dArray[n7] - d10 * dArray2[n3];
            }
            for (n3 = i2 + 1; n3 < n2; ++n3) {
                double[] dArray4 = this.a[n3];
                for (int i5 = n3; i5 < n2; ++i5) {
                    int n8 = i5;
                    dArray4[n8] = dArray4[n8] - (dArray2[n3] * dArray[i5] + dArray[n3] * dArray2[i5]);
                }
            }
        }
        this.b[n2 - 1] = this.a[n2 - 1][n2 - 1];
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.th_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

final class sW {
    final double[][] a;
    private final double[] c;
    private tq_0 d;
    private tq_0 e;
    tq_0 b;

    sW(tq_0 object) {
        if (!object.e()) {
            throw new th_0(object.f(), object.g());
        }
        int n2 = object.f();
        this.a = object.a();
        this.c = new double[n2];
        this.d = null;
        this.e = null;
        this.b = null;
        object = this;
        n2 = ((sW)object).a.length;
        int n3 = n2 - 1;
        for (int i2 = 1; i2 <= n3 - 1; ++i2) {
            int n4;
            double d2;
            int n5;
            double d3 = 0.0;
            for (int i3 = i2; i3 <= n3; ++i3) {
                d3 += BY.w(((sW)object).a[i3][i2 - 1]);
            }
            if (cq_0.a(d3, 0.0)) continue;
            double d4 = 0.0;
            for (int i4 = n3; i4 >= i2; --i4) {
                ((sW)object).c[i4] = ((sW)object).a[i4][i2 - 1] / d3;
                d4 += ((sW)object).c[i4] * ((sW)object).c[i4];
            }
            double d5 = ((sW)object).c[i2] > 0.0 ? -BY.a(d4) : BY.a(d4);
            d4 -= ((sW)object).c[i2] * d5;
            int n6 = i2;
            ((sW)object).c[n6] = ((sW)object).c[n6] - d5;
            for (n5 = i2; n5 < n2; ++n5) {
                d2 = 0.0;
                for (n4 = n3; n4 >= i2; --n4) {
                    d2 += ((sW)object).c[n4] * ((sW)object).a[n4][n5];
                }
                d2 /= d4;
                for (n4 = i2; n4 <= n3; ++n4) {
                    double[] dArray = ((sW)object).a[n4];
                    int n7 = n5;
                    dArray[n7] = dArray[n7] - d2 * ((sW)object).c[n4];
                }
            }
            for (n5 = 0; n5 <= n3; ++n5) {
                d2 = 0.0;
                for (n4 = n3; n4 >= i2; --n4) {
                    d2 += ((sW)object).c[n4] * ((sW)object).a[n5][n4];
                }
                d2 /= d4;
                for (n4 = i2; n4 <= n3; ++n4) {
                    double[] dArray = ((sW)object).a[n5];
                    int n8 = n4;
                    dArray[n8] = dArray[n8] - d2 * ((sW)object).c[n4];
                }
            }
            ((sW)object).c[i2] = d3 * ((sW)object).c[i2];
            ((sW)object).a[i2][i2 - 1] = d3 * d5;
        }
    }

    public final tq_0 a() {
        if (this.d == null) {
            int n2;
            int n3;
            int n4 = this.a.length;
            int n5 = n4 - 1;
            int n6 = n4;
            double[][] dArray = new double[n6][n6];
            for (n3 = 0; n3 < n4; ++n3) {
                for (n2 = 0; n2 < n4; ++n2) {
                    dArray[n3][n2] = n3 == n2 ? 1.0 : 0.0;
                }
            }
            for (n3 = n5 - 1; n3 > 0; --n3) {
                if (this.a[n3][n3 - 1] == 0.0) continue;
                for (n2 = n3 + 1; n2 <= n5; ++n2) {
                    this.c[n2] = this.a[n2][n3 - 1];
                }
                for (n2 = n3; n2 <= n5; ++n2) {
                    double d2 = 0.0;
                    for (n4 = n3; n4 <= n5; ++n4) {
                        d2 += this.c[n4] * dArray[n4][n2];
                    }
                    d2 = d2 / this.c[n3] / this.a[n3][n3 - 1];
                    for (n4 = n3; n4 <= n5; ++n4) {
                        double[] dArray2 = dArray[n4];
                        int n7 = n2;
                        dArray2[n7] = dArray2[n7] + d2 * this.c[n4];
                    }
                }
            }
            this.d = td_0.a(dArray);
        }
        return this.d;
    }

    private tq_0 c() {
        if (this.e == null) {
            this.e = this.a().d();
        }
        return this.e;
    }

    public final tq_0 b() {
        if (this.b == null) {
            int n2 = this.a.length;
            double[][] dArray = new double[n2][n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                if (i2 > 0) {
                    dArray[i2][i2 - 1] = this.a[i2][i2 - 1];
                }
                for (int i3 = i2; i3 < n2; ++i3) {
                    dArray[i2][i3] = this.a[i2][i3];
                }
            }
            this.b = td_0.a(dArray);
        }
        return this.b;
    }

    private double[][] d() {
        return this.a;
    }

    private void e() {
        int n2 = this.a.length;
        int n3 = n2 - 1;
        for (int i2 = 1; i2 <= n3 - 1; ++i2) {
            int n4;
            double d2;
            int n5;
            double d3 = 0.0;
            for (int i3 = i2; i3 <= n3; ++i3) {
                d3 += BY.w(this.a[i3][i2 - 1]);
            }
            if (cq_0.a(d3, 0.0)) continue;
            double d4 = 0.0;
            for (int i4 = n3; i4 >= i2; --i4) {
                this.c[i4] = this.a[i4][i2 - 1] / d3;
                d4 += this.c[i4] * this.c[i4];
            }
            double d5 = this.c[i2] > 0.0 ? -BY.a(d4) : BY.a(d4);
            d4 -= this.c[i2] * d5;
            int n6 = i2;
            this.c[n6] = this.c[n6] - d5;
            for (n5 = i2; n5 < n2; ++n5) {
                d2 = 0.0;
                for (n4 = n3; n4 >= i2; --n4) {
                    d2 += this.c[n4] * this.a[n4][n5];
                }
                d2 /= d4;
                for (n4 = i2; n4 <= n3; ++n4) {
                    double[] dArray = this.a[n4];
                    int n7 = n5;
                    dArray[n7] = dArray[n7] - d2 * this.c[n4];
                }
            }
            for (n5 = 0; n5 <= n3; ++n5) {
                d2 = 0.0;
                for (n4 = n3; n4 >= i2; --n4) {
                    d2 += this.c[n4] * this.a[n5][n4];
                }
                d2 /= d4;
                for (n4 = i2; n4 <= n3; ++n4) {
                    double[] dArray = this.a[n5];
                    int n8 = n4;
                    dArray[n8] = dArray[n8] - d2 * this.c[n4];
                }
            }
            this.c[i2] = d3 * this.c[i2];
            this.a[i2][i2 - 1] = d3 * d5;
        }
    }
}


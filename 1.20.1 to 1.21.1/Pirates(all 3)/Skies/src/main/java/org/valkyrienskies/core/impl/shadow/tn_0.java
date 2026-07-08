/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.tn$a
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.sG;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tn;
import org.valkyrienskies.core.impl.shadow.tq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.tn
 */
public class tn_0 {
    public double[][] a;
    public double[] b;
    public tq_0 c;
    public tq_0 d;
    private tq_0 e;
    private tq_0 f;
    private final double g;

    public tn_0(sv_0 sv_02) {
        this(sv_02, 0.0);
    }

    public tn_0(tq_0 tq_02, double d2) {
        this.g = d2;
        int n2 = tq_02.f();
        int n3 = tq_02.g();
        this.a = tq_02.d().a();
        this.b = new double[BY.a(n2, n3)];
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        tn_0 tn_02 = this;
        tn_02.a(tn_02.a);
    }

    protected void a(double[][] dArray) {
        for (int i2 = 0; i2 < BY.a(dArray.length, dArray[0].length); ++i2) {
            this.a(i2, dArray);
        }
    }

    protected void a(int n2, double[][] dArray) {
        double d2;
        double[] dArray2 = dArray[n2];
        double d3 = 0.0;
        for (int i2 = n2; i2 < dArray2.length; ++i2) {
            double d4;
            double d5 = d4 = dArray2[i2];
            d3 += d5 * d5;
        }
        this.b[n2] = d2 = dArray2[n2] > 0.0 ? -BY.a(d3) : BY.a(d3);
        if (d2 != 0.0) {
            int n3 = n2;
            dArray2[n3] = dArray2[n3] - d2;
            for (int i3 = n2 + 1; i3 < dArray.length; ++i3) {
                int n4;
                double[] dArray3 = dArray[i3];
                double d6 = 0.0;
                for (n4 = n2; n4 < dArray3.length; ++n4) {
                    d6 -= dArray3[n4] * dArray2[n4];
                }
                d6 /= d2 * dArray2[n2];
                for (n4 = n2; n4 < dArray3.length; ++n4) {
                    int n5 = n4;
                    dArray3[n5] = dArray3[n5] - d6 * dArray2[n4];
                }
            }
        }
    }

    public final tq_0 a() {
        if (this.e == null) {
            int n2 = this.a.length;
            int n3 = this.a[0].length;
            double[][] dArray = new double[n3][n2];
            for (n3 = BY.a(n3, n2) - 1; n3 >= 0; --n3) {
                dArray[n3][n3] = this.b[n3];
                for (int i2 = n3 + 1; i2 < n2; ++i2) {
                    dArray[n3][i2] = this.a[i2][n3];
                }
            }
            this.e = td_0.a(dArray);
        }
        return this.e;
    }

    public final tq_0 b() {
        if (this.c == null) {
            tn_0 tn_02 = this;
            if (tn_02.d == null) {
                int n2;
                int n3 = tn_02.a.length;
                int n4 = tn_02.a[0].length;
                double[][] dArray = new double[n4][n4];
                for (n2 = n4 - 1; n2 >= BY.a(n4, n3); --n2) {
                    dArray[n2][n2] = 1.0;
                }
                for (n2 = BY.a(n4, n3) - 1; n2 >= 0; --n2) {
                    double[] dArray2 = tn_02.a[n2];
                    dArray[n2][n2] = 1.0;
                    if (dArray2[n2] == 0.0) continue;
                    for (int i2 = n2; i2 < n4; ++i2) {
                        int n5;
                        double d2 = 0.0;
                        for (n5 = n2; n5 < n4; ++n5) {
                            d2 -= dArray[i2][n5] * dArray2[n5];
                        }
                        d2 /= tn_02.b[n2] * dArray2[n2];
                        for (n5 = n2; n5 < n4; ++n5) {
                            double[] dArray3 = dArray[i2];
                            int n6 = n5;
                            dArray3[n6] = dArray3[n6] + -d2 * dArray2[n5];
                        }
                    }
                }
                tn_02.d = td_0.a(dArray);
            }
            tn_02.c = tn_02.d.d();
        }
        return this.c;
    }

    private tq_0 d() {
        if (this.d == null) {
            int n2;
            int n3 = this.a.length;
            int n4 = this.a[0].length;
            double[][] dArray = new double[n4][n4];
            for (n2 = n4 - 1; n2 >= BY.a(n4, n3); --n2) {
                dArray[n2][n2] = 1.0;
            }
            for (n2 = BY.a(n4, n3) - 1; n2 >= 0; --n2) {
                double[] dArray2 = this.a[n2];
                dArray[n2][n2] = 1.0;
                if (dArray2[n2] == 0.0) continue;
                for (int i2 = n2; i2 < n4; ++i2) {
                    int n5;
                    double d2 = 0.0;
                    for (n5 = n2; n5 < n4; ++n5) {
                        d2 -= dArray[i2][n5] * dArray2[n5];
                    }
                    d2 /= this.b[n2] * dArray2[n2];
                    for (n5 = n2; n5 < n4; ++n5) {
                        double[] dArray3 = dArray[i2];
                        int n6 = n5;
                        dArray3[n6] = dArray3[n6] + -d2 * dArray2[n5];
                    }
                }
            }
            this.d = td_0.a(dArray);
        }
        return this.d;
    }

    private tq_0 e() {
        if (this.f == null) {
            int n2 = this.a.length;
            int n3 = this.a[0].length;
            double[][] dArray = new double[n3][n2];
            for (int i2 = 0; i2 < n3; ++i2) {
                for (int i3 = 0; i3 < BY.a(i2 + 1, n2); ++i3) {
                    dArray[i2][i3] = this.a[i3][i2] / -this.b[i3];
                }
            }
            this.f = td_0.a(dArray);
        }
        return this.f;
    }

    public sG c() {
        return new tn.a(this.a, this.b, this.g, 0);
    }

    static final class 1 {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.ld_0;
import org.valkyrienskies.core.impl.shadow.le_0;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.ln_0;
import org.valkyrienskies.core.impl.shadow.lo_0;
import org.valkyrienskies.core.impl.shadow.lp_0;
import org.valkyrienskies.core.impl.shadow.lq_0;
import org.valkyrienskies.core.impl.shadow.lr_0;
import org.valkyrienskies.core.impl.shadow.ls_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.pn_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.lh
 */
public final class lh_0
implements Serializable,
lq_0,
lr_0,
ls_0 {
    private static final long a = 20120917L;
    private final int b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;

    private lh_0(int n2, double d2) {
        this(n2, d2, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private lh_0(int n2, double d2, double d3, double d4) {
        if (n2 <= 1) {
            throw new pn_0(d2, (Number)1, false);
        }
        this.b = n2;
        if (d2 <= 0.0) {
            throw new pj_0(d2);
        }
        this.c = d2;
        this.d = d2 * 0.5 * (double)(n2 - 1);
        if (2.0 * this.d >= Double.POSITIVE_INFINITY) {
            throw new pm_0(2.0 * this.d, (Number)Double.POSITIVE_INFINITY, false);
        }
        double d5 = BY.x(this.d);
        this.e = Double.NEGATIVE_INFINITY + this.d + d5;
        this.f = Double.POSITIVE_INFINITY - this.d - d5;
    }

    private int a() {
        return this.b;
    }

    private double b() {
        return this.c;
    }

    private lg_0 a(lg_0 lg_02, double d2, double[] dArray) {
        int n2;
        int n3;
        double[] dArray2 = new double[this.b];
        Object object = new double[this.b];
        for (n3 = 0; n3 < this.b; ++n3) {
            object[n3] = dArray[n3];
            for (n2 = 1; n2 <= n3; ++n2) {
                object[n3 - n2] = (object[n3 - n2 + 1] - object[n3 - n2]) / ((double)n2 * this.c);
            }
            dArray2[n3] = object[0];
        }
        n3 = lg_02.D();
        n2 = lg_02.C();
        dArray = lg_02.F();
        double d3 = lg_02.b[0] - d2;
        lg_02 = new lg_0(n2, n3, 0.0);
        lg_0 lg_03 = null;
        for (int i2 = 0; i2 < this.b; ++i2) {
            if (i2 == 0) {
                lg_03 = new lg_0(n2, n3, 1.0);
            } else {
                dArray[0] = d3 - (double)(i2 - 1) * this.c;
                object = new lg_0(n2, n3, dArray);
                lg_03 = lg_03.b((lg_0)object);
            }
            lg_02 = lg_02.a(lg_03.j(dArray2[i2]));
        }
        return lg_02;
    }

    public final 1 a(lc_0 lc_02) {
        return new ln_0(this, lc_02){
            private /* synthetic */ lc_0 a;
            private /* synthetic */ lh_0 b;
            {
                this.b = lh_02;
                this.a = lc_02;
            }

            public final double a(double d2) {
                return this.a.a(d2);
            }

            public final lg_0 a(lg_0 lg_02) {
                if (lg_02.D() >= this.b.b) {
                    throw new pm_0(lg_02.D(), (Number)this.b.b, false);
                }
                lg_0 lg_03 = lg_02;
                double d2 = BY.e(BY.d(lg_03.b[0], this.b.f), this.b.e) - this.b.d;
                double[] dArray = new double[this.b.b];
                for (int i2 = 0; i2 < this.b.b; ++i2) {
                    dArray[i2] = this.a.a(d2 + (double)i2 * this.b.c);
                }
                return lh_0.a(this.b, lg_02, d2, dArray);
            }
        };
    }

    public final 2 a(le_0 le_02) {
        return new lp_0(this, le_02){
            private /* synthetic */ le_0 a;
            private /* synthetic */ lh_0 b;
            {
                this.b = lh_02;
                this.a = le_02;
            }

            public final double[] a(double d2) {
                return this.a.a(d2);
            }

            public final lg_0[] a(lg_0 lg_02) {
                if (lg_02.D() >= this.b.b) {
                    throw new pm_0(lg_02.D(), (Number)this.b.b, false);
                }
                lg_0 lg_03 = lg_02;
                double d2 = BY.e(BY.d(lg_03.b[0], this.b.f), this.b.e) - this.b.d;
                double[][] dArray = null;
                for (int i2 = 0; i2 < this.b.b; ++i2) {
                    double[] dArray2 = this.a.a(d2 + (double)i2 * this.b.c);
                    if (i2 == 0) {
                        dArray = new double[dArray2.length][this.b.b];
                    }
                    for (int i3 = 0; i3 < dArray2.length; ++i3) {
                        dArray[i3][i2] = dArray2[i3];
                    }
                }
                lg_0[] lg_0Array = new lg_0[dArray.length];
                for (int i4 = 0; i4 < lg_0Array.length; ++i4) {
                    lg_0Array[i4] = lh_0.a(this.b, lg_02, d2, (double[])dArray[i4]);
                }
                return lg_0Array;
            }
        };
    }

    public final 3 a(ld_0 ld_02) {
        return new lo_0(this, ld_02){
            private /* synthetic */ ld_0 a;
            private /* synthetic */ lh_0 b;
            {
                this.b = lh_02;
                this.a = ld_02;
            }

            public final double[][] a(double d2) {
                return this.a.a(d2);
            }

            public final lg_0[][] a(lg_0 lg_02) {
                int n2;
                if (lg_02.D() >= this.b.b) {
                    throw new pm_0(lg_02.D(), (Number)this.b.b, false);
                }
                lg_0 lg_03 = lg_02;
                double d2 = BY.e(BY.d(lg_03.b[0], this.b.f), this.b.e) - this.b.d;
                double[][][] dArray = null;
                for (int i2 = 0; i2 < this.b.b; ++i2) {
                    double[][] dArray2 = this.a.a(d2 + (double)i2 * this.b.c);
                    if (i2 == 0) {
                        dArray = new double[dArray2.length][dArray2[0].length][this.b.b];
                    }
                    for (n2 = 0; n2 < dArray2.length; ++n2) {
                        for (int i3 = 0; i3 < dArray2[n2].length; ++i3) {
                            dArray[n2][i3][i2] = dArray2[n2][i3];
                        }
                    }
                }
                lg_0[][] lg_0Array = new lg_0[dArray.length][((void)dArray[0]).length];
                for (int i4 = 0; i4 < lg_0Array.length; ++i4) {
                    for (n2 = 0; n2 < ((void)dArray[i4]).length; ++n2) {
                        lg_0Array[i4][n2] = lh_0.a(this.b, lg_02, d2, dArray[i4][n2]);
                    }
                }
                return lg_0Array;
            }
        };
    }

    static /* synthetic */ lg_0 a(lh_0 lh_02, lg_0 lg_02, double d2, double[] object) {
        int n2;
        int n3;
        double[] dArray = object;
        double d3 = d2;
        double[] dArray2 = new double[lh_02.b];
        object = new double[lh_02.b];
        for (n3 = 0; n3 < lh_02.b; ++n3) {
            object[n3] = dArray[n3];
            for (n2 = 1; n2 <= n3; ++n2) {
                object[n3 - n2] = (object[n3 - n2 + 1] - object[n3 - n2]) / ((double)n2 * lh_02.c);
            }
            dArray2[n3] = object[0];
        }
        n3 = lg_02.D();
        n2 = lg_02.C();
        dArray = lg_02.F();
        double d4 = lg_02.b[0] - d3;
        lg_02 = new lg_0(n2, n3, 0.0);
        object = null;
        for (int i2 = 0; i2 < lh_02.b; ++i2) {
            if (i2 == 0) {
                object = new lg_0(n2, n3, 1.0);
            } else {
                dArray[0] = d4 - (double)(i2 - 1) * lh_02.c;
                lg_0 lg_03 = new lg_0(n2, n3, dArray);
                object = ((lg_0)object).b(lg_03);
            }
            lg_02 = lg_02.a(((lg_0)object).j(dArray2[i2]));
        }
        return lg_02;
    }
}


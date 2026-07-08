/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.AB;
import org.valkyrienskies.core.impl.shadow.AG;
import org.valkyrienskies.core.impl.shadow.AH;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ao_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class AM
extends an_0
implements Serializable,
AB {
    private static final long c = -9111962718267217978L;
    protected AH a = null;
    private boolean d = true;
    public boolean b = true;

    public AM() {
        this.a = new AH();
    }

    public AM(AH aH) {
        this.d = false;
        this.a = aH;
    }

    public AM(boolean bl) {
        this.a = new AH();
        this.b = bl;
    }

    public AM(boolean bl, AH aH) {
        this.d = false;
        this.a = aH;
        this.b = bl;
    }

    private AM(AM aM) {
        AM.a(aM, this);
    }

    public final void a(double d2) {
        if (this.d) {
            ((an_0)this.a).a(d2);
        }
    }

    public final double c() {
        if (this.a.a == 0L) {
            return Double.NaN;
        }
        if (this.a.a == 1L) {
            return 0.0;
        }
        if (this.b) {
            return this.a.e / ((double)this.a.a - 1.0);
        }
        return this.a.e / (double)this.a.a;
    }

    public final long g_() {
        return this.a.g_();
    }

    public final void b() {
        if (this.d) {
            ((an_0)this.a).b();
        }
    }

    public final double a(double[] dArray) {
        if (dArray == null) {
            throw new pl_0(px_0.INPUT_ARRAY, new Object[0]);
        }
        return ((ao_0)this).a(dArray, 0, dArray.length);
    }

    public final double a(double[] dArray, int n2, int n3) {
        double d2 = Double.NaN;
        int n4 = n3;
        int n5 = n2;
        double[] dArray2 = dArray;
        if (ch_0.a(dArray, n5, n4, false)) {
            ((an_0)this).b();
            if (n3 == 1) {
                d2 = 0.0;
            } else if (n3 > 1) {
                AG aG = new AG();
                double d3 = ((ao_0)aG).a(dArray, n2, n3);
                d2 = this.a(dArray, d3, n2, n3);
            }
        }
        return d2;
    }

    public final double a(double[] dArray, double[] dArray2, int n2, int n3) {
        double d2 = Double.NaN;
        if (AM.a_(dArray, dArray2, n2, n3)) {
            ((an_0)this).b();
            if (n3 == 1) {
                d2 = 0.0;
            } else if (n3 > 1) {
                AG aG = new AG();
                double d3 = aG.a(dArray, dArray2, n2, n3);
                d2 = this.a(dArray, dArray2, d3, n2, n3);
            }
        }
        return d2;
    }

    public final double a(double[] dArray, double[] dArray2) {
        return this.a(dArray, dArray2, 0, dArray.length);
    }

    public final double a(double[] dArray, double d2, int n2, int n3) {
        double d3 = Double.NaN;
        int n4 = n3;
        int n5 = n2;
        double[] dArray2 = dArray;
        if (ch_0.a(dArray, n5, n4, false)) {
            if (n3 == 1) {
                d3 = 0.0;
            } else if (n3 > 1) {
                double d4 = 0.0;
                double d5 = 0.0;
                for (int i2 = n2; i2 < n2 + n3; ++i2) {
                    double d6;
                    double d7 = d6 = dArray[i2] - d2;
                    d4 += d7 * d7;
                    d5 += d6;
                }
                double d8 = n3;
                if (this.b) {
                    double d9 = d5;
                    d3 = (d4 - d9 * d9 / d8) / (d8 - 1.0);
                } else {
                    double d10 = d5;
                    d3 = (d4 - d10 * d10 / d8) / d8;
                }
            }
        }
        return d3;
    }

    public final double a(double[] dArray, double d2) {
        return this.a(dArray, d2, 0, dArray.length);
    }

    private double a(double[] dArray, double[] dArray2, double d2, int n2, int n3) {
        double d3 = Double.NaN;
        if (AM.a_(dArray, dArray2, n2, n3)) {
            if (n3 == 1) {
                d3 = 0.0;
            } else if (n3 > 1) {
                double d4 = 0.0;
                double d5 = 0.0;
                for (int i2 = n2; i2 < n2 + n3; ++i2) {
                    double d6;
                    double d7 = d6 = dArray[i2] - d2;
                    d4 += dArray2[i2] * (d7 * d7);
                    d5 += dArray2[i2] * d6;
                }
                double d8 = 0.0;
                for (int i3 = n2; i3 < n2 + n3; ++i3) {
                    d8 += dArray2[i3];
                }
                if (this.b) {
                    double d9 = d5;
                    d3 = (d4 - d9 * d9 / d8) / (d8 - 1.0);
                } else {
                    double d10 = d5;
                    d3 = (d4 - d10 * d10 / d8) / d8;
                }
            }
        }
        return d3;
    }

    private double a(double[] dArray, double[] dArray2, double d2) {
        return this.a(dArray, dArray2, d2, 0, dArray.length);
    }

    public final boolean f() {
        return this.b;
    }

    public final void a(boolean bl) {
        this.b = bl;
    }

    public final AM g() {
        AM aM = new AM();
        AM.a(this, aM);
        return aM;
    }

    public static void a(AM aM, AM aM2) {
        ci_0.a(aM);
        ci_0.a(aM2);
        aM2.c(aM.e());
        aM2.a = aM.a.i();
        aM2.b = aM.b;
        aM2.d = aM.d;
    }

    public final /* synthetic */ an_0 a() {
        return this.g();
    }

    public final /* synthetic */ AA d() {
        return this.g();
    }
}


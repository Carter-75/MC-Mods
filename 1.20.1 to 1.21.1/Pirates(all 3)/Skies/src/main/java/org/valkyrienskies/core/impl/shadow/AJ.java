/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.AG;
import org.valkyrienskies.core.impl.shadow.AL;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ao_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

public final class AJ
extends an_0
implements Serializable {
    private static final long a = 7101857578996691352L;
    private AL b = null;
    private boolean c;

    public AJ() {
        this.c = true;
        this.b = new AL();
    }

    private AJ(AL aL) {
        this.c = false;
        this.b = aL;
    }

    private AJ(AJ aJ) {
        AJ.a(aJ, this);
    }

    public final void a(double d2) {
        if (this.c) {
            ((an_0)this.b).a(d2);
        }
    }

    public final double c() {
        double d2;
        if (this.b.a < 3L) {
            return Double.NaN;
        }
        double d3 = this.b.e / (double)(this.b.a - 1L);
        if (d2 < 1.0E-19) {
            return 0.0;
        }
        double d4 = this.b.g_();
        return d4 * this.b.f / ((d4 - 1.0) * (d4 - 2.0) * BY.a(d3) * d3);
    }

    public final long g_() {
        return this.b.g_();
    }

    public final void b() {
        if (this.c) {
            ((an_0)this.b).b();
        }
    }

    public final double a(double[] dArray, int n2, int n3) {
        double d2 = Double.NaN;
        int n4 = n3;
        int n5 = n2;
        double[] dArray2 = dArray;
        if (ch_0.a(dArray, n5, n4, false) && n3 > 2) {
            AG aG = new AG();
            double d3 = ((ao_0)aG).a(dArray, n2, n3);
            double d4 = 0.0;
            double d5 = 0.0;
            for (int i2 = n2; i2 < n2 + n3; ++i2) {
                double d6;
                double d7 = d6 = dArray[i2] - d3;
                d4 += d7 * d7;
                d5 += d6;
            }
            double d8 = d5;
            double d9 = (d4 - d8 * d8 / (double)n3) / (double)(n3 - 1);
            double d10 = 0.0;
            for (int i3 = n2; i3 < n2 + n3; ++i3) {
                double d11;
                double d12 = d11 = dArray[i3] - d3;
                d10 += d12 * d12 * d11;
            }
            double d13 = d9;
            double d14 = n3;
            d2 = d14 / ((d14 - 1.0) * (d14 - 2.0)) * (d10 /= d13 * BY.a(d13));
        }
        return d2;
    }

    private AJ f() {
        AJ aJ = new AJ();
        AJ.a(this, aJ);
        return aJ;
    }

    private static void a(AJ aJ, AJ aJ2) {
        ci_0.a(aJ);
        ci_0.a(aJ2);
        aJ2.c(aJ.e());
        aJ2.b = new AL(aJ.b.h());
        aJ2.c = aJ.c;
    }

    public final /* synthetic */ an_0 a() {
        return this.f();
    }

    public final /* synthetic */ AA d() {
        return this.f();
    }
}


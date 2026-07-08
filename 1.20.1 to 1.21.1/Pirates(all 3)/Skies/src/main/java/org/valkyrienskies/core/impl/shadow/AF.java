/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.AD;
import org.valkyrienskies.core.impl.shadow.AM;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

public final class AF
extends an_0
implements Serializable {
    private static final long a = 2784465764798260919L;
    private AD b;
    private boolean c;

    public AF() {
        this.c = true;
        this.b = new AD();
    }

    private AF(AD aD) {
        this.c = false;
        this.b = aD;
    }

    private AF(AF aF) {
        AF.a(aF, this);
    }

    public final void a(double d2) {
        if (this.c) {
            ((an_0)this.b).a(d2);
        }
    }

    public final double c() {
        double d2 = Double.NaN;
        if (this.b.g_() > 3L) {
            double d3 = this.b.e / (double)(this.b.a - 1L);
            if (this.b.a <= 3L || d3 < 1.0E-19) {
                d2 = 0.0;
            } else {
                double d4 = this.b.a;
                d2 = (d4 * (d4 + 1.0) * ((an_0)this.b).c() - 3.0 * this.b.e * this.b.e * (d4 - 1.0)) / ((d4 - 1.0) * (d4 - 2.0) * (d4 - 3.0) * d3 * d3);
            }
        }
        return d2;
    }

    public final void b() {
        if (this.c) {
            ((an_0)this.b).b();
        }
    }

    public final long g_() {
        return this.b.g_();
    }

    public final double a(double[] dArray, int n2, int n3) {
        double d2 = Double.NaN;
        int n4 = n3;
        int n5 = n2;
        double[] dArray2 = dArray;
        if (ch_0.a(dArray, n5, n4, false) && n3 > 3) {
            AM aM = new AM();
            aM.b(dArray, n2, n3);
            double d3 = aM.a.b;
            double d4 = BY.a(((an_0)aM).c());
            double d5 = 0.0;
            for (int i2 = n2; i2 < n2 + n3; ++i2) {
                d5 += BY.a(dArray[i2] - d3, 4.0);
            }
            double d6 = n3;
            double d7 = d6 * (d6 + 1.0) / ((d6 - 1.0) * (d6 - 2.0) * (d6 - 3.0));
            double d8 = 3.0 * BY.a(d6 - 1.0, 2.0) / ((d6 - 2.0) * (d6 - 3.0));
            d2 = d7 * (d5 /= BY.a(d4, 4.0)) - d8;
        }
        return d2;
    }

    private AF f() {
        AF aF = new AF();
        AF.a(this, aF);
        return aF;
    }

    private static void a(AF aF, AF aF2) {
        ci_0.a(aF);
        ci_0.a(aF2);
        aF2.c(aF.e());
        aF2.b = aF.b.g();
        aF2.c = aF.c;
    }

    public final /* synthetic */ an_0 a() {
        return this.f();
    }

    public final /* synthetic */ AA d() {
        return this.f();
    }
}


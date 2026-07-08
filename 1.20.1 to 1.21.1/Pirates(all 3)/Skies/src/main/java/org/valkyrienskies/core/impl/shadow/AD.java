/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.AC;
import org.valkyrienskies.core.impl.shadow.AH;
import org.valkyrienskies.core.impl.shadow.AL;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

final class AD
extends AL
implements Serializable {
    private static final long h = 4763990447117157611L;
    private double i;

    AD() {
        this.i = Double.NaN;
    }

    private AD(AD aD) {
        AD.a(aD, this);
    }

    public final void a(double d2) {
        double d3;
        if (this.a < 1L) {
            this.i = 0.0;
            this.f = 0.0;
            this.e = 0.0;
            this.b = 0.0;
        }
        double d4 = this.f;
        double d5 = this.e;
        super.a(d2);
        double d6 = d3 = (double)this.a;
        this.i = this.i - 4.0 * this.d * d4 + 6.0 * this.g * d5 + (d6 * d6 - 3.0 * (d3 - 1.0)) * (this.g * this.g * (d3 - 1.0) * d3);
    }

    public final double c() {
        return this.i;
    }

    public final void b() {
        super.b();
        this.i = Double.NaN;
    }

    public final AD g() {
        AD aD = new AD();
        AD.a(this, aD);
        return aD;
    }

    private static void a(AD aD, AD aD2) {
        ci_0.a(aD);
        ci_0.a(aD2);
        AL.a(aD, aD2);
        aD2.i = aD.i;
    }

    public final /* synthetic */ AL h() {
        return this.g();
    }

    public final /* synthetic */ AH i() {
        return this.g();
    }

    public final /* synthetic */ AC f() {
        return this.g();
    }

    public final /* synthetic */ an_0 a() {
        return this.g();
    }

    public final /* synthetic */ AA d() {
        return this.g();
    }
}


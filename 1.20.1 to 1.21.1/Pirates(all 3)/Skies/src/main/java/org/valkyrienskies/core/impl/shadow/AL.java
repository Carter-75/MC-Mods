/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.AC;
import org.valkyrienskies.core.impl.shadow.AH;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

class AL
extends AH
implements Serializable {
    private static final long h = -7818711964045118679L;
    protected double f;
    protected double g;

    AL() {
        this.f = Double.NaN;
        this.g = Double.NaN;
    }

    AL(AL aL) {
        AL.a(aL, this);
    }

    public void a(double d2) {
        if (this.a < 1L) {
            AL aL = this;
            this.b = 0.0;
            aL.e = 0.0;
            aL.f = 0.0;
        }
        double d3 = this.e;
        super.a(d2);
        this.g = this.d * this.d;
        double d4 = this.a;
        this.f = this.f - 3.0 * this.d * d3 + (d4 - 1.0) * (d4 - 2.0) * this.g * this.c;
    }

    public double c() {
        return this.f;
    }

    public void b() {
        super.b();
        this.f = Double.NaN;
        this.g = Double.NaN;
    }

    public AL h() {
        AL aL = new AL();
        AL.a(this, aL);
        return aL;
    }

    public static void a(AL aL, AL aL2) {
        ci_0.a(aL);
        ci_0.a(aL2);
        AH.a(aL, aL2);
        aL2.f = aL.f;
        aL2.g = aL.g;
    }

    public /* synthetic */ AH i() {
        return this.h();
    }

    public /* synthetic */ AC f() {
        return this.h();
    }

    public /* synthetic */ an_0 a() {
        return this.h();
    }

    public /* synthetic */ AA d() {
        return this.h();
    }
}


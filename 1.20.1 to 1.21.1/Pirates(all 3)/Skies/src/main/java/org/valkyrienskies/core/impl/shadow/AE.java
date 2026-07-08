/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.AW;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.av_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class AE
extends an_0
implements Serializable {
    private static final long b = -8178734905303459453L;
    public av_0 a;

    public AE() {
        this.a = new AW();
    }

    private AE(AE aE) {
        AE.a(aE, this);
    }

    public AE(AW aW) {
        this.a = aW;
    }

    private AE f() {
        AE aE = new AE();
        AE.a(this, aE);
        return aE;
    }

    public final void a(double d2) {
        this.a.a(d2);
    }

    public final double c() {
        if (this.a.g_() > 0L) {
            return BY.i(this.a.c() / (double)this.a.g_());
        }
        return Double.NaN;
    }

    public final void b() {
        this.a.b();
    }

    public final double a(double[] dArray, int n2, int n3) {
        return BY.i(this.a.a(dArray, n2, n3) / (double)n3);
    }

    public final long g_() {
        return this.a.g_();
    }

    public final void a(av_0 av_02) {
        this.h();
        this.a = av_02;
    }

    private av_0 g() {
        return this.a;
    }

    public static void a(AE aE, AE aE2) {
        ci_0.a(aE);
        ci_0.a(aE2);
        aE2.c(aE.e());
        aE2.a = aE.a.a();
    }

    private void h() {
        if (this.g_() > 0L) {
            throw new oX(px_0.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, this.g_());
        }
    }

    public final /* synthetic */ an_0 a() {
        return this.f();
    }

    public final /* synthetic */ AA d() {
        return this.f();
    }
}


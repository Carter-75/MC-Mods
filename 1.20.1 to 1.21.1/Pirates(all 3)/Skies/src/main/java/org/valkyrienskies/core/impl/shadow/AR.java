/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

public final class AR
extends an_0
implements Serializable {
    private static final long a = -2941995784909003131L;
    private long b;
    private double c;

    public AR() {
        this.b = 0L;
        this.c = Double.NaN;
    }

    private AR(AR aR) {
        AR.a(aR, this);
    }

    public final void a(double d2) {
        if (d2 < this.c || Double.isNaN(this.c)) {
            this.c = d2;
        }
        ++this.b;
    }

    public final void b() {
        this.c = Double.NaN;
        this.b = 0L;
    }

    public final double c() {
        return this.c;
    }

    public final long g_() {
        return this.b;
    }

    public final double a(double[] dArray, int n2, int n3) {
        double d2 = Double.NaN;
        int n4 = n3;
        int n5 = n2;
        double[] dArray2 = dArray;
        if (ch_0.a(dArray, n5, n4, false)) {
            d2 = dArray[n2];
            for (int i2 = n2; i2 < n2 + n3; ++i2) {
                if (Double.isNaN(dArray[i2])) continue;
                d2 = d2 < dArray[i2] ? d2 : dArray[i2];
            }
        }
        return d2;
    }

    private AR f() {
        AR aR = new AR();
        AR.a(this, aR);
        return aR;
    }

    public static void a(AR aR, AR aR2) {
        ci_0.a(aR);
        ci_0.a(aR2);
        aR2.c(aR.e());
        aR2.b = aR.b;
        aR2.c = aR.c;
    }

    public final /* synthetic */ an_0 a() {
        return this.f();
    }

    public final /* synthetic */ AA d() {
        return this.f();
    }
}


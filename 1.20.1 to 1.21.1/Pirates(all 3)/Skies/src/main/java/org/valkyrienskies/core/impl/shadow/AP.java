/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

public final class AP
extends an_0
implements Serializable {
    private static final long a = -5593383832225844641L;
    private long b;
    private double c;

    public AP() {
        this.b = 0L;
        this.c = Double.NaN;
    }

    private AP(AP aP) {
        AP.a(aP, this);
    }

    public final void a(double d2) {
        if (d2 > this.c || Double.isNaN(this.c)) {
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
                d2 = d2 > dArray[i2] ? d2 : dArray[i2];
            }
        }
        return d2;
    }

    private AP f() {
        AP aP = new AP();
        AP.a(this, aP);
        return aP;
    }

    public static void a(AP aP, AP aP2) {
        ci_0.a(aP);
        ci_0.a(aP2);
        aP2.c(aP.e());
        aP2.b = aP.b;
        aP2.c = aP.c;
    }

    public final /* synthetic */ an_0 a() {
        return this.f();
    }

    public final /* synthetic */ AA d() {
        return this.f();
    }
}


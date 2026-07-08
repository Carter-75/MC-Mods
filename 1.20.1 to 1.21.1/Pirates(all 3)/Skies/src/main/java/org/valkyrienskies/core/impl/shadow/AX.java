/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

public final class AX
extends an_0
implements Serializable {
    private static final long a = 1460986908574398008L;
    private long b;
    private double c;

    public AX() {
        this.b = 0L;
        this.c = 0.0;
    }

    private AX(AX aX) {
        AX.a(aX, this);
    }

    public final void a(double d2) {
        double d3 = d2;
        this.c += d3 * d3;
        ++this.b;
    }

    public final double c() {
        return this.c;
    }

    public final long g_() {
        return this.b;
    }

    public final void b() {
        this.c = 0.0;
        this.b = 0L;
    }

    public final double a(double[] dArray, int n2, int n3) {
        double d2 = Double.NaN;
        boolean bl = true;
        int n4 = n3;
        int n5 = n2;
        double[] dArray2 = dArray;
        if (ch_0.a(dArray, n5, n4, true)) {
            d2 = 0.0;
            for (int i2 = n2; i2 < n2 + n3; ++i2) {
                d2 += dArray[i2] * dArray[i2];
            }
        }
        return d2;
    }

    private AX f() {
        AX aX = new AX();
        AX.a(this, aX);
        return aX;
    }

    public static void a(AX aX, AX aX2) {
        ci_0.a(aX);
        ci_0.a(aX2);
        aX2.c(aX.e());
        aX2.b = aX.b;
        aX2.c = aX.c;
    }

    public final /* synthetic */ an_0 a() {
        return this.f();
    }

    public final /* synthetic */ AA d() {
        return this.f();
    }
}


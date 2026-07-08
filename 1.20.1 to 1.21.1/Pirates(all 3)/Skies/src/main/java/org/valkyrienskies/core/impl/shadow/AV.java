/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

public final class AV
extends an_0
implements Serializable {
    private static final long a = -8231831954703408316L;
    private long b;
    private double c;

    public AV() {
        this.b = 0L;
        this.c = 0.0;
    }

    private AV(AV aV) {
        AV.a(aV, this);
    }

    public final void a(double d2) {
        this.c += d2;
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
                d2 += dArray[i2];
            }
        }
        return d2;
    }

    public final double b(double[] dArray, double[] dArray2, int n2, int n3) {
        double d2 = Double.NaN;
        if (AV.a(dArray, dArray2, n2, n3, true)) {
            d2 = 0.0;
            for (int i2 = n2; i2 < n2 + n3; ++i2) {
                d2 += dArray[i2] * dArray2[i2];
            }
        }
        return d2;
    }

    private double a(double[] dArray, double[] dArray2) {
        return this.b(dArray, dArray2, 0, dArray.length);
    }

    private AV f() {
        AV aV = new AV();
        AV.a(this, aV);
        return aV;
    }

    public static void a(AV aV, AV aV2) {
        ci_0.a(aV);
        ci_0.a(aV2);
        aV2.c(aV.e());
        aV2.b = aV.b;
        aV2.c = aV.c;
    }

    public final /* synthetic */ an_0 a() {
        return this.f();
    }

    public final /* synthetic */ AA d() {
        return this.f();
    }
}


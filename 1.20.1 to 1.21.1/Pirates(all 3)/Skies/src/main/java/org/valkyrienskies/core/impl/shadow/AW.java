/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

public final class AW
extends an_0
implements Serializable {
    private static final long a = -370076995648386763L;
    private int b;
    private double c;

    public AW() {
        this.c = 0.0;
        this.b = 0;
    }

    private AW(AW aW) {
        AW.a(aW, this);
    }

    public final void a(double d2) {
        this.c += BY.k(d2);
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
        this.b = 0;
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
                d2 += BY.k(dArray[i2]);
            }
        }
        return d2;
    }

    private AW f() {
        AW aW = new AW();
        AW.a(this, aW);
        return aW;
    }

    public static void a(AW aW, AW aW2) {
        ci_0.a(aW);
        ci_0.a(aW2);
        aW2.c(aW.e());
        aW2.b = aW.b;
        aW2.c = aW.c;
    }

    public final /* synthetic */ an_0 a() {
        return this.f();
    }

    public final /* synthetic */ AA d() {
        return this.f();
    }
}


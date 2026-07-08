/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.AB;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

public final class AU
extends an_0
implements Serializable,
AB {
    private static final long a = 2824226005990582538L;
    private long b;
    private double c;

    public AU() {
        this.b = 0L;
        this.c = 1.0;
    }

    private AU(AU aU) {
        AU.a(aU, this);
    }

    public final void a(double d2) {
        this.c *= d2;
        ++this.b;
    }

    public final double c() {
        return this.c;
    }

    public final long g_() {
        return this.b;
    }

    public final void b() {
        this.c = 1.0;
        this.b = 0L;
    }

    public final double a(double[] dArray, int n2, int n3) {
        double d2 = Double.NaN;
        boolean bl = true;
        int n4 = n3;
        int n5 = n2;
        double[] dArray2 = dArray;
        if (ch_0.a(dArray, n5, n4, true)) {
            d2 = 1.0;
            for (int i2 = n2; i2 < n2 + n3; ++i2) {
                d2 *= dArray[i2];
            }
        }
        return d2;
    }

    public final double a(double[] dArray, double[] dArray2, int n2, int n3) {
        double d2 = Double.NaN;
        if (AU.a(dArray, dArray2, n2, n3, true)) {
            d2 = 1.0;
            for (int i2 = n2; i2 < n2 + n3; ++i2) {
                d2 *= BY.a(dArray[i2], dArray2[i2]);
            }
        }
        return d2;
    }

    public final double a(double[] dArray, double[] dArray2) {
        return this.a(dArray, dArray2, 0, dArray.length);
    }

    private AU f() {
        AU aU = new AU();
        AU.a(this, aU);
        return aU;
    }

    private static void a(AU aU, AU aU2) {
        ci_0.a(aU);
        ci_0.a(aU2);
        aU2.c(aU.e());
        aU2.b = aU.b;
        aU2.c = aU.c;
    }

    public final /* synthetic */ an_0 a() {
        return this.f();
    }

    public final /* synthetic */ AA d() {
        return this.f();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.AG;
import org.valkyrienskies.core.impl.shadow.ao_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

public final class AI
extends ao_0
implements Serializable {
    private static a a;
    private static a b;
    private static final long c = -2653430366886024994L;
    private boolean d = true;
    private a e = org.valkyrienskies.core.impl.shadow.AI$a.DOWNSIDE;

    public AI() {
    }

    private AI(boolean bl) {
        this.d = bl;
    }

    private AI(a a2) {
        this.e = a2;
    }

    private AI(boolean bl, a a2) {
        this.d = bl;
        this.e = a2;
    }

    private AI(AI aI) {
        AI.a(aI, this);
    }

    private AI a() {
        AI aI = new AI();
        AI.a(this, aI);
        return aI;
    }

    private static void a(AI aI, AI aI2) {
        ci_0.a(aI);
        ci_0.a(aI2);
        aI2.c(aI.e());
        aI2.d = aI.d;
        aI2.e = aI.e;
    }

    public final double a(double[] dArray, int n2, int n3) {
        double d2 = ((ao_0)new AG()).a(dArray, n2, n3);
        return this.a(dArray, d2, this.e, this.d, 0, dArray.length);
    }

    private double a(double[] dArray, a a2) {
        double d2 = ((ao_0)new AG()).a(dArray);
        return this.a(dArray, d2, a2, this.d, 0, dArray.length);
    }

    private double a(double[] dArray, double d2) {
        return this.a(dArray, d2, this.e, this.d, 0, dArray.length);
    }

    private double a(double[] dArray, double d2, a a2) {
        return this.a(dArray, d2, a2, this.d, 0, dArray.length);
    }

    private double a(double[] dArray, double d2, a a2, boolean bl, int n2, int n3) {
        int n4 = n3;
        int n5 = 0;
        Object object = dArray;
        ch_0.a(dArray, n5, n4, false);
        if (dArray.length == 0) {
            return Double.NaN;
        }
        if (dArray.length == 1) {
            return 0.0;
        }
        a a3 = a2;
        object = (Object)a3;
        boolean bl2 = a3.direction;
        double d3 = 0.0;
        for (int i2 = 0; i2 < n3; ++i2) {
            double d4;
            if (dArray[i2] > d2 != bl2) continue;
            double d5 = d4 = dArray[i2] - d2;
            d3 += d5 * d5;
        }
        if (bl) {
            return d3 / ((double)n3 - 1.0);
        }
        return d3 / (double)n3;
    }

    private boolean b() {
        return this.d;
    }

    private void a(boolean bl) {
        this.d = bl;
    }

    private a c() {
        return this.e;
    }

    private void a(a a2) {
        this.e = a2;
    }

    public final /* synthetic */ AA d() {
        AI aI = this;
        AI aI2 = new AI();
        AI.a(aI, aI2);
        return aI2;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum a {
        UPSIDE(true),
        DOWNSIDE(false);

        boolean direction;

        private a(boolean bl) {
            this.direction = bl;
        }

        final boolean a() {
            return this.direction;
        }
    }
}


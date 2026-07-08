/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.AB;
import org.valkyrienskies.core.impl.shadow.AC;
import org.valkyrienskies.core.impl.shadow.AH;
import org.valkyrienskies.core.impl.shadow.AV;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.ao_0;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

public final class AG
extends an_0
implements Serializable,
AB {
    private static final long a = -1296043746617791564L;
    private AC b;
    private boolean c;

    public AG() {
        this.c = true;
        this.b = new AC();
    }

    public AG(AH aH) {
        this.b = aH;
        this.c = false;
    }

    private AG(AG aG) {
        AG.a(aG, this);
    }

    public final void a(double d2) {
        if (this.c) {
            ((an_0)this.b).a(d2);
        }
    }

    public final void b() {
        if (this.c) {
            ((an_0)this.b).b();
        }
    }

    public final double c() {
        return this.b.b;
    }

    public final long g_() {
        return this.b.g_();
    }

    public final double a(double[] dArray, int n2, int n3) {
        int n4 = n3;
        int n5 = n2;
        Object object = dArray;
        if (ch_0.a(dArray, n5, n4, false)) {
            object = new AV();
            double d2 = n3;
            double d3 = ((ao_0)object).a(dArray, n2, n3) / d2;
            double d4 = 0.0;
            for (int i2 = n2; i2 < n2 + n3; ++i2) {
                d4 += dArray[i2] - d3;
            }
            return d3 + d4 / d2;
        }
        return Double.NaN;
    }

    public final double a(double[] dArray, double[] dArray2, int n2, int n3) {
        if (AG.a_(dArray, dArray2, n2, n3)) {
            AV aV = new AV();
            double d2 = ((ao_0)aV).a(dArray2, n2, n3);
            double d3 = aV.b(dArray, dArray2, n2, n3) / d2;
            double d4 = 0.0;
            for (int i2 = n2; i2 < n2 + n3; ++i2) {
                d4 += dArray2[i2] * (dArray[i2] - d3);
            }
            return d3 + d4 / d2;
        }
        return Double.NaN;
    }

    public final double a(double[] dArray, double[] dArray2) {
        return this.a(dArray, dArray2, 0, dArray.length);
    }

    private AG f() {
        AG aG = new AG();
        AG.a(this, aG);
        return aG;
    }

    public static void a(AG aG, AG aG2) {
        ci_0.a(aG);
        ci_0.a(aG2);
        aG2.c(aG.e());
        aG2.c = aG.c;
        aG2.b = aG.b.f();
    }

    public final /* synthetic */ an_0 a() {
        return this.f();
    }

    public final /* synthetic */ AA d() {
        return this.f();
    }
}


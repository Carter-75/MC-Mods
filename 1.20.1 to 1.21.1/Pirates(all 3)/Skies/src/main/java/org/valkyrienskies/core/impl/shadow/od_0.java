/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oC;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.od
 */
public abstract class od_0
implements oC {
    protected final zF a;
    private final int b;

    protected od_0(zF zF2, int n2) {
        this.a = zF2;
        this.b = n2;
    }

    public void a(long l2) {
        this.a.setSeed(l2);
    }

    public final int a() {
        return this.b;
    }

    public abstract double[] b();

    public final double[][] a(int n2) {
        if (n2 <= 0) {
            throw new pk_0(px_0.NUMBER_OF_SAMPLES, n2);
        }
        double[][] dArray = new double[n2][this.b];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = this.b();
        }
        return dArray;
    }
}


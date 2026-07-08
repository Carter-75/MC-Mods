/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.uM;
import org.valkyrienskies.core.impl.shadow.vb_0;

public final class uL
implements uM {
    private final vb_0 a;
    private final int b;
    private final double[] c;
    private final double[] d;
    private final double[] e;

    private uL(vb_0 vb_02) {
        this.a = vb_02;
        this.b = vb_02.a();
        this.c = new double[this.b];
        this.d = new double[this.b];
        this.e = new double[this.b];
    }

    public final int a() {
        return 2 * this.b;
    }

    public final void a(double d2, double[] dArray, double[] dArray2) {
        System.arraycopy(dArray, 0, this.c, 0, this.b);
        System.arraycopy(dArray, this.b, this.d, 0, this.b);
        System.arraycopy(this.d, 0, dArray2, 0, this.b);
        System.arraycopy(this.e, 0, dArray2, this.b, this.b);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.oS;

public final class uE
implements Serializable {
    private static final long c = 20110925L;
    final int a;
    public final int b;

    public uE(int n2, int n3) {
        this.a = n2;
        this.b = n3;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final void a(double[] dArray, double[] dArray2) {
        if (dArray2.length != this.b) {
            throw new oS(dArray2.length, this.b);
        }
        System.arraycopy(dArray, this.a, dArray2, 0, this.b);
    }

    public final void b(double[] dArray, double[] dArray2) {
        if (dArray.length != this.b) {
            throw new oS(dArray.length, this.b);
        }
        System.arraycopy(dArray, 0, dArray2, this.a, this.b);
    }
}


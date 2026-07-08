/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.xd_0;

public final class wW
implements Serializable {
    private static final long d = -764632794033034092L;
    final transient tu_0 a;
    final xd_0 b;
    final double c;

    private wW(double[] dArray, xd_0 xd_02, double d2) {
        this((tu_0)((Object)new sA(dArray)), xd_02, d2);
    }

    public wW(tu_0 tu_02, xd_0 xd_02, double d2) {
        this.a = tu_02;
        this.b = xd_02;
        this.c = d2;
    }

    private wW(double[] dArray, double d2, xd_0 xd_02, double[] dArray2, double d3) {
        double[] dArray3 = new double[dArray.length];
        for (int i2 = 0; i2 < dArray3.length; ++i2) {
            dArray3[i2] = dArray[i2] - dArray2[i2];
        }
        this.a = new sA(dArray3, false);
        this.b = xd_02;
        this.c = d3 - d2;
    }

    private wW(tu_0 tu_02, double d2, xd_0 xd_02, tu_0 tu_03, double d3) {
        this.a = tu_02.k(tu_03);
        this.b = xd_02;
        this.c = d3 - d2;
    }

    public final tu_0 a() {
        return this.a;
    }

    public final xd_0 b() {
        return this.b;
    }

    public final double c() {
        return this.c;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof wW) {
            wW wW2;
            wW2 = wW2;
            return this.b == wW2.b && this.c == wW2.c && this.a.equals(wW2.a);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() ^ Double.valueOf(this.c).hashCode() ^ this.a.hashCode();
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        td_0.a(this.a, objectOutputStream);
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        td_0.a(this, "coefficients", objectInputStream);
    }
}


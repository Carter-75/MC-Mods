/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.wO;

public final class wY
implements Serializable,
kW,
wO {
    private static final long c = -4531815507568396090L;
    final transient tu_0 a;
    final double b;

    private wY(double[] dArray, double d2) {
        this(new sA(dArray), d2);
    }

    private wY(sA sA2, double d2) {
        this.a = sA2;
        this.b = d2;
    }

    public final tu_0 a() {
        return this.a;
    }

    public final double b() {
        return this.b;
    }

    public final double a(double[] object) {
        wY wY2 = this;
        sA sA2 = new sA((double[])object, false);
        object = wY2;
        return wY2.a.b((tu_0)((Object)sA2)) + object.b;
    }

    private double a(sA sA2) {
        return this.a.b((tu_0)((Object)sA2)) + this.b;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof wY) {
            wY wY2;
            wY2 = wY2;
            return this.b == wY2.b && this.a.equals(wY2.a);
        }
        return false;
    }

    public final int hashCode() {
        return Double.valueOf(this.b).hashCode() ^ this.a.hashCode();
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


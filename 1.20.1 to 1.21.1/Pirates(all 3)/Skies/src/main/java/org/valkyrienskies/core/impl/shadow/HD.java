/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.hm_0;

public final class HD
implements hm_0 {
    private double a;
    private double b;
    private int c;

    public HD(double d2, double d3, int n2) {
        this.a = d2;
        this.b = d3;
        this.c = n2;
    }

    @Override
    public final double a() {
        return this.a;
    }

    @Override
    public final void a(double d2) {
        this.a = d2;
    }

    @Override
    public final double k_() {
        return this.b;
    }

    @Override
    public final void b(double d2) {
        this.b = d2;
    }

    @Override
    public final int c() {
        return this.c;
    }

    @Override
    public final void a(int n2) {
        this.c = n2;
    }

    @Override
    public final void close() {
    }

    private double d() {
        HD hD = this;
        return hD.a;
    }

    private double e() {
        HD hD = this;
        return hD.b;
    }

    private int f() {
        HD hD = this;
        return hD.c;
    }

    private static HD a(double d2, double d3, int n2) {
        return new HD(d2, d3, n2);
    }

    private static /* synthetic */ HD a(HD hD, double d2, double d3, int n2, int n3) {
        HD hD2;
        if ((n3 & 1) != 0) {
            hD2 = hD;
            d2 = hD2.a;
        }
        if ((n3 & 2) != 0) {
            hD2 = hD;
            d3 = hD2.b;
        }
        if ((n3 & 4) != 0) {
            hD2 = hD;
            n2 = hD2.c;
        }
        int n4 = n2;
        double d4 = d3;
        double d5 = d2;
        return new HD(d5, d4, n4);
    }

    public final String toString() {
        HD hD = this;
        HD hD2 = hD;
        HD hD3 = this;
        hD2 = hD3;
        hD2 = this;
        return "DummyWheelShapeReference(wheelRadius=" + hD.a + ", halfThickness=" + hD3.b + ", pointShellSize=" + hD2.c + ')';
    }

    public final int hashCode() {
        HD hD = this;
        int n2 = Double.hashCode(hD.a);
        HD hD2 = this;
        int n3 = n2 * 31 + Double.hashCode(hD2.b);
        HD hD3 = this;
        int n4 = n3 * 31 + Integer.hashCode(hD3.c);
        return n4;
    }

    public final boolean equals(Object other) {
        HD hD;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HD)) {
            return false;
        }
        hD = hD;
        HD hD2 = this;
        HD hD3 = hD2;
        hD3 = hD;
        if (!Intrinsics.areEqual((Object)hD2.a, (Object)hD3.a)) {
            return false;
        }
        HD hD4 = this;
        hD3 = hD4;
        hD3 = hD;
        if (!Intrinsics.areEqual((Object)hD4.b, (Object)hD3.b)) {
            return false;
        }
        HD hD5 = this;
        hD3 = hD5;
        hD3 = hD;
        return hD5.c == hD3.c;
    }
}


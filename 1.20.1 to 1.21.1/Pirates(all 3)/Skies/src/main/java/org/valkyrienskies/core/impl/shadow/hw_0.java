/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.hg_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Hw
 */
public final class hw_0
implements hg_0 {
    private double a;

    public hw_0(double d2) {
        this.a = d2;
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
    public final void close() {
    }

    private double b() {
        hw_0 hw_02 = this;
        return hw_02.a;
    }

    private static hw_0 b(double d2) {
        return new hw_0(d2);
    }

    private static /* synthetic */ hw_0 a(hw_0 hw_02, double d2, int n2) {
        if ((n2 & 1) != 0) {
            d2 = hw_02.a;
        }
        double d3 = d2;
        return new hw_0(d3);
    }

    public final String toString() {
        hw_0 hw_02 = this;
        return "DummySphereShapeReference(radius=" + hw_02.a + ')';
    }

    public final int hashCode() {
        hw_0 hw_02 = this;
        return Double.hashCode(hw_02.a);
    }

    public final boolean equals(Object other) {
        hw_0 hw_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof hw_0)) {
            return false;
        }
        hw_02 = hw_02;
        hw_0 hw_03 = this;
        hw_0 hw_04 = hw_03;
        hw_04 = hw_02;
        return Intrinsics.areEqual((Object)hw_03.a, (Object)hw_04.a);
    }
}


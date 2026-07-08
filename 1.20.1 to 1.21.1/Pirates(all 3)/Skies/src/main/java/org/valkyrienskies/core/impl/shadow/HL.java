/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;

public final class HL {
    public final float a;
    public final float b;

    public HL(float f2, float f3) {
        this.a = f2;
        this.b = f3;
    }

    public final float a() {
        return this.a;
    }

    public final float b() {
        return this.b;
    }

    private float c() {
        return this.a;
    }

    private float d() {
        return this.b;
    }

    private static HL a(float f2, float f3) {
        return new HL(f2, f3);
    }

    private static /* synthetic */ HL a(HL hL, float f2, float f3, int n2) {
        if ((n2 & 1) != 0) {
            f2 = hL.a;
        }
        if ((n2 & 2) != 0) {
            f3 = hL.b;
        }
        float f4 = f2;
        f2 = f3;
        float f5 = f4;
        return new HL(f5, f2);
    }

    public final String toString() {
        return "MaxForceTorque(maxForce=" + this.a + ", maxTorque=" + this.b + ')';
    }

    public final int hashCode() {
        int n2 = Float.hashCode(this.a);
        n2 = n2 * 31 + Float.hashCode(this.b);
        return n2;
    }

    public final boolean equals(Object other) {
        HL hL;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HL)) {
            return false;
        }
        hL = hL;
        if (!Intrinsics.areEqual((Object)Float.valueOf(this.a), (Object)Float.valueOf(hL.a))) {
            return false;
        }
        return Intrinsics.areEqual((Object)Float.valueOf(this.b), (Object)Float.valueOf(hL.b));
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Bl
 */
public final class bl_0 {
    private double a;
    private double b;
    private double c;

    public bl_0(double d2, double d3, double d4) {
        double d5;
        double d6 = d4;
        double d7 = d3;
        double d8 = d2;
        if (d5 >= d7) {
            throw new oV(px_0.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, d8, d7);
        }
        if (d6 <= 0.0 || d6 >= 1.0) {
            throw new oV(px_0.OUT_OF_BOUNDS_CONFIDENCE_LEVEL, d6, 0, 1);
        }
        this.a = d2;
        this.b = d3;
        this.c = d4;
    }

    private double a() {
        return this.a;
    }

    private double b() {
        return this.b;
    }

    private double c() {
        return this.c;
    }

    public final String toString() {
        return "[" + this.a + ";" + this.b + "] (confidence level:" + this.c + ")";
    }

    private static void a(double d2, double d3, double d4) {
        if (d2 >= d3) {
            throw new oV(px_0.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, d2, d3);
        }
        if (d4 <= 0.0 || d4 >= 1.0) {
            throw new oV(px_0.OUT_OF_BOUNDS_CONFIDENCE_LEVEL, d4, 0, 1);
        }
    }
}


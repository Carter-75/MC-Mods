/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.wO;

public final class wS
implements wO {
    private final double[] a;
    private final double[] b;

    private wS(double[] dArray, double[] dArray2) {
        this.a = (double[])dArray.clone();
        this.b = (double[])dArray2.clone();
    }

    public final double[] a() {
        return (double[])this.a.clone();
    }

    public final double[] b() {
        return (double[])this.b.clone();
    }

    private static wS a(int n2) {
        double[] dArray = new double[n2];
        Arrays.fill(dArray, Double.NEGATIVE_INFINITY);
        double[] dArray2 = new double[n2];
        Arrays.fill(dArray2, Double.POSITIVE_INFINITY);
        return new wS(dArray, dArray2);
    }
}


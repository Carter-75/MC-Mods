/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.yo_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.yr
 */
@Deprecated
public final class yr_0
implements yo_0 {
    private final double[] a;
    private final double[] b;

    public yr_0(double[] dArray, double[] dArray2) {
        this.a = (double[])dArray.clone();
        this.b = (double[])dArray2.clone();
    }

    public final double[] a() {
        return (double[])this.a.clone();
    }

    public final double[] b() {
        return (double[])this.b.clone();
    }
}


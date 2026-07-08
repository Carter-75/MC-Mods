/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ni_0;
import org.valkyrienskies.core.impl.shadow.yJ;
import org.valkyrienskies.core.impl.shadow.ye_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class yM
extends yJ<ni_0.a> {
    @Deprecated
    private final int b;

    @Deprecated
    private yM(int n2, ye_0 ye_02) {
        super(ye_02);
        this.b = n2;
    }

    private yM(ye_0 ye_02) {
        super(ye_02);
        this.b = -1;
    }

    @Deprecated
    private double[] b() {
        return this.a(new ni_0.a(), new double[this.b + 1]);
    }

    @Override
    private double[] a(int n2, double[] dArray) {
        return this.a(n2, new ni_0.a(), dArray);
    }

    private double[] a(double[] dArray) {
        return this.a(new ni_0.a(), dArray);
    }
}


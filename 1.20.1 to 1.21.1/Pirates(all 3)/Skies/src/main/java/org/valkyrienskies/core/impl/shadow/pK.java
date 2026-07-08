/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ni_0;
import org.valkyrienskies.core.impl.shadow.pE;
import org.valkyrienskies.core.impl.shadow.xJ;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class pK
extends pE<ni_0.a> {
    public pK(xJ xJ2) {
        super(xJ2);
    }

    @Override
    private double[] a(int n2, double[] dArray) {
        return this.a(n2, new ni_0.a(), dArray);
    }

    public final double[] a(double[] dArray) {
        return this.a(new ni_0.a(), dArray);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.wO;

@Deprecated
public final class xG
implements wO {
    private final double[] a;

    public xG(double[] dArray) {
        this.a = (double[])dArray.clone();
    }

    public final double[] a() {
        return (double[])this.a.clone();
    }
}


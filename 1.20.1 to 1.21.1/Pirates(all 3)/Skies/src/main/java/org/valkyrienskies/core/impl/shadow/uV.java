/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;

final class uV
implements Serializable {
    private static final long c = 2247518849090889379L;
    String a;
    double b;

    uV(String string, double d2) {
        this.a = string;
        this.b = Double.NaN;
    }

    public final String a() {
        return this.a;
    }

    public final double b() {
        return this.b;
    }

    public final void a(double d2) {
        this.b = d2;
    }
}


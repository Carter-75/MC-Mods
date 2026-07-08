/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.ya_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public abstract class xT<PAIR>
implements ya_0<PAIR> {
    @Deprecated
    private static final double a = 100.0 * cq_0.a;
    @Deprecated
    private static final double b = 100.0 * cq_0.b;
    private final double c;
    private final double d;

    @Deprecated
    public xT() {
        this.c = a;
        this.d = b;
    }

    public xT(double d2, double d3) {
        this.c = d2;
        this.d = d3;
    }

    public final double a() {
        return this.c;
    }

    public final double b() {
        return this.d;
    }

    @Override
    public abstract boolean a(int var1, PAIR var2, PAIR var3);
}


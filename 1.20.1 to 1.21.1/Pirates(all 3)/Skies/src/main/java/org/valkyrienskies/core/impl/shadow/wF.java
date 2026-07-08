/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.wK;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class wF<PAIR>
implements wK<PAIR> {
    private final double a;
    private final double b;

    public wF(double d2, double d3) {
        this.a = d2;
        this.b = d3;
    }

    public final double a() {
        return this.a;
    }

    public final double b() {
        return this.b;
    }

    @Override
    public abstract boolean a(int var1, PAIR var2, PAIR var3);
}


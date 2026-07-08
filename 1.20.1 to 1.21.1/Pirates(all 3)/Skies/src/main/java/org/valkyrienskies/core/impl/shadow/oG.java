/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BR;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oc_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;
import org.valkyrienskies.core.impl.shadow.zW;

public final class oG
extends oc_0 {
    private static final long b = 6751309484392813623L;
    private final int c;
    private final double d;
    private final double e;
    private final double f;

    private oG(int n2, double d2) {
        this(new zR(), n2, d2);
    }

    public oG(zF zF2, int n2, double d2) {
        super(zF2);
        if (n2 <= 0) {
            throw new pk_0(px_0.NUMBER_OF_SUCCESSES, n2);
        }
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        this.c = n2;
        this.d = d2;
        this.e = BY.k(d2);
        this.f = BY.l(-d2);
    }

    private int g() {
        return this.c;
    }

    private double h() {
        return this.d;
    }

    public final double c(int n2) {
        double d2 = n2 < 0 ? 0.0 : BR.b(n2 + this.c - 1, this.c - 1) * BY.a(this.d, this.c) * BY.a(1.0 - this.d, n2);
        return d2;
    }

    public final double b(int n2) {
        double d2 = n2 < 0 ? Double.NEGATIVE_INFINITY : BR.c(n2 + this.c - 1, this.c - 1) + this.e * (double)this.c + this.f * (double)n2;
        return d2;
    }

    public final double d(int n2) {
        double d2 = n2 < 0 ? 0.0 : zW.a(this.d, this.c, (double)n2 + 1.0);
        return d2;
    }

    public final double b() {
        oG oG2 = this;
        double d2 = oG2.d;
        oG2 = this;
        double d3 = oG2.c;
        return d3 * (1.0 - d2) / d2;
    }

    public final double c() {
        oG oG2 = this;
        double d2 = oG2.d;
        oG2 = this;
        double d3 = oG2.c;
        double d4 = d2;
        return d3 * (1.0 - d2) / (d4 * d4);
    }

    public final int d() {
        return 0;
    }

    public final int e() {
        return Integer.MAX_VALUE;
    }

    public final boolean f() {
        return true;
    }
}


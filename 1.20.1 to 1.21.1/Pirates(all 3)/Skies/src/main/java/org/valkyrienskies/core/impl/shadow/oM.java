/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oc_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;

public final class oM
extends oc_0 {
    private static final long b = 20120109L;
    private final int c;
    private final int d;

    private oM(int n2, int n3) {
        this(new zR(), n2, n3);
    }

    public oM(zF zF2, int n2, int n3) {
        super(zF2);
        if (n2 > n3) {
            throw new pm_0(px_0.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, (Number)n2, n3, true);
        }
        this.c = n2;
        this.d = n3;
    }

    public final double c(int n2) {
        if (n2 < this.c || n2 > this.d) {
            return 0.0;
        }
        return 1.0 / (double)(this.d - this.c + 1);
    }

    public final double d(int n2) {
        if (n2 < this.c) {
            return 0.0;
        }
        if (n2 > this.d) {
            return 1.0;
        }
        return ((double)(n2 - this.c) + 1.0) / ((double)(this.d - this.c) + 1.0);
    }

    public final double b() {
        return 0.5 * (double)(this.c + this.d);
    }

    public final double c() {
        double d2 = this.d - this.c + 1;
        return (d2 * d2 - 1.0) / 12.0;
    }

    public final int d() {
        return this.c;
    }

    public final int e() {
        return this.d;
    }

    public final boolean f() {
        return true;
    }

    public final int a() {
        int n2 = this.d - this.c + 1;
        if (n2 <= 0) {
            while ((n2 = this.a.nextInt()) < this.c || n2 > this.d) {
            }
            return n2;
        }
        return this.c + this.a.nextInt(n2);
    }
}


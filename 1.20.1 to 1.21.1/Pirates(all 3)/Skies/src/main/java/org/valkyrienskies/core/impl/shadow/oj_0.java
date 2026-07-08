/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.po_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.oj
 */
public final class oj_0
extends oe_0 {
    private static final long b = -4157745166772046273L;
    private final double c;

    public oj_0(double d2) {
        super(null);
        this.c = d2;
    }

    public final double d(double d2) {
        if (d2 == this.c) {
            return 1.0;
        }
        return 0.0;
    }

    public final double e(double d2) {
        if (d2 < this.c) {
            return 0.0;
        }
        return 1.0;
    }

    public final double a(double d2) {
        if (d2 < 0.0 || d2 > 1.0) {
            throw new po_0(d2, (Number)0, 1);
        }
        return this.c;
    }

    public final double c() {
        return this.c;
    }

    public final double d() {
        return 0.0;
    }

    public final double e() {
        return this.c;
    }

    public final double f() {
        return this.c;
    }

    public final boolean g() {
        return true;
    }

    public final boolean h() {
        return true;
    }

    public final boolean i() {
        return true;
    }

    public final double b() {
        return this.c;
    }

    public final void a(long l2) {
    }
}


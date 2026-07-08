/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.sj_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.si
 */
public final class si_0
implements qM<sj_0> {
    public static final si_0 a = new si_0(Double.NaN, rB.b);
    private static final long c = 20131218L;
    public final double b;
    private final rB d;

    public si_0(double d2) {
        this(ci_0.b(d2, Math.PI), new rB(BY.o(d2), BY.n(d2)));
    }

    private si_0(double d2, rB rB2) {
        this.b = d2;
        this.d = rB2;
    }

    public final double c() {
        return this.b;
    }

    private rB d() {
        return this.d;
    }

    @Override
    public final qN a() {
        return sj_0.a.a();
    }

    @Override
    public final boolean b() {
        return Double.isNaN(this.b);
    }

    @Override
    public final double a(qM<sj_0> si_02) {
        si_0 si_03 = si_02;
        si_02 = this;
        return rB.a(si_02.d, si_03.d);
    }

    private static double a(si_0 si_02, si_0 si_03) {
        return rB.a(si_02.d, si_03.d);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof si_0) {
            si_0 si_02;
            si_0 si_03 = si_02 = (si_0)si_02;
            if (Double.isNaN(si_02.b)) {
                si_03 = this;
                return Double.isNaN(si_03.b);
            }
            return this.b == si_02.b;
        }
        return false;
    }

    public final int hashCode() {
        si_0 si_02 = this;
        if (Double.isNaN(si_02.b)) {
            return 542;
        }
        return 1759 * ci_0.a(this.b);
    }
}


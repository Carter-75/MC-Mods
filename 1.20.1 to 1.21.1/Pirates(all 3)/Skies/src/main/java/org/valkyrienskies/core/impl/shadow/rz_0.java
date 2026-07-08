/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.rv_0;
import org.valkyrienskies.core.impl.shadow.rw_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.rz
 */
public class rz_0 {
    final rB g;
    final rB h;
    public final rw_0 i;

    public rz_0(rB rB2, rB rB3, rw_0 rw_02) {
        this.g = rB2;
        this.h = rB3;
        this.i = rw_02;
    }

    public final rB g() {
        return this.g;
    }

    public final rB h() {
        return this.h;
    }

    public final rw_0 i() {
        return this.i;
    }

    private double a(rB rB2) {
        rB rB3;
        rB rB4;
        rB rB5;
        rB rB6 = this.h;
        Object object = rB6;
        object = this.g;
        double d2 = rB6.c - ((rB)object).c;
        rB rB7 = this.h;
        object = rB7;
        object = this.g;
        double d3 = rB7.d - ((rB)object).d;
        object = rB2;
        object = this.g;
        object = rB2;
        object = this.g;
        double d4 = d2;
        double d5 = d3;
        double d6 = ((rB5.c - rB4.c) * d2 + (rB3.d - ((rB)object).d) * d3) / (d4 * d4 + d5 * d5);
        if (d6 < 0.0 || d6 > 1.0) {
            object = this;
            double d7 = ((rz_0)object).g.a((qM<rv_0>)rB2);
            object = this;
            double d8 = ((rz_0)object).h.a((qM<rv_0>)rB2);
            return BY.d(d7, d8);
        }
        object = this.g;
        double d9 = ((rB)object).c + d6 * d2;
        object = this.g;
        double d10 = ((rB)object).d + d6 * d3;
        rB rB8 = new rB(d9, d10);
        return rB8.a((qM<rv_0>)rB2);
    }
}


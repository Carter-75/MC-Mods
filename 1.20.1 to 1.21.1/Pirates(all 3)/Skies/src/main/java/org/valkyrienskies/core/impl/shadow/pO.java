/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.pW;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sG;
import org.valkyrienskies.core.impl.shadow.tn_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

public abstract class pO
implements pW.a {
    private final int a;

    pO(int n2) {
        this.a = n2;
    }

    public final tq_0 a(double d2) {
        tq_0 tq_02 = this.c();
        tq_02 = tq_02.d().c(tq_02);
        sG sG2 = new tn_0(tq_02, d2).c();
        return sG2.b();
    }

    public final tu_0 b(double d2) {
        tq_0 tq_02 = this.a(d2);
        int n2 = tq_02.g();
        sA sA2 = new sA(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = i2;
            ((tu_0)((Object)sA2)).a(i2, BY.a(tq_02.b(n3, n3)));
        }
        return sA2;
    }

    public final double a() {
        double d2 = this.b();
        return BY.a(d2 * d2 / (double)this.a);
    }

    public final double b() {
        sA sA2 = new sA(this.d());
        return BY.a(((tu_0)((Object)sA2)).b((tu_0)((Object)sA2)));
    }
}


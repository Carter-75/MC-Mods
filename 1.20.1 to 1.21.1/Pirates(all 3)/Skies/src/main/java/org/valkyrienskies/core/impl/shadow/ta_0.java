/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.mg_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.ti_0;
import org.valkyrienskies.core.impl.shadow.tp_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ta
 */
public final class ta_0
extends tp_0 {
    private final sA a;

    private ta_0(double[] dArray, boolean bl) {
        this.a = new sA(dArray, false);
    }

    private static ta_0 a(tp_0 tp_02) {
        int n2 = tp_02.g();
        if (tp_02.f() != n2) {
            throw new ti_0(tp_02.f(), n2);
        }
        double[] dArray = new double[n2];
        if (tp_02 instanceof sv_0) {
            sv_0 sv_02 = (sv_0)tp_02;
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3 = i2;
                dArray[i2] = sv_02.b(n3, n3);
            }
        } else {
            sA sA2 = new sA(n2);
            for (int i3 = 0; i3 < n2; ++i3) {
                ((tu_0)((Object)sA2)).f(0.0);
                ((tu_0)((Object)sA2)).a(i3, 1.0);
                dArray[i3] = ((tu_0)((Object)tp_02.a((tu_0)((Object)sA2)))).a(i3);
            }
        }
        return new ta_0(dArray, false);
    }

    public final int g() {
        sA sA2 = this.a;
        return sA2.a.length;
    }

    public final int f() {
        sA sA2 = this.a;
        return sA2.a.length;
    }

    public final sA a(tu_0 tu_02) {
        return new sA(ch_0.b(tu_02.g(), ((tu_0)((Object)this.a)).g()), false);
    }

    private 1 a() {
        sA sA2 = this.a.a(new mg_0());
        return new tp_0(this, sA2){
            private /* synthetic */ tu_0 a;
            private /* synthetic */ ta_0 b;
            {
                this.b = ta_02;
                this.a = sA2;
            }

            public final sA a(tu_0 tu_02) {
                return new sA(ch_0.b(tu_02.g(), this.a.g()), false);
            }

            public final int f() {
                return this.a.f();
            }

            public final int g() {
                return this.a.f();
            }
        };
    }
}


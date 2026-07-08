/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.lE;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.oI;
import org.valkyrienskies.core.impl.shadow.oN;
import org.valkyrienskies.core.impl.shadow.ua_0;
import org.valkyrienskies.core.impl.shadow.zF;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ub
 */
public final class ub_0 {
    private ub_0() {
    }

    private static ua_0 a(zF zF2, double d2, double d3) {
        return ub_0.a(new oN(zF2, d2, d3), ub_0.a(new lE(0.0), 0.0, 0.0));
    }

    private static ua_0 a(double d2, double d3) {
        return ub_0.a(new oN(d2, d3), ub_0.a(new lE(0.0), 0.0, 0.0));
    }

    private static 1 a(lE lE2, double d2, double d3) {
        return new ua_0(0.0, lE2, 0.0){
            private double a;
            private /* synthetic */ double b;
            private /* synthetic */ lc_0 c;
            private /* synthetic */ double d;
            {
                this.b = d2;
                this.c = lc_02;
                this.d = d3;
                this.a = this.b;
            }

            public final double a() {
                double d2 = this.c.a(this.a);
                this.a += this.d;
                return d2;
            }
        };
    }

    private static 2 a(oN oN2, ua_0 ua_02) {
        return new ua_0(ua_02, oN2){
            private /* synthetic */ ua_0 a;
            private /* synthetic */ oI b;
            {
                this.a = ua_02;
                this.b = oI2;
            }

            public final double a() {
                return this.a.a() + this.b.b();
            }
        };
    }
}


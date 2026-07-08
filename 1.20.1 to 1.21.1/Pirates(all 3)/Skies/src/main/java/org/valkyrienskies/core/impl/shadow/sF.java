/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cc_0;
import org.valkyrienskies.core.impl.shadow.cf_0;
import org.valkyrienskies.core.impl.shadow.pu_0;
import org.valkyrienskies.core.impl.shadow.sJ;
import org.valkyrienskies.core.impl.shadow.tf_0;
import org.valkyrienskies.core.impl.shadow.tm_0;
import org.valkyrienskies.core.impl.shadow.tp_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

public final class sF
extends tm_0 {
    private static String a = "operator";
    private static String b = "vector";
    private boolean c;
    private final double d;

    private sF(int n2, double d2, boolean bl) {
        super(n2);
        this.d = d2;
        this.c = bl;
    }

    private sF(cf_0 cf_02, double d2, boolean bl) {
        super(cf_02);
        this.d = d2;
        this.c = bl;
    }

    private boolean b() {
        return this.c;
    }

    public final tu_0 a(tp_0 tp_02, tp_0 tp_03, tu_0 tu_02, tu_0 tu_03) {
        sF.c(tp_02, tp_03, tu_02, tu_03);
        cf_0 cf_02 = this.a();
        cf_02.c();
        double d2 = this.d * tu_02.c();
        tu_0.2 var8_7 = tu_0.n(tu_02);
        Object object = cf_02;
        object = ((cf_0)object).a;
        ((cc_0.a)object).d(1);
        tu_0.2 var9_9 = tu_0.n(tu_03);
        tu_0 tu_04 = tu_03.j();
        object = tp_02.a(tu_04);
        tu_02 = tu_02.b(1.0, -1.0, (tu_0)object);
        tu_0.2 var12_11 = tu_0.n(tu_02);
        double d3 = tu_02.c();
        Object object2 = tp_03 == null ? tu_02 : null;
        object = cf_02;
        object = ((cf_0)object).a;
        object = new sJ(this, ((cc_0.a)object).e, (tu_0)((Object)var9_9), (tu_0)((Object)var8_7), (tu_0)((Object)var12_11), d3);
        cf_02.a((sJ)object);
        if (d3 <= d2) {
            cf_02.d((sJ)object);
            return tu_03;
        }
        double d4 = 0.0;
        do {
            object = cf_02;
            object = ((cf_0)object).a;
            ((cc_0.a)object).d(1);
            object = cf_02;
            object = ((cf_0)object).a;
            object = new sJ(this, ((cc_0.a)object).e, (tu_0)((Object)var9_9), (tu_0)((Object)var8_7), (tu_0)((Object)var12_11), d3);
            cf_02.c((sJ)object);
            if (tp_03 != null) {
                object2 = tp_03.a(tu_02);
            }
            double d5 = tu_02.b((tu_0)object2);
            if (this.c && d5 <= 0.0) {
                tf_0 tf_02 = new tf_0();
                object = tf_02;
                pu_0 pu_02 = tf_02.a;
                pu_02.a("operator", (Object)tp_03);
                pu_02.a("vector", (Object)tu_02);
                throw tf_02;
            }
            object = cf_02;
            object = ((cf_0)object).a;
            if (((cc_0.a)object).e == 2) {
                tu_04.a(0, (tu_0)object2);
            } else {
                tu_04.a(d5 / d4, 1.0, (tu_0)object2);
            }
            object = tp_02.a(tu_04);
            double d6 = tu_04.b((tu_0)object);
            if (this.c && d6 <= 0.0) {
                tf_0 tf_03 = new tf_0();
                object = tf_03;
                pu_0 pu_03 = tf_03.a;
                pu_03.a("operator", (Object)tp_02);
                pu_03.a("vector", (Object)tu_04);
                throw tf_03;
            }
            double d7 = d5 / d6;
            tu_03.a(1.0, d7, tu_04);
            tu_02.a(1.0, -d7, (tu_0)object);
            d4 = d5;
            d3 = tu_02.c();
            object = cf_02;
            object = ((cf_0)object).a;
            object = new sJ(this, ((cc_0.a)object).e, (tu_0)((Object)var9_9), (tu_0)((Object)var8_7), (tu_0)((Object)var12_11), d3);
            cf_02.b((sJ)object);
        } while (!(d3 <= d2));
        cf_02.d((sJ)object);
        return tu_03;
    }
}


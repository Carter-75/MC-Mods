/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cf_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.ti_0;
import org.valkyrienskies.core.impl.shadow.tp_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

public abstract class sY {
    private final cf_0 a;

    public sY(int n2) {
        this.a = new cf_0(n2);
    }

    public sY(cf_0 cf_02) {
        ci_0.a(cf_02);
        this.a = cf_02;
    }

    protected static void a(tp_0 tp_02, tu_0 tu_02, tu_0 tu_03) {
        ci_0.a(tp_02);
        ci_0.a(tu_02);
        ci_0.a(tu_03);
        if (tp_02.f() != tp_02.g()) {
            throw new ti_0(tp_02.f(), tp_02.g());
        }
        if (tu_02.f() != tp_02.f()) {
            throw new oS(tu_02.f(), tp_02.f());
        }
        if (tu_03.f() != tp_02.g()) {
            throw new oS(tu_03.f(), tp_02.g());
        }
    }

    public final cf_0 a() {
        return this.a;
    }

    public tu_0 a(tp_0 tp_02, tu_0 tu_02) {
        ci_0.a(tp_02);
        sA sA2 = new sA(tp_02.g());
        ((tu_0)((Object)sA2)).f(0.0);
        return this.c(tp_02, tu_02, (tu_0)((Object)sA2));
    }

    public tu_0 b(tp_0 tp_02, tu_0 tu_02, tu_0 tu_03) {
        ci_0.a(tu_03);
        return this.c(tp_02, tu_02, tu_03.j());
    }

    public abstract tu_0 c(tp_0 var1, tu_0 var2, tu_0 var3);
}


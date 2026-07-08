/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cf_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sY;
import org.valkyrienskies.core.impl.shadow.ti_0;
import org.valkyrienskies.core.impl.shadow.tp_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.tm
 */
public abstract class tm_0
extends sY {
    public tm_0(int n2) {
        super(n2);
    }

    public tm_0(cf_0 cf_02) {
        super(cf_02);
    }

    public tu_0 b(tp_0 tp_02, tp_0 tp_03, tu_0 tu_02, tu_0 tu_03) {
        ci_0.a(tu_03);
        return this.a(tp_02, tp_03, tu_02, tu_03.j());
    }

    public tu_0 a(tp_0 tp_02, tu_0 tu_02) {
        ci_0.a(tp_02);
        sA sA2 = new sA(tp_02.g());
        ((tu_0)((Object)sA2)).f(0.0);
        return this.a(tp_02, null, tu_02, (tu_0)((Object)sA2));
    }

    public tu_0 b(tp_0 tp_02, tu_0 tu_02, tu_0 tu_03) {
        ci_0.a(tu_03);
        return this.a(tp_02, null, tu_02, tu_03.j());
    }

    protected static void c(tp_0 tp_02, tp_0 tp_03, tu_0 object, tu_0 tu_02) {
        tu_0 tu_03 = tu_02;
        tu_02 = object;
        object = tp_02;
        ci_0.a(object);
        ci_0.a(tu_02);
        ci_0.a(tu_03);
        if (((tp_0)object).f() != ((tp_0)object).g()) {
            throw new ti_0(((tp_0)object).f(), ((tp_0)object).g());
        }
        if (tu_02.f() != ((tp_0)object).f()) {
            throw new oS(tu_02.f(), ((tp_0)object).f());
        }
        if (tu_03.f() != ((tp_0)object).g()) {
            throw new oS(tu_03.f(), ((tp_0)object).g());
        }
        if (tp_03 != null) {
            if (tp_03.g() != tp_03.f()) {
                throw new ti_0(tp_03.g(), tp_03.f());
            }
            if (tp_03.f() != tp_02.f()) {
                throw new oS(tp_03.f(), tp_02.f());
            }
        }
    }

    public tu_0 a(tp_0 tp_02, tp_0 tp_03, tu_0 tu_02) {
        ci_0.a(tp_02);
        sA sA2 = new sA(tp_02.g());
        return this.a(tp_02, tp_03, tu_02, (tu_0)((Object)sA2));
    }

    public abstract tu_0 a(tp_0 var1, tp_0 var2, tu_0 var3, tu_0 var4);

    public tu_0 c(tp_0 tp_02, tu_0 tu_02, tu_0 tu_03) {
        return this.a(tp_02, null, tu_02, tu_03);
    }
}


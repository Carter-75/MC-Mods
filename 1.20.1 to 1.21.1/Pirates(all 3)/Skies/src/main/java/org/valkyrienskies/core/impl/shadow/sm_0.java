/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.rs_0;
import org.valkyrienskies.core.impl.shadow.sf_0;
import org.valkyrienskies.core.impl.shadow.sl_0;
import org.valkyrienskies.core.impl.shadow.sp_0;
import org.valkyrienskies.core.impl.shadow.st_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.sm
 */
public final class sm_0 {
    final st_0 a;
    st_0 b;
    final double c;
    final sl_0 d;

    sm_0(st_0 object, st_0 st_02, double d2, sl_0 sl_02) {
        sm_0 sm_02;
        this.a = object;
        this.b = st_02;
        this.c = d2;
        this.d = sl_02;
        v0.c = sm_02 = this;
        st_0 st_03 = object;
        object = sm_02;
        st_03.a(((sm_0)object).d);
        st_02.a(this);
    }

    public final st_0 a() {
        return this.a;
    }

    public final st_0 b() {
        return this.b;
    }

    public final double c() {
        return this.c;
    }

    public final sl_0 d() {
        return this.d;
    }

    private rs_0 a(double d2) {
        Object object = this.a;
        object = ((st_0)object).a;
        return this.d.a(d2 + this.d.a(((sp_0)object).c));
    }

    final void a(sm_0 sm_02) {
        this.b = sm_02.a;
        this.b.a(this);
        sm_02 = this;
        this.b.a(sm_02.d);
    }

    final void a(sl_0 sl_02, List<sm_0> list, List<sm_0> list2) {
        Object object;
        Object object2 = this.a;
        object2 = ((st_0)object2).a;
        double d2 = this.d.a(((sp_0)object2).c);
        object2 = object = this.d.a(sl_02);
        double d3 = ci_0.b(((sf_0)object).a, d2 + Math.PI) - d2;
        double d4 = d3 + ((sf_0)object).c();
        double d5 = d4 - Math.PI * 2;
        object2 = this.d;
        double d6 = ((sl_0)object2).d;
        object = this.a;
        if (d5 >= this.c - d6) {
            list2.add(this);
            return;
        }
        double d7 = 0.0;
        if (d5 >= 0.0) {
            object = this.a((st_0)object, new st_0(new sp_0(this.d.a(d2 + d5))), d5, list2, sl_02);
            d7 = d5;
        }
        if (d3 >= this.c - d6) {
            if (d5 >= 0.0) {
                this.a((st_0)object, this.b, this.c - d7, list, sl_02);
                return;
            }
            list.add(this);
            return;
        }
        object = this.a((st_0)object, new st_0(new sp_0(this.d.a(d2 + d3))), d3 - d7, list, sl_02);
        d7 = d3;
        if (d4 >= this.c - d6) {
            this.a((st_0)object, this.b, this.c - d7, list2, sl_02);
            return;
        }
        object = this.a((st_0)object, new st_0(new sp_0(this.d.a(d2 + d3))), d3 - d7, list2, sl_02);
        d7 = d3;
        this.a((st_0)object, this.b, this.c - d7, list, sl_02);
    }

    private st_0 a(st_0 object, st_0 st_02, double d2, List<sm_0> list, sl_0 sl_02) {
        sl_0 sl_03;
        sl_0 sl_04 = this.d;
        if (d2 <= sl_03.d) {
            return object;
        }
        st_02.a(sl_02);
        object = new sm_0((st_0)object, st_02, d2, this.d);
        list.add((sm_0)object);
        return st_02;
    }
}


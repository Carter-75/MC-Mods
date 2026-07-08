/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.sl_0;
import org.valkyrienskies.core.impl.shadow.sm_0;
import org.valkyrienskies.core.impl.shadow.sp_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.st
 */
public final class st_0 {
    final sp_0 a;
    sm_0 b;
    sm_0 c;
    final List<sl_0> d;

    st_0(sp_0 sp_02) {
        this.a = sp_02;
        this.b = null;
        this.c = null;
        this.d = new ArrayList<sl_0>();
    }

    public final sp_0 a() {
        return this.a;
    }

    final void a(sl_0 sl_02) {
        this.d.add(sl_02);
    }

    final sl_0 a(st_0 st_02) {
        for (sl_0 sl_02 : this.d) {
            for (sl_0 sl_03 : st_02.d) {
                if (sl_02 != sl_03) continue;
                return sl_02;
            }
        }
        return null;
    }

    final void a(sm_0 sm_02) {
        this.b = sm_02;
        this.a(sm_02.d);
    }

    public final sm_0 b() {
        return this.b;
    }

    final void b(sm_0 sm_02) {
        this.c = sm_02;
        this.a(sm_02.d);
    }

    public final sm_0 c() {
        return this.c;
    }
}


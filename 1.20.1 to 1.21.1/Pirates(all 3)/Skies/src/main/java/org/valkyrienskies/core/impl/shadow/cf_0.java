/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import org.valkyrienskies.core.impl.shadow.cb_0;
import org.valkyrienskies.core.impl.shadow.cc_0;
import org.valkyrienskies.core.impl.shadow.ce_0;
import org.valkyrienskies.core.impl.shadow.sJ;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Cf
 */
public final class cf_0 {
    public cc_0.a a;
    private final Collection<ce_0> b;

    public cf_0(int n2) {
        this.a = cc_0.a.a().b(n2);
        this.b = new CopyOnWriteArrayList<ce_0>();
    }

    @Deprecated
    private cf_0(int n2, cb_0.a a2) {
        this(n2, new cc_0.a.a(a2){
            private /* synthetic */ cb_0.a a;
            {
                this.a = a2;
            }

            public final void a(int n2) {
                this.a.a(n2);
            }
        });
    }

    private cf_0(int n2, 1 var2_3) {
        cc_0.a a2 = cc_0.a.a().b(n2);
        this.a = new cc_0.a(a2.a, a2.b, a2.c, var2_3);
        this.b = new CopyOnWriteArrayList<ce_0>();
    }

    private void a(ce_0 ce_02) {
        this.b.add(ce_02);
    }

    public final void a(sJ object) {
        object = this.b.iterator();
        while (object.hasNext()) {
            ce_0 cfr_ignored_0 = (ce_0)object.next();
        }
    }

    public final void b(sJ object) {
        object = this.b.iterator();
        while (object.hasNext()) {
            ce_0 cfr_ignored_0 = (ce_0)object.next();
        }
    }

    public final void c(sJ object) {
        object = this.b.iterator();
        while (object.hasNext()) {
            ce_0 cfr_ignored_0 = (ce_0)object.next();
        }
    }

    public final void d(sJ object) {
        object = this.b.iterator();
        while (object.hasNext()) {
            ce_0 cfr_ignored_0 = (ce_0)object.next();
        }
    }

    public final int a() {
        cc_0.a a2 = this.a;
        return a2.e;
    }

    private int d() {
        cc_0.a a2 = this.a;
        return a2.b;
    }

    public final void b() {
        cc_0.a a2 = this.a;
        a2.d(1);
    }

    private void b(ce_0 ce_02) {
        this.b.remove(ce_02);
    }

    public final void c() {
        this.a = this.a.a(0);
    }
}


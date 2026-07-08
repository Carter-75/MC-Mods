/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.wH;
import org.valkyrienskies.core.impl.shadow.wQ;
import org.valkyrienskies.core.impl.shadow.xi_0;
import org.valkyrienskies.core.impl.shadow.xp_0;
import org.valkyrienskies.core.impl.shadow.zH;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.xm
 */
public final class xm_0
extends wH<wQ> {
    final xp_0 a;
    private final List<wQ> b = new ArrayList<wQ>();

    private xm_0(xp_0 xp_02, int n2, zH zH2) {
        super(xp_02, n2, zH2);
        this.a = xp_02;
    }

    private wQ[] m() {
        xm_0 xm_02 = this;
        Collections.sort(this.b, new Comparator<wQ>(xm_02){
            private /* synthetic */ xm_0 a;
            {
                this.a = xm_02;
            }

            private int a(wQ object, wQ wQ2) {
                if (object == null) {
                    if (wQ2 == null) {
                        return 0;
                    }
                    return 1;
                }
                if (wQ2 == null) {
                    return -1;
                }
                double d2 = (Double)((co_0)object).c();
                double d3 = (Double)wQ2.c();
                object = this.a;
                object = ((xm_0)object).a;
                if (((xp_0)object).a == xi_0.MINIMIZE) {
                    return Double.compare(d2, d3);
                }
                return Double.compare(d3, d2);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            public final /* synthetic */ int compare(Object object, Object object2) {
                wQ wQ2 = (wQ)object2;
                object2 = (wQ)object;
                object = this;
                if (object2 == null) {
                    if (wQ2 != null) return 1;
                    return 0;
                }
                if (wQ2 == null) {
                    return -1;
                }
                double d2 = (Double)((co_0)object2).c();
                double d3 = (Double)wQ2.c();
                object = object.a;
                object = ((xm_0)object).a;
                if (((xp_0)object).a == xi_0.MINIMIZE) {
                    return Double.compare(d2, d3);
                }
                int n2 = Double.compare(d3, d2);
                return n2;
            }
        });
        return this.b.toArray(new wQ[0]);
    }

    @Override
    private void a(wQ wQ2) {
        this.b.add(wQ2);
    }

    @Override
    public final void d() {
        this.b.clear();
    }

    private Comparator<wQ> n() {
        return new /* invalid duplicate definition of identical inner class */;
    }

    @Override
    public final /* synthetic */ void a(Object object) {
        wQ wQ2 = (wQ)object;
        object = this;
        ((xm_0)object).b.add(wQ2);
    }

    public final /* synthetic */ co_0[] b() {
        xm_0 xm_02;
        xm_0 xm_03 = xm_02 = this;
        Collections.sort(xm_02.b, new /* invalid duplicate definition of identical inner class */);
        return xm_02.b.toArray(new wQ[0]);
    }

    static /* synthetic */ xp_0 a(xm_0 xm_02) {
        return xm_02.a;
    }
}


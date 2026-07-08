/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.wH;
import org.valkyrienskies.core.impl.shadow.wR;
import org.valkyrienskies.core.impl.shadow.xF;
import org.valkyrienskies.core.impl.shadow.zH;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class xE
extends wH<wR> {
    final xF a;
    private final List<wR> b = new ArrayList<wR>();

    private xE(xF xF2, int n2, zH zH2) {
        super(xF2, n2, zH2);
        this.a = xF2;
    }

    private wR[] m() {
        xE xE2 = this;
        Collections.sort(this.b, new Comparator<wR>(xE2){
            private final sA a;
            private final tq_0 b;
            private /* synthetic */ xE c;
            {
                this.c = xE2;
                xE2 = this.c;
                this.a = new sA(xE2.a.d(), false);
                xE2 = this.c;
                this.b = xE2.a.b();
            }

            private int a(wR wR2, wR wR3) {
                if (wR2 == null) {
                    if (wR3 == null) {
                        return 0;
                    }
                    return 1;
                }
                if (wR3 == null) {
                    return -1;
                }
                return Double.compare(this.a(wR2), this.a(wR3));
            }

            private double a(wR object) {
                object = new sA(((wR)object).b(), false);
                object = ((tu_0)((Object)this.a)).k((tu_0)object);
                return ((tu_0)object).b((tu_0)((Object)this.b.a((tu_0)object)));
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Override
            public final /* synthetic */ int compare(Object object, Object object2) {
                wR wR2 = (wR)object2;
                object2 = (wR)object;
                object = this;
                if (object2 == null) {
                    if (wR2 != null) return 1;
                    return 0;
                }
                if (wR2 == null) {
                    return -1;
                }
                int n2 = Double.compare(super.a((wR)object2), super.a(wR2));
                return n2;
            }
        });
        return this.b.toArray(new wR[0]);
    }

    @Override
    private void a(wR wR2) {
        this.b.add(wR2);
    }

    @Override
    public final void d() {
        this.b.clear();
    }

    private Comparator<wR> n() {
        return new /* invalid duplicate definition of identical inner class */;
    }

    @Override
    public final /* synthetic */ void a(Object object) {
        wR wR2 = (wR)object;
        object = this;
        ((xE)object).b.add(wR2);
    }

    public final /* synthetic */ co_0[] b() {
        xE xE2;
        xE xE3 = xE2 = this;
        Collections.sort(xE2.b, new /* invalid duplicate definition of identical inner class */);
        return xE2.b.toArray(new wR[0]);
    }

    static /* synthetic */ xF a(xE xE2) {
        return xE2.a;
    }
}


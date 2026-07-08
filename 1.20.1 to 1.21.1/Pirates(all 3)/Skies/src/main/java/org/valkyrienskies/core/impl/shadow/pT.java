/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kX;
import org.valkyrienskies.core.impl.shadow.kY;
import org.valkyrienskies.core.impl.shadow.pU;
import org.valkyrienskies.core.impl.shadow.pW;
import org.valkyrienskies.core.impl.shadow.pY;
import org.valkyrienskies.core.impl.shadow.qa_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sM;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wR;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class pT {
    public int a;
    public int b;
    private wK<pW.a> d;
    private pY e;
    private tu_0 f;
    private tu_0 g;
    public tq_0 c;
    private boolean h;
    private qa_0 i;

    public final pW a() {
        return pU.a(this.e, this.f, this.g, this.c, this.d, this.a, this.b, this.h, this.i);
    }

    public final pT a(int n2) {
        this.a = Integer.MAX_VALUE;
        return this;
    }

    public final pT b(int n2) {
        this.b = n2;
        return this;
    }

    private pT a(wK<pW.a> wK2) {
        this.d = wK2;
        return this;
    }

    private pT b(wK<wR> object) {
        wK<pW.a> wK2 = new wK<pW.a>(object){
            private /* synthetic */ wK a;
            {
                this.a = wK2;
            }

            private boolean a(int n2, pW.a a2, pW.a a3) {
                return this.a.a(n2, new wR(a2.e().g(), a2.d().g(), false), new wR(a3.e().g(), a3.d().g(), false));
            }

            public final /* synthetic */ boolean a(int n2, Object object, Object object2) {
                pW.a a2 = (pW.a)object2;
                object2 = (pW.a)object;
                int n3 = n2;
                pU.3 var1_2 = this;
                return var1_2.a.a(n3, new wR(object2.e().g(), object2.d().g(), false), new wR(a2.e().g(), a2.d().g(), false));
            }
        };
        object = this;
        this.d = wK2;
        return object;
    }

    public final pT a(kY object, kX object2) {
        object2 = pU.a((kY)object, (kX)object2);
        object = this;
        this.e = object2;
        return object;
    }

    private pT a(pY pY2) {
        this.e = pY2;
        return this;
    }

    private pT a(sA sA2) {
        this.f = sA2;
        return this;
    }

    public final pT a(double[] object) {
        sA sA2 = new sA((double[])object, false);
        object = this;
        this.f = sA2;
        return object;
    }

    private pT b(sA sA2) {
        this.g = sA2;
        return this;
    }

    public final pT b(double[] object) {
        sA sA2 = new sA((double[])object, false);
        object = this;
        this.g = sA2;
        return object;
    }

    public final pT a(sM sM2) {
        this.c = sM2;
        return this;
    }

    private pT a(boolean bl) {
        this.h = bl;
        return this;
    }

    private pT a(qa_0 qa_02) {
        this.i = qa_02;
        return this;
    }
}


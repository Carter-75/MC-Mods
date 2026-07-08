/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.pW;
import org.valkyrienskies.core.impl.shadow.wK;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class pQ
implements wK<pW.a> {
    private final double a;
    private final double b;

    private pQ(double d2) {
        double d3 = d2;
        this(d3, d3);
    }

    private pQ(double d2, double d3) {
        this.a = d2;
        this.b = d3;
    }

    private boolean a(pW.a a2, pW.a a3) {
        double d2;
        double d3 = a2.a();
        return cq_0.b(d3, d2 = a3.a(), this.b) || cq_0.c(d3, d2, this.a);
    }

    @Override
    public final /* synthetic */ boolean a(int n2, Object object, Object object2) {
        double d2;
        object2 = (pW.a)object2;
        object = (pW.a)object;
        pQ pQ2 = this;
        double d3 = object.a();
        return cq_0.b(d3, d2 = object2.a(), pQ2.b) || cq_0.c(d3, d2, pQ2.a);
    }
}


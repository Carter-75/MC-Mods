/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.wF;
import org.valkyrienskies.core.impl.shadow.wQ;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class wU
extends wF<wQ> {
    private static final int a = -1;
    private final int b;

    public wU(double d2, double d3) {
        super(d2, d3);
        this.b = -1;
    }

    private wU(double d2, double d3, int n2) {
        super(d2, d3);
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.b = n2;
    }

    @Override
    private boolean a(int n2, wQ wQ2, wQ wQ3) {
        double d2;
        double d3;
        if (this.b != -1 && n2 >= this.b) {
            return true;
        }
        double d4 = (Double)wQ2.c();
        double d5 = BY.w(d4 - (d3 = ((Double)wQ3.c()).doubleValue()));
        return d5 <= (d2 = BY.e(BY.w(d4), BY.w(d3))) * this.a() || d5 <= this.b();
    }

    @Override
    public final /* synthetic */ boolean a(int n2, Object object, Object object2) {
        double d2;
        double d3;
        wQ wQ2 = (wQ)object2;
        object2 = (wQ)object;
        int n3 = n2;
        wU wU2 = this;
        if (wU2.b != -1 && n3 >= wU2.b) {
            return true;
        }
        double d4 = (Double)((co_0)object2).c();
        double d5 = BY.w(d4 - (d3 = ((Double)wQ2.c()).doubleValue()));
        return d5 <= (d2 = BY.e(BY.w(d4), BY.w(d3))) * wU2.a() || d5 <= wU2.b();
    }
}


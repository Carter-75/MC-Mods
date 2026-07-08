/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.wF;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class wT<PAIR extends co_0<double[], ? extends Object>>
extends wF<PAIR> {
    private static final int a = -1;
    private final int b;

    private wT(double d2, double d3) {
        super(d2, d3);
        this.b = -1;
    }

    private wT(double d2, double d3, int n2) {
        super(d2, d3);
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.b = n2;
    }

    @Override
    private boolean a(int n2, PAIR object, PAIR PAIR) {
        if (this.b != -1 && n2 >= this.b) {
            return true;
        }
        double[] dArray = (double[])((co_0)object).a;
        object = PAIR;
        object = (double[])((co_0)object).a;
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            double d2;
            double d3 = dArray[i2];
            PAIR PAIR2 = object[i2];
            double d4 = BY.w(d3 - PAIR2);
            if (!(d4 > (d2 = BY.e(BY.w(d3), BY.w(PAIR2))) * this.a()) || !(d4 > this.b())) continue;
            return false;
        }
        return true;
    }

    @Override
    public final /* synthetic */ boolean a(int n2, Object object, Object object2) {
        co_0 co_02 = (co_0)object2;
        object2 = (co_0)object;
        int n3 = n2;
        wT wT2 = this;
        if (wT2.b == -1 || n3 < wT2.b) {
            double[] dArray = (double[])((co_0)object2).a;
            object2 = co_02;
            object2 = (double[])((co_0)object2).a;
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                double d2;
                double d3 = dArray[i2];
                Object object3 = object2[i2];
                double d4 = BY.w(d3 - object3);
                if (!(d4 > (d2 = BY.e(BY.w(d3), BY.w((double)object3))) * wT2.a()) || !(d4 > wT2.b())) continue;
                return false;
            }
        }
        return true;
    }
}


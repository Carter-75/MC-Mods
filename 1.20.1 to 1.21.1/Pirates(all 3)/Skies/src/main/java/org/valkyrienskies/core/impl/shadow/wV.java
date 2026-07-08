/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.wF;
import org.valkyrienskies.core.impl.shadow.wR;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class wV
extends wF<wR> {
    private static final int a = -1;
    private final int b;

    public wV(double d2, double d3) {
        super(d2, d3);
        this.b = -1;
    }

    private wV(double d2, double d3, int n2) {
        super(d2, d3);
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.b = n2;
    }

    @Override
    private boolean a(int n2, wR object, wR wR2) {
        if (this.b != -1 && n2 >= this.b) {
            return true;
        }
        double[] dArray = ((wR)object).b();
        object = wR2.b();
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            double d2;
            double d3 = dArray[i2];
            Object object2 = object[i2];
            double d4 = BY.w(d3 - object2);
            if (!(d4 > (d2 = BY.e(BY.w(d3), BY.w((double)object2))) * this.a()) || !(d4 > this.b())) continue;
            return false;
        }
        return true;
    }

    @Override
    public final /* synthetic */ boolean a(int n2, Object object, Object object2) {
        wR wR2 = (wR)object2;
        object2 = (wR)object;
        int n3 = n2;
        wV wV2 = this;
        if (wV2.b == -1 || n3 < wV2.b) {
            double[] dArray = ((wR)object2).b();
            object2 = wR2.b();
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                double d2;
                double d3 = dArray[i2];
                Object object3 = object2[i2];
                double d4 = BY.w(d3 - object3);
                if (!(d4 > (d2 = BY.e(BY.w(d3), BY.w((double)object3))) * wV2.a()) || !(d4 > wV2.b())) continue;
                return false;
            }
        }
        return true;
    }
}


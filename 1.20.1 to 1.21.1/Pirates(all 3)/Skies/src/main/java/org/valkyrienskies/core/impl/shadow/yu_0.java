/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.xT;
import org.valkyrienskies.core.impl.shadow.yq_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.yu
 */
@Deprecated
public final class yu_0
extends xT<yq_0> {
    private static final int a = -1;
    private final int b;

    @Deprecated
    public yu_0() {
        this.b = -1;
    }

    private yu_0(double d2, double d3) {
        super(d2, d3);
        this.b = -1;
    }

    private yu_0(double d2, double d3, int n2) {
        super(d2, d3);
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.b = n2;
    }

    @Override
    private boolean a(int n2, yq_0 object, yq_0 yq_02) {
        if (this.b != -1 && n2 >= this.b) {
            return true;
        }
        double[] dArray = ((yq_0)object).d();
        object = yq_02.d();
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
        yq_0 yq_02 = (yq_0)object2;
        object2 = (yq_0)object;
        int n3 = n2;
        yu_0 yu_02 = this;
        if (yu_02.b == -1 || n3 < yu_02.b) {
            double[] dArray = ((yq_0)object2).d();
            object2 = yq_02.d();
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                double d2;
                double d3 = dArray[i2];
                Object object3 = object2[i2];
                double d4 = BY.w(d3 - object3);
                if (!(d4 > (d2 = BY.e(BY.w(d3), BY.w((double)object3))) * yu_02.a()) || !(d4 > yu_02.b())) continue;
                return false;
            }
        }
        return true;
    }
}


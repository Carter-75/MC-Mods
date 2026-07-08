/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.xT;
import org.valkyrienskies.core.impl.shadow.yp_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.yt
 */
@Deprecated
public final class yt_0
extends xT<yp_0> {
    private static final int a = -1;
    private final int b;

    @Deprecated
    public yt_0() {
        this.b = -1;
    }

    public yt_0(double d2, double d3) {
        super(d2, d3);
        this.b = -1;
    }

    private yt_0(double d2, double d3, int n2) {
        super(d2, d3);
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.b = n2;
    }

    @Override
    private boolean a(int n2, yp_0 yp_02, yp_0 yp_03) {
        double d2;
        double d3;
        if (this.b != -1 && n2 >= this.b) {
            return true;
        }
        double d4 = (Double)yp_02.c();
        double d5 = BY.w(d4 - (d3 = ((Double)yp_03.c()).doubleValue()));
        return d5 <= (d2 = BY.e(BY.w(d4), BY.w(d3))) * this.a() || d5 <= this.b();
    }

    @Override
    public final /* synthetic */ boolean a(int n2, Object object, Object object2) {
        double d2;
        double d3;
        yp_0 yp_02 = (yp_0)object2;
        object2 = (yp_0)object;
        int n3 = n2;
        yt_0 yt_02 = this;
        if (yt_02.b != -1 && n3 >= yt_02.b) {
            return true;
        }
        double d4 = (Double)((co_0)object2).c();
        double d5 = BY.w(d4 - (d3 = ((Double)yp_02.c()).doubleValue()));
        return d5 <= (d2 = BY.e(BY.w(d4), BY.w(d3))) * yt_02.a() || d5 <= yt_02.b();
    }
}


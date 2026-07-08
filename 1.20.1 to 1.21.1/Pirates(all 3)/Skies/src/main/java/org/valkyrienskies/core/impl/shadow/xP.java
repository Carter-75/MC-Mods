/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.wF;
import org.valkyrienskies.core.impl.shadow.xS;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class xP
extends wF<xS> {
    private static final int a = -1;
    private final int b;

    public xP(double d2, double d3) {
        super(d2, d3);
        this.b = -1;
    }

    private xP(double d2, double d3, int n2) {
        super(d2, d3);
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.b = n2;
    }

    @Override
    private boolean a(int n2, xS xS2, xS xS3) {
        double d2;
        if (this.b != -1 && n2 >= this.b) {
            return true;
        }
        xS xS4 = xS2;
        double d3 = xS4.b;
        xS4 = xS3;
        double d4 = xS4.b;
        double d5 = BY.w(d3 - d4);
        return d5 <= (d2 = BY.e(BY.w(d3), BY.w(d4))) * this.a() || d5 <= this.b();
    }

    @Override
    public final /* synthetic */ boolean a(int n2, Object object, Object object2) {
        double d2;
        xS xS2 = (xS)object2;
        object2 = (xS)object;
        int n3 = n2;
        xP xP2 = this;
        if (xP2.b != -1 && n3 >= xP2.b) {
            return true;
        }
        Object object3 = object2;
        double d3 = ((xS)object3).b;
        object3 = xS2;
        double d4 = ((xS)object3).b;
        double d5 = BY.w(d3 - d4);
        return d5 <= (d2 = BY.e(BY.w(d3), BY.w(d4))) * xP2.a() || d5 <= xP2.b();
    }
}


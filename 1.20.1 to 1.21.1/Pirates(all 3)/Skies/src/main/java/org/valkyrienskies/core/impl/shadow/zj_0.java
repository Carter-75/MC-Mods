/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.xT;
import org.valkyrienskies.core.impl.shadow.zm_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.zj
 */
@Deprecated
public final class zj_0
extends xT<zm_0> {
    private static final int a = -1;
    private final int b;

    @Deprecated
    public zj_0() {
        this.b = -1;
    }

    public zj_0(double d2, double d3) {
        super(d2, d3);
        this.b = -1;
    }

    private zj_0(double d2, double d3, int n2) {
        super(d2, d3);
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.b = n2;
    }

    @Override
    private boolean a(int n2, zm_0 zm_02, zm_0 zm_03) {
        double d2;
        if (this.b != -1 && n2 >= this.b) {
            return true;
        }
        zm_0 zm_04 = zm_02;
        double d3 = zm_04.b;
        zm_04 = zm_03;
        double d4 = zm_04.b;
        double d5 = BY.w(d3 - d4);
        return d5 <= (d2 = BY.e(BY.w(d3), BY.w(d4))) * this.a() || d5 <= this.b();
    }

    @Override
    public final /* synthetic */ boolean a(int n2, Object object, Object object2) {
        double d2;
        zm_0 zm_02 = (zm_0)object2;
        object2 = (zm_0)object;
        int n3 = n2;
        zj_0 zj_02 = this;
        if (zj_02.b != -1 && n3 >= zj_02.b) {
            return true;
        }
        Object object3 = object2;
        double d3 = ((zm_0)object3).b;
        object3 = zm_02;
        double d4 = ((zm_0)object3).b;
        double d5 = BY.w(d3 - d4);
        return d5 <= (d2 = BY.e(BY.w(d3), BY.w(d4))) * zj_02.a() || d5 <= zj_02.b();
    }
}


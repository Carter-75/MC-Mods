/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cb_0;
import org.valkyrienskies.core.impl.shadow.lc_0;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pp_0;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yf_0;
import org.valkyrienskies.core.impl.shadow.zl_0;
import org.valkyrienskies.core.impl.shadow.zm_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.zf
 */
@Deprecated
public abstract class zf_0
implements zl_0 {
    private final ya_0<zm_0> a;
    private final cb_0 b = new cb_0();
    private yf_0 c;
    private double d;
    private double e;
    private double f;
    private lc_0 g;

    protected zf_0(ya_0<zm_0> ya_02) {
        this.a = ya_02;
    }

    @Override
    public final int a() {
        cb_0 cb_02 = this.b;
        return cb_02.a;
    }

    @Override
    public final int b() {
        cb_0 cb_02 = this.b;
        return cb_02.b;
    }

    public final yf_0 d() {
        return this.c;
    }

    public final double e() {
        return this.d;
    }

    public final double f() {
        return this.e;
    }

    public final double g() {
        return this.f;
    }

    protected final double a(double d2) {
        try {
            this.b.c();
        }
        catch (pc_0 pc_02) {
            pc_0 pc_03 = pc_02;
            throw new pp_0(pc_03.a);
        }
        return this.g.a(d2);
    }

    @Override
    public final zm_0 a(int n2, lc_0 lc_02, yf_0 yf_02, double d2, double d3, double d4) {
        if (lc_02 == null) {
            throw new pl_0();
        }
        if (yf_02 == null) {
            throw new pl_0();
        }
        this.d = d2;
        this.e = d3;
        this.f = d4;
        this.c = yf_02;
        this.g = lc_02;
        this.b.a(n2);
        this.b.d();
        return this.h();
    }

    @Override
    public final zm_0 a(int n2, lc_0 lc_02, yf_0 yf_02, double d2, double d3) {
        return this.a(n2, lc_02, yf_02, d2, d3, d2 + 0.5 * (d3 - d2));
    }

    @Override
    public final ya_0<zm_0> c() {
        return this.a;
    }

    protected abstract zm_0 h();
}


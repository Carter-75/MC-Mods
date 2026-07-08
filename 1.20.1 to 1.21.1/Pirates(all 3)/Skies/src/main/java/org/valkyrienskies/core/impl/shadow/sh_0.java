/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.qM;
import org.valkyrienskies.core.impl.shadow.rK;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.sg_0;
import org.valkyrienskies.core.impl.shadow.si_0;
import org.valkyrienskies.core.impl.shadow.sj_0;
import org.valkyrienskies.core.impl.shadow.sk_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.sh
 */
public final class sh_0
implements rV<sj_0> {
    si_0 a;
    boolean b;
    private final double c;

    public sh_0(si_0 si_02, boolean bl, double d2) {
        this.a = si_02;
        this.b = bl;
        this.c = d2;
    }

    private sh_0 h() {
        return this;
    }

    @Override
    public final double a(qM<sj_0> si_02) {
        si_0 si_03 = si_02;
        si_02 = si_03;
        si_02 = this.a;
        double d2 = si_03.b - si_02.b;
        if (this.b) {
            return d2;
        }
        return -d2;
    }

    public final boolean a() {
        return this.b;
    }

    private sh_0 i() {
        return new sh_0(this.a, !this.b, this.c);
    }

    public final sk_0 c() {
        return new sk_0(this, null);
    }

    private sg_0 j() {
        return new sg_0(this.c);
    }

    @Override
    public final boolean a(rV<sj_0> rV2) {
        return !(this.b ^ ((sh_0)rV2).b);
    }

    public final si_0 d() {
        return this.a;
    }

    @Override
    public final qM<sj_0> b(qM<sj_0> qM2) {
        return this.a;
    }

    @Override
    public final double b() {
        return this.c;
    }

    public final /* synthetic */ rK e() {
        sh_0 sh_02 = this;
        return new sg_0(sh_02.c);
    }

    public final /* synthetic */ rL f() {
        return this.c();
    }
}


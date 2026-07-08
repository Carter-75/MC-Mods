/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rN;
import org.valkyrienskies.core.impl.shadow.rO;
import org.valkyrienskies.core.impl.shadow.rT;
import org.valkyrienskies.core.impl.shadow.rX;
import org.valkyrienskies.core.impl.shadow.sb_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
final class rP<S extends qN>
implements rN<S> {
    rP() {
    }

    @Override
    public final int a(rM<S> rM2) {
        return rN.a.PLUS_MINUS_SUB$672d2271;
    }

    @Override
    public final void b(rM<S> object) {
        rT rT2;
        rM<S> rM2;
        sb_0 sb_02 = null;
        sb_0 sb_03 = null;
        rX rX2 = null;
        rT rT3 = object;
        rT3 = object;
        rT rT4 = new rT(rM2.b, ((rM)((Object)rT3)).a.e());
        if (rT4.a()) {
            rM<S> rM3;
            rT3 = object;
            rT3 = rT4;
            rT2 = new rT(rM3.c, rT3.a);
            if (rT2.d()) {
                rT3 = rT2;
                sb_02 = rT3.b;
                rX2 = new rX();
                rT3 = rT2;
                rX2.a(rT3.d);
                rT3 = rT4;
                rX2.a(rT3.c);
            }
        }
        if (rT4.d()) {
            rM<S> rM4;
            rT3 = object;
            rT3 = rT4;
            rT2 = new rT(rM4.c, rT3.b);
            if (rT2.a()) {
                rT3 = rT2;
                sb_03 = rT3.a;
                if (rX2 == null) {
                    rX2 = new rX();
                }
                rT3 = rT2;
                rX2.a(rT3.c);
                rT3 = rT4;
                rX2.a(rT3.d);
            }
        }
        if (rX2 != null) {
            rT3 = object;
            rT2 = ((rM)((Object)rT3)).d;
            while (rT2 != null) {
                rX2.a(rT2);
                rT3 = rT2;
                rT2 = ((rM)((Object)rT3)).d;
            }
        }
        rM<S> rM5 = object;
        object = new rO(sb_02, sb_03, rX2);
        rT3 = rM5;
        rM5.e = object;
    }

    @Override
    public final void c(rM<S> rM2) {
    }
}


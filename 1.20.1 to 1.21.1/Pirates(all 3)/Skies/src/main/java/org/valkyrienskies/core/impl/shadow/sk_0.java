/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.sb_0;
import org.valkyrienskies.core.impl.shadow.sh_0;
import org.valkyrienskies.core.impl.shadow.sj_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.sk
 */
public final class sk_0
extends rL<sj_0, sj_0> {
    public sk_0(rV<sj_0> rV2, rY<sj_0> rY2) {
        super(rV2, rY2);
    }

    @Override
    public final double a() {
        return 0.0;
    }

    @Override
    public final boolean b() {
        return false;
    }

    @Override
    public final rL<sj_0, sj_0> a(rV<sj_0> rV2, rY<sj_0> rY2) {
        return new sk_0(rV2, rY2);
    }

    @Override
    public final sb_0.a<sj_0> a(rV<sj_0> sh_02) {
        double d2;
        sh_0 sh_03 = sh_02;
        sh_02 = (sh_0)this.c();
        double d3 = sh_03.a(sh_02.a);
        if (d2 < -1.0E-10) {
            return new sb_0.a<sj_0>(null, this);
        }
        return new sb_0.a<sj_0>(this, null);
    }
}


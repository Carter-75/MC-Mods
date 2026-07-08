/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.qU;
import org.valkyrienskies.core.impl.shadow.qX;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.sb_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class qY
extends rL<qU, qU> {
    public qY(rV<qU> rV2, rY<qU> rY2) {
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
    public final rL<qU, qU> a(rV<qU> rV2, rY<qU> rY2) {
        return new qY(rV2, rY2);
    }

    @Override
    public final sb_0.a<qU> a(rV<qU> qX2) {
        double d2;
        qX qX3 = qX2;
        qX2 = (qX)this.c();
        double d3 = qX3.a(qX2.a);
        if (d2 < -1.0E-10) {
            return new sb_0.a<qU>(null, this);
        }
        if (d3 > 1.0E-10) {
            return new sb_0.a<qU>(this, null);
        }
        return new sb_0.a<qU>(null, null);
    }
}


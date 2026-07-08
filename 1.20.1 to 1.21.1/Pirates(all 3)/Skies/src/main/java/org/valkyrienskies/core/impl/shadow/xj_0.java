/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kY;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.wQ;
import org.valkyrienskies.core.impl.shadow.xp_0;
import org.valkyrienskies.core.impl.shadow.xr_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.xj
 */
public abstract class xj_0
extends xp_0 {
    private kY b;

    public xj_0(wK<wQ> wK2) {
        super(wK2);
    }

    protected final double[] a(double[] dArray) {
        return this.b.a(dArray);
    }

    @Override
    public wQ c(wO ... wOArray) {
        return super.c(wOArray);
    }

    @Override
    public void b(wO ... object) {
        super.b((wO)object);
        int n2 = ((wO[])object).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            wO wO2 = object[i2];
            if (!(wO2 instanceof xr_0)) continue;
            object = (xr_0)wO2;
            this.b = object.a;
            return;
        }
    }

    @Override
    public /* synthetic */ Object a(wO[] wOArray) {
        return ((xp_0)this).c(wOArray);
    }
}


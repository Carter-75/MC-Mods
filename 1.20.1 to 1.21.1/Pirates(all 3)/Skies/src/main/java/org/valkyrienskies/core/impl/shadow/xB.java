/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kX;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.wR;
import org.valkyrienskies.core.impl.shadow.xD;
import org.valkyrienskies.core.impl.shadow.xF;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public abstract class xB
extends xF {
    private kX a;

    public xB(wK<wR> wK2) {
        super(wK2);
    }

    protected final double[][] a(double[] dArray) {
        return this.a.a(dArray);
    }

    @Override
    public wR c(wO ... wOArray) {
        return super.c(wOArray);
    }

    @Override
    public void b(wO ... object) {
        super.b((wO)object);
        int n2 = ((wO[])object).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            wO wO2 = object[i2];
            if (!(wO2 instanceof xD)) continue;
            object = (xD)wO2;
            this.a = object.a;
            return;
        }
    }

    @Override
    public /* synthetic */ Object a(wO[] wOArray) {
        return ((xF)this).c(wOArray);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.wI;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.wQ;
import org.valkyrienskies.core.impl.shadow.xi_0;
import org.valkyrienskies.core.impl.shadow.xq_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.xp
 */
public abstract class xp_0
extends wI<wQ> {
    private kW b;
    xi_0 a;

    public xp_0(wK<wQ> wK2) {
        super(wK2);
    }

    public wQ c(wO ... wOArray) {
        return (wQ)super.a(wOArray);
    }

    @Override
    public void b(wO ... wOArray) {
        super.b(wOArray);
        for (wO wO2 : wOArray) {
            if (wO2 instanceof xi_0) {
                this.a = (xi_0)wO2;
                continue;
            }
            if (!(wO2 instanceof xq_0)) continue;
            wO2 = (xq_0)wO2;
            this.b = ((xq_0)wO2).a;
        }
    }

    public final xi_0 n() {
        return this.a;
    }

    public final double b(double[] dArray) {
        super.k();
        return this.b.a(dArray);
    }

    @Override
    public /* synthetic */ Object a(wO[] wOArray) {
        return this.c(wOArray);
    }
}


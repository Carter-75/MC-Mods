/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.sM;
import org.valkyrienskies.core.impl.shadow.th_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.wO;

@Deprecated
public final class xH
implements wO {
    private final tq_0 a;

    public xH(double[] dArray) {
        this.a = new sM(dArray);
    }

    private xH(tq_0 tq_02) {
        if (tq_02.g() != tq_02.f()) {
            throw new th_0(tq_02.g(), tq_02.f());
        }
        this.a = tq_02.i();
    }

    public final tq_0 a() {
        return this.a.i();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rN;
import org.valkyrienskies.core.impl.shadow.rO;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
final class rS<S extends qN>
implements rN<S> {
    double a = 0.0;

    rS() {
    }

    @Override
    public final int a(rM<S> rM2) {
        return rN.a.MINUS_SUB_PLUS$672d2271;
    }

    @Override
    public final void b(rM<S> object) {
        Object object2 = object;
        object2 = object = (rO)((rM)object2).e;
        if (((rO)object).a != null) {
            object2 = object;
            this.a += ((rO)object2).a.a();
        }
        object2 = object;
        if (((rO)object2).b != null) {
            object2 = object;
            this.a += ((rO)object2).b.a();
        }
    }

    @Override
    public final void c(rM<S> rM2) {
    }

    public final double a() {
        return this.a;
    }
}


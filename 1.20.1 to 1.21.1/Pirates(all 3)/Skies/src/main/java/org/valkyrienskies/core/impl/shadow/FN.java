/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.EU;
import org.valkyrienskies.core.impl.shadow.FD;
import org.valkyrienskies.core.impl.shadow.FF;
import org.valkyrienskies.core.impl.shadow.FJ;
import org.valkyrienskies.core.impl.shadow.FM;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.er_0;
import org.valkyrienskies.core.impl.shadow.ew_2;

public final class FN
implements ek_2<FM> {
    private final Provider<er_0> a;
    private final Provider<FD> b;
    private final Provider<FJ> c;
    private final Provider<FF> d;
    private final Provider<EU> e;

    private FN(Provider<er_0> provider, Provider<FD> provider2, Provider<FJ> provider3, Provider<FF> provider4, Provider<EU> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    private FM a() {
        EU eU = this.e.get();
        FF fF = this.d.get();
        FJ fJ = this.c.get();
        FD fD = this.b.get();
        er_0 er_02 = this.a.get();
        return new FM(er_02, fD, fJ, fF, eU);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static FN a(ew_2 ew_22, ew_2 ew_23, ew_2 ew_24, ew_2 ew_25, ew_2 ew_26) {
        return new FN(ew_22, ew_23, ew_24, ew_25, ew_26);
    }

    private static FM a(er_0 er_02, FD fD, FJ fJ, FF fF, EU eU) {
        return new FM(er_02, fD, fJ, fF, eU);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        EU eU = ((FN)object).e.get();
        FF fF = ((FN)object).d.get();
        FJ fJ = ((FN)object).c.get();
        FD fD = ((FN)object).b.get();
        object = ((FN)object).a.get();
        return new FM((er_0)object, fD, fJ, fF, eU);
    }
}


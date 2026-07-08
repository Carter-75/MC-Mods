/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.program.VSCoreInternal;
import org.valkyrienskies.core.impl.shadow.FD;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.er_0;
import org.valkyrienskies.core.impl.shadow.ew_2;

public final class FE
implements ek_2<FD> {
    private final Provider<er_0> a;
    private final Provider<VSCoreInternal> b;

    private FE(Provider<er_0> provider, Provider<VSCoreInternal> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    private FD a() {
        Provider<VSCoreInternal> provider = this.b;
        er_0 er_02 = this.a.get();
        return new FD(er_02, provider);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static FE a(ew_2 ew_22, ew_2 ew_23) {
        return new FE(ew_22, ew_23);
    }

    private static FD a(er_0 er_02, Provider<VSCoreInternal> provider) {
        return new FD(er_02, provider);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        Provider<VSCoreInternal> provider = ((FE)object).b;
        object = ((FE)object).a.get();
        return new FD((er_0)object, provider);
    }
}


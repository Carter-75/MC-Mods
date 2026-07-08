/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.program.VSCoreInternal;
import org.valkyrienskies.core.impl.shadow.DN;
import org.valkyrienskies.core.impl.shadow.FJ;
import org.valkyrienskies.core.impl.shadow.FR;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.er_0;
import org.valkyrienskies.core.impl.shadow.ew_2;

public final class FK
implements ek_2<FJ> {
    private final Provider<DN> a;
    private final Provider<FR> b;
    private final Provider<er_0> c;
    private final Provider<VSCoreInternal> d;

    private FK(Provider<DN> provider, Provider<FR> provider2, Provider<er_0> provider3, Provider<VSCoreInternal> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    private FJ a() {
        Provider<VSCoreInternal> provider = this.d;
        er_0 er_02 = this.c.get();
        FR fR = this.b.get();
        DN dN = this.a.get();
        return new FJ(dN, fR, er_02, provider);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static FK a(ew_2 ew_22, ew_2 ew_23, ew_2 ew_24, ew_2 ew_25) {
        return new FK(ew_22, ew_23, ew_24, ew_25);
    }

    private static FJ a(DN dN, FR fR, er_0 er_02, Provider<VSCoreInternal> provider) {
        return new FJ(dN, fR, er_02, provider);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        Provider<VSCoreInternal> provider = ((FK)object).d;
        er_0 er_02 = ((FK)object).c.get();
        FR fR = ((FK)object).b.get();
        object = ((FK)object).a.get();
        return new FJ((DN)object, fR, er_02, provider);
    }
}


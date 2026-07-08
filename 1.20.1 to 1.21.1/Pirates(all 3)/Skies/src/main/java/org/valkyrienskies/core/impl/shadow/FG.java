/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.FF;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.er_0;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.fb_0;
import org.valkyrienskies.core.impl.shadow.fi_0;

public final class FG
implements ek_2<FF> {
    private final Provider<er_0> a;
    private final Provider<fi_0> b;
    private final Provider<fb_0> c;

    private FG(Provider<er_0> provider, Provider<fi_0> provider2, Provider<fb_0> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    private FF a() {
        fb_0 fb_02 = this.c.get();
        fi_0 fi_02 = this.b.get();
        er_0 er_02 = this.a.get();
        return new FF(er_02, fi_02, fb_02);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public static FG a(ew_2 ew_22, ew_2 ew_23, ew_2 ew_24) {
        return new FG(ew_22, ew_23, ew_24);
    }

    private static FF a(er_0 er_02, fi_0 fi_02, fb_0 fb_02) {
        return new FF(er_02, fi_02, fb_02);
    }

    @Override
    public final /* synthetic */ Object get() {
        Object object = this;
        fb_0 fb_02 = ((FG)object).c.get();
        fi_0 fi_02 = ((FG)object).b.get();
        object = ((FG)object).a.get();
        return new FF((er_0)object, fi_02, fb_02);
    }
}


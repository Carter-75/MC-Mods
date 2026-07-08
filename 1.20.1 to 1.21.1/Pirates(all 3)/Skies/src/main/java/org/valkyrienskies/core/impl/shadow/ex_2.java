/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.dt_1;
import org.valkyrienskies.core.impl.shadow.ej_2;
import org.valkyrienskies.core.impl.shadow.ev_2;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.ey_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ex
 */
public final class ex_2<T>
implements ew_2<dt_1<T>> {
    private final ew_2<T> a;

    private ex_2(ew_2<T> provider) {
        assert (provider != null);
        this.a = provider;
    }

    private dt_1<T> a() {
        return ej_2.b(this.a);
    }

    private static <T> ew_2<dt_1<T>> a(ew_2<T> provider) {
        return new ex_2<T>(ev_2.a(provider));
    }

    @Deprecated
    private static <T> ew_2<dt_1<T>> a(Provider<T> provider) {
        provider = ey_2.a(provider);
        return new ex_2<T>(ev_2.a(provider));
    }

    @Override
    public final /* synthetic */ Object get() {
        ex_2 ex_22 = this;
        return ej_2.b(ex_22.a);
    }
}


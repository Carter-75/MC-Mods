/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.cx_0;
import org.valkyrienskies.core.impl.shadow.ej_2;
import org.valkyrienskies.core.impl.shadow.ev_2;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.ey_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.eD
 */
public final class ed_1<T>
implements ew_2<T> {
    private static final Object a = new Object();
    private volatile @cx_0 ew_2<T> b;
    private volatile @cx_0 Object c = a;

    private ed_1(ew_2<T> provider) {
        assert (provider != null);
        this.b = provider;
    }

    @Override
    public final T get() {
        @cx_0 ew_2<T> ew_22 = this.c;
        if (ew_22 == a) {
            ew_22 = this.b;
            if (ew_22 == null) {
                ew_22 = this.c;
            } else {
                this.c = ew_22 = ew_22.get();
                this.b = null;
            }
        }
        return (T)ew_22;
    }

    public static <T> ew_2<T> a(ew_2<T> provider) {
        if (provider instanceof ed_1 || provider instanceof ej_2) {
            return provider;
        }
        return new ed_1<T>(ev_2.a(provider));
    }

    private static <P extends Provider<T>, T> Provider<T> a(P delegate) {
        return ed_1.a(ey_2.a(delegate));
    }
}


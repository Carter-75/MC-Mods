/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.cx_0;
import org.valkyrienskies.core.impl.shadow.dt_1;
import org.valkyrienskies.core.impl.shadow.ev_2;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.ey_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ej
 */
public final class ej_2<T>
implements dt_1<T>,
ew_2<T> {
    private static final Object a = new Object();
    private volatile @cx_0 ew_2<T> b;
    private volatile @cx_0 Object c = a;

    private ej_2(ew_2<T> provider) {
        assert (provider != null);
        this.b = provider;
    }

    @Override
    public final T get() {
        @cx_0 Object object = this.c;
        if (object == a) {
            object = this.a();
        }
        return (T)object;
    }

    private synchronized @cx_0 Object a() {
        @cx_0 Object object = this.c;
        if (object == a) {
            Object object2 = object = this.b.get();
            Object object3 = this.c;
            boolean bl = object3 != a;
            if (bl && object3 != object2) {
                throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + object3 + " & " + object2 + ". This is likely due to a circular dependency.");
            }
            this.c = object2;
            this.b = null;
        }
        return object;
    }

    private static @cx_0 Object a(@cx_0 Object currentInstance, @cx_0 Object newInstance) {
        boolean bl = currentInstance != a;
        if (bl && currentInstance != newInstance) {
            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + currentInstance + " & " + newInstance + ". This is likely due to a circular dependency.");
        }
        return newInstance;
    }

    public static <T> ew_2<T> a(ew_2<T> delegate) {
        ev_2.a(delegate);
        if (delegate instanceof ej_2) {
            return delegate;
        }
        return new ej_2<T>(delegate);
    }

    @Deprecated
    private static <P extends Provider<T>, T> Provider<T> b(P delegate) {
        return ej_2.a(ey_2.a(delegate));
    }

    public static <T> dt_1<T> b(ew_2<T> provider) {
        if (provider instanceof dt_1) {
            provider = (dt_1)provider;
            return provider;
        }
        return new ej_2<T>(ev_2.a(provider));
    }

    public static <P extends Provider<T>, T> dt_1<T> a(P provider) {
        return ej_2.b(ey_2.a(provider));
    }
}


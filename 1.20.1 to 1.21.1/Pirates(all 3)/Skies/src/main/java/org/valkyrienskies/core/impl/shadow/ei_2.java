/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.cx_0;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.ev_2;
import org.valkyrienskies.core.impl.shadow.ew_2;
import org.valkyrienskies.core.impl.shadow.ey_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ei
 */
public final class ei_2<T>
implements ek_2<T> {
    @cx_0 ew_2<T> a;

    @Override
    public final T get() {
        if (this.a == null) {
            throw new IllegalStateException();
        }
        return this.a.get();
    }

    @Deprecated
    private void a(ew_2<T> delegate) {
        ei_2.a(this, delegate);
    }

    @Deprecated
    private void a(Provider<T> delegate) {
        ey_2.1 var2_2 = ey_2.a(delegate);
        delegate = this;
        ei_2.a(delegate, var2_2);
    }

    public static <T> void a(ew_2<T> delegateFactory, ew_2<T> delegate) {
        delegateFactory = delegateFactory;
        ei_2.a(delegateFactory, delegate);
    }

    @Deprecated
    private static <T> void a(Provider<T> delegateFactory, Provider<T> delegate) {
        delegateFactory = delegateFactory;
        ei_2.a(delegateFactory, ey_2.a(delegate));
    }

    private static <T> void a(ei_2<T> delegateFactory, ew_2<T> delegate) {
        ev_2.a(delegate);
        if (delegateFactory.a != null) {
            throw new IllegalStateException();
        }
        delegateFactory.a = delegate;
    }

    final ew_2<T> a() {
        return ev_2.a(this.a);
    }
}


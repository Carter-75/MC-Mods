/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import org.valkyrienskies.core.impl.shadow.ev_2;
import org.valkyrienskies.core.impl.shadow.ew_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ey
 */
public final class ey_2 {
    public static <T> ew_2<T> a(Provider<T> provider) {
        ev_2.a(provider);
        return new ew_2<T>(provider){
            private /* synthetic */ Provider a;
            {
                this.a = val$provider;
            }

            @Override
            public final T get() {
                return this.a.get();
            }
        };
    }

    private ey_2() {
    }
}


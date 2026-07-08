/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.dv_1;
import org.valkyrienskies.core.impl.shadow.ev_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.eu
 */
public final class eu_2 {
    private static <T> dv_1<T> a() {
        return a.INSTANCE;
    }

    private eu_2() {
    }

    /*
     * Exception performing whole class analysis.
     */
    static final class a
    extends Enum<a>
    implements dv_1<Object> {
        @Override
        public final void a(Object instance) {
            ev_2.a(instance, "Cannot inject members into a null reference");
        }

        private static /* synthetic */ a[] a() {
            return new a[]{INSTANCE};
        }
    }
}


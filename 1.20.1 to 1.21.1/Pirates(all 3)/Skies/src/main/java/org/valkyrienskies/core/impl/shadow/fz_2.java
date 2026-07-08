/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fy_2;
import org.valkyrienskies.core.impl.shadow.jU;
import org.valkyrienskies.core.impl.shadow.jV;
import org.valkyrienskies.core.impl.shadow.jW;
import org.valkyrienskies.core.impl.shadow.jX;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fz
 */
public final class fz_2 {
    private static fy_2 a = jX.a(new jU());

    private fz_2() {
    }

    private static <E> fy_2<E> a(fy_2<E> fy_22) {
        return jW.a(fy_22);
    }

    private static <E> fy_2<E> b(fy_2<? extends E> fy_22) {
        return jX.a(fy_22);
    }

    private static <E> fy_2<E> a(fy_2<E> fy_22, ff_1<? super E> ff_12) {
        return jV.a(fy_22, ff_12);
    }

    private static <E> fy_2<E> a() {
        return a;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ListIterator;
import org.valkyrienskies.core.impl.shadow.fk_1;
import org.valkyrienskies.core.impl.shadow.hl_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hX
 */
public final class hx_1<E>
extends hl_1<E>
implements fk_1<E> {
    public static final hx_1 a;
    private static fk_1 b;

    public static <E> fk_1<E> a() {
        return a;
    }

    private static <E> ListIterator<E> b() {
        return b;
    }

    protected hx_1() {
    }

    static {
        b = a = new hx_1();
    }
}


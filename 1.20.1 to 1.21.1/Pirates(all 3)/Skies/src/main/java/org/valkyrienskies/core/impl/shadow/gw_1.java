/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.fg_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gW
 */
public final class gw_1<T>
implements Serializable,
fg_2<T> {
    private static final long a = 825802648423525485L;
    private static gw_1 b = new gw_1();
    private static int c = -1;

    public static <T> gw_1<T> a() {
        return b;
    }

    private gw_1() {
    }

    @Override
    public final boolean a(T t, T t2) {
        return t == t2 || t != null && t.equals(t2);
    }

    @Override
    public final int a(T t) {
        if (t == null) {
            return -1;
        }
        return t.hashCode();
    }

    private static gw_1 b() {
        return b;
    }
}


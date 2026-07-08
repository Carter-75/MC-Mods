/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.fq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hC
 */
public final class hc_1<T>
implements Serializable,
fq_1<T, String> {
    private static final long a = 7511110693171758606L;
    private static final fq_1<Object, String> b = new hc_1<Object>();

    public static <T> fq_1<T, String> a() {
        return b;
    }

    private hc_1() {
    }

    private static String b(T t) {
        return String.valueOf(t);
    }

    private static fq_1 b() {
        return b;
    }

    @Override
    public final /* synthetic */ Object a(Object object) {
        return String.valueOf(object);
    }
}


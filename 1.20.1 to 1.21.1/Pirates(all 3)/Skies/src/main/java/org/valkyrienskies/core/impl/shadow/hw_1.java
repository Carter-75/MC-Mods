/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.fj_1;
import org.valkyrienskies.core.impl.shadow.hl_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.hW
 */
public final class hw_1<E>
extends hl_1<E>
implements fj_1<E> {
    public static final hw_1 a;
    private static fj_1 b;

    public static <E> fj_1<E> a() {
        return a;
    }

    public static <E> Iterator<E> b() {
        return b;
    }

    protected hw_1() {
    }

    static {
        b = a = new hw_1();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.ew_1;
import org.valkyrienskies.core.impl.shadow.fn_1;
import org.valkyrienskies.core.impl.shadow.gd_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ge
 */
public final class ge_2<E>
extends gd_2<E>
implements fn_1<E> {
    private static final long b = 722374056718497858L;

    public static <E> ge_2<E> a(fn_1<E> fn_12) {
        return new ge_2<E>(fn_12);
    }

    private ge_2(fn_1<E> fn_12) {
        super(fn_12);
    }

    private ge_2(ew_1<E> ew_12, Object object) {
        super(ew_12, object);
    }

    private fn_1<E> f() {
        return (fn_1)this.e();
    }

    @Override
    public final synchronized E c() {
        Object object = this.a;
        synchronized (object) {
            ge_2 ge_22 = this;
            return ((fn_1)ge_22.e()).c();
        }
    }

    @Override
    public final synchronized E d() {
        Object object = this.a;
        synchronized (object) {
            ge_2 ge_22 = this;
            return ((fn_1)ge_22.e()).d();
        }
    }

    @Override
    public final synchronized Comparator<? super E> b() {
        Object object = this.a;
        synchronized (object) {
            ge_2 ge_22 = this;
            return ((fn_1)ge_22.e()).b();
        }
    }
}


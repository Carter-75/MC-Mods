/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.fn_1;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.gf_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gg
 */
public final class gg_2<E>
extends gf_2<E>
implements fn_1<E> {
    private static final long b = -251737742649401930L;

    public static <E> gg_2<E> a(fn_1<E> fn_12, fq_1<? super E, ? extends E> fq_12) {
        return new gg_2<E>(fn_12, fq_12);
    }

    private static <E> gg_2<E> b(fn_1<E> objectArray, fq_1<? super E, ? extends E> fq_12) {
        gg_2<E> gg_22 = new gg_2<E>(objectArray, fq_12);
        if (objectArray.size() > 0) {
            Object[] objectArray2 = objectArray.toArray();
            objectArray.clear();
            objectArray = objectArray2;
            int n2 = objectArray2.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = objectArray[i2];
                gg_22.f().add(fq_12.a(object));
            }
        }
        return gg_22;
    }

    private gg_2(fn_1<E> fn_12, fq_1<? super E, ? extends E> fq_12) {
        super(fn_12, fq_12);
    }

    private fn_1<E> e() {
        return (fn_1)this.f();
    }

    @Override
    public final E c() {
        gg_2 gg_22 = this;
        return ((fn_1)gg_22.f()).c();
    }

    @Override
    public final E d() {
        gg_2 gg_22 = this;
        return ((fn_1)gg_22.f()).d();
    }

    @Override
    public final Comparator<? super E> b() {
        gg_2 gg_22 = this;
        return ((fn_1)gg_22.f()).b();
    }
}


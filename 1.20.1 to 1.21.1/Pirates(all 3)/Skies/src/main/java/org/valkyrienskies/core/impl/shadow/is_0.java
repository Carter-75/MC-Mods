/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import org.valkyrienskies.core.impl.shadow.fh_2;
import org.valkyrienskies.core.impl.shadow.io_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iS
 */
public final class is_0<E>
extends io_1<E> {
    private static final long a = -1708388017160694542L;
    private final fh_2<? extends E> b;

    public static <E> is_0<E> a(List<E> list, fh_2<? extends E> fh_22) {
        return new is_0<E>(list, fh_22);
    }

    private is_0(List<E> list, fh_2<? extends E> fh_22) {
        super(list);
        if (fh_22 == null) {
            throw new IllegalArgumentException("Factory must not be null");
        }
        this.b = fh_22;
    }

    @Override
    public final E get(int index) {
        int n2 = this.c().size();
        if (index < n2) {
            Object e2 = this.c().get(index);
            if (e2 == null) {
                e2 = this.b.a();
                this.c().set(index, e2);
                return e2;
            }
            return e2;
        }
        while (n2 < index) {
            this.c().add(null);
            ++n2;
        }
        E e3 = this.b.a();
        this.c().add(e3);
        return e3;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final List<E> subList(int fromIndex, int toIndex) {
        void var2_3;
        void var1_1;
        List list = this.c().subList((int)var1_1, (int)var2_3);
        return new is_0<E>(list, this.b);
    }
}


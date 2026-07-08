/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.io_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iR
 */
public final class ir_0<E>
extends io_1<E> {
    private static final long a = -3620001881672L;

    private static <E> ir_0<E> a(List<E> list) {
        return new ir_0<E>(list);
    }

    public ir_0() {
        super(new ArrayList());
    }

    private ir_0(int n2) {
        super(new ArrayList(n2));
    }

    private ir_0(List<E> list) {
        super(list);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void add(int index, E element) {
        void var2_2;
        void var1_1;
        int n2 = this.c().size();
        if (index > n2) {
            this.c().addAll(Collections.nCopies(index - n2, null));
        }
        this.c().add((int)var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean addAll(int index, Collection<? extends E> coll) {
        void var2_2;
        void var1_1;
        int n2 = this.c().size();
        boolean bl = false;
        if (index > n2) {
            this.c().addAll(Collections.nCopies(index - n2, null));
            bl = true;
        }
        return this.c().addAll((int)var1_1, var2_2) | bl;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final E set(int index, E element) {
        void var2_2;
        void var1_1;
        int n2 = this.c().size();
        if (index >= n2) {
            this.c().addAll(Collections.nCopies(index - n2 + 1, null));
        }
        return this.c().set((int)var1_1, var2_2);
    }
}


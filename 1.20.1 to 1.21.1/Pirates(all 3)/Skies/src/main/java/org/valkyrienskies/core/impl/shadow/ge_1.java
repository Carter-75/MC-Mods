/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Comparator;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gE
 */
public final class ge_1<E extends Comparable<? super E>>
implements Serializable,
Comparator<E> {
    private static final long a = -291439688585137865L;
    private static ge_1 b = new ge_1();

    public static <E extends Comparable<? super E>> ge_1<E> a() {
        return b;
    }

    private static int a(E e2, E e3) {
        return e2.compareTo(e3);
    }

    public final int hashCode() {
        return "ComparableComparator".hashCode();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean equals(Object object) {
        void var1_1;
        return this == object || object != null && var1_1.getClass().equals(this.getClass());
    }

    @Override
    public final /* synthetic */ int compare(Object object, Object object2) {
        object2 = (Comparable)object2;
        object = (Comparable)object;
        return object.compareTo(object2);
    }
}


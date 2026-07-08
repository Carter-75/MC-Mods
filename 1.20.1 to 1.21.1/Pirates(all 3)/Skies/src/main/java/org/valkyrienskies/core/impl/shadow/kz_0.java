/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.ga_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.kz
 */
public class kz_0<E>
extends ga_1<E>
implements Set<E> {
    private static final long b = 306127383500410386L;

    public static <E> kz_0<E> a(Set<E> set, fq_1<? super E, ? extends E> fq_12) {
        return new kz_0<E>(set, fq_12);
    }

    private static <E> Set<E> b(Set<E> objectArray, fq_1<? super E, ? extends E> fq_12) {
        kz_0<E> kz_02 = new kz_0<E>(objectArray, fq_12);
        if (objectArray.size() > 0) {
            Object[] objectArray2 = objectArray.toArray();
            objectArray.clear();
            objectArray = objectArray2;
            int n2 = objectArray2.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = objectArray[i2];
                kz_02.f().add(fq_12.a(object));
            }
        }
        return kz_02;
    }

    protected kz_0(Set<E> set, fq_1<? super E, ? extends E> fq_12) {
        super(set, fq_12);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean equals(Object object) {
        void var1_1;
        return object == this || this.f().equals(var1_1);
    }

    @Override
    public int hashCode() {
        return this.f().hashCode();
    }
}


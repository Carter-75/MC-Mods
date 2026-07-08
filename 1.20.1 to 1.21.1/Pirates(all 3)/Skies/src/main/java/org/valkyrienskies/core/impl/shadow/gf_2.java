/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ew_1;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.ga_1;
import org.valkyrienskies.core.impl.shadow.kz_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gf
 */
public class gf_2<E>
extends ga_1<E>
implements ew_1<E> {
    private static final long b = 5421170911299074185L;

    public static <E> ew_1<E> a(ew_1<E> ew_12, fq_1<? super E, ? extends E> fq_12) {
        return new gf_2<E>(ew_12, fq_12);
    }

    private static <E> ew_1<E> b(ew_1<E> objectArray, fq_1<? super E, ? extends E> fq_12) {
        gf_2<E> gf_22 = new gf_2<E>(objectArray, fq_12);
        if (objectArray.size() > 0) {
            Object[] objectArray2 = objectArray.toArray();
            objectArray.clear();
            objectArray = objectArray2;
            int n2 = objectArray2.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = objectArray[i2];
                gf_22.f().add(fq_12.a(object));
            }
        }
        return gf_22;
    }

    protected gf_2(ew_1<E> ew_12, fq_1<? super E, ? extends E> fq_12) {
        super(ew_12, fq_12);
    }

    private ew_1<E> b() {
        return (ew_1)this.f();
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

    @Override
    public final int a(Object object) {
        gf_2 gf_22 = this;
        return ((ew_1)gf_22.f()).a(object);
    }

    @Override
    public final boolean b(Object object, int n2) {
        gf_2 gf_22 = this;
        return ((ew_1)gf_22.f()).b(object, n2);
    }

    @Override
    public final boolean a(E e2, int n2) {
        gf_2 gf_22 = this;
        return ((ew_1)gf_22.f()).a(this.b(e2), n2);
    }

    @Override
    public final Set<E> a() {
        Collection<E> collection = this;
        collection = ((ew_1)collection.f()).a();
        return kz_0.a(collection, this.a);
    }
}


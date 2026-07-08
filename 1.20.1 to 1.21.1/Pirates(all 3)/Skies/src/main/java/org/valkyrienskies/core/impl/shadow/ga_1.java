/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.gv_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gA
 */
public class ga_1<E>
extends gv_2<E> {
    private static final long b = 8692300188161871514L;
    protected final fq_1<? super E, ? extends E> a;

    public static <E> ga_1<E> a(Collection<E> collection, fq_1<? super E, ? extends E> fq_12) {
        return new ga_1<E>(collection, fq_12);
    }

    private static <E> ga_1<E> b(Collection<E> objectArray, fq_1<? super E, ? extends E> fq_12) {
        ga_1<E> ga_12 = new ga_1<E>(objectArray, fq_12);
        if (objectArray.size() > 0) {
            Object[] objectArray2 = objectArray.toArray();
            objectArray.clear();
            objectArray = objectArray2;
            int n2 = objectArray2.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object = objectArray[i2];
                ga_12.f().add(fq_12.a(object));
            }
        }
        return ga_12;
    }

    public ga_1(Collection<E> collection, fq_1<? super E, ? extends E> fq_12) {
        super(collection);
        if (fq_12 == null) {
            throw new NullPointerException("Transformer must not be null");
        }
        this.a = fq_12;
    }

    public final E b(E e2) {
        return this.a.a(e2);
    }

    protected final Collection<E> b(Collection<? extends E> object) {
        ArrayList arrayList = new ArrayList(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            arrayList.add(this.b(e2));
        }
        return arrayList;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean add(E object) {
        void var1_1;
        return this.f().add(this.b(var1_1));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean addAll(Collection<? extends E> coll) {
        void var1_1;
        return this.f().addAll(this.b((Collection<? extends E>)var1_1));
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.ew_1;
import org.valkyrienskies.core.impl.shadow.fv_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fY
 */
public final class fy_1<E>
extends fv_1<E> {
    private static final long a = -2560033712679053143L;

    public static <E> ew_1<E> a(ew_1<E> ew_12) {
        return new fy_1<E>(ew_12);
    }

    private fy_1(ew_1<E> ew_12) {
        super(ew_12);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.e());
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a((Collection)objectInputStream.readObject());
    }

    @Override
    public final boolean containsAll(Collection<?> coll) {
        Iterator<?> iterator2 = coll.iterator();
        while (iterator2.hasNext()) {
            if (this.contains(iterator2.next())) continue;
            return false;
        }
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean add(E object) {
        void var1_1;
        return ((fv_1)this).a(var1_1, 1);
    }

    @Override
    public final boolean addAll(Collection<? extends E> coll) {
        Iterator iterator2;
        boolean bl = false;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            boolean bl2 = ((fv_1)this).a(iterator2.next(), 1);
            bl = bl || bl2;
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean remove(Object object) {
        void var1_1;
        return this.b(var1_1, 1);
    }

    @Override
    public final boolean removeAll(Collection<?> coll) {
        if (coll != null) {
            Iterator iterator2;
            boolean bl = false;
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                Object e2 = iterator2.next();
                boolean bl2 = this.b(e2, this.a(e2));
                bl = bl || bl2;
            }
            return bl;
        }
        return this.e().removeAll(null);
    }

    @Override
    public final boolean retainAll(Collection<?> coll) {
        if (coll != null) {
            boolean bl = false;
            Iterator iterator2 = this.iterator();
            while (iterator2.hasNext()) {
                if (coll.contains(iterator2.next())) continue;
                iterator2.remove();
                bl = true;
            }
            return bl;
        }
        return this.e().retainAll(null);
    }

    @Override
    public final boolean a(E e2, int n2) {
        this.e().a(e2, n2);
        return true;
    }
}


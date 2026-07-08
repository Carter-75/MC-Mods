/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.fw_2;
import org.valkyrienskies.core.impl.shadow.gv_2;
import org.valkyrienskies.core.impl.shadow.jv_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gx
 */
public final class gx_2<K, C>
extends gv_2<C> {
    private static final long a = -5512610452568370038L;
    private final fq_1<C, K> b;
    private final fw_2<K, C> c;
    private final boolean d;

    private static <K, C> gx_2<K, C> a(Collection<C> collection, fq_1<C, K> fq_12) {
        return new gx_2<K, C>(collection, fq_12, jv_0.a(new HashMap()), true);
    }

    private static <K, C> gx_2<K, C> b(Collection<C> collection, fq_1<C, K> fq_12) {
        return new gx_2<K, C>(collection, fq_12, jv_0.a(new HashMap()), false);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private gx_2(Collection collection, fq_1 fq_12, jv_0 jv_02, boolean bl) {
        super(collection);
        this.b = fq_12;
        this.c = jv_02;
        this.d = bl;
        this.a();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean add(C object) {
        boolean bl = super.add(object);
        if (bl) {
            void var1_1;
            this.c(var1_1);
        }
        return bl;
    }

    @Override
    public final boolean addAll(Collection<? extends C> coll) {
        Iterator iterator2;
        boolean bl = false;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object e2 = iterator2.next();
            bl |= ((gv_2)this).add(e2);
        }
        return bl;
    }

    @Override
    public final void clear() {
        super.clear();
        this.c.clear();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean contains(Object object) {
        void var1_1;
        return this.c.containsKey(this.b.a(var1_1));
    }

    @Override
    public final boolean containsAll(Collection<?> coll) {
        for (Object obj : coll) {
            if (((gv_2)this).contains(obj)) continue;
            return false;
        }
        return true;
    }

    private C a(K object) {
        if ((object = (Collection)this.c.get(object)) == null) {
            return null;
        }
        return (C)object.iterator().next();
    }

    private Collection<C> b(K k2) {
        return (Collection)this.c.get(k2);
    }

    private void a() {
        this.c.clear();
        for (Object e2 : this.f()) {
            this.c(e2);
        }
    }

    @Override
    public final boolean remove(Object object) {
        boolean bl = super.remove(object);
        if (bl) {
            gx_2 gx_22;
            void var3_3 = gx_22;
            gx_22 = this;
            gx_22.c.remove(gx_22.b.a(var3_3));
        }
        return bl;
    }

    @Override
    public final boolean removeAll(Collection<?> coll) {
        Iterator iterator2;
        boolean bl = false;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object e2 = iterator2.next();
            bl |= ((gv_2)this).remove(e2);
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean retainAll(Collection<?> coll) {
        void var1_1;
        boolean bl = super.retainAll((Collection<?>)var1_1);
        if (bl) {
            this.a();
        }
        return bl;
    }

    private void c(C c2) {
        K k2 = this.b.a(c2);
        if (this.d && this.c.containsKey(k2)) {
            throw new IllegalArgumentException("Duplicate key in uniquely indexed collection.");
        }
        this.c.put(k2, (Object)c2);
    }

    private void d(C c2) {
        this.c.remove(this.b.a(c2));
    }
}


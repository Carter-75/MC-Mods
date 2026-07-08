/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ew_1;
import org.valkyrienskies.core.impl.shadow.gz_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gd
 */
public class gd_2<E>
extends gz_2<E>
implements ew_1<E> {
    private static final long b = 8084674570753837109L;

    public static <E> gd_2<E> a(ew_1<E> ew_12) {
        return new gd_2<E>(ew_12);
    }

    protected gd_2(ew_1<E> ew_12) {
        super(ew_12);
    }

    protected gd_2(ew_1<E> ew_12, Object object) {
        super(ew_12, object);
    }

    private ew_1<E> b() {
        return (ew_1)this.e();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        Object object2 = this.a;
        synchronized (object2) {
            void var1_1;
            gd_2 gd_22 = this;
            return ((ew_1)gd_22.e()).equals(var1_1);
        }
    }

    @Override
    public int hashCode() {
        Object object = this.a;
        synchronized (object) {
            gd_2 gd_22 = this;
            return ((ew_1)gd_22.e()).hashCode();
        }
    }

    @Override
    public final boolean a(E e2, int n2) {
        Object object = this.a;
        synchronized (object) {
            gd_2 gd_22 = this;
            return ((ew_1)gd_22.e()).a(e2, n2);
        }
    }

    @Override
    public final boolean b(Object object, int n2) {
        Object object2 = this.a;
        synchronized (object2) {
            gd_2 gd_22 = this;
            return ((ew_1)gd_22.e()).b(object, n2);
        }
    }

    @Override
    public final Set<E> a() {
        Object object = this.a;
        synchronized (object) {
            Collection<E> collection = this;
            collection = ((ew_1)collection.e()).a();
            return new a(this, collection, this.a);
        }
    }

    @Override
    public final int a(Object object) {
        Object object2 = this.a;
        synchronized (object2) {
            gd_2 gd_22 = this;
            return ((ew_1)gd_22.e()).a(object);
        }
    }

    final class a
    extends gz_2<E>
    implements Set<E> {
        private static final long b = 2990565892366827855L;
        private /* synthetic */ gd_2 c;

        a(gd_2 gd_22, Set<E> set, Object object) {
            this.c = gd_22;
            super(set, object);
        }
    }
}


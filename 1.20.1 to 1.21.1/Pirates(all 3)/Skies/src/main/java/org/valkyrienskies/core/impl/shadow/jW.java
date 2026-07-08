/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.fy
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fy;
import org.valkyrienskies.core.impl.shadow.fy_2;
import org.valkyrienskies.core.impl.shadow.gz_2;

public final class jW<E>
extends gz_2<E>
implements fy_2<E> {
    private static final long b = 20150629L;

    public static <E> jW<E> a(fy_2<E> fy_22) {
        return new jW<E>(fy_22);
    }

    private jW(fy_2<E> fy_22) {
        super(fy_22);
    }

    private jW(fy_2<E> fy_22, Object object) {
        super(fy_22, object);
    }

    private fy_2<E> c() {
        return (fy)super.e();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        Object object2 = this.a;
        synchronized (object2) {
            void var1_1;
            jW jW2 = this;
            return ((fy)super.e()).equals((Object)var1_1);
        }
    }

    @Override
    public final int hashCode() {
        Object object = this.a;
        synchronized (object) {
            jW jW2 = this;
            return ((fy)super.e()).hashCode();
        }
    }

    @Override
    public final int b(E e2, int n2) {
        Object object = this.a;
        synchronized (object) {
            jW jW2 = this;
            return ((fy)super.e()).b(e2, n2);
        }
    }

    @Override
    public final int c(Object object, int n2) {
        Object object2 = this.a;
        synchronized (object2) {
            jW jW2 = this;
            return ((fy)super.e()).c(object, n2);
        }
    }

    @Override
    public final int a(Object object) {
        Object object2 = this.a;
        synchronized (object2) {
            jW jW2 = this;
            return ((fy)super.e()).a(object);
        }
    }

    @Override
    public final int a(E e2, int n2) {
        Object object = this.a;
        synchronized (object) {
            jW jW2 = this;
            return ((fy)super.e()).a(e2, n2);
        }
    }

    @Override
    public final Set<E> a() {
        Object object = this.a;
        synchronized (object) {
            Collection<E> collection = this;
            collection = ((fy)super.e()).a();
            return new a(collection, this.a);
        }
    }

    @Override
    public final Set<fy_2.a_0<E>> b() {
        Object object = this.a;
        synchronized (object) {
            Collection<E> collection = this;
            collection = ((fy)super.e()).b();
            return new a<fy_2.a_0<E>>(collection, this.a);
        }
    }

    static final class a<T>
    extends gz_2<T>
    implements Set<T> {
        private static final long b = 20150629L;

        a(Set<T> set, Object object) {
            super(set, object);
        }
    }
}


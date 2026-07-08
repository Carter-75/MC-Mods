/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.fy
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fy;
import org.valkyrienskies.core.impl.shadow.fy_2;
import org.valkyrienskies.core.impl.shadow.gy_2;

public final class jV<E>
extends gy_2<E>
implements fy_2<E> {
    private static final long b = 20150629L;

    public static <E> jV<E> a(fy_2<E> fy_22, ff_1<? super E> ff_12) {
        return new jV<E>(fy_22, ff_12);
    }

    private jV(fy_2<E> fy_22, ff_1<? super E> ff_12) {
        super(fy_22, ff_12);
    }

    private fy_2<E> c() {
        return (fy)super.f();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean equals(Object object) {
        void var1_1;
        jV jV2;
        return object == this || ((fy)super.f()).equals((Object)var1_1);
    }

    @Override
    public final int hashCode() {
        jV jV2 = this;
        return ((fy)super.f()).hashCode();
    }

    @Override
    public final int b(E e2, int n2) {
        this.b(e2);
        jV jV2 = this;
        return ((fy)super.f()).b(e2, n2);
    }

    @Override
    public final int c(Object object, int n2) {
        jV jV2 = this;
        return ((fy)super.f()).c(object, n2);
    }

    @Override
    public final int a(Object object) {
        jV jV2 = this;
        return ((fy)super.f()).a(object);
    }

    @Override
    public final int a(E e2, int n2) {
        this.b(e2);
        jV jV2 = this;
        return ((fy)super.f()).a(e2, n2);
    }

    @Override
    public final Set<E> a() {
        jV jV2 = this;
        return ((fy)super.f()).a();
    }

    @Override
    public final Set<fy_2.a_0<E>> b() {
        jV jV2 = this;
        return ((fy)super.f()).b();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.fy
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fy;
import org.valkyrienskies.core.impl.shadow.fy_2;
import org.valkyrienskies.core.impl.shadow.gv_2;

public abstract class jT<E>
extends gv_2<E>
implements fy_2<E> {
    private static final long a = 20150610L;

    protected jT() {
    }

    protected jT(fy_2<E> fy_22) {
        super(fy_22);
    }

    protected final fy_2<E> c() {
        return (fy)super.f();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean equals(Object object) {
        void var1_1;
        jT jT2;
        return object == this || ((fy)super.f()).equals((Object)var1_1);
    }

    @Override
    public int hashCode() {
        jT jT2 = this;
        return ((fy)super.f()).hashCode();
    }

    @Override
    public final int a(Object object) {
        jT jT2 = this;
        return ((fy)super.f()).a(object);
    }

    @Override
    public int a(E e2, int n2) {
        jT jT2 = this;
        return ((fy)super.f()).a(e2, n2);
    }

    @Override
    public int b(E e2, int n2) {
        jT jT2 = this;
        return ((fy)super.f()).b(e2, n2);
    }

    @Override
    public int c(Object object, int n2) {
        jT jT2 = this;
        return ((fy)super.f()).c(object, n2);
    }

    @Override
    public Set<E> a() {
        jT jT2 = this;
        return ((fy)super.f()).a();
    }

    @Override
    public Set<fy_2.a_0<E>> b() {
        jT jT2 = this;
        return ((fy)super.f()).b();
    }
}


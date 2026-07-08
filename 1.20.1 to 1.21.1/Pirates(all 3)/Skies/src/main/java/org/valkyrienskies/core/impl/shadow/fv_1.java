/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ew_1;
import org.valkyrienskies.core.impl.shadow.gv_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fV
 */
public abstract class fv_1<E>
extends gv_2<E>
implements ew_1<E> {
    private static final long a = -3768146017343785417L;

    protected fv_1() {
    }

    protected fv_1(ew_1<E> ew_12) {
        super(ew_12);
    }

    protected ew_1<E> e() {
        return (ew_1)super.f();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean equals(Object object) {
        void var1_1;
        return object == this || this.e().equals(var1_1);
    }

    @Override
    public int hashCode() {
        return this.e().hashCode();
    }

    @Override
    public final int a(Object object) {
        return this.e().a(object);
    }

    @Override
    public boolean a(E e2, int n2) {
        return this.e().a(e2, n2);
    }

    @Override
    public boolean b(Object object, int n2) {
        return this.e().b(object, n2);
    }

    @Override
    public Set<E> a() {
        return this.e().a();
    }

    @Override
    public /* synthetic */ Collection f() {
        return this.e();
    }
}


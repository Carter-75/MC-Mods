/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ew_1;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.gy_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gb
 */
public class gb_2<E>
extends gy_2<E>
implements ew_1<E> {
    private static final long b = -2575833140344736876L;

    public static <E> gb_2<E> a(ew_1<E> ew_12, ff_1<? super E> ff_12) {
        return new gb_2<E>(ew_12, ff_12);
    }

    protected gb_2(ew_1<E> ew_12, ff_1<? super E> ff_12) {
        super(ew_12, ff_12);
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
    public final boolean a(E e2, int n2) {
        this.b(e2);
        return this.e().a(e2, n2);
    }

    @Override
    public final boolean b(Object object, int n2) {
        return this.e().b(object, n2);
    }

    @Override
    public final Set<E> a() {
        return this.e().a();
    }

    @Override
    public final int a(Object object) {
        return this.e().a(object);
    }

    @Override
    public /* synthetic */ Collection f() {
        return this.e();
    }
}


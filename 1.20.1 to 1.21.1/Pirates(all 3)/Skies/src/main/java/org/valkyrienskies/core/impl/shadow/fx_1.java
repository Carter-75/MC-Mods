/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.fn_1;
import org.valkyrienskies.core.impl.shadow.fv_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fX
 */
public abstract class fx_1<E>
extends fv_1<E>
implements fn_1<E> {
    private static final long a = -8223473624050467718L;

    protected fx_1() {
    }

    protected fx_1(fn_1<E> fn_12) {
        super(fn_12);
    }

    protected final fn_1<E> g() {
        return (fn_1)super.e();
    }

    @Override
    public final E c() {
        fx_1 fx_12 = this;
        return ((fn_1)super.e()).c();
    }

    @Override
    public final E d() {
        fx_1 fx_12 = this;
        return ((fn_1)super.e()).d();
    }

    @Override
    public final Comparator<? super E> b() {
        fx_1 fx_12 = this;
        return ((fn_1)super.e()).b();
    }

    @Override
    public final /* synthetic */ Collection f() {
        fx_1 fx_12 = this;
        return (fn_1)super.e();
    }
}


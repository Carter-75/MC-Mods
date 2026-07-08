/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.rX;
import org.valkyrienskies.core.impl.shadow.sa_0;
import org.valkyrienskies.core.impl.shadow.sb_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
final class rT<S extends qN> {
    sb_0<S> a = null;
    sb_0<S> b = null;
    final rX<S> c = new rX();
    final rX<S> d = new rX();

    rT(rM<S> rM2, sb_0<S> sb_02) {
        this.a(rM2, sb_02, new ArrayList<rM<S>>());
    }

    private void a(rM<S> rM2, sb_0<S> sb_02, List<rM<S>> list) {
        Object object = rM2;
        if (((rM)object).a == null) {
            object = rM2;
            boolean bl = (Boolean)((rM)object).e;
            if (!bl) {
                this.a(sb_02, list);
                return;
            }
        } else {
            object = rM2;
            Object object2 = ((rM)object).a.c();
            object2 = sb_02.a((rV)object2);
            switch (1.a[((sb_0.a)object2).c() - 1]) {
                case 1: {
                    object = rM2;
                    this.a(((rM)object).b, sb_02, list);
                    return;
                }
                case 2: {
                    object = rM2;
                    this.a(((rM)object).c, sb_02, list);
                    return;
                }
                case 3: {
                    list.add(rM2);
                    rM<S> rM3 = rM2;
                    object = rM3;
                    object = object2;
                    this.a(rM3.b, ((sb_0.a)object).a, list);
                    rM<S> rM4 = rM2;
                    object = rM4;
                    object = object2;
                    this.a(rM4.c, ((sb_0.a)object).b, list);
                    List<rM<S>> list2 = list;
                    list2.remove(list2.size() - 1);
                    return;
                }
            }
            throw new oY();
        }
        this.b(sb_02, list);
    }

    private void a(sb_0<S> sb_02, List<rM<S>> list) {
        this.a = this.a == null ? sb_02 : this.a.a(sb_02);
        this.c.a(list);
    }

    private void b(sb_0<S> sb_02, List<rM<S>> list) {
        this.b = this.b == null ? sb_02 : this.b.a(sb_02);
        this.d.a(list);
    }

    public final boolean a() {
        return this.a != null && !this.a.b();
    }

    public final sb_0<S> b() {
        return this.a;
    }

    public final rX<S> c() {
        return this.c;
    }

    public final boolean d() {
        return this.b != null && !this.b.b();
    }

    public final sb_0<S> e() {
        return this.b;
    }

    public final rX<S> f() {
        return this.d;
    }

    static final class 1 {
        static final /* synthetic */ int[] a;

        static {
            a = new int[sa_0.values$65ac40a5().length];
            try {
                1.a[sa_0.PLUS$7c70dd6b - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[sa_0.MINUS$7c70dd6b - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[sa_0.BOTH$7c70dd6b - 1] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }
}


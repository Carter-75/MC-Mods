/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.HashMap;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.rK;
import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rN;
import org.valkyrienskies.core.impl.shadow.rO;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.rX;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.sa_0;
import org.valkyrienskies.core.impl.shadow.sb_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class rZ<S extends qN> {
    final c a = new c(this, 0);

    public final rY<S> a(rV<S> ... rVArray) {
        if (rVArray.length == 0) {
            return null;
        }
        rK rK2 = rVArray[0].e();
        rM rM2 = rK2.a(false);
        rV<S> rV2 = Boolean.TRUE;
        rM rM3 = rM2;
        rM2.e = rV2;
        rV<S>[] rVArray2 = rVArray;
        int n2 = rVArray.length;
        block4: for (int i2 = 0; i2 < n2; ++i2) {
            rV2 = rVArray2[i2];
            if (rM2.a(rV2)) {
                rV2 = null;
                rM3 = rM2;
                rM2.e = rV2;
                rM3 = rM2;
                rV2 = Boolean.FALSE;
                rM3 = rM3.b;
                rM3.b.e = rV2;
                rM3 = rM2;
                rM2 = rM3.c;
                rV2 = Boolean.TRUE;
                rM3 = rM2;
                rM2.e = rV2;
                continue;
            }
            sb_0<Object> sb_02 = rV2.f();
            rM rM4 = rM2;
            while (true) {
                rM3 = rM4;
                if (rM3.d == null || sb_02 == null) continue block4;
                rM3 = rM4;
                rM3 = rM3.d;
                rM3 = rM3.a.c();
                sb_0.a a2 = sb_02.a((rV)((Object)rM3));
                switch (1.a[a2.c() - 1]) {
                    case 1: {
                        if (rV2.a((rV<S>)((Object)rM3))) break;
                        return this.a(rVArray[0].e());
                    }
                    case 2: {
                        throw new oV(px_0.NOT_CONVEX_HYPERPLANES, new Object[0]);
                    }
                    default: {
                        rM3 = a2;
                        sb_02 = ((sb_0.a)((Object)rM3)).b;
                    }
                }
                rM3 = rM4;
                rM4 = rM3.d;
            }
        }
        return rK2;
    }

    public final rY<S> a(rY<S> rY2, rY<S> object) {
        object = rY2.a(false).a(object.a(false), new d(this, 0));
        ((rM)object).a(this.a);
        return rY2.b((rM)object);
    }

    public final rY<S> b(rY<S> rY2, rY<S> object) {
        object = rY2.a(false).a(object.a(false), new b(this, 0));
        ((rM)object).a(this.a);
        return rY2.b((rM)object);
    }

    private rY<S> c(rY<S> rY2, rY<S> object) {
        object = rY2.a(false).a(object.a(false), new f(this, 0));
        ((rM)object).a(this.a);
        return rY2.b((rM)object);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final rY a(rY rY2, rK object) {
        object = rY2.a(false).a(object.a(false), new a(this, rY2, object));
        ((rM)object).a(this.a);
        return rY2.b((rM)object);
    }

    public final rY<S> a(rY<S> rY2) {
        return rY2.b(this.a(rY2.a(false)));
    }

    rM<S> a(rM<S> rM2) {
        HashMap<rM<S>, rM<S>> hashMap = new HashMap<rM<S>, rM<S>>();
        rM2 = this.a(rM2, hashMap);
        for (Map.Entry entry : hashMap.entrySet()) {
            Object object = (rM)entry.getKey();
            if (((rM)object).a == null) continue;
            object = (rM)entry.getKey();
            rO rO2 = (rO)((rM)object).e;
            if (rO2 == null) continue;
            object = (rM)entry.getValue();
            rO rO3 = (rO)((rM)object).e;
            object = rO2;
            for (rM rM3 : ((rO)object).c) {
                object = rO3;
                ((rO)object).c.a((rM)hashMap.get(rM3));
            }
        }
        return rM2;
    }

    private rM<S> a(rM<S> rM2, Map<rM<S>, rM<S>> map2) {
        Object object;
        rM<S> rM3 = rM2;
        if (rM3.a == null) {
            rM3 = rM2;
            object = new rM((Boolean)rM3.e != false ? Boolean.FALSE : Boolean.TRUE);
        } else {
            rM3 = rM2;
            object = (rO)rM3.e;
            if (object != null) {
                rL rL2;
                rL rL3;
                rM3 = object;
                if (((rO)((Object)rM3)).b == null) {
                    rL3 = null;
                } else {
                    rM3 = object;
                    rL3 = ((rO)((Object)rM3)).b.e();
                }
                rL rL4 = rL3;
                rM3 = object;
                if (((rO)((Object)rM3)).a == null) {
                    rL2 = null;
                } else {
                    rM3 = object;
                    rL2 = ((rO)((Object)rM3)).a.e();
                }
                object = rL2;
                object = new rO(rL4, object, new rX());
            }
            rM<S> rM4 = rM2;
            rM3 = rM4;
            rM<S> rM5 = rM2;
            rM3 = rM5;
            rM3 = rM2;
            object = new rM(rM4.a.e(), this.a(rM5.b, map2), this.a(rM3.c, map2), object);
        }
        map2.put(rM2, (rM<S>)object);
        return object;
    }

    static /* synthetic */ rM a(rZ rZ2, rM rM2) {
        return rZ2.a(rM2);
    }

    static final class 1 {
        static final /* synthetic */ int[] a;

        static {
            a = new int[sa_0.values$65ac40a5().length];
            try {
                1.a[sa_0.HYPER$7c70dd6b - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[sa_0.PLUS$7c70dd6b - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    final class e
    implements rM.b<S> {
        private final boolean a;
        private /* synthetic */ rZ b;

        e(rZ rZ2, boolean bl) {
            this.b = rZ2;
            this.a = bl;
        }

        @Override
        public final rM<S> a(rM<S> rM2) {
            rM rM3;
            rM rM4 = rM2;
            rM4 = rM4.b;
            rM4 = rM2;
            rM4 = rM4.c;
            if (rM3.e.equals(rM4.e)) {
                rM4 = rM2;
                rM4 = rM4.b;
                return new rM(rM4.e);
            }
            return new rM(this.a);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    final class c
    implements rN<S> {
        private /* synthetic */ rZ a;

        private c(rZ rZ2) {
            this.a = rZ2;
        }

        @Override
        public final int a(rM<S> rM2) {
            return rN.a.PLUS_SUB_MINUS$672d2271;
        }

        @Override
        public final void b(rM<S> rM2) {
            Object var2_2 = null;
            v0.e = var2_2;
        }

        @Override
        public final void c(rM<S> rM2) {
        }

        /* synthetic */ c(rZ rZ2, byte by) {
            this(rZ2);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    final class a
    implements rM.a<S>,
    rM.b<S> {
        private final rY<S> a;
        private final rY<S> b;
        private /* synthetic */ rZ c;

        a(rZ rZ2, rY<S> rY2, rY<S> rY3) {
            this.c = rZ2;
            this.a = rY2.i();
            this.b = rY3.i();
        }

        @Override
        public final rM<S> a(rM<S> rM2, rM<S> rM3, rM<S> rM4, boolean bl, boolean bl2) {
            Object object = rM2;
            if (((Boolean)((rM)object).e).booleanValue()) {
                rM2 = bl2 ? rM3 : rM2;
                object = this.c;
                rM2 = ((rZ)object).a(rM2);
                rM2.a(rM4, bl, this);
                return rM2;
            }
            rM2 = bl2 ? rM2 : rM3;
            rM2.a(rM4, bl, this);
            return rM2;
        }

        @Override
        public final rM<S> a(rM<S> qM2) {
            qM2 = ((rM)((Object)qM2)).a(Boolean.TRUE, Boolean.FALSE, null);
            qM2 = this.a.b((rM)((Object)qM2));
            return new rM(this.a.b(qM2 = qM2.h()) == rY.a.INSIDE$3ad793e5 && this.b.b(qM2) == rY.a.OUTSIDE$3ad793e5);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    final class f
    implements rM.a<S> {
        private /* synthetic */ rZ a;

        private f(rZ rZ2) {
            this.a = rZ2;
        }

        @Override
        public final rM<S> a(rM<S> object, rM<S> rM2, rM<S> rM3, boolean bl, boolean bl2) {
            if (((Boolean)((rM)object).e).booleanValue()) {
                object = this.a;
                rM2 = ((rZ)object).a(rM2);
            }
            rM2.a(rM3, bl, new e(this.a, true));
            return rM2;
        }

        /* synthetic */ f(rZ rZ2, byte by) {
            this(rZ2);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    final class b
    implements rM.a<S> {
        private /* synthetic */ rZ a;

        private b(rZ rZ2) {
            this.a = rZ2;
        }

        @Override
        public final rM<S> a(rM<S> rM2, rM<S> rM3, rM<S> rM4, boolean bl, boolean bl2) {
            rM rM5 = rM2;
            if (((Boolean)rM5.e).booleanValue()) {
                rM3.a(rM4, bl, new e(this.a, true));
                return rM3;
            }
            rM2.a(rM4, bl, new e(this.a, false));
            return rM2;
        }

        /* synthetic */ b(rZ rZ2, byte by) {
            this(rZ2);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    final class d
    implements rM.a<S> {
        private /* synthetic */ rZ a;

        private d(rZ rZ2) {
            this.a = rZ2;
        }

        @Override
        public final rM<S> a(rM<S> rM2, rM<S> rM3, rM<S> rM4, boolean bl, boolean bl2) {
            rM rM5 = rM2;
            if (((Boolean)rM5.e).booleanValue()) {
                rM2.a(rM4, bl, new e(this.a, true));
                return rM2;
            }
            rM3.a(rM4, bl, new e(this.a, false));
            return rM3;
        }

        /* synthetic */ d(rZ rZ2, byte by) {
            this(rZ2);
        }
    }
}


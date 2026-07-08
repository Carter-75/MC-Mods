/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cb_0;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.kX;
import org.valkyrienskies.core.impl.shadow.kY;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.pO;
import org.valkyrienskies.core.impl.shadow.pP;
import org.valkyrienskies.core.impl.shadow.pS;
import org.valkyrienskies.core.impl.shadow.pW;
import org.valkyrienskies.core.impl.shadow.pY;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qa_0;
import org.valkyrienskies.core.impl.shadow.qb_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sM;
import org.valkyrienskies.core.impl.shadow.sN;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.wG;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wR;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class pU {
    private pU() {
    }

    public static pW a(pY object, tu_0 tu_02, tu_0 tu_03, tq_0 tq_02, wK<pW.a> wK2, int n2, int n3, boolean bl, qa_0 qa_02) {
        object = new a((pY)object, tu_02, tu_03, wK2, n2, n3, bl, qa_02);
        if (tq_02 != null) {
            return pU.a((pW)object, tq_02);
        }
        return object;
    }

    private static pW a(pY pY2, tu_0 tu_02, tu_0 tu_03, wK<pW.a> wK2, int n2, int n3) {
        return pU.a(pY2, tu_02, tu_03, null, wK2, n2, n3, false, null);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private static pW a(pY pY2, sA sA2, sA sA3, tq_0 tq_02, wK wK2, int n2, int n3) {
        return pU.a(pU.a(pY2, (tu_0)((Object)sA2), (tu_0)((Object)sA3), null, wK2, n2, n3, false, null), tq_02);
    }

    private static pW a(kY object, kX object2, double[] object3, double[] object4, tq_0 object5, wK<pW.a> wK2, int n2, int n3) {
        b b2 = pU.a((kY)object, (kX)object2);
        sA sA2 = new sA((double[])object3, false);
        sA sA3 = new sA((double[])object4, false);
        tq_0 tq_02 = object5;
        int n4 = n2;
        n2 = n3;
        int n5 = n4;
        object5 = wK2;
        object4 = tq_02;
        object3 = sA3;
        object2 = sA2;
        object = b2;
        object = b2;
        return pU.a(pU.a(b2, (tu_0)object2, (tu_0)object3, null, (wK<pW.a>)object5, n5, n2, false, null), (tq_0)object4);
    }

    private static 1 a(pW pW2, tq_0 tq_02) {
        tq_02 = pU.a(tq_02);
        return new pS(pW2, tq_02){
            private /* synthetic */ tq_0 a;
            {
                this.a = tq_02;
                super(pW2);
            }

            public final pW.a a(tu_0 tu_02) {
                return new pP(super.a(tu_02), this.a);
            }
        };
    }

    private static pW a(pW pW2, tu_0 tu_02) {
        return pU.a(pW2, new sM(tu_02.g()));
    }

    private static 2 a(pW pW2, cb_0 cb_02) {
        return new pS(pW2, cb_02){
            private /* synthetic */ cb_0 a;
            {
                this.a = cb_02;
                super(pW2);
            }

            public final pW.a a(tu_0 tu_02) {
                this.a.c();
                return super.a(tu_02);
            }
        };
    }

    public static wK<pW.a> a(wK<wR> wK2) {
        return new wK<pW.a>(wK2){
            private /* synthetic */ wK a;
            {
                this.a = wK2;
            }

            @Override
            private boolean a(int n2, pW.a a2, pW.a a3) {
                return this.a.a(n2, new wR(a2.e().g(), a2.d().g(), false), new wR(a3.e().g(), a3.d().g(), false));
            }

            @Override
            public final /* synthetic */ boolean a(int n2, Object object, Object object2) {
                pW.a a2 = (pW.a)object2;
                object2 = (pW.a)object;
                int n3 = n2;
                3 var1_2 = this;
                return var1_2.a.a(n3, new wR(object2.e().g(), object2.d().g(), false), new wR(a2.e().g(), a2.d().g(), false));
            }
        };
    }

    private static tq_0 a(tq_0 tq_02) {
        if (tq_02 instanceof sM) {
            int n2 = tq_02.f();
            sM sM2 = new sM(n2);
            int n3 = 0;
            while (n3 < n2) {
                int n4 = n3;
                int n5 = n3++;
                sM2.c(n4, n4, BY.a(tq_02.b(n5, n5)));
            }
            return sM2;
        }
        sN sN2 = new sN(tq_02);
        return sN2.e();
    }

    public static b a(kY kY2, kX kX2) {
        return new b(kY2, kX2);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class org.valkyrienskies.core.impl.shadow.pU$a
    extends wG<pW.a>
    implements pW {
        private final tu_0 a;
        private final pY b;
        private final tu_0 c;
        private final boolean d;
        private final qa_0 e;

        org.valkyrienskies.core.impl.shadow.pU$a(pY pY2, tu_0 tu_02, tu_0 tu_03, wK<pW.a> wK2, int n2, int n3, boolean bl, qa_0 qa_02) {
            super(n2, n3, wK2);
            this.a = tu_02;
            this.b = pY2;
            this.c = tu_03;
            this.d = bl;
            this.e = qa_02;
            if (bl && !(pY2 instanceof qb_0)) {
                throw new oX(px_0.INVALID_IMPLEMENTATION, pY2.getClass().getName());
            }
        }

        @Override
        public final int b() {
            return this.a.f();
        }

        @Override
        public final int c() {
            return this.c.f();
        }

        @Override
        public final tu_0 a() {
            if (this.c == null) {
                return null;
            }
            return this.c.j();
        }

        @Override
        public final pW.a a(tu_0 tu_02) {
            co_0<tu_0, tq_0> co_02;
            tu_0 tu_03;
            if (this.e == null) {
                tu_03 = tu_02.j();
            } else {
                tu_02.j();
                tu_03 = tu_02 = this.e.a();
            }
            if (this.d) {
                return new a((qb_0)this.b, this.a, tu_02, 0);
            }
            co_0<tu_0, tq_0> co_03 = co_02 = this.b.a(tu_02);
            co_0<tu_0, tq_0> co_04 = co_03;
            co_04 = co_02;
            return new b((tu_0)co_03.a, (tq_0)co_04.b, this.a, tu_02, 0);
        }

        static final class a
        extends pO {
            private final tu_0 a;
            private final qb_0 b;
            private final tu_0 c;

            private a(qb_0 qb_02, tu_0 tu_02, tu_0 tu_03) {
                super(tu_02.f());
                this.b = qb_02;
                this.a = tu_03;
                this.c = tu_02;
            }

            public final tq_0 c() {
                return this.b.b(this.a.g());
            }

            public final tu_0 e() {
                return this.a;
            }

            public final tu_0 d() {
                return this.c.k((tu_0)((Object)this.b.a(this.a.g())));
            }

            /* synthetic */ a(qb_0 qb_02, tu_0 tu_02, tu_0 tu_03, byte by) {
                this(qb_02, tu_02, tu_03);
            }
        }

        static final class b
        extends pO {
            private final tu_0 a;
            private final tq_0 b;
            private final tu_0 c;

            private b(tu_0 tu_02, tq_0 tq_02, tu_0 tu_03, tu_0 tu_04) {
                super(tu_03.f());
                this.b = tq_02;
                this.a = tu_04;
                this.c = tu_03.k(tu_02);
            }

            public final tq_0 c() {
                return this.b;
            }

            public final tu_0 e() {
                return this.a;
            }

            public final tu_0 d() {
                return this.c;
            }

            /* synthetic */ b(tu_0 tu_02, tq_0 tq_02, tu_0 tu_03, tu_0 tu_04, byte by) {
                this(tu_02, tq_02, tu_03, tu_04);
            }
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class b
    implements qb_0 {
        private final kY a;
        private final kX b;

        b(kY kY2, kX kX2) {
            this.a = kY2;
            this.b = kX2;
        }

        @Override
        public final co_0<tu_0, tq_0> a(tu_0 object) {
            object = ((tu_0)object).g();
            return new co_0<sA, sy_0>(this.a((double[])object), this.b((double[])object));
        }

        @Override
        public final sA a(double[] dArray) {
            return new sA(this.a.a(dArray), false);
        }

        @Override
        public final sy_0 b(double[] dArray) {
            return new sy_0(this.b.a(dArray), false);
        }
    }
}


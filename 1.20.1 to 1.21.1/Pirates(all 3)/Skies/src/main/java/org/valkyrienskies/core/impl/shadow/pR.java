/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cb_0;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.oR;
import org.valkyrienskies.core.impl.shadow.pV;
import org.valkyrienskies.core.impl.shadow.pW;
import org.valkyrienskies.core.impl.shadow.pZ;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sE;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.tA;
import org.valkyrienskies.core.impl.shadow.tC;
import org.valkyrienskies.core.impl.shadow.tb_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.te_0;
import org.valkyrienskies.core.impl.shadow.tn_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.tu_0;
import org.valkyrienskies.core.impl.shadow.wK;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class pR
implements pV {
    private static final double a = 1.0E-11;
    private final a b;

    public pR() {
        this(org.valkyrienskies.core.impl.shadow.pR$a.QR);
    }

    private pR(a a2) {
        this.b = a2;
    }

    private a a() {
        return this.b;
    }

    private static pR a(a a2) {
        return new pR(a2);
    }

    @Override
    public final pZ a(pW pW2) {
        cb_0 cb_02 = pW2.d();
        cb_0 cb_03 = pW2.e();
        wK<pW.a> wK2 = pW2.f();
        if (wK2 == null) {
            throw new pl_0();
        }
        tu_0 tu_02 = pW2.a();
        pW.a a2 = null;
        while (true) {
            cb_03.c();
            Object object = a2;
            cb_02.c();
            a2 = pW2.a(tu_02);
            tu_0 tu_03 = a2.d();
            tq_0 tq_02 = a2.c();
            tu_02 = a2.e();
            if (object != null) {
                cb_0 cb_04 = cb_03;
                if (wK2.a(cb_04.b, (pW.a)object, a2)) {
                    cb_0 cb_05 = cb_02;
                    cb_04 = cb_05;
                    cb_04 = cb_03;
                    return new pZ(a2, cb_05.b, cb_04.b);
                }
            }
            object = this.b.a(tq_02, tu_03);
            tu_02 = tu_02.l((tu_0)object);
        }
    }

    public final String toString() {
        return "GaussNewtonOptimizer{decomposition=" + (Object)((Object)this.b) + '}';
    }

    private static co_0<tq_0, tu_0> b(tq_0 tq_02, tu_0 tu_02) {
        int n2;
        int n3;
        int n4 = tq_02.f();
        int n5 = tq_02.g();
        sv_0 sv_02 = td_0.a(n5, n5);
        sA sA2 = new sA(n5);
        for (n3 = 0; n3 < n4; ++n3) {
            for (n2 = 0; n2 < n5; ++n2) {
                ((tu_0)((Object)sA2)).a(n2, ((tu_0)((Object)sA2)).a(n2) + tu_02.a(n3) * tq_02.b(n3, n2));
            }
            for (n2 = 0; n2 < n5; ++n2) {
                for (int i2 = n2; i2 < n5; ++i2) {
                    sv_02.c(n2, i2, sv_02.b(n2, i2) + tq_02.b(n3, n2) * tq_02.b(n3, i2));
                }
            }
        }
        for (n3 = 0; n3 < n5; ++n3) {
            for (n2 = 0; n2 < n3; ++n2) {
                sv_02.c(n3, n2, sv_02.b(n2, n3));
            }
        }
        return new co_0<sv_0, sA>(sv_02, sA2);
    }

    static /* synthetic */ co_0 a(tq_0 tq_02, tu_0 tu_02) {
        int n2;
        int n3;
        int n4 = tq_02.f();
        int n5 = tq_02.g();
        sv_0 sv_02 = td_0.a(n5, n5);
        sA sA2 = new sA(n5);
        for (n3 = 0; n3 < n4; ++n3) {
            for (n2 = 0; n2 < n5; ++n2) {
                ((tu_0)((Object)sA2)).a(n2, ((tu_0)((Object)sA2)).a(n2) + tu_02.a(n3) * tq_02.b(n3, n2));
            }
            for (n2 = 0; n2 < n5; ++n2) {
                for (int i2 = n2; i2 < n5; ++i2) {
                    sv_02.c(n2, i2, sv_02.b(n2, i2) + tq_02.b(n3, n2) * tq_02.b(n3, i2));
                }
            }
        }
        for (n3 = 0; n3 < n5; ++n3) {
            for (n2 = 0; n2 < n3; ++n2) {
                sv_02.c(n3, n2, sv_02.b(n2, n3));
            }
        }
        return new co_0<sv_0, sA>(sv_02, sA2);
    }

    static final class 1 {
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum a {
        LU{

            protected final tu_0 a(tq_0 object, tu_0 object2) {
                try {
                    Object object3 = object = pR.a((tq_0)object, (tu_0)object2);
                    object2 = (tq_0)((co_0)object).a;
                    object3 = object;
                    object = (tu_0)((co_0)object3).b;
                    return new tb_0((tq_0)object2, 1.0E-11).a().a((tu_0)object);
                }
                catch (tA tA2) {
                    throw new oR(px_0.UNABLE_TO_SOLVE_SINGULAR_PROBLEM, tA2);
                }
            }
        }
        ,
        QR{

            protected final tu_0 a(tq_0 tq_02, tu_0 tu_02) {
                try {
                    return new tn_0(tq_02, 1.0E-11).c().a(tu_02);
                }
                catch (tA tA2) {
                    throw new oR(px_0.UNABLE_TO_SOLVE_SINGULAR_PROBLEM, tA2);
                }
            }
        }
        ,
        CHOLESKY{

            protected final tu_0 a(tq_0 object, tu_0 object2) {
                try {
                    Object object3 = object = pR.a((tq_0)object, (tu_0)object2);
                    object2 = (tq_0)((co_0)object).a;
                    object3 = object;
                    object = (tu_0)((co_0)object3).b;
                    return new sE((tq_0)object2, 1.0E-11, 1.0E-11).a().a((tu_0)object);
                }
                catch (te_0 te_02) {
                    throw new oR(px_0.UNABLE_TO_SOLVE_SINGULAR_PROBLEM, te_02);
                }
            }
        }
        ,
        SVD{

            protected final tu_0 a(tq_0 tq_02, tu_0 tu_02) {
                return new tC(tq_02).a().a(tu_02);
            }
        };


        private a() {
        }

        protected abstract tu_0 a(tq_0 var1, tu_0 var2);

        /* synthetic */ a(String string, int n2, byte by) {
            this();
        }
    }
}


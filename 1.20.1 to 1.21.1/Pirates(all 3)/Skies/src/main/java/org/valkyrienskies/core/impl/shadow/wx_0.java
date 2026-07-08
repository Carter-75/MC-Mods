/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.uI;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.wD;
import org.valkyrienskies.core.impl.shadow.wE;
import org.valkyrienskies.core.impl.shadow.wr_0;
import org.valkyrienskies.core.impl.shadow.wu_0;
import org.valkyrienskies.core.impl.shadow.wv_0;
import org.valkyrienskies.core.impl.shadow.ww_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.wx
 */
public final class wx_0<T extends kO<T>>
implements wv_0<T> {
    private double a;
    private final wu_0<T> b;
    private uJ<T> c;
    private uJ<T> d;
    private boolean e;
    private final wD f;
    private final int g;

    private wx_0(double d2, wu_0<T> wu_02) {
        this(d2, wu_02, wE.INCREMENT$34d2fcad, wD.FIRST);
    }

    private wx_0(double d2, wu_0<T> wu_02, int n2) {
        this(d2, wu_02, n2, wD.FIRST);
    }

    private wx_0(double d2, wu_0<T> wu_02, wD wD2) {
        this(d2, wu_02, wE.INCREMENT$34d2fcad, wD2);
    }

    private wx_0(double d2, wu_0<T> wu_02, int n2, wD wD2) {
        this.a = BY.w(d2);
        this.b = wu_02;
        this.g = n2;
        this.f = wD2;
        this.c = null;
        this.d = null;
        this.e = true;
    }

    @Override
    public final void a(uJ<T> uJ2, T t) {
        this.c = null;
        this.d = null;
        this.e = true;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public final void a(wr_0 var1_1, boolean var2_2) {
        block10: {
            if (this.d == null) {
                this.c = var1_1.c();
                this.d = this.c;
                this.e = var1_1.e();
                if (!this.e) {
                    this.a = -this.a;
                }
            }
            if (this.g == wE.INCREMENT$34d2fcad) {
                var4_3 = this.d;
                v0 = (kO)var4_3.a.a((double)this.a);
            } else {
                v1 = this.d;
                var4_3 = v1;
                var4_3 = this.d;
                v0 = var3_6 = (kO)((kO)v1.a.c().a()).a((BY.y(var4_3.a.d() / this.a) + 1.0) * this.a);
            }
            if (this.g == wE.MULTIPLES$34d2fcad) {
                var4_3 = this.d;
                if (cq_0.b(var3_6.d(), var4_3.a.d(), 1)) {
                    var3_6 = (kO)var3_6.a(this.a);
                }
            }
            while (var4_4 = this.a(var3_6, var1_1)) {
                this.a(false);
                this.d = var1_1.a(var3_6);
                var3_6 = (kO)var3_6.a(this.a);
            }
            if (!var2_2) break block10;
            var4_5 /* !! */  = this.f;
            if (!var4_5 /* !! */ .last) ** GOTO lbl-1000
            v2 = this.d;
            var4_5 /* !! */  = v2;
            var4_5 /* !! */  = var1_1.d();
            if (v2.a.d() != var4_5 /* !! */ .a.d()) {
                v3 = true;
            } else lbl-1000:
            // 2 sources

            {
                v3 = false;
            }
            var2_2 = v3;
            this.a(var2_2 == false);
            if (var2_2) {
                this.d = var1_1.d();
                this.a(true);
            }
        }
    }

    private boolean a(T object, ww_0<T> ww_02) {
        uJ<T> uJ2;
        if (this.e) {
            uJ<T> uJ3;
            double d2 = object.d();
            object = ww_02.d();
            return d2 <= uJ3.a.d();
        }
        double d3 = object.d();
        object = ww_02.d();
        return d3 >= uJ2.a.d();
    }

    private void a(boolean bl) {
        Object object = this.f;
        if (!object.first) {
            uJ<T> uJ2 = this.c;
            object = uJ2;
            object = this.d;
            if (uJ2.a.d() == ((uI)object).a.d()) {
                return;
            }
        }
    }
}


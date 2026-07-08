/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.sS;
import org.valkyrienskies.core.impl.shadow.sx_0;
import org.valkyrienskies.core.impl.shadow.uH;
import org.valkyrienskies.core.impl.shadow.uI;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.uz_0;
import org.valkyrienskies.core.impl.shadow.vp_0;
import org.valkyrienskies.core.impl.shadow.vq_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.vs
 */
public final class vs_0<T extends kO<T>>
extends vp_0<T> {
    private static final String k = "Adams-Moulton";

    private vs_0(kM<T> kM2, int n2, double d2, double d3, double d4, double d5) {
        int n3 = n2;
        super(kM2, k, n3, n3 + 1, d2, d3, d4, d5);
    }

    private vs_0(kM<T> kM2, int n2, double d2, double d3, double[] dArray, double[] dArray2) {
        int n3 = n2;
        super(kM2, k, n3, n3 + 1, d2, d3, dArray, dArray2);
    }

    @Override
    public final uJ<T> a(uH<T> uH2, uI<T> uI2, T t) {
        Object object;
        uI<T> uI3;
        ((uz_0)this).a(uI2, t);
        uJ uJ2 = uI2;
        Object object2 = uJ2.a;
        uJ2 = uH2;
        kO[] kOArray = ((uH)((Object)uJ2)).c.a(uI2);
        vs_0 vs_02 = this;
        ((uz_0)vs_02).a(vs_02.a(uH2, (kO)object2, kOArray, (kO)t));
        uJ2 = uI2;
        boolean bl = ((kO)t.b(uI3.a)).d() > 0.0;
        this.a((uH)uH2, this.n(), (kO)t);
        object2 = this.n();
        uJ2 = object2;
        object2 = vq_0.a(object2, (kO)((kO)uJ2.a.a(this.m())), this.m(), this.d, this.e);
        this.a(false);
        do {
            boolean bl2;
            kO[] kOArray2;
            object = null;
            kO[] kOArray3 = (kO[])ch_0.a(this.a(), kOArray.length);
            sx_0 sx_02 = null;
            kO kO2 = (kO)((kO)this.a().a()).a(10.0);
            while (((kO)kO2.b(1.0)).d() >= 0.0) {
                kO kO3;
                object = object2.c();
                uJ2 = object2;
                kOArray2 = this.a((kO)uJ2.a, (kO[])object);
                for (int i2 = 0; i2 < kOArray3.length; ++i2) {
                    kOArray3[i2] = this.m().c((kO)kOArray2[i2]);
                }
                vs_0 vs_03 = this;
                sx_02 = vs_03.a(vs_03.e);
                vs_0 vs_04 = this;
                vs_04.a((kO[])vs_04.d, kOArray3, sx_02);
                kO2 = (kO)sx_02.c(new a(this, kOArray, kOArray3, (kO[])object));
                if (!(((kO)kO3.b(1.0)).d() >= 0.0)) continue;
                kO kO4 = this.c(kO2);
                vs_0 vs_05 = this;
                vs_05.b(vs_05.a(this.m().c((kO)kO4), bl, false));
                uJ2 = this.n();
                object2 = vq_0.a(this.n(), (kO)((kO)uJ2.a.a(this.m())), this.m(), this.d, this.e);
            }
            uJ2 = object2;
            kOArray2 = this.a((kO)uJ2.a, (kO[])object);
            kO[] kOArray4 = (kO[])ch_0.a(this.a(), kOArray.length);
            for (int i3 = 0; i3 < kOArray4.length; ++i3) {
                kOArray4[i3] = this.m().c((kO)kOArray2[i3]);
            }
            this.a(kOArray3, kOArray4, sx_02);
            uJ2 = object2;
            object2 = new uJ(uJ2.a, (kO[])object, kOArray2);
            vs_0 vs_06 = this;
            uJ2 = uH2;
            ((uz_0)vs_06).a(vs_06.a(new vq_0(this.m(), object2, kOArray4, sx_02, bl, this.n(), object2, ((uH)((Object)uJ2)).c), t));
            this.d = kOArray4;
            this.e = sx_02;
            if (this.o()) continue;
            System.arraycopy(object, 0, kOArray, 0, kOArray.length);
            if (this.l()) {
                this.a((uH)uH2, this.n(), (kO)t);
            }
            uJ2 = this.c(kO2);
            object2 = (kO)this.m().c((Object)uJ2);
            uJ2 = this.n();
            object = (kO)uJ2.a.a(object2);
            boolean bl3 = bl ? ((kO)object.b(t)).d() >= 0.0 : ((kO)object.b(t)).d() <= 0.0;
            object2 = this.a(object2, bl, bl3);
            uJ2 = this.n();
            kO kO5 = (kO)uJ2.a.a(object2);
            boolean bl4 = bl ? ((kO)kO5.b(t)).d() >= 0.0 : (bl2 = ((kO)kO5.b(t)).d() <= 0.0);
            if (bl4) {
                uJ2 = this.n();
                object2 = (kO)t.b(uJ2.a);
            }
            this.b(object2);
            uJ2 = this.n();
            object2 = vq_0.a(this.n(), (kO)((kO)uJ2.a.a(this.m())), this.m(), this.d, this.e);
        } while (!this.o());
        object = this.n();
        ((uz_0)this).a(null);
        this.a(null);
        return object;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    final class a
    implements sS<T> {
        private final T[] a;
        private final T[] b;
        private final T[] c;
        private final T[] d;
        private /* synthetic */ vs_0 e;

        a(T[] TArray, T[] TArray2, T[] TArray3) {
            this.e = var1_1;
            this.a = TArray;
            this.b = TArray2;
            this.d = TArray3;
            this.c = (kO[])TArray3.clone();
        }

        @Override
        public final void a(int n2, int n3, int n4, int n5) {
            vs_0 vs_02 = this.e;
            Arrays.fill(this.d, vs_02.c.a());
        }

        @Override
        private void a(int n2, int n3, T t) {
            if ((n2 & 1) == 0) {
                this.d[n3] = (kO)this.d[n3].b(t);
                return;
            }
            this.d[n3] = (kO)this.d[n3].a(t);
        }

        private T b() {
            Object object = this.e;
            object = (kO)((uz_0)object).c.a();
            for (int i2 = 0; i2 < this.d.length; ++i2) {
                this.d[i2] = (kO)this.d[i2].a(this.a[i2].a(this.b[i2]));
                if (i2 >= this.e.j) continue;
                kO kO2 = ci_0.a((kO)this.a[i2].e(), (kO)this.d[i2].e());
                kO2 = this.e.h == null ? (kO)((kO)kO2.c(this.e.g)).a(this.e.f) : (kO)((kO)kO2.c(this.e.i[i2])).a(this.e.h[i2]);
                kO kO3 = kO2 = ((kO)this.d[i2].b(this.c[i2])).d(kO2);
                object = object.a(kO3.c(kO3));
            }
            return (kO)((kO)object.d((double)this.e.j)).k();
        }

        @Override
        public final /* synthetic */ kN a() {
            a a2 = this;
            Object object = a2.e;
            object = (kO)((uz_0)object).c.a();
            for (int i2 = 0; i2 < a2.d.length; ++i2) {
                a2.d[i2] = (kO)a2.d[i2].a(a2.a[i2].a(a2.b[i2]));
                if (i2 >= a2.e.j) continue;
                kO kO2 = ci_0.a((kO)a2.a[i2].e(), (kO)a2.d[i2].e());
                kO2 = a2.e.h == null ? (kO)((kO)kO2.c(a2.e.g)).a(a2.e.f) : (kO)((kO)kO2.c(a2.e.i[i2])).a(a2.e.h[i2]);
                kO kO3 = kO2 = ((kO)a2.d[i2].b(a2.c[i2])).d(kO2);
                object = object.a(kO3.c(kO3));
            }
            return (kO)((kO)object.d((double)a2.e.j)).k();
        }

        @Override
        public final /* synthetic */ void a(int n2, int n3, kN kN2) {
            kO kO2 = (kO)kN2;
            int n4 = n3;
            n3 = n2;
            a a2 = this;
            if ((n3 & 1) == 0) {
                a2.d[n4] = a2.d[n4].b((kO)kO2);
                return;
            }
            a2.d[n4] = a2.d[n4].a((kO)kO2);
        }
    }
}


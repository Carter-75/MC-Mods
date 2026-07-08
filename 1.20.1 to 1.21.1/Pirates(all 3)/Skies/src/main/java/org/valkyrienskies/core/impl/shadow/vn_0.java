/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.sx_0;
import org.valkyrienskies.core.impl.shadow.uH;
import org.valkyrienskies.core.impl.shadow.uI;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.uz_0;
import org.valkyrienskies.core.impl.shadow.vp_0;
import org.valkyrienskies.core.impl.shadow.vq_0;
import org.valkyrienskies.core.impl.shadow.vw_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.vn
 */
public final class vn_0<T extends kO<T>>
extends vp_0<T> {
    private static final String k = "Adams-Bashforth";

    private vn_0(kM<T> kM2, int n2, double d2, double d3, double d4, double d5) {
        int n3 = n2;
        super(kM2, k, n3, n3, d2, d3, d4, d5);
    }

    private vn_0(kM<T> kM2, int n2, double d2, double d3, double[] dArray, double[] dArray2) {
        int n3 = n2;
        super(kM2, k, n3, n3, d2, d3, dArray, dArray2);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private kO a(kO[] kOArray, kO[] kOArray2, kO[] kOArray3, sx_0 sx_02) {
        kO kO2 = (kO)this.a().a();
        for (int i2 = 0; i2 < this.j; ++i2) {
            kO kO3;
            kO kO4 = (kO)kOArray2[i2].e();
            kO4 = this.h == null ? (kO)((kO)kO4.c(this.g)).a(this.f) : (kO)((kO)kO4.c(this.i[i2])).a(this.h[i2]);
            kO kO5 = (kO)this.a().a();
            int n2 = sx_02.f() % 2 == 0 ? -1 : 1;
            for (int i3 = sx_02.f() - 1; i3 >= 0; --i3) {
                kO5 = (kO)kO5.a(((kO)sx_02.b(i3, i2)).a(n2));
                n2 = -n2;
            }
            kO5 = kO5.b(kOArray3[i2]);
            kO kO6 = kO3 = kOArray2[i2].b(kOArray[i2]).a(kO5).d(kO4);
            kO2 = kO2.a(kO6.c(kO6));
        }
        return (kO)((kO)kO2.d((double)this.j)).k();
    }

    @Override
    public final uJ<T> a(uH<T> uH2, uI<T> uI2, T t) {
        Object object;
        uI<T> uI3;
        ((uz_0)this).a(uI2, t);
        Object object2 = uI2;
        Object object3 = object2.a;
        object2 = uH2;
        kO[] kOArray = object2.c.a(uI2);
        vn_0 vn_02 = this;
        ((uz_0)vn_02).a(vn_02.a(uH2, (kO)object3, kOArray, (kO)t));
        object2 = uI2;
        boolean bl = ((kO)t.b(uI3.a)).d() > 0.0;
        this.a((uH)uH2, this.n(), (kO)t);
        object3 = this.n();
        object2 = object3;
        object3 = vq_0.a(object3, (kO)((kO)object2.a.a(this.m())), this.m(), this.d, this.e);
        this.a(false);
        do {
            boolean bl2;
            Object object4;
            object = null;
            kO[] kOArray2 = (kO[])ch_0.a(this.a(), kOArray.length);
            Object object5 = null;
            Object object6 = (kO)((kO)this.a().a()).a(10.0);
            while (((kO)object6.b(1.0)).d() >= 0.0) {
                kO kO2;
                object = object3.c();
                object2 = object3;
                object5 = this.a((kO)object2.a, (kO[])object);
                for (int i2 = 0; i2 < kOArray2.length; ++i2) {
                    kOArray2[i2] = this.m().c((kO)object5[i2]);
                }
                vn_0 vn_03 = this;
                object5 = vn_03.a(vn_03.e);
                vn_0 vn_04 = this;
                vn_04.a((kO[])vn_04.d, kOArray2, (sx_0)object5);
                kO[] kOArray3 = object5;
                kO[] kOArray4 = kOArray2;
                object2 = object;
                object4 = kOArray;
                object6 = this;
                kO kO3 = (kO)((uz_0)object6).a().a();
                for (int i3 = 0; i3 < ((vw_0)object6).j; ++i3) {
                    kO kO4;
                    kO kO5 = (kO)object2[i3].e();
                    kO5 = ((vw_0)object6).h == null ? (kO)((kO)kO5.c(((vw_0)object6).g)).a(((vw_0)object6).f) : (kO)((kO)kO5.c(((vw_0)object6).i[i3])).a(((vw_0)object6).h[i3]);
                    kO kO6 = (kO)((uz_0)object6).a().a();
                    int n2 = kOArray3.f() % 2 == 0 ? -1 : 1;
                    for (int i4 = kOArray3.f() - 1; i4 >= 0; --i4) {
                        kO6 = (kO)kO6.a(((kO)kOArray3.b(i4, i3)).a(n2));
                        n2 = -n2;
                    }
                    kO6 = kO6.b(kOArray4[i3]);
                    kO kO7 = kO4 = object2[i3].b(object4[i3]).a(kO6).d(kO5);
                    kO3 = kO3.a(kO7.c(kO7));
                }
                object6 = (kO)((kO)kO3.d((double)((vw_0)object6).j)).k();
                if (!(((kO)kO2.b(1.0)).d() >= 0.0)) continue;
                object4 = this.c(object6);
                vn_0 vn_05 = this;
                vn_05.b(vn_05.a((kO)this.m().c((kO[])object4), bl, false));
                object2 = this.n();
                object3 = vq_0.a(this.n(), (kO)((kO)object2.a.a(this.m())), this.m(), this.d, this.e);
            }
            vn_0 vn_06 = this;
            object2 = uH2;
            ((uz_0)vn_06).a(vn_06.a(new vq_0(this.m(), object3, kOArray2, (sx_0)object5, bl, this.n(), object3, object2.c), t));
            this.d = kOArray2;
            this.e = object5;
            if (this.o()) continue;
            System.arraycopy(object, 0, kOArray, 0, kOArray.length);
            if (this.l()) {
                this.a((uH)uH2, this.n(), (kO)t);
            }
            object5 = this.c(object6);
            object4 = (kO)this.m().c((kO[])object5);
            object2 = this.n();
            object3 = (kO)object2.a.a((kO[])object4);
            boolean bl3 = bl ? ((kO)object3.b(t)).d() >= 0.0 : ((kO)object3.b(t)).d() <= 0.0;
            object3 = this.a(object4, bl, bl3);
            object2 = this.n();
            object = (kO)object2.a.a((Object)object3);
            boolean bl4 = bl ? ((kO)object.b(t)).d() >= 0.0 : (bl2 = ((kO)object.b(t)).d() <= 0.0);
            if (bl4) {
                object2 = this.n();
                object3 = (kO)t.b(object2.a);
            }
            this.b(object3);
            object2 = this.n();
            object3 = vq_0.a(this.n(), (kO)((kO)object2.a.a(this.m())), this.m(), this.d, this.e);
        } while (!this.o());
        object = this.n();
        ((uz_0)this).a(null);
        this.a(null);
        return object;
    }
}


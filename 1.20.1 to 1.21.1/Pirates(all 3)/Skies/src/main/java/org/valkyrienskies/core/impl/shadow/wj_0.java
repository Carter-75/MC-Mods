/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uH;
import org.valkyrienskies.core.impl.shadow.uI;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.uN;
import org.valkyrienskies.core.impl.shadow.uz_0;
import org.valkyrienskies.core.impl.shadow.vQ;
import org.valkyrienskies.core.impl.shadow.wk_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.wj
 */
public abstract class wj_0<T extends kO<T>>
extends uz_0<T>
implements vQ<T> {
    private final T[] d = this.p();
    private final T[][] e = this.q();
    private final T[] f = this.r();
    private final T g;

    protected wj_0(kM<T> kM2, String string, T t) {
        super(kM2, string);
        this.g = (kO)t.e();
    }

    protected final T a(int n2, int n3) {
        return (T)((kO)((kO)((kO)this.a().a()).a((double)n2)).d((double)n3));
    }

    protected abstract wk_0<T> a(boolean var1, T[][] var2, uJ<T> var3, uJ<T> var4, uG<T> var5);

    @Override
    public final uJ<T> a(uH<T> uH2, uI<T> uI2, T t) {
        Object object;
        uI<T> uI3;
        this.a(uI2, t);
        Object object2 = uI2;
        Object t2 = object2.a;
        object2 = uH2;
        kO[] kOArray = object2.c.a(uI2);
        wj_0 wj_02 = this;
        wj_02.a(wj_02.a(uH2, (kO)t2, kOArray, (kO)t));
        object2 = uI2;
        boolean bl = ((kO)t.b(uI3.a)).d() > 0.0;
        int n2 = this.d.length + 1;
        kO[][] kOArray2 = (kO[][])ch_0.a(this.a(), n2, -1);
        kO[] kOArray3 = (kO[])ch_0.a(this.a(), kOArray.length);
        if (bl) {
            uJ uJ2;
            object2 = this.n();
            if (((kO)((kO)uJ2.a.a(this.g)).b(t)).d() >= 0.0) {
                object2 = this.n();
                this.a((kO)t.b(object2.a));
            } else {
                wj_0 wj_03 = this;
                wj_03.a(wj_03.g);
            }
        } else {
            uJ uJ3;
            object2 = this.n();
            if (((kO)((kO)uJ3.a.b(this.g)).b(t)).d() <= 0.0) {
                object2 = this.n();
                this.a((kO)t.b(object2.a));
            } else {
                wj_0 wj_04 = this;
                wj_04.a((kO)wj_04.g.a());
            }
        }
        this.a(false);
        do {
            boolean bl2;
            Object object3;
            int n3;
            object2 = uH2;
            kO[] kOArray4 = object2.c.a(this.n());
            object2 = uH2;
            kOArray2[0] = object2.c.a(this.n());
            for (n3 = 1; n3 < n2; ++n3) {
                for (int i2 = 0; i2 < kOArray.length; ++i2) {
                    object3 = (kO)kOArray2[0][i2].c(this.e[n3 - 1][0]);
                    for (int i3 = 1; i3 < n3; ++i3) {
                        object3 = (kO)object3.a(kOArray2[i3][i2].c(this.e[n3 - 1][i3]));
                    }
                    kOArray3[i2] = (kO)kOArray4[i2].a(this.m().c((Object)object3));
                }
                wj_0 wj_05 = this;
                object2 = wj_05.n();
                kOArray2[n3] = wj_05.a((kO)object2.a.a(this.m().c(this.d[n3 - 1])), kOArray3);
            }
            for (n3 = 0; n3 < kOArray.length; ++n3) {
                object2 = (kO)kOArray2[0][n3].c(this.f[0]);
                for (int i4 = 1; i4 < n2; ++i4) {
                    object2 = (kO)object2.a(kOArray2[i4][n3].c(this.f[i4]));
                }
                kOArray3[n3] = (kO)kOArray4[n3].a(this.m().c((kO[])object2));
            }
            object2 = this.n();
            object = (kO)object2.a.a(this.m());
            object2 = this.a((kO)object, kOArray3);
            object3 = new uJ((kO)object, kOArray3, object2);
            System.arraycopy(kOArray3, 0, kOArray4, 0, kOArray.length);
            wj_0 wj_06 = this;
            object2 = uH2;
            wj_06.a(wj_06.a(this.a(bl, kOArray2, this.n(), (uJ)object3, object2.c), t));
            if (this.o()) continue;
            object2 = this.n();
            kO kO2 = (kO)object2.a.a(this.m());
            boolean bl3 = bl ? ((kO)kO2.b(t)).d() >= 0.0 : (bl2 = ((kO)kO2.b(t)).d() <= 0.0);
            if (!bl3) continue;
            object2 = this.n();
            this.a((kO)t.b(object2.a));
        } while (!this.o());
        object = this.n();
        this.a(null);
        this.a(null);
        return object;
    }

    private T[] a(uN<T> uN2, T t, T[] TArray, T object) {
        int n2;
        kO[] kOArray = (kO[])TArray.clone();
        int n3 = this.d.length + 1;
        kO[][] kOArray2 = (kO[][])ch_0.a(this.a(), n3, -1);
        kO[] kOArray3 = (kO[])TArray.clone();
        object = (kO)object.b(t);
        kOArray2[0] = uN2.c();
        for (n2 = 1; n2 < n3; ++n2) {
            for (int i2 = 0; i2 < TArray.length; ++i2) {
                kO kO2 = (kO)kOArray2[0][i2].c(this.e[n2 - 1][0]);
                for (int i3 = 1; i3 < n2; ++i3) {
                    kO2 = (kO)kO2.a(kOArray2[i3][i2].c(this.e[n2 - 1][i3]));
                }
                kOArray3[i2] = kOArray[i2].a(object.c(kO2));
            }
            kO cfr_ignored_0 = (kO)t.a(object.c(this.d[n2 - 1]));
            kOArray2[n2] = uN2.c();
        }
        for (n2 = 0; n2 < TArray.length; ++n2) {
            kO kO3 = (kO)kOArray2[0][n2].c(this.f[0]);
            for (int i4 = 1; i4 < n3; ++i4) {
                kO3 = (kO)kO3.a(kOArray2[i4][n2].c(this.f[i4]));
            }
            kOArray[n2] = kOArray[n2].a(object.c(kO3));
        }
        return kOArray;
    }
}


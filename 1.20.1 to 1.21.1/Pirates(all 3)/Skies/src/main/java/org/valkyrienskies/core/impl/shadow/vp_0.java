/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.sP;
import org.valkyrienskies.core.impl.shadow.sx_0;
import org.valkyrienskies.core.impl.shadow.uH;
import org.valkyrienskies.core.impl.shadow.uI;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.uS;
import org.valkyrienskies.core.impl.shadow.vu_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.vp
 */
public abstract class vp_0<T extends kO<T>>
extends uS<T> {
    private final vu_0<T> k;

    public vp_0(kM<T> kM2, String string, int n2, int n3, double d2, double d3, double d4, double d5) {
        super(kM2, string, n2, n3, d2, d3, d4, d5);
        this.k = vu_0.a(kM2, n2);
    }

    public vp_0(kM<T> kM2, String string, int n2, int n3, double d2, double d3, double[] dArray, double[] dArray2) {
        super(kM2, string, n2, n3, d2, d3, dArray, dArray2);
        this.k = vu_0.a(kM2, n2);
    }

    @Override
    public abstract uJ<T> a(uH<T> var1, uI<T> var2, T var3);

    @Override
    public final sx_0<T> a(T object, T[] object2, T[][] TArray, T[][] TArray2) {
        T[] TArray3;
        Object object3;
        T[][] TArray4 = TArray2;
        TArray2 = TArray;
        TArray = object2;
        object2 = object;
        object = this.k;
        kN[][] kNArray = (kO[][])ch_0.a(((vu_0)object).a, ((vu_0)object).c.length + 1, ((vu_0)object).c.length + 1);
        kN[][] kNArray2 = (kO[][])ch_0.a(((vu_0)object).a, ((vu_0)object).c.length + 1, TArray2[0].length);
        T[] TArray5 = TArray2[0];
        T[] TArray6 = TArray4[0];
        for (int i2 = 1; i2 < TArray2.length; ++i2) {
            object3 = (kO)TArray[i2].b(TArray[0]);
            TArray3 = (kO)object3.d(object2);
            kN[] kNArray3 = (kN[])object2.b();
            kN[] kNArray4 = kNArray[2 * i2 - 2];
            kN[] kNArray5 = 2 * i2 - 1 < kNArray.length ? kNArray[2 * i2 - 1] : null;
            for (int i3 = 0; i3 < kNArray4.length; ++i3) {
                kNArray3 = (kO)kNArray3.c(TArray3);
                kNArray4[i3] = object3.c(kNArray3);
                if (kNArray5 == null) continue;
                kNArray5[i3] = (kO)kNArray3.a(i3 + 2);
            }
            T[] TArray7 = TArray2[i2];
            TArray3 = TArray4[i2];
            kNArray3 = kNArray2[2 * i2 - 2];
            kNArray4 = 2 * i2 - 1 < kNArray2.length ? kNArray2[2 * i2 - 1] : null;
            for (int i4 = 0; i4 < TArray7.length; ++i4) {
                kNArray3[i4] = (kO)((kO)TArray7[i4].b(TArray5[i4])).b(object3.c(TArray6[i4]));
                if (kNArray4 == null) continue;
                kNArray4[i4] = (kO)TArray3[i4].b(TArray6[i4]);
            }
        }
        sP sP2 = new sP(new sx_0(kNArray, false));
        object3 = sP2.a().a(new sx_0(kNArray2, false));
        TArray3 = new sx_0(((vu_0)object).a, object3.f() - 1, object3.g());
        for (int i5 = 0; i5 < TArray3.f(); ++i5) {
            for (int i6 = 0; i6 < TArray3.g(); ++i6) {
                TArray3.a(i5, i6, object3.b(i5, i6));
            }
        }
        return TArray3;
    }

    public final sx_0<T> a(sx_0<T> object) {
        sx_0<T> sx_02 = object;
        object = this.k;
        return ((vu_0)object).b.a(sx_02);
    }

    public final void a(T[] object, T[] TArray, sx_0<T> TArray2) {
        T[] TArray3 = TArray2;
        TArray2 = TArray;
        TArray = object;
        object = this.k;
        TArray3 = (kO[][])TArray3.a;
        for (int i2 = 0; i2 < TArray3.length; ++i2) {
            T t = TArray3[i2];
            T t2 = object.c[i2];
            for (int i3 = 0; i3 < ((T)t).length; ++i3) {
                t[i3] = (kO)t[i3].a(t2.c(TArray[i3].b(TArray2[i3])));
            }
        }
    }
}


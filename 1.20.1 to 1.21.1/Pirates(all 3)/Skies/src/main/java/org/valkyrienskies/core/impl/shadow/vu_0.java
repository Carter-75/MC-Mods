/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.sP;
import org.valkyrienskies.core.impl.shadow.sQ;
import org.valkyrienskies.core.impl.shadow.sx_0;
import org.valkyrienskies.core.impl.shadow.sz_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.vu
 */
public final class vu_0<T extends kO<T>> {
    private static final Map<Integer, Map<kM<? extends kO<?>>, vu_0<? extends kO<?>>>> d = new HashMap();
    final kM<T> a;
    final sx_0<T> b;
    final T[] c;

    private vu_0(kM<T> kM2, int n2) {
        this.a = kM2;
        int n3 = --n2;
        kN[][] kNArray = this;
        int n4 = n3;
        Object object = (kO[][])ch_0.a(kNArray.a, n4, n4);
        for (int i2 = 1; i2 <= ((kO[][])object).length; ++i2) {
            kO[] kOArray = object[i2 - 1];
            int n5 = -i2;
            kO kO2 = (kO)((kO)kNArray.a.a()).a((double)n5);
            for (int i3 = 1; i3 <= kOArray.length; ++i3) {
                kOArray[i3 - 1] = (kO)kO2.a(i3 + 1);
                kO2 = (kO)kO2.a(n5);
            }
        }
        kNArray = new sx_0((kN[][])object, false);
        object = new sP(kNArray).a();
        Object[] objectArray = (kO[])ch_0.a(kM2, n2);
        Arrays.fill(objectArray, kM2.b());
        this.c = (kO[])object.a(new sz_0((kN[])objectArray, false)).h();
        kNArray = (kO[][])kNArray.c();
        for (int i4 = kNArray.length - 1; i4 > 0; --i4) {
            kNArray[i4] = kNArray[i4 - 1];
        }
        kNArray[0] = (kO[])ch_0.a(kM2, n2);
        Arrays.fill(kNArray[0], kM2.a());
        this.b = new sx_0(object.a(new sx_0(kNArray, false)).c());
    }

    public static <T extends kO<T>> vu_0<T> a(kM<T> kM2, int n2) {
        Map<Integer, Map<kM<? extends kO<?>>, vu_0<? extends kO<?>>>> map2 = d;
        synchronized (map2) {
            vu_0<kO<Object>> vu_02;
            Map<kM<kO<?>>, vu_0<kO<?>>> map3 = d.get(n2);
            if (map3 == null) {
                map3 = new HashMap();
                d.put(n2, map3);
            }
            if ((vu_02 = map3.get(kM2)) == null) {
                vu_02 = new vu_0<T>(kM2, n2);
                map3.put(kM2, vu_02);
            }
            return vu_02;
        }
    }

    private sQ<T> a(int n2) {
        int n3 = n2;
        kN[][] kNArray = (kO[][])ch_0.a(this.a, n3, n3);
        for (int i2 = 1; i2 <= kNArray.length; ++i2) {
            kO[] kOArray = kNArray[i2 - 1];
            int n4 = -i2;
            kO kO2 = (kO)((kO)this.a.a()).a((double)n4);
            for (int i3 = 1; i3 <= kOArray.length; ++i3) {
                kOArray[i3 - 1] = (kO)kO2.a(i3 + 1);
                kO2 = (kO)kO2.a(n4);
            }
        }
        return new sx_0(kNArray, false);
    }

    public final sx_0<T> a(T t, T[] TArray, T[][] TArray2, T[][] TArray3) {
        T[] TArray4;
        Object object;
        kN[][] kNArray = (kO[][])ch_0.a(this.a, this.c.length + 1, this.c.length + 1);
        kN[][] kNArray2 = (kO[][])ch_0.a(this.a, this.c.length + 1, TArray2[0].length);
        T[] TArray5 = TArray2[0];
        T[] TArray6 = TArray3[0];
        for (int i2 = 1; i2 < TArray2.length; ++i2) {
            object = (kO)TArray[i2].b(TArray[0]);
            TArray4 = (kO)object.d(t);
            kN[] kNArray3 = (kN[])t.b();
            kN[] kNArray4 = kNArray[2 * i2 - 2];
            kN[] kNArray5 = 2 * i2 - 1 < kNArray.length ? kNArray[2 * i2 - 1] : null;
            for (int i3 = 0; i3 < kNArray4.length; ++i3) {
                kNArray3 = (kO)kNArray3.c(TArray4);
                kNArray4[i3] = object.c(kNArray3);
                if (kNArray5 == null) continue;
                kNArray5[i3] = (kO)kNArray3.a(i3 + 2);
            }
            T[] TArray7 = TArray2[i2];
            TArray4 = TArray3[i2];
            kNArray3 = kNArray2[2 * i2 - 2];
            kNArray4 = 2 * i2 - 1 < kNArray2.length ? kNArray2[2 * i2 - 1] : null;
            for (int i4 = 0; i4 < TArray7.length; ++i4) {
                kNArray3[i4] = (kO)((kO)TArray7[i4].b(TArray5[i4])).b(object.c(TArray6[i4]));
                if (kNArray4 == null) continue;
                kNArray4[i4] = (kO)TArray4[i4].b(TArray6[i4]);
            }
        }
        sP sP2 = new sP(new sx_0(kNArray, false));
        object = sP2.a().a(new sx_0(kNArray2, false));
        TArray4 = new sx_0<T>(this.a, object.f() - 1, object.g());
        for (int i5 = 0; i5 < TArray4.f(); ++i5) {
            for (int i6 = 0; i6 < TArray4.g(); ++i6) {
                TArray4.a(i5, i6, object.b(i5, i6));
            }
        }
        return TArray4;
    }

    public final sx_0<T> a(sx_0<T> sx_02) {
        return this.b.a(sx_02);
    }

    public final void a(T[] TArray, T[] TArray2, sx_0<T> kOArray) {
        kOArray = (kO[][])kOArray.a;
        for (int i2 = 0; i2 < kOArray.length; ++i2) {
            kO[] kOArray2 = kOArray[i2];
            T t = this.c[i2];
            for (int i3 = 0; i3 < kOArray2.length; ++i3) {
                kOArray2[i3] = (kO)kOArray2[i3].a(t.c(TArray[i3].b(TArray2[i3])));
            }
        }
    }
}


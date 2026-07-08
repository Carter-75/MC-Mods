/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.sx_0;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uI;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.wr_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.vq
 */
final class vq_0<T extends kO<T>>
extends wr_0<T> {
    private T d;
    private final uJ<T> e;
    private final T[] f;
    private final sx_0<T> g;

    vq_0(T t, uJ<T> uJ2, T[] TArray, sx_0<T> sx_02, boolean bl, uJ<T> uJ3, uJ<T> uJ4, uG<T> uG2) {
        this((kO)t, uJ2, (kO[])TArray, sx_02, bl, uJ3, uJ4, uJ3, uJ4, uG2);
    }

    private vq_0(T t, uJ<T> uJ2, T[] TArray, sx_0<T> sx_02, boolean bl, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uJ<T> uJ6, uG<T> uG2) {
        super(bl, uJ3, uJ4, uJ5, uJ6, uG2);
        this.d = t;
        this.e = uJ2;
        this.f = (kO[])TArray.clone();
        this.g = new sx_0(sx_02.c(), false);
    }

    private vq_0<T> b(boolean bl, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        return new vq_0(this.d, this.e, this.f, this.g, bl, uJ2, uJ3, uJ4, uJ5, uG2);
    }

    @Override
    public final uJ<T> a(T t, T t2, T t3, T t4) {
        return vq_0.a(this.e, t, this.d, this.f, this.g);
    }

    public static <S extends kO<S>> uJ<S> a(uJ<S> uJ2, S s, S s2, S[] SArray, sx_0<S> kOArray) {
        int n2;
        Object object = uJ2;
        kO kO2 = (kO)s.b(((uI)object).a);
        s2 = kO2.d(s2);
        Object[] objectArray = (kO[])ch_0.a(s.c(), SArray.length);
        Arrays.fill(objectArray, s.c().a());
        Object[] objectArray2 = (kO[])ch_0.a(s.c(), SArray.length);
        Arrays.fill(objectArray2, s.c().a());
        object = kOArray;
        kOArray = (kO[][])kOArray.a;
        for (int i2 = kOArray.length - 1; i2 >= 0; --i2) {
            n2 = i2 + 2;
            kO[] kOArray2 = kOArray[i2];
            kO kO3 = (kO)s2.d(n2);
            for (int i3 = 0; i3 < kOArray2.length; ++i3) {
                kO kO4 = kOArray2[i3].c(kO3);
                objectArray[i3] = objectArray[i3].a(kO4);
                objectArray2[i3] = (kO)objectArray2[i3].a(kO4.a(n2));
            }
        }
        kO[] kOArray3 = uJ2.c();
        for (n2 = 0; n2 < objectArray.length; ++n2) {
            objectArray[n2] = objectArray[n2].a(SArray[n2].c(s2));
            kOArray3[n2] = (kO)kOArray3[n2].a(objectArray[n2]);
            objectArray2[n2] = objectArray2[n2].a(SArray[n2].c(s2)).d((kO)kO2);
        }
        return new uJ(s, kOArray3, (kO[])objectArray2);
    }

    @Override
    public final /* synthetic */ wr_0 a(boolean bl, uJ uJ2, uJ uJ3, uJ uJ4, uJ uJ5, uG object) {
        uG uG2 = object;
        object = uJ5;
        uJ5 = uJ4;
        uJ4 = uJ3;
        uJ3 = uJ2;
        boolean bl2 = bl;
        vq_0 vq_02 = this;
        return new vq_0(vq_02.d, vq_02.e, vq_02.f, vq_02.g, bl2, uJ3, uJ4, uJ5, (uJ)object, uG2);
    }
}


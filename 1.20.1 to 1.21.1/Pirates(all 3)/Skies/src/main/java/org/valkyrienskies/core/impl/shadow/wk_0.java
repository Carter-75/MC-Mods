/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.wr_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.wk
 */
abstract class wk_0<T extends kO<T>>
extends wr_0<T> {
    private final kM<T> d;
    private final T[][] e;

    protected wk_0(kM<T> kM2, boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        super(bl, uJ2, uJ3, uJ4, uJ5, uG2);
        this.d = kM2;
        this.e = (kO[][])ch_0.a(kM2, TArray.length, -1);
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            this.e[i2] = (kO[])TArray[i2].clone();
        }
    }

    private wk_0<T> b(boolean bl, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        wk_0 wk_02 = this;
        return wk_02.a(wk_02.d, bl, (kO[][])this.e, uJ2, uJ3, uJ4, uJ5, uG2);
    }

    protected abstract wk_0<T> a(kM<T> var1, boolean var2, T[][] var3, uJ<T> var4, uJ<T> var5, uJ<T> var6, uJ<T> var7, uG<T> var8);

    protected final T[] a(T ... TArray) {
        wk_0 wk_02 = this;
        return wk_02.a(wk_02.c().c(), (kO[])TArray);
    }

    protected final T[] b(T ... TArray) {
        wk_0 wk_02 = this;
        return wk_02.a(wk_02.d().c(), (kO[])TArray);
    }

    protected final T[] c(T ... TArray) {
        wk_0 wk_02 = this;
        return wk_02.a((kO[])ch_0.a(wk_02.d, this.e[0].length), (kO[])TArray);
    }

    private T[] a(T[] TArray, T ... TArray2) {
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            for (int i3 = 0; i3 < TArray2.length; ++i3) {
                TArray[i2] = (kO)TArray[i2].a(TArray2[i3].c(this.e[i3][i2]));
            }
        }
        return TArray;
    }
}


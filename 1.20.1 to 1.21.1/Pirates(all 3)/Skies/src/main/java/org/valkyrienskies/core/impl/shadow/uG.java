/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.uI;
import org.valkyrienskies.core.impl.shadow.uJ;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class uG<T extends kO<T>>
implements Serializable {
    private static final long b = 20151114L;
    final int[] a;

    uG(uG<T> uG2, int n2) {
        int n3;
        if (uG2 == null) {
            n3 = 0;
        } else {
            uG<T> uG3 = uG2;
            n3 = uG3.a.length - 1;
        }
        int n4 = n3;
        this.a = new int[n4 + 2];
        if (uG2 == null) {
            this.a[0] = 0;
        } else {
            System.arraycopy(uG2.a, 0, this.a, 0, n4 + 1);
        }
        this.a[n4 + 1] = this.a[n4] + n2;
    }

    public final int a() {
        return this.a.length - 1;
    }

    public final int b() {
        return this.a[this.a.length - 1];
    }

    public final T[] a(uI<T> uI2) {
        Object object = uI2;
        kO[] kOArray = (kO[])ch_0.a(((uI)object).a.c(), this.b());
        int n2 = 0;
        this.a(0, uI2.c(), kOArray);
        while (true) {
            object = this;
            if (++n2 >= ((uG)object).a.length - 1) break;
            this.a(n2, uI2.b(n2), kOArray);
        }
        return kOArray;
    }

    public final T[] a(uJ<T> uJ2) {
        Object object = uJ2;
        kO[] kOArray = (kO[])ch_0.a(((uI)object).a.c(), this.b());
        int n2 = 0;
        this.a(0, uJ2.e(), kOArray);
        while (true) {
            object = this;
            if (++n2 >= ((uG)object).a.length - 1) break;
            this.a(n2, uJ2.c(n2), kOArray);
        }
        return kOArray;
    }

    public final uJ<T> a(T t, T[] TArray, T[] TArray2) {
        if (TArray.length != this.b()) {
            throw new oS(TArray.length, this.b());
        }
        if (TArray2.length != this.b()) {
            throw new oS(TArray2.length, this.b());
        }
        uG uG2 = this;
        int n2 = uG2.a.length - 1;
        int n3 = 0;
        kO[] kOArray = this.a(0, (kO[])TArray);
        kO[] kOArray2 = this.a(0, (kO[])TArray2);
        if (n2 < 2) {
            return new uJ(t, kOArray, kOArray2);
        }
        kO[][] kOArray3 = (kO[][])ch_0.a(t.c(), n2 - 1, -1);
        kO[][] kOArray4 = (kO[][])ch_0.a(t.c(), n2 - 1, -1);
        while (true) {
            uG2 = this;
            if (++n3 >= uG2.a.length - 1) break;
            kOArray3[n3 - 1] = this.a(n3, (kO[])TArray);
            kOArray4[n3 - 1] = this.a(n3, (kO[])TArray2);
        }
        return new uJ(t, kOArray, kOArray2, kOArray3, kOArray4);
    }

    public final T[] a(int n2, T[] TArray) {
        this.a(n2);
        int n3 = this.a[n2];
        n2 = this.a[n2 + 1];
        if (TArray.length < n2) {
            throw new oS(TArray.length, n2);
        }
        kO[] kOArray = (kO[])ch_0.a(TArray[0].c(), n2 -= n3);
        System.arraycopy(TArray, n3, kOArray, 0, n2);
        return kOArray;
    }

    public final void a(int n2, T[] TArray, T[] TArray2) {
        this.a(n2);
        int n3 = this.a[n2];
        n2 = this.a[n2 + 1];
        int n4 = n2 - n3;
        if (TArray2.length < n2) {
            throw new oS(TArray2.length, n2);
        }
        if (TArray.length != n4) {
            throw new oS(TArray.length, n4);
        }
        System.arraycopy(TArray, 0, TArray2, n3, n4);
    }

    private void a(int n2) {
        if (n2 < 0 || n2 > this.a.length - 2) {
            throw new oV(px_0.ARGUMENT_OUTSIDE_DOMAIN, n2, 0, this.a.length - 2);
        }
    }
}


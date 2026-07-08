/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sQ;
import org.valkyrienskies.core.impl.shadow.sR;
import org.valkyrienskies.core.impl.shadow.sS;
import org.valkyrienskies.core.impl.shadow.su_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.sx
 */
public final class sx_0<T extends kN<T>>
extends su_0<T>
implements Serializable {
    private static final long b = 7260756672015356458L;
    public T[][] a;

    private sx_0(kM<T> kM2) {
        super(kM2);
    }

    public sx_0(kM<T> kM2, int n2, int n3) {
        super(kM2, n2, n3);
        this.a = (kN[][])ch_0.a(kM2, n2, n3);
    }

    public sx_0(T[][] TArray) {
        this(sx_0.a(TArray), (kN[][])TArray);
    }

    public sx_0(kM<T> object, T[][] TArray) {
        super(object);
        object = this;
        object.a(TArray, 0, 0);
    }

    public sx_0(T[][] TArray, boolean bl) {
        this(sx_0.a(TArray), (kN[][])TArray, false);
    }

    public sx_0(kM<T> object, T[][] TArray, boolean n2) {
        super(object);
        if (n2 != 0) {
            object = this;
            object.a(TArray, 0, 0);
            return;
        }
        ci_0.a(TArray);
        int n3 = TArray.length;
        if (n3 == 0) {
            throw new pf_0(px_0.AT_LEAST_ONE_ROW);
        }
        n2 = TArray[0].length;
        if (n2 == 0) {
            throw new pf_0(px_0.AT_LEAST_ONE_COLUMN);
        }
        for (int i2 = 1; i2 < n3; ++i2) {
            if (TArray[i2].length == n2) continue;
            throw new oS(n2, TArray[i2].length);
        }
        this.a = TArray;
    }

    private sx_0(T[] TArray) {
        T[] TArray2 = TArray;
        if (TArray.length == 0) {
            throw new pf_0(px_0.AT_LEAST_ONE_ROW);
        }
        this(TArray2[0].c(), (kN[])TArray);
    }

    private sx_0(kM<T> kM2, T[] TArray) {
        super(kM2);
        int n2 = TArray.length;
        this.a = (kN[][])ch_0.a(this.a(), n2, 1);
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a[i2][0] = TArray[i2];
        }
    }

    @Override
    public final sQ<T> a(int n2, int n3) {
        return new sx_0(this.a(), n2, n3);
    }

    @Override
    public final sQ<T> b() {
        return new sx_0(this.a(), this.j(), false);
    }

    @Override
    private sx_0<T> b(sx_0<T> sx_02) {
        this.e(sx_02);
        int n2 = ((su_0)this).f();
        int n3 = ((su_0)this).g();
        kN[][] kNArray = (kN[][])ch_0.a(this.a(), n2, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            T[] TArray = this.a[i2];
            T[] TArray2 = sx_02.a[i2];
            kN[] kNArray2 = kNArray[i2];
            for (int i3 = 0; i3 < n3; ++i3) {
                kNArray2[i3] = (kN)TArray[i3].a(TArray2[i3]);
            }
        }
        return new sx_0(this.a(), kNArray, false);
    }

    @Override
    private sx_0<T> c(sx_0<T> sx_02) {
        this.f(sx_02);
        int n2 = ((su_0)this).f();
        int n3 = ((su_0)this).g();
        kN[][] kNArray = (kN[][])ch_0.a(this.a(), n2, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            T[] TArray = this.a[i2];
            T[] TArray2 = sx_02.a[i2];
            kN[] kNArray2 = kNArray[i2];
            for (int i3 = 0; i3 < n3; ++i3) {
                kNArray2[i3] = (kN)TArray[i3].b(TArray2[i3]);
            }
        }
        return new sx_0(this.a(), kNArray, false);
    }

    @Override
    public final sx_0<T> a(sx_0<T> sx_02) {
        this.g(sx_02);
        int n2 = ((su_0)this).f();
        int n3 = ((su_0)sx_02).g();
        int n4 = ((su_0)this).g();
        kN[][] kNArray = (kN[][])ch_0.a(this.a(), n2, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            T[] TArray = this.a[i2];
            kN[] kNArray2 = kNArray[i2];
            for (int i3 = 0; i3 < n3; ++i3) {
                kN kN2 = (kN)this.a().a();
                for (int i4 = 0; i4 < n4; ++i4) {
                    kN2 = (kN)kN2.a(TArray[i4].c(sx_02.a[i4][i3]));
                }
                kNArray2[i3] = kN2;
            }
        }
        return new sx_0(this.a(), kNArray, false);
    }

    @Override
    public final T[][] c() {
        return this.j();
    }

    public final T[][] i() {
        return this.a;
    }

    @Override
    public final void a(T[][] TArray, int n2, int n3) {
        if (this.a == null) {
            if (n2 > 0) {
                throw new oX(px_0.FIRST_ROWS_NOT_INITIALIZED_YET, n2);
            }
            if (n3 > 0) {
                throw new oX(px_0.FIRST_COLUMNS_NOT_INITIALIZED_YET, n3);
            }
            int n4 = TArray.length;
            if (n4 == 0) {
                throw new pf_0(px_0.AT_LEAST_ONE_ROW);
            }
            n4 = TArray[0].length;
            if (n4 == 0) {
                throw new pf_0(px_0.AT_LEAST_ONE_COLUMN);
            }
            this.a = (kN[][])ch_0.a(this.a(), TArray.length, n4);
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                if (TArray[i2].length != n4) {
                    throw new oS(n4, TArray[i2].length);
                }
                System.arraycopy(TArray[i2], 0, this.a[i2 + n2], n3, n4);
            }
            return;
        }
        super.a(TArray, n2, n3);
    }

    @Override
    public final T b(int n2, int n3) {
        this.h(n2);
        this.i(n3);
        return this.a[n2][n3];
    }

    @Override
    public final void a(int n2, int n3, T t) {
        this.h(n2);
        this.i(n3);
        this.a[n2][n3] = t;
    }

    @Override
    public final void b(int n2, int n3, T t) {
        this.h(n2);
        this.i(n3);
        T[] TArray = this.a[n2];
        TArray[n3] = (kN)TArray[n3].a(t);
    }

    @Override
    public final void c(int n2, int n3, T t) {
        this.h(n2);
        this.i(n3);
        T[] TArray = this.a[n2];
        TArray[n3] = (kN)TArray[n3].c(t);
    }

    @Override
    public final int f() {
        if (this.a == null) {
            return 0;
        }
        return this.a.length;
    }

    @Override
    public final int g() {
        if (this.a == null || this.a[0] == null) {
            return 0;
        }
        return this.a[0].length;
    }

    @Override
    public final T[] b(T[] TArray) {
        int n2 = ((su_0)this).f();
        int n3 = ((su_0)this).g();
        if (TArray.length != n3) {
            throw new oS(TArray.length, n3);
        }
        kN[] kNArray = (kN[])ch_0.a(this.a(), n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            T[] TArray2 = this.a[i2];
            kN kN2 = (kN)this.a().a();
            for (int i3 = 0; i3 < n3; ++i3) {
                kN2 = (kN)kN2.a(TArray2[i3].c(TArray[i3]));
            }
            kNArray[i2] = kN2;
        }
        return kNArray;
    }

    @Override
    public final T[] c(T[] TArray) {
        int n2 = ((su_0)this).f();
        int n3 = ((su_0)this).g();
        if (TArray.length != n2) {
            throw new oS(TArray.length, n2);
        }
        kN[] kNArray = (kN[])ch_0.a(this.a(), n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            kN kN2 = (kN)this.a().a();
            for (int i3 = 0; i3 < n2; ++i3) {
                kN2 = (kN)kN2.a(this.a[i3][i2].c(TArray[i3]));
            }
            kNArray[i2] = kN2;
        }
        return kNArray;
    }

    @Override
    public final T a(sR<T> sR2) {
        int n2 = ((su_0)this).f();
        int n3 = ((su_0)this).g();
        for (int i2 = 0; i2 < n2; ++i2) {
            T[] TArray = this.a[i2];
            for (int i3 = 0; i3 < n3; ++i3) {
                TArray[i3] = sR2.a(i2, i3, TArray[i3]);
            }
        }
        return sR2.b();
    }

    @Override
    public final T a(sS<T> sS2) {
        int n2 = ((su_0)this).f();
        int n3 = ((su_0)this).g();
        sS2.a(n2, n3, 0, 0);
        for (int i2 = 0; i2 < n2; ++i2) {
            T[] TArray = this.a[i2];
            for (int i3 = 0; i3 < n3; ++i3) {
                sS2.a(i2, i3, TArray[i3]);
            }
        }
        return sS2.a();
    }

    @Override
    public final T a(sR<T> sR2, int n2, int n3, int n4, int n5) {
        this.b(n2, n3, n4, n5);
        ((su_0)this).f();
        ((su_0)this).g();
        while (n2 <= n3) {
            T[] TArray = this.a[n2];
            for (int i2 = n4; i2 <= n5; ++i2) {
                TArray[i2] = sR2.a(n2, i2, TArray[i2]);
            }
            ++n2;
        }
        return sR2.b();
    }

    @Override
    public final T a(sS<T> sS2, int n2, int n3, int n4, int n5) {
        this.b(n2, n3, n4, n5);
        sS2.a(((su_0)this).f(), ((su_0)this).g(), n2, n4);
        while (n2 <= n3) {
            T[] TArray = this.a[n2];
            for (int i2 = n4; i2 <= n5; ++i2) {
                sS2.a(n2, i2, TArray[i2]);
            }
            ++n2;
        }
        return sS2.a();
    }

    @Override
    public final T b(sR<T> sR2) {
        int n2 = ((su_0)this).f();
        int n3 = ((su_0)this).g();
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                T[] TArray = this.a[i3];
                T[] TArray2 = TArray;
                TArray[i2] = sR2.a(i3, i2, TArray2[i2]);
            }
        }
        return sR2.b();
    }

    @Override
    public final T b(sS<T> sS2) {
        int n2 = ((su_0)this).f();
        int n3 = ((su_0)this).g();
        sS2.a(n2, n3, 0, 0);
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                sS2.a(i3, i2, this.a[i3][i2]);
            }
        }
        return sS2.a();
    }

    @Override
    public final T b(sR<T> sR2, int n2, int n3, int n4, int n5) {
        this.b(n2, n3, n4, n5);
        ((su_0)this).f();
        ((su_0)this).g();
        while (n4 <= n5) {
            for (int i2 = n2; i2 <= n3; ++i2) {
                T[] TArray = this.a[i2];
                T[] TArray2 = TArray;
                TArray[n4] = sR2.a(i2, n4, TArray2[n4]);
            }
            ++n4;
        }
        return sR2.b();
    }

    @Override
    public final T b(sS<T> sS2, int n2, int n3, int n4, int n5) {
        this.b(n2, n3, n4, n5);
        sS2.a(((su_0)this).f(), ((su_0)this).g(), n2, n4);
        while (n4 <= n5) {
            for (int i2 = n2; i2 <= n3; ++i2) {
                sS2.a(i2, n4, this.a[i2][n4]);
            }
            ++n4;
        }
        return sS2.a();
    }

    private T[][] j() {
        int n2 = ((su_0)this).f();
        kN[][] kNArray = (kN[][])ch_0.a(this.a(), n2, ((su_0)this).g());
        for (int i2 = 0; i2 < n2; ++i2) {
            System.arraycopy(this.a[i2], 0, kNArray[i2], 0, this.a[i2].length);
        }
        return kNArray;
    }

    private void b(T[][] TArray) {
        this.a((kN[][])TArray, 0, 0);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sH;
import org.valkyrienskies.core.impl.shadow.sI;
import org.valkyrienskies.core.impl.shadow.sQ;
import org.valkyrienskies.core.impl.shadow.sR;
import org.valkyrienskies.core.impl.shadow.sS;
import org.valkyrienskies.core.impl.shadow.sT;
import org.valkyrienskies.core.impl.shadow.sz_0;
import org.valkyrienskies.core.impl.shadow.tc_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.th_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.su
 */
public abstract class su_0<T extends kN<T>>
implements sQ<T> {
    private final kM<T> a;

    protected su_0() {
        this.a = null;
    }

    protected su_0(kM<T> kM2) {
        this.a = kM2;
    }

    protected su_0(kM<T> kM2, int n2, int n3) {
        if (n2 <= 0) {
            throw new pk_0(px_0.DIMENSION, n2);
        }
        if (n3 <= 0) {
            throw new pk_0(px_0.DIMENSION, n3);
        }
        this.a = kM2;
    }

    protected static <T extends kN<T>> kM<T> a(T[][] TArray) {
        if (TArray == null) {
            throw new pl_0();
        }
        if (TArray.length == 0) {
            throw new pf_0(px_0.AT_LEAST_ONE_ROW);
        }
        if (TArray[0].length == 0) {
            throw new pf_0(px_0.AT_LEAST_ONE_COLUMN);
        }
        return TArray[0][0].c();
    }

    protected static <T extends kN<T>> kM<T> a(T[] TArray) {
        if (TArray.length == 0) {
            throw new pf_0(px_0.AT_LEAST_ONE_ROW);
        }
        return TArray[0].c();
    }

    @Deprecated
    private static <T extends kN<T>> T[][] a(kM<T> kM2, int n2, int n3) {
        return (kN[][])ch_0.a(kM2, n2, n3);
    }

    @Deprecated
    private static <T extends kN<T>> T[] a(kM<T> kM2, int n2) {
        return (kN[])ch_0.a(kM2, n2);
    }

    @Override
    public final kM<T> a() {
        return this.a;
    }

    @Override
    public abstract sQ<T> a(int var1, int var2);

    @Override
    public abstract sQ<T> b();

    @Override
    public sQ<T> a(sQ<T> sQ2) {
        this.e(sQ2);
        int n2 = this.f();
        int n3 = this.g();
        su_0 su_02 = this.a(n2, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                su_02.a(i2, i3, (kN)this.b(i2, i3).a(sQ2.b(i2, i3)));
            }
        }
        return su_02;
    }

    @Override
    public sQ<T> b(sQ<T> sQ2) {
        this.f(sQ2);
        int n2 = this.f();
        int n3 = this.g();
        su_0 su_02 = this.a(n2, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                su_02.a(i2, i3, (kN)this.b(i2, i3).b(sQ2.b(i2, i3)));
            }
        }
        return su_02;
    }

    @Override
    public sQ<T> a(T t) {
        int n2 = this.f();
        int n3 = this.g();
        su_0 su_02 = this.a(n2, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                su_02.a(i2, i3, (kN)this.b(i2, i3).a(t));
            }
        }
        return su_02;
    }

    @Override
    public sQ<T> b(T t) {
        int n2 = this.f();
        int n3 = this.g();
        su_0 su_02 = this.a(n2, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                su_02.a(i2, i3, (kN)this.b(i2, i3).c(t));
            }
        }
        return su_02;
    }

    @Override
    public sQ<T> c(sQ<T> sQ2) {
        this.g(sQ2);
        int n2 = this.f();
        int n3 = sQ2.g();
        int n4 = this.g();
        su_0 su_02 = this.a(n2, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                kN kN2 = (kN)this.a.a();
                for (int i4 = 0; i4 < n4; ++i4) {
                    kN2 = (kN)kN2.a(this.b(i2, i4).c(sQ2.b(i4, i3)));
                }
                su_02.a(i2, i3, kN2);
            }
        }
        return su_02;
    }

    @Override
    public final sQ<T> d(sQ<T> sQ2) {
        return sQ2.c(this);
    }

    @Override
    public final sQ<T> a(int n2) {
        int n3;
        if (n2 < 0) {
            throw new pj_0(n2);
        }
        if (!this.e()) {
            throw new th_0(this.f(), this.g());
        }
        if (n2 == 0) {
            su_0 su_02 = this;
            return td_0.a(su_02.a, (int)this.f());
        }
        if (n2 == 1) {
            return this.b();
        }
        char[] cArray = Integer.toBinaryString(--n2).toCharArray();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            if (cArray[i2] != '1') continue;
            n3 = cArray.length - i2 - 1;
            arrayList.add(n3);
        }
        ArrayList arrayList2 = new ArrayList(cArray.length);
        arrayList2.add(0, this.b());
        for (n3 = 1; n3 < cArray.length; ++n3) {
            sQ sQ2 = (sQ)arrayList2.get(n3 - 1);
            sQ object = sQ2.c(sQ2);
            arrayList2.add(n3, object);
        }
        sQ<T> sQ3 = this.b();
        for (Integer n4 : arrayList) {
            sQ3 = sQ3.c((sQ)arrayList2.get(n4));
        }
        return sQ3;
    }

    @Override
    public T[][] c() {
        kN[][] kNArray = (kN[][])ch_0.a(this.a, this.f(), this.g());
        for (int i2 = 0; i2 < kNArray.length; ++i2) {
            kN[] kNArray2 = kNArray[i2];
            for (int i3 = 0; i3 < kNArray2.length; ++i3) {
                kNArray2[i3] = this.b(i2, i3);
            }
        }
        return kNArray;
    }

    @Override
    public sQ<T> a(int n2, int n3, int n4, int n5) {
        this.b(n2, n3, n4, n5);
        su_0 su_02 = this.a(n3 - n2 + 1, n5 - n4 + 1);
        for (int i2 = n2; i2 <= n3; ++i2) {
            for (int i3 = n4; i3 <= n5; ++i3) {
                su_02.a(i2 - n2, i3 - n4, this.b(i2, i3));
            }
        }
        return su_02;
    }

    @Override
    public final sQ<T> a(int[] nArray, int[] nArray2) {
        this.b(nArray, nArray2);
        su_0 su_02 = this.a(nArray.length, nArray2.length);
        su_0 su_03 = this;
        su_02.a(new sH<T>(su_03, (kN)su_03.a.a(), nArray, nArray2){
            private /* synthetic */ int[] a;
            private /* synthetic */ int[] b;
            private /* synthetic */ su_0 c;
            {
                this.c = su_02;
                this.a = nArray;
                this.b = nArray2;
                super(kN2);
            }

            @Override
            public final T a(int n2, int n3, T t) {
                return this.c.b(this.a[n2], this.b[n3]);
            }
        });
        return su_02;
    }

    @Override
    public final void a(int n2, int n3, int n4, int n5, T[][] TArray) {
        this.b(n2, n3, n4, n5);
        int n6 = n3 + 1 - n2;
        int n7 = n5 + 1 - n4;
        if (TArray.length < n6 || TArray[0].length < n7) {
            throw new tc_0(TArray.length, TArray[0].length, n6, n7);
        }
        su_0 su_02 = this;
        this.a(new sI<T>(su_02, (kN)su_02.a.a(), (kN[][])TArray){
            private int a;
            private int b;
            private /* synthetic */ kN[][] c;
            private /* synthetic */ su_0 d;
            {
                this.d = su_02;
                this.c = kNArray;
                super(kN2);
            }

            @Override
            public final void a(int n2, int n3, int n4, int n5) {
                this.a = n4;
                this.b = n5;
            }

            @Override
            public final void a(int n2, int n3, T t) {
                this.c[n2 - this.a][n3 - this.b] = t;
            }
        }, n2, n3, n4, n5);
    }

    @Override
    public final void a(int[] nArray, int[] nArray2, T[][] TArray) {
        this.b(nArray, nArray2);
        if (TArray.length < nArray.length || TArray[0].length < nArray2.length) {
            throw new tc_0(TArray.length, TArray[0].length, nArray.length, nArray2.length);
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            T[] TArray2 = TArray[i2];
            for (int i3 = 0; i3 < nArray2.length; ++i3) {
                TArray2[i3] = this.b(nArray[i2], nArray2[i3]);
            }
        }
    }

    @Override
    public void a(T[][] TArray, int n2, int n3) {
        int n4;
        if (TArray == null) {
            throw new pl_0();
        }
        int n5 = TArray.length;
        if (n5 == 0) {
            throw new pf_0(px_0.AT_LEAST_ONE_ROW);
        }
        int n6 = TArray[0].length;
        if (n6 == 0) {
            throw new pf_0(px_0.AT_LEAST_ONE_COLUMN);
        }
        for (n4 = 1; n4 < n5; ++n4) {
            if (TArray[n4].length == n6) continue;
            throw new oS(n6, TArray[n4].length);
        }
        this.h(n2);
        this.i(n3);
        this.h(n5 + n2 - 1);
        this.i(n6 + n3 - 1);
        for (n4 = 0; n4 < n5; ++n4) {
            for (int i2 = 0; i2 < n6; ++i2) {
                this.a(n2 + n4, n3 + i2, TArray[n4][i2]);
            }
        }
    }

    @Override
    public sQ<T> b(int n2) {
        this.h(n2);
        int n3 = this.g();
        su_0 su_02 = this.a(1, n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            su_02.a(0, i2, this.b(n2, i2));
        }
        return su_02;
    }

    @Override
    public void a(int n2, sQ<T> sQ2) {
        this.h(n2);
        int n3 = this.g();
        if (sQ2.f() != 1 || sQ2.g() != n3) {
            throw new tc_0(sQ2.f(), sQ2.g(), 1, n3);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            this.a(n2, i2, sQ2.b(0, i2));
        }
    }

    @Override
    public sQ<T> c(int n2) {
        this.i(n2);
        int n3 = this.f();
        su_0 su_02 = this.a(n3, 1);
        for (int i2 = 0; i2 < n3; ++i2) {
            su_02.a(i2, 0, this.b(i2, n2));
        }
        return su_02;
    }

    @Override
    public void b(int n2, sQ<T> sQ2) {
        this.i(n2);
        int n3 = this.f();
        if (sQ2.f() != n3 || sQ2.g() != 1) {
            throw new tc_0(sQ2.f(), sQ2.g(), n3, 1);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            this.a(i2, n2, sQ2.b(i2, 0));
        }
    }

    @Override
    public sT<T> d(int n2) {
        return new sz_0(this.a, this.f(n2), false);
    }

    @Override
    public void a(int n2, sT<T> sT2) {
        this.h(n2);
        int n3 = this.g();
        if (sT2.g() != n3) {
            throw new tc_0(1, sT2.g(), 1, n3);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            this.a(n2, i2, sT2.a(i2));
        }
    }

    @Override
    public sT<T> e(int n2) {
        return new sz_0(this.a, this.g(n2), false);
    }

    @Override
    public void b(int n2, sT<T> sT2) {
        this.i(n2);
        int n3 = this.f();
        if (sT2.g() != n3) {
            throw new tc_0(sT2.g(), 1, n3, 1);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            this.a(i2, n2, sT2.a(i2));
        }
    }

    @Override
    public T[] f(int n2) {
        this.h(n2);
        int n3 = this.g();
        kN[] kNArray = (kN[])ch_0.a(this.a, n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            kNArray[i2] = this.b(n2, i2);
        }
        return kNArray;
    }

    @Override
    public void a(int n2, T[] TArray) {
        this.h(n2);
        int n3 = this.g();
        if (TArray.length != n3) {
            throw new tc_0(1, TArray.length, 1, n3);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            this.a(n2, i2, TArray[i2]);
        }
    }

    @Override
    public T[] g(int n2) {
        this.i(n2);
        int n3 = this.f();
        kN[] kNArray = (kN[])ch_0.a(this.a, n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            kNArray[i2] = this.b(i2, n2);
        }
        return kNArray;
    }

    @Override
    public void b(int n2, T[] TArray) {
        this.i(n2);
        int n3 = this.f();
        if (TArray.length != n3) {
            throw new tc_0(TArray.length, 1, n3, 1);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            this.a(i2, n2, TArray[i2]);
        }
    }

    @Override
    public abstract T b(int var1, int var2);

    @Override
    public abstract void a(int var1, int var2, T var3);

    @Override
    public abstract void b(int var1, int var2, T var3);

    @Override
    public abstract void c(int var1, int var2, T var3);

    @Override
    public sQ<T> d() {
        int n2 = this.f();
        int n3 = this.g();
        su_0 su_02 = this.a(n3, n2);
        su_0 su_03 = this;
        this.c(new sI<T>(su_03, (kN)su_03.a.a(), su_02){
            private /* synthetic */ sQ a;
            private /* synthetic */ su_0 b;
            {
                this.b = su_02;
                this.a = sQ2;
                super(kN2);
            }

            @Override
            public final void a(int n2, int n3, T t) {
                this.a.a(n3, n2, t);
            }
        });
        return su_02;
    }

    @Override
    public final boolean e() {
        return this.g() == this.f();
    }

    @Override
    public abstract int f();

    @Override
    public abstract int g();

    @Override
    public final T h() {
        int n2;
        int n3 = this.f();
        if (n3 != (n2 = this.g())) {
            throw new th_0(n3, n2);
        }
        kN kN2 = (kN)this.a.a();
        int n4 = 0;
        while (n4 < n3) {
            int n5 = n4++;
            kN2 = (kN)kN2.a(this.b(n5, n5));
        }
        return (T)kN2;
    }

    @Override
    public T[] b(T[] TArray) {
        int n2 = this.f();
        int n3 = this.g();
        if (TArray.length != n3) {
            throw new oS(TArray.length, n3);
        }
        kN[] kNArray = (kN[])ch_0.a(this.a, n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            kN kN2 = (kN)this.a.a();
            for (int i3 = 0; i3 < n3; ++i3) {
                kN2 = (kN)kN2.a(this.b(i2, i3).c(TArray[i3]));
            }
            kNArray[i2] = kN2;
        }
        return kNArray;
    }

    @Override
    public final sT<T> a(sT<T> sT2) {
        try {
            sz_0 sz_02 = (sz_0)sT2;
            return new sz_0(this.a, this.b((kN[])sz_02.a), false);
        }
        catch (ClassCastException classCastException) {
            int n2 = this.f();
            int n3 = this.g();
            if (sT2.g() != n3) {
                throw new oS(sT2.g(), n3);
            }
            kN[] kNArray = (kN[])ch_0.a(this.a, n2);
            for (int i2 = 0; i2 < n2; ++i2) {
                kN kN2 = (kN)this.a.a();
                for (int i3 = 0; i3 < n3; ++i3) {
                    kN2 = (kN)kN2.a(this.b(i2, i3).c(sT2.a(i3)));
                }
                kNArray[i2] = kN2;
            }
            return new sz_0(this.a, kNArray, false);
        }
    }

    @Override
    public T[] c(T[] TArray) {
        int n2 = this.f();
        int n3 = this.g();
        if (TArray.length != n2) {
            throw new oS(TArray.length, n2);
        }
        kN[] kNArray = (kN[])ch_0.a(this.a, n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            kN kN2 = (kN)this.a.a();
            for (int i3 = 0; i3 < n2; ++i3) {
                kN2 = (kN)kN2.a(this.b(i3, i2).c(TArray[i3]));
            }
            kNArray[i2] = kN2;
        }
        return kNArray;
    }

    @Override
    public final sT<T> b(sT<T> sT2) {
        try {
            sz_0 sz_02 = (sz_0)sT2;
            return new sz_0(this.a, this.c((kN[])sz_02.a), false);
        }
        catch (ClassCastException classCastException) {
            int n2 = this.f();
            int n3 = this.g();
            if (sT2.g() != n2) {
                throw new oS(sT2.g(), n2);
            }
            kN[] kNArray = (kN[])ch_0.a(this.a, n3);
            for (int i2 = 0; i2 < n3; ++i2) {
                kN kN2 = (kN)this.a.a();
                for (int i3 = 0; i3 < n2; ++i3) {
                    kN2 = (kN)kN2.a(this.b(i3, i2).c(sT2.a(i3)));
                }
                kNArray[i2] = kN2;
            }
            return new sz_0(this.a, kNArray, false);
        }
    }

    @Override
    public T a(sR<T> sR2) {
        int n2 = this.f();
        int n3 = this.g();
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                T t = this.b(i2, i3);
                t = sR2.a(i2, i3, t);
                this.a(i2, i3, t);
            }
        }
        return sR2.b();
    }

    @Override
    public T a(sS<T> sS2) {
        int n2 = this.f();
        int n3 = this.g();
        sS2.a(n2, n3, 0, 0);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                sS2.a(i2, i3, this.b(i2, i3));
            }
        }
        return sS2.a();
    }

    @Override
    public T a(sR<T> sR2, int n2, int n3, int n4, int n5) {
        this.b(n2, n3, n4, n5);
        this.f();
        this.g();
        while (n2 <= n3) {
            for (int i2 = n4; i2 <= n5; ++i2) {
                T t = this.b(n2, i2);
                t = sR2.a(n2, i2, t);
                this.a(n2, i2, t);
            }
            ++n2;
        }
        return sR2.b();
    }

    @Override
    public T a(sS<T> sS2, int n2, int n3, int n4, int n5) {
        this.b(n2, n3, n4, n5);
        sS2.a(this.f(), this.g(), n2, n4);
        while (n2 <= n3) {
            for (int i2 = n4; i2 <= n5; ++i2) {
                sS2.a(n2, i2, this.b(n2, i2));
            }
            ++n2;
        }
        return sS2.a();
    }

    @Override
    public T b(sR<T> sR2) {
        int n2 = this.f();
        int n3 = this.g();
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                T t = this.b(i3, i2);
                t = sR2.a(i3, i2, t);
                this.a(i3, i2, t);
            }
        }
        return sR2.b();
    }

    @Override
    public T b(sS<T> sS2) {
        int n2 = this.f();
        int n3 = this.g();
        sS2.a(n2, n3, 0, 0);
        for (int i2 = 0; i2 < n3; ++i2) {
            for (int i3 = 0; i3 < n2; ++i3) {
                sS2.a(i3, i2, this.b(i3, i2));
            }
        }
        return sS2.a();
    }

    @Override
    public T b(sR<T> sR2, int n2, int n3, int n4, int n5) {
        this.b(n2, n3, n4, n5);
        this.f();
        this.g();
        while (n4 <= n5) {
            for (int i2 = n2; i2 <= n3; ++i2) {
                T t = this.b(i2, n4);
                t = sR2.a(i2, n4, t);
                this.a(i2, n4, t);
            }
            ++n4;
        }
        return sR2.b();
    }

    @Override
    public T b(sS<T> sS2, int n2, int n3, int n4, int n5) {
        this.b(n2, n3, n4, n5);
        sS2.a(this.f(), this.g(), n2, n4);
        while (n4 <= n5) {
            for (int i2 = n2; i2 <= n3; ++i2) {
                sS2.a(i2, n4, this.b(i2, n4));
            }
            ++n4;
        }
        return sS2.a();
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    public kN a(1 var1_1) {
        return this.a((sR<T>)var1_1);
    }

    @Override
    public T c(sS<T> sS2) {
        return this.a(sS2);
    }

    @Override
    public T c(sR<T> sR2, int n2, int n3, int n4, int n5) {
        return this.a(sR2, n2, n3, n4, n5);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    public kN a(2 var1_1, int n2, int n3, int n4, int n5) {
        return this.a((sS<T>)var1_1, n2, n3, n4, n5);
    }

    public String toString() {
        int n2 = this.f();
        int n3 = this.g();
        StringBuffer stringBuffer = new StringBuffer();
        String string = this.getClass().getName();
        string = string.substring(string.lastIndexOf(46) + 1);
        stringBuffer.append(string).append("{");
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("{");
            for (int i3 = 0; i3 < n3; ++i3) {
                if (i3 > 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append(this.b(i2, i3));
            }
            stringBuffer.append("}");
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public boolean equals(Object object) {
        sQ sQ2;
        if (object == this) {
            return true;
        }
        if (!(object instanceof sQ)) {
            return false;
        }
        sQ2 = sQ2;
        int n2 = this.f();
        int n3 = this.g();
        if (sQ2.g() != n3 || sQ2.f() != n2) {
            return false;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                if (this.b(i2, i3).equals(sQ2.b(i2, i3))) continue;
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int n2 = this.f();
        int n3 = this.g();
        int n4 = n2 + 9999422;
        n4 = n4 * 31 + n3;
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                n4 = n4 * 31 + (11 * (i2 + 1) + 17 * (i3 + 1)) * this.b(i2, i3).hashCode();
            }
        }
        return n4;
    }

    protected final void h(int n2) {
        if (n2 < 0 || n2 >= this.f()) {
            throw new po_0(px_0.ROW_INDEX, (Number)n2, 0, this.f() - 1);
        }
    }

    protected final void i(int n2) {
        if (n2 < 0 || n2 >= this.g()) {
            throw new po_0(px_0.COLUMN_INDEX, (Number)n2, 0, this.g() - 1);
        }
    }

    protected final void b(int n2, int n3, int n4, int n5) {
        this.h(n2);
        this.h(n3);
        if (n3 < n2) {
            throw new pn_0((pw_0)px_0.INITIAL_ROW_AFTER_FINAL_ROW, (Number)n3, n2, true);
        }
        this.i(n4);
        this.i(n5);
        if (n5 < n4) {
            throw new pn_0((pw_0)px_0.INITIAL_COLUMN_AFTER_FINAL_COLUMN, (Number)n5, n4, true);
        }
    }

    private void b(int[] nArray, int[] nArray2) {
        if (nArray == null || nArray2 == null) {
            throw new pl_0();
        }
        if (nArray.length == 0 || nArray2.length == 0) {
            throw new pf_0();
        }
        for (int n2 : nArray) {
            this.h(n2);
        }
        nArray = nArray2;
        int n3 = nArray2.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n2;
            n2 = nArray[i2];
            this.i(n2);
        }
    }

    protected final void e(sQ<T> sQ2) {
        if (this.f() != sQ2.f() || this.g() != sQ2.g()) {
            throw new tc_0(sQ2.f(), sQ2.g(), this.f(), this.g());
        }
    }

    protected final void f(sQ<T> sQ2) {
        if (this.f() != sQ2.f() || this.g() != sQ2.g()) {
            throw new tc_0(sQ2.f(), sQ2.g(), this.f(), this.g());
        }
    }

    protected final void g(sQ<T> sQ2) {
        if (this.g() != sQ2.f()) {
            throw new oS(sQ2.f(), this.g());
        }
    }
}


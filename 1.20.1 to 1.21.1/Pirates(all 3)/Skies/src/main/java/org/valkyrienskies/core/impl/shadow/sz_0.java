/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pr_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sQ;
import org.valkyrienskies.core.impl.shadow.sT;
import org.valkyrienskies.core.impl.shadow.sU;
import org.valkyrienskies.core.impl.shadow.sV;
import org.valkyrienskies.core.impl.shadow.sx_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.sz
 */
public final class sz_0<T extends kN<T>>
implements Serializable,
sT<T> {
    private static final long b = 7648186910365927050L;
    T[] a;
    private final kM<T> c;

    private sz_0(kM<T> kM2) {
        this(kM2, 0);
    }

    private sz_0(kM<T> kM2, int n2) {
        this.c = kM2;
        this.a = (kN[])ch_0.a(kM2, n2);
    }

    private sz_0(int n2, T t) {
        this(t.c(), n2);
        Arrays.fill(this.a, t);
    }

    private sz_0(T[] TArray) {
        ci_0.a(TArray);
        try {
            this.c = TArray[0].c();
            this.a = (kN[])TArray.clone();
            return;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new pr_0(px_0.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
        }
    }

    private sz_0(kM<T> kM2, T[] TArray) {
        ci_0.a(TArray);
        this.c = kM2;
        this.a = (kN[])TArray.clone();
    }

    public sz_0(T[] TArray, boolean bl) {
        ci_0.a(TArray);
        if (TArray.length == 0) {
            throw new pr_0(px_0.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
        }
        this.c = TArray[0].c();
        this.a = TArray;
    }

    public sz_0(kM<T> kM2, T[] TArray, boolean bl) {
        ci_0.a(TArray);
        this.c = kM2;
        this.a = bl ? (kN[])TArray.clone() : TArray;
    }

    private sz_0(T[] TArray, int n2, int n3) {
        ci_0.a(TArray);
        if (TArray.length < n2 + n3) {
            throw new pm_0(n2 + n3, (Number)TArray.length, true);
        }
        this.c = TArray[0].c();
        this.a = (kN[])ch_0.a(this.c, n3);
        System.arraycopy(TArray, n2, this.a, 0, n3);
    }

    private sz_0(kM<T> kM2, T[] TArray, int n2, int n3) {
        ci_0.a(TArray);
        if (TArray.length < n2 + n3) {
            throw new pm_0(n2 + n3, (Number)TArray.length, true);
        }
        this.c = kM2;
        this.a = (kN[])ch_0.a(kM2, n3);
        System.arraycopy(TArray, n2, this.a, 0, n3);
    }

    private sz_0(sT<T> sT2) {
        ci_0.a(sT2);
        this.c = sT2.a();
        this.a = (kN[])ch_0.a(this.c, sT2.g());
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2] = sT2.a(i2);
        }
    }

    private sz_0(sz_0<T> sz_02) {
        ci_0.a(sz_02);
        sz_0<T> sz_03 = sz_02;
        this.c = sz_03.c;
        this.a = (kN[])sz_02.a.clone();
    }

    private sz_0(sz_0<T> sz_02, boolean bl) {
        ci_0.a(sz_02);
        sz_0<T> sz_03 = sz_02;
        this.c = sz_03.c;
        this.a = (kN[])sz_02.a.clone();
    }

    @Deprecated
    private sz_0(sz_0<T> sz_02, sz_0<T> sz_03) {
        this(sz_02, sz_03, 0);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private sz_0(sz_0 kNArray, sz_0 sz_02, byte by) {
        ci_0.a(kNArray);
        ci_0.a(sz_02);
        this.c = kNArray.a();
        kN<T>[] kNArray2 = kNArray instanceof sz_0 ? kNArray.a : kNArray.h();
        kNArray = sz_02 instanceof sz_0 ? sz_02.a : sz_02.h();
        this.a = (kN[])ch_0.a(this.c, kNArray2.length + kNArray.length);
        System.arraycopy(kNArray2, 0, this.a, 0, kNArray2.length);
        System.arraycopy(kNArray, 0, this.a, kNArray2.length, kNArray.length);
    }

    @Deprecated
    private sz_0(sz_0<T> sz_02, T[] TArray) {
        this((sz_0)sz_02, (kN[])TArray, 0);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private sz_0(sz_0 sz_02, kN[] kNArray, byte by) {
        ci_0.a(sz_02);
        ci_0.a(kNArray);
        this.c = sz_02.a();
        kN<T>[] kNArray2 = sz_02 instanceof sz_0 ? sz_02.a : sz_02.h();
        this.a = (kN[])ch_0.a(this.c, kNArray2.length + kNArray.length);
        System.arraycopy(kNArray2, 0, this.a, 0, kNArray2.length);
        System.arraycopy(kNArray, 0, this.a, kNArray2.length, kNArray.length);
    }

    @Deprecated
    private sz_0(T[] TArray, sz_0<T> sz_02) {
        this((kN[])TArray, (sz_0)sz_02, 0);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private sz_0(kN[] kNArray, sz_0 sz_02, byte by) {
        ci_0.a(kNArray);
        ci_0.a(sz_02);
        this.c = sz_02.a();
        kN<T>[] kNArray2 = sz_02 instanceof sz_0 ? sz_02.a : sz_02.h();
        this.a = (kN[])ch_0.a(this.c, kNArray.length + kNArray2.length);
        System.arraycopy(kNArray, 0, this.a, 0, kNArray.length);
        System.arraycopy(kNArray2, 0, this.a, kNArray.length, kNArray2.length);
    }

    private sz_0(T[] TArray, T[] TArray2) {
        ci_0.a(TArray);
        ci_0.a(TArray2);
        if (TArray.length + TArray2.length == 0) {
            throw new pr_0(px_0.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
        }
        this.a = (kN[])ch_0.a(TArray[0].c(), TArray.length + TArray2.length);
        System.arraycopy(TArray, 0, this.a, 0, TArray.length);
        System.arraycopy(TArray2, 0, this.a, TArray.length, TArray2.length);
        this.c = this.a[0].c();
    }

    private sz_0(kM<T> kM2, T[] TArray, T[] TArray2) {
        ci_0.a(TArray);
        ci_0.a(TArray2);
        if (TArray.length + TArray2.length == 0) {
            throw new pr_0(px_0.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
        }
        this.a = (kN[])ch_0.a(kM2, TArray.length + TArray2.length);
        System.arraycopy(TArray, 0, this.a, 0, TArray.length);
        System.arraycopy(TArray2, 0, this.a, TArray.length, TArray2.length);
        this.c = kM2;
    }

    @Override
    public final kM<T> a() {
        return this.c;
    }

    @Override
    public final sT<T> b() {
        return new sz_0<T>(this, true);
    }

    @Override
    public final sT<T> a(sT<T> sT2) {
        try {
            sz_0 sz_02 = (sz_0)sT2;
            sz_0 sz_03 = this;
            sz_03.b(sz_02.a.length);
            kN[] kNArray = (kN[])ch_0.a(sz_03.c, sz_03.a.length);
            for (int i2 = 0; i2 < sz_03.a.length; ++i2) {
                kNArray[i2] = (kN)sz_03.a[i2].a(sz_02.a[i2]);
            }
            return new sz_0(sz_03.c, kNArray, false);
        }
        catch (ClassCastException classCastException) {
            this.i(sT2);
            kN[] kNArray = (kN[])ch_0.a(this.c, this.a.length);
            for (int i3 = 0; i3 < this.a.length; ++i3) {
                kNArray[i3] = (kN)this.a[i3].a(sT2.a(i3));
            }
            return new sz_0(this.c, kNArray, false);
        }
    }

    @Override
    private sz_0<T> a(sz_0<T> sz_02) {
        this.b(sz_02.a.length);
        kN[] kNArray = (kN[])ch_0.a(this.c, this.a.length);
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            kNArray[i2] = (kN)this.a[i2].a(sz_02.a[i2]);
        }
        return new sz_0(this.c, kNArray, false);
    }

    @Override
    public final sT<T> b(sT<T> sT2) {
        try {
            sz_0 sz_02 = (sz_0)sT2;
            sz_0 sz_03 = this;
            sz_03.b(sz_02.a.length);
            kN[] kNArray = (kN[])ch_0.a(sz_03.c, sz_03.a.length);
            for (int i2 = 0; i2 < sz_03.a.length; ++i2) {
                kNArray[i2] = (kN)sz_03.a[i2].b(sz_02.a[i2]);
            }
            return new sz_0(sz_03.c, kNArray, false);
        }
        catch (ClassCastException classCastException) {
            this.i(sT2);
            kN[] kNArray = (kN[])ch_0.a(this.c, this.a.length);
            for (int i3 = 0; i3 < this.a.length; ++i3) {
                kNArray[i3] = (kN)this.a[i3].b(sT2.a(i3));
            }
            return new sz_0(this.c, kNArray, false);
        }
    }

    @Override
    private sz_0<T> b(sz_0<T> sz_02) {
        this.b(sz_02.a.length);
        kN[] kNArray = (kN[])ch_0.a(this.c, this.a.length);
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            kNArray[i2] = (kN)this.a[i2].b(sz_02.a[i2]);
        }
        return new sz_0(this.c, kNArray, false);
    }

    @Override
    public final sT<T> a(T t) {
        kN[] kNArray = (kN[])ch_0.a(this.c, this.a.length);
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            kNArray[i2] = (kN)this.a[i2].a(t);
        }
        return new sz_0(this.c, kNArray, false);
    }

    @Override
    public final sT<T> b(T t) {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2] = (kN)this.a[i2].a(t);
        }
        return this;
    }

    @Override
    public final sT<T> c(T t) {
        kN[] kNArray = (kN[])ch_0.a(this.c, this.a.length);
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            kNArray[i2] = (kN)this.a[i2].b(t);
        }
        return new sz_0(this.c, kNArray, false);
    }

    @Override
    public final sT<T> d(T t) {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2] = (kN)this.a[i2].b(t);
        }
        return this;
    }

    @Override
    public final sT<T> e(T t) {
        kN[] kNArray = (kN[])ch_0.a(this.c, this.a.length);
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            kNArray[i2] = (kN)this.a[i2].c(t);
        }
        return new sz_0(this.c, kNArray, false);
    }

    @Override
    public final sT<T> f(T t) {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2] = (kN)this.a[i2].c(t);
        }
        return this;
    }

    @Override
    public final sT<T> g(T t) {
        ci_0.a(t);
        kN[] kNArray = (kN[])ch_0.a(this.c, this.a.length);
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            kNArray[i2] = (kN)this.a[i2].d(t);
        }
        return new sz_0(this.c, kNArray, false);
    }

    @Override
    public final sT<T> h(T t) {
        ci_0.a(t);
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            this.a[i2] = (kN)this.a[i2].d(t);
        }
        return this;
    }

    @Override
    public final sT<T> c() {
        kN[] kNArray = (kN[])ch_0.a(this.c, this.a.length);
        kN kN2 = (kN)this.c.b();
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            try {
                kNArray[i2] = (kN)kN2.d(this.a[i2]);
                continue;
            }
            catch (oU oU2) {
                throw new oU(px_0.INDEX, i2);
            }
        }
        return new sz_0(this.c, kNArray, false);
    }

    @Override
    public final sT<T> d() {
        kN kN2 = (kN)this.c.b();
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            try {
                this.a[i2] = (kN)kN2.d(this.a[i2]);
                continue;
            }
            catch (oU oU2) {
                throw new oU(px_0.INDEX, i2);
            }
        }
        return this;
    }

    @Override
    public final sT<T> c(sT<T> sT2) {
        try {
            sz_0 sz_02 = (sz_0)sT2;
            sz_0 sz_03 = this;
            sz_03.b(sz_02.a.length);
            kN[] kNArray = (kN[])ch_0.a(sz_03.c, sz_03.a.length);
            for (int i2 = 0; i2 < sz_03.a.length; ++i2) {
                kNArray[i2] = (kN)sz_03.a[i2].c(sz_02.a[i2]);
            }
            return new sz_0(sz_03.c, kNArray, false);
        }
        catch (ClassCastException classCastException) {
            this.i(sT2);
            kN[] kNArray = (kN[])ch_0.a(this.c, this.a.length);
            for (int i3 = 0; i3 < this.a.length; ++i3) {
                kNArray[i3] = (kN)this.a[i3].c(sT2.a(i3));
            }
            return new sz_0(this.c, kNArray, false);
        }
    }

    @Override
    private sz_0<T> c(sz_0<T> sz_02) {
        this.b(sz_02.a.length);
        kN[] kNArray = (kN[])ch_0.a(this.c, this.a.length);
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            kNArray[i2] = (kN)this.a[i2].c(sz_02.a[i2]);
        }
        return new sz_0(this.c, kNArray, false);
    }

    @Override
    public final sT<T> d(sT<T> sT2) {
        try {
            return this.d((sz_0)sT2);
        }
        catch (ClassCastException classCastException) {
            this.i(sT2);
            kN[] kNArray = (kN[])ch_0.a(this.c, this.a.length);
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                try {
                    kNArray[i2] = (kN)this.a[i2].d(sT2.a(i2));
                    continue;
                }
                catch (oU oU2) {
                    throw new oU(px_0.INDEX, i2);
                }
            }
            return new sz_0(this.c, kNArray, false);
        }
    }

    @Override
    private sz_0<T> d(sz_0<T> sz_02) {
        this.b(sz_02.a.length);
        kN[] kNArray = (kN[])ch_0.a(this.c, this.a.length);
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            try {
                kNArray[i2] = (kN)this.a[i2].d(sz_02.a[i2]);
                continue;
            }
            catch (oU oU2) {
                throw new oU(px_0.INDEX, i2);
            }
        }
        return new sz_0(this.c, kNArray, false);
    }

    @Override
    public final T[] e() {
        return (kN[])this.a.clone();
    }

    public final T[] f() {
        return this.a;
    }

    @Override
    public final T e(sT<T> sT2) {
        try {
            return this.e((sz_0)sT2);
        }
        catch (ClassCastException classCastException) {
            this.i(sT2);
            kN kN2 = (kN)this.c.a();
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                kN2 = (kN)kN2.a(this.a[i2].c(sT2.a(i2)));
            }
            return (T)kN2;
        }
    }

    @Override
    private T e(sz_0<T> sz_02) {
        this.b(sz_02.a.length);
        kN kN2 = (kN)this.c.a();
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            kN2 = (kN)kN2.a(this.a[i2].c(sz_02.a[i2]));
        }
        return (T)kN2;
    }

    @Override
    public final sT<T> f(sT<T> sT2) {
        sT<kN> sT3 = sT2;
        return sT2.e((kN)this.e(sT2).d(sT3.e(sT3)));
    }

    @Override
    private sz_0<T> f(sz_0<T> sz_02) {
        sz_0<kN> sz_03 = sz_02;
        return (sz_0)sz_02.e((kN)this.e(sz_02).d(sz_03.e(sz_03)));
    }

    @Override
    public final sQ<T> g(sT<T> sT2) {
        try {
            sz_0 sz_02 = (sz_0)sT2;
            sz_0 sz_03 = this;
            int n2 = sz_03.a.length;
            int n3 = sz_02.a.length;
            sx_0<kN> sx_02 = new sx_0<kN>(sz_03.c, n2, n3);
            for (int i2 = 0; i2 < n2; ++i2) {
                for (int i3 = 0; i3 < n3; ++i3) {
                    sx_02.a(i2, i3, (kN)sz_03.a[i2].c(sz_02.a[i3]));
                }
            }
            return sx_02;
        }
        catch (ClassCastException classCastException) {
            int n4 = this.a.length;
            int n5 = sT2.g();
            sx_0<kN> sx_03 = new sx_0<kN>(this.c, n4, n5);
            for (int i4 = 0; i4 < n4; ++i4) {
                for (int i5 = 0; i5 < n5; ++i5) {
                    sx_03.a(i4, i5, (kN)this.a[i4].c(sT2.a(i5)));
                }
            }
            return sx_03;
        }
    }

    @Override
    private sQ<T> g(sz_0<T> sz_02) {
        int n2 = this.a.length;
        int n3 = sz_02.a.length;
        sx_0<kN> sx_02 = new sx_0<kN>(this.c, n2, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                sx_02.a(i2, i3, (kN)this.a[i2].c(sz_02.a[i3]));
            }
        }
        return sx_02;
    }

    @Override
    public final T a(int n2) {
        return this.a[n2];
    }

    @Override
    public final int g() {
        return this.a.length;
    }

    @Override
    public final sT<T> h(sT<T> sT2) {
        try {
            sz_0 sz_02 = (sz_0)sT2;
            sz_0 sz_03 = this;
            return new sz_0<T>(sz_03, sz_02);
        }
        catch (ClassCastException classCastException) {
            return new sz_0<T>(this, new sz_0<T>(sT2));
        }
    }

    @Override
    private sz_0<T> h(sz_0<T> sz_02) {
        return new sz_0<T>(this, sz_02);
    }

    @Override
    public final sT<T> i(T t) {
        kN[] kNArray = (kN[])ch_0.a(this.c, this.a.length + 1);
        System.arraycopy(this.a, 0, kNArray, 0, this.a.length);
        kNArray[this.a.length] = t;
        return new sz_0(this.c, kNArray, false);
    }

    @Override
    public final sT<T> a(int n2, int n3) {
        if (n3 < 0) {
            throw new pj_0(px_0.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, n3);
        }
        sz_0<T> sz_02 = new sz_0<T>(this.c, n3);
        try {
            System.arraycopy(this.a, n2, sz_02.a, 0, n3);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.c(n2);
            this.c(n2 + n3 - 1);
        }
        return sz_02;
    }

    @Override
    public final void a(int n2, T t) {
        try {
            this.a[n2] = t;
            return;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.c(n2);
            return;
        }
    }

    @Override
    public final void a(int n2, sT<T> sT2) {
        block8: {
            try {
                try {
                    sz_0 sz_02 = (sz_0)sT2;
                    int n3 = n2;
                    sz_0 sz_03 = this;
                    try {
                        System.arraycopy(sz_02.a, 0, sz_03.a, n3, sz_02.a.length);
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        sz_03.c(n3);
                        sz_03.c(n3 + sz_02.a.length - 1);
                        break block8;
                    }
                }
                catch (ClassCastException classCastException) {
                    for (int i2 = n2; i2 < n2 + sT2.g(); ++i2) {
                        this.a[i2] = sT2.a(i2 - n2);
                    }
                }
                return;
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                this.c(n2);
                this.c(n2 + sT2.g() - 1);
            }
        }
    }

    @Override
    private void a(int n2, sz_0<T> sz_02) {
        try {
            System.arraycopy(sz_02.a, 0, this.a, n2, sz_02.a.length);
            return;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.c(n2);
            this.c(n2 + sz_02.a.length - 1);
            return;
        }
    }

    @Override
    public final void j(T t) {
        Arrays.fill(this.a, t);
    }

    @Override
    public final T[] h() {
        return (kN[])this.a.clone();
    }

    private void i(sT<T> sT2) {
        this.b(sT2.g());
    }

    private void b(int n2) {
        if (this.a.length != n2) {
            throw new oS(this.a.length, n2);
        }
    }

    private T a(sV<T> sV2) {
        sz_0 sz_02 = this;
        int n2 = sz_02.a.length;
        int n3 = 0;
        while (n3 < n2) {
            int n4 = n3++;
            sz_02 = this;
            T cfr_ignored_0 = sz_02.a[n4];
        }
        return sV2.c();
    }

    private T a(sV<T> sV2, int n2, int n3) {
        this.b(n2, n3);
        sz_0 sz_02 = this;
        int cfr_ignored_0 = sz_02.a.length;
        while (n2 <= n3) {
            int n4 = n2++;
            sz_02 = this;
            T cfr_ignored_1 = sz_02.a[n4];
        }
        return sV2.c();
    }

    private T b(sV<T> object) {
        sV<T> sV2 = object;
        Object object2 = object = this;
        int n2 = ((sz_0)object).a.length;
        int n3 = 0;
        while (n3 < n2) {
            int n4 = n3++;
            object2 = object;
            T cfr_ignored_0 = ((sz_0)object2).a[n4];
        }
        return sV2.c();
    }

    private T b(sV<T> object, int n2, int n3) {
        int n4 = n3;
        n3 = n2;
        sV<T> sV2 = object;
        object = this;
        ((sz_0)object).b(n3, n4);
        Object object2 = object;
        int cfr_ignored_0 = ((sz_0)object2).a.length;
        while (n3 <= n4) {
            int n5 = n3++;
            object2 = object;
            T cfr_ignored_1 = ((sz_0)object2).a[n5];
        }
        return sV2.c();
    }

    private T a(sU<T> sU2) {
        sz_0 sz_02 = this;
        int n2 = sz_02.a.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = i2;
            sz_02 = this;
            T cfr_ignored_0 = sz_02.a[n3];
            this.a(i2, sU2.b());
        }
        return sU2.c();
    }

    private T a(sU<T> sU2, int n2, int n3) {
        this.b(n2, n3);
        sz_0 sz_02 = this;
        int cfr_ignored_0 = sz_02.a.length;
        while (n2 <= n3) {
            int n4 = n2;
            sz_02 = this;
            T cfr_ignored_1 = sz_02.a[n4];
            this.a(n2, sU2.b());
            ++n2;
        }
        return sU2.c();
    }

    private T b(sU<T> sU2) {
        return this.a(sU2);
    }

    private T b(sU<T> sU2, int n2, int n3) {
        return this.a(sU2, n2, n3);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        try {
            sT sT2;
            sT2 = sT2;
            if (this.a.length != sT2.g()) {
                return false;
            }
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                if (this.a[i2].equals(sT2.a(i2))) continue;
                return false;
            }
            return true;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public final int hashCode() {
        int n2 = 3542;
        T[] TArray = this.a;
        int n3 = this.a.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            T t = TArray[i2];
            n2 ^= t.hashCode();
        }
        return n2;
    }

    private void c(int n2) {
        block3: {
            sz_0 sz_02;
            block2: {
                if (n2 < 0) break block2;
                sz_02 = this;
                if (n2 < sz_02.a.length) break block3;
            }
            sz_02 = this;
            throw new po_0(px_0.INDEX, (Number)n2, 0, sz_02.a.length - 1);
        }
    }

    private void b(int n2, int n3) {
        sz_0 sz_02 = this;
        int n4 = sz_02.a.length;
        if (n2 < 0 || n2 >= n4) {
            throw new po_0(px_0.INDEX, (Number)n2, 0, n4 - 1);
        }
        if (n3 < 0 || n3 >= n4) {
            throw new po_0(px_0.INDEX, (Number)n3, 0, n4 - 1);
        }
        if (n3 < n2) {
            throw new pn_0((pw_0)px_0.INITIAL_ROW_AFTER_FINAL_ROW, (Number)n3, n2, false);
        }
    }
}


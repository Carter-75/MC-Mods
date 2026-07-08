/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.Cn
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.Cn;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Cn
 */
public final class cn_0<T extends kN<T>>
implements Serializable {
    private static byte a = 0;
    private static byte b = 1;
    private static byte c = 2;
    private static final long d = -9179080286849120720L;
    private static final float e = 0.5f;
    private static final int f = 16;
    private static final int g = 2;
    private static final int h = 5;
    private final kM<T> i;
    private int[] j;
    private T[] k;
    private byte[] l;
    private final T m;
    private int n;
    private int o;
    private transient int p;

    public cn_0(kM<T> kM2) {
        this(kM2, 16, (kN)kM2.a());
    }

    private cn_0(kM<T> kM2, T t) {
        this(kM2, 16, t);
    }

    public cn_0(kM<T> kM2, int n2) {
        this(kM2, n2, (kN)kM2.a());
    }

    private cn_0(kM<T> kM2, int n2, T t) {
        this.i = kM2;
        int n3 = n2;
        n3 = n3 == 0 ? 1 : ((n2 = Integer.highestOneBit(n3 = (int)BY.z((float)n3 / 0.5f))) == n3 ? n3 : Integer.highestOneBit(n3) << 1);
        this.j = new int[n3];
        this.k = this.k(n3);
        this.l = new byte[n3];
        this.m = t;
        this.o = n3 - 1;
    }

    public cn_0(cn_0<T> cn_02) {
        this.i = cn_02.i;
        int n2 = cn_02.j.length;
        this.j = new int[n2];
        System.arraycopy(cn_02.j, 0, this.j, 0, n2);
        this.k = this.k(n2);
        System.arraycopy(cn_02.k, 0, this.k, 0, n2);
        this.l = new byte[n2];
        System.arraycopy(cn_02.l, 0, this.l, 0, n2);
        this.m = cn_02.m;
        this.n = cn_02.n;
        this.o = cn_02.o;
        this.p = cn_02.p;
    }

    private static int d(int n2) {
        if (n2 == 0) {
            return 1;
        }
        int n3 = Integer.highestOneBit(n2 = (int)BY.z((float)n2 / 0.5f));
        if (n3 == n2) {
            return n2;
        }
        return Integer.highestOneBit(n2) << 1;
    }

    private static int e(int n2) {
        return Integer.highestOneBit(n2) << 1;
    }

    public final T a(int n2) {
        int n3 = cn_0.j(n2);
        int n4 = n3 & this.o;
        if (this.b(n2, n4)) {
            return this.k[n4];
        }
        if (this.l[n4] == 0) {
            return this.m;
        }
        int n5 = n4;
        n3 &= Integer.MAX_VALUE;
        while (this.l[n4] != 0) {
            n4 = (n5 = cn_0.a(n3, n5)) & this.o;
            if (this.b(n2, n4)) {
                return this.k[n4];
            }
            n3 >>= 5;
        }
        return this.m;
    }

    public final boolean b(int n2) {
        int n3 = cn_0.j(n2);
        int n4 = n3 & this.o;
        if (this.b(n2, n4)) {
            return true;
        }
        if (this.l[n4] == 0) {
            return false;
        }
        int n5 = n4;
        n3 &= Integer.MAX_VALUE;
        while (this.l[n4] != 0) {
            n4 = (n5 = cn_0.a(n3, n5)) & this.o;
            if (this.b(n2, n4)) {
                return true;
            }
            n3 >>= 5;
        }
        return false;
    }

    public final a a() {
        return new a(this, 0);
    }

    private static int f(int n2) {
        return n2 & Integer.MAX_VALUE;
    }

    private int g(int n2) {
        return cn_0.a(this.j, this.l, n2, this.o);
    }

    private static int a(int[] nArray, byte[] byArray, int n2, int n3) {
        int n4 = cn_0.j(n2);
        int n5 = n4 & n3;
        if (byArray[n5] == 0) {
            return n5;
        }
        if (byArray[n5] == 1 && nArray[n5] == n2) {
            n4 = n5;
            return -n4 - 1;
        }
        n4 &= Integer.MAX_VALUE;
        int n6 = n5;
        if (byArray[n5] == 1) {
            do {
                n6 = cn_0.a(n4, n6);
                n5 = n6 & n3;
                n4 >>= 5;
            } while (byArray[n5] == 1 && nArray[n5] != n2);
        }
        if (byArray[n5] == 0) {
            return n5;
        }
        if (byArray[n5] == 1) {
            n4 = n5;
            return -n4 - 1;
        }
        int n7 = n5;
        while (byArray[n5 = (n6 = cn_0.a(n4, n6)) & n3] != 0) {
            if (byArray[n5] == 1 && nArray[n5] == n2) {
                n4 = n5;
                return -n4 - 1;
            }
            n4 >>= 5;
        }
        return n7;
    }

    private static int a(int n2, int n3) {
        return (n3 << 2) + n3 + n2 + 1;
    }

    private static int h(int n2) {
        return -n2 - 1;
    }

    private int b() {
        return this.n;
    }

    public final T c(int n2) {
        int n3 = cn_0.j(n2);
        int n4 = n3 & this.o;
        if (this.b(n2, n4)) {
            return this.i(n4);
        }
        if (this.l[n4] == 0) {
            return this.m;
        }
        int n5 = n4;
        n3 &= Integer.MAX_VALUE;
        while (this.l[n4] != 0) {
            n4 = (n5 = cn_0.a(n3, n5)) & this.o;
            if (this.b(n2, n4)) {
                return this.i(n4);
            }
            n3 >>= 5;
        }
        return this.m;
    }

    private boolean b(int n2, int n3) {
        return (n2 != 0 || this.l[n3] == 1) && this.j[n3] == n2;
    }

    private T i(int n2) {
        this.j[n2] = 0;
        this.l[n2] = 2;
        T t = this.k[n2];
        this.k[n2] = this.m;
        --this.n;
        ++this.p;
        return t;
    }

    public final T a(int n2, T t) {
        int n3 = this.g(n2);
        T t2 = this.m;
        boolean bl = true;
        if (n3 < 0) {
            n3 = -n3 - 1;
            t2 = this.k[n3];
            bl = false;
        }
        this.j[n3] = n2;
        this.l[n3] = 1;
        this.k[n3] = t;
        if (bl) {
            ++this.n;
            if (this.d()) {
                this.c();
            }
            ++this.p;
        }
        return t2;
    }

    private void c() {
        int n2 = this.l.length;
        int[] nArray = this.j;
        T[] TArray = this.k;
        byte[] byArray = this.l;
        int n3 = 2 * n2;
        int[] nArray2 = new int[n3];
        kN[] kNArray = this.k(n3);
        byte[] byArray2 = new byte[n3];
        --n3;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (byArray[i2] != 1) continue;
            int n4 = nArray[i2];
            int n5 = cn_0.a(nArray2, byArray2, n4, n3);
            nArray2[n5] = n4;
            kNArray[n5] = TArray[i2];
            byArray2[n5] = 1;
        }
        this.o = n3;
        this.j = nArray2;
        this.k = kNArray;
        this.l = byArray2;
    }

    private boolean d() {
        return (float)this.n > (float)(this.o + 1) * 0.5f;
    }

    private static int j(int n2) {
        int n3 = n2;
        n2 = n3 ^ (n3 >>> 20 ^ n2 >>> 12);
        return n2 ^ n2 >>> 7 ^ n2 >>> 4;
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.p = 0;
    }

    private T[] k(int n2) {
        return (kN[])Array.newInstance(this.i.c(), n2);
    }

    static /* synthetic */ int a(cn_0 cn_02) {
        return cn_02.p;
    }

    static /* synthetic */ int[] b(cn_0 cn_02) {
        return cn_02.j;
    }

    static /* synthetic */ kN[] c(cn_0 cn_02) {
        return cn_02.k;
    }

    static /* synthetic */ byte[] d(cn_0 cn_02) {
        return cn_02.l;
    }

    static final class 1 {
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public final class a {
        private final int a;
        private int b;
        private int c;
        private /* synthetic */ cn_0 d;

        private a(cn_0 cn_02) {
            this.d = cn_02;
            this.a = Cn.a((cn_0)cn_02);
            this.c = -1;
            try {
                this.d();
                return;
            }
            catch (NoSuchElementException noSuchElementException) {
                return;
            }
        }

        public final boolean a() {
            return this.c >= 0;
        }

        public final int b() {
            if (this.a != Cn.a((cn_0)this.d)) {
                throw new ConcurrentModificationException();
            }
            if (this.b < 0) {
                throw new NoSuchElementException();
            }
            return Cn.b((cn_0)this.d)[this.b];
        }

        public final T c() {
            if (this.a != Cn.a((cn_0)this.d)) {
                throw new ConcurrentModificationException();
            }
            if (this.b < 0) {
                throw new NoSuchElementException();
            }
            return Cn.c((cn_0)this.d)[this.b];
        }

        public final void d() {
            if (this.a != Cn.a((cn_0)this.d)) {
                throw new ConcurrentModificationException();
            }
            this.b = this.c;
            try {
                while (Cn.d((cn_0)this.d)[++this.c] != 1) {
                }
                return;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                this.c = -2;
                if (this.b < 0) {
                    throw new NoSuchElementException();
                }
                return;
            }
        }

        /* synthetic */ a(cn_0 cn_02, byte by) {
            this(cn_02);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.Cm
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.Cm;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Cm
 */
public final class cm_0
implements Serializable {
    private static byte b = 0;
    private static byte c = 1;
    private static byte d = 2;
    private static final long e = -3646337053166149105L;
    private static final float f = 0.5f;
    private static final int g = 16;
    private static final int h = 2;
    private static final int i = 5;
    private int[] j;
    private double[] k;
    private byte[] l;
    private final double m;
    public int a;
    private int n;
    private transient int o;

    public cm_0() {
        this(16, Double.NaN);
    }

    public cm_0(double d2) {
        this(16, 0.0);
    }

    private cm_0(int n2) {
        this(n2, Double.NaN);
    }

    public cm_0(int n2, double d2) {
        int n3;
        n2 = n2 == 0 ? 1 : ((n3 = Integer.highestOneBit(n2 = (int)BY.z((float)n2 / 0.5f))) == n2 ? n2 : Integer.highestOneBit(n2) << 1);
        this.j = new int[n2];
        this.k = new double[n2];
        this.l = new byte[n2];
        this.m = d2;
        this.n = n2 - 1;
    }

    public cm_0(cm_0 cm_02) {
        int n2 = cm_02.j.length;
        this.j = new int[n2];
        System.arraycopy(cm_02.j, 0, this.j, 0, n2);
        this.k = new double[n2];
        System.arraycopy(cm_02.k, 0, this.k, 0, n2);
        this.l = new byte[n2];
        System.arraycopy(cm_02.l, 0, this.l, 0, n2);
        this.m = cm_02.m;
        this.a = cm_02.a;
        this.n = cm_02.n;
        this.o = cm_02.o;
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

    public final double a(int n2) {
        int n3 = cm_0.j(n2);
        int n4 = n3 & this.n;
        if (this.b(n2, n4)) {
            return this.k[n4];
        }
        if (this.l[n4] == 0) {
            return this.m;
        }
        int n5 = n4;
        n3 &= Integer.MAX_VALUE;
        while (this.l[n4] != 0) {
            n4 = (n5 = cm_0.a(n3, n5)) & this.n;
            if (this.b(n2, n4)) {
                return this.k[n4];
            }
            n3 >>= 5;
        }
        return this.m;
    }

    public final boolean b(int n2) {
        int n3 = cm_0.j(n2);
        int n4 = n3 & this.n;
        if (this.b(n2, n4)) {
            return true;
        }
        if (this.l[n4] == 0) {
            return false;
        }
        int n5 = n4;
        n3 &= Integer.MAX_VALUE;
        while (this.l[n4] != 0) {
            n4 = (n5 = cm_0.a(n3, n5)) & this.n;
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
        return cm_0.a(this.j, this.l, n2, this.n);
    }

    private static int a(int[] nArray, byte[] byArray, int n2, int n3) {
        int n4 = cm_0.j(n2);
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
                n6 = cm_0.a(n4, n6);
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
        while (byArray[n5 = (n6 = cm_0.a(n4, n6)) & n3] != 0) {
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

    public final int b() {
        return this.a;
    }

    public final double c(int n2) {
        int n3 = cm_0.j(n2);
        int n4 = n3 & this.n;
        if (this.b(n2, n4)) {
            return this.i(n4);
        }
        if (this.l[n4] == 0) {
            return this.m;
        }
        int n5 = n4;
        n3 &= Integer.MAX_VALUE;
        while (this.l[n4] != 0) {
            n4 = (n5 = cm_0.a(n3, n5)) & this.n;
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

    private double i(int n2) {
        this.j[n2] = 0;
        this.l[n2] = 2;
        double d2 = this.k[n2];
        this.k[n2] = this.m;
        --this.a;
        ++this.o;
        return d2;
    }

    public final double a(int n2, double d2) {
        int n3 = this.g(n2);
        double d3 = this.m;
        boolean bl = true;
        if (n3 < 0) {
            n3 = -n3 - 1;
            d3 = this.k[n3];
            bl = false;
        }
        this.j[n3] = n2;
        this.l[n3] = 1;
        this.k[n3] = d2;
        if (bl) {
            ++this.a;
            if (this.d()) {
                this.c();
            }
            ++this.o;
        }
        return d3;
    }

    private void c() {
        int n2 = this.l.length;
        int[] nArray = this.j;
        double[] dArray = this.k;
        byte[] byArray = this.l;
        int n3 = 2 * n2;
        int[] nArray2 = new int[n3];
        double[] dArray2 = new double[n3];
        byte[] byArray2 = new byte[n3];
        --n3;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (byArray[i2] != 1) continue;
            int n4 = nArray[i2];
            int n5 = cm_0.a(nArray2, byArray2, n4, n3);
            nArray2[n5] = n4;
            dArray2[n5] = dArray[i2];
            byArray2[n5] = 1;
        }
        this.n = n3;
        this.j = nArray2;
        this.k = dArray2;
        this.l = byArray2;
    }

    private boolean d() {
        return (float)this.a > (float)(this.n + 1) * 0.5f;
    }

    private static int j(int n2) {
        int n3 = n2;
        n2 = n3 ^ (n3 >>> 20 ^ n2 >>> 12);
        return n2 ^ n2 >>> 7 ^ n2 >>> 4;
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.o = 0;
    }

    static /* synthetic */ int a(cm_0 cm_02) {
        return cm_02.o;
    }

    static /* synthetic */ int[] b(cm_0 cm_02) {
        return cm_02.j;
    }

    static /* synthetic */ double[] c(cm_0 cm_02) {
        return cm_02.k;
    }

    static /* synthetic */ byte[] d(cm_0 cm_02) {
        return cm_02.l;
    }

    static final class 1 {
    }

    public final class a {
        private final int a;
        private int b;
        private int c;
        private /* synthetic */ cm_0 d;

        private a(cm_0 cm_02) {
            this.d = cm_02;
            this.a = Cm.a((cm_0)cm_02);
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
            if (this.a != Cm.a((cm_0)this.d)) {
                throw new ConcurrentModificationException();
            }
            if (this.b < 0) {
                throw new NoSuchElementException();
            }
            return Cm.b((cm_0)this.d)[this.b];
        }

        public final double c() {
            if (this.a != Cm.a((cm_0)this.d)) {
                throw new ConcurrentModificationException();
            }
            if (this.b < 0) {
                throw new NoSuchElementException();
            }
            return Cm.c((cm_0)this.d)[this.b];
        }

        public final void d() {
            if (this.a != Cm.a((cm_0)this.d)) {
                throw new ConcurrentModificationException();
            }
            this.b = this.c;
            try {
                while (Cm.d((cm_0)this.d)[++this.c] != 1) {
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

        /* synthetic */ a(cm_0 cm_02, byte by) {
            this(cm_02);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.sO;
import org.valkyrienskies.core.impl.shadow.sQ;
import org.valkyrienskies.core.impl.shadow.sx_0;
import org.valkyrienskies.core.impl.shadow.sz_0;
import org.valkyrienskies.core.impl.shadow.tA;
import org.valkyrienskies.core.impl.shadow.th_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class sP<T extends kN<T>> {
    private final kM<T> a;
    private T[][] b;
    private int[] c;
    private boolean d;
    private boolean e;
    private sQ<T> f;
    private sQ<T> g;
    private sQ<T> h;

    public sP(sQ<T> sQ2) {
        if (!sQ2.e()) {
            throw new th_0(sQ2.f(), sQ2.g());
        }
        int n2 = sQ2.g();
        this.a = sQ2.a();
        this.b = sQ2.c();
        this.c = new int[n2];
        this.f = null;
        this.g = null;
        this.h = null;
        int n3 = 0;
        while (n3 < n2) {
            int n4 = n3++;
            this.c[n4] = n4;
        }
        this.d = true;
        this.e = false;
        for (n3 = 0; n3 < n2; ++n3) {
            int n5;
            Object object;
            Object object2;
            int n6;
            kN cfr_ignored_0 = (kN)this.a.a();
            for (n6 = 0; n6 < n3; ++n6) {
                object2 = this.b[n6];
                object = object2[n3];
                for (n5 = 0; n5 < n6; ++n5) {
                    object = (kN)object.b(object2[n5].c(this.b[n5][n3]));
                }
                object2[n3] = object;
            }
            n6 = n3;
            for (int i2 = n3; i2 < n2; ++i2) {
                T[] TArray = this.b[i2];
                object = TArray[n3];
                for (int i3 = 0; i3 < n3; ++i3) {
                    object = (kN)object.b(TArray[i3].c(this.b[i3][n3]));
                }
                TArray[n3] = object;
                if (!this.b[n6][n3].equals(this.a.a())) continue;
                ++n6;
            }
            if (n6 >= n2) {
                this.e = true;
                return;
            }
            if (n6 != n3) {
                int n7;
                kN cfr_ignored_1 = (kN)this.a.a();
                for (n7 = 0; n7 < n2; ++n7) {
                    T t = this.b[n6][n7];
                    this.b[n6][n7] = this.b[n3][n7];
                    this.b[n3][n7] = t;
                }
                n7 = this.c[n6];
                this.c[n6] = this.c[n3];
                this.c[n3] = n7;
                this.d = !this.d;
            }
            object2 = this.b[n3][n3];
            for (n5 = n3 + 1; n5 < n2; ++n5) {
                T[] TArray = this.b[n5];
                T[] TArray2 = TArray;
                TArray[n3] = (kN)TArray2[n3].d(object2);
            }
        }
    }

    private sQ<T> b() {
        if (this.f == null && !this.e) {
            int n2;
            int n3 = n2 = this.c.length;
            this.f = new sx_0<T>(this.a, n3, n3);
            int n4 = 0;
            while (n4 < n2) {
                T[] TArray = this.b[n4];
                for (int i2 = 0; i2 < n4; ++i2) {
                    this.f.a(n4, i2, TArray[i2]);
                }
                int n5 = n4++;
                this.f.a(n5, n5, (kN)this.a.b());
            }
        }
        return this.f;
    }

    private sQ<T> c() {
        if (this.g == null && !this.e) {
            int n2;
            int n3 = n2 = this.c.length;
            this.g = new sx_0<T>(this.a, n3, n3);
            for (int i2 = 0; i2 < n2; ++i2) {
                T[] TArray = this.b[i2];
                for (int i3 = i2; i3 < n2; ++i3) {
                    this.g.a(i2, i3, TArray[i3]);
                }
            }
        }
        return this.g;
    }

    private sQ<T> d() {
        if (this.h == null && !this.e) {
            int n2;
            int n3 = n2 = this.c.length;
            this.h = new sx_0<T>(this.a, n3, n3);
            for (int i2 = 0; i2 < n2; ++i2) {
                this.h.a(i2, this.c[i2], (kN)this.a.b());
            }
        }
        return this.h;
    }

    private int[] e() {
        return (int[])this.c.clone();
    }

    private T f() {
        if (this.e) {
            return (T)((kN)this.a.a());
        }
        int n2 = this.c.length;
        kN kN2 = this.d ? (kN)this.a.b() : (kN)((kN)this.a.a()).b(this.a.b());
        for (int i2 = 0; i2 < n2; ++i2) {
            kN2 = (kN)kN2.c(this.b[i2][i2]);
        }
        return (T)kN2;
    }

    public final sO<T> a() {
        return new a(this.a, (kN[][])this.b, this.c, this.e, 0);
    }

    static final class 1 {
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class a<T extends kN<T>>
    implements sO<T> {
        private final kM<T> a;
        private final T[][] b;
        private final int[] c;
        private final boolean d;

        private a(kM<T> kM2, T[][] TArray, int[] nArray, boolean bl) {
            this.a = kM2;
            this.b = TArray;
            this.c = nArray;
            this.d = bl;
        }

        @Override
        public final boolean a() {
            return !this.d;
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        @Override
        public final sz_0 a(sz_0 object) {
            try {
                int n2;
                Object object2 = object;
                a a2 = this;
                int n3 = a2.c.length;
                sz_0 sz_02 = object2;
                int n4 = sz_02.a.length;
                if (n4 != n3) {
                    throw new oS(n4, n3);
                }
                if (a2.d) {
                    throw new tA();
                }
                kN[] kNArray = (kN[])ch_0.a(a2.a, n3);
                for (n2 = 0; n2 < n3; ++n2) {
                    int n5 = a2.c[n2];
                    sz_02 = object2;
                    kNArray[n2] = sz_02.a[n5];
                }
                for (n2 = 0; n2 < n3; ++n2) {
                    object2 = kNArray[n2];
                    for (int i2 = n2 + 1; i2 < n3; ++i2) {
                        kNArray[i2] = (kN)kNArray[i2].b(object2.c(a2.b[i2][n2]));
                    }
                }
                for (n2 = n3 - 1; n2 >= 0; --n2) {
                    kNArray[n2] = (kN)kNArray[n2].d(a2.b[n2][n2]);
                    object2 = kNArray[n2];
                    for (int i3 = 0; i3 < n2; ++i3) {
                        kNArray[i3] = (kN)kNArray[i3].b(object2.c(a2.b[i3][n2]));
                    }
                }
                return new sz_0(kNArray, false);
            }
            catch (ClassCastException classCastException) {
                int n6;
                int n7;
                int n8 = this.c.length;
                if (object.g() != n8) {
                    throw new oS(object.g(), n8);
                }
                if (this.d) {
                    throw new tA();
                }
                kN[] kNArray = (kN[])ch_0.a(this.a, n8);
                for (n7 = 0; n7 < n8; ++n7) {
                    kNArray[n7] = object.a(this.c[n7]);
                }
                for (n7 = 0; n7 < n8; ++n7) {
                    object = kNArray[n7];
                    for (n6 = n7 + 1; n6 < n8; ++n6) {
                        kNArray[n6] = (kN)kNArray[n6].b(object.c(this.b[n6][n7]));
                    }
                }
                for (n7 = n8 - 1; n7 >= 0; --n7) {
                    kNArray[n7] = (kN)kNArray[n7].d(this.b[n7][n7]);
                    object = kNArray[n7];
                    for (n6 = 0; n6 < n7; ++n6) {
                        kNArray[n6] = (kN)kNArray[n6].b(object.c(this.b[n6][n7]));
                    }
                }
                return new sz_0(this.a, kNArray, false);
            }
        }

        private sz_0<T> b(sz_0<T> object) {
            int n2;
            int n3 = this.c.length;
            sz_0<T> sz_02 = object;
            int n4 = sz_02.a.length;
            if (n4 != n3) {
                throw new oS(n4, n3);
            }
            if (this.d) {
                throw new tA();
            }
            kN[] kNArray = (kN[])ch_0.a(this.a, n3);
            for (n2 = 0; n2 < n3; ++n2) {
                int n5 = this.c[n2];
                sz_02 = object;
                kNArray[n2] = sz_02.a[n5];
            }
            for (n2 = 0; n2 < n3; ++n2) {
                object = kNArray[n2];
                for (int i2 = n2 + 1; i2 < n3; ++i2) {
                    kNArray[i2] = (kN)kNArray[i2].b(object.c(this.b[i2][n2]));
                }
            }
            for (n2 = n3 - 1; n2 >= 0; --n2) {
                kNArray[n2] = (kN)kNArray[n2].d(this.b[n2][n2]);
                object = kNArray[n2];
                for (int i3 = 0; i3 < n2; ++i3) {
                    kNArray[i3] = (kN)kNArray[i3].b(object.c(this.b[i3][n2]));
                }
            }
            return new sz_0(kNArray, false);
        }

        /*
         * Ignored method signature, as it can't be verified against descriptor
         */
        @Override
        public final sx_0 a(sx_0 kNArray) {
            int n2;
            kN[] kNArray2;
            int n3;
            int n4 = this.c.length;
            if (kNArray.f() != n4) {
                throw new oS(kNArray.f(), n4);
            }
            if (this.d) {
                throw new tA();
            }
            int n5 = kNArray.g();
            kN[][] kNArray3 = (kN[][])ch_0.a(this.a, n4, n5);
            for (n3 = 0; n3 < n4; ++n3) {
                kNArray2 = kNArray3[n3];
                n2 = this.c[n3];
                for (int i2 = 0; i2 < n5; ++i2) {
                    kNArray2[i2] = kNArray.b(n2, i2);
                }
            }
            for (n3 = 0; n3 < n4; ++n3) {
                kNArray2 = kNArray3[n3];
                for (n2 = n3 + 1; n2 < n4; ++n2) {
                    kN[] kNArray4 = kNArray3[n2];
                    kNArray = this.b[n2][n3];
                    for (int i3 = 0; i3 < n5; ++i3) {
                        kNArray4[i3] = (kN)kNArray4[i3].b(kNArray2[i3].c(kNArray));
                    }
                }
            }
            for (n3 = n4 - 1; n3 >= 0; --n3) {
                int n6;
                kNArray2 = kNArray3[n3];
                T t = this.b[n3][n3];
                for (n6 = 0; n6 < n5; ++n6) {
                    kNArray2[n6] = (kN)kNArray2[n6].d(t);
                }
                for (n6 = 0; n6 < n3; ++n6) {
                    kNArray = kNArray3[n6];
                    T t2 = this.b[n6][n3];
                    for (n4 = 0; n4 < n5; ++n4) {
                        kNArray[n4] = (kN)kNArray[n4].b(kNArray2[n4].c(t2));
                    }
                }
            }
            return new sx_0(this.a, kNArray3, false);
        }

        @Override
        public final sQ<T> b() {
            int n2 = this.c.length;
            kN kN2 = (kN)this.a.b();
            int n3 = n2;
            sx_0<kN> sx_02 = new sx_0<kN>(this.a, n3, n3);
            int n4 = 0;
            while (n4 < n2) {
                int n5 = n4++;
                sx_02.a(n5, n5, kN2);
            }
            return this.a(sx_02);
        }

        /* synthetic */ a(kM kM2, kN[][] kNArray, int[] nArray, boolean bl, byte by) {
            this(kM2, kNArray, nArray, bl);
        }
    }
}


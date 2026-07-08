/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.sQ;
import org.valkyrienskies.core.impl.shadow.sR;
import org.valkyrienskies.core.impl.shadow.sS;
import org.valkyrienskies.core.impl.shadow.sT;
import org.valkyrienskies.core.impl.shadow.su_0;
import org.valkyrienskies.core.impl.shadow.sz_0;
import org.valkyrienskies.core.impl.shadow.tc_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class sC<T extends kN<T>>
extends su_0<T>
implements Serializable {
    private static int a = 36;
    private static final long b = -4602336630143123183L;
    private final T[][] c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public sC(kM<T> kM2, int n2, int n3) {
        super(kM2, n2, n3);
        this.d = n2;
        this.e = n3;
        this.f = (n2 + 36 - 1) / 36;
        this.g = (n3 + 36 - 1) / 36;
        int n4 = (n2 + 36 - 1) / 36;
        int n5 = (n3 + 36 - 1) / 36;
        kN[][] kNArray = (kN[][])ch_0.a(kM2, n4 * n5, -1);
        int n6 = 0;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n7 = i2 * 36;
            int n8 = BY.a(n7 + 36, n2);
            n7 = n8 - n7;
            for (n8 = 0; n8 < n5; ++n8) {
                int n9 = n8 * 36;
                int n10 = BY.a(n9 + 36, n3);
                n9 = n10 - n9;
                kNArray[n6] = (kN[])ch_0.a(kM2, n7 * n9);
                ++n6;
            }
        }
        this.c = kNArray;
    }

    public sC(T[][] TArray) {
        this(TArray.length, TArray[0].length, sC.b(TArray), false);
    }

    private sC(int n2, int n3, T[][] TArray, boolean bl) {
        super(sC.a(TArray), n2, n3);
        this.d = n2;
        this.e = n3;
        this.f = (n2 + 36 - 1) / 36;
        this.g = (n3 + 36 - 1) / 36;
        this.c = TArray;
        n2 = 0;
        for (n3 = 0; n3 < this.f; ++n3) {
            int n4 = this.j(n3);
            int n5 = 0;
            while (n5 < this.g) {
                if (TArray[n2].length != n4 * this.k(n5)) {
                    throw new oS(TArray[n2].length, n4 * this.k(n5));
                }
                ++n5;
                ++n2;
            }
        }
    }

    private static <T extends kN<T>> T[][] b(T[][] TArray) {
        int n2 = TArray.length;
        int n3 = TArray[0].length;
        int n4 = (n2 + 36 - 1) / 36;
        int n5 = (n3 + 36 - 1) / 36;
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            int n6 = TArray[i2].length;
            if (n6 == n3) continue;
            throw new oS(n3, n6);
        }
        kM kM2 = sC.a(TArray);
        kN[][] kNArray = (kN[][])ch_0.a(kM2, n4 * n5, -1);
        int n7 = 0;
        for (int i3 = 0; i3 < n4; ++i3) {
            int n8 = i3 * 36;
            int n9 = BY.a(n8 + 36, n2);
            int n10 = n9 - n8;
            for (int i4 = 0; i4 < n5; ++i4) {
                int n11 = i4 * 36;
                int n12 = BY.a(n11 + 36, n3);
                kN[] kNArray2 = (kN[])ch_0.a(kM2, n10 * (n12 -= n11));
                kNArray[n7] = kNArray2;
                int n13 = 0;
                for (int i5 = n8; i5 < n9; ++i5) {
                    System.arraycopy(TArray[i5], n11, kNArray2, n13, n12);
                    n13 += n12;
                }
                ++n7;
            }
        }
        return kNArray;
    }

    private static <T extends kN<T>> T[][] a(kM<T> kM2, int n2, int n3) {
        int n4 = (n2 + 36 - 1) / 36;
        int n5 = (n3 + 36 - 1) / 36;
        kN[][] kNArray = (kN[][])ch_0.a(kM2, n4 * n5, -1);
        int n6 = 0;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n7 = i2 * 36;
            int n8 = BY.a(n7 + 36, n2);
            n7 = n8 - n7;
            for (n8 = 0; n8 < n5; ++n8) {
                int n9 = n8 * 36;
                int n10 = BY.a(n9 + 36, n3);
                n9 = n10 - n9;
                kNArray[n6] = (kN[])ch_0.a(kM2, n7 * n9);
                ++n6;
            }
        }
        return kNArray;
    }

    @Override
    public final sQ<T> a(int n2, int n3) {
        return new sC(this.a(), n2, n3);
    }

    @Override
    public final sQ<T> b() {
        sC sC2 = new sC(this.a(), this.d, this.e);
        for (int i2 = 0; i2 < this.c.length; ++i2) {
            System.arraycopy(this.c[i2], 0, sC2.c[i2], 0, this.c[i2].length);
        }
        return sC2;
    }

    @Override
    public final sQ<T> a(sQ<T> sQ2) {
        try {
            sC sC2 = (sC)sQ2;
            sC sC3 = this;
            sC3.e(sC2);
            sC sC4 = new sC(sC3.a(), sC3.d, sC3.e);
            for (int i2 = 0; i2 < sC4.c.length; ++i2) {
                T[] TArray = sC4.c[i2];
                T[] TArray2 = sC3.c[i2];
                T[] TArray3 = sC2.c[i2];
                for (int i3 = 0; i3 < TArray.length; ++i3) {
                    TArray[i3] = (kN)TArray2[i3].a(TArray3[i3]);
                }
            }
            return sC4;
        }
        catch (ClassCastException classCastException) {
            this.e(sQ2);
            sC sC5 = new sC(this.a(), this.d, this.e);
            int n2 = 0;
            for (int i4 = 0; i4 < sC5.f; ++i4) {
                for (int i5 = 0; i5 < sC5.g; ++i5) {
                    T[] TArray = sC5.c[n2];
                    T[] TArray4 = this.c[n2];
                    int n3 = i4 * 36;
                    int n4 = BY.a(n3 + 36, this.d);
                    int n5 = i5 * 36;
                    int n6 = BY.a(n5 + 36, this.e);
                    int n7 = 0;
                    while (n3 < n4) {
                        for (int i6 = n5; i6 < n6; ++i6) {
                            TArray[n7] = (kN)TArray4[n7].a(sQ2.b(n3, i6));
                            ++n7;
                        }
                        ++n3;
                    }
                    ++n2;
                }
            }
            return sC5;
        }
    }

    @Override
    private sC<T> a(sC<T> sC2) {
        this.e(sC2);
        sC sC3 = new sC(this.a(), this.d, this.e);
        for (int i2 = 0; i2 < sC3.c.length; ++i2) {
            T[] TArray = sC3.c[i2];
            T[] TArray2 = this.c[i2];
            T[] TArray3 = sC2.c[i2];
            for (int i3 = 0; i3 < TArray.length; ++i3) {
                TArray[i3] = (kN)TArray2[i3].a(TArray3[i3]);
            }
        }
        return sC3;
    }

    @Override
    public final sQ<T> b(sQ<T> sQ2) {
        try {
            sC sC2 = (sC)sQ2;
            sC sC3 = this;
            sC3.f(sC2);
            sC sC4 = new sC(sC3.a(), sC3.d, sC3.e);
            for (int i2 = 0; i2 < sC4.c.length; ++i2) {
                T[] TArray = sC4.c[i2];
                T[] TArray2 = sC3.c[i2];
                T[] TArray3 = sC2.c[i2];
                for (int i3 = 0; i3 < TArray.length; ++i3) {
                    TArray[i3] = (kN)TArray2[i3].b(TArray3[i3]);
                }
            }
            return sC4;
        }
        catch (ClassCastException classCastException) {
            this.f(sQ2);
            sC sC5 = new sC(this.a(), this.d, this.e);
            int n2 = 0;
            for (int i4 = 0; i4 < sC5.f; ++i4) {
                for (int i5 = 0; i5 < sC5.g; ++i5) {
                    T[] TArray = sC5.c[n2];
                    T[] TArray4 = this.c[n2];
                    int n3 = i4 * 36;
                    int n4 = BY.a(n3 + 36, this.d);
                    int n5 = i5 * 36;
                    int n6 = BY.a(n5 + 36, this.e);
                    int n7 = 0;
                    while (n3 < n4) {
                        for (int i6 = n5; i6 < n6; ++i6) {
                            TArray[n7] = (kN)TArray4[n7].b(sQ2.b(n3, i6));
                            ++n7;
                        }
                        ++n3;
                    }
                    ++n2;
                }
            }
            return sC5;
        }
    }

    @Override
    private sC<T> b(sC<T> sC2) {
        this.f(sC2);
        sC sC3 = new sC(this.a(), this.d, this.e);
        for (int i2 = 0; i2 < sC3.c.length; ++i2) {
            T[] TArray = sC3.c[i2];
            T[] TArray2 = this.c[i2];
            T[] TArray3 = sC2.c[i2];
            for (int i3 = 0; i3 < TArray.length; ++i3) {
                TArray[i3] = (kN)TArray2[i3].b(TArray3[i3]);
            }
        }
        return sC3;
    }

    @Override
    public final sQ<T> a(T t) {
        sC sC2 = new sC(this.a(), this.d, this.e);
        for (int i2 = 0; i2 < sC2.c.length; ++i2) {
            T[] TArray = sC2.c[i2];
            T[] TArray2 = this.c[i2];
            for (int i3 = 0; i3 < TArray.length; ++i3) {
                TArray[i3] = (kN)TArray2[i3].a(t);
            }
        }
        return sC2;
    }

    @Override
    public final sQ<T> b(T t) {
        sC sC2 = new sC(this.a(), this.d, this.e);
        for (int i2 = 0; i2 < sC2.c.length; ++i2) {
            T[] TArray = sC2.c[i2];
            T[] TArray2 = this.c[i2];
            for (int i3 = 0; i3 < TArray.length; ++i3) {
                TArray[i3] = (kN)TArray2[i3].c(t);
            }
        }
        return sC2;
    }

    @Override
    public final sQ<T> c(sQ<T> sQ2) {
        try {
            sC sC2 = (sC)sQ2;
            sC sC3 = this;
            sC3.g(sC2);
            sC sC4 = new sC(sC3.a(), sC3.d, sC2.e);
            kN kN2 = (kN)sC3.a().a();
            int n2 = 0;
            for (int i2 = 0; i2 < sC4.f; ++i2) {
                int n3 = i2 * 36;
                int n4 = BY.a(n3 + 36, sC3.d);
                for (int i3 = 0; i3 < sC4.g; ++i3) {
                    int n5 = super.k(i3);
                    int n6 = n5 + n5;
                    int n7 = n6 + n5;
                    int n8 = n7 + n5;
                    T[] TArray = sC4.c[n2];
                    for (int i4 = 0; i4 < sC3.g; ++i4) {
                        int n9 = sC3.k(i4);
                        T[] TArray2 = sC3.c[i2 * sC3.g + i4];
                        T[] TArray3 = sC2.c[i4 * sC2.g + i3];
                        int n10 = 0;
                        for (int i5 = n3; i5 < n4; ++i5) {
                            int n11 = (i5 - n3) * n9;
                            int n12 = n11 + n9;
                            for (int i6 = 0; i6 < n5; ++i6) {
                                kN kN3 = kN2;
                                int n13 = n11;
                                int n14 = i6;
                                while (n13 < n12 - 3) {
                                    kN3 = (kN)((kN)((kN)((kN)kN3.a(TArray2[n13].c(TArray3[n14]))).a(TArray2[n13 + 1].c(TArray3[n14 + n5]))).a(TArray2[n13 + 2].c(TArray3[n14 + n6]))).a(TArray2[n13 + 3].c(TArray3[n14 + n7]));
                                    n13 += 4;
                                    n14 += n8;
                                }
                                while (n13 < n12) {
                                    kN3 = (kN)kN3.a(TArray2[n13++].c(TArray3[n14]));
                                    n14 += n5;
                                }
                                TArray[n10] = TArray[n10].a((kN)kN3);
                                ++n10;
                            }
                        }
                    }
                    ++n2;
                }
            }
            return sC4;
        }
        catch (ClassCastException classCastException) {
            this.g(sQ2);
            sC sC5 = new sC(this.a(), this.d, sQ2.g());
            kN kN4 = (kN)this.a().a();
            int n15 = 0;
            for (int i7 = 0; i7 < sC5.f; ++i7) {
                int n16 = i7 * 36;
                int n17 = BY.a(n16 + 36, this.d);
                for (int i8 = 0; i8 < sC5.g; ++i8) {
                    int n18 = i8 * 36;
                    int n19 = BY.a(n18 + 36, sQ2.g());
                    T[] TArray = sC5.c[n15];
                    for (int i9 = 0; i9 < this.g; ++i9) {
                        int n20 = this.k(i9);
                        T[] TArray4 = this.c[i7 * this.g + i9];
                        int n21 = i9 * 36;
                        int n22 = 0;
                        for (int i10 = n16; i10 < n17; ++i10) {
                            int n23 = (i10 - n16) * n20;
                            int n24 = n23 + n20;
                            for (int i11 = n18; i11 < n19; ++i11) {
                                kN kN5 = kN4;
                                int n25 = n21;
                                for (int i12 = n23; i12 < n24; ++i12) {
                                    kN5 = (kN)kN5.a(TArray4[i12].c(sQ2.b(n25, i11)));
                                    ++n25;
                                }
                                TArray[n22] = TArray[n22].a((kN)kN5);
                                ++n22;
                            }
                        }
                    }
                    ++n15;
                }
            }
            return sC5;
        }
    }

    @Override
    private sC<T> c(sC<T> sC2) {
        this.g(sC2);
        sC sC3 = new sC(this.a(), this.d, sC2.e);
        kN kN2 = (kN)this.a().a();
        int n2 = 0;
        for (int i2 = 0; i2 < sC3.f; ++i2) {
            int n3 = i2 * 36;
            int n4 = BY.a(n3 + 36, this.d);
            for (int i3 = 0; i3 < sC3.g; ++i3) {
                int n5 = super.k(i3);
                int n6 = n5 + n5;
                int n7 = n6 + n5;
                int n8 = n7 + n5;
                T[] TArray = sC3.c[n2];
                for (int i4 = 0; i4 < this.g; ++i4) {
                    int n9 = this.k(i4);
                    T[] TArray2 = this.c[i2 * this.g + i4];
                    T[] TArray3 = sC2.c[i4 * sC2.g + i3];
                    int n10 = 0;
                    for (int i5 = n3; i5 < n4; ++i5) {
                        int n11 = (i5 - n3) * n9;
                        int n12 = n11 + n9;
                        for (int i6 = 0; i6 < n5; ++i6) {
                            kN kN3 = kN2;
                            int n13 = n11;
                            int n14 = i6;
                            while (n13 < n12 - 3) {
                                kN3 = (kN)((kN)((kN)((kN)kN3.a(TArray2[n13].c(TArray3[n14]))).a(TArray2[n13 + 1].c(TArray3[n14 + n5]))).a(TArray2[n13 + 2].c(TArray3[n14 + n6]))).a(TArray2[n13 + 3].c(TArray3[n14 + n7]));
                                n13 += 4;
                                n14 += n8;
                            }
                            while (n13 < n12) {
                                kN3 = (kN)kN3.a(TArray2[n13++].c(TArray3[n14]));
                                n14 += n5;
                            }
                            TArray[n10] = TArray[n10].a((kN)kN3);
                            ++n10;
                        }
                    }
                }
                ++n2;
            }
        }
        return sC3;
    }

    @Override
    public final T[][] c() {
        kN[][] kNArray = this;
        kNArray = this;
        kNArray = (kN[][])ch_0.a(this.a(), this.d, this.e);
        int n2 = this.e - (this.g - 1) * 36;
        for (int i2 = 0; i2 < this.f; ++i2) {
            int n3 = i2 * 36;
            int n4 = BY.a(n3 + 36, this.d);
            int n5 = 0;
            int n6 = 0;
            while (n3 < n4) {
                kN[] kNArray2 = kNArray[n3];
                int n7 = i2 * this.g;
                int n8 = 0;
                for (int i3 = 0; i3 < this.g - 1; ++i3) {
                    System.arraycopy(this.c[n7++], n5, kNArray2, n8, 36);
                    n8 += 36;
                }
                System.arraycopy(this.c[n7], n6, kNArray2, n8, n2);
                n5 += 36;
                n6 += n2;
                ++n3;
            }
        }
        return kNArray;
    }

    @Override
    public final sQ<T> a(int n2, int n3, int n4, int n5) {
        this.b(n2, n3, n4, n5);
        sC sC2 = new sC(this.a(), n3 - n2 + 1, n5 - n4 + 1);
        n5 = n2 / 36;
        n2 %= 36;
        int n6 = n4 / 36;
        n4 %= 36;
        for (int i2 = 0; i2 < sC2.f; ++i2) {
            int n7 = super.j(i2);
            int n8 = n6;
            for (int i3 = 0; i3 < sC2.g; ++i3) {
                int n9;
                int n10 = super.k(i3);
                int n11 = i2 * sC2.g + i3;
                T[] TArray = sC2.c[n11];
                int n12 = n5 * this.g + n8;
                int n13 = this.k(n8);
                int n14 = n7 + n2 - 36;
                int n15 = n10 + n4 - 36;
                if (n14 > 0) {
                    if (n15 > 0) {
                        n9 = this.k(n8 + 1);
                        sC.a(this.c[n12], (int)n13, (int)n2, (int)36, (int)n4, (int)36, TArray, (int)n10, (int)0, (int)0);
                        sC.a(this.c[n12 + 1], (int)n9, (int)n2, (int)36, (int)0, (int)n15, TArray, (int)n10, (int)0, (int)(n10 - n15));
                        sC.a(this.c[n12 + this.g], (int)n13, (int)0, (int)n14, (int)n4, (int)36, TArray, (int)n10, (int)(n7 - n14), (int)0);
                        sC.a(this.c[n12 + this.g + 1], (int)n9, (int)0, (int)n14, (int)0, (int)n15, TArray, (int)n10, (int)(n7 - n14), (int)(n10 - n15));
                    } else {
                        sC.a(this.c[n12], (int)n13, (int)n2, (int)36, (int)n4, (int)(n10 + n4), TArray, (int)n10, (int)0, (int)0);
                        sC.a(this.c[n12 + this.g], (int)n13, (int)0, (int)n14, (int)n4, (int)(n10 + n4), TArray, (int)n10, (int)(n7 - n14), (int)0);
                    }
                } else if (n15 > 0) {
                    n9 = this.k(n8 + 1);
                    sC.a(this.c[n12], (int)n13, (int)n2, (int)(n7 + n2), (int)n4, (int)36, TArray, (int)n10, (int)0, (int)0);
                    sC.a(this.c[n12 + 1], (int)n9, (int)n2, (int)(n7 + n2), (int)0, (int)n15, TArray, (int)n10, (int)0, (int)(n10 - n15));
                } else {
                    sC.a(this.c[n12], (int)n13, (int)n2, (int)(n7 + n2), (int)n4, (int)(n10 + n4), TArray, (int)n10, (int)0, (int)0);
                }
                ++n8;
            }
            ++n5;
        }
        return sC2;
    }

    private static void a(T[] TArray, int n2, int n3, int n4, int n5, int n6, T[] TArray2, int n7, int n8, int n9) {
        n6 -= n5;
        n5 = n3 * n2 + n5;
        n8 = n8 * n7 + n9;
        while (n3 < n4) {
            System.arraycopy(TArray, n5, TArray2, n8, n6);
            n5 += n2;
            n8 += n7;
            ++n3;
        }
    }

    @Override
    public final void a(T[][] TArray, int n2, int n3) {
        int n4;
        ci_0.a(TArray);
        int n5 = TArray[0].length;
        if (n5 == 0) {
            throw new pf_0(px_0.AT_LEAST_ONE_COLUMN);
        }
        int n6 = n2 + TArray.length - 1;
        int n7 = n3 + n5 - 1;
        this.b(n2, n6, n3, n7);
        T[][] TArray2 = TArray;
        int n8 = TArray.length;
        for (n4 = 0; n4 < n8; ++n4) {
            T[] TArray3 = TArray2[n4];
            if (TArray3.length == n5) continue;
            throw new oS(n5, TArray3.length);
        }
        int n9 = n2 / 36;
        n8 = (n6 + 36) / 36;
        n4 = n3 / 36;
        int n10 = (n7 + 36) / 36;
        for (n5 = n9; n5 < n8; ++n5) {
            n9 = this.j(n5);
            int n11 = n5 * 36;
            int n12 = BY.b(n2, n11);
            n9 = BY.a(n6 + 1, n11 + n9);
            for (int i2 = n4; i2 < n10; ++i2) {
                int n13 = this.k(i2);
                int n14 = i2 * 36;
                int n15 = BY.b(n3, n14);
                int n16 = BY.a(n7 + 1, n14 + n13);
                n16 -= n15;
                T[] TArray4 = this.c[n5 * this.g + i2];
                for (int i3 = n12; i3 < n9; ++i3) {
                    System.arraycopy(TArray[i3 - n2], n15 - n3, TArray4, (i3 - n11) * n13 + (n15 - n14), n16);
                }
            }
        }
    }

    @Override
    public final sQ<T> b(int n2) {
        this.h(n2);
        sC sC2 = new sC(this.a(), 1, this.e);
        int n3 = n2 / 36;
        n2 -= n3 * 36;
        int n4 = 0;
        int n5 = 0;
        T[] TArray = sC2.c[0];
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n6 = this.k(i2);
            T[] TArray2 = this.c[n3 * this.g + i2];
            int n7 = TArray.length - n5;
            if (n6 > n7) {
                System.arraycopy(TArray2, n2 * n6, TArray, n5, n7);
                TArray = sC2.c[++n4];
                System.arraycopy(TArray2, n2 * n6, TArray, 0, n6 - n7);
                n5 = n6 - n7;
                continue;
            }
            System.arraycopy(TArray2, n2 * n6, TArray, n5, n6);
            n5 += n6;
        }
        return sC2;
    }

    @Override
    public final void a(int n2, sQ<T> sQ2) {
        try {
            int n3;
            sC sC2;
            int n4;
            sC sC3;
            block8: {
                sC sC4;
                block7: {
                    sC3 = (sC)sQ2;
                    n4 = n2;
                    sC2 = this;
                    sC2.h(n4);
                    sC4 = sC2;
                    n3 = sC4.e;
                    sC4 = sC3;
                    if (sC4.d != 1) break block7;
                    sC4 = sC3;
                    if (sC4.e == n3) break block8;
                }
                sC sC5 = sC3;
                sC4 = sC5;
                sC4 = sC3;
                throw new tc_0(sC5.d, sC4.e, 1, n3);
            }
            n3 = n4 / 36;
            n4 -= n3 * 36;
            int n5 = 0;
            int n6 = 0;
            T[] TArray = sC3.c[0];
            for (int i2 = 0; i2 < sC2.g; ++i2) {
                int n7 = sC2.k(i2);
                T[] TArray2 = sC2.c[n3 * sC2.g + i2];
                int n8 = TArray.length - n6;
                if (n7 > n8) {
                    System.arraycopy(TArray, n6, TArray2, n4 * n7, n8);
                    TArray = sC3.c[++n5];
                    System.arraycopy(TArray, 0, TArray2, n4 * n7, n7 - n8);
                    n6 = n7 - n8;
                    continue;
                }
                System.arraycopy(TArray, n6, TArray2, n4 * n7, n7);
                n6 += n7;
            }
            return;
        }
        catch (ClassCastException classCastException) {
            super.a(n2, sQ2);
            return;
        }
    }

    @Override
    private void a(int n2, sC<T> sC2) {
        int n3;
        block6: {
            sC<T> sC3;
            block5: {
                this.h(n2);
                sC3 = this;
                n3 = sC3.e;
                sC3 = sC2;
                if (sC3.d != 1) break block5;
                sC3 = sC2;
                if (sC3.e == n3) break block6;
            }
            sC<T> sC4 = sC2;
            sC3 = sC4;
            sC3 = sC2;
            throw new tc_0(sC4.d, sC3.e, 1, n3);
        }
        n3 = n2 / 36;
        n2 -= n3 * 36;
        int n4 = 0;
        int n5 = 0;
        T[] TArray = sC2.c[0];
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n6 = super.k(i2);
            T[] TArray2 = this.c[n3 * this.g + i2];
            int n7 = TArray.length - n5;
            if (n6 > n7) {
                System.arraycopy(TArray, n5, TArray2, n2 * n6, n7);
                TArray = sC2.c[++n4];
                System.arraycopy(TArray, 0, TArray2, n2 * n6, n6 - n7);
                n5 = n6 - n7;
                continue;
            }
            System.arraycopy(TArray, n5, TArray2, n2 * n6, n6);
            n5 += n6;
        }
    }

    @Override
    public final sQ<T> c(int n2) {
        this.i(n2);
        sC sC2 = new sC(this.a(), this.d, 1);
        int n3 = n2 / 36;
        n2 -= n3 * 36;
        int n4 = this.k(n3);
        int n5 = 0;
        int n6 = 0;
        T[] TArray = sC2.c[0];
        for (int i2 = 0; i2 < this.f; ++i2) {
            int n7 = this.j(i2);
            T[] TArray2 = this.c[i2 * this.g + n3];
            for (int i3 = 0; i3 < n7; ++i3) {
                if (n6 >= TArray.length) {
                    TArray = sC2.c[++n5];
                    n6 = 0;
                }
                TArray[n6++] = TArray2[i3 * n4 + n2];
            }
        }
        return sC2;
    }

    @Override
    public final void b(int n2, sQ<T> sQ2) {
        try {
            int n3;
            sC sC2;
            int n4;
            sC sC3;
            block9: {
                sC sC4;
                block8: {
                    sC3 = (sC)sQ2;
                    n4 = n2;
                    sC2 = this;
                    sC2.i(n4);
                    sC4 = sC2;
                    n3 = sC4.d;
                    sC4 = sC3;
                    if (sC4.d != n3) break block8;
                    sC4 = sC3;
                    if (sC4.e == 1) break block9;
                }
                sC sC5 = sC3;
                sC4 = sC5;
                sC4 = sC3;
                throw new tc_0(sC5.d, sC4.e, n3, 1);
            }
            n3 = n4 / 36;
            n4 -= n3 * 36;
            int n5 = sC2.k(n3);
            int n6 = 0;
            int n7 = 0;
            T[] TArray = sC3.c[0];
            for (int i2 = 0; i2 < sC2.f; ++i2) {
                int n8 = sC2.j(i2);
                T[] TArray2 = sC2.c[i2 * sC2.g + n3];
                for (int i3 = 0; i3 < n8; ++i3) {
                    if (n7 >= TArray.length) {
                        TArray = sC3.c[++n6];
                        n7 = 0;
                    }
                    TArray2[i3 * n5 + n4] = TArray[n7++];
                }
            }
            return;
        }
        catch (ClassCastException classCastException) {
            super.b(n2, sQ2);
            return;
        }
    }

    @Override
    private void b(int n2, sC<T> sC2) {
        int n3;
        block7: {
            sC<T> sC3;
            block6: {
                this.i(n2);
                sC3 = this;
                n3 = sC3.d;
                sC3 = sC2;
                if (sC3.d != n3) break block6;
                sC3 = sC2;
                if (sC3.e == 1) break block7;
            }
            sC<T> sC4 = sC2;
            sC3 = sC4;
            sC3 = sC2;
            throw new tc_0(sC4.d, sC3.e, n3, 1);
        }
        n3 = n2 / 36;
        n2 -= n3 * 36;
        int n4 = super.k(n3);
        int n5 = 0;
        int n6 = 0;
        T[] TArray = sC2.c[0];
        for (int i2 = 0; i2 < this.f; ++i2) {
            int n7 = super.j(i2);
            T[] TArray2 = this.c[i2 * this.g + n3];
            for (int i3 = 0; i3 < n7; ++i3) {
                if (n6 >= TArray.length) {
                    TArray = sC2.c[++n5];
                    n6 = 0;
                }
                TArray2[i3 * n4 + n2] = TArray[n6++];
            }
        }
    }

    @Override
    public final sT<T> d(int n2) {
        this.h(n2);
        kN[] kNArray = (kN[])ch_0.a(this.a(), this.e);
        int n3 = n2 / 36;
        n2 -= n3 * 36;
        int n4 = 0;
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n5 = this.k(i2);
            T[] TArray = this.c[n3 * this.g + i2];
            System.arraycopy(TArray, n2 * n5, kNArray, n4, n5);
            n4 += n5;
        }
        return new sz_0(this.a(), kNArray, false);
    }

    @Override
    public final void a(int n2, sT<T> sT2) {
        try {
            Serializable serializable = (sz_0)sT2;
            T[] TArray = serializable.a;
            int n3 = n2;
            sC sC2 = this;
            sC2.h(n3);
            serializable = sC2;
            int n4 = ((sC)serializable).e;
            if (TArray.length != n4) {
                throw new tc_0(1, TArray.length, 1, n4);
            }
            n4 = n3 / 36;
            n3 -= n4 * 36;
            int n5 = 0;
            for (int i2 = 0; i2 < sC2.g; ++i2) {
                int n6 = sC2.k(i2);
                T[] TArray2 = sC2.c[n4 * sC2.g + i2];
                System.arraycopy(TArray, n5, TArray2, n3 * n6, n6);
                n5 += n6;
            }
            return;
        }
        catch (ClassCastException classCastException) {
            super.a(n2, sT2);
            return;
        }
    }

    @Override
    public final sT<T> e(int n2) {
        this.i(n2);
        kN[] kNArray = (kN[])ch_0.a(this.a(), this.d);
        int n3 = n2 / 36;
        n2 -= n3 * 36;
        int n4 = this.k(n3);
        int n5 = 0;
        for (int i2 = 0; i2 < this.f; ++i2) {
            int n6 = this.j(i2);
            T[] TArray = this.c[i2 * this.g + n3];
            for (int i3 = 0; i3 < n6; ++i3) {
                kNArray[n5++] = TArray[i3 * n4 + n2];
            }
        }
        return new sz_0(this.a(), kNArray, false);
    }

    @Override
    public final void b(int n2, sT<T> sT2) {
        try {
            Serializable serializable = (sz_0)sT2;
            T[] TArray = serializable.a;
            int n3 = n2;
            sC sC2 = this;
            sC2.i(n3);
            serializable = sC2;
            int n4 = ((sC)serializable).d;
            if (TArray.length != n4) {
                throw new tc_0(TArray.length, 1, n4, 1);
            }
            n4 = n3 / 36;
            n3 -= n4 * 36;
            int n5 = sC2.k(n4);
            int n6 = 0;
            for (int i2 = 0; i2 < sC2.f; ++i2) {
                int n7 = sC2.j(i2);
                T[] TArray2 = sC2.c[i2 * sC2.g + n4];
                for (int i3 = 0; i3 < n7; ++i3) {
                    TArray2[i3 * n5 + n3] = TArray[n6++];
                }
            }
            return;
        }
        catch (ClassCastException classCastException) {
            super.b(n2, sT2);
            return;
        }
    }

    @Override
    public final T[] f(int n2) {
        this.h(n2);
        kN[] kNArray = (kN[])ch_0.a(this.a(), this.e);
        int n3 = n2 / 36;
        n2 -= n3 * 36;
        int n4 = 0;
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n5 = this.k(i2);
            T[] TArray = this.c[n3 * this.g + i2];
            System.arraycopy(TArray, n2 * n5, kNArray, n4, n5);
            n4 += n5;
        }
        return kNArray;
    }

    @Override
    public final void a(int n2, T[] TArray) {
        this.h(n2);
        sC sC2 = this;
        int n3 = sC2.e;
        if (TArray.length != n3) {
            throw new tc_0(1, TArray.length, 1, n3);
        }
        n3 = n2 / 36;
        n2 -= n3 * 36;
        int n4 = 0;
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n5 = this.k(i2);
            T[] TArray2 = this.c[n3 * this.g + i2];
            System.arraycopy(TArray, n4, TArray2, n2 * n5, n5);
            n4 += n5;
        }
    }

    @Override
    public final T[] g(int n2) {
        this.i(n2);
        kN[] kNArray = (kN[])ch_0.a(this.a(), this.d);
        int n3 = n2 / 36;
        n2 -= n3 * 36;
        int n4 = this.k(n3);
        int n5 = 0;
        for (int i2 = 0; i2 < this.f; ++i2) {
            int n6 = this.j(i2);
            T[] TArray = this.c[i2 * this.g + n3];
            for (int i3 = 0; i3 < n6; ++i3) {
                kNArray[n5++] = TArray[i3 * n4 + n2];
            }
        }
        return kNArray;
    }

    @Override
    public final void b(int n2, T[] TArray) {
        this.i(n2);
        sC sC2 = this;
        int n3 = sC2.d;
        if (TArray.length != n3) {
            throw new tc_0(TArray.length, 1, n3, 1);
        }
        n3 = n2 / 36;
        n2 -= n3 * 36;
        int n4 = this.k(n3);
        int n5 = 0;
        for (int i2 = 0; i2 < this.f; ++i2) {
            int n6 = this.j(i2);
            T[] TArray2 = this.c[i2 * this.g + n3];
            for (int i3 = 0; i3 < n6; ++i3) {
                TArray2[i3 * n4 + n2] = TArray[n5++];
            }
        }
    }

    @Override
    public final T b(int n2, int n3) {
        this.h(n2);
        this.i(n3);
        int n4 = n2 / 36;
        int n5 = n3 / 36;
        n2 = (n2 - n4 * 36) * this.k(n5) + (n3 - n5 * 36);
        return this.c[n4 * this.g + n5][n2];
    }

    @Override
    public final void a(int n2, int n3, T t) {
        this.h(n2);
        this.i(n3);
        int n4 = n2 / 36;
        int n5 = n3 / 36;
        n2 = (n2 - n4 * 36) * this.k(n5) + (n3 - n5 * 36);
        this.c[n4 * this.g + n5][n2] = t;
    }

    @Override
    public final void b(int n2, int n3, T t) {
        this.h(n2);
        this.i(n3);
        int n4 = n2 / 36;
        int n5 = n3 / 36;
        n2 = (n2 - n4 * 36) * this.k(n5) + (n3 - n5 * 36);
        T[] TArray = this.c[n4 * this.g + n5];
        T[] TArray2 = TArray;
        TArray[n2] = (kN)TArray2[n2].a(t);
    }

    @Override
    public final void c(int n2, int n3, T t) {
        this.h(n2);
        this.i(n3);
        int n4 = n2 / 36;
        int n5 = n3 / 36;
        n2 = (n2 - n4 * 36) * this.k(n5) + (n3 - n5 * 36);
        T[] TArray = this.c[n4 * this.g + n5];
        T[] TArray2 = TArray;
        TArray[n2] = (kN)TArray2[n2].c(t);
    }

    @Override
    public final sQ<T> d() {
        sC sC2 = this;
        int n2 = sC2.d;
        sC2 = this;
        int n3 = sC2.e;
        sC sC3 = new sC(this.a(), n3, n2);
        n3 = 0;
        for (int i2 = 0; i2 < this.g; ++i2) {
            for (int i3 = 0; i3 < this.f; ++i3) {
                T[] TArray = sC3.c[n3];
                T[] TArray2 = this.c[i3 * this.g + i2];
                int n4 = i2 * 36;
                int n5 = BY.a(n4 + 36, this.e);
                int n6 = i3 * 36;
                int n7 = BY.a(n6 + 36, this.d);
                int n8 = 0;
                for (int i4 = n4; i4 < n5; ++i4) {
                    int n9 = n5 - n4;
                    int n10 = i4 - n4;
                    for (int i5 = n6; i5 < n7; ++i5) {
                        TArray[n8] = TArray2[n10];
                        ++n8;
                        n10 += n9;
                    }
                }
                ++n3;
            }
        }
        return sC3;
    }

    @Override
    public final int f() {
        return this.d;
    }

    @Override
    public final int g() {
        return this.e;
    }

    @Override
    public final T[] b(T[] TArray) {
        if (TArray.length != this.e) {
            throw new oS(TArray.length, this.e);
        }
        kN[] kNArray = (kN[])ch_0.a(this.a(), this.d);
        kN kN2 = (kN)this.a().a();
        for (int i2 = 0; i2 < this.f; ++i2) {
            int n2 = i2 * 36;
            int n3 = BY.a(n2 + 36, this.d);
            for (int i3 = 0; i3 < this.g; ++i3) {
                T[] TArray2 = this.c[i2 * this.g + i3];
                int n4 = i3 * 36;
                int n5 = BY.a(n4 + 36, this.e);
                int n6 = 0;
                for (int i4 = n2; i4 < n3; ++i4) {
                    int n7;
                    kN kN3 = kN2;
                    for (n7 = n4; n7 < n5 - 3; n7 += 4) {
                        kN3 = (kN)((kN)((kN)((kN)kN3.a(TArray2[n6].c(TArray[n7]))).a(TArray2[n6 + 1].c(TArray[n7 + 1]))).a(TArray2[n6 + 2].c(TArray[n7 + 2]))).a(TArray2[n6 + 3].c(TArray[n7 + 3]));
                        n6 += 4;
                    }
                    while (n7 < n5) {
                        kN3 = (kN)kN3.a(TArray2[n6++].c(TArray[n7++]));
                    }
                    kNArray[i4] = kNArray[i4].a(kN3);
                }
            }
        }
        return kNArray;
    }

    @Override
    public final T[] c(T[] TArray) {
        if (TArray.length != this.d) {
            throw new oS(TArray.length, this.d);
        }
        kN[] kNArray = (kN[])ch_0.a(this.a(), this.e);
        kN kN2 = (kN)this.a().a();
        for (int i2 = 0; i2 < this.g; ++i2) {
            int n2 = this.k(i2);
            int n3 = n2 + n2;
            int n4 = n3 + n2;
            int n5 = n4 + n2;
            int n6 = i2 * 36;
            int n7 = BY.a(n6 + 36, this.e);
            for (int i3 = 0; i3 < this.f; ++i3) {
                T[] TArray2 = this.c[i3 * this.g + i2];
                int n8 = i3 * 36;
                int n9 = BY.a(n8 + 36, this.d);
                for (int i4 = n6; i4 < n7; ++i4) {
                    int n10;
                    int n11 = i4 - n6;
                    kN kN3 = kN2;
                    for (n10 = n8; n10 < n9 - 3; n10 += 4) {
                        kN3 = (kN)((kN)((kN)((kN)kN3.a(TArray2[n11].c(TArray[n10]))).a(TArray2[n11 + n2].c(TArray[n10 + 1]))).a(TArray2[n11 + n3].c(TArray[n10 + 2]))).a(TArray2[n11 + n4].c(TArray[n10 + 3]));
                        n11 += n5;
                    }
                    while (n10 < n9) {
                        kN3 = (kN)kN3.a(TArray2[n11].c(TArray[n10++]));
                        n11 += n2;
                    }
                    kNArray[i4] = kNArray[i4].a(kN3);
                }
            }
        }
        return kNArray;
    }

    @Override
    public final T a(sR<T> sR2) {
        for (int i2 = 0; i2 < this.f; ++i2) {
            int n2 = i2 * 36;
            int n3 = BY.a(n2 + 36, this.d);
            for (int i3 = n2; i3 < n3; ++i3) {
                for (int i4 = 0; i4 < this.g; ++i4) {
                    int n4 = this.k(i4);
                    int n5 = i4 * 36;
                    int n6 = BY.a(n5 + 36, this.e);
                    T[] TArray = this.c[i2 * this.g + i4];
                    n4 = (i3 - n2) * n4;
                    while (n5 < n6) {
                        TArray[n4] = sR2.a(i3, n5, TArray[n4]);
                        ++n4;
                        ++n5;
                    }
                }
            }
        }
        return sR2.b();
    }

    @Override
    public final T a(sS<T> sS2) {
        sS2.a(this.d, this.e, 0, 0);
        for (int i2 = 0; i2 < this.f; ++i2) {
            int n2 = i2 * 36;
            int n3 = BY.a(n2 + 36, this.d);
            for (int i3 = n2; i3 < n3; ++i3) {
                for (int i4 = 0; i4 < this.g; ++i4) {
                    int n4 = this.k(i4);
                    int n5 = i4 * 36;
                    int n6 = BY.a(n5 + 36, this.e);
                    T[] TArray = this.c[i2 * this.g + i4];
                    n4 = (i3 - n2) * n4;
                    while (n5 < n6) {
                        sS2.a(i3, n5, TArray[n4]);
                        ++n4;
                        ++n5;
                    }
                }
            }
        }
        return sS2.a();
    }

    @Override
    public final T a(sR<T> sR2, int n2, int n3, int n4, int n5) {
        this.b(n2, n3, n4, n5);
        for (int i2 = n2 / 36; i2 < 1 + n3 / 36; ++i2) {
            int n6 = i2 * 36;
            int n7 = BY.b(n2, n6);
            int n8 = BY.a((i2 + 1) * 36, n3 + 1);
            while (n7 < n8) {
                for (int i3 = n4 / 36; i3 < 1 + n5 / 36; ++i3) {
                    int n9 = this.k(i3);
                    int n10 = i3 * 36;
                    int n11 = BY.b(n4, n10);
                    int n12 = BY.a((i3 + 1) * 36, n5 + 1);
                    T[] TArray = this.c[i2 * this.g + i3];
                    n9 = (n7 - n6) * n9 + n11 - n10;
                    for (n10 = n11; n10 < n12; ++n10) {
                        TArray[n9] = sR2.a(n7, n10, TArray[n9]);
                        ++n9;
                    }
                }
                ++n7;
            }
        }
        return sR2.b();
    }

    @Override
    public final T a(sS<T> sS2, int n2, int n3, int n4, int n5) {
        this.b(n2, n3, n4, n5);
        sS2.a(this.d, this.e, n2, n4);
        for (int i2 = n2 / 36; i2 < 1 + n3 / 36; ++i2) {
            int n6 = i2 * 36;
            int n7 = BY.b(n2, n6);
            int n8 = BY.a((i2 + 1) * 36, n3 + 1);
            while (n7 < n8) {
                for (int i3 = n4 / 36; i3 < 1 + n5 / 36; ++i3) {
                    int n9 = this.k(i3);
                    int n10 = i3 * 36;
                    int n11 = BY.b(n4, n10);
                    int n12 = BY.a((i3 + 1) * 36, n5 + 1);
                    T[] TArray = this.c[i2 * this.g + i3];
                    n9 = (n7 - n6) * n9 + n11 - n10;
                    for (n10 = n11; n10 < n12; ++n10) {
                        sS2.a(n7, n10, TArray[n9]);
                        ++n9;
                    }
                }
                ++n7;
            }
        }
        return sS2.a();
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    public final kN a(su_0.1 var1_1) {
        int n2 = 0;
        for (int i2 = 0; i2 < this.f; ++i2) {
            int n3 = i2 * 36;
            int n4 = BY.a(n3 + 36, this.d);
            for (int i3 = 0; i3 < this.g; ++i3) {
                int n5 = i3 * 36;
                int n6 = BY.a(n5 + 36, this.e);
                T[] TArray = this.c[n2];
                int n7 = 0;
                for (int i4 = n3; i4 < n4; ++i4) {
                    for (int i5 = n5; i5 < n6; ++i5) {
                        TArray[n7] = var1_1.a(i4, i5, TArray[n7]);
                        ++n7;
                    }
                }
                ++n2;
            }
        }
        return var1_1.b();
    }

    @Override
    public final T c(sS<T> sS2) {
        sS2.a(this.d, this.e, 0, 0);
        int n2 = 0;
        for (int i2 = 0; i2 < this.f; ++i2) {
            int n3 = i2 * 36;
            int n4 = BY.a(n3 + 36, this.d);
            for (int i3 = 0; i3 < this.g; ++i3) {
                int n5 = i3 * 36;
                int n6 = BY.a(n5 + 36, this.e);
                T[] TArray = this.c[n2];
                int n7 = 0;
                for (int i4 = n3; i4 < n4; ++i4) {
                    for (int i5 = n5; i5 < n6; ++i5) {
                        sS2.a(i4, i5, TArray[n7]);
                        ++n7;
                    }
                }
                ++n2;
            }
        }
        return sS2.a();
    }

    @Override
    public final T c(sR<T> sR2, int n2, int n3, int n4, int n5) {
        this.b(n2, n3, n4, n5);
        for (int i2 = n2 / 36; i2 < 1 + n3 / 36; ++i2) {
            int n6 = i2 * 36;
            int n7 = BY.b(n2, n6);
            int n8 = BY.a((i2 + 1) * 36, n3 + 1);
            for (int i3 = n4 / 36; i3 < 1 + n5 / 36; ++i3) {
                int n9 = this.k(i3);
                int n10 = i3 * 36;
                int n11 = BY.b(n4, n10);
                int n12 = BY.a((i3 + 1) * 36, n5 + 1);
                T[] TArray = this.c[i2 * this.g + i3];
                for (int i4 = n7; i4 < n8; ++i4) {
                    int n13 = (i4 - n6) * n9 + n11 - n10;
                    for (int i5 = n11; i5 < n12; ++i5) {
                        TArray[n13] = sR2.a(i4, i5, TArray[n13]);
                        ++n13;
                    }
                }
            }
        }
        return sR2.b();
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    public final kN a(su_0.2 var1_1, int n2, int n3, int n4, int n5) {
        this.b(n2, n3, n4, n5);
        var1_1.a(this.d, this.e, n2, n4);
        for (int i2 = n2 / 36; i2 < 1 + n3 / 36; ++i2) {
            int n6 = i2 * 36;
            int n7 = BY.b(n2, n6);
            int n8 = BY.a((i2 + 1) * 36, n3 + 1);
            for (int i3 = n4 / 36; i3 < 1 + n5 / 36; ++i3) {
                int n9 = this.k(i3);
                int n10 = i3 * 36;
                int n11 = BY.b(n4, n10);
                int n12 = BY.a((i3 + 1) * 36, n5 + 1);
                T[] TArray = this.c[i2 * this.g + i3];
                for (int i4 = n7; i4 < n8; ++i4) {
                    int n13 = (i4 - n6) * n9 + n11 - n10;
                    for (int i5 = n11; i5 < n12; ++i5) {
                        var1_1.a(i4, i5, TArray[n13]);
                        ++n13;
                    }
                }
            }
        }
        return var1_1.a();
    }

    private int j(int n2) {
        if (n2 == this.f - 1) {
            return this.d - n2 * 36;
        }
        return 36;
    }

    private int k(int n2) {
        if (n2 == this.g - 1) {
            return this.e - n2 * 36;
        }
        return 36;
    }
}


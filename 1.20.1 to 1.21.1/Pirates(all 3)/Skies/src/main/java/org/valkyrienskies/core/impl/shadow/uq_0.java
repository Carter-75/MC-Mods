/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.uq$1
 *  org.valkyrienskies.core.impl.shadow.uq$b
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.ua_0;
import org.valkyrienskies.core.impl.shadow.ud_0;
import org.valkyrienskies.core.impl.shadow.ue_0;
import org.valkyrienskies.core.impl.shadow.uq;
import org.valkyrienskies.core.impl.shadow.uq_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.uq
 */
public final class uq_0
implements Serializable,
Iterable<ue_0> {
    private static final long d = 1L;
    public final ud_0 a;
    public final int b;
    public final int c;
    private final boolean e;
    private final boolean f;
    private final int g;
    private final long[][] h;

    uq_0(boolean n2, boolean n3, int n4, double[][][] dArray) {
        this.b = dArray.length;
        this.c = dArray[0].length;
        if (this.b < 2) {
            throw new pn_0(this.b, (Number)2, true);
        }
        if (this.c < 2) {
            throw new pn_0(this.c, (Number)2, true);
        }
        this.e = n2;
        this.f = n3;
        this.g = n4;
        n2 = dArray[0][0].length;
        this.a = new ud_0(0L, n2);
        this.h = new long[this.b][this.c];
        for (n2 = 0; n2 < this.b; ++n2) {
            for (n3 = 0; n3 < this.c; ++n3) {
                this.h[n2][n3] = this.a.a(dArray[n2][n3]);
            }
        }
        this.e();
    }

    private uq_0(int n2, boolean n3, int n4, boolean n5, int n6, ua_0[] ua_0Array) {
        if (n2 < 2) {
            throw new pn_0(n2, (Number)2, true);
        }
        if (n4 < 2) {
            throw new pn_0(n4, (Number)2, true);
        }
        this.b = n2;
        this.e = n3;
        this.c = n4;
        this.f = n5;
        this.g = n6;
        this.h = new long[this.b][this.c];
        n3 = ua_0Array.length;
        this.a = new ud_0(0L, n3);
        for (n5 = 0; n5 < n2; ++n5) {
            for (n6 = 0; n6 < n4; ++n6) {
                double[] dArray = new double[n3];
                for (int i2 = 0; i2 < n3; ++i2) {
                    dArray[i2] = ua_0Array[i2].a();
                }
                this.h[n5][n6] = this.a.a(dArray);
            }
        }
        this.e();
    }

    private uq_0(boolean bl, boolean bl2, int n2, ud_0 ud_02, long[][] lArray) {
        this.b = lArray.length;
        this.c = lArray[0].length;
        this.e = bl;
        this.f = bl2;
        this.g = n2;
        this.a = ud_02;
        this.h = lArray;
    }

    private synchronized uq_0 d() {
        long[][] lArray = new long[this.b][this.c];
        for (int i2 = 0; i2 < this.b; ++i2) {
            for (int i3 = 0; i3 < this.c; ++i3) {
                lArray[i2][i3] = this.h[i2][i3];
            }
        }
        return new uq_0(this.e, this.f, this.g, this.a.a(), lArray);
    }

    @Override
    public final Iterator<ue_0> iterator() {
        return this.a.iterator();
    }

    public final ud_0 a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final ue_0 a(int n2, int n3) {
        if (n2 < 0 || n2 >= this.b) {
            throw new po_0(n2, (Number)0, this.b - 1);
        }
        if (n3 < 0 || n3 >= this.c) {
            throw new po_0(n3, (Number)0, this.c - 1);
        }
        return this.a.a(this.h[n2][n3]);
    }

    public final ue_0 a(int n2, int n3, int n4, int n5) {
        int[] nArray;
        int n6 = n5;
        n5 = n4;
        n4 = n3;
        n3 = n2;
        uq_0 uq_02 = this;
        switch (uq.1.a[n5 - 1]) {
            case 1: {
                n5 = -1;
                break;
            }
            case 2: {
                n5 = 1;
                break;
            }
            case 3: {
                n5 = 0;
                break;
            }
            default: {
                throw new oY();
            }
        }
        n4 += n5;
        if (uq_02.f) {
            n4 = n4 < 0 ? (n4 += uq_02.c) : (n4 %= uq_02.c);
        }
        switch (uq.1.b[n6 - 1]) {
            case 1: {
                n5 = -1;
                break;
            }
            case 2: {
                n5 = 1;
                break;
            }
            case 3: {
                n5 = 0;
                break;
            }
            default: {
                throw new oY();
            }
        }
        n3 += n5;
        if (uq_02.e) {
            n3 = n3 < 0 ? (n3 += uq_02.b) : (n3 %= uq_02.b);
        }
        if (n3 < 0 || n3 >= uq_02.b || n4 < 0 || n4 >= uq_02.c) {
            nArray = null;
        } else {
            int[] nArray2 = new int[2];
            nArray2[0] = n3;
            nArray = nArray2;
            nArray2[1] = n4;
        }
        uq_02 = nArray;
        if (nArray == null) {
            return null;
        }
        return this.a((int)uq_02[0], (int)uq_02[1]);
    }

    private int[] b(int n2, int n3, int n4, int n5) {
        switch (uq.1.a[n4 - 1]) {
            case 1: {
                n4 = -1;
                break;
            }
            case 2: {
                n4 = 1;
                break;
            }
            case 3: {
                n4 = 0;
                break;
            }
            default: {
                throw new oY();
            }
        }
        n3 += n4;
        if (this.f) {
            n3 = n3 < 0 ? (n3 += this.c) : (n3 %= this.c);
        }
        switch (uq.1.b[n5 - 1]) {
            case 1: {
                n4 = -1;
                break;
            }
            case 2: {
                n4 = 1;
                break;
            }
            case 3: {
                n4 = 0;
                break;
            }
            default: {
                throw new oY();
            }
        }
        n2 += n4;
        if (this.e) {
            n2 = n2 < 0 ? (n2 += this.b) : (n2 %= this.b);
        }
        if (n2 < 0 || n2 >= this.b || n3 < 0 || n3 >= this.c) {
            return null;
        }
        return new int[]{n2, n3};
    }

    /*
     * Unable to fully structure code
     */
    private void e() {
        var1_1 = new ArrayList<Long>();
        var2_2 = this.b - 1;
        var3_3 = this.c - 1;
        for (var4_4 = 0; var4_4 < this.b; ++var4_4) {
            for (var5_5 = 0; var5_5 < this.c; ++var5_5) {
                var1_1.clear();
                switch (uq.1.c[this.g - 1]) {
                    case 1: {
                        if (var4_4 > 0) {
                            if (var5_5 > 0) {
                                var1_1.add(this.h[var4_4 - 1][var5_5 - 1]);
                            }
                            if (var5_5 < var3_3) {
                                var1_1.add(this.h[var4_4 - 1][var5_5 + 1]);
                            }
                        }
                        if (var4_4 < var2_2) {
                            if (var5_5 > 0) {
                                var1_1.add(this.h[var4_4 + 1][var5_5 - 1]);
                            }
                            if (var5_5 < var3_3) {
                                var1_1.add(this.h[var4_4 + 1][var5_5 + 1]);
                            }
                        }
                        if (this.e) {
                            if (var4_4 == 0) {
                                if (var5_5 > 0) {
                                    var1_1.add(this.h[var2_2][var5_5 - 1]);
                                }
                                if (var5_5 < var3_3) {
                                    var1_1.add(this.h[var2_2][var5_5 + 1]);
                                }
                            } else if (var4_4 == var2_2) {
                                if (var5_5 > 0) {
                                    var1_1.add(this.h[0][var5_5 - 1]);
                                }
                                if (var5_5 < var3_3) {
                                    var1_1.add(this.h[0][var5_5 + 1]);
                                }
                            }
                        }
                        if (this.f) {
                            if (var5_5 == 0) {
                                if (var4_4 > 0) {
                                    var1_1.add(this.h[var4_4 - 1][var3_3]);
                                }
                                if (var4_4 < var2_2) {
                                    var1_1.add(this.h[var4_4 + 1][var3_3]);
                                }
                            } else if (var5_5 == var3_3) {
                                if (var4_4 > 0) {
                                    var1_1.add(this.h[var4_4 - 1][0]);
                                }
                                if (var4_4 < var2_2) {
                                    var1_1.add(this.h[var4_4 + 1][0]);
                                }
                            }
                        }
                        if (!this.e || !this.f) ** GOTO lbl71
                        if (var4_4 != 0 || var5_5 != 0) ** GOTO lbl60
                        var1_1.add(this.h[var2_2][var3_3]);
                        ** GOTO lbl71
lbl60:
                        // 1 sources

                        if (var4_4 != 0 || var5_5 != var3_3) ** GOTO lbl64
                        var1_1.add(this.h[var2_2][0]);
                        ** GOTO lbl71
lbl64:
                        // 1 sources

                        if (var4_4 != var2_2 || var5_5 != 0) ** GOTO lbl68
                        var1_1.add(this.h[0][var3_3]);
                        ** GOTO lbl71
lbl68:
                        // 1 sources

                        if (var4_4 == var2_2 && var5_5 == var3_3) {
                            var1_1.add(this.h[0][0]);
                        }
                    }
lbl71:
                    // 8 sources

                    case 2: {
                        if (var4_4 > 0) {
                            var1_1.add(this.h[var4_4 - 1][var5_5]);
                        }
                        if (var4_4 < var2_2) {
                            var1_1.add(this.h[var4_4 + 1][var5_5]);
                        }
                        if (this.e) {
                            if (var4_4 == 0) {
                                var1_1.add(this.h[var2_2][var5_5]);
                            } else if (var4_4 == var2_2) {
                                var1_1.add(this.h[0][var5_5]);
                            }
                        }
                        if (var5_5 > 0) {
                            var1_1.add(this.h[var4_4][var5_5 - 1]);
                        }
                        if (var5_5 < var3_3) {
                            var1_1.add(this.h[var4_4][var5_5 + 1]);
                        }
                        if (!this.f) break;
                        if (var5_5 == 0) {
                            var1_1.add(this.h[var4_4][var3_3]);
                            break;
                        }
                        if (var5_5 != var3_3) break;
                        var1_1.add(this.h[var4_4][0]);
                        break;
                    }
                    default: {
                        throw new oY();
                    }
                }
                var6_6 = this.a.a(this.h[var4_4][var5_5]);
                var7_7 = var1_1.iterator();
                while (var7_7.hasNext()) {
                    var8_9 = (Long)var7_7.next();
                    var8_8 = this.a.a(var8_9);
                    this.a.a(var6_6, var8_8);
                }
            }
        }
    }

    private static void f() {
        throw new IllegalStateException();
    }

    private b_0 g() {
        double[][][] dArray = new double[this.b][this.c][];
        for (int i2 = 0; i2 < this.b; ++i2) {
            for (int i3 = 0; i3 < this.c; ++i3) {
                dArray[i2][i3] = this.a(i2, i3).c();
            }
        }
        return new uq.b(this.e, this.f, this.g, dArray);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.yW;
import org.valkyrienskies.core.impl.shadow.yp_0;
import org.valkyrienskies.core.impl.shadow.za_0;
import org.valkyrienskies.core.impl.shadow.zd_0;
import org.valkyrienskies.core.impl.shadow.ze_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.zc
 */
@Deprecated
public final class zc_0
extends yW {
    private static final double a = 1.0E-6;
    private static final int b = 10;
    private final double c;
    private final int d;

    public zc_0() {
        this(1.0E-6, 10);
    }

    private zc_0(double d2, int n2) {
        this.c = 1.0E-6;
        this.d = 10;
    }

    private static Integer a(zd_0 zd_02) {
        double d2 = 0.0;
        Integer n2 = null;
        for (int i2 = zd_02.a(); i2 < zd_02.e() - 1; ++i2) {
            double d3;
            double d4 = zd_02.a(0, i2);
            if (!(d3 < d2)) continue;
            d2 = d4;
            n2 = i2;
        }
        return n2;
    }

    private Integer a(zd_0 zd_02, int n2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        double d2 = Double.MAX_VALUE;
        for (int i2 = zd_02.a(); i2 < zd_02.f(); ++i2) {
            double d3 = zd_02.a(i2, zd_02.e() - 1);
            double d4 = zd_02.a(i2, n2);
            if (cq_0.a(d4, 0.0, this.d) <= 0) continue;
            double d5 = d3 / d4;
            int n3 = Double.compare(d5, d2);
            if (n3 == 0) {
                arrayList.add(i2);
                continue;
            }
            if (n3 >= 0) continue;
            d2 = d5;
            arrayList = new ArrayList<Integer>();
            arrayList.add(i2);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        if (arrayList.size() > 1) {
            int n4;
            zd_0 zd_03 = zd_02;
            if (zd_03.a > 0) {
                block1: for (Integer n5 : arrayList) {
                    n4 = 0;
                    while (true) {
                        zd_03 = zd_02;
                        if (n4 >= zd_03.a) continue block1;
                        int n6 = n4 + zd_02.g();
                        double d6 = zd_02.a((int)n5, n6);
                        if (cq_0.b(d6, 1.0, this.d) && n5.equals(zd_02.a(n6))) {
                            return n5;
                        }
                        ++n4;
                    }
                }
            }
            if (this.f() < this.e() / 2) {
                Integer n7 = null;
                int n8 = zd_02.e();
                n4 = zd_02.a();
                int n9 = zd_02.e() - 1;
                for (Integer n10 : arrayList) {
                    for (int i3 = n4; i3 < n9 && !n10.equals(n7); ++i3) {
                        Integer n11 = zd_02.a(i3);
                        if (n11 == null || !n11.equals(n10) || i3 >= n8) continue;
                        n8 = i3;
                        n7 = n10;
                    }
                }
                return n7;
            }
        }
        return (Integer)arrayList.get(0);
    }

    /*
     * Unable to fully structure code
     */
    private void b(zd_0 var1_1) {
        block13: {
            block14: {
                this.g();
                var3_2 = var1_1;
                var11_3 = 0.0;
                var13_5 = null;
                for (var14_7 = var3_2.a(); var14_7 < var3_2.e() - 1; ++var14_7) {
                    var15_8 = var3_2.a(0, var14_7);
                    if (!(v0 < var11_3)) continue;
                    var11_3 = var15_8;
                    var13_5 = var14_7;
                }
                var2_12 = var13_5;
                var11_4 = var2_12;
                var4_13 = var1_1;
                var3_2 = this;
                var12_16 = new ArrayList<Integer>();
                var13_6 = 1.7976931348623157E308;
                for (var15_9 = var4_13.a(); var15_9 < var4_13.f(); ++var15_9) {
                    var16_19 = var4_13.a(var15_9, var4_13.e() - 1);
                    var18_22 = var4_13.a(var15_9, var11_4);
                    if (cq_0.a(var18_22, 0.0, var3_2.d) <= 0) continue;
                    var20_25 = var16_19 / var18_22;
                    var5_17 = Double.compare(var20_25, var13_6);
                    if (var5_17 == 0) {
                        var12_16.add(var15_9);
                        continue;
                    }
                    if (var5_17 >= 0) continue;
                    var13_6 = var20_25;
                    var12_16 = new ArrayList<Integer>();
                    var12_16.add(var15_9);
                }
                if (var12_16.size() != 0) break block14;
                v1 = null;
                break block13;
            }
            if (var12_16.size() <= 1) ** GOTO lbl-1000
            var5_18 = var4_13;
            if (var5_18.a > 0) {
                block2: for (Integer var16_20 : var12_16) {
                    var17_27 = 0;
                    while (true) {
                        var5_18 = var4_13;
                        if (var17_27 >= var5_18.a) continue block2;
                        var18_23 = var17_27 + var4_13.g();
                        var19_28 = var4_13.a((int)var16_20, var18_23);
                        if (cq_0.b(var19_28, 1.0, var3_2.d) && var16_20.equals(var4_13.a(var18_23))) {
                            v1 = var16_20;
                            break block13;
                        }
                        ++var17_27;
                    }
                }
            }
            if (var3_2.f() < var3_2.e() / 2) {
                var15_11 = null;
                var16_21 = var4_13.e();
                var17_27 = var4_13.a();
                var18_24 = var4_13.e() - 1;
                for (Integer var20_26 : var12_16) {
                    for (var21_30 = var17_27; var21_30 < var18_24 && !var20_26.equals(var15_11); ++var21_30) {
                        var5_18 = var4_13.a(var21_30);
                        if (var5_18 == null || !var5_18.equals(var20_26) || var21_30 >= var16_21) continue;
                        var16_21 = var21_30;
                        var15_11 = var20_26;
                    }
                }
                v1 = var15_11;
            } else lbl-1000:
            // 2 sources

            {
                v1 = var3_2 = (Integer)var12_16.get(0);
            }
        }
        if (v1 == null) {
            throw new ze_0();
        }
        var4_14 = var1_1.a(var3_2.intValue(), var2_12);
        var1_1.a(var3_2.intValue(), var4_14);
        for (var4_15 = 0; var4_15 < var1_1.f(); ++var4_15) {
            if (var4_15 == var3_2.intValue()) continue;
            var7_31 = var1_1.a(var4_15, var2_12);
            var1_1.a(var4_15, var3_2.intValue(), var7_31);
        }
    }

    private void c(zd_0 zd_02) {
        zd_0 zd_03 = zd_02;
        if (zd_03.a == 0) {
            return;
        }
        while (!zd_02.c()) {
            this.b(zd_02);
        }
        if (!cq_0.b(zd_02.a(0, zd_02.h()), 0.0, this.c)) {
            throw new za_0();
        }
    }

    public final yp_0 h() {
        zd_0 zd_02;
        zd_0 zd_03 = zd_02 = new zd_0(this.c(), this.d(), this.b(), this.a(), this.c, this.d);
        zc_0 zc_02 = this;
        zd_0 zd_04 = zd_03;
        if (zd_04.a != 0) {
            while (!zd_03.c()) {
                zc_02.b(zd_03);
            }
            if (!cq_0.b(zd_03.a(0, zd_03.h()), 0.0, zc_02.c)) {
                throw new za_0();
            }
        }
        zd_02.b();
        while (!zd_02.c()) {
            this.b(zd_02);
        }
        return zd_02.d();
    }
}


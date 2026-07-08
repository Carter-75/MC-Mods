/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.vH;
import org.valkyrienskies.core.impl.shadow.vK;
import org.valkyrienskies.core.impl.shadow.wk_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class vG<T extends kO<T>>
extends vK<T> {
    private static final String d = "Dormand-Prince 8 (5, 3)";
    private final T e = this.a(1.16092271E8, 8.84846592E9);
    private final T k = this.a(-1871647.0, 1527680.0);
    private final T l = this.a(-6.9799717E7, 1.4079366E8);
    private final T m = this.a(1.230164450203E12, 7.39113984E11);
    private final T n = this.a(-1.980813971228885E15, 5.654156025964544E15);
    private final T o = this.a(4.64500805E8, 1.389975552E9);
    private final T p = this.a(1.606764981773E12, 1.9613062656E13);
    private final T q = this.a(-137909.0, 6168960.0);
    private final T r = this.a(-364463.0, 1920240.0);
    private final T s = this.a(3399327.0, 763840.0);
    private final T t = this.a(6.6578432E7, 3.5198415E7);
    private final T u = this.a(-1.674902723E9, 2.887164E8);
    private final T v = this.a(-7.4684743568175E13, 1.76692375811392E14);
    private final T w = this.a(-734375.0, 4826304.0);
    private final T x = this.a(1.71414593E8, 8.512614E8);
    private final T y = this.a(69869.0, 3084480.0);

    public vG(kM<T> kM2, double d2, double d3, double d4, double d5) {
        super(kM2, d, 12, d2, d3, d4, d5);
    }

    public vG(kM<T> kM2, double d2, double d3, double[] dArray, double[] dArray2) {
        super(kM2, d, 12, d2, d3, dArray, dArray2);
    }

    @Override
    public final T[] p() {
        kO kO2 = (kO)((kO)((kO)this.a().b()).a(6)).k();
        kO[] kOArray = (kO[])ch_0.a(this.a(), 15);
        kO[] kOArray2 = kOArray;
        kOArray[0] = (kO)((kO)kO2.a(-6.0)).d(-67.5);
        kOArray2[1] = (kO)((kO)kO2.a(-6.0)).d(-45.0);
        kOArray2[2] = (kO)((kO)kO2.a(-6.0)).d(-30.0);
        kOArray2[3] = (kO)((kO)kO2.a(6.0)).d(30.0);
        kOArray2[4] = this.a(1, 3);
        kOArray2[5] = this.a(1, 4);
        kOArray2[6] = this.a(4, 13);
        kOArray2[7] = this.a(127, 195);
        kOArray2[8] = this.a(3, 5);
        kOArray2[9] = this.a(6, 7);
        kOArray2[10] = (kO)this.a().b();
        kOArray2[11] = (kO)this.a().b();
        kOArray2[12] = this.a(1.0, 10.0);
        kOArray2[13] = this.a(1.0, 5.0);
        kOArray2[14] = this.a(7.0, 9.0);
        return kOArray2;
    }

    @Override
    public final T[][] q() {
        kO kO2 = (kO)((kO)((kO)this.a().b()).a(6)).k();
        kO[][] kOArray = (kO[][])ch_0.a(this.a(), 15, -1);
        for (int i2 = 0; i2 < kOArray.length; ++i2) {
            kOArray[i2] = (kO[])ch_0.a(this.a(), i2 + 1);
        }
        kOArray[0][0] = (kO)((kO)kO2.a(-6.0)).d(-67.5);
        kOArray[1][0] = (kO)((kO)kO2.a(-6.0)).d(-180.0);
        kOArray[1][1] = (kO)((kO)kO2.a(-6.0)).d(-60.0);
        kOArray[2][0] = (kO)((kO)kO2.a(-6.0)).d(-120.0);
        kOArray[2][1] = (kO)this.a().a();
        kOArray[2][2] = (kO)((kO)kO2.a(-6.0)).d(-40.0);
        kOArray[3][0] = (kO)((kO)((kO)kO2.a(107)).a(462.0)).d(3000.0);
        kOArray[3][1] = (kO)this.a().a();
        kOArray[3][2] = (kO)((kO)((kO)kO2.a(197)).a(402.0)).d(-1000.0);
        kOArray[3][3] = (kO)((kO)((kO)kO2.a(73)).a(168.0)).d(375.0);
        kOArray[4][0] = this.a(1, 27);
        kOArray[4][1] = (kO)this.a().a();
        kOArray[4][2] = (kO)this.a().a();
        kOArray[4][3] = (kO)((kO)kO2.a(16.0)).d(108.0);
        kOArray[4][4] = (kO)((kO)kO2.a(-16.0)).d(-108.0);
        kOArray[5][0] = this.a(19, 512);
        kOArray[5][1] = (kO)this.a().a();
        kOArray[5][2] = (kO)this.a().a();
        kOArray[5][3] = (kO)((kO)((kO)kO2.a(23)).a(118.0)).d(1024.0);
        kOArray[5][4] = (kO)((kO)((kO)kO2.a(-23)).a(118.0)).d(1024.0);
        kOArray[5][5] = this.a(-9, 512);
        kOArray[6][0] = this.a(13772, 371293);
        kOArray[6][1] = (kO)this.a().a();
        kOArray[6][2] = (kO)this.a().a();
        kOArray[6][3] = (kO)((kO)((kO)kO2.a(4784)).a(51544.0)).d(371293.0);
        kOArray[6][4] = (kO)((kO)((kO)kO2.a(-4784)).a(51544.0)).d(371293.0);
        kOArray[6][5] = this.a(-5688, 371293);
        kOArray[6][6] = this.a(3072, 371293);
        kOArray[7][0] = this.a(5.8656157643E10, 9.3983540625E10);
        kOArray[7][1] = (kO)this.a().a();
        kOArray[7][2] = (kO)this.a().a();
        kOArray[7][3] = (kO)((kO)((kO)kO2.c(-3.18801444819E11)).a(-1.324889724104E12)).d(6.265569375E11);
        kOArray[7][4] = (kO)((kO)((kO)kO2.c(3.18801444819E11)).a(-1.324889724104E12)).d(6.265569375E11);
        kOArray[7][5] = this.a(9.6044563816E10, 3.480871875E9);
        kOArray[7][6] = this.a(5.682451879168E12, 2.81950621875E11);
        kOArray[7][7] = this.a(-1.65125654E8, 3796875.0);
        kOArray[8][0] = this.a(8909899.0, 1.8653125E7);
        kOArray[8][1] = (kO)this.a().a();
        kOArray[8][2] = (kO)this.a().a();
        kOArray[8][3] = (kO)((kO)((kO)kO2.c(-1137963.0)).a(-4521408.0)).d(2937500.0);
        kOArray[8][4] = (kO)((kO)((kO)kO2.c(1137963.0)).a(-4521408.0)).d(2937500.0);
        kOArray[8][5] = this.a(9.6663078E7, 4553125.0);
        kOArray[8][6] = this.a(2.107245056E9, 1.37915625E8);
        kOArray[8][7] = this.a(-4.913652016E9, 1.47609375E8);
        kOArray[8][8] = this.a(-7.889427E7, 3.880452869E9);
        kOArray[9][0] = this.a(-2.0401265806E10, 2.1769653311E10);
        kOArray[9][1] = (kO)this.a().a();
        kOArray[9][2] = (kO)this.a().a();
        kOArray[9][3] = (kO)((kO)((kO)kO2.c(94326.0)).a(354216.0)).d(112847.0);
        kOArray[9][4] = (kO)((kO)((kO)kO2.c(-94326.0)).a(354216.0)).d(112847.0);
        kOArray[9][5] = this.a(-4.3306765128E10, 5.313852383E9);
        kOArray[9][6] = this.a(-2.0866708358144E13, 1.126708119789E12);
        kOArray[9][7] = this.a(1.488600343802E13, 6.54632330667E11);
        kOArray[9][8] = this.a(3.5290686222309376E16, 1.4152473387134412E16);
        kOArray[9][9] = this.a(-1.477884375E9, 4.85066827E8);
        kOArray[10][0] = this.a(3.9815761E7, 1.7514443E7);
        kOArray[10][1] = (kO)this.a().a();
        kOArray[10][2] = (kO)this.a().a();
        kOArray[10][3] = (kO)((kO)((kO)kO2.c(-960905.0)).a(-3457480.0)).d(551636.0);
        kOArray[10][4] = (kO)((kO)((kO)kO2.c(960905.0)).a(-3457480.0)).d(551636.0);
        kOArray[10][5] = this.a(-8.44554132E8, 4.7026969E7);
        kOArray[10][6] = this.a(8.444996352E9, 3.02158619E8);
        kOArray[10][7] = this.a(-2.509602342E9, 8.77790785E8);
        kOArray[10][8] = this.a(-2.838879529799625E16, 3.199510091356783E15);
        kOArray[10][9] = this.a(2.2671625E8, 1.8341897E7);
        kOArray[10][10] = this.a(1.371316744E9, 2.131383595E9);
        kOArray[11][0] = this.a(104257.0, 1920240.0);
        kOArray[11][1] = (kO)this.a().a();
        kOArray[11][2] = (kO)this.a().a();
        kOArray[11][3] = (kO)this.a().a();
        kOArray[11][4] = (kO)this.a().a();
        kOArray[11][5] = this.a(3399327.0, 763840.0);
        kOArray[11][6] = this.a(6.6578432E7, 3.5198415E7);
        kOArray[11][7] = this.a(-1.674902723E9, 2.887164E8);
        kOArray[11][8] = this.a(5.4980371265625E13, 1.76692375811392E14);
        kOArray[11][9] = this.a(-734375.0, 4826304.0);
        kOArray[11][10] = this.a(1.71414593E8, 8.512614E8);
        kOArray[11][11] = this.a(137909.0, 3084480.0);
        kOArray[12][0] = this.a(1.3481885573E10, 2.4003E11);
        kOArray[12][1] = (kO)this.a().a();
        kOArray[12][2] = (kO)this.a().a();
        kOArray[12][3] = (kO)this.a().a();
        kOArray[12][4] = (kO)this.a().a();
        kOArray[12][5] = (kO)this.a().a();
        kOArray[12][6] = this.a(1.39418837528E11, 5.49975234375E11);
        kOArray[12][7] = this.a(-1.1108320068443E13, 4.51119375E13);
        kOArray[12][8] = this.a(-1.769651421925959E15, 1.424938514608E16);
        kOArray[12][9] = this.a(5.7799439E7, 3.77055E8);
        kOArray[12][10] = this.a(7.93322643029E11, 9.673425E13);
        kOArray[12][11] = this.a(1.458939311E9, 1.9278E11);
        kOArray[12][12] = this.a(-4149.0, 500000.0);
        kOArray[13][0] = this.a(1.595561272731E12, 5.01202735E13);
        kOArray[13][1] = (kO)this.a().a();
        kOArray[13][2] = (kO)this.a().a();
        kOArray[13][3] = (kO)this.a().a();
        kOArray[13][4] = (kO)this.a().a();
        kOArray[13][5] = this.a(9.75183916491E11, 3.445768803125E13);
        kOArray[13][6] = this.a(3.8492013932672E13, 7.18912673015625E14);
        kOArray[13][7] = this.a(-1.114881286517557E15, 2.02987107675E16);
        kOArray[13][8] = (kO)this.a().a();
        kOArray[13][9] = (kO)this.a().a();
        kOArray[13][10] = this.a(-2.538710946863E12, 2.343122786125E16);
        kOArray[13][11] = this.a(8.824659001E9, 2.306671678125E13);
        kOArray[13][12] = this.a(-1.1518334563E10, 3.38311846125E13);
        kOArray[13][13] = this.a(1.912306948E9, 1.3532473845E10);
        kOArray[14][0] = this.a(-1.3613986967E10, 3.1741908048E10);
        kOArray[14][1] = (kO)this.a().a();
        kOArray[14][2] = (kO)this.a().a();
        kOArray[14][3] = (kO)this.a().a();
        kOArray[14][4] = (kO)this.a().a();
        kOArray[14][5] = this.a(-4.755612631E9, 1.012344804E9);
        kOArray[14][6] = this.a(4.2939257944576E13, 5.588559685701E12);
        kOArray[14][7] = this.a(7.7881972900277E13, 1.9140370552944E13);
        kOArray[14][8] = this.a(2.2719829234375E13, 6.3689648654052E13);
        kOArray[14][9] = (kO)this.a().a();
        kOArray[14][10] = (kO)this.a().a();
        kOArray[14][11] = (kO)this.a().a();
        kOArray[14][12] = this.a(-1.199007803E9, 8.57031517296E11);
        kOArray[14][13] = this.a(1.57882067E11, 5.3564469831E10);
        kOArray[14][14] = this.a(-2.90468882375E11, 3.1741908048E10);
        return kOArray;
    }

    @Override
    public final T[] r() {
        kO[] kOArray = (kO[])ch_0.a(this.a(), 16);
        kO[] kOArray2 = kOArray;
        kOArray[0] = this.a(104257, 1920240);
        kOArray2[1] = (kO)this.a().a();
        kOArray2[2] = (kO)this.a().a();
        kOArray2[3] = (kO)this.a().a();
        kOArray2[4] = (kO)this.a().a();
        kOArray2[5] = this.a(3399327.0, 763840.0);
        kOArray2[6] = this.a(6.6578432E7, 3.5198415E7);
        kOArray2[7] = this.a(-1.674902723E9, 2.887164E8);
        kOArray2[8] = this.a(5.4980371265625E13, 1.76692375811392E14);
        kOArray2[9] = this.a(-734375.0, 4826304.0);
        kOArray2[10] = this.a(1.71414593E8, 8.512614E8);
        kOArray2[11] = this.a(137909.0, 3084480.0);
        kOArray2[12] = (kO)this.a().a();
        kOArray2[13] = (kO)this.a().a();
        kOArray2[14] = (kO)this.a().a();
        kOArray2[15] = (kO)this.a().a();
        return kOArray2;
    }

    private vH<T> b(boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uG<T> uG2) {
        return new vH(this.a(), bl, TArray, uJ2, uJ3, uJ2, uJ3, uG2);
    }

    @Override
    public final int s() {
        return 8;
    }

    @Override
    protected final T a(T[][] TArray, T[] TArray2, T[] TArray3, T t) {
        kO kO2;
        kO kO3 = (kO)t.c().a();
        kO kO4 = (kO)t.c().a();
        for (int i2 = 0; i2 < this.j; ++i2) {
            kO kO5 = (kO)((kO)((kO)((kO)((kO)((kO)((kO)((kO)TArray[0][i2].c(this.e)).a(TArray[5][i2].c(this.k))).a(TArray[6][i2].c(this.l))).a(TArray[7][i2].c(this.m))).a(TArray[8][i2].c(this.n))).a(TArray[9][i2].c(this.o))).a(TArray[10][i2].c(this.p))).a(TArray[11][i2].c(this.q));
            kO kO6 = (kO)((kO)((kO)((kO)((kO)((kO)((kO)((kO)TArray[0][i2].c(this.r)).a(TArray[5][i2].c(this.s))).a(TArray[6][i2].c(this.t))).a(TArray[7][i2].c(this.u))).a(TArray[8][i2].c(this.v))).a(TArray[9][i2].c(this.w))).a(TArray[10][i2].c(this.x))).a(TArray[11][i2].c(this.y));
            kO kO7 = ci_0.a((kO)TArray2[i2].e(), (kO)TArray3[i2].e());
            kO7 = this.h == null ? (kO)((kO)kO7.c(this.g)).a(this.f) : (kO)((kO)kO7.c(this.i[i2])).a(this.h[i2]);
            kO kO8 = kO5 = kO5.d(kO7);
            kO3 = kO3.a(kO8.c(kO8));
            kO kO9 = kO5 = kO6.d(kO7);
            kO4 = kO4.a(kO9.c(kO9));
        }
        kO kO10 = (kO)kO3.a(kO4.c(0.01));
        if (kO2.d() <= 0.0) {
            kO10 = (kO)t.c().b();
        }
        return (T)((kO)((kO)t.e()).c(kO3).d(((kO)kO10.a(this.j)).k()));
    }

    protected final /* synthetic */ wk_0 a(boolean bl, kO[][] kOArray, uJ kOArray2, uJ uJ2, uG object) {
        uG uG2 = object;
        object = uJ2;
        uJ2 = kOArray2;
        kOArray2 = kOArray;
        boolean bl2 = bl;
        vG vG2 = this;
        return new vH(vG2.a(), bl2, kOArray2, uJ2, (uJ)object, uJ2, (uJ)object, uG2);
    }
}


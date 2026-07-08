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
import org.valkyrienskies.core.impl.shadow.vD;
import org.valkyrienskies.core.impl.shadow.vK;
import org.valkyrienskies.core.impl.shadow.wk_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class vC<T extends kO<T>>
extends vK<T> {
    private static final String d = "Dormand-Prince 5(4)";
    private final T e = this.a(71, 57600);
    private final T k = this.a(-71, 16695);
    private final T l = this.a(71, 1920);
    private final T m = this.a(-17253, 339200);
    private final T n = this.a(22, 525);
    private final T o = this.a(-1, 40);

    private vC(kM<T> kM2, double d2, double d3, double d4, double d5) {
        super(kM2, d, 6, d2, d3, d4, d5);
    }

    private vC(kM<T> kM2, double d2, double d3, double[] dArray, double[] dArray2) {
        super(kM2, d, 6, d2, d3, dArray, dArray2);
    }

    @Override
    public final T[] p() {
        kO[] kOArray = (kO[])ch_0.a(this.a(), 6);
        kO[] kOArray2 = kOArray;
        kOArray[0] = this.a(1, 5);
        kOArray2[1] = this.a(3, 10);
        kOArray2[2] = this.a(4, 5);
        kOArray2[3] = this.a(8, 9);
        kOArray2[4] = (kO)this.a().b();
        kOArray2[5] = (kO)this.a().b();
        return kOArray2;
    }

    @Override
    public final T[][] q() {
        kO[][] kOArray = (kO[][])ch_0.a(this.a(), 6, -1);
        for (int i2 = 0; i2 < kOArray.length; ++i2) {
            kOArray[i2] = (kO[])ch_0.a(this.a(), i2 + 1);
        }
        kOArray[0][0] = this.a(1, 5);
        kOArray[1][0] = this.a(3, 40);
        kOArray[1][1] = this.a(9, 40);
        kOArray[2][0] = this.a(44, 45);
        kOArray[2][1] = this.a(-56, 15);
        kOArray[2][2] = this.a(32, 9);
        kOArray[3][0] = this.a(19372, 6561);
        kOArray[3][1] = this.a(-25360, 2187);
        kOArray[3][2] = this.a(64448, 6561);
        kOArray[3][3] = this.a(-212, 729);
        kOArray[4][0] = this.a(9017, 3168);
        kOArray[4][1] = this.a(-355, 33);
        kOArray[4][2] = this.a(46732, 5247);
        kOArray[4][3] = this.a(49, 176);
        kOArray[4][4] = this.a(-5103, 18656);
        kOArray[5][0] = this.a(35, 384);
        kOArray[5][1] = (kO)this.a().a();
        kOArray[5][2] = this.a(500, 1113);
        kOArray[5][3] = this.a(125, 192);
        kOArray[5][4] = this.a(-2187, 6784);
        kOArray[5][5] = this.a(11, 84);
        return kOArray;
    }

    @Override
    public final T[] r() {
        kO[] kOArray = (kO[])ch_0.a(this.a(), 7);
        kO[] kOArray2 = kOArray;
        kOArray[0] = this.a(35, 384);
        kOArray2[1] = (kO)this.a().a();
        kOArray2[2] = this.a(500, 1113);
        kOArray2[3] = this.a(125, 192);
        kOArray2[4] = this.a(-2187, 6784);
        kOArray2[5] = this.a(11, 84);
        kOArray2[6] = (kO)this.a().a();
        return kOArray2;
    }

    private vD<T> b(boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uG<T> uG2) {
        return new vD(this.a(), bl, TArray, uJ2, uJ3, uJ2, uJ3, uG2);
    }

    @Override
    public final int s() {
        return 5;
    }

    @Override
    protected final T a(T[][] TArray, T[] TArray2, T[] TArray3, T kO2) {
        kO kO3 = (kO)this.a().a();
        for (int i2 = 0; i2 < this.j; ++i2) {
            kO kO4 = (kO)((kO)((kO)((kO)((kO)((kO)TArray[0][i2].c(this.e)).a(TArray[2][i2].c(this.k))).a(TArray[3][i2].c(this.l))).a(TArray[4][i2].c(this.m))).a(TArray[5][i2].c(this.n))).a(TArray[6][i2].c(this.o));
            kO kO5 = ci_0.a((kO)TArray2[i2].e(), (kO)TArray3[i2].e());
            kO5 = this.h == null ? (kO)((kO)kO5.c(this.g)).a(this.f) : (kO)((kO)kO5.c(this.i[i2])).a(this.h[i2]);
            kO kO6 = kO4 = kO2.c((kO)kO4).d(kO5);
            kO3 = kO3.a(kO6.c(kO6));
        }
        return (T)((kO)((kO)kO3.d((double)this.j)).k());
    }

    protected final /* synthetic */ wk_0 a(boolean bl, kO[][] kOArray, uJ kOArray2, uJ uJ2, uG object) {
        uG uG2 = object;
        object = uJ2;
        uJ2 = kOArray2;
        kOArray2 = kOArray;
        boolean bl2 = bl;
        vC vC2 = this;
        return new vD(vC2.a(), bl2, kOArray2, uJ2, (uJ)object, uJ2, (uJ)object, uG2);
    }
}


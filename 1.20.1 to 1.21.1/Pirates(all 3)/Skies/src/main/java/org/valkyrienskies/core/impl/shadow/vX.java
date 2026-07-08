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
import org.valkyrienskies.core.impl.shadow.vK;
import org.valkyrienskies.core.impl.shadow.vY;
import org.valkyrienskies.core.impl.shadow.wk_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class vX<T extends kO<T>>
extends vK<T> {
    private static final String d = "Higham-Hall 5(4)";
    private final T[] e;

    private vX(kM<T> kM2, double d2, double d3, double d4, double d5) {
        super(kM2, d, -1, d2, d3, d4, d5);
        this.e = (kO[])ch_0.a(kM2, 7);
        this.e[0] = this.a(-1, 20);
        this.e[1] = (kO)kM2.a();
        this.e[2] = this.a(81, 160);
        this.e[3] = this.a(-6, 5);
        this.e[4] = this.a(25, 32);
        this.e[5] = this.a(1, 16);
        this.e[6] = this.a(-1, 10);
    }

    private vX(kM<T> kM2, double d2, double d3, double[] dArray, double[] dArray2) {
        super(kM2, d, -1, d2, d3, dArray, dArray2);
        this.e = (kO[])ch_0.a(kM2, 7);
        this.e[0] = this.a(-1, 20);
        this.e[1] = (kO)kM2.a();
        this.e[2] = this.a(81, 160);
        this.e[3] = this.a(-6, 5);
        this.e[4] = this.a(25, 32);
        this.e[5] = this.a(1, 16);
        this.e[6] = this.a(-1, 10);
    }

    @Override
    public final T[] p() {
        kO[] kOArray = (kO[])ch_0.a(this.a(), 6);
        kO[] kOArray2 = kOArray;
        kOArray[0] = this.a(2, 9);
        kOArray2[1] = this.a(1, 3);
        kOArray2[2] = this.a(1, 2);
        kOArray2[3] = this.a(3, 5);
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
        kOArray[0][0] = this.a(2, 9);
        kOArray[1][0] = this.a(1, 12);
        kOArray[1][1] = this.a(1, 4);
        kOArray[2][0] = this.a(1, 8);
        kOArray[2][1] = (kO)this.a().a();
        kOArray[2][2] = this.a(3, 8);
        kOArray[3][0] = this.a(91, 500);
        kOArray[3][1] = this.a(-27, 100);
        kOArray[3][2] = this.a(78, 125);
        kOArray[3][3] = this.a(8, 125);
        kOArray[4][0] = this.a(-11, 20);
        kOArray[4][1] = this.a(27, 20);
        kOArray[4][2] = this.a(12, 5);
        kOArray[4][3] = this.a(-36, 5);
        kOArray[4][4] = this.a(5, 1);
        kOArray[5][0] = this.a(1, 12);
        kOArray[5][1] = (kO)this.a().a();
        kOArray[5][2] = this.a(27, 32);
        kOArray[5][3] = this.a(-4, 3);
        kOArray[5][4] = this.a(125, 96);
        kOArray[5][5] = this.a(5, 48);
        return kOArray;
    }

    @Override
    public final T[] r() {
        kO[] kOArray = (kO[])ch_0.a(this.a(), 7);
        kO[] kOArray2 = kOArray;
        kOArray[0] = this.a(1, 12);
        kOArray2[1] = (kO)this.a().a();
        kOArray2[2] = this.a(27, 32);
        kOArray2[3] = this.a(-4, 3);
        kOArray2[4] = this.a(125, 96);
        kOArray2[5] = this.a(5, 48);
        kOArray2[6] = (kO)this.a().a();
        return kOArray2;
    }

    private vY<T> b(boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uG<T> uG2) {
        return new vY(this.a(), bl, TArray, uJ2, uJ3, uJ2, uJ3, uG2);
    }

    @Override
    public final int s() {
        return 5;
    }

    @Override
    protected final T a(T[][] TArray, T[] TArray2, T[] TArray3, T kO2) {
        kO kO3 = (kO)this.a().a();
        for (int i2 = 0; i2 < this.j; ++i2) {
            kO kO4 = (kO)TArray[0][i2].c(this.e[0]);
            for (int i3 = 1; i3 < this.e.length; ++i3) {
                kO4 = (kO)kO4.a(TArray[i3][i2].c(this.e[i3]));
            }
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
        vX vX2 = this;
        return new vY(vX2.a(), bl2, kOArray2, uJ2, (uJ)object, uJ2, (uJ)object, uG2);
    }
}


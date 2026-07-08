/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.wc_0;
import org.valkyrienskies.core.impl.shadow.wj_0;
import org.valkyrienskies.core.impl.shadow.wk_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.wb
 */
public final class wb_0<T extends kO<T>>
extends wj_0<T> {
    private wb_0(kM<T> kM2, T t) {
        super(kM2, "Luther", t);
    }

    @Override
    public final T[] p() {
        kO kO2 = (kO)((kO)((kO)this.a().a()).a(21.0)).k();
        kO[] kOArray = (kO[])ch_0.a(this.a(), 6);
        kO[] kOArray2 = kOArray;
        kOArray[0] = (kO)this.a().b();
        kOArray2[1] = this.a(1, 2);
        kOArray2[2] = this.a(2, 3);
        kOArray2[3] = (kO)((kO)kO2.b(7.0)).d(-14.0);
        kOArray2[4] = (kO)((kO)kO2.a(7.0)).d(14.0);
        kOArray2[5] = (kO)this.a().b();
        return kOArray2;
    }

    @Override
    public final T[][] q() {
        kO kO2 = (kO)((kO)((kO)this.a().a()).a(21.0)).k();
        kO[][] kOArray = (kO[][])ch_0.a(this.a(), 6, -1);
        for (int i2 = 0; i2 < kOArray.length; ++i2) {
            kOArray[i2] = (kO[])ch_0.a(this.a(), i2 + 1);
        }
        kOArray[0][0] = (kO)this.a().b();
        kOArray[1][0] = this.a(3, 8);
        kOArray[1][1] = this.a(1, 8);
        kOArray[2][0] = this.a(8, 27);
        kOArray[2][1] = this.a(2, 27);
        kOArray[2][2] = kOArray[2][0];
        kOArray[3][0] = (kO)((kO)((kO)kO2.a(9)).a(-21.0)).d(392.0);
        kOArray[3][1] = (kO)((kO)((kO)kO2.a(8)).a(-56.0)).d(392.0);
        kOArray[3][2] = (kO)((kO)((kO)kO2.a(-48)).a(336.0)).d(392.0);
        kOArray[3][3] = (kO)((kO)((kO)kO2.a(3)).a(-63.0)).d(392.0);
        kOArray[4][0] = (kO)((kO)((kO)kO2.a(-255)).a(-1155.0)).d(1960.0);
        kOArray[4][1] = (kO)((kO)((kO)kO2.a(-40)).a(-280.0)).d(1960.0);
        kOArray[4][2] = (kO)((kO)kO2.a(-320)).d(1960.0);
        kOArray[4][3] = (kO)((kO)((kO)kO2.a(363)).a(63.0)).d(1960.0);
        kOArray[4][4] = (kO)((kO)((kO)kO2.a(392)).a(2352.0)).d(1960.0);
        kOArray[5][0] = (kO)((kO)((kO)kO2.a(105)).a(330.0)).d(180.0);
        kOArray[5][1] = this.a(2, 3);
        kOArray[5][2] = (kO)((kO)((kO)kO2.a(280)).a(-200.0)).d(180.0);
        kOArray[5][3] = (kO)((kO)((kO)kO2.a(-189)).a(126.0)).d(180.0);
        kOArray[5][4] = (kO)((kO)((kO)kO2.a(-126)).a(-686.0)).d(180.0);
        kOArray[5][5] = (kO)((kO)((kO)kO2.a(-70)).a(490.0)).d(180.0);
        return kOArray;
    }

    @Override
    public final T[] r() {
        kO[] kOArray = (kO[])ch_0.a(this.a(), 7);
        kO[] kOArray2 = kOArray;
        kOArray[0] = this.a(1, 20);
        kOArray2[1] = (kO)this.a().a();
        kOArray2[2] = this.a(16, 45);
        kOArray2[3] = (kO)this.a().a();
        kOArray2[4] = this.a(49, 180);
        kOArray2[5] = kOArray2[4];
        kOArray2[6] = kOArray2[0];
        return kOArray2;
    }

    private wc_0<T> b(boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uG<T> uG2) {
        return new wc_0(this.a(), bl, TArray, uJ2, uJ3, uJ2, uJ3, uG2);
    }

    protected final /* synthetic */ wk_0 a(boolean bl, kO[][] kOArray, uJ kOArray2, uJ uJ2, uG object) {
        uG uG2 = object;
        object = uJ2;
        uJ2 = kOArray2;
        kOArray2 = kOArray;
        boolean bl2 = bl;
        wb_0 wb_02 = this;
        return new wc_0(wb_02.a(), bl2, kOArray2, uJ2, (uJ)object, uJ2, (uJ)object, uG2);
    }
}


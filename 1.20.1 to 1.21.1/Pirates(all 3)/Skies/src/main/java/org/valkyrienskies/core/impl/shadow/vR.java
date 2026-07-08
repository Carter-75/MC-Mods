/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.vS;
import org.valkyrienskies.core.impl.shadow.wj_0;
import org.valkyrienskies.core.impl.shadow.wk_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class vR<T extends kO<T>>
extends wj_0<T> {
    private vR(kM<T> kM2, T t) {
        super(kM2, "Gill", t);
    }

    @Override
    public final T[] p() {
        kO[] kOArray = (kO[])ch_0.a(this.a(), 3);
        kO[] kOArray2 = kOArray;
        kOArray[0] = this.a(1, 2);
        kOArray2[1] = kOArray2[0];
        kOArray2[2] = (kO)this.a().b();
        return kOArray2;
    }

    @Override
    public final T[][] q() {
        kO kO2 = (kO)((kO)this.a().a()).a(2.0);
        kO2 = (kO)kO2.k();
        kO[][] kOArray = (kO[][])ch_0.a(this.a(), 3, -1);
        for (int i2 = 0; i2 < kOArray.length; ++i2) {
            kOArray[i2] = (kO[])ch_0.a(this.a(), i2 + 1);
        }
        kOArray[0][0] = this.a(1, 2);
        kOArray[1][0] = (kO)((kO)kO2.b(1.0)).c(0.5);
        kOArray[1][1] = (kO)((kO)kO2.b(2.0)).c(-0.5);
        kOArray[2][0] = (kO)this.a().a();
        kOArray[2][1] = (kO)kO2.c(-0.5);
        kOArray[2][2] = (kO)((kO)kO2.a(2.0)).c(0.5);
        return kOArray;
    }

    @Override
    public final T[] r() {
        kO kO2 = (kO)((kO)this.a().a()).a(2.0);
        kO2 = (kO)kO2.k();
        kO[] kOArray = (kO[])ch_0.a(this.a(), 4);
        kO[] kOArray2 = kOArray;
        kOArray[0] = this.a(1, 6);
        kOArray2[1] = (kO)((kO)kO2.b(2.0)).d(-6.0);
        kOArray2[2] = (kO)((kO)kO2.a(2.0)).d(6.0);
        kOArray2[3] = kOArray2[0];
        return kOArray2;
    }

    private vS<T> b(boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uG<T> uG2) {
        return new vS(this.a(), bl, TArray, uJ2, uJ3, uJ2, uJ3, uG2);
    }

    protected final /* synthetic */ wk_0 a(boolean bl, kO[][] kOArray, uJ kOArray2, uJ uJ2, uG object) {
        uG uG2 = object;
        object = uJ2;
        uJ2 = kOArray2;
        kOArray2 = kOArray;
        boolean bl2 = bl;
        vR vR2 = this;
        return new vS(vR2.a(), bl2, kOArray2, uJ2, (uJ)object, uJ2, (uJ)object, uG2);
    }
}


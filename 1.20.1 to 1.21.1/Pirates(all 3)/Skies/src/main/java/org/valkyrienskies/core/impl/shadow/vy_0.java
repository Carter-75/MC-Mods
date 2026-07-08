/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.vz_0;
import org.valkyrienskies.core.impl.shadow.wj_0;
import org.valkyrienskies.core.impl.shadow.wk_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.vy
 */
public final class vy_0<T extends kO<T>>
extends wj_0<T> {
    private vy_0(kM<T> kM2, T t) {
        super(kM2, "classical Runge-Kutta", t);
    }

    @Override
    public final T[] p() {
        kO[] kOArray = (kO[])ch_0.a(this.a(), 3);
        kO[] kOArray2 = kOArray;
        kOArray[0] = (kO)((kO)this.a().b()).c(0.5);
        kOArray2[1] = kOArray2[0];
        kOArray2[2] = (kO)this.a().b();
        return kOArray2;
    }

    @Override
    public final T[][] q() {
        kO[][] kOArray = (kO[][])ch_0.a(this.a(), 3, -1);
        for (int i2 = 0; i2 < kOArray.length; ++i2) {
            kOArray[i2] = (kO[])ch_0.a(this.a(), i2 + 1);
        }
        kOArray[0][0] = this.a(1, 2);
        kOArray[1][0] = (kO)this.a().a();
        kOArray[1][1] = kOArray[0][0];
        kOArray[2][0] = (kO)this.a().a();
        kOArray[2][1] = (kO)this.a().a();
        kOArray[2][2] = (kO)this.a().b();
        return kOArray;
    }

    @Override
    public final T[] r() {
        kO[] kOArray = (kO[])ch_0.a(this.a(), 4);
        kO[] kOArray2 = kOArray;
        kOArray[0] = this.a(1, 6);
        kOArray2[1] = this.a(1, 3);
        kOArray2[2] = kOArray2[1];
        kOArray2[3] = kOArray2[0];
        return kOArray2;
    }

    private vz_0<T> b(boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uG<T> uG2) {
        return new vz_0(this.a(), bl, TArray, uJ2, uJ3, uJ2, uJ3, uG2);
    }

    protected final /* synthetic */ wk_0 a(boolean bl, kO[][] kOArray, uJ kOArray2, uJ uJ2, uG object) {
        uG uG2 = object;
        object = uJ2;
        uJ2 = kOArray2;
        kOArray2 = kOArray;
        boolean bl2 = bl;
        vy_0 vy_02 = this;
        return new vz_0(vy_02.a(), bl2, kOArray2, uJ2, (uJ)object, uJ2, (uJ)object, uG2);
    }
}


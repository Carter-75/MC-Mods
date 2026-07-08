/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.wg_0;
import org.valkyrienskies.core.impl.shadow.wj_0;
import org.valkyrienskies.core.impl.shadow.wk_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.wf
 */
public final class wf_0<T extends kO<T>>
extends wj_0<T> {
    private wf_0(kM<T> kM2, T t) {
        super(kM2, "midpoint", t);
    }

    @Override
    public final T[] p() {
        kO[] kOArray = (kO[])ch_0.a(this.a(), 1);
        kO[] kOArray2 = kOArray;
        kOArray[0] = (kO)((kO)this.a().b()).c(0.5);
        return kOArray2;
    }

    @Override
    public final T[][] q() {
        kO[][] kOArray = (kO[][])ch_0.a(this.a(), 1, 1);
        kOArray[0][0] = this.a(1, 2);
        return kOArray;
    }

    @Override
    public final T[] r() {
        kO[] kOArray = (kO[])ch_0.a(this.a(), 2);
        kO[] kOArray2 = kOArray;
        kOArray[0] = (kO)this.a().a();
        kOArray2[1] = (kO)this.a().b();
        return kOArray2;
    }

    private wg_0<T> b(boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uG<T> uG2) {
        return new wg_0(this.a(), bl, TArray, uJ2, uJ3, uJ2, uJ3, uG2);
    }

    protected final /* synthetic */ wk_0 a(boolean bl, kO[][] kOArray, uJ kOArray2, uJ uJ2, uG object) {
        uG uG2 = object;
        object = uJ2;
        uJ2 = kOArray2;
        kOArray2 = kOArray;
        boolean bl2 = bl;
        wf_0 wf_02 = this;
        return new wg_0(wf_02.a(), bl2, kOArray2, uJ2, (uJ)object, uJ2, (uJ)object, uG2);
    }
}


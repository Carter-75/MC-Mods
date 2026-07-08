/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.vN;
import org.valkyrienskies.core.impl.shadow.wj_0;
import org.valkyrienskies.core.impl.shadow.wk_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class vM<T extends kO<T>>
extends wj_0<T> {
    private vM(kM<T> kM2, T t) {
        super(kM2, "Euler", t);
    }

    @Override
    public final T[] p() {
        return (kO[])ch_0.a(this.a(), 0);
    }

    @Override
    public final T[][] q() {
        return (kO[][])ch_0.a(this.a(), 0, 0);
    }

    @Override
    public final T[] r() {
        kO[] kOArray = (kO[])ch_0.a(this.a(), 1);
        kO[] kOArray2 = kOArray;
        kOArray[0] = (kO)this.a().b();
        return kOArray2;
    }

    private vN<T> b(boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uG<T> uG2) {
        return new vN(this.a(), bl, TArray, uJ2, uJ3, uJ2, uJ3, uG2);
    }

    protected final /* synthetic */ wk_0 a(boolean bl, kO[][] kOArray, uJ kOArray2, uJ uJ2, uG object) {
        uG uG2 = object;
        object = uJ2;
        uJ2 = kOArray2;
        kOArray2 = kOArray;
        boolean bl2 = bl;
        vM vM2 = this;
        return new vN(vM2.a(), bl2, kOArray2, uJ2, (uJ)object, uJ2, (uJ)object, uG2);
    }
}


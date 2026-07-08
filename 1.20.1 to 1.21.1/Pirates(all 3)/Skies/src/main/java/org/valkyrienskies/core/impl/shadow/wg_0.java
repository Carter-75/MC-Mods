/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uJ;
import org.valkyrienskies.core.impl.shadow.wk_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.wg
 */
final class wg_0<T extends kO<T>>
extends wk_0<T> {
    wg_0(kM<T> kM2, boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        super(kM2, bl, TArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }

    private static wg_0<T> b(kM<T> kM2, boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        return new wg_0(kM2, bl, TArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }

    @Override
    public final uJ<T> a(T t, T object, T object2, T n2) {
        kO kO2 = (kO)object.a((int)2);
        kO kO3 = ((kO)t.c().b()).b(kO2);
        if (this.a() != null && object.d() <= 0.5) {
            kO kO4 = (kO)object.c(n2);
            object = (kO)object.c(object2);
            object = this.a(new kO[]{kO4, object});
            object2 = this.c(new kO[]{kO3, kO2});
        } else {
            kO kO5 = (kO)n2.c(object);
            object = (kO)((kO)n2.c(object.a((double)1.0))).a();
            object = this.b(new kO[]{kO5, object});
            object2 = this.c(new kO[]{kO3, kO2});
        }
        return new uJ(t, object, object2);
    }

    protected final /* synthetic */ wk_0 a(kM kM2, boolean bl, kO[][] kOArray, uJ uJ2, uJ uJ3, uJ uJ4, uJ uJ5, uG uG2) {
        return new wg_0(kM2, bl, kOArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }
}


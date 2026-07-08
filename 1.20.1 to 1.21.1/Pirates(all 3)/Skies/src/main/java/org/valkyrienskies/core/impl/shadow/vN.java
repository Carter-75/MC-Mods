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
 */
final class vN<T extends kO<T>>
extends wk_0<T> {
    vN(kM<T> kM2, boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        super(kM2, bl, TArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }

    private static vN<T> b(kM<T> kM2, boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        return new vN(kM2, bl, TArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }

    @Override
    public final uJ<T> a(T t, T object, T object2, T t2) {
        if (this.a() != null && object.d() <= 0.5) {
            object = this.a(new kO[]{object2});
            object2 = this.c(new kO[]{(kO)t.c().b()});
        } else {
            object = this.b(new kO[]{(kO)t2.a()});
            object2 = this.c(new kO[]{(kO)t.c().b()});
        }
        return new uJ(t, object, object2);
    }

    protected final /* synthetic */ wk_0 a(kM kM2, boolean bl, kO[][] kOArray, uJ uJ2, uJ uJ3, uJ uJ4, uJ uJ5, uG uG2) {
        return new vN(kM2, bl, kOArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }
}


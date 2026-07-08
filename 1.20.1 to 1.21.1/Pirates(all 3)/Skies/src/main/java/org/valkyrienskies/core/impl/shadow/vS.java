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
final class vS<T extends kO<T>>
extends wk_0<T> {
    private final T d;
    private final T e;

    vS(kM<T> kM2, boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        super(kM2, bl, TArray, uJ2, uJ3, uJ4, uJ5, uG2);
        kO kO2 = (kO)((kO)((kO)kM2.a()).a(0.5)).k();
        this.d = ((kO)kM2.b()).b(kO2);
        this.e = ((kO)kM2.b()).a(kO2);
    }

    private static vS<T> b(kM<T> kM2, boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        return new vS(kM2, bl, TArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }

    @Override
    public final uJ<T> a(T t, T object, T object2, T object3) {
        kO kO2 = (kO)t.c().b();
        kO kO3 = (kO)object.a((int)2);
        kO kO4 = kO3.c(kO3);
        kO kO5 = (kO)((kO)object.c(kO3.b(3.0))).a(1.0);
        kO2 = (kO)kO3.c(kO2.b(object));
        kO kO6 = (kO)kO2.c(this.d);
        kO2 = (kO)kO2.c(this.e);
        kO kO7 = (kO)object.c(kO3.b(1.0));
        if (this.a() != null && object.d() <= 0.5) {
            object2 = (kO)object2.d(6.0);
            object3 = object2.c(((kO)object.a((int)6)).b(kO4));
            kO3 = (kO)object2.c(((kO)kO4.b(object.a((int)9))).a(6.0));
            kO kO8 = (kO)object3.c(this.d);
            object3 = (kO)object3.c(this.e);
            object = (kO)object2.c(kO4.b(object.a((int)3)));
            object = this.a(new kO[]{kO3, kO8, object3, object});
            object2 = this.c(new kO[]{kO5, kO6, kO2, kO7});
        } else {
            object2 = (kO)object3.d(-6.0);
            object3 = object2.c(((kO)kO3.a(2.0)).b(kO4));
            kO3 = (kO)object2.c(((kO)kO4.b(object.a((int)5))).a(1.0));
            kO kO9 = (kO)object3.c(this.d);
            object3 = (kO)object3.c(this.e);
            object = (kO)object2.c(((kO)kO4.a(object)).a(1.0));
            object = this.b(new kO[]{kO3, kO9, object3, object});
            object2 = this.c(new kO[]{kO5, kO6, kO2, kO7});
        }
        return new uJ(t, object, (kO[])object2);
    }

    protected final /* synthetic */ wk_0 a(kM kM2, boolean bl, kO[][] kOArray, uJ uJ2, uJ uJ3, uJ uJ4, uJ uJ5, uG uG2) {
        return new vS(kM2, bl, kOArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }
}


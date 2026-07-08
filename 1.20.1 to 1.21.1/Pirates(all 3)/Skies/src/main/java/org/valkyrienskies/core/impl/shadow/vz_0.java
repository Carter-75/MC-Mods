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
 * Renamed from org.valkyrienskies.core.impl.shadow.vz
 */
final class vz_0<T extends kO<T>>
extends wk_0<T> {
    vz_0(kM<T> kM2, boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        super(kM2, bl, TArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }

    private static vz_0<T> b(kM<T> kM2, boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        return new vz_0(kM2, bl, TArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }

    @Override
    public final uJ<T> a(T t, T object, T object2, T object3) {
        kO kO2 = (kO)t.c().b();
        kO kO3 = (kO)kO2.b(object);
        kO2 = (kO)kO2.b(object.a((int)2));
        kO kO4 = kO3.c(kO2);
        kO3 = (kO)object.c((kO)kO3).a(2);
        kO2 = (kO)object.c((kO)kO2).a();
        if (this.a() != null && object.d() <= 0.5) {
            int n2 = object;
            kO kO5 = (kO)((kO)n2.c(n2)).a(4);
            object2 = (kO)object2.d(6.0);
            object3 = (kO)object2.c(((kO)kO5.b(object.a((int)9))).a(6.0));
            kO kO6 = object2.c(((kO)object.a((int)6)).b(kO5));
            object = (kO)object2.c(kO5.b(object.a((int)3)));
            object = this.a(new kO[]{object3, kO6, kO6, object});
            object2 = this.c(new kO[]{kO4, kO3, kO3, kO2});
        } else {
            kO kO7 = (kO)object.a((int)4);
            object2 = (kO)object3.d(6.0);
            object3 = (kO)object2.c(((kO)object.c(((kO)kO7.a()).a(5.0))).b(1.0));
            kO kO8 = (kO)object2.c(((kO)object.c(kO7.b(2.0))).b(2.0));
            object = (kO)object2.c(((kO)object.c(((kO)kO7.a()).b(1.0))).b(1.0));
            object = this.b(new kO[]{object3, kO8, kO8, object});
            object2 = this.c(new kO[]{kO4, kO3, kO3, kO2});
        }
        return new uJ(t, object, (kO[])object2);
    }

    protected final /* synthetic */ wk_0 a(kM kM2, boolean bl, kO[][] kOArray, uJ uJ2, uJ uJ3, uJ uJ4, uJ uJ5, uG uG2) {
        return new vz_0(kM2, bl, kOArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }
}


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
 * Renamed from org.valkyrienskies.core.impl.shadow.wo
 */
final class wo_0<T extends kO<T>>
extends wk_0<T> {
    wo_0(kM<T> kM2, boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        super(kM2, bl, TArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }

    private static wo_0<T> b(kM<T> kM2, boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        return new wo_0(kM2, bl, TArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }

    @Override
    public final uJ<T> a(T t, T object, T object2, T object3) {
        kO kO2 = (kO)object.c(0.75);
        kO kO3 = (kO)((kO)kO2.c(((kO)object.a((int)4)).b(5.0))).a(1.0);
        kO kO4 = (kO)kO2.c(((kO)object.a((int)-6)).a(5.0));
        kO kO5 = (kO)kO2.c(((kO)object.a((int)2)).b(1.0));
        if (this.a() != null && object.d() <= 0.5) {
            object2 = (kO)object2.d(8.0);
            int n2 = object;
            object3 = (kO)((kO)n2.c(n2)).a(4);
            kO kO6 = (kO)object2.c(((kO)((kO)object3.a((int)2)).b(object.a((int)15))).a(8.0));
            kO kO7 = (kO)((kO)object2.c(((kO)object.a((int)5)).b(object3))).a(3);
            kO kO8 = (kO)((kO)object2.c(object)).a(3);
            object = (kO)object2.c(object3.b(object.a((int)3)));
            object = this.a(new kO[]{kO6, kO7, kO8, object});
            object2 = this.c(new kO[]{kO3, kO4, kO2, kO5});
        } else {
            object2 = (kO)object3.d(-8.0);
            int n3 = object;
            object3 = (kO)((kO)n3.c(n3)).a(4);
            kO kO9 = (kO)object.a((double)1.0);
            kO kO10 = (kO)object2.c(((kO)((kO)object3.a(2)).b(object.a((int)7))).a(1.0));
            kO kO11 = (kO)((kO)object2.c(kO9.b(object3))).a(3);
            object = (kO)object2.c(kO9).a(3);
            object2 = (kO)object2.c(kO9.a(object3));
            object = this.b(new kO[]{kO10, kO11, object, object2});
            object2 = this.c(new kO[]{kO3, kO4, kO2, kO5});
        }
        return new uJ(t, (kO[])object, (kO[])object2);
    }

    protected final /* synthetic */ wk_0 a(kM kM2, boolean bl, kO[][] kOArray, uJ uJ2, uJ uJ3, uJ uJ4, uJ uJ5, uG uG2) {
        return new wo_0(kM2, bl, kOArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }
}


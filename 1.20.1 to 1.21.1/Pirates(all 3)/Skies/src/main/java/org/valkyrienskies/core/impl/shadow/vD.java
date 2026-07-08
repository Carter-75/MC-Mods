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
final class vD<T extends kO<T>>
extends wk_0<T> {
    private final T d;
    private final T e;
    private final T f;
    private final T g;
    private final T h;
    private final T i;
    private final T j;
    private final T k;
    private final T l;
    private final T m;
    private final T n;

    vD(kM<T> object, boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        super(object, bl, TArray, uJ2, uJ3, uJ4, uJ5, uG2);
        object = (kO)object.b();
        this.d = (kO)((kO)object.c(35.0)).d(384.0);
        this.e = (kO)((kO)object.c(500.0)).d(1113.0);
        this.f = (kO)((kO)object.c(125.0)).d(192.0);
        this.g = (kO)((kO)object.c(-2187.0)).d(6784.0);
        this.h = (kO)((kO)object.c(11.0)).d(84.0);
        this.i = (kO)((kO)object.c(-1.2715105075E10)).d(1.1282082432E10);
        this.j = (kO)((kO)object.c(8.74874797E10)).d(3.2700410799E10);
        this.k = (kO)((kO)object.c(-1.0690763975E10)).d(1.880347072E9);
        this.l = (kO)((kO)object.c(7.01980252875E11)).d(1.99316789632E11);
        this.m = (kO)((kO)object.c(-1.453857185E9)).d(8.22651844E8);
        this.n = (kO)((kO)object.c(6.9997945E7)).d(2.9380423E7);
    }

    private static vD<T> b(kM<T> kM2, boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        return new vD(kM2, bl, TArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }

    @Override
    public final uJ<T> a(T t, T object, T object2, T object3) {
        kO kO2 = (kO)t.c().b();
        kO kO3 = (kO)kO2.b(object);
        kO kO4 = (kO)object.a((int)2);
        kO2 = kO2.b(kO4);
        int n2 = object;
        kO kO5 = (kO)n2.c(((kO)n2.a((int)-3)).a(2.0));
        kO4 = (kO)kO4.c(((kO)object.c(kO4.b(3.0))).a(1.0));
        if (this.a() != null && object.d() <= 0.5) {
            object3 = object2.c((kO)kO3);
            object = (kO)object3.c(object);
            kO3 = object.c(kO3);
            kO kO6 = (kO)((kO)((kO)((kO)object2.c(this.d)).b(object3.c(this.d.b(1.0)))).a(object.c(((kO)this.d.a((int)2)).b(1.0)))).a(kO3.c(this.i));
            kO kO7 = (kO)t.c().a();
            kO kO8 = (kO)((kO)((kO)((kO)object2.c(this.e)).b(object3.c(this.e))).a(object.c(this.e.a((int)2)))).a(kO3.c(this.j));
            kO kO9 = (kO)((kO)((kO)((kO)object2.c(this.f)).b(object3.c(this.f))).a(object.c(this.f.a((int)2)))).a(kO3.c(this.k));
            kO kO10 = (kO)((kO)((kO)((kO)object2.c(this.g)).b(object3.c(this.g))).a(object.c(this.g.a((int)2)))).a(kO3.c(this.l));
            object2 = (kO)((kO)((kO)((kO)object2.c(this.h)).b(object3.c(this.h))).a(object.c(this.h.a((int)2)))).a(kO3.c(this.m));
            object = (kO)((kO)kO3.c(this.n)).b(object);
            object3 = (kO)((kO)((kO)this.d.b(kO2.c(this.d.b(1.0)))).a(kO5.c(((kO)this.d.a((int)2)).b(1.0)))).a(kO4.c(this.i));
            kO3 = (kO)t.c().a();
            kO kO11 = (kO)((kO)((kO)this.e.b(kO2.c(this.e))).a(kO5.c(this.e.a((int)2)))).a(kO4.c(this.j));
            kO kO12 = (kO)((kO)((kO)this.f.b(kO2.c(this.f))).a(kO5.c(this.f.a((int)2)))).a(kO4.c(this.k));
            kO kO13 = (kO)((kO)((kO)this.g.b(kO2.c(this.g))).a(kO5.c(this.g.a((int)2)))).a(kO4.c(this.l));
            kO2 = (kO)((kO)((kO)this.h.b(kO2.c(this.h))).a(kO5.c(this.h.a((int)2)))).a(kO4.c(this.m));
            kO4 = ((kO)kO4.c(this.n)).b(kO5);
            object = this.a(new kO[]{kO6, kO7, kO8, kO9, kO10, object2, object});
            object2 = this.c(new kO[]{object3, kO3, kO11, kO12, kO13, kO2, kO4});
        } else {
            object2 = (kO)object3.a();
            object3 = (kO)object3.c(object);
            object = (kO)object3.c(object);
            kO3 = object.c(kO3);
            kO kO14 = (kO)((kO)((kO)((kO)object2.c(this.d)).b(object3.c(this.d.b(1.0)))).a(object.c(((kO)this.d.a((int)2)).b(1.0)))).a(kO3.c(this.i));
            kO kO15 = (kO)t.c().a();
            kO kO16 = (kO)((kO)((kO)((kO)object2.c(this.e)).b(object3.c(this.e))).a(object.c(this.e.a((int)2)))).a(kO3.c(this.j));
            kO kO17 = (kO)((kO)((kO)((kO)object2.c(this.f)).b(object3.c(this.f))).a(object.c(this.f.a((int)2)))).a(kO3.c(this.k));
            kO kO18 = (kO)((kO)((kO)((kO)object2.c(this.g)).b(object3.c(this.g))).a(object.c(this.g.a((int)2)))).a(kO3.c(this.l));
            object2 = (kO)((kO)((kO)((kO)object2.c(this.h)).b(object3.c(this.h))).a(object.c(this.h.a((int)2)))).a(kO3.c(this.m));
            object = (kO)((kO)kO3.c(this.n)).b(object);
            object3 = (kO)((kO)((kO)this.d.b(kO2.c(this.d.b(1.0)))).a(kO5.c(((kO)this.d.a((int)2)).b(1.0)))).a(kO4.c(this.i));
            kO3 = (kO)t.c().a();
            kO kO19 = (kO)((kO)((kO)this.e.b(kO2.c(this.e))).a(kO5.c(this.e.a((int)2)))).a(kO4.c(this.j));
            kO kO20 = (kO)((kO)((kO)this.f.b(kO2.c(this.f))).a(kO5.c(this.f.a((int)2)))).a(kO4.c(this.k));
            kO kO21 = (kO)((kO)((kO)this.g.b(kO2.c(this.g))).a(kO5.c(this.g.a((int)2)))).a(kO4.c(this.l));
            kO2 = (kO)((kO)((kO)this.h.b(kO2.c(this.h))).a(kO5.c(this.h.a((int)2)))).a(kO4.c(this.m));
            kO4 = ((kO)kO4.c(this.n)).b(kO5);
            object = this.b(new kO[]{kO14, kO15, kO16, kO17, kO18, object2, object});
            object2 = this.c(new kO[]{object3, kO3, kO19, kO20, kO21, kO2, kO4});
        }
        return new uJ(t, (kO[])object, (kO[])object2);
    }

    protected final /* synthetic */ wk_0 a(kM kM2, boolean bl, kO[][] kOArray, uJ uJ2, uJ uJ3, uJ uJ4, uJ uJ5, uG uG2) {
        return new vD(kM2, bl, kOArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }
}


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
final class vY<T extends kO<T>>
extends wk_0<T> {
    vY(kM<T> kM2, boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        super(kM2, bl, TArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }

    private static vY<T> b(kM<T> kM2, boolean bl, T[][] TArray, uJ<T> uJ2, uJ<T> uJ3, uJ<T> uJ4, uJ<T> uJ5, uG<T> uG2) {
        return new vY(kM2, bl, TArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }

    @Override
    public final uJ<T> a(T t, T object, T object2, T object3) {
        double d2 = object;
        object3 = (kO)((kO)d2.c(((kO)d2.c(((kO)object.c(-10.0)).a(16.0))).a(-7.5))).a(1.0);
        kO kO2 = (kO)t.c().a();
        double d3 = object;
        kO kO3 = (kO)d3.c(((kO)d3.c(((kO)object.c(67.5)).a(-91.125))).a(28.6875));
        double d4 = object;
        kO kO4 = (kO)d4.c(((kO)d4.c(((kO)object.c(-120.0)).a(152.0))).a(-44.0));
        double d5 = object;
        kO kO5 = (kO)d5.c(((kO)d5.c(((kO)object.c(62.5)).a(-78.125))).a(23.4375));
        kO kO6 = (kO)((kO)object.c(0.625)).c(((kO)object.a((int)2)).b(1.0));
        if (this.a() != null && object.d() <= 0.5) {
            double d6 = object;
            kO kO7 = (kO)object2.c(((kO)d6.c(((kO)d6.c(((kO)object.c(-2.5)).a(5.333333333333333))).a(-3.75))).a(1.0));
            kO kO8 = (kO)t.c().a();
            double d7 = object;
            kO kO9 = (kO)object2.c(d7.c(((kO)d7.c(((kO)object.c(16.875)).a(-30.375))).a(14.34375)));
            double d8 = object;
            kO kO10 = (kO)object2.c(d8.c(((kO)d8.c(((kO)object.c(-30.0)).a(50.666666666666664))).a(-22.0)));
            double d9 = object;
            kO kO11 = (kO)object2.c(d9.c(((kO)d9.c(((kO)object.c(15.625)).a(-26.041666666666668))).a(11.71875)));
            double d10 = object;
            object2 = (kO)object2.c(d10.c(((kO)d10.c(0.4166666666666667)).a(-0.3125)));
            object = this.a(new kO[]{kO7, kO8, kO9, kO10, kO11, object2});
            object2 = this.c(new kO[]{object3, kO2, kO3, kO4, kO5, kO6});
        } else {
            double d11 = object;
            kO kO12 = (kO)d11.c(d11);
            kO kO13 = (kO)object2.d(object);
            double d12 = object;
            double d13 = object;
            kO kO14 = (kO)kO13.c(((kO)d12.c(((kO)d12.c(((kO)d13.c(((kO)d13.c(-2.5)).a(5.333333333333333))).a(-3.75))).a(1.0))).a(-0.08333333333333333));
            kO kO15 = (kO)t.c().a();
            double d14 = object;
            kO kO16 = (kO)kO13.c(((kO)kO12.c(((kO)d14.c(((kO)d14.c(16.875)).a(-30.375))).a(14.34375))).a(-0.84375));
            double d15 = object;
            object2 = (kO)kO13.c(((kO)kO12.c(((kO)d15.c(((kO)d15.c(-30.0)).a(50.666666666666664))).a(-22.0))).a(1.3333333333333333));
            double d16 = object;
            kO kO17 = (kO)kO13.c(((kO)kO12.c(((kO)d16.c(((kO)d16.c(15.625)).a(-26.041666666666668))).a(11.71875))).a(-1.3020833333333333));
            object = (kO)kO13.c(((kO)kO12.c(((kO)object.c(0.4166666666666667)).a(-0.3125))).a(-0.10416666666666667));
            object = this.b(new kO[]{kO14, kO15, kO16, object2, kO17, object});
            object2 = this.c(new kO[]{object3, kO2, kO3, kO4, kO5, kO6});
        }
        return new uJ(t, object, (kO[])object2);
    }

    protected final /* synthetic */ wk_0 a(kM kM2, boolean bl, kO[][] kOArray, uJ uJ2, uJ uJ3, uJ uJ4, uJ uJ5, uG uG2) {
        return new vY(kM2, bl, kOArray, uJ2, uJ3, uJ4, uJ5, uG2);
    }
}


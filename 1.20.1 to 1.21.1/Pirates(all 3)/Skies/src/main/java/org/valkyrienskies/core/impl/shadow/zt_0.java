/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.ty_0;
import org.valkyrienskies.core.impl.shadow.zA;
import org.valkyrienskies.core.impl.shadow.zH;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.zt
 */
public final class zt_0
implements zH {
    private final double[] a;
    private final zA b;
    private final double[] c;
    private final tq_0 d;

    private zt_0(double[] object, tq_0 object2, double d2, zA zA2) {
        int n2 = object2.f();
        if (((double[])object).length != n2) {
            throw new oS(((double[])object).length, n2);
        }
        this.a = (double[])object.clone();
        object = new ty_0((tq_0)object2, d2);
        object2 = object;
        this.d = object.a;
        this.b = zA2;
        object2 = object;
        this.c = new double[object.b];
    }

    private zt_0(tq_0 object, double d2, zA zA2) {
        int n2 = object.f();
        this.a = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a[i2] = 0.0;
        }
        ty_0 ty_02 = new ty_0((tq_0)object, d2);
        object = ty_02;
        this.d = ((ty_0)object).a;
        this.b = zA2;
        object = ty_02;
        this.c = new double[((ty_0)object).b];
    }

    private zA b() {
        return this.b;
    }

    private int c() {
        return this.c.length;
    }

    private tq_0 d() {
        return this.d;
    }

    public final double[] a() {
        for (int i2 = 0; i2 < this.c.length; ++i2) {
            this.c[i2] = this.b.a();
        }
        double[] dArray = new double[this.a.length];
        for (int i3 = 0; i3 < dArray.length; ++i3) {
            dArray[i3] = this.a[i3];
            for (int i4 = 0; i4 < this.d.g(); ++i4) {
                int n2 = i3;
                dArray[n2] = dArray[n2] + this.d.b(i3, i4) * this.c[i4];
            }
        }
        return dArray;
    }
}


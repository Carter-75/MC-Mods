/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.oC;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.od_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class oA<T extends oC>
extends od_0 {
    private final double[] b;
    private final List<T> c;

    public oA(List<co_0<Double, T>> list) {
        this((zF)new zR(), list);
    }

    public oA(zF zF2, List<co_0<Double, T>> list) {
        co_0<Double, T> co_02;
        int n2;
        co_0<Double, T> co_03 = list.get(0);
        super(zF2, ((oC)co_03.b).a());
        int n3 = list.size();
        int n4 = this.a();
        double d2 = 0.0;
        for (n2 = 0; n2 < n3; ++n2) {
            co_0<Double, T> co_04;
            co_03 = co_02 = list.get(n2);
            if (((oC)co_02.b).a() != n4) {
                co_03 = co_02;
                throw new oS(((oC)co_03.b).a(), n4);
            }
            co_03 = co_02;
            if ((Double)co_04.a < 0.0) {
                co_03 = co_02;
                throw new pj_0((Number)co_03.a);
            }
            co_03 = co_02;
            d2 += ((Double)co_03.a).doubleValue();
        }
        if (Double.isInfinite(d2)) {
            throw new oU(px_0.OVERFLOW, new Object[0]);
        }
        this.c = new ArrayList<T>();
        this.b = new double[n3];
        for (n2 = 0; n2 < n3; ++n2) {
            co_03 = co_02 = list.get(n2);
            this.b[n2] = (Double)co_03.a / d2;
            co_03 = co_02;
            this.c.add(co_03.b);
        }
    }

    @Override
    public final double a(double[] dArray) {
        double d2 = 0.0;
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            d2 += this.b[i2] * ((oC)this.c.get(i2)).a(dArray);
        }
        return d2;
    }

    @Override
    public final double[] b() {
        double[] dArray = null;
        double d2 = this.a.nextDouble();
        double d3 = 0.0;
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            if (!(d2 <= (d3 += this.b[i2]))) continue;
            dArray = ((oC)this.c.get(i2)).b();
            break;
        }
        if (dArray == null) {
            dArray = ((oC)this.c.get(this.b.length - 1)).b();
        }
        return dArray;
    }

    @Override
    public final void a(long l2) {
        super.a(l2);
        for (int i2 = 0; i2 < this.c.size(); ++i2) {
            ((oC)this.c.get(i2)).a((long)(i2 + 1) + l2);
        }
    }

    public final List<co_0<Double, T>> c() {
        ArrayList<co_0<Double, T>> arrayList = new ArrayList<co_0<Double, T>>(this.b.length);
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            arrayList.add(new co_0<Double, T>(this.b[i2], this.c.get(i2)));
        }
        return arrayList;
    }
}


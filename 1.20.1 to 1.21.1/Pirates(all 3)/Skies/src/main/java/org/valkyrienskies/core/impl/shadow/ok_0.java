/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.ph_0;
import org.valkyrienskies.core.impl.shadow.pi_0;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zR;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.ok
 */
public final class ok_0<T>
implements Serializable {
    private static final long a = 20123308L;
    private zF b;
    private final List<T> c;
    private final double[] d;
    private final double[] e;

    private ok_0(List<co_0<T, Double>> list) {
        this(new zR(), list);
    }

    public ok_0(zF object, List<co_0<T, Double>> list) {
        this.b = object;
        this.c = new ArrayList<T>(list.size());
        object = new double[list.size()];
        for (int i2 = 0; i2 < list.size(); ++i2) {
            double d2;
            co_0<T, Double> co_02;
            co_0<T, Double> co_03 = co_02 = list.get(i2);
            this.c.add(co_03.a);
            double d3 = co_02.c();
            if (d2 < 0.0) {
                throw new pj_0(co_02.c());
            }
            if (Double.isInfinite(d3)) {
                throw new pi_0(d3, new Object[0]);
            }
            if (Double.isNaN(d3)) {
                throw new ph_0();
            }
            object[i2] = d3;
        }
        this.d = ch_0.a((double[])object, 1.0);
        this.e = new double[this.d.length];
        double d4 = 0.0;
        for (int i3 = 0; i3 < this.d.length; ++i3) {
            this.e[i3] = d4 += this.d[i3];
        }
    }

    private void a(long l2) {
        this.b.setSeed(l2);
    }

    final double a(T t) {
        double d2 = 0.0;
        for (int i2 = 0; i2 < this.d.length; ++i2) {
            if ((t != null || this.c.get(i2) != null) && (t == null || !t.equals(this.c.get(i2)))) continue;
            d2 += this.d[i2];
        }
        return d2;
    }

    public final List<co_0<T, Double>> a() {
        ArrayList<co_0<T, Double>> arrayList = new ArrayList<co_0<T, Double>>(this.d.length);
        for (int i2 = 0; i2 < this.d.length; ++i2) {
            arrayList.add(new co_0<T, Double>(this.c.get(i2), this.d[i2]));
        }
        return arrayList;
    }

    public final T b() {
        double d2 = this.b.nextDouble();
        int n2 = Arrays.binarySearch(this.e, d2);
        if (n2 < 0) {
            n2 = -n2 - 1;
        }
        if (n2 >= 0 && n2 < this.d.length && d2 < this.e[n2]) {
            return this.c.get(n2);
        }
        return this.c.get(this.c.size() - 1);
    }

    private Object[] a(int n2) {
        if (n2 <= 0) {
            throw new pk_0(px_0.NUMBER_OF_SAMPLES, n2);
        }
        Object[] objectArray = new Object[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            objectArray[i2] = this.b();
        }
        return objectArray;
    }

    private T[] a(int n2, T[] objectArray) {
        if (n2 <= 0) {
            throw new pk_0(px_0.NUMBER_OF_SAMPLES, n2);
        }
        if (objectArray == null) {
            throw new pl_0(px_0.INPUT_ARRAY, new Object[0]);
        }
        if (objectArray.length < n2) {
            Object[] objectArray2 = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n2);
            objectArray = objectArray2;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            objectArray[i2] = this.b();
        }
        return objectArray;
    }
}


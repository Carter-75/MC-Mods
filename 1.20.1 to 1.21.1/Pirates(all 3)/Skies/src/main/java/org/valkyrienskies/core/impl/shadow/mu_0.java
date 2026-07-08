/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import java.util.TreeMap;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.mu
 */
public abstract class mu_0<T extends Number> {
    private final Map<Integer, co_0<T[], T[]>> a = new TreeMap<Integer, co_0<T[], T[]>>();
    private final Map<Integer, co_0<double[], double[]>> b = new TreeMap<Integer, co_0<double[], double[]>>();

    public final co_0<double[], double[]> a(int n2) {
        if (n2 <= 0) {
            throw new pk_0(px_0.NUMBER_OF_POINTS, n2);
        }
        Object object = this.b.get(n2);
        if (object == null) {
            co_0<T[], T[]> co_02 = this.b(n2);
            object = co_02;
            object = co_02;
            co_0<Object[], Object[]> co_03 = co_02;
            Number[] numberArray = (Number[])co_02.a;
            co_03 = object;
            object = (Number[])co_03.b;
            int n3 = numberArray.length;
            double[] dArray = new double[n3];
            double[] dArray2 = new double[n3];
            for (int i2 = 0; i2 < n3; ++i2) {
                dArray[i2] = numberArray[i2].doubleValue();
                dArray2[i2] = object[i2].doubleValue();
            }
            object = new co_0<double[], double[]>(dArray, dArray2);
            this.b.put(n2, (co_0<double[], double[]>)object);
        }
        co_0<double[], double[]> co_04 = object;
        co_0<double[], double[]> co_05 = co_04;
        co_05 = object;
        return new co_0<Object, Object>(((double[])co_04.a).clone(), ((double[])co_05.b).clone());
    }

    protected final synchronized co_0<T[], T[]> b(int n2) {
        co_0<T[], T[]> co_02 = this.a.get(n2);
        if (co_02 == null) {
            mu_0 mu_02 = this;
            co_0<T[], T[]> co_03 = mu_02.c(n2);
            co_02 = mu_02;
            co_0<T[], T[]> co_04 = co_03;
            co_0<T[], T[]> co_05 = co_04;
            co_05 = co_03;
            if (((Number[])co_04.a).length != ((Number[])co_05.b).length) {
                co_0<T[], T[]> co_06 = co_03;
                co_05 = co_06;
                co_05 = co_03;
                throw new oS(((Number[])co_06.a).length, ((Number[])co_05.b).length);
            }
            co_05 = co_03;
            ((mu_0)((Object)co_02)).a.put(((Number[])co_05.a).length, co_03);
            return this.b(n2);
        }
        return co_02;
    }

    private void a(co_0<T[], T[]> co_02) {
        co_0<T[], T[]> co_03 = co_02;
        co_0<T[], T[]> co_04 = co_03;
        co_04 = co_02;
        if (((Number[])co_03.a).length != ((Number[])co_04.b).length) {
            co_0<T[], T[]> co_05 = co_02;
            co_04 = co_05;
            co_04 = co_02;
            throw new oS(((Number[])co_05.a).length, ((Number[])co_04.b).length);
        }
        co_04 = co_02;
        this.a.put(((Number[])co_04.a).length, co_02);
    }

    protected abstract co_0<T[], T[]> c(int var1);

    private static <T extends Number> co_0<double[], double[]> b(co_0<T[], T[]> numberArray) {
        Number[] numberArray2 = numberArray;
        Number[] numberArray3 = (Number[])numberArray.a;
        numberArray2 = numberArray;
        numberArray = (Number[])numberArray.b;
        int n2 = numberArray3.length;
        double[] dArray = new double[n2];
        double[] dArray2 = new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            dArray[i2] = numberArray3[i2].doubleValue();
            dArray2[i2] = numberArray[i2].doubleValue();
        }
        return new co_0<double[], double[]>(dArray, dArray2);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import org.valkyrienskies.core.impl.shadow.tJ;
import org.valkyrienskies.core.impl.shadow.tK;
import org.valkyrienskies.core.impl.shadow.tL;
import org.valkyrienskies.core.impl.shadow.tO;
import org.valkyrienskies.core.impl.shadow.tW;
import org.valkyrienskies.core.impl.shadow.tY;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class tS<T extends tL> {
    private final tW a;

    public tS() {
        this(new tY());
    }

    public tS(tW tW2) {
        this.a = tW2;
    }

    public abstract double a(List<? extends tK<T>> var1);

    public static boolean a(double d2, double d3) {
        return d2 < d3;
    }

    protected final double a(tL tL2, tL tL3) {
        return this.a.a(tL2.a(), tL3.a());
    }

    protected static tL a(tK<T> tK2) {
        List list = tK2;
        list = ((tK)((Object)list)).b;
        if (list.isEmpty()) {
            return null;
        }
        if (tK2 instanceof tJ) {
            list = (tJ)tK2;
            return ((tJ)((Object)list)).a;
        }
        int n2 = ((tL)list.get(0)).a().length;
        double[] dArray = new double[n2];
        for (Object object : list) {
            object = object.a();
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                int n3 = i2;
                dArray[n3] = dArray[n3] + object[i2];
            }
        }
        int n4 = 0;
        while (n4 < dArray.length) {
            int n5 = n4++;
            dArray[n5] = dArray[n5] / (double)list.size();
        }
        return new tO(dArray);
    }
}


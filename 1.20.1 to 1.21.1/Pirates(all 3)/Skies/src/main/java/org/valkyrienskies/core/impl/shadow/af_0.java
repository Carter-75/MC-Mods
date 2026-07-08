/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ac_0;
import org.valkyrienskies.core.impl.shadow.ch_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Af
 */
@Deprecated
public final class af_0
implements Serializable,
ac_0<af_0> {
    private static final long a = 3946024775784901369L;
    private final int[] b;

    private af_0(int[] nArray) {
        this.b = nArray;
    }

    private int[] a() {
        return this.b;
    }

    @Override
    private double a(af_0 object) {
        Object object2 = object;
        int[] nArray = ((af_0)object2).b;
        object = this.b;
        int[] nArray2 = nArray;
        object2 = this.b;
        ch_0.a(this.b, nArray2, true);
        double d2 = 0.0;
        for (int i2 = 0; i2 < ((Object)object).length; ++i2) {
            double d3;
            double d4 = d3 = (double)(object[i2] - nArray[i2]);
            d2 += d4 * d4;
        }
        return BY.a(d2);
    }

    private af_0 b(Collection<af_0> collection) {
        af_0 af_02 = this;
        int[] nArray = new int[af_02.b.length];
        for (af_0 af_03 : collection) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                int n2 = i2;
                af_02 = af_03;
                nArray[n2] = nArray[n2] + af_02.b[i2];
            }
        }
        int n3 = 0;
        while (n3 < nArray.length) {
            int n4 = n3++;
            nArray[n4] = nArray[n4] / collection.size();
        }
        return new af_0(nArray);
    }

    /*
     * WARNING - void declaration
     */
    public final boolean equals(Object other) {
        void var1_1;
        if (!(other instanceof af_0)) {
            return false;
        }
        return Arrays.equals(this.b, ((af_0)var1_1).b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b);
    }

    public final String toString() {
        return Arrays.toString(this.b);
    }

    @Override
    public final /* synthetic */ Object a(Collection object) {
        Collection collection = object;
        object = this;
        af_0 af_02 = object;
        object = new int[((af_0)object).b.length];
        for (af_0 af_03 : collection) {
            for (int i2 = 0; i2 < ((Object)object).length; ++i2) {
                Object object2 = object;
                int n2 = i2;
                af_02 = af_03;
                object2[n2] = object2[n2] + af_02.b[i2];
            }
        }
        int n3 = 0;
        while (n3 < ((Object)object).length) {
            Object object3 = object;
            int n4 = n3++;
            object3[n4] = object3[n4] / collection.size();
        }
        return new af_0((int[])object);
    }
}


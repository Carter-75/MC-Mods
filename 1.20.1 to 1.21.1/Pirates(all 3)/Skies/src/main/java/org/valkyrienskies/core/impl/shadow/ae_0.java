/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.ac_0;
import org.valkyrienskies.core.impl.shadow.ch_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Ae
 */
@Deprecated
public final class ae_0
implements Serializable,
ac_0<ae_0> {
    private static final long a = 8026472786091227632L;
    private final double[] b;

    private ae_0(double[] dArray) {
        this.b = dArray;
    }

    private ae_0 b(Collection<ae_0> collection) {
        ae_0 ae_02 = this;
        double[] dArray = new double[ae_02.b.length];
        for (ae_0 ae_03 : collection) {
            for (int i2 = 0; i2 < dArray.length; ++i2) {
                int n2 = i2;
                ae_02 = ae_03;
                dArray[n2] = dArray[n2] + ae_02.b[i2];
            }
        }
        int n3 = 0;
        while (n3 < dArray.length) {
            int n4 = n3++;
            dArray[n4] = dArray[n4] / (double)collection.size();
        }
        return new ae_0(dArray);
    }

    @Override
    private double a(ae_0 ae_02) {
        return ch_0.d(this.b, ae_02.b);
    }

    /*
     * WARNING - void declaration
     */
    public final boolean equals(Object other) {
        void var1_1;
        if (!(other instanceof ae_0)) {
            return false;
        }
        return Arrays.equals(this.b, ((ae_0)var1_1).b);
    }

    private double[] a() {
        return this.b;
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
        ae_0 ae_02 = object;
        object = new double[((ae_0)object).b.length];
        for (ae_0 ae_03 : collection) {
            for (int i2 = 0; i2 < ((Object)object).length; ++i2) {
                Object object2 = object;
                int n2 = i2;
                ae_02 = ae_03;
                object2[n2] = object2[n2] + ae_02.b[i2];
            }
        }
        int n3 = 0;
        while (n3 < ((Object)object).length) {
            Object object3 = object;
            int n4 = n3++;
            object3[n4] = object3[n4] / (double)collection.size();
        }
        return new ae_0((double[])object);
    }

    @Override
    public final /* synthetic */ double a(Object object) {
        ae_0 ae_02 = this;
        ae_0 ae_03 = (ae_0)object;
        object = ae_02;
        object = ae_03;
        return ch_0.d(ae_02.b, ((ae_0)object).b);
    }
}


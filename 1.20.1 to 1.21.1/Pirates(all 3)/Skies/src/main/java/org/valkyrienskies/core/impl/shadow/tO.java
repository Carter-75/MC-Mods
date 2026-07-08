/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.tL;

public final class tO
implements Serializable,
tL {
    private static final long a = 3946024775784901369L;
    private final double[] b;

    public tO(double[] dArray) {
        this.b = dArray;
    }

    private tO(int[] nArray) {
        this.b = new double[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.b[i2] = nArray[i2];
        }
    }

    public final double[] a() {
        return this.b;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean equals(Object other) {
        void var1_1;
        if (!(other instanceof tO)) {
            return false;
        }
        return Arrays.equals(this.b, ((tO)var1_1).b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b);
    }

    public final String toString() {
        return Arrays.toString(this.b);
    }
}


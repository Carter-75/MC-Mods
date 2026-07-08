/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.AG;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.oS;

public final class AO
implements Serializable {
    private static final long a = 8223009086481006892L;
    private final AG[] b;

    private AO(int n2) {
        this.b = new AG[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            this.b[i2] = new AG();
        }
    }

    private void a(double[] dArray) {
        if (dArray.length != this.b.length) {
            throw new oS(dArray.length, this.b.length);
        }
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            ((an_0)this.b[i2]).a(dArray[i2]);
        }
    }

    private double[] a() {
        double[] dArray = new double[this.b.length];
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            dArray[i2] = ((an_0)this.b[i2]).c();
        }
        return dArray;
    }

    private long b() {
        if (this.b.length == 0) {
            return 0L;
        }
        return this.b[0].g_();
    }

    public final int hashCode() {
        int n2 = 31 + Arrays.hashCode(this.b);
        return n2;
    }

    public final boolean equals(Object obj) {
        AO aO;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AO)) {
            return false;
        }
        aO = aO;
        return Arrays.equals(this.b, aO.b);
    }
}


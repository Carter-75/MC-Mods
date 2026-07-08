/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.uM;
import org.valkyrienskies.core.impl.shadow.uR;
import org.valkyrienskies.core.impl.shadow.uV;
import org.valkyrienskies.core.impl.shadow.uW;
import org.valkyrienskies.core.impl.shadow.uZ;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
final class uX
implements uW {
    private final uM a;
    private final uZ b;
    private final Map<String, Double> c;

    uX(uR uVArray, uZ uZ2, uV[] uVArray2) {
        this.a = uVArray;
        this.b = uZ2;
        this.c = new HashMap<String, Double>();
        uVArray = uVArray2;
        int n2 = uVArray2.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            uV uV2 = uVArray[i2];
            Object object = uV2;
            object = uV2.a;
            if (!uZ2.a((String)object)) continue;
            this.c.put((String)object, uV2.b);
        }
    }

    @Override
    public final Collection<String> a() {
        return this.b.a();
    }

    @Override
    public final boolean a(String string) {
        return this.b.a(string);
    }

    @Override
    public final void a(double d2, double[] dArray, double[] dArray2, String string, double[] dArray3) {
        int n2 = this.a.a();
        if (this.b.a(string)) {
            double[] dArray4 = new double[n2];
            this.b.b(string);
            double d3 = this.c.get(string);
            this.a.a(d2, dArray, dArray4);
            for (int i2 = 0; i2 < n2; ++i2) {
                dArray3[i2] = (dArray4[i2] - dArray2[i2]) / d3;
            }
            return;
        }
        Arrays.fill(dArray3, 0, n2, 0.0);
    }
}


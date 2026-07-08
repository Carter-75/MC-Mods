/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.cp_0;

public final class BP
implements Serializable,
cp_0 {
    private static final long a = 20140713L;

    public final int a(double[] dArray, int n2, int n3) {
        int n4 = n3 - n2;
        int n5 = n2;
        ch_0.a(dArray, n5, n4, false);
        return n2 + (n3 - n2) / 2;
    }
}


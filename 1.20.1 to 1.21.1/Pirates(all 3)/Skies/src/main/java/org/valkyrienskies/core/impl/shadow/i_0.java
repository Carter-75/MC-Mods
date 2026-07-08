/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.time.DateTimeException;
import org.valkyrienskies.core.impl.shadow.n_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.i
 */
public abstract class i_0
implements n_0 {
    private static int a = 9;

    protected static void a(int n2) {
        if (n2 > 9) {
            throw new DateTimeException("Maximum supported number of fraction digits in second is 9, got " + n2);
        }
    }
}


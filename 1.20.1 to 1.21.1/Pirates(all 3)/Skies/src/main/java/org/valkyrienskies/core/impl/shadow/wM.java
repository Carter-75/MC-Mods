/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.wO;

public final class wM
implements wO {
    final int a;

    public wM(int n2) {
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.a = n2;
    }

    public final int a() {
        return this.a;
    }

    private static wM b() {
        return new wM(Integer.MAX_VALUE);
    }
}


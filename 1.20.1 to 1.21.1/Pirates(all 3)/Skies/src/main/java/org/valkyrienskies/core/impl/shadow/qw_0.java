/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.qJ;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.qw
 */
public final class qw_0
implements qJ {
    private int a = 0;
    private final int b;

    private qw_0(int n2) {
        if (n2 <= 0) {
            throw new pn_0(n2, (Number)1, true);
        }
        this.b = n2;
    }

    public final boolean a() {
        if (this.a < this.b) {
            ++this.a;
            return false;
        }
        return true;
    }

    private int b() {
        return this.a;
    }
}


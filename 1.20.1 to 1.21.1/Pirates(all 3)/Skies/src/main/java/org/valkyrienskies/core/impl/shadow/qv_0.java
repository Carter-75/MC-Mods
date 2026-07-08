/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.concurrent.TimeUnit;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.qJ;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.qv
 */
public final class qv_0
implements qJ {
    private final long a;
    private long b = -1L;

    private qv_0(long l2) {
        this(l2, TimeUnit.SECONDS);
    }

    private qv_0(long l2, TimeUnit timeUnit) {
        if (l2 < 0L) {
            throw new pn_0(l2, (Number)0, true);
        }
        this.a = timeUnit.toNanos(l2);
    }

    public final boolean a() {
        if (this.b < 0L) {
            this.b = System.nanoTime() + this.a;
        }
        return System.nanoTime() >= this.b;
    }
}


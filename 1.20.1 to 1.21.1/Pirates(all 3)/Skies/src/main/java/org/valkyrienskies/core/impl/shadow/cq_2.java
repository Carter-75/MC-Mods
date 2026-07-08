/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collections;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.dg_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cq
 */
public class cq_2
extends RuntimeException {
    private static final long a = -7805792737596582110L;
    private dg_2 b;

    public cq_2(dg_2 dg_22) {
        super(dg_22.f());
        this.b = dg_22;
    }

    public cq_2(String string) {
        super(string);
    }

    public cq_2(Throwable throwable) {
        super(throwable);
    }

    public Set<dg_2> a() {
        if (this.b == null) {
            return Collections.emptySet();
        }
        return Collections.singleton(this.b);
    }
}


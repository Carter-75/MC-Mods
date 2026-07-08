/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cd_0;
import org.valkyrienskies.core.impl.shadow.pb_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

public abstract class sZ
extends cd_0 {
    private static final long a = 20120129L;

    public sZ(Object object, int n2) {
        super(object, n2);
    }

    public abstract tu_0 c();

    public abstract double a();

    public tu_0 b() {
        throw new pb_0();
    }

    public abstract tu_0 d();

    public boolean e() {
        return false;
    }
}


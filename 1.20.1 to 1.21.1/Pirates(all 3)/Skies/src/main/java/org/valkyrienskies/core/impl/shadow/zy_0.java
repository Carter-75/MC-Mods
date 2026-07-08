/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Random;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zG;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.zy
 */
public final class zy_0
extends Random
implements zF {
    private static final long a = -7745277476784028798L;

    public zy_0() {
    }

    public zy_0(int n2) {
        int n3 = 100;
        zy_0 zy_02 = this;
        zy_02.setSeed(n3);
    }

    public final void a(int n2) {
        this.setSeed(n2);
    }

    public final void a(int[] nArray) {
        this.setSeed(zG.a(nArray));
    }
}


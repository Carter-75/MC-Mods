/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.gt_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gs
 */
public final class gs_0<S>
implements gt_0<S> {
    private final S b;

    public gs_0(S s) {
        this.b = s;
    }

    @Override
    public final boolean a(S s) {
        return Intrinsics.areEqual(this.b, s);
    }

    public final String toString() {
        return String.valueOf(this.b);
    }
}


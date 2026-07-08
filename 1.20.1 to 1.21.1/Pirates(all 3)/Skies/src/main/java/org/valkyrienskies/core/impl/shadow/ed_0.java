/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.world.connectivity.DoubleAugmentation;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ed
 */
public final class ed_0
implements DoubleAugmentation {
    private final String a;

    public ed_0(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        this.a = string;
    }

    @Override
    public final String getKey() {
        return this.a;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final double combineDouble(double a2, double b2) {
        void var3_2;
        return a2 + var3_2;
    }
}


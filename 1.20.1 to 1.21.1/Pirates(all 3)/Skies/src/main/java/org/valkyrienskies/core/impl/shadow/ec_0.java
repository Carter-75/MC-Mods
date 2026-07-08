/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.util.DoublePair;
import org.valkyrienskies.core.api.world.connectivity.Component;
import org.valkyrienskies.core.api.world.connectivity.DoubleComponentAugmentation;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ec
 */
public final class ec_0
implements DoubleComponentAugmentation {
    private final String a;

    private ec_0(String string) {
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
        return Math.max(a2, (double)var3_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final DoublePair splitDouble(double value, Component component1, Component component2) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)component1, (String)"");
        Intrinsics.checkNotNullParameter((Object)component2, (String)"");
        void v0 = var1_1;
        return new DoublePair((double)v0, (double)v0);
    }
}


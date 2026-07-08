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
 * Renamed from org.valkyrienskies.core.impl.shadow.Ee
 */
public final class ee_0
implements DoubleComponentAugmentation {
    private final String a;

    public ee_0(String string) {
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

    /*
     * WARNING - void declaration
     */
    @Override
    public final DoublePair splitDouble(double value, Component component1, Component component2) {
        void var1_1;
        void var3_2;
        Intrinsics.checkNotNullParameter((Object)component1, (String)"");
        Intrinsics.checkNotNullParameter((Object)component2, (String)"");
        long l2 = var3_2.getSize();
        long l3 = component2.getSize();
        long l4 = l2 + l3;
        if (l4 == 0L) {
            return new DoublePair(0.0, 0.0);
        }
        return new DoublePair(value * ((double)l2 / (double)l4), (double)(var1_1 * ((double)l3 / (double)l4)));
    }
}


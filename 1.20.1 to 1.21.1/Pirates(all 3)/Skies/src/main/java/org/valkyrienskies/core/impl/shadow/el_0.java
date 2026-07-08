/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.ships.properties.PhysPose;
import org.valkyrienskies.core.impl.game.ships.PhysPoseImpl;
import org.valkyrienskies.core.impl.shadow.hb_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.El
 */
public final class el_0 {
    public static final hb_0 a(PhysPose physPose) {
        Intrinsics.checkNotNullParameter((Object)physPose, (String)"");
        return new hb_0(physPose.getPos(), physPose.getRot());
    }

    public static final PhysPoseImpl a(hb_0 hb_02) {
        Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
        hb_0 hb_03 = hb_02;
        hb_0 hb_04 = hb_03;
        hb_04 = hb_02;
        return new PhysPoseImpl(hb_03.a, hb_04.b);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.impl.shadow.CU;
import org.valkyrienskies.core.internal.world.VsiPlayer;

public final class CV {
    public static final CU a(long l2, String string, Iterable<? extends VsiPlayer> iterable, double d2, ServerShip serverShip) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Intrinsics.checkNotNullParameter(iterable, (String)"");
        Intrinsics.checkNotNullParameter((Object)serverShip, (String)"");
        return new CU(l2, string, iterable, d2, serverShip);
    }
}


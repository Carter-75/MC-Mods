/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.impl.shadow.CS;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkUnwatchTask;

public final class CT {
    public static final VsiChunkUnwatchTask a(long l2, String string, Iterable<? extends VsiPlayer> iterable, boolean bl, double d2, ServerShip serverShip) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Intrinsics.checkNotNullParameter(iterable, (String)"");
        Intrinsics.checkNotNullParameter((Object)serverShip, (String)"");
        return new CS(l2, string, iterable, bl, d2, serverShip);
    }
}


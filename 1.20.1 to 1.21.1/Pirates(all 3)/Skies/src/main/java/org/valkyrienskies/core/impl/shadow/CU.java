/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTask;

public final class CU
implements Comparable<VsiChunkWatchTask>,
VsiChunkWatchTask {
    private final long a;
    private final String b;
    private final Iterable<VsiPlayer> c;
    private final double d;
    private final ServerShip e;

    public CU(long l2, String string, Iterable<? extends VsiPlayer> iterable, double d2, ServerShip serverShip) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Intrinsics.checkNotNullParameter(iterable, (String)"");
        Intrinsics.checkNotNullParameter((Object)serverShip, (String)"");
        this.a = l2;
        this.b = string;
        this.c = iterable;
        this.d = d2;
        this.e = serverShip;
    }

    @Override
    public final long getChunkPos() {
        return this.a;
    }

    @Override
    public final String getDimensionId() {
        return this.b;
    }

    @Override
    public final Iterable<VsiPlayer> getPlayersNeedWatching() {
        return this.c;
    }

    @Override
    public final ServerShip getShip() {
        return this.e;
    }

    @Override
    public final int getChunkX() {
        return IShipActiveChunksSet.Companion.longToChunkX(this.getChunkPos());
    }

    @Override
    public final int getChunkZ() {
        return IShipActiveChunksSet.Companion.longToChunkZ(this.getChunkPos());
    }

    private int a(VsiChunkWatchTask vsiChunkWatchTask) {
        Intrinsics.checkNotNullParameter((Object)vsiChunkWatchTask, (String)"");
        CU cfr_ignored_0 = (CU)vsiChunkWatchTask;
        int n2 = Double.compare(this.d, ((CU)vsiChunkWatchTask).d);
        if (n2 == 0) {
            n2 = Intrinsics.compare((long)this.getChunkPos(), (long)vsiChunkWatchTask.getChunkPos());
        }
        return n2;
    }

    @Override
    public final /* synthetic */ int compareTo(Object other) {
        CU cU;
        VsiChunkWatchTask vsiChunkWatchTask = cU;
        cU = this;
        Intrinsics.checkNotNullParameter((Object)vsiChunkWatchTask, (String)"");
        CU cfr_ignored_0 = (CU)vsiChunkWatchTask;
        int n2 = Double.compare(cU.d, ((CU)vsiChunkWatchTask).d);
        if (n2 == 0) {
            n2 = Intrinsics.compare((long)cU.getChunkPos(), (long)vsiChunkWatchTask.getChunkPos());
        }
        return n2;
    }
}


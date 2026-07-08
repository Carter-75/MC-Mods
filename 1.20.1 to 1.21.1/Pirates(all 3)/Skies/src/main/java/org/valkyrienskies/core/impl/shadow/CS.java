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
import org.valkyrienskies.core.internal.world.chunks.VsiChunkUnwatchTask;

public final class CS
implements Comparable<VsiChunkUnwatchTask>,
VsiChunkUnwatchTask {
    private final long a;
    private final String b;
    private final Iterable<VsiPlayer> c;
    private final boolean d;
    private final double e;
    private final ServerShip f;

    public CS(long l2, String string, Iterable<? extends VsiPlayer> iterable, boolean bl, double d2, ServerShip serverShip) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Intrinsics.checkNotNullParameter(iterable, (String)"");
        Intrinsics.checkNotNullParameter((Object)serverShip, (String)"");
        this.a = l2;
        this.b = string;
        this.c = iterable;
        this.d = bl;
        this.e = d2;
        this.f = serverShip;
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
    public final Iterable<VsiPlayer> getPlayersNeedUnwatching() {
        return this.c;
    }

    @Override
    public final boolean getShouldUnload() {
        return this.d;
    }

    @Override
    public final ServerShip getShip() {
        return this.f;
    }

    @Override
    public final int getChunkX() {
        return IShipActiveChunksSet.Companion.longToChunkX(this.getChunkPos());
    }

    @Override
    public final int getChunkZ() {
        return IShipActiveChunksSet.Companion.longToChunkZ(this.getChunkPos());
    }

    private int a(VsiChunkUnwatchTask vsiChunkUnwatchTask) {
        Intrinsics.checkNotNullParameter((Object)vsiChunkUnwatchTask, (String)"");
        CS cfr_ignored_0 = (CS)vsiChunkUnwatchTask;
        int n2 = Double.compare(this.e, ((CS)vsiChunkUnwatchTask).e);
        if (n2 == 0) {
            n2 = Intrinsics.compare((long)this.getChunkPos(), (long)vsiChunkUnwatchTask.getChunkPos());
        }
        return n2;
    }

    @Override
    public final /* synthetic */ int compareTo(Object other) {
        CS cS;
        VsiChunkUnwatchTask vsiChunkUnwatchTask = cS;
        cS = this;
        Intrinsics.checkNotNullParameter((Object)vsiChunkUnwatchTask, (String)"");
        CS cfr_ignored_0 = (CS)vsiChunkUnwatchTask;
        int n2 = Double.compare(cS.e, ((CS)vsiChunkUnwatchTask).e);
        if (n2 == 0) {
            n2 = Intrinsics.compare((long)cS.getChunkPos(), (long)vsiChunkUnwatchTask.getChunkPos());
        }
        return n2;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.world.chunks;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.internal.world.VsiPlayer;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0018\u0010\u0010\u001a\u00060\fj\u0002`\r8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001a\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/world/chunks/VsiChunkWatchTask;", "", "", "getChunkPos", "()J", "chunkPos", "", "getChunkX", "()I", "chunkX", "getChunkZ", "chunkZ", "", "Lorg/valkyrienskies/core/internal/world/properties/DimensionId;", "getDimensionId", "()Ljava/lang/String;", "dimensionId", "", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "getPlayersNeedWatching", "()Ljava/lang/Iterable;", "playersNeedWatching", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "getShip", "()Lorg/valkyrienskies/core/api/ships/ServerShip;", "ship", "internal"})
public interface VsiChunkWatchTask
extends Comparable<VsiChunkWatchTask> {
    public long getChunkPos();

    @NotNull
    public String getDimensionId();

    @NotNull
    public Iterable<VsiPlayer> getPlayersNeedWatching();

    @NotNull
    public ServerShip getShip();

    public int getChunkX();

    public int getChunkZ();
}


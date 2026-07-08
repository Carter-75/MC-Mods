/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.world;

import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.valkyrienskies.core.internal.world.VsiPlayerState;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0011\u001a\u00060\rj\u0002`\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0013j\u0002`\u00140\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u000bR\u0014\u0010\u001c\u001a\u00020\u00198&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001d\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "", "Lorg/valkyrienskies/core/internal/world/VsiPlayerState;", "getPlayerState", "()Lorg/valkyrienskies/core/internal/world/VsiPlayerState;", "Lorg/joml/Vector3d;", "dest", "getPosition", "(Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "", "getCanModifyServerConfig", "()Z", "canModifyServerConfig", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "getDimension", "()Ljava/lang/String;", "dimension", "", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "getForceWatchingShips", "()Ljava/util/Set;", "forceWatchingShips", "isAdmin", "Ljava/util/UUID;", "getUuid", "()Ljava/util/UUID;", "uuid", "internal"})
public interface VsiPlayer {
    @NotNull
    public Vector3d getPosition(@NotNull Vector3d var1);

    @NotNull
    public VsiPlayerState getPlayerState();

    @NotNull
    public String getDimension();

    @NotNull
    public UUID getUuid();

    public boolean isAdmin();

    default public boolean getCanModifyServerConfig() {
        return this.isAdmin();
    }

    @NotNull
    public Set<Long> getForceWatchingShips();
}


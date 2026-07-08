/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.world.ServerShipWorld;
import org.valkyrienskies.core.internal.ShipTeleportData;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&\u00a2\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH&\u00a2\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH&\u00a2\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H&\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0017\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/VsiCoreCommands;", "", "Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "world", "", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "ships", "", "deleteShips", "(Lorg/valkyrienskies/core/api/world/ServerShipWorld;Ljava/util/List;)V", "ship", "", "newName", "renameShip", "(Lorg/valkyrienskies/core/api/ships/ServerShip;Ljava/lang/String;)V", "", "newScale", "scaleShip", "(Lorg/valkyrienskies/core/api/world/ServerShipWorld;Lorg/valkyrienskies/core/api/ships/ServerShip;D)V", "Lorg/valkyrienskies/core/internal/ShipTeleportData;", "teleportData", "teleportShip", "(Lorg/valkyrienskies/core/api/world/ServerShipWorld;Lorg/valkyrienskies/core/api/ships/ServerShip;Lorg/valkyrienskies/core/internal/ShipTeleportData;)V", "internal"})
public interface VsiCoreCommands {
    public void deleteShips(@NotNull ServerShipWorld var1, @NotNull List<? extends ServerShip> var2);

    public void renameShip(@NotNull ServerShip var1, @NotNull String var2);

    public void scaleShip(@NotNull ServerShipWorld var1, @NotNull ServerShip var2, double var3);

    public void teleportShip(@NotNull ServerShipWorld var1, @NotNull ServerShip var2, @NotNull ShipTeleportData var3);
}


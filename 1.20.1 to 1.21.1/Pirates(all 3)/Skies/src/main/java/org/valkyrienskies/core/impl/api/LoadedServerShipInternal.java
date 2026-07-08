/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 */
package org.valkyrienskies.core.impl.api;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.valkyrienskies.core.impl.api.LoadedShipInternal;
import org.valkyrienskies.core.impl.api.ServerShipInternal;
import org.valkyrienskies.core.internal.ShipTeleportData;
import org.valkyrienskies.core.internal.ships.VsiLoadedServerShip;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/api/LoadedServerShipInternal;", "Lorg/valkyrienskies/core/internal/ships/VsiLoadedServerShip;", "Lorg/valkyrienskies/core/impl/api/LoadedShipInternal;", "Lorg/valkyrienskies/core/impl/api/ServerShipInternal;", "Lorg/valkyrienskies/core/internal/ShipTeleportData;", "teleportData", "", "teleportShip", "(Lorg/valkyrienskies/core/internal/ShipTeleportData;)V", "", "getShipTeleportId", "()I", "shipTeleportId"})
public interface LoadedServerShipInternal
extends LoadedShipInternal,
ServerShipInternal,
VsiLoadedServerShip {
    @JvmName(name="getShipTeleportId")
    public int getShipTeleportId();

    public void teleportShip(ShipTeleportData var1);
}


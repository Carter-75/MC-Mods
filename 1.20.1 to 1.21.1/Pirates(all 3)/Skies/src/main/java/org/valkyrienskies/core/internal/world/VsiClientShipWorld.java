/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.world;

import java.net.SocketAddress;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.api.util.GameTickOnly;
import org.valkyrienskies.core.api.world.ClientShipWorld;
import org.valkyrienskies.core.internal.ships.VsiQueryableShipData;
import org.valkyrienskies.core.internal.world.VsiShipWorld;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u0004\u0018\u00010\t2\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H&\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\f\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH&\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H&\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001a8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001f\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;", "Lorg/valkyrienskies/core/internal/world/VsiShipWorld;", "Lorg/valkyrienskies/core/api/world/ClientShipWorld;", "", "destroyWorld", "()V", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "id", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getPhysEntityClientRenderTransform", "(J)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "postTick", "Ljava/net/SocketAddress;", "server", "tickNetworking", "(Ljava/net/SocketAddress;)V", "", "partialTicks", "updateRenderTransforms", "(D)V", "Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "getAllShips", "()Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "allShips", "", "isSyncedWithServer", "()Z", "getLoadedShips", "loadedShips", "internal"})
@GameTickOnly
public interface VsiClientShipWorld
extends VsiShipWorld,
ClientShipWorld {
    @NotNull
    public VsiQueryableShipData<ClientShip> getAllShips();

    @NotNull
    public VsiQueryableShipData<ClientShip> getLoadedShips();

    @Nullable
    public ShipTransform getPhysEntityClientRenderTransform(long var1);

    public void tickNetworking(@NotNull SocketAddress var1);

    public void postTick();

    public void updateRenderTransforms(double var1);

    public void destroyWorld();

    public boolean isSyncedWithServer();
}


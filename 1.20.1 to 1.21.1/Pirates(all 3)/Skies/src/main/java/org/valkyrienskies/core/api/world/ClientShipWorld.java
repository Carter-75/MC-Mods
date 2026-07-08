/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 */
package org.valkyrienskies.core.api.world;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.QueryableShipData;
import org.valkyrienskies.core.api.util.GameTickOnly;
import org.valkyrienskies.core.api.world.ShipWorld;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\nR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\b8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000e\u0010\n\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0012\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/world/ClientShipWorld;", "Lorg/valkyrienskies/core/api/world/ShipWorld;", "Lorg/joml/primitives/AABBdc;", "aabb", "", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "getShipObjectsIntersecting", "(Lorg/joml/primitives/AABBdc;)Ljava/util/List;", "Lorg/valkyrienskies/core/api/ships/QueryableShipData;", "getAllShips", "()Lorg/valkyrienskies/core/api/ships/QueryableShipData;", "allShips", "getLoadedShips", "loadedShips", "getQueryableShipData", "getQueryableShipData$annotations", "()V", "queryableShipData", "api"})
@GameTickOnly
public interface ClientShipWorld
extends ShipWorld {
    @NotNull
    public QueryableShipData<ClientShip> getAllShips();

    @NotNull
    public QueryableShipData<ClientShip> getLoadedShips();

    @Deprecated(message="redundant", replaceWith=@ReplaceWith(expression="loadedShips.getShipDataIntersecting(aabb)", imports={}))
    @NotNull
    public List<ClientShip> getShipObjectsIntersecting(@NotNull AABBdc var1);

    @NotNull
    default public QueryableShipData<ClientShip> getQueryableShipData() {
        return this.getAllShips();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="allShips", imports={}))
    public static /* synthetic */ void getQueryableShipData$annotations() {
    }
}


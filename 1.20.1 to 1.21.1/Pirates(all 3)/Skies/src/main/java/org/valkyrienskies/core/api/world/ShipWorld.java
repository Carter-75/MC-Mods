/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function4
 */
package org.valkyrienskies.core.api.world;

import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3ic;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.QueryableShipData;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.world.connectivity.ConnectionStatus;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H'\u00a2\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\u0010\f\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u000e\u001a\u00020\rH'\u00a2\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\u0010\f\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u000e\u001a\u00020\rH'\u00a2\u0006\u0004\b\u0013\u0010\u0012J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0015\u001a\u00020\u0014H'\u00a2\u0006\u0004\b\u0018\u0010\u0019J3\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H'\u00a2\u0006\u0004\b\u001a\u0010\u000bJ3\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007H&\u00a2\u0006\u0004\b\u001f\u0010 J+\u0010#\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007H&\u00a2\u0006\u0004\b#\u0010$JK\u0010,\u001a\u00020+2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H'\u00a2\u0006\u0004\b,\u0010-JK\u0010.\u001a\u00020+2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H'\u00a2\u0006\u0004\b.\u0010-J3\u0010/\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H'\u00a2\u0006\u0004\b/\u00100J3\u00101\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H'\u00a2\u0006\u0004\b1\u00100JY\u00105\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022$\u00104\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000203022\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H'\u00a2\u0006\u0004\b5\u00106JY\u00107\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022$\u00104\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000203022\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H'\u00a2\u0006\u0004\b7\u00106R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u000209088&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010;R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u0017088&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010;R \u0010B\u001a\b\u0012\u0004\u0012\u000209088VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b@\u0010A\u001a\u0004\b?\u0010;\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006C\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/world/ShipWorld;", "", "", "x", "y", "z", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimension", "", "getAirComponentSize", "(IIILjava/lang/String;)J", "dimensionId", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "chunkClaim", "", "Lorg/joml/Vector3ic;", "getAllAirComponentsFromClaim", "(Ljava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;)Ljava/util/Set;", "getAllSolidComponentsFromClaim", "Lorg/joml/primitives/AABBdc;", "aabb", "", "Lorg/valkyrienskies/core/api/ships/LoadedShip;", "getShipObjectsIntersecting", "(Lorg/joml/primitives/AABBdc;)Ljava/util/List;", "getSolidComponentSize", "blockX", "blockY", "blockZ", "", "isBlockInShipyard", "(IIILjava/lang/String;)Z", "chunkX", "chunkZ", "isChunkInShipyard", "(IILjava/lang/String;)Z", "x1", "y1", "z1", "x2", "y2", "z2", "Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isConnectedByAir", "(IIIIIILjava/lang/String;)Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isConnectedBySolid", "isIsolatedAir", "(IIILjava/lang/String;)Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isIsolatedSolid", "Lkotlin/Function4;", "", "action", "traverseAirComponent", "(IIILkotlin/jvm/functions/Function4;Ljava/lang/String;)V", "traverseSolidComponent", "Lorg/valkyrienskies/core/api/ships/QueryableShipData;", "Lorg/valkyrienskies/core/api/ships/Ship;", "getAllShips", "()Lorg/valkyrienskies/core/api/ships/QueryableShipData;", "allShips", "getLoadedShips", "loadedShips", "getQueryableShipData", "getQueryableShipData$annotations", "()V", "queryableShipData", "api"})
public interface ShipWorld {
    @NotNull
    public QueryableShipData<Ship> getAllShips();

    @NotNull
    public QueryableShipData<LoadedShip> getLoadedShips();

    public boolean isChunkInShipyard(int var1, int var2, @NotNull String var3);

    public boolean isBlockInShipyard(int var1, int var2, int var3, @NotNull String var4);

    @Deprecated(message="redundant", replaceWith=@ReplaceWith(expression="loadedShips.getIntersecting(aabb)", imports={}))
    @NotNull
    public List<LoadedShip> getShipObjectsIntersecting(@NotNull AABBdc var1);

    @NotNull
    default public QueryableShipData<Ship> getQueryableShipData() {
        return this.getAllShips();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="allShips", imports={}))
    public static /* synthetic */ void getQueryableShipData$annotations() {
    }

    @ApiStatus.Experimental
    @NotNull
    public ConnectionStatus isConnectedByAir(int var1, int var2, int var3, int var4, int var5, int var6, @NotNull String var7);

    @ApiStatus.Experimental
    @NotNull
    public ConnectionStatus isConnectedBySolid(int var1, int var2, int var3, int var4, int var5, int var6, @NotNull String var7);

    @ApiStatus.Experimental
    @NotNull
    public ConnectionStatus isIsolatedAir(int var1, int var2, int var3, @NotNull String var4);

    @ApiStatus.Experimental
    @NotNull
    public ConnectionStatus isIsolatedSolid(int var1, int var2, int var3, @NotNull String var4);

    @ApiStatus.Experimental
    public long getSolidComponentSize(int var1, int var2, int var3, @NotNull String var4);

    @ApiStatus.Experimental
    @NotNull
    public Set<Vector3ic> getAllSolidComponentsFromClaim(@NotNull String var1, @NotNull ChunkClaim var2);

    @ApiStatus.Experimental
    public long getAirComponentSize(int var1, int var2, int var3, @NotNull String var4);

    @ApiStatus.Experimental
    public void traverseSolidComponent(int var1, int var2, int var3, @NotNull Function4<? super Integer, ? super Integer, ? super Integer, ? super Long, Unit> var4, @NotNull String var5);

    @ApiStatus.Experimental
    public void traverseAirComponent(int var1, int var2, int var3, @NotNull Function4<? super Integer, ? super Integer, ? super Integer, ? super Long, Unit> var4, @NotNull String var5);

    @ApiStatus.Experimental
    @NotNull
    public Set<Vector3ic> getAllAirComponentsFromClaim(@NotNull String var1, @NotNull ChunkClaim var2);
}


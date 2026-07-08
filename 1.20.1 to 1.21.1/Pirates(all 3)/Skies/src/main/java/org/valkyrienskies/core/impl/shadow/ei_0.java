/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.net.SocketAddress;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.joml.Vector3ic;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.api.world.LevelYRange;
import org.valkyrienskies.core.api.world.connectivity.ConnectionStatus;
import org.valkyrienskies.core.impl.shadow.em_0;
import org.valkyrienskies.core.internal.ships.VsiQueryableShipData;
import org.valkyrienskies.core.internal.world.VsiClientShipWorld;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;
import org.valkyrienskies.core.internal.world.chunks.VsiTerrainUpdate;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ei
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bR\u0010\u0014J;\u0010\r\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0011\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00152\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001dJ\u001d\u0010!\u001a\u0004\u0018\u00010 2\n\u0010\u0004\u001a\u00060\u0016j\u0002`\u001fH\u0016\u00a2\u0006\u0004\b!\u0010\"J\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u000f2\u0006\u0010\u0004\u001a\u00020#H\u0017\u00a2\u0006\u0004\b%\u0010&J3\u0010'\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00152\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b'\u0010\u0018J3\u0010)\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00152\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b)\u0010*J+\u0010+\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00152\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b+\u0010,JK\u00100\u001a\u00020/2\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00152\n\u0010.\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b0\u00101JK\u00102\u001a\u00020/2\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00152\n\u0010.\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b2\u00101J3\u00103\u001a\u00020/2\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00152\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b3\u00104J3\u00105\u001a\u00020/2\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00152\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b5\u00104JS\u00108\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00152\n\u0010\n\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u0002062\u0006\u0010-\u001a\u0002062\u0006\u0010.\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b:\u0010\u0014J\u001b\u0010;\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020=H\u0016\u00a2\u0006\u0004\b>\u0010?JY\u0010A\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00152$\u0010\n\u001a \u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0@2\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\bA\u0010BJY\u0010C\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00152$\u0010\n\u001a \u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0@2\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\bC\u0010BJ7\u0010D\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\tH\u0016\u00a2\u0006\u0004\bF\u0010GR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020$0H8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020(8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010MR \u0010Q\u001a\b\u0012\u0004\u0012\u00020$0H8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010J"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Ei;", "Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "p0", "Lorg/valkyrienskies/core/api/world/LevelYRange;", "p1", "Lorg/joml/Vector3dc;", "p2", "", "p3", "p4", "", "addDimension", "(Ljava/lang/String;Lorg/valkyrienskies/core/api/world/LevelYRange;Lorg/joml/Vector3dc;DD)V", "", "Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate;", "addTerrainUpdates", "(Ljava/lang/String;Ljava/util/List;)V", "destroyWorld", "()V", "", "", "getAirComponentSize", "(IIILjava/lang/String;)J", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "", "Lorg/joml/Vector3ic;", "getAllAirComponentsFromClaim", "(Ljava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;)Ljava/util/Set;", "getAllSolidComponentsFromClaim", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getPhysEntityClientRenderTransform", "(J)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "Lorg/joml/primitives/AABBdc;", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "getShipObjectsIntersecting", "(Lorg/joml/primitives/AABBdc;)Ljava/util/List;", "getSolidComponentSize", "", "isBlockInShipyard", "(IIILjava/lang/String;)Z", "isChunkInShipyard", "(IILjava/lang/String;)Z", "p5", "p6", "Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isConnectedByAir", "(IIIIIILjava/lang/String;)Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isConnectedBySolid", "isIsolatedAir", "(IIILjava/lang/String;)Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isIsolatedSolid", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "p7", "onSetBlock", "(IIILjava/lang/String;Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;DD)V", "postTick", "removeDimension", "(Ljava/lang/String;)V", "Ljava/net/SocketAddress;", "tickNetworking", "(Ljava/net/SocketAddress;)V", "Lkotlin/Function4;", "traverseAirComponent", "(IIILkotlin/jvm/functions/Function4;Ljava/lang/String;)V", "traverseSolidComponent", "updateDimension", "(Ljava/lang/String;Lorg/joml/Vector3dc;Ljava/lang/Double;Ljava/lang/Double;)V", "updateRenderTransforms", "(D)V", "Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "getAllShips", "()Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "a", "isSyncedWithServer", "()Z", "b", "Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "getLoadedShips", "c", "<init>"})
public final class ei_0
implements VsiClientShipWorld {
    public static final ei_0 INSTANCE = new ei_0();
    private static final VsiQueryableShipData<ClientShip> b = new em_0(null, 1, null);

    private ei_0() {
    }

    @Override
    public final void tickNetworking(SocketAddress server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"");
        throw new UnsupportedOperationException();
    }

    @Override
    public final void postTick() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void updateRenderTransforms(double partialTicks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void destroyWorld() {
        throw new UnsupportedOperationException();
    }

    @Override
    @JvmName(name="isSyncedWithServer")
    public final boolean isSyncedWithServer() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void onSetBlock(int posX, int posY, int posZ, String dimensionId, VsiBlockType oldBlockType, VsiBlockType newBlockType, double oldBlockMass, double newBlockMass) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)oldBlockType, (String)"");
        Intrinsics.checkNotNullParameter((Object)newBlockType, (String)"");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void addTerrainUpdates(String dimensionId, List<? extends VsiTerrainUpdate> terrainUpdates) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void addDimension(String dimensionId, LevelYRange yRange, Vector3dc gravity, double seaLevel, double maxY) {
        void var3_3;
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        Intrinsics.checkNotNullParameter((Object)var3_3, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void updateDimension(String dimensionId, Vector3dc gravity, Double seaLevel, Double maxY) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void removeDimension(String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    @JvmName(name="getAllShips")
    public final VsiQueryableShipData<ClientShip> getAllShips() {
        return this.getLoadedShips();
    }

    @Override
    @JvmName(name="getLoadedShips")
    public final VsiQueryableShipData<ClientShip> getLoadedShips() {
        return b;
    }

    @Override
    public final ShipTransform getPhysEntityClientRenderTransform(long id) {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final boolean isChunkInShipyard(int chunkX, int chunkZ, String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        return false;
    }

    @Override
    public final boolean isBlockInShipyard(int blockX, int blockY, int blockZ, String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        return false;
    }

    @Override
    @Deprecated(message="redundant", replaceWith=@ReplaceWith(expression="loadedShips.getIntersecting(aabb)", imports={}))
    public final List<ClientShip> getShipObjectsIntersecting(AABBdc aabb) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"");
        return CollectionsKt.emptyList();
    }

    @Override
    public final ConnectionStatus isConnectedByAir(int x1, int y1, int z1, int x2, int y2, int z2, String dimension) {
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final ConnectionStatus isConnectedBySolid(int x1, int y1, int z1, int x2, int y2, int z2, String dimension) {
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final ConnectionStatus isIsolatedAir(int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final ConnectionStatus isIsolatedSolid(int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final long getSolidComponentSize(int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Set<Vector3ic> getAllSolidComponentsFromClaim(String dimensionId, ChunkClaim chunkClaim) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final long getAirComponentSize(int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void traverseSolidComponent(int x, int y, int z, Function4<? super Integer, ? super Integer, ? super Integer, ? super Long, Unit> action, String dimension) {
        Intrinsics.checkNotNullParameter(action, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void traverseAirComponent(int x, int y, int z, Function4<? super Integer, ? super Integer, ? super Integer, ? super Long, Unit> action, String dimension) {
        Intrinsics.checkNotNullParameter(action, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Set<Vector3ic> getAllAirComponentsFromClaim(String dimensionId, ChunkClaim chunkClaim) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }
}


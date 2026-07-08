/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 */
package org.valkyrienskies.core.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix3dc;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.VsCoreApi;
import org.valkyrienskies.core.api.physics.blockstates.BoxesBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.LiquidState;
import org.valkyrienskies.core.api.physics.blockstates.SolidState;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.ShipInertiaData;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.internal.ShipTeleportData;
import org.valkyrienskies.core.internal.VsiCoreCommands;
import org.valkyrienskies.core.internal.collision.VsiEntityPolygonCollider;
import org.valkyrienskies.core.internal.collision.VsiSolidShapeUtils;
import org.valkyrienskies.core.internal.config.VsiConfigModel;
import org.valkyrienskies.core.internal.hooks.VsiCoreHooks;
import org.valkyrienskies.core.internal.physics.blockstates.VsiBlockState;
import org.valkyrienskies.core.internal.world.VsiClientShipWorld;
import org.valkyrienskies.core.internal.world.VsiPipeline;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockTypes;
import org.valkyrienskies.core.internal.world.chunks.VsiTerrainUpdate;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00f4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H'\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\u0011\u0010\u0010J'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\tH&\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH&\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH&\u00a2\u0006\u0004\b \u0010!J\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\"H&\u00a2\u0006\u0004\b \u0010$J\u001f\u0010'\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"H&\u00a2\u0006\u0004\b'\u0010(J'\u00100\u001a\u00020/2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-H&\u00a2\u0006\u0004\b0\u00101Ja\u0010=\u001a\u00020<2\b\b\u0002\u00102\u001a\u00020)2\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020)2\b\b\u0002\u00106\u001a\u00020)2\u0010\b\u0002\u00109\u001a\n\u0018\u000107j\u0004\u0018\u0001`82\n\b\u0002\u0010:\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010)H&\u00a2\u0006\u0004\b=\u0010>J7\u0010D\u001a\u00020C2\b\b\u0002\u0010?\u001a\u00020)2\b\b\u0002\u0010@\u001a\u00020)2\b\b\u0002\u0010A\u001a\u0002032\b\b\u0002\u0010B\u001a\u00020)H&\u00a2\u0006\u0004\bD\u0010EJ\u000f\u0010G\u001a\u00020FH&\u00a2\u0006\u0004\bG\u0010HJ\u000f\u0010J\u001a\u00020IH&\u00a2\u0006\u0004\bJ\u0010KJ'\u0010L\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&\u00a2\u0006\u0004\bL\u0010\u0018J\u001d\u0010Q\u001a\u00020P2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020N0MH&\u00a2\u0006\u0004\bQ\u0010RJ\u0017\u0010T\u001a\u00020\"2\u0006\u0010S\u001a\u00020\u001fH&\u00a2\u0006\u0004\bT\u0010UR\u0014\u0010Y\u001a\u00020V8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bW\u0010XR\"\u0010`\u001a\u00020\t8&@&X\u00a7\u000e\u00a2\u0006\u0012\u0012\u0004\b^\u0010_\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0014\u0010d\u001a\u00020a8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bb\u0010cR\u0014\u0010h\u001a\u00020e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bj\u0010kR\u0014\u0010p\u001a\u00020m8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bn\u0010oR\u0014\u0010t\u001a\u00020q8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\br\u0010sR\u0014\u0010x\u001a\u00020u8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bv\u0010wR\u0014\u0010|\u001a\u00020y8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bz\u0010{\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006}\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/VsiCore;", "Lorg/valkyrienskies/core/api/VsCoreApi;", "Lorg/valkyrienskies/core/internal/VsiCoreCommands;", "Lorg/valkyrienskies/core/internal/config/VsiConfigModel;", "getServerConfig", "()Lorg/valkyrienskies/core/internal/config/VsiConfigModel;", "", "chunkX", "chunkZ", "", "isChunkInShipyard", "(II)Z", "claimX", "claimZ", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "newChunkClaim", "(II)Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "newChunkClaimFromChunkPos", "chunkY", "Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate;", "newDeleteTerrainUpdate", "(III)Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate;", "Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate$Builder;", "newDenseTerrainUpdateBuilder", "(III)Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate$Builder;", "overwrite", "newEmptyVoxelShapeUpdate", "(IIIZ)Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate;", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "newLiquidStateBuilder", "()Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "newPipeline", "()Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "", "data", "([B)Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "queryableShipDataBytes", "chunkAllocatorBytes", "newPipelineLegacyData", "([B[B)Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "Lorg/joml/Vector3dc;", "centerOfMassInShip", "", "mass", "Lorg/joml/Matrix3dc;", "momentOfInertiaTensor", "Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "newShipInertiaData", "(Lorg/joml/Vector3dc;DLorg/joml/Matrix3dc;)Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "newPos", "Lorg/joml/Quaterniondc;", "newRot", "newVel", "newOmega", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "newDimension", "newScale", "newPosInShip", "Lorg/valkyrienskies/core/internal/ShipTeleportData;", "newShipTeleportData", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Ljava/lang/String;Ljava/lang/Double;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/internal/ShipTeleportData;", "positionInWorld", "positionInShip", "shipToWorldRotation", "shipToWorldScaling", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "newShipTransform", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "newSolidStateBoxesShapeBuilder", "()Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "newSolidStateBuilder", "()Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "newSparseTerrainUpdateBuilder", "", "Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;", "states", "", "registerBlockStates", "(Ljava/lang/Iterable;)V", "pipeline", "serializePipeline", "(Lorg/valkyrienskies/core/internal/world/VsiPipeline;)[B", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockTypes;", "getBlockTypes", "()Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockTypes;", "blockTypes", "getClientUsesUDP", "()Z", "setClientUsesUDP", "(Z)V", "getClientUsesUDP$annotations", "()V", "clientUsesUDP", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "getDefaultMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "defaultMapper", "Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;", "getDummyShipWorldClient", "()Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;", "dummyShipWorldClient", "Lorg/valkyrienskies/core/internal/world/VsiServerShipWorld;", "getDummyShipWorldServer", "()Lorg/valkyrienskies/core/internal/world/VsiServerShipWorld;", "dummyShipWorldServer", "Lorg/valkyrienskies/core/internal/collision/VsiEntityPolygonCollider;", "getEntityPolygonCollider", "()Lorg/valkyrienskies/core/internal/collision/VsiEntityPolygonCollider;", "entityPolygonCollider", "Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooks;", "getHooks", "()Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooks;", "hooks", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "getSimplePacketNetworking", "()Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "simplePacketNetworking", "Lorg/valkyrienskies/core/internal/collision/VsiSolidShapeUtils;", "getSolidShapeUtils", "()Lorg/valkyrienskies/core/internal/collision/VsiSolidShapeUtils;", "solidShapeUtils", "internal"})
public interface VsiCore
extends VsCoreApi,
VsiCoreCommands {
    @NotNull
    public SimplePacketNetworking getSimplePacketNetworking();

    @NotNull
    public VsiCoreHooks getHooks();

    @NotNull
    public VsiBlockTypes getBlockTypes();

    @NotNull
    public VsiEntityPolygonCollider getEntityPolygonCollider();

    @NotNull
    public VsiSolidShapeUtils getSolidShapeUtils();

    @NotNull
    public VsiClientShipWorld getDummyShipWorldClient();

    @NotNull
    public VsiServerShipWorld getDummyShipWorldServer();

    public void registerBlockStates(@NotNull Iterable<VsiBlockState> var1);

    @NotNull
    public VsiTerrainUpdate newEmptyVoxelShapeUpdate(int var1, int var2, int var3, boolean var4);

    @NotNull
    public VsiTerrainUpdate newDeleteTerrainUpdate(int var1, int var2, int var3);

    @NotNull
    public VsiTerrainUpdate.Builder newDenseTerrainUpdateBuilder(int var1, int var2, int var3);

    @NotNull
    public VsiTerrainUpdate.Builder newSparseTerrainUpdateBuilder(int var1, int var2, int var3);

    @NotNull
    public VsiPipeline newPipelineLegacyData(@NotNull byte[] var1, @NotNull byte[] var2);

    @NotNull
    public VsiPipeline newPipeline();

    @NotNull
    public VsiPipeline newPipeline(@NotNull byte[] var1);

    @NotNull
    public byte[] serializePipeline(@NotNull VsiPipeline var1);

    @NotNull
    public ChunkClaim newChunkClaim(int var1, int var2);

    @NotNull
    public ChunkClaim newChunkClaimFromChunkPos(int var1, int var2);

    @NotNull
    public SolidState.Builder newSolidStateBuilder();

    @NotNull
    public LiquidState.Builder newLiquidStateBuilder();

    @NotNull
    public BoxesBlockShape.Builder newSolidStateBoxesShapeBuilder();

    @NotNull
    public ShipTransform newShipTransform(@NotNull Vector3dc var1, @NotNull Vector3dc var2, @NotNull Quaterniondc var3, @NotNull Vector3dc var4);

    public static /* synthetic */ ShipTransform newShipTransform$default(VsiCore vsiCore, Vector3dc vector3dc, Vector3dc vector3dc2, Quaterniondc quaterniondc, Vector3dc vector3dc3, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newShipTransform");
        }
        if ((n2 & 1) != 0) {
            vector3dc = new Vector3d();
        }
        if ((n2 & 2) != 0) {
            vector3dc2 = new Vector3d();
        }
        if ((n2 & 4) != 0) {
            quaterniondc = new Quaterniond();
        }
        if ((n2 & 8) != 0) {
            vector3dc3 = new Vector3d(1.0);
        }
        return vsiCore.newShipTransform(vector3dc, vector3dc2, quaterniondc, vector3dc3);
    }

    @NotNull
    public ShipTeleportData newShipTeleportData(@NotNull Vector3dc var1, @NotNull Quaterniondc var2, @NotNull Vector3dc var3, @NotNull Vector3dc var4, @Nullable String var5, @Nullable Double var6, @Nullable Vector3dc var7);

    public static /* synthetic */ ShipTeleportData newShipTeleportData$default(VsiCore vsiCore, Vector3dc vector3dc, Quaterniondc quaterniondc, Vector3dc vector3dc2, Vector3dc vector3dc3, String string, Double d2, Vector3dc vector3dc4, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newShipTeleportData");
        }
        if ((n2 & 1) != 0) {
            vector3dc = new Vector3d();
        }
        if ((n2 & 2) != 0) {
            quaterniondc = new Quaterniond();
        }
        if ((n2 & 4) != 0) {
            vector3dc2 = new Vector3d();
        }
        if ((n2 & 8) != 0) {
            vector3dc3 = new Vector3d();
        }
        if ((n2 & 0x10) != 0) {
            string = null;
        }
        if ((n2 & 0x20) != 0) {
            d2 = null;
        }
        if ((n2 & 0x40) != 0) {
            vector3dc4 = null;
        }
        return vsiCore.newShipTeleportData(vector3dc, quaterniondc, vector3dc2, vector3dc3, string, d2, vector3dc4);
    }

    @NotNull
    public ShipInertiaData newShipInertiaData(@NotNull Vector3dc var1, double var2, @NotNull Matrix3dc var4);

    @NotNull
    public VsiConfigModel getServerConfig();

    @NotNull
    public ObjectMapper getDefaultMapper();

    @Deprecated(message="This method isn't tied to a world, which is bad if we want to have different chunk allocation strategies per world in the future.", replaceWith=@ReplaceWith(expression="ShipWorld.isChunkInShipyard(chunkX, chunkZ, DimensionId)", imports={}))
    public boolean isChunkInShipyard(int var1, int var2);

    public boolean getClientUsesUDP();

    public void setClientUsesUDP(boolean var1);

    @Deprecated(message="Surely we can do better than this")
    public static /* synthetic */ void getClientUsesUDP$annotations() {
    }
}


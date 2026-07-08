/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Function
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.FunctionAdapter
 *  kotlin.jvm.internal.FunctionReferenceImpl
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 */
package org.valkyrienskies.core.impl.game.ships;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.event.RegisteredListener;
import org.valkyrienskies.core.api.ships.ClientShipTransformProvider;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.api.world.LevelYRange;
import org.valkyrienskies.core.api.world.connectivity.ConnectionStatus;
import org.valkyrienskies.core.impl.game.ChunkAllocatorProvider;
import org.valkyrienskies.core.impl.game.phys_entities.PhysicsEntityClient;
import org.valkyrienskies.core.impl.game.ships.ShipDataCommon;
import org.valkyrienskies.core.impl.hooks.VSEvents;
import org.valkyrienskies.core.impl.networking.impl.PacketPhysEntityCreate;
import org.valkyrienskies.core.impl.networking.impl.PacketPhysEntityRemove;
import org.valkyrienskies.core.impl.networking.impl.PacketShipDataCreate;
import org.valkyrienskies.core.impl.networking.impl.PacketShipRemove;
import org.valkyrienskies.core.impl.networking.impl.PhysEntityCreateData;
import org.valkyrienskies.core.impl.shadow.DP;
import org.valkyrienskies.core.impl.shadow.DW;
import org.valkyrienskies.core.impl.shadow.EL;
import org.valkyrienskies.core.impl.shadow.ET;
import org.valkyrienskies.core.impl.shadow.EX;
import org.valkyrienskies.core.impl.shadow.EZ;
import org.valkyrienskies.core.impl.shadow.eg_0;
import org.valkyrienskies.core.impl.shadow.em_0;
import org.valkyrienskies.core.impl.shadow.eo_0;
import org.valkyrienskies.core.impl.shadow.ep_0;
import org.valkyrienskies.core.impl.shadow.et_0;
import org.valkyrienskies.core.impl.shadow.fb_0;
import org.valkyrienskies.core.impl.shadow.fi_0;
import org.valkyrienskies.core.impl.shadow.ii_0;
import org.valkyrienskies.core.impl.shadow.ij_0;
import org.valkyrienskies.core.impl.shadow.ik_0;
import org.valkyrienskies.core.impl.shadow.il_0;
import org.valkyrienskies.core.internal.ships.VsiQueryableShipData;
import org.valkyrienskies.core.internal.world.VsiClientShipWorld;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockTypes;
import org.valkyrienskies.core.internal.world.chunks.VsiTerrainUpdate;
import org.valkyrienskies.core.util.AABBdUtilKt;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00fe\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002BI\b\u0007\u0012\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001\u0012\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001\u0012\u0006\u0010n\u001a\u00020m\u0012\u0006\u0010q\u001a\u00020p\u0012\u0018\b\u0001\u0010t\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020s0e\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J;\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001c\u001a\u00020\u000e2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ3\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\n\u0010$\u001a\u00060\u0004j\u0002`\u0005H\u0016\u00a2\u0006\u0004\b&\u0010'J)\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010)\u001a\u00020(H\u0016\u00a2\u0006\u0004\b,\u0010-J)\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010)\u001a\u00020(H\u0016\u00a2\u0006\u0004\b.\u0010-J\u001d\u00102\u001a\u0004\u0018\u0001012\n\u00100\u001a\u00060%j\u0002`/H\u0016\u00a2\u0006\u0004\b2\u00103J3\u00104\u001a\u00020%2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\n\u0010$\u001a\u00060\u0004j\u0002`\u0005H\u0016\u00a2\u0006\u0004\b4\u0010'JK\u0010<\u001a\u00020;2\u0006\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 2\n\u0010$\u001a\u00060\u0004j\u0002`\u0005H\u0016\u00a2\u0006\u0004\b<\u0010=JK\u0010>\u001a\u00020;2\u0006\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 2\n\u0010$\u001a\u00060\u0004j\u0002`\u0005H\u0016\u00a2\u0006\u0004\b>\u0010=J3\u0010?\u001a\u00020;2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\n\u0010$\u001a\u00060\u0004j\u0002`\u0005H\u0016\u00a2\u0006\u0004\b?\u0010@J3\u0010A\u001a\u00020;2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\n\u0010$\u001a\u00060\u0004j\u0002`\u0005H\u0016\u00a2\u0006\u0004\bA\u0010@JS\u0010K\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020 2\u0006\u0010C\u001a\u00020 2\u0006\u0010D\u001a\u00020 2\n\u0010\u0006\u001a\u00060\u0004j\u0002`E2\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020F2\u0006\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\bM\u0010\u001fJ\u001b\u0010N\u001a\u00020\u000e2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016\u00a2\u0006\u0004\bN\u0010OJ\u0019\u0010Q\u001a\u00020\u000e2\n\u0010P\u001a\u00060%j\u0002`/\u00a2\u0006\u0004\bQ\u0010RJ\u0019\u0010S\u001a\u00020\u000e2\n\u0010P\u001a\u00060%j\u0002`/\u00a2\u0006\u0004\bS\u0010RJ\u0017\u0010V\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020TH\u0016\u00a2\u0006\u0004\bV\u0010WJY\u0010Z\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2$\u0010Y\u001a \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000e0X2\n\u0010$\u001a\u00060\u0004j\u0002`\u0005H\u0016\u00a2\u0006\u0004\bZ\u0010[JY\u0010\\\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2$\u0010Y\u001a \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000e0X2\n\u0010$\u001a\u00060\u0004j\u0002`\u0005H\u0016\u00a2\u0006\u0004\b\\\u0010[J7\u0010]\u001a\u00020\u000e2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b`\u0010aR\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00030b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR$\u0010g\u001a\u0012\u0012\b\u0012\u00060%j\u0002`/\u0012\u0004\u0012\u00020f0e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u001a\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00030i8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bj\u0010kR\u0014\u0010n\u001a\u00020m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010q\u001a\u00020p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010rR$\u0010t\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020s0e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010hR\u0014\u0010v\u001a\u00020u8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bv\u0010wR\u001a\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00030i8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bx\u0010kR\u0014\u0010{\u001a\u00020z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010|R\"\u0010\u0080\u0001\u001a\u0012\u0012\b\u0012\u00060%j\u0002`/\u0012\u0004\u0012\u00020f0}8G\u00a2\u0006\u0006\u001a\u0004\b~\u0010\u007f"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/ShipObjectClientWorld;", "Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;", "Lorg/valkyrienskies/core/impl/shadow/Et;", "Lorg/valkyrienskies/core/impl/shadow/Ep;", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimensionId", "Lorg/valkyrienskies/core/api/world/LevelYRange;", "yRange", "Lorg/joml/Vector3dc;", "gravity", "", "seaLevel", "maxY", "", "addDimension", "(Ljava/lang/String;Lorg/valkyrienskies/core/api/world/LevelYRange;Lorg/joml/Vector3dc;DD)V", "Lorg/valkyrienskies/core/impl/networking/impl/PhysEntityCreateData;", "physicsEntityCreateData", "addPhysicsEntity", "(Lorg/valkyrienskies/core/impl/networking/impl/PhysEntityCreateData;)V", "Lorg/valkyrienskies/core/impl/game/ships/ShipDataCommon;", "ship", "addShip", "(Lorg/valkyrienskies/core/impl/game/ships/ShipDataCommon;)V", "", "Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate;", "terrainUpdates", "addTerrainUpdates", "(Ljava/lang/String;Ljava/util/List;)V", "destroyWorld", "()V", "", "x", "y", "z", "dimension", "", "getAirComponentSize", "(IIILjava/lang/String;)J", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "chunkClaim", "", "Lorg/joml/Vector3ic;", "getAllAirComponentsFromClaim", "(Ljava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;)Ljava/util/Set;", "getAllSolidComponentsFromClaim", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "id", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getPhysEntityClientRenderTransform", "(J)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getSolidComponentSize", "x1", "y1", "z1", "x2", "y2", "z2", "Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isConnectedByAir", "(IIIIIILjava/lang/String;)Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isConnectedBySolid", "isIsolatedAir", "(IIILjava/lang/String;)Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isIsolatedSolid", "posX", "posY", "posZ", "Lorg/valkyrienskies/core/internal/world/properties/DimensionId;", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "oldBlockType", "newBlockType", "oldBlockMass", "newBlockMass", "onSetBlock", "(IIILjava/lang/String;Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;DD)V", "postTick", "removeDimension", "(Ljava/lang/String;)V", "shipId", "removePhysicsEntity", "(J)V", "removeShip", "Ljava/net/SocketAddress;", "server", "tickNetworking", "(Ljava/net/SocketAddress;)V", "Lkotlin/Function4;", "action", "traverseAirComponent", "(IIILkotlin/jvm/functions/Function4;Ljava/lang/String;)V", "traverseSolidComponent", "updateDimension", "(Ljava/lang/String;Lorg/joml/Vector3dc;Ljava/lang/Double;Ljava/lang/Double;)V", "partialTicks", "updateRenderTransforms", "(D)V", "Lorg/valkyrienskies/core/impl/shadow/Em;", "_loadedShips", "Lorg/valkyrienskies/core/impl/shadow/Em;", "", "Lorg/valkyrienskies/core/impl/game/phys_entities/PhysicsEntityClient;", "_physicsEntities", "Ljava/util/Map;", "Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "getAllShips", "()Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "allShips", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockTypes;", "blockTypes", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockTypes;", "Lorg/valkyrienskies/core/impl/shadow/DW;", "connectivityHandler", "Lorg/valkyrienskies/core/impl/shadow/DW;", "Lorg/valkyrienskies/core/impl/shadow/DP;", "dimensionInfo", "", "isSyncedWithServer", "()Z", "getLoadedShips", "loadedShips", "Lorg/valkyrienskies/core/impl/shadow/EL;", "networkManager", "Lorg/valkyrienskies/core/impl/shadow/EL;", "", "getPhysicsEntities", "()Ljava/util/Map;", "physicsEntities", "Lorg/valkyrienskies/core/impl/shadow/EL$b;", "networkManagerFactory", "Lorg/valkyrienskies/core/impl/game/ChunkAllocatorProvider;", "chunkAllocators", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/EL$b;Lorg/valkyrienskies/core/impl/game/ChunkAllocatorProvider;Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockTypes;Lorg/valkyrienskies/core/impl/shadow/DW;Ljava/util/Map;)V"})
public final class ShipObjectClientWorld
extends et_0<ep_0>
implements VsiClientShipWorld {
    private final VsiBlockTypes blockTypes;
    private final DW connectivityHandler;
    private final Map<String, DP> dimensionInfo;
    private final em_0<ep_0> _loadedShips;
    private final Map<Long, PhysicsEntityClient> _physicsEntities;
    private final EL networkManager;

    @Inject
    public ShipObjectClientWorld(EL.b networkManagerFactory, ChunkAllocatorProvider chunkAllocators, VsiBlockTypes blockTypes, DW connectivityHandler, @Named(value="mutableDimensionInfo") Map<String, DP> dimensionInfo) {
        EL eL;
        Object object;
        Object[] objectArray;
        Intrinsics.checkNotNullParameter((Object)networkManagerFactory, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkAllocators, (String)"");
        Intrinsics.checkNotNullParameter((Object)blockTypes, (String)"");
        Intrinsics.checkNotNullParameter((Object)connectivityHandler, (String)"");
        Intrinsics.checkNotNullParameter(dimensionInfo, (String)"");
        super((ChunkAllocatorProvider)objectArray, blockTypes);
        this.blockTypes = object;
        this.connectivityHandler = connectivityHandler;
        this.dimensionInfo = dimensionInfo;
        this._loadedShips = new em_0(null, 1, null);
        this._physicsEntities = new HashMap();
        eL = this.networkManager = eL.a(this);
        Object[] objectArray2 = new RegisteredListener[7];
        objectArray = objectArray2;
        object = eL.d;
        objectArray2[0] = ((fb_0)object).d.a((EX)new FunctionAdapter(eL){
            private /* synthetic */ EL a;
            {
                this.a = eL;
            }

            /*
             * WARNING - void declaration
             */
            public final void handlePacket(EZ p0) {
                void var1_1;
                Intrinsics.checkNotNullParameter((Object)p0, (String)"");
                EL.a(this.a, (EZ)var1_1);
            }

            public final Function<?> getFunctionDelegate() {
                return (Function)new FunctionReferenceImpl(1, (Object)this.a, EL.class, "onShipTransform", "onShipTransform(Lorg/valkyrienskies/core/impl/networking/Packet;)V", 0);
            }

            /*
             * WARNING - void declaration
             */
            public final boolean equals(Object other) {
                if (other instanceof EX) {
                    if (other instanceof FunctionAdapter) {
                        void var1_1;
                        return Intrinsics.areEqual((Object)((FunctionAdapter)this).getFunctionDelegate(), (Object)((FunctionAdapter)var1_1).getFunctionDelegate());
                    }
                    return false;
                }
                return false;
            }

            public final int hashCode() {
                return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
            }
        });
        object = eL.d;
        objectArray[1] = ((fb_0)object).e.a((EX)new FunctionAdapter(eL){
            private /* synthetic */ EL a;
            {
                this.a = eL;
            }

            /*
             * WARNING - void declaration
             */
            public final void handlePacket(EZ p0) {
                void var1_1;
                Intrinsics.checkNotNullParameter((Object)p0, (String)"");
                EL.b(this.a, (EZ)var1_1);
            }

            public final Function<?> getFunctionDelegate() {
                return (Function)new FunctionReferenceImpl(1, (Object)this.a, EL.class, "onPhysEntityTransform", "onPhysEntityTransform(Lorg/valkyrienskies/core/impl/networking/Packet;)V", 0);
            }

            /*
             * WARNING - void declaration
             */
            public final boolean equals(Object other) {
                if (other instanceof EX) {
                    if (other instanceof FunctionAdapter) {
                        void var1_1;
                        return Intrinsics.areEqual((Object)((FunctionAdapter)this).getFunctionDelegate(), (Object)((FunctionAdapter)var1_1).getFunctionDelegate());
                    }
                    return false;
                }
                return false;
            }

            public final int hashCode() {
                return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
            }
        });
        object = eL.d;
        objectArray[2] = ((fb_0)object).c.a((EX)new FunctionAdapter(eL){
            private /* synthetic */ EL a;
            {
                this.a = eL;
            }

            /*
             * WARNING - void declaration
             */
            public final void handlePacket(EZ p0) {
                void var1_1;
                Intrinsics.checkNotNullParameter((Object)p0, (String)"");
                EL.c(this.a, (EZ)var1_1);
            }

            public final Function<?> getFunctionDelegate() {
                return (Function)new FunctionReferenceImpl(1, (Object)this.a, EL.class, "onShipDataDelta", "onShipDataDelta(Lorg/valkyrienskies/core/impl/networking/Packet;)V", 0);
            }

            /*
             * WARNING - void declaration
             */
            public final boolean equals(Object other) {
                if (other instanceof EX) {
                    if (other instanceof FunctionAdapter) {
                        void var1_1;
                        return Intrinsics.areEqual((Object)((FunctionAdapter)this).getFunctionDelegate(), (Object)((FunctionAdapter)var1_1).getFunctionDelegate());
                    }
                    return false;
                }
                return false;
            }

            public final int hashCode() {
                return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
            }
        });
        objectArray[3] = eL.c.registerClientHandler(Reflection.getOrCreateKotlinClass(PacketShipDataCreate.class), (Function1)new Function1<PacketShipDataCreate, Unit>(eL){

            private void a(PacketShipDataCreate packetShipDataCreate) {
                Intrinsics.checkNotNullParameter((Object)packetShipDataCreate, (String)"");
                EL.a((EL)this.receiver, packetShipDataCreate);
            }

            public final /* synthetic */ Object invoke(Object p1) {
                EL.k k2;
                PacketShipDataCreate packetShipDataCreate = (PacketShipDataCreate)((Object)k2);
                k2 = this;
                Intrinsics.checkNotNullParameter((Object)packetShipDataCreate, (String)"");
                EL.a((EL)k2.receiver, packetShipDataCreate);
                return Unit.INSTANCE;
            }
        });
        objectArray[4] = eL.c.registerClientHandler(Reflection.getOrCreateKotlinClass(PacketShipRemove.class), (Function1)new Function1<PacketShipRemove, Unit>(eL){

            private void a(PacketShipRemove packetShipRemove) {
                Intrinsics.checkNotNullParameter((Object)packetShipRemove, (String)"");
                EL.a((EL)this.receiver, packetShipRemove);
            }

            public final /* synthetic */ Object invoke(Object p1) {
                EL.l l2;
                PacketShipRemove packetShipRemove = (PacketShipRemove)((Object)l2);
                l2 = this;
                Intrinsics.checkNotNullParameter((Object)packetShipRemove, (String)"");
                EL.a((EL)l2.receiver, packetShipRemove);
                return Unit.INSTANCE;
            }
        });
        objectArray[5] = eL.c.registerClientHandler(Reflection.getOrCreateKotlinClass(PacketPhysEntityCreate.class), (Function1)new Function1<PacketPhysEntityCreate, Unit>(eL){

            private void a(PacketPhysEntityCreate packetPhysEntityCreate) {
                Intrinsics.checkNotNullParameter((Object)packetPhysEntityCreate, (String)"");
                EL.a((EL)this.receiver, packetPhysEntityCreate);
            }

            public final /* synthetic */ Object invoke(Object p1) {
                EL.m m2;
                PacketPhysEntityCreate packetPhysEntityCreate = (PacketPhysEntityCreate)((Object)m2);
                m2 = this;
                Intrinsics.checkNotNullParameter((Object)packetPhysEntityCreate, (String)"");
                EL.a((EL)m2.receiver, packetPhysEntityCreate);
                return Unit.INSTANCE;
            }
        });
        objectArray[6] = eL.c.registerClientHandler(Reflection.getOrCreateKotlinClass(PacketPhysEntityRemove.class), (Function1)new Function1<PacketPhysEntityRemove, Unit>(eL){

            private void a(PacketPhysEntityRemove packetPhysEntityRemove) {
                Intrinsics.checkNotNullParameter((Object)packetPhysEntityRemove, (String)"");
                EL.a((EL)this.receiver, packetPhysEntityRemove);
            }

            public final /* synthetic */ Object invoke(Object p1) {
                EL.n n2;
                PacketPhysEntityRemove packetPhysEntityRemove = (PacketPhysEntityRemove)((Object)n2);
                n2 = this;
                Intrinsics.checkNotNullParameter((Object)packetPhysEntityRemove, (String)"");
                EL.a((EL)n2.receiver, packetPhysEntityRemove);
                return Unit.INSTANCE;
            }
        });
        this.networkManager.e = CollectionsKt.listOf((Object[])objectArray);
        object = eL.b;
        ((fi_0)object).b.b();
        object = eL.b;
        ((fi_0)object).a.b();
    }

    @Override
    @JvmName(name="getAllShips")
    public final VsiQueryableShipData<ep_0> getAllShips() {
        return ((et_0)this).getLoadedShips();
    }

    @JvmName(name="getPhysicsEntities")
    public final Map<Long, PhysicsEntityClient> getPhysicsEntities() {
        return this._physicsEntities;
    }

    @Override
    @JvmName(name="isSyncedWithServer")
    public final boolean isSyncedWithServer() {
        EL eL = this.networkManager;
        return eL.g;
    }

    @Override
    @JvmName(name="getLoadedShips")
    public final VsiQueryableShipData<ep_0> getLoadedShips() {
        return this._loadedShips;
    }

    @Override
    public final void addTerrainUpdates(String dimensionId, List<? extends VsiTerrainUpdate> terrainUpdates) {
        Object object;
        Object object2;
        Object object3;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter(terrainUpdates, (String)"");
        object3 = (Iterable)object3;
        Iterator iterator2 = object3;
        object3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object3, (int)10));
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object2 = iterator2.next();
            object = (VsiTerrainUpdate)object2;
            object2 = object3;
            Intrinsics.checkNotNull((Object)object);
            object = (ET)object;
            object2.add((il_0)((ET)object).a);
        }
        object3 = (List)object3;
        object3 = (Iterable)object3;
        iterator2 = object3.iterator();
        while (iterator2.hasNext()) {
            object3 = iterator2.next();
            object3 = (il_0)object3;
            if ((ep_0)((et_0)this).getAllShips().getByChunkPos(object3.a(), object3.c(), dimensionId) == null) continue;
            object = object3;
            if (object instanceof ij_0 ? true : object instanceof ik_0) {
                this.connectivityHandler.a(dimensionId, object3.a(), object3.b(), object3.c(), ((eo_0)object2).getId(), (il_0)object3);
                continue;
            }
            if (!(object instanceof ii_0)) continue;
            this.connectivityHandler.a(dimensionId, object3.a(), object3.b(), object3.c());
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void addDimension(String dimensionId, LevelYRange yRange, Vector3dc gravity, double seaLevel, double maxY) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)yRange, (String)"");
        Intrinsics.checkNotNullParameter((Object)gravity, (String)"");
        this.dimensionInfo.put(dimensionId, new DP((String)var1_1, (LevelYRange)var2_2, new Vector3d((Vector3dc)var3_3)));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void updateDimension(String dimensionId, Vector3dc gravity, Double seaLevel, Double maxY) {
        void var1_1;
        DP dP;
        DP dP2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)gravity, (String)"");
        DP dP3 = this.dimensionInfo.get(dimensionId);
        if (dP3 == null) {
            return;
        }
        DP dP4 = dP2 = dP3;
        DP dP5 = dP4;
        dP5 = dP2;
        dP = new DP(dP4.a, dP5.b, (Vector3dc)((Object)dP));
        this.dimensionInfo.put((String)var1_1, dP);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void removeDimension(String dimensionId) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        this.dimensionInfo.remove(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void onSetBlock(int posX, int posY, int posZ, String dimensionId, VsiBlockType oldBlockType, VsiBlockType newBlockType, double oldBlockMass, double newBlockMass) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)oldBlockType, (String)"");
        Intrinsics.checkNotNullParameter((Object)newBlockType, (String)"");
        super.onSetBlock(posX, posY, posZ, dimensionId, oldBlockType, newBlockType, oldBlockMass, newBlockMass);
        if (!Intrinsics.areEqual((Object)oldBlockType, (Object)newBlockType) && this.dimensionInfo.get(dimensionId) != null) {
            void var3_3;
            void var2_2;
            void var1_1;
            Object object = new Vector3i(posX >> 4, posY >> 4, posZ >> 4);
            object = (ep_0)((et_0)this).getAllShips().getByChunkPos(object.x(), object.z(), dimensionId);
            object = object != null ? Long.valueOf(((eo_0)object).getId()) : null;
            if (object == null) {
                return;
            }
            VsiBlockType vsiBlockType = newBlockType;
            int n2 = Intrinsics.areEqual((Object)vsiBlockType, (Object)this.blockTypes.getAir()) ? 0 : ((Intrinsics.areEqual((Object)vsiBlockType, (Object)this.blockTypes.getWater()) ? true : Intrinsics.areEqual((Object)vsiBlockType, (Object)this.blockTypes.getLava())) ? 2 : 1);
            this.connectivityHandler.a(dimensionId, (Long)object, (int)var1_1, (int)var2_2, (int)var3_3, n2);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ConnectionStatus isConnectedByAir(int x1, int y1, int z1, int x2, int y2, int z2, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.connectivityHandler.a(dimension, (int)var1_1, (int)var2_2, (int)var3_3, x2, y2, z2, 0);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ConnectionStatus isConnectedBySolid(int x1, int y1, int z1, int x2, int y2, int z2, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.connectivityHandler.a(dimension, (int)var1_1, (int)var2_2, (int)var3_3, x2, y2, z2, 1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ConnectionStatus isIsolatedAir(int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.connectivityHandler.a(dimension, (int)var1_1, (int)var2_2, (int)var3_3, 0);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ConnectionStatus isIsolatedSolid(int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.connectivityHandler.a(dimension, (int)var1_1, (int)var2_2, (int)var3_3, 1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final long getSolidComponentSize(int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.connectivityHandler.a((int)var1_1, (int)var2_2, (int)var3_3, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void traverseSolidComponent(int x, int y, int z, Function4<? super Integer, ? super Integer, ? super Integer, ? super Long, Unit> action, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter(action, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        this.connectivityHandler.a((int)var1_1, (int)var2_2, (int)var3_3, action, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Set<Vector3ic> getAllSolidComponentsFromClaim(String dimensionId, ChunkClaim chunkClaim) {
        void var1_1;
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
        return this.connectivityHandler.a((ChunkClaim)var2_2, (String)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final long getAirComponentSize(int x, int y, int z, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        return this.connectivityHandler.b((int)var1_1, (int)var2_2, (int)var3_3, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void traverseAirComponent(int x, int y, int z, Function4<? super Integer, ? super Integer, ? super Integer, ? super Long, Unit> action, String dimension) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter(action, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        this.connectivityHandler.b((int)var1_1, (int)var2_2, (int)var3_3, action, dimension);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Set<Vector3ic> getAllAirComponentsFromClaim(String dimensionId, ChunkClaim chunkClaim) {
        void var1_1;
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
        return this.connectivityHandler.b((ChunkClaim)var2_2, (String)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ShipTransform getPhysEntityClientRenderTransform(long id) {
        void var1_1;
        PhysicsEntityClient physicsEntityClient = this.getPhysicsEntities().get((long)var1_1);
        if (physicsEntityClient != null) {
            return physicsEntityClient.getRenderTransform();
        }
        return null;
    }

    public final void addShip(ShipDataCommon ship) {
        ep_0 ep_02;
        Intrinsics.checkNotNullParameter((Object)ship, (String)"");
        ep_02 = new ep_0((ShipDataCommon)((Object)ep_02), null, 2, null);
        this._loadedShips.add((ep_0)((Ship)ep_02));
        VSEvents.INSTANCE.getShipLoadEventClient().emit(new VSEvents.ShipLoadEventClient(ep_02));
    }

    /*
     * WARNING - void declaration
     */
    public final void removeShip(long shipId) {
        try {
            void var1_1;
            ep_0 ep_02 = this._loadedShips.remove((long)var1_1);
            VSEvents.INSTANCE.getShipUnloadEventClient().emit(new VSEvents.ShipUnloadEventClient(ep_02));
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    public final void addPhysicsEntity(PhysEntityCreateData physicsEntityCreateData) {
        PhysicsEntityClient physicsEntityClient;
        Intrinsics.checkNotNullParameter((Object)physicsEntityCreateData, (String)"");
        physicsEntityClient = new PhysicsEntityClient(physicsEntityCreateData.getId(), physicsEntityCreateData.getDimensionId(), physicsEntityCreateData.getShipTransform(), physicsEntityCreateData.getShipTransform(), ((PhysEntityCreateData)((Object)physicsEntityClient)).getCollisionShapeData());
        this._physicsEntities.put(physicsEntityClient.getId(), physicsEntityClient);
    }

    /*
     * WARNING - void declaration
     */
    public final void removePhysicsEntity(long shipId) {
        void var1_1;
        this._physicsEntities.remove((long)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void tickNetworking(SocketAddress server) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)server, (String)"");
        this.networkManager.a((SocketAddress)var1_1);
    }

    @Override
    public final void postTick() {
        Object object;
        super.preTick();
        Iterator iterator2 = ((et_0)this).getLoadedShips();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            BodyTransform bodyTransform;
            object = iterator2.next();
            ep_0 ep_02 = (ep_0)object;
            object = ep_02;
            object = ep_02;
            ep_02.b = ((ep_0)object).e;
            ClientShipTransformProvider clientShipTransformProvider = ((ep_0)object).getTransformProvider();
            if (clientShipTransformProvider != null) {
                ShipTransform shipTransform = ((eo_0)object).getPrevTickTransform();
                ShipTransform shipTransform2 = ((eo_0)object).a().getTransform();
                BodyTransform bodyTransform2 = ((ep_0)object).b.getTransform();
                Intrinsics.checkNotNull((Object)bodyTransform2);
                bodyTransform = clientShipTransformProvider.provideNextTransform(shipTransform, shipTransform2, (ShipTransform)bodyTransform2);
            } else {
                bodyTransform = null;
            }
            BodyTransform bodyTransform3 = bodyTransform;
            BodyTransform bodyTransform4 = bodyTransform;
            if (bodyTransform == null) {
                ShipTransform shipTransform = ((eo_0)object).getPrevTickTransform();
                ShipTransform shipTransform3 = ((eo_0)object).a().getTransform();
                BodyTransform bodyTransform5 = ((ep_0)object).b.getTransform();
                Intrinsics.checkNotNull((Object)bodyTransform5);
                bodyTransform4 = eg_0.a(shipTransform, shipTransform3, (ShipTransform)bodyTransform5);
            }
            bodyTransform3 = bodyTransform4;
            ((eo_0)object).a().updatePrevTickShipTransform();
            ((eo_0)object).a().setKinematics(((ep_0)object).e.withTransform(bodyTransform3));
        }
        iterator2 = this.getPhysicsEntities().values();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next();
            object = (PhysicsEntityClient)object;
            ((PhysicsEntityClient)object).tickUpdateShipTransform();
        }
    }

    @Override
    public final void updateRenderTransforms(double partialTicks) {
        Object object;
        VSEvents.INSTANCE.getStartUpdateRenderTransformsEvent().emit(new VSEvents.StartUpdateRenderTransformsEvent(this));
        Iterator iterator2 = ((et_0)this).getLoadedShips();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next();
            ep_0 ep_02 = (ep_0)object;
            object = ep_02;
            double d2 = partialTicks;
            object = ep_02;
            ClientShipTransformProvider clientShipTransformProvider = ep_02.getTransformProvider();
            BodyTransform bodyTransform = clientShipTransformProvider != null ? clientShipTransformProvider.provideNextRenderTransform(((eo_0)object).a().getPrevTickTransform(), ((eo_0)object).a().getTransform(), d2) : null;
            BodyTransform bodyTransform2 = bodyTransform;
            if (bodyTransform2 == null) {
                bodyTransform2 = eg_0.a(((eo_0)object).a().getPrevTickTransform(), ((eo_0)object).a().getTransform(), d2);
            }
            Intrinsics.checkNotNull((Object)bodyTransform2);
            ((ep_0)object).c = (ShipTransform)bodyTransform2;
            Object object2 = ((eo_0)object).a().getShipAABB();
            bodyTransform = object2 != null && (object2 = AABBdUtilKt.toAABBd((AABBic)object2, new AABBd())) != null ? ((AABBd)object2).transform(((ep_0)object).getRenderTransform().getShipToWorld(), new AABBd()) : null;
            ((ep_0)object).d = bodyTransform == null ? ((ep_0)object).getRenderTransform().createEmptyAABB() : (AABBdc)((Object)bodyTransform);
        }
        iterator2 = this.getPhysicsEntities().values();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next();
            object = (PhysicsEntityClient)object;
            ((PhysicsEntityClient)object).updateRenderShipTransform(partialTicks);
        }
    }

    @Override
    public final void destroyWorld() {
        EL eL = this.networkManager;
        List<? extends RegisteredListener> list = eL.e;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            list = null;
        }
        Object object = list;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            object2 = (RegisteredListener)object2;
            object2.unregister();
        }
        eL.f = null;
        object = eL.b;
        ((fi_0)object).b.c();
        object = eL.b;
        ((fi_0)object).a.c();
    }
}


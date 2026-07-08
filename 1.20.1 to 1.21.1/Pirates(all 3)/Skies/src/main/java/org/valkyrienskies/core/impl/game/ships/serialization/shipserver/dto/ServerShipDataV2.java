/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto;

import com.fasterxml.jackson.databind.JsonNode;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.impl.game.ships.ShipPhysicsData;
import org.valkyrienskies.core.impl.game.ships.serialization.shipinertia.dto.ShipInertiaDataV0;
import org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.dto.ShipTransformDataV0;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001By\u0012\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\t\u001a\u00060\u0007j\u0002`\b\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u00107\u001a\u00020(\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010.\u001a\u00020-\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b>\u0010?R\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0007\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00060\rj\u0002`\u000e8\u0007\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0007\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0007\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0017\u0010\u001c\u001a\u00020\u00078\u0007\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\fR\u0017\u0010\u001f\u001a\u00020\u001e8\u0007\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010$\u001a\u00020#8\u0007\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010)\u001a\u00020(8\u0007\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010.\u001a\u00020-8\u0007\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00103\u001a\u0002028\u0007\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u00107\u001a\u00020(8\u0007\u00a2\u0006\f\n\u0004\b7\u0010*\u001a\u0004\b8\u0010,R\u0019\u0010:\u001a\u0004\u0018\u0001098\u0007\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010="}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV2;", "", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "chunkClaim", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "getChunkClaim", "()Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "chunkClaimDimension", "Ljava/lang/String;", "getChunkClaimDimension", "()Ljava/lang/String;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "id", "J", "getId", "()J", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "inertiaData", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "getInertiaData", "()Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "", "isStatic", "Z", "()Z", "name", "getName", "Lcom/fasterxml/jackson/databind/JsonNode;", "persistentAttachedData", "Lcom/fasterxml/jackson/databind/JsonNode;", "getPersistentAttachedData", "()Lcom/fasterxml/jackson/databind/JsonNode;", "Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;", "physicsData", "Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;", "getPhysicsData", "()Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "prevTickShipTransform", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "getPrevTickShipTransform", "()Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "Lorg/joml/primitives/AABBdc;", "shipAABB", "Lorg/joml/primitives/AABBdc;", "getShipAABB", "()Lorg/joml/primitives/AABBdc;", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "shipActiveChunksSet", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "getShipActiveChunksSet", "()Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "shipTransform", "getShipTransform", "Lorg/joml/primitives/AABBic;", "shipVoxelAABB", "Lorg/joml/primitives/AABBic;", "getShipVoxelAABB", "()Lorg/joml/primitives/AABBic;", "<init>", "(JLjava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;Ljava/lang/String;Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;Lorg/joml/primitives/AABBdc;Lorg/joml/primitives/AABBic;Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;ZLcom/fasterxml/jackson/databind/JsonNode;)V"})
public final class ServerShipDataV2 {
    private final long id;
    private final String name;
    private final ChunkClaim chunkClaim;
    private final String chunkClaimDimension;
    private final ShipPhysicsData physicsData;
    private final ShipInertiaDataV0 inertiaData;
    private final ShipTransformDataV0 shipTransform;
    private final ShipTransformDataV0 prevTickShipTransform;
    private final AABBdc shipAABB;
    private final AABBic shipVoxelAABB;
    private final IShipActiveChunksSet shipActiveChunksSet;
    private final boolean isStatic;
    private final JsonNode persistentAttachedData;

    /*
     * WARNING - void declaration
     */
    public ServerShipDataV2(long id, String name, ChunkClaim chunkClaim, String chunkClaimDimension, ShipPhysicsData physicsData, ShipInertiaDataV0 inertiaData, ShipTransformDataV0 shipTransform, ShipTransformDataV0 prevTickShipTransform, AABBdc shipAABB, AABBic shipVoxelAABB, IShipActiveChunksSet shipActiveChunksSet, boolean isStatic, JsonNode persistentAttachedData) {
        void var3_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)name, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkClaimDimension, (String)"");
        Intrinsics.checkNotNullParameter((Object)physicsData, (String)"");
        Intrinsics.checkNotNullParameter((Object)inertiaData, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"");
        Intrinsics.checkNotNullParameter((Object)prevTickShipTransform, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipAABB, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipActiveChunksSet, (String)"");
        Intrinsics.checkNotNullParameter((Object)persistentAttachedData, (String)"");
        this.id = var1_1;
        this.name = var3_2;
        this.chunkClaim = chunkClaim;
        this.chunkClaimDimension = chunkClaimDimension;
        this.physicsData = physicsData;
        this.inertiaData = inertiaData;
        this.shipTransform = shipTransform;
        this.prevTickShipTransform = prevTickShipTransform;
        this.shipAABB = shipAABB;
        this.shipVoxelAABB = shipVoxelAABB;
        this.shipActiveChunksSet = shipActiveChunksSet;
        this.isStatic = isStatic;
        this.persistentAttachedData = persistentAttachedData;
    }

    @JvmName(name="getId")
    public final long getId() {
        return this.id;
    }

    @JvmName(name="getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name="getChunkClaim")
    public final ChunkClaim getChunkClaim() {
        return this.chunkClaim;
    }

    @JvmName(name="getChunkClaimDimension")
    public final String getChunkClaimDimension() {
        return this.chunkClaimDimension;
    }

    @JvmName(name="getPhysicsData")
    public final ShipPhysicsData getPhysicsData() {
        return this.physicsData;
    }

    @JvmName(name="getInertiaData")
    public final ShipInertiaDataV0 getInertiaData() {
        return this.inertiaData;
    }

    @JvmName(name="getShipTransform")
    public final ShipTransformDataV0 getShipTransform() {
        return this.shipTransform;
    }

    @JvmName(name="getPrevTickShipTransform")
    public final ShipTransformDataV0 getPrevTickShipTransform() {
        return this.prevTickShipTransform;
    }

    @JvmName(name="getShipAABB")
    public final AABBdc getShipAABB() {
        return this.shipAABB;
    }

    @JvmName(name="getShipVoxelAABB")
    public final AABBic getShipVoxelAABB() {
        return this.shipVoxelAABB;
    }

    @JvmName(name="getShipActiveChunksSet")
    public final IShipActiveChunksSet getShipActiveChunksSet() {
        return this.shipActiveChunksSet;
    }

    @JvmName(name="isStatic")
    public final boolean isStatic() {
        return this.isStatic;
    }

    @JvmName(name="getPersistentAttachedData")
    public final JsonNode getPersistentAttachedData() {
        return this.persistentAttachedData;
    }
}


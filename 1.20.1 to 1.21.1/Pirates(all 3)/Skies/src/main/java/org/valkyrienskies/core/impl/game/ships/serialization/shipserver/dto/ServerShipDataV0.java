/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.impl.game.ships.ShipPhysicsData;
import org.valkyrienskies.core.impl.game.ships.serialization.shipinertia.dto.ShipInertiaDataV0;
import org.valkyrienskies.core.impl.game.ships.serialization.shipserver.dto.ShipDataCommon;
import org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.dto.ShipTransformDataV0;
import org.valkyrienskies.core.impl.shadow.GF;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001Bs\u0012\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\u0010\u001a\u001a\u00060\u0015j\u0002`\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010%\u001a\u00020$\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b&\u0010'R\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u0006*\u00020\r0\r8\u0007\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV0;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ShipDataCommon;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "inertiaData", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "getInertiaData", "()Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "", "isStatic", "Z", "()Z", "setStatic", "(Z)V", "Lcom/fasterxml/jackson/databind/node/ObjectNode;", "persistentAttachedData", "Lcom/fasterxml/jackson/databind/node/ObjectNode;", "getPersistentAttachedData", "()Lcom/fasterxml/jackson/databind/node/ObjectNode;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "id", "", "name", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "chunkClaim", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "chunkClaimDimension", "Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;", "physicsData", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "shipTransform", "prevTickShipTransform", "Lorg/joml/primitives/AABBdc;", "shipAABB", "Lorg/joml/primitives/AABBic;", "shipVoxelAABB", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "shipActiveChunksSet", "<init>", "(JLjava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;Ljava/lang/String;Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;Lorg/joml/primitives/AABBdc;Lorg/joml/primitives/AABBic;Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;Z)V"})
public final class ServerShipDataV0
extends ShipDataCommon {
    @GF
    private final ShipInertiaDataV0 inertiaData;
    private boolean isStatic;
    private final ObjectNode persistentAttachedData;

    /*
     * WARNING - void declaration
     */
    public ServerShipDataV0(long id, String name, ChunkClaim chunkClaim, String chunkClaimDimension, ShipPhysicsData physicsData, ShipInertiaDataV0 inertiaData, ShipTransformDataV0 shipTransform, ShipTransformDataV0 prevTickShipTransform, AABBdc shipAABB, AABBic shipVoxelAABB, IShipActiveChunksSet shipActiveChunksSet, boolean isStatic) {
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
        super((long)var1_1, (String)var3_2, chunkClaim, chunkClaimDimension, physicsData, shipTransform, prevTickShipTransform, shipAABB, shipVoxelAABB, shipActiveChunksSet);
        this.inertiaData = inertiaData;
        this.isStatic = isStatic;
        this.persistentAttachedData = JsonNodeFactory.instance.objectNode();
    }

    public /* synthetic */ ServerShipDataV0(long l2, String string, ChunkClaim chunkClaim, String string2, ShipPhysicsData shipPhysicsData, ShipInertiaDataV0 shipInertiaDataV0, ShipTransformDataV0 shipTransformDataV0, ShipTransformDataV0 shipTransformDataV02, AABBdc aABBdc, AABBic aABBic, IShipActiveChunksSet iShipActiveChunksSet, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 0x800) != 0) {
            bl = false;
        }
        this(l2, string, chunkClaim, string2, shipPhysicsData, shipInertiaDataV0, shipTransformDataV0, shipTransformDataV02, aABBdc, aABBic, iShipActiveChunksSet, bl);
    }

    @JvmName(name="getInertiaData")
    public final ShipInertiaDataV0 getInertiaData() {
        return this.inertiaData;
    }

    @JvmName(name="isStatic")
    public final boolean isStatic() {
        return this.isStatic;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setStatic")
    public final void setStatic(boolean bl) {
        void var1_1;
        this.isStatic = var1_1;
    }

    @JvmName(name="getPersistentAttachedData")
    public final ObjectNode getPersistentAttachedData() {
        return this.persistentAttachedData;
    }
}


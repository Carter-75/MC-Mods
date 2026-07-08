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

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\n\u0010'\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010(\u001a\u00020\u0012\u0012\u0006\u0010)\u001a\u00020\u0015\u0012\n\u0010*\u001a\u00060\u0012j\u0002`\u0018\u0012\u0006\u0010+\u001a\u00020\u001a\u0012\u0006\u0010,\u001a\u00020\u001d\u0012\u0006\u0010-\u001a\u00020 \u0012\u0006\u0010.\u001a\u00020 \u0012\u0006\u0010/\u001a\u00020$\u0012\b\u00100\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u00101\u001a\u00020\t\u0012\u0006\u00102\u001a\u00020\f\u0012\u0006\u00103\u001a\u00020\u000f\u00a2\u0006\u0004\bT\u0010UJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00c6\u0003\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015H\u00c6\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0019\u001a\u00060\u0012j\u0002`\u0018H\u00c6\u0003\u00a2\u0006\u0004\b\u0019\u0010\u0014J\u0010\u0010\u001b\u001a\u00020\u001aH\u00c6\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dH\u00c6\u0003\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 H\u00c6\u0003\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020 H\u00c6\u0003\u00a2\u0006\u0004\b#\u0010\"J\u0010\u0010%\u001a\u00020$H\u00c6\u0003\u00a2\u0006\u0004\b%\u0010&J\u009c\u0001\u00104\u001a\u00020\u00002\f\b\u0002\u0010'\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u0010)\u001a\u00020\u00152\f\b\u0002\u0010*\u001a\u00060\u0012j\u0002`\u00182\b\b\u0002\u0010+\u001a\u00020\u001a2\b\b\u0002\u0010,\u001a\u00020\u001d2\b\b\u0002\u0010-\u001a\u00020 2\b\b\u0002\u0010.\u001a\u00020 2\b\b\u0002\u0010/\u001a\u00020$2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u00102\u001a\u00020\f2\b\b\u0002\u00103\u001a\u00020\u000fH\u00c6\u0001\u00a2\u0006\u0004\b4\u00105J\u001a\u00107\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b7\u00108J\u0010\u0010:\u001a\u000209H\u00d6\u0001\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010<\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b<\u0010\u0014R\u001a\u0010)\u001a\u00020\u00158\u0007X\u0087\u0004\u00a2\u0006\f\n\u0004\b)\u0010=\u001a\u0004\b>\u0010\u0017R\u001b\u0010*\u001a\u00060\u0012j\u0002`\u00188\u0007\u00a2\u0006\f\n\u0004\b*\u0010?\u001a\u0004\b@\u0010\u0014R\u001b\u0010'\u001a\u00060\u0002j\u0002`\u00038\u0007\u00a2\u0006\f\n\u0004\b'\u0010A\u001a\u0004\bB\u0010\u0005R\u0017\u0010,\u001a\u00020\u001d8\u0007\u00a2\u0006\f\n\u0004\b,\u0010C\u001a\u0004\bD\u0010\u001fR\u0017\u00102\u001a\u00020\f8\u0007\u00a2\u0006\f\n\u0004\b2\u0010E\u001a\u0004\b2\u0010\u000eR\u0017\u0010(\u001a\u00020\u00128\u0007\u00a2\u0006\f\n\u0004\b(\u0010?\u001a\u0004\bF\u0010\u0014R\u0017\u00103\u001a\u00020\u000f8\u0007\u00a2\u0006\f\n\u0004\b3\u0010G\u001a\u0004\bH\u0010\u0011R\u0017\u0010+\u001a\u00020\u001a8\u0007\u00a2\u0006\f\n\u0004\b+\u0010I\u001a\u0004\bJ\u0010\u001cR\u0017\u0010.\u001a\u00020 8\u0007\u00a2\u0006\f\n\u0004\b.\u0010K\u001a\u0004\bL\u0010\"R\u0017\u0010/\u001a\u00020$8\u0007\u00a2\u0006\f\n\u0004\b/\u0010M\u001a\u0004\bN\u0010&R\u0017\u00101\u001a\u00020\t8\u0007\u00a2\u0006\f\n\u0004\b1\u0010O\u001a\u0004\bP\u0010\u000bR\u0017\u0010-\u001a\u00020 8\u0007\u00a2\u0006\f\n\u0004\b-\u0010K\u001a\u0004\bQ\u0010\"R\u0019\u00100\u001a\u0004\u0018\u00010\u00068\u0007\u00a2\u0006\f\n\u0004\b0\u0010R\u001a\u0004\bS\u0010\b"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV1;", "", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component1", "()J", "Lorg/joml/primitives/AABBic;", "component10", "()Lorg/joml/primitives/AABBic;", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "component11", "()Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "", "component12", "()Z", "Lcom/fasterxml/jackson/databind/JsonNode;", "component13", "()Lcom/fasterxml/jackson/databind/JsonNode;", "", "component2", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "component3", "()Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "component4", "Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;", "component5", "()Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "component6", "()Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "component7", "()Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "component8", "Lorg/joml/primitives/AABBdc;", "component9", "()Lorg/joml/primitives/AABBdc;", "id", "name", "chunkClaim", "chunkClaimDimension", "physicsData", "inertiaData", "shipTransform", "prevTickShipTransform", "shipAABB", "shipVoxelAABB", "shipActiveChunksSet", "isStatic", "persistentAttachedData", "copy", "(JLjava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;Ljava/lang/String;Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;Lorg/joml/primitives/AABBdc;Lorg/joml/primitives/AABBic;Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;ZLcom/fasterxml/jackson/databind/JsonNode;)Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV1;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "getChunkClaim", "Ljava/lang/String;", "getChunkClaimDimension", "J", "getId", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "getInertiaData", "Z", "getName", "Lcom/fasterxml/jackson/databind/JsonNode;", "getPersistentAttachedData", "Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;", "getPhysicsData", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "getPrevTickShipTransform", "Lorg/joml/primitives/AABBdc;", "getShipAABB", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "getShipActiveChunksSet", "getShipTransform", "Lorg/joml/primitives/AABBic;", "getShipVoxelAABB", "<init>", "(JLjava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;Ljava/lang/String;Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;Lorg/joml/primitives/AABBdc;Lorg/joml/primitives/AABBic;Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;ZLcom/fasterxml/jackson/databind/JsonNode;)V"})
public final class ServerShipDataV1 {
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
    public ServerShipDataV1(long id, String name, ChunkClaim chunkClaim, String chunkClaimDimension, ShipPhysicsData physicsData, ShipInertiaDataV0 inertiaData, ShipTransformDataV0 shipTransform, ShipTransformDataV0 prevTickShipTransform, AABBdc shipAABB, AABBic shipVoxelAABB, IShipActiveChunksSet shipActiveChunksSet, boolean isStatic, JsonNode persistentAttachedData) {
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

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final ChunkClaim component3() {
        return this.chunkClaim;
    }

    public final String component4() {
        return this.chunkClaimDimension;
    }

    public final ShipPhysicsData component5() {
        return this.physicsData;
    }

    public final ShipInertiaDataV0 component6() {
        return this.inertiaData;
    }

    public final ShipTransformDataV0 component7() {
        return this.shipTransform;
    }

    public final ShipTransformDataV0 component8() {
        return this.prevTickShipTransform;
    }

    public final AABBdc component9() {
        return this.shipAABB;
    }

    public final AABBic component10() {
        return this.shipVoxelAABB;
    }

    public final IShipActiveChunksSet component11() {
        return this.shipActiveChunksSet;
    }

    public final boolean component12() {
        return this.isStatic;
    }

    public final JsonNode component13() {
        return this.persistentAttachedData;
    }

    /*
     * WARNING - void declaration
     */
    public final ServerShipDataV1 copy(long id, String name, ChunkClaim chunkClaim, String chunkClaimDimension, ShipPhysicsData physicsData, ShipInertiaDataV0 inertiaData, ShipTransformDataV0 shipTransform, ShipTransformDataV0 prevTickShipTransform, AABBdc shipAABB, AABBic shipVoxelAABB, IShipActiveChunksSet shipActiveChunksSet, boolean isStatic, JsonNode persistentAttachedData) {
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
        return new ServerShipDataV1((long)var1_1, (String)var3_2, chunkClaim, chunkClaimDimension, physicsData, inertiaData, shipTransform, prevTickShipTransform, shipAABB, shipVoxelAABB, shipActiveChunksSet, isStatic, persistentAttachedData);
    }

    public static /* synthetic */ ServerShipDataV1 copy$default(ServerShipDataV1 serverShipDataV1, long l2, String string, ChunkClaim chunkClaim, String string2, ShipPhysicsData shipPhysicsData, ShipInertiaDataV0 shipInertiaDataV0, ShipTransformDataV0 shipTransformDataV0, ShipTransformDataV0 shipTransformDataV02, AABBdc aABBdc, AABBic aABBic, IShipActiveChunksSet iShipActiveChunksSet, boolean bl, JsonNode jsonNode, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = serverShipDataV1.id;
        }
        if ((n2 & 2) != 0) {
            string = serverShipDataV1.name;
        }
        if ((n2 & 4) != 0) {
            chunkClaim = serverShipDataV1.chunkClaim;
        }
        if ((n2 & 8) != 0) {
            string2 = serverShipDataV1.chunkClaimDimension;
        }
        if ((n2 & 0x10) != 0) {
            shipPhysicsData = serverShipDataV1.physicsData;
        }
        if ((n2 & 0x20) != 0) {
            shipInertiaDataV0 = serverShipDataV1.inertiaData;
        }
        if ((n2 & 0x40) != 0) {
            shipTransformDataV0 = serverShipDataV1.shipTransform;
        }
        if ((n2 & 0x80) != 0) {
            shipTransformDataV02 = serverShipDataV1.prevTickShipTransform;
        }
        if ((n2 & 0x100) != 0) {
            aABBdc = serverShipDataV1.shipAABB;
        }
        if ((n2 & 0x200) != 0) {
            aABBic = serverShipDataV1.shipVoxelAABB;
        }
        if ((n2 & 0x400) != 0) {
            iShipActiveChunksSet = serverShipDataV1.shipActiveChunksSet;
        }
        if ((n2 & 0x800) != 0) {
            bl = serverShipDataV1.isStatic;
        }
        if ((n2 & 0x1000) != 0) {
            jsonNode = serverShipDataV1.persistentAttachedData;
        }
        return serverShipDataV1.copy(l2, string, chunkClaim, string2, shipPhysicsData, shipInertiaDataV0, shipTransformDataV0, shipTransformDataV02, aABBdc, aABBic, iShipActiveChunksSet, bl, jsonNode);
    }

    public final String toString() {
        return "ServerShipDataV1(id=" + this.id + ", name=" + this.name + ", chunkClaim=" + this.chunkClaim + ", chunkClaimDimension=" + this.chunkClaimDimension + ", physicsData=" + this.physicsData + ", inertiaData=" + this.inertiaData + ", shipTransform=" + this.shipTransform + ", prevTickShipTransform=" + this.prevTickShipTransform + ", shipAABB=" + this.shipAABB + ", shipVoxelAABB=" + this.shipVoxelAABB + ", shipActiveChunksSet=" + this.shipActiveChunksSet + ", isStatic=" + this.isStatic + ", persistentAttachedData=" + this.persistentAttachedData + ")";
    }

    public final int hashCode() {
        int n2 = Long.hashCode(this.id);
        n2 = n2 * 31 + this.name.hashCode();
        n2 = n2 * 31 + this.chunkClaim.hashCode();
        n2 = n2 * 31 + this.chunkClaimDimension.hashCode();
        n2 = n2 * 31 + this.physicsData.hashCode();
        n2 = n2 * 31 + this.inertiaData.hashCode();
        n2 = n2 * 31 + this.shipTransform.hashCode();
        n2 = n2 * 31 + this.prevTickShipTransform.hashCode();
        n2 = n2 * 31 + this.shipAABB.hashCode();
        n2 = n2 * 31 + (this.shipVoxelAABB == null ? 0 : this.shipVoxelAABB.hashCode());
        n2 = n2 * 31 + this.shipActiveChunksSet.hashCode();
        n2 = n2 * 31 + Boolean.hashCode(this.isStatic);
        n2 = n2 * 31 + this.persistentAttachedData.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        ServerShipDataV1 serverShipDataV1;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerShipDataV1)) {
            return false;
        }
        serverShipDataV1 = serverShipDataV1;
        if (this.id != serverShipDataV1.id) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.name, (Object)serverShipDataV1.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.chunkClaim, (Object)serverShipDataV1.chunkClaim)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.chunkClaimDimension, (Object)serverShipDataV1.chunkClaimDimension)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.physicsData, (Object)serverShipDataV1.physicsData)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.inertiaData, (Object)serverShipDataV1.inertiaData)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.shipTransform, (Object)serverShipDataV1.shipTransform)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.prevTickShipTransform, (Object)serverShipDataV1.prevTickShipTransform)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.shipAABB, (Object)serverShipDataV1.shipAABB)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.shipVoxelAABB, (Object)serverShipDataV1.shipVoxelAABB)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.shipActiveChunksSet, (Object)serverShipDataV1.shipActiveChunksSet)) {
            return false;
        }
        if (this.isStatic != serverShipDataV1.isStatic) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.persistentAttachedData, (Object)serverShipDataV1.persistentAttachedData);
    }
}


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

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.impl.game.ships.ShipPhysicsData;
import org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.dto.ShipTransformDataV0;
import org.valkyrienskies.core.impl.shadow.GF;
import org.valkyrienskies.core.impl.shadow.gx_0;
import org.valkyrienskies.core.util.AABBdUtilKt;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001Be\u0012\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\t\u001a\u00060\u0007j\u0002`\b\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u00100\u001a\u00020 \u0012\b\b\u0002\u0010\"\u001a\u00020 \u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\u0006\u0010,\u001a\u00020+\u00a2\u0006\u0004\b=\u0010>R\u0017\u0010\u0003\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0007\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00060\rj\u0002`\u000e8\u0007\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00078\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u00178G\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u001b8\u0007X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020 8\u0007@BX\u0087\u000e\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R$\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020&8\u0007@BX\u0087\u000e\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010,\u001a\u00020+8\u0007\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R*\u00100\u001a\u00020 2\u0006\u00100\u001a\u00020 8\u0007@GX\u0087\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010#\u001a\u0004\b1\u0010%\"\u0004\b2\u00103R$\u00105\u001a\u0004\u0018\u0001048\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0011\u0010<\u001a\u00020\u00178G\u00a2\u0006\u0006\u001a\u0004\b;\u0010\u0019"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ShipDataCommon;", "", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "chunkClaim", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "getChunkClaim", "()Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "chunkClaimDimension", "Ljava/lang/String;", "getChunkClaimDimension", "()Ljava/lang/String;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "id", "J", "getId", "()J", "name", "getName", "setName", "(Ljava/lang/String;)V", "Lorg/joml/Vector3dc;", "getOmega", "()Lorg/joml/Vector3dc;", "omega", "Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;", "physicsData", "Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;", "getPhysicsData", "()Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "p0", "prevTickShipTransform", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "getPrevTickShipTransform", "()Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "Lorg/joml/primitives/AABBdc;", "shipAABB", "Lorg/joml/primitives/AABBdc;", "getShipAABB", "()Lorg/joml/primitives/AABBdc;", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "shipActiveChunksSet", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "getShipActiveChunksSet", "()Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "shipTransform", "getShipTransform", "setShipTransform", "(Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;)V", "Lorg/joml/primitives/AABBic;", "shipVoxelAABB", "Lorg/joml/primitives/AABBic;", "getShipVoxelAABB", "()Lorg/joml/primitives/AABBic;", "setShipVoxelAABB", "(Lorg/joml/primitives/AABBic;)V", "getVelocity", "velocity", "<init>", "(JLjava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;Ljava/lang/String;Lorg/valkyrienskies/core/impl/game/ships/ShipPhysicsData;Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;Lorg/joml/primitives/AABBdc;Lorg/joml/primitives/AABBic;Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;)V"})
public class ShipDataCommon {
    private final long id;
    private String name;
    private final ChunkClaim chunkClaim;
    private final String chunkClaimDimension;
    @gx_0
    private final ShipPhysicsData physicsData;
    private AABBic shipVoxelAABB;
    private final IShipActiveChunksSet shipActiveChunksSet;
    @gx_0
    private ShipTransformDataV0 shipTransform;
    @GF
    private ShipTransformDataV0 prevTickShipTransform;
    @gx_0
    private AABBdc shipAABB;

    /*
     * WARNING - void declaration
     */
    public ShipDataCommon(long id, String name, ChunkClaim chunkClaim, String chunkClaimDimension, ShipPhysicsData physicsData, ShipTransformDataV0 shipTransform, ShipTransformDataV0 prevTickShipTransform, AABBdc shipAABB, AABBic shipVoxelAABB, IShipActiveChunksSet shipActiveChunksSet) {
        void var3_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)name, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkClaimDimension, (String)"");
        Intrinsics.checkNotNullParameter((Object)physicsData, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"");
        Intrinsics.checkNotNullParameter((Object)prevTickShipTransform, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipAABB, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipActiveChunksSet, (String)"");
        this.id = var1_1;
        this.name = var3_2;
        this.chunkClaim = chunkClaim;
        this.chunkClaimDimension = chunkClaimDimension;
        this.physicsData = physicsData;
        this.shipVoxelAABB = shipVoxelAABB;
        this.shipActiveChunksSet = shipActiveChunksSet;
        this.shipTransform = shipTransform;
        this.prevTickShipTransform = prevTickShipTransform;
        this.shipAABB = shipAABB;
    }

    public /* synthetic */ ShipDataCommon(long l2, String string, ChunkClaim chunkClaim, String string2, ShipPhysicsData shipPhysicsData, ShipTransformDataV0 shipTransformDataV0, ShipTransformDataV0 shipTransformDataV02, AABBdc aABBdc, AABBic aABBic, IShipActiveChunksSet iShipActiveChunksSet, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 0x40) != 0) {
            shipTransformDataV02 = shipTransformDataV0;
        }
        if ((n2 & 0x80) != 0) {
            aABBdc = shipTransformDataV0.createEmptyAABB();
        }
        this(l2, string, chunkClaim, string2, shipPhysicsData, shipTransformDataV0, shipTransformDataV02, aABBdc, aABBic, iShipActiveChunksSet);
    }

    @JvmName(name="getId")
    public final long getId() {
        return this.id;
    }

    @JvmName(name="getName")
    public final String getName() {
        return this.name;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setName")
    public final void setName(String string) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        this.name = var1_1;
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

    @JvmName(name="getShipVoxelAABB")
    public final AABBic getShipVoxelAABB() {
        return this.shipVoxelAABB;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setShipVoxelAABB")
    public final void setShipVoxelAABB(AABBic aABBic) {
        void var1_1;
        this.shipVoxelAABB = var1_1;
    }

    @JvmName(name="getShipActiveChunksSet")
    public final IShipActiveChunksSet getShipActiveChunksSet() {
        return this.shipActiveChunksSet;
    }

    @JvmName(name="getVelocity")
    public final Vector3dc getVelocity() {
        return this.physicsData.getLinearVelocity();
    }

    @JvmName(name="getOmega")
    public final Vector3dc getOmega() {
        return this.physicsData.getAngularVelocity();
    }

    @JvmName(name="getShipTransform")
    public final ShipTransformDataV0 getShipTransform() {
        return this.shipTransform;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setShipTransform")
    public final void setShipTransform(ShipTransformDataV0 shipTransform) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"");
        this.shipTransform = shipTransform;
        Object object = this.shipVoxelAABB;
        AABBd aABBd = object != null && (object = AABBdUtilKt.toAABBd((AABBic)object, new AABBd())) != null ? ((AABBd)object).transform(shipTransform.getShipToWorldMatrix(), new AABBd()) : null;
        this.shipAABB = aABBd == null ? var1_1.createEmptyAABB() : (AABBdc)aABBd;
    }

    @JvmName(name="getPrevTickShipTransform")
    public final ShipTransformDataV0 getPrevTickShipTransform() {
        return this.prevTickShipTransform;
    }

    @JvmName(name="getShipAABB")
    public final AABBdc getShipAABB() {
        return this.shipAABB;
    }
}


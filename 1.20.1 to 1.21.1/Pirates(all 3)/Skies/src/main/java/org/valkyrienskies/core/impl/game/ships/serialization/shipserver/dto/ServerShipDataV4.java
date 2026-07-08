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
import org.joml.Vector3dc;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.impl.game.ships.serialization.shipinertia.dto.ShipInertiaDataV0;
import org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.dto.ShipTransformDataV0;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b5\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\u0010+\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010,\u001a\u00020\u0018\u0012\u0006\u0010-\u001a\u00020\u001b\u0012\n\u0010.\u001a\u00060\u0018j\u0002`\u001e\u0012\u0006\u0010/\u001a\u00020 \u0012\u0006\u00100\u001a\u00020 \u0012\u0006\u00101\u001a\u00020$\u0012\u0006\u00102\u001a\u00020'\u0012\u0006\u00103\u001a\u00020'\u0012\u0006\u00104\u001a\u00020\u0006\u0012\b\u00105\u001a\u0004\u0018\u00010\t\u0012\u0006\u00106\u001a\u00020\f\u0012\u0006\u00107\u001a\u00020\u000f\u0012\u0006\u00108\u001a\u00020\u0012\u0012\u0006\u00109\u001a\u00020\u0015\u00a2\u0006\u0004\b[\u0010\\J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00c6\u0003\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015H\u00c6\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018H\u00c6\u0003\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bH\u00c6\u0003\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u001f\u001a\u00060\u0018j\u0002`\u001eH\u00c6\u0003\u00a2\u0006\u0004\b\u001f\u0010\u001aJ\u0010\u0010!\u001a\u00020 H\u00c6\u0003\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020 H\u00c6\u0003\u00a2\u0006\u0004\b#\u0010\"J\u0010\u0010%\u001a\u00020$H\u00c6\u0003\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'H\u00c6\u0003\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020'H\u00c6\u0003\u00a2\u0006\u0004\b*\u0010)J\u00b0\u0001\u0010:\u001a\u00020\u00002\f\b\u0002\u0010+\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010,\u001a\u00020\u00182\b\b\u0002\u0010-\u001a\u00020\u001b2\f\b\u0002\u0010.\u001a\u00060\u0018j\u0002`\u001e2\b\b\u0002\u0010/\u001a\u00020 2\b\b\u0002\u00100\u001a\u00020 2\b\b\u0002\u00101\u001a\u00020$2\b\b\u0002\u00102\u001a\u00020'2\b\b\u0002\u00103\u001a\u00020'2\b\b\u0002\u00104\u001a\u00020\u00062\n\b\u0002\u00105\u001a\u0004\u0018\u00010\t2\b\b\u0002\u00106\u001a\u00020\f2\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u00122\b\b\u0002\u00109\u001a\u00020\u0015H\u00c6\u0001\u00a2\u0006\u0004\b:\u0010;J\u001a\u0010=\u001a\u00020\u000f2\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010?\u001a\u00020\u0015H\u00d6\u0001\u00a2\u0006\u0004\b?\u0010\u0017J\u0010\u0010@\u001a\u00020\u0018H\u00d6\u0001\u00a2\u0006\u0004\b@\u0010\u001aR\u001a\u00106\u001a\u00020\f8\u0007X\u0087\u0004\u00a2\u0006\f\n\u0004\b6\u0010A\u001a\u0004\bB\u0010\u000eR\u0017\u0010-\u001a\u00020\u001b8\u0007\u00a2\u0006\f\n\u0004\b-\u0010C\u001a\u0004\bD\u0010\u001dR\u001b\u0010.\u001a\u00060\u0018j\u0002`\u001e8\u0007\u00a2\u0006\f\n\u0004\b.\u0010E\u001a\u0004\bF\u0010\u001aR\u001b\u0010+\u001a\u00060\u0002j\u0002`\u00038\u0007\u00a2\u0006\f\n\u0004\b+\u0010G\u001a\u0004\bH\u0010\u0005R\u0017\u00101\u001a\u00020$8\u0007\u00a2\u0006\f\n\u0004\b1\u0010I\u001a\u0004\bJ\u0010&R\u0017\u00107\u001a\u00020\u000f8\u0007\u00a2\u0006\f\n\u0004\b7\u0010K\u001a\u0004\b7\u0010\u0011R\u0017\u0010,\u001a\u00020\u00188\u0007\u00a2\u0006\f\n\u0004\b,\u0010E\u001a\u0004\bL\u0010\u001aR\u0017\u00100\u001a\u00020 8\u0007\u00a2\u0006\f\n\u0004\b0\u0010M\u001a\u0004\bN\u0010\"R\u0017\u00108\u001a\u00020\u00128\u0007\u00a2\u0006\f\n\u0004\b8\u0010O\u001a\u0004\bP\u0010\u0014R\u0017\u00109\u001a\u00020\u00158\u0007\u00a2\u0006\f\n\u0004\b9\u0010Q\u001a\u0004\bR\u0010\u0017R\u0017\u00103\u001a\u00020'8\u0007\u00a2\u0006\f\n\u0004\b3\u0010S\u001a\u0004\bT\u0010)R\u0019\u00105\u001a\u0004\u0018\u00010\t8\u0007\u00a2\u0006\f\n\u0004\b5\u0010U\u001a\u0004\bV\u0010\u000bR\u0017\u00102\u001a\u00020'8\u0007\u00a2\u0006\f\n\u0004\b2\u0010S\u001a\u0004\bW\u0010)R\u0017\u0010/\u001a\u00020 8\u0007\u00a2\u0006\f\n\u0004\b/\u0010M\u001a\u0004\bX\u0010\"R\u0017\u00104\u001a\u00020\u00068\u0007\u00a2\u0006\f\n\u0004\b4\u0010Y\u001a\u0004\bZ\u0010\b"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV4;", "", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component1", "()J", "Lorg/joml/primitives/AABBdc;", "component10", "()Lorg/joml/primitives/AABBdc;", "Lorg/joml/primitives/AABBic;", "component11", "()Lorg/joml/primitives/AABBic;", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "component12", "()Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "", "component13", "()Z", "Lcom/fasterxml/jackson/databind/JsonNode;", "component14", "()Lcom/fasterxml/jackson/databind/JsonNode;", "", "component15", "()I", "", "component2", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "component3", "()Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "component4", "Lorg/joml/Vector3dc;", "component5", "()Lorg/joml/Vector3dc;", "component6", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "component7", "()Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "component8", "()Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "component9", "id", "name", "chunkClaim", "chunkClaimDimension", "velocity", "omega", "inertiaData", "transform", "prevTickTransform", "worldAABB", "shipAABB", "activeChunks", "isStatic", "persistentAttachedData", "portalCoolDown", "copy", "(JLjava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;Ljava/lang/String;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;Lorg/joml/primitives/AABBdc;Lorg/joml/primitives/AABBic;Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;ZLcom/fasterxml/jackson/databind/JsonNode;I)Lorg/valkyrienskies/core/impl/game/ships/serialization/shipserver/dto/ServerShipDataV4;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "getActiveChunks", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "getChunkClaim", "Ljava/lang/String;", "getChunkClaimDimension", "J", "getId", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "getInertiaData", "Z", "getName", "Lorg/joml/Vector3dc;", "getOmega", "Lcom/fasterxml/jackson/databind/JsonNode;", "getPersistentAttachedData", "I", "getPortalCoolDown", "Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "getPrevTickTransform", "Lorg/joml/primitives/AABBic;", "getShipAABB", "getTransform", "getVelocity", "Lorg/joml/primitives/AABBdc;", "getWorldAABB", "<init>", "(JLjava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;Ljava/lang/String;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;Lorg/joml/primitives/AABBdc;Lorg/joml/primitives/AABBic;Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;ZLcom/fasterxml/jackson/databind/JsonNode;I)V"})
public final class ServerShipDataV4 {
    private final long id;
    private final String name;
    private final ChunkClaim chunkClaim;
    private final String chunkClaimDimension;
    private final Vector3dc velocity;
    private final Vector3dc omega;
    private final ShipInertiaDataV0 inertiaData;
    private final ShipTransformDataV0 transform;
    private final ShipTransformDataV0 prevTickTransform;
    private final AABBdc worldAABB;
    private final AABBic shipAABB;
    private final IShipActiveChunksSet activeChunks;
    private final boolean isStatic;
    private final JsonNode persistentAttachedData;
    private final int portalCoolDown;

    /*
     * WARNING - void declaration
     */
    public ServerShipDataV4(long id, String name, ChunkClaim chunkClaim, String chunkClaimDimension, Vector3dc velocity, Vector3dc omega, ShipInertiaDataV0 inertiaData, ShipTransformDataV0 transform2, ShipTransformDataV0 prevTickTransform, AABBdc worldAABB, AABBic shipAABB, IShipActiveChunksSet activeChunks, boolean isStatic, JsonNode persistentAttachedData, int portalCoolDown) {
        void var3_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)name, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkClaimDimension, (String)"");
        Intrinsics.checkNotNullParameter((Object)velocity, (String)"");
        Intrinsics.checkNotNullParameter((Object)omega, (String)"");
        Intrinsics.checkNotNullParameter((Object)inertiaData, (String)"");
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
        Intrinsics.checkNotNullParameter((Object)prevTickTransform, (String)"");
        Intrinsics.checkNotNullParameter((Object)worldAABB, (String)"");
        Intrinsics.checkNotNullParameter((Object)activeChunks, (String)"");
        Intrinsics.checkNotNullParameter((Object)persistentAttachedData, (String)"");
        this.id = var1_1;
        this.name = var3_2;
        this.chunkClaim = chunkClaim;
        this.chunkClaimDimension = chunkClaimDimension;
        this.velocity = velocity;
        this.omega = omega;
        this.inertiaData = inertiaData;
        this.transform = transform2;
        this.prevTickTransform = prevTickTransform;
        this.worldAABB = worldAABB;
        this.shipAABB = shipAABB;
        this.activeChunks = activeChunks;
        this.isStatic = isStatic;
        this.persistentAttachedData = persistentAttachedData;
        this.portalCoolDown = portalCoolDown;
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

    @JvmName(name="getVelocity")
    public final Vector3dc getVelocity() {
        return this.velocity;
    }

    @JvmName(name="getOmega")
    public final Vector3dc getOmega() {
        return this.omega;
    }

    @JvmName(name="getInertiaData")
    public final ShipInertiaDataV0 getInertiaData() {
        return this.inertiaData;
    }

    @JvmName(name="getTransform")
    public final ShipTransformDataV0 getTransform() {
        return this.transform;
    }

    @JvmName(name="getPrevTickTransform")
    public final ShipTransformDataV0 getPrevTickTransform() {
        return this.prevTickTransform;
    }

    @JvmName(name="getWorldAABB")
    public final AABBdc getWorldAABB() {
        return this.worldAABB;
    }

    @JvmName(name="getShipAABB")
    public final AABBic getShipAABB() {
        return this.shipAABB;
    }

    @JvmName(name="getActiveChunks")
    public final IShipActiveChunksSet getActiveChunks() {
        return this.activeChunks;
    }

    @JvmName(name="isStatic")
    public final boolean isStatic() {
        return this.isStatic;
    }

    @JvmName(name="getPersistentAttachedData")
    public final JsonNode getPersistentAttachedData() {
        return this.persistentAttachedData;
    }

    @JvmName(name="getPortalCoolDown")
    public final int getPortalCoolDown() {
        return this.portalCoolDown;
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

    public final Vector3dc component5() {
        return this.velocity;
    }

    public final Vector3dc component6() {
        return this.omega;
    }

    public final ShipInertiaDataV0 component7() {
        return this.inertiaData;
    }

    public final ShipTransformDataV0 component8() {
        return this.transform;
    }

    public final ShipTransformDataV0 component9() {
        return this.prevTickTransform;
    }

    public final AABBdc component10() {
        return this.worldAABB;
    }

    public final AABBic component11() {
        return this.shipAABB;
    }

    public final IShipActiveChunksSet component12() {
        return this.activeChunks;
    }

    public final boolean component13() {
        return this.isStatic;
    }

    public final JsonNode component14() {
        return this.persistentAttachedData;
    }

    public final int component15() {
        return this.portalCoolDown;
    }

    /*
     * WARNING - void declaration
     */
    public final ServerShipDataV4 copy(long id, String name, ChunkClaim chunkClaim, String chunkClaimDimension, Vector3dc velocity, Vector3dc omega, ShipInertiaDataV0 inertiaData, ShipTransformDataV0 transform2, ShipTransformDataV0 prevTickTransform, AABBdc worldAABB, AABBic shipAABB, IShipActiveChunksSet activeChunks, boolean isStatic, JsonNode persistentAttachedData, int portalCoolDown) {
        void var3_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)name, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkClaimDimension, (String)"");
        Intrinsics.checkNotNullParameter((Object)velocity, (String)"");
        Intrinsics.checkNotNullParameter((Object)omega, (String)"");
        Intrinsics.checkNotNullParameter((Object)inertiaData, (String)"");
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
        Intrinsics.checkNotNullParameter((Object)prevTickTransform, (String)"");
        Intrinsics.checkNotNullParameter((Object)worldAABB, (String)"");
        Intrinsics.checkNotNullParameter((Object)activeChunks, (String)"");
        Intrinsics.checkNotNullParameter((Object)persistentAttachedData, (String)"");
        return new ServerShipDataV4((long)var1_1, (String)var3_2, chunkClaim, chunkClaimDimension, velocity, omega, inertiaData, transform2, prevTickTransform, worldAABB, shipAABB, activeChunks, isStatic, persistentAttachedData, portalCoolDown);
    }

    public static /* synthetic */ ServerShipDataV4 copy$default(ServerShipDataV4 serverShipDataV4, long l2, String string, ChunkClaim chunkClaim, String string2, Vector3dc vector3dc, Vector3dc vector3dc2, ShipInertiaDataV0 shipInertiaDataV0, ShipTransformDataV0 shipTransformDataV0, ShipTransformDataV0 shipTransformDataV02, AABBdc aABBdc, AABBic aABBic, IShipActiveChunksSet iShipActiveChunksSet, boolean bl, JsonNode jsonNode, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            l2 = serverShipDataV4.id;
        }
        if ((n3 & 2) != 0) {
            string = serverShipDataV4.name;
        }
        if ((n3 & 4) != 0) {
            chunkClaim = serverShipDataV4.chunkClaim;
        }
        if ((n3 & 8) != 0) {
            string2 = serverShipDataV4.chunkClaimDimension;
        }
        if ((n3 & 0x10) != 0) {
            vector3dc = serverShipDataV4.velocity;
        }
        if ((n3 & 0x20) != 0) {
            vector3dc2 = serverShipDataV4.omega;
        }
        if ((n3 & 0x40) != 0) {
            shipInertiaDataV0 = serverShipDataV4.inertiaData;
        }
        if ((n3 & 0x80) != 0) {
            shipTransformDataV0 = serverShipDataV4.transform;
        }
        if ((n3 & 0x100) != 0) {
            shipTransformDataV02 = serverShipDataV4.prevTickTransform;
        }
        if ((n3 & 0x200) != 0) {
            aABBdc = serverShipDataV4.worldAABB;
        }
        if ((n3 & 0x400) != 0) {
            aABBic = serverShipDataV4.shipAABB;
        }
        if ((n3 & 0x800) != 0) {
            iShipActiveChunksSet = serverShipDataV4.activeChunks;
        }
        if ((n3 & 0x1000) != 0) {
            bl = serverShipDataV4.isStatic;
        }
        if ((n3 & 0x2000) != 0) {
            jsonNode = serverShipDataV4.persistentAttachedData;
        }
        if ((n3 & 0x4000) != 0) {
            n2 = serverShipDataV4.portalCoolDown;
        }
        return serverShipDataV4.copy(l2, string, chunkClaim, string2, vector3dc, vector3dc2, shipInertiaDataV0, shipTransformDataV0, shipTransformDataV02, aABBdc, aABBic, iShipActiveChunksSet, bl, jsonNode, n2);
    }

    public final String toString() {
        return "ServerShipDataV4(id=" + this.id + ", name=" + this.name + ", chunkClaim=" + this.chunkClaim + ", chunkClaimDimension=" + this.chunkClaimDimension + ", velocity=" + this.velocity + ", omega=" + this.omega + ", inertiaData=" + this.inertiaData + ", transform=" + this.transform + ", prevTickTransform=" + this.prevTickTransform + ", worldAABB=" + this.worldAABB + ", shipAABB=" + this.shipAABB + ", activeChunks=" + this.activeChunks + ", isStatic=" + this.isStatic + ", persistentAttachedData=" + this.persistentAttachedData + ", portalCoolDown=" + this.portalCoolDown + ")";
    }

    public final int hashCode() {
        int n2 = Long.hashCode(this.id);
        n2 = n2 * 31 + this.name.hashCode();
        n2 = n2 * 31 + this.chunkClaim.hashCode();
        n2 = n2 * 31 + this.chunkClaimDimension.hashCode();
        n2 = n2 * 31 + this.velocity.hashCode();
        n2 = n2 * 31 + this.omega.hashCode();
        n2 = n2 * 31 + this.inertiaData.hashCode();
        n2 = n2 * 31 + this.transform.hashCode();
        n2 = n2 * 31 + this.prevTickTransform.hashCode();
        n2 = n2 * 31 + this.worldAABB.hashCode();
        n2 = n2 * 31 + (this.shipAABB == null ? 0 : this.shipAABB.hashCode());
        n2 = n2 * 31 + this.activeChunks.hashCode();
        n2 = n2 * 31 + Boolean.hashCode(this.isStatic);
        n2 = n2 * 31 + this.persistentAttachedData.hashCode();
        n2 = n2 * 31 + Integer.hashCode(this.portalCoolDown);
        return n2;
    }

    public final boolean equals(Object other) {
        ServerShipDataV4 serverShipDataV4;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerShipDataV4)) {
            return false;
        }
        serverShipDataV4 = serverShipDataV4;
        if (this.id != serverShipDataV4.id) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.name, (Object)serverShipDataV4.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.chunkClaim, (Object)serverShipDataV4.chunkClaim)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.chunkClaimDimension, (Object)serverShipDataV4.chunkClaimDimension)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.velocity, (Object)serverShipDataV4.velocity)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.omega, (Object)serverShipDataV4.omega)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.inertiaData, (Object)serverShipDataV4.inertiaData)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.transform, (Object)serverShipDataV4.transform)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.prevTickTransform, (Object)serverShipDataV4.prevTickTransform)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.worldAABB, (Object)serverShipDataV4.worldAABB)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.shipAABB, (Object)serverShipDataV4.shipAABB)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.activeChunks, (Object)serverShipDataV4.activeChunks)) {
            return false;
        }
        if (this.isStatic != serverShipDataV4.isStatic) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.persistentAttachedData, (Object)serverShipDataV4.persistentAttachedData)) {
            return false;
        }
        return this.portalCoolDown == serverShipDataV4.portalCoolDown;
    }
}


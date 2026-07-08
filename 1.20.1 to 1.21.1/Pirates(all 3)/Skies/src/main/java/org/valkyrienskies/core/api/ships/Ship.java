/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.ships;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4dc;
import org.joml.Vector3dc;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.api.util.Identified;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0012\u001a\u00060\u000ej\u0002`\u000f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0017\u001a\u00060\u0013j\u0002`\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00188&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\u00020\u00068VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u001e\u0010\bR\u001a\u0010%\u001a\u00020!8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b$\u0010\u001c\u001a\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020!8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010#R\u0016\u0010+\u001a\u0004\u0018\u00010(8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u001a\u0010.\u001a\u00020\u00028VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b-\u0010\u001c\u001a\u0004\b,\u0010\u0004R\u0014\u00102\u001a\u00020/8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00105\u001a\u00020!8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b4\u0010\u001c\u001a\u0004\b3\u0010#R\u001c\u00108\u001a\u0004\u0018\u00010(8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b7\u0010\u001c\u001a\u0004\b6\u0010*R\u0016\u0010:\u001a\u0004\u0018\u00010\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010\u0011R\u0014\u0010<\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b;\u0010#R\u0014\u0010>\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010\bR\u0014\u0010B\u001a\u00020?8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010D\u001a\u00020/8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u00101\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006E\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/Ship;", "Lorg/valkyrienskies/core/api/util/Identified;", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "getActiveChunksSet", "()Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "activeChunksSet", "Lorg/joml/Vector3dc;", "getAngularVelocity", "()Lorg/joml/Vector3dc;", "angularVelocity", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "getChunkClaim", "()Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "chunkClaim", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "getChunkClaimDimension", "()Ljava/lang/String;", "chunkClaimDimension", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "getId", "()J", "id", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "getKinematics", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "getKinematics$annotations", "()V", "kinematics", "getOmega", "getOmega$annotations", "omega", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getPrevTickShipTransform", "()Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getPrevTickShipTransform$annotations", "prevTickShipTransform", "getPrevTickTransform", "prevTickTransform", "Lorg/joml/primitives/AABBic;", "getShipAABB", "()Lorg/joml/primitives/AABBic;", "shipAABB", "getShipActiveChunksSet", "getShipActiveChunksSet$annotations", "shipActiveChunksSet", "Lorg/joml/Matrix4dc;", "getShipToWorld", "()Lorg/joml/Matrix4dc;", "shipToWorld", "getShipTransform", "getShipTransform$annotations", "shipTransform", "getShipVoxelAABB", "getShipVoxelAABB$annotations", "shipVoxelAABB", "getSlug", "slug", "getTransform", "transform", "getVelocity", "velocity", "Lorg/joml/primitives/AABBdc;", "getWorldAABB", "()Lorg/joml/primitives/AABBdc;", "worldAABB", "getWorldToShip", "worldToShip", "api"})
public interface Ship
extends Identified {
    @Override
    public long getId();

    @Nullable
    public String getSlug();

    @NotNull
    public BodyKinematics getKinematics();

    @VsBeta
    public static /* synthetic */ void getKinematics$annotations() {
    }

    @NotNull
    default public ShipTransform getTransform() {
        BodyTransform bodyTransform = this.getKinematics().getTransform();
        Intrinsics.checkNotNull((Object)bodyTransform, (String)"null cannot be cast to non-null type org.valkyrienskies.core.api.ships.properties.ShipTransform");
        return (ShipTransform)bodyTransform;
    }

    @NotNull
    public ShipTransform getPrevTickTransform();

    @NotNull
    public ChunkClaim getChunkClaim();

    @NotNull
    public String getChunkClaimDimension();

    @NotNull
    public AABBdc getWorldAABB();

    @Nullable
    public AABBic getShipAABB();

    @NotNull
    default public Vector3dc getVelocity() {
        return this.getKinematics().getVelocity();
    }

    @NotNull
    default public Vector3dc getAngularVelocity() {
        return this.getKinematics().getAngularVelocity();
    }

    @NotNull
    public IShipActiveChunksSet getActiveChunksSet();

    @NotNull
    default public Matrix4dc getShipToWorld() {
        return this.getTransform().getToWorld();
    }

    @NotNull
    default public Matrix4dc getWorldToShip() {
        return this.getTransform().getToModel();
    }

    @NotNull
    default public ShipTransform getPrevTickShipTransform() {
        return this.getPrevTickTransform();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="prevTickTransform", imports={}))
    public static /* synthetic */ void getPrevTickShipTransform$annotations() {
    }

    @NotNull
    default public Vector3dc getOmega() {
        return this.getAngularVelocity();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="angularVelocity", imports={}))
    public static /* synthetic */ void getOmega$annotations() {
    }

    @NotNull
    default public ShipTransform getShipTransform() {
        return this.getTransform();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="transform", imports={}))
    public static /* synthetic */ void getShipTransform$annotations() {
    }

    @Nullable
    default public AABBic getShipVoxelAABB() {
        return this.getShipAABB();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="shipAABB", imports={}))
    public static /* synthetic */ void getShipVoxelAABB$annotations() {
    }

    @NotNull
    default public IShipActiveChunksSet getShipActiveChunksSet() {
        return this.getActiveChunksSet();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="activeChunksSet", imports={}))
    public static /* synthetic */ void getShipActiveChunksSet$annotations() {
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.ships.properties;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4dc;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u00002\u00020\u0001J7\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u0017\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0017\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0017\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0017\u00a2\u0006\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u00058VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001e\u001a\u00020\u00028VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010!\u001a\u00020\u00028VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b \u0010\u001a\u001a\u0004\b\u001f\u0010\u0015R\u001a\u0010$\u001a\u00020\u00028VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b#\u0010\u001a\u001a\u0004\b\"\u0010\u0015R\u0014\u0010(\u001a\u00020%8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010+\u001a\u00020%8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b*\u0010\u001a\u001a\u0004\b)\u0010'R\u0014\u0010\u0006\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010\u0015R\u0014\u0010/\u001a\u00020%8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010'R\u001a\u00102\u001a\u00020%8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b1\u0010\u001a\u001a\u0004\b0\u0010'\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u00063\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "Lorg/joml/Vector3dc;", "positionInWorld", "positionInShip", "Lorg/joml/Quaterniondc;", "shipToWorldRotation", "shipToWorldScaling", "copy", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "Lorg/joml/primitives/AABBdc;", "createEmptyAABB", "()Lorg/joml/primitives/AABBdc;", "directionInShip", "Lorg/joml/Vector3d;", "dest", "transformDirectionNoScalingFromShipToWorld", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "directionInWorld", "transformDirectionNoScalingFromWorldToShip", "getPositionInShip", "()Lorg/joml/Vector3dc;", "getPositionInWorld", "getShipCoordinatesToWorldCoordinatesRotation", "()Lorg/joml/Quaterniondc;", "getShipCoordinatesToWorldCoordinatesRotation$annotations", "()V", "shipCoordinatesToWorldCoordinatesRotation", "getShipCoordinatesToWorldCoordinatesScaling", "getShipCoordinatesToWorldCoordinatesScaling$annotations", "shipCoordinatesToWorldCoordinatesScaling", "getShipPositionInShipCoordinates", "getShipPositionInShipCoordinates$annotations", "shipPositionInShipCoordinates", "getShipPositionInWorldCoordinates", "getShipPositionInWorldCoordinates$annotations", "shipPositionInWorldCoordinates", "Lorg/joml/Matrix4dc;", "getShipToWorld", "()Lorg/joml/Matrix4dc;", "shipToWorld", "getShipToWorldMatrix", "getShipToWorldMatrix$annotations", "shipToWorldMatrix", "getShipToWorldRotation", "getShipToWorldScaling", "getWorldToShip", "worldToShip", "getWorldToShipMatrix", "getWorldToShipMatrix$annotations", "worldToShipMatrix", "api"})
@ApiStatus.NonExtendable
public interface ShipTransform
extends BodyTransform {
    @NotNull
    default public Vector3dc getPositionInWorld() {
        return this.getPosition();
    }

    @NotNull
    default public Vector3dc getPositionInShip() {
        return this.getPositionInModel();
    }

    @NotNull
    default public Quaterniondc getShipToWorldRotation() {
        return this.getRotation();
    }

    @NotNull
    default public Vector3dc getShipToWorldScaling() {
        return this.getScaling();
    }

    @NotNull
    default public Matrix4dc getShipToWorld() {
        return this.getToWorld();
    }

    @NotNull
    default public Matrix4dc getWorldToShip() {
        return this.getToModel();
    }

    @Deprecated(message="not sure why this exists", replaceWith=@ReplaceWith(expression="AABBd(position, position)", imports={"org.joml.primitives.AABBd"}))
    @NotNull
    default public AABBdc createEmptyAABB() {
        return new AABBd(this.getPosition(), this.getPosition());
    }

    @Deprecated(message="use toBuilder or rebuild instead - you can cast the result back to ShipTransform if needed")
    @NotNull
    default public ShipTransform copy(@NotNull Vector3dc positionInWorld, @NotNull Vector3dc positionInShip, @NotNull Quaterniondc shipToWorldRotation, @NotNull Vector3dc shipToWorldScaling) {
        Intrinsics.checkNotNullParameter((Object)positionInWorld, (String)"positionInWorld");
        Intrinsics.checkNotNullParameter((Object)positionInShip, (String)"positionInShip");
        Intrinsics.checkNotNullParameter((Object)shipToWorldRotation, (String)"shipToWorldRotation");
        Intrinsics.checkNotNullParameter((Object)shipToWorldScaling, (String)"shipToWorldScaling");
        BodyTransform bodyTransform = this.toBuilder().position(positionInWorld).rotation(shipToWorldRotation).scaling(shipToWorldScaling).positionInModel(positionInShip).build();
        Intrinsics.checkNotNull((Object)bodyTransform, (String)"null cannot be cast to non-null type org.valkyrienskies.core.api.ships.properties.ShipTransform");
        return (ShipTransform)bodyTransform;
    }

    public static /* synthetic */ ShipTransform copy$default(ShipTransform shipTransform, Vector3dc vector3dc, Vector3dc vector3dc2, Quaterniondc quaterniondc, Vector3dc vector3dc3, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((n2 & 1) != 0) {
            vector3dc = shipTransform.getPositionInWorld();
        }
        if ((n2 & 2) != 0) {
            vector3dc2 = shipTransform.getPositionInShip();
        }
        if ((n2 & 4) != 0) {
            quaterniondc = shipTransform.getShipToWorldRotation();
        }
        if ((n2 & 8) != 0) {
            vector3dc3 = shipTransform.getShipToWorldScaling();
        }
        return shipTransform.copy(vector3dc, vector3dc2, quaterniondc, vector3dc3);
    }

    @Deprecated(message="redundant", replaceWith=@ReplaceWith(expression="rotation.transform(directionInShip, dest)", imports={}))
    @NotNull
    default public Vector3d transformDirectionNoScalingFromShipToWorld(@NotNull Vector3dc directionInShip, @NotNull Vector3d dest) {
        Intrinsics.checkNotNullParameter((Object)directionInShip, (String)"directionInShip");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        Vector3d vector3d = this.getRotation().transform(directionInShip, dest);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"rotation.transform(directionInShip, dest)");
        return vector3d;
    }

    @Deprecated(message="redundant", replaceWith=@ReplaceWith(expression="rotation.transformInverse(directionInWorld, dest)", imports={}))
    @NotNull
    default public Vector3d transformDirectionNoScalingFromWorldToShip(@NotNull Vector3dc directionInWorld, @NotNull Vector3d dest) {
        Intrinsics.checkNotNullParameter((Object)directionInWorld, (String)"directionInWorld");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        Vector3d vector3d = this.getRotation().transformInverse(directionInWorld, dest);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"rotation.transformInverse(directionInWorld, dest)");
        return vector3d;
    }

    @NotNull
    default public Vector3dc getShipPositionInWorldCoordinates() {
        return this.getPosition();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="position", imports={}))
    public static /* synthetic */ void getShipPositionInWorldCoordinates$annotations() {
    }

    @NotNull
    default public Vector3dc getShipPositionInShipCoordinates() {
        return this.getPositionInModel();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="positionInModel", imports={}))
    public static /* synthetic */ void getShipPositionInShipCoordinates$annotations() {
    }

    @NotNull
    default public Quaterniondc getShipCoordinatesToWorldCoordinatesRotation() {
        return this.getRotation();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="rotation", imports={}))
    public static /* synthetic */ void getShipCoordinatesToWorldCoordinatesRotation$annotations() {
    }

    @NotNull
    default public Vector3dc getShipCoordinatesToWorldCoordinatesScaling() {
        return this.getScaling();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="scaling", imports={}))
    public static /* synthetic */ void getShipCoordinatesToWorldCoordinatesScaling$annotations() {
    }

    @NotNull
    default public Matrix4dc getShipToWorldMatrix() {
        return this.getToWorld();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="toWorld", imports={}))
    public static /* synthetic */ void getShipToWorldMatrix$annotations() {
    }

    @NotNull
    default public Matrix4dc getWorldToShipMatrix() {
        return this.getToModel();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="toModel", imports={}))
    public static /* synthetic */ void getWorldToShipMatrix$annotations() {
    }
}


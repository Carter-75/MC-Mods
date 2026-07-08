/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shiptransform.dto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;

@JsonIncludeProperties(value={"shipPositionInWorldCoordinates", "shipPositionInShipCoordinates", "shipCoordinatesToWorldCoordinatesRotation", "shipCoordinatesToWorldCoordinatesScaling"})
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0004J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u00d6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u00020\u00068\u0007X\u0087\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u0017\u0010\r\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b!\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b\"\u0010\u0004R\u0017\u0010$\u001a\u00020#8\u0007\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010(\u001a\u00020#8\u0007\u00a2\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b)\u0010'"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "", "Lorg/joml/Vector3dc;", "component1", "()Lorg/joml/Vector3dc;", "component2", "Lorg/joml/Quaterniondc;", "component3", "()Lorg/joml/Quaterniondc;", "component4", "shipPositionInWorldCoordinates", "shipPositionInShipCoordinates", "shipCoordinatesToWorldCoordinatesRotation", "shipCoordinatesToWorldCoordinatesScaling", "copy", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/impl/game/ships/serialization/shiptransform/dto/ShipTransformDataV0;", "Lorg/joml/primitives/AABBdc;", "createEmptyAABB", "()Lorg/joml/primitives/AABBdc;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/joml/Quaterniondc;", "getShipCoordinatesToWorldCoordinatesRotation", "Lorg/joml/Vector3dc;", "getShipCoordinatesToWorldCoordinatesScaling", "getShipPositionInShipCoordinates", "getShipPositionInWorldCoordinates", "Lorg/joml/Matrix4dc;", "shipToWorldMatrix", "Lorg/joml/Matrix4dc;", "getShipToWorldMatrix", "()Lorg/joml/Matrix4dc;", "worldToShipMatrix", "getWorldToShipMatrix", "<init>", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;)V"})
public final class ShipTransformDataV0 {
    private final Vector3dc shipPositionInWorldCoordinates;
    private final Vector3dc shipPositionInShipCoordinates;
    private final Quaterniondc shipCoordinatesToWorldCoordinatesRotation;
    private final Vector3dc shipCoordinatesToWorldCoordinatesScaling;
    private final Matrix4dc shipToWorldMatrix;
    private final Matrix4dc worldToShipMatrix;

    /*
     * WARNING - void declaration
     */
    public ShipTransformDataV0(Vector3dc shipPositionInWorldCoordinates, Vector3dc shipPositionInShipCoordinates, Quaterniondc shipCoordinatesToWorldCoordinatesRotation, Vector3dc shipCoordinatesToWorldCoordinatesScaling) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)shipPositionInWorldCoordinates, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipPositionInShipCoordinates, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipCoordinatesToWorldCoordinatesRotation, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipCoordinatesToWorldCoordinatesScaling, (String)"");
        this.shipPositionInWorldCoordinates = var1_1;
        this.shipPositionInShipCoordinates = var2_2;
        this.shipCoordinatesToWorldCoordinatesRotation = var3_3;
        this.shipCoordinatesToWorldCoordinatesScaling = shipCoordinatesToWorldCoordinatesScaling;
        Matrix4d matrix4d = new Matrix4d().translate(this.shipPositionInWorldCoordinates).rotate(this.shipCoordinatesToWorldCoordinatesRotation).scale(this.shipCoordinatesToWorldCoordinatesScaling).translate(-this.shipPositionInShipCoordinates.x(), -this.shipPositionInShipCoordinates.y(), -this.shipPositionInShipCoordinates.z());
        Intrinsics.checkNotNullExpressionValue((Object)matrix4d, (String)"");
        this.shipToWorldMatrix = matrix4d;
        Matrix4d matrix4d2 = this.shipToWorldMatrix.invert(new Matrix4d());
        Intrinsics.checkNotNullExpressionValue((Object)matrix4d2, (String)"");
        this.worldToShipMatrix = matrix4d2;
    }

    @JvmName(name="getShipPositionInWorldCoordinates")
    public final Vector3dc getShipPositionInWorldCoordinates() {
        return this.shipPositionInWorldCoordinates;
    }

    @JvmName(name="getShipPositionInShipCoordinates")
    public final Vector3dc getShipPositionInShipCoordinates() {
        return this.shipPositionInShipCoordinates;
    }

    @JvmName(name="getShipCoordinatesToWorldCoordinatesRotation")
    public final Quaterniondc getShipCoordinatesToWorldCoordinatesRotation() {
        return this.shipCoordinatesToWorldCoordinatesRotation;
    }

    @JvmName(name="getShipCoordinatesToWorldCoordinatesScaling")
    public final Vector3dc getShipCoordinatesToWorldCoordinatesScaling() {
        return this.shipCoordinatesToWorldCoordinatesScaling;
    }

    @JvmName(name="getShipToWorldMatrix")
    public final Matrix4dc getShipToWorldMatrix() {
        return this.shipToWorldMatrix;
    }

    @JvmName(name="getWorldToShipMatrix")
    public final Matrix4dc getWorldToShipMatrix() {
        return this.worldToShipMatrix;
    }

    public final AABBdc createEmptyAABB() {
        return new AABBd(this.shipPositionInWorldCoordinates, this.shipPositionInWorldCoordinates);
    }

    public final Vector3dc component1() {
        return this.shipPositionInWorldCoordinates;
    }

    public final Vector3dc component2() {
        return this.shipPositionInShipCoordinates;
    }

    public final Quaterniondc component3() {
        return this.shipCoordinatesToWorldCoordinatesRotation;
    }

    public final Vector3dc component4() {
        return this.shipCoordinatesToWorldCoordinatesScaling;
    }

    /*
     * WARNING - void declaration
     */
    public final ShipTransformDataV0 copy(Vector3dc shipPositionInWorldCoordinates, Vector3dc shipPositionInShipCoordinates, Quaterniondc shipCoordinatesToWorldCoordinatesRotation, Vector3dc shipCoordinatesToWorldCoordinatesScaling) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)shipPositionInWorldCoordinates, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipPositionInShipCoordinates, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipCoordinatesToWorldCoordinatesRotation, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipCoordinatesToWorldCoordinatesScaling, (String)"");
        return new ShipTransformDataV0((Vector3dc)var1_1, (Vector3dc)var2_2, (Quaterniondc)var3_3, shipCoordinatesToWorldCoordinatesScaling);
    }

    public static /* synthetic */ ShipTransformDataV0 copy$default(ShipTransformDataV0 shipTransformDataV0, Vector3dc vector3dc, Vector3dc vector3dc2, Quaterniondc quaterniondc, Vector3dc vector3dc3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            vector3dc = shipTransformDataV0.shipPositionInWorldCoordinates;
        }
        if ((n2 & 2) != 0) {
            vector3dc2 = shipTransformDataV0.shipPositionInShipCoordinates;
        }
        if ((n2 & 4) != 0) {
            quaterniondc = shipTransformDataV0.shipCoordinatesToWorldCoordinatesRotation;
        }
        if ((n2 & 8) != 0) {
            vector3dc3 = shipTransformDataV0.shipCoordinatesToWorldCoordinatesScaling;
        }
        return shipTransformDataV0.copy(vector3dc, vector3dc2, quaterniondc, vector3dc3);
    }

    public final String toString() {
        return "ShipTransformDataV0(shipPositionInWorldCoordinates=" + this.shipPositionInWorldCoordinates + ", shipPositionInShipCoordinates=" + this.shipPositionInShipCoordinates + ", shipCoordinatesToWorldCoordinatesRotation=" + this.shipCoordinatesToWorldCoordinatesRotation + ", shipCoordinatesToWorldCoordinatesScaling=" + this.shipCoordinatesToWorldCoordinatesScaling + ")";
    }

    public final int hashCode() {
        int n2 = this.shipPositionInWorldCoordinates.hashCode();
        n2 = n2 * 31 + this.shipPositionInShipCoordinates.hashCode();
        n2 = n2 * 31 + this.shipCoordinatesToWorldCoordinatesRotation.hashCode();
        n2 = n2 * 31 + this.shipCoordinatesToWorldCoordinatesScaling.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        ShipTransformDataV0 shipTransformDataV0;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShipTransformDataV0)) {
            return false;
        }
        shipTransformDataV0 = shipTransformDataV0;
        if (!Intrinsics.areEqual((Object)this.shipPositionInWorldCoordinates, (Object)shipTransformDataV0.shipPositionInWorldCoordinates)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.shipPositionInShipCoordinates, (Object)shipTransformDataV0.shipPositionInShipCoordinates)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.shipCoordinatesToWorldCoordinatesRotation, (Object)shipTransformDataV0.shipCoordinatesToWorldCoordinatesRotation)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.shipCoordinatesToWorldCoordinatesScaling, (Object)shipTransformDataV0.shipCoordinatesToWorldCoordinatesScaling);
    }
}


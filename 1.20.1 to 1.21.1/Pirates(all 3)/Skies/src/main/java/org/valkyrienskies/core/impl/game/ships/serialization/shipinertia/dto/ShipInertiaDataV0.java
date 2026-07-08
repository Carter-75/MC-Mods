/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships.serialization.shipinertia.dto;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix3d;
import org.joml.Vector3d;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bH\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0017\u0010\r\u001a\u00020\b8\u0007\u00a2\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\"\u0010\f\u001a\u00020\u00058\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010!"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "", "Lorg/joml/Vector3d;", "component1", "()Lorg/joml/Vector3d;", "", "component2", "()D", "Lorg/joml/Matrix3d;", "component3", "()Lorg/joml/Matrix3d;", "centerOfMassInShipSpace", "shipMass", "momentOfInertiaTensor", "copy", "(Lorg/joml/Vector3d;DLorg/joml/Matrix3d;)Lorg/valkyrienskies/core/impl/game/ships/serialization/shipinertia/dto/ShipInertiaDataV0;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/joml/Vector3d;", "getCenterOfMassInShipSpace", "Lorg/joml/Matrix3d;", "getMomentOfInertiaTensor", "D", "getShipMass", "setShipMass", "(D)V", "<init>", "(Lorg/joml/Vector3d;DLorg/joml/Matrix3d;)V"})
public final class ShipInertiaDataV0 {
    private final Vector3d centerOfMassInShipSpace;
    private double shipMass;
    private final Matrix3d momentOfInertiaTensor;

    /*
     * WARNING - void declaration
     */
    public ShipInertiaDataV0(Vector3d centerOfMassInShipSpace, double shipMass, Matrix3d momentOfInertiaTensor) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)centerOfMassInShipSpace, (String)"");
        Intrinsics.checkNotNullParameter((Object)momentOfInertiaTensor, (String)"");
        this.centerOfMassInShipSpace = var1_1;
        this.shipMass = var2_2;
        this.momentOfInertiaTensor = momentOfInertiaTensor;
    }

    @JvmName(name="getCenterOfMassInShipSpace")
    public final Vector3d getCenterOfMassInShipSpace() {
        return this.centerOfMassInShipSpace;
    }

    @JvmName(name="getShipMass")
    public final double getShipMass() {
        return this.shipMass;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setShipMass")
    public final void setShipMass(double d2) {
        void var1_1;
        this.shipMass = var1_1;
    }

    @JvmName(name="getMomentOfInertiaTensor")
    public final Matrix3d getMomentOfInertiaTensor() {
        return this.momentOfInertiaTensor;
    }

    public final Vector3d component1() {
        return this.centerOfMassInShipSpace;
    }

    public final double component2() {
        return this.shipMass;
    }

    public final Matrix3d component3() {
        return this.momentOfInertiaTensor;
    }

    /*
     * WARNING - void declaration
     */
    public final ShipInertiaDataV0 copy(Vector3d centerOfMassInShipSpace, double shipMass, Matrix3d momentOfInertiaTensor) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)centerOfMassInShipSpace, (String)"");
        Intrinsics.checkNotNullParameter((Object)momentOfInertiaTensor, (String)"");
        return new ShipInertiaDataV0((Vector3d)var1_1, (double)var2_2, momentOfInertiaTensor);
    }

    public static /* synthetic */ ShipInertiaDataV0 copy$default(ShipInertiaDataV0 shipInertiaDataV0, Vector3d vector3d, double d2, Matrix3d matrix3d, int n2, Object object) {
        if ((n2 & 1) != 0) {
            vector3d = shipInertiaDataV0.centerOfMassInShipSpace;
        }
        if ((n2 & 2) != 0) {
            d2 = shipInertiaDataV0.shipMass;
        }
        if ((n2 & 4) != 0) {
            matrix3d = shipInertiaDataV0.momentOfInertiaTensor;
        }
        return shipInertiaDataV0.copy(vector3d, d2, matrix3d);
    }

    public final String toString() {
        return "ShipInertiaDataV0(centerOfMassInShipSpace=" + this.centerOfMassInShipSpace + ", shipMass=" + this.shipMass + ", momentOfInertiaTensor=" + this.momentOfInertiaTensor + ")";
    }

    public final int hashCode() {
        int n2 = this.centerOfMassInShipSpace.hashCode();
        n2 = n2 * 31 + Double.hashCode(this.shipMass);
        n2 = n2 * 31 + this.momentOfInertiaTensor.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        ShipInertiaDataV0 shipInertiaDataV0;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShipInertiaDataV0)) {
            return false;
        }
        shipInertiaDataV0 = shipInertiaDataV0;
        if (!Intrinsics.areEqual((Object)this.centerOfMassInShipSpace, (Object)shipInertiaDataV0.centerOfMassInShipSpace)) {
            return false;
        }
        if (Double.compare(this.shipMass, shipInertiaDataV0.shipMass) != 0) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.momentOfInertiaTensor, (Object)shipInertiaDataV0.momentOfInertiaTensor);
    }
}


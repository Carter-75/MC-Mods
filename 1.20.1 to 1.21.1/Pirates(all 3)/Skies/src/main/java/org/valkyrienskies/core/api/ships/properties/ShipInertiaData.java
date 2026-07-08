/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 */
package org.valkyrienskies.core.api.ships.properties;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3dc;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.bodies.properties.BodyInertia;

@Deprecated(message="Deprecated for removal; use BodyInertia instead.", replaceWith=@ReplaceWith(expression="BodyInertia", imports={"org.valkyrienskies.core.api.bodies.properties.BodyInertia"}))
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u000b8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u00108VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0015\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyInertia;", "Lorg/joml/Vector3dc;", "getCenterOfMassInShip", "()Lorg/joml/Vector3dc;", "getCenterOfMassInShip$annotations", "()V", "centerOfMassInShip", "getCenterOfMassInShipSpace", "getCenterOfMassInShipSpace$annotations", "centerOfMassInShipSpace", "Lorg/joml/Matrix3dc;", "getMomentOfInertiaTensor", "()Lorg/joml/Matrix3dc;", "getMomentOfInertiaTensor$annotations", "momentOfInertiaTensor", "", "getShipMass", "()D", "getShipMass$annotations", "shipMass", "api"})
public interface ShipInertiaData
extends BodyInertia {
    @NotNull
    default public Matrix3dc getMomentOfInertiaTensor() {
        return this.getInertiaTensor();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="inertiaTensor", imports={}))
    public static /* synthetic */ void getMomentOfInertiaTensor$annotations() {
    }

    @NotNull
    default public Vector3dc getCenterOfMassInShip() {
        return this.getCenterOfMass();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="centerOfMass", imports={}))
    public static /* synthetic */ void getCenterOfMassInShip$annotations() {
    }

    default public double getShipMass() {
        return this.getMass();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="mass", imports={}))
    public static /* synthetic */ void getShipMass$annotations() {
    }

    @NotNull
    default public Vector3dc getCenterOfMassInShipSpace() {
        return this.getCenterOfMass();
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="centerOfMass", imports={}))
    public static /* synthetic */ void getCenterOfMassInShipSpace$annotations() {
    }
}


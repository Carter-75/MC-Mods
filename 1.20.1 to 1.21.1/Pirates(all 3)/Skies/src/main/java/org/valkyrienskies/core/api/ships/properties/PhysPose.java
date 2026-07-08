/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.ships.properties;

import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.bodies.properties.BodyPose;

@Deprecated(message="DO NOT USE. DO NOT LEAVE IN FOR VS 2.5. Replace with BodyPose")
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\n\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000e\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/properties/PhysPose;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyPose;", "Lorg/joml/Vector3dc;", "getPos", "()Lorg/joml/Vector3dc;", "pos", "getPosition", "position", "Lorg/joml/Quaterniondc;", "getRot", "()Lorg/joml/Quaterniondc;", "rot", "getRotation", "rotation", "api"})
public interface PhysPose
extends BodyPose {
    @NotNull
    public Vector3dc getPos();

    @NotNull
    public Quaterniondc getRot();

    @Override
    @NotNull
    default public Vector3dc getPosition() {
        return this.getPos();
    }

    @Override
    @NotNull
    default public Quaterniondc getRotation() {
        return this.getRot();
    }
}


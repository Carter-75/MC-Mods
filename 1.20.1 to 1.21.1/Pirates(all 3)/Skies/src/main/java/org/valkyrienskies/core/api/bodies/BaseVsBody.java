/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.bodies;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.util.Identified;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u000e\u001a\u00060\nj\u0002`\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0013\u001a\u00060\u000fj\u0002`\u00108&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001c\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/bodies/BaseVsBody;", "Lorg/valkyrienskies/core/api/util/Identified;", "Lorg/joml/primitives/AABBdc;", "getAabb", "()Lorg/joml/primitives/AABBdc;", "aabb", "Lorg/joml/Vector3dc;", "getAngularVelocity", "()Lorg/joml/Vector3dc;", "angularVelocity", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "getDimension", "()Ljava/lang/String;", "dimension", "", "Lorg/valkyrienskies/core/api/bodies/properties/BodyId;", "getId", "()J", "id", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "getPrevTickTransform", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "prevTickTransform", "getTransform", "transform", "getVelocity", "velocity", "api"})
public interface BaseVsBody
extends Identified {
    @Override
    public long getId();

    @NotNull
    public String getDimension();

    @NotNull
    public BodyKinematics getTransform();

    @NotNull
    public BodyKinematics getPrevTickTransform();

    @NotNull
    public AABBdc getAabb();

    @NotNull
    default public Vector3dc getVelocity() {
        return this.getTransform().getVelocity();
    }

    @NotNull
    default public Vector3dc getAngularVelocity() {
        return this.getTransform().getAngularVelocity();
    }
}


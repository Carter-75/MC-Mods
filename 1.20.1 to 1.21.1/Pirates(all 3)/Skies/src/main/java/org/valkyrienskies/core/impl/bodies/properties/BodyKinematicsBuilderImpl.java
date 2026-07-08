/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 */
package org.valkyrienskies.core.impl.bodies.properties;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.impl.bodies.properties.BodyKinematicsFactory;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u001a\u0010\u000f\u001a\u00020\u000e8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\tR\u001a\u0010\u0015\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\t"}, d2={"Lorg/valkyrienskies/core/impl/bodies/properties/BodyKinematicsBuilderImpl;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "build", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "Lorg/joml/Vector3d;", "angularVelocity", "Lorg/joml/Vector3d;", "getAngularVelocity", "()Lorg/joml/Vector3d;", "position", "getPosition", "positionInModel", "getPositionInModel", "Lorg/joml/Quaterniond;", "rotation", "Lorg/joml/Quaterniond;", "getRotation", "()Lorg/joml/Quaterniond;", "scaling", "getScaling", "velocity", "getVelocity", "<init>", "()V"})
public final class BodyKinematicsBuilderImpl
implements BodyKinematics.Builder {
    private final Vector3d position = new Vector3d();
    private final Vector3d positionInModel = new Vector3d();
    private final Quaterniond rotation = new Quaterniond();
    private final Vector3d scaling = new Vector3d();
    private final Vector3d velocity = new Vector3d();
    private final Vector3d angularVelocity = new Vector3d();

    @Override
    @JvmName(name="getPosition")
    public final Vector3d getPosition() {
        return this.position;
    }

    @Override
    @JvmName(name="getPositionInModel")
    public final Vector3d getPositionInModel() {
        return this.positionInModel;
    }

    @Override
    @JvmName(name="getRotation")
    public final Quaterniond getRotation() {
        return this.rotation;
    }

    @Override
    @JvmName(name="getScaling")
    public final Vector3d getScaling() {
        return this.scaling;
    }

    @Override
    @JvmName(name="getVelocity")
    public final Vector3d getVelocity() {
        return this.velocity;
    }

    @Override
    @JvmName(name="getAngularVelocity")
    public final Vector3d getAngularVelocity() {
        return this.angularVelocity;
    }

    @Override
    public final BodyKinematics build() {
        BodyKinematicsFactory bodyKinematicsFactory = BodyKinematicsFactory.INSTANCE;
        Vector3d vector3d = new Vector3d(this.getPosition());
        Vector3d vector3d2 = new Vector3d(this.getPositionInModel());
        Quaterniond quaterniond = new Quaterniond(this.getRotation());
        Vector3d vector3d3 = new Vector3d(this.getScaling());
        Vector3d vector3d4 = new Vector3d(this.getVelocity());
        Vector3d vector3d5 = new Vector3d(this.getAngularVelocity());
        return bodyKinematicsFactory.create(vector3d4, vector3d5, vector3d, quaterniond, vector3d3, vector3d2);
    }
}


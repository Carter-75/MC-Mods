/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.bodies.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4dc;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;

@VsBeta
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001:\u0001!J\u000f\u0010\u0003\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u000b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\"\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "toBuilder", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "withTransform", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "Lorg/joml/Vector3dc;", "getAngularVelocity", "()Lorg/joml/Vector3dc;", "angularVelocity", "getPosition", "position", "getPositionInModel", "positionInModel", "Lorg/joml/Quaterniondc;", "getRotation", "()Lorg/joml/Quaterniondc;", "rotation", "getScaling", "scaling", "Lorg/joml/Matrix4dc;", "getToModel", "()Lorg/joml/Matrix4dc;", "toModel", "getToWorld", "toWorld", "getTransform", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "getVelocity", "velocity", "Builder", "api"})
public interface BodyKinematics {
    @NotNull
    public BodyTransform getTransform();

    @NotNull
    public Vector3dc getVelocity();

    @NotNull
    public Vector3dc getAngularVelocity();

    @NotNull
    default public Vector3dc getPosition() {
        return this.getTransform().getPosition();
    }

    @NotNull
    default public Quaterniondc getRotation() {
        return this.getTransform().getRotation();
    }

    @NotNull
    default public Vector3dc getScaling() {
        return this.getTransform().getScaling();
    }

    @NotNull
    default public Vector3dc getPositionInModel() {
        return this.getTransform().getPositionInModel();
    }

    @NotNull
    default public Matrix4dc getToWorld() {
        return this.getTransform().getToWorld();
    }

    @NotNull
    default public Matrix4dc getToModel() {
        return this.getTransform().getToModel();
    }

    @NotNull
    public BodyKinematics withTransform(@NotNull BodyTransform var1);

    @VsBeta
    @NotNull
    public Builder toBuilder();

    @VsBeta
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u000f\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u0014\u0010\u0010\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u0012\u001a\u00020\u001b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0014\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018R\u0014\u0010\u0015\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006 \u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "", "Lorg/joml/Vector3dc;", "angularVelocity", "(Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "build", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "kinematics", "from", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "fromTransform", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "position", "positionInModel", "Lorg/joml/Quaterniondc;", "rotation", "(Lorg/joml/Quaterniondc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "scaling", "velocity", "Lorg/joml/Vector3d;", "getAngularVelocity", "()Lorg/joml/Vector3d;", "getPosition", "getPositionInModel", "Lorg/joml/Quaterniond;", "getRotation", "()Lorg/joml/Quaterniond;", "getScaling", "getVelocity", "api"})
    public static interface Builder {
        @NotNull
        public Vector3d getVelocity();

        @NotNull
        public Vector3d getAngularVelocity();

        @NotNull
        public Vector3d getPosition();

        @NotNull
        public Vector3d getPositionInModel();

        @NotNull
        public Quaterniond getRotation();

        @NotNull
        public Vector3d getScaling();

        @NotNull
        default public Builder position(@NotNull Vector3dc position) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)position, (String)"position");
            Builder it = builder = this;
            boolean bl = false;
            this.getPosition().set(position);
            return builder;
        }

        @NotNull
        default public Builder positionInModel(@NotNull Vector3dc positionInModel) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)positionInModel, (String)"positionInModel");
            Builder it = builder = this;
            boolean bl = false;
            this.getPositionInModel().set(positionInModel);
            return builder;
        }

        @NotNull
        default public Builder rotation(@NotNull Quaterniondc rotation) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
            Builder it = builder = this;
            boolean bl = false;
            this.getRotation().set(rotation);
            return builder;
        }

        @NotNull
        default public Builder scaling(@NotNull Vector3dc scaling) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)scaling, (String)"scaling");
            Builder it = builder = this;
            boolean bl = false;
            this.getScaling().set(scaling);
            return builder;
        }

        @NotNull
        default public Builder velocity(@NotNull Vector3dc velocity) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)velocity, (String)"velocity");
            Builder it = builder = this;
            boolean bl = false;
            this.getVelocity().set(velocity);
            return builder;
        }

        @NotNull
        default public Builder angularVelocity(@NotNull Vector3dc angularVelocity) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"angularVelocity");
            Builder it = builder = this;
            boolean bl = false;
            this.getAngularVelocity().set(angularVelocity);
            return builder;
        }

        @NotNull
        default public Builder fromTransform(@NotNull BodyTransform transform2) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)transform2, (String)"transform");
            Builder it = builder = this;
            boolean bl = false;
            this.getPosition().set(transform2.getPosition());
            this.getPositionInModel().set(transform2.getPositionInModel());
            this.getRotation().set(transform2.getRotation());
            this.getScaling().set(transform2.getScaling());
            return builder;
        }

        @NotNull
        default public Builder from(@NotNull BodyKinematics kinematics) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)kinematics, (String)"kinematics");
            Builder it = builder = this;
            boolean bl = false;
            this.getPosition().set(kinematics.getPosition());
            this.getPositionInModel().set(kinematics.getPositionInModel());
            this.getRotation().set(kinematics.getRotation());
            this.getScaling().set(kinematics.getScaling());
            this.getVelocity().set(kinematics.getVelocity());
            this.getAngularVelocity().set(kinematics.getAngularVelocity());
            return builder;
        }

        @NotNull
        public BodyKinematics build();
    }
}


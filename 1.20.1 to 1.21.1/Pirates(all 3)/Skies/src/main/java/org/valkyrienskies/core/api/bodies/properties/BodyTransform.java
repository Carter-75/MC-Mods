/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.bodies.properties;

import java.io.DataInput;
import java.io.DataOutput;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4dc;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0002!\"J\u000f\u0010\u0003\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H'\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00158&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001e\u001a\u00020\u001b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u001b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006#\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "toBuilder", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "Lorg/joml/Vector3dc;", "velocity", "angularVelocity", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "withVelocity", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "Ljava/io/DataOutput;", "output", "", "writeTransform", "(Ljava/io/DataOutput;)V", "getPosition", "()Lorg/joml/Vector3dc;", "position", "getPositionInModel", "positionInModel", "Lorg/joml/Quaterniondc;", "getRotation", "()Lorg/joml/Quaterniondc;", "rotation", "getScaling", "scaling", "Lorg/joml/Matrix4dc;", "getToModel", "()Lorg/joml/Matrix4dc;", "toModel", "getToWorld", "toWorld", "Builder", "Factory", "api"})
public interface BodyTransform {
    @NotNull
    public Vector3dc getPosition();

    @NotNull
    public Quaterniondc getRotation();

    @NotNull
    public Vector3dc getScaling();

    @NotNull
    public Vector3dc getPositionInModel();

    @NotNull
    public Matrix4dc getToWorld();

    @NotNull
    public Matrix4dc getToModel();

    @VsBeta
    @NotNull
    public BodyKinematics withVelocity(@NotNull Vector3dc var1, @NotNull Vector3dc var2);

    @VsBeta
    @NotNull
    public Builder toBuilder();

    @VsBeta
    public void writeTransform(@NotNull DataOutput var1);

    @VsBeta
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u000f\u0010\nR\u0014\u0010\t\u001a\u00020\u00108&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u000b\u001a\u00020\u00108&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\r\u001a\u00020\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000f\u001a\u00020\u00108&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0018\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "build", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "from", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "Lorg/joml/Vector3dc;", "position", "(Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "positionInModel", "Lorg/joml/Quaterniondc;", "rotation", "(Lorg/joml/Quaterniondc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "scaling", "Lorg/joml/Vector3d;", "getPosition", "()Lorg/joml/Vector3d;", "getPositionInModel", "Lorg/joml/Quaterniond;", "getRotation", "()Lorg/joml/Quaterniond;", "getScaling", "api"})
    public static interface Builder {
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
        public Builder from(@NotNull BodyTransform var1);

        @NotNull
        public BodyTransform build();
    }

    @VsBeta
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u00a2\u0006\u0002\b\u0005H&\u00a2\u0006\u0004\b\b\u0010\tJ/\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH&\u00a2\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H&\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0007H&\u00a2\u0006\u0004\b\u0018\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001cH&\u00a2\u0006\u0004\b\u001d\u0010\u001e\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001f\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Factory;", "", "Lkotlin/Function1;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "", "Lkotlin/ExtensionFunctionType;", "builder", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "build", "(Lkotlin/jvm/functions/Function1;)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "Lorg/joml/Vector3dc;", "position", "Lorg/joml/Quaterniondc;", "rotation", "scaling", "positionInModel", "create", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "previous", "current", "", "alpha", "createFromSlerp", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;D)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "newBuilder", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "from", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "Ljava/io/DataInput;", "readFrom", "(Ljava/io/DataInput;)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "api"})
    public static interface Factory {
        @NotNull
        public Builder newBuilder();

        @NotNull
        public Builder newBuilder(@NotNull BodyTransform var1);

        @NotNull
        public BodyTransform readFrom(@NotNull DataInput var1);

        @NotNull
        public BodyTransform build(@NotNull Function1<? super Builder, Unit> var1);

        @NotNull
        public BodyTransform create(@NotNull Vector3dc var1, @NotNull Quaterniondc var2, @NotNull Vector3dc var3, @NotNull Vector3dc var4);

        @NotNull
        public BodyTransform createFromSlerp(@NotNull BodyTransform var1, @NotNull BodyTransform var2, double var3);
    }
}


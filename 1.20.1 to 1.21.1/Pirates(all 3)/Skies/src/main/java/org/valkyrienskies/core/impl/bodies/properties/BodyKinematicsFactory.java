/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.bodies.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.impl.bodies.properties.BodyKinematicsBuilderImpl;
import org.valkyrienskies.core.impl.bodies.properties.BodyKinematicsImpl;
import org.valkyrienskies.core.impl.bodies.properties.BodyTransformFactory;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J=\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000b\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2={"Lorg/valkyrienskies/core/impl/bodies/properties/BodyKinematicsFactory;", "", "Lorg/joml/Vector3dc;", "velocity", "angularVelocity", "position", "Lorg/joml/Quaterniondc;", "rotation", "scaling", "positionInModel", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "create", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "newBuilder", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "Lorg/valkyrienskies/core/impl/bodies/properties/BodyTransformFactory;", "transformFactory", "Lorg/valkyrienskies/core/impl/bodies/properties/BodyTransformFactory;", "<init>", "()V"})
public final class BodyKinematicsFactory {
    public static final BodyKinematicsFactory INSTANCE = new BodyKinematicsFactory();
    private static final BodyTransformFactory transformFactory = BodyTransformFactory.INSTANCE;

    private BodyKinematicsFactory() {
    }

    /*
     * WARNING - void declaration
     */
    public final BodyKinematics create(Vector3dc velocity, Vector3dc angularVelocity, BodyTransform transform2) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)velocity, (String)"");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"");
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
        return new BodyKinematicsImpl((Vector3dc)var1_1, (Vector3dc)var2_2, (BodyTransform)var3_3);
    }

    /*
     * WARNING - void declaration
     */
    public final BodyKinematics create(Vector3dc velocity, Vector3dc angularVelocity, Vector3dc position, Quaterniondc rotation, Vector3dc scaling, Vector3dc positionInModel) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)velocity, (String)"");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"");
        Intrinsics.checkNotNullParameter((Object)position, (String)"");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"");
        Intrinsics.checkNotNullParameter((Object)scaling, (String)"");
        Intrinsics.checkNotNullParameter((Object)positionInModel, (String)"");
        return this.create((Vector3dc)var1_1, (Vector3dc)var2_2, transformFactory.create((Vector3dc)var3_3, rotation, scaling, positionInModel));
    }

    public final BodyKinematics.Builder newBuilder() {
        return new BodyKinematicsBuilderImpl();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.bodies.properties;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.impl.bodies.properties.BodyKinematicsFactory;
import org.valkyrienskies.core.impl.util.DoNotObfuscate;

@DoNotObfuscate
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\t8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r"}, d2={"Lorg/valkyrienskies/core/impl/bodies/properties/BodyKinematicsImpl;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "toBuilder", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "withTransform", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "Lorg/joml/Vector3dc;", "angularVelocity", "Lorg/joml/Vector3dc;", "getAngularVelocity", "()Lorg/joml/Vector3dc;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "getTransform", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "velocity", "getVelocity", "<init>", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)V"})
public final class BodyKinematicsImpl
implements BodyKinematics {
    private final BodyTransform transform;
    private final Vector3dc velocity;
    private final Vector3dc angularVelocity;

    /*
     * WARNING - void declaration
     */
    public BodyKinematicsImpl(Vector3dc velocity, Vector3dc angularVelocity, BodyTransform transform2) {
        void var2_2;
        void var1_1;
        void var3_3;
        Intrinsics.checkNotNullParameter((Object)velocity, (String)"");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"");
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
        this.transform = var3_3;
        this.velocity = new Vector3d((Vector3dc)var1_1);
        this.angularVelocity = new Vector3d((Vector3dc)var2_2);
    }

    @Override
    @JvmName(name="getTransform")
    public final BodyTransform getTransform() {
        return this.transform;
    }

    @Override
    @JvmName(name="getVelocity")
    public final Vector3dc getVelocity() {
        return this.velocity;
    }

    @Override
    @JvmName(name="getAngularVelocity")
    public final Vector3dc getAngularVelocity() {
        return this.angularVelocity;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final BodyKinematics withTransform(BodyTransform transform2) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
        return new BodyKinematicsImpl(this.getVelocity(), this.getAngularVelocity(), (BodyTransform)var1_1);
    }

    @Override
    @VsBeta
    public final BodyKinematics.Builder toBuilder() {
        return BodyKinematicsFactory.INSTANCE.newBuilder().from(this);
    }
}


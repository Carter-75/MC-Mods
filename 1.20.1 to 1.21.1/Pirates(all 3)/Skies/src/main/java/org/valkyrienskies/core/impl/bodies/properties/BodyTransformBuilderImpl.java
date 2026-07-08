/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.bodies.properties;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.bodies.properties.BodyTransformImpl;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0017@\u0017X\u0097\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\t8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f"}, d2={"Lorg/valkyrienskies/core/impl/bodies/properties/BodyTransformBuilderImpl;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "build", "()Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "from", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)Lorg/valkyrienskies/core/impl/bodies/properties/BodyTransformBuilderImpl;", "Lorg/joml/Vector3d;", "position", "Lorg/joml/Vector3d;", "getPosition", "()Lorg/joml/Vector3d;", "setPosition", "(Lorg/joml/Vector3d;)V", "positionInModel", "getPositionInModel", "setPositionInModel", "Lorg/joml/Quaterniond;", "rotation", "Lorg/joml/Quaterniond;", "getRotation", "()Lorg/joml/Quaterniond;", "setRotation", "(Lorg/joml/Quaterniond;)V", "scaling", "getScaling", "setScaling", "<init>", "(Lorg/joml/Vector3d;Lorg/joml/Vector3d;Lorg/joml/Quaterniond;Lorg/joml/Vector3d;)V"})
public final class BodyTransformBuilderImpl
implements BodyTransform.Builder {
    private Vector3d position;
    private Vector3d positionInModel;
    private Quaterniond rotation;
    private Vector3d scaling;

    /*
     * WARNING - void declaration
     */
    public BodyTransformBuilderImpl(Vector3d position, Vector3d positionInModel, Quaterniond rotation, Vector3d scaling) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)position, (String)"");
        Intrinsics.checkNotNullParameter((Object)positionInModel, (String)"");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"");
        Intrinsics.checkNotNullParameter((Object)scaling, (String)"");
        this.position = var1_1;
        this.positionInModel = var2_2;
        this.rotation = var3_3;
        this.scaling = scaling;
    }

    public /* synthetic */ BodyTransformBuilderImpl(Vector3d vector3d, Vector3d vector3d2, Quaterniond quaterniond, Vector3d vector3d3, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            vector3d = new Vector3d();
        }
        if ((n2 & 2) != 0) {
            vector3d2 = new Vector3d();
        }
        if ((n2 & 4) != 0) {
            quaterniond = new Quaterniond();
        }
        if ((n2 & 8) != 0) {
            vector3d3 = new Vector3d();
        }
        this(vector3d, vector3d2, quaterniond, vector3d3);
    }

    @Override
    @JvmName(name="getPosition")
    public final Vector3d getPosition() {
        return this.position;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setPosition")
    public final void setPosition(Vector3d vector3d) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
        this.position = var1_1;
    }

    @Override
    @JvmName(name="getPositionInModel")
    public final Vector3d getPositionInModel() {
        return this.positionInModel;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setPositionInModel")
    public final void setPositionInModel(Vector3d vector3d) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
        this.positionInModel = var1_1;
    }

    @Override
    @JvmName(name="getRotation")
    public final Quaterniond getRotation() {
        return this.rotation;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setRotation")
    public final void setRotation(Quaterniond quaterniond) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)quaterniond, (String)"");
        this.rotation = var1_1;
    }

    @Override
    @JvmName(name="getScaling")
    public final Vector3d getScaling() {
        return this.scaling;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setScaling")
    public final void setScaling(Vector3d vector3d) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
        this.scaling = var1_1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final BodyTransformBuilderImpl from(BodyTransform transform2) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
        BodyTransformBuilderImpl bodyTransformBuilderImpl = this;
        this.getPosition().set(transform2.getPosition());
        this.getPositionInModel().set(transform2.getPositionInModel());
        this.getRotation().set(transform2.getRotation());
        this.getScaling().set(var1_1.getScaling());
        return bodyTransformBuilderImpl;
    }

    @Override
    public final ShipTransform build() {
        return new BodyTransformImpl(this.getPosition(), this.getRotation(), this.getScaling(), this.getPositionInModel());
    }

    public BodyTransformBuilderImpl() {
        this(null, null, null, null, 15, null);
    }
}


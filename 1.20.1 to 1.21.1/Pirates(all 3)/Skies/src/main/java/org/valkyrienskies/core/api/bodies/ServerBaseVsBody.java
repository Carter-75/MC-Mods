/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.bodies;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3dc;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.bodies.BaseVsBody;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\f\u0010\u0006J'\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\u00020\u000f8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188&@&X\u00a7\u000e\u00a2\u0006\u0012\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\u00020\u00188&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR\u0014\u0010#\u001a\u00020\u000f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u0011R\u0014\u0010'\u001a\u00020$8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006(\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/bodies/ServerBaseVsBody;", "Lorg/valkyrienskies/core/api/bodies/BaseVsBody;", "Lorg/joml/Vector3dc;", "position", "", "setPosition", "(Lorg/joml/Vector3dc;)V", "Lorg/joml/Quaterniondc;", "rotation", "setRotation", "(Lorg/joml/Quaterniondc;)V", "scaling", "setScaling", "setTransform", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;)V", "", "getBuoyantFactor", "()D", "setBuoyantFactor", "(D)V", "buoyantFactor", "getCenterOfMass", "()Lorg/joml/Vector3dc;", "centerOfMass", "", "getDoFluidDrag", "()Z", "setDoFluidDrag", "(Z)V", "getDoFluidDrag$annotations", "()V", "doFluidDrag", "isStatic", "setStatic", "getMass", "mass", "Lorg/joml/Matrix3dc;", "getMomentOfInertia", "()Lorg/joml/Matrix3dc;", "momentOfInertia", "api"})
public interface ServerBaseVsBody
extends BaseVsBody {
    public double getMass();

    @NotNull
    default public Vector3dc getCenterOfMass() {
        return this.getTransform().getPositionInModel();
    }

    @NotNull
    public Matrix3dc getMomentOfInertia();

    public boolean isStatic();

    public void setStatic(boolean var1);

    public double getBuoyantFactor();

    public void setBuoyantFactor(double var1);

    public boolean getDoFluidDrag();

    public void setDoFluidDrag(boolean var1);

    @VsBeta
    public static /* synthetic */ void getDoFluidDrag$annotations() {
    }

    public void setTransform(@NotNull Vector3dc var1, @NotNull Quaterniondc var2, @NotNull Vector3dc var3);

    default public void setPosition(@NotNull Vector3dc position) {
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        this.setTransform(position, this.getTransform().getRotation(), this.getTransform().getScaling());
    }

    default public void setRotation(@NotNull Quaterniondc rotation) {
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
        this.setTransform(this.getTransform().getPosition(), rotation, this.getTransform().getScaling());
    }

    default public void setScaling(@NotNull Vector3dc scaling) {
        Intrinsics.checkNotNullParameter((Object)scaling, (String)"scaling");
        this.setTransform(this.getTransform().getPosition(), this.getTransform().getRotation(), scaling);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.physics;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.internal.physics.VSCollisionShapeData;
import org.valkyrienskies.core.internal.physics.VSCollisionShapes;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2={"Lorg/valkyrienskies/core/internal/physics/VSSphereCollisionShapeData;", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "", "component1", "()D", "radius", "copy", "(D)Lorg/valkyrienskies/core/internal/physics/VSSphereCollisionShapeData;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "D", "getRadius", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapes;", "getShapeType", "()Lorg/valkyrienskies/core/internal/physics/VSCollisionShapes;", "shapeType", "<init>", "(D)V", "internal"})
public final class VSSphereCollisionShapeData
implements VSCollisionShapeData {
    private final double radius;

    public VSSphereCollisionShapeData(double radius) {
        this.radius = radius;
    }

    public final double getRadius() {
        return this.radius;
    }

    @Override
    @NotNull
    public VSCollisionShapes getShapeType() {
        return VSCollisionShapes.SPHERE;
    }

    public final double component1() {
        return this.radius;
    }

    @NotNull
    public final VSSphereCollisionShapeData copy(double radius) {
        return new VSSphereCollisionShapeData(radius);
    }

    public static /* synthetic */ VSSphereCollisionShapeData copy$default(VSSphereCollisionShapeData vSSphereCollisionShapeData, double d2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            d2 = vSSphereCollisionShapeData.radius;
        }
        return vSSphereCollisionShapeData.copy(d2);
    }

    @NotNull
    public String toString() {
        return "VSSphereCollisionShapeData(radius=" + this.radius + ")";
    }

    public int hashCode() {
        return Double.hashCode(this.radius);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSSphereCollisionShapeData)) {
            return false;
        }
        VSSphereCollisionShapeData vSSphereCollisionShapeData = (VSSphereCollisionShapeData)other;
        return Double.compare(this.radius, vSSphereCollisionShapeData.radius) == 0;
    }
}


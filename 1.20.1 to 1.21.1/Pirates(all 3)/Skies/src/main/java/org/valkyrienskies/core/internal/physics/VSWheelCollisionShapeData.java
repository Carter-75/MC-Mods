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

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u00c6\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0006H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001f\u0010\u0004\u00a8\u0006\""}, d2={"Lorg/valkyrienskies/core/internal/physics/VSWheelCollisionShapeData;", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "", "component1", "()D", "component2", "", "component3", "()I", "wheelRadius", "halfThickness", "pointShellSize", "copy", "(DDI)Lorg/valkyrienskies/core/internal/physics/VSWheelCollisionShapeData;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "D", "getHalfThickness", "I", "getPointShellSize", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapes;", "getShapeType", "()Lorg/valkyrienskies/core/internal/physics/VSCollisionShapes;", "shapeType", "getWheelRadius", "<init>", "(DDI)V", "internal"})
public final class VSWheelCollisionShapeData
implements VSCollisionShapeData {
    private final double wheelRadius;
    private final double halfThickness;
    private final int pointShellSize;

    public VSWheelCollisionShapeData(double wheelRadius, double halfThickness, int pointShellSize) {
        this.wheelRadius = wheelRadius;
        this.halfThickness = halfThickness;
        this.pointShellSize = pointShellSize;
    }

    public final double getWheelRadius() {
        return this.wheelRadius;
    }

    public final double getHalfThickness() {
        return this.halfThickness;
    }

    public final int getPointShellSize() {
        return this.pointShellSize;
    }

    @Override
    @NotNull
    public VSCollisionShapes getShapeType() {
        return VSCollisionShapes.WHEEL;
    }

    public final double component1() {
        return this.wheelRadius;
    }

    public final double component2() {
        return this.halfThickness;
    }

    public final int component3() {
        return this.pointShellSize;
    }

    @NotNull
    public final VSWheelCollisionShapeData copy(double wheelRadius, double halfThickness, int pointShellSize) {
        return new VSWheelCollisionShapeData(wheelRadius, halfThickness, pointShellSize);
    }

    public static /* synthetic */ VSWheelCollisionShapeData copy$default(VSWheelCollisionShapeData vSWheelCollisionShapeData, double d2, double d3, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            d2 = vSWheelCollisionShapeData.wheelRadius;
        }
        if ((n3 & 2) != 0) {
            d3 = vSWheelCollisionShapeData.halfThickness;
        }
        if ((n3 & 4) != 0) {
            n2 = vSWheelCollisionShapeData.pointShellSize;
        }
        return vSWheelCollisionShapeData.copy(d2, d3, n2);
    }

    @NotNull
    public String toString() {
        return "VSWheelCollisionShapeData(wheelRadius=" + this.wheelRadius + ", halfThickness=" + this.halfThickness + ", pointShellSize=" + this.pointShellSize + ")";
    }

    public int hashCode() {
        int result2 = Double.hashCode(this.wheelRadius);
        result2 = result2 * 31 + Double.hashCode(this.halfThickness);
        result2 = result2 * 31 + Integer.hashCode(this.pointShellSize);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSWheelCollisionShapeData)) {
            return false;
        }
        VSWheelCollisionShapeData vSWheelCollisionShapeData = (VSWheelCollisionShapeData)other;
        if (Double.compare(this.wheelRadius, vSWheelCollisionShapeData.wheelRadius) != 0) {
            return false;
        }
        if (Double.compare(this.halfThickness, vSWheelCollisionShapeData.halfThickness) != 0) {
            return false;
        }
        return this.pointShellSize == vSWheelCollisionShapeData.pointShellSize;
    }
}


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

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2={"Lorg/valkyrienskies/core/internal/physics/VSCapsuleCollisionShapeData;", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "", "component1", "()D", "component2", "radius", "length", "copy", "(DD)Lorg/valkyrienskies/core/internal/physics/VSCapsuleCollisionShapeData;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "D", "getLength", "getRadius", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapes;", "getShapeType", "()Lorg/valkyrienskies/core/internal/physics/VSCollisionShapes;", "shapeType", "<init>", "(DD)V", "internal"})
public final class VSCapsuleCollisionShapeData
implements VSCollisionShapeData {
    private final double radius;
    private final double length;

    public VSCapsuleCollisionShapeData(double radius, double length) {
        this.radius = radius;
        this.length = length;
    }

    public final double getRadius() {
        return this.radius;
    }

    public final double getLength() {
        return this.length;
    }

    @Override
    @NotNull
    public VSCollisionShapes getShapeType() {
        return VSCollisionShapes.CAPSULE;
    }

    public final double component1() {
        return this.radius;
    }

    public final double component2() {
        return this.length;
    }

    @NotNull
    public final VSCapsuleCollisionShapeData copy(double radius, double length) {
        return new VSCapsuleCollisionShapeData(radius, length);
    }

    public static /* synthetic */ VSCapsuleCollisionShapeData copy$default(VSCapsuleCollisionShapeData vSCapsuleCollisionShapeData, double d2, double d3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            d2 = vSCapsuleCollisionShapeData.radius;
        }
        if ((n2 & 2) != 0) {
            d3 = vSCapsuleCollisionShapeData.length;
        }
        return vSCapsuleCollisionShapeData.copy(d2, d3);
    }

    @NotNull
    public String toString() {
        return "VSCapsuleCollisionShapeData(radius=" + this.radius + ", length=" + this.length + ")";
    }

    public int hashCode() {
        int result2 = Double.hashCode(this.radius);
        result2 = result2 * 31 + Double.hashCode(this.length);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSCapsuleCollisionShapeData)) {
            return false;
        }
        VSCapsuleCollisionShapeData vSCapsuleCollisionShapeData = (VSCapsuleCollisionShapeData)other;
        if (Double.compare(this.radius, vSCapsuleCollisionShapeData.radius) != 0) {
            return false;
        }
        return Double.compare(this.length, vSCapsuleCollisionShapeData.length) == 0;
    }
}


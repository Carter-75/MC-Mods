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

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2={"Lorg/valkyrienskies/core/internal/physics/VSBoxCollisionShapeData;", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "", "component1", "()D", "component2", "component3", "lengthX", "lengthY", "lengthZ", "copy", "(DDD)Lorg/valkyrienskies/core/internal/physics/VSBoxCollisionShapeData;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "D", "getLengthX", "getLengthY", "getLengthZ", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapes;", "getShapeType", "()Lorg/valkyrienskies/core/internal/physics/VSCollisionShapes;", "shapeType", "<init>", "(DDD)V", "internal"})
public final class VSBoxCollisionShapeData
implements VSCollisionShapeData {
    private final double lengthX;
    private final double lengthY;
    private final double lengthZ;

    public VSBoxCollisionShapeData(double lengthX, double lengthY, double lengthZ) {
        this.lengthX = lengthX;
        this.lengthY = lengthY;
        this.lengthZ = lengthZ;
    }

    public final double getLengthX() {
        return this.lengthX;
    }

    public final double getLengthY() {
        return this.lengthY;
    }

    public final double getLengthZ() {
        return this.lengthZ;
    }

    @Override
    @NotNull
    public VSCollisionShapes getShapeType() {
        return VSCollisionShapes.BOX;
    }

    public final double component1() {
        return this.lengthX;
    }

    public final double component2() {
        return this.lengthY;
    }

    public final double component3() {
        return this.lengthZ;
    }

    @NotNull
    public final VSBoxCollisionShapeData copy(double lengthX, double lengthY, double lengthZ) {
        return new VSBoxCollisionShapeData(lengthX, lengthY, lengthZ);
    }

    public static /* synthetic */ VSBoxCollisionShapeData copy$default(VSBoxCollisionShapeData vSBoxCollisionShapeData, double d2, double d3, double d4, int n2, Object object) {
        if ((n2 & 1) != 0) {
            d2 = vSBoxCollisionShapeData.lengthX;
        }
        if ((n2 & 2) != 0) {
            d3 = vSBoxCollisionShapeData.lengthY;
        }
        if ((n2 & 4) != 0) {
            d4 = vSBoxCollisionShapeData.lengthZ;
        }
        return vSBoxCollisionShapeData.copy(d2, d3, d4);
    }

    @NotNull
    public String toString() {
        return "VSBoxCollisionShapeData(lengthX=" + this.lengthX + ", lengthY=" + this.lengthY + ", lengthZ=" + this.lengthZ + ")";
    }

    public int hashCode() {
        int result2 = Double.hashCode(this.lengthX);
        result2 = result2 * 31 + Double.hashCode(this.lengthY);
        result2 = result2 * 31 + Double.hashCode(this.lengthZ);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSBoxCollisionShapeData)) {
            return false;
        }
        VSBoxCollisionShapeData vSBoxCollisionShapeData = (VSBoxCollisionShapeData)other;
        if (Double.compare(this.lengthX, vSBoxCollisionShapeData.lengthX) != 0) {
            return false;
        }
        if (Double.compare(this.lengthY, vSBoxCollisionShapeData.lengthY) != 0) {
            return false;
        }
        return Double.compare(this.lengthZ, vSBoxCollisionShapeData.lengthZ) == 0;
    }
}


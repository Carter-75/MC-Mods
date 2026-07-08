/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.physics.blockstates;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.util.PhysTickOnly;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u001d\u0012\u0006\u0010\t\u001a\u00020\u001d\u0012\u0006\u0010\n\u001a\u00020\u001d\u0012\u0006\u0010\u000b\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001e\u0010\u001fB'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004\u00a8\u0006!"}, d2={"Lorg/valkyrienskies/core/api/physics/blockstates/CollisionPoint;", "", "", "component1", "()D", "component2", "component3", "component4", "x", "y", "z", "radius", "copy", "(DDDD)Lorg/valkyrienskies/core/api/physics/blockstates/CollisionPoint;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "D", "getRadius", "getX", "getY", "getZ", "", "<init>", "(FFFF)V", "(DDDD)V", "api"})
@PhysTickOnly
public final class CollisionPoint {
    private final double x;
    private final double y;
    private final double z;
    private final double radius;

    public CollisionPoint(double x, double y, double z, double radius) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public final double getZ() {
        return this.z;
    }

    public final double getRadius() {
        return this.radius;
    }

    public CollisionPoint(float x, float y, float z, float radius) {
        this((double)x, (double)y, (double)z, (double)radius);
    }

    public final double component1() {
        return this.x;
    }

    public final double component2() {
        return this.y;
    }

    public final double component3() {
        return this.z;
    }

    public final double component4() {
        return this.radius;
    }

    @NotNull
    public final CollisionPoint copy(double x, double y, double z, double radius) {
        return new CollisionPoint(x, y, z, radius);
    }

    public static /* synthetic */ CollisionPoint copy$default(CollisionPoint collisionPoint, double d2, double d3, double d4, double d5, int n2, Object object) {
        if ((n2 & 1) != 0) {
            d2 = collisionPoint.x;
        }
        if ((n2 & 2) != 0) {
            d3 = collisionPoint.y;
        }
        if ((n2 & 4) != 0) {
            d4 = collisionPoint.z;
        }
        if ((n2 & 8) != 0) {
            d5 = collisionPoint.radius;
        }
        return collisionPoint.copy(d2, d3, d4, d5);
    }

    @NotNull
    public String toString() {
        return "CollisionPoint(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", radius=" + this.radius + ")";
    }

    public int hashCode() {
        int result2 = Double.hashCode(this.x);
        result2 = result2 * 31 + Double.hashCode(this.y);
        result2 = result2 * 31 + Double.hashCode(this.z);
        result2 = result2 * 31 + Double.hashCode(this.radius);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollisionPoint)) {
            return false;
        }
        CollisionPoint collisionPoint = (CollisionPoint)other;
        if (Double.compare(this.x, collisionPoint.x) != 0) {
            return false;
        }
        if (Double.compare(this.y, collisionPoint.y) != 0) {
            return false;
        }
        if (Double.compare(this.z, collisionPoint.z) != 0) {
            return false;
        }
        return Double.compare(this.radius, collisionPoint.radius) == 0;
    }
}


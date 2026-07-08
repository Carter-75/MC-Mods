/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBic;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000e\u001a\u00020\r*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001aA\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a\u0019\u0010\u0019\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u001d\u001a\u00020\u0000*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u00a8\u0006\u001f"}, d2={"Lorg/joml/primitives/AABBd;", "", "expansion", "expand", "(Lorg/joml/primitives/AABBd;D)Lorg/joml/primitives/AABBd;", "Lorg/joml/Vector3dc;", "extension", "extend", "(Lorg/joml/primitives/AABBd;Lorg/joml/Vector3dc;)Lorg/joml/primitives/AABBd;", "getSize", "(Lorg/joml/primitives/AABBd;)D", "Lorg/joml/primitives/AABBdc;", "other", "", "intersectsAABB", "(Lorg/joml/primitives/AABBdc;Lorg/joml/primitives/AABBdc;)Z", "minX", "minY", "minZ", "maxX", "maxY", "maxZ", "set", "(Lorg/joml/primitives/AABBd;DDDDDD)Lorg/joml/primitives/AABBd;", "pos", "signedDistanceTo", "(Lorg/joml/primitives/AABBdc;Lorg/joml/Vector3dc;)D", "Lorg/joml/primitives/AABBic;", "dest", "toAABBd", "(Lorg/joml/primitives/AABBic;Lorg/joml/primitives/AABBd;)Lorg/joml/primitives/AABBd;", "util"})
public final class AABBdUtilKt {
    @NotNull
    public static final AABBd set(@NotNull AABBd $this$set, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        AABBd aABBd;
        Intrinsics.checkNotNullParameter((Object)$this$set, (String)"<this>");
        AABBd it = aABBd = $this$set;
        boolean bl = false;
        $this$set.setMin(minX, minY, minZ);
        $this$set.setMax(maxX, maxY, maxZ);
        return aABBd;
    }

    @NotNull
    public static final AABBd expand(@NotNull AABBd $this$expand, double expansion) {
        Intrinsics.checkNotNullParameter((Object)$this$expand, (String)"<this>");
        $this$expand.minX -= expansion;
        $this$expand.minY -= expansion;
        $this$expand.minZ -= expansion;
        $this$expand.maxX += expansion;
        $this$expand.maxY += expansion;
        $this$expand.maxZ += expansion;
        return $this$expand;
    }

    public static final double getSize(@NotNull AABBd $this$getSize) {
        Intrinsics.checkNotNullParameter((Object)$this$getSize, (String)"<this>");
        double d2 = $this$getSize.lengthX();
        double e2 = $this$getSize.lengthY();
        double f2 = $this$getSize.lengthZ();
        return (d2 + e2 + f2) / 3.0;
    }

    @NotNull
    public static final AABBd extend(@NotNull AABBd $this$extend, @NotNull Vector3dc extension) {
        Intrinsics.checkNotNullParameter((Object)$this$extend, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)extension, (String)"extension");
        if (extension.x() > 0.0) {
            $this$extend.maxX += extension.x();
        } else {
            $this$extend.minX += extension.x();
        }
        if (extension.y() > 0.0) {
            $this$extend.maxY += extension.y();
        } else {
            $this$extend.minY += extension.y();
        }
        if (extension.z() > 0.0) {
            $this$extend.maxZ += extension.z();
        } else {
            $this$extend.minZ += extension.z();
        }
        return $this$extend;
    }

    public static final double signedDistanceTo(@NotNull AABBdc $this$signedDistanceTo, @NotNull Vector3dc pos) {
        Intrinsics.checkNotNullParameter((Object)$this$signedDistanceTo, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        boolean isPointInside = $this$signedDistanceTo.containsPoint(pos);
        if (isPointInside) {
            double centerX = ($this$signedDistanceTo.minX() + $this$signedDistanceTo.maxX()) / 2.0;
            double centerY = ($this$signedDistanceTo.minY() + $this$signedDistanceTo.maxY()) / 2.0;
            double centerZ = ($this$signedDistanceTo.minZ() + $this$signedDistanceTo.maxZ()) / 2.0;
            double lenX = ($this$signedDistanceTo.maxX() - $this$signedDistanceTo.minX()) / 2.0;
            double lenY = ($this$signedDistanceTo.maxX() - $this$signedDistanceTo.minX()) / 2.0;
            double lenZ = ($this$signedDistanceTo.maxX() - $this$signedDistanceTo.minX()) / 2.0;
            double relPosX = pos.x() - centerX;
            double relPosY = pos.y() - centerY;
            double relPosZ = pos.z() - centerZ;
            double xDist = lenX - Math.abs(relPosX);
            double yDist = lenY - Math.abs(relPosY);
            double zDist = lenZ - Math.abs(relPosZ);
            return -Math.min(xDist, Math.min(yDist, zDist));
        }
        double closestSurfacePointX = Math.max($this$signedDistanceTo.minX(), Math.min($this$signedDistanceTo.maxX(), pos.x()));
        double closestSurfacePointY = Math.max($this$signedDistanceTo.minY(), Math.min($this$signedDistanceTo.maxY(), pos.y()));
        double closestSurfacePointZ = Math.max($this$signedDistanceTo.minZ(), Math.min($this$signedDistanceTo.maxZ(), pos.z()));
        return pos.distance(closestSurfacePointX, closestSurfacePointY, closestSurfacePointZ);
    }

    @NotNull
    public static final AABBd toAABBd(@NotNull AABBic $this$toAABBd, @NotNull AABBd dest) {
        Intrinsics.checkNotNullParameter((Object)$this$toAABBd, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        dest.minX = $this$toAABBd.minX();
        dest.minY = $this$toAABBd.minY();
        dest.minZ = $this$toAABBd.minZ();
        dest.maxX = $this$toAABBd.maxX();
        dest.maxY = $this$toAABBd.maxY();
        dest.maxZ = $this$toAABBd.maxZ();
        return dest;
    }

    public static final boolean intersectsAABB(@NotNull AABBdc $this$intersectsAABB, @NotNull AABBdc other) {
        Intrinsics.checkNotNullParameter((Object)$this$intersectsAABB, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return $this$intersectsAABB.intersectsAABB((AABBd)other);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package org.valkyrienskies.core.internal.collision;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0018\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u00158&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0019\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;", "", "Lorg/joml/Vector3d;", "output", "computeCenterPos", "(Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "Lorg/joml/primitives/AABBd;", "getEnclosingAABB", "(Lorg/joml/primitives/AABBd;)Lorg/joml/primitives/AABBd;", "Lorg/joml/primitives/AABBdc;", "getAabb", "()Lorg/joml/primitives/AABBdc;", "aabb", "", "Lorg/joml/Vector3dc;", "getNormals", "()Ljava/lang/Iterable;", "normals", "getPoints", "points", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "getShipFrom", "()Ljava/lang/Long;", "shipFrom", "internal"})
@SourceDebugExtension(value={"SMAP\nVsiConvexPolygonc.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VsiConvexPolygonc.kt\norg/valkyrienskies/core/internal/collision/VsiConvexPolygonc\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,50:1\n1863#2,2:51\n*S KotlinDebug\n*F\n+ 1 VsiConvexPolygonc.kt\norg/valkyrienskies/core/internal/collision/VsiConvexPolygonc\n*L\n42#1:51,2\n*E\n"})
public interface VsiConvexPolygonc {
    @NotNull
    public Iterable<Vector3dc> getPoints();

    @NotNull
    public Iterable<Vector3dc> getNormals();

    @Nullable
    public Long getShipFrom();

    @NotNull
    public AABBdc getAabb();

    @NotNull
    default public AABBd getEnclosingAABB(@NotNull AABBd output) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        output.minX = Double.POSITIVE_INFINITY;
        output.minY = Double.POSITIVE_INFINITY;
        output.minZ = Double.POSITIVE_INFINITY;
        output.maxX = Double.NEGATIVE_INFINITY;
        output.maxY = Double.NEGATIVE_INFINITY;
        output.maxZ = Double.NEGATIVE_INFINITY;
        for (Vector3dc point : this.getPoints()) {
            output.minX = Math.min(output.minX, point.x());
            output.minY = Math.min(output.minY, point.y());
            output.minZ = Math.min(output.minZ, point.z());
            output.maxX = Math.max(output.maxX, point.x());
            output.maxY = Math.max(output.maxY, point.y());
            output.maxZ = Math.max(output.maxZ, point.z());
        }
        return output;
    }

    @NotNull
    default public Vector3d computeCenterPos(@NotNull Vector3d output) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        output.zero();
        int pointsCount = 0;
        Iterable<Vector3dc> $this$forEach$iv = this.getPoints();
        boolean $i$f$forEach = false;
        Iterator<Vector3dc> iterator2 = $this$forEach$iv.iterator();
        while (iterator2.hasNext()) {
            Vector3dc element$iv;
            Vector3dc it = element$iv = iterator2.next();
            boolean bl = false;
            output.add(it);
            ++pointsCount;
        }
        if (pointsCount > 0) {
            output.div(pointsCount);
        }
        return output;
    }
}


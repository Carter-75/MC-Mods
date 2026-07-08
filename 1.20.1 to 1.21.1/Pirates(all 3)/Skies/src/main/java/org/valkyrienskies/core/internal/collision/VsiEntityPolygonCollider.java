/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 */
package org.valkyrienskies.core.internal.collision;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4dc;
import org.joml.Vector3dc;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.internal.collision.VsiConvexPolygonc;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JI\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0018\u00010\fj\u0004\u0018\u0001`\r0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rH&\u00a2\u0006\u0004\b\u0014\u0010\u0015\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0016\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/collision/VsiEntityPolygonCollider;", "", "Lorg/joml/Vector3dc;", "movement", "Lorg/joml/primitives/AABBdc;", "entityBoundingBox", "", "entityStepHeight", "", "Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;", "collidingPolygons", "Lkotlin/Pair;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "adjustEntityMovementForPolygonCollisions", "(Lorg/joml/Vector3dc;Lorg/joml/primitives/AABBdc;DLjava/util/List;)Lkotlin/Pair;", "aabb", "Lorg/joml/Matrix4dc;", "transform", "shipFrom", "createPolygonFromAABB", "(Lorg/joml/primitives/AABBdc;Lorg/joml/Matrix4dc;Ljava/lang/Long;)Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;", "internal"})
public interface VsiEntityPolygonCollider {
    @NotNull
    public Pair<Vector3dc, Long> adjustEntityMovementForPolygonCollisions(@NotNull Vector3dc var1, @NotNull AABBdc var2, double var3, @NotNull List<? extends VsiConvexPolygonc> var5);

    @NotNull
    public VsiConvexPolygonc createPolygonFromAABB(@NotNull AABBdc var1, @Nullable Matrix4dc var2, @Nullable Long var3);

    public static /* synthetic */ VsiConvexPolygonc createPolygonFromAABB$default(VsiEntityPolygonCollider vsiEntityPolygonCollider, AABBdc aABBdc, Matrix4dc matrix4dc, Long l2, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPolygonFromAABB");
        }
        if ((n2 & 2) != 0) {
            matrix4dc = null;
        }
        if ((n2 & 4) != 0) {
            l2 = null;
        }
        return vsiEntityPolygonCollider.createPolygonFromAABB(aABBdc, matrix4dc, l2);
    }
}


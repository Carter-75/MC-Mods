/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.collision;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.physics.blockstates.BoxesBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.CollisionPoint;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J+\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\bH&\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a2\u0006\u0004\b\u0010\u0010\u000b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0011\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/collision/VsiSolidShapeUtils;", "", "", "Lorg/joml/primitives/AABBic;", "boxes", "cut", "cutBoxes", "(Ljava/util/List;Lorg/joml/primitives/AABBic;)Ljava/util/List;", "", "Lorg/valkyrienskies/core/api/physics/blockstates/CollisionPoint;", "generateCollisionPointsForBoxes", "(Ljava/util/List;)Ljava/util/List;", "posBoxes", "Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape;", "generateShapeFromBoxes", "(Ljava/util/List;)Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape;", "mergeBoxes", "internal"})
public interface VsiSolidShapeUtils {
    @NotNull
    public List<AABBic> mergeBoxes(@NotNull List<AABBic> var1);

    @NotNull
    public List<AABBic> cutBoxes(@NotNull List<AABBic> var1, @NotNull AABBic var2);

    @NotNull
    public List<CollisionPoint> generateCollisionPointsForBoxes(@NotNull List<? extends AABBic> var1);

    @Nullable
    public BoxesBlockShape generateShapeFromBoxes(@NotNull List<AABBic> var1);
}


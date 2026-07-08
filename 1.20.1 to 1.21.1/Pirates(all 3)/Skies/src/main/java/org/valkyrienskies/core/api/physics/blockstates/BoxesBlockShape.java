/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package org.valkyrienskies.core.api.physics.blockstates;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.physics.blockstates.CollisionPoint;
import org.valkyrienskies.core.api.physics.blockstates.SolidBlockShape;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0005\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\r\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;", "", "Lorg/valkyrienskies/core/api/physics/blockstates/CollisionPoint;", "getCollisionPoints", "()Ljava/util/Collection;", "collisionPoints", "Lorg/joml/primitives/AABBic;", "getNegativeBoxes", "negativeBoxes", "getPositiveBoxes", "positiveBoxes", "Builder", "api"})
public interface BoxesBlockShape
extends SolidBlockShape {
    @NotNull
    public Collection<AABBic> getPositiveBoxes();

    @NotNull
    public Collection<AABBic> getNegativeBoxes();

    @NotNull
    public Collection<CollisionPoint> getCollisionPoints();

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH&\u00a2\u0006\u0004\b\u0007\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H&\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0015\u001a\u00020\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\fH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H&\u00a2\u0006\u0004\b\u0016\u0010\u0013J\u001d\u0010\u0017\u001a\u00020\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\fH\u0016\u00a2\u0006\u0004\b\u0017\u0010\u000fJ\u000f\u0010\u0019\u001a\u00020\u0018H&\u00a2\u0006\u0004\b\u0019\u0010\u001a\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001b\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "", "", "x", "y", "z", "radius", "addCollisionPoint", "(FFFF)Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "Lorg/valkyrienskies/core/api/physics/blockstates/CollisionPoint;", "point", "(Lorg/valkyrienskies/core/api/physics/blockstates/CollisionPoint;)Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "", "points", "addCollisionPoints", "(Ljava/lang/Iterable;)Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "Lorg/joml/primitives/AABBic;", "box", "addNegativeBox", "(Lorg/joml/primitives/AABBic;)Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "boxes", "addNegativeBoxes", "addPositiveBox", "addPositiveBoxes", "Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape;", "build", "()Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape;", "api"})
    @SourceDebugExtension(value={"SMAP\nBoxesBlockShape.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BoxesBlockShape.kt\norg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,89:1\n1#2:90\n1863#3,2:91\n1863#3,2:93\n1863#3,2:95\n*S KotlinDebug\n*F\n+ 1 BoxesBlockShape.kt\norg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder\n*L\n46#1:91,2\n63#1:93,2\n82#1:95,2\n*E\n"})
    public static interface Builder {
        @NotNull
        public Builder addPositiveBox(@NotNull AABBic var1);

        @NotNull
        default public Builder addPositiveBoxes(@NotNull Iterable<? extends AABBic> boxes) {
            Builder builder;
            Intrinsics.checkNotNullParameter(boxes, (String)"boxes");
            Builder it = builder = this;
            boolean bl = false;
            Iterable<? extends AABBic> $this$forEach$iv = boxes;
            boolean $i$f$forEach = false;
            Iterator<? extends AABBic> iterator2 = $this$forEach$iv.iterator();
            while (iterator2.hasNext()) {
                AABBic element$iv;
                AABBic p0 = element$iv = iterator2.next();
                boolean bl2 = false;
                this.addPositiveBox(p0);
            }
            return builder;
        }

        @NotNull
        public Builder addNegativeBox(@NotNull AABBic var1);

        @NotNull
        default public Builder addNegativeBoxes(@NotNull Iterable<? extends AABBic> boxes) {
            Builder builder;
            Intrinsics.checkNotNullParameter(boxes, (String)"boxes");
            Builder it = builder = this;
            boolean bl = false;
            Iterable<? extends AABBic> $this$forEach$iv = boxes;
            boolean $i$f$forEach = false;
            Iterator<? extends AABBic> iterator2 = $this$forEach$iv.iterator();
            while (iterator2.hasNext()) {
                AABBic element$iv;
                AABBic p0 = element$iv = iterator2.next();
                boolean bl2 = false;
                this.addNegativeBox(p0);
            }
            return builder;
        }

        @NotNull
        public Builder addCollisionPoint(float var1, float var2, float var3, float var4);

        @NotNull
        public Builder addCollisionPoint(@NotNull CollisionPoint var1);

        @NotNull
        default public Builder addCollisionPoints(@NotNull Iterable<CollisionPoint> points) {
            Builder builder;
            Intrinsics.checkNotNullParameter(points, (String)"points");
            Builder it = builder = this;
            boolean bl = false;
            Iterable<CollisionPoint> $this$forEach$iv = points;
            boolean $i$f$forEach = false;
            Iterator<CollisionPoint> iterator2 = $this$forEach$iv.iterator();
            while (iterator2.hasNext()) {
                CollisionPoint element$iv;
                CollisionPoint p0 = element$iv = iterator2.next();
                boolean bl2 = false;
                this.addCollisionPoint(p0);
            }
            return builder;
        }

        @NotNull
        public BoxesBlockShape build();
    }
}


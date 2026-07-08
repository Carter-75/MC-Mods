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
import org.joml.Vector3ic;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBi;
import org.joml.primitives.AABBic;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0006*\u00020\u0005H\u0086\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0007\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b\b\u0010\u0003\u001a\u0014\u0010\b\u001a\u00020\u0006*\u00020\u0005H\u0086\u0002\u00a2\u0006\u0004\b\b\u0010\u0007\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u0000H\u0086\u0002\u00a2\u0006\u0004\b\t\u0010\u0003\u001a\u0014\u0010\t\u001a\u00020\u0006*\u00020\u0005H\u0086\u0002\u00a2\u0006\u0004\b\t\u0010\u0007\u001a\u0019\u0010\u000b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a#\u0010\u0011\u001a\u00020\u000f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0003\u001a\u0011\u0010\u0014\u001a\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0003\u001a\u0011\u0010\u0015\u001a\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0003\u001a\u0011\u0010\u0015\u001a\u00020\u0006*\u00020\u0005\u00a2\u0006\u0004\b\u0015\u0010\u0007\u001a\u001b\u0010\u0017\u001a\u00020\u000f*\u00020\u00162\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0017\u0010\u0018\"\u0015\u0010\u001a\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0003\"\u0015\u0010\u001a\u001a\u00020\u0006*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007\"\u0015\u0010\u001c\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0003\"\u0015\u0010\u001c\u001a\u00020\u0006*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007\"\u0015\u0010\u001e\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0003\"\u0015\u0010\u001e\u001a\u00020\u0006*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007\u00a8\u0006\u001f"}, d2={"Lorg/joml/Vector3dc;", "", "addTerms", "(Lorg/joml/Vector3dc;)D", "component1", "Lorg/joml/Vector3ic;", "", "(Lorg/joml/Vector3ic;)I", "component2", "component3", "other", "differenceHorLengthSq", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)D", "Lorg/joml/primitives/AABBic;", "expansion", "Lorg/joml/primitives/AABBi;", "dest", "expand", "(Lorg/joml/primitives/AABBic;ILorg/joml/primitives/AABBi;)Lorg/joml/primitives/AABBi;", "horizontalLength", "horizontalLengthSq", "multiplyTerms", "Lorg/joml/primitives/AABBdc;", "toAABBi", "(Lorg/joml/primitives/AABBdc;Lorg/joml/primitives/AABBi;)Lorg/joml/primitives/AABBi;", "getX", "x", "getY", "y", "getZ", "z", "util"})
public final class VectorConversionsKt {
    public static final int component1(@NotNull Vector3ic $this$component1) {
        Intrinsics.checkNotNullParameter((Object)$this$component1, (String)"<this>");
        return VectorConversionsKt.getX($this$component1);
    }

    public static final int component2(@NotNull Vector3ic $this$component2) {
        Intrinsics.checkNotNullParameter((Object)$this$component2, (String)"<this>");
        return VectorConversionsKt.getY($this$component2);
    }

    public static final int component3(@NotNull Vector3ic $this$component3) {
        Intrinsics.checkNotNullParameter((Object)$this$component3, (String)"<this>");
        return VectorConversionsKt.getZ($this$component3);
    }

    public static final int getX(@NotNull Vector3ic $this$x) {
        Intrinsics.checkNotNullParameter((Object)$this$x, (String)"<this>");
        return $this$x.x();
    }

    public static final int getY(@NotNull Vector3ic $this$y) {
        Intrinsics.checkNotNullParameter((Object)$this$y, (String)"<this>");
        return $this$y.y();
    }

    public static final int getZ(@NotNull Vector3ic $this$z) {
        Intrinsics.checkNotNullParameter((Object)$this$z, (String)"<this>");
        return $this$z.z();
    }

    public static final int multiplyTerms(@NotNull Vector3ic $this$multiplyTerms) {
        Intrinsics.checkNotNullParameter((Object)$this$multiplyTerms, (String)"<this>");
        return VectorConversionsKt.getX($this$multiplyTerms) * VectorConversionsKt.getY($this$multiplyTerms) * VectorConversionsKt.getZ($this$multiplyTerms);
    }

    public static final double component1(@NotNull Vector3dc $this$component1) {
        Intrinsics.checkNotNullParameter((Object)$this$component1, (String)"<this>");
        return VectorConversionsKt.getX($this$component1);
    }

    public static final double component2(@NotNull Vector3dc $this$component2) {
        Intrinsics.checkNotNullParameter((Object)$this$component2, (String)"<this>");
        return VectorConversionsKt.getY($this$component2);
    }

    public static final double component3(@NotNull Vector3dc $this$component3) {
        Intrinsics.checkNotNullParameter((Object)$this$component3, (String)"<this>");
        return VectorConversionsKt.getZ($this$component3);
    }

    public static final double getX(@NotNull Vector3dc $this$x) {
        Intrinsics.checkNotNullParameter((Object)$this$x, (String)"<this>");
        return $this$x.x();
    }

    public static final double getY(@NotNull Vector3dc $this$y) {
        Intrinsics.checkNotNullParameter((Object)$this$y, (String)"<this>");
        return $this$y.y();
    }

    public static final double getZ(@NotNull Vector3dc $this$z) {
        Intrinsics.checkNotNullParameter((Object)$this$z, (String)"<this>");
        return $this$z.z();
    }

    public static final double multiplyTerms(@NotNull Vector3dc $this$multiplyTerms) {
        Intrinsics.checkNotNullParameter((Object)$this$multiplyTerms, (String)"<this>");
        return VectorConversionsKt.getX($this$multiplyTerms) * VectorConversionsKt.getY($this$multiplyTerms) * VectorConversionsKt.getZ($this$multiplyTerms);
    }

    public static final double addTerms(@NotNull Vector3dc $this$addTerms) {
        Intrinsics.checkNotNullParameter((Object)$this$addTerms, (String)"<this>");
        return VectorConversionsKt.getX($this$addTerms) + VectorConversionsKt.getY($this$addTerms) + VectorConversionsKt.getZ($this$addTerms);
    }

    public static final double horizontalLengthSq(@NotNull Vector3dc $this$horizontalLengthSq) {
        Intrinsics.checkNotNullParameter((Object)$this$horizontalLengthSq, (String)"<this>");
        return VectorConversionsKt.getX($this$horizontalLengthSq) * VectorConversionsKt.getX($this$horizontalLengthSq) + VectorConversionsKt.getZ($this$horizontalLengthSq) * VectorConversionsKt.getZ($this$horizontalLengthSq);
    }

    public static final double differenceHorLengthSq(@NotNull Vector3dc $this$differenceHorLengthSq, @NotNull Vector3dc other) {
        Intrinsics.checkNotNullParameter((Object)$this$differenceHorLengthSq, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        double xDif = $this$differenceHorLengthSq.x() - other.x();
        double zDif = $this$differenceHorLengthSq.z() - other.z();
        return xDif * xDif + zDif * zDif;
    }

    public static final double horizontalLength(@NotNull Vector3dc $this$horizontalLength) {
        Intrinsics.checkNotNullParameter((Object)$this$horizontalLength, (String)"<this>");
        return Math.sqrt(VectorConversionsKt.horizontalLengthSq($this$horizontalLength));
    }

    @NotNull
    public static final AABBi toAABBi(@NotNull AABBdc $this$toAABBi, @NotNull AABBi dest) {
        Intrinsics.checkNotNullParameter((Object)$this$toAABBi, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        dest.setMin((int)Math.rint($this$toAABBi.minX()), (int)Math.rint($this$toAABBi.minY()), (int)Math.rint($this$toAABBi.minZ()));
        dest.setMax((int)Math.rint($this$toAABBi.maxX()), (int)Math.rint($this$toAABBi.maxY()), (int)Math.rint($this$toAABBi.maxZ()));
        return dest;
    }

    public static /* synthetic */ AABBi toAABBi$default(AABBdc aABBdc, AABBi aABBi, int n2, Object object) {
        if ((n2 & 1) != 0) {
            aABBi = new AABBi();
        }
        return VectorConversionsKt.toAABBi(aABBdc, aABBi);
    }

    @NotNull
    public static final AABBi expand(@NotNull AABBic $this$expand, int expansion, @NotNull AABBi dest) {
        Intrinsics.checkNotNullParameter((Object)$this$expand, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        dest.minX = $this$expand.minX() - expansion;
        dest.minY = $this$expand.minY() - expansion;
        dest.minZ = $this$expand.minZ() - expansion;
        dest.maxX = $this$expand.maxX() + expansion;
        dest.maxY = $this$expand.maxY() + expansion;
        dest.maxZ = $this$expand.maxZ() + expansion;
        return dest;
    }

    public static /* synthetic */ AABBi expand$default(AABBic aABBic, int n2, AABBi aABBi, int n3, Object object) {
        if ((n3 & 2) != 0) {
            aABBi = new AABBi();
        }
        return VectorConversionsKt.expand(aABBic, n2, aABBi);
    }
}


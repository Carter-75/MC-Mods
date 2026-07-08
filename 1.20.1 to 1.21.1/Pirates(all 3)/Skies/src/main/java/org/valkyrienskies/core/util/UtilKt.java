/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package org.valkyrienskies.core.util;

import java.nio.ByteBuffer;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.valkyrienskies.core.util.VectorConversionsKt;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000N\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aI\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0005H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\u0007\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u0007\u0010\u000b\u001a-\u0010\u000f\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a\u001d\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0012\u001a1\u0010\u0018\u001a\u00020\u0016*\u00020\u00132\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0014H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a1\u0010\u0018\u001a\u00020\u0016*\u00020\u001a2\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0014H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u001b\u001a1\u0010\u0018\u001a\u00020\u0016*\u00020\u00012\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0014H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u001c\u001a1\u0010\u0018\u001a\u00020\u0016*\u00020\u001d2\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0014H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u001e\u001a7\u0010\"\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u00028\u00000 2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160!H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010#\u001aK\u0010\"\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u00028\u00000 2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160!2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150!H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010%\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006&"}, d2={"R", "", "index", "Lorg/joml/Vector3ic;", "dimensions", "Lkotlin/Function3;", "out", "unwrapIndex", "(ILorg/joml/Vector3ic;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lorg/joml/Vector3i;", "v", "(ILorg/joml/Vector3ic;Lorg/joml/Vector3i;)Lorg/joml/Vector3i;", "x", "y", "z", "wrapIndex", "(IIILorg/joml/Vector3ic;)I", "point", "(Lorg/joml/Vector3ic;Lorg/joml/Vector3ic;)I", "Ljava/nio/ByteBuffer;", "Lkotlin/Function2;", "", "", "func", "iterateBits", "(Ljava/nio/ByteBuffer;Lkotlin/jvm/functions/Function2;)V", "", "(BLkotlin/jvm/functions/Function2;)V", "(ILkotlin/jvm/functions/Function2;)V", "", "(JLkotlin/jvm/functions/Function2;)V", "T", "Ljava/util/Queue;", "Lkotlin/Function1;", "pollUntilEmpty", "(Ljava/util/Queue;Lkotlin/jvm/functions/Function1;)V", "predicate", "(Ljava/util/Queue;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "util"})
@SourceDebugExtension(value={"SMAP\nUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Util.kt\norg/valkyrienskies/core/util/UtilKt\n*L\n1#1,77:1\n10#1,5:78\n66#1,5:83\n*S KotlinDebug\n*F\n+ 1 Util.kt\norg/valkyrienskies/core/util/UtilKt\n*L\n37#1:78,5\n60#1:83,5\n*E\n"})
public final class UtilKt {
    public static final void iterateBits(byte $this$iterateBits, @NotNull Function2<? super Boolean, ? super Integer, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        boolean $i$f$iterateBits = false;
        for (int i2 = 7; -1 < i2; --i2) {
            int masked = $this$iterateBits & 1 << i2;
            func.invoke((Object)(masked != 0 ? 1 : 0), (Object)i2);
        }
    }

    public static final void iterateBits(int $this$iterateBits, @NotNull Function2<? super Boolean, ? super Integer, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        boolean $i$f$iterateBits = false;
        for (int i2 = 31; -1 < i2; --i2) {
            int masked = $this$iterateBits & 1 << i2;
            func.invoke((Object)(masked != 0 ? 1 : 0), (Object)i2);
        }
    }

    public static final void iterateBits(long $this$iterateBits, @NotNull Function2<? super Boolean, ? super Integer, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        boolean $i$f$iterateBits = false;
        for (int i2 = 63; -1 < i2; --i2) {
            long masked = $this$iterateBits & 1L << i2;
            func.invoke((Object)(masked != 0L ? 1 : 0), (Object)i2);
        }
    }

    /*
     * WARNING - void declaration
     */
    public static final void iterateBits(@NotNull ByteBuffer $this$iterateBits, @NotNull Function2<? super Boolean, ? super Integer, Unit> func) {
        Intrinsics.checkNotNullParameter((Object)$this$iterateBits, (String)"<this>");
        Intrinsics.checkNotNullParameter(func, (String)"func");
        boolean $i$f$iterateBits = false;
        int i2 = 0;
        int n2 = $this$iterateBits.capacity();
        if (i2 <= n2) {
            while (true) {
                byte by;
                byte $this$iterateBits$iv = by = $this$iterateBits.get(i2);
                boolean $i$f$iterateBits2 = false;
                int i$iv = 7;
                while (-1 < i$iv) {
                    void j2;
                    int n3 = i$iv--;
                    int masked$iv = $this$iterateBits$iv & 1 << i$iv;
                    boolean bit = masked$iv != 0;
                    boolean bl = false;
                    func.invoke((Object)bit, (Object)(i2 * 8 + j2));
                }
                if (i2 == n2) break;
                ++i2;
            }
        }
    }

    public static final <T> void pollUntilEmpty(@NotNull Queue<T> $this$pollUntilEmpty, @NotNull Function1<? super T, Unit> func) {
        Intrinsics.checkNotNullParameter($this$pollUntilEmpty, (String)"<this>");
        Intrinsics.checkNotNullParameter(func, (String)"func");
        boolean $i$f$pollUntilEmpty = false;
        while (true) {
            T t = $this$pollUntilEmpty.poll();
            if (t == null) {
                return;
            }
            func.invoke(t);
        }
    }

    public static final <T> void pollUntilEmpty(@NotNull Queue<T> $this$pollUntilEmpty, @NotNull Function1<? super T, Unit> func, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$pollUntilEmpty, (String)"<this>");
        Intrinsics.checkNotNullParameter(func, (String)"func");
        Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
        boolean $i$f$pollUntilEmpty = false;
        while ($this$pollUntilEmpty.poll() != null) {
            T polled;
            if (!((Boolean)predicate.invoke(polled)).booleanValue()) continue;
            func.invoke(polled);
        }
        return;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Vector3i unwrapIndex(int index, @NotNull Vector3ic dimensions, @NotNull Vector3i v) {
        void z;
        void y;
        Intrinsics.checkNotNullParameter((Object)dimensions, (String)"dimensions");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        boolean $i$f$unwrapIndex = false;
        int z$iv = index / (dimensions.x() * dimensions.y());
        int y$iv = (index - z$iv * dimensions.x() * dimensions.y()) / dimensions.x();
        int x$iv = (index - z$iv * dimensions.x() * dimensions.y()) % dimensions.x();
        int n2 = z$iv;
        int n3 = y$iv;
        int x = x$iv;
        boolean bl = false;
        Vector3i vector3i = v.set(x, (int)y, (int)z);
        Intrinsics.checkNotNullExpressionValue((Object)vector3i, (String)"unwrapIndex(index, dimen\u2026     v.set(x, y, z)\n    }");
        return vector3i;
    }

    public static final <R> R unwrapIndex(int index, @NotNull Vector3ic dimensions, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, ? extends R> out) {
        Intrinsics.checkNotNullParameter((Object)dimensions, (String)"dimensions");
        Intrinsics.checkNotNullParameter(out, (String)"out");
        boolean $i$f$unwrapIndex = false;
        int z = index / (dimensions.x() * dimensions.y());
        int y = (index - z * dimensions.x() * dimensions.y()) / dimensions.x();
        int x = (index - z * dimensions.x() * dimensions.y()) % dimensions.x();
        return (R)out.invoke((Object)x, (Object)y, (Object)z);
    }

    public static final int wrapIndex(int x, int y, int z, @NotNull Vector3ic dimensions) {
        Intrinsics.checkNotNullParameter((Object)dimensions, (String)"dimensions");
        return x + y * VectorConversionsKt.getX(dimensions) + z * VectorConversionsKt.getX(dimensions) * VectorConversionsKt.getY(dimensions);
    }

    public static final int wrapIndex(@NotNull Vector3ic point, @NotNull Vector3ic dimensions) {
        Intrinsics.checkNotNullParameter((Object)point, (String)"point");
        Intrinsics.checkNotNullParameter((Object)dimensions, (String)"dimensions");
        return UtilKt.wrapIndex(VectorConversionsKt.getX(point), VectorConversionsKt.getY(point), VectorConversionsKt.getZ(point), dimensions);
    }
}


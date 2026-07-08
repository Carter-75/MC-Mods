/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package org.valkyrienskies.core.util.datastructures;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.valkyrienskies.core.util.UtilKt;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ%\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\bJ3\u0010\r\u001a\u00020\u000b2\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ'\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u000f\u0010\bJ%\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\bJ'\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001b"}, d2={"Lorg/valkyrienskies/core/util/datastructures/SingleChunkDenseBlockPosSet;", "", "", "x", "y", "z", "", "add", "(III)Z", "contains", "Lkotlin/Function3;", "", "fn", "forEach", "(Lkotlin/jvm/functions/Function3;)V", "isInBounds", "remove", "requireInBounds", "(III)V", "", "data", "[B", "getData", "()[B", "<init>", "()V", "Companion", "util"})
@SourceDebugExtension(value={"SMAP\nSingleChunkDenseBlockPosSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SingleChunkDenseBlockPosSet.kt\norg/valkyrienskies/core/util/datastructures/SingleChunkDenseBlockPosSet\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 Util.kt\norg/valkyrienskies/core/util/UtilKt\n*L\n1#1,79:1\n13477#2,2:80\n13479#2:91\n10#3,3:82\n66#3,5:85\n14#3:90\n*S KotlinDebug\n*F\n+ 1 SingleChunkDenseBlockPosSet.kt\norg/valkyrienskies/core/util/datastructures/SingleChunkDenseBlockPosSet\n*L\n24#1:80,2\n24#1:91\n25#1:82,3\n27#1:85,5\n25#1:90\n*E\n"})
public final class SingleChunkDenseBlockPosSet {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final byte[] data = new byte[512];
    @NotNull
    private static final Vector3ic dimensions = new Vector3i(16, 16, 16);

    @NotNull
    public final byte[] getData() {
        return this.data;
    }

    /*
     * WARNING - void declaration
     */
    public final void forEach(@NotNull Function3<? super Integer, ? super Integer, ? super Integer, Unit> fn) {
        Intrinsics.checkNotNullParameter(fn, (String)"fn");
        boolean $i$f$forEach = false;
        byte[] $this$forEachIndexed$iv = this.getData();
        boolean $i$f$forEachIndexed = false;
        int index$iv = 0;
        for (byte item$iv : $this$forEachIndexed$iv) {
            void byteVal;
            int n2 = index$iv++;
            byte by = item$iv;
            int index = n2;
            boolean bl = false;
            void $this$iterateBits$iv = byteVal;
            boolean $i$f$iterateBits = false;
            for (int i$iv = 7; -1 < i$iv; --i$iv) {
                void z;
                void y;
                void index$iv2;
                void bitIndex;
                int n3 = i$iv;
                int masked$iv = $this$iterateBits$iv & 1 << i$iv;
                boolean isSet = masked$iv != 0;
                boolean bl2 = false;
                if (!isSet) continue;
                int n4 = index * 8 + bitIndex;
                Vector3ic dimensions$iv = Companion.getDimensions();
                boolean $i$f$unwrapIndex = false;
                void z$iv = index$iv2 / (dimensions$iv.x() * dimensions$iv.y());
                void y$iv = (index$iv2 - z$iv * dimensions$iv.x() * dimensions$iv.y()) / dimensions$iv.x();
                void x$iv = (index$iv2 - z$iv * dimensions$iv.x() * dimensions$iv.y()) % dimensions$iv.x();
                void var25_25 = z$iv;
                void var26_26 = y$iv;
                void x = x$iv;
                boolean bl3 = false;
                fn.invoke((Object)((int)x), (Object)((int)y), (Object)((int)z));
            }
        }
    }

    public final boolean remove(int x, int y, int z) {
        this.requireInBounds(x, y, z);
        int index = UtilKt.wrapIndex(x, y, z, dimensions);
        int realIndex = index / 8;
        int offset = index % 8;
        byte prev2 = this.data[realIndex];
        this.data[realIndex] = (byte)(prev2 & (byte)(~(1 << offset)));
        return SingleChunkDenseBlockPosSet.Companion.isBitSet(prev2, offset);
    }

    public final boolean add(int x, int y, int z) {
        this.requireInBounds(x, y, z);
        int index = UtilKt.wrapIndex(x, y, z, dimensions);
        int realIndex = index / 8;
        int offset = index % 8;
        byte prev2 = this.data[realIndex];
        this.data[realIndex] = (byte)(prev2 | (byte)(1 << offset));
        return !SingleChunkDenseBlockPosSet.Companion.isBitSet(prev2, offset);
    }

    public final boolean contains(int x, int y, int z) {
        if (!this.isInBounds(x, y, z)) {
            return false;
        }
        int index = UtilKt.wrapIndex(x, y, z, dimensions);
        int realIndex = index / 8;
        int offset = index % 8;
        return SingleChunkDenseBlockPosSet.Companion.isBitSet(this.data[realIndex], offset);
    }

    private final void requireInBounds(int x, int y, int z) {
        if (!this.isInBounds(x, y, z)) {
            boolean bl = false;
            String string = "Block coordinates (" + x + ", " + y + ", " + z + ") must be within the bounds of the chunk (0 <= x, y, z <= 15)";
            throw new IllegalArgumentException(string.toString());
        }
    }

    private final boolean isInBounds(int x, int y, int z) {
        return x < dimensions.x() && x >= 0 && y < dimensions.y() && y >= 0 && z < dimensions.z() && z >= 0;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2={"Lorg/valkyrienskies/core/util/datastructures/SingleChunkDenseBlockPosSet$Companion;", "", "", "", "bitIndex", "", "isBitSet", "(BI)Z", "Lorg/joml/Vector3ic;", "dimensions", "Lorg/joml/Vector3ic;", "getDimensions", "()Lorg/joml/Vector3ic;", "<init>", "()V", "util"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Vector3ic getDimensions() {
            return dimensions;
        }

        private final boolean isBitSet(byte $this$isBitSet, int bitIndex) {
            return (byte)($this$isBitSet & (byte)(1 << bitIndex)) != 0;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


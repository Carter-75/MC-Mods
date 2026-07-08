/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.IntIterator
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.IntRange
 */
package org.valkyrienskies.core.api.world;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ6\u0010\u0014\u001a\u00020\u00122!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u0011\u0010 \u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006#"}, d2={"Lorg/valkyrienskies/core/api/world/LevelYRange;", "", "", "component1", "()I", "component2", "minY", "maxY", "copy", "(II)Lorg/valkyrienskies/core/api/world/LevelYRange;", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "chunkYPos", "", "lambda", "forEachYChunkPos", "(Lkotlin/jvm/functions/Function1;)V", "hashCode", "", "toString", "()Ljava/lang/String;", "getCenter", "center", "I", "getMaxY", "getMinY", "getSize", "size", "<init>", "(II)V", "api"})
@SourceDebugExtension(value={"SMAP\nLevelYRange.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LevelYRange.kt\norg/valkyrienskies/core/api/world/LevelYRange\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,40:1\n1863#2,2:41\n*S KotlinDebug\n*F\n+ 1 LevelYRange.kt\norg/valkyrienskies/core/api/world/LevelYRange\n*L\n35#1:41,2\n*E\n"})
public final class LevelYRange {
    private final int minY;
    private final int maxY;

    public LevelYRange(int minY, int maxY) {
        this.minY = minY;
        this.maxY = maxY;
        int n2 = this.minY;
        int n3 = 16;
        int n4 = n2 % n3;
        if (n4 + (n3 & ((n4 ^ n3) & (n4 | -n4)) >> 31) != 0) {
            throw new IllegalArgumentException("minY must be congruent to 0 mod 16, but minY = " + this.minY);
        }
        n2 = this.maxY + 1;
        n3 = 16;
        n4 = n2 % n3;
        if (n4 + (n3 & ((n4 ^ n3) & (n4 | -n4)) >> 31) != 0) {
            throw new IllegalArgumentException("maxY must be congruent to 15 mod 16, but maxY = " + this.maxY);
        }
        if (this.maxY < this.minY) {
            throw new IllegalArgumentException("maxY must not be less than minY, but maxY = " + this.maxY + " and minY = " + this.minY);
        }
    }

    public final int getMinY() {
        return this.minY;
    }

    public final int getMaxY() {
        return this.maxY;
    }

    public final int getCenter() {
        return (this.minY + this.maxY + 1) / 2;
    }

    public final int getSize() {
        return this.maxY - this.minY + 1;
    }

    public final void forEachYChunkPos(@NotNull Function1<? super Integer, Unit> lambda) {
        Intrinsics.checkNotNullParameter(lambda, (String)"lambda");
        boolean $i$f$forEachYChunkPos = false;
        Iterable $this$forEach$iv = (Iterable)new IntRange(this.getMinY() >> 4, this.getMaxY() >> 4);
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.iterator();
        while (iterator2.hasNext()) {
            int element$iv;
            int it = element$iv = ((IntIterator)iterator2).nextInt();
            boolean bl = false;
            lambda.invoke((Object)it);
        }
    }

    public final int component1() {
        return this.minY;
    }

    public final int component2() {
        return this.maxY;
    }

    @NotNull
    public final LevelYRange copy(int minY, int maxY) {
        return new LevelYRange(minY, maxY);
    }

    public static /* synthetic */ LevelYRange copy$default(LevelYRange levelYRange, int n2, int n3, int n4, Object object) {
        if ((n4 & 1) != 0) {
            n2 = levelYRange.minY;
        }
        if ((n4 & 2) != 0) {
            n3 = levelYRange.maxY;
        }
        return levelYRange.copy(n2, n3);
    }

    @NotNull
    public String toString() {
        return "LevelYRange(minY=" + this.minY + ", maxY=" + this.maxY + ")";
    }

    public int hashCode() {
        int result2 = Integer.hashCode(this.minY);
        result2 = result2 * 31 + Integer.hashCode(this.maxY);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LevelYRange)) {
            return false;
        }
        LevelYRange levelYRange = (LevelYRange)other;
        if (this.minY != levelYRange.minY) {
            return false;
        }
        return this.maxY == levelYRange.maxY;
    }
}


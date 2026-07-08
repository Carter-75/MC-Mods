/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableSet
 *  com.google.common.collect.ImmutableSet$Builder
 *  io.netty.buffer.ByteBuf
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 */
package org.valkyrienskies.core.util;

import com.google.common.collect.ImmutableSet;
import io.netty.buffer.ByteBuf;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBi;
import org.joml.primitives.AABBic;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u008a\u0001\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\b\u001a!\u0010\f\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0006\b\u0000\u0010\u000e\u0018\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fH\u0086\b\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a?\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0006\b\u0000\u0010\u000e\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0012H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001aE\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f\"\u0004\b\u0000\u0010\u000e\"\u0006\b\u0001\u0010\u0017\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u0016\u001a\u0011\u0010\u001c\u001a\u00020\u001b*\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a\u0011\u0010\u001f\u001a\u00020\u001e*\u00020\u001a\u00a2\u0006\u0004\b\u001f\u0010 \u001a\u0011\u0010!\u001a\u00020\u001b*\u00020\u001a\u00a2\u0006\u0004\b!\u0010\u001d\u001a\u0011\u0010\"\u001a\u00020\u001b*\u00020\u001a\u00a2\u0006\u0004\b\"\u0010\u001d\u001a\u0011\u0010$\u001a\u00020#*\u00020\u001a\u00a2\u0006\u0004\b$\u0010%\u001a\u0011\u0010&\u001a\u00020#*\u00020\u001a\u00a2\u0006\u0004\b&\u0010%\u001a\u0011\u0010(\u001a\u00020'*\u00020'\u00a2\u0006\u0004\b(\u0010)\u001a\u0011\u0010(\u001a\u00020\u0003*\u00020\u0003\u00a2\u0006\u0004\b(\u0010*\u001a#\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00000+\u00a2\u0006\u0004\b-\u0010.\u001a#\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00000/\u00a2\u0006\u0004\b-\u00100\u001a-\u00104\u001a\b\u0012\u0004\u0012\u00028\u000103\"\u0004\b\u0000\u00101\"\b\b\u0001\u00102*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u000003\u00a2\u0006\u0004\b4\u00105\u001a\u0019\u00108\u001a\u00020\n*\u00020\u001a2\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109\u001a\u0019\u0010<\u001a\u00020\n*\u00020\u001a2\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b<\u0010=\u001a\u0019\u0010>\u001a\u00020\n*\u00020\u001a2\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b>\u0010=\u001a\u0019\u0010?\u001a\u00020\n*\u00020\u001a2\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b?\u0010=\u001a\u0019\u0010B\u001a\u00020\n*\u00020\u001a2\u0006\u0010A\u001a\u00020@\u00a2\u0006\u0004\bB\u0010C\u001a\u0019\u0010D\u001a\u00020\n*\u00020\u001a2\u0006\u0010A\u001a\u00020@\u00a2\u0006\u0004\bD\u0010C\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006E"}, d2={"", "x", "Lkotlin/Pair;", "", "asInts", "(J)Lkotlin/Pair;", "y", "asLong", "(II)J", "Lkotlin/Function0;", "", "func", "tryAndPrint", "(Lkotlin/jvm/functions/Function0;)V", "T", "", "filterNotNullToArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "Lkotlin/Function1;", "", "predicate", "filterToArray", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)[Ljava/lang/Object;", "R", "transform", "mapToArray", "Lio/netty/buffer/ByteBuf;", "Lorg/joml/Quaterniond;", "read3FAsNormQuatd", "(Lio/netty/buffer/ByteBuf;)Lorg/joml/Quaterniond;", "Lorg/joml/primitives/AABBi;", "readAABBi", "(Lio/netty/buffer/ByteBuf;)Lorg/joml/primitives/AABBi;", "readQuatd", "readQuatfAsDouble", "Lorg/joml/Vector3d;", "readVec3d", "(Lio/netty/buffer/ByteBuf;)Lorg/joml/Vector3d;", "readVec3fAsDouble", "", "squared", "(D)D", "(I)I", "", "Lcom/google/common/collect/ImmutableSet;", "toImmutableSet", "(Ljava/lang/Iterable;)Lcom/google/common/collect/ImmutableSet;", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;)Lcom/google/common/collect/ImmutableSet;", "A", "B", "Ljava/util/function/Consumer;", "variance", "(Ljava/util/function/Consumer;)Ljava/util/function/Consumer;", "Lorg/joml/primitives/AABBic;", "a", "writeAABBi", "(Lio/netty/buffer/ByteBuf;Lorg/joml/primitives/AABBic;)V", "Lorg/joml/Quaterniondc;", "q", "writeNormQuatdAs3F", "(Lio/netty/buffer/ByteBuf;Lorg/joml/Quaterniondc;)V", "writeQuatd", "writeQuatfAsFloat", "Lorg/joml/Vector3dc;", "v", "writeVec3AsFloat", "(Lio/netty/buffer/ByteBuf;Lorg/joml/Vector3dc;)V", "writeVec3d", "util"})
@SourceDebugExtension(value={"SMAP\nVSCoreUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VSCoreUtil.kt\norg/valkyrienskies/core/util/VSCoreUtilKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,173:1\n144#1:177\n145#1,16:181\n1#2:174\n1317#3,2:175\n12727#4,3:178\n12727#4,3:197\n*S KotlinDebug\n*F\n+ 1 VSCoreUtil.kt\norg/valkyrienskies/core/util/VSCoreUtilKt\n*L\n138#1:177\n138#1:181,16\n29#1:175,2\n138#1:178,3\n144#1:197,3\n*E\n"})
public final class VSCoreUtilKt {
    public static final int squared(int $this$squared) {
        return $this$squared * $this$squared;
    }

    public static final double squared(double $this$squared) {
        return $this$squared * $this$squared;
    }

    @NotNull
    public static final <A, B extends A> Consumer<B> variance(@NotNull Consumer<A> $this$variance) {
        Intrinsics.checkNotNullParameter($this$variance, (String)"<this>");
        return $this$variance;
    }

    @NotNull
    public static final <T> ImmutableSet<T> toImmutableSet(@NotNull Sequence<? extends T> $this$toImmutableSet) {
        ImmutableSet.Builder builder;
        Intrinsics.checkNotNullParameter($this$toImmutableSet, (String)"<this>");
        ImmutableSet.Builder builder2 = builder = ImmutableSet.builder();
        boolean bl = false;
        Sequence<? extends T> $this$forEach$iv = $this$toImmutableSet;
        boolean $i$f$forEach = false;
        Iterator iterator2 = $this$forEach$iv.iterator();
        while (iterator2.hasNext()) {
            Object element$iv;
            Object it = element$iv = iterator2.next();
            boolean bl2 = false;
            builder2.add(it);
        }
        ImmutableSet immutableSet = builder.build();
        Intrinsics.checkNotNullExpressionValue((Object)immutableSet, (String)"builder<T>().also { buil\u2026ilder.add(it) } }.build()");
        return immutableSet;
    }

    @NotNull
    public static final <T> ImmutableSet<T> toImmutableSet(@NotNull Iterable<? extends T> $this$toImmutableSet) {
        Intrinsics.checkNotNullParameter($this$toImmutableSet, (String)"<this>");
        ImmutableSet immutableSet = ImmutableSet.copyOf($this$toImmutableSet);
        Intrinsics.checkNotNullExpressionValue((Object)immutableSet, (String)"copyOf(this)");
        return immutableSet;
    }

    @NotNull
    public static final Vector3d readVec3fAsDouble(@NotNull ByteBuf $this$readVec3fAsDouble) {
        Intrinsics.checkNotNullParameter((Object)$this$readVec3fAsDouble, (String)"<this>");
        return new Vector3d($this$readVec3fAsDouble.readFloat(), $this$readVec3fAsDouble.readFloat(), $this$readVec3fAsDouble.readFloat());
    }

    public static final void writeVec3AsFloat(@NotNull ByteBuf $this$writeVec3AsFloat, @NotNull Vector3dc v) {
        Intrinsics.checkNotNullParameter((Object)$this$writeVec3AsFloat, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        $this$writeVec3AsFloat.writeFloat((float)v.x());
        $this$writeVec3AsFloat.writeFloat((float)v.y());
        $this$writeVec3AsFloat.writeFloat((float)v.z());
    }

    @NotNull
    public static final Quaterniond readQuatfAsDouble(@NotNull ByteBuf $this$readQuatfAsDouble) {
        Intrinsics.checkNotNullParameter((Object)$this$readQuatfAsDouble, (String)"<this>");
        return new Quaterniond($this$readQuatfAsDouble.readFloat(), $this$readQuatfAsDouble.readFloat(), $this$readQuatfAsDouble.readFloat(), $this$readQuatfAsDouble.readFloat());
    }

    public static final void writeQuatfAsFloat(@NotNull ByteBuf $this$writeQuatfAsFloat, @NotNull Quaterniondc q) {
        Intrinsics.checkNotNullParameter((Object)$this$writeQuatfAsFloat, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)q, (String)"q");
        $this$writeQuatfAsFloat.writeFloat((float)q.x());
        $this$writeQuatfAsFloat.writeFloat((float)q.y());
        $this$writeQuatfAsFloat.writeFloat((float)q.z());
        $this$writeQuatfAsFloat.writeFloat((float)q.w());
    }

    public static final void writeNormQuatdAs3F(@NotNull ByteBuf $this$writeNormQuatdAs3F, @NotNull Quaterniondc q) {
        Intrinsics.checkNotNullParameter((Object)$this$writeNormQuatdAs3F, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)q, (String)"q");
        double lengthSq = q.lengthSquared();
        if (Math.abs(lengthSq - 1.0) > 1.0E-12) {
            throw new IllegalArgumentException("The input quaternion " + q + " is not normalized!");
        }
        if (q.w() > 0.0) {
            $this$writeNormQuatdAs3F.writeFloat((float)q.x());
            $this$writeNormQuatdAs3F.writeFloat((float)q.y());
            $this$writeNormQuatdAs3F.writeFloat((float)q.z());
        } else {
            $this$writeNormQuatdAs3F.writeFloat(-((float)q.x()));
            $this$writeNormQuatdAs3F.writeFloat(-((float)q.y()));
            $this$writeNormQuatdAs3F.writeFloat(-((float)q.z()));
        }
    }

    @NotNull
    public static final Quaterniond read3FAsNormQuatd(@NotNull ByteBuf $this$read3FAsNormQuatd) {
        Intrinsics.checkNotNullParameter((Object)$this$read3FAsNormQuatd, (String)"<this>");
        double x = $this$read3FAsNormQuatd.readFloat();
        double y = $this$read3FAsNormQuatd.readFloat();
        double z = $this$read3FAsNormQuatd.readFloat();
        double wSquared = 1.0 - (x * x + y * y + z * z);
        if (wSquared < 0.0) {
            if (wSquared > -1.0E-7) {
                wSquared = 0.0;
            } else {
                throw new IllegalStateException("The computed value for wSquared is " + wSquared + "; which is negative! Did we send a non-normalized quaternion? Or was packet corrupted?");
            }
        }
        double w = Math.sqrt(wSquared);
        Quaterniond quaterniond = new Quaterniond(x, y, z, w).normalize();
        Intrinsics.checkNotNullExpressionValue((Object)quaterniond, (String)"Quaterniond(x, y, z, w).normalize()");
        return quaterniond;
    }

    public static final void writeQuatd(@NotNull ByteBuf $this$writeQuatd, @NotNull Quaterniondc q) {
        Intrinsics.checkNotNullParameter((Object)$this$writeQuatd, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)q, (String)"q");
        $this$writeQuatd.writeDouble(q.x());
        $this$writeQuatd.writeDouble(q.y());
        $this$writeQuatd.writeDouble(q.z());
        $this$writeQuatd.writeDouble(q.w());
    }

    @NotNull
    public static final Quaterniond readQuatd(@NotNull ByteBuf $this$readQuatd) {
        Intrinsics.checkNotNullParameter((Object)$this$readQuatd, (String)"<this>");
        return new Quaterniond($this$readQuatd.readDouble(), $this$readQuatd.readDouble(), $this$readQuatd.readDouble(), $this$readQuatd.readDouble());
    }

    public static final void writeVec3d(@NotNull ByteBuf $this$writeVec3d, @NotNull Vector3dc v) {
        Intrinsics.checkNotNullParameter((Object)$this$writeVec3d, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        $this$writeVec3d.writeDouble(v.x());
        $this$writeVec3d.writeDouble(v.y());
        $this$writeVec3d.writeDouble(v.z());
    }

    @NotNull
    public static final Vector3d readVec3d(@NotNull ByteBuf $this$readVec3d) {
        Intrinsics.checkNotNullParameter((Object)$this$readVec3d, (String)"<this>");
        return new Vector3d($this$readVec3d.readDouble(), $this$readVec3d.readDouble(), $this$readVec3d.readDouble());
    }

    public static final void writeAABBi(@NotNull ByteBuf $this$writeAABBi, @NotNull AABBic a2) {
        Intrinsics.checkNotNullParameter((Object)$this$writeAABBi, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)a2, (String)"a");
        $this$writeAABBi.writeInt(a2.minX());
        $this$writeAABBi.writeInt(a2.minY());
        $this$writeAABBi.writeInt(a2.minZ());
        $this$writeAABBi.writeInt(a2.maxX());
        $this$writeAABBi.writeInt(a2.maxY());
        $this$writeAABBi.writeInt(a2.maxZ());
    }

    @NotNull
    public static final AABBi readAABBi(@NotNull ByteBuf $this$readAABBi) {
        Intrinsics.checkNotNullParameter((Object)$this$readAABBi, (String)"<this>");
        return new AABBi($this$readAABBi.readInt(), $this$readAABBi.readInt(), $this$readAABBi.readInt(), $this$readAABBi.readInt(), $this$readAABBi.readInt(), $this$readAABBi.readInt());
    }

    public static final /* synthetic */ <T, R> R[] mapToArray(T[] $this$mapToArray, Function1<? super T, ? extends R> transform2) {
        Intrinsics.checkNotNullParameter($this$mapToArray, (String)"<this>");
        Intrinsics.checkNotNullParameter(transform2, (String)"transform");
        boolean $i$f$mapToArray = false;
        int n2 = 0;
        int n3 = $this$mapToArray.length;
        Intrinsics.reifiedOperationMarker((int)0, (String)"R");
        Object[] objectArray = new Object[n3];
        while (n2 < n3) {
            int n4 = n2++;
            objectArray[n4] = transform2.invoke($this$mapToArray[n4]);
        }
        return objectArray;
    }

    public static final /* synthetic */ <T> T[] filterNotNullToArray(T[] $this$filterNotNullToArray) {
        boolean bl;
        T it;
        Intrinsics.checkNotNullParameter($this$filterNotNullToArray, (String)"<this>");
        boolean $i$f$filterNotNullToArray = false;
        T[] $this$filterToArray$iv = $this$filterNotNullToArray;
        boolean $i$f$filterToArray = false;
        T[] $this$count$iv$iv = $this$filterToArray$iv;
        int $i$f$count = 0;
        int count$iv$iv = 0;
        int n2 = $this$count$iv$iv.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            T element$iv$iv;
            it = element$iv$iv = $this$count$iv$iv[i2];
            bl = false;
            if (!(it != null)) continue;
            ++count$iv$iv;
        }
        Intrinsics.reifiedOperationMarker((int)0, (String)"T?");
        Object[] newArray$iv = new Object[count$iv$iv];
        int count$iv = 0;
        try {
            int n3 = $this$filterToArray$iv.length;
            for ($i$f$count = 0; $i$f$count < n3; ++$i$f$count) {
                T item$iv;
                it = item$iv = $this$filterToArray$iv[$i$f$count];
                bl = false;
                if (!(it != null)) continue;
                newArray$iv[count$iv++] = item$iv;
            }
        }
        catch (IndexOutOfBoundsException ex$iv) {
            throw new ConcurrentModificationException("Array was modified while filtering", ex$iv);
        }
        if (count$iv != newArray$iv.length) {
            throw new ConcurrentModificationException("Array was modified while filtering");
        }
        return newArray$iv;
    }

    public static final /* synthetic */ <T> T[] filterToArray(T[] $this$filterToArray, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$filterToArray, (String)"<this>");
        Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
        boolean $i$f$filterToArray = false;
        T[] $this$count$iv = $this$filterToArray;
        int $i$f$count = 0;
        int count$iv = 0;
        for (T element$iv : $this$count$iv) {
            if (!((Boolean)predicate.invoke(element$iv)).booleanValue()) continue;
            ++count$iv;
        }
        Intrinsics.reifiedOperationMarker((int)0, (String)"T?");
        Object[] newArray = new Object[count$iv];
        int count2 = 0;
        try {
            for (T item : $this$filterToArray) {
                if (!((Boolean)predicate.invoke(item)).booleanValue()) continue;
                newArray[count2++] = item;
            }
        }
        catch (IndexOutOfBoundsException ex) {
            throw new ConcurrentModificationException("Array was modified while filtering", ex);
        }
        if (count2 != newArray.length) {
            throw new ConcurrentModificationException("Array was modified while filtering");
        }
        return newArray;
    }

    public static final long asLong(int x, int y) {
        return (long)x | (long)y << 32;
    }

    @NotNull
    public static final Pair<Integer, Integer> asInts(long x) {
        return new Pair((Object)((int)x), (Object)((int)(x >> 32)));
    }

    public static final void tryAndPrint(@NotNull Function0<Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        boolean $i$f$tryAndPrint = false;
        try {
            func.invoke();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


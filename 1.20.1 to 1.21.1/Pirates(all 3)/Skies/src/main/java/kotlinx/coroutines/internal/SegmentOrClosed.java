/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@JvmInline
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0081@\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u00d6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\tH\u00d6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00028\u00008F\u00a2\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u0088\u0001\u0019\u0092\u0001\u0004\u0018\u00010\u0003\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2={"Lkotlinx/coroutines/internal/SegmentOrClosed;", "Lkotlinx/coroutines/internal/Segment;", "S", "", "other", "", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "equals", "", "hashCode-impl", "(Ljava/lang/Object;)I", "hashCode", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "isClosed-impl", "(Ljava/lang/Object;)Z", "isClosed", "getSegment-impl", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/Segment;", "getSegment$annotations", "()V", "segment", "value", "Ljava/lang/Object;", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class SegmentOrClosed<S extends Segment<S>> {
    @Nullable
    private final Object value;

    public static final boolean isClosed-impl(Object arg0) {
        return arg0 == ConcurrentLinkedListKt.access$getCLOSED$p();
    }

    @NotNull
    public static final S getSegment-impl(Object arg0) {
        if (arg0 == ConcurrentLinkedListKt.access$getCLOSED$p()) {
            throw new IllegalStateException("Does not contain segment".toString());
        }
        Object object = arg0;
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (Segment)object;
    }

    public static /* synthetic */ void getSegment$annotations() {
    }

    public static String toString-impl(Object arg0) {
        return "SegmentOrClosed(value=" + arg0 + ')';
    }

    public String toString() {
        return SegmentOrClosed.toString-impl(this.value);
    }

    public static int hashCode-impl(Object arg0) {
        Object object = arg0;
        return object == null ? 0 : object.hashCode();
    }

    public int hashCode() {
        return SegmentOrClosed.hashCode-impl(this.value);
    }

    public static boolean equals-impl(Object arg0, Object other) {
        if (!(other instanceof SegmentOrClosed)) {
            return false;
        }
        return Intrinsics.areEqual((Object)arg0, (Object)((SegmentOrClosed)other).unbox-impl());
    }

    public boolean equals(Object other) {
        return SegmentOrClosed.equals-impl(this.value, other);
    }

    private /* synthetic */ SegmentOrClosed(Object value) {
        this.value = value;
    }

    @NotNull
    public static <S extends Segment<S>> Object constructor-impl(@Nullable Object value) {
        return value;
    }

    public static final /* synthetic */ SegmentOrClosed box-impl(Object v) {
        return new SegmentOrClosed(v);
    }

    public final /* synthetic */ Object unbox-impl() {
        return this.value;
    }

    public static final boolean equals-impl0(Object p1, Object p2) {
        return Intrinsics.areEqual((Object)p1, (Object)p2);
    }
}


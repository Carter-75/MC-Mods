/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@JvmInline
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087@\u0018\u0000 %*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003&%'B\u0016\b\u0001\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010\rJ\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000e\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\r\u0010\u0010\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010!\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0011\u0010#\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u001e\u0088\u0001\u0019\u0092\u0001\u0004\u0018\u00010\u0002\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006("}, d2={"Lkotlinx/coroutines/channels/ChannelResult;", "T", "", "other", "", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "equals", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "exceptionOrNull", "getOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrNull", "getOrThrow-impl", "getOrThrow", "", "hashCode-impl", "(Ljava/lang/Object;)I", "hashCode", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "holder", "Ljava/lang/Object;", "getHolder$annotations", "()V", "isClosed-impl", "(Ljava/lang/Object;)Z", "isClosed", "isFailure-impl", "isFailure", "isSuccess-impl", "isSuccess", "constructor-impl", "Companion", "Closed", "Failed", "kotlinx-coroutines-core"})
public final class ChannelResult<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Object holder;
    @NotNull
    private static final Failed failed = new Failed();

    @PublishedApi
    public static /* synthetic */ void getHolder$annotations() {
    }

    public static final boolean isSuccess-impl(Object arg0) {
        return !(arg0 instanceof Failed);
    }

    public static final boolean isFailure-impl(Object arg0) {
        return arg0 instanceof Failed;
    }

    public static final boolean isClosed-impl(Object arg0) {
        return arg0 instanceof Closed;
    }

    @Nullable
    public static final T getOrNull-impl(Object arg0) {
        return !(arg0 instanceof Failed) ? arg0 : null;
    }

    public static final T getOrThrow-impl(Object arg0) {
        if (!(arg0 instanceof Failed)) {
            return arg0;
        }
        if (arg0 instanceof Closed && ((Closed)arg0).cause != null) {
            throw ((Closed)arg0).cause;
        }
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + arg0).toString());
    }

    @Nullable
    public static final Throwable exceptionOrNull-impl(Object arg0) {
        Object object = arg0;
        Closed closed = object instanceof Closed ? (Closed)object : null;
        return closed != null ? closed.cause : null;
    }

    @NotNull
    public static String toString-impl(Object arg0) {
        return arg0 instanceof Closed ? ((Closed)arg0).toString() : "Value(" + arg0 + ')';
    }

    @NotNull
    public String toString() {
        return ChannelResult.toString-impl(this.holder);
    }

    public static int hashCode-impl(Object arg0) {
        Object object = arg0;
        return object == null ? 0 : object.hashCode();
    }

    public int hashCode() {
        return ChannelResult.hashCode-impl(this.holder);
    }

    public static boolean equals-impl(Object arg0, Object other) {
        if (!(other instanceof ChannelResult)) {
            return false;
        }
        return Intrinsics.areEqual((Object)arg0, (Object)((ChannelResult)other).unbox-impl());
    }

    public boolean equals(Object other) {
        return ChannelResult.equals-impl(this.holder, other);
    }

    @PublishedApi
    private /* synthetic */ ChannelResult(Object holder) {
        this.holder = holder;
    }

    @PublishedApi
    @NotNull
    public static <T> Object constructor-impl(@Nullable Object holder) {
        return holder;
    }

    public static final /* synthetic */ ChannelResult box-impl(Object v) {
        return new ChannelResult(v);
    }

    public final /* synthetic */ Object unbox-impl() {
        return this.holder;
    }

    public static final boolean equals-impl0(Object p1, Object p2) {
        return Intrinsics.areEqual((Object)p1, (Object)p2);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2={"Lkotlinx/coroutines/channels/ChannelResult$Closed;", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "cause", "Ljava/lang/Throwable;", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"})
    public static final class Closed
    extends Failed {
        @JvmField
        @Nullable
        public final Throwable cause;

        public Closed(@Nullable Throwable cause) {
            this.cause = cause;
        }

        public boolean equals(@Nullable Object other) {
            return other instanceof Closed && Intrinsics.areEqual((Object)this.cause, (Object)((Closed)other).cause);
        }

        public int hashCode() {
            Throwable throwable = this.cause;
            return throwable != null ? throwable.hashCode() : 0;
        }

        @Override
        @NotNull
        public String toString() {
            return "Closed(" + this.cause + ')';
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J.\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u0002H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b\t\u0010\nJ,\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u00022\u0006\u0010\f\u001a\u00028\u0001H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2={"Lkotlinx/coroutines/channels/ChannelResult$Companion;", "", "E", "", "cause", "Lkotlinx/coroutines/channels/ChannelResult;", "closed-JP2dKIU", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "closed", "failure-PtdJZtk", "()Ljava/lang/Object;", "failure", "value", "success-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "success", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "failed", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "<init>", "()V", "kotlinx-coroutines-core"})
    @InternalCoroutinesApi
    public static final class Companion {
        private Companion() {
        }

        @InternalCoroutinesApi
        @NotNull
        public final <E> Object success-JP2dKIU(E value) {
            return ChannelResult.constructor-impl(value);
        }

        @InternalCoroutinesApi
        @NotNull
        public final <E> Object failure-PtdJZtk() {
            return ChannelResult.constructor-impl(failed);
        }

        @InternalCoroutinesApi
        @NotNull
        public final <E> Object closed-JP2dKIU(@Nullable Throwable cause) {
            return ChannelResult.constructor-impl(new Closed(cause));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2={"Lkotlinx/coroutines/channels/ChannelResult$Failed;", "", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "kotlinx-coroutines-core"})
    public static class Failed {
        @NotNull
        public String toString() {
            return "Failed";
        }
    }
}


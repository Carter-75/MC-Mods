/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\\\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b.\u0010/J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J-\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0003J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011Jg\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dH\u00d6\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\"\u001a\u00020\f2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030 2\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$H\u00d6\u0001\u00a2\u0006\u0004\b%\u0010&R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010'R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010(R\u0011\u0010+\u001a\u00020\u001a8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010,R1\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010-R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010,\u00a8\u00060"}, d2={"Lkotlinx/coroutines/CompletedContinuation;", "", "component1", "()Ljava/lang/Object;", "Lkotlinx/coroutines/CancelHandler;", "component2", "()Lkotlinx/coroutines/CancelHandler;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "component3", "()Lkotlin/jvm/functions/Function1;", "component4", "component5", "()Ljava/lang/Throwable;", "result", "cancelHandler", "onCancellation", "idempotentResume", "cancelCause", "copy", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;)Lkotlinx/coroutines/CompletedContinuation;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lkotlinx/coroutines/CancellableContinuationImpl;", "cont", "invokeHandlers", "(Lkotlinx/coroutines/CancellableContinuationImpl;Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "Lkotlinx/coroutines/CancelHandler;", "getCancelled", "()Z", "cancelled", "Ljava/lang/Object;", "Lkotlin/jvm/functions/Function1;", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CompletedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,662:1\n1#2:663\n*E\n"})
final class CompletedContinuation {
    @JvmField
    @Nullable
    public final Object result;
    @JvmField
    @Nullable
    public final CancelHandler cancelHandler;
    @JvmField
    @Nullable
    public final Function1<Throwable, Unit> onCancellation;
    @JvmField
    @Nullable
    public final Object idempotentResume;
    @JvmField
    @Nullable
    public final Throwable cancelCause;

    public CompletedContinuation(@Nullable Object result2, @Nullable CancelHandler cancelHandler, @Nullable Function1<? super Throwable, Unit> onCancellation, @Nullable Object idempotentResume, @Nullable Throwable cancelCause) {
        this.result = result2;
        this.cancelHandler = cancelHandler;
        this.onCancellation = onCancellation;
        this.idempotentResume = idempotentResume;
        this.cancelCause = cancelCause;
    }

    public /* synthetic */ CompletedContinuation(Object object, CancelHandler cancelHandler, Function1 function1, Object object2, Throwable throwable, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            cancelHandler = null;
        }
        if ((n2 & 4) != 0) {
            function1 = null;
        }
        if ((n2 & 8) != 0) {
            object2 = null;
        }
        if ((n2 & 0x10) != 0) {
            throwable = null;
        }
        this(object, cancelHandler, (Function1<? super Throwable, Unit>)function1, object2, throwable);
    }

    public final boolean getCancelled() {
        return this.cancelCause != null;
    }

    public final void invokeHandlers(@NotNull CancellableContinuationImpl<?> cont, @NotNull Throwable cause) {
        block1: {
            Function1<Throwable, Unit> it;
            Function1<Throwable, Unit> function1 = this.cancelHandler;
            if (function1 != null) {
                it = function1;
                boolean bl = false;
                cont.callCancelHandler((CancelHandler)it, cause);
            }
            Function1<Throwable, Unit> function12 = this.onCancellation;
            if (function12 == null) break block1;
            it = function12;
            boolean bl = false;
            cont.callOnCancellation(it, cause);
        }
    }

    @Nullable
    public final Object component1() {
        return this.result;
    }

    @Nullable
    public final CancelHandler component2() {
        return this.cancelHandler;
    }

    @Nullable
    public final Function1<Throwable, Unit> component3() {
        return this.onCancellation;
    }

    @Nullable
    public final Object component4() {
        return this.idempotentResume;
    }

    @Nullable
    public final Throwable component5() {
        return this.cancelCause;
    }

    @NotNull
    public final CompletedContinuation copy(@Nullable Object result2, @Nullable CancelHandler cancelHandler, @Nullable Function1<? super Throwable, Unit> onCancellation, @Nullable Object idempotentResume, @Nullable Throwable cancelCause) {
        return new CompletedContinuation(result2, cancelHandler, onCancellation, idempotentResume, cancelCause);
    }

    public static /* synthetic */ CompletedContinuation copy$default(CompletedContinuation completedContinuation, Object object, CancelHandler cancelHandler, Function1 function1, Object object2, Throwable throwable, int n2, Object object3) {
        if ((n2 & 1) != 0) {
            object = completedContinuation.result;
        }
        if ((n2 & 2) != 0) {
            cancelHandler = completedContinuation.cancelHandler;
        }
        if ((n2 & 4) != 0) {
            function1 = completedContinuation.onCancellation;
        }
        if ((n2 & 8) != 0) {
            object2 = completedContinuation.idempotentResume;
        }
        if ((n2 & 0x10) != 0) {
            throwable = completedContinuation.cancelCause;
        }
        return completedContinuation.copy(object, cancelHandler, function1, object2, throwable);
    }

    @NotNull
    public String toString() {
        return "CompletedContinuation(result=" + this.result + ", cancelHandler=" + this.cancelHandler + ", onCancellation=" + this.onCancellation + ", idempotentResume=" + this.idempotentResume + ", cancelCause=" + this.cancelCause + ')';
    }

    public int hashCode() {
        int result2 = this.result == null ? 0 : this.result.hashCode();
        result2 = result2 * 31 + (this.cancelHandler == null ? 0 : this.cancelHandler.hashCode());
        result2 = result2 * 31 + (this.onCancellation == null ? 0 : this.onCancellation.hashCode());
        result2 = result2 * 31 + (this.idempotentResume == null ? 0 : this.idempotentResume.hashCode());
        result2 = result2 * 31 + (this.cancelCause == null ? 0 : this.cancelCause.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation)other;
        if (!Intrinsics.areEqual((Object)this.result, (Object)completedContinuation.result)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.cancelHandler, (Object)completedContinuation.cancelHandler)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.onCancellation, completedContinuation.onCancellation)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.idempotentResume, (Object)completedContinuation.idempotentResume)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.cancelCause, (Object)completedContinuation.cancelCause);
    }
}


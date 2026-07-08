/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0005\u001a\u00020\u00042\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\t\u001a\u00020\u00042\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0082\b\u00a2\u0006\u0004\b\t\u0010\n\u001a%\u0010\f\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00040\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a@\u0010\f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u000e*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\u0011\u001a{\u0010\f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u000e*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00132\u0006\u0010\u0014\u001a\u00028\u00002\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002%\b\u0002\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2={"Lkotlin/coroutines/Continuation;", "completion", "", "e", "", "dispatcherFailure", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;)V", "Lkotlin/Function0;", "block", "runSafely", "(Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function0;)V", "fatalCompletion", "startCoroutineCancellable", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/Continuation;)V", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "Lkotlin/ParameterName;", "name", "cause", "onCancellation", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nCancellable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cancellable.kt\nkotlinx/coroutines/intrinsics/CancellableKt\n*L\n1#1,68:1\n49#1,6:69\n49#1,6:75\n49#1,6:81\n*S KotlinDebug\n*F\n+ 1 Cancellable.kt\nkotlinx/coroutines/intrinsics/CancellableKt\n*L\n17#1:69,6\n29#1:75,6\n38#1:81,6\n*E\n"})
public final class CancellableKt {
    @InternalCoroutinesApi
    public static final <T> void startCoroutineCancellable(@NotNull Function1<? super Continuation<? super T>, ? extends Object> $this$startCoroutineCancellable, @NotNull Continuation<? super T> completion) {
        boolean $i$f$runSafely = false;
        try {
            boolean bl = false;
            DispatchedContinuationKt.resumeCancellableWith$default(IntrinsicsKt.intercepted((Continuation)IntrinsicsKt.createCoroutineUnintercepted($this$startCoroutineCancellable, completion)), Result.constructor-impl((Object)Unit.INSTANCE), null, 2, null);
        }
        catch (Throwable e$iv) {
            CancellableKt.dispatcherFailure(completion, e$iv);
        }
    }

    public static final <R, T> void startCoroutineCancellable(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> $this$startCoroutineCancellable, R receiver, @NotNull Continuation<? super T> completion, @Nullable Function1<? super Throwable, Unit> onCancellation) {
        boolean $i$f$runSafely = false;
        try {
            boolean bl = false;
            DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt.intercepted((Continuation)IntrinsicsKt.createCoroutineUnintercepted($this$startCoroutineCancellable, receiver, completion)), Result.constructor-impl((Object)Unit.INSTANCE), onCancellation);
        }
        catch (Throwable e$iv) {
            CancellableKt.dispatcherFailure(completion, e$iv);
        }
    }

    public static /* synthetic */ void startCoroutineCancellable$default(Function2 function2, Object object, Continuation continuation, Function1 function1, int n2, Object object2) {
        if ((n2 & 4) != 0) {
            function1 = null;
        }
        CancellableKt.startCoroutineCancellable(function2, object, continuation, (Function1<? super Throwable, Unit>)function1);
    }

    public static final void startCoroutineCancellable(@NotNull Continuation<? super Unit> $this$startCoroutineCancellable, @NotNull Continuation<?> fatalCompletion) {
        boolean $i$f$runSafely = false;
        try {
            boolean bl = false;
            DispatchedContinuationKt.resumeCancellableWith$default(IntrinsicsKt.intercepted($this$startCoroutineCancellable), Result.constructor-impl((Object)Unit.INSTANCE), null, 2, null);
        }
        catch (Throwable e$iv) {
            CancellableKt.dispatcherFailure(fatalCompletion, e$iv);
        }
    }

    private static final void runSafely(Continuation<?> completion, Function0<Unit> block) {
        boolean $i$f$runSafely = false;
        try {
            block.invoke();
        }
        catch (Throwable e2) {
            CancellableKt.dispatcherFailure(completion, e2);
        }
    }

    private static final void dispatcherFailure(Continuation<?> completion, Throwable e2) {
        completion.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)e2)));
        throw e2;
    }
}


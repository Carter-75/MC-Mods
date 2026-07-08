/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a:\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004H\u0081H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a:\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004H\u0081H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\u0007\u001a'\u0010\f\u001a\u00020\u0003\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u0010\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2={"R", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builder", "selectOld", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUnbiasedOld", "T", "Lkotlinx/coroutines/CancellableContinuation;", "result", "resumeUndispatched", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;)V", "", "exception", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"})
public final class SelectOldKt {
    @PublishedApi
    @Nullable
    public static final <R> Object selectOld(@NotNull Function1<? super SelectBuilder<? super R>, Unit> builder, @NotNull Continuation<? super R> $completion) {
        boolean $i$f$selectOld = false;
        Continuation<? super R> uCont = $completion;
        boolean bl = false;
        SelectBuilderImpl<R> scope = new SelectBuilderImpl<R>(uCont);
        try {
            builder.invoke(scope);
        }
        catch (Throwable e2) {
            scope.handleBuilderException(e2);
        }
        Object object = scope.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    @PublishedApi
    private static final <R> Object selectOld$$forInline(Function1<? super SelectBuilder<? super R>, Unit> builder, Continuation<? super R> $completion) {
        boolean $i$f$selectOld = false;
        InlineMarker.mark((int)0);
        Continuation<? super R> uCont = $completion;
        boolean bl = false;
        SelectBuilderImpl<R> scope = new SelectBuilderImpl<R>(uCont);
        try {
            builder.invoke(scope);
        }
        catch (Throwable e2) {
            scope.handleBuilderException(e2);
        }
        Object object = scope.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        InlineMarker.mark((int)1);
        return object;
    }

    @PublishedApi
    @Nullable
    public static final <R> Object selectUnbiasedOld(@NotNull Function1<? super SelectBuilder<? super R>, Unit> builder, @NotNull Continuation<? super R> $completion) {
        boolean $i$f$selectUnbiasedOld = false;
        Continuation<? super R> uCont = $completion;
        boolean bl = false;
        UnbiasedSelectBuilderImpl<R> scope = new UnbiasedSelectBuilderImpl<R>(uCont);
        try {
            builder.invoke(scope);
        }
        catch (Throwable e2) {
            scope.handleBuilderException(e2);
        }
        Object object = scope.initSelectResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    @PublishedApi
    private static final <R> Object selectUnbiasedOld$$forInline(Function1<? super SelectBuilder<? super R>, Unit> builder, Continuation<? super R> $completion) {
        boolean $i$f$selectUnbiasedOld = false;
        InlineMarker.mark((int)0);
        Continuation<? super R> uCont = $completion;
        boolean bl = false;
        UnbiasedSelectBuilderImpl<R> scope = new UnbiasedSelectBuilderImpl<R>(uCont);
        try {
            builder.invoke(scope);
        }
        catch (Throwable e2) {
            scope.handleBuilderException(e2);
        }
        Object object = scope.initSelectResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        InlineMarker.mark((int)1);
        return object;
    }

    private static final <T> void resumeUndispatched(CancellableContinuation<? super T> $this$resumeUndispatched, T result2) {
        CoroutineDispatcher dispatcher = (CoroutineDispatcher)$this$resumeUndispatched.getContext().get((CoroutineContext.Key)CoroutineDispatcher.Key);
        if (dispatcher != null) {
            $this$resumeUndispatched.resumeUndispatched(dispatcher, result2);
        } else {
            ((Continuation)$this$resumeUndispatched).resumeWith(Result.constructor-impl(result2));
        }
    }

    private static final void resumeUndispatchedWithException(CancellableContinuation<?> $this$resumeUndispatchedWithException, Throwable exception) {
        CoroutineDispatcher dispatcher = (CoroutineDispatcher)$this$resumeUndispatchedWithException.getContext().get((CoroutineContext.Key)CoroutineDispatcher.Key);
        if (dispatcher != null) {
            $this$resumeUndispatchedWithException.resumeUndispatchedWithException(dispatcher, exception);
        } else {
            ((Continuation)$this$resumeUndispatchedWithException).resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)exception)));
        }
    }

    public static final /* synthetic */ void access$resumeUndispatchedWithException(CancellableContinuation $receiver, Throwable exception) {
        SelectOldKt.resumeUndispatchedWithException($receiver, exception);
    }

    public static final /* synthetic */ void access$resumeUndispatched(CancellableContinuation $receiver, Object result2) {
        SelectOldKt.resumeUndispatched($receiver, result2);
    }
}


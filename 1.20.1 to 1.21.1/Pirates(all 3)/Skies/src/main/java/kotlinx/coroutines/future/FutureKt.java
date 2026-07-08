/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.future;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.future.CompletableFutureCoroutine;
import kotlinx.coroutines.future.ContinuationHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002*\u00020\u0005\u00a2\u0006\u0004\b\u0003\u0010\u0007\u001a#\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0004\b\t\u0010\n\u001a#\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a]\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102'\u0010\u0016\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012\u00a2\u0006\u0002\b\u0015\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a\u001f\u0010\u0019\u001a\u00020\u0006*\u00020\u00052\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2={"T", "Lkotlinx/coroutines/Deferred;", "Ljava/util/concurrent/CompletableFuture;", "asCompletableFuture", "(Lkotlinx/coroutines/Deferred;)Ljava/util/concurrent/CompletableFuture;", "Lkotlinx/coroutines/Job;", "", "(Lkotlinx/coroutines/Job;)Ljava/util/concurrent/CompletableFuture;", "Ljava/util/concurrent/CompletionStage;", "asDeferred", "(Ljava/util/concurrent/CompletionStage;)Lkotlinx/coroutines/Deferred;", "await", "(Ljava/util/concurrent/CompletionStage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "future", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Ljava/util/concurrent/CompletableFuture;", "setupCancellation", "(Lkotlinx/coroutines/Job;Ljava/util/concurrent/CompletableFuture;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nFuture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,197:1\n1#2:198\n314#3,11:199\n*S KotlinDebug\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n*L\n172#1:199,11\n*E\n"})
public final class FutureKt {
    @NotNull
    public static final <T> CompletableFuture<T> future(@NotNull CoroutineScope $this$future, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        if (!(!start.isLazy())) {
            boolean $i$a$-require-FutureKt$future$22 = false;
            String $i$a$-require-FutureKt$future$22 = (Object)((Object)start) + " start is not supported";
            throw new IllegalArgumentException($i$a$-require-FutureKt$future$22.toString());
        }
        CoroutineContext newContext = CoroutineContextKt.newCoroutineContext($this$future, context);
        CompletableFuture future = new CompletableFuture();
        CompletableFutureCoroutine coroutine = new CompletableFutureCoroutine(newContext, future);
        future.handle((BiFunction)coroutine);
        coroutine.start(start, coroutine, block);
        return future;
    }

    public static /* synthetic */ CompletableFuture future$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return FutureKt.future(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    @NotNull
    public static final <T> CompletableFuture<T> asCompletableFuture(@NotNull Deferred<? extends T> $this$asCompletableFuture) {
        CompletableFuture future = new CompletableFuture();
        FutureKt.setupCancellation($this$asCompletableFuture, future);
        $this$asCompletableFuture.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(future, $this$asCompletableFuture){
            final /* synthetic */ CompletableFuture<T> $future;
            final /* synthetic */ Deferred<T> $this_asCompletableFuture;
            {
                this.$future = $future;
                this.$this_asCompletableFuture = $receiver;
                super(1);
            }

            public final void invoke(@Nullable Throwable it) {
                try {
                    this.$future.complete(this.$this_asCompletableFuture.getCompleted());
                }
                catch (Throwable t) {
                    this.$future.completeExceptionally(t);
                }
            }
        }));
        return future;
    }

    @NotNull
    public static final CompletableFuture<Unit> asCompletableFuture(@NotNull Job $this$asCompletableFuture) {
        CompletableFuture<Unit> future = new CompletableFuture<Unit>();
        FutureKt.setupCancellation($this$asCompletableFuture, future);
        $this$asCompletableFuture.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(future){
            final /* synthetic */ CompletableFuture<Unit> $future;
            {
                this.$future = $future;
                super(1);
            }

            public final void invoke(@Nullable Throwable cause) {
                if (cause == null) {
                    this.$future.complete(Unit.INSTANCE);
                } else {
                    this.$future.completeExceptionally(cause);
                }
            }
        }));
        return future;
    }

    private static final void setupCancellation(Job $this$setupCancellation, CompletableFuture<?> future) {
        future.handle((arg_0, arg_1) -> FutureKt.setupCancellation$lambda$2($this$setupCancellation, arg_0, arg_1));
    }

    @NotNull
    public static final <T> Deferred<T> asDeferred(@NotNull CompletionStage<T> $this$asDeferred) {
        CompletableFuture<T> future = $this$asDeferred.toCompletableFuture();
        if (future.isDone()) {
            Deferred deferred;
            try {
                deferred = CompletableDeferredKt.CompletableDeferred(future.get());
            }
            catch (Throwable e2) {
                CompletableDeferred completableDeferred;
                Throwable throwable = e2 instanceof ExecutionException ? (ExecutionException)e2 : null;
                if (throwable == null || (throwable = throwable.getCause()) == null) {
                    throwable = e2;
                }
                Throwable original = throwable;
                CompletableDeferred it = completableDeferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                boolean bl = false;
                it.completeExceptionally(original);
                deferred = completableDeferred;
            }
            return deferred;
        }
        CompletableDeferred result2 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        $this$asDeferred.handle((arg_0, arg_1) -> FutureKt.asDeferred$lambda$4((Function2)new Function2<T, Throwable, Object>(result2){
            final /* synthetic */ CompletableDeferred<T> $result;
            {
                this.$result = $result;
                super(2);
            }

            public final Object invoke(T value, Throwable exception) {
                Object object;
                try {
                    boolean bl;
                    if (exception == null) {
                        bl = this.$result.complete(value);
                    } else {
                        Throwable throwable = exception instanceof CompletionException ? (CompletionException)exception : null;
                        if (throwable == null || (throwable = throwable.getCause()) == null) {
                            throwable = exception;
                        }
                        bl = this.$result.completeExceptionally(throwable);
                    }
                    object = bl;
                }
                catch (Throwable e2) {
                    CoroutineExceptionHandlerKt.handleCoroutineException((CoroutineContext)EmptyCoroutineContext.INSTANCE, e2);
                    object = Unit.INSTANCE;
                }
                return object;
            }
        }, arg_0, arg_1));
        JobKt.cancelFutureOnCompletion(result2, (Future)future);
        return result2;
    }

    @Nullable
    public static final <T> Object await(@NotNull CompletionStage<T> $this$await, @NotNull Continuation<? super T> $completion) {
        CompletableFuture<T> future = $this$await.toCompletableFuture();
        if (future.isDone()) {
            try {
                return future.get();
            }
            catch (ExecutionException e2) {
                Throwable throwable = e2.getCause();
                if (throwable == null) {
                    throwable = e2;
                }
                throw throwable;
            }
        }
        boolean $i$f$suspendCancellableCoroutine = false;
        Continuation<? super T> uCont$iv = $completion;
        boolean bl = false;
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
        cancellable$iv.initCancellability();
        CancellableContinuation cont = cancellable$iv;
        boolean bl2 = false;
        ContinuationHandler consumer = new ContinuationHandler(cont);
        $this$await.handle(consumer);
        cont.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)new Function1<Throwable, Unit>(future, consumer){
            final /* synthetic */ CompletableFuture<T> $future;
            final /* synthetic */ ContinuationHandler<T> $consumer;
            {
                this.$future = $future;
                this.$consumer = $consumer;
                super(1);
            }

            public final void invoke(@Nullable Throwable it) {
                this.$future.cancel(false);
                this.$consumer.cont = null;
            }
        }));
        Object object = cancellable$iv.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit setupCancellation$lambda$2(Job $this_setupCancellation, Object object, Throwable exception) {
        CancellationException cancellationException;
        Job job = $this_setupCancellation;
        Throwable throwable = exception;
        if (throwable != null) {
            void it;
            Throwable throwable2 = throwable;
            Job job2 = job;
            boolean bl = false;
            CancellationException cancellationException2 = it instanceof CancellationException ? (CancellationException)it : null;
            if (cancellationException2 == null) {
                cancellationException2 = ExceptionsKt.CancellationException("CompletableFuture was completed exceptionally", (Throwable)it);
            }
            cancellationException = cancellationException2;
            job = job2;
        } else {
            cancellationException = null;
        }
        job.cancel(cancellationException);
        return Unit.INSTANCE;
    }

    private static final Object asDeferred$lambda$4(Function2 $tmp0, Object p0, Throwable p1) {
        return $tmp0.invoke(p0, (Object)p1);
    }
}


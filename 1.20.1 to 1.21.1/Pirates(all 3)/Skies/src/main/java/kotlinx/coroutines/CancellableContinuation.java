/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function1
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002J\u001b\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH'\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH'\u00a2\u0006\u0004\b\r\u0010\u000eJ8\u0010\u0014\u001a\u00020\n2'\u0010\u0013\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\n0\u000fj\u0002`\u0012H&\u00a2\u0006\u0004\b\u0014\u0010\u0015J<\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00028\u00002#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH'\u00a2\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00028\u00002\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\bH'\u00a2\u0006\u0004\b\u001b\u0010\u001cJH\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00028\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\b2#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH'\u00a2\u0006\u0004\b\u001b\u0010\u001dJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u0003H'\u00a2\u0006\u0004\b\u001f\u0010 J\u001b\u0010\"\u001a\u00020\n*\u00020!2\u0006\u0010\u0016\u001a\u00028\u0000H'\u00a2\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\n*\u00020!2\u0006\u0010\u001e\u001a\u00020\u0003H'\u00a2\u0006\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010'\u00a8\u0006*"}, d2={"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "", "token", "", "completeResume", "(Ljava/lang/Object;)V", "initCancellability", "()V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "value", "onCancellation", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "idempotent", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "isActive", "()Z", "isCancelled", "isCompleted", "kotlinx-coroutines-core"})
public interface CancellableContinuation<T>
extends Continuation<T> {
    public boolean isActive();

    public boolean isCompleted();

    public boolean isCancelled();

    @InternalCoroutinesApi
    @Nullable
    public Object tryResume(T var1, @Nullable Object var2);

    @InternalCoroutinesApi
    @Nullable
    public Object tryResume(T var1, @Nullable Object var2, @Nullable Function1<? super Throwable, Unit> var3);

    @InternalCoroutinesApi
    @Nullable
    public Object tryResumeWithException(@NotNull Throwable var1);

    @InternalCoroutinesApi
    public void completeResume(@NotNull Object var1);

    @InternalCoroutinesApi
    public void initCancellability();

    public boolean cancel(@Nullable Throwable var1);

    public void invokeOnCancellation(@NotNull Function1<? super Throwable, Unit> var1);

    @ExperimentalCoroutinesApi
    public void resumeUndispatched(@NotNull CoroutineDispatcher var1, T var2);

    @ExperimentalCoroutinesApi
    public void resumeUndispatchedWithException(@NotNull CoroutineDispatcher var1, @NotNull Throwable var2);

    @ExperimentalCoroutinesApi
    public void resume(T var1, @Nullable Function1<? super Throwable, Unit> var2);

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object tryResume$default(CancellableContinuation cancellableContinuation, Object object, Object object2, int n2, Object object3) {
            if (object3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
            }
            if ((n2 & 2) != 0) {
                object2 = null;
            }
            return cancellableContinuation.tryResume(object, object2);
        }

        public static /* synthetic */ boolean cancel$default(CancellableContinuation cancellableContinuation, Throwable throwable, int n2, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((n2 & 1) != 0) {
                throwable = null;
            }
            return cancellableContinuation.cancel(throwable);
        }
    }
}


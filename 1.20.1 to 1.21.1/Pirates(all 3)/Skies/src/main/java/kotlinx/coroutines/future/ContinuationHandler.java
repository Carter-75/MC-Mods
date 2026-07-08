/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.JvmField
 */
package kotlinx.coroutines.future;

import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\u00a2\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/future/ContinuationHandler;", "T", "Ljava/util/function/BiFunction;", "", "", "result", "exception", "apply", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/Continuation;", "cont", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"})
final class ContinuationHandler<T>
implements BiFunction<T, Throwable, Unit> {
    @JvmField
    @Nullable
    public volatile Continuation<? super T> cont;

    public ContinuationHandler(@Nullable Continuation<? super T> cont) {
        this.cont = cont;
    }

    @Override
    public void apply(@Nullable T result2, @Nullable Throwable exception) {
        Continuation<? super T> continuation = this.cont;
        if (continuation == null) {
            return;
        }
        Continuation<? super T> cont = continuation;
        if (exception == null) {
            cont.resumeWith(Result.constructor-impl(result2));
        } else {
            Continuation<? super T> continuation2 = cont;
            Throwable throwable = exception instanceof CompletionException ? (CompletionException)exception : null;
            if (throwable == null || (throwable = throwable.getCause()) == null) {
                throwable = exception;
            }
            Throwable throwable2 = throwable;
            continuation2.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable2)));
        }
    }
}


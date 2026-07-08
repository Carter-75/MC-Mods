/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.JobSupportKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuationImpl;", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "<init>", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/ResumeAwaitOnCompletion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
final class ResumeAwaitOnCompletion<T>
extends JobNode {
    @NotNull
    private final CancellableContinuationImpl<T> continuation;

    public ResumeAwaitOnCompletion(@NotNull CancellableContinuationImpl<? super T> continuation) {
        this.continuation = continuation;
    }

    @Override
    public void invoke(@Nullable Throwable cause) {
        Object state = this.getJob().getState$kotlinx_coroutines_core();
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(!(state instanceof Incomplete))) {
                throw new AssertionError();
            }
        }
        if (state instanceof CompletedExceptionally) {
            ((Continuation)this.continuation).resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)((CompletedExceptionally)state).cause)));
        } else {
            ((Continuation)this.continuation).resumeWith(Result.constructor-impl((Object)JobSupportKt.unboxState(state)));
        }
    }
}


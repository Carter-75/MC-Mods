/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.AbstractCoroutineContextElement
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.functions.Function1
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.selects.SelectClause0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b<\u0010)J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0017\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0017\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000b\u001a\u00020\u000f2\u000e\u0010\t\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eH\u0017\u00a2\u0006\u0004\b\u000b\u0010\u0010J\u0013\u0010\u0011\u001a\u00060\rj\u0002`\u000eH\u0017\u00a2\u0006\u0004\b\u0011\u0010\u0012JH\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000f0\u0015j\u0002`\u0018H\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ8\u0010\u001b\u001a\u00020\u001a2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000f0\u0015j\u0002`\u0018H\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u000fH\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\nH\u0017\u00a2\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016\u00a2\u0006\u0004\b#\u0010$R \u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020%8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u001a\u0010+\u001a\u00020\n8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b,\u0010)\u001a\u0004\b+\u0010!R\u001a\u0010-\u001a\u00020\n8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b.\u0010)\u001a\u0004\b-\u0010!R\u001a\u0010/\u001a\u00020\n8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b0\u0010)\u001a\u0004\b/\u0010!R\u0014\u00101\u001a\u00020\"8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001a\u00107\u001a\u0002038VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b6\u0010)\u001a\u0004\b4\u00105R\u001c\u0010;\u001a\u0004\u0018\u00010\u00028VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b:\u0010)\u001a\u0004\b8\u00109\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006="}, d2={"Lkotlinx/coroutines/NonCancellable;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "()Z", "", "toString", "()Ljava/lang/String;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "getChildren$annotations", "()V", "children", "isActive", "isActive$annotations", "isCancelled", "isCancelled$annotations", "isCompleted", "isCompleted$annotations", "message", "Ljava/lang/String;", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "onJoin", "getParent", "()Lkotlinx/coroutines/Job;", "getParent$annotations", "parent", "<init>", "kotlinx-coroutines-core"})
public final class NonCancellable
extends AbstractCoroutineContextElement
implements Job {
    @NotNull
    public static final NonCancellable INSTANCE = new NonCancellable();
    @NotNull
    private static final String message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited";

    private NonCancellable() {
        super((CoroutineContext.Key)Job.Key);
    }

    @Override
    @Nullable
    public Job getParent() {
        return null;
    }

    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public static /* synthetic */ void getParent$annotations() {
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public static /* synthetic */ void isActive$annotations() {
    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public static /* synthetic */ void isCompleted$annotations() {
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public static /* synthetic */ void isCancelled$annotations() {
    }

    @Override
    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public boolean start() {
        return false;
    }

    @Override
    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    @Nullable
    public Object join(@NotNull Continuation<? super Unit> $completion) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override
    @NotNull
    public SelectClause0 getOnJoin() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public static /* synthetic */ void getOnJoin$annotations() {
    }

    @Override
    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    @NotNull
    public CancellationException getCancellationException() {
        throw new IllegalStateException("This job is always active");
    }

    @Override
    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    @NotNull
    public DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> handler) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override
    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    @NotNull
    public DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, @NotNull Function1<? super Throwable, Unit> handler) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override
    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public void cancel(@Nullable CancellationException cause) {
    }

    @Override
    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ boolean cancel(Throwable cause) {
        return false;
    }

    @Override
    @NotNull
    public Sequence<Job> getChildren() {
        return SequencesKt.emptySequence();
    }

    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    public static /* synthetic */ void getChildren$annotations() {
    }

    @Override
    @Deprecated(message="NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited", level=DeprecationLevel.WARNING)
    @NotNull
    public ChildHandle attachChild(@NotNull ChildJob child) {
        return NonDisposableHandle.INSTANCE;
    }

    @NotNull
    public String toString() {
        return "NonCancellable";
    }

    @Override
    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ void cancel() {
        Job.DefaultImpls.cancel(this);
    }

    @Override
    @Deprecated(message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.", level=DeprecationLevel.ERROR)
    @NotNull
    public Job plus(@NotNull Job other) {
        return Job.DefaultImpls.plus((Job)this, other);
    }
}


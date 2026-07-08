/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Element$DefaultImpls
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.sequences.Sequence
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.selects.SelectClause0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000 42\u00020\u0001:\u00014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0017\u00a2\u0006\u0004\b\b\u0010\tJ\u001b\u0010\b\u001a\u00020\f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH'\u00a2\u0006\u0004\b\b\u0010\rJ!\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH&\u00a2\u0006\u0004\b\b\u0010\u0010J\u0013\u0010\u0011\u001a\u00060\u000ej\u0002`\u000fH'\u00a2\u0006\u0004\b\u0011\u0010\u0012JL\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00070\u0015j\u0002`\u0018H'\u00a2\u0006\u0004\b\u001b\u0010\u001cJ8\u0010\u001b\u001a\u00020\u001a2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00070\u0015j\u0002`\u0018H&\u00a2\u0006\u0004\b\u001b\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0000H\u0097\u0002\u00a2\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\fH&\u00a2\u0006\u0004\b#\u0010$R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00000%8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010$R\u0014\u0010*\u001a\u00020\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010$R\u0014\u0010+\u001a\u00020\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010$R\u0014\u0010/\u001a\u00020,8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.R\u001c\u00103\u001a\u0004\u0018\u00010\u00008&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b2\u0010\t\u001a\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2={"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "", "cancel", "()V", "", "cause", "", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "other", "plus", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/Job;", "start", "()Z", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "isActive", "isCancelled", "isCompleted", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "getParent", "()Lkotlinx/coroutines/Job;", "getParent$annotations", "parent", "Key", "kotlinx-coroutines-core"})
public interface Job
extends CoroutineContext.Element {
    @NotNull
    public static final Key Key = kotlinx.coroutines.Job$Key.$$INSTANCE;

    @Nullable
    public Job getParent();

    public boolean isActive();

    public boolean isCompleted();

    public boolean isCancelled();

    @InternalCoroutinesApi
    @NotNull
    public CancellationException getCancellationException();

    public boolean start();

    public void cancel(@Nullable CancellationException var1);

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ void cancel();

    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ boolean cancel(Throwable var1);

    @NotNull
    public Sequence<Job> getChildren();

    @InternalCoroutinesApi
    @NotNull
    public ChildHandle attachChild(@NotNull ChildJob var1);

    @Nullable
    public Object join(@NotNull Continuation<? super Unit> var1);

    @NotNull
    public SelectClause0 getOnJoin();

    @NotNull
    public DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> var1);

    @InternalCoroutinesApi
    @NotNull
    public DisposableHandle invokeOnCompletion(boolean var1, boolean var2, @NotNull Function1<? super Throwable, Unit> var3);

    @Deprecated(message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.", level=DeprecationLevel.ERROR)
    @NotNull
    public Job plus(@NotNull Job var1);

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @ExperimentalCoroutinesApi
        public static /* synthetic */ void getParent$annotations() {
        }

        public static /* synthetic */ void cancel$default(Job job, CancellationException cancellationException, int n2, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((n2 & 1) != 0) {
                cancellationException = null;
            }
            job.cancel(cancellationException);
        }

        @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
        public static /* synthetic */ void cancel(Job $this) {
            $this.cancel(null);
        }

        public static /* synthetic */ boolean cancel$default(Job job, Throwable throwable, int n2, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((n2 & 1) != 0) {
                throwable = null;
            }
            return job.cancel(throwable);
        }

        public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean bl, boolean bl2, Function1 function1, int n2, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((n2 & 1) != 0) {
                bl = false;
            }
            if ((n2 & 2) != 0) {
                bl2 = true;
            }
            return job.invokeOnCompletion(bl, bl2, (Function1<? super Throwable, Unit>)function1);
        }

        @Deprecated(message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.", level=DeprecationLevel.ERROR)
        @NotNull
        public static Job plus(@NotNull Job $this, @NotNull Job other) {
            return other;
        }

        @NotNull
        public static CoroutineContext plus(@NotNull Job $this, @NotNull CoroutineContext context) {
            return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)$this, (CoroutineContext)context);
        }

        public static <R> R fold(@NotNull Job $this, R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return (R)CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element)$this, initial, operation);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E get(@NotNull Job $this, @NotNull CoroutineContext.Key<E> key) {
            return (E)CoroutineContext.Element.DefaultImpls.get((CoroutineContext.Element)$this, key);
        }

        @NotNull
        public static CoroutineContext minusKey(@NotNull Job $this, @NotNull CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey((CoroutineContext.Element)$this, key);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlinx/coroutines/Job$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/Job;", "<init>", "()V", "kotlinx-coroutines-core"})
    public static final class Key
    implements CoroutineContext.Key<Job> {
        static final /* synthetic */ Key $$INSTANCE;

        private Key() {
        }

        static {
            $$INSTANCE = new Key();
        }
    }
}


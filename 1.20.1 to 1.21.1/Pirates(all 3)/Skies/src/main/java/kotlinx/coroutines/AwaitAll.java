/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancelHandlerBase;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletionHandlerBase;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u000e\u000fB\u001d\u0012\u0014\u0010\b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u000b\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2={"Lkotlinx/coroutines/AwaitAll;", "T", "", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "[Lkotlinx/coroutines/Deferred;", "Lkotlinx/atomicfu/AtomicInt;", "notCompletedCount", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n314#2,9:128\n323#2,2:141\n13#3:137\n19#3:140\n13579#4,2:138\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll\n*L\n71#1:128,9\n71#1:141,2\n78#1:137\n90#1:140\n83#1:138,2\n*E\n"})
final class AwaitAll<T> {
    @NotNull
    private final Deferred<T>[] deferreds;
    @Volatile
    private volatile int notCompletedCount;
    @NotNull
    private static final AtomicIntegerFieldUpdater notCompletedCount$FU = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount");

    public AwaitAll(@NotNull Deferred<? extends T>[] deferreds) {
        this.deferreds = deferreds;
        this.notCompletedCount = this.deferreds.length;
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final Object await(@NotNull Continuation<? super List<? extends T>> $completion) {
        int n2;
        boolean $i$f$suspendCancellableCoroutine = false;
        Continuation<? super List<? extends T>> uCont$iv = $completion;
        boolean bl = false;
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
        cancellable$iv.initCancellability();
        CancellableContinuation cont = cancellable$iv;
        boolean bl2 = false;
        int n3 = 0;
        int n4 = this.deferreds.length;
        AwaitAllNode[] awaitAllNodeArray = new AwaitAllNode[n4];
        while (n3 < n4) {
            void $this$await_u24lambda_u242_u24lambda_u240;
            AwaitAllNode awaitAllNode;
            n2 = n3++;
            Deferred deferred = this.deferreds[n2];
            deferred.start();
            AwaitAllNode awaitAllNode2 = awaitAllNode = new AwaitAllNode(cont);
            int n5 = n2;
            AwaitAllNode[] awaitAllNodeArray2 = awaitAllNodeArray;
            boolean bl3 = false;
            CompletionHandlerBase $this$asHandler$iv = (CompletionHandlerBase)$this$await_u24lambda_u242_u24lambda_u240;
            boolean $i$f$getAsHandler = false;
            $this$await_u24lambda_u242_u24lambda_u240.setHandle(deferred.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)$this$asHandler$iv)));
            Unit unit = Unit.INSTANCE;
            awaitAllNodeArray2[n5] = awaitAllNode;
        }
        AwaitAllNode[] nodes = awaitAllNodeArray;
        DisposeHandlersOnCancel disposer = new DisposeHandlersOnCancel(nodes);
        AwaitAllNode[] $this$forEach$iv = nodes;
        boolean $i$f$forEach = false;
        int n6 = $this$forEach$iv.length;
        for (n2 = 0; n2 < n6; ++n2) {
            AwaitAllNode element$iv;
            AwaitAllNode it = element$iv = $this$forEach$iv[n2];
            boolean bl4 = false;
            it.setDisposer(disposer);
        }
        if (cont.isCompleted()) {
            disposer.disposeAll();
        } else {
            CancelHandlerBase $this$asHandler$iv = disposer;
            boolean $i$f$getAsHandler = false;
            cont.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)$this$asHandler$iv));
        }
        Object object = cancellable$iv.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0018\u00010\bR\b\u0012\u0004\u0012\u00028\u00000\t0\u00078\u0002X\u0082\u0004R \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR<\u0010\u0014\u001a\u000e\u0018\u00010\bR\b\u0012\u0004\u0012\u00028\u00000\t2\u0012\u0010\u000f\u001a\u000e\u0018\u00010\bR\b\u0012\u0004\u0012\u00028\u00000\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2={"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/JobNode;", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "_disposer", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "value", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;)V", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$AwaitAllNode\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n11335#2:128\n11670#2,3:129\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$AwaitAllNode\n*L\n121#1:128\n121#1:129,3\n*E\n"})
    private final class AwaitAllNode
    extends JobNode {
        @NotNull
        private final CancellableContinuation<List<? extends T>> continuation;
        public DisposableHandle handle;
        @Volatile
        @Nullable
        private volatile Object _disposer;
        @NotNull
        private static final AtomicReferenceFieldUpdater _disposer$FU = AtomicReferenceFieldUpdater.newUpdater(AwaitAllNode.class, Object.class, "_disposer");

        public AwaitAllNode(CancellableContinuation<? super List<? extends T>> continuation) {
            this.continuation = continuation;
        }

        @NotNull
        public final DisposableHandle getHandle() {
            DisposableHandle disposableHandle = this.handle;
            if (disposableHandle != null) {
                return disposableHandle;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"handle");
            return null;
        }

        public final void setHandle(@NotNull DisposableHandle disposableHandle) {
            this.handle = disposableHandle;
        }

        @Nullable
        public final DisposeHandlersOnCancel getDisposer() {
            return (DisposeHandlersOnCancel)_disposer$FU.get(this);
        }

        public final void setDisposer(@Nullable DisposeHandlersOnCancel value) {
            _disposer$FU.set(this, value);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void invoke(@Nullable Throwable cause) {
            if (cause != null) {
                Object token2 = this.continuation.tryResumeWithException(cause);
                if (token2 != null) {
                    this.continuation.completeResume(token2);
                    DisposeHandlersOnCancel disposeHandlersOnCancel = this.getDisposer();
                    if (disposeHandlersOnCancel != null) {
                        disposeHandlersOnCancel.disposeAll();
                    }
                }
            } else if (notCompletedCount$FU.decrementAndGet(AwaitAll.this) == 0) {
                void $this$mapTo$iv$iv;
                Continuation continuation = this.continuation;
                Deferred[] $this$map$iv = AwaitAll.this.deferreds;
                boolean $i$f$map = false;
                Deferred[] deferredArray = $this$map$iv;
                Collection destination$iv$iv = new ArrayList($this$map$iv.length);
                boolean $i$f$mapTo = false;
                int n2 = ((void)$this$mapTo$iv$iv).length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    void it;
                    void item$iv$iv;
                    void var11_12 = item$iv$iv = $this$mapTo$iv$iv[i2];
                    Collection collection = destination$iv$iv;
                    boolean bl = false;
                    collection.add(it.getCompleted());
                }
                List list = (List)destination$iv$iv;
                continuation.resumeWith(Result.constructor-impl((Object)list));
            }
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f0\rR\b\u0012\u0004\u0012\u00028\u00000\u000e0\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR$\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f0\rR\b\u0012\u0004\u0012\u00028\u00000\u000e0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2={"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "", "disposeAll", "()V", "", "cause", "invoke", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "nodes", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "<init>", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n13579#2,2:128\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel\n*L\n96#1:128,2\n*E\n"})
    private final class DisposeHandlersOnCancel
    extends CancelHandler {
        @NotNull
        private final AwaitAllNode[] nodes;

        public DisposeHandlersOnCancel(AwaitAllNode[] nodes) {
            this.nodes = nodes;
        }

        public final void disposeAll() {
            AwaitAllNode[] $this$forEach$iv = this.nodes;
            boolean $i$f$forEach = false;
            int n2 = $this$forEach$iv.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                AwaitAllNode element$iv;
                AwaitAllNode it = element$iv = $this$forEach$iv[i2];
                boolean bl = false;
                it.getHandle().dispose();
            }
        }

        @Override
        public void invoke(@Nullable Throwable cause) {
            this.disposeAll();
        }

        @NotNull
        public String toString() {
            return "DisposeHandlersOnCancel[" + this.nodes + ']';
        }
    }
}


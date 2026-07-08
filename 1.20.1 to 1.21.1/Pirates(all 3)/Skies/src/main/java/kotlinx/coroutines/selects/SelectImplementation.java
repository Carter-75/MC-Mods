/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.ReplaceWith
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.internal.LowPriorityInOverloadResolution
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.selects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstanceInternal;
import kotlinx.coroutines.selects.SelectKt;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004:\u0001WB\u000f\u0012\u0006\u0010F\u001a\u00020E\u00a2\u0006\u0004\bU\u0010VJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0010\u0010\u000b\u001a\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00028\u0000H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00028\u0000H\u0091@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u000fJ\u0013\u0010\u0015\u001a\u00028\u0000H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u000fJ#\u0010\u0016\u001a\u000e\u0018\u00010\nR\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0096\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ#\u0010 \u001a\u00020\u00072\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016\u00a2\u0006\u0004\b \u0010!J/\u0010$\u001a\u00028\u00002\u0010\u0010\"\u001a\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b&\u0010\tJ\u0019\u0010'\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b'\u0010\tJ!\u0010*\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b-\u0010.J!\u0010/\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b/\u00100J\u0013\u00101\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u000fJ5\u0010\u001a\u001a\u00020\u0007*\u0002022\u001c\u00105\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000004\u0012\u0006\u0012\u0004\u0018\u00010\u000503H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u00106JG\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0001\u00107*\b\u0012\u0004\u0012\u00028\u0001082\"\u00105\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000004\u0012\u0006\u0012\u0004\u0018\u00010\u000509H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010:J[\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0001\u0010;\"\u0004\b\u0002\u00107*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020<2\u0006\u0010=\u001a\u00028\u00012\"\u00105\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000004\u0012\u0006\u0012\u0004\u0018\u00010\u000509H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010>J'\u0010@\u001a\u00020\u0007*\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010?\u001a\u00020)H\u0001\u00a2\u0006\u0004\b@\u0010AR(\u0010C\u001a\u0014\u0012\u000e\u0012\f0\nR\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001a\u0010F\u001a\u00020E8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010N\u001a\u00020)8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010#\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010KR\u0014\u0010Q\u001a\u00020)8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bQ\u0010MR\u0014\u0010R\u001a\u00020)8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bR\u0010MR\u0011\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00050S8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006X"}, d2={"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "", "clauseObject", "", "checkClauseObject", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "selectedClause", "cleanup", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;)V", "complete", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/DisposableHandle;", "disposableHandle", "disposeOnCompletion", "(Lkotlinx/coroutines/DisposableHandle;)V", "doSelect", "doSelectSuspend", "findClause", "(Ljava/lang/Object;)Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "cause", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/internal/Segment;", "segment", "", "index", "invokeOnCancellation", "(Lkotlinx/coroutines/internal/Segment;I)V", "clause", "internalResult", "processResultAndInvokeBlockRecoveringException", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reregisterClause", "selectInRegistrationPhase", "result", "", "trySelect", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectDetailed", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectInternal", "(Ljava/lang/Object;Ljava/lang/Object;)I", "waitUntilSelected", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "block", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "reregister", "register", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;Z)V", "", "clauses", "Ljava/util/List;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "disposableHandleOrSegment", "Ljava/lang/Object;", "getInRegistrationPhase", "()Z", "inRegistrationPhase", "indexInSegment", "I", "isCancelled", "isSelected", "Lkotlinx/atomicfu/AtomicRef;", "state", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "ClauseData", "kotlinx-coroutines-core"})
@PublishedApi
@SourceDebugExtension(value={"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,873:1\n1#2:874\n2624#3,3:875\n1855#3,2:888\n1855#3,2:896\n1855#3,2:898\n314#4,9:878\n323#4,2:890\n19#5:887\n153#6,4:892\n*S KotlinDebug\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n*L\n505#1:875,3\n569#1:888,2\n726#1:896,2\n751#1:898,2\n545#1:878,9\n545#1:890,2\n561#1:887\n711#1:892,4\n*E\n"})
public class SelectImplementation<R>
extends CancelHandler
implements SelectBuilder<R>,
SelectInstanceInternal<R> {
    @NotNull
    private final CoroutineContext context;
    @Volatile
    @Nullable
    private volatile Object state;
    @Nullable
    private List<ClauseData> clauses;
    @Nullable
    private Object disposableHandleOrSegment;
    private int indexInSegment;
    @Nullable
    private Object internalResult;
    @NotNull
    private static final AtomicReferenceFieldUpdater state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state");

    public SelectImplementation(@NotNull CoroutineContext context) {
        this.context = context;
        this.state = SelectKt.access$getSTATE_REG$p();
        this.clauses = new ArrayList(2);
        this.indexInSegment = -1;
        this.internalResult = SelectKt.access$getNO_RESULT$p();
    }

    @Override
    @NotNull
    public CoroutineContext getContext() {
        return this.context;
    }

    private final boolean getInRegistrationPhase() {
        Object it = state$FU.get(this);
        boolean bl = false;
        return it == SelectKt.access$getSTATE_REG$p() || it instanceof List;
    }

    private final boolean isSelected() {
        return state$FU.get(this) instanceof ClauseData;
    }

    private final boolean isCancelled() {
        return state$FU.get(this) == SelectKt.access$getSTATE_CANCELLED$p();
    }

    @PublishedApi
    @Nullable
    public Object doSelect(@NotNull Continuation<? super R> $completion) {
        return SelectImplementation.doSelect$suspendImpl(this, $completion);
    }

    @PublishedApi
    static /* synthetic */ <R> Object doSelect$suspendImpl(SelectImplementation<R> $this, Continuation<? super R> $completion) {
        if (super.isSelected()) {
            return super.complete($completion);
        }
        return super.doSelectSuspend($completion);
    }

    /*
     * Unable to fully structure code
     */
    private final Object doSelectSuspend(Continuation<? super R> var1_1) {
        if (!(var1_1 instanceof doSelectSuspend.1)) ** GOTO lbl-1000
        var3_2 = var1_1;
        if ((var3_2.label & -2147483648) != 0) {
            var3_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, var1_1){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ SelectImplementation<R> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return SelectImplementation.access$doSelectSuspend(this.this$0, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = this;
                $continuation.label = 1;
                v0 = this.waitUntilSelected((Continuation<Unit>)$continuation);
                if (v0 == var4_4) {
                    return var4_4;
                }
                ** GOTO lbl22
            }
            case 1: {
                this = (SelectImplementation)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                $continuation.L$0 = null;
                $continuation.label = 2;
                v1 = this.complete((Continuation<? super R>)$continuation);
                if (v1 == var4_4) {
                    return var4_4;
                }
                ** GOTO lbl31
            }
            case 2: {
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl31:
                // 2 sources

                return v1;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override
    public void invoke(@NotNull SelectClause0 $this$invoke, @NotNull Function1<? super Continuation<? super R>, ? extends Object> block) {
        SelectImplementation.register$default(this, new ClauseData($this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), block, $this$invoke.getOnCancellationConstructor()), false, 1, null);
    }

    @Override
    public <Q> void invoke(@NotNull SelectClause1<? extends Q> $this$invoke, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        SelectImplementation.register$default(this, new ClauseData($this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), null, block, $this$invoke.getOnCancellationConstructor()), false, 1, null);
    }

    @Override
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> $this$invoke, P param, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        SelectImplementation.register$default(this, new ClauseData($this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), param, block, $this$invoke.getOnCancellationConstructor()), false, 1, null);
    }

    @JvmName(name="register")
    public final void register(@NotNull ClauseData $this$register, boolean reregister) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(state$FU.get(this) != SelectKt.access$getSTATE_CANCELLED$p())) {
                throw new AssertionError();
            }
        }
        Object it = state$FU.get(this);
        boolean bl = false;
        if (it instanceof ClauseData) {
            return;
        }
        if (!reregister) {
            this.checkClauseObject($this$register.clauseObject);
        }
        if ($this$register.tryRegisterAsWaiter(this)) {
            if (!reregister) {
                List<ClauseData> list = this.clauses;
                Intrinsics.checkNotNull(list);
                ((Collection)list).add($this$register);
            }
            $this$register.disposableHandleOrSegment = this.disposableHandleOrSegment;
            $this$register.indexInSegment = this.indexInSegment;
            this.disposableHandleOrSegment = null;
            this.indexInSegment = -1;
        } else {
            state$FU.set(this, $this$register);
        }
    }

    public static /* synthetic */ void register$default(SelectImplementation selectImplementation, ClauseData clauseData, boolean bl, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
        if ((n2 & 1) != 0) {
            bl = false;
        }
        selectImplementation.register(clauseData, bl);
    }

    private final void checkClauseObject(Object clauseObject) {
        boolean bl;
        block4: {
            List<ClauseData> list = this.clauses;
            Intrinsics.checkNotNull(list);
            List<ClauseData> clauses = list;
            Iterable $this$none$iv = clauses;
            boolean $i$f$none = false;
            if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                bl = true;
            } else {
                for (Object element$iv : $this$none$iv) {
                    ClauseData it = (ClauseData)element$iv;
                    boolean bl2 = false;
                    if (!(it.clauseObject == clauseObject)) continue;
                    bl = false;
                    break block4;
                }
                bl = true;
            }
        }
        if (!bl) {
            boolean bl3 = false;
            String string = "Cannot use select clauses on the same object: " + clauseObject;
            throw new IllegalStateException(string.toString());
        }
    }

    @Override
    public void disposeOnCompletion(@NotNull DisposableHandle disposableHandle) {
        this.disposableHandleOrSegment = disposableHandle;
    }

    @Override
    public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
        this.disposableHandleOrSegment = segment;
        this.indexInSegment = index;
    }

    @Override
    public void selectInRegistrationPhase(@Nullable Object internalResult) {
        this.internalResult = internalResult;
    }

    /*
     * Unable to fully structure code
     */
    private final Object waitUntilSelected(Continuation<? super Unit> $completion) {
        block7: {
            $i$f$suspendCancellableCoroutine = false;
            uCont$iv = $completion;
            $i$a$-suspendCoroutineUninterceptedOrReturn-CancellableContinuationKt$suspendCancellableCoroutine$2$iv = false;
            cancellable$iv = new CancellableContinuationImpl<T>(IntrinsicsKt.intercepted(uCont$iv), 1);
            cancellable$iv.initCancellability();
            cont = cancellable$iv;
            $i$a$-suspendCancellableCoroutine-SelectImplementation$waitUntilSelected$2 = false;
            var8_8 = this;
            atomicfu$handler$iv = SelectImplementation.access$getState$FU$p();
            $i$f$loop$atomicfu = false;
            block0: while (true) {
                curState = atomicfu$handler$iv.get(this);
                $i$a$-loop$atomicfu-SelectImplementation$waitUntilSelected$2$1 = false;
                if (curState == SelectKt.access$getSTATE_REG$p()) {
                    if (!SelectImplementation.access$getState$FU$p().compareAndSet(this, curState, cont)) continue;
                    $this$asHandler$iv = this;
                    $i$f$getAsHandler = false;
                    cont.invokeOnCancellation((Function1<Throwable, Unit>)((Function1)$this$asHandler$iv));
                    break block7;
                }
                if (!(curState instanceof List)) break;
                if (!SelectImplementation.access$getState$FU$p().compareAndSet(this, curState, SelectKt.access$getSTATE_REG$p())) continue;
                (List)curState;
                $this$forEach$iv = (Iterable)curState;
                $i$f$forEach = false;
                var15_15 = $this$forEach$iv.iterator();
                while (true) {
                    if (var15_15.hasNext()) ** break;
                    continue block0;
                    it = element$iv = var15_15.next();
                    $i$a$-forEach-SelectImplementation$waitUntilSelected$2$1$1 = false;
                    SelectImplementation.access$reregisterClause(this, it);
                }
                break;
            }
            if (curState instanceof ClauseData) {
                cont.resume(Unit.INSTANCE, ((ClauseData)curState).createOnCancellationAction(this, SelectImplementation.access$getInternalResult$p(this)));
            } else {
                throw new IllegalStateException(("unexpected state: " + curState).toString());
            }
        }
        v0 = cancellable$iv.getResult();
        if (v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }
        return Unit.INSTANCE;
    }

    private final void reregisterClause(Object clauseObject) {
        ClauseData clauseData = this.findClause(clauseObject);
        Intrinsics.checkNotNull((Object)clauseData);
        ClauseData clause = clauseData;
        clause.disposableHandleOrSegment = null;
        clause.indexInSegment = -1;
        this.register(clause, true);
    }

    @Override
    public boolean trySelect(@NotNull Object clauseObject, @Nullable Object result2) {
        return this.trySelectInternal(clauseObject, result2) == 0;
    }

    @NotNull
    public final TrySelectDetailedResult trySelectDetailed(@NotNull Object clauseObject, @Nullable Object result2) {
        return SelectKt.access$TrySelectDetailedResult(this.trySelectInternal(clauseObject, result2));
    }

    private final int trySelectInternal(Object clauseObject, Object internalResult) {
        Object curState;
        block6: {
            while (true) {
                if ((curState = state$FU.get(this)) instanceof CancellableContinuation) {
                    ClauseData clause;
                    if (this.findClause(clauseObject) == null) continue;
                    Function1<Throwable, Unit> onCancellation = clause.createOnCancellationAction(this, internalResult);
                    if (!state$FU.compareAndSet(this, curState, clause)) continue;
                    CancellableContinuation cont = (CancellableContinuation)curState;
                    this.internalResult = internalResult;
                    if (SelectKt.access$tryResume(cont, onCancellation)) {
                        return 0;
                    }
                    this.internalResult = null;
                    return 2;
                }
                if (Intrinsics.areEqual(curState, (Object)SelectKt.access$getSTATE_COMPLETED$p()) ? true : curState instanceof ClauseData) {
                    return 3;
                }
                if (Intrinsics.areEqual(curState, (Object)SelectKt.access$getSTATE_CANCELLED$p())) {
                    return 2;
                }
                if (Intrinsics.areEqual(curState, (Object)SelectKt.access$getSTATE_REG$p())) {
                    if (!state$FU.compareAndSet(this, curState, CollectionsKt.listOf((Object)clauseObject))) continue;
                    return 1;
                }
                if (!(curState instanceof List)) break block6;
                if (state$FU.compareAndSet(this, curState, CollectionsKt.plus((Collection)((Collection)curState), (Object)clauseObject))) break;
            }
            return 1;
        }
        throw new IllegalStateException(("Unexpected state: " + curState).toString());
    }

    private final ClauseData findClause(Object clauseObject) {
        Object v1;
        block3: {
            List<ClauseData> list = this.clauses;
            if (list == null) {
                return null;
            }
            List<ClauseData> clauses = list;
            Iterable iterable = clauses;
            for (Object t : iterable) {
                ClauseData it = (ClauseData)t;
                boolean bl = false;
                if (!(it.clauseObject == clauseObject)) continue;
                v1 = t;
                break block3;
            }
            v1 = null;
        }
        ClauseData clauseData = v1;
        if (clauseData == null) {
            throw new IllegalStateException(("Clause with object " + clauseObject + " is not found").toString());
        }
        return clauseData;
    }

    private final Object complete(Continuation<? super R> $completion) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!this.isSelected()) {
                throw new AssertionError();
            }
        }
        Object v = state$FU.get(this);
        Intrinsics.checkNotNull(v, (String)"null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        ClauseData selectedClause = (ClauseData)v;
        Object internalResult = this.internalResult;
        this.cleanup(selectedClause);
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            Object blockArgument = selectedClause.processResult(internalResult);
            return selectedClause.invokeBlock(blockArgument, $completion);
        }
        return this.processResultAndInvokeBlockRecoveringException(selectedClause, internalResult, $completion);
    }

    /*
     * Unable to fully structure code
     */
    private final Object processResultAndInvokeBlockRecoveringException(ClauseData var1_1, Object var2_2, Continuation<? super R> var3_3) {
        if (!(var3_3 instanceof processResultAndInvokeBlockRecoveringException.1)) ** GOTO lbl-1000
        var10_4 = var3_3;
        if ((var10_4.label & -2147483648) != 0) {
            var10_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, var3_3){
                /* synthetic */ Object result;
                final /* synthetic */ SelectImplementation<R> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return SelectImplementation.access$processResultAndInvokeBlockRecoveringException(this.this$0, null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var11_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                blockArgument = clause.processResult(internalResult);
                $continuation.label = 1;
                v0 = clause.invokeBlock(blockArgument, $continuation);
                ** if (v0 != var11_6) goto lbl19
lbl18:
                // 1 sources

                return var11_6;
lbl19:
                // 1 sources

                ** GOTO lbl25
            }
            case 1: {
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl25:
                    // 2 sources

                    var4_7 = v0;
                }
                catch (Throwable e) {
                    $i$f$recoverAndThrow = false;
                    if (!DebugKt.getRECOVER_STACK_TRACES()) {
                        throw e;
                    }
                    it$iv = $continuation;
                    $i$a$-suspendCoroutineUninterceptedOrReturn-StackTraceRecoveryKt$recoverAndThrow$2$iv = false;
                    if (!(it$iv instanceof CoroutineStackFrame)) {
                        throw e;
                    }
                    throw StackTraceRecoveryKt.access$recoverFromStackFrame(e, (CoroutineStackFrame)it$iv);
                }
                return var4_7;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private final void cleanup(ClauseData selectedClause) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!Intrinsics.areEqual(state$FU.get(this), (Object)selectedClause)) {
                throw new AssertionError();
            }
        }
        List<ClauseData> list = this.clauses;
        if (list == null) {
            return;
        }
        List<ClauseData> clauses = list;
        Iterable $this$forEach$iv = clauses;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ClauseData clause = (ClauseData)element$iv;
            boolean bl = false;
            if (clause == selectedClause) continue;
            clause.dispose();
        }
        state$FU.set(this, SelectKt.access$getSTATE_COMPLETED$p());
        this.internalResult = SelectKt.access$getNO_RESULT$p();
        this.clauses = null;
    }

    @Override
    public void invoke(@Nullable Throwable cause) {
        Object cur;
        Object v;
        SelectImplementation selectImplementation = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = state$FU;
        boolean $i$f$update$atomicfu = false;
        do {
            v = atomicfu$handler$iv.get(this);
            cur = v;
            boolean bl = false;
            if (cur != SelectKt.access$getSTATE_COMPLETED$p()) continue;
            return;
        } while (!atomicfu$handler$iv.compareAndSet(this, v, cur = SelectKt.access$getSTATE_CANCELLED$p()));
        List<ClauseData> list = this.clauses;
        if (list == null) {
            return;
        }
        List<ClauseData> clauses = list;
        Iterable $this$forEach$iv = clauses;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ClauseData it = (ClauseData)element$iv;
            boolean bl = false;
            it.dispose();
        }
        this.internalResult = SelectKt.access$getNO_RESULT$p();
        this.clauses = null;
    }

    @Override
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> $this$invoke, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        SelectBuilder.DefaultImpls.invoke(this, $this$invoke, block);
    }

    @Override
    @Deprecated(message="Replaced with the same extension function", replaceWith=@ReplaceWith(expression="onTimeout", imports={"kotlinx.coroutines.selects.onTimeout"}), level=DeprecationLevel.ERROR)
    @ExperimentalCoroutinesApi
    @LowPriorityInOverloadResolution
    public void onTimeout(long timeMillis, @NotNull Function1<? super Continuation<? super R>, ? extends Object> block) {
        SelectBuilder.DefaultImpls.onTimeout(this, timeMillis, block);
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicfu$handler, Function1<Object, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            atomicfu$action.invoke(atomicfu$handler.get(atomicfu$dispatchReceiver));
        }
    }

    private final void update$atomicfu(AtomicReferenceFieldUpdater atomicfu$handler, Function1<Object, ? extends Object> atomicfu$action, Object atomicfu$dispatchReceiver) {
        Object object;
        Object v;
        boolean $i$f$update$atomicfu = false;
        while (!atomicfu$handler.compareAndSet(atomicfu$dispatchReceiver, v = atomicfu$handler.get(atomicfu$dispatchReceiver), object = atomicfu$action.invoke(v))) {
        }
    }

    public static final /* synthetic */ Object access$doSelectSuspend(SelectImplementation $this, Continuation $completion) {
        return $this.doSelectSuspend($completion);
    }

    public static final /* synthetic */ Object access$waitUntilSelected(SelectImplementation $this, Continuation $completion) {
        return $this.waitUntilSelected((Continuation<Unit>)$completion);
    }

    public static final /* synthetic */ Object access$complete(SelectImplementation $this, Continuation $completion) {
        return $this.complete($completion);
    }

    public static final /* synthetic */ Object access$processResultAndInvokeBlockRecoveringException(SelectImplementation $this, ClauseData clause, Object internalResult, Continuation $completion) {
        return $this.processResultAndInvokeBlockRecoveringException(clause, internalResult, $completion);
    }

    public static final /* synthetic */ void access$reregisterClause(SelectImplementation $this, Object clauseObject) {
        $this.reregisterClause(clauseObject);
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater access$getState$FU$p() {
        return state$FU;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u00b8\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0001\u0012U\u0010(\u001aQ\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0018\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0002\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00070\u001dj\u0002`'\u0012U\u0010&\u001aQ\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dj\u0002`%\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0016\u001a\u00020\u0001\u0012g\u0010\"\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0002\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0018\u00010\u001dj\u0004\u0018\u0001`!\u00a2\u0006\u0004\b)\u0010*J1\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\u00028\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u00020\u00132\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cRu\u0010\"\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0002\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0018\u00010\u001dj\u0004\u0018\u0001`!8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010 \u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0017Rc\u0010&\u001aQ\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001dj\u0002`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010#Rc\u0010(\u001aQ\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0018\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0002\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00070\u001dj\u0002`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010#\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2={"Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "internalResult", "Lkotlin/Function1;", "", "", "createOnCancellationAction", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "dispose", "()V", "argument", "invokeBlock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "result", "processResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectImplementation;", "", "tryRegisterAsWaiter", "(Lkotlinx/coroutines/selects/SelectImplementation;)Z", "block", "Ljava/lang/Object;", "clauseObject", "disposableHandleOrSegment", "", "indexInSegment", "I", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "param", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onCancellationConstructor", "Lkotlin/jvm/functions/Function3;", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "processResFunc", "Lkotlinx/coroutines/selects/RegistrationFunction;", "regFunc", "<init>", "(Lkotlinx/coroutines/selects/SelectImplementation;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation$ClauseData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,873:1\n1#2:874\n*E\n"})
    public final class ClauseData {
        @JvmField
        @NotNull
        public final Object clauseObject;
        @NotNull
        private final Function3<Object, SelectInstance<?>, Object, Unit> regFunc;
        @NotNull
        private final Function3<Object, Object, Object, Object> processResFunc;
        @Nullable
        private final Object param;
        @NotNull
        private final Object block;
        @JvmField
        @Nullable
        public final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onCancellationConstructor;
        @JvmField
        @Nullable
        public Object disposableHandleOrSegment;
        @JvmField
        public int indexInSegment;

        public ClauseData(@NotNull Object clauseObject, @NotNull Function3<Object, ? super SelectInstance<?>, Object, Unit> regFunc, @Nullable Function3<Object, Object, Object, ? extends Object> processResFunc, @NotNull Object param, @Nullable Object block, Function3<? super SelectInstance<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> onCancellationConstructor) {
            this.clauseObject = clauseObject;
            this.regFunc = regFunc;
            this.processResFunc = processResFunc;
            this.param = param;
            this.block = block;
            this.onCancellationConstructor = onCancellationConstructor;
            this.indexInSegment = -1;
        }

        public final boolean tryRegisterAsWaiter(@NotNull SelectImplementation<R> select) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl = false;
                if (!(select.getInRegistrationPhase() || select.isCancelled())) {
                    throw new AssertionError();
                }
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl = false;
                if (!(select.internalResult == SelectKt.access$getNO_RESULT$p())) {
                    throw new AssertionError();
                }
            }
            this.regFunc.invoke(this.clauseObject, select, this.param);
            return select.internalResult == SelectKt.access$getNO_RESULT$p();
        }

        @Nullable
        public final Object processResult(@Nullable Object result2) {
            return this.processResFunc.invoke(this.clauseObject, this.param, result2);
        }

        @Nullable
        public final Object invokeBlock(@Nullable Object argument, @NotNull Continuation<? super R> $completion) {
            Object block = this.block;
            if (this.param == SelectKt.getPARAM_CLAUSE_0()) {
                Intrinsics.checkNotNull((Object)block, (String)"null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                Function1 cfr_ignored_0 = (Function1)block;
                return ((Function1)block).invoke($completion);
            }
            Intrinsics.checkNotNull((Object)block, (String)"null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            Function2 cfr_ignored_1 = (Function2)block;
            return ((Function2)block).invoke(argument, $completion);
        }

        public final void dispose() {
            block1: {
                Object $this$dispose_u24lambda_u242;
                block0: {
                    Object object = this.disposableHandleOrSegment;
                    SelectImplementation selectImplementation = SelectImplementation.this;
                    $this$dispose_u24lambda_u242 = object;
                    boolean bl = false;
                    if (!($this$dispose_u24lambda_u242 instanceof Segment)) break block0;
                    ((Segment)$this$dispose_u24lambda_u242).onCancellation(this.indexInSegment, null, selectImplementation.getContext());
                    break block1;
                }
                DisposableHandle disposableHandle = $this$dispose_u24lambda_u242 instanceof DisposableHandle ? (DisposableHandle)$this$dispose_u24lambda_u242 : null;
                if (disposableHandle == null) break block1;
                disposableHandle.dispose();
            }
        }

        @Nullable
        public final Function1<Throwable, Unit> createOnCancellationAction(@NotNull SelectInstance<?> select, @Nullable Object internalResult) {
            Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> function3 = this.onCancellationConstructor;
            return function3 != null ? (Function1)function3.invoke(select, this.param, internalResult) : null;
        }
    }
}


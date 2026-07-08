/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.StateFlowSlot;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006B\u000f\u0012\u0006\u00109\u001a\u00020(\u00a2\u0006\u0004\b:\u00107J!\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0014\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001fH\u0016\u00a2\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b&\u0010'J!\u0010+\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010*\u001a\u00020(H\u0002\u00a2\u0006\u0004\b+\u0010\u0010R\u0011\u0010-\u001a\b\u0012\u0004\u0012\u00020(0,8\u0002X\u0082\u0004R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000.8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00102\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R*\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00008V@VX\u0096\u000e\u00a2\u0006\u0012\u0012\u0004\b8\u0010%\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006;"}, d2={"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expect", "update", "", "compareAndSet", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "resetReplayCache", "()V", "tryEmit", "(Ljava/lang/Object;)Z", "", "expectedState", "newState", "updateState", "Lkotlinx/atomicfu/AtomicRef;", "_state", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "getValue$annotations", "initialState", "<init>", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,428:1\n18#2:429\n18#2:443\n28#3,4:430\n28#3,4:437\n20#4:434\n20#4:441\n13579#5,2:435\n329#6:442\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n*L\n315#1:429\n396#1:443\n324#1:430,4\n352#1:437,4\n324#1:434\n352#1:441\n348#1:435,2\n385#1:442\n*E\n"})
final class StateFlowImpl<T>
extends AbstractSharedFlow<StateFlowSlot>
implements MutableStateFlow<T>,
CancellableFlow<T>,
FusibleFlow<T> {
    @Volatile
    @Nullable
    private volatile Object _state;
    private int sequence;
    @NotNull
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");

    public StateFlowImpl(@NotNull Object initialState) {
        this._state = initialState;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public T getValue() {
        void var2_2;
        void this_$iv;
        Symbol symbol = NullSurrogateKt.NULL;
        Object value$iv = _state$FU.get(this);
        boolean $i$f$unbox = false;
        return (T)(value$iv == this_$iv ? null : var2_2);
    }

    @Override
    public void setValue(T value) {
        Object object = value;
        if (object == null) {
            object = NullSurrogateKt.NULL;
        }
        this.updateState(null, object);
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    @Override
    public boolean compareAndSet(T expect, T update) {
        Object object;
        Object object2 = expect;
        if (object2 == null) {
            object2 = NullSurrogateKt.NULL;
        }
        if ((object = update) == null) {
            object = NullSurrogateKt.NULL;
        }
        return this.updateState(object2, object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final boolean updateState(Object expectedState, Object newState) {
        int n2;
        int curSequence = 0;
        AbstractSharedFlowSlot[] curSlots = null;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        StateFlowImpl stateFlowImpl = this;
        synchronized (stateFlowImpl) {
            n2 = 0;
            Object oldState = _state$FU.get(this);
            if (expectedState != null && !Intrinsics.areEqual(oldState, (Object)expectedState)) {
                return false;
            }
            if (Intrinsics.areEqual(oldState, (Object)newState)) {
                return true;
            }
            _state$FU.set(this, newState);
            curSequence = this.sequence;
            if ((curSequence & 1) != 0) {
                this.sequence = curSequence + 2;
                return true;
            }
            this.sequence = ++curSequence;
            curSlots = this.getSlots();
            Unit unit = Unit.INSTANCE;
        }
        while (true) {
            if ((StateFlowSlot[])curSlots != null) {
                StateFlowSlot[] $this$forEach$iv;
                boolean $i$f$forEach = false;
                int n3 = $this$forEach$iv.length;
                for (n2 = 0; n2 < n3; ++n2) {
                    StateFlowSlot element$iv;
                    StateFlowSlot it = element$iv = $this$forEach$iv[n2];
                    boolean bl = false;
                    StateFlowSlot stateFlowSlot = it;
                    if (stateFlowSlot == null) continue;
                    stateFlowSlot.makePending();
                }
            }
            $i$f$synchronized = false;
            $i$f$synchronizedImpl = false;
            stateFlowImpl = this;
            synchronized (stateFlowImpl) {
                boolean bl = false;
                if (this.sequence == curSequence) {
                    this.sequence = curSequence + 1;
                    return true;
                }
                curSequence = this.sequence;
                curSlots = this.getSlots();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override
    @NotNull
    public List<T> getReplayCache() {
        return CollectionsKt.listOf(this.getValue());
    }

    @Override
    public boolean tryEmit(T value) {
        this.setValue(value);
        return true;
    }

    @Override
    @Nullable
    public Object emit(T value, @NotNull Continuation<? super Unit> $completion) {
        this.setValue(value);
        return Unit.INSTANCE;
    }

    @Override
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /*
     * Exception decompiling
     */
    @Override
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<?> var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 11[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    @NotNull
    protected StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    @NotNull
    protected StateFlowSlot[] createSlotArray(int size) {
        return new StateFlowSlot[size];
    }

    @Override
    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, context, capacity, onBufferOverflow);
    }
}


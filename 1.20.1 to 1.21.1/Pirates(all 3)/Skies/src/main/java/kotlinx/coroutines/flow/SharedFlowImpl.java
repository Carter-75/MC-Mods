/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.CancellableFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharedFlowSlot;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010 \n\u0002\b\r\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u0001uB\u001f\u0012\u0006\u0010h\u001a\u00020\u001c\u0012\u0006\u0010W\u001a\u00020\u001c\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\bs\u0010tJ\u001b\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0003H\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014\u00a2\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b!\u0010\u0010J\u001b\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$J\u001b\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00028\u0000H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010$J\u0019\u0010(\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002\u00a2\u0006\u0004\b(\u0010)J3\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010*0\u001e2\u0014\u0010+\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010*0\u001eH\u0002\u00a2\u0006\u0004\b,\u0010-J-\u00104\u001a\b\u0012\u0004\u0012\u00028\u0000032\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u001c2\u0006\u00102\u001a\u000201H\u0016\u00a2\u0006\u0004\b4\u00105J\u0019\u00107\u001a\u0004\u0018\u00010&2\u0006\u00106\u001a\u00020\u0016H\u0002\u00a2\u0006\u0004\b7\u00108J9\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u001e2\u0010\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010\u001e2\u0006\u0010:\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020\u001cH\u0002\u00a2\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b>\u0010\u0010J\u0017\u0010@\u001a\u00020?2\u0006\u0010\"\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020?2\u0006\u0010\"\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\bB\u0010AJ\u0017\u0010C\u001a\u00020?2\u0006\u0010\"\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\bC\u0010AJ\u0017\u0010D\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u0004\u0018\u00010&2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\bF\u0010GJ/\u0010L\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u00162\u0006\u0010I\u001a\u00020\u00162\u0006\u0010J\u001a\u00020\u00162\u0006\u0010K\u001a\u00020\u0016H\u0002\u00a2\u0006\u0004\bL\u0010MJ%\u0010Q\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010*0\u001e2\u0006\u0010N\u001a\u00020\u0016H\u0000\u00a2\u0006\u0004\bO\u0010PJ\u000f\u0010T\u001a\u00020\u0016H\u0000\u00a2\u0006\u0004\bR\u0010SR \u0010U\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010W\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Z\u001a\u00020\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bY\u0010SR\u0016\u0010[\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010XR\u0014\u0010]\u001a\u00020\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\\\u0010SR\u001a\u0010a\u001a\u00028\u00008DX\u0084\u0004\u00a2\u0006\f\u0012\u0004\b`\u0010\u0010\u001a\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010dR\u0014\u0010f\u001a\u00020\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\be\u0010SR\u0016\u0010g\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010XR\u0014\u0010h\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010XR\u001a\u0010l\u001a\b\u0012\u0004\u0012\u00028\u00000i8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bj\u0010kR\u0016\u0010m\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010cR\u0014\u0010p\u001a\u00020\u001c8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bn\u0010oR\u0014\u0010r\u001a\u00020\u001c8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bq\u0010o\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006v"}, d2={"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "slot", "", "awaitValue", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "emitter", "cancelEmitter", "(Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;)V", "cleanupTailLocked", "()V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "newHead", "correctCollectorIndexesOnDropOldest", "(J)V", "createSlot", "()Lkotlinx/coroutines/flow/SharedFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "dropOldestLocked", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSuspend", "", "item", "enqueueLocked", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/Continuation;", "resumesIn", "findSlotsToResumeLocked", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "index", "getPeekedValueLockedAt", "(J)Ljava/lang/Object;", "curBuffer", "curSize", "newSize", "growBuffer", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "resetReplayCache", "", "tryEmit", "(Ljava/lang/Object;)Z", "tryEmitLocked", "tryEmitNoCollectorsLocked", "tryPeekLocked", "(Lkotlinx/coroutines/flow/SharedFlowSlot;)J", "tryTakeValue", "(Lkotlinx/coroutines/flow/SharedFlowSlot;)Ljava/lang/Object;", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateBufferLocked", "(JJJJ)V", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "()J", "updateNewCollectorIndexLocked", "buffer", "[Ljava/lang/Object;", "bufferCapacity", "I", "getBufferEndIndex", "bufferEndIndex", "bufferSize", "getHead", "head", "getLastReplayedLocked", "()Ljava/lang/Object;", "getLastReplayedLocked$annotations", "lastReplayedLocked", "minCollectorIndex", "J", "Lkotlinx/coroutines/channels/BufferOverflow;", "getQueueEndIndex", "queueEndIndex", "queueSize", "replay", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "replayIndex", "getReplaySize", "()I", "replaySize", "getTotalSize", "totalSize", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "Emitter", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 7 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 8 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,731:1\n28#2,4:732\n28#2,4:738\n28#2,4:760\n28#2,4:767\n28#2,4:779\n28#2,4:793\n28#2,4:807\n20#3:736\n20#3:742\n20#3:764\n20#3:771\n20#3:783\n20#3:797\n20#3:811\n329#4:737\n1#5:743\n94#6,2:744\n96#6,2:747\n98#6:750\n94#6,2:772\n96#6,2:775\n98#6:778\n94#6,2:800\n96#6,2:803\n98#6:806\n13579#7:746\n13580#7:749\n13579#7:774\n13580#7:777\n13579#7:802\n13580#7:805\n314#8,9:751\n323#8,2:765\n314#8,9:784\n323#8,2:798\n*S KotlinDebug\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n*L\n351#1:732,4\n391#1:738,4\n485#1:760,4\n506#1:767,4\n626#1:779,4\n661#1:793,4\n689#1:807,4\n351#1:736\n391#1:742\n485#1:764\n506#1:771\n626#1:783\n661#1:797\n689#1:811\n373#1:737\n453#1:744,2\n453#1:747,2\n453#1:750\n529#1:772,2\n529#1:775,2\n529#1:778\n676#1:800,2\n676#1:803,2\n676#1:806\n453#1:746\n453#1:749\n529#1:774\n529#1:777\n676#1:802\n676#1:805\n483#1:751,9\n483#1:765,2\n660#1:784,9\n660#1:798,2\n*E\n"})
public class SharedFlowImpl<T>
extends AbstractSharedFlow<SharedFlowSlot>
implements MutableSharedFlow<T>,
CancellableFlow<T>,
FusibleFlow<T> {
    private final int replay;
    private final int bufferCapacity;
    @NotNull
    private final BufferOverflow onBufferOverflow;
    @Nullable
    private Object[] buffer;
    private long replayIndex;
    private long minCollectorIndex;
    private int bufferSize;
    private int queueSize;

    public SharedFlowImpl(int replay, int bufferCapacity, @NotNull BufferOverflow onBufferOverflow) {
        this.replay = replay;
        this.bufferCapacity = bufferCapacity;
        this.onBufferOverflow = onBufferOverflow;
    }

    private final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    private final int getReplaySize() {
        return (int)(this.getHead() + (long)this.bufferSize - this.replayIndex);
    }

    private final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    private final long getBufferEndIndex() {
        return this.getHead() + (long)this.bufferSize;
    }

    private final long getQueueEndIndex() {
        return this.getHead() + (long)this.bufferSize + (long)this.queueSize;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @NotNull
    public List<T> getReplayCache() {
        ArrayList arrayList;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        SharedFlowImpl sharedFlowImpl = this;
        synchronized (sharedFlowImpl) {
            int replaySize;
            block5: {
                boolean bl = false;
                replaySize = this.getReplaySize();
                if (replaySize != 0) break block5;
                List list = CollectionsKt.emptyList();
                return list;
            }
            ArrayList result2 = new ArrayList(replaySize);
            Intrinsics.checkNotNull((Object)this.buffer);
            Object[] buffer = this.buffer;
            for (int i2 = 0; i2 < replaySize; ++i2) {
                ((Collection)result2).add(SharedFlowKt.access$getBufferAt(buffer, this.replayIndex + (long)i2));
            }
            arrayList = result2;
        }
        return arrayList;
    }

    protected final T getLastReplayedLocked() {
        Intrinsics.checkNotNull((Object)this.buffer);
        return (T)SharedFlowKt.access$getBufferAt(this.buffer, this.replayIndex + (long)this.getReplaySize() - 1L);
    }

    protected static /* synthetic */ void getLastReplayedLocked$annotations() {
    }

    @Override
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> collector2, @NotNull Continuation<?> $completion) {
        return SharedFlowImpl.collect$suspendImpl(this, collector2, $completion);
    }

    /*
     * Exception decompiling
     */
    static /* synthetic */ <T> Object collect$suspendImpl(SharedFlowImpl<T> var0, FlowCollector<? super T> var1_1, Continuation<?> var2_2) {
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
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1050)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean tryEmit(T value) {
        boolean bl;
        Continuation<Unit>[] resumes = null;
        resumes = AbstractSharedFlowKt.EMPTY_RESUMES;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        SharedFlowImpl sharedFlowImpl = this;
        synchronized (sharedFlowImpl) {
            boolean bl2;
            boolean bl3 = false;
            if (this.tryEmitLocked(value)) {
                resumes = this.findSlotsToResumeLocked(resumes);
                bl2 = true;
            } else {
                bl2 = false;
            }
            bl = bl2;
        }
        boolean emitted = bl;
        Continuation<Unit>[] continuationArray = resumes;
        int n2 = continuationArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Continuation<Unit> cont;
            Continuation<Unit> continuation = cont = continuationArray[i2];
            if (continuation == null) continue;
            continuation.resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
        }
        return emitted;
    }

    @Override
    @Nullable
    public Object emit(T value, @NotNull Continuation<? super Unit> $completion) {
        return SharedFlowImpl.emit$suspendImpl(this, value, $completion);
    }

    static /* synthetic */ <T> Object emit$suspendImpl(SharedFlowImpl<T> $this, T value, Continuation<? super Unit> $completion) {
        if ($this.tryEmit(value)) {
            return Unit.INSTANCE;
        }
        Object object = super.emitSuspend(value, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final boolean tryEmitLocked(T value) {
        if (this.getNCollectors() == 0) {
            return this.tryEmitNoCollectorsLocked(value);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()]) {
                case 1: {
                    return false;
                }
                case 2: {
                    return true;
                }
            }
        }
        this.enqueueLocked(value);
        int n2 = this.bufferSize;
        this.bufferSize = n2 + 1;
        if (this.bufferSize > this.bufferCapacity) {
            this.dropOldestLocked();
        }
        if (this.getReplaySize() > this.replay) {
            this.updateBufferLocked(this.replayIndex + 1L, this.minCollectorIndex, this.getBufferEndIndex(), this.getQueueEndIndex());
        }
        return true;
    }

    private final boolean tryEmitNoCollectorsLocked(T value) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(this.getNCollectors() == 0)) {
                throw new AssertionError();
            }
        }
        if (this.replay == 0) {
            return true;
        }
        this.enqueueLocked(value);
        int n2 = this.bufferSize;
        this.bufferSize = n2 + 1;
        if (this.bufferSize > this.replay) {
            this.dropOldestLocked();
        }
        this.minCollectorIndex = this.getHead() + (long)this.bufferSize;
        return true;
    }

    private final void dropOldestLocked() {
        Intrinsics.checkNotNull((Object)this.buffer);
        SharedFlowKt.access$setBufferAt(this.buffer, this.getHead(), null);
        int n2 = this.bufferSize;
        this.bufferSize = n2 + -1;
        long newHead = this.getHead() + 1L;
        if (this.replayIndex < newHead) {
            this.replayIndex = newHead;
        }
        if (this.minCollectorIndex < newHead) {
            this.correctCollectorIndexesOnDropOldest(newHead);
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(this.getHead() == newHead)) {
                throw new AssertionError();
            }
        }
    }

    private final void correctCollectorIndexesOnDropOldest(long newHead) {
        AbstractSharedFlow this_$iv = this;
        boolean $i$f$forEachSlotLocked = false;
        if (AbstractSharedFlow.access$getNCollectors(this_$iv) != 0) {
            AbstractSharedFlowSlot[] abstractSharedFlowSlotArray = AbstractSharedFlow.access$getSlots(this_$iv);
            if (abstractSharedFlowSlotArray != null) {
                AbstractSharedFlowSlot[] $this$forEach$iv$iv = abstractSharedFlowSlotArray;
                boolean $i$f$forEach = false;
                int n2 = $this$forEach$iv$iv.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    AbstractSharedFlowSlot element$iv$iv;
                    AbstractSharedFlowSlot slot$iv = element$iv$iv = $this$forEach$iv$iv[i2];
                    boolean bl = false;
                    if (slot$iv == null) continue;
                    SharedFlowSlot slot = (SharedFlowSlot)slot$iv;
                    boolean bl2 = false;
                    if (slot.index < 0L || slot.index >= newHead) continue;
                    slot.index = newHead;
                }
            }
        }
        this.minCollectorIndex = newHead;
    }

    private final void enqueueLocked(Object item) {
        int curSize = this.getTotalSize();
        Object[] curBuffer = this.buffer;
        Object[] buffer = curBuffer == null ? this.growBuffer(null, 0, 2) : (curSize >= curBuffer.length ? this.growBuffer(curBuffer, curSize, curBuffer.length * 2) : curBuffer);
        SharedFlowKt.access$setBufferAt(buffer, this.getHead() + (long)curSize, item);
    }

    private final Object[] growBuffer(Object[] curBuffer, int curSize, int newSize) {
        Object[] $i$a$-check-SharedFlowImpl$growBuffer$222;
        if (!(newSize > 0)) {
            boolean $i$a$-check-SharedFlowImpl$growBuffer$222 = false;
            String $i$a$-check-SharedFlowImpl$growBuffer$222 = "Buffer size overflow";
            throw new IllegalStateException($i$a$-check-SharedFlowImpl$growBuffer$222.toString());
        }
        Object[] it = $i$a$-check-SharedFlowImpl$growBuffer$222 = new Object[newSize];
        boolean bl = false;
        this.buffer = it;
        Object[] newBuffer = $i$a$-check-SharedFlowImpl$growBuffer$222;
        if (curBuffer == null) {
            return newBuffer;
        }
        long head = this.getHead();
        for (int i2 = 0; i2 < curSize; ++i2) {
            SharedFlowKt.access$setBufferAt(newBuffer, head + (long)i2, SharedFlowKt.access$getBufferAt(curBuffer, head + (long)i2));
        }
        return newBuffer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final Object emitSuspend(T value, Continuation<? super Unit> $completion) {
        Emitter emitter;
        Emitter emitter2;
        boolean $i$f$suspendCancellableCoroutine = false;
        Continuation<? super Unit> uCont$iv = $completion;
        boolean bl = false;
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
        cancellable$iv.initCancellability();
        CancellableContinuation cont = cancellable$iv;
        boolean bl2 = false;
        Continuation<Unit>[] resumes = null;
        resumes = AbstractSharedFlowKt.EMPTY_RESUMES;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        SharedFlowImpl sharedFlowImpl = this;
        synchronized (sharedFlowImpl) {
            Emitter emitter3;
            boolean bl3 = false;
            if (SharedFlowImpl.access$tryEmitLocked(this, value)) {
                ((Continuation)cont).resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
                resumes = SharedFlowImpl.access$findSlotsToResumeLocked(this, resumes);
                emitter3 = null;
            } else {
                Emitter emitter4;
                Emitter it = emitter4 = new Emitter(this, SharedFlowImpl.access$getHead(this) + (long)SharedFlowImpl.access$getTotalSize(this), value, (Continuation<? super Unit>)((Continuation)cont));
                boolean bl4 = false;
                SharedFlowImpl.access$enqueueLocked(this, it);
                int n2 = SharedFlowImpl.access$getQueueSize$p(this);
                SharedFlowImpl.access$setQueueSize$p(this, n2 + 1);
                if (SharedFlowImpl.access$getBufferCapacity$p(this) == 0) {
                    resumes = SharedFlowImpl.access$findSlotsToResumeLocked(this, resumes);
                }
                emitter3 = emitter4;
            }
            emitter2 = emitter3;
        }
        Emitter emitter5 = emitter = emitter2;
        if (emitter5 != null) {
            Emitter it = emitter5;
            boolean bl5 = false;
            CancellableContinuationKt.disposeOnCancellation(cont, it);
        }
        Continuation<Unit>[] continuationArray = resumes;
        int n3 = continuationArray.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            Continuation<Unit> r;
            Continuation<Unit> continuation = r = continuationArray[i2];
            if (continuation == null) continue;
            continuation.resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
        }
        Object object = cancellable$iv.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void cancelEmitter(Emitter emitter) {
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        SharedFlowImpl sharedFlowImpl = this;
        synchronized (sharedFlowImpl) {
            boolean bl = false;
            if (emitter.index < this.getHead()) {
                return;
            }
            Intrinsics.checkNotNull((Object)this.buffer);
            Object[] buffer = this.buffer;
            if (SharedFlowKt.access$getBufferAt(buffer, emitter.index) != emitter) {
                return;
            }
            SharedFlowKt.access$setBufferAt(buffer, emitter.index, SharedFlowKt.NO_VALUE);
            this.cleanupTailLocked();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long index = this.replayIndex;
        if (index < this.minCollectorIndex) {
            this.minCollectorIndex = index;
        }
        return index;
    }

    @NotNull
    public final Continuation<Unit>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long oldIndex) {
        int n2;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(oldIndex >= this.minCollectorIndex)) {
                throw new AssertionError();
            }
        }
        if (oldIndex > this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long head = this.getHead();
        long newMinCollectorIndex = 0L;
        newMinCollectorIndex = head + (long)this.bufferSize;
        if (this.bufferCapacity == 0 && this.queueSize > 0) {
            long l2 = newMinCollectorIndex;
            newMinCollectorIndex = l2 + 1L;
        }
        AbstractSharedFlow this_$iv = this;
        boolean $i$f$forEachSlotLocked = false;
        if (AbstractSharedFlow.access$getNCollectors(this_$iv) != 0) {
            AbstractSharedFlowSlot[] abstractSharedFlowSlotArray = AbstractSharedFlow.access$getSlots(this_$iv);
            if (abstractSharedFlowSlotArray != null) {
                AbstractSharedFlowSlot[] $this$forEach$iv$iv = abstractSharedFlowSlotArray;
                boolean $i$f$forEach = false;
                int n3 = $this$forEach$iv$iv.length;
                for (int i2 = 0; i2 < n3; ++i2) {
                    AbstractSharedFlowSlot element$iv$iv;
                    AbstractSharedFlowSlot slot$iv = element$iv$iv = $this$forEach$iv$iv[i2];
                    boolean bl = false;
                    if (slot$iv == null) continue;
                    SharedFlowSlot slot = (SharedFlowSlot)slot$iv;
                    boolean bl2 = false;
                    if (slot.index < 0L || slot.index >= newMinCollectorIndex) continue;
                    newMinCollectorIndex = slot.index;
                }
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(newMinCollectorIndex >= this.minCollectorIndex)) {
                throw new AssertionError();
            }
        }
        if (newMinCollectorIndex <= this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long newBufferEndIndex = this.getBufferEndIndex();
        if (this.getNCollectors() > 0) {
            int newBufferSize0 = (int)(newBufferEndIndex - newMinCollectorIndex);
            n2 = Math.min(this.queueSize, this.bufferCapacity - newBufferSize0);
        } else {
            n2 = this.queueSize;
        }
        int maxResumeCount = n2;
        Continuation<Unit>[] resumes = AbstractSharedFlowKt.EMPTY_RESUMES;
        long newQueueEndIndex = newBufferEndIndex + (long)this.queueSize;
        if (maxResumeCount > 0) {
            resumes = new Continuation[maxResumeCount];
            int resumeCount = 0;
            Intrinsics.checkNotNull((Object)this.buffer);
            Object[] buffer = this.buffer;
            for (long curEmitterIndex = newBufferEndIndex; curEmitterIndex < newQueueEndIndex; ++curEmitterIndex) {
                Object emitter = SharedFlowKt.access$getBufferAt(buffer, curEmitterIndex);
                if (emitter == SharedFlowKt.NO_VALUE) continue;
                Intrinsics.checkNotNull((Object)emitter, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                Emitter cfr_ignored_0 = (Emitter)emitter;
                resumes[resumeCount++] = ((Emitter)emitter).cont;
                SharedFlowKt.access$setBufferAt(buffer, curEmitterIndex, SharedFlowKt.NO_VALUE);
                SharedFlowKt.access$setBufferAt(buffer, newBufferEndIndex, ((Emitter)emitter).value);
                long l3 = newBufferEndIndex;
                newBufferEndIndex = l3 + 1L;
                if (resumeCount >= maxResumeCount) break;
            }
        }
        int newBufferSize1 = (int)(newBufferEndIndex - head);
        if (this.getNCollectors() == 0) {
            newMinCollectorIndex = newBufferEndIndex;
        }
        long newReplayIndex = Math.max(this.replayIndex, newBufferEndIndex - (long)Math.min(this.replay, newBufferSize1));
        if (this.bufferCapacity == 0 && newReplayIndex < newQueueEndIndex) {
            Intrinsics.checkNotNull((Object)this.buffer);
            if (Intrinsics.areEqual((Object)SharedFlowKt.access$getBufferAt(this.buffer, newReplayIndex), (Object)SharedFlowKt.NO_VALUE)) {
                long l4 = newBufferEndIndex;
                newBufferEndIndex = l4 + 1L;
                l4 = newReplayIndex;
                newReplayIndex = l4 + 1L;
            }
        }
        this.updateBufferLocked(newReplayIndex, newMinCollectorIndex, newBufferEndIndex, newQueueEndIndex);
        this.cleanupTailLocked();
        if (!(resumes.length == 0)) {
            resumes = this.findSlotsToResumeLocked(resumes);
        }
        return resumes;
    }

    private final void updateBufferLocked(long newReplayIndex, long newMinCollectorIndex, long newBufferEndIndex, long newQueueEndIndex) {
        long newHead = Math.min(newMinCollectorIndex, newReplayIndex);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(newHead >= this.getHead())) {
                throw new AssertionError();
            }
        }
        for (long index = this.getHead(); index < newHead; ++index) {
            Intrinsics.checkNotNull((Object)this.buffer);
            SharedFlowKt.access$setBufferAt(this.buffer, index, null);
        }
        this.replayIndex = newReplayIndex;
        this.minCollectorIndex = newMinCollectorIndex;
        this.bufferSize = (int)(newBufferEndIndex - newHead);
        this.queueSize = (int)(newQueueEndIndex - newBufferEndIndex);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(this.bufferSize >= 0)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(this.queueSize >= 0)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(this.replayIndex <= this.getHead() + (long)this.bufferSize)) {
                throw new AssertionError();
            }
        }
    }

    private final void cleanupTailLocked() {
        if (this.bufferCapacity == 0 && this.queueSize <= 1) {
            return;
        }
        Intrinsics.checkNotNull((Object)this.buffer);
        Object[] buffer = this.buffer;
        while (this.queueSize > 0 && SharedFlowKt.access$getBufferAt(buffer, this.getHead() + (long)this.getTotalSize() - 1L) == SharedFlowKt.NO_VALUE) {
            int n2 = this.queueSize;
            this.queueSize = n2 + -1;
            SharedFlowKt.access$setBufferAt(buffer, this.getHead() + (long)this.getTotalSize(), null);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final Object tryTakeValue(SharedFlowSlot slot) {
        Symbol symbol;
        Continuation<Unit>[] resumes = null;
        resumes = AbstractSharedFlowKt.EMPTY_RESUMES;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        SharedFlowImpl sharedFlowImpl = this;
        synchronized (sharedFlowImpl) {
            Object object;
            boolean bl = false;
            long index = this.tryPeekLocked(slot);
            if (index < 0L) {
                object = SharedFlowKt.NO_VALUE;
            } else {
                long oldIndex = slot.index;
                Object newValue = this.getPeekedValueLockedAt(index);
                slot.index = index + 1L;
                resumes = this.updateCollectorIndexLocked$kotlinx_coroutines_core(oldIndex);
                object = newValue;
            }
            symbol = object;
        }
        Symbol value = symbol;
        Continuation<Unit>[] continuationArray = resumes;
        int n2 = continuationArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Continuation<Unit> resume2;
            Continuation<Unit> continuation = resume2 = continuationArray[i2];
            if (continuation == null) continue;
            continuation.resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
        }
        return value;
    }

    private final long tryPeekLocked(SharedFlowSlot slot) {
        long index = slot.index;
        if (index < this.getBufferEndIndex()) {
            return index;
        }
        if (this.bufferCapacity > 0) {
            return -1L;
        }
        if (index > this.getHead()) {
            return -1L;
        }
        if (this.queueSize == 0) {
            return -1L;
        }
        return index;
    }

    /*
     * WARNING - void declaration
     */
    private final Object getPeekedValueLockedAt(long index) {
        void var3_2;
        Intrinsics.checkNotNull((Object)this.buffer);
        Object item = SharedFlowKt.access$getBufferAt(this.buffer, index);
        return item instanceof Emitter ? ((Emitter)item).value : var3_2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final Object awaitValue(SharedFlowSlot slot, Continuation<? super Unit> $completion) {
        boolean $i$f$suspendCancellableCoroutine = false;
        Continuation<? super Unit> uCont$iv = $completion;
        boolean bl = false;
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
        cancellable$iv.initCancellability();
        CancellableContinuation cont = cancellable$iv;
        boolean bl2 = false;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        SharedFlowImpl sharedFlowImpl = this;
        synchronized (sharedFlowImpl) {
            boolean bl3 = false;
            long index = SharedFlowImpl.access$tryPeekLocked(this, slot);
            if (index >= 0L) {
                ((Continuation)cont).resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
            } else {
                slot.cont = cont;
                slot.cont = cont;
            }
            Unit unit = Unit.INSTANCE;
        }
        Object object = cancellable$iv.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final Continuation<Unit>[] findSlotsToResumeLocked(Continuation<Unit>[] resumesIn) {
        Continuation<Unit>[] resumes;
        block3: {
            resumes = null;
            resumes = resumesIn;
            int resumeCount = 0;
            resumeCount = resumesIn.length;
            AbstractSharedFlow this_$iv = this;
            boolean $i$f$forEachSlotLocked = false;
            if (AbstractSharedFlow.access$getNCollectors(this_$iv) == 0) break block3;
            AbstractSharedFlowSlot[] abstractSharedFlowSlotArray = AbstractSharedFlow.access$getSlots(this_$iv);
            if (abstractSharedFlowSlotArray != null) {
                AbstractSharedFlowSlot[] $this$forEach$iv$iv = abstractSharedFlowSlotArray;
                boolean $i$f$forEach = false;
                int n2 = $this$forEach$iv$iv.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    Continuation<? super Unit> cont;
                    AbstractSharedFlowSlot element$iv$iv;
                    AbstractSharedFlowSlot slot$iv = element$iv$iv = $this$forEach$iv$iv[i2];
                    boolean bl = false;
                    if (slot$iv == null) continue;
                    SharedFlowSlot slot = (SharedFlowSlot)slot$iv;
                    boolean bl2 = false;
                    if (slot.cont == null || this.tryPeekLocked(slot) < 0L) continue;
                    if (resumeCount >= resumes.length) {
                        Intrinsics.checkNotNullExpressionValue(Arrays.copyOf(resumes, Math.max(2, 2 * resumes.length)), (String)"copyOf(this, newSize)");
                    }
                    int n3 = resumeCount;
                    resumeCount = n3 + 1;
                    resumes[n3] = cont;
                    slot.cont = null;
                }
            }
        }
        return resumes;
    }

    @Override
    @NotNull
    protected SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    @NotNull
    protected SharedFlowSlot[] createSlotArray(int size) {
        return new SharedFlowSlot[size];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetReplayCache() {
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        SharedFlowImpl sharedFlowImpl = this;
        synchronized (sharedFlowImpl) {
            boolean bl = false;
            this.updateBufferLocked(this.getBufferEndIndex(), this.minCollectorIndex, this.getBufferEndIndex(), this.getQueueEndIndex());
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override
    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, context, capacity, onBufferOverflow);
    }

    public static final /* synthetic */ Object access$emitSuspend(SharedFlowImpl $this, Object value, Continuation $completion) {
        return $this.emitSuspend(value, (Continuation<Unit>)$completion);
    }

    public static final /* synthetic */ Object access$awaitValue(SharedFlowImpl $this, SharedFlowSlot slot, Continuation $completion) {
        return $this.awaitValue(slot, (Continuation<Unit>)$completion);
    }

    public static final /* synthetic */ void access$enqueueLocked(SharedFlowImpl $this, Object item) {
        $this.enqueueLocked(item);
    }

    public static final /* synthetic */ int access$getQueueSize$p(SharedFlowImpl $this) {
        return $this.queueSize;
    }

    public static final /* synthetic */ void access$setQueueSize$p(SharedFlowImpl $this, int n2) {
        $this.queueSize = n2;
    }

    public static final /* synthetic */ int access$getBufferCapacity$p(SharedFlowImpl $this) {
        return $this.bufferCapacity;
    }

    public static final /* synthetic */ Continuation[] access$findSlotsToResumeLocked(SharedFlowImpl $this, Continuation[] resumesIn) {
        return $this.findSlotsToResumeLocked(resumesIn);
    }

    public static final /* synthetic */ boolean access$tryEmitLocked(SharedFlowImpl $this, Object value) {
        return $this.tryEmitLocked(value);
    }

    public static final /* synthetic */ long access$getHead(SharedFlowImpl $this) {
        return $this.getHead();
    }

    public static final /* synthetic */ int access$getTotalSize(SharedFlowImpl $this) {
        return $this.getTotalSize();
    }

    public static final /* synthetic */ long access$tryPeekLocked(SharedFlowImpl $this, SharedFlowSlot slot) {
        return $this.tryPeekLocked(slot);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2={"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "", "dispose", "()V", "Lkotlin/coroutines/Continuation;", "cont", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "", "index", "J", "", "value", "Ljava/lang/Object;", "<init>", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"})
    private static final class Emitter
    implements DisposableHandle {
        @JvmField
        @NotNull
        public final SharedFlowImpl<?> flow;
        @JvmField
        public long index;
        @JvmField
        @Nullable
        public final Object value;
        @JvmField
        @NotNull
        public final Continuation<Unit> cont;

        public Emitter(@NotNull SharedFlowImpl<?> flow, long index, @Nullable Object value, @NotNull Continuation<? super Unit> cont) {
            this.flow = flow;
            this.index = index;
            this.value = value;
            this.cont = cont;
        }

        @Override
        public void dispose() {
            ((SharedFlowImpl)this.flow).cancelEmitter(this);
        }
    }

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[BufferOverflow.values().length];
            try {
                nArray[BufferOverflow.SUSPEND.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}


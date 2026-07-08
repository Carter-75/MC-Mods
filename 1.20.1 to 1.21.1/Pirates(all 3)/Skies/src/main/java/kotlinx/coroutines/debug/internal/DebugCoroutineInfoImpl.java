/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequenceScope
 *  kotlin.sequences.SequencesKt
 */
package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl;
import kotlinx.coroutines.debug.internal.StackTraceFrame;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B%\b\u0000\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b8\u00109J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\t\u0010\nJ+\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\b2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\u00030\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u0015H\u0082P\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0013\u0010!\u001a\u0004\u0018\u00010\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u0005R(\u0010-\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00158@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u0010\u000b\u001a\u00020\b8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u0010\nR\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006:"}, d2={"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "", "", "Ljava/lang/StackTraceElement;", "creationStackTrace", "()Ljava/util/List;", "lastObservedStackTrace$kotlinx_coroutines_core", "lastObservedStackTrace", "", "toString", "()Ljava/lang/String;", "state", "Lkotlin/coroutines/Continuation;", "frame", "", "shouldBeMatched", "", "updateState$kotlinx_coroutines_core", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;Z)V", "updateState", "Lkotlin/sequences/SequenceScope;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "yieldFrames", "(Lkotlin/sequences/SequenceScope;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/ref/WeakReference;", "Lkotlin/coroutines/CoroutineContext;", "_context", "Ljava/lang/ref/WeakReference;", "_lastObservedFrame", "_state", "Ljava/lang/String;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "creationStackBottom", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getCreationStackBottom$kotlinx_coroutines_core", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getCreationStackTrace", "value", "getLastObservedFrame$kotlinx_coroutines_core", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "setLastObservedFrame$kotlinx_coroutines_core", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "lastObservedFrame", "Ljava/lang/Thread;", "lastObservedThread", "Ljava/lang/Thread;", "", "sequenceNumber", "J", "getState$kotlinx_coroutines_core", "", "unmatchedResume", "I", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/debug/internal/StackTraceFrame;J)V", "kotlinx-coroutines-core"})
@PublishedApi
@SourceDebugExtension(value={"SMAP\nDebugCoroutineInfoImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugCoroutineInfoImpl.kt\nkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n1#2:181\n*E\n"})
public final class DebugCoroutineInfoImpl {
    @Nullable
    private final StackTraceFrame creationStackBottom;
    @JvmField
    public final long sequenceNumber;
    @NotNull
    private final WeakReference<CoroutineContext> _context;
    @JvmField
    @NotNull
    public volatile String _state;
    private int unmatchedResume;
    @JvmField
    @Nullable
    public volatile Thread lastObservedThread;
    @JvmField
    @Nullable
    public volatile WeakReference<CoroutineStackFrame> _lastObservedFrame;

    public DebugCoroutineInfoImpl(@Nullable CoroutineContext context, @Nullable StackTraceFrame creationStackBottom, long sequenceNumber) {
        this.creationStackBottom = creationStackBottom;
        this.sequenceNumber = sequenceNumber;
        this._context = new WeakReference<CoroutineContext>(context);
        this._state = "CREATED";
    }

    @Nullable
    public final StackTraceFrame getCreationStackBottom$kotlinx_coroutines_core() {
        return this.creationStackBottom;
    }

    @Nullable
    public final CoroutineContext getContext() {
        return (CoroutineContext)this._context.get();
    }

    @NotNull
    public final List<StackTraceElement> getCreationStackTrace() {
        return this.creationStackTrace();
    }

    @NotNull
    public final String getState$kotlinx_coroutines_core() {
        return this._state;
    }

    public final synchronized void updateState$kotlinx_coroutines_core(@NotNull String state, @NotNull Continuation<?> frame, boolean shouldBeMatched) {
        if (Intrinsics.areEqual((Object)this._state, (Object)"RUNNING") && Intrinsics.areEqual((Object)state, (Object)"RUNNING") && shouldBeMatched) {
            ++this.unmatchedResume;
        } else if (this.unmatchedResume > 0 && Intrinsics.areEqual((Object)state, (Object)"SUSPENDED")) {
            this.unmatchedResume += -1;
            return;
        }
        if (Intrinsics.areEqual((Object)this._state, (Object)state) && Intrinsics.areEqual((Object)state, (Object)"SUSPENDED") && this.getLastObservedFrame$kotlinx_coroutines_core() != null) {
            return;
        }
        this._state = state;
        this.setLastObservedFrame$kotlinx_coroutines_core(frame instanceof CoroutineStackFrame ? (CoroutineStackFrame)frame : null);
        this.lastObservedThread = Intrinsics.areEqual((Object)state, (Object)"RUNNING") ? Thread.currentThread() : null;
    }

    @Nullable
    public final CoroutineStackFrame getLastObservedFrame$kotlinx_coroutines_core() {
        WeakReference<CoroutineStackFrame> weakReference = this._lastObservedFrame;
        return weakReference != null ? (CoroutineStackFrame)weakReference.get() : null;
    }

    /*
     * WARNING - void declaration
     */
    public final void setLastObservedFrame$kotlinx_coroutines_core(@Nullable CoroutineStackFrame value) {
        WeakReference<void> weakReference;
        DebugCoroutineInfoImpl debugCoroutineInfoImpl = this;
        CoroutineStackFrame coroutineStackFrame = value;
        if (coroutineStackFrame != null) {
            void it;
            CoroutineStackFrame coroutineStackFrame2 = coroutineStackFrame;
            DebugCoroutineInfoImpl debugCoroutineInfoImpl2 = debugCoroutineInfoImpl;
            boolean bl = false;
            weakReference = new WeakReference<void>(it);
            debugCoroutineInfoImpl = debugCoroutineInfoImpl2;
        } else {
            weakReference = null;
        }
        debugCoroutineInfoImpl._lastObservedFrame = weakReference;
    }

    @NotNull
    public final List<StackTraceElement> lastObservedStackTrace$kotlinx_coroutines_core() {
        if (this.getLastObservedFrame$kotlinx_coroutines_core() == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList<StackTraceElement> result2 = new ArrayList<StackTraceElement>();
        for (CoroutineStackFrame frame = v314840; frame != null; frame = frame.getCallerFrame()) {
            StackTraceElement it;
            if (frame.getStackTraceElement() == null) continue;
            boolean bl = false;
            result2.add(it);
        }
        return result2;
    }

    private final List<StackTraceElement> creationStackTrace() {
        StackTraceFrame stackTraceFrame = this.creationStackBottom;
        if (stackTraceFrame == null) {
            return CollectionsKt.emptyList();
        }
        StackTraceFrame bottom = stackTraceFrame;
        return SequencesKt.toList((Sequence)SequencesKt.sequence((Function2)((Function2)new Function2<SequenceScope<? super StackTraceElement>, Continuation<? super Unit>, Object>(this, bottom, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ DebugCoroutineInfoImpl this$0;
            final /* synthetic */ StackTraceFrame $bottom;
            {
                this.this$0 = $receiver;
                this.$bottom = $bottom;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        SequenceScope $this$sequence = (SequenceScope)this.L$0;
                        this.label = 1;
                        Object object3 = DebugCoroutineInfoImpl.access$yieldFrames(this.this$0, $this$sequence, this.$bottom.getCallerFrame(), (Continuation)this);
                        if (object3 != object2) return Unit.INSTANCE;
                        return object2;
                    }
                    case 1: {
                        void $result;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object3 = $result;
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<SequenceScope<? super StackTraceElement>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull SequenceScope<? super StackTraceElement> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        })));
    }

    /*
     * Unable to fully structure code
     */
    private final Object yieldFrames(SequenceScope<? super StackTraceElement> var1_1, CoroutineStackFrame var2_2, Continuation<? super Unit> var3_3) {
        block10: {
            if (!(var3_3 instanceof yieldFrames.1)) ** GOTO lbl-1000
            var9_4 = var3_3;
            if ((var9_4.label & -2147483648) != 0) {
                var9_4.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(this, var3_3){
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    /* synthetic */ Object result;
                    final /* synthetic */ DebugCoroutineInfoImpl this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return DebugCoroutineInfoImpl.access$yieldFrames(this.this$0, null, null, (Continuation)this);
                    }
                };
            }
            $result = $continuation.result;
            var10_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            block0 : switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
lbl12:
                    // 2 sources

                    while (true) {
                        if (frame == null) {
                            return Unit.INSTANCE;
                        }
                        if (frame.getStackTraceElement() == null) break block0;
                        $i$a$-let-DebugCoroutineInfoImpl$yieldFrames$2 = false;
                        $continuation.L$0 = this;
                        $continuation.L$1 = $this$yieldFrames;
                        $continuation.L$2 = frame;
                        $continuation.label = 1;
                        v0 = $this$yieldFrames.yield((Object)it, (Continuation)$continuation);
                        if (v0 == var10_6) {
                            return var10_6;
                        }
                        break block10;
                        break;
                    }
                }
                case 1: {
                    $i$a$-let-DebugCoroutineInfoImpl$yieldFrames$2 = false;
                    frame = (CoroutineStackFrame)$continuation.L$2;
                    $this$yieldFrames = (SequenceScope)$continuation.L$1;
                    this = (DebugCoroutineInfoImpl)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
                    break;
                }
            }
        }
        caller = frame.getCallerFrame();
        if (caller != null) {
            var5_8 = this;
            var6_9 = $this$yieldFrames;
            this = var5_8;
            var1_1 = var6_9;
            var2_2 = caller;
            ** continue;
        }
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public String toString() {
        return "DebugCoroutineInfo(state=" + this.getState$kotlinx_coroutines_core() + ",context=" + this.getContext() + ')';
    }

    public static final /* synthetic */ Object access$yieldFrames(DebugCoroutineInfoImpl $this, SequenceScope $receiver, CoroutineStackFrame frame, Continuation $completion) {
        return $this.yieldFrames((SequenceScope<? super StackTraceElement>)$receiver, frame, (Continuation<? super Unit>)$completion);
    }
}


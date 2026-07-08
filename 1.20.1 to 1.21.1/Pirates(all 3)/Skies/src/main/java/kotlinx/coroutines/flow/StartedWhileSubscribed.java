/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
 */
package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingCommand;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0017\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015\u00a8\u0006\u0019"}, d2={"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/SharingStarted;", "Lkotlinx/coroutines/flow/StateFlow;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "command", "(Lkotlinx/coroutines/flow/StateFlow;)Lkotlinx/coroutines/flow/Flow;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "replayExpiration", "J", "stopTimeout", "<init>", "(JJ)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nSharingStarted.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharingStarted.kt\nkotlinx/coroutines/flow/StartedWhileSubscribed\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,209:1\n1#2:210\n*E\n"})
final class StartedWhileSubscribed
implements SharingStarted {
    private final long stopTimeout;
    private final long replayExpiration;

    public StartedWhileSubscribed(long stopTimeout, long replayExpiration) {
        this.stopTimeout = stopTimeout;
        this.replayExpiration = replayExpiration;
        if (!(this.stopTimeout >= 0L)) {
            boolean $i$a$-require-StartedWhileSubscribed$32 = false;
            String $i$a$-require-StartedWhileSubscribed$32 = "stopTimeout(" + this.stopTimeout + " ms) cannot be negative";
            throw new IllegalArgumentException($i$a$-require-StartedWhileSubscribed$32.toString());
        }
        if (!(this.replayExpiration >= 0L)) {
            boolean bl = false;
            String string = "replayExpiration(" + this.replayExpiration + " ms) cannot be negative";
            throw new IllegalArgumentException(string.toString());
        }
    }

    @Override
    @NotNull
    public Flow<SharingCommand> command(@NotNull StateFlow<Integer> subscriptionCount) {
        return FlowKt.distinctUntilChanged(FlowKt.dropWhile(FlowKt.transformLatest((Flow)subscriptionCount, (Function3)new Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object>(this, null){
            int label;
            private /* synthetic */ Object L$0;
            /* synthetic */ int I$0;
            final /* synthetic */ StartedWhileSubscribed this$0;
            {
                this.this$0 = $receiver;
                super(3, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var4_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$transformLatest = (FlowCollector)this.L$0;
                        count = this.I$0;
                        if (count <= 0) break;
                        this.label = 1;
                        v0 = $this$transformLatest.emit(SharingCommand.START, (Continuation<Unit>)((Continuation)this));
                        if (v0 == var4_2) {
                            return var4_2;
                        }
                        ** GOTO lbl57
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
                        ** GOTO lbl57
                    }
                }
                this.L$0 = $this$transformLatest;
                this.label = 2;
                v1 = DelayKt.delay(StartedWhileSubscribed.access$getStopTimeout$p(this.this$0), (Continuation<? super Unit>)((Continuation)this));
                if (v1 == var4_2) {
                    return var4_2;
                }
                ** GOTO lbl27
                {
                    case 2: {
                        $this$transformLatest = (FlowCollector)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl27:
                        // 2 sources

                        if (StartedWhileSubscribed.access$getReplayExpiration$p(this.this$0) <= 0L) ** GOTO lbl48
                        this.L$0 = $this$transformLatest;
                        this.label = 3;
                        v2 = $this$transformLatest.emit(SharingCommand.STOP, (Continuation<Unit>)((Continuation)this));
                        if (v2 == var4_2) {
                            return var4_2;
                        }
                        ** GOTO lbl38
                    }
                    case 3: {
                        $this$transformLatest = (FlowCollector)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl38:
                        // 2 sources

                        this.L$0 = $this$transformLatest;
                        this.label = 4;
                        v3 = DelayKt.delay(StartedWhileSubscribed.access$getReplayExpiration$p(this.this$0), (Continuation<? super Unit>)((Continuation)this));
                        if (v3 == var4_2) {
                            return var4_2;
                        }
                        ** GOTO lbl48
                    }
                    case 4: {
                        $this$transformLatest = (FlowCollector)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v3 = $result;
lbl48:
                        // 3 sources

                        this.L$0 = null;
                        this.label = 5;
                        v4 = $this$transformLatest.emit(SharingCommand.STOP_AND_RESET_REPLAY_CACHE, (Continuation<Unit>)((Continuation)this));
                        if (v4 == var4_2) {
                            return var4_2;
                        }
                        ** GOTO lbl57
                    }
                    case 5: {
                        ResultKt.throwOnFailure((Object)$result);
                        v4 = $result;
lbl57:
                        // 4 sources

                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super SharingCommand> p1, int p2, @Nullable Continuation<? super Unit> p3) {
                Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                function3.L$0 = p1;
                function3.I$0 = p2;
                return function3.invokeSuspend((Object)Unit.INSTANCE);
            }
        }), (Function2)new Function2<SharingCommand, Continuation<? super Boolean>, Object>(null){
            int label;
            /* synthetic */ Object L$0;

            @Nullable
            public final Object invokeSuspend(@NotNull Object object) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        SharingCommand it = (SharingCommand)((Object)this.L$0);
                        return Boxing.boxBoolean((it != SharingCommand.START ? 1 : 0) != 0);
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<SharingCommand, Continuation<? super Boolean>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull SharingCommand p1, @Nullable Continuation<? super Boolean> p2) {
                return (this.create((Object)((Object)p1), p2)).invokeSuspend(Unit.INSTANCE);
            }
        }));
    }

    @NotNull
    public String toString() {
        List list;
        List $this$toString_u24lambda_u242 = list = CollectionsKt.createListBuilder((int)2);
        boolean bl = false;
        if (this.stopTimeout > 0L) {
            $this$toString_u24lambda_u242.add("stopTimeout=" + this.stopTimeout + "ms");
        }
        if (this.replayExpiration < Long.MAX_VALUE) {
            $this$toString_u24lambda_u242.add("replayExpiration=" + this.replayExpiration + "ms");
        }
        List params = CollectionsKt.build((List)list);
        return "SharingStarted.WhileSubscribed(" + CollectionsKt.joinToString$default((Iterable)params, null, null, null, (int)0, null, null, (int)63, null) + ')';
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof StartedWhileSubscribed && this.stopTimeout == ((StartedWhileSubscribed)other).stopTimeout && this.replayExpiration == ((StartedWhileSubscribed)other).replayExpiration;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return Long.hashCode(this.stopTimeout) * 31 + Long.hashCode(this.replayExpiration);
    }

    public static final /* synthetic */ long access$getStopTimeout$p(StartedWhileSubscribed $this) {
        return $this.stopTimeout;
    }

    public static final /* synthetic */ long access$getReplayExpiration$p(StartedWhileSubscribed $this) {
        return $this.replayExpiration;
    }
}


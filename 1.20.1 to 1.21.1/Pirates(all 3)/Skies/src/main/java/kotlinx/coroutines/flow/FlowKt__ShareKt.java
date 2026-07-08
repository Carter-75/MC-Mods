/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingCommand;
import kotlinx.coroutines.flow.SharingConfig;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.SubscribedSharedFlow;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\r\u0010\u000e\u001aM\u0010\u001b\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0000*\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001aC\u0010!\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000*\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u001cH\u0002\u00a2\u0006\u0004\b\u001f\u0010 \u001aU\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022-\u0010'\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0$\u0012\u0006\u0012\u0004\u0018\u00010%0\"\u00a2\u0006\u0002\b&\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)\u001a=\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b+\u0010,\u001a1\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010*\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010.\u001a;\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00028\u0000\u00a2\u0006\u0004\b-\u0010/\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00060"}, d2={"T", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlow;", "asSharedFlow", "(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "asStateFlow", "(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/Flow;", "", "replay", "Lkotlinx/coroutines/flow/SharingConfig;", "configureSharing$FlowKt__ShareKt", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/SharingConfig;", "configureSharing", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "context", "upstream", "shared", "Lkotlinx/coroutines/flow/SharingStarted;", "started", "initialValue", "Lkotlinx/coroutines/Job;", "launchSharing$FlowKt__ShareKt", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/Job;", "launchSharing", "Lkotlinx/coroutines/CompletableDeferred;", "result", "", "launchSharingDeferred$FlowKt__ShareKt", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CompletableDeferred;)V", "launchSharingDeferred", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "action", "onSubscription", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/SharedFlow;", "scope", "shareIn", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/SharingStarted;I)Lkotlinx/coroutines/flow/SharedFlow;", "stateIn", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(value={"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/FlowKt__ShareKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,426:1\n1#2:427\n*E\n"})
final class FlowKt__ShareKt {
    @NotNull
    public static final <T> SharedFlow<T> shareIn(@NotNull Flow<? extends T> $this$shareIn, @NotNull CoroutineScope scope, @NotNull SharingStarted started, int replay) {
        SharingConfig<? extends T> config = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt($this$shareIn, replay);
        MutableSharedFlow shared = SharedFlowKt.MutableSharedFlow(replay, config.extraBufferCapacity, config.onBufferOverflow);
        Job job = FlowKt__ShareKt.launchSharing$FlowKt__ShareKt(scope, config.context, config.upstream, shared, started, (Object)SharedFlowKt.NO_VALUE);
        return new ReadonlySharedFlow(shared, job);
    }

    public static /* synthetic */ SharedFlow shareIn$default(Flow flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, int n2, int n3, Object object) {
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        return FlowKt.shareIn(flow, coroutineScope, sharingStarted, n2);
    }

    private static final <T> SharingConfig<T> configureSharing$FlowKt__ShareKt(Flow<? extends T> $this$configureSharing, int replay) {
        Flow upstream;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(replay >= 0)) {
                throw new AssertionError();
            }
        }
        int defaultExtraCapacity = RangesKt.coerceAtLeast((int)replay, (int)Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core()) - replay;
        if ($this$configureSharing instanceof ChannelFlow && (upstream = ((ChannelFlow)$this$configureSharing).dropChannelOperators()) != null) {
            int n2;
            switch (((ChannelFlow)$this$configureSharing).capacity) {
                case -3: 
                case -2: 
                case 0: {
                    if (((ChannelFlow)$this$configureSharing).onBufferOverflow == BufferOverflow.SUSPEND) {
                        if (((ChannelFlow)$this$configureSharing).capacity == 0) {
                            n2 = 0;
                            break;
                        }
                        n2 = defaultExtraCapacity;
                        break;
                    }
                    if (replay == 0) {
                        n2 = 1;
                        break;
                    }
                    n2 = 0;
                    break;
                }
                default: {
                    n2 = ((ChannelFlow)$this$configureSharing).capacity;
                }
            }
            return new SharingConfig(upstream, n2, ((ChannelFlow)$this$configureSharing).onBufferOverflow, ((ChannelFlow)$this$configureSharing).context);
        }
        return new SharingConfig<T>($this$configureSharing, defaultExtraCapacity, BufferOverflow.SUSPEND, (CoroutineContext)EmptyCoroutineContext.INSTANCE);
    }

    private static final <T> Job launchSharing$FlowKt__ShareKt(CoroutineScope $this$launchSharing, CoroutineContext context, Flow<? extends T> upstream, MutableSharedFlow<T> shared, SharingStarted started, T initialValue) {
        CoroutineStart start = Intrinsics.areEqual((Object)started, (Object)SharingStarted.Companion.getEagerly()) ? CoroutineStart.DEFAULT : CoroutineStart.UNDISPATCHED;
        return BuildersKt.launch($this$launchSharing, context, start, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(started, upstream, shared, initialValue, null){
            int label;
            final /* synthetic */ SharingStarted $started;
            final /* synthetic */ Flow<T> $upstream;
            final /* synthetic */ MutableSharedFlow<T> $shared;
            final /* synthetic */ T $initialValue;
            {
                this.$started = $started;
                this.$upstream = $upstream;
                this.$shared = $shared;
                this.$initialValue = $initialValue;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                block11: {
                    var2_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)var1_1);
                            if (this.$started != SharingStarted.Companion.getEagerly()) break;
                            this.label = 1;
                            v0 = this.$upstream.collect(this.$shared, (Continuation<Unit>)((Continuation)this));
                            if (v0 == var2_2) {
                                return var2_2;
                            }
                            ** GOTO lbl43
                        }
                        case 1: {
                            ResultKt.throwOnFailure((Object)$result);
                            v0 = $result;
                            ** GOTO lbl43
                        }
                    }
                    if (this.$started != SharingStarted.Companion.getLazily()) break block11;
                    this.label = 2;
                    v1 = FlowKt.first((Flow)this.$shared.getSubscriptionCount(), (Function2)new Function2<Integer, Continuation<? super Boolean>, Object>(null){
                        int label;
                        /* synthetic */ int I$0;

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object object) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0: {
                                    ResultKt.throwOnFailure((Object)object);
                                    int it = this.I$0;
                                    return Boxing.boxBoolean((it > 0 ? 1 : 0) != 0);
                                }
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                            Function2<Integer, Continuation<? super Boolean>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                            function2.I$0 = ((Number)value).intValue();
                            return (Continuation)function2;
                        }

                        @Nullable
                        public final Object invoke(int p1, @Nullable Continuation<? super Boolean> p2) {
                            return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                        }
                    }, (Continuation)this);
                    if (v1 == var2_2) {
                        return var2_2;
                    }
                    ** GOTO lbl25
                    {
                        case 2: {
                            ResultKt.throwOnFailure((Object)$result);
                            v1 = $result;
lbl25:
                            // 2 sources

                            this.label = 3;
                            v2 = this.$upstream.collect(this.$shared, (Continuation<Unit>)((Continuation)this));
                            if (v2 == var2_2) {
                                return var2_2;
                            }
                            ** GOTO lbl43
                        }
                        case 3: {
                            ResultKt.throwOnFailure((Object)$result);
                            v2 = $result;
                            ** GOTO lbl43
                        }
                    }
                }
                this.label = 4;
                v3 = FlowKt.collectLatest(FlowKt.distinctUntilChanged(this.$started.command(this.$shared.getSubscriptionCount())), (Function2)new Function2<SharingCommand, Continuation<? super Unit>, Object>(this.$upstream, this.$shared, this.$initialValue, null){
                    int label;
                    /* synthetic */ Object L$0;
                    final /* synthetic */ Flow<T> $upstream;
                    final /* synthetic */ MutableSharedFlow<T> $shared;
                    final /* synthetic */ T $initialValue;
                    {
                        this.$upstream = $upstream;
                        this.$shared = $shared;
                        this.$initialValue = $initialValue;
                        super(2, $completion);
                    }

                    /*
                     * Exception decompiling
                     */
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object var1_1) {
                        /*
                         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                         * 
                         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[CASE]], but top level block is 4[SWITCH]
                         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                         *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                         *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.CastExpression.dumpInner(CastExpression.java:114)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                         *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                         *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                         *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredAssignment.dump(StructuredAssignment.java:69)
                         *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                         *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                         *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                         *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                         *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                         *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.CastExpression.dumpInner(CastExpression.java:114)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:139)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.CastExpression.dumpInner(CastExpression.java:114)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                         *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                         *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                         *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.dump(StructuredReturn.java:60)
                         *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                         *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                         *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                         *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                         *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                         *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                         *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                         *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                         *     at org.benf.cfr.reader.Main.main(Main.java:54)
                         */
                        throw new IllegalStateException("Decompilation failed");
                    }

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                        Function2<SharingCommand, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                        function2.L$0 = value;
                        return (Continuation)function2;
                    }

                    @Nullable
                    public final Object invoke(@NotNull SharingCommand p1, @Nullable Continuation<? super Unit> p2) {
                        return (this.create((Object)((Object)p1), p2)).invokeSuspend(Unit.INSTANCE);
                    }
                }, (Continuation<? super Unit>)((Continuation)this));
                if (v3 == var2_2) {
                    return var2_2;
                }
                ** GOTO lbl43
                {
                    case 4: {
                        ResultKt.throwOnFailure((Object)$result);
                        v3 = $result;
lbl43:
                        // 6 sources

                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }));
    }

    @NotNull
    public static final <T> StateFlow<T> stateIn(@NotNull Flow<? extends T> $this$stateIn, @NotNull CoroutineScope scope, @NotNull SharingStarted started, T initialValue) {
        SharingConfig<? extends T> config = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt($this$stateIn, 1);
        MutableStateFlow<T> state = StateFlowKt.MutableStateFlow(initialValue);
        Job job = FlowKt__ShareKt.launchSharing$FlowKt__ShareKt(scope, config.context, config.upstream, state, started, initialValue);
        return new ReadonlyStateFlow(state, job);
    }

    @Nullable
    public static final <T> Object stateIn(@NotNull Flow<? extends T> $this$stateIn, @NotNull CoroutineScope scope, @NotNull Continuation<? super StateFlow<? extends T>> $completion) {
        SharingConfig<? extends T> config = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt($this$stateIn, 1);
        CompletableDeferred result2 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        FlowKt__ShareKt.launchSharingDeferred$FlowKt__ShareKt(scope, config.context, config.upstream, result2);
        return result2.await($completion);
    }

    private static final <T> void launchSharingDeferred$FlowKt__ShareKt(CoroutineScope $this$launchSharingDeferred, CoroutineContext context, Flow<? extends T> upstream, CompletableDeferred<StateFlow<T>> result2) {
        BuildersKt.launch$default($this$launchSharingDeferred, context, null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(upstream, result2, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Flow<T> $upstream;
            final /* synthetic */ CompletableDeferred<StateFlow<T>> $result;
            {
                this.$upstream = $upstream;
                this.$result = $result;
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
                        CoroutineScope $this$launch = (CoroutineScope)this.L$0;
                        Ref.ObjectRef state = new Ref.ObjectRef();
                        this.label = 1;
                        Object object3 = this.$upstream.collect(new FlowCollector(state, $this$launch, this.$result){
                            final /* synthetic */ Ref.ObjectRef<MutableStateFlow<T>> $state;
                            final /* synthetic */ CoroutineScope $$this$launch;
                            final /* synthetic */ CompletableDeferred<StateFlow<T>> $result;
                            {
                                this.$state = $state;
                                this.$$this$launch = $$this$launch;
                                this.$result = $result;
                            }

                            /*
                             * WARNING - void declaration
                             */
                            @Nullable
                            public final Object emit(T value, @NotNull Continuation<? super Unit> $completion) {
                                block2: {
                                    void it;
                                    MutableStateFlow<T> mutableStateFlow;
                                    Unit unit;
                                    MutableStateFlow mutableStateFlow2 = (MutableStateFlow)this.$state.element;
                                    if (mutableStateFlow2 != null) {
                                        MutableStateFlow it2 = mutableStateFlow2;
                                        boolean bl = false;
                                        it2.setValue(value);
                                        unit = Unit.INSTANCE;
                                    } else {
                                        unit = null;
                                    }
                                    if (unit != null) break block2;
                                    CoroutineScope coroutineScope = this.$$this$launch;
                                    Ref.ObjectRef<MutableStateFlow<T>> objectRef = this.$state;
                                    CompletableDeferred<StateFlow<ReadonlyStateFlow<T>>> completableDeferred = this.$result;
                                    CoroutineScope $this$emit_u24lambda_u242 = coroutineScope;
                                    boolean bl = false;
                                    MutableStateFlow<T> mutableStateFlow3 = mutableStateFlow = StateFlowKt.MutableStateFlow(value);
                                    Ref.ObjectRef<MutableStateFlow<T>> objectRef2 = objectRef;
                                    boolean bl2 = false;
                                    completableDeferred.complete(new ReadonlyStateFlow<T>((StateFlow)it, JobKt.getJob($this$emit_u24lambda_u242.getCoroutineContext())));
                                    objectRef2.element = mutableStateFlow;
                                }
                                return Unit.INSTANCE;
                            }
                        }, (Continuation<Unit>)((Continuation)this));
                        if (object3 != object2) return Unit.INSTANCE;
                        return object2;
                    }
                    case 1: {
                        Object object3;
                        try {
                            void $result;
                            ResultKt.throwOnFailure((Object)$result);
                            object3 = $result;
                            return Unit.INSTANCE;
                        }
                        catch (Throwable e2) {
                            this.$result.completeExceptionally(e2);
                            throw e2;
                        }
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 2, null);
    }

    @NotNull
    public static final <T> SharedFlow<T> asSharedFlow(@NotNull MutableSharedFlow<T> $this$asSharedFlow) {
        return new ReadonlySharedFlow($this$asSharedFlow, null);
    }

    @NotNull
    public static final <T> StateFlow<T> asStateFlow(@NotNull MutableStateFlow<T> $this$asStateFlow) {
        return new ReadonlyStateFlow($this$asStateFlow, null);
    }

    @NotNull
    public static final <T> SharedFlow<T> onSubscription(@NotNull SharedFlow<? extends T> $this$onSubscription, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> action) {
        return new SubscribedSharedFlow<T>($this$onSubscription, action);
    }
}


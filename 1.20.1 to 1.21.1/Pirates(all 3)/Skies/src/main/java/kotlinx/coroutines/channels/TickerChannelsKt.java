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
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.channels.TickerChannelsKt;
import kotlinx.coroutines.channels.TickerMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000(\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a1\u0010\b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\u0007\u001a;\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2={"", "delayMillis", "initialDelayMillis", "Lkotlinx/coroutines/channels/SendChannel;", "", "channel", "fixedDelayTicker", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/channels/TickerMode;", "mode", "Lkotlinx/coroutines/channels/ReceiveChannel;", "ticker", "(JJLkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/TickerMode;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nTickerChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TickerChannels.kt\nkotlinx/coroutines/channels/TickerChannelsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,112:1\n1#2:113\n*E\n"})
public final class TickerChannelsKt {
    @ObsoleteCoroutinesApi
    @NotNull
    public static final ReceiveChannel<Unit> ticker(long delayMillis, long initialDelayMillis, @NotNull CoroutineContext context, @NotNull TickerMode mode) {
        if (!(delayMillis >= 0L)) {
            boolean $i$a$-require-TickerChannelsKt$ticker$32 = false;
            String $i$a$-require-TickerChannelsKt$ticker$32 = "Expected non-negative delay, but has " + delayMillis + " ms";
            throw new IllegalArgumentException($i$a$-require-TickerChannelsKt$ticker$32.toString());
        }
        if (!(initialDelayMillis >= 0L)) {
            boolean bl = false;
            String string = "Expected non-negative initial delay, but has " + initialDelayMillis + " ms";
            throw new IllegalArgumentException(string.toString());
        }
        return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(context), 0, (Function2)new Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object>(mode, delayMillis, initialDelayMillis, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ TickerMode $mode;
            final /* synthetic */ long $delayMillis;
            final /* synthetic */ long $initialDelayMillis;
            {
                this.$mode = $mode;
                this.$delayMillis = $delayMillis;
                this.$initialDelayMillis = $initialDelayMillis;
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
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[CASE]], but top level block is 5[SWITCH]
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
                Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super Unit> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long l2, long l3, CoroutineContext coroutineContext, TickerMode tickerMode, int n2, Object object) {
        if ((n2 & 2) != 0) {
            l3 = l2;
        }
        if ((n2 & 4) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n2 & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return TickerChannelsKt.ticker(l2, l3, coroutineContext, tickerMode);
    }

    /*
     * Unable to fully structure code
     */
    private static final Object fixedPeriodTicker(long var0, long var2_1, SendChannel<? super Unit> var4_2, Continuation<? super Unit> var5_3) {
        if (!(var5_3 instanceof fixedPeriodTicker.1)) ** GOTO lbl-1000
        var17_4 = var5_3;
        if ((var17_4.label & -2147483648) != 0) {
            var17_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var5_3){
                long J$0;
                long J$1;
                Object L$0;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return TickerChannelsKt.access$fixedPeriodTicker(0L, 0L, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var18_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                v0 = AbstractTimeSourceKt.getTimeSource();
                deadline = (v0 != null ? v0.nanoTime() : System.nanoTime()) + EventLoop_commonKt.delayToNanos((long)initialDelayMillis);
                $continuation.L$0 = channel;
                $continuation.J$0 = delayMillis;
                $continuation.J$1 = deadline;
                $continuation.label = 1;
                v1 = DelayKt.delay((long)initialDelayMillis, (Continuation<? super Unit>)$continuation);
                if (v1 == var18_6) {
                    return var18_6;
                }
                ** GOTO lbl28
            }
            case 1: {
                deadline = $continuation.J$1;
                delayMillis = $continuation.J$0;
                channel = (SendChannel)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl28:
                // 2 sources

                delayNs = EventLoop_commonKt.delayToNanos(delayMillis);
lbl30:
                // 4 sources

                while (true) {
                    $continuation.L$0 = channel;
                    $continuation.J$0 = deadline += delayNs;
                    $continuation.J$1 = delayNs;
                    $continuation.label = 2;
                    v2 = channel.send(Unit.INSTANCE, (Continuation<Unit>)$continuation);
                    if (v2 == var18_6) {
                        return var18_6;
                    }
                    ** GOTO lbl45
                    break;
                }
            }
            case 2: {
                delayNs = $continuation.J$1;
                deadline = $continuation.J$0;
                channel = (SendChannel)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl45:
                // 2 sources

                v3 = AbstractTimeSourceKt.getTimeSource();
                now = v3 != null ? v3.nanoTime() : System.nanoTime();
                nextDelay = RangesKt.coerceAtLeast((long)(deadline - now), (long)0L);
                if (nextDelay != 0L || delayNs == 0L) break;
                adjustedDelay = delayNs - (now - deadline) % delayNs;
                deadline = now + adjustedDelay;
                $continuation.L$0 = channel;
                $continuation.J$0 = deadline;
                $continuation.J$1 = delayNs;
                $continuation.label = 3;
                v4 = DelayKt.delay(EventLoop_commonKt.delayNanosToMillis(adjustedDelay), (Continuation<? super Unit>)$continuation);
                if (v4 != var18_6) ** GOTO lbl30
                return var18_6;
            }
            case 3: {
                delayNs = $continuation.J$1;
                deadline = $continuation.J$0;
                channel = (SendChannel)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v4 = $result;
                ** GOTO lbl30
            }
        }
        $continuation.L$0 = channel;
        $continuation.J$0 = deadline;
        $continuation.J$1 = delayNs;
        $continuation.label = 4;
        v5 = DelayKt.delay(EventLoop_commonKt.delayNanosToMillis(nextDelay), (Continuation<? super Unit>)$continuation);
        if (v5 == var18_6) {
            return var18_6;
        }
        ** GOTO lbl79
        {
            case 4: {
                delayNs = $continuation.J$1;
                deadline = $continuation.J$0;
                channel = (SendChannel)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v5 = $result;
lbl79:
                // 2 sources

                ** continue;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    private static final Object fixedDelayTicker(long var0, long var2_1, SendChannel<? super Unit> var4_2, Continuation<? super Unit> var5_3) {
        if (!(var5_3 instanceof fixedDelayTicker.1)) ** GOTO lbl-1000
        var7_4 = var5_3;
        if ((var7_4.label & -2147483648) != 0) {
            var7_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var5_3){
                long J$0;
                Object L$0;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return TickerChannelsKt.access$fixedDelayTicker(0L, 0L, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var8_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = channel;
                $continuation.J$0 = delayMillis;
                $continuation.label = 1;
                v0 = DelayKt.delay((long)initialDelayMillis, (Continuation<? super Unit>)$continuation);
                if (v0 == var8_6) {
                    return var8_6;
                }
                ** GOTO lbl24
            }
            case 1: {
                delayMillis = $continuation.J$0;
                channel = (SendChannel)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl24:
                // 3 sources

                while (true) {
                    $continuation.L$0 = channel;
                    $continuation.J$0 = delayMillis;
                    $continuation.label = 2;
                    v1 = channel.send(Unit.INSTANCE, (Continuation<Unit>)$continuation);
                    if (v1 == var8_6) {
                        return var8_6;
                    }
                    ** GOTO lbl37
                    break;
                }
            }
            case 2: {
                delayMillis = $continuation.J$0;
                channel = (SendChannel)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl37:
                // 2 sources

                $continuation.L$0 = channel;
                $continuation.J$0 = delayMillis;
                $continuation.label = 3;
                v2 = DelayKt.delay(delayMillis, (Continuation<? super Unit>)$continuation);
                if (v2 == var8_6) {
                    return var8_6;
                }
                ** GOTO lbl49
            }
            case 3: {
                delayMillis = $continuation.J$0;
                channel = (SendChannel)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl49:
                // 2 sources

                ** continue;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static final /* synthetic */ Object access$fixedPeriodTicker(long delayMillis, long initialDelayMillis, SendChannel channel, Continuation $completion) {
        return TickerChannelsKt.fixedPeriodTicker(delayMillis, initialDelayMillis, channel, (Continuation<? super Unit>)$completion);
    }

    public static final /* synthetic */ Object access$fixedDelayTicker(long delayMillis, long initialDelayMillis, SendChannel channel, Continuation $completion) {
        return TickerChannelsKt.fixedDelayTicker(delayMillis, initialDelayMillis, channel, (Continuation<? super Unit>)$completion);
    }
}


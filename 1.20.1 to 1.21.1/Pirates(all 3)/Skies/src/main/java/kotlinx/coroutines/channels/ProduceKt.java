/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.BuilderInference
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.channels;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0004\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u00a0\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2-\b\u0002\u0010\u0014\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000ej\u0004\u0018\u0001`\u00132/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015\u00a2\u0006\u0002\b\u0018H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a\u00aa\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\r\u001a\u00020\f2-\b\u0002\u0010\u0014\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000ej\u0004\u0018\u0001`\u00132/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015\u00a2\u0006\u0002\b\u0018H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001e\u001ag\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015\u00a2\u0006\u0002\b\u0018H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2={"Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Function0;", "", "block", "awaitClose", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "E", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "produce", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nProduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Produce.kt\nkotlinx/coroutines/channels/ProduceKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,151:1\n1#2:152\n314#3,11:153\n*S KotlinDebug\n*F\n+ 1 Produce.kt\nkotlinx/coroutines/channels/ProduceKt\n*L\n48#1:153,11\n*E\n"})
public final class ProduceKt {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Nullable
    public static final Object awaitClose(@NotNull ProducerScope<?> var0, @NotNull Function0<Unit> var1_1, @NotNull Continuation<? super Unit> var2_2) {
        if (!(var2_2 instanceof awaitClose.1)) ** GOTO lbl-1000
        var10_3 = var2_2;
        if ((var10_3.label & -2147483648) != 0) {
            var10_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var2_2){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ProduceKt.awaitClose(null, null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var11_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                if (!($continuation.getContext().get((CoroutineContext.Key)Job.Key) == $this$awaitClose)) {
                    $i$a$-check-ProduceKt$awaitClose$3 = false;
                    $i$a$-check-ProduceKt$awaitClose$3 = "awaitClose() can only be invoked from the producer context";
                    throw new IllegalStateException($i$a$-check-ProduceKt$awaitClose$3.toString());
                }
                $i$f$suspendCancellableCoroutine = false;
                $continuation.L$0 = $this$awaitClose;
                $continuation.L$1 = block;
                $continuation.label = 1;
                uCont$iv = (Continuation)$continuation;
                $i$a$-suspendCoroutineUninterceptedOrReturn-CancellableContinuationKt$suspendCancellableCoroutine$2$iv = false;
                cancellable$iv = new CancellableContinuationImpl<T>(IntrinsicsKt.intercepted((Continuation)uCont$iv), 1);
                cancellable$iv.initCancellability();
                cont = cancellable$iv;
                $i$a$-suspendCancellableCoroutine-ProduceKt$awaitClose$4 = false;
                $this$awaitClose.invokeOnClose((Function1<Throwable, Unit>)((Function1)new Function1<Throwable, Unit>((CancellableContinuation<? super Unit>)cont){
                    final /* synthetic */ CancellableContinuation<Unit> $cont;
                    {
                        this.$cont = $cont;
                        super(1);
                    }

                    public final void invoke(@Nullable Throwable it) {
                        ((Continuation)this.$cont).resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
                    }
                }));
                v0 = cancellable$iv.getResult();
                if (v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended((Continuation)((Continuation)$continuation));
                }
                v1 = v0;
                if (v0 == var11_5) {
                    return var11_5;
                }
                ** GOTO lbl51
            }
            case 1: {
                $i$f$suspendCancellableCoroutine = false;
                block = (Function0)$continuation.L$1;
                var0 = (ProducerScope)$continuation.L$0;
                {
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
                    ** GOTO lbl51
                }
            }
            {
                finally {
                    block.invoke();
                }
            }
lbl51:
            // 2 sources

            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static /* synthetic */ Object awaitClose$default(ProducerScope producerScope, Function0 function0, Continuation continuation, int n2, Object object) {
        if ((n2 & 1) != 0) {
            function0 = awaitClose.2.INSTANCE;
        }
        return ProduceKt.awaitClose(producerScope, (Function0<Unit>)function0, (Continuation<? super Unit>)continuation);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <E> ReceiveChannel<E> produce(@NotNull CoroutineScope $this$produce, @NotNull CoroutineContext context, int capacity, @BuilderInference @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> block) {
        return ProduceKt.produce($this$produce, context, capacity, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, block);
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int n2, Function2 function2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        return ProduceKt.produce(coroutineScope, coroutineContext, n2, function2);
    }

    @InternalCoroutinesApi
    @NotNull
    public static final <E> ReceiveChannel<E> produce(@NotNull CoroutineScope $this$produce, @NotNull CoroutineContext context, int capacity, @NotNull CoroutineStart start, @Nullable Function1<? super Throwable, Unit> onCompletion, @BuilderInference @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> block) {
        return ProduceKt.produce($this$produce, context, capacity, BufferOverflow.SUSPEND, start, onCompletion, block);
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int n2, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        if ((n3 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        if ((n3 & 8) != 0) {
            function1 = null;
        }
        return ProduceKt.produce(coroutineScope, coroutineContext, n2, coroutineStart, (Function1<? super Throwable, Unit>)function1, function2);
    }

    @NotNull
    public static final <E> ReceiveChannel<E> produce(@NotNull CoroutineScope $this$produce, @NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow, @NotNull CoroutineStart start, @Nullable Function1<? super Throwable, Unit> onCompletion, @BuilderInference @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Channel channel = ChannelKt.Channel$default(capacity, onBufferOverflow, null, 4, null);
        CoroutineContext newContext = CoroutineContextKt.newCoroutineContext($this$produce, context);
        ProducerCoroutine coroutine = new ProducerCoroutine(newContext, channel);
        if (onCompletion != null) {
            coroutine.invokeOnCompletion(onCompletion);
        }
        coroutine.start(start, coroutine, block);
        return coroutine;
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int n2, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        if ((n3 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((n3 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        if ((n3 & 0x10) != 0) {
            function1 = null;
        }
        return ProduceKt.produce(coroutineScope, coroutineContext, n2, bufferOverflow, coroutineStart, (Function1<? super Throwable, Unit>)function1, function2);
    }
}


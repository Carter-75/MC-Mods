/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.Volatile
 */
package kotlinx.coroutines.stream;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.stream.StreamFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u000b\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2={"Lkotlinx/coroutines/stream/StreamFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/atomicfu/AtomicBoolean;", "consumed", "Ljava/util/stream/Stream;", "stream", "Ljava/util/stream/Stream;", "<init>", "(Ljava/util/stream/Stream;)V", "kotlinx-coroutines-core"})
final class StreamFlow<T>
implements Flow<T> {
    @NotNull
    private final Stream<T> stream;
    @Volatile
    private volatile int consumed;
    @NotNull
    private static final AtomicIntegerFieldUpdater consumed$FU = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed");

    public StreamFlow(@NotNull Stream<T> stream) {
        this.stream = stream;
        this.consumed = 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> var1_1, @NotNull Continuation<? super Unit> var2_2) {
        if (!(var2_2 instanceof collect.1)) ** GOTO lbl-1000
        var6_3 = var2_2;
        if ((var6_3.label & -2147483648) != 0) {
            var6_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, var2_2){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                final /* synthetic */ StreamFlow<T> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.collect(null, (Continuation<Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var7_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                if (!StreamFlow.consumed$FU.compareAndSet(this, 0, 1)) {
                    throw new IllegalStateException("Stream.consumeAsFlow can be collected only once".toString());
                }
                try {
                    var3_6 = this.stream.iterator();
                }
                catch (Throwable var3_7) {
                    this.stream.close();
                    throw var3_7;
                }
lbl21:
                // 3 sources

                while (var3_6.hasNext()) {
                    value = var3_6.next();
                    $continuation.L$0 = this;
                    $continuation.L$1 = collector;
                    $continuation.L$2 = var3_6;
                    $continuation.label = 1;
                    v0 = collector.emit(value, (Continuation<Unit>)$continuation);
                    if (v0 != var7_5) continue;
                    return var7_5;
                }
                break;
            }
            case 1: {
                var3_6 = (Iterator<T>)$continuation.L$2;
                collector = (FlowCollector)$continuation.L$1;
                this = (StreamFlow)$continuation.L$0;
                {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
                    ** GOTO lbl21
                }
            }
        }
        this.stream.close();
        return Unit.INSTANCE;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}


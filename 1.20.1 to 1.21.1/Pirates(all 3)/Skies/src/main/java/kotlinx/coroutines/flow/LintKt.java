/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines.flow;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010#\n\u0002\b\n\u001a)\u0010\u0005\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\bH\u0007\u00a2\u0006\u0004\b\n\u0010\u000b\u001ao\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\b2D\b\b\u0010\u0013\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\f\u00a2\u0006\u0002\b\u0012H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a#\u0010\u001a\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\bH\u0087H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a%\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0007\u00a2\u0006\u0004\b\u001c\u0010\u0018\u001a-\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007\u00a2\u0006\u0004\b\u001f\u0010 \u001ah\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\b2\b\b\u0002\u0010\"\u001a\u00020!23\b\n\u0010%\u001a-\b\u0001\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110#H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010'\u001a\u0084\u0001\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\b2Y\b\b\u0010%\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b()\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110(\u00a2\u0006\u0002\b\u0012H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+\u001a)\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\bH\u0087H\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010\u001b\u001a1\u0010-\u001a\u000200\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000.H\u0087H\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u00101\u001a)\u00103\u001a\b\u0012\u0004\u0012\u00028\u000002\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\bH\u0087H\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u001b\u001a1\u00103\u001a\u000200\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0087H\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u00105\"\"\u0010:\u001a\u00020\u001d*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b8\u00109\u001a\u0004\b6\u00107\"\"\u0010;\u001a\u00020$*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b=\u00109\u001a\u0004\b;\u0010<\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006>"}, d2={"Lkotlinx/coroutines/flow/FlowCollector;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "cancel", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/util/concurrent/CancellationException;)V", "T", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/Flow;", "cancellable", "(Lkotlinx/coroutines/flow/SharedFlow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "action", "catch", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/StateFlow;", "conflate", "(Lkotlinx/coroutines/flow/StateFlow;)Lkotlinx/coroutines/flow/Flow;", "", "count", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "distinctUntilChanged", "Lkotlin/coroutines/CoroutineContext;", "context", "flowOn", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/flow/Flow;", "", "retries", "Lkotlin/Function2;", "", "predicate", "retry", "(Lkotlinx/coroutines/flow/SharedFlow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", "attempt", "retryWhen", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "", "toList", "", "destination", "", "(Lkotlinx/coroutines/flow/SharedFlow;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toSet", "", "(Lkotlinx/coroutines/flow/SharedFlow;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCoroutineContext", "(Lkotlinx/coroutines/flow/FlowCollector;)Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext$annotations", "(Lkotlinx/coroutines/flow/FlowCollector;)V", "coroutineContext", "isActive", "(Lkotlinx/coroutines/flow/FlowCollector;)Z", "isActive$annotations", "kotlinx-coroutines-core"})
public final class LintKt {
    @Deprecated(message="Applying 'cancellable' to a SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith=@ReplaceWith(expression="this", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> cancellable(@NotNull SharedFlow<? extends T> $this$cancellable) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Applying 'flowOn' to SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith=@ReplaceWith(expression="this", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> flowOn(@NotNull SharedFlow<? extends T> $this$flowOn, @NotNull CoroutineContext context) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Applying 'conflate' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith=@ReplaceWith(expression="this", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> conflate(@NotNull StateFlow<? extends T> $this$conflate) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Applying 'distinctUntilChanged' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith=@ReplaceWith(expression="this", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> distinctUntilChanged(@NotNull StateFlow<? extends T> $this$distinctUntilChanged) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final boolean isActive(@NotNull FlowCollector<?> $this$isActive) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="isActive is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().isActive or cancellable() operator instead or specify the receiver of isActive explicitly. Additionally, flow {} builder emissions are cancellable by default.", replaceWith=@ReplaceWith(expression="currentCoroutineContext().isActive", imports={}), level=DeprecationLevel.ERROR)
    public static /* synthetic */ void isActive$annotations(FlowCollector flowCollector) {
    }

    @Deprecated(message="cancel() is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().cancel() instead or specify the receiver of cancel() explicitly", replaceWith=@ReplaceWith(expression="currentCoroutineContext().cancel(cause)", imports={}), level=DeprecationLevel.ERROR)
    public static final void cancel(@NotNull FlowCollector<?> $this$cancel, @Nullable CancellationException cause) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void cancel$default(FlowCollector flowCollector, CancellationException cancellationException, int n2, Object object) {
        if ((n2 & 1) != 0) {
            cancellationException = null;
        }
        LintKt.cancel(flowCollector, cancellationException);
    }

    @NotNull
    public static final CoroutineContext getCoroutineContext(@NotNull FlowCollector<?> $this$coroutineContext) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="coroutineContext is resolved into the property of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext() instead or specify the receiver of coroutineContext explicitly", replaceWith=@ReplaceWith(expression="currentCoroutineContext()", imports={}), level=DeprecationLevel.ERROR)
    public static /* synthetic */ void getCoroutineContext$annotations(FlowCollector flowCollector) {
    }

    @Deprecated(message="SharedFlow never completes, so this operator typically has not effect, it can only catch exceptions from 'onSubscribe' operator", replaceWith=@ReplaceWith(expression="this", imports={}), level=DeprecationLevel.WARNING)
    @InlineOnly
    private static final <T> Flow<T> catch(SharedFlow<? extends T> $this$catch, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> action) {
        Intrinsics.checkNotNull($this$catch, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.catch>");
        return FlowKt.catch((Flow)$this$catch, action);
    }

    @Deprecated(message="SharedFlow never completes, so this operator has no effect.", replaceWith=@ReplaceWith(expression="this", imports={}), level=DeprecationLevel.WARNING)
    @InlineOnly
    private static final <T> Flow<T> retry(SharedFlow<? extends T> $this$retry, long retries, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        Intrinsics.checkNotNull($this$retry, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return FlowKt.retry((Flow)$this$retry, retries, predicate);
    }

    static /* synthetic */ Flow retry$default(SharedFlow $this$retry_u24default, long retries, Function2 predicate, int n2, Object object) {
        if ((n2 & 1) != 0) {
            retries = Long.MAX_VALUE;
        }
        if ((n2 & 2) != 0) {
            predicate = (Function2)new Function2<Throwable, Continuation<? super Boolean>, Object>(null){
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object object) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)object);
                            return Boxing.boxBoolean((boolean)true);
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                @NotNull
                public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                }

                @Nullable
                public final Object invoke(@NotNull Throwable p1, @Nullable Continuation<? super Boolean> p2) {
                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                }
            };
        }
        Intrinsics.checkNotNull((Object)$this$retry_u24default, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return FlowKt.retry($this$retry_u24default, retries, (Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object>)predicate);
    }

    @Deprecated(message="SharedFlow never completes, so this operator has no effect.", replaceWith=@ReplaceWith(expression="this", imports={}), level=DeprecationLevel.WARNING)
    @InlineOnly
    private static final <T> Flow<T> retryWhen(SharedFlow<? extends T> $this$retryWhen, Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        Intrinsics.checkNotNull($this$retryWhen, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retryWhen>");
        return FlowKt.retryWhen((Flow)$this$retryWhen, predicate);
    }

    @Deprecated(message="SharedFlow never completes, so this terminal operation never completes.", level=DeprecationLevel.WARNING)
    @InlineOnly
    private static final <T> Object toList(SharedFlow<? extends T> $this$toList, Continuation<? super List<? extends T>> $completion) {
        Intrinsics.checkNotNull($this$toList, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        Flow flow = $this$toList;
        InlineMarker.mark((int)0);
        Object object = FlowKt.toList$default(flow, null, $completion, 1, null);
        InlineMarker.mark((int)1);
        return object;
    }

    @InlineOnly
    private static final <T> Object toList(SharedFlow<? extends T> $this$toList, List<T> destination, Continuation<?> $completion) {
        Intrinsics.checkNotNull($this$toList, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        Flow flow = $this$toList;
        InlineMarker.mark((int)0);
        FlowKt.toList(flow, destination, $completion);
        InlineMarker.mark((int)1);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }

    @Deprecated(message="SharedFlow never completes, so this terminal operation never completes.", level=DeprecationLevel.WARNING)
    @InlineOnly
    private static final <T> Object toSet(SharedFlow<? extends T> $this$toSet, Continuation<? super Set<? extends T>> $completion) {
        Intrinsics.checkNotNull($this$toSet, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        Flow flow = $this$toSet;
        InlineMarker.mark((int)0);
        Object object = FlowKt.toSet$default(flow, null, $completion, 1, null);
        InlineMarker.mark((int)1);
        return object;
    }

    @InlineOnly
    private static final <T> Object toSet(SharedFlow<? extends T> $this$toSet, Set<T> destination, Continuation<?> $completion) {
        Intrinsics.checkNotNull($this$toSet, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        Flow flow = $this$toSet;
        InlineMarker.mark((int)0);
        FlowKt.toSet(flow, destination, $completion);
        InlineMarker.mark((int)1);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }

    @Deprecated(message="SharedFlow never completes, so this terminal operation never completes.", level=DeprecationLevel.WARNING)
    @InlineOnly
    private static final <T> Object count(SharedFlow<? extends T> $this$count, Continuation<? super Integer> $completion) {
        Intrinsics.checkNotNull($this$count, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.count>");
        Flow flow = $this$count;
        InlineMarker.mark((int)0);
        Object object = FlowKt.count(flow, $completion);
        InlineMarker.mark((int)1);
        return object;
    }
}


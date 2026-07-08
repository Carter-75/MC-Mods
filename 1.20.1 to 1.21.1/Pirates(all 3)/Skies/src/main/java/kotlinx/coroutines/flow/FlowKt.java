/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.BuilderInference
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.OverloadResolutionByLambdaReturnType
 *  kotlin.PublishedApi
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.collections.IndexedValue
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.functions.Function6
 *  kotlin.jvm.functions.Function7
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.LongRange
 *  kotlin.reflect.KClass
 *  kotlin.sequences.Sequence
 *  kotlin.time.Duration
 */
package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__BuildersKt;
import kotlinx.coroutines.flow.FlowKt__ChannelsKt;
import kotlinx.coroutines.flow.FlowKt__CollectKt;
import kotlinx.coroutines.flow.FlowKt__CollectionKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;
import kotlinx.coroutines.flow.FlowKt__CountKt;
import kotlinx.coroutines.flow.FlowKt__DelayKt;
import kotlinx.coroutines.flow.FlowKt__DistinctKt;
import kotlinx.coroutines.flow.FlowKt__EmittersKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt;
import kotlinx.coroutines.flow.FlowKt__LimitKt;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.FlowKt__MigrationKt;
import kotlinx.coroutines.flow.FlowKt__ReduceKt;
import kotlinx.coroutines.flow.FlowKt__ShareKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=4, xi=48, d1={"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"})
public final class FlowKt {
    @NotNull
    public static final String DEFAULT_CONCURRENCY_PROPERTY_NAME = "kotlinx.coroutines.flow.defaultConcurrency";

    @NotNull
    public static final <T> Flow<T> flow(@BuilderInference @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        return FlowKt__BuildersKt.flow(block);
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Function0<? extends T> $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Function1<? super Continuation<? super T>, ? extends Object> $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Iterable<? extends T> $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Iterator<? extends T> $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull Sequence<? extends T> $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    @NotNull
    public static final <T> Flow<T> flowOf(T ... elements) {
        return FlowKt__BuildersKt.flowOf(elements);
    }

    @NotNull
    public static final <T> Flow<T> flowOf(T value) {
        return FlowKt__BuildersKt.flowOf(value);
    }

    @NotNull
    public static final <T> Flow<T> emptyFlow() {
        return FlowKt__BuildersKt.emptyFlow();
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull T[] $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    @NotNull
    public static final Flow<Integer> asFlow(@NotNull int[] $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    @NotNull
    public static final Flow<Long> asFlow(@NotNull long[] $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    @NotNull
    public static final Flow<Integer> asFlow(@NotNull IntRange $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    @NotNull
    public static final Flow<Long> asFlow(@NotNull LongRange $this$asFlow) {
        return FlowKt__BuildersKt.asFlow($this$asFlow);
    }

    @NotNull
    public static final <T> Flow<T> channelFlow(@BuilderInference @NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        return FlowKt__BuildersKt.channelFlow(block);
    }

    @NotNull
    public static final <T> Flow<T> callbackFlow(@BuilderInference @NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        return FlowKt__BuildersKt.callbackFlow(block);
    }

    @Nullable
    public static final <T> Object emitAll(@NotNull FlowCollector<? super T> $this$emitAll, @NotNull ReceiveChannel<? extends T> channel, @NotNull Continuation<? super Unit> $completion) {
        return FlowKt__ChannelsKt.emitAll($this$emitAll, channel, $completion);
    }

    @NotNull
    public static final <T> Flow<T> receiveAsFlow(@NotNull ReceiveChannel<? extends T> $this$receiveAsFlow) {
        return FlowKt__ChannelsKt.receiveAsFlow($this$receiveAsFlow);
    }

    @NotNull
    public static final <T> Flow<T> consumeAsFlow(@NotNull ReceiveChannel<? extends T> $this$consumeAsFlow) {
        return FlowKt__ChannelsKt.consumeAsFlow($this$consumeAsFlow);
    }

    @Deprecated(message="'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow", level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull BroadcastChannel<T> $this$asFlow) {
        return FlowKt__ChannelsKt.asFlow($this$asFlow);
    }

    @NotNull
    public static final <T> ReceiveChannel<T> produceIn(@NotNull Flow<? extends T> $this$produceIn, @NotNull CoroutineScope scope) {
        return FlowKt__ChannelsKt.produceIn($this$produceIn, scope);
    }

    @Nullable
    public static final Object collect(@NotNull Flow<?> $this$collect, @NotNull Continuation<? super Unit> $completion) {
        return FlowKt__CollectKt.collect($this$collect, $completion);
    }

    @NotNull
    public static final <T> Job launchIn(@NotNull Flow<? extends T> $this$launchIn, @NotNull CoroutineScope scope) {
        return FlowKt__CollectKt.launchIn($this$launchIn, scope);
    }

    @Nullable
    public static final <T> Object collectIndexed(@NotNull Flow<? extends T> $this$collectIndexed, @NotNull Function3<? super Integer, ? super T, ? super Continuation<? super Unit>, ? extends Object> action, @NotNull Continuation<? super Unit> $completion) {
        return FlowKt__CollectKt.collectIndexed($this$collectIndexed, action, $completion);
    }

    @Nullable
    public static final <T> Object collectLatest(@NotNull Flow<? extends T> $this$collectLatest, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action, @NotNull Continuation<? super Unit> $completion) {
        return FlowKt__CollectKt.collectLatest($this$collectLatest, action, $completion);
    }

    @Nullable
    public static final <T> Object emitAll(@NotNull FlowCollector<? super T> $this$emitAll, @NotNull Flow<? extends T> flow, @NotNull Continuation<? super Unit> $completion) {
        return FlowKt__CollectKt.emitAll($this$emitAll, flow, $completion);
    }

    @Deprecated(message="Backwards compatibility with JS and K/N", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ <T> Object collect(Flow<? extends T> $this$collect, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action, Continuation<? super Unit> $completion) {
        return FlowKt__CollectKt.collect($this$collect, action, $completion);
    }

    @Nullable
    public static final <T> Object toList(@NotNull Flow<? extends T> $this$toList, @NotNull List<T> destination, @NotNull Continuation<? super List<? extends T>> $completion) {
        return FlowKt__CollectionKt.toList($this$toList, destination, $completion);
    }

    public static /* synthetic */ Object toList$default(Flow flow, List list, Continuation continuation, int n2, Object object) {
        return FlowKt__CollectionKt.toList$default(flow, list, continuation, n2, object);
    }

    @Nullable
    public static final <T> Object toSet(@NotNull Flow<? extends T> $this$toSet, @NotNull Set<T> destination, @NotNull Continuation<? super Set<? extends T>> $completion) {
        return FlowKt__CollectionKt.toSet($this$toSet, destination, $completion);
    }

    public static /* synthetic */ Object toSet$default(Flow flow, Set set, Continuation continuation, int n2, Object object) {
        return FlowKt__CollectionKt.toSet$default(flow, set, continuation, n2, object);
    }

    @Nullable
    public static final <T, C extends Collection<? super T>> Object toCollection(@NotNull Flow<? extends T> $this$toCollection, @NotNull C destination, @NotNull Continuation<? super C> $completion) {
        return FlowKt__CollectionKt.toCollection($this$toCollection, destination, $completion);
    }

    @NotNull
    public static final <T> Flow<T> buffer(@NotNull Flow<? extends T> $this$buffer, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        return FlowKt__ContextKt.buffer($this$buffer, capacity, onBufferOverflow);
    }

    public static /* synthetic */ Flow buffer$default(Flow flow, int n2, BufferOverflow bufferOverflow, int n3, Object object) {
        return FlowKt__ContextKt.buffer$default(flow, n2, bufferOverflow, n3, object);
    }

    @Deprecated(message="Since 1.4.0, binary compatibility with earlier versions", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Flow buffer(Flow $this$buffer, int capacity) {
        return FlowKt__ContextKt.buffer($this$buffer, capacity);
    }

    public static /* synthetic */ Flow buffer$default(Flow flow, int n2, int n3, Object object) {
        return FlowKt__ContextKt.buffer$default(flow, n2, n3, object);
    }

    @NotNull
    public static final <T> Flow<T> conflate(@NotNull Flow<? extends T> $this$conflate) {
        return FlowKt__ContextKt.conflate($this$conflate);
    }

    @NotNull
    public static final <T> Flow<T> flowOn(@NotNull Flow<? extends T> $this$flowOn, @NotNull CoroutineContext context) {
        return FlowKt__ContextKt.flowOn($this$flowOn, context);
    }

    @NotNull
    public static final <T> Flow<T> cancellable(@NotNull Flow<? extends T> $this$cancellable) {
        return FlowKt__ContextKt.cancellable($this$cancellable);
    }

    @Nullable
    public static final <T> Object count(@NotNull Flow<? extends T> $this$count, @NotNull Continuation<? super Integer> $completion) {
        return FlowKt__CountKt.count($this$count, $completion);
    }

    @Nullable
    public static final <T> Object count(@NotNull Flow<? extends T> $this$count, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate, @NotNull Continuation<? super Integer> $completion) {
        return FlowKt__CountKt.count($this$count, predicate, $completion);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> $this$debounce, long timeoutMillis) {
        return FlowKt__DelayKt.debounce($this$debounce, timeoutMillis);
    }

    @FlowPreview
    @OverloadResolutionByLambdaReturnType
    @NotNull
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> $this$debounce, @NotNull Function1<? super T, Long> timeoutMillis) {
        return FlowKt__DelayKt.debounce($this$debounce, timeoutMillis);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> debounce-HG0u8IE(@NotNull Flow<? extends T> $this$debounce_u2dHG0u8IE, long timeout) {
        return FlowKt__DelayKt.debounce-HG0u8IE($this$debounce_u2dHG0u8IE, timeout);
    }

    @FlowPreview
    @JvmName(name="debounceDuration")
    @OverloadResolutionByLambdaReturnType
    @NotNull
    public static final <T> Flow<T> debounceDuration(@NotNull Flow<? extends T> $this$debounce, @NotNull Function1<? super T, Duration> timeout) {
        return FlowKt__DelayKt.debounceDuration($this$debounce, timeout);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> sample(@NotNull Flow<? extends T> $this$sample, long periodMillis) {
        return FlowKt__DelayKt.sample($this$sample, periodMillis);
    }

    @NotNull
    public static final ReceiveChannel<Unit> fixedPeriodTicker(@NotNull CoroutineScope $this$fixedPeriodTicker, long delayMillis, long initialDelayMillis) {
        return FlowKt__DelayKt.fixedPeriodTicker($this$fixedPeriodTicker, delayMillis, initialDelayMillis);
    }

    public static /* synthetic */ ReceiveChannel fixedPeriodTicker$default(CoroutineScope coroutineScope, long l2, long l3, int n2, Object object) {
        return FlowKt__DelayKt.fixedPeriodTicker$default(coroutineScope, l2, l3, n2, object);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> sample-HG0u8IE(@NotNull Flow<? extends T> $this$sample_u2dHG0u8IE, long period) {
        return FlowKt__DelayKt.sample-HG0u8IE($this$sample_u2dHG0u8IE, period);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> timeout-HG0u8IE(@NotNull Flow<? extends T> $this$timeout_u2dHG0u8IE, long timeout) {
        return FlowKt__DelayKt.timeout-HG0u8IE($this$timeout_u2dHG0u8IE, timeout);
    }

    @NotNull
    public static final <T> Flow<T> distinctUntilChanged(@NotNull Flow<? extends T> $this$distinctUntilChanged) {
        return FlowKt__DistinctKt.distinctUntilChanged($this$distinctUntilChanged);
    }

    @NotNull
    public static final <T> Flow<T> distinctUntilChanged(@NotNull Flow<? extends T> $this$distinctUntilChanged, @NotNull Function2<? super T, ? super T, Boolean> areEquivalent) {
        return FlowKt__DistinctKt.distinctUntilChanged($this$distinctUntilChanged, areEquivalent);
    }

    @NotNull
    public static final <T, K> Flow<T> distinctUntilChangedBy(@NotNull Flow<? extends T> $this$distinctUntilChangedBy, @NotNull Function1<? super T, ? extends K> keySelector) {
        return FlowKt__DistinctKt.distinctUntilChangedBy($this$distinctUntilChangedBy, keySelector);
    }

    @NotNull
    public static final <T, R> Flow<R> transform(@NotNull Flow<? extends T> $this$transform, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        return FlowKt__EmittersKt.transform($this$transform, transform2);
    }

    @PublishedApi
    @NotNull
    public static final <T, R> Flow<R> unsafeTransform(@NotNull Flow<? extends T> $this$unsafeTransform, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        return FlowKt__EmittersKt.unsafeTransform($this$unsafeTransform, transform2);
    }

    @NotNull
    public static final <T> Flow<T> onStart(@NotNull Flow<? extends T> $this$onStart, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> action) {
        return FlowKt__EmittersKt.onStart($this$onStart, action);
    }

    @NotNull
    public static final <T> Flow<T> onCompletion(@NotNull Flow<? extends T> $this$onCompletion, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> action) {
        return FlowKt__EmittersKt.onCompletion($this$onCompletion, action);
    }

    @NotNull
    public static final <T> Flow<T> onEmpty(@NotNull Flow<? extends T> $this$onEmpty, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> action) {
        return FlowKt__EmittersKt.onEmpty($this$onEmpty, action);
    }

    public static final void ensureActive(@NotNull FlowCollector<?> $this$ensureActive) {
        FlowKt__EmittersKt.ensureActive($this$ensureActive);
    }

    @NotNull
    public static final <T> Flow<T> catch(@NotNull Flow<? extends T> $this$catch, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> action) {
        return FlowKt__ErrorsKt.catch($this$catch, action);
    }

    @NotNull
    public static final <T> Flow<T> retry(@NotNull Flow<? extends T> $this$retry, long retries, @NotNull Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return FlowKt__ErrorsKt.retry($this$retry, retries, predicate);
    }

    public static /* synthetic */ Flow retry$default(Flow flow, long l2, Function2 function2, int n2, Object object) {
        return FlowKt__ErrorsKt.retry$default(flow, l2, function2, n2, object);
    }

    @NotNull
    public static final <T> Flow<T> retryWhen(@NotNull Flow<? extends T> $this$retryWhen, @NotNull Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return FlowKt__ErrorsKt.retryWhen($this$retryWhen, predicate);
    }

    @Nullable
    public static final <T> Object catchImpl(@NotNull Flow<? extends T> $this$catchImpl, @NotNull FlowCollector<? super T> collector2, @NotNull Continuation<? super Throwable> $completion) {
        return FlowKt__ErrorsKt.catchImpl($this$catchImpl, collector2, $completion);
    }

    @NotNull
    public static final <T> Flow<T> drop(@NotNull Flow<? extends T> $this$drop, int count2) {
        return FlowKt__LimitKt.drop($this$drop, count2);
    }

    @NotNull
    public static final <T> Flow<T> dropWhile(@NotNull Flow<? extends T> $this$dropWhile, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return FlowKt__LimitKt.dropWhile($this$dropWhile, predicate);
    }

    @NotNull
    public static final <T> Flow<T> take(@NotNull Flow<? extends T> $this$take, int count2) {
        return FlowKt__LimitKt.take($this$take, count2);
    }

    @NotNull
    public static final <T> Flow<T> takeWhile(@NotNull Flow<? extends T> $this$takeWhile, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return FlowKt__LimitKt.takeWhile($this$takeWhile, predicate);
    }

    @NotNull
    public static final <T, R> Flow<R> transformWhile(@NotNull Flow<? extends T> $this$transformWhile, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> transform2) {
        return FlowKt__LimitKt.transformWhile($this$transformWhile, transform2);
    }

    @Nullable
    public static final <T> Object collectWhile(@NotNull Flow<? extends T> $this$collectWhile, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate, @NotNull Continuation<? super Unit> $completion) {
        return FlowKt__LimitKt.collectWhile($this$collectWhile, predicate, $completion);
    }

    @FlowPreview
    public static /* synthetic */ void getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations() {
        FlowKt__MergeKt.getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations();
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return FlowKt__MergeKt.getDEFAULT_CONCURRENCY();
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> flatMapConcat(@NotNull Flow<? extends T> $this$flatMapConcat, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> transform2) {
        return FlowKt__MergeKt.flatMapConcat($this$flatMapConcat, transform2);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> flatMapMerge(@NotNull Flow<? extends T> $this$flatMapMerge, int concurrency, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> transform2) {
        return FlowKt__MergeKt.flatMapMerge($this$flatMapMerge, concurrency, transform2);
    }

    public static /* synthetic */ Flow flatMapMerge$default(Flow flow, int n2, Function2 function2, int n3, Object object) {
        return FlowKt__MergeKt.flatMapMerge$default(flow, n2, function2, n3, object);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> Flow<T> flattenConcat(@NotNull Flow<? extends Flow<? extends T>> $this$flattenConcat) {
        return FlowKt__MergeKt.flattenConcat($this$flattenConcat);
    }

    @NotNull
    public static final <T> Flow<T> merge(@NotNull Iterable<? extends Flow<? extends T>> $this$merge) {
        return FlowKt__MergeKt.merge($this$merge);
    }

    @NotNull
    public static final <T> Flow<T> merge(Flow<? extends T> ... flows) {
        return FlowKt__MergeKt.merge(flows);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> Flow<T> flattenMerge(@NotNull Flow<? extends Flow<? extends T>> $this$flattenMerge, int concurrency) {
        return FlowKt__MergeKt.flattenMerge($this$flattenMerge, concurrency);
    }

    public static /* synthetic */ Flow flattenMerge$default(Flow flow, int n2, int n3, Object object) {
        return FlowKt__MergeKt.flattenMerge$default(flow, n2, n3, object);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> transformLatest(@NotNull Flow<? extends T> $this$transformLatest, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        return FlowKt__MergeKt.transformLatest($this$transformLatest, transform2);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> flatMapLatest(@NotNull Flow<? extends T> $this$flatMapLatest, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> transform2) {
        return FlowKt__MergeKt.flatMapLatest($this$flatMapLatest, transform2);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> mapLatest(@NotNull Flow<? extends T> $this$mapLatest, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt__MergeKt.mapLatest($this$mapLatest, transform2);
    }

    @NotNull
    public static final Void noImpl() {
        return FlowKt__MigrationKt.noImpl();
    }

    @Deprecated(message="Collect flow in the desired context instead", level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> observeOn(@NotNull Flow<? extends T> $this$observeOn, @NotNull CoroutineContext context) {
        return FlowKt__MigrationKt.observeOn($this$observeOn, context);
    }

    @Deprecated(message="Collect flow in the desired context instead", level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> publishOn(@NotNull Flow<? extends T> $this$publishOn, @NotNull CoroutineContext context) {
        return FlowKt__MigrationKt.publishOn($this$publishOn, context);
    }

    @Deprecated(message="Use 'flowOn' instead", level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> subscribeOn(@NotNull Flow<? extends T> $this$subscribeOn, @NotNull CoroutineContext context) {
        return FlowKt__MigrationKt.subscribeOn($this$subscribeOn, context);
    }

    @Deprecated(message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith=@ReplaceWith(expression="catch { emitAll(fallback) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> onErrorResume(@NotNull Flow<? extends T> $this$onErrorResume, @NotNull Flow<? extends T> fallback) {
        return FlowKt__MigrationKt.onErrorResume($this$onErrorResume, fallback);
    }

    @Deprecated(message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith=@ReplaceWith(expression="catch { emitAll(fallback) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> onErrorResumeNext(@NotNull Flow<? extends T> $this$onErrorResumeNext, @NotNull Flow<? extends T> fallback) {
        return FlowKt__MigrationKt.onErrorResumeNext($this$onErrorResumeNext, fallback);
    }

    @Deprecated(message="Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead", level=DeprecationLevel.ERROR)
    public static final <T> void subscribe(@NotNull Flow<? extends T> $this$subscribe) {
        FlowKt__MigrationKt.subscribe($this$subscribe);
    }

    @Deprecated(message="Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead", level=DeprecationLevel.ERROR)
    public static final <T> void subscribe(@NotNull Flow<? extends T> $this$subscribe, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> onEach) {
        FlowKt__MigrationKt.subscribe($this$subscribe, onEach);
    }

    @Deprecated(message="Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead", level=DeprecationLevel.ERROR)
    public static final <T> void subscribe(@NotNull Flow<? extends T> $this$subscribe, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> onEach, @NotNull Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> onError) {
        FlowKt__MigrationKt.subscribe($this$subscribe, onEach, onError);
    }

    @Deprecated(message="Flow analogue is 'flatMapConcat'", replaceWith=@ReplaceWith(expression="flatMapConcat(mapper)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T, R> Flow<R> flatMap(@NotNull Flow<? extends T> $this$flatMap, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> mapper) {
        return FlowKt__MigrationKt.flatMap($this$flatMap, mapper);
    }

    @Deprecated(message="Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith=@ReplaceWith(expression="flatMapConcat(mapper)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T, R> Flow<R> concatMap(@NotNull Flow<? extends T> $this$concatMap, @NotNull Function1<? super T, ? extends Flow<? extends R>> mapper) {
        return FlowKt__MigrationKt.concatMap($this$concatMap, mapper);
    }

    @Deprecated(message="Flow analogue of 'merge' is 'flattenConcat'", replaceWith=@ReplaceWith(expression="flattenConcat()", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> merge(@NotNull Flow<? extends Flow<? extends T>> $this$merge) {
        return FlowKt__MigrationKt.merge($this$merge);
    }

    @Deprecated(message="Flow analogue of 'flatten' is 'flattenConcat'", replaceWith=@ReplaceWith(expression="flattenConcat()", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> flatten(@NotNull Flow<? extends Flow<? extends T>> $this$flatten) {
        return FlowKt__MigrationKt.flatten($this$flatten);
    }

    @Deprecated(message="Flow analogue of 'compose' is 'let'", replaceWith=@ReplaceWith(expression="let(transformer)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T, R> Flow<R> compose(@NotNull Flow<? extends T> $this$compose, @NotNull Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> transformer) {
        return FlowKt__MigrationKt.compose($this$compose, transformer);
    }

    @Deprecated(message="Flow analogue of 'skip' is 'drop'", replaceWith=@ReplaceWith(expression="drop(count)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> skip(@NotNull Flow<? extends T> $this$skip, int count2) {
        return FlowKt__MigrationKt.skip($this$skip, count2);
    }

    @Deprecated(message="Flow analogue of 'forEach' is 'collect'", replaceWith=@ReplaceWith(expression="collect(action)", imports={}), level=DeprecationLevel.ERROR)
    public static final <T> void forEach(@NotNull Flow<? extends T> $this$forEach, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action) {
        FlowKt__MigrationKt.forEach($this$forEach, action);
    }

    @Deprecated(message="Flow has less verbose 'scan' shortcut", replaceWith=@ReplaceWith(expression="scan(initial, operation)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T, R> Flow<R> scanFold(@NotNull Flow<? extends T> $this$scanFold, R initial, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation) {
        return FlowKt__MigrationKt.scanFold($this$scanFold, initial, operation);
    }

    @Deprecated(message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith=@ReplaceWith(expression="catch { emit(fallback) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> onErrorReturn(@NotNull Flow<? extends T> $this$onErrorReturn, T fallback) {
        return FlowKt__MigrationKt.onErrorReturn($this$onErrorReturn, fallback);
    }

    @Deprecated(message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith=@ReplaceWith(expression="catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> onErrorReturn(@NotNull Flow<? extends T> $this$onErrorReturn, T fallback, @NotNull Function1<? super Throwable, Boolean> predicate) {
        return FlowKt__MigrationKt.onErrorReturn($this$onErrorReturn, fallback, predicate);
    }

    public static /* synthetic */ Flow onErrorReturn$default(Flow flow, Object object, Function1 function1, int n2, Object object2) {
        return FlowKt__MigrationKt.onErrorReturn$default(flow, object, function1, n2, object2);
    }

    @Deprecated(message="Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith=@ReplaceWith(expression="onStart { emit(value) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> startWith(@NotNull Flow<? extends T> $this$startWith, T value) {
        return FlowKt__MigrationKt.startWith($this$startWith, value);
    }

    @Deprecated(message="Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith=@ReplaceWith(expression="onStart { emitAll(other) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> startWith(@NotNull Flow<? extends T> $this$startWith, @NotNull Flow<? extends T> other) {
        return FlowKt__MigrationKt.startWith($this$startWith, other);
    }

    @Deprecated(message="Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith=@ReplaceWith(expression="onCompletion { emit(value) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> concatWith(@NotNull Flow<? extends T> $this$concatWith, T value) {
        return FlowKt__MigrationKt.concatWith($this$concatWith, value);
    }

    @Deprecated(message="Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith=@ReplaceWith(expression="onCompletion { if (it == null) emitAll(other) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> concatWith(@NotNull Flow<? extends T> $this$concatWith, @NotNull Flow<? extends T> other) {
        return FlowKt__MigrationKt.concatWith($this$concatWith, other);
    }

    @Deprecated(message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="this.combine(other, transform)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T1, T2, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> $this$combineLatest, @NotNull Flow<? extends T2> other, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt__MigrationKt.combineLatest($this$combineLatest, other, transform2);
    }

    @Deprecated(message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="combine(this, other, other2, transform)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T1, T2, T3, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> $this$combineLatest, @NotNull Flow<? extends T2> other, @NotNull Flow<? extends T3> other2, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt__MigrationKt.combineLatest($this$combineLatest, other, other2, transform2);
    }

    @Deprecated(message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="combine(this, other, other2, other3, transform)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T1, T2, T3, T4, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> $this$combineLatest, @NotNull Flow<? extends T2> other, @NotNull Flow<? extends T3> other2, @NotNull Flow<? extends T4> other3, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt__MigrationKt.combineLatest($this$combineLatest, other, other2, other3, transform2);
    }

    @Deprecated(message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="combine(this, other, other2, other3, transform)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> $this$combineLatest, @NotNull Flow<? extends T2> other, @NotNull Flow<? extends T3> other2, @NotNull Flow<? extends T4> other3, @NotNull Flow<? extends T5> other4, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt__MigrationKt.combineLatest($this$combineLatest, other, other2, other3, other4, transform2);
    }

    @Deprecated(message="Use 'onStart { delay(timeMillis) }'", replaceWith=@ReplaceWith(expression="onStart { delay(timeMillis) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> delayFlow(@NotNull Flow<? extends T> $this$delayFlow, long timeMillis) {
        return FlowKt__MigrationKt.delayFlow($this$delayFlow, timeMillis);
    }

    @Deprecated(message="Use 'onEach { delay(timeMillis) }'", replaceWith=@ReplaceWith(expression="onEach { delay(timeMillis) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> delayEach(@NotNull Flow<? extends T> $this$delayEach, long timeMillis) {
        return FlowKt__MigrationKt.delayEach($this$delayEach, timeMillis);
    }

    @Deprecated(message="Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith=@ReplaceWith(expression="this.flatMapLatest(transform)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T, R> Flow<R> switchMap(@NotNull Flow<? extends T> $this$switchMap, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> transform2) {
        return FlowKt__MigrationKt.switchMap($this$switchMap, transform2);
    }

    @Deprecated(message="'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith=@ReplaceWith(expression="runningReduce(operation)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> scanReduce(@NotNull Flow<? extends T> $this$scanReduce, @NotNull Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> operation) {
        return FlowKt__MigrationKt.scanReduce($this$scanReduce, operation);
    }

    @Deprecated(message="Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith=@ReplaceWith(expression="this.shareIn(scope, 0)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> publish(@NotNull Flow<? extends T> $this$publish) {
        return FlowKt__MigrationKt.publish($this$publish);
    }

    @Deprecated(message="Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith=@ReplaceWith(expression="this.buffer(bufferSize).shareIn(scope, 0)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> publish(@NotNull Flow<? extends T> $this$publish, int bufferSize) {
        return FlowKt__MigrationKt.publish($this$publish, bufferSize);
    }

    @Deprecated(message="Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith=@ReplaceWith(expression="this.shareIn(scope, Int.MAX_VALUE)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> replay(@NotNull Flow<? extends T> $this$replay) {
        return FlowKt__MigrationKt.replay($this$replay);
    }

    @Deprecated(message="Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith=@ReplaceWith(expression="this.shareIn(scope, bufferSize)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> replay(@NotNull Flow<? extends T> $this$replay, int bufferSize) {
        return FlowKt__MigrationKt.replay($this$replay, bufferSize);
    }

    @Deprecated(message="Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith=@ReplaceWith(expression="this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> cache(@NotNull Flow<? extends T> $this$cache) {
        return FlowKt__MigrationKt.cache($this$cache);
    }

    @Nullable
    public static final <S, T extends S> Object reduce(@NotNull Flow<? extends T> $this$reduce, @NotNull Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> operation, @NotNull Continuation<? super S> $completion) {
        return FlowKt__ReduceKt.reduce($this$reduce, operation, $completion);
    }

    @Nullable
    public static final <T, R> Object fold(@NotNull Flow<? extends T> $this$fold, R initial, @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation, @NotNull Continuation<? super R> $completion) {
        return FlowKt__ReduceKt.fold($this$fold, initial, operation, $completion);
    }

    @Nullable
    public static final <T> Object single(@NotNull Flow<? extends T> $this$single, @NotNull Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.single($this$single, $completion);
    }

    @Nullable
    public static final <T> Object singleOrNull(@NotNull Flow<? extends T> $this$singleOrNull, @NotNull Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.singleOrNull($this$singleOrNull, $completion);
    }

    @Nullable
    public static final <T> Object first(@NotNull Flow<? extends T> $this$first, @NotNull Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.first($this$first, $completion);
    }

    @Nullable
    public static final <T> Object first(@NotNull Flow<? extends T> $this$first, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate, @NotNull Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.first($this$first, predicate, $completion);
    }

    @Nullable
    public static final <T> Object firstOrNull(@NotNull Flow<? extends T> $this$firstOrNull, @NotNull Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.firstOrNull($this$firstOrNull, $completion);
    }

    @Nullable
    public static final <T> Object firstOrNull(@NotNull Flow<? extends T> $this$firstOrNull, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate, @NotNull Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.firstOrNull($this$firstOrNull, predicate, $completion);
    }

    @Nullable
    public static final <T> Object last(@NotNull Flow<? extends T> $this$last, @NotNull Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.last($this$last, $completion);
    }

    @Nullable
    public static final <T> Object lastOrNull(@NotNull Flow<? extends T> $this$lastOrNull, @NotNull Continuation<? super T> $completion) {
        return FlowKt__ReduceKt.lastOrNull($this$lastOrNull, $completion);
    }

    @NotNull
    public static final <T> SharedFlow<T> shareIn(@NotNull Flow<? extends T> $this$shareIn, @NotNull CoroutineScope scope, @NotNull SharingStarted started, int replay) {
        return FlowKt__ShareKt.shareIn($this$shareIn, scope, started, replay);
    }

    public static /* synthetic */ SharedFlow shareIn$default(Flow flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, int n2, int n3, Object object) {
        return FlowKt__ShareKt.shareIn$default(flow, coroutineScope, sharingStarted, n2, n3, object);
    }

    @NotNull
    public static final <T> StateFlow<T> stateIn(@NotNull Flow<? extends T> $this$stateIn, @NotNull CoroutineScope scope, @NotNull SharingStarted started, T initialValue) {
        return FlowKt__ShareKt.stateIn($this$stateIn, scope, started, initialValue);
    }

    @Nullable
    public static final <T> Object stateIn(@NotNull Flow<? extends T> $this$stateIn, @NotNull CoroutineScope scope, @NotNull Continuation<? super StateFlow<? extends T>> $completion) {
        return FlowKt__ShareKt.stateIn($this$stateIn, scope, $completion);
    }

    @NotNull
    public static final <T> SharedFlow<T> asSharedFlow(@NotNull MutableSharedFlow<T> $this$asSharedFlow) {
        return FlowKt__ShareKt.asSharedFlow($this$asSharedFlow);
    }

    @NotNull
    public static final <T> StateFlow<T> asStateFlow(@NotNull MutableStateFlow<T> $this$asStateFlow) {
        return FlowKt__ShareKt.asStateFlow($this$asStateFlow);
    }

    @NotNull
    public static final <T> SharedFlow<T> onSubscription(@NotNull SharedFlow<? extends T> $this$onSubscription, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> action) {
        return FlowKt__ShareKt.onSubscription($this$onSubscription, action);
    }

    @NotNull
    public static final <T> Flow<T> filter(@NotNull Flow<? extends T> $this$filter, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return FlowKt__TransformKt.filter($this$filter, predicate);
    }

    @NotNull
    public static final <T> Flow<T> filterNot(@NotNull Flow<? extends T> $this$filterNot, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return FlowKt__TransformKt.filterNot($this$filterNot, predicate);
    }

    public static final /* synthetic */ <R> Flow<R> filterIsInstance(Flow<?> $this$filterIsInstance) {
        return FlowKt__TransformKt.filterIsInstance($this$filterIsInstance);
    }

    @NotNull
    public static final <R> Flow<R> filterIsInstance(@NotNull Flow<?> $this$filterIsInstance, @NotNull KClass<R> klass) {
        return FlowKt__TransformKt.filterIsInstance($this$filterIsInstance, klass);
    }

    @NotNull
    public static final <T> Flow<T> filterNotNull(@NotNull Flow<? extends T> $this$filterNotNull) {
        return FlowKt__TransformKt.filterNotNull($this$filterNotNull);
    }

    @NotNull
    public static final <T, R> Flow<R> map(@NotNull Flow<? extends T> $this$map, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt__TransformKt.map($this$map, transform2);
    }

    @NotNull
    public static final <T, R> Flow<R> mapNotNull(@NotNull Flow<? extends T> $this$mapNotNull, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt__TransformKt.mapNotNull($this$mapNotNull, transform2);
    }

    @NotNull
    public static final <T> Flow<IndexedValue<T>> withIndex(@NotNull Flow<? extends T> $this$withIndex) {
        return FlowKt__TransformKt.withIndex($this$withIndex);
    }

    @NotNull
    public static final <T> Flow<T> onEach(@NotNull Flow<? extends T> $this$onEach, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action) {
        return FlowKt__TransformKt.onEach($this$onEach, action);
    }

    @NotNull
    public static final <T, R> Flow<R> scan(@NotNull Flow<? extends T> $this$scan, R initial, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation) {
        return FlowKt__TransformKt.scan($this$scan, initial, operation);
    }

    @NotNull
    public static final <T, R> Flow<R> runningFold(@NotNull Flow<? extends T> $this$runningFold, R initial, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation) {
        return FlowKt__TransformKt.runningFold($this$runningFold, initial, operation);
    }

    @NotNull
    public static final <T> Flow<T> runningReduce(@NotNull Flow<? extends T> $this$runningReduce, @NotNull Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> operation) {
        return FlowKt__TransformKt.runningReduce($this$runningReduce, operation);
    }

    @JvmName(name="flowCombine")
    @NotNull
    public static final <T1, T2, R> Flow<R> flowCombine(@NotNull Flow<? extends T1> $this$combine, @NotNull Flow<? extends T2> flow, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt__ZipKt.flowCombine($this$combine, flow, transform2);
    }

    @NotNull
    public static final <T1, T2, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt__ZipKt.combine(flow, flow2, transform2);
    }

    @JvmName(name="flowCombineTransform")
    @NotNull
    public static final <T1, T2, R> Flow<R> flowCombineTransform(@NotNull Flow<? extends T1> $this$combineTransform, @NotNull Flow<? extends T2> flow, @BuilderInference @NotNull Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        return FlowKt__ZipKt.flowCombineTransform($this$combineTransform, flow, transform2);
    }

    @NotNull
    public static final <T1, T2, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @BuilderInference @NotNull Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, transform2);
    }

    @NotNull
    public static final <T1, T2, T3, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @BuilderInference @NotNull Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, transform2);
    }

    @NotNull
    public static final <T1, T2, T3, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @BuilderInference @NotNull Function5<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, transform2);
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, flow4, transform2);
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @BuilderInference @NotNull Function6<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, flow4, transform2);
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt__ZipKt.combine(flow, flow2, flow3, flow4, flow5, transform2);
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @BuilderInference @NotNull Function7<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        return FlowKt__ZipKt.combineTransform(flow, flow2, flow3, flow4, flow5, transform2);
    }

    public static final /* synthetic */ <T, R> Flow<R> combine(Flow<? extends T>[] flows, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt__ZipKt.combine(flows, transform2);
    }

    public static final /* synthetic */ <T, R> Flow<R> combineTransform(Flow<? extends T>[] flows, @BuilderInference Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> transform2) {
        return FlowKt__ZipKt.combineTransform(flows, transform2);
    }

    public static final /* synthetic */ <T, R> Flow<R> combine(Iterable<? extends Flow<? extends T>> flows, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt__ZipKt.combine(flows, transform2);
    }

    public static final /* synthetic */ <T, R> Flow<R> combineTransform(Iterable<? extends Flow<? extends T>> flows, @BuilderInference Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> transform2) {
        return FlowKt__ZipKt.combineTransform(flows, transform2);
    }

    @NotNull
    public static final <T1, T2, R> Flow<R> zip(@NotNull Flow<? extends T1> $this$zip, @NotNull Flow<? extends T2> other, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt__ZipKt.zip($this$zip, other, transform2);
    }
}


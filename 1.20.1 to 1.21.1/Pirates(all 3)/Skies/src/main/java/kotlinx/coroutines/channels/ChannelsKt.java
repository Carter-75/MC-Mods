/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.PublishedApi
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 */
package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ChannelsKt__ChannelsKt;
import kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt;
import kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=4, xi=48, d1={"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt", "kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt"})
public final class ChannelsKt {
    @NotNull
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    @NotNull
    public static final <E> Object trySendBlocking(@NotNull SendChannel<? super E> $this$trySendBlocking, E element) {
        return ChannelsKt__ChannelsKt.trySendBlocking($this$trySendBlocking, element);
    }

    @Deprecated(message="Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith=@ReplaceWith(expression="trySendBlocking(element)", imports={}), level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ void sendBlocking(SendChannel $this$sendBlocking, Object element) {
        ChannelsKt__ChannelsKt.sendBlocking($this$sendBlocking, element);
    }

    @Deprecated(message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported", level=DeprecationLevel.WARNING)
    @ObsoleteCoroutinesApi
    public static final <E, R> R consume(@NotNull BroadcastChannel<E> $this$consume, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> block) {
        return ChannelsKt__Channels_commonKt.consume($this$consume, block);
    }

    @Deprecated(message="Deprecated in the favour of 'receiveCatching'", replaceWith=@ReplaceWith(expression="receiveCatching().getOrNull()", imports={}), level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object receiveOrNull(ReceiveChannel $this$receiveOrNull, Continuation $completion) {
        return ChannelsKt__Channels_commonKt.receiveOrNull($this$receiveOrNull, $completion);
    }

    @Deprecated(message="Deprecated in the favour of 'onReceiveCatching'", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ SelectClause1 onReceiveOrNull(ReceiveChannel $this$onReceiveOrNull) {
        return ChannelsKt__Channels_commonKt.onReceiveOrNull($this$onReceiveOrNull);
    }

    public static final <E, R> R consume(@NotNull ReceiveChannel<? extends E> $this$consume, @NotNull Function1<? super ReceiveChannel<? extends E>, ? extends R> block) {
        return ChannelsKt__Channels_commonKt.consume($this$consume, block);
    }

    @Nullable
    public static final <E> Object consumeEach(@NotNull ReceiveChannel<? extends E> $this$consumeEach, @NotNull Function1<? super E, Unit> action, @NotNull Continuation<? super Unit> $completion) {
        return ChannelsKt__Channels_commonKt.consumeEach($this$consumeEach, action, $completion);
    }

    @Nullable
    public static final <E> Object toList(@NotNull ReceiveChannel<? extends E> $this$toList, @NotNull Continuation<? super List<? extends E>> $completion) {
        return ChannelsKt__Channels_commonKt.toList($this$toList, $completion);
    }

    @Deprecated(message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported", level=DeprecationLevel.WARNING)
    @Nullable
    public static final <E> Object consumeEach(@NotNull BroadcastChannel<E> $this$consumeEach, @NotNull Function1<? super E, Unit> action, @NotNull Continuation<? super Unit> $completion) {
        return ChannelsKt__Channels_commonKt.consumeEach($this$consumeEach, action, $completion);
    }

    @PublishedApi
    public static final void cancelConsumed(@NotNull ReceiveChannel<?> $this$cancelConsumed, @Nullable Throwable cause) {
        ChannelsKt__Channels_commonKt.cancelConsumed($this$cancelConsumed, cause);
    }

    @PublishedApi
    @NotNull
    public static final Function1<Throwable, Unit> consumesAll(ReceiveChannel<?> ... channels) {
        return ChannelsKt__DeprecatedKt.consumesAll(channels);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object elementAt(ReceiveChannel $this$elementAt, int index, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.elementAt($this$elementAt, index, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object elementAtOrNull(ReceiveChannel $this$elementAtOrNull, int index, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.elementAtOrNull($this$elementAtOrNull, index, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object first(ReceiveChannel $this$first, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.first($this$first, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object firstOrNull(ReceiveChannel $this$firstOrNull, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.firstOrNull($this$firstOrNull, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object indexOf(ReceiveChannel $this$indexOf, Object element, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.indexOf($this$indexOf, element, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object last(ReceiveChannel $this$last, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.last($this$last, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object lastIndexOf(ReceiveChannel $this$lastIndexOf, Object element, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.lastIndexOf($this$lastIndexOf, element, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object lastOrNull(ReceiveChannel $this$lastOrNull, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.lastOrNull($this$lastOrNull, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object single(ReceiveChannel $this$single, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.single($this$single, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object singleOrNull(ReceiveChannel $this$singleOrNull, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.singleOrNull($this$singleOrNull, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel drop(ReceiveChannel $this$drop, int n2, CoroutineContext context) {
        return ChannelsKt__DeprecatedKt.drop($this$drop, n2, context);
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel receiveChannel, int n2, CoroutineContext coroutineContext, int n3, Object object) {
        return ChannelsKt__DeprecatedKt.drop$default(receiveChannel, n2, coroutineContext, n3, object);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel dropWhile(ReceiveChannel $this$dropWhile, CoroutineContext context, Function2 predicate) {
        return ChannelsKt__DeprecatedKt.dropWhile($this$dropWhile, context, predicate);
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        return ChannelsKt__DeprecatedKt.dropWhile$default(receiveChannel, coroutineContext, function2, n2, object);
    }

    @PublishedApi
    @NotNull
    public static final <E> ReceiveChannel<E> filter(@NotNull ReceiveChannel<? extends E> $this$filter, @NotNull CoroutineContext context, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return ChannelsKt__DeprecatedKt.filter($this$filter, context, predicate);
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        return ChannelsKt__DeprecatedKt.filter$default(receiveChannel, coroutineContext, function2, n2, object);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel filterIndexed(ReceiveChannel $this$filterIndexed, CoroutineContext context, Function3 predicate) {
        return ChannelsKt__DeprecatedKt.filterIndexed($this$filterIndexed, context, predicate);
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int n2, Object object) {
        return ChannelsKt__DeprecatedKt.filterIndexed$default(receiveChannel, coroutineContext, function3, n2, object);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel filterNot(ReceiveChannel $this$filterNot, CoroutineContext context, Function2 predicate) {
        return ChannelsKt__DeprecatedKt.filterNot($this$filterNot, context, predicate);
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        return ChannelsKt__DeprecatedKt.filterNot$default(receiveChannel, coroutineContext, function2, n2, object);
    }

    @PublishedApi
    @NotNull
    public static final <E> ReceiveChannel<E> filterNotNull(@NotNull ReceiveChannel<? extends E> $this$filterNotNull) {
        return ChannelsKt__DeprecatedKt.filterNotNull($this$filterNotNull);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel $this$filterNotNullTo, Collection destination, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.filterNotNullTo($this$filterNotNullTo, destination, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel $this$filterNotNullTo, SendChannel destination, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.filterNotNullTo($this$filterNotNullTo, destination, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel take(ReceiveChannel $this$take, int n2, CoroutineContext context) {
        return ChannelsKt__DeprecatedKt.take($this$take, n2, context);
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel receiveChannel, int n2, CoroutineContext coroutineContext, int n3, Object object) {
        return ChannelsKt__DeprecatedKt.take$default(receiveChannel, n2, coroutineContext, n3, object);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel takeWhile(ReceiveChannel $this$takeWhile, CoroutineContext context, Function2 predicate) {
        return ChannelsKt__DeprecatedKt.takeWhile($this$takeWhile, context, predicate);
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        return ChannelsKt__DeprecatedKt.takeWhile$default(receiveChannel, coroutineContext, function2, n2, object);
    }

    @PublishedApi
    @Nullable
    public static final <E, C extends SendChannel<? super E>> Object toChannel(@NotNull ReceiveChannel<? extends E> $this$toChannel, @NotNull C destination, @NotNull Continuation<? super C> $completion) {
        return ChannelsKt__DeprecatedKt.toChannel($this$toChannel, destination, $completion);
    }

    @PublishedApi
    @Nullable
    public static final <E, C extends Collection<? super E>> Object toCollection(@NotNull ReceiveChannel<? extends E> $this$toCollection, @NotNull C destination, @NotNull Continuation<? super C> $completion) {
        return ChannelsKt__DeprecatedKt.toCollection($this$toCollection, destination, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object toMap(ReceiveChannel $this$toMap, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.toMap($this$toMap, $completion);
    }

    @PublishedApi
    @Nullable
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(@NotNull ReceiveChannel<? extends Pair<? extends K, ? extends V>> $this$toMap, @NotNull M destination, @NotNull Continuation<? super M> $completion) {
        return ChannelsKt__DeprecatedKt.toMap($this$toMap, destination, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object toMutableList(ReceiveChannel $this$toMutableList, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.toMutableList($this$toMutableList, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object toSet(ReceiveChannel $this$toSet, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.toSet($this$toSet, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel flatMap(ReceiveChannel $this$flatMap, CoroutineContext context, Function2 transform2) {
        return ChannelsKt__DeprecatedKt.flatMap($this$flatMap, context, transform2);
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        return ChannelsKt__DeprecatedKt.flatMap$default(receiveChannel, coroutineContext, function2, n2, object);
    }

    @PublishedApi
    @NotNull
    public static final <E, R> ReceiveChannel<R> map(@NotNull ReceiveChannel<? extends E> $this$map, @NotNull CoroutineContext context, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> transform2) {
        return ChannelsKt__DeprecatedKt.map($this$map, context, transform2);
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        return ChannelsKt__DeprecatedKt.map$default(receiveChannel, coroutineContext, function2, n2, object);
    }

    @PublishedApi
    @NotNull
    public static final <E, R> ReceiveChannel<R> mapIndexed(@NotNull ReceiveChannel<? extends E> $this$mapIndexed, @NotNull CoroutineContext context, @NotNull Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> transform2) {
        return ChannelsKt__DeprecatedKt.mapIndexed($this$mapIndexed, context, transform2);
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int n2, Object object) {
        return ChannelsKt__DeprecatedKt.mapIndexed$default(receiveChannel, coroutineContext, function3, n2, object);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel mapIndexedNotNull(ReceiveChannel $this$mapIndexedNotNull, CoroutineContext context, Function3 transform2) {
        return ChannelsKt__DeprecatedKt.mapIndexedNotNull($this$mapIndexedNotNull, context, transform2);
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int n2, Object object) {
        return ChannelsKt__DeprecatedKt.mapIndexedNotNull$default(receiveChannel, coroutineContext, function3, n2, object);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel mapNotNull(ReceiveChannel $this$mapNotNull, CoroutineContext context, Function2 transform2) {
        return ChannelsKt__DeprecatedKt.mapNotNull($this$mapNotNull, context, transform2);
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        return ChannelsKt__DeprecatedKt.mapNotNull$default(receiveChannel, coroutineContext, function2, n2, object);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel withIndex(ReceiveChannel $this$withIndex, CoroutineContext context) {
        return ChannelsKt__DeprecatedKt.withIndex($this$withIndex, context);
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int n2, Object object) {
        return ChannelsKt__DeprecatedKt.withIndex$default(receiveChannel, coroutineContext, n2, object);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel distinct(ReceiveChannel $this$distinct) {
        return ChannelsKt__DeprecatedKt.distinct($this$distinct);
    }

    @PublishedApi
    @NotNull
    public static final <E, K> ReceiveChannel<E> distinctBy(@NotNull ReceiveChannel<? extends E> $this$distinctBy, @NotNull CoroutineContext context, @NotNull Function2<? super E, ? super Continuation<? super K>, ? extends Object> selector) {
        return ChannelsKt__DeprecatedKt.distinctBy($this$distinctBy, context, selector);
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        return ChannelsKt__DeprecatedKt.distinctBy$default(receiveChannel, coroutineContext, function2, n2, object);
    }

    @PublishedApi
    @Nullable
    public static final <E> Object toMutableSet(@NotNull ReceiveChannel<? extends E> $this$toMutableSet, @NotNull Continuation<? super Set<E>> $completion) {
        return ChannelsKt__DeprecatedKt.toMutableSet($this$toMutableSet, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object any(ReceiveChannel $this$any, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.any($this$any, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object count(ReceiveChannel $this$count, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.count($this$count, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object maxWith(ReceiveChannel $this$maxWith, Comparator comparator, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.maxWith($this$maxWith, comparator, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object minWith(ReceiveChannel $this$minWith, Comparator comparator, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.minWith($this$minWith, comparator, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object none(ReceiveChannel $this$none, Continuation $completion) {
        return ChannelsKt__DeprecatedKt.none($this$none, $completion);
    }

    @Deprecated(message="Left for binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel requireNoNulls(ReceiveChannel $this$requireNoNulls) {
        return ChannelsKt__DeprecatedKt.requireNoNulls($this$requireNoNulls);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel zip(ReceiveChannel $this$zip, ReceiveChannel other) {
        return ChannelsKt__DeprecatedKt.zip($this$zip, other);
    }

    @PublishedApi
    @NotNull
    public static final <E, R, V> ReceiveChannel<V> zip(@NotNull ReceiveChannel<? extends E> $this$zip, @NotNull ReceiveChannel<? extends R> other, @NotNull CoroutineContext context, @NotNull Function2<? super E, ? super R, ? extends V> transform2) {
        return ChannelsKt__DeprecatedKt.zip($this$zip, other, context, transform2);
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        return ChannelsKt__DeprecatedKt.zip$default(receiveChannel, receiveChannel2, coroutineContext, function2, n2, object);
    }

    @PublishedApi
    @NotNull
    public static final Function1<Throwable, Unit> consumes(@NotNull ReceiveChannel<?> $this$consumes) {
        return ChannelsKt__DeprecatedKt.consumes($this$consumes);
    }
}


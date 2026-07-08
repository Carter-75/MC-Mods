/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.PublishedApi
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.IndexedValue
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000\u009c\u0001\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001aL\u0010\n\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t2\u001a\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u0000\"\u0006\u0012\u0002\b\u00030\u0001H\u0001\u00a2\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a8\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t*\u0006\u0012\u0002\b\u00030\u0001H\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0013\u001a\u00020\u0012\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u000f\u001a%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a\\\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00172\"\u0010\u001c\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001a7\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0007\u00a2\u0006\u0004\b \u0010!\u001aV\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00172\"\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010\u001e\u001a+\u0010%\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010$\u001a\u00020\u0012H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&\u001a-\u0010'\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010$\u001a\u00020\u0012H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010&\u001aV\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00172\"\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010\u001e\u001ak\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u001727\u0010\"\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0)H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+\u001aV\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00172\"\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010\u001e\u001a+\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\f*\u00020\u001b*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001H\u0001\u00a2\u0006\u0004\b-\u0010\u0015\u001aC\u00101\u001a\u00028\u0001\"\b\b\u0000\u0010\f*\u00020\u001b\"\u0010\b\u0001\u0010/*\n\u0012\u0006\b\u0000\u0012\u00028\u00000.*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00012\u0006\u00100\u001a\u00028\u0001H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u00102\u001aA\u00101\u001a\u00028\u0001\"\b\b\u0000\u0010\f*\u00020\u001b\"\u000e\b\u0001\u0010/*\b\u0012\u0004\u0012\u00028\u000003*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00012\u0006\u00100\u001a\u00028\u0001H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u00104\u001a#\u00105\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u0010\u000f\u001a%\u00106\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u0010\u000f\u001ab\u00109\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u00107*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00172(\u00108\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u0010\u001e\u001a+\u0010;\u001a\u00020\u0012\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010:\u001a\u00028\u0000H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b;\u0010<\u001a#\u0010=\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b=\u0010\u000f\u001a+\u0010>\u001a\u00020\u0012\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010:\u001a\u00028\u0000H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010<\u001a%\u0010?\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010\u000f\u001a\\\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u00107*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00172\"\u00108\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b@\u0010\u001e\u001aq\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u00107*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u001727\u00108\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0)H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bA\u0010+\u001aw\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\f\"\b\b\u0001\u00107*\u00020\u001b*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u001729\u00108\u001a5\b\u0001\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0)H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bB\u0010+\u001ab\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\f\"\b\b\u0001\u00107*\u00020\u001b*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00172$\u00108\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bC\u0010\u001e\u001aA\u0010G\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010F\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000Dj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`EH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\bG\u0010H\u001aA\u0010I\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010F\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000Dj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`EH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u0010H\u001a#\u0010J\u001a\u00020\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\bJ\u0010\u000f\u001a+\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\f*\u00020\u001b*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001H\u0007\u00a2\u0006\u0004\bK\u0010\u0015\u001a#\u0010L\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\bL\u0010\u000f\u001a%\u0010M\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\bM\u0010\u000f\u001a7\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0007\u00a2\u0006\u0004\bN\u0010!\u001aV\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00172\"\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010\u001e\u001a;\u0010P\u001a\u00028\u0001\"\u0004\b\u0000\u0010\f\"\u000e\b\u0001\u0010/*\b\u0012\u0004\u0012\u00028\u000003*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00100\u001a\u00028\u0001H\u0081@\u00f8\u0001\u0000\u00a2\u0006\u0004\bP\u00104\u001a=\u0010Q\u001a\u00028\u0001\"\u0004\b\u0000\u0010\f\"\u0010\b\u0001\u0010/*\n\u0012\u0006\b\u0000\u0012\u00028\u00000.*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00100\u001a\u00028\u0001H\u0081@\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u00102\u001aA\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010T\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010R*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S0\u0001H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\bU\u0010\u000f\u001aW\u0010U\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010R\"\u0018\b\u0002\u0010W*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010V*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S0\u00012\u0006\u00100\u001a\u00028\u0002H\u0081@\u00f8\u0001\u0000\u00a2\u0006\u0004\bU\u0010X\u001a)\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000Y\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\bZ\u0010\u000f\u001a)\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000[\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0081@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\\\u0010\u000f\u001a)\u0010^\u001a\b\u0012\u0004\u0012\u00028\u00000]\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b^\u0010\u000f\u001a5\u0010`\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000_0\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0007\u00a2\u0006\u0004\b`\u0010a\u001aF\u0010c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S0\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u00107*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0087\u0004\u00a2\u0006\u0004\bc\u0010d\u001a\u0081\u0001\u0010c\u001a\b\u0012\u0004\u0012\u00028\u00020\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u00107\"\u0004\b\u0002\u0010R*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u001726\u00108\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(e\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(f\u0012\u0004\u0012\u00028\u00020\u0019H\u0001\u00a2\u0006\u0004\bc\u0010g\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006h"}, d2={"", "Lkotlinx/coroutines/channels/ReceiveChannel;", "channels", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "consumesAll", "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", "E", "", "any", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumes", "(Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", "", "count", "distinct", "(Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlinx/coroutines/channels/ReceiveChannel;", "K", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "selector", "distinctBy", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "n", "drop", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/channels/ReceiveChannel;", "predicate", "dropWhile", "index", "elementAt", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrNull", "filter", "Lkotlin/Function3;", "filterIndexed", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filterNot", "filterNotNull", "", "C", "destination", "filterNotNullTo", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "first", "firstOrNull", "R", "transform", "flatMap", "element", "indexOf", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapNotNull", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "maxWith", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minWith", "none", "requireNoNulls", "single", "singleOrNull", "take", "takeWhile", "toChannel", "toCollection", "V", "Lkotlin/Pair;", "", "toMap", "", "M", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toMutableList", "", "toMutableSet", "", "toSet", "Lkotlin/collections/IndexedValue;", "withIndex", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/channels/ReceiveChannel;", "other", "zip", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlinx/coroutines/channels/ReceiveChannel;", "a", "b", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/channels/ChannelsKt")
@SourceDebugExtension(value={"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,479:1\n82#2,11:480\n82#2,11:491\n82#2,11:502\n82#2,11:513\n105#2:524\n82#2,6:525\n106#2:531\n92#2:532\n107#2:533\n88#2,3:534\n82#2,11:537\n105#2:548\n82#2,6:549\n106#2,2:555\n92#2:557\n88#2,3:558\n82#2,11:561\n82#2,11:572\n82#2,11:583\n105#2:594\n82#2,6:595\n106#2,2:601\n92#2:603\n88#2,3:604\n105#2:607\n82#2,6:608\n106#2,2:614\n92#2:616\n88#2,3:617\n105#2:620\n82#2,6:621\n106#2,2:627\n92#2:629\n88#2,3:630\n105#2:633\n82#2,6:634\n106#2,2:640\n92#2:642\n88#2,3:643\n105#2:646\n82#2,6:647\n106#2,2:653\n92#2:655\n88#2,3:656\n82#2,11:659\n105#2:670\n82#2,6:671\n106#2,2:677\n92#2:679\n88#2,3:680\n82#2,11:683\n82#2,11:694\n82#2,11:705\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt\n*L\n34#1:480,11\n49#1:491,11\n63#1:502,11\n73#1:513,11\n84#1:524\n84#1:525,6\n84#1:531\n84#1:532\n84#1:533\n84#1:534,3\n95#1:537,11\n110#1:548\n110#1:549,6\n110#1:555,2\n110#1:557\n110#1:558,3\n121#1:561,11\n134#1:572,11\n147#1:583,11\n232#1:594\n232#1:595,6\n232#1:601,2\n232#1:603\n232#1:604,3\n241#1:607\n241#1:608,6\n241#1:614,2\n241#1:616\n241#1:617,3\n277#1:620\n277#1:621,6\n277#1:627,2\n277#1:629\n277#1:630,3\n285#1:633\n285#1:634,6\n285#1:640,2\n285#1:642\n285#1:643,3\n298#1:646\n298#1:647,6\n298#1:653,2\n298#1:655\n298#1:656,3\n403#1:659,11\n411#1:670\n411#1:671,6\n411#1:677,2\n411#1:679\n411#1:680,3\n418#1:683,11\n432#1:694,11\n446#1:705,11\n*E\n"})
final class ChannelsKt__DeprecatedKt {
    @PublishedApi
    @NotNull
    public static final Function1<Throwable, Unit> consumesAll(ReceiveChannel<?> ... channels) {
        return (Function1)new Function1<Throwable, Unit>(channels){
            final /* synthetic */ ReceiveChannel<?>[] $channels;
            {
                this.$channels = $channels;
                super(1);
            }

            public final void invoke(@Nullable Throwable cause) {
                Throwable exception = null;
                for (ReceiveChannel<?> channel : this.$channels) {
                    try {
                        ChannelsKt.cancelConsumed(channel, cause);
                    }
                    catch (Throwable e2) {
                        if (exception == null) {
                            exception = e2;
                            continue;
                        }
                        Throwable $this$addSuppressedThrowable$iv = exception;
                        boolean $i$f$addSuppressedThrowable = false;
                        ExceptionsKt.addSuppressed((Throwable)$this$addSuppressedThrowable$iv, (Throwable)e2);
                    }
                }
                Throwable throwable = exception;
                if (throwable != null) {
                    Throwable it = throwable;
                    boolean bl = false;
                    throw it;
                }
            }
        };
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object elementAt(ReceiveChannel var0, int var1_1, Continuation var2_2) {
        if (!(var2_2 instanceof elementAt.1)) ** GOTO lbl-1000
        var13_3 = var2_2;
        if ((var13_3.label & -2147483648) != 0) {
            var13_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl((Continuation<? super elementAt.1>)var2_2){
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.elementAt(null, 0, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var14_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$consume$iv = $this$elementAt;
                $i$f$consume = false;
                cause$iv = null;
                try {
                    $this$elementAt_u24lambda_u240 = $this$consume$iv;
                    $i$a$-consume-ChannelsKt__DeprecatedKt$elementAt$2 = false;
                    if (index < 0) {
                        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + index + '.');
                    }
                    count = 0;
                    var9_14 = $this$elementAt_u24lambda_u240.iterator();
                }
                catch (Throwable e$iv) {
                    cause$iv = e$iv;
                    throw e$iv;
                }
                catch (Throwable var6_11) {
                    ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                    throw var6_11;
                }
                while (true) {
                    $continuation.L$0 = $this$consume$iv;
                    $continuation.L$1 = var9_14;
                    $continuation.I$0 = index;
                    $continuation.I$1 = count;
                    $continuation.label = 1;
                    v0 = var9_14.hasNext((Continuation<Boolean>)$continuation);
                    if (v0 == var14_5) {
                        return var14_5;
                    }
                    ** GOTO lbl52
                    break;
                }
            }
            case 1: {
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__DeprecatedKt$elementAt$2 = false;
                count = $continuation.I$1;
                index = $continuation.I$0;
                var9_14 = (ChannelIterator<E>)$continuation.L$1;
                cause$iv = null;
                $this$consume$iv = (ReceiveChannel)$continuation.L$0;
                {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl52:
                    // 2 sources

                    if (!((Boolean)v0).booleanValue()) ** GOTO lbl-1000
                    element = var9_14.next();
                    if (index != count++) ** continue;
                    var11_16 = element;
                }
                ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                return var11_16;
lbl-1000:
                // 1 sources

                {
                    throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + index + '.');
                }
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Exception decompiling
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object elementAtOrNull(ReceiveChannel var0, int var1_1, Continuation var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 12[DOLOOP]
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
     * Unable to fully structure code
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object first(ReceiveChannel var0, Continuation var1_1) {
        if (!(var1_1 instanceof first.1)) ** GOTO lbl-1000
        var10_2 = var1_1;
        if ((var10_2.label & -2147483648) != 0) {
            var10_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl((Continuation<? super first.1>)var1_1){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.first(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var11_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$consume$iv = $this$first;
                $i$f$consume = false;
                cause$iv = null;
                $this$first_u24lambda_u242 = $this$consume$iv;
                $i$a$-consume-ChannelsKt__DeprecatedKt$first$2 = false;
                iterator = $this$first_u24lambda_u242.iterator();
                $continuation.L$0 = $this$consume$iv;
                $continuation.L$1 = iterator;
                $continuation.label = 1;
                v0 = iterator.hasNext((Continuation<Boolean>)$continuation);
                ** if (v0 != var11_4) goto lbl27
lbl26:
                // 1 sources

                return var11_4;
lbl27:
                // 1 sources

                ** GOTO lbl38
            }
            case 1: {
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__DeprecatedKt$first$2 = false;
                iterator = (ChannelIterator<E>)$continuation.L$1;
                cause$iv = null;
                $this$consume$iv = (ReceiveChannel)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl38:
                    // 2 sources

                    if (!((Boolean)v0).booleanValue()) {
                        throw new NoSuchElementException("ReceiveChannel is empty.");
                    }
                    var8_15 = iterator.next();
                    return var8_15;
                }
                catch (Throwable e$iv) {
                    cause$iv = e$iv;
                    throw e$iv;
                }
            }
            catch (Throwable var5_11) {
                throw var5_11;
            }
            {
                finally {
                    ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                }
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object firstOrNull(ReceiveChannel var0, Continuation var1_1) {
        if (!(var1_1 instanceof firstOrNull.1)) ** GOTO lbl-1000
        var11_2 = var1_1;
        if ((var11_2.label & -2147483648) != 0) {
            var11_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl((Continuation<? super firstOrNull.1>)var1_1){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.firstOrNull(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var12_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$consume$iv = $this$firstOrNull;
                $i$f$consume = false;
                cause$iv = null;
                $this$firstOrNull_u24lambda_u243 = $this$consume$iv;
                $i$a$-consume-ChannelsKt__DeprecatedKt$firstOrNull$2 = false;
                iterator = $this$firstOrNull_u24lambda_u243.iterator();
                $continuation.L$0 = $this$consume$iv;
                $continuation.L$1 = iterator;
                $continuation.label = 1;
                v0 = iterator.hasNext((Continuation<Boolean>)$continuation);
                ** if (v0 != var12_4) goto lbl27
lbl26:
                // 1 sources

                return var12_4;
lbl27:
                // 1 sources

                ** GOTO lbl38
            }
            case 1: {
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__DeprecatedKt$firstOrNull$2 = false;
                iterator = (ChannelIterator<E>)$continuation.L$1;
                cause$iv = null;
                $this$consume$iv = (ReceiveChannel)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl38:
                    // 2 sources

                    if (!((Boolean)v0).booleanValue()) {
                        var9_15 = null;
                        return var9_15;
                    }
                    var8_16 = iterator.next();
                    return var8_16;
                }
                catch (Throwable e$iv) {
                    cause$iv = e$iv;
                    throw e$iv;
                }
            }
            catch (Throwable var5_11) {
                throw var5_11;
            }
            {
                finally {
                    ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                }
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object indexOf(ReceiveChannel var0, Object var1_1, Continuation var2_2) {
        if (!(var2_2 instanceof indexOf.1)) ** GOTO lbl-1000
        var18_3 = var2_2;
        if ((var18_3.label & -2147483648) != 0) {
            var18_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl((Continuation<? super indexOf.1>)var2_2){
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.indexOf(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var19_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                index = new Ref.IntRef();
                $this$consumeEach$iv = $this$indexOf;
                $i$f$consumeEach = false;
                $this$consume$iv$iv = $this$consumeEach$iv;
                $i$f$consume = false;
                cause$iv$iv = null;
                try {
                    $this$consumeEach_u24lambda_u241$iv = $this$consume$iv$iv;
                    $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv = false;
                    var11_16 = $this$consumeEach_u24lambda_u241$iv.iterator();
                }
                catch (Throwable e$iv$iv) {
                    try {
                        cause$iv$iv = e$iv$iv;
                        throw e$iv$iv;
                    }
                    catch (Throwable var9_14) {
                        ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                        throw var9_14;
                    }
                }
lbl32:
                // 2 sources

                while (true) {
                    $continuation.L$0 = element;
                    $continuation.L$1 = index;
                    $continuation.L$2 = $this$consume$iv$iv;
                    $continuation.L$3 = var11_16;
                    $continuation.label = 1;
                    v0 = var11_16.hasNext((Continuation<Boolean>)$continuation);
                    if (v0 == var19_5) {
                        return var19_5;
                    }
                    ** GOTO lbl54
                    break;
                }
            }
            case 1: {
                $i$f$consumeEach = false;
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv = false;
                var11_16 = (ChannelIterator<E>)$continuation.L$3;
                cause$iv$iv = null;
                $this$consume$iv$iv = (ReceiveChannel)$continuation.L$2;
                index = (Ref.IntRef)$continuation.L$1;
                element = $continuation.L$0;
                {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl54:
                    // 2 sources

                    if (!((Boolean)v0).booleanValue()) ** GOTO lbl65
                    it = e$iv = var11_16.next();
                    $i$a$-consumeEach-ChannelsKt__DeprecatedKt$indexOf$2 = false;
                    if (!Intrinsics.areEqual((Object)element, it)) ** GOTO lbl-1000
                    var16_21 = Boxing.boxInt((int)index.element);
                }
                ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                return var16_21;
lbl-1000:
                // 1 sources

                {
                    var15_20 = index.element;
                    index.element = var15_20 + 1;
                    ** continue;
lbl65:
                    // 1 sources

                    $this$consumeEach_u24lambda_u241$iv = Unit.INSTANCE;
                }
                ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                return Boxing.boxInt((int)-1);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Exception decompiling
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object last(ReceiveChannel var0, Continuation var1_1) {
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
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object lastIndexOf(ReceiveChannel var0, Object var1_1, Continuation var2_2) {
        if (!(var2_2 instanceof lastIndexOf.1)) ** GOTO lbl-1000
        var18_3 = var2_2;
        if ((var18_3.label & -2147483648) != 0) {
            var18_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl((Continuation<? super lastIndexOf.1>)var2_2){
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.lastIndexOf(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var19_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                lastIndex = new Ref.IntRef();
                lastIndex.element = -1;
                index = new Ref.IntRef();
                $this$consumeEach$iv = $this$lastIndexOf;
                $i$f$consumeEach = false;
                $this$consume$iv$iv = $this$consumeEach$iv;
                $i$f$consume = false;
                cause$iv$iv = null;
                try {
                    $this$consumeEach_u24lambda_u241$iv = $this$consume$iv$iv;
                    $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv = false;
                    var12_17 = $this$consumeEach_u24lambda_u241$iv.iterator();
                }
                catch (Throwable e$iv$iv) {
                    try {
                        cause$iv$iv = e$iv$iv;
                        throw e$iv$iv;
                    }
                    catch (Throwable var10_15) {
                        ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                        throw var10_15;
                    }
                }
lbl34:
                // 2 sources

                while (true) {
                    $continuation.L$0 = element;
                    $continuation.L$1 = lastIndex;
                    $continuation.L$2 = index;
                    $continuation.L$3 = $this$consume$iv$iv;
                    $continuation.L$4 = var12_17;
                    $continuation.label = 1;
                    v0 = var12_17.hasNext((Continuation<Boolean>)$continuation);
                    if (v0 == var19_5) {
                        return var19_5;
                    }
                    ** GOTO lbl58
                    break;
                }
            }
            case 1: {
                $i$f$consumeEach = false;
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv = false;
                var12_17 = (ChannelIterator<E>)$continuation.L$4;
                cause$iv$iv = null;
                $this$consume$iv$iv = (ReceiveChannel)$continuation.L$3;
                index = (Ref.IntRef)$continuation.L$2;
                lastIndex = (Ref.IntRef)$continuation.L$1;
                element = $continuation.L$0;
                {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl58:
                    // 2 sources

                    if (((Boolean)v0).booleanValue()) {
                        it = e$iv = var12_17.next();
                        $i$a$-consumeEach-ChannelsKt__DeprecatedKt$lastIndexOf$2 = false;
                        if (Intrinsics.areEqual((Object)element, it)) {
                            lastIndex.element = index.element;
                        }
                        var16_21 = index.element;
                        index.element = var16_21 + 1;
                        ** continue;
                    }
                    $this$consumeEach_u24lambda_u241$iv = Unit.INSTANCE;
                }
                ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                return Boxing.boxInt((int)lastIndex.element);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Exception decompiling
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object lastOrNull(ReceiveChannel var0, Continuation var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 12[UNCONDITIONALDOLOOP]
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
     * Unable to fully structure code
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object single(ReceiveChannel var0, Continuation var1_1) {
        if (!(var1_1 instanceof single.1)) ** GOTO lbl-1000
        var11_2 = var1_1;
        if ((var11_2.label & -2147483648) != 0) {
            var11_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl((Continuation<? super single.1>)var1_1){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.single(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var12_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$consume$iv = $this$single;
                $i$f$consume = false;
                cause$iv = null;
                $this$single_u24lambda_u248 = $this$consume$iv;
                $i$a$-consume-ChannelsKt__DeprecatedKt$single$2 = false;
                iterator = $this$single_u24lambda_u248.iterator();
                $continuation.L$0 = $this$consume$iv;
                $continuation.L$1 = iterator;
                $continuation.label = 1;
                v0 = iterator.hasNext((Continuation<Boolean>)$continuation);
                ** if (v0 != var12_4) goto lbl27
lbl26:
                // 1 sources

                return var12_4;
lbl27:
                // 1 sources

                ** GOTO lbl38
            }
            case 1: {
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__DeprecatedKt$single$2 = false;
                iterator = (ChannelIterator<E>)$continuation.L$1;
                cause$iv = null;
                $this$consume$iv = (ReceiveChannel)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl38:
                // 2 sources

                if (!((Boolean)v0).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                single = iterator.next();
                $continuation.L$0 = $this$consume$iv;
                $continuation.L$1 = single;
                $continuation.label = 2;
                v1 = iterator.hasNext((Continuation<Boolean>)$continuation);
                ** if (v1 != var12_4) goto lbl47
lbl46:
                // 1 sources

                return var12_4;
lbl47:
                // 1 sources

                ** GOTO lbl58
            }
            case 2: {
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__DeprecatedKt$single$2 = false;
                single = $continuation.L$1;
                cause$iv = null;
                $this$consume$iv = (ReceiveChannel)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl58:
                    // 2 sources

                    if (((Boolean)v1).booleanValue()) {
                        throw new IllegalArgumentException("ReceiveChannel has more than one element.");
                    }
                    var9_18 = single;
                    return var9_18;
                }
                catch (Throwable e$iv) {
                    cause$iv = e$iv;
                    throw e$iv;
                }
            }
            catch (Throwable var5_12) {
                throw var5_12;
            }
            {
                finally {
                    ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                }
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object singleOrNull(ReceiveChannel var0, Continuation var1_1) {
        if (!(var1_1 instanceof singleOrNull.1)) ** GOTO lbl-1000
        var13_2 = var1_1;
        if ((var13_2.label & -2147483648) != 0) {
            var13_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl((Continuation<? super singleOrNull.1>)var1_1){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.singleOrNull(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var14_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$consume$iv = $this$singleOrNull;
                $i$f$consume = false;
                cause$iv = null;
                $this$singleOrNull_u24lambda_u249 = $this$consume$iv;
                $i$a$-consume-ChannelsKt__DeprecatedKt$singleOrNull$2 = false;
                iterator = $this$singleOrNull_u24lambda_u249.iterator();
                $continuation.L$0 = $this$consume$iv;
                $continuation.L$1 = iterator;
                $continuation.label = 1;
                v0 = iterator.hasNext((Continuation<Boolean>)$continuation);
                ** if (v0 != var14_4) goto lbl27
lbl26:
                // 1 sources

                return var14_4;
lbl27:
                // 1 sources

                ** GOTO lbl38
            }
            case 1: {
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__DeprecatedKt$singleOrNull$2 = false;
                iterator = (ChannelIterator<E>)$continuation.L$1;
                cause$iv = null;
                $this$consume$iv = (ReceiveChannel)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl38:
                // 2 sources

                if (((Boolean)v0).booleanValue()) ** GOTO lbl43
                var11_17 = null;
                ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                return var11_17;
lbl43:
                // 2 sources

                single = iterator.next();
                $continuation.L$0 = $this$consume$iv;
                $continuation.L$1 = single;
                $continuation.label = 2;
                v1 = iterator.hasNext((Continuation<Boolean>)$continuation);
                ** if (v1 != var14_4) goto lbl50
lbl49:
                // 1 sources

                return var14_4;
lbl50:
                // 1 sources

                ** GOTO lbl61
            }
            case 2: {
                $i$a$-consume-ChannelsKt__DeprecatedKt$singleOrNull$2 = false;
                $i$f$consume = false;
                single = $continuation.L$1;
                cause$iv = null;
                $this$consume$iv = (ReceiveChannel)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl61:
                    // 2 sources

                    if (((Boolean)v1).booleanValue()) {
                        var10_19 = null;
                        return var10_19;
                    }
                    var9_20 = single;
                    return var9_20;
                }
                catch (Throwable e$iv) {
                    cause$iv = e$iv;
                    throw e$iv;
                }
            }
            catch (Throwable var5_12) {
                throw var5_12;
            }
            {
                finally {
                    ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                }
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel drop(ReceiveChannel $this$drop, int n2, CoroutineContext context) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, null, ChannelsKt.consumes($this$drop), new Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>(n2, $this$drop, null){
            Object L$1;
            int I$0;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ int $n;
            final /* synthetic */ ReceiveChannel<E> $this_drop;
            {
                this.$n = $n;
                this.$this_drop = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var6_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$produce = (ProducerScope)this.L$0;
                        var3_4 = this.$n >= 0;
                        var4_5 = this.$n;
                        if (!var3_4) {
                            $i$a$-require-ChannelsKt__DeprecatedKt$drop$1$1 = false;
                            $i$a$-require-ChannelsKt__DeprecatedKt$drop$1$1 = "Requested element count " + var4_5 + " is less than zero.";
                            throw new IllegalArgumentException($i$a$-require-ChannelsKt__DeprecatedKt$drop$1$1.toString());
                        }
                        remaining = this.$n;
                        if (remaining <= 0) ** GOTO lbl34
                        var4_6 = this.$this_drop.iterator();
                        while (true) {
                            this.L$0 = $this$produce;
                            this.L$1 = var4_6;
                            this.I$0 = remaining;
                            this.label = 1;
                            v0 = var4_6.hasNext((Continuation<Boolean>)((Continuation)this));
                            if (v0 == var6_2) {
                                return var6_2;
                            }
                            ** GOTO lbl30
                            break;
                        }
                    }
                    case 1: {
                        remaining = this.I$0;
                        var4_6 = (ChannelIterator<E>)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl30:
                        // 2 sources

                        if (((Boolean)v0).booleanValue()) {
                            var4_6.next();
                            if (--remaining != 0) ** continue;
                        }
lbl34:
                        // 4 sources

                        var4_7 = this.$this_drop.iterator();
lbl35:
                        // 2 sources

                        while (true) {
                            this.L$0 = $this$produce;
                            this.L$1 = var4_7;
                            this.label = 2;
                            v1 = var4_7.hasNext((Continuation<Boolean>)((Continuation)this));
                            if (v1 == var6_2) {
                                return var6_2;
                            }
                            ** GOTO lbl48
                            break;
                        }
                    }
                    case 2: {
                        var4_7 = (ChannelIterator<E>)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl48:
                        // 2 sources

                        if (!((Boolean)v1).booleanValue()) break;
                        e = var4_7.next();
                        this.L$0 = $this$produce;
                        this.L$1 = var4_7;
                        this.label = 3;
                        v2 = $this$produce.send(e, (Continuation<Unit>)((Continuation)this));
                        if (v2 == var6_2) {
                            return var6_2;
                        }
                        ** GOTO lbl62
                    }
                    case 3: {
                        var4_7 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl62:
                        // 2 sources

                        ** continue;
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super E> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel receiveChannel, int n2, CoroutineContext coroutineContext, int n3, Object object) {
        if ((n3 & 2) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.drop(receiveChannel, n2, coroutineContext);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel dropWhile(ReceiveChannel $this$dropWhile, CoroutineContext context, Function2 predicate) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, null, ChannelsKt.consumes($this$dropWhile), new Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>($this$dropWhile, predicate, null){
            Object L$1;
            Object L$2;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ ReceiveChannel<E> $this_dropWhile;
            final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
            {
                this.$this_dropWhile = $receiver;
                this.$predicate = $predicate;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var5_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$produce = (ProducerScope)this.L$0;
                        var3_4 = this.$this_dropWhile.iterator();
                        while (true) {
                            this.L$0 = $this$produce;
                            this.L$1 = var3_4;
                            this.L$2 = null;
                            this.label = 1;
                            v0 = var3_4.hasNext((Continuation<Boolean>)((Continuation)this));
                            if (v0 == var5_2) {
                                return var5_2;
                            }
                            ** GOTO lbl21
                            break;
                        }
                    }
                    case 1: {
                        var3_4 = (ChannelIterator<E>)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl21:
                        // 2 sources

                        if (!((Boolean)v0).booleanValue()) ** GOTO lbl50
                        e = var3_4.next();
                        this.L$0 = $this$produce;
                        this.L$1 = var3_4;
                        this.L$2 = e;
                        this.label = 2;
                        v1 = this.$predicate.invoke(e, (Object)this);
                        if (v1 == var5_2) {
                            return var5_2;
                        }
                        ** GOTO lbl37
                    }
                    case 2: {
                        e = this.L$2;
                        var3_4 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl37:
                        // 2 sources

                        if (((Boolean)v1).booleanValue()) ** continue;
                        this.L$0 = $this$produce;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 3;
                        v2 = $this$produce.send(e, (Continuation<Unit>)((Continuation)this));
                        if (v2 == var5_2) {
                            return var5_2;
                        }
                        ** GOTO lbl50
                    }
                    case 3: {
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl50:
                        // 3 sources

                        var3_4 = this.$this_dropWhile.iterator();
lbl51:
                        // 2 sources

                        while (true) {
                            this.L$0 = $this$produce;
                            this.L$1 = var3_4;
                            this.label = 4;
                            v3 = var3_4.hasNext((Continuation<Boolean>)((Continuation)this));
                            if (v3 == var5_2) {
                                return var5_2;
                            }
                            ** GOTO lbl64
                            break;
                        }
                    }
                    case 4: {
                        var3_4 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v3 = $result;
lbl64:
                        // 2 sources

                        if (!((Boolean)v3).booleanValue()) break;
                        e = var3_4.next();
                        this.L$0 = $this$produce;
                        this.L$1 = var3_4;
                        this.label = 5;
                        v4 = $this$produce.send(e, (Continuation<Unit>)((Continuation)this));
                        if (v4 == var5_2) {
                            return var5_2;
                        }
                        ** GOTO lbl78
                    }
                    case 5: {
                        var3_4 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v4 = $result;
lbl78:
                        // 2 sources

                        ** continue;
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super E> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.dropWhile(receiveChannel, coroutineContext, function2);
    }

    @PublishedApi
    @NotNull
    public static final <E> ReceiveChannel<E> filter(@NotNull ReceiveChannel<? extends E> $this$filter, @NotNull CoroutineContext context, @NotNull Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, null, ChannelsKt.consumes($this$filter), new Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>($this$filter, predicate, null){
            Object L$1;
            Object L$2;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ ReceiveChannel<E> $this_filter;
            final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
            {
                this.$this_filter = $receiver;
                this.$predicate = $predicate;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var5_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$produce = (ProducerScope)this.L$0;
                        var3_4 = this.$this_filter.iterator();
lbl7:
                        // 3 sources

                        while (true) {
                            this.L$0 = $this$produce;
                            this.L$1 = var3_4;
                            this.L$2 = null;
                            this.label = 1;
                            v0 = var3_4.hasNext((Continuation<Boolean>)((Continuation)this));
                            if (v0 == var5_2) {
                                return var5_2;
                            }
                            ** GOTO lbl21
                            break;
                        }
                    }
                    case 1: {
                        var3_4 = (ChannelIterator<E>)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl21:
                        // 2 sources

                        if (!((Boolean)v0).booleanValue()) break;
                        e = var3_4.next();
                        this.L$0 = $this$produce;
                        this.L$1 = var3_4;
                        this.L$2 = e;
                        this.label = 2;
                        v1 = this.$predicate.invoke(e, (Object)this);
                        if (v1 == var5_2) {
                            return var5_2;
                        }
                        ** GOTO lbl37
                    }
                    case 2: {
                        e = this.L$2;
                        var3_4 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl37:
                        // 2 sources

                        if (!((Boolean)v1).booleanValue()) ** GOTO lbl7
                        this.L$0 = $this$produce;
                        this.L$1 = var3_4;
                        this.L$2 = null;
                        this.label = 3;
                        v2 = $this$produce.send(e, (Continuation<Unit>)((Continuation)this));
                        if (v2 == var5_2) {
                            return var5_2;
                        }
                        ** GOTO lbl51
                    }
                    case 3: {
                        var3_4 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl51:
                        // 2 sources

                        ** continue;
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super E> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.filter(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel filterIndexed(ReceiveChannel $this$filterIndexed, CoroutineContext context, Function3 predicate) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, null, ChannelsKt.consumes($this$filterIndexed), new Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>($this$filterIndexed, predicate, null){
            Object L$1;
            Object L$2;
            int I$0;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ ReceiveChannel<E> $this_filterIndexed;
            final /* synthetic */ Function3<Integer, E, Continuation<? super Boolean>, Object> $predicate;
            {
                this.$this_filterIndexed = $receiver;
                this.$predicate = $predicate;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var6_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$produce = (ProducerScope)this.L$0;
                        index = 0;
                        var4_5 = this.$this_filterIndexed.iterator();
lbl8:
                        // 3 sources

                        while (true) {
                            this.L$0 = $this$produce;
                            this.L$1 = var4_5;
                            this.L$2 = null;
                            this.I$0 = index;
                            this.label = 1;
                            v0 = var4_5.hasNext((Continuation<Boolean>)((Continuation)this));
                            if (v0 == var6_2) {
                                return var6_2;
                            }
                            ** GOTO lbl24
                            break;
                        }
                    }
                    case 1: {
                        index = this.I$0;
                        var4_5 = (ChannelIterator<E>)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl24:
                        // 2 sources

                        if (!((Boolean)v0).booleanValue()) break;
                        e = var4_5.next();
                        v1 = index++;
                        this.L$0 = $this$produce;
                        this.L$1 = var4_5;
                        this.L$2 = e;
                        this.I$0 = index;
                        this.label = 2;
                        v2 = this.$predicate.invoke((Object)Boxing.boxInt((int)v1), e, (Object)this);
                        if (v2 == var6_2) {
                            return var6_2;
                        }
                        ** GOTO lbl43
                    }
                    case 2: {
                        index = this.I$0;
                        e = this.L$2;
                        var4_5 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl43:
                        // 2 sources

                        if (!((Boolean)v2).booleanValue()) ** GOTO lbl8
                        this.L$0 = $this$produce;
                        this.L$1 = var4_5;
                        this.L$2 = null;
                        this.I$0 = index;
                        this.label = 3;
                        v3 = $this$produce.send(e, (Continuation<Unit>)((Continuation)this));
                        if (v3 == var6_2) {
                            return var6_2;
                        }
                        ** GOTO lbl59
                    }
                    case 3: {
                        index = this.I$0;
                        var4_5 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v3 = $result;
lbl59:
                        // 2 sources

                        ** continue;
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super E> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.filterIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel filterNot(ReceiveChannel $this$filterNot, CoroutineContext context, Function2 predicate) {
        return ChannelsKt.filter($this$filterNot, context, (Function2)new Function2<E, Continuation<? super Boolean>, Object>(predicate, null){
            int label;
            /* synthetic */ Object L$0;
            final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
            {
                this.$predicate = $predicate;
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
                        Object it = this.L$0;
                        this.label = 1;
                        Object object3 = this.$predicate.invoke(it, (Object)((Object)this));
                        if (object3 != object2) return Boxing.boxBoolean(((Boolean)object3 == false ? 1 : 0) != 0);
                        return object2;
                    }
                    case 1: {
                        void $result;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object3 = $result;
                        return Boxing.boxBoolean(((Boolean)object3 == false ? 1 : 0) != 0);
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<E, Continuation<? super Boolean>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(E p1, @Nullable Continuation<? super Boolean> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.filterNot(receiveChannel, coroutineContext, function2);
    }

    @PublishedApi
    @NotNull
    public static final <E> ReceiveChannel<E> filterNotNull(@NotNull ReceiveChannel<? extends E> $this$filterNotNull) {
        ReceiveChannel receiveChannel = ChannelsKt.filter$default($this$filterNotNull, null, new Function2<E, Continuation<? super Boolean>, Object>(null){
            int label;
            /* synthetic */ Object L$0;

            @Nullable
            public final Object invokeSuspend(@NotNull Object object) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        Object it = this.L$0;
                        return Boxing.boxBoolean((it != null ? 1 : 0) != 0);
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<E, Continuation<? super Boolean>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@Nullable E p1, @Nullable Continuation<? super Boolean> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 1, null);
        Intrinsics.checkNotNull((Object)receiveChannel, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNull>");
        return receiveChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel var0, Collection var1_1, Continuation var2_2) {
        if (!(var2_2 instanceof filterNotNullTo.1)) ** GOTO lbl-1000
        var15_3 = var2_2;
        if ((var15_3.label & -2147483648) != 0) {
            var15_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl((Continuation<? super filterNotNullTo.1>)var2_2){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.filterNotNullTo(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var16_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$consumeEach$iv = $this$filterNotNullTo;
                $i$f$consumeEach = false;
                $this$consume$iv$iv = $this$consumeEach$iv;
                $i$f$consume = false;
                cause$iv$iv = null;
                try {
                    $this$consumeEach_u24lambda_u241$iv = $this$consume$iv$iv;
                    $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv = false;
                    var10_15 = $this$consumeEach_u24lambda_u241$iv.iterator();
                }
                catch (Throwable e$iv$iv) {
                    try {
                        cause$iv$iv = e$iv$iv;
                        throw e$iv$iv;
                    }
                    catch (Throwable var8_13) {
                        ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                        throw var8_13;
                    }
                }
lbl31:
                // 3 sources

                while (true) {
                    $continuation.L$0 = destination;
                    $continuation.L$1 = $this$consume$iv$iv;
                    $continuation.L$2 = var10_15;
                    $continuation.label = 1;
                    v0 = var10_15.hasNext((Continuation<Boolean>)$continuation);
                    if (v0 == var16_5) {
                        return var16_5;
                    }
                    ** GOTO lbl51
                    break;
                }
            }
            case 1: {
                $i$f$consumeEach = false;
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv = false;
                var10_15 = (ChannelIterator<E>)$continuation.L$2;
                cause$iv$iv = null;
                $this$consume$iv$iv = (ReceiveChannel)$continuation.L$1;
                destination = (Collection)$continuation.L$0;
                {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl51:
                    // 2 sources

                    if (!((Boolean)v0).booleanValue()) ** GOTO lbl59
                    it = e$iv = var10_15.next();
                    $i$a$-consumeEach-ChannelsKt__DeprecatedKt$filterNotNullTo$2 = false;
                    if (it == null) ** GOTO lbl31
                    destination.add(it);
                    ** continue;
lbl59:
                    // 1 sources

                    $this$consumeEach_u24lambda_u241$iv = Unit.INSTANCE;
                }
                ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                return destination;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Exception decompiling
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel var0, SendChannel var1_1, Continuation var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 11[UNCONDITIONALDOLOOP]
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

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel take(ReceiveChannel $this$take, int n2, CoroutineContext context) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, null, ChannelsKt.consumes($this$take), new Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>(n2, $this$take, null){
            Object L$1;
            int I$0;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ int $n;
            final /* synthetic */ ReceiveChannel<E> $this_take;
            {
                this.$n = $n;
                this.$this_take = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var6_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$produce = (ProducerScope)this.L$0;
                        if (this.$n == 0) {
                            return Unit.INSTANCE;
                        }
                        var3_4 = this.$n >= 0;
                        var4_5 = this.$n;
                        if (!var3_4) {
                            $i$a$-require-ChannelsKt__DeprecatedKt$take$1$1 = false;
                            $i$a$-require-ChannelsKt__DeprecatedKt$take$1$1 = "Requested element count " + var4_5 + " is less than zero.";
                            throw new IllegalArgumentException($i$a$-require-ChannelsKt__DeprecatedKt$take$1$1.toString());
                        }
                        remaining = this.$n;
                        var4_6 = this.$this_take.iterator();
                        while (true) {
                            this.L$0 = $this$produce;
                            this.L$1 = var4_6;
                            this.I$0 = remaining;
                            this.label = 1;
                            v0 = var4_6.hasNext((Continuation<Boolean>)((Continuation)this));
                            if (v0 == var6_2) {
                                return var6_2;
                            }
                            ** GOTO lbl31
                            break;
                        }
                    }
                    case 1: {
                        remaining = this.I$0;
                        var4_6 = (ChannelIterator<E>)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl31:
                        // 2 sources

                        if (!((Boolean)v0).booleanValue()) break;
                        e = var4_6.next();
                        this.L$0 = $this$produce;
                        this.L$1 = var4_6;
                        this.I$0 = remaining;
                        this.label = 2;
                        v1 = $this$produce.send(e, (Continuation<Unit>)((Continuation)this));
                        if (v1 == var6_2) {
                            return var6_2;
                        }
                        ** GOTO lbl47
                    }
                    case 2: {
                        remaining = this.I$0;
                        var4_6 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl47:
                        // 2 sources

                        if (--remaining != 0) ** continue;
                        return Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super E> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel receiveChannel, int n2, CoroutineContext coroutineContext, int n3, Object object) {
        if ((n3 & 2) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.take(receiveChannel, n2, coroutineContext);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel takeWhile(ReceiveChannel $this$takeWhile, CoroutineContext context, Function2 predicate) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, null, ChannelsKt.consumes($this$takeWhile), new Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>($this$takeWhile, predicate, null){
            Object L$1;
            Object L$2;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ ReceiveChannel<E> $this_takeWhile;
            final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
            {
                this.$this_takeWhile = $receiver;
                this.$predicate = $predicate;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var5_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$produce = (ProducerScope)this.L$0;
                        var3_4 = this.$this_takeWhile.iterator();
lbl7:
                        // 2 sources

                        while (true) {
                            this.L$0 = $this$produce;
                            this.L$1 = var3_4;
                            this.label = 1;
                            v0 = var3_4.hasNext((Continuation<Boolean>)((Continuation)this));
                            if (v0 == var5_2) {
                                return var5_2;
                            }
                            ** GOTO lbl20
                            break;
                        }
                    }
                    case 1: {
                        var3_4 = (ChannelIterator<E>)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl20:
                        // 2 sources

                        if (!((Boolean)v0).booleanValue()) break;
                        e = var3_4.next();
                        this.L$0 = $this$produce;
                        this.L$1 = var3_4;
                        this.L$2 = e;
                        this.label = 2;
                        v1 = this.$predicate.invoke(e, (Object)this);
                        if (v1 == var5_2) {
                            return var5_2;
                        }
                        ** GOTO lbl36
                    }
                    case 2: {
                        e = this.L$2;
                        var3_4 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl36:
                        // 2 sources

                        if (!((Boolean)v1).booleanValue()) {
                            return Unit.INSTANCE;
                        }
                        this.L$0 = $this$produce;
                        this.L$1 = var3_4;
                        this.L$2 = null;
                        this.label = 3;
                        v2 = $this$produce.send(e, (Continuation<Unit>)((Continuation)this));
                        if (v2 == var5_2) {
                            return var5_2;
                        }
                        ** GOTO lbl51
                    }
                    case 3: {
                        var3_4 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl51:
                        // 2 sources

                        ** continue;
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super E> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.takeWhile(receiveChannel, coroutineContext, function2);
    }

    /*
     * Exception decompiling
     */
    @PublishedApi
    @Nullable
    public static final <E, C extends SendChannel<? super E>> Object toChannel(@NotNull ReceiveChannel<? extends E> var0, @NotNull C var1_1, @NotNull Continuation<? super C> var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 11[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
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
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @PublishedApi
    @Nullable
    public static final <E, C extends Collection<? super E>> Object toCollection(@NotNull ReceiveChannel<? extends E> var0, @NotNull C var1_1, @NotNull Continuation<? super C> var2_2) {
        if (!(var2_2 instanceof toCollection.1)) ** GOTO lbl-1000
        var15_3 = var2_2;
        if ((var15_3.label & -2147483648) != 0) {
            var15_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var2_2){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.toCollection(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var16_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$consumeEach$iv = $this$toCollection;
                $i$f$consumeEach = false;
                $this$consume$iv$iv = $this$consumeEach$iv;
                $i$f$consume = false;
                cause$iv$iv = null;
                try {
                    $this$consumeEach_u24lambda_u241$iv = $this$consume$iv$iv;
                    $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv = false;
                    var10_15 = $this$consumeEach_u24lambda_u241$iv.iterator();
                }
                catch (Throwable e$iv$iv) {
                    try {
                        cause$iv$iv = e$iv$iv;
                        throw e$iv$iv;
                    }
                    catch (Throwable var8_13) {
                        ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                        throw var8_13;
                    }
                }
lbl31:
                // 2 sources

                while (true) {
                    $continuation.L$0 = destination;
                    $continuation.L$1 = $this$consume$iv$iv;
                    $continuation.L$2 = var10_15;
                    $continuation.label = 1;
                    v0 = var10_15.hasNext((Continuation<Boolean>)$continuation);
                    if (v0 == var16_5) {
                        return var16_5;
                    }
                    ** GOTO lbl51
                    break;
                }
            }
            case 1: {
                $i$f$consumeEach = false;
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv = false;
                var10_15 = (ChannelIterator<E>)$continuation.L$2;
                cause$iv$iv = null;
                $this$consume$iv$iv = (ReceiveChannel)$continuation.L$1;
                destination = (Collection)$continuation.L$0;
                {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl51:
                    // 2 sources

                    if (((Boolean)v0).booleanValue()) {
                        it = e$iv = var10_15.next();
                        $i$a$-consumeEach-ChannelsKt__DeprecatedKt$toCollection$2 = false;
                        destination.add(it);
                        ** continue;
                    }
                    $this$consumeEach_u24lambda_u241$iv = Unit.INSTANCE;
                }
                ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                return destination;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object toMap(ReceiveChannel $this$toMap, Continuation $completion) {
        return ChannelsKt.toMap($this$toMap, (Map)new LinkedHashMap(), $completion);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @PublishedApi
    @Nullable
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(@NotNull ReceiveChannel<? extends Pair<? extends K, ? extends V>> var0, @NotNull M var1_1, @NotNull Continuation<? super M> var2_2) {
        if (!(var2_2 instanceof toMap.2)) ** GOTO lbl-1000
        var15_3 = var2_2;
        if ((var15_3.label & -2147483648) != 0) {
            var15_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var2_2){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.toMap(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var16_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$consumeEach$iv = $this$toMap;
                $i$f$consumeEach = false;
                $this$consume$iv$iv = $this$consumeEach$iv;
                $i$f$consume = false;
                cause$iv$iv = null;
                try {
                    $this$consumeEach_u24lambda_u241$iv = $this$consume$iv$iv;
                    $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv = false;
                    var10_15 = $this$consumeEach_u24lambda_u241$iv.iterator();
                }
                catch (Throwable e$iv$iv) {
                    try {
                        cause$iv$iv = e$iv$iv;
                        throw e$iv$iv;
                    }
                    catch (Throwable var8_13) {
                        ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                        throw var8_13;
                    }
                }
lbl31:
                // 2 sources

                while (true) {
                    $continuation.L$0 = destination;
                    $continuation.L$1 = $this$consume$iv$iv;
                    $continuation.L$2 = var10_15;
                    $continuation.label = 1;
                    v0 = var10_15.hasNext((Continuation<Boolean>)$continuation);
                    if (v0 == var16_5) {
                        return var16_5;
                    }
                    ** GOTO lbl51
                    break;
                }
            }
            case 1: {
                $i$f$consumeEach = false;
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv = false;
                var10_15 = (ChannelIterator<E>)$continuation.L$2;
                cause$iv$iv = null;
                $this$consume$iv$iv = (ReceiveChannel)$continuation.L$1;
                destination = (Map)$continuation.L$0;
                {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl51:
                    // 2 sources

                    if (((Boolean)v0).booleanValue()) {
                        e$iv = var10_15.next();
                        it = (Pair)e$iv;
                        $i$a$-consumeEach-ChannelsKt__DeprecatedKt$toMap$3 = false;
                        destination.put(it.getFirst(), it.getSecond());
                        ** continue;
                    }
                    $this$consumeEach_u24lambda_u241$iv = Unit.INSTANCE;
                }
                ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                return destination;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object toMutableList(ReceiveChannel $this$toMutableList, Continuation $completion) {
        return ChannelsKt.toCollection($this$toMutableList, (Collection)new ArrayList(), $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object toSet(ReceiveChannel $this$toSet, Continuation $completion) {
        return ChannelsKt.toMutableSet($this$toSet, $completion);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel flatMap(ReceiveChannel $this$flatMap, CoroutineContext context, Function2 transform2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, null, ChannelsKt.consumes($this$flatMap), new Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object>($this$flatMap, transform2, null){
            Object L$1;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ ReceiveChannel<E> $this_flatMap;
            final /* synthetic */ Function2<E, Continuation<? super ReceiveChannel<? extends R>>, Object> $transform;
            {
                this.$this_flatMap = $receiver;
                this.$transform = $transform;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var5_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$produce = (ProducerScope)this.L$0;
                        var3_4 = this.$this_flatMap.iterator();
lbl7:
                        // 2 sources

                        while (true) {
                            this.L$0 = $this$produce;
                            this.L$1 = var3_4;
                            this.label = 1;
                            v0 = var3_4.hasNext((Continuation<Boolean>)((Continuation)this));
                            if (v0 == var5_2) {
                                return var5_2;
                            }
                            ** GOTO lbl20
                            break;
                        }
                    }
                    case 1: {
                        var3_4 = (ChannelIterator<E>)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl20:
                        // 2 sources

                        if (!((Boolean)v0).booleanValue()) break;
                        e = var3_4.next();
                        this.L$0 = $this$produce;
                        this.L$1 = var3_4;
                        this.label = 2;
                        v1 = this.$transform.invoke(e, (Object)this);
                        if (v1 == var5_2) {
                            return var5_2;
                        }
                        ** GOTO lbl34
                    }
                    case 2: {
                        var3_4 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl34:
                        // 2 sources

                        this.L$0 = $this$produce;
                        this.L$1 = var3_4;
                        this.label = 3;
                        v2 = ChannelsKt.toChannel((ReceiveChannel)v1, (SendChannel)$this$produce, (Continuation)this);
                        if (v2 == var5_2) {
                            return var5_2;
                        }
                        ** GOTO lbl46
                    }
                    case 3: {
                        var3_4 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl46:
                        // 2 sources

                        ** continue;
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super R> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.flatMap(receiveChannel, coroutineContext, function2);
    }

    @PublishedApi
    @NotNull
    public static final <E, R> ReceiveChannel<R> map(@NotNull ReceiveChannel<? extends E> $this$map, @NotNull CoroutineContext context, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> transform2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, null, ChannelsKt.consumes($this$map), new Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object>($this$map, transform2, null){
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ ReceiveChannel<E> $this_map;
            final /* synthetic */ Function2<E, Continuation<? super R>, Object> $transform;
            {
                this.$this_map = $receiver;
                this.$transform = $transform;
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
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 13[UNCONDITIONALDOLOOP]
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
                Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super R> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.map(receiveChannel, coroutineContext, function2);
    }

    @PublishedApi
    @NotNull
    public static final <E, R> ReceiveChannel<R> mapIndexed(@NotNull ReceiveChannel<? extends E> $this$mapIndexed, @NotNull CoroutineContext context, @NotNull Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> transform2) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, null, ChannelsKt.consumes($this$mapIndexed), new Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object>($this$mapIndexed, transform2, null){
            Object L$1;
            Object L$2;
            int I$0;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ ReceiveChannel<E> $this_mapIndexed;
            final /* synthetic */ Function3<Integer, E, Continuation<? super R>, Object> $transform;
            {
                this.$this_mapIndexed = $receiver;
                this.$transform = $transform;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var7_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$produce = (ProducerScope)this.L$0;
                        index = 0;
                        var4_5 = this.$this_mapIndexed.iterator();
lbl8:
                        // 2 sources

                        while (true) {
                            this.L$0 = $this$produce;
                            this.L$1 = var4_5;
                            this.I$0 = index;
                            this.label = 1;
                            v0 = var4_5.hasNext((Continuation<Boolean>)((Continuation)this));
                            if (v0 == var7_2) {
                                return var7_2;
                            }
                            ** GOTO lbl23
                            break;
                        }
                    }
                    case 1: {
                        index = this.I$0;
                        var4_5 = (ChannelIterator<E>)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl23:
                        // 2 sources

                        if (!((Boolean)v0).booleanValue()) break;
                        e = var4_5.next();
                        var6_7 = $this$produce;
                        v1 = index++;
                        this.L$0 = $this$produce;
                        this.L$1 = var4_5;
                        this.L$2 = var6_7;
                        this.I$0 = index;
                        this.label = 2;
                        v2 = this.$transform.invoke((Object)Boxing.boxInt((int)v1), e, (Object)this);
                        if (v2 == var7_2) {
                            return var7_2;
                        }
                        ** GOTO lbl43
                    }
                    case 2: {
                        index = this.I$0;
                        var6_7 = (ProducerScope)this.L$2;
                        var4_5 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl43:
                        // 2 sources

                        this.L$0 = $this$produce;
                        this.L$1 = var4_5;
                        this.L$2 = null;
                        this.I$0 = index;
                        this.label = 3;
                        v3 = var6_7.send(v2, (Continuation<Unit>)((Continuation)this));
                        if (v3 == var7_2) {
                            return var7_2;
                        }
                        ** GOTO lbl58
                    }
                    case 3: {
                        index = this.I$0;
                        var4_5 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v3 = $result;
lbl58:
                        // 2 sources

                        ** continue;
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super R> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel mapIndexedNotNull(ReceiveChannel $this$mapIndexedNotNull, CoroutineContext context, Function3 transform2) {
        return ChannelsKt.filterNotNull(ChannelsKt.mapIndexed($this$mapIndexedNotNull, context, transform2));
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexedNotNull(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel mapNotNull(ReceiveChannel $this$mapNotNull, CoroutineContext context, Function2 transform2) {
        return ChannelsKt.filterNotNull(ChannelsKt.map($this$mapNotNull, context, transform2));
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapNotNull(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel withIndex(ReceiveChannel $this$withIndex, CoroutineContext context) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, null, ChannelsKt.consumes($this$withIndex), new Function2<ProducerScope<? super IndexedValue<? extends E>>, Continuation<? super Unit>, Object>($this$withIndex, null){
            Object L$1;
            int I$0;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ ReceiveChannel<E> $this_withIndex;
            {
                this.$this_withIndex = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var6_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$produce = (ProducerScope)this.L$0;
                        index = 0;
                        var4_5 = this.$this_withIndex.iterator();
lbl8:
                        // 2 sources

                        while (true) {
                            this.L$0 = $this$produce;
                            this.L$1 = var4_5;
                            this.I$0 = index;
                            this.label = 1;
                            v0 = var4_5.hasNext((Continuation<Boolean>)((Continuation)this));
                            if (v0 == var6_2) {
                                return var6_2;
                            }
                            ** GOTO lbl23
                            break;
                        }
                    }
                    case 1: {
                        index = this.I$0;
                        var4_5 = (ChannelIterator<E>)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl23:
                        // 2 sources

                        if (!((Boolean)v0).booleanValue()) break;
                        e = var4_5.next();
                        v1 = index++;
                        this.L$0 = $this$produce;
                        this.L$1 = var4_5;
                        this.I$0 = index;
                        this.label = 2;
                        v2 = $this$produce.send(new IndexedValue(v1, e), (Continuation<Unit>)((Continuation)this));
                        if (v2 == var6_2) {
                            return var6_2;
                        }
                        ** GOTO lbl40
                    }
                    case 2: {
                        index = this.I$0;
                        var4_5 = (ChannelIterator)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl40:
                        // 2 sources

                        ** continue;
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<ProducerScope<? super IndexedValue<? extends E>>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super IndexedValue<? extends E>> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.withIndex(receiveChannel, coroutineContext);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel distinct(ReceiveChannel $this$distinct) {
        return ChannelsKt.distinctBy$default($this$distinct, null, new Function2<E, Continuation<? super E>, Object>(null){
            int label;
            /* synthetic */ Object L$0;

            @Nullable
            public final Object invokeSuspend(@NotNull Object object) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        Object it = this.L$0;
                        return it;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<E, Continuation<? super E>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(E p1, @Nullable Continuation<? super E> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 1, null);
    }

    @PublishedApi
    @NotNull
    public static final <E, K> ReceiveChannel<E> distinctBy(@NotNull ReceiveChannel<? extends E> $this$distinctBy, @NotNull CoroutineContext context, @NotNull Function2<? super E, ? super Continuation<? super K>, ? extends Object> selector) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, null, ChannelsKt.consumes($this$distinctBy), new Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object>($this$distinctBy, selector, null){
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ ReceiveChannel<E> $this_distinctBy;
            final /* synthetic */ Function2<E, Continuation<? super K>, Object> $selector;
            {
                this.$this_distinctBy = $receiver;
                this.$selector = $selector;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var7_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$produce = (ProducerScope)this.L$0;
                        keys = new HashSet();
                        var4_5 = this.$this_distinctBy.iterator();
lbl8:
                        // 3 sources

                        while (true) {
                            this.L$0 = $this$produce;
                            this.L$1 = keys;
                            this.L$2 = var4_5;
                            this.L$3 = null;
                            this.label = 1;
                            v0 = var4_5.hasNext((Continuation<Boolean>)((Continuation)this));
                            if (v0 == var7_2) {
                                return var7_2;
                            }
                            ** GOTO lbl24
                            break;
                        }
                    }
                    case 1: {
                        var4_5 = (ChannelIterator<E>)this.L$2;
                        keys = (HashSet)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl24:
                        // 2 sources

                        if (!((Boolean)v0).booleanValue()) break;
                        e = var4_5.next();
                        this.L$0 = $this$produce;
                        this.L$1 = keys;
                        this.L$2 = var4_5;
                        this.L$3 = e;
                        this.label = 2;
                        v1 = this.$selector.invoke(e, (Object)this);
                        if (v1 == var7_2) {
                            return var7_2;
                        }
                        ** GOTO lbl42
                    }
                    case 2: {
                        e = this.L$3;
                        var4_5 = (ChannelIterator)this.L$2;
                        keys = (HashSet)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl42:
                        // 2 sources

                        if (keys.contains(k = v1)) ** GOTO lbl8
                        this.L$0 = $this$produce;
                        this.L$1 = keys;
                        this.L$2 = var4_5;
                        this.L$3 = k;
                        this.label = 3;
                        v2 = $this$produce.send(e, (Continuation<Unit>)((Continuation)this));
                        if (v2 == var7_2) {
                            return var7_2;
                        }
                        ** GOTO lbl59
                    }
                    case 3: {
                        k = this.L$3;
                        var4_5 = (ChannelIterator)this.L$2;
                        keys = (HashSet)this.L$1;
                        $this$produce = (ProducerScope)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl59:
                        // 2 sources

                        ((Collection)keys).add(k);
                        ** continue;
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super E> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    @PublishedApi
    @Nullable
    public static final <E> Object toMutableSet(@NotNull ReceiveChannel<? extends E> $this$toMutableSet, @NotNull Continuation<? super Set<E>> $completion) {
        return ChannelsKt.toCollection($this$toMutableSet, (Collection)new LinkedHashSet(), $completion);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object any(ReceiveChannel var0, Continuation var1_1) {
        if (!(var1_1 instanceof any.1)) ** GOTO lbl-1000
        var9_2 = var1_1;
        if ((var9_2.label & -2147483648) != 0) {
            var9_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl((Continuation<? super any.1>)var1_1){
                Object L$0;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.any(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var10_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$consume$iv = $this$any;
                $i$f$consume = false;
                cause$iv = null;
                $this$any_u24lambda_u2415 = $this$consume$iv;
                $i$a$-consume-ChannelsKt__DeprecatedKt$any$2 = false;
                $continuation.L$0 = $this$consume$iv;
                $continuation.label = 1;
                v0 = $this$any_u24lambda_u2415.iterator().hasNext((Continuation<Boolean>)$continuation);
                ** if (v0 != var10_4) goto lbl25
lbl24:
                // 1 sources

                return var10_4;
lbl25:
                // 1 sources

                ** GOTO lbl35
            }
            case 1: {
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__DeprecatedKt$any$2 = false;
                cause$iv = null;
                $this$consume$iv = (ReceiveChannel)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl35:
                    // 2 sources

                    var7_12 = v0;
                    return var7_12;
                }
                catch (Throwable e$iv) {
                    cause$iv = e$iv;
                    throw e$iv;
                }
            }
            catch (Throwable var5_10) {
                throw var5_10;
            }
            {
                finally {
                    ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                }
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object count(ReceiveChannel var0, Continuation var1_1) {
        if (!(var1_1 instanceof count.1)) ** GOTO lbl-1000
        var15_2 = var1_1;
        if ((var15_2.label & -2147483648) != 0) {
            var15_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl((Continuation<? super count.1>)var1_1){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.count(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var16_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                count = new Ref.IntRef();
                $this$consumeEach$iv = $this$count;
                $i$f$consumeEach = false;
                $this$consume$iv$iv = $this$consumeEach$iv;
                $i$f$consume = false;
                cause$iv$iv = null;
                try {
                    $this$consumeEach_u24lambda_u241$iv = $this$consume$iv$iv;
                    $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv = false;
                    var10_15 = $this$consumeEach_u24lambda_u241$iv.iterator();
                }
                catch (Throwable e$iv$iv) {
                    try {
                        cause$iv$iv = e$iv$iv;
                        throw e$iv$iv;
                    }
                    catch (Throwable var8_13) {
                        ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                        throw var8_13;
                    }
                }
lbl32:
                // 2 sources

                while (true) {
                    $continuation.L$0 = count;
                    $continuation.L$1 = $this$consume$iv$iv;
                    $continuation.L$2 = var10_15;
                    $continuation.label = 1;
                    v0 = var10_15.hasNext((Continuation<Boolean>)$continuation);
                    if (v0 == var16_4) {
                        return var16_4;
                    }
                    ** GOTO lbl52
                    break;
                }
            }
            case 1: {
                $i$f$consumeEach = false;
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__Channels_commonKt$consumeEach$2$iv = false;
                var10_15 = (ChannelIterator<E>)$continuation.L$2;
                cause$iv$iv = null;
                $this$consume$iv$iv = (ReceiveChannel)$continuation.L$1;
                count = (Ref.IntRef)$continuation.L$0;
                {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl52:
                    // 2 sources

                    if (((Boolean)v0).booleanValue()) {
                        e$iv = var10_15.next();
                        $i$a$-consumeEach-ChannelsKt__DeprecatedKt$count$2 = false;
                        var13_18 = count.element;
                        count.element = var13_18 + 1;
                        ** continue;
                    }
                    $this$consumeEach_u24lambda_u241$iv = Unit.INSTANCE;
                }
                ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                return Boxing.boxInt((int)count.element);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Exception decompiling
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object maxWith(ReceiveChannel var0, Comparator var1_1, Continuation var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 12[UNCONDITIONALDOLOOP]
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
     * Exception decompiling
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object minWith(ReceiveChannel var0, Comparator var1_1, Continuation var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 12[UNCONDITIONALDOLOOP]
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
     * Unable to fully structure code
     */
    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ Object none(ReceiveChannel var0, Continuation var1_1) {
        if (!(var1_1 instanceof none.1)) ** GOTO lbl-1000
        var9_2 = var1_1;
        if ((var9_2.label & -2147483648) != 0) {
            var9_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl((Continuation<? super none.1>)var1_1){
                Object L$0;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return ChannelsKt.none(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var10_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$consume$iv = $this$none;
                $i$f$consume = false;
                cause$iv = null;
                $this$none_u24lambda_u2419 = $this$consume$iv;
                $i$a$-consume-ChannelsKt__DeprecatedKt$none$2 = false;
                $continuation.L$0 = $this$consume$iv;
                $continuation.label = 1;
                v0 = $this$none_u24lambda_u2419.iterator().hasNext((Continuation<Boolean>)$continuation);
                ** if (v0 != var10_4) goto lbl25
lbl24:
                // 1 sources

                return var10_4;
lbl25:
                // 1 sources

                ** GOTO lbl35
            }
            case 1: {
                $i$f$consume = false;
                $i$a$-consume-ChannelsKt__DeprecatedKt$none$2 = false;
                cause$iv = null;
                $this$consume$iv = (ReceiveChannel)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl35:
                    // 2 sources

                    var7_14 = Boxing.boxBoolean((boolean)((Boolean)v0 == false));
                    return var7_14;
                }
                catch (Throwable e$iv) {
                    cause$iv = e$iv;
                    throw e$iv;
                }
            }
            catch (Throwable var5_11) {
                throw var5_11;
            }
            {
                finally {
                    ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                }
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Deprecated(message="Left for binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel requireNoNulls(ReceiveChannel $this$requireNoNulls) {
        return ChannelsKt.map$default($this$requireNoNulls, null, new Function2<E, Continuation<? super E>, Object>($this$requireNoNulls, null){
            int label;
            /* synthetic */ Object L$0;
            final /* synthetic */ ReceiveChannel<E> $this_requireNoNulls;
            {
                this.$this_requireNoNulls = $receiver;
                super(2, $completion);
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object object) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        Object it;
                        ResultKt.throwOnFailure((Object)object);
                        Object object2 = it = this.L$0;
                        if (object2 == null) {
                            throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + '.');
                        }
                        return object2;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<E, Continuation<? super E>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@Nullable E p1, @Nullable Continuation<? super E> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 1, null);
    }

    @Deprecated(message="Binary compatibility", level=DeprecationLevel.HIDDEN)
    public static final /* synthetic */ ReceiveChannel zip(ReceiveChannel $this$zip, ReceiveChannel other) {
        return ChannelsKt.zip$default($this$zip, other, null, zip.1.INSTANCE, 2, null);
    }

    @PublishedApi
    @NotNull
    public static final <E, R, V> ReceiveChannel<V> zip(@NotNull ReceiveChannel<? extends E> $this$zip, @NotNull ReceiveChannel<? extends R> other, @NotNull CoroutineContext context, @NotNull Function2<? super E, ? super R, ? extends V> transform2) {
        ReceiveChannel[] receiveChannelArray = new ReceiveChannel[]{$this$zip, other};
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, null, ChannelsKt.consumesAll(receiveChannelArray), new Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object>(other, $this$zip, transform2, null){
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ ReceiveChannel<R> $other;
            final /* synthetic */ ReceiveChannel<E> $this_zip;
            final /* synthetic */ Function2<E, R, V> $transform;
            {
                this.$other = $other;
                this.$this_zip = $receiver;
                this.$transform = $transform;
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
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 13[UNCONDITIONALDOLOOP]
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
                Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull ProducerScope<? super V> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }, 6, null);
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            coroutineContext = (CoroutineContext)Dispatchers.getUnconfined();
        }
        return ChannelsKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }

    @PublishedApi
    @NotNull
    public static final Function1<Throwable, Unit> consumes(@NotNull ReceiveChannel<?> $this$consumes) {
        return (Function1)new Function1<Throwable, Unit>($this$consumes){
            final /* synthetic */ ReceiveChannel<?> $this_consumes;
            {
                this.$this_consumes = $receiver;
                super(1);
            }

            public final void invoke(@Nullable Throwable cause) {
                ChannelsKt.cancelConsumed(this.$this_consumes, cause);
            }
        };
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.internal.LowPriorityInOverloadResolution
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.TypeIntrinsics
 *  kotlin.text.StringsKt
 */
package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannelKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelSegment;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveCatching;
import kotlinx.coroutines.channels.WaiterEB;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004\u00fd\u0001\u00fe\u0001B8\u0012\u0007\u0010\u00c7\u0001\u001a\u00020<\u0012$\b\u0002\u0010\u00e6\u0001\u001a\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u000105j\u000b\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00e5\u0001\u00a2\u0006\u0006\b\u00fb\u0001\u0010\u00fc\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\t\u0010\rJ\u001d\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f\u00a2\u0006\u0004\b\t\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0010\u00a2\u0006\u0004\b\u0011\u0010\rJ%\u0010\u0016\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0015\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\b\u00a2\u0006\u0004\b\u0018\u0010\nJ\u0019\u0010\u0019\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0004\b\u0019\u0010\rJ\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001c\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\u0005H\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u001e\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b#\u0010\nJ\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0003H\u0004\u00a2\u0006\u0004\b%\u0010 J\u000f\u0010&\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b&\u0010\nJ5\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00132\u0006\u0010'\u001a\u00020\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010)\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b*\u0010+J-\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00132\u0006\u0010'\u001a\u00020\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002\u00a2\u0006\u0004\b,\u0010-J-\u0010.\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00132\u0006\u0010'\u001a\u00020\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002\u00a2\u0006\u0004\b.\u0010-J\u000f\u00101\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b/\u00100J\u0019\u00103\u001a\u00020\b2\b\b\u0002\u00102\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b3\u0010 J\u000f\u00104\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b4\u0010\nJ4\u00109\u001a\u00020\b2#\u00108\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\b05H\u0016\u00a2\u0006\u0004\b9\u0010:J-\u0010?\u001a\u00020\u00052\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b?\u0010@J\u001f\u0010C\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\bC\u0010DJ\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000EH\u0096\u0002\u00a2\u0006\u0004\bF\u0010GJ\u001d\u0010H\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002\u00a2\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\bH\u0002\u00a2\u0006\u0004\bJ\u0010\nJ\u000f\u0010K\u001a\u00020\bH\u0002\u00a2\u0006\u0004\bK\u0010\nJ\u000f\u0010L\u001a\u00020\bH\u0002\u00a2\u0006\u0004\bL\u0010\nJ%\u0010M\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002\u00a2\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\bH\u0014\u00a2\u0006\u0004\bO\u0010\nJ&\u0010S\u001a\u00020\b2\u0012\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000Q0PH\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\bS\u0010TJ\u001d\u0010U\u001a\u00020\b2\f\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000PH\u0002\u00a2\u0006\u0004\bU\u0010TJ\u001b\u0010X\u001a\u00020\b2\n\u0010W\u001a\u0006\u0012\u0002\b\u00030VH\u0002\u00a2\u0006\u0004\bX\u0010YJ#\u0010[\u001a\u00020\b2\u0006\u0010Z\u001a\u00028\u00002\n\u0010W\u001a\u0006\u0012\u0002\b\u00030VH\u0002\u00a2\u0006\u0004\b[\u0010\\J\u001b\u0010]\u001a\u00020\b2\u0006\u0010Z\u001a\u00028\u0000H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b]\u0010^J%\u0010_\u001a\u00020\b2\u0006\u0010Z\u001a\u00028\u00002\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\b0PH\u0002\u00a2\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\bH\u0014\u00a2\u0006\u0004\ba\u0010\nJ\u000f\u0010b\u001a\u00020\bH\u0014\u00a2\u0006\u0004\bb\u0010\nJ%\u0010f\u001a\u0004\u0018\u00010c2\b\u0010d\u001a\u0004\u0018\u00010c2\b\u0010e\u001a\u0004\u0018\u00010cH\u0002\u00a2\u0006\u0004\bf\u0010gJ%\u0010h\u001a\u0004\u0018\u00010c2\b\u0010d\u001a\u0004\u0018\u00010c2\b\u0010e\u001a\u0004\u0018\u00010cH\u0002\u00a2\u0006\u0004\bh\u0010gJ%\u0010i\u001a\u0004\u0018\u00010c2\b\u0010d\u001a\u0004\u0018\u00010c2\b\u0010e\u001a\u0004\u0018\u00010cH\u0002\u00a2\u0006\u0004\bi\u0010gJ%\u0010j\u001a\u0004\u0018\u00010c2\b\u0010d\u001a\u0004\u0018\u00010c2\b\u0010e\u001a\u0004\u0018\u00010cH\u0002\u00a2\u0006\u0004\bj\u0010gJ\u0013\u0010k\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bk\u0010lJ\"\u0010n\u001a\b\u0012\u0004\u0012\u00028\u00000QH\u0096@\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\bm\u0010lJ@\u0010r\u001a\b\u0012\u0004\u0012\u00028\u00000Q2\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010=\u001a\u00020<2\u0006\u0010o\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\bp\u0010qJ\u00f9\u0001\u0010}\u001a\u00028\u0001\"\u0004\b\u0001\u0010s2\b\u0010t\u001a\u0004\u0018\u00010c2!\u0010u\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(Z\u0012\u0004\u0012\u00028\u0001052Q\u0010y\u001aM\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0013\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110<\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(o\u0012\u0004\u0012\u00028\u00010v2\f\u0010{\u001a\b\u0012\u0004\u0012\u00028\u00010z2S\b\u0002\u0010|\u001aM\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0013\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110<\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(o\u0012\u0004\u0012\u00028\u00010vH\u0082\b\u00a2\u0006\u0004\b}\u0010~Jj\u0010\u0080\u0001\u001a\u00020\b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010=\u001a\u00020<2\u0006\u0010o\u001a\u00020\u00032\u0006\u0010t\u001a\u00020\u007f2!\u0010u\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(Z\u0012\u0004\u0012\u00020\b052\f\u0010{\u001a\b\u0012\u0004\u0012\u00020\b0zH\u0082\b\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J3\u0010\u0082\u0001\u001a\u00028\u00002\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010=\u001a\u00020<2\u0006\u0010o\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0082\u0001\u0010qJ(\u0010\u0083\u0001\u001a\u00020\b2\n\u0010W\u001a\u0006\u0012\u0002\b\u00030V2\b\u0010d\u001a\u0004\u0018\u00010cH\u0002\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J(\u0010\u0085\u0001\u001a\u00020\b2\n\u0010W\u001a\u0006\u0012\u0002\b\u00030V2\b\u0010Z\u001a\u0004\u0018\u00010cH\u0014\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0084\u0001J \u0010\u0086\u0001\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001d\u0010\u0088\u0001\u001a\u00020\b2\u0006\u0010Z\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0088\u0001\u0010^J\u001d\u0010\u008a\u0001\u001a\u00020\u00052\u0006\u0010Z\u001a\u00028\u0000H\u0090@\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0089\u0001\u0010^J\u00f3\u0001\u0010\u008f\u0001\u001a\u00028\u0001\"\u0004\b\u0001\u0010s2\u0006\u0010Z\u001a\u00028\u00002\b\u0010t\u001a\u0004\u0018\u00010c2\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00028\u00010z2=\u0010y\u001a9\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0013\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110<\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(x\u0012\u0004\u0012\u00028\u00010\u008c\u00012\f\u0010{\u001a\b\u0012\u0004\u0012\u00028\u00010z2j\b\u0002\u0010|\u001ad\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0013\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110<\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(x\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(Z\u0012\u0014\u0012\u00120\u0003\u00a2\u0006\r\b6\u0012\t\b7\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00028\u00010\u008d\u0001H\u0084\b\u00a2\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J_\u0010\u0091\u0001\u001a\u00020\b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010=\u001a\u00020<2\u0006\u0010Z\u001a\u00028\u00002\u0007\u0010\u008e\u0001\u001a\u00020\u00032\u0006\u0010t\u001a\u00020\u007f2\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\b0z2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020\b0zH\u0082\b\u00a2\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J=\u0010\u0093\u0001\u001a\u00020\b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010=\u001a\u00020<2\u0006\u0010Z\u001a\u00028\u00002\u0007\u0010\u008e\u0001\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u0011\u0010\u0096\u0001\u001a\u00020\u0005H\u0010\u00a2\u0006\u0005\b\u0095\u0001\u00100J\u001a\u0010\u0096\u0001\u001a\u00020\u00052\u0007\u0010\u0097\u0001\u001a\u00020\u0003H\u0003\u00a2\u0006\u0005\b\u0096\u0001\u0010\u0007J\u0013\u0010\u0099\u0001\u001a\u00030\u0098\u0001H\u0016\u00a2\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u0013\u0010\u009c\u0001\u001a\u00030\u0098\u0001H\u0000\u00a2\u0006\u0006\b\u009b\u0001\u0010\u009a\u0001J!\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000QH\u0016\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J)\u0010\u00a2\u0001\u001a\b\u0012\u0004\u0012\u00020\b0Q2\u0006\u0010Z\u001a\u00028\u0000H\u0016\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0006\b\u00a0\u0001\u0010\u00a1\u0001J0\u0010\u00a4\u0001\u001a\u00020\u00052\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010=\u001a\u00020<2\u0007\u0010\u00a3\u0001\u001a\u00020\u0003H\u0002\u00a2\u0006\u0005\b\u00a4\u0001\u0010@J0\u0010\u00a5\u0001\u001a\u00020\u00052\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010=\u001a\u00020<2\u0007\u0010\u00a3\u0001\u001a\u00020\u0003H\u0002\u00a2\u0006\u0005\b\u00a5\u0001\u0010@J<\u0010\u00a6\u0001\u001a\u0004\u0018\u00010c2\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010=\u001a\u00020<2\u0006\u0010o\u001a\u00020\u00032\b\u0010t\u001a\u0004\u0018\u00010cH\u0002\u00a2\u0006\u0006\b\u00a6\u0001\u0010\u00a7\u0001J<\u0010\u00a8\u0001\u001a\u0004\u0018\u00010c2\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010=\u001a\u00020<2\u0006\u0010o\u001a\u00020\u00032\b\u0010t\u001a\u0004\u0018\u00010cH\u0002\u00a2\u0006\u0006\b\u00a8\u0001\u0010\u00a7\u0001JL\u0010\u00aa\u0001\u001a\u00020<2\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010=\u001a\u00020<2\u0006\u0010Z\u001a\u00028\u00002\u0007\u0010\u008e\u0001\u001a\u00020\u00032\b\u0010t\u001a\u0004\u0018\u00010c2\u0007\u0010\u00a9\u0001\u001a\u00020\u0005H\u0002\u00a2\u0006\u0006\b\u00aa\u0001\u0010\u00ab\u0001JL\u0010\u00ac\u0001\u001a\u00020<2\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010=\u001a\u00020<2\u0006\u0010Z\u001a\u00028\u00002\u0007\u0010\u008e\u0001\u001a\u00020\u00032\b\u0010t\u001a\u0004\u0018\u00010c2\u0007\u0010\u00a9\u0001\u001a\u00020\u0005H\u0002\u00a2\u0006\u0006\b\u00ac\u0001\u0010\u00ab\u0001J\u001a\u0010\u00ae\u0001\u001a\u00020\b2\u0007\u0010\u00ad\u0001\u001a\u00020\u0003H\u0002\u00a2\u0006\u0005\b\u00ae\u0001\u0010 J\u001a\u0010\u00af\u0001\u001a\u00020\b2\u0007\u0010\u00ad\u0001\u001a\u00020\u0003H\u0002\u00a2\u0006\u0005\b\u00af\u0001\u0010 J\u0019\u0010\u00b1\u0001\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u0003H\u0000\u00a2\u0006\u0005\b\u00b0\u0001\u0010 J,\u0010\u00b2\u0001\u001a\u00020\b*\u00020\u007f2\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010=\u001a\u00020<H\u0002\u00a2\u0006\u0006\b\u00b2\u0001\u0010\u00b3\u0001J,\u0010\u00b4\u0001\u001a\u00020\b*\u00020\u007f2\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010=\u001a\u00020<H\u0002\u00a2\u0006\u0006\b\u00b4\u0001\u0010\u00b3\u0001J\u0016\u0010\u00b5\u0001\u001a\u00020\b*\u00020\u007fH\u0002\u00a2\u0006\u0006\b\u00b5\u0001\u0010\u00b6\u0001J\u0016\u0010\u00b7\u0001\u001a\u00020\b*\u00020\u007fH\u0002\u00a2\u0006\u0006\b\u00b7\u0001\u0010\u00b6\u0001J\u001f\u0010\u00b9\u0001\u001a\u00020\b*\u00020\u007f2\u0007\u0010\u00b8\u0001\u001a\u00020\u0005H\u0002\u00a2\u0006\u0006\b\u00b9\u0001\u0010\u00ba\u0001J\u001e\u0010\u00bb\u0001\u001a\u00020\u0005*\u00020c2\u0006\u0010Z\u001a\u00028\u0000H\u0002\u00a2\u0006\u0006\b\u00bb\u0001\u0010\u00bc\u0001J,\u0010\u00bd\u0001\u001a\u00020\u0005*\u00020c2\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010=\u001a\u00020<H\u0002\u00a2\u0006\u0006\b\u00bd\u0001\u0010\u00be\u0001R\u0015\u0010\u00c0\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010c0\u00bf\u00018\u0002X\u0082\u0004R\r\u0010\u00c2\u0001\u001a\u00030\u00c1\u00018\u0002X\u0082\u0004R\u0017\u0010\u00c5\u0001\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00c3\u0001\u0010\u00c4\u0001R\u0019\u0010\u00c6\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u00bf\u00018\u0002X\u0082\u0004R\u0017\u0010\u00c7\u0001\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c7\u0001\u0010\u00c8\u0001R\u0019\u0010\u00cb\u0001\u001a\u0004\u0018\u00010\u000b8DX\u0084\u0004\u00a2\u0006\b\u001a\u0006\b\u00c9\u0001\u0010\u00ca\u0001R\u0015\u0010\u00cc\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010c0\u00bf\u00018\u0002X\u0082\u0004R\r\u0010\u00cd\u0001\u001a\u00030\u00c1\u00018\u0002X\u0082\u0004R\u001b\u0010B\u001a\u00020\u00058VX\u0097\u0004\u00a2\u0006\r\u0012\u0005\b\u00ce\u0001\u0010\n\u001a\u0004\bB\u00100R\u001d\u0010\u00cf\u0001\u001a\u00020\u00058VX\u0097\u0004\u00a2\u0006\u000e\u0012\u0005\b\u00d0\u0001\u0010\n\u001a\u0005\b\u00cf\u0001\u00100R\u0016\u0010\u00d1\u0001\u001a\u00020\u00058TX\u0094\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00d1\u0001\u00100R\u001d\u0010\u00d2\u0001\u001a\u00020\u00058VX\u0097\u0004\u00a2\u0006\u000e\u0012\u0005\b\u00d3\u0001\u0010\n\u001a\u0005\b\u00d2\u0001\u00100R\u0016\u0010\u00d4\u0001\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00d4\u0001\u00100R%\u0010\u00d9\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u00d5\u00018VX\u0096\u0004\u00a2\u0006\u000f\u0012\u0005\b\u00d8\u0001\u0010\n\u001a\u0006\b\u00d6\u0001\u0010\u00d7\u0001R.\u0010\u00dc\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000Q0\u00d5\u00018VX\u0096\u0004\u00f8\u0001\u0000\u00a2\u0006\u000f\u0012\u0005\b\u00db\u0001\u0010\n\u001a\u0006\b\u00da\u0001\u0010\u00d7\u0001R'\u0010\u00df\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00d5\u00018VX\u0096\u0004\u00a2\u0006\u000f\u0012\u0005\b\u00de\u0001\u0010\n\u001a\u0006\b\u00dd\u0001\u0010\u00d7\u0001R1\u0010\u00e4\u0001\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u00e0\u00018VX\u0096\u0004\u00a2\u0006\u000f\u0012\u0005\b\u00e3\u0001\u0010\n\u001a\u0006\b\u00e1\u0001\u0010\u00e2\u0001R2\u0010\u00e6\u0001\u001a\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u000105j\u000b\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00e5\u00018\u0000X\u0081\u0004\u00a2\u0006\b\n\u0006\b\u00e6\u0001\u0010\u00e7\u0001R\u0082\u0001\u0010\u00eb\u0001\u001af\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030V\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(W\u0012\u0016\u0012\u0014\u0018\u00010c\u00a2\u0006\r\b6\u0012\t\b7\u0012\u0005\b\b(\u00e8\u0001\u0012\u0016\u0012\u0014\u0018\u00010c\u00a2\u0006\r\b6\u0012\t\b7\u0012\u0005\b\b(\u00e9\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b05\u0018\u00010vj\u0005\u0018\u0001`\u00ea\u00018\u0002X\u0082\u0004\u00a2\u0006\u000f\n\u0006\b\u00eb\u0001\u0010\u00ec\u0001\u0012\u0005\b\u00ed\u0001\u0010\nR\u0017\u0010\u00ef\u0001\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00ee\u0001\u0010\u00ca\u0001R\u0019\u0010\u00f0\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u00bf\u00018\u0002X\u0082\u0004R\r\u0010\u00f1\u0001\u001a\u00030\u00c1\u00018\u0002X\u0082\u0004R\u0017\u0010\u00f3\u0001\u001a\u00020\u00038@X\u0080\u0004\u00a2\u0006\b\u001a\u0006\b\u00f2\u0001\u0010\u00c4\u0001R\u0017\u0010\u00f5\u0001\u001a\u00020\u000b8DX\u0084\u0004\u00a2\u0006\b\u001a\u0006\b\u00f4\u0001\u0010\u00ca\u0001R\u0019\u0010\u00f6\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u00bf\u00018\u0002X\u0082\u0004R\r\u0010\u00f7\u0001\u001a\u00030\u00c1\u00018\u0002X\u0082\u0004R\u0016\u0010\u0015\u001a\u00020\u00038@X\u0080\u0004\u00a2\u0006\b\u001a\u0006\b\u00f8\u0001\u0010\u00c4\u0001R\u001a\u0010\u00f9\u0001\u001a\u00020\u0005*\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00f9\u0001\u0010\u0007R\u001a\u0010\u00fa\u0001\u001a\u00020\u0005*\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00fa\u0001\u0010\u0007\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u00ff\u0001"}, d2={"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", "", "curSenders", "", "bufferOrRendezvousSend", "(J)Z", "", "cancel", "()V", "", "cause", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelImpl$kotlinx_coroutines_core", "cancelImpl", "Lkotlinx/coroutines/channels/ChannelSegment;", "lastSegment", "sendersCounter", "cancelSuspendedReceiveRequests", "(Lkotlinx/coroutines/channels/ChannelSegment;J)V", "checkSegmentStructureInvariants", "close", "closeLinkedList", "()Lkotlinx/coroutines/channels/ChannelSegment;", "closeOrCancelImpl", "(Ljava/lang/Throwable;Z)Z", "sendersCur", "completeCancel", "(J)V", "completeClose", "(J)Lkotlinx/coroutines/channels/ChannelSegment;", "completeCloseOrCancel", "globalCellIndex", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "expandBuffer", "id", "startFrom", "currentBufferEndCounter", "findSegmentBufferEnd", "(JLkotlinx/coroutines/channels/ChannelSegment;J)Lkotlinx/coroutines/channels/ChannelSegment;", "findSegmentReceive", "(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", "findSegmentSend", "hasElements$kotlinx_coroutines_core", "()Z", "hasElements", "nAttempts", "incCompletedExpandBufferAttempts", "invokeCloseHandler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "segment", "", "index", "globalIndex", "isCellNonEmpty", "(Lkotlinx/coroutines/channels/ChannelSegment;IJ)Z", "sendersAndCloseStatusCur", "isClosedForReceive", "isClosed", "(JZ)Z", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "markAllEmptyCellsAsClosed", "(Lkotlinx/coroutines/channels/ChannelSegment;)J", "markCancellationStarted", "markCancelled", "markClosed", "moveSegmentBufferEndToSpecifiedOrLast", "(JLkotlinx/coroutines/channels/ChannelSegment;)V", "onClosedIdempotent", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/channels/ChannelResult;", "cont", "onClosedReceiveCatchingOnNoWaiterSuspend", "(Lkotlinx/coroutines/CancellableContinuation;)V", "onClosedReceiveOnNoWaiterSuspend", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "onClosedSelectOnReceive", "(Lkotlinx/coroutines/selects/SelectInstance;)V", "element", "onClosedSelectOnSend", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "onClosedSend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedSendOnNoWaiterSuspend", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "onReceiveDequeued", "onReceiveEnqueued", "", "ignoredParam", "selectResult", "processResultSelectReceive", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "processResultSelectReceiveCatching", "processResultSelectReceiveOrNull", "processResultSelectSend", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching-JP2dKIU", "receiveCatching", "r", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatchingOnNoWaiterSuspend", "R", "waiter", "onElementRetrieved", "Lkotlin/Function3;", "segm", "i", "onSuspend", "Lkotlin/Function0;", "onClosed", "onNoWaiterSuspend", "receiveImpl", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlinx/coroutines/Waiter;", "receiveImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "receiveOnNoWaiterSuspend", "registerSelectForReceive", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "registerSelectForSend", "removeUnprocessedElements", "(Lkotlinx/coroutines/channels/ChannelSegment;)V", "send", "sendBroadcast$kotlinx_coroutines_core", "sendBroadcast", "onRendezvousOrBuffered", "Lkotlin/Function2;", "Lkotlin/Function4;", "s", "sendImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "sendImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "sendOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldSendSuspend$kotlinx_coroutines_core", "shouldSendSuspend", "curSendersAndCloseStatus", "", "toString", "()Ljava/lang/String;", "toStringDebug$kotlinx_coroutines_core", "toStringDebug", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryReceive", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "b", "updateCellExpandBuffer", "updateCellExpandBufferSlow", "updateCellReceive", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLjava/lang/Object;)Ljava/lang/Object;", "updateCellReceiveSlow", "closed", "updateCellSend", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "value", "updateReceiversCounterIfLower", "updateSendersCounterIfLower", "waitExpandBufferCompletion$kotlinx_coroutines_core", "waitExpandBufferCompletion", "prepareReceiverForSuspension", "(Lkotlinx/coroutines/Waiter;Lkotlinx/coroutines/channels/ChannelSegment;I)V", "prepareSenderForSuspension", "resumeReceiverOnClosedChannel", "(Lkotlinx/coroutines/Waiter;)V", "resumeSenderOnCancelledChannel", "receiver", "resumeWaiterOnClosedChannel", "(Lkotlinx/coroutines/Waiter;Z)V", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "tryResumeSender", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/ChannelSegment;I)Z", "Lkotlinx/atomicfu/AtomicRef;", "_closeCause", "Lkotlinx/atomicfu/AtomicLong;", "bufferEnd", "getBufferEndCounter", "()J", "bufferEndCounter", "bufferEndSegment", "capacity", "I", "getCloseCause", "()Ljava/lang/Throwable;", "closeCause", "closeHandler", "completedExpandBuffersAndPauseFlag", "isClosedForReceive$annotations", "isClosedForSend", "isClosedForSend$annotations", "isConflatedDropOldest", "isEmpty", "isEmpty$annotations", "isRendezvousOrUnlimited", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "onReceive", "getOnReceiveCatching", "getOnReceiveCatching$annotations", "onReceiveCatching", "getOnReceiveOrNull", "getOnReceiveOrNull$annotations", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "onSend", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "Lkotlin/jvm/functions/Function1;", "param", "internalResult", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onUndeliveredElementReceiveCancellationConstructor", "Lkotlin/jvm/functions/Function3;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "getReceiveException", "receiveException", "receiveSegment", "receivers", "getReceiversCounter$kotlinx_coroutines_core", "receiversCounter", "getSendException", "sendException", "sendSegment", "sendersAndCloseStatus", "getSendersCounter$kotlinx_coroutines_core", "isClosedForReceive0", "isClosedForSend0", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "BufferedChannelIterator", "SendBroadcast", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 7 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n+ 8 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 9 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 10 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 11 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,3055:1\n273#1,6:3058\n280#1,68:3065\n374#1,18:3156\n244#1:3174\n269#1,10:3175\n280#1,48:3186\n395#1:3234\n334#1,14:3235\n399#1,3:3250\n244#1:3263\n269#1,10:3264\n280#1,68:3275\n244#1:3353\n269#1,10:3354\n280#1,68:3365\n244#1:3437\n269#1,10:3438\n280#1,68:3449\n886#1,52:3519\n964#1,8:3575\n858#1:3583\n882#1,33:3584\n974#1:3617\n916#1,14:3618\n935#1,3:3633\n979#1,6:3636\n886#1,52:3650\n964#1,8:3706\n858#1:3714\n882#1,33:3715\n974#1:3748\n916#1,14:3749\n935#1,3:3764\n979#1,6:3767\n858#1:3782\n882#1,48:3783\n935#1,3:3832\n858#1:3835\n882#1,48:3836\n935#1,3:3885\n244#1:3897\n269#1,10:3898\n280#1,68:3909\n858#1:3978\n882#1,48:3979\n935#1,3:4028\n1#2:3056\n3038#3:3057\n3038#3:3064\n3038#3:3185\n3038#3:3274\n3038#3:3364\n3038#3:3436\n3038#3:3448\n3038#3:3518\n3038#3:3781\n3038#3:3888\n3038#3:3889\n3052#3:3890\n3052#3:3891\n3051#3:3892\n3051#3:3893\n3051#3:3894\n3052#3:3895\n3051#3:3896\n3038#3:3908\n3039#3:4031\n3038#3:4032\n3038#3:4033\n3038#3:4034\n3039#3:4035\n3038#3:4036\n3039#3:4059\n3038#3:4060\n3038#3:4061\n3039#3:4062\n3038#3:4112\n3039#3:4113\n3039#3:4114\n3039#3:4132\n3039#3:4133\n314#4,9:3133\n323#4,2:3150\n332#4,4:3152\n336#4,8:3253\n314#4,9:3344\n323#4,2:3434\n332#4,4:3571\n336#4,8:3642\n332#4,4:3702\n336#4,8:3773\n220#5:3142\n221#5:3145\n220#5:3146\n221#5:3149\n61#6,2:3143\n61#6,2:3147\n61#6,2:3261\n269#7:3249\n269#7:3343\n269#7:3433\n269#7:3517\n269#7:3977\n882#8:3632\n882#8:3763\n882#8:3831\n882#8:3884\n882#8:4027\n37#9,11:4037\n37#9,11:4048\n72#10,3:4063\n46#10,8:4066\n72#10,3:4074\n46#10,8:4077\n46#10,8:4085\n72#10,3:4093\n46#10,8:4096\n46#10,8:4104\n766#11:4115\n857#11,2:4116\n2310#11,14:4118\n766#11:4134\n857#11,2:4135\n2310#11,14:4137\n766#11:4151\n857#11,2:4152\n2310#11,14:4154\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n*L\n113#1:3058,6\n113#1:3065,68\n154#1:3156,18\n154#1:3174\n154#1:3175,10\n154#1:3186,48\n154#1:3234\n154#1:3235,14\n154#1:3250,3\n194#1:3263\n194#1:3264,10\n194#1:3275,68\n225#1:3353\n225#1:3354,10\n225#1:3365,68\n391#1:3437\n391#1:3438,10\n391#1:3449,68\n667#1:3519,52\n696#1:3575,8\n696#1:3583\n696#1:3584,33\n696#1:3617\n696#1:3618,14\n696#1:3633,3\n696#1:3636,6\n732#1:3650,52\n748#1:3706,8\n748#1:3714\n748#1:3715,33\n748#1:3748\n748#1:3749,14\n748#1:3764,3\n748#1:3767,6\n781#1:3782\n781#1:3783,48\n781#1:3832,3\n971#1:3835\n971#1:3836,48\n971#1:3885,3\n1464#1:3897\n1464#1:3898,10\n1464#1:3909,68\n1512#1:3978\n1512#1:3979,48\n1512#1:4028,3\n70#1:3057\n113#1:3064\n154#1:3185\n194#1:3274\n225#1:3364\n278#1:3436\n391#1:3448\n606#1:3518\n771#1:3781\n1007#1:3888\n1056#1:3889\n1374#1:3890\n1376#1:3891\n1406#1:3892\n1416#1:3893\n1425#1:3894\n1426#1:3895\n1433#1:3896\n1464#1:3908\n1865#1:4031\n1867#1:4032\n1869#1:4033\n1882#1:4034\n1893#1:4035\n1894#1:4036\n2196#1:4059\n2209#1:4060\n2219#1:4061\n2222#1:4062\n2539#1:4112\n2541#1:4113\n2566#1:4114\n2628#1:4132\n2629#1:4133\n134#1:3133,9\n134#1:3150,2\n153#1:3152,4\n153#1:3253,8\n221#1:3344,9\n221#1:3434,2\n695#1:3571,4\n695#1:3642,8\n746#1:3702,4\n746#1:3773,8\n138#1:3142\n138#1:3145\n141#1:3146\n141#1:3149\n138#1:3143,2\n141#1:3147,2\n183#1:3261,2\n154#1:3249\n194#1:3343\n225#1:3433\n391#1:3517\n1464#1:3977\n696#1:3632\n748#1:3763\n781#1:3831\n971#1:3884\n1512#1:4027\n2098#1:4037,11\n2153#1:4048,11\n2361#1:4063,3\n2361#1:4066,8\n2416#1:4074,3\n2416#1:4077,8\n2435#1:4085,8\n2465#1:4093,3\n2465#1:4096,8\n2526#1:4104,8\n2575#1:4115\n2575#1:4116,2\n2576#1:4118,14\n2640#1:4134\n2640#1:4135,2\n2641#1:4137,14\n2681#1:4151\n2681#1:4152,2\n2682#1:4154,14\n*E\n"})
public class BufferedChannel<E>
implements Channel<E> {
    private final int capacity;
    @JvmField
    @Nullable
    public final Function1<E, Unit> onUndeliveredElement;
    @Volatile
    private volatile long sendersAndCloseStatus;
    @Volatile
    private volatile long receivers;
    @Volatile
    private volatile long bufferEnd;
    @Volatile
    private volatile long completedExpandBuffersAndPauseFlag;
    @Volatile
    @Nullable
    private volatile Object sendSegment;
    @Volatile
    @Nullable
    private volatile Object receiveSegment;
    @Volatile
    @Nullable
    private volatile Object bufferEndSegment;
    @Nullable
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onUndeliveredElementReceiveCancellationConstructor;
    @Volatile
    @Nullable
    private volatile Object _closeCause;
    @Volatile
    @Nullable
    private volatile Object closeHandler;
    @NotNull
    private static final AtomicLongFieldUpdater sendersAndCloseStatus$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus");
    @NotNull
    private static final AtomicLongFieldUpdater receivers$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers");
    @NotNull
    private static final AtomicLongFieldUpdater bufferEnd$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd");
    @NotNull
    private static final AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag");
    @NotNull
    private static final AtomicReferenceFieldUpdater sendSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment");
    @NotNull
    private static final AtomicReferenceFieldUpdater receiveSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment");
    @NotNull
    private static final AtomicReferenceFieldUpdater bufferEndSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment");
    @NotNull
    private static final AtomicReferenceFieldUpdater _closeCause$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause");
    @NotNull
    private static final AtomicReferenceFieldUpdater closeHandler$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler");

    public BufferedChannel(int capacity, @Nullable Function1<? super E, Unit> onUndeliveredElement) {
        Function3 function3;
        ChannelSegment channelSegment;
        ChannelSegment firstSegment;
        this.capacity = capacity;
        this.onUndeliveredElement = onUndeliveredElement;
        if (!(this.capacity >= 0)) {
            boolean bl = false;
            String string = "Invalid channel capacity: " + this.capacity + ", should be >=0";
            throw new IllegalArgumentException(string.toString());
        }
        this.bufferEnd = BufferedChannelKt.access$initialBufferEnd(this.capacity);
        this.completedExpandBuffersAndPauseFlag = this.getBufferEndCounter();
        this.sendSegment = firstSegment = new ChannelSegment(0L, null, this, 3);
        this.receiveSegment = firstSegment;
        if (this.isRendezvousOrUnlimited()) {
            ChannelSegment channelSegment2 = BufferedChannelKt.access$getNULL_SEGMENT$p();
            channelSegment = channelSegment2;
            Intrinsics.checkNotNull((Object)channelSegment2, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        } else {
            channelSegment = firstSegment;
        }
        this.bufferEndSegment = channelSegment;
        BufferedChannel bufferedChannel = this;
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            Function1<E, Unit> function12 = function1;
            BufferedChannel bufferedChannel2 = bufferedChannel;
            boolean bl = false;
            function3 = new Function3<SelectInstance<?>, Object, Object, Function1<? super Throwable, ? extends Unit>>(this){
                final /* synthetic */ BufferedChannel<E> this$0;
                {
                    this.this$0 = $receiver;
                    super(3);
                }

                @NotNull
                public final Function1<Throwable, Unit> invoke(@NotNull SelectInstance<?> select, @Nullable Object object, @Nullable Object element) {
                    return (Function1)new Function1<Throwable, Unit>(element, this.this$0, select){
                        final /* synthetic */ Object $element;
                        final /* synthetic */ BufferedChannel<E> this$0;
                        final /* synthetic */ SelectInstance<?> $select;
                        {
                            this.$element = $element;
                            this.this$0 = $receiver;
                            this.$select = $select;
                            super(1);
                        }

                        public final void invoke(@NotNull Throwable it) {
                            if (this.$element != BufferedChannelKt.getCHANNEL_CLOSED()) {
                                OnUndeliveredElementKt.callUndeliveredElement(this.this$0.onUndeliveredElement, this.$element, this.$select.getContext());
                            }
                        }
                    };
                }
            };
            bufferedChannel = bufferedChannel2;
        } else {
            function3 = null;
        }
        bufferedChannel.onUndeliveredElementReceiveCancellationConstructor = function3;
        this._closeCause = BufferedChannelKt.access$getNO_CLOSE_CAUSE$p();
    }

    public /* synthetic */ BufferedChannel(int n2, Function1 function1, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 2) != 0) {
            function1 = null;
        }
        this(n2, function1);
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        long $this$sendersCounter$iv = sendersAndCloseStatus$FU.get(this);
        boolean $i$f$getSendersCounter = false;
        return $this$sendersCounter$iv & 0xFFFFFFFFFFFFFFFL;
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return receivers$FU.get(this);
    }

    private final long getBufferEndCounter() {
        return bufferEnd$FU.get(this);
    }

    private final boolean isRendezvousOrUnlimited() {
        long it = this.getBufferEndCounter();
        boolean bl = false;
        return it == 0L || it == Long.MAX_VALUE;
    }

    @Override
    @Nullable
    public Object send(E element, @NotNull Continuation<? super Unit> $completion) {
        return BufferedChannel.send$suspendImpl(this, element, $completion);
    }

    /*
     * WARNING - void declaration
     */
    static /* synthetic */ <E> Object send$suspendImpl(BufferedChannel<E> $this, E element, Continuation<? super Unit> $completion) {
        void this_$iv;
        BufferedChannel<E> bufferedChannel = $this;
        Object var4_4 = null;
        boolean $i$f$sendImpl = false;
        ChannelSegment segment$iv = (ChannelSegment)BufferedChannel.sendSegment$FU.get(this_$iv);
        block8: while (true) {
            void waiter$iv;
            long sendersAndCloseStatusCur$iv;
            long $this$sendersCounter$iv$iv = sendersAndCloseStatusCur$iv = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(this_$iv);
            boolean $i$f$getSendersCounter = false;
            long s$iv = $this$sendersCounter$iv$iv & 0xFFFFFFFFFFFFFFFL;
            boolean closed$iv = ((BufferedChannel)this_$iv).isClosedForSend0(sendersAndCloseStatusCur$iv);
            long id$iv = s$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
            int i$iv = (int)(s$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (segment$iv.id != id$iv && ((BufferedChannel)this_$iv).findSegmentSend(id$iv, segment$iv) == null) {
                if (!closed$iv) continue;
                boolean bl = false;
                Object object = super.onClosedSend(element, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                break;
            }
            switch (((BufferedChannel)this_$iv).updateCellSend(segment$iv, i$iv, element, s$iv, waiter$iv, closed$iv)) {
                case 0: {
                    segment$iv.cleanPrev();
                    boolean bl = false;
                    break block8;
                }
                case 1: {
                    boolean bl = false;
                    break block8;
                }
                case 2: {
                    if (closed$iv) {
                        segment$iv.onSlotCleaned();
                        boolean bl = false;
                        Object object = super.onClosedSend(element, $completion);
                        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            return object;
                        }
                        break block8;
                    }
                    boolean bl = false;
                    if (!DebugKt.getASSERTIONS_ENABLED()) break block8;
                    boolean bl2 = false;
                    if (!false) {
                        throw new AssertionError();
                    }
                    break block8;
                }
                case 4: {
                    if (s$iv < this_$iv.getReceiversCounter$kotlinx_coroutines_core()) {
                        segment$iv.cleanPrev();
                    }
                    boolean bl = false;
                    Object object = super.onClosedSend(element, $completion);
                    if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return object;
                    }
                    break block8;
                }
                case 5: {
                    segment$iv.cleanPrev();
                    continue block8;
                }
                case 3: {
                    void s;
                    void elem;
                    void i2;
                    long l2 = s$iv;
                    E bl = element;
                    int n2 = i$iv;
                    ChannelSegment segm = segment$iv;
                    boolean bl3 = false;
                    Object object = super.sendOnNoWaiterSuspend(segm, (int)i2, elem, (long)s, $completion);
                    if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return object;
                    }
                    break block8;
                }
                default: {
                    continue block8;
                }
            }
            break;
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private final Object onClosedSend(E element, Continuation<? super Unit> $completion) {
        boolean $i$f$suspendCancellableCoroutine = false;
        Continuation<? super Unit> uCont$iv = $completion;
        boolean bl = false;
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
        cancellable$iv.initCancellability();
        CancellableContinuation continuation = cancellable$iv;
        boolean bl2 = false;
        Object object = this.onUndeliveredElement;
        if (object != null && (object = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(object, element, null, 2, null)) != null) {
            Object it = object;
            boolean bl3 = false;
            ExceptionsKt.addSuppressed((Throwable)((Throwable)it), (Throwable)this.getSendException());
            Continuation $this$resumeWithStackTrace$iv = continuation;
            boolean $i$f$resumeWithStackTrace = false;
            boolean $i$f$recoverStackTrace = false;
            $this$resumeWithStackTrace$iv.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)(!DebugKt.getRECOVER_STACK_TRACES() || !($this$resumeWithStackTrace$iv instanceof CoroutineStackFrame) ? (Throwable)it : StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)it, (CoroutineStackFrame)$this$resumeWithStackTrace$iv)))));
        } else {
            void $this$resumeWithStackTrace$iv;
            Continuation continuation2 = continuation;
            Throwable exception$iv = this.getSendException();
            boolean $i$f$resumeWithStackTrace = false;
            boolean $i$f$recoverStackTrace = false;
            $this$resumeWithStackTrace$iv.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)(!DebugKt.getRECOVER_STACK_TRACES() || !($this$resumeWithStackTrace$iv instanceof CoroutineStackFrame) ? exception$iv : StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv, (CoroutineStackFrame)$this$resumeWithStackTrace$iv)))));
        }
        Object object2 = cancellable$iv.getResult();
        if (object2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (object2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object2;
        }
        return Unit.INSTANCE;
    }

    private final Object sendOnNoWaiterSuspend(ChannelSegment<E> segment, int index, E element, long s, Continuation<? super Unit> $completion) {
        boolean $i$f$suspendCancellableCoroutineReusable = false;
        Continuation<? super Unit> uCont$iv = $completion;
        boolean bl = false;
        CancellableContinuationImpl cancellable$iv = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(uCont$iv));
        try {
            CancellableContinuationImpl cont = cancellable$iv;
            boolean bl2 = false;
            BufferedChannel this_$iv = this;
            boolean $i$f$sendImplOnNoWaiter = false;
            block1 : switch (this_$iv.updateCellSend(segment, index, element, s, cont, false)) {
                case 0: {
                    segment.cleanPrev();
                    boolean bl3 = false;
                    ((Continuation)cont).resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
                    break;
                }
                case 1: {
                    boolean bl4 = false;
                    ((Continuation)cont).resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
                    break;
                }
                case 2: {
                    this_$iv.prepareSenderForSuspension(cont, segment, index);
                    break;
                }
                case 4: {
                    if (s < this_$iv.getReceiversCounter$kotlinx_coroutines_core()) {
                        segment.cleanPrev();
                    }
                    boolean bl5 = false;
                    this.onClosedSendOnNoWaiterSuspend(element, cont);
                    break;
                }
                case 5: {
                    segment.cleanPrev();
                    boolean $i$f$sendImpl = false;
                    ChannelSegment segment$iv$iv = (ChannelSegment)BufferedChannel.sendSegment$FU.get(this_$iv);
                    block17: while (true) {
                        long sendersAndCloseStatusCur$iv$iv;
                        long $this$sendersCounter$iv$iv$iv = sendersAndCloseStatusCur$iv$iv = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(this_$iv);
                        boolean $i$f$getSendersCounter = false;
                        long s$iv$iv = $this$sendersCounter$iv$iv$iv & 0xFFFFFFFFFFFFFFFL;
                        boolean closed$iv$iv = this_$iv.isClosedForSend0(sendersAndCloseStatusCur$iv$iv);
                        long id$iv$iv = s$iv$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
                        int i$iv$iv = (int)(s$iv$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
                        if (segment$iv$iv.id != id$iv$iv && this_$iv.findSegmentSend(id$iv$iv, segment$iv$iv) == null) {
                            if (!closed$iv$iv) continue;
                            boolean bl6 = false;
                            this.onClosedSendOnNoWaiterSuspend(element, cont);
                            break block1;
                        }
                        switch (this_$iv.updateCellSend(segment$iv$iv, i$iv$iv, element, s$iv$iv, cont, closed$iv$iv)) {
                            case 0: {
                                segment$iv$iv.cleanPrev();
                                boolean bl7 = false;
                                ((Continuation)cont).resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
                                break block1;
                            }
                            case 1: {
                                boolean bl8 = false;
                                ((Continuation)cont).resumeWith(Result.constructor-impl((Object)Unit.INSTANCE));
                                break block1;
                            }
                            case 2: {
                                if (closed$iv$iv) {
                                    segment$iv$iv.onSlotCleaned();
                                    boolean bl9 = false;
                                    this.onClosedSendOnNoWaiterSuspend(element, cont);
                                    break block1;
                                }
                                Waiter waiter = (Waiter)cont instanceof Waiter ? (Waiter)cont : null;
                                if (waiter != null) {
                                    this_$iv.prepareSenderForSuspension(waiter, segment$iv$iv, i$iv$iv);
                                }
                                boolean bl10 = false;
                                break block1;
                            }
                            case 4: {
                                if (s$iv$iv < this_$iv.getReceiversCounter$kotlinx_coroutines_core()) {
                                    segment$iv$iv.cleanPrev();
                                }
                                boolean bl11 = false;
                                this.onClosedSendOnNoWaiterSuspend(element, cont);
                                break block1;
                            }
                            case 5: {
                                segment$iv$iv.cleanPrev();
                                continue block17;
                            }
                            case 3: {
                                E e2 = element;
                                int n2 = i$iv$iv;
                                ChannelSegment channelSegment = segment$iv$iv;
                                boolean bl12 = false;
                                throw new IllegalStateException("unexpected".toString());
                            }
                        }
                    }
                }
                default: {
                    throw new IllegalStateException("unexpected".toString());
                }
            }
        }
        catch (Throwable e$iv) {
            cancellable$iv.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw e$iv;
        }
        Object object = cancellable$iv.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final void prepareSenderForSuspension(Waiter $this$prepareSenderForSuspension, ChannelSegment<E> segment, int index) {
        $this$prepareSenderForSuspension.invokeOnCancellation((Segment)segment, index + BufferedChannelKt.SEGMENT_SIZE);
    }

    private final void onClosedSendOnNoWaiterSuspend(E element, CancellableContinuation<? super Unit> cont) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, element, cont.getContext());
        }
        Continuation continuation = cont;
        Throwable exception$iv = this.getSendException();
        boolean $i$f$recoverStackTrace = false;
        Throwable throwable = !DebugKt.getRECOVER_STACK_TRACES() || !((Continuation)cont instanceof CoroutineStackFrame) ? exception$iv : StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv, (CoroutineStackFrame)cont);
        continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable)));
    }

    @Override
    @NotNull
    public Object trySend-JP2dKIU(E element) {
        Object object;
        if (this.shouldSendSuspend(sendersAndCloseStatus$FU.get(this))) {
            return ChannelResult.Companion.failure-PtdJZtk();
        }
        Symbol waiter$iv = BufferedChannelKt.access$getINTERRUPTED_SEND$p();
        boolean $i$f$sendImpl = false;
        ChannelSegment segment$iv = (ChannelSegment)BufferedChannel.sendSegment$FU.get(this);
        block8: while (true) {
            long sendersAndCloseStatusCur$iv;
            long $this$sendersCounter$iv$iv = sendersAndCloseStatusCur$iv = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(this);
            boolean $i$f$getSendersCounter = false;
            long s$iv = $this$sendersCounter$iv$iv & 0xFFFFFFFFFFFFFFFL;
            boolean closed$iv = this.isClosedForSend0(sendersAndCloseStatusCur$iv);
            long id$iv = s$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
            int i$iv = (int)(s$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (segment$iv.id != id$iv && this.findSegmentSend(id$iv, segment$iv) == null) {
                if (!closed$iv) continue;
                boolean bl = false;
                object = ChannelResult.Companion.closed-JP2dKIU(this.getSendException());
                break;
            }
            switch (this.updateCellSend(segment$iv, i$iv, element, s$iv, waiter$iv, closed$iv)) {
                case 0: {
                    segment$iv.cleanPrev();
                    boolean bl = false;
                    object = ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
                    break block8;
                }
                case 1: {
                    boolean bl = false;
                    object = ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
                    break block8;
                }
                case 2: {
                    if (closed$iv) {
                        segment$iv.onSlotCleaned();
                        boolean bl = false;
                        object = ChannelResult.Companion.closed-JP2dKIU(this.getSendException());
                        break block8;
                    }
                    Waiter waiter = waiter$iv instanceof Waiter ? (Waiter)((Object)waiter$iv) : null;
                    if (waiter != null) {
                        this.prepareSenderForSuspension(waiter, segment$iv, i$iv);
                    }
                    ChannelSegment segm = segment$iv;
                    boolean bl = false;
                    segm.onSlotCleaned();
                    object = ChannelResult.Companion.failure-PtdJZtk();
                    break block8;
                }
                case 4: {
                    if (s$iv < this.getReceiversCounter$kotlinx_coroutines_core()) {
                        segment$iv.cleanPrev();
                    }
                    boolean bl = false;
                    object = ChannelResult.Companion.closed-JP2dKIU(this.getSendException());
                    break block8;
                }
                case 5: {
                    segment$iv.cleanPrev();
                    continue block8;
                }
                case 3: {
                    E e2 = element;
                    int n2 = i$iv;
                    ChannelSegment channelSegment = segment$iv;
                    boolean bl = false;
                    throw new IllegalStateException("unexpected".toString());
                }
                default: {
                    continue block8;
                }
            }
            break;
        }
        return object;
    }

    @Nullable
    public Object sendBroadcast$kotlinx_coroutines_core(E element, @NotNull Continuation<? super Boolean> $completion) {
        return BufferedChannel.sendBroadcast$suspendImpl(this, element, $completion);
    }

    /*
     * WARNING - void declaration
     */
    static /* synthetic */ <E> Object sendBroadcast$suspendImpl(BufferedChannel<E> $this, E element, Continuation<? super Boolean> $completion) {
        boolean $i$f$suspendCancellableCoroutine = false;
        Continuation<? super Boolean> uCont$iv = $completion;
        boolean bl = false;
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
        cancellable$iv.initCancellability();
        CancellableContinuation cont = cancellable$iv;
        boolean bl2 = false;
        if (!($this.onUndeliveredElement == null)) {
            boolean bl3 = false;
            String string = "the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`";
            throw new IllegalStateException(string.toString());
        }
        SendBroadcast sendBroadcast = new SendBroadcast(cont);
        boolean $i$f$sendImpl = false;
        ChannelSegment segment$iv = (ChannelSegment)BufferedChannel.sendSegment$FU.get($this);
        block8: while (true) {
            void waiter$iv;
            long sendersAndCloseStatusCur$iv;
            long $this$sendersCounter$iv$iv = sendersAndCloseStatusCur$iv = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement($this);
            boolean $i$f$getSendersCounter = false;
            long s$iv = $this$sendersCounter$iv$iv & 0xFFFFFFFFFFFFFFFL;
            boolean closed$iv = ((BufferedChannel)$this).isClosedForSend0(sendersAndCloseStatusCur$iv);
            long id$iv = s$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
            int i$iv = (int)(s$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (segment$iv.id != id$iv && ((BufferedChannel)$this).findSegmentSend(id$iv, segment$iv) == null) {
                if (!closed$iv) continue;
                boolean bl4 = false;
                ((Continuation)cont).resumeWith(Result.constructor-impl((Object)Boxing.boxBoolean((boolean)false)));
                break;
            }
            switch (((BufferedChannel)$this).updateCellSend(segment$iv, i$iv, element, s$iv, waiter$iv, closed$iv)) {
                case 0: {
                    segment$iv.cleanPrev();
                    boolean bl5 = false;
                    ((Continuation)cont).resumeWith(Result.constructor-impl((Object)Boxing.boxBoolean((boolean)true)));
                    break block8;
                }
                case 1: {
                    boolean bl6 = false;
                    ((Continuation)cont).resumeWith(Result.constructor-impl((Object)Boxing.boxBoolean((boolean)true)));
                    break block8;
                }
                case 2: {
                    if (closed$iv) {
                        segment$iv.onSlotCleaned();
                        boolean bl7 = false;
                        ((Continuation)cont).resumeWith(Result.constructor-impl((Object)Boxing.boxBoolean((boolean)false)));
                        break block8;
                    }
                    Waiter waiter = waiter$iv instanceof Waiter ? (Waiter)waiter$iv : null;
                    if (waiter != null) {
                        ((BufferedChannel)$this).prepareSenderForSuspension(waiter, segment$iv, i$iv);
                    }
                    boolean bl8 = false;
                    break block8;
                }
                case 4: {
                    if (s$iv < $this.getReceiversCounter$kotlinx_coroutines_core()) {
                        segment$iv.cleanPrev();
                    }
                    boolean bl9 = false;
                    ((Continuation)cont).resumeWith(Result.constructor-impl((Object)Boxing.boxBoolean((boolean)false)));
                    break block8;
                }
                case 5: {
                    segment$iv.cleanPrev();
                    break;
                }
                case 3: {
                    E e2 = element;
                    int n2 = i$iv;
                    ChannelSegment channelSegment = segment$iv;
                    boolean bl10 = false;
                    throw new IllegalStateException("unexpected".toString());
                }
            }
        }
        Object object = cancellable$iv.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    protected final <R> R sendImpl(E element, @Nullable Object waiter, @NotNull Function0<? extends R> onRendezvousOrBuffered, @NotNull Function2<? super ChannelSegment<E>, ? super Integer, ? extends R> onSuspend, @NotNull Function0<? extends R> onClosed, @NotNull Function4<? super ChannelSegment<E>, ? super Integer, ? super E, ? super Long, ? extends R> onNoWaiterSuspend) {
        boolean $i$f$sendImpl = false;
        ChannelSegment segment = (ChannelSegment)BufferedChannel.sendSegment$FU.get(this);
        block8: while (true) {
            long sendersAndCloseStatusCur;
            long $this$sendersCounter$iv = sendersAndCloseStatusCur = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(this);
            boolean $i$f$getSendersCounter = false;
            long s = $this$sendersCounter$iv & 0xFFFFFFFFFFFFFFFL;
            boolean closed = this.isClosedForSend0(sendersAndCloseStatusCur);
            long id = s / (long)BufferedChannelKt.SEGMENT_SIZE;
            int i2 = (int)(s % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (segment.id != id && this.findSegmentSend(id, segment) == null) {
                if (!closed) continue;
                return (R)onClosed.invoke();
            }
            switch (this.updateCellSend(segment, i2, element, s, waiter, closed)) {
                case 0: {
                    segment.cleanPrev();
                    return (R)onRendezvousOrBuffered.invoke();
                }
                case 1: {
                    return (R)onRendezvousOrBuffered.invoke();
                }
                case 2: {
                    if (closed) {
                        segment.onSlotCleaned();
                        return (R)onClosed.invoke();
                    }
                    Waiter waiter2 = waiter instanceof Waiter ? (Waiter)waiter : null;
                    if (waiter2 != null) {
                        this.prepareSenderForSuspension(waiter2, segment, i2);
                    }
                    return (R)onSuspend.invoke((Object)segment, (Object)i2);
                }
                case 4: {
                    if (s < this.getReceiversCounter$kotlinx_coroutines_core()) {
                        segment.cleanPrev();
                    }
                    return (R)onClosed.invoke();
                }
                case 5: {
                    segment.cleanPrev();
                    continue block8;
                }
                case 3: {
                    return (R)onNoWaiterSuspend.invoke((Object)segment, (Object)i2, element, (Object)s);
                }
            }
        }
    }

    public static /* synthetic */ Object sendImpl$default(BufferedChannel $this, Object element, Object waiter, Function0 onRendezvousOrBuffered, Function2 onSuspend, Function0 onClosed, Function4 onNoWaiterSuspend, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        }
        if ((n2 & 0x20) != 0) {
            onNoWaiterSuspend = sendImpl.1.INSTANCE;
        }
        boolean $i$f$sendImpl = false;
        ChannelSegment segment = (ChannelSegment)BufferedChannel.sendSegment$FU.get($this);
        block8: while (true) {
            long sendersAndCloseStatusCur;
            long $this$sendersCounter$iv = sendersAndCloseStatusCur = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement($this);
            boolean $i$f$getSendersCounter = false;
            long s = $this$sendersCounter$iv & 0xFFFFFFFFFFFFFFFL;
            boolean closed = $this.isClosedForSend0(sendersAndCloseStatusCur);
            long id = s / (long)BufferedChannelKt.SEGMENT_SIZE;
            int i2 = (int)(s % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (segment.id != id && $this.findSegmentSend(id, segment) == null) {
                if (!closed) continue;
                return onClosed.invoke();
            }
            switch ($this.updateCellSend(segment, i2, element, s, waiter, closed)) {
                case 0: {
                    segment.cleanPrev();
                    return onRendezvousOrBuffered.invoke();
                }
                case 1: {
                    return onRendezvousOrBuffered.invoke();
                }
                case 2: {
                    if (closed) {
                        segment.onSlotCleaned();
                        return onClosed.invoke();
                    }
                    Waiter waiter2 = waiter instanceof Waiter ? (Waiter)waiter : null;
                    if (waiter2 != null) {
                        $this.prepareSenderForSuspension(waiter2, segment, i2);
                    }
                    return onSuspend.invoke((Object)segment, (Object)i2);
                }
                case 4: {
                    if (s < $this.getReceiversCounter$kotlinx_coroutines_core()) {
                        segment.cleanPrev();
                    }
                    return onClosed.invoke();
                }
                case 5: {
                    segment.cleanPrev();
                    continue block8;
                }
                case 3: {
                    return onNoWaiterSuspend.invoke((Object)segment, (Object)i2, element, (Object)s);
                }
            }
        }
    }

    private final void sendImplOnNoWaiter(ChannelSegment<E> segment, int index, E element, long s, Waiter waiter, Function0<Unit> onRendezvousOrBuffered, Function0<Unit> onClosed) {
        boolean $i$f$sendImplOnNoWaiter = false;
        switch (this.updateCellSend(segment, index, element, s, waiter, false)) {
            case 0: {
                segment.cleanPrev();
                onRendezvousOrBuffered.invoke();
                break;
            }
            case 1: {
                onRendezvousOrBuffered.invoke();
                break;
            }
            case 2: {
                this.prepareSenderForSuspension(waiter, segment, index);
                break;
            }
            case 4: {
                if (s < this.getReceiversCounter$kotlinx_coroutines_core()) {
                    segment.cleanPrev();
                }
                onClosed.invoke();
                break;
            }
            case 5: {
                segment.cleanPrev();
                boolean $i$f$sendImpl = false;
                ChannelSegment segment$iv = (ChannelSegment)BufferedChannel.sendSegment$FU.get(this);
                block15: while (true) {
                    Object object;
                    long sendersAndCloseStatusCur$iv;
                    long $this$sendersCounter$iv$iv = sendersAndCloseStatusCur$iv = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(this);
                    boolean $i$f$getSendersCounter = false;
                    long s$iv = $this$sendersCounter$iv$iv & 0xFFFFFFFFFFFFFFFL;
                    boolean closed$iv = this.isClosedForSend0(sendersAndCloseStatusCur$iv);
                    long id$iv = s$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
                    int i$iv = (int)(s$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
                    if (segment$iv.id != id$iv && this.findSegmentSend(id$iv, segment$iv) == null) {
                        if (!closed$iv) continue;
                        object = onClosed.invoke();
                        break;
                    }
                    switch (this.updateCellSend(segment$iv, i$iv, element, s$iv, waiter, closed$iv)) {
                        case 0: {
                            segment$iv.cleanPrev();
                            object = onRendezvousOrBuffered.invoke();
                            break block15;
                        }
                        case 1: {
                            object = onRendezvousOrBuffered.invoke();
                            break block15;
                        }
                        case 2: {
                            if (closed$iv) {
                                segment$iv.onSlotCleaned();
                                object = onClosed.invoke();
                                break block15;
                            }
                            Waiter waiter2 = waiter instanceof Waiter ? waiter : null;
                            if (waiter2 != null) {
                                this.prepareSenderForSuspension(waiter2, segment$iv, i$iv);
                            }
                            boolean bl = false;
                            object = Unit.INSTANCE;
                            break block15;
                        }
                        case 4: {
                            if (s$iv < this.getReceiversCounter$kotlinx_coroutines_core()) {
                                segment$iv.cleanPrev();
                            }
                            object = onClosed.invoke();
                            break block15;
                        }
                        case 5: {
                            segment$iv.cleanPrev();
                            continue block15;
                        }
                        case 3: {
                            E e2 = element;
                            int n2 = i$iv;
                            ChannelSegment channelSegment = segment$iv;
                            boolean bl = false;
                            throw new IllegalStateException("unexpected".toString());
                        }
                        default: {
                            continue block15;
                        }
                    }
                    break;
                }
                break;
            }
            default: {
                throw new IllegalStateException("unexpected".toString());
            }
        }
    }

    private final int updateCellSend(ChannelSegment<E> segment, int index, E element, long s, Object waiter, boolean closed) {
        segment.storeElement$kotlinx_coroutines_core(index, element);
        if (closed) {
            return this.updateCellSendSlow(segment, index, element, s, waiter, closed);
        }
        Object state = segment.getState$kotlinx_coroutines_core(index);
        if (state == null) {
            if (this.bufferOrRendezvousSend(s)) {
                if (segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (waiter == null) {
                    return 3;
                }
                if (segment.casState$kotlinx_coroutines_core(index, null, waiter)) {
                    return 2;
                }
            }
        } else if (state instanceof Waiter) {
            int n2;
            segment.cleanElement$kotlinx_coroutines_core(index);
            if (this.tryResumeReceiver(state, element)) {
                segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getDONE_RCV$p());
                this.onReceiveDequeued();
                n2 = 0;
            } else {
                if (segment.getAndSetState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) != BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                    segment.onCancelledRequest(index, true);
                }
                n2 = 5;
            }
            return n2;
        }
        return this.updateCellSendSlow(segment, index, element, s, waiter, closed);
    }

    private final int updateCellSendSlow(ChannelSegment<E> segment, int index, E element, long s, Object waiter, boolean closed) {
        int n2;
        Object receiver;
        Object state;
        block13: {
            while (true) {
                state = segment.getState$kotlinx_coroutines_core(index);
                if (state == null) {
                    if (this.bufferOrRendezvousSend(s) && !closed) {
                        if (!segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.BUFFERED)) continue;
                        return 1;
                    }
                    if (closed) {
                        if (!segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.access$getINTERRUPTED_SEND$p())) continue;
                        segment.onCancelledRequest(index, false);
                        return 4;
                    }
                    if (waiter == null) {
                        return 3;
                    }
                    if (!segment.casState$kotlinx_coroutines_core(index, null, waiter)) continue;
                    return 2;
                }
                if (state != BufferedChannelKt.access$getIN_BUFFER$p()) break block13;
                if (segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.BUFFERED)) break;
            }
            return 1;
        }
        if (state == BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
            segment.cleanElement$kotlinx_coroutines_core(index);
            return 5;
        }
        if (state == BufferedChannelKt.access$getPOISONED$p()) {
            segment.cleanElement$kotlinx_coroutines_core(index);
            return 5;
        }
        if (state == BufferedChannelKt.getCHANNEL_CLOSED()) {
            segment.cleanElement$kotlinx_coroutines_core(index);
            this.completeCloseOrCancel();
            return 4;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(state instanceof Waiter || state instanceof WaiterEB)) {
                throw new AssertionError();
            }
        }
        segment.cleanElement$kotlinx_coroutines_core(index);
        Object object = receiver = state instanceof WaiterEB ? ((WaiterEB)state).waiter : state;
        if (this.tryResumeReceiver(receiver, element)) {
            segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getDONE_RCV$p());
            this.onReceiveDequeued();
            n2 = 0;
        } else {
            if (segment.getAndSetState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) != BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                segment.onCancelledRequest(index, true);
            }
            n2 = 5;
        }
        return n2;
    }

    private final boolean shouldSendSuspend(long curSendersAndCloseStatus) {
        if (this.isClosedForSend0(curSendersAndCloseStatus)) {
            return false;
        }
        long $this$sendersCounter$iv = curSendersAndCloseStatus;
        boolean $i$f$getSendersCounter = false;
        return !this.bufferOrRendezvousSend($this$sendersCounter$iv & 0xFFFFFFFFFFFFFFFL);
    }

    private final boolean bufferOrRendezvousSend(long curSenders) {
        return curSenders < this.getBufferEndCounter() || curSenders < this.getReceiversCounter$kotlinx_coroutines_core() + (long)this.capacity;
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return this.shouldSendSuspend(sendersAndCloseStatus$FU.get(this));
    }

    private final boolean tryResumeReceiver(Object $this$tryResumeReceiver, E element) {
        boolean bl;
        Object object = $this$tryResumeReceiver;
        if (object instanceof SelectInstance) {
            bl = ((SelectInstance)$this$tryResumeReceiver).trySelect(this, element);
        } else if (object instanceof ReceiveCatching) {
            Intrinsics.checkNotNull((Object)$this$tryResumeReceiver, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            ReceiveCatching cfr_ignored_0 = (ReceiveCatching)$this$tryResumeReceiver;
            Function1<E, Unit> function1 = this.onUndeliveredElement;
            bl = BufferedChannelKt.access$tryResume0(((ReceiveCatching)$this$tryResumeReceiver).cont, ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(element)), function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, element, ((ReceiveCatching)$this$tryResumeReceiver).cont.getContext()) : null);
        } else if (object instanceof BufferedChannelIterator) {
            Intrinsics.checkNotNull((Object)$this$tryResumeReceiver, (String)"null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            BufferedChannelIterator cfr_ignored_1 = (BufferedChannelIterator)$this$tryResumeReceiver;
            bl = ((BufferedChannelIterator)$this$tryResumeReceiver).tryResumeHasNext(element);
        } else if (object instanceof CancellableContinuation) {
            Intrinsics.checkNotNull((Object)$this$tryResumeReceiver, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cfr_ignored_2 = (CancellableContinuation)$this$tryResumeReceiver;
            Function1<E, Unit> function1 = this.onUndeliveredElement;
            bl = BufferedChannelKt.access$tryResume0((CancellableContinuation)$this$tryResumeReceiver, element, function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, element, ((CancellableContinuation)$this$tryResumeReceiver).getContext()) : null);
        } else {
            throw new IllegalStateException(("Unexpected receiver type: " + $this$tryResumeReceiver).toString());
        }
        return bl;
    }

    protected void onReceiveEnqueued() {
    }

    protected void onReceiveDequeued() {
    }

    @Override
    @Nullable
    public Object receive(@NotNull Continuation<? super E> $completion) {
        return BufferedChannel.receive$suspendImpl(this, $completion);
    }

    /*
     * WARNING - void declaration
     */
    static /* synthetic */ <E> Object receive$suspendImpl(BufferedChannel<E> $this, Continuation<? super E> $completion) {
        void r;
        void i2;
        Object updCellResult$iv;
        int i$iv;
        long r$iv;
        void this_$iv;
        BufferedChannel<E> bufferedChannel = $this;
        Object waiter$iv = null;
        boolean $i$f$receiveImpl = false;
        ChannelSegment segment$iv = (ChannelSegment)BufferedChannel.receiveSegment$FU.get(this_$iv);
        while (true) {
            if (this_$iv.isClosedForReceive()) {
                boolean bl = false;
                throw StackTraceRecoveryKt.recoverStackTrace(super.getReceiveException());
            }
            r$iv = BufferedChannel.receivers$FU.getAndIncrement(this_$iv);
            long id$iv = r$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
            i$iv = (int)(r$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (segment$iv.id != id$iv && ((BufferedChannel)this_$iv).findSegmentReceive(id$iv, segment$iv) == null) continue;
            updCellResult$iv = ((BufferedChannel)this_$iv).updateCellReceive(segment$iv, i$iv, r$iv, waiter$iv);
            if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                boolean bl = false;
                throw new IllegalStateException("unexpected".toString());
            }
            if (updCellResult$iv != BufferedChannelKt.access$getFAILED$p()) break;
            if (r$iv >= this_$iv.getSendersCounter$kotlinx_coroutines_core()) continue;
            segment$iv.cleanPrev();
        }
        if (updCellResult$iv != BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
            segment$iv.cleanPrev();
            Object element = updCellResult$iv;
            boolean bl = false;
            return element;
        }
        long l2 = r$iv;
        int n2 = i$iv;
        ChannelSegment segm = segment$iv;
        boolean bl = false;
        return super.receiveOnNoWaiterSuspend(segm, (int)i2, (long)r, $completion);
    }

    private final Object receiveOnNoWaiterSuspend(ChannelSegment<E> segment, int index, long r, Continuation<? super E> $completion) {
        CancellableContinuationImpl<Object> cancellable$iv;
        block11: {
            boolean $i$f$suspendCancellableCoroutineReusable = false;
            Continuation<? super E> uCont$iv = $completion;
            boolean bl = false;
            cancellable$iv = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(uCont$iv));
            try {
                CancellableContinuationImpl<Object> cont = cancellable$iv;
                boolean bl2 = false;
                BufferedChannel this_$iv = this;
                boolean $i$f$receiveImplOnNoWaiter = false;
                Object updCellResult$iv = this_$iv.updateCellReceive(segment, index, r, cont);
                if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                    this_$iv.prepareReceiverForSuspension(cont, segment, index);
                    break block11;
                }
                if (updCellResult$iv == BufferedChannelKt.access$getFAILED$p()) {
                    Object updCellResult$iv$iv;
                    int i$iv$iv;
                    if (r < this_$iv.getSendersCounter$kotlinx_coroutines_core()) {
                        segment.cleanPrev();
                    }
                    boolean $i$f$receiveImpl = false;
                    ChannelSegment segment$iv$iv = (ChannelSegment)BufferedChannel.receiveSegment$FU.get(this_$iv);
                    while (true) {
                        if (this_$iv.isClosedForReceive()) {
                            boolean bl3 = false;
                            this.onClosedReceiveOnNoWaiterSuspend(cont);
                            break block11;
                        }
                        long r$iv$iv = BufferedChannel.receivers$FU.getAndIncrement(this_$iv);
                        long id$iv$iv = r$iv$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
                        i$iv$iv = (int)(r$iv$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
                        if (segment$iv$iv.id != id$iv$iv && this_$iv.findSegmentReceive(id$iv$iv, segment$iv$iv) == null) continue;
                        updCellResult$iv$iv = this_$iv.updateCellReceive(segment$iv$iv, i$iv$iv, r$iv$iv, cont);
                        if (updCellResult$iv$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                            Waiter waiter = (Waiter)cont instanceof Waiter ? (Waiter)cont : null;
                            if (waiter != null) {
                                this_$iv.prepareReceiverForSuspension(waiter, segment$iv$iv, i$iv$iv);
                            }
                            boolean bl4 = false;
                            break block11;
                        }
                        if (updCellResult$iv$iv != BufferedChannelKt.access$getFAILED$p()) break;
                        if (r$iv$iv >= this_$iv.getSendersCounter$kotlinx_coroutines_core()) continue;
                        segment$iv$iv.cleanPrev();
                    }
                    if (updCellResult$iv$iv == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                        int n2 = i$iv$iv;
                        ChannelSegment channelSegment = segment$iv$iv;
                        boolean bl5 = false;
                        throw new IllegalStateException("unexpected".toString());
                    }
                    segment$iv$iv.cleanPrev();
                    Object element = updCellResult$iv$iv;
                    boolean bl6 = false;
                    Function1<E, Unit> function1 = this.onUndeliveredElement;
                    Function1<Throwable, Unit> onCancellation = function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, element, cont.getContext()) : null;
                    cont.resume(element, onCancellation);
                    break block11;
                }
                segment.cleanPrev();
                Object element = updCellResult$iv;
                boolean bl7 = false;
                Function1<E, Unit> function1 = this.onUndeliveredElement;
                Function1<Throwable, Unit> onCancellation = function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, element, cont.getContext()) : null;
                cont.resume(element, onCancellation);
            }
            catch (Throwable e$iv) {
                cancellable$iv.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw e$iv;
            }
        }
        Object object = cancellable$iv.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    private final void prepareReceiverForSuspension(Waiter $this$prepareReceiverForSuspension, ChannelSegment<E> segment, int index) {
        this.onReceiveEnqueued();
        $this$prepareReceiverForSuspension.invokeOnCancellation((Segment)segment, index);
    }

    private final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation<? super E> cont) {
        ((Continuation)cont).resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)this.getReceiveException())));
    }

    @Override
    @Nullable
    public Object receiveCatching-JP2dKIU(@NotNull Continuation<? super ChannelResult<? extends E>> $completion) {
        return BufferedChannel.receiveCatching-JP2dKIU$suspendImpl(this, $completion);
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ <E> Object receiveCatching-JP2dKIU$suspendImpl(BufferedChannel<E> var0, Continuation<? super ChannelResult<? extends E>> var1_1) {
        block10: {
            if (!(var1_1 instanceof receiveCatching.1)) ** GOTO lbl-1000
            var19_2 = var1_1;
            if ((var19_2.label & -2147483648) != 0) {
                var19_2.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(var0, var1_1){
                    /* synthetic */ Object result;
                    final /* synthetic */ BufferedChannel<E> this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        Object object = BufferedChannel.receiveCatching-JP2dKIU$suspendImpl(this.this$0, (Continuation)this);
                        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            return object;
                        }
                        return ChannelResult.box-impl(object);
                    }
                };
            }
            $result = $continuation.result;
            var20_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    this_$iv = $this;
                    waiter$iv = null;
                    $i$f$receiveImpl = false;
                    segment$iv = (ChannelSegment)BufferedChannel.access$getReceiveSegment$FU$p().get(this_$iv);
                    while (true) {
                        if (this_$iv.isClosedForReceive()) {
                            $i$a$-receiveImpl-BufferedChannel$receiveCatching$4 = false;
                            v0 = ChannelResult.Companion.closed-JP2dKIU($this.getCloseCause());
                            break block10;
                        }
                        r$iv = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(this_$iv);
                        id$iv = r$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
                        i$iv = (int)(r$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
                        if (segment$iv.id != id$iv && BufferedChannel.access$findSegmentReceive(this_$iv, id$iv, segment$iv) == null) continue;
                        updCellResult$iv = BufferedChannel.access$updateCellReceive(this_$iv, segment$iv, i$iv, r$iv, waiter$iv);
                        if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                            $i$a$-receiveImpl-BufferedChannel$receiveCatching$3 = false;
                            throw new IllegalStateException("unexpected".toString());
                        }
                        if (updCellResult$iv != BufferedChannelKt.access$getFAILED$p()) break;
                        if (r$iv >= this_$iv.getSendersCounter$kotlinx_coroutines_core()) continue;
                        segment$iv.cleanPrev();
                    }
                    if (updCellResult$iv != BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) break;
                    var13_18 = r$iv;
                    var15_19 = i$iv;
                    segm = segment$iv;
                    $i$a$-receiveImpl-BufferedChannel$receiveCatching$5 = false;
                    $continuation.label = 1;
                    v0 = super.receiveCatchingOnNoWaiterSuspend-GKJJFZk(segm, (int)i, (long)r, (Continuation<ChannelResult<E>>)$continuation);
                    if (v0 == var20_4) {
                        return var20_4;
                    }
                    break block10;
                }
                case 1: {
                    $i$f$receiveImpl = false;
                    $i$a$-receiveImpl-BufferedChannel$receiveCatching$5 = false;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = ((ChannelResult)$result).unbox-impl();
                    break block10;
                }
            }
            segment$iv.cleanPrev();
            element = updCellResult$iv;
            $i$a$-receiveImpl-BufferedChannel$receiveCatching$2 = false;
            v0 = ChannelResult.Companion.success-JP2dKIU(element);
        }
        return v0;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    private final Object receiveCatchingOnNoWaiterSuspend-GKJJFZk(ChannelSegment<E> var1_1, int var2_2, long var3_3, Continuation<? super ChannelResult<? extends E>> var5_4) {
        if (!(var5_4 instanceof receiveCatchingOnNoWaiterSuspend.1)) ** GOTO lbl-1000
        var32_5 = var5_4;
        if ((var32_5.label & -2147483648) != 0) {
            var32_5.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, var5_4){
                Object L$0;
                Object L$1;
                int I$0;
                long J$0;
                /* synthetic */ Object result;
                final /* synthetic */ BufferedChannel<E> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    Object object = BufferedChannel.access$receiveCatchingOnNoWaiterSuspend-GKJJFZk(this.this$0, null, 0, 0L, (Continuation)this);
                    if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return object;
                    }
                    return ChannelResult.box-impl(object);
                }
            };
        }
        $result = $continuation.result;
        var33_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $i$f$suspendCancellableCoroutineReusable = false;
                $continuation.L$0 = this;
                $continuation.L$1 = segment;
                $continuation.I$0 = index;
                $continuation.J$0 = r;
                $continuation.label = 1;
                uCont$iv = (Continuation)$continuation;
                $i$a$-suspendCoroutineUninterceptedOrReturn-CancellableContinuationKt$suspendCancellableCoroutineReusable$2$iv = false;
                cancellable$iv = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted((Continuation)uCont$iv));
                try {
                    cont = cancellable$iv;
                    $i$a$-suspendCancellableCoroutineReusable-BufferedChannel$receiveCatchingOnNoWaiterSuspend$2 = false;
                    Intrinsics.checkNotNull(cont, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$35>>");
                    waiter = new ReceiveCatching<E>(cont);
                    this_$iv = this;
                    $i$f$receiveImplOnNoWaiter = false;
                    updCellResult$iv = BufferedChannel.access$updateCellReceive(this_$iv, (ChannelSegment)segment, (int)index, (long)r, waiter);
                    if (updCellResult$iv != BufferedChannelKt.access$getSUSPEND$p()) ** GOTO lbl34
                    BufferedChannel.access$prepareReceiverForSuspension(this_$iv, waiter, (ChannelSegment)segment, (int)index);
                    ** GOTO lbl89
lbl34:
                    // 1 sources

                    if (updCellResult$iv != BufferedChannelKt.access$getFAILED$p()) ** GOTO lbl76
                    if (r < this_$iv.getSendersCounter$kotlinx_coroutines_core()) {
                        segment.cleanPrev();
                    }
                    $i$f$receiveImpl = false;
                    segment$iv$iv = (ChannelSegment)BufferedChannel.access$getReceiveSegment$FU$p().get(this_$iv);
                    while (true) {
                        if (!this_$iv.isClosedForReceive()) ** GOTO lbl46
                        $i$a$-receiveImplOnNoWaiter-BufferedChannel$receiveCatchingOnNoWaiterSuspend$2$2 = false;
                        BufferedChannel.access$onClosedReceiveCatchingOnNoWaiterSuspend(this, cont);
                        ** GOTO lbl89
lbl46:
                        // 1 sources

                        r$iv$iv = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(this_$iv);
                        id$iv$iv = r$iv$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
                        i$iv$iv = (int)(r$iv$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
                        if (segment$iv$iv.id != id$iv$iv && BufferedChannel.access$findSegmentReceive(this_$iv, id$iv$iv, segment$iv$iv) == null) continue;
                        updCellResult$iv$iv = BufferedChannel.access$updateCellReceive(this_$iv, segment$iv$iv, i$iv$iv, r$iv$iv, waiter);
                        if (updCellResult$iv$iv != BufferedChannelKt.access$getSUSPEND$p()) ** GOTO lbl59
                        v0 = (Waiter)waiter instanceof Waiter != false ? (Waiter)waiter : null;
                        if (v0 != null) {
                            BufferedChannel.access$prepareReceiverForSuspension(this_$iv, v0, segment$iv$iv, i$iv$iv);
                        }
                        $i$a$-receiveImpl$default-BufferedChannel$receiveImplOnNoWaiter$1$iv = false;
                        ** GOTO lbl89
lbl59:
                        // 1 sources

                        if (updCellResult$iv$iv != BufferedChannelKt.access$getFAILED$p()) break;
                        if (r$iv$iv >= this_$iv.getSendersCounter$kotlinx_coroutines_core()) continue;
                        segment$iv$iv.cleanPrev();
                    }
                    if (updCellResult$iv$iv == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                        var26_29 = i$iv$iv;
                        var27_30 = segment$iv$iv;
                        $i$a$-receiveImpl-BufferedChannel$receiveImpl$1$iv = false;
                        throw new IllegalStateException("unexpected".toString());
                    }
                    segment$iv$iv.cleanPrev();
                    element = updCellResult$iv$iv;
                    $i$a$-receiveImplOnNoWaiter-BufferedChannel$receiveCatchingOnNoWaiterSuspend$2$1 = false;
                    v1 = this.onUndeliveredElement;
                    cont.resume(ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(element)), v1 != null ? OnUndeliveredElementKt.bindCancellationFun(v1, element, cont.getContext()) : null);
                    ** GOTO lbl89
lbl76:
                    // 1 sources

                    segment.cleanPrev();
                    element = updCellResult$iv;
                    $i$a$-receiveImplOnNoWaiter-BufferedChannel$receiveCatchingOnNoWaiterSuspend$2$1 = false;
                    v2 = this.onUndeliveredElement;
                    cont.resume(ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(element)), v2 != null ? OnUndeliveredElementKt.bindCancellationFun(v2, element, cont.getContext()) : null);
                }
                catch (Throwable e$iv) {
                    cancellable$iv.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                    throw e$iv;
                }
lbl89:
                // 5 sources

                v3 = cancellable$iv.getResult();
                if (v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended((Continuation)((Continuation)$continuation));
                }
                v4 = v3;
                if (v3 == var33_7) {
                    return var33_7;
                }
                ** GOTO lbl109
            }
            case 1: {
                $i$f$suspendCancellableCoroutineReusable = false;
                $continuation.J$0;
                $continuation.I$0;
                (ChannelSegment)$continuation.L$1;
                (BufferedChannel)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v4 = $result;
lbl109:
                // 2 sources

                return ((ChannelResult)v4).unbox-impl();
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation<? super ChannelResult<? extends E>> cont) {
        ((Continuation)cont).resumeWith(Result.constructor-impl((Object)ChannelResult.box-impl(ChannelResult.Companion.closed-JP2dKIU(this.getCloseCause()))));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Object tryReceive-PtdJZtk() {
        Object object;
        block7: {
            Object updCellResult$iv;
            int i$iv;
            long r = receivers$FU.get(this);
            long sendersAndCloseStatusCur = sendersAndCloseStatus$FU.get(this);
            if (this.isClosedForReceive0(sendersAndCloseStatusCur)) {
                return ChannelResult.Companion.closed-JP2dKIU(this.getCloseCause());
            }
            long $this$sendersCounter$iv22 = sendersAndCloseStatusCur;
            boolean $i$f$getSendersCounter = false;
            long s = $this$sendersCounter$iv22 & 0xFFFFFFFFFFFFFFFL;
            if (r >= s) {
                return ChannelResult.Companion.failure-PtdJZtk();
            }
            Symbol $this$sendersCounter$iv22 = BufferedChannelKt.access$getINTERRUPTED_RCV$p();
            boolean $i$f$receiveImpl = false;
            ChannelSegment segment$iv = (ChannelSegment)BufferedChannel.receiveSegment$FU.get(this);
            while (true) {
                void waiter$iv;
                if (this.isClosedForReceive()) {
                    boolean bl = false;
                    object = ChannelResult.Companion.closed-JP2dKIU(this.getCloseCause());
                    break block7;
                }
                long r$iv = BufferedChannel.receivers$FU.getAndIncrement(this);
                long id$iv = r$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
                i$iv = (int)(r$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
                if (segment$iv.id != id$iv && this.findSegmentReceive(id$iv, segment$iv) == null) continue;
                updCellResult$iv = this.updateCellReceive(segment$iv, i$iv, r$iv, waiter$iv);
                if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                    void globalIndex;
                    Waiter waiter = waiter$iv instanceof Waiter ? (Waiter)waiter$iv : null;
                    if (waiter != null) {
                        this.prepareReceiverForSuspension(waiter, segment$iv, i$iv);
                    }
                    long l2 = r$iv;
                    ChannelSegment segm = segment$iv;
                    boolean bl = false;
                    this.waitExpandBufferCompletion$kotlinx_coroutines_core((long)globalIndex);
                    segm.onSlotCleaned();
                    object = ChannelResult.Companion.failure-PtdJZtk();
                    break block7;
                }
                if (updCellResult$iv != BufferedChannelKt.access$getFAILED$p()) break;
                if (r$iv >= this.getSendersCounter$kotlinx_coroutines_core()) continue;
                segment$iv.cleanPrev();
            }
            if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                int n2 = i$iv;
                ChannelSegment segm = segment$iv;
                boolean bl = false;
                throw new IllegalStateException("unexpected".toString());
            }
            segment$iv.cleanPrev();
            Object element = updCellResult$iv;
            boolean bl = false;
            object = ChannelResult.Companion.success-JP2dKIU(element);
        }
        return object;
    }

    protected final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long globalCellIndex) {
        UndeliveredElementException undeliveredElementException;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!this.isConflatedDropOldest()) {
                throw new AssertionError();
            }
        }
        ChannelSegment<E> segment = (ChannelSegment<E>)receiveSegment$FU.get(this);
        while (true) {
            long r;
            if (globalCellIndex < Math.max((r = receivers$FU.get(this)) + (long)this.capacity, this.getBufferEndCounter())) {
                return;
            }
            if (!receivers$FU.compareAndSet(this, r, r + 1L)) continue;
            long id = r / (long)BufferedChannelKt.SEGMENT_SIZE;
            int i2 = (int)(r % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (segment.id != id && this.findSegmentReceive(id, segment) == null) continue;
            Object updCellResult = this.updateCellReceive(segment, i2, r, null);
            if (updCellResult == BufferedChannelKt.access$getFAILED$p()) {
                if (r >= this.getSendersCounter$kotlinx_coroutines_core()) continue;
                segment.cleanPrev();
                continue;
            }
            segment.cleanPrev();
            Function1<E, Unit> function1 = this.onUndeliveredElement;
            if (function1 != null && (undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, updCellResult, null, 2, null)) != null) break;
        }
        UndeliveredElementException it = undeliveredElementException;
        boolean bl = false;
        throw it;
    }

    private final <R> R receiveImpl(Object waiter, Function1<? super E, ? extends R> onElementRetrieved, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> onSuspend, Function0<? extends R> onClosed, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> onNoWaiterSuspend) {
        Object object;
        block6: {
            Object updCellResult;
            int i2;
            long r;
            boolean $i$f$receiveImpl = false;
            ChannelSegment segment = (ChannelSegment)BufferedChannel.receiveSegment$FU.get(this);
            while (true) {
                if (this.isClosedForReceive()) {
                    return (R)onClosed.invoke();
                }
                r = BufferedChannel.receivers$FU.getAndIncrement(this);
                long id = r / (long)BufferedChannelKt.SEGMENT_SIZE;
                i2 = (int)(r % (long)BufferedChannelKt.SEGMENT_SIZE);
                if (segment.id != id && this.findSegmentReceive(id, segment) == null) continue;
                updCellResult = this.updateCellReceive(segment, i2, r, waiter);
                if (updCellResult == BufferedChannelKt.access$getSUSPEND$p()) {
                    Waiter waiter2 = waiter instanceof Waiter ? (Waiter)waiter : null;
                    if (waiter2 != null) {
                        this.prepareReceiverForSuspension(waiter2, segment, i2);
                    }
                    object = onSuspend.invoke((Object)segment, (Object)i2, (Object)r);
                    break block6;
                }
                if (updCellResult != BufferedChannelKt.access$getFAILED$p()) break;
                if (r >= this.getSendersCounter$kotlinx_coroutines_core()) continue;
                segment.cleanPrev();
            }
            if (updCellResult == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                object = onNoWaiterSuspend.invoke((Object)segment, (Object)i2, (Object)r);
            } else {
                segment.cleanPrev();
                object = onElementRetrieved.invoke(updCellResult);
            }
        }
        return (R)object;
    }

    static /* synthetic */ Object receiveImpl$default(BufferedChannel $this, Object waiter, Function1 onElementRetrieved, Function3 onSuspend, Function0 onClosed, Function3 onNoWaiterSuspend, int n2, Object object) {
        Object object2;
        block8: {
            Object updCellResult;
            int i2;
            long r;
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
            }
            if ((n2 & 0x10) != 0) {
                onNoWaiterSuspend = receiveImpl.1.INSTANCE;
            }
            boolean $i$f$receiveImpl = false;
            ChannelSegment segment = (ChannelSegment)BufferedChannel.receiveSegment$FU.get($this);
            while (true) {
                if ($this.isClosedForReceive()) {
                    return onClosed.invoke();
                }
                r = BufferedChannel.receivers$FU.getAndIncrement($this);
                long id = r / (long)BufferedChannelKt.SEGMENT_SIZE;
                i2 = (int)(r % (long)BufferedChannelKt.SEGMENT_SIZE);
                if (segment.id != id && $this.findSegmentReceive(id, segment) == null) continue;
                updCellResult = $this.updateCellReceive(segment, i2, r, waiter);
                if (updCellResult == BufferedChannelKt.access$getSUSPEND$p()) {
                    Waiter waiter2 = waiter instanceof Waiter ? (Waiter)waiter : null;
                    if (waiter2 != null) {
                        $this.prepareReceiverForSuspension(waiter2, segment, i2);
                    }
                    object2 = onSuspend.invoke((Object)segment, (Object)i2, (Object)r);
                    break block8;
                }
                if (updCellResult != BufferedChannelKt.access$getFAILED$p()) break;
                if (r >= $this.getSendersCounter$kotlinx_coroutines_core()) continue;
                segment.cleanPrev();
            }
            if (updCellResult == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                object2 = onNoWaiterSuspend.invoke((Object)segment, (Object)i2, (Object)r);
            } else {
                segment.cleanPrev();
                object2 = onElementRetrieved.invoke(updCellResult);
            }
        }
        return object2;
    }

    private final void receiveImplOnNoWaiter(ChannelSegment<E> segment, int index, long r, Waiter waiter, Function1<? super E, Unit> onElementRetrieved, Function0<Unit> onClosed) {
        block10: {
            boolean $i$f$receiveImplOnNoWaiter = false;
            Object updCellResult = this.updateCellReceive(segment, index, r, waiter);
            if (updCellResult == BufferedChannelKt.access$getSUSPEND$p()) {
                this.prepareReceiverForSuspension(waiter, segment, index);
            } else if (updCellResult == BufferedChannelKt.access$getFAILED$p()) {
                Object updCellResult$iv;
                int i$iv;
                Object object;
                if (r < this.getSendersCounter$kotlinx_coroutines_core()) {
                    segment.cleanPrev();
                }
                boolean $i$f$receiveImpl = false;
                ChannelSegment segment$iv = (ChannelSegment)BufferedChannel.receiveSegment$FU.get(this);
                while (true) {
                    if (this.isClosedForReceive()) {
                        object = onClosed.invoke();
                        break block10;
                    }
                    long r$iv = BufferedChannel.receivers$FU.getAndIncrement(this);
                    long id$iv = r$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
                    i$iv = (int)(r$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
                    if (segment$iv.id != id$iv && this.findSegmentReceive(id$iv, segment$iv) == null) continue;
                    updCellResult$iv = this.updateCellReceive(segment$iv, i$iv, r$iv, waiter);
                    if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                        Waiter waiter2 = waiter instanceof Waiter ? waiter : null;
                        if (waiter2 != null) {
                            this.prepareReceiverForSuspension(waiter2, segment$iv, i$iv);
                        }
                        boolean bl = false;
                        object = Unit.INSTANCE;
                        break block10;
                    }
                    if (updCellResult$iv != BufferedChannelKt.access$getFAILED$p()) break;
                    if (r$iv >= this.getSendersCounter$kotlinx_coroutines_core()) continue;
                    segment$iv.cleanPrev();
                }
                if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                    int n2 = i$iv;
                    ChannelSegment channelSegment = segment$iv;
                    boolean bl = false;
                    throw new IllegalStateException("unexpected".toString());
                }
                segment$iv.cleanPrev();
                object = onElementRetrieved.invoke(updCellResult$iv);
            } else {
                segment.cleanPrev();
                onElementRetrieved.invoke(updCellResult);
            }
        }
    }

    private final Object updateCellReceive(ChannelSegment<E> segment, int index, long r, Object waiter) {
        Object state = segment.getState$kotlinx_coroutines_core(index);
        if (state == null) {
            long $this$sendersCounter$iv = sendersAndCloseStatus$FU.get(this);
            boolean $i$f$getSendersCounter = false;
            long senders = $this$sendersCounter$iv & 0xFFFFFFFFFFFFFFFL;
            if (r >= senders) {
                if (waiter == null) {
                    return BufferedChannelKt.access$getSUSPEND_NO_WAITER$p();
                }
                if (segment.casState$kotlinx_coroutines_core(index, state, waiter)) {
                    this.expandBuffer();
                    return BufferedChannelKt.access$getSUSPEND$p();
                }
            }
        } else if (state == BufferedChannelKt.BUFFERED && segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getDONE_RCV$p())) {
            this.expandBuffer();
            return segment.retrieveElement$kotlinx_coroutines_core(index);
        }
        return this.updateCellReceiveSlow(segment, index, r, waiter);
    }

    private final Object updateCellReceiveSlow(ChannelSegment<E> segment, int index, long r, Object waiter) {
        Object object;
        Object sender;
        Object state;
        while (true) {
            state = segment.getState$kotlinx_coroutines_core(index);
            if (state == null || state == BufferedChannelKt.access$getIN_BUFFER$p()) {
                long $this$sendersCounter$iv = sendersAndCloseStatus$FU.get(this);
                boolean $i$f$getSendersCounter = false;
                long senders = $this$sendersCounter$iv & 0xFFFFFFFFFFFFFFFL;
                if (r < senders) {
                    if (!segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getPOISONED$p())) continue;
                    this.expandBuffer();
                    return BufferedChannelKt.access$getFAILED$p();
                }
                if (waiter == null) {
                    return BufferedChannelKt.access$getSUSPEND_NO_WAITER$p();
                }
                if (!segment.casState$kotlinx_coroutines_core(index, state, waiter)) continue;
                this.expandBuffer();
                return BufferedChannelKt.access$getSUSPEND$p();
            }
            if (state == BufferedChannelKt.BUFFERED) {
                if (!segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getDONE_RCV$p())) continue;
                this.expandBuffer();
                return segment.retrieveElement$kotlinx_coroutines_core(index);
            }
            if (state == BufferedChannelKt.access$getINTERRUPTED_SEND$p()) {
                return BufferedChannelKt.access$getFAILED$p();
            }
            if (state == BufferedChannelKt.access$getPOISONED$p()) {
                return BufferedChannelKt.access$getFAILED$p();
            }
            if (state == BufferedChannelKt.getCHANNEL_CLOSED()) {
                this.expandBuffer();
                return BufferedChannelKt.access$getFAILED$p();
            }
            if (state != BufferedChannelKt.access$getRESUMING_BY_EB$p() && segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getRESUMING_BY_RCV$p())) break;
        }
        boolean helpExpandBuffer = state instanceof WaiterEB;
        Object object2 = sender = state instanceof WaiterEB ? ((WaiterEB)state).waiter : state;
        if (this.tryResumeSender(sender, segment, index)) {
            segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getDONE_RCV$p());
            this.expandBuffer();
            object = segment.retrieveElement$kotlinx_coroutines_core(index);
        } else {
            segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
            segment.onCancelledRequest(index, false);
            if (helpExpandBuffer) {
                this.expandBuffer();
            }
            object = BufferedChannelKt.access$getFAILED$p();
        }
        return object;
    }

    private final boolean tryResumeSender(Object $this$tryResumeSender, ChannelSegment<E> segment, int index) {
        boolean bl;
        Object object = $this$tryResumeSender;
        if (object instanceof CancellableContinuation) {
            Intrinsics.checkNotNull((Object)$this$tryResumeSender, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            CancellableContinuation cfr_ignored_0 = (CancellableContinuation)$this$tryResumeSender;
            bl = BufferedChannelKt.tryResume0$default((CancellableContinuation)$this$tryResumeSender, Unit.INSTANCE, null, 2, null);
        } else if (object instanceof SelectInstance) {
            Intrinsics.checkNotNull((Object)$this$tryResumeSender, (String)"null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            SelectImplementation cfr_ignored_1 = (SelectImplementation)$this$tryResumeSender;
            TrySelectDetailedResult trySelectResult = ((SelectImplementation)$this$tryResumeSender).trySelectDetailed(this, Unit.INSTANCE);
            if (trySelectResult == TrySelectDetailedResult.REREGISTER) {
                segment.cleanElement$kotlinx_coroutines_core(index);
            }
            bl = trySelectResult == TrySelectDetailedResult.SUCCESSFUL;
        } else if (object instanceof SendBroadcast) {
            bl = BufferedChannelKt.tryResume0$default(((SendBroadcast)$this$tryResumeSender).getCont(), true, null, 2, null);
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + $this$tryResumeSender).toString());
        }
        return bl;
    }

    private final void expandBuffer() {
        if (this.isRendezvousOrUnlimited()) {
            return;
        }
        ChannelSegment<E> segment = (ChannelSegment<E>)bufferEndSegment$FU.get(this);
        while (true) {
            long b2 = bufferEnd$FU.getAndIncrement(this);
            long id = b2 / (long)BufferedChannelKt.SEGMENT_SIZE;
            long s = this.getSendersCounter$kotlinx_coroutines_core();
            if (s <= b2) {
                if (segment.id < id && segment.getNext() != null) {
                    this.moveSegmentBufferEndToSpecifiedOrLast(id, segment);
                }
                BufferedChannel.incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            if (segment.id != id && this.findSegmentBufferEnd(id, segment, b2) == null) continue;
            int i2 = (int)(b2 % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (this.updateCellExpandBuffer(segment, i2, b2)) {
                BufferedChannel.incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            BufferedChannel.incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
        }
    }

    private final boolean updateCellExpandBuffer(ChannelSegment<E> segment, int index, long b2) {
        Object state = segment.getState$kotlinx_coroutines_core(index);
        if (state instanceof Waiter && b2 >= receivers$FU.get(this) && segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getRESUMING_BY_EB$p())) {
            boolean bl;
            if (this.tryResumeSender(state, segment, index)) {
                segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.BUFFERED);
                bl = true;
            } else {
                segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                segment.onCancelledRequest(index, false);
                bl = false;
            }
            return bl;
        }
        return this.updateCellExpandBufferSlow(segment, index, b2);
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment<E> segment, int index, long b2) {
        Object state;
        while (true) {
            state = segment.getState$kotlinx_coroutines_core(index);
            if (state instanceof Waiter) {
                boolean bl;
                if (b2 < receivers$FU.get(this)) {
                    if (!segment.casState$kotlinx_coroutines_core(index, state, new WaiterEB((Waiter)state))) continue;
                    return true;
                }
                if (!segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getRESUMING_BY_EB$p())) continue;
                if (this.tryResumeSender(state, segment, index)) {
                    segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.BUFFERED);
                    bl = true;
                } else {
                    segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                    segment.onCancelledRequest(index, false);
                    bl = false;
                }
                return bl;
            }
            if (state == BufferedChannelKt.access$getINTERRUPTED_SEND$p()) {
                return false;
            }
            if (state == null) {
                if (!segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getIN_BUFFER$p())) continue;
                return true;
            }
            if (state == BufferedChannelKt.BUFFERED) {
                return true;
            }
            if (state == BufferedChannelKt.access$getPOISONED$p() || state == BufferedChannelKt.access$getDONE_RCV$p() || state == BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                return true;
            }
            if (state == BufferedChannelKt.getCHANNEL_CLOSED()) {
                return true;
            }
            if (state != BufferedChannelKt.access$getRESUMING_BY_RCV$p()) break;
        }
        throw new IllegalStateException(("Unexpected cell state: " + state).toString());
    }

    private final void incCompletedExpandBufferAttempts(long nAttempts) {
        long l2;
        long it = l2 = completedExpandBuffersAndPauseFlag$FU.addAndGet(this, nAttempts);
        boolean bl = false;
        long $this$ebPauseExpandBuffers$iv = it;
        boolean $i$f$getEbPauseExpandBuffers = false;
        if (($this$ebPauseExpandBuffers$iv & 0x4000000000000000L) != 0L) {
            do {
                $this$ebPauseExpandBuffers$iv = completedExpandBuffersAndPauseFlag$FU.get(this);
                $i$f$getEbPauseExpandBuffers = false;
            } while (($this$ebPauseExpandBuffers$iv & 0x4000000000000000L) != 0L);
        }
    }

    static /* synthetic */ void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel, long l2, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((n2 & 1) != 0) {
            l2 = 1L;
        }
        bufferedChannel.incCompletedExpandBufferAttempts(l2);
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long globalIndex) {
        long $this$ebCompletedCounter$iv;
        long l2;
        long l3;
        if (this.isRendezvousOrUnlimited()) {
            return;
        }
        while (this.getBufferEndCounter() <= globalIndex) {
        }
        int n2 = BufferedChannelKt.access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p();
        for (int i2 = 0; i2 < n2; ++i2) {
            int it = i2;
            boolean bl = false;
            long b2 = this.getBufferEndCounter();
            long $this$ebCompletedCounter$iv2 = completedExpandBuffersAndPauseFlag$FU.get(this);
            boolean $i$f$getEbCompletedCounter = false;
            long ebCompleted = $this$ebCompletedCounter$iv2 & 0x3FFFFFFFFFFFFFFFL;
            if (b2 != ebCompleted || b2 != this.getBufferEndCounter()) continue;
            return;
        }
        BufferedChannel bufferedChannel = this;
        AtomicLongFieldUpdater atomicfu$handler$iv = completedExpandBuffersAndPauseFlag$FU;
        boolean $i$f$update$atomicfu = false;
        do {
            long it = l3 = atomicfu$handler$iv.get(this);
            boolean bl = false;
            $this$ebCompletedCounter$iv = it;
            boolean $i$f$getEbCompletedCounter = false;
        } while (!atomicfu$handler$iv.compareAndSet(this, l3, l2 = BufferedChannelKt.access$constructEBCompletedAndPauseFlag($this$ebCompletedCounter$iv & 0x3FFFFFFFFFFFFFFFL, true)));
        while (true) {
            boolean pauseExpandBuffers;
            long ebCompletedAndBit;
            long b3 = this.getBufferEndCounter();
            long $this$ebCompletedCounter$iv3 = ebCompletedAndBit = completedExpandBuffersAndPauseFlag$FU.get(this);
            boolean $i$f$getEbCompletedCounter = false;
            long ebCompleted = $this$ebCompletedCounter$iv3 & 0x3FFFFFFFFFFFFFFFL;
            long $this$ebPauseExpandBuffers$iv2 = ebCompletedAndBit;
            boolean $i$f$getEbPauseExpandBuffers = false;
            boolean bl = pauseExpandBuffers = ($this$ebPauseExpandBuffers$iv2 & 0x4000000000000000L) != 0L;
            if (b3 == ebCompleted && b3 == this.getBufferEndCounter()) {
                long $this$ebCompletedCounter$iv4;
                long l4;
                long l5;
                BufferedChannel $this$ebPauseExpandBuffers$iv2 = this;
                AtomicLongFieldUpdater atomicfu$handler$iv2 = completedExpandBuffersAndPauseFlag$FU;
                boolean $i$f$update$atomicfu2 = false;
                do {
                    long it = l5 = atomicfu$handler$iv2.get(this);
                    boolean bl2 = false;
                    $this$ebCompletedCounter$iv4 = it;
                    boolean $i$f$getEbCompletedCounter2 = false;
                } while (!atomicfu$handler$iv2.compareAndSet(this, l5, l4 = BufferedChannelKt.access$constructEBCompletedAndPauseFlag($this$ebCompletedCounter$iv4 & 0x3FFFFFFFFFFFFFFFL, false)));
                return;
            }
            if (pauseExpandBuffers) continue;
            completedExpandBuffersAndPauseFlag$FU.compareAndSet(this, ebCompletedAndBit, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(ebCompleted, true));
        }
    }

    @Override
    @NotNull
    public SelectClause2<E, BufferedChannel<E>> getOnSend() {
        onSend.1 v0 = onSend.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v0), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v0), (int)3);
        onSend.2 v2 = onSend.2.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v2), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, function3, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v2), (int)3), null, 8, null);
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    protected void registerSelectForSend(@NotNull SelectInstance<?> select, @Nullable Object element) {
        Object element$iv = element;
        boolean $i$f$sendImpl = false;
        ChannelSegment segment$iv = (ChannelSegment)BufferedChannel.sendSegment$FU.get(this);
        block8: while (true) {
            long sendersAndCloseStatusCur$iv;
            long $this$sendersCounter$iv$iv = sendersAndCloseStatusCur$iv = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(this);
            boolean $i$f$getSendersCounter = false;
            long s$iv = $this$sendersCounter$iv$iv & 0xFFFFFFFFFFFFFFFL;
            boolean closed$iv = this.isClosedForSend0(sendersAndCloseStatusCur$iv);
            long id$iv = s$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
            int i$iv = (int)(s$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (segment$iv.id != id$iv && this.findSegmentSend(id$iv, segment$iv) == null) {
                if (!closed$iv) continue;
                boolean bl = false;
                this.onClosedSelectOnSend(element, select);
                break;
            }
            switch (this.updateCellSend(segment$iv, i$iv, element$iv, s$iv, select, closed$iv)) {
                case 0: {
                    segment$iv.cleanPrev();
                    boolean bl = false;
                    select.selectInRegistrationPhase(Unit.INSTANCE);
                    break block8;
                }
                case 1: {
                    boolean bl = false;
                    select.selectInRegistrationPhase(Unit.INSTANCE);
                    break block8;
                }
                case 2: {
                    if (closed$iv) {
                        segment$iv.onSlotCleaned();
                        boolean bl = false;
                        this.onClosedSelectOnSend(element, select);
                        break block8;
                    }
                    Waiter waiter = select instanceof Waiter ? (Waiter)((Object)select) : null;
                    if (waiter != null) {
                        this.prepareSenderForSuspension(waiter, segment$iv, i$iv);
                    }
                    boolean bl = false;
                    break block8;
                }
                case 4: {
                    if (s$iv < this.getReceiversCounter$kotlinx_coroutines_core()) {
                        segment$iv.cleanPrev();
                    }
                    boolean bl = false;
                    this.onClosedSelectOnSend(element, select);
                    break block8;
                }
                case 5: {
                    segment$iv.cleanPrev();
                    continue block8;
                }
                case 3: {
                    Object object = element$iv;
                    int n2 = i$iv;
                    ChannelSegment channelSegment = segment$iv;
                    boolean bl = false;
                    throw new IllegalStateException("unexpected".toString());
                }
                default: {
                    continue block8;
                }
            }
            break;
        }
    }

    private final void onClosedSelectOnSend(E element, SelectInstance<?> select) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, element, select.getContext());
        }
        select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final Object processResultSelectSend(Object ignoredParam, Object selectResult) {
        if (selectResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
            throw this.getSendException();
        }
        return this;
    }

    @Override
    @NotNull
    public SelectClause1<E> getOnReceive() {
        onReceive.1 v0 = onReceive.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v0), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v0), (int)3);
        onReceive.2 v2 = onReceive.2.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v2), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, function3, (Function3<Object, Object, Object, ? extends Object>)((Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v2), (int)3)), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public static /* synthetic */ void getOnReceive$annotations() {
    }

    @Override
    @NotNull
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        onReceiveCatching.1 v0 = onReceiveCatching.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v0), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v0), (int)3);
        onReceiveCatching.2 v2 = onReceiveCatching.2.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v2), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, function3, (Function3<Object, Object, Object, ? extends Object>)((Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v2), (int)3)), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public static /* synthetic */ void getOnReceiveCatching$annotations() {
    }

    @Override
    @NotNull
    public SelectClause1<E> getOnReceiveOrNull() {
        onReceiveOrNull.1 v0 = onReceiveOrNull.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v0), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v0), (int)3);
        onReceiveOrNull.2 v2 = onReceiveOrNull.2.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v2), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, function3, (Function3<Object, Object, Object, ? extends Object>)((Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v2), (int)3)), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public static /* synthetic */ void getOnReceiveOrNull$annotations() {
    }

    private final void registerSelectForReceive(SelectInstance<?> select, Object ignoredParam) {
        block5: {
            Object updCellResult$iv;
            int i$iv;
            boolean $i$f$receiveImpl = false;
            ChannelSegment segment$iv = (ChannelSegment)BufferedChannel.receiveSegment$FU.get(this);
            while (true) {
                if (this.isClosedForReceive()) {
                    boolean bl = false;
                    this.onClosedSelectOnReceive(select);
                    break block5;
                }
                long r$iv = BufferedChannel.receivers$FU.getAndIncrement(this);
                long id$iv = r$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
                i$iv = (int)(r$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
                if (segment$iv.id != id$iv && this.findSegmentReceive(id$iv, segment$iv) == null) continue;
                updCellResult$iv = this.updateCellReceive(segment$iv, i$iv, r$iv, select);
                if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                    Waiter waiter = select instanceof Waiter ? (Waiter)((Object)select) : null;
                    if (waiter != null) {
                        this.prepareReceiverForSuspension(waiter, segment$iv, i$iv);
                    }
                    boolean bl = false;
                    break block5;
                }
                if (updCellResult$iv != BufferedChannelKt.access$getFAILED$p()) break;
                if (r$iv >= this.getSendersCounter$kotlinx_coroutines_core()) continue;
                segment$iv.cleanPrev();
            }
            if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                int n2 = i$iv;
                ChannelSegment channelSegment = segment$iv;
                boolean bl = false;
                throw new IllegalStateException("unexpected".toString());
            }
            segment$iv.cleanPrev();
            Object elem = updCellResult$iv;
            boolean bl = false;
            select.selectInRegistrationPhase(elem);
        }
    }

    private final void onClosedSelectOnReceive(SelectInstance<?> select) {
        select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final Object processResultSelectReceive(Object ignoredParam, Object selectResult) {
        if (selectResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
            throw this.getReceiveException();
        }
        return selectResult;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final Object processResultSelectReceiveOrNull(Object ignoredParam, Object selectResult) {
        if (selectResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
            if (this.getCloseCause() != null) throw this.getReceiveException();
            return null;
        }
        Object object = selectResult;
        return object;
    }

    private final Object processResultSelectReceiveCatching(Object ignoredParam, Object selectResult) {
        return ChannelResult.box-impl(selectResult == BufferedChannelKt.getCHANNEL_CLOSED() ? ChannelResult.Companion.closed-JP2dKIU(this.getCloseCause()) : ChannelResult.Companion.success-JP2dKIU(selectResult));
    }

    private static /* synthetic */ void getOnUndeliveredElementReceiveCancellationConstructor$annotations() {
    }

    @Override
    @NotNull
    public ChannelIterator<E> iterator() {
        return new BufferedChannelIterator();
    }

    @Nullable
    protected final Throwable getCloseCause() {
        return (Throwable)_closeCause$FU.get(this);
    }

    @NotNull
    protected final Throwable getSendException() {
        Throwable throwable = this.getCloseCause();
        if (throwable == null) {
            throwable = new ClosedSendChannelException("Channel was closed");
        }
        return throwable;
    }

    private final Throwable getReceiveException() {
        Throwable throwable = this.getCloseCause();
        if (throwable == null) {
            throwable = new ClosedReceiveChannelException("Channel was closed");
        }
        return throwable;
    }

    protected void onClosedIdempotent() {
    }

    @Override
    public boolean close(@Nullable Throwable cause) {
        return this.closeOrCancelImpl(cause, false);
    }

    @Override
    public final boolean cancel(@Nullable Throwable cause) {
        return this.cancelImpl$kotlinx_coroutines_core(cause);
    }

    @Override
    public final void cancel() {
        this.cancelImpl$kotlinx_coroutines_core(null);
    }

    @Override
    public final void cancel(@Nullable CancellationException cause) {
        this.cancelImpl$kotlinx_coroutines_core(cause);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(@Nullable Throwable cause) {
        Throwable throwable = cause;
        if (throwable == null) {
            throwable = new CancellationException("Channel was cancelled");
        }
        return this.closeOrCancelImpl(throwable, true);
    }

    protected boolean closeOrCancelImpl(@Nullable Throwable cause, boolean cancel) {
        boolean bl;
        if (cancel) {
            this.markCancellationStarted();
        }
        boolean closedByThisOperation = _closeCause$FU.compareAndSet(this, BufferedChannelKt.access$getNO_CLOSE_CAUSE$p(), cause);
        if (cancel) {
            this.markCancelled();
        } else {
            this.markClosed();
        }
        this.completeCloseOrCancel();
        boolean it = bl = closedByThisOperation;
        boolean bl2 = false;
        this.onClosedIdempotent();
        if (it) {
            this.invokeCloseHandler();
        }
        return bl;
    }

    private final void invokeCloseHandler() {
        Symbol symbol;
        Symbol symbol2;
        Object v;
        BufferedChannel bufferedChannel = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = closeHandler$FU;
        boolean $i$f$getAndUpdate$atomicfu = false;
        do {
            Object it = v = atomicfu$handler$iv.get(this);
            boolean bl = false;
            if (it == null) {
                symbol = BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p();
                continue;
            }
            symbol = BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p();
        } while (!atomicfu$handler$iv.compareAndSet(this, v, symbol2 = symbol));
        Object v2 = v;
        if (v2 == null) {
            return;
        }
        Object closeHandler = v2;
        Function1 cfr_ignored_0 = (Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(closeHandler, (int)1);
        ((Function1)closeHandler).invoke((Object)this.getCloseCause());
    }

    @Override
    public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> handler) {
        Object cur;
        block3: {
            if (closeHandler$FU.compareAndSet(this, null, handler)) {
                return;
            }
            BufferedChannel bufferedChannel = this;
            AtomicReferenceFieldUpdater atomicfu$handler$iv = closeHandler$FU;
            boolean $i$f$loop$atomicfu = false;
            do {
                cur = atomicfu$handler$iv.get(this);
                boolean bl = false;
                if (cur != BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p()) break block3;
            } while (!closeHandler$FU.compareAndSet(this, BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p(), BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p()));
            handler.invoke((Object)this.getCloseCause());
            return;
        }
        if (cur == BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p()) {
            throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
        }
        throw new IllegalStateException(("Another handler is already registered: " + cur).toString());
    }

    private final void markClosed() {
        long l2;
        long l3;
        long l4;
        BufferedChannel bufferedChannel = this;
        AtomicLongFieldUpdater atomicfu$handler$iv = sendersAndCloseStatus$FU;
        boolean $i$f$update$atomicfu = false;
        do {
            long cur = l4 = atomicfu$handler$iv.get(this);
            boolean bl = false;
            long $this$sendersCloseStatus$iv = cur;
            boolean $i$f$getSendersCloseStatus = false;
            switch ((int)($this$sendersCloseStatus$iv >> 60)) {
                case 0: {
                    long $this$sendersCounter$iv = cur;
                    boolean $i$f$getSendersCounter = false;
                    l2 = BufferedChannelKt.access$constructSendersAndCloseStatus($this$sendersCounter$iv & 0xFFFFFFFFFFFFFFFL, 2);
                    break;
                }
                case 1: {
                    long $this$sendersCounter$iv = cur;
                    boolean $i$f$getSendersCounter = false;
                    l2 = BufferedChannelKt.access$constructSendersAndCloseStatus($this$sendersCounter$iv & 0xFFFFFFFFFFFFFFFL, 3);
                    break;
                }
                default: {
                    return;
                }
            }
        } while (!atomicfu$handler$iv.compareAndSet(this, l4, l3 = l2));
    }

    private final void markCancelled() {
        long $this$sendersCounter$iv;
        long l2;
        long l3;
        BufferedChannel bufferedChannel = this;
        AtomicLongFieldUpdater atomicfu$handler$iv = sendersAndCloseStatus$FU;
        boolean $i$f$update$atomicfu = false;
        do {
            long cur = l3 = atomicfu$handler$iv.get(this);
            boolean bl = false;
            $this$sendersCounter$iv = cur;
            boolean $i$f$getSendersCounter = false;
        } while (!atomicfu$handler$iv.compareAndSet(this, l3, l2 = BufferedChannelKt.access$constructSendersAndCloseStatus($this$sendersCounter$iv & 0xFFFFFFFFFFFFFFFL, 3)));
    }

    private final void markCancellationStarted() {
        long $this$sendersCounter$iv;
        long l2;
        long l3;
        BufferedChannel bufferedChannel = this;
        AtomicLongFieldUpdater atomicfu$handler$iv = sendersAndCloseStatus$FU;
        boolean $i$f$update$atomicfu = false;
        do {
            long cur = l3 = atomicfu$handler$iv.get(this);
            boolean bl = false;
            long $this$sendersCloseStatus$iv = cur;
            boolean $i$f$getSendersCloseStatus = false;
            if ((int)($this$sendersCloseStatus$iv >> 60) != 0) {
                return;
            }
            $this$sendersCounter$iv = cur;
            boolean $i$f$getSendersCounter = false;
        } while (!atomicfu$handler$iv.compareAndSet(this, l3, l2 = BufferedChannelKt.access$constructSendersAndCloseStatus($this$sendersCounter$iv & 0xFFFFFFFFFFFFFFFL, 1)));
    }

    private final void completeCloseOrCancel() {
        this.isClosedForSend();
    }

    protected boolean isConflatedDropOldest() {
        return false;
    }

    private final ChannelSegment<E> completeClose(long sendersCur) {
        long lastBufferedCellGlobalIndex;
        ChannelSegment<E> lastSegment = this.closeLinkedList();
        if (this.isConflatedDropOldest() && (lastBufferedCellGlobalIndex = this.markAllEmptyCellsAsClosed(lastSegment)) != -1L) {
            this.dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(lastBufferedCellGlobalIndex);
        }
        this.cancelSuspendedReceiveRequests(lastSegment, sendersCur);
        return lastSegment;
    }

    private final void completeCancel(long sendersCur) {
        ChannelSegment<E> lastSegment = this.completeClose(sendersCur);
        this.removeUnprocessedElements(lastSegment);
    }

    private final ChannelSegment<E> closeLinkedList() {
        ChannelSegment lastSegment = null;
        lastSegment = (ChannelSegment)bufferEndSegment$FU.get(this);
        ChannelSegment it = (ChannelSegment)sendSegment$FU.get(this);
        boolean bl = false;
        if (it.id > ((ChannelSegment)lastSegment).id) {
            lastSegment = it;
        }
        it = (ChannelSegment)receiveSegment$FU.get(this);
        boolean bl2 = false;
        if (it.id > lastSegment.id) {
            lastSegment = it;
        }
        return (ChannelSegment)ConcurrentLinkedListKt.close((ConcurrentLinkedListNode)lastSegment);
    }

    private final long markAllEmptyCellsAsClosed(ChannelSegment<E> lastSegment) {
        ChannelSegment segment = lastSegment;
        while (true) {
            for (int index = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < index; --index) {
                Object state;
                long globalIndex;
                block4: {
                    globalIndex = segment.id * (long)BufferedChannelKt.SEGMENT_SIZE + (long)index;
                    if (globalIndex < this.getReceiversCounter$kotlinx_coroutines_core()) {
                        return -1L;
                    }
                    do {
                        state = segment.getState$kotlinx_coroutines_core(index);
                        if (state != null && state != BufferedChannelKt.access$getIN_BUFFER$p()) break block4;
                    } while (!segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.getCHANNEL_CLOSED()));
                    segment.onSlotCleaned();
                    continue;
                }
                if (state != BufferedChannelKt.BUFFERED) continue;
                return globalIndex;
            }
            if ((ChannelSegment)segment.getPrev() != null) continue;
            return -1L;
        }
    }

    private final void removeUnprocessedElements(ChannelSegment<E> lastSegment) {
        UndeliveredElementException undeliveredElementException;
        Waiter it;
        Function1<E, Unit> onUndeliveredElement = this.onUndeliveredElement;
        UndeliveredElementException undeliveredElementException2 = null;
        Object suspendedSenders = InlineList.constructor-impl$default(null, 1, null);
        ChannelSegment segment = lastSegment;
        block0: while (true) {
            block1: for (int index = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < index; --index) {
                long globalIndex = segment.id * (long)BufferedChannelKt.SEGMENT_SIZE + (long)index;
                while (true) {
                    Object state = segment.getState$kotlinx_coroutines_core(index);
                    if (state == BufferedChannelKt.access$getDONE_RCV$p()) break block0;
                    if (state == BufferedChannelKt.BUFFERED) {
                        if (globalIndex < this.getReceiversCounter$kotlinx_coroutines_core()) break block0;
                        if (!segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.getCHANNEL_CLOSED())) continue;
                        if (onUndeliveredElement != null) {
                            Object element = segment.getElement$kotlinx_coroutines_core(index);
                            undeliveredElementException2 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(onUndeliveredElement, element, undeliveredElementException2);
                        }
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        segment.onSlotCleaned();
                        continue block1;
                    }
                    if (state == BufferedChannelKt.access$getIN_BUFFER$p() || state == null) {
                        if (!segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.getCHANNEL_CLOSED())) continue;
                        segment.onSlotCleaned();
                        continue block1;
                    }
                    if (state instanceof Waiter || state instanceof WaiterEB) {
                        Waiter sender;
                        if (globalIndex < this.getReceiversCounter$kotlinx_coroutines_core()) break block0;
                        Waiter waiter = sender = state instanceof WaiterEB ? ((WaiterEB)state).waiter : (Waiter)state;
                        if (!segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.getCHANNEL_CLOSED())) continue;
                        if (onUndeliveredElement != null) {
                            Object element = segment.getElement$kotlinx_coroutines_core(index);
                            undeliveredElementException2 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(onUndeliveredElement, element, undeliveredElementException2);
                        }
                        suspendedSenders = InlineList.plus-FjFbRPM(suspendedSenders, sender);
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        segment.onSlotCleaned();
                        continue block1;
                    }
                    if (state == BufferedChannelKt.access$getRESUMING_BY_EB$p() || state == BufferedChannelKt.access$getRESUMING_BY_RCV$p()) break block0;
                    if (state != BufferedChannelKt.access$getRESUMING_BY_EB$p()) continue block1;
                }
            }
            if ((ChannelSegment)segment.getPrev() == null) break;
        }
        boolean bl = false;
        Object object = suspendedSenders;
        if (object != null) {
            if (!(object instanceof ArrayList)) {
                it = (Waiter)suspendedSenders;
                boolean bl2 = false;
                this.resumeSenderOnCancelledChannel(it);
            } else {
                Object object2 = suspendedSenders;
                Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                ArrayList list$iv = (ArrayList)object2;
                for (int i$iv = list$iv.size() - 1; -1 < i$iv; --i$iv) {
                    Waiter it2 = (Waiter)list$iv.get(i$iv);
                    boolean bl3 = false;
                    this.resumeSenderOnCancelledChannel(it2);
                }
            }
        }
        if ((undeliveredElementException = undeliveredElementException2) != null) {
            it = undeliveredElementException;
            boolean bl4 = false;
            throw it;
        }
    }

    /*
     * Unable to fully structure code
     */
    private final void cancelSuspendedReceiveRequests(ChannelSegment<E> lastSegment, long sendersCounter) {
        suspendedReceivers = InlineList.constructor-impl$default(null, 1, null);
        block0: for (segment = lastSegment; segment != null; segment = (ChannelSegment)segment.getPrev()) {
            block1: for (index = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < index; --index) {
                if (segment.id * (long)BufferedChannelKt.SEGMENT_SIZE + (long)index < sendersCounter) break block0;
                do lbl-1000:
                // 4 sources

                {
                    block8: {
                        block7: {
                            state = segment.getState$kotlinx_coroutines_core(index);
                            if (state != null && state != BufferedChannelKt.access$getIN_BUFFER$p()) break block7;
                            if (!segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.getCHANNEL_CLOSED())) ** GOTO lbl-1000
                            segment.onSlotCleaned();
                            continue block1;
                        }
                        if (!(state instanceof WaiterEB)) break block8;
                        if (!segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.getCHANNEL_CLOSED())) ** GOTO lbl-1000
                        suspendedReceivers = InlineList.plus-FjFbRPM(suspendedReceivers, ((WaiterEB)state).waiter);
                        segment.onCancelledRequest(index, true);
                        continue block1;
                    }
                    if (!(state instanceof Waiter)) continue block1;
                } while (!segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.getCHANNEL_CLOSED()));
                suspendedReceivers = InlineList.plus-FjFbRPM(suspendedReceivers, state);
                segment.onCancelledRequest(index, true);
            }
        }
        $i$f$forEachReversed-impl = false;
        var7_6 = suspendedReceivers;
        if (var7_6 != null) {
            if (!(var7_6 instanceof ArrayList)) {
                it = (Waiter)suspendedReceivers;
                $i$a$-forEachReversed-impl-BufferedChannel$cancelSuspendedReceiveRequests$1 = false;
                this.resumeReceiverOnClosedChannel(it);
            } else {
                v0 = suspendedReceivers;
                Intrinsics.checkNotNull((Object)v0, (String)"null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                list$iv = (ArrayList)v0;
                for (i$iv = list$iv.size() - 1; -1 < i$iv; --i$iv) {
                    it = (Waiter)list$iv.get(i$iv);
                    $i$a$-forEachReversed-impl-BufferedChannel$cancelSuspendedReceiveRequests$1 = false;
                    this.resumeReceiverOnClosedChannel(it);
                }
            }
        }
    }

    private final void resumeReceiverOnClosedChannel(Waiter $this$resumeReceiverOnClosedChannel) {
        this.resumeWaiterOnClosedChannel($this$resumeReceiverOnClosedChannel, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter $this$resumeSenderOnCancelledChannel) {
        this.resumeWaiterOnClosedChannel($this$resumeSenderOnCancelledChannel, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter $this$resumeWaiterOnClosedChannel, boolean receiver) {
        Waiter waiter = $this$resumeWaiterOnClosedChannel;
        if (waiter instanceof SendBroadcast) {
            ((Continuation)((SendBroadcast)$this$resumeWaiterOnClosedChannel).getCont()).resumeWith(Result.constructor-impl((Object)false));
        } else if (waiter instanceof CancellableContinuation) {
            ((Continuation)$this$resumeWaiterOnClosedChannel).resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)(receiver ? this.getReceiveException() : this.getSendException()))));
        } else if (waiter instanceof ReceiveCatching) {
            ((Continuation)((ReceiveCatching)$this$resumeWaiterOnClosedChannel).cont).resumeWith(Result.constructor-impl((Object)ChannelResult.box-impl(ChannelResult.Companion.closed-JP2dKIU(this.getCloseCause()))));
        } else if (waiter instanceof BufferedChannelIterator) {
            ((BufferedChannelIterator)$this$resumeWaiterOnClosedChannel).tryResumeHasNextOnClosedChannel();
        } else if (waiter instanceof SelectInstance) {
            ((SelectInstance)((Object)$this$resumeWaiterOnClosedChannel)).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + $this$resumeWaiterOnClosedChannel).toString());
        }
    }

    @Override
    public boolean isClosedForSend() {
        return this.isClosedForSend0(sendersAndCloseStatus$FU.get(this));
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    private final boolean isClosedForSend0(long $this$isClosedForSend0) {
        return this.isClosed($this$isClosedForSend0, false);
    }

    @Override
    public boolean isClosedForReceive() {
        return this.isClosedForReceive0(sendersAndCloseStatus$FU.get(this));
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    private final boolean isClosedForReceive0(long $this$isClosedForReceive0) {
        return this.isClosed($this$isClosedForReceive0, true);
    }

    private final boolean isClosed(long sendersAndCloseStatusCur, boolean isClosedForReceive) {
        boolean bl;
        long $this$sendersCloseStatus$iv = sendersAndCloseStatusCur;
        boolean $i$f$getSendersCloseStatus = false;
        switch ((int)($this$sendersCloseStatus$iv >> 60)) {
            case 0: {
                bl = false;
                break;
            }
            case 1: {
                bl = false;
                break;
            }
            case 2: {
                long $this$sendersCounter$iv = sendersAndCloseStatusCur;
                boolean $i$f$getSendersCounter = false;
                this.completeClose($this$sendersCounter$iv & 0xFFFFFFFFFFFFFFFL);
                if (isClosedForReceive) {
                    if (!this.hasElements$kotlinx_coroutines_core()) {
                        bl = true;
                        break;
                    }
                    bl = false;
                    break;
                }
                bl = true;
                break;
            }
            case 3: {
                long $this$sendersCounter$iv = sendersAndCloseStatusCur;
                boolean $i$f$getSendersCounter = false;
                this.completeCancel($this$sendersCounter$iv & 0xFFFFFFFFFFFFFFFL);
                bl = true;
                break;
            }
            default: {
                $this$sendersCloseStatus$iv = sendersAndCloseStatusCur;
                $i$f$getSendersCloseStatus = false;
                String string = "unexpected close status: " + (int)($this$sendersCloseStatus$iv >> 60);
                throw new IllegalStateException(string.toString());
            }
        }
        return bl;
    }

    @Override
    public boolean isEmpty() {
        if (this.isClosedForReceive()) {
            return false;
        }
        if (this.hasElements$kotlinx_coroutines_core()) {
            return false;
        }
        return !this.isClosedForReceive();
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void isEmpty$annotations() {
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            ChannelSegment<E> segment = (ChannelSegment<E>)receiveSegment$FU.get(this);
            long r = this.getReceiversCounter$kotlinx_coroutines_core();
            long s = this.getSendersCounter$kotlinx_coroutines_core();
            if (s <= r) {
                return false;
            }
            long id = r / (long)BufferedChannelKt.SEGMENT_SIZE;
            if (segment.id != id) {
                ChannelSegment<E> channelSegment = this.findSegmentReceive(id, segment);
                if (channelSegment == null) {
                    if (((ChannelSegment)BufferedChannel.receiveSegment$FU.get(this)).id >= id) continue;
                    return false;
                }
                segment = channelSegment;
            }
            segment.cleanPrev();
            int i2 = (int)(r % (long)BufferedChannelKt.SEGMENT_SIZE);
            if (this.isCellNonEmpty(segment, i2, r)) {
                return true;
            }
            receivers$FU.compareAndSet(this, r, r + 1L);
        }
    }

    private final boolean isCellNonEmpty(ChannelSegment<E> segment, int index, long globalIndex) {
        Object state;
        block8: {
            do {
                state = segment.getState$kotlinx_coroutines_core(index);
                if (state != null && state != BufferedChannelKt.access$getIN_BUFFER$p()) break block8;
            } while (!segment.casState$kotlinx_coroutines_core(index, state, BufferedChannelKt.access$getPOISONED$p()));
            this.expandBuffer();
            return false;
        }
        if (state == BufferedChannelKt.BUFFERED) {
            return true;
        }
        if (state == BufferedChannelKt.access$getINTERRUPTED_SEND$p()) {
            return false;
        }
        if (state == BufferedChannelKt.getCHANNEL_CLOSED()) {
            return false;
        }
        if (state == BufferedChannelKt.access$getDONE_RCV$p()) {
            return false;
        }
        if (state == BufferedChannelKt.access$getPOISONED$p()) {
            return false;
        }
        if (state == BufferedChannelKt.access$getRESUMING_BY_EB$p()) {
            return true;
        }
        if (state == BufferedChannelKt.access$getRESUMING_BY_RCV$p()) {
            return false;
        }
        return globalIndex == this.getReceiversCounter$kotlinx_coroutines_core();
    }

    /*
     * WARNING - void declaration
     */
    private final ChannelSegment<E> findSegmentSend(long id, ChannelSegment<E> startFrom) {
        ChannelSegment channelSegment;
        Object s$iv;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = sendSegment$FU;
        Function2 createNewSegment$iv = (Function2)BufferedChannelKt.createSegmentFunction();
        boolean $i$f$findSegmentAndMoveForward$atomicfu = false;
        while (!SegmentOrClosed.isClosed-impl(s$iv = ConcurrentLinkedListKt.findSegmentInternal((Segment)startFrom, id, createNewSegment$iv))) {
            boolean bl;
            Object to$iv$iv = SegmentOrClosed.getSegment-impl(s$iv);
            boolean $i$f$moveForward$atomicfu = false;
            boolean $i$f$loop$atomicfu = false;
            while (true) {
                void atomicfu$handler$iv;
                Segment cur$iv$iv = (Segment)atomicfu$handler$iv.get(this);
                boolean bl2 = false;
                if (cur$iv$iv.id >= ((Segment)to$iv$iv).id) {
                    bl = true;
                    break;
                }
                if (!((Segment)to$iv$iv).tryIncPointers$kotlinx_coroutines_core()) {
                    bl = false;
                    break;
                }
                if (atomicfu$handler$iv.compareAndSet(this, cur$iv$iv, to$iv$iv)) {
                    if (cur$iv$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv$iv.remove();
                    }
                    bl = true;
                    break;
                }
                if (!((Segment)to$iv$iv).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)to$iv$iv).remove();
            }
            if (!bl) continue;
        }
        Object it = s$iv;
        boolean bl = false;
        if (SegmentOrClosed.isClosed-impl(it)) {
            this.completeCloseOrCancel();
            if (startFrom.id * (long)BufferedChannelKt.SEGMENT_SIZE < this.getReceiversCounter$kotlinx_coroutines_core()) {
                startFrom.cleanPrev();
            }
            channelSegment = null;
        } else {
            ChannelSegment segment = (ChannelSegment)SegmentOrClosed.getSegment-impl(it);
            if (segment.id > id) {
                this.updateSendersCounterIfLower(segment.id * (long)BufferedChannelKt.SEGMENT_SIZE);
                if (segment.id * (long)BufferedChannelKt.SEGMENT_SIZE < this.getReceiversCounter$kotlinx_coroutines_core()) {
                    segment.cleanPrev();
                }
                channelSegment = null;
            } else {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl3 = false;
                    if (!(segment.id == id)) {
                        throw new AssertionError();
                    }
                }
                channelSegment = segment;
            }
        }
        return channelSegment;
    }

    /*
     * WARNING - void declaration
     */
    private final ChannelSegment<E> findSegmentReceive(long id, ChannelSegment<E> startFrom) {
        ChannelSegment channelSegment;
        boolean $i$f$loop$atomicfu;
        boolean $i$f$moveForward$atomicfu;
        Object s$iv;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$FU;
        Function2 createNewSegment$iv = (Function2)BufferedChannelKt.createSegmentFunction();
        boolean $i$f$findSegmentAndMoveForward$atomicfu = false;
        while (!SegmentOrClosed.isClosed-impl(s$iv = ConcurrentLinkedListKt.findSegmentInternal((Segment)startFrom, id, createNewSegment$iv))) {
            boolean bl;
            Object to$iv$iv = SegmentOrClosed.getSegment-impl(s$iv);
            $i$f$moveForward$atomicfu = false;
            $i$f$loop$atomicfu = false;
            while (true) {
                void atomicfu$handler$iv;
                Segment cur$iv$iv = (Segment)atomicfu$handler$iv.get(this);
                boolean bl2 = false;
                if (cur$iv$iv.id >= ((Segment)to$iv$iv).id) {
                    bl = true;
                    break;
                }
                if (!((Segment)to$iv$iv).tryIncPointers$kotlinx_coroutines_core()) {
                    bl = false;
                    break;
                }
                if (atomicfu$handler$iv.compareAndSet(this, cur$iv$iv, to$iv$iv)) {
                    if (cur$iv$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv$iv.remove();
                    }
                    bl = true;
                    break;
                }
                if (!((Segment)to$iv$iv).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)to$iv$iv).remove();
            }
            if (!bl) continue;
        }
        Object it = s$iv;
        boolean bl = false;
        if (SegmentOrClosed.isClosed-impl(it)) {
            this.completeCloseOrCancel();
            if (startFrom.id * (long)BufferedChannelKt.SEGMENT_SIZE < this.getSendersCounter$kotlinx_coroutines_core()) {
                startFrom.cleanPrev();
            }
            channelSegment = null;
        } else {
            ChannelSegment segment = (ChannelSegment)SegmentOrClosed.getSegment-impl(it);
            if (!this.isRendezvousOrUnlimited() && id <= this.getBufferEndCounter() / (long)BufferedChannelKt.SEGMENT_SIZE) {
                AtomicReferenceFieldUpdater atomicfu$handler$iv = bufferEndSegment$FU;
                $i$f$moveForward$atomicfu = false;
                $i$f$loop$atomicfu = false;
                while (true) {
                    Segment cur$iv = (Segment)atomicfu$handler$iv.get(this);
                    boolean bl3 = false;
                    if (cur$iv.id >= ((Segment)segment).id || !((Segment)segment).tryIncPointers$kotlinx_coroutines_core()) break;
                    if (atomicfu$handler$iv.compareAndSet(this, cur$iv, (Segment)segment)) {
                        if (!cur$iv.decPointers$kotlinx_coroutines_core()) break;
                        cur$iv.remove();
                        break;
                    }
                    if (!((Segment)segment).decPointers$kotlinx_coroutines_core()) continue;
                    ((Segment)segment).remove();
                }
            }
            if (segment.id > id) {
                this.updateReceiversCounterIfLower(segment.id * (long)BufferedChannelKt.SEGMENT_SIZE);
                if (segment.id * (long)BufferedChannelKt.SEGMENT_SIZE < this.getSendersCounter$kotlinx_coroutines_core()) {
                    segment.cleanPrev();
                }
                channelSegment = null;
            } else {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl4 = false;
                    if (!(segment.id == id)) {
                        throw new AssertionError();
                    }
                }
                channelSegment = segment;
            }
        }
        return channelSegment;
    }

    /*
     * WARNING - void declaration
     */
    private final ChannelSegment<E> findSegmentBufferEnd(long id, ChannelSegment<E> startFrom, long currentBufferEndCounter) {
        ChannelSegment channelSegment;
        Object s$iv;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$FU;
        Function2 createNewSegment$iv = (Function2)BufferedChannelKt.createSegmentFunction();
        boolean $i$f$findSegmentAndMoveForward$atomicfu = false;
        while (!SegmentOrClosed.isClosed-impl(s$iv = ConcurrentLinkedListKt.findSegmentInternal((Segment)startFrom, id, createNewSegment$iv))) {
            boolean bl;
            Object to$iv$iv = SegmentOrClosed.getSegment-impl(s$iv);
            boolean $i$f$moveForward$atomicfu = false;
            boolean $i$f$loop$atomicfu = false;
            while (true) {
                void atomicfu$handler$iv;
                Segment cur$iv$iv = (Segment)atomicfu$handler$iv.get(this);
                boolean bl2 = false;
                if (cur$iv$iv.id >= ((Segment)to$iv$iv).id) {
                    bl = true;
                    break;
                }
                if (!((Segment)to$iv$iv).tryIncPointers$kotlinx_coroutines_core()) {
                    bl = false;
                    break;
                }
                if (atomicfu$handler$iv.compareAndSet(this, cur$iv$iv, to$iv$iv)) {
                    if (cur$iv$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv$iv.remove();
                    }
                    bl = true;
                    break;
                }
                if (!((Segment)to$iv$iv).decPointers$kotlinx_coroutines_core()) continue;
                ((ConcurrentLinkedListNode)to$iv$iv).remove();
            }
            if (!bl) continue;
        }
        Object it = s$iv;
        boolean bl = false;
        if (SegmentOrClosed.isClosed-impl(it)) {
            this.completeCloseOrCancel();
            this.moveSegmentBufferEndToSpecifiedOrLast(id, startFrom);
            BufferedChannel.incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            channelSegment = null;
        } else {
            ChannelSegment segment = (ChannelSegment)SegmentOrClosed.getSegment-impl(it);
            if (segment.id > id) {
                if (bufferEnd$FU.compareAndSet(this, currentBufferEndCounter + 1L, segment.id * (long)BufferedChannelKt.SEGMENT_SIZE)) {
                    this.incCompletedExpandBufferAttempts(segment.id * (long)BufferedChannelKt.SEGMENT_SIZE - currentBufferEndCounter);
                } else {
                    BufferedChannel.incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                }
                channelSegment = null;
            } else {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl3 = false;
                    if (!(segment.id == id)) {
                        throw new AssertionError();
                    }
                }
                channelSegment = segment;
            }
        }
        return channelSegment;
    }

    private final void moveSegmentBufferEndToSpecifiedOrLast(long id, ChannelSegment<E> startFrom) {
        ChannelSegment segment = startFrom;
        while (segment.id < id && (ChannelSegment)segment.getNext() != null) {
        }
        while (true) {
            boolean bl;
            if (segment.isRemoved() && (ChannelSegment)segment.getNext() != null) {
                continue;
            }
            AtomicReferenceFieldUpdater atomicfu$handler$iv = bufferEndSegment$FU;
            boolean $i$f$moveForward$atomicfu = false;
            boolean $i$f$loop$atomicfu = false;
            while (true) {
                Segment cur$iv = (Segment)atomicfu$handler$iv.get(this);
                boolean bl2 = false;
                if (cur$iv.id >= ((Segment)segment).id) {
                    bl = true;
                    break;
                }
                if (!((Segment)segment).tryIncPointers$kotlinx_coroutines_core()) {
                    bl = false;
                    break;
                }
                if (atomicfu$handler$iv.compareAndSet(this, cur$iv, (Segment)segment)) {
                    if (cur$iv.decPointers$kotlinx_coroutines_core()) {
                        cur$iv.remove();
                    }
                    bl = true;
                    break;
                }
                if (!((Segment)segment).decPointers$kotlinx_coroutines_core()) continue;
                ((Segment)segment).remove();
            }
            if (bl) break;
        }
    }

    private final void updateSendersCounterIfLower(long value) {
        long $this$sendersCloseStatus$iv;
        long curCounter;
        long update;
        long cur;
        BufferedChannel bufferedChannel = this;
        AtomicLongFieldUpdater atomicfu$handler$iv = sendersAndCloseStatus$FU;
        boolean $i$f$loop$atomicfu = false;
        do {
            cur = atomicfu$handler$iv.get(this);
            boolean bl = false;
            long $this$sendersCounter$iv = cur;
            boolean $i$f$getSendersCounter = false;
            curCounter = $this$sendersCounter$iv & 0xFFFFFFFFFFFFFFFL;
            if (curCounter >= value) {
                return;
            }
            $this$sendersCloseStatus$iv = cur;
            boolean $i$f$getSendersCloseStatus = false;
        } while (!sendersAndCloseStatus$FU.compareAndSet(this, cur, update = BufferedChannelKt.access$constructSendersAndCloseStatus(curCounter, (int)($this$sendersCloseStatus$iv >> 60))));
    }

    private final void updateReceiversCounterIfLower(long value) {
        long cur;
        BufferedChannel bufferedChannel = this;
        AtomicLongFieldUpdater atomicfu$handler$iv = receivers$FU;
        boolean $i$f$loop$atomicfu = false;
        do {
            cur = atomicfu$handler$iv.get(this);
            boolean bl = false;
            if (cur < value) continue;
            return;
        } while (!receivers$FU.compareAndSet(this, cur, value));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public String toString() {
        Object t;
        void $this$filterTo$iv$iv;
        StringBuilder sb = new StringBuilder();
        long $this$sendersCloseStatus$iv22 = sendersAndCloseStatus$FU.get(this);
        boolean $i$f$getSendersCloseStatus22 = false;
        switch ((int)($this$sendersCloseStatus$iv22 >> 60)) {
            case 2: {
                sb.append("closed,");
                break;
            }
            case 3: {
                sb.append("cancelled,");
            }
        }
        sb.append("capacity=" + this.capacity + ',');
        sb.append("data=[");
        Object[] $this$sendersCloseStatus$iv22 = new ChannelSegment[]{receiveSegment$FU.get(this), sendSegment$FU.get(this), bufferEndSegment$FU.get(this)};
        Iterable $this$filter$iv = CollectionsKt.listOf((Object[])$this$sendersCloseStatus$iv22);
        boolean $i$f$filter = false;
        Iterable $i$f$getSendersCloseStatus22 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            ChannelSegment it = (ChannelSegment)element$iv$iv;
            boolean bl = false;
            if (!(it != BufferedChannelKt.access$getNULL_SEGMENT$p())) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$minBy$iv = (List)destination$iv$iv;
        boolean $i$f$minByOrThrow = false;
        Iterator iterator$iv = $this$minBy$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new NoSuchElementException();
        }
        Object minElem$iv = iterator$iv.next();
        if (!iterator$iv.hasNext()) {
            t = minElem$iv;
        } else {
            ChannelSegment it = (ChannelSegment)minElem$iv;
            boolean bl = false;
            long minValue$iv = it.id;
            do {
                Object e$iv = iterator$iv.next();
                ChannelSegment it2 = (ChannelSegment)e$iv;
                $i$a$-minByOrThrow-BufferedChannel$toString$firstSegment$2 = false;
                long v$iv = it2.id;
                if (minValue$iv <= v$iv) continue;
                minElem$iv = e$iv;
                minValue$iv = v$iv;
            } while (iterator$iv.hasNext());
            t = minElem$iv;
        }
        ChannelSegment firstSegment = (ChannelSegment)t;
        long r = this.getReceiversCounter$kotlinx_coroutines_core();
        long s = this.getSendersCounter$kotlinx_coroutines_core();
        ChannelSegment segment = firstSegment;
        block6: while (true) {
            int n2 = BufferedChannelKt.SEGMENT_SIZE;
            for (int i2 = 0; i2 < n2; ++i2) {
                String cellStateString;
                String string;
                long globalCellIndex = segment.id * (long)BufferedChannelKt.SEGMENT_SIZE + (long)i2;
                if (globalCellIndex >= s && globalCellIndex >= r) break block6;
                Object cellState = segment.getState$kotlinx_coroutines_core(i2);
                Object element = segment.getElement$kotlinx_coroutines_core(i2);
                Object object = cellState;
                if (object instanceof CancellableContinuation) {
                    string = globalCellIndex < r && globalCellIndex >= s ? "receive" : (globalCellIndex < s && globalCellIndex >= r ? "send" : "cont");
                } else if (object instanceof SelectInstance) {
                    string = globalCellIndex < r && globalCellIndex >= s ? "onReceive" : (globalCellIndex < s && globalCellIndex >= r ? "onSend" : "select");
                } else if (object instanceof ReceiveCatching) {
                    string = "receiveCatching";
                } else if (object instanceof SendBroadcast) {
                    string = "sendBroadcast";
                } else if (object instanceof WaiterEB) {
                    string = "EB(" + cellState + ')';
                } else if (Intrinsics.areEqual((Object)object, (Object)BufferedChannelKt.access$getRESUMING_BY_RCV$p()) ? true : Intrinsics.areEqual((Object)object, (Object)BufferedChannelKt.access$getRESUMING_BY_EB$p())) {
                    string = "resuming_sender";
                } else {
                    Object object2 = object;
                    if ((((((object2 == null ? true : Intrinsics.areEqual((Object)object2, (Object)BufferedChannelKt.access$getIN_BUFFER$p())) ? true : Intrinsics.areEqual((Object)object, (Object)BufferedChannelKt.access$getDONE_RCV$p())) ? true : Intrinsics.areEqual((Object)object, (Object)BufferedChannelKt.access$getPOISONED$p())) ? true : Intrinsics.areEqual((Object)object, (Object)BufferedChannelKt.access$getINTERRUPTED_RCV$p())) ? true : Intrinsics.areEqual((Object)object, (Object)BufferedChannelKt.access$getINTERRUPTED_SEND$p())) ? true : Intrinsics.areEqual((Object)object, (Object)BufferedChannelKt.getCHANNEL_CLOSED())) continue;
                    string = cellStateString = cellState.toString();
                }
                if (element != null) {
                    sb.append('(' + cellStateString + ',' + element + "),");
                    continue;
                }
                sb.append(cellStateString + ',');
            }
            if ((ChannelSegment)segment.getNext() == null) break;
        }
        if (StringsKt.last((CharSequence)sb) == ',') {
            Intrinsics.checkNotNullExpressionValue((Object)sb.deleteCharAt(sb.length() - 1), (String)"this.deleteCharAt(index)");
        }
        sb.append("]");
        return sb.toString();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final String toStringDebug$kotlinx_coroutines_core() {
        Object t;
        void $this$filterTo$iv$iv;
        StringBuilder sb = new StringBuilder();
        long $this$sendersCloseStatus$iv = sendersAndCloseStatus$FU.get(this);
        boolean $i$f$getSendersCloseStatus = false;
        sb.append("S=" + this.getSendersCounter$kotlinx_coroutines_core() + ",R=" + this.getReceiversCounter$kotlinx_coroutines_core() + ",B=" + this.getBufferEndCounter() + ",B'=" + completedExpandBuffersAndPauseFlag$FU.get(this) + ",C=" + (int)($this$sendersCloseStatus$iv >> 60) + ',');
        long $this$sendersCloseStatus$iv22 = sendersAndCloseStatus$FU.get(this);
        boolean $i$f$getSendersCloseStatus22 = false;
        switch ((int)($this$sendersCloseStatus$iv22 >> 60)) {
            case 1: {
                sb.append("CANCELLATION_STARTED,");
                break;
            }
            case 2: {
                sb.append("CLOSED,");
                break;
            }
            case 3: {
                sb.append("CANCELLED,");
            }
        }
        sb.append("SEND_SEGM=" + DebugStringsKt.getHexAddress(sendSegment$FU.get(this)) + ",RCV_SEGM=" + DebugStringsKt.getHexAddress(receiveSegment$FU.get(this)));
        if (!this.isRendezvousOrUnlimited()) {
            sb.append(",EB_SEGM=" + DebugStringsKt.getHexAddress(bufferEndSegment$FU.get(this)));
        }
        sb.append("  ");
        Object[] $this$sendersCloseStatus$iv22 = new ChannelSegment[]{receiveSegment$FU.get(this), sendSegment$FU.get(this), bufferEndSegment$FU.get(this)};
        Iterable $this$filter$iv = CollectionsKt.listOf((Object[])$this$sendersCloseStatus$iv22);
        boolean $i$f$filter = false;
        Iterable $i$f$getSendersCloseStatus22 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            ChannelSegment it = (ChannelSegment)element$iv$iv;
            boolean bl = false;
            if (!(it != BufferedChannelKt.access$getNULL_SEGMENT$p())) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$minBy$iv = (List)destination$iv$iv;
        boolean $i$f$minByOrThrow = false;
        Iterator iterator$iv = $this$minBy$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new NoSuchElementException();
        }
        Object minElem$iv = iterator$iv.next();
        if (!iterator$iv.hasNext()) {
            t = minElem$iv;
        } else {
            ChannelSegment it = (ChannelSegment)minElem$iv;
            boolean bl = false;
            long minValue$iv = it.id;
            do {
                Object e$iv = iterator$iv.next();
                ChannelSegment it2 = (ChannelSegment)e$iv;
                $i$a$-minByOrThrow-BufferedChannel$toStringDebug$firstSegment$2 = false;
                long v$iv = it2.id;
                if (minValue$iv <= v$iv) continue;
                minElem$iv = e$iv;
                minValue$iv = v$iv;
            } while (iterator$iv.hasNext());
            t = minElem$iv;
        }
        ChannelSegment firstSegment = (ChannelSegment)t;
        ChannelSegment segment = null;
        segment = firstSegment;
        while (true) {
            ChannelSegment channelSegment = (ChannelSegment)segment.getPrev();
            sb.append(DebugStringsKt.getHexAddress(segment) + "=[" + (segment.isRemoved() ? "*" : "") + segment.id + ",prev=" + (channelSegment != null ? DebugStringsKt.getHexAddress(channelSegment) : null) + ',');
            int n2 = BufferedChannelKt.SEGMENT_SIZE;
            for (int i2 = 0; i2 < n2; ++i2) {
                int i3 = i2;
                boolean bl = false;
                Object cellState = segment.getState$kotlinx_coroutines_core(i3);
                Object element = segment.getElement$kotlinx_coroutines_core(i3);
                Object object = cellState;
                String cellStateString = object instanceof CancellableContinuation ? "cont" : (object instanceof SelectInstance ? "select" : (object instanceof ReceiveCatching ? "receiveCatching" : (object instanceof SendBroadcast ? "send(broadcast)" : (object instanceof WaiterEB ? "EB(" + cellState + ')' : String.valueOf(cellState)))));
                sb.append("" + '[' + i3 + "]=(" + cellStateString + ',' + element + "),");
            }
            ChannelSegment channelSegment2 = (ChannelSegment)segment.getNext();
            sb.append("next=" + (channelSegment2 != null ? DebugStringsKt.getHexAddress(channelSegment2) : null) + "]  ");
            if ((ChannelSegment)segment.getNext() == null) break;
        }
        return sb.toString();
    }

    /*
     * Unable to fully structure code
     */
    public final void checkSegmentStructureInvariants() {
        if (this.isRendezvousOrUnlimited()) {
            if (!(BufferedChannel.bufferEndSegment$FU.get(this) == BufferedChannelKt.access$getNULL_SEGMENT$p())) {
                $i$a$-check-BufferedChannel$checkSegmentStructureInvariants$1 = false;
                $i$a$-check-BufferedChannel$checkSegmentStructureInvariants$1 = "bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: " + this;
                throw new IllegalStateException($i$a$-check-BufferedChannel$checkSegmentStructureInvariants$1.toString());
            }
        } else if (!(((ChannelSegment)BufferedChannel.receiveSegment$FU.get(this)).id <= ((ChannelSegment)BufferedChannel.bufferEndSegment$FU.get(this)).id)) {
            $i$a$-check-BufferedChannel$checkSegmentStructureInvariants$2 = false;
            $i$a$-check-BufferedChannel$checkSegmentStructureInvariants$2 = "bufferEndSegment should not have lower id than receiveSegment.\nChannel state: " + this;
            throw new IllegalStateException($i$a$-check-BufferedChannel$checkSegmentStructureInvariants$2.toString());
        }
        $i$a$-check-BufferedChannel$checkSegmentStructureInvariants$2 = new ChannelSegment[]{BufferedChannel.receiveSegment$FU.get(this), BufferedChannel.sendSegment$FU.get(this), BufferedChannel.bufferEndSegment$FU.get(this)};
        $this$filter$iv = CollectionsKt.listOf((Object[])$i$a$-check-BufferedChannel$checkSegmentStructureInvariants$2);
        $i$f$filter = false;
        var4_8 = $this$filter$iv;
        destination$iv$iv = new ArrayList<E>();
        $i$f$filterTo = false;
        for (T element$iv$iv : $this$filterTo$iv$iv) {
            it = (ChannelSegment)element$iv$iv;
            $i$a$-filter-BufferedChannel$checkSegmentStructureInvariants$firstSegment$1 = false;
            if (!(it != BufferedChannelKt.access$getNULL_SEGMENT$p())) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$minBy$iv = (List)destination$iv$iv;
        $i$f$minByOrThrow = false;
        iterator$iv = $this$minBy$iv.iterator();
        if (!iterator$iv.hasNext()) {
            throw new NoSuchElementException();
        }
        minElem$iv = iterator$iv.next();
        if (!iterator$iv.hasNext()) {
            v0 = minElem$iv;
        } else {
            it = (ChannelSegment)minElem$iv;
            $i$a$-minByOrThrow-BufferedChannel$checkSegmentStructureInvariants$firstSegment$2 = false;
            minValue$iv = it.id;
            do {
                e$iv = iterator$iv.next();
                it = (ChannelSegment)e$iv;
                $i$a$-minByOrThrow-BufferedChannel$checkSegmentStructureInvariants$firstSegment$2 = false;
                v$iv = it.id;
                if (minValue$iv <= v$iv) continue;
                minElem$iv = e$iv;
                minValue$iv = v$iv;
            } while (iterator$iv.hasNext());
            v0 = minElem$iv;
        }
        firstSegment = (ChannelSegment)v0;
        if (!(firstSegment.getPrev() == null)) {
            $i$a$-check-BufferedChannel$checkSegmentStructureInvariants$3 = false;
            $i$a$-check-BufferedChannel$checkSegmentStructureInvariants$3 = "All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: " + this;
            throw new IllegalStateException($i$a$-check-BufferedChannel$checkSegmentStructureInvariants$3.toString());
        }
        segment = firstSegment;
        while (segment.getNext() != null) {
            v1 = segment.getNext();
            Intrinsics.checkNotNull(v1);
            if (((ChannelSegment)v1).getPrev() == null) ** GOTO lbl-1000
            v2 = segment.getNext();
            Intrinsics.checkNotNull(v2);
            if (((ChannelSegment)v2).getPrev() == segment) lbl-1000:
            // 2 sources

            {
                v3 = true;
            } else {
                v3 = false;
            }
            if (!v3) {
                $i$a$-check-BufferedChannel$checkSegmentStructureInvariants$4 = false;
                $i$a$-check-BufferedChannel$checkSegmentStructureInvariants$4 = "The `segment.next.prev === segment` invariant is violated.\nChannel state: " + this;
                throw new IllegalStateException($i$a$-check-BufferedChannel$checkSegmentStructureInvariants$4.toString());
            }
            interruptedOrClosedCells = 0;
            minElem$iv = BufferedChannelKt.SEGMENT_SIZE;
            for (i = 0; i < minElem$iv; ++i) {
                state = segment.getState$kotlinx_coroutines_core(i);
                if (Intrinsics.areEqual((Object)state, (Object)BufferedChannelKt.BUFFERED) || state instanceof Waiter) continue;
                if ((Intrinsics.areEqual((Object)state, (Object)BufferedChannelKt.access$getINTERRUPTED_RCV$p()) != false ? true : Intrinsics.areEqual((Object)state, (Object)BufferedChannelKt.access$getINTERRUPTED_SEND$p())) != false ? true : Intrinsics.areEqual((Object)state, (Object)BufferedChannelKt.getCHANNEL_CLOSED())) {
                    if (!(segment.getElement$kotlinx_coroutines_core(i) == null)) {
                        var9_24 = "Check failed.";
                        throw new IllegalStateException(var9_24.toString());
                    }
                    ++interruptedOrClosedCells;
                    continue;
                }
                if (Intrinsics.areEqual((Object)state, (Object)BufferedChannelKt.access$getPOISONED$p()) != false ? true : Intrinsics.areEqual((Object)state, (Object)BufferedChannelKt.access$getDONE_RCV$p())) {
                    if (segment.getElement$kotlinx_coroutines_core(i) == null) continue;
                    var9_25 = "Check failed.";
                    throw new IllegalStateException(var9_25.toString());
                }
                throw new IllegalStateException(("Unexpected segment cell state: " + state + ".\nChannel state: " + this).toString());
            }
            if (interruptedOrClosedCells == BufferedChannelKt.SEGMENT_SIZE && !(segment == BufferedChannel.receiveSegment$FU.get(this) || segment == BufferedChannel.sendSegment$FU.get(this) || segment == BufferedChannel.bufferEndSegment$FU.get(this))) {
                $i$a$-check-BufferedChannel$checkSegmentStructureInvariants$5 = false;
                var5_14 = "Logically removed segment is reachable.\nChannel state: " + this;
                throw new IllegalStateException(var5_14.toString());
            }
            v4 = segment.getNext();
            Intrinsics.checkNotNull(v4);
            segment = (ChannelSegment)v4;
        }
    }

    @Override
    @Deprecated(message="Deprecated in the favour of 'trySend' method", replaceWith=@ReplaceWith(expression="trySend(element).isSuccess", imports={}), level=DeprecationLevel.ERROR)
    public boolean offer(E element) {
        return Channel.DefaultImpls.offer(this, element);
    }

    @Override
    @Deprecated(message="Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith=@ReplaceWith(expression="tryReceive().getOrNull()", imports={}), level=DeprecationLevel.ERROR)
    @Nullable
    public E poll() {
        return Channel.DefaultImpls.poll(this);
    }

    @Override
    @Deprecated(message="Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith=@ReplaceWith(expression="receiveCatching().getOrNull()", imports={}), level=DeprecationLevel.ERROR)
    @LowPriorityInOverloadResolution
    @Nullable
    public Object receiveOrNull(@NotNull Continuation<? super E> $completion) {
        return Channel.DefaultImpls.receiveOrNull(this, $completion);
    }

    private final void update$atomicfu(AtomicLongFieldUpdater atomicfu$handler, Function1<? super Long, Long> atomicfu$action, Object atomicfu$dispatchReceiver) {
        Object object;
        long l2;
        boolean $i$f$update$atomicfu = false;
        while (!atomicfu$handler.compareAndSet(atomicfu$dispatchReceiver, l2 = atomicfu$handler.get(atomicfu$dispatchReceiver), ((Number)(object = atomicfu$action.invoke((Object)l2))).longValue())) {
        }
    }

    private final Object getAndUpdate$atomicfu(AtomicReferenceFieldUpdater atomicfu$handler, Function1<Object, ? extends Object> atomicfu$action, Object atomicfu$dispatchReceiver) {
        Object object;
        Object v;
        boolean $i$f$getAndUpdate$atomicfu = false;
        while (!atomicfu$handler.compareAndSet(atomicfu$dispatchReceiver, v = atomicfu$handler.get(atomicfu$dispatchReceiver), object = atomicfu$action.invoke(v))) {
        }
        return v;
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicfu$handler, Function1<Object, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            atomicfu$action.invoke(atomicfu$handler.get(atomicfu$dispatchReceiver));
        }
    }

    private final void loop$atomicfu(AtomicLongFieldUpdater atomicfu$handler, Function1<? super Long, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            long l2 = atomicfu$handler.get(atomicfu$dispatchReceiver);
            atomicfu$action.invoke((Object)l2);
        }
    }

    public static final /* synthetic */ Object access$onClosedSend(BufferedChannel $this, Object element, Continuation $completion) {
        return $this.onClosedSend(element, (Continuation<Unit>)$completion);
    }

    public static final /* synthetic */ Object access$sendOnNoWaiterSuspend(BufferedChannel $this, ChannelSegment segment, int index, Object element, long s, Continuation $completion) {
        return $this.sendOnNoWaiterSuspend(segment, index, element, s, (Continuation<Unit>)$completion);
    }

    public static final /* synthetic */ Object access$receiveOnNoWaiterSuspend(BufferedChannel $this, ChannelSegment segment, int index, long r, Continuation $completion) {
        return $this.receiveOnNoWaiterSuspend(segment, index, r, $completion);
    }

    public static final /* synthetic */ Object access$receiveCatchingOnNoWaiterSuspend-GKJJFZk(BufferedChannel $this, ChannelSegment segment, int index, long r, Continuation $completion) {
        return $this.receiveCatchingOnNoWaiterSuspend-GKJJFZk(segment, index, r, $completion);
    }

    public static final /* synthetic */ Object access$processResultSelectSend(BufferedChannel $this, Object ignoredParam, Object selectResult) {
        return $this.processResultSelectSend(ignoredParam, selectResult);
    }

    public static final /* synthetic */ void access$registerSelectForReceive(BufferedChannel $this, SelectInstance select, Object ignoredParam) {
        $this.registerSelectForReceive(select, ignoredParam);
    }

    public static final /* synthetic */ Object access$processResultSelectReceive(BufferedChannel $this, Object ignoredParam, Object selectResult) {
        return $this.processResultSelectReceive(ignoredParam, selectResult);
    }

    public static final /* synthetic */ Object access$processResultSelectReceiveCatching(BufferedChannel $this, Object ignoredParam, Object selectResult) {
        return $this.processResultSelectReceiveCatching(ignoredParam, selectResult);
    }

    public static final /* synthetic */ Object access$processResultSelectReceiveOrNull(BufferedChannel $this, Object ignoredParam, Object selectResult) {
        return $this.processResultSelectReceiveOrNull(ignoredParam, selectResult);
    }

    public static final /* synthetic */ void access$onClosedReceiveCatchingOnNoWaiterSuspend(BufferedChannel $this, CancellableContinuation cont) {
        $this.onClosedReceiveCatchingOnNoWaiterSuspend(cont);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0013\u0010\u0004\u001a\u00020\u0003H\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J1\u0010\f\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000fH\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001b\u0010\u0017R\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2={"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelSegment;", "segment", "", "index", "", "r", "hasNextOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Segment;", "", "invokeOnCancellation", "(Lkotlinx/coroutines/internal/Segment;I)V", "next", "()Ljava/lang/Object;", "onClosedHasNext", "()Z", "onClosedHasNextNoWaiterSuspend", "()V", "element", "tryResumeHasNext", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "Lkotlinx/coroutines/CancellableContinuationImpl;", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "receiveResult", "Ljava/lang/Object;", "<init>", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n+ 2 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3055:1\n886#2,52:3056\n964#2,8:3112\n858#2:3120\n882#2,33:3121\n974#2:3154\n916#2,14:3155\n935#2,3:3170\n979#2,6:3173\n332#3,4:3108\n336#3,8:3179\n882#4:3169\n61#5,2:3187\n61#5,2:3190\n1#6:3189\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n*L\n1590#1:3056,52\n1627#1:3112,8\n1627#1:3120\n1627#1:3121,33\n1627#1:3154\n1627#1:3155,14\n1627#1:3170,3\n1627#1:3173,6\n1625#1:3108,4\n1625#1:3179,8\n1627#1:3169\n1663#1:3187,2\n1708#1:3190,2\n*E\n"})
    private final class BufferedChannelIterator
    implements ChannelIterator<E>,
    Waiter {
        @Nullable
        private Object receiveResult = BufferedChannelKt.access$getNO_RECEIVE_RESULT$p();
        @Nullable
        private CancellableContinuationImpl<? super Boolean> continuation;

        /*
         * WARNING - void declaration
         */
        @Override
        @Nullable
        public Object hasNext(@NotNull Continuation<? super Boolean> $completion) {
            Boolean bl;
            block4: {
                Object updCellResult$iv;
                int i$iv;
                long r$iv;
                void this_$iv;
                BufferedChannel bufferedChannel = BufferedChannel.this;
                Object waiter$iv = null;
                boolean $i$f$receiveImpl = false;
                ChannelSegment segment$iv = (ChannelSegment)receiveSegment$FU.get(this_$iv);
                while (true) {
                    if (this_$iv.isClosedForReceive()) {
                        boolean bl2 = false;
                        bl = Boxing.boxBoolean((boolean)this.onClosedHasNext());
                        break block4;
                    }
                    r$iv = receivers$FU.getAndIncrement(this_$iv);
                    long id$iv = r$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
                    i$iv = (int)(r$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
                    if (segment$iv.id != id$iv && ((BufferedChannel)this_$iv).findSegmentReceive(id$iv, segment$iv) == null) continue;
                    updCellResult$iv = ((BufferedChannel)this_$iv).updateCellReceive(segment$iv, i$iv, r$iv, waiter$iv);
                    if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                        boolean bl3 = false;
                        throw new IllegalStateException("unreachable".toString());
                    }
                    if (updCellResult$iv != BufferedChannelKt.access$getFAILED$p()) break;
                    if (r$iv >= this_$iv.getSendersCounter$kotlinx_coroutines_core()) continue;
                    segment$iv.cleanPrev();
                }
                if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                    void r;
                    void i2;
                    long l2 = r$iv;
                    int n2 = i$iv;
                    ChannelSegment segm = segment$iv;
                    boolean bl4 = false;
                    return this.hasNextOnNoWaiterSuspend(segm, (int)i2, (long)r, $completion);
                }
                segment$iv.cleanPrev();
                Object element = updCellResult$iv;
                boolean bl5 = false;
                this.receiveResult = element;
                bl = Boxing.boxBoolean((boolean)true);
            }
            return bl;
        }

        private final boolean onClosedHasNext() {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable throwable = BufferedChannel.this.getCloseCause();
            if (throwable == null) {
                return false;
            }
            Throwable cause = throwable;
            throw StackTraceRecoveryKt.recoverStackTrace(cause);
        }

        private final Object hasNextOnNoWaiterSuspend(ChannelSegment<E> segment, int index, long r, Continuation<? super Boolean> $completion) {
            CancellableContinuationImpl<Boolean> cancellable$iv;
            block11: {
                BufferedChannel bufferedChannel = BufferedChannel.this;
                boolean $i$f$suspendCancellableCoroutineReusable = false;
                Continuation<? super Boolean> uCont$iv = $completion;
                boolean bl = false;
                cancellable$iv = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(uCont$iv));
                try {
                    CancellableContinuationImpl<Boolean> cont = cancellable$iv;
                    boolean bl2 = false;
                    this.continuation = cont;
                    BufferedChannel this_$iv = bufferedChannel;
                    boolean $i$f$receiveImplOnNoWaiter = false;
                    Object updCellResult$iv = this_$iv.updateCellReceive(segment, index, r, this);
                    if (updCellResult$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                        this_$iv.prepareReceiverForSuspension(this, segment, index);
                        break block11;
                    }
                    if (updCellResult$iv == BufferedChannelKt.access$getFAILED$p()) {
                        Object updCellResult$iv$iv;
                        int i$iv$iv;
                        if (r < this_$iv.getSendersCounter$kotlinx_coroutines_core()) {
                            segment.cleanPrev();
                        }
                        boolean $i$f$receiveImpl = false;
                        ChannelSegment segment$iv$iv = (ChannelSegment)receiveSegment$FU.get(this_$iv);
                        while (true) {
                            if (this_$iv.isClosedForReceive()) {
                                boolean bl3 = false;
                                this.onClosedHasNextNoWaiterSuspend();
                                break block11;
                            }
                            long r$iv$iv = receivers$FU.getAndIncrement(this_$iv);
                            long id$iv$iv = r$iv$iv / (long)BufferedChannelKt.SEGMENT_SIZE;
                            i$iv$iv = (int)(r$iv$iv % (long)BufferedChannelKt.SEGMENT_SIZE);
                            if (segment$iv$iv.id != id$iv$iv && this_$iv.findSegmentReceive(id$iv$iv, segment$iv$iv) == null) continue;
                            updCellResult$iv$iv = this_$iv.updateCellReceive(segment$iv$iv, i$iv$iv, r$iv$iv, this);
                            if (updCellResult$iv$iv == BufferedChannelKt.access$getSUSPEND$p()) {
                                Waiter waiter = (Waiter)this instanceof Waiter ? (Waiter)this : null;
                                if (waiter != null) {
                                    this_$iv.prepareReceiverForSuspension(waiter, segment$iv$iv, i$iv$iv);
                                }
                                boolean bl4 = false;
                                break block11;
                            }
                            if (updCellResult$iv$iv != BufferedChannelKt.access$getFAILED$p()) break;
                            if (r$iv$iv >= this_$iv.getSendersCounter$kotlinx_coroutines_core()) continue;
                            segment$iv$iv.cleanPrev();
                        }
                        if (updCellResult$iv$iv == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                            int n2 = i$iv$iv;
                            ChannelSegment channelSegment = segment$iv$iv;
                            boolean bl5 = false;
                            throw new IllegalStateException("unexpected".toString());
                        }
                        segment$iv$iv.cleanPrev();
                        Object element = updCellResult$iv$iv;
                        boolean bl6 = false;
                        this.receiveResult = element;
                        this.continuation = null;
                        Function1 function1 = bufferedChannel.onUndeliveredElement;
                        cont.resume(Boxing.boxBoolean((boolean)true), function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, element, cont.getContext()) : null);
                        break block11;
                    }
                    segment.cleanPrev();
                    Object element = updCellResult$iv;
                    boolean bl7 = false;
                    this.receiveResult = element;
                    this.continuation = null;
                    Function1 function1 = bufferedChannel.onUndeliveredElement;
                    cont.resume(Boxing.boxBoolean((boolean)true), function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, element, cont.getContext()) : null);
                }
                catch (Throwable e$iv) {
                    cancellable$iv.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                    throw e$iv;
                }
            }
            Object object = cancellable$iv.getResult();
            if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended($completion);
            }
            return object;
        }

        @Override
        public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
            block0: {
                CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
                if (cancellableContinuationImpl == null) break block0;
                cancellableContinuationImpl.invokeOnCancellation(segment, index);
            }
        }

        private final void onClosedHasNextNoWaiterSuspend() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            CancellableContinuationImpl<? super Boolean> cont = cancellableContinuationImpl;
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable cause = BufferedChannel.this.getCloseCause();
            if (cause == null) {
                ((Continuation)cont).resumeWith(Result.constructor-impl((Object)false));
            } else {
                Continuation continuation = cont;
                boolean $i$f$recoverStackTrace = false;
                Throwable throwable = !DebugKt.getRECOVER_STACK_TRACES() || !((Continuation)cont instanceof CoroutineStackFrame) ? cause : StackTraceRecoveryKt.access$recoverFromStackFrame(cause, (CoroutineStackFrame)((Continuation)cont));
                continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable)));
            }
        }

        @Override
        public E next() {
            Object result2 = this.receiveResult;
            if (!(result2 != BufferedChannelKt.access$getNO_RECEIVE_RESULT$p())) {
                boolean bl = false;
                String string = "`hasNext()` has not been invoked";
                throw new IllegalStateException(string.toString());
            }
            this.receiveResult = BufferedChannelKt.access$getNO_RECEIVE_RESULT$p();
            if (result2 == BufferedChannelKt.getCHANNEL_CLOSED()) {
                throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.this.getReceiveException());
            }
            return result2;
        }

        public final boolean tryResumeHasNext(E element) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            CancellableContinuationImpl<? super Boolean> cont = cancellableContinuationImpl;
            this.continuation = null;
            this.receiveResult = element;
            Function1 function1 = BufferedChannel.this.onUndeliveredElement;
            return BufferedChannelKt.access$tryResume0(cont, true, function1 != null ? OnUndeliveredElementKt.bindCancellationFun(function1, element, cont.getContext()) : null);
        }

        public final void tryResumeHasNextOnClosedChannel() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            CancellableContinuationImpl<? super Boolean> cont = cancellableContinuationImpl;
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable cause = BufferedChannel.this.getCloseCause();
            if (cause == null) {
                ((Continuation)cont).resumeWith(Result.constructor-impl((Object)false));
            } else {
                Continuation continuation = cont;
                boolean $i$f$recoverStackTrace = false;
                Throwable throwable = !DebugKt.getRECOVER_STACK_TRACES() || !((Continuation)cont instanceof CoroutineStackFrame) ? cause : StackTraceRecoveryKt.access$recoverFromStackFrame(cause, (CoroutineStackFrame)((Continuation)cont));
                continuation.resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable)));
            }
        }

        @Override
        @Deprecated(message="Since 1.3.0, binary compatibility with versions <= 1.2.x", level=DeprecationLevel.HIDDEN)
        @JvmName(name="next")
        public /* synthetic */ Object next(Continuation $completion) {
            return ChannelIterator.DefaultImpls.next(this, $completion);
        }

        public static final /* synthetic */ Object access$hasNextOnNoWaiterSuspend(BufferedChannelIterator $this, ChannelSegment segment, int index, long r, Continuation $completion) {
            return $this.hasNextOnNoWaiterSuspend(segment, index, r, (Continuation<? super Boolean>)$completion);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001\u00a2\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2={"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "Lkotlinx/coroutines/internal/Segment;", "segment", "", "index", "", "invokeOnCancellation", "(Lkotlinx/coroutines/internal/Segment;I)V", "Lkotlinx/coroutines/CancellableContinuation;", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "getCont", "()Lkotlinx/coroutines/CancellableContinuation;", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;)V", "kotlinx-coroutines-core"})
    private static final class SendBroadcast
    implements Waiter {
        @NotNull
        private final CancellableContinuation<Boolean> cont;
        private final /* synthetic */ CancellableContinuationImpl<Boolean> $$delegate_0;

        public SendBroadcast(@NotNull CancellableContinuation<? super Boolean> cont) {
            this.cont = cont;
            Intrinsics.checkNotNull(cont, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.$$delegate_0 = (CancellableContinuationImpl)cont;
        }

        @NotNull
        public final CancellableContinuation<Boolean> getCont() {
            return this.cont;
        }

        @Override
        public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
            this.$$delegate_0.invokeOnCancellation(segment, index);
        }
    }
}


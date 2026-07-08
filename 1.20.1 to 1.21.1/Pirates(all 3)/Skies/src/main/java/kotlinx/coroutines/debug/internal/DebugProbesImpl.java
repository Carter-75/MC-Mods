/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.PublishedApi
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.concurrent.ThreadsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.TypeIntrinsics
 *  kotlin.ranges.RangesKt
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.StringsKt
 */
package kotlinx.coroutines.debug.internal;

import _COROUTINE.ArtificialStackFrames;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.debug.internal.AgentInstallationType;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfo;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import kotlinx.coroutines.debug.internal.DebugProbesImplKt;
import kotlinx.coroutines.debug.internal.DebuggerInfo;
import kotlinx.coroutines.debug.internal.StackTraceFrame;
import kotlinx.coroutines.internal.ScopeCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c1\u0002\u0018\u00002\u00020\u0001:\u0002\u009a\u0001B\n\b\u0002\u00a2\u0006\u0005\b\u0099\u0001\u0010?J3\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012\u00a2\u0006\u0004\b\u0013\u0010\u0014J@\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\b\b\u0000\u0010\u0015*\u00020\u00012\u001e\b\u0004\u0010\u0019\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00028\u00000\u0016H\u0082\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\u001c\u0010\rJ\u0013\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e\u00a2\u0006\u0004\b\u001e\u0010\u0011J)\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u000e2\u0006\u0010\u001f\u001a\u00020\u000f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u000e\u00a2\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u000f\u00a2\u0006\u0004\b%\u0010&J5\u0010*\u001a\b\u0012\u0004\u0012\u00020 0\u000e2\u0006\u0010'\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010(2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u000eH\u0002\u00a2\u0006\u0004\b*\u0010+J?\u00100\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,0/2\u0006\u0010-\u001a\u00020,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020 0\u00122\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u000eH\u0002\u00a2\u0006\u0004\b0\u00101J3\u00103\u001a\u00020,2\u0006\u00102\u001a\u00020,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020 0\u00122\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u000eH\u0002\u00a2\u0006\u0004\b3\u00104J\u001d\u00107\u001a\u0010\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u000b\u0018\u000105H\u0002\u00a2\u0006\u0004\b7\u00108J\u0017\u0010=\u001a\u00020$2\u0006\u0010:\u001a\u000209H\u0000\u00a2\u0006\u0004\b;\u0010<J\u000f\u0010@\u001a\u00020\u000bH\u0000\u00a2\u0006\u0004\b>\u0010?J%\u0010B\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020 0\u000eH\u0002\u00a2\u0006\u0004\bB\u0010CJ\u001b\u0010E\u001a\u00020\u000b2\n\u0010D\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002\u00a2\u0006\u0004\bE\u0010FJ)\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0000\u00a2\u0006\u0004\bG\u0010HJ\u001b\u0010L\u001a\u00020\u000b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0000\u00a2\u0006\u0004\bJ\u0010KJ\u001b\u0010N\u001a\u00020\u000b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0000\u00a2\u0006\u0004\bM\u0010KJ'\u0010Q\u001a\b\u0012\u0004\u0012\u00020 0\u000e\"\b\b\u0000\u0010\u0002*\u00020O2\u0006\u0010P\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\bS\u0010?J\u000f\u0010T\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\bT\u0010?J\u000f\u0010V\u001a\u00020\u000bH\u0000\u00a2\u0006\u0004\bU\u0010?J\u001f\u0010X\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020W2\u0006\u0010'\u001a\u00020$H\u0002\u00a2\u0006\u0004\bX\u0010YJ#\u0010Z\u001a\u00020\u000b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010'\u001a\u00020$H\u0002\u00a2\u0006\u0004\bZ\u0010[J/\u0010Z\u001a\u00020\u000b2\n\u0010D\u001a\u0006\u0012\u0002\b\u00030\u00172\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010'\u001a\u00020$H\u0002\u00a2\u0006\u0004\bZ\u0010\\J;\u0010d\u001a\u00020\u000b*\u0002092\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020^0]2\n\u0010b\u001a\u00060`j\u0002`a2\u0006\u0010c\u001a\u00020$H\u0002\u00a2\u0006\u0004\bd\u0010eJ\u0017\u0010f\u001a\u000206*\u0006\u0012\u0002\b\u00030\u0017H\u0002\u00a2\u0006\u0004\bf\u0010gJ\u001d\u0010D\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017*\u0006\u0012\u0002\b\u00030\u0003H\u0002\u00a2\u0006\u0004\bD\u0010hJ\u001a\u0010D\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017*\u00020WH\u0082\u0010\u00a2\u0006\u0004\bD\u0010iJ\u0016\u0010j\u001a\u0004\u0018\u00010W*\u00020WH\u0082\u0010\u00a2\u0006\u0004\bj\u0010kJ\u0019\u0010l\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020 0\u000eH\u0002\u00a2\u0006\u0004\bl\u0010mJ\u0013\u0010n\u001a\u00020$*\u00020\u0001H\u0002\u00a2\u0006\u0004\bn\u0010oR\u0014\u0010p\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR \u0010s\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020^0r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u001e\u0010x\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170u8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bv\u0010wR$\u0010y\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u0002060r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\by\u0010tR\u0014\u0010{\u001a\u00020z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010|R\"\u0010}\u001a\u0010\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u000b\u0018\u0001058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b}\u0010~R'\u0010\u007f\u001a\u0002068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R)\u0010\u0085\u0001\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0080\u0001\u001a\u0006\b\u0086\u0001\u0010\u0082\u0001\"\u0006\b\u0087\u0001\u0010\u0084\u0001R\r\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004R\u0014\u0010\u008b\u0001\u001a\u0002068G\u00a2\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u0082\u0001R)\u0010\u008c\u0001\u001a\u0002068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u0080\u0001\u001a\u0006\b\u008d\u0001\u0010\u0082\u0001\"\u0006\b\u008e\u0001\u0010\u0084\u0001R\r\u0010\u0090\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004R\u001b\u0010\u0091\u0001\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\"\u0010\u0096\u0001\u001a\u00020$*\u0002098BX\u0082\u0004\u00a2\u0006\u000f\u0012\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0005\b\u0093\u0001\u0010<R\u001b\u0010\u0097\u0001\u001a\u000206*\u00020 8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\u00a8\u0006\u009b\u0001"}, d2={"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "", "T", "Lkotlin/coroutines/Continuation;", "completion", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "frame", "createOwner", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/StackTraceFrame;)Lkotlin/coroutines/Continuation;", "Ljava/io/PrintStream;", "out", "", "dumpCoroutines", "(Ljava/io/PrintStream;)V", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "dumpCoroutinesInfo", "()Ljava/util/List;", "", "dumpCoroutinesInfoAsJsonAndReferences", "()[Ljava/lang/Object;", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "Lkotlin/coroutines/CoroutineContext;", "create", "dumpCoroutinesInfoImpl", "(Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "dumpCoroutinesSynchronized", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "dumpDebuggerInfo", "info", "Ljava/lang/StackTraceElement;", "coroutineTrace", "enhanceStackTraceWithThreadDump", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;Ljava/util/List;)Ljava/util/List;", "", "enhanceStackTraceWithThreadDumpAsJson", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;)Ljava/lang/String;", "state", "Ljava/lang/Thread;", "thread", "enhanceStackTraceWithThreadDumpImpl", "(Ljava/lang/String;Ljava/lang/Thread;Ljava/util/List;)Ljava/util/List;", "", "indexOfResumeWith", "actualTrace", "Lkotlin/Pair;", "findContinuationStartIndex", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "frameIndex", "findIndexOfFrame", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "Lkotlin/Function1;", "", "getDynamicAttach", "()Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/Job;", "job", "hierarchyToString$kotlinx_coroutines_core", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "hierarchyToString", "install$kotlinx_coroutines_core", "()V", "install", "frames", "printStackTrace", "(Ljava/io/PrintStream;Ljava/util/List;)V", "owner", "probeCoroutineCompleted", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)V", "probeCoroutineCreated$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "probeCoroutineCreated", "probeCoroutineResumed$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)V", "probeCoroutineResumed", "probeCoroutineSuspended$kotlinx_coroutines_core", "probeCoroutineSuspended", "", "throwable", "sanitizeStackTrace", "(Ljava/lang/Throwable;)Ljava/util/List;", "startWeakRefCleanerThread", "stopWeakRefCleanerThread", "uninstall$kotlinx_coroutines_core", "uninstall", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateRunningState", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Ljava/lang/String;)V", "updateState", "(Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "map", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "indent", "build", "(Lkotlinx/coroutines/Job;Ljava/util/Map;Ljava/lang/StringBuilder;Ljava/lang/String;)V", "isFinished", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Z", "(Lkotlin/coroutines/Continuation;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "realCaller", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "toStackTraceFrame", "(Ljava/util/List;)Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "toStringRepr", "(Ljava/lang/Object;)Ljava/lang/String;", "ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "callerInfoCache", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "getCapturedCoroutines", "()Ljava/util/Set;", "capturedCoroutines", "capturedCoroutinesMap", "Ljava/text/SimpleDateFormat;", "dateFormat", "Ljava/text/SimpleDateFormat;", "dynamicAttach", "Lkotlin/jvm/functions/Function1;", "enableCreationStackTraces", "Z", "getEnableCreationStackTraces$kotlinx_coroutines_core", "()Z", "setEnableCreationStackTraces$kotlinx_coroutines_core", "(Z)V", "ignoreCoroutinesWithEmptyContext", "getIgnoreCoroutinesWithEmptyContext", "setIgnoreCoroutinesWithEmptyContext", "Lkotlinx/atomicfu/AtomicInt;", "installations", "isInstalled$kotlinx_coroutines_debug", "isInstalled", "sanitizeStackTraces", "getSanitizeStackTraces$kotlinx_coroutines_core", "setSanitizeStackTraces$kotlinx_coroutines_core", "Lkotlinx/atomicfu/AtomicLong;", "sequenceNumber", "weakRefCleanerThread", "Ljava/lang/Thread;", "getDebugString", "getDebugString$annotations", "(Lkotlinx/coroutines/Job;)V", "debugString", "isInternalMethod", "(Ljava/lang/StackTraceElement;)Z", "<init>", "CoroutineOwner", "kotlinx-coroutines-core"})
@PublishedApi
@SourceDebugExtension(value={"SMAP\nDebugProbesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,620:1\n150#1:638\n151#1,4:640\n156#1,5:645\n150#1:650\n151#1,4:652\n156#1,5:657\n1#2:621\n1#2:639\n1#2:651\n766#3:622\n857#3,2:623\n1208#3,2:625\n1238#3,4:627\n1855#3,2:665\n350#3,7:673\n1819#3,8:680\n603#4:631\n603#4:644\n603#4:656\n603#4:662\n1295#4,2:663\n37#5,2:632\n37#5,2:634\n37#5,2:636\n1627#6,6:667\n1735#6,6:688\n*S KotlinDebug\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n245#1:638\n245#1:640,4\n245#1:645,5\n252#1:650\n252#1:652,4\n252#1:657,5\n245#1:639\n252#1:651\n110#1:622\n110#1:623,2\n111#1:625,2\n111#1:627,4\n307#1:665,2\n416#1:673,7\n506#1:680,8\n154#1:631\n245#1:644\n252#1:656\n287#1:662\n288#1:663,2\n211#1:632,2\n212#1:634,2\n213#1:636,2\n355#1:667,6\n558#1:688,6\n*E\n"})
public final class DebugProbesImpl {
    @NotNull
    public static final DebugProbesImpl INSTANCE = new DebugProbesImpl();
    @NotNull
    private static final StackTraceElement ARTIFICIAL_FRAME = new ArtificialStackFrames().coroutineCreation();
    @NotNull
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    @Nullable
    private static Thread weakRefCleanerThread;
    @NotNull
    private static final ConcurrentWeakMap<CoroutineOwner<?>, Boolean> capturedCoroutinesMap;
    private static boolean sanitizeStackTraces;
    private static boolean enableCreationStackTraces;
    private static boolean ignoreCoroutinesWithEmptyContext;
    @Nullable
    private static final Function1<Boolean, Unit> dynamicAttach;
    @NotNull
    private static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> callerInfoCache;
    @NotNull
    private static final Installations.kotlinx.VolatileWrapper installations$kotlinx$VolatileWrapper;
    @NotNull
    private static final SequenceNumber.kotlinx.VolatileWrapper sequenceNumber$kotlinx$VolatileWrapper;

    private DebugProbesImpl() {
    }

    private final Set<CoroutineOwner<?>> getCapturedCoroutines() {
        return capturedCoroutinesMap.keySet();
    }

    @JvmName(name="isInstalled$kotlinx_coroutines_debug")
    public final boolean isInstalled$kotlinx_coroutines_debug() {
        return Installations.kotlinx.VolatileWrapper.installations$FU.get(installations$kotlinx$VolatileWrapper) > 0;
    }

    public final boolean getSanitizeStackTraces$kotlinx_coroutines_core() {
        return sanitizeStackTraces;
    }

    public final void setSanitizeStackTraces$kotlinx_coroutines_core(boolean bl) {
        sanitizeStackTraces = bl;
    }

    public final boolean getEnableCreationStackTraces$kotlinx_coroutines_core() {
        return enableCreationStackTraces;
    }

    public final void setEnableCreationStackTraces$kotlinx_coroutines_core(boolean bl) {
        enableCreationStackTraces = bl;
    }

    public final boolean getIgnoreCoroutinesWithEmptyContext() {
        return ignoreCoroutinesWithEmptyContext;
    }

    public final void setIgnoreCoroutinesWithEmptyContext(boolean bl) {
        ignoreCoroutinesWithEmptyContext = bl;
    }

    private final Function1<Boolean, Unit> getDynamicAttach() {
        Object object;
        Object object2 = this;
        try {
            DebugProbesImpl $this$getDynamicAttach_u24lambda_u240 = object2;
            boolean bl = false;
            Class<?> clz = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach");
            Constructor<?> ctor = clz.getConstructors()[0];
            Object obj = ctor.newInstance(new Object[0]);
            Intrinsics.checkNotNull(obj, (String)"null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            object = Result.constructor-impl((Object)((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, (int)1)));
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        object2 = object;
        return (Function1)(Result.isFailure-impl((Object)object2) ? null : object2);
    }

    public final void install$kotlinx_coroutines_core() {
        block2: {
            if (Installations.kotlinx.VolatileWrapper.installations$FU.incrementAndGet(installations$kotlinx$VolatileWrapper) > 1) {
                return;
            }
            this.startWeakRefCleanerThread();
            if (AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core()) {
                return;
            }
            Function1<Boolean, Unit> function1 = dynamicAttach;
            if (function1 == null) break block2;
            function1.invoke((Object)true);
        }
    }

    public final void uninstall$kotlinx_coroutines_core() {
        block3: {
            if (!this.isInstalled$kotlinx_coroutines_debug()) {
                boolean bl = false;
                String string = "Agent was not installed";
                throw new IllegalStateException(string.toString());
            }
            if (Installations.kotlinx.VolatileWrapper.installations$FU.decrementAndGet(installations$kotlinx$VolatileWrapper) != 0) {
                return;
            }
            this.stopWeakRefCleanerThread();
            capturedCoroutinesMap.clear();
            callerInfoCache.clear();
            if (AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core()) {
                return;
            }
            Function1<Boolean, Unit> function1 = dynamicAttach;
            if (function1 == null) break block3;
            function1.invoke((Object)false);
        }
    }

    private final void startWeakRefCleanerThread() {
        weakRefCleanerThread = ThreadsKt.thread$default((boolean)false, (boolean)true, null, (String)"Coroutines Debugger Cleaner", (int)0, (Function0)startWeakRefCleanerThread.1.INSTANCE, (int)21, null);
    }

    private final void stopWeakRefCleanerThread() {
        Thread thread = weakRefCleanerThread;
        if (thread == null) {
            return;
        }
        Thread thread2 = thread;
        weakRefCleanerThread = null;
        thread2.interrupt();
        thread2.join();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final String hierarchyToString$kotlinx_coroutines_core(@NotNull Job job) {
        StringBuilder stringBuilder;
        void $this$associateByTo$iv$iv;
        void $this$filterTo$iv$iv;
        if (!this.isInstalled$kotlinx_coroutines_debug()) {
            boolean $i$a$-check-DebugProbesImpl$hierarchyToString$22 = false;
            String $i$a$-check-DebugProbesImpl$hierarchyToString$22 = "Debug probes are not installed";
            throw new IllegalStateException($i$a$-check-DebugProbesImpl$hierarchyToString$22.toString());
        }
        Iterable $this$filter$iv = this.getCapturedCoroutines();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Iterable destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            CoroutineOwner it = (CoroutineOwner)element$iv$iv;
            boolean bl = false;
            if (!(it.delegate.getContext().get((CoroutineContext.Key)Job.Key) != null)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$associateBy$iv = (List)destination$iv$iv;
        boolean $i$f$associateBy = false;
        int capacity$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateBy$iv, (int)10)), (int)16);
        destination$iv$iv = $this$associateBy$iv;
        Map destination$iv$iv2 = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv : $this$associateByTo$iv$iv) {
            CoroutineOwner bl = (CoroutineOwner)element$iv$iv;
            Map map2 = destination$iv$iv2;
            boolean bl2 = false;
            CoroutineOwner it = (CoroutineOwner)element$iv$iv;
            Job job2 = JobKt.getJob(it.delegate.getContext());
            boolean bl3 = false;
            DebugCoroutineInfoImpl debugCoroutineInfoImpl = it.info;
            map2.put(job2, debugCoroutineInfoImpl);
        }
        Map jobToStack = destination$iv$iv2;
        StringBuilder $this$hierarchyToString_u24lambda_u246 = stringBuilder = new StringBuilder();
        boolean bl = false;
        INSTANCE.build(job, jobToStack, $this$hierarchyToString_u24lambda_u246, "");
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private final void build(Job $this$build, Map<Job, DebugCoroutineInfoImpl> map2, StringBuilder builder, String indent) {
        DebugCoroutineInfoImpl info = map2.get($this$build);
        String newIndent = null;
        if (info == null) {
            if (!($this$build instanceof ScopeCoroutine)) {
                builder.append(indent + this.getDebugString($this$build) + '\n');
                newIndent = indent + '\t';
            } else {
                newIndent = indent;
            }
        } else {
            StackTraceElement element = (StackTraceElement)CollectionsKt.firstOrNull(info.lastObservedStackTrace$kotlinx_coroutines_core());
            String state = info.getState$kotlinx_coroutines_core();
            builder.append(indent + this.getDebugString($this$build) + ", continuation is " + state + " at line " + element + '\n');
            newIndent = indent + '\t';
        }
        for (Job child : $this$build.getChildren()) {
            this.build(child, map2, builder, newIndent);
        }
    }

    private final String getDebugString(Job $this$debugString) {
        return $this$debugString instanceof JobSupport ? ((JobSupport)$this$debugString).toDebugString() : $this$debugString.toString();
    }

    private static /* synthetic */ void getDebugString$annotations(Job job) {
    }

    private final <R> List<R> dumpCoroutinesInfoImpl(Function2<? super CoroutineOwner<?>, ? super CoroutineContext, ? extends R> create) {
        boolean $i$f$dumpCoroutinesInfoImpl = false;
        if (!this.isInstalled$kotlinx_coroutines_debug()) {
            boolean $i$a$-check-DebugProbesImpl$dumpCoroutinesInfoImpl$22 = false;
            String $i$a$-check-DebugProbesImpl$dumpCoroutinesInfoImpl$22 = "Debug probes are not installed";
            throw new IllegalStateException($i$a$-check-DebugProbesImpl$dumpCoroutinesInfoImpl$22.toString());
        }
        Sequence $this$sortedBy$iv = CollectionsKt.asSequence((Iterable)this.getCapturedCoroutines());
        boolean $i$f$sortedBy = false;
        return SequencesKt.toList((Sequence)SequencesKt.mapNotNull((Sequence)SequencesKt.sortedWith((Sequence)$this$sortedBy$iv, (Comparator)new Comparator(){

            public final int compare(T a2, T b2) {
                CoroutineOwner it = (CoroutineOwner)a2;
                boolean bl = false;
                it = (CoroutineOwner)b2;
                Comparable comparable = Long.valueOf(it.info.sequenceNumber);
                bl = false;
                return ComparisonsKt.compareValues((Comparable)comparable, (Comparable)Long.valueOf(it.info.sequenceNumber));
            }
        }), (Function1)new Function1<CoroutineOwner<?>, R>(create){
            final /* synthetic */ Function2<CoroutineOwner<?>, CoroutineContext, R> $create;
            {
                this.$create = $create;
                super(1);
            }

            @Nullable
            public final R invoke(@NotNull CoroutineOwner<?> owner) {
                Object object;
                if (DebugProbesImpl.access$isFinished(DebugProbesImpl.INSTANCE, owner)) {
                    object = null;
                } else {
                    CoroutineContext coroutineContext = owner.info.getContext();
                    if (coroutineContext != null) {
                        CoroutineContext coroutineContext2 = coroutineContext;
                        Function2<CoroutineOwner<?>, CoroutineContext, R> function2 = this.$create;
                        CoroutineContext context = coroutineContext2;
                        boolean bl = false;
                        object = function2.invoke(owner, (Object)context);
                    } else {
                        object = null;
                    }
                }
                return (R)object;
            }
        }));
    }

    @NotNull
    public final Object[] dumpCoroutinesInfoAsJsonAndReferences() {
        List<DebugCoroutineInfo> coroutinesInfo = this.dumpCoroutinesInfo();
        int size = coroutinesInfo.size();
        ArrayList<Thread> lastObservedThreads = new ArrayList<Thread>(size);
        ArrayList<CoroutineStackFrame> lastObservedFrames = new ArrayList<CoroutineStackFrame>(size);
        ArrayList<String> coroutinesInfoAsJson = new ArrayList<String>(size);
        for (DebugCoroutineInfo info : coroutinesInfo) {
            CoroutineContext context = info.getContext();
            Object object = (CoroutineName)context.get((CoroutineContext.Key)CoroutineName.Key);
            String name = object != null && (object = object.getName()) != null ? this.toStringRepr(object) : null;
            CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher)context.get((CoroutineContext.Key)CoroutineDispatcher.Key);
            String dispatcher = coroutineDispatcher != null ? this.toStringRepr((Object)coroutineDispatcher) : null;
            CoroutineId coroutineId = (CoroutineId)context.get((CoroutineContext.Key)CoroutineId.Key);
            coroutinesInfoAsJson.add(StringsKt.trimIndent((String)("\n                {\n                    \"name\": " + name + ",\n                    \"id\": " + (coroutineId != null ? Long.valueOf(coroutineId.getId()) : null) + ",\n                    \"dispatcher\": " + dispatcher + ",\n                    \"sequenceNumber\": " + info.getSequenceNumber() + ",\n                    \"state\": \"" + info.getState() + "\"\n                } \n                ")));
            lastObservedFrames.add(info.getLastObservedFrame());
            lastObservedThreads.add(info.getLastObservedThread());
        }
        Object[] objectArray = new Object[4];
        objectArray[0] = '[' + CollectionsKt.joinToString$default((Iterable)coroutinesInfoAsJson, null, null, null, (int)0, null, null, (int)63, null) + ']';
        Collection $this$toTypedArray$iv = lastObservedThreads;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        objectArray[1] = thisCollection$iv.toArray(new Thread[0]);
        $this$toTypedArray$iv = lastObservedFrames;
        $i$f$toTypedArray = false;
        thisCollection$iv = $this$toTypedArray$iv;
        objectArray[2] = thisCollection$iv.toArray(new CoroutineStackFrame[0]);
        $this$toTypedArray$iv = coroutinesInfo;
        $i$f$toTypedArray = false;
        thisCollection$iv = $this$toTypedArray$iv;
        objectArray[3] = thisCollection$iv.toArray(new DebugCoroutineInfo[0]);
        return objectArray;
    }

    @NotNull
    public final String enhanceStackTraceWithThreadDumpAsJson(@NotNull DebugCoroutineInfo info) {
        List<StackTraceElement> stackTraceElements = this.enhanceStackTraceWithThreadDump(info, info.lastObservedStackTrace());
        List stackTraceElementsInfoAsJson = new ArrayList();
        for (StackTraceElement element : stackTraceElements) {
            String string = element.getFileName();
            stackTraceElementsInfoAsJson.add(StringsKt.trimIndent((String)("\n                {\n                    \"declaringClass\": \"" + element.getClassName() + "\",\n                    \"methodName\": \"" + element.getMethodName() + "\",\n                    \"fileName\": " + (string != null ? this.toStringRepr(string) : null) + ",\n                    \"lineNumber\": " + element.getLineNumber() + "\n                }\n                ")));
        }
        return '[' + CollectionsKt.joinToString$default((Iterable)stackTraceElementsInfoAsJson, null, null, null, (int)0, null, null, (int)63, null) + ']';
    }

    private final String toStringRepr(Object $this$toStringRepr) {
        return DebugProbesImplKt.access$repr($this$toStringRepr.toString());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<DebugCoroutineInfo> dumpCoroutinesInfo() {
        void $this$sortedBy$iv$iv;
        DebugProbesImpl this_$iv = this;
        boolean $i$f$dumpCoroutinesInfoImpl = false;
        if (!this_$iv.isInstalled$kotlinx_coroutines_debug()) {
            boolean $i$a$-check-DebugProbesImpl$dumpCoroutinesInfoImpl$1$iv22 = false;
            String $i$a$-check-DebugProbesImpl$dumpCoroutinesInfoImpl$1$iv22 = "Debug probes are not installed";
            throw new IllegalStateException($i$a$-check-DebugProbesImpl$dumpCoroutinesInfoImpl$1$iv22.toString());
        }
        Sequence sequence = CollectionsKt.asSequence((Iterable)this_$iv.getCapturedCoroutines());
        boolean $i$f$sortedBy = false;
        return SequencesKt.toList((Sequence)SequencesKt.mapNotNull((Sequence)SequencesKt.sortedWith((Sequence)$this$sortedBy$iv$iv, (Comparator)new /* invalid duplicate definition of identical inner class */), (Function1)new Function1<CoroutineOwner<?>, DebugCoroutineInfo>(){

            /*
             * WARNING - void declaration
             */
            @Nullable
            public final DebugCoroutineInfo invoke(@NotNull CoroutineOwner<?> owner) {
                DebugCoroutineInfo debugCoroutineInfo;
                if (DebugProbesImpl.access$isFinished(DebugProbesImpl.INSTANCE, owner)) {
                    debugCoroutineInfo = null;
                } else {
                    CoroutineContext coroutineContext = owner.info.getContext();
                    if (coroutineContext != null) {
                        void context;
                        CoroutineContext context2 = coroutineContext;
                        boolean bl = false;
                        CoroutineContext coroutineContext2 = context2;
                        CoroutineOwner<?> owner2 = owner;
                        boolean bl2 = false;
                        debugCoroutineInfo = new DebugCoroutineInfo(owner2.info, (CoroutineContext)context);
                    } else {
                        debugCoroutineInfo = null;
                    }
                }
                return debugCoroutineInfo;
            }
        }));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<DebuggerInfo> dumpDebuggerInfo() {
        void $this$sortedBy$iv$iv;
        DebugProbesImpl this_$iv = this;
        boolean $i$f$dumpCoroutinesInfoImpl = false;
        if (!this_$iv.isInstalled$kotlinx_coroutines_debug()) {
            boolean $i$a$-check-DebugProbesImpl$dumpCoroutinesInfoImpl$1$iv22 = false;
            String $i$a$-check-DebugProbesImpl$dumpCoroutinesInfoImpl$1$iv22 = "Debug probes are not installed";
            throw new IllegalStateException($i$a$-check-DebugProbesImpl$dumpCoroutinesInfoImpl$1$iv22.toString());
        }
        Sequence sequence = CollectionsKt.asSequence((Iterable)this_$iv.getCapturedCoroutines());
        boolean $i$f$sortedBy = false;
        return SequencesKt.toList((Sequence)SequencesKt.mapNotNull((Sequence)SequencesKt.sortedWith((Sequence)$this$sortedBy$iv$iv, (Comparator)new /* invalid duplicate definition of identical inner class */), (Function1)new Function1<CoroutineOwner<?>, DebuggerInfo>(){

            /*
             * WARNING - void declaration
             */
            @Nullable
            public final DebuggerInfo invoke(@NotNull CoroutineOwner<?> owner) {
                DebuggerInfo debuggerInfo;
                if (DebugProbesImpl.access$isFinished(DebugProbesImpl.INSTANCE, owner)) {
                    debuggerInfo = null;
                } else {
                    CoroutineContext coroutineContext = owner.info.getContext();
                    if (coroutineContext != null) {
                        void context;
                        CoroutineContext context2 = coroutineContext;
                        boolean bl = false;
                        CoroutineContext coroutineContext2 = context2;
                        CoroutineOwner<?> owner2 = owner;
                        boolean bl2 = false;
                        debuggerInfo = new DebuggerInfo(owner2.info, (CoroutineContext)context);
                    } else {
                        debuggerInfo = null;
                    }
                }
                return debuggerInfo;
            }
        }));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @JvmName(name="dumpCoroutines")
    public final void dumpCoroutines(@NotNull PrintStream out) {
        PrintStream printStream = out;
        synchronized (printStream) {
            boolean bl = false;
            INSTANCE.dumpCoroutinesSynchronized(out);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final boolean isFinished(CoroutineOwner<?> $this$isFinished) {
        Object object = $this$isFinished.info.getContext();
        if (object == null || (object = (Job)object.get((CoroutineContext.Key)Job.Key)) == null) {
            return false;
        }
        Object job = object;
        if (!job.isCompleted()) {
            return false;
        }
        capturedCoroutinesMap.remove($this$isFinished);
        return true;
    }

    private final void dumpCoroutinesSynchronized(PrintStream out) {
        if (!this.isInstalled$kotlinx_coroutines_debug()) {
            boolean $i$a$-check-DebugProbesImpl$dumpCoroutinesSynchronized$22 = false;
            String $i$a$-check-DebugProbesImpl$dumpCoroutinesSynchronized$22 = "Debug probes are not installed";
            throw new IllegalStateException($i$a$-check-DebugProbesImpl$dumpCoroutinesSynchronized$22.toString());
        }
        out.print("Coroutines dump " + dateFormat.format(System.currentTimeMillis()));
        Sequence $this$sortedBy$iv = SequencesKt.filter((Sequence)CollectionsKt.asSequence((Iterable)this.getCapturedCoroutines()), (Function1)dumpCoroutinesSynchronized.2.INSTANCE);
        boolean $i$f$sortedBy = false;
        Sequence $this$forEach$iv = SequencesKt.sortedWith((Sequence)$this$sortedBy$iv, (Comparator)new Comparator(){

            public final int compare(T a2, T b2) {
                CoroutineOwner it = (CoroutineOwner)a2;
                boolean bl = false;
                it = (CoroutineOwner)b2;
                Comparable comparable = Long.valueOf(it.info.sequenceNumber);
                bl = false;
                return ComparisonsKt.compareValues((Comparable)comparable, (Comparable)Long.valueOf(it.info.sequenceNumber));
            }
        });
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            CoroutineOwner owner = (CoroutineOwner)element$iv;
            boolean bl = false;
            DebugCoroutineInfoImpl info = owner.info;
            List<StackTraceElement> observedStackTrace = info.lastObservedStackTrace$kotlinx_coroutines_core();
            List<StackTraceElement> enhancedStackTrace = INSTANCE.enhanceStackTraceWithThreadDumpImpl(info.getState$kotlinx_coroutines_core(), info.lastObservedThread, observedStackTrace);
            String state = Intrinsics.areEqual((Object)info.getState$kotlinx_coroutines_core(), (Object)"RUNNING") && enhancedStackTrace == observedStackTrace ? info.getState$kotlinx_coroutines_core() + " (Last suspension stacktrace, not an actual stacktrace)" : info.getState$kotlinx_coroutines_core();
            out.print("\n\nCoroutine " + owner.delegate + ", state: " + state);
            if (observedStackTrace.isEmpty()) {
                out.print("\n\tat " + ARTIFICIAL_FRAME);
                INSTANCE.printStackTrace(out, info.getCreationStackTrace());
                continue;
            }
            INSTANCE.printStackTrace(out, enhancedStackTrace);
        }
    }

    private final void printStackTrace(PrintStream out, List<StackTraceElement> frames) {
        Iterable $this$forEach$iv = frames;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            StackTraceElement frame = (StackTraceElement)element$iv;
            boolean bl = false;
            out.print("\n\tat " + frame);
        }
    }

    @NotNull
    public final List<StackTraceElement> enhanceStackTraceWithThreadDump(@NotNull DebugCoroutineInfo info, @NotNull List<StackTraceElement> coroutineTrace) {
        return this.enhanceStackTraceWithThreadDumpImpl(info.getState(), info.getLastObservedThread(), coroutineTrace);
    }

    private final List<StackTraceElement> enhanceStackTraceWithThreadDumpImpl(String state, Thread thread, List<StackTraceElement> coroutineTrace) {
        int index;
        int n2;
        StackTraceElement[] actualTrace;
        Pair<Integer, Integer> pair;
        block8: {
            Object $this$enhanceStackTraceWithThreadDumpImpl_u24lambda_u2416;
            if (!Intrinsics.areEqual((Object)state, (Object)"RUNNING") || thread == null) {
                return coroutineTrace;
            }
            pair = this;
            try {
                $this$enhanceStackTraceWithThreadDumpImpl_u24lambda_u2416 = pair;
                boolean bl = false;
                $this$enhanceStackTraceWithThreadDumpImpl_u24lambda_u2416 = Result.constructor-impl((Object)thread.getStackTrace());
            }
            catch (Throwable bl) {
                $this$enhanceStackTraceWithThreadDumpImpl_u24lambda_u2416 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl));
            }
            pair = $this$enhanceStackTraceWithThreadDumpImpl_u24lambda_u2416;
            StackTraceElement[] stackTraceElementArray = (StackTraceElement[])(Result.isFailure-impl((Object)pair) ? null : pair);
            if (stackTraceElementArray == null) {
                return coroutineTrace;
            }
            StackTraceElement[] $this$indexOfFirst$iv = actualTrace = stackTraceElementArray;
            boolean $i$f$indexOfFirst = false;
            int n3 = $this$indexOfFirst$iv.length;
            for (int index$iv = 0; index$iv < n3; ++index$iv) {
                StackTraceElement it = $this$indexOfFirst$iv[index$iv];
                boolean bl = false;
                boolean bl2 = Intrinsics.areEqual((Object)it.getClassName(), (Object)"kotlin.coroutines.jvm.internal.BaseContinuationImpl") && Intrinsics.areEqual((Object)it.getMethodName(), (Object)"resumeWith") && Intrinsics.areEqual((Object)it.getFileName(), (Object)"ContinuationImpl.kt");
                if (!bl2) continue;
                n2 = index$iv;
                break block8;
            }
            n2 = -1;
        }
        int indexOfResumeWith = n2;
        pair = this.findContinuationStartIndex(indexOfResumeWith, actualTrace, coroutineTrace);
        int continuationStartFrame = ((Number)pair.component1()).intValue();
        int delta = ((Number)pair.component2()).intValue();
        if (continuationStartFrame == -1) {
            return coroutineTrace;
        }
        int expectedSize = indexOfResumeWith + coroutineTrace.size() - continuationStartFrame - 1 - delta;
        ArrayList result2 = new ArrayList(expectedSize);
        int n4 = indexOfResumeWith - delta;
        for (index = 0; index < n4; ++index) {
            ((Collection)result2).add(actualTrace[index]);
        }
        n4 = coroutineTrace.size();
        for (index = continuationStartFrame + 1; index < n4; ++index) {
            ((Collection)result2).add(coroutineTrace.get(index));
        }
        return result2;
    }

    private final Pair<Integer, Integer> findContinuationStartIndex(int indexOfResumeWith, StackTraceElement[] actualTrace, List<StackTraceElement> coroutineTrace) {
        int n2 = 3;
        int n3 = 0;
        while (n3 < n2) {
            int it = n3++;
            boolean bl = false;
            int result2 = INSTANCE.findIndexOfFrame(indexOfResumeWith - 1 - it, actualTrace, coroutineTrace);
            if (result2 == -1) continue;
            return TuplesKt.to((Object)result2, (Object)it);
        }
        return TuplesKt.to((Object)-1, (Object)0);
    }

    private final int findIndexOfFrame(int frameIndex, StackTraceElement[] actualTrace, List<StackTraceElement> coroutineTrace) {
        int n2;
        block3: {
            StackTraceElement stackTraceElement = (StackTraceElement)ArraysKt.getOrNull((Object[])actualTrace, (int)frameIndex);
            if (stackTraceElement == null) {
                return -1;
            }
            StackTraceElement continuationFrame = stackTraceElement;
            List<StackTraceElement> $this$indexOfFirst$iv = coroutineTrace;
            boolean $i$f$indexOfFirst = false;
            int index$iv = 0;
            Iterator<StackTraceElement> iterator2 = $this$indexOfFirst$iv.iterator();
            while (iterator2.hasNext()) {
                StackTraceElement item$iv;
                StackTraceElement it = item$iv = iterator2.next();
                boolean bl = false;
                boolean bl2 = Intrinsics.areEqual((Object)it.getFileName(), (Object)continuationFrame.getFileName()) && Intrinsics.areEqual((Object)it.getClassName(), (Object)continuationFrame.getClassName()) && Intrinsics.areEqual((Object)it.getMethodName(), (Object)continuationFrame.getMethodName());
                if (bl2) {
                    n2 = index$iv;
                    break block3;
                }
                ++index$iv;
            }
            n2 = -1;
        }
        return n2;
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(@NotNull Continuation<?> frame) {
        this.updateState(frame, "RUNNING");
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(@NotNull Continuation<?> frame) {
        this.updateState(frame, "SUSPENDED");
    }

    private final void updateState(Continuation<?> frame, String state) {
        if (!this.isInstalled$kotlinx_coroutines_debug()) {
            return;
        }
        if (ignoreCoroutinesWithEmptyContext && frame.getContext() == EmptyCoroutineContext.INSTANCE) {
            return;
        }
        if (Intrinsics.areEqual((Object)state, (Object)"RUNNING")) {
            CoroutineStackFrame coroutineStackFrame = frame instanceof CoroutineStackFrame ? (CoroutineStackFrame)frame : null;
            if (coroutineStackFrame == null) {
                return;
            }
            CoroutineStackFrame stackFrame = coroutineStackFrame;
            this.updateRunningState(stackFrame, state);
            return;
        }
        CoroutineOwner<?> coroutineOwner = this.owner(frame);
        if (coroutineOwner == null) {
            return;
        }
        CoroutineOwner<?> owner = coroutineOwner;
        this.updateState(owner, frame, state);
    }

    private final void updateRunningState(CoroutineStackFrame frame, String state) {
        if (!this.isInstalled$kotlinx_coroutines_debug()) {
            return;
        }
        Object info = null;
        DebugCoroutineInfoImpl cached = callerInfoCache.remove(frame);
        boolean shouldBeMatchedWithProbeSuspended = false;
        if (cached != null) {
            info = cached;
            shouldBeMatchedWithProbeSuspended = false;
        } else {
            CoroutineStackFrame realCaller;
            CoroutineOwner<?> coroutineOwner = this.owner(frame);
            if (coroutineOwner == null || (coroutineOwner = coroutineOwner.info) == null) {
                return;
            }
            info = coroutineOwner;
            shouldBeMatchedWithProbeSuspended = true;
            CoroutineStackFrame coroutineStackFrame = ((DebugCoroutineInfoImpl)info).getLastObservedFrame$kotlinx_coroutines_core();
            CoroutineStackFrame coroutineStackFrame2 = realCaller = coroutineStackFrame != null ? this.realCaller(coroutineStackFrame) : null;
            if (realCaller != null) {
                callerInfoCache.remove(realCaller);
            }
        }
        Intrinsics.checkNotNull((Object)frame, (String)"null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
        ((DebugCoroutineInfoImpl)info).updateState$kotlinx_coroutines_core(state, (Continuation)frame, shouldBeMatchedWithProbeSuspended);
        CoroutineStackFrame coroutineStackFrame = this.realCaller(frame);
        if (coroutineStackFrame == null) {
            return;
        }
        CoroutineStackFrame caller = coroutineStackFrame;
        ((Map)((Object)callerInfoCache)).put(caller, info);
    }

    private final CoroutineStackFrame realCaller(CoroutineStackFrame $this$realCaller) {
        CoroutineStackFrame caller;
        while (true) {
            if ($this$realCaller.getCallerFrame() == null) {
                return null;
            }
            if (caller.getStackTraceElement() != null) break;
            $this$realCaller = caller;
        }
        return caller;
    }

    private final void updateState(CoroutineOwner<?> owner, Continuation<?> frame, String state) {
        if (!this.isInstalled$kotlinx_coroutines_debug()) {
            return;
        }
        owner.info.updateState$kotlinx_coroutines_core(state, frame, true);
    }

    private final CoroutineOwner<?> owner(Continuation<?> $this$owner) {
        CoroutineStackFrame coroutineStackFrame = $this$owner instanceof CoroutineStackFrame ? (CoroutineStackFrame)$this$owner : null;
        return coroutineStackFrame != null ? this.owner(coroutineStackFrame) : null;
    }

    private final CoroutineOwner<?> owner(CoroutineStackFrame $this$owner) {
        CoroutineOwner coroutineOwner;
        block2: {
            while (true) {
                if ($this$owner instanceof CoroutineOwner) {
                    coroutineOwner = (CoroutineOwner)$this$owner;
                    break block2;
                }
                CoroutineStackFrame coroutineStackFrame = $this$owner.getCallerFrame();
                if (coroutineStackFrame == null) break;
                $this$owner = coroutineStackFrame;
            }
            coroutineOwner = null;
        }
        return coroutineOwner;
    }

    @NotNull
    public final <T> Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(@NotNull Continuation<? super T> completion) {
        if (!this.isInstalled$kotlinx_coroutines_debug()) {
            return completion;
        }
        if (ignoreCoroutinesWithEmptyContext && completion.getContext() == EmptyCoroutineContext.INSTANCE) {
            return completion;
        }
        CoroutineOwner<?> owner = this.owner(completion);
        if (owner != null) {
            return completion;
        }
        StackTraceFrame frame = enableCreationStackTraces ? this.toStackTraceFrame(this.sanitizeStackTrace((Throwable)new Exception())) : null;
        return this.createOwner(completion, frame);
    }

    /*
     * WARNING - void declaration
     */
    private final StackTraceFrame toStackTraceFrame(List<StackTraceElement> $this$toStackTraceFrame) {
        void $this$foldRight$iv;
        List<StackTraceElement> list = $this$toStackTraceFrame;
        StackTraceFrame initial$iv = null;
        boolean $i$f$foldRight = false;
        StackTraceFrame accumulator$iv = initial$iv;
        if (!$this$foldRight$iv.isEmpty()) {
            ListIterator iterator$iv = $this$foldRight$iv.listIterator($this$foldRight$iv.size());
            while (iterator$iv.hasPrevious()) {
                void acc;
                StackTraceFrame stackTraceFrame = accumulator$iv;
                StackTraceElement frame = (StackTraceElement)iterator$iv.previous();
                boolean bl = false;
                accumulator$iv = new StackTraceFrame((CoroutineStackFrame)acc, frame);
            }
        }
        StackTraceElement stackTraceElement = ARTIFICIAL_FRAME;
        CoroutineStackFrame coroutineStackFrame = accumulator$iv;
        return new StackTraceFrame(coroutineStackFrame, stackTraceElement);
    }

    private final <T> Continuation<T> createOwner(Continuation<? super T> completion, StackTraceFrame frame) {
        if (!this.isInstalled$kotlinx_coroutines_debug()) {
            return completion;
        }
        DebugCoroutineInfoImpl info = new DebugCoroutineInfoImpl(completion.getContext(), frame, SequenceNumber.kotlinx.VolatileWrapper.sequenceNumber$FU.incrementAndGet(sequenceNumber$kotlinx$VolatileWrapper));
        CoroutineOwner<? super T> owner = new CoroutineOwner<T>(completion, info);
        ((Map)((Object)capturedCoroutinesMap)).put(owner, true);
        if (!this.isInstalled$kotlinx_coroutines_debug()) {
            capturedCoroutinesMap.clear();
        }
        return owner;
    }

    private final void probeCoroutineCompleted(CoroutineOwner<?> owner) {
        capturedCoroutinesMap.remove(owner);
        CoroutineStackFrame coroutineStackFrame = owner.info.getLastObservedFrame$kotlinx_coroutines_core();
        if (coroutineStackFrame == null || (coroutineStackFrame = this.realCaller(coroutineStackFrame)) == null) {
            return;
        }
        CoroutineStackFrame caller = coroutineStackFrame;
        callerInfoCache.remove(caller);
    }

    /*
     * WARNING - void declaration
     */
    private final <T extends Throwable> List<StackTraceElement> sanitizeStackTrace(T throwable) {
        int n2;
        int index$iv;
        int n3;
        int n4;
        int size;
        StackTraceElement[] stackTrace;
        block9: {
            void $this$indexOfLast$iv;
            stackTrace = throwable.getStackTrace();
            size = stackTrace.length;
            StackTraceElement[] stackTraceElementArray = stackTrace;
            n4 = 1;
            boolean $i$f$indexOfLast = false;
            n3 = ((void)$this$indexOfLast$iv).length + -1;
            if (0 <= n3) {
                do {
                    index$iv = n3--;
                    void it = $this$indexOfLast$iv[index$iv];
                    boolean bl = false;
                    if (!Intrinsics.areEqual((Object)it.getClassName(), (Object)"kotlin.coroutines.jvm.internal.DebugProbesKt")) continue;
                    n2 = index$iv;
                    break block9;
                } while (0 <= n3);
            }
            n2 = -1;
        }
        int n5 = n2;
        int traceStart = n4 + n5;
        if (!sanitizeStackTraces) {
            int $this$indexOfLast$iv = size - traceStart;
            ArrayList<StackTraceElement> $i$f$indexOfLast = new ArrayList<StackTraceElement>($this$indexOfLast$iv);
            n3 = 0;
            while (n3 < $this$indexOfLast$iv) {
                int it = index$iv = n3++;
                ArrayList<StackTraceElement> arrayList = $i$f$indexOfLast;
                boolean bl = false;
                arrayList.add(stackTrace[it + traceStart]);
            }
            return $i$f$indexOfLast;
        }
        ArrayList result2 = new ArrayList(size - traceStart + 1);
        int i2 = traceStart;
        while (i2 < size) {
            if (this.isInternalMethod(stackTrace[i2])) {
                int k2;
                int j2;
                ((Collection)result2).add(stackTrace[i2]);
                for (j2 = i2 + 1; j2 < size && this.isInternalMethod(stackTrace[j2]); ++j2) {
                }
                for (k2 = j2 - 1; k2 > i2 && stackTrace[k2].getFileName() == null; --k2) {
                }
                if (k2 > i2 && k2 < j2 - 1) {
                    ((Collection)result2).add(stackTrace[k2]);
                }
                ((Collection)result2).add(stackTrace[j2 - 1]);
                i2 = j2;
                continue;
            }
            ((Collection)result2).add(stackTrace[i2]);
            ++i2;
        }
        return result2;
    }

    private final boolean isInternalMethod(StackTraceElement $this$isInternalMethod) {
        return StringsKt.startsWith$default((String)$this$isInternalMethod.getClassName(), (String)"kotlinx.coroutines", (boolean)false, (int)2, null);
    }

    public static final /* synthetic */ ConcurrentWeakMap access$getCallerInfoCache$p() {
        return callerInfoCache;
    }

    public static final /* synthetic */ boolean access$isFinished(DebugProbesImpl $this, CoroutineOwner $receiver) {
        return $this.isFinished($receiver);
    }

    static {
        capturedCoroutinesMap = new ConcurrentWeakMap(false, 1, null);
        sanitizeStackTraces = true;
        enableCreationStackTraces = true;
        ignoreCoroutinesWithEmptyContext = true;
        dynamicAttach = INSTANCE.getDynamicAttach();
        callerInfoCache = new ConcurrentWeakMap(true);
        installations$kotlinx$VolatileWrapper = new Installations.kotlinx.VolatileWrapper(null);
        sequenceNumber$kotlinx$VolatileWrapper = new SequenceNumber.kotlinx.VolatileWrapper(null);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u001f\b\u0000\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001f\u0010 J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J \u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2={"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "delegate", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getFrame", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "frame", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;)V", "kotlinx-coroutines-core"})
    public static final class CoroutineOwner<T>
    implements Continuation<T>,
    CoroutineStackFrame {
        @JvmField
        @NotNull
        public final Continuation<T> delegate;
        @JvmField
        @NotNull
        public final DebugCoroutineInfoImpl info;

        public CoroutineOwner(@NotNull Continuation<? super T> delegate, @NotNull DebugCoroutineInfoImpl info) {
            this.delegate = delegate;
            this.info = info;
        }

        @NotNull
        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        private final StackTraceFrame getFrame() {
            return this.info.getCreationStackBottom$kotlinx_coroutines_core();
        }

        @Nullable
        public CoroutineStackFrame getCallerFrame() {
            StackTraceFrame stackTraceFrame = this.getFrame();
            return stackTraceFrame != null ? stackTraceFrame.getCallerFrame() : null;
        }

        @Nullable
        public StackTraceElement getStackTraceElement() {
            StackTraceFrame stackTraceFrame = this.getFrame();
            return stackTraceFrame != null ? stackTraceFrame.getStackTraceElement() : null;
        }

        public void resumeWith(@NotNull Object result2) {
            INSTANCE.probeCoroutineCompleted(this);
            this.delegate.resumeWith(result2);
        }

        @NotNull
        public String toString() {
            return this.delegate.toString();
        }
    }
}


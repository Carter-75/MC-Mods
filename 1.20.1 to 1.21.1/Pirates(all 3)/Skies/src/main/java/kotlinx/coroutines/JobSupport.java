/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.TypeIntrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequenceScope
 *  kotlin.sequences.SequencesKt
 */
package kotlinx.coroutines;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildHandleNode;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionHandlerBase;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Empty;
import kotlinx.coroutines.InactiveNodeList;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.InvokeOnCancelling;
import kotlinx.coroutines.InvokeOnCompletion;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobCancellingNode;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.NodeList;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.ParentJob;
import kotlinx.coroutines.ResumeAwaitOnCompletion;
import kotlinx.coroutines.ResumeOnCompletion;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause0Impl;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message="This is internal API and may be removed in the future releases", level=DeprecationLevel.ERROR)
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00de\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\n\u00d8\u0001\u00d9\u0001\u00da\u0001\u00db\u0001\u00dc\u0001B\u0012\u0012\u0007\u0010\u00d5\u0001\u001a\u00020\n\u00a2\u0006\u0006\b\u00d6\u0001\u0010\u00d7\u0001J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0014\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0017\u00a2\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u001f\u001a\u00020\u00112\u000e\u0010\u001e\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"H\u0016\u00a2\u0006\u0004\b\u001f\u0010#J\u0017\u0010$\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b$\u0010 J\u0019\u0010'\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0000\u00a2\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b,\u0010 J\u000f\u0010.\u001a\u00020-H\u0014\u00a2\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b0\u0010 J!\u00103\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b3\u00104J)\u00109\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002052\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b;\u0010<J(\u0010A\u001a\u00020>2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0080\b\u00a2\u0006\u0004\b?\u0010@J#\u0010B\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u0002052\b\u00108\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\bB\u0010CJ\u0019\u0010D\u001a\u0004\u0018\u0001062\u0006\u0010\u0014\u001a\u000201H\u0002\u00a2\u0006\u0004\bD\u0010EJ\u0011\u0010F\u001a\u00060!j\u0002`\"\u00a2\u0006\u0004\bF\u0010GJ\u0013\u0010H\u001a\u00060!j\u0002`\"H\u0016\u00a2\u0006\u0004\bH\u0010GJ\u0011\u0010K\u001a\u0004\u0018\u00010\u0004H\u0000\u00a2\u0006\u0004\bI\u0010JJ\u000f\u0010L\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\bL\u0010MJ'\u0010N\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u0002052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002\u00a2\u0006\u0004\bN\u0010OJ\u0019\u0010P\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u000201H\u0002\u00a2\u0006\u0004\bP\u0010QJ\u0017\u0010S\u001a\u00020\n2\u0006\u0010R\u001a\u00020\rH\u0014\u00a2\u0006\u0004\bS\u0010 J\u0017\u0010U\u001a\u00020\u00112\u0006\u0010R\u001a\u00020\rH\u0010\u00a2\u0006\u0004\bT\u0010)J\u0019\u0010W\u001a\u00020\u00112\b\u0010V\u001a\u0004\u0018\u00010\u0001H\u0004\u00a2\u0006\u0004\bW\u0010XJF\u0010a\u001a\u00020`2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\n2'\u0010_\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00110[j\u0002`^\u00a2\u0006\u0004\ba\u0010bJ6\u0010a\u001a\u00020`2'\u0010_\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00110[j\u0002`^\u00a2\u0006\u0004\ba\u0010cJ\u0013\u0010d\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bd\u0010\u001cJ\u000f\u0010e\u001a\u00020\nH\u0002\u00a2\u0006\u0004\be\u0010fJ\u0013\u0010g\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bg\u0010\u001cJ&\u0010j\u001a\u00020i2\u0014\u0010h\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00110[H\u0082\b\u00a2\u0006\u0004\bj\u0010kJ\u001b\u0010l\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\bl\u0010+J\u0019\u0010n\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u00010\u0004H\u0000\u00a2\u0006\u0004\bm\u0010&J\u001b\u0010p\u001a\u0004\u0018\u00010\u00042\b\u00108\u001a\u0004\u0018\u00010\u0004H\u0000\u00a2\u0006\u0004\bo\u0010+J@\u0010q\u001a\u00020\b2'\u0010_\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00110[j\u0002`^2\u0006\u0010Y\u001a\u00020\nH\u0002\u00a2\u0006\u0004\bq\u0010rJ\u000f\u0010t\u001a\u00020-H\u0010\u00a2\u0006\u0004\bs\u0010/J\u001f\u0010u\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\rH\u0002\u00a2\u0006\u0004\bu\u0010vJ.\u0010x\u001a\u00020\u0011\"\n\b\u0000\u0010w\u0018\u0001*\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0082\b\u00a2\u0006\u0004\bx\u0010vJ%\u0010{\u001a\u0004\u0018\u00010\u00042\b\u0010y\u001a\u0004\u0018\u00010\u00042\b\u0010z\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b{\u0010|J&\u0010\u007f\u001a\u00020\u00112\n\u0010~\u001a\u0006\u0012\u0002\b\u00030}2\b\u0010y\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0019\u0010Y\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0014\u00a2\u0006\u0004\bY\u0010)J\u001b\u0010\u0081\u0001\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0014\u00a2\u0006\u0005\b\u0081\u0001\u0010\u0016J\u0012\u0010\u0082\u0001\u001a\u00020\u0011H\u0014\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0019\u0010\u0085\u0001\u001a\u00020\u00112\u0007\u0010\u0084\u0001\u001a\u00020\u0003\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u001b\u0010\u0088\u0001\u001a\u00020\u00112\u0007\u0010\u0014\u001a\u00030\u0087\u0001H\u0002\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001a\u0010\u008a\u0001\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\bH\u0002\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J(\u0010\u008c\u0001\u001a\u00020\u00112\n\u0010~\u001a\u0006\u0012\u0002\b\u00030}2\b\u0010y\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0006\b\u008c\u0001\u0010\u0080\u0001J\u001a\u0010\u008e\u0001\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\bH\u0000\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008b\u0001J\u000f\u0010\u008f\u0001\u001a\u00020\n\u00a2\u0006\u0005\b\u008f\u0001\u0010fJ\u001d\u0010\u0091\u0001\u001a\u00030\u0090\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u001c\u0010\u0093\u0001\u001a\u00020-2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u0011\u0010\u0095\u0001\u001a\u00020-H\u0007\u00a2\u0006\u0005\b\u0095\u0001\u0010/J\u0011\u0010\u0096\u0001\u001a\u00020-H\u0016\u00a2\u0006\u0005\b\u0096\u0001\u0010/J$\u0010\u0097\u0001\u001a\u00020\n2\u0006\u0010\u0014\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\"\u0010\u0099\u0001\u001a\u00020\n2\u0006\u0010\u0014\u001a\u0002012\u0006\u0010\u000e\u001a\u00020\rH\u0002\u00a2\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J'\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u00108\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0005\b\u009b\u0001\u0010|J&\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u0002012\b\u00108\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J-\u0010\u009e\u0001\u001a\u00020\n2\u0006\u0010\u0014\u001a\u0002052\u0006\u0010\u0017\u001a\u0002062\b\u00108\u001a\u0004\u0018\u00010\u0004H\u0082\u0010\u00a2\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u0019\u0010\u00a1\u0001\u001a\u0004\u0018\u000106*\u00030\u00a0\u0001H\u0002\u00a2\u0006\u0006\b\u00a1\u0001\u0010\u00a2\u0001J\u001f\u0010\u00a3\u0001\u001a\u00020\u0011*\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0002\u00a2\u0006\u0005\b\u00a3\u0001\u0010vJ&\u0010\u00a4\u0001\u001a\u00060!j\u0002`\"*\u00020\r2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010-H\u0004\u00a2\u0006\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u0015\u0010\u00a7\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00a6\u00018\u0002X\u0082\u0004R\u0015\u0010\u00a8\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00a6\u00018\u0002X\u0082\u0004R\u001b\u0010\u00ac\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010\u00a9\u00018F\u00a2\u0006\b\u001a\u0006\b\u00aa\u0001\u0010\u00ab\u0001R\u0018\u0010\u00ae\u0001\u001a\u0004\u0018\u00010\r8DX\u0084\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00ad\u0001\u0010MR\u0016\u0010\u00b0\u0001\u001a\u00020\n8DX\u0084\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00af\u0001\u0010fR\u0016\u0010\u00b2\u0001\u001a\u00020\n8PX\u0090\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00b1\u0001\u0010fR\u0016\u0010\u00b3\u0001\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00b3\u0001\u0010fR\u0013\u0010\u00b4\u0001\u001a\u00020\n8F\u00a2\u0006\u0007\u001a\u0005\b\u00b4\u0001\u0010fR\u0013\u0010\u00b5\u0001\u001a\u00020\n8F\u00a2\u0006\u0007\u001a\u0005\b\u00b5\u0001\u0010fR\u0013\u0010\u00b6\u0001\u001a\u00020\n8F\u00a2\u0006\u0007\u001a\u0005\b\u00b6\u0001\u0010fR\u0016\u0010\u00b7\u0001\u001a\u00020\n8TX\u0094\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00b7\u0001\u0010fR\u0019\u0010\u00bb\u0001\u001a\u0007\u0012\u0002\b\u00030\u00b8\u00018F\u00a2\u0006\b\u001a\u0006\b\u00b9\u0001\u0010\u00ba\u0001R$\u0010\u00c0\u0001\u001a\u0007\u0012\u0002\b\u00030\u00bc\u00018DX\u0084\u0004\u00a2\u0006\u0010\u0012\u0006\b\u00bf\u0001\u0010\u0083\u0001\u001a\u0006\b\u00bd\u0001\u0010\u00be\u0001R\u0016\u0010\u00c2\u0001\u001a\u00020\n8PX\u0090\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00c1\u0001\u0010fR\u001d\u0010\u00c7\u0001\u001a\u00030\u00c3\u00018F\u00a2\u0006\u0010\u0012\u0006\b\u00c6\u0001\u0010\u0083\u0001\u001a\u0006\b\u00c4\u0001\u0010\u00c5\u0001R\u0018\u0010V\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00c8\u0001\u0010\u00c9\u0001R.\u0010\u00cf\u0001\u001a\u0004\u0018\u00010\u00182\t\u0010\u00ca\u0001\u001a\u0004\u0018\u00010\u00188@@@X\u0080\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00cb\u0001\u0010\u00cc\u0001\"\u0006\b\u00cd\u0001\u0010\u00ce\u0001R\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00048@X\u0080\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00d0\u0001\u0010JR\u001e\u0010\u00d2\u0001\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u00048BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00d1\u0001\u0010<R\u001b\u0010\u00d3\u0001\u001a\u00020\n*\u0002018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00d3\u0001\u0010\u00d4\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00dd\u0001"}, d2={"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "parent", "initParentJob", "(Lkotlinx/coroutines/Job;)V", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "ignoredParam", "result", "onAwaitInternalProcessResFunc", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "onAwaitInternalRegFunc", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "onCompletionInternal", "onStart", "()V", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "registerSelectForOnJoin", "removeNode$kotlinx_coroutines_core", "removeNode", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlinx/atomicfu/AtomicRef;", "_parentHandle", "_state", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwaitInternal", "()Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwaitInternal$annotations", "onAwaitInternal", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "onJoin", "getParent", "()Lkotlinx/coroutines/Job;", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "active", "<init>", "(Z)V", "AwaitContinuation", "ChildCompletion", "Finishing", "SelectOnAwaitCompletionHandler", "SelectOnJoinCompletionHandler", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 7 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 8 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n+ 9 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n+ 10 CompletionHandler.common.kt\nkotlinx/coroutines/CompletionHandler_commonKt\n+ 11 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 12 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 13 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,1454:1\n706#1,2:1461\n367#1,2:1471\n369#1,4:1476\n373#1,4:1482\n377#1,2:1489\n367#1,2:1491\n369#1,4:1496\n373#1,4:1502\n377#1,2:1509\n178#1,2:1518\n707#1:1520\n178#1,2:1521\n178#1,2:1540\n178#1,2:1555\n706#1,2:1557\n706#1,2:1559\n178#1,2:1561\n706#1,2:1563\n178#1,2:1565\n178#1,2:1572\n178#1,2:1574\n1#2:1455\n1#2:1480\n1#2:1500\n28#3,4:1456\n28#3,4:1523\n28#3,4:1567\n28#3,4:1576\n20#4:1460\n20#4:1527\n20#4:1571\n20#4:1580\n288#5,2:1463\n288#5,2:1465\n19#6:1467\n163#7:1468\n163#7:1469\n153#7,4:1583\n75#8:1470\n75#8:1481\n75#8:1501\n75#8:1514\n341#9,3:1473\n344#9,3:1486\n341#9,3:1493\n344#9,3:1506\n341#9,3:1511\n344#9,3:1515\n47#10:1528\n22#11:1529\n22#11:1530\n13#11:1551\n13#11:1554\n13#11:1581\n13#11:1582\n13#11:1587\n13#11:1588\n134#12:1531\n73#12,3:1532\n135#12,5:1535\n314#13,9:1542\n323#13,2:1552\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n250#1:1461,2\n332#1:1471,2\n332#1:1476,4\n332#1:1482,4\n332#1:1489,2\n364#1:1491,2\n364#1:1496,4\n364#1:1502,4\n364#1:1509,2\n381#1:1518,2\n426#1:1520\n461#1:1521,2\n553#1:1540,2\n594#1:1555,2\n621#1:1557,2\n630#1:1559,2\n694#1:1561,2\n723#1:1563,2\n736#1:1565,2\n809#1:1572,2\n831#1:1574,2\n332#1:1480\n364#1:1500\n213#1:1456,4\n478#1:1523,4\n739#1:1567,4\n884#1:1576,4\n213#1:1460\n478#1:1527\n739#1:1571\n884#1:1580\n261#1:1463,2\n265#1:1465,2\n273#1:1467\n279#1:1468\n281#1:1469\n1218#1:1583,4\n284#1:1470\n332#1:1481\n364#1:1501\n372#1:1514\n332#1:1473,3\n332#1:1486,3\n364#1:1493,3\n364#1:1506,3\n368#1:1511,3\n368#1:1515,3\n483#1:1528\n495#1:1529\n505#1:1530\n561#1:1551\n577#1:1554\n924#1:1581\n974#1:1582\n1237#1:1587\n1259#1:1588\n526#1:1531\n526#1:1532,3\n526#1:1535,5\n559#1:1542,9\n559#1:1552,2\n*E\n"})
public class JobSupport
implements Job,
ChildJob,
ParentJob {
    @Volatile
    @Nullable
    private volatile Object _state;
    @Volatile
    @Nullable
    private volatile Object _parentHandle;
    @NotNull
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    @NotNull
    private static final AtomicReferenceFieldUpdater _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle");

    public JobSupport(boolean active) {
        this._state = active ? JobSupportKt.access$getEMPTY_ACTIVE$p() : JobSupportKt.access$getEMPTY_NEW$p();
    }

    @NotNull
    public final CoroutineContext.Key<?> getKey() {
        return Job.Key;
    }

    @Nullable
    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle)_parentHandle$FU.get(this);
    }

    public final void setParentHandle$kotlinx_coroutines_core(@Nullable ChildHandle value) {
        _parentHandle$FU.set(this, value);
    }

    @Override
    @Nullable
    public Job getParent() {
        ChildHandle childHandle = this.getParentHandle$kotlinx_coroutines_core();
        return childHandle != null ? childHandle.getParent() : null;
    }

    protected final void initParentJob(@Nullable Job parent) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(this.getParentHandle$kotlinx_coroutines_core() == null)) {
                throw new AssertionError();
            }
        }
        if (parent == null) {
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
            return;
        }
        parent.start();
        ChildHandle handle = parent.attachChild(this);
        this.setParentHandle$kotlinx_coroutines_core(handle);
        if (this.isCompleted()) {
            handle.dispose();
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        JobSupport jobSupport = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _state$FU;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            Object state = atomicfu$handler$iv.get(this);
            boolean bl = false;
            if (!(state instanceof OpDescriptor)) {
                return state;
            }
            ((OpDescriptor)state).perform(this);
        }
    }

    private final Void loopOnState(Function1<Object, Unit> block) {
        boolean $i$f$loopOnState = false;
        while (true) {
            block.invoke(this.getState$kotlinx_coroutines_core());
        }
    }

    @Override
    public boolean isActive() {
        Object state = this.getState$kotlinx_coroutines_core();
        return state instanceof Incomplete && ((Incomplete)state).isActive();
    }

    @Override
    public final boolean isCompleted() {
        return !(this.getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    @Override
    public final boolean isCancelled() {
        Object state = this.getState$kotlinx_coroutines_core();
        return state instanceof CompletedExceptionally || state instanceof Finishing && ((Finishing)state).isCancelling();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final Object finalizeFinishingState(Finishing state, Object proposedUpdate) {
        Object finalState;
        Throwable throwable;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(this.getState$kotlinx_coroutines_core() == state)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(!state.isSealed())) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!state.isCompleting()) {
                throw new AssertionError();
            }
        }
        CompletedExceptionally completedExceptionally = proposedUpdate instanceof CompletedExceptionally ? (CompletedExceptionally)proposedUpdate : null;
        Throwable proposedException = completedExceptionally != null ? completedExceptionally.cause : null;
        boolean wasCancelling = false;
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        Finishing finishing = state;
        synchronized (finishing) {
            boolean bl = false;
            wasCancelling = state.isCancelling();
            List<Throwable> exceptions = state.sealLocked(proposedException);
            Throwable finalCause = this.getFinalRootCause(state, exceptions);
            if (finalCause != null) {
                this.addSuppressedExceptions(finalCause, exceptions);
            }
            throwable = finalCause;
        }
        Throwable finalException = throwable;
        Object object = finalException == null ? proposedUpdate : (finalState = finalException == proposedException ? proposedUpdate : new CompletedExceptionally(finalException, false, 2, null));
        if (finalException != null) {
            boolean handled;
            boolean bl = handled = this.cancelParent(finalException) || this.handleJobException(finalException);
            if (handled) {
                Intrinsics.checkNotNull((Object)finalState, (String)"null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                ((CompletedExceptionally)finalState).makeHandled();
            }
        }
        if (!wasCancelling) {
            this.onCancelling(finalException);
        }
        this.onCompletionInternal(finalState);
        boolean casSuccess = _state$FU.compareAndSet(this, state, JobSupportKt.boxIncomplete(finalState));
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!casSuccess) {
                throw new AssertionError();
            }
        }
        this.completeStateFinalization(state, finalState);
        return finalState;
    }

    private final Throwable getFinalRootCause(Finishing state, List<? extends Throwable> exceptions) {
        Throwable firstNonCancellation;
        Object v0;
        block7: {
            if (exceptions.isEmpty()) {
                if (state.isCancelling()) {
                    Object message$iv = null;
                    Throwable cause$iv = null;
                    boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
                    return new JobCancellationException(this.cancellationExceptionMessage(), cause$iv, this);
                }
                return null;
            }
            Iterable $this$firstOrNull$iv = exceptions;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                Throwable it = (Throwable)element$iv;
                boolean bl = false;
                if (!(!(it instanceof CancellationException))) continue;
                v0 = element$iv;
                break block7;
            }
            v0 = null;
        }
        Throwable throwable = firstNonCancellation = (Throwable)v0;
        if (throwable != null) {
            return throwable;
        }
        Throwable first2 = exceptions.get(0);
        if (first2 instanceof TimeoutCancellationException) {
            Object v2;
            block8: {
                Iterable $this$firstOrNull$iv = exceptions;
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    Throwable it = (Throwable)element$iv;
                    boolean bl = false;
                    if (!(it != first2 && it instanceof TimeoutCancellationException)) continue;
                    v2 = element$iv;
                    break block8;
                }
                v2 = null;
            }
            Throwable detailedTimeoutException = v2;
            if (detailedTimeoutException != null) {
                return detailedTimeoutException;
            }
        }
        return first2;
    }

    private final void addSuppressedExceptions(Throwable rootCause, List<? extends Throwable> exceptions) {
        if (exceptions.size() <= 1) {
            return;
        }
        int expectedSize$iv = exceptions.size();
        boolean $i$f$identitySet = false;
        Set<Throwable> seenExceptions = Collections.newSetFromMap(new IdentityHashMap(expectedSize$iv));
        boolean $i$f$unwrap = false;
        Throwable unwrappedCause = !DebugKt.getRECOVER_STACK_TRACES() ? rootCause : StackTraceRecoveryKt.unwrapImpl(rootCause);
        for (Throwable throwable : exceptions) {
            boolean $i$f$unwrap2 = false;
            Throwable unwrapped = !DebugKt.getRECOVER_STACK_TRACES() ? throwable : StackTraceRecoveryKt.unwrapImpl(throwable);
            if (unwrapped == rootCause || unwrapped == unwrappedCause || unwrapped instanceof CancellationException || !seenExceptions.add(unwrapped)) continue;
            Throwable $this$addSuppressedThrowable$iv = rootCause;
            boolean $i$f$addSuppressedThrowable = false;
            ExceptionsKt.addSuppressed((Throwable)$this$addSuppressedThrowable$iv, (Throwable)unwrapped);
        }
    }

    private final boolean tryFinalizeSimpleState(Incomplete state, Object update) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(state instanceof Empty || state instanceof JobNode)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(!(update instanceof CompletedExceptionally))) {
                throw new AssertionError();
            }
        }
        if (!_state$FU.compareAndSet(this, state, JobSupportKt.boxIncomplete(update))) {
            return false;
        }
        this.onCancelling(null);
        this.onCompletionInternal(update);
        this.completeStateFinalization(state, update);
        return true;
    }

    private final void completeStateFinalization(Incomplete state, Object update) {
        block4: {
            Throwable cause;
            block3: {
                ChildHandle childHandle = this.getParentHandle$kotlinx_coroutines_core();
                if (childHandle != null) {
                    ChildHandle it = childHandle;
                    boolean bl = false;
                    it.dispose();
                    this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
                }
                CompletedExceptionally completedExceptionally = update instanceof CompletedExceptionally ? (CompletedExceptionally)update : null;
                Throwable throwable = cause = completedExceptionally != null ? completedExceptionally.cause : null;
                if (!(state instanceof JobNode)) break block3;
                try {
                    ((JobNode)state).invoke(cause);
                }
                catch (Throwable ex) {
                    this.handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + state + " for " + this, ex));
                }
                break block4;
            }
            NodeList nodeList = state.getList();
            if (nodeList == null) break block4;
            this.notifyCompletion(nodeList, cause);
        }
    }

    private final void notifyCancelling(NodeList list, Throwable cause) {
        this.onCancelling(cause);
        JobSupport this_$iv = this;
        boolean $i$f$notifyHandlers = false;
        CompletionHandlerException exception$iv = null;
        LockFreeLinkedListHead this_$iv$iv = list;
        boolean $i$f$forEach = false;
        Object object = this_$iv$iv.getNext();
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode cur$iv$iv = (LockFreeLinkedListNode)object;
        while (!Intrinsics.areEqual((Object)cur$iv$iv, (Object)this_$iv$iv)) {
            block6: {
                if (cur$iv$iv instanceof JobCancellingNode) {
                    JobNode node$iv = (JobNode)cur$iv$iv;
                    boolean bl = false;
                    try {
                        node$iv.invoke(cause);
                    }
                    catch (Throwable ex$iv) {
                        Throwable throwable = exception$iv;
                        if (throwable != null) {
                            Throwable throwable2;
                            Throwable $this$notifyHandlers_u24lambda_u2414_u24lambda_u2412$iv = throwable2 = throwable;
                            boolean bl2 = false;
                            Throwable $this$addSuppressedThrowable$iv$iv = $this$notifyHandlers_u24lambda_u2414_u24lambda_u2412$iv;
                            boolean $i$f$addSuppressedThrowable = false;
                            ExceptionsKt.addSuppressed((Throwable)$this$addSuppressedThrowable$iv$iv, (Throwable)ex$iv);
                            throwable = throwable2;
                            if (throwable != null) break block6;
                        }
                        JobSupport $this$notifyHandlers_u24lambda_u2414_u24lambda_u2413$iv = this_$iv;
                        boolean bl3 = false;
                        exception$iv = new CompletionHandlerException("Exception in completion handler " + node$iv + " for " + $this$notifyHandlers_u24lambda_u2414_u24lambda_u2413$iv, ex$iv);
                        throwable = Unit.INSTANCE;
                    }
                }
            }
            cur$iv$iv = cur$iv$iv.getNextNode();
        }
        Throwable throwable = exception$iv;
        if (throwable != null) {
            Throwable it$iv = throwable;
            boolean bl = false;
            this_$iv.handleOnCompletionException$kotlinx_coroutines_core(it$iv);
        }
        this.cancelParent(cause);
    }

    private final boolean cancelParent(Throwable cause) {
        if (this.isScopedCoroutine()) {
            return true;
        }
        boolean isCancellation = cause instanceof CancellationException;
        ChildHandle parent = this.getParentHandle$kotlinx_coroutines_core();
        if (parent == null || parent == NonDisposableHandle.INSTANCE) {
            return isCancellation;
        }
        return parent.childCancelled(cause) || isCancellation;
    }

    private final void notifyCompletion(NodeList $this$notifyCompletion, Throwable cause) {
        block6: {
            JobSupport this_$iv = this;
            boolean $i$f$notifyHandlers = false;
            CompletionHandlerException exception$iv = null;
            LockFreeLinkedListHead this_$iv$iv = $this$notifyCompletion;
            boolean $i$f$forEach = false;
            Object object = this_$iv$iv.getNext();
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            LockFreeLinkedListNode cur$iv$iv = (LockFreeLinkedListNode)object;
            while (!Intrinsics.areEqual((Object)cur$iv$iv, (Object)this_$iv$iv)) {
                block5: {
                    if (cur$iv$iv instanceof JobNode) {
                        JobNode node$iv = (JobNode)cur$iv$iv;
                        boolean bl = false;
                        try {
                            node$iv.invoke(cause);
                        }
                        catch (Throwable ex$iv) {
                            Throwable throwable = exception$iv;
                            if (throwable != null) {
                                Throwable throwable2;
                                Throwable $this$notifyHandlers_u24lambda_u2414_u24lambda_u2412$iv = throwable2 = throwable;
                                boolean bl2 = false;
                                Throwable $this$addSuppressedThrowable$iv$iv = $this$notifyHandlers_u24lambda_u2414_u24lambda_u2412$iv;
                                boolean $i$f$addSuppressedThrowable = false;
                                ExceptionsKt.addSuppressed((Throwable)$this$addSuppressedThrowable$iv$iv, (Throwable)ex$iv);
                                throwable = throwable2;
                                if (throwable != null) break block5;
                            }
                            JobSupport $this$notifyHandlers_u24lambda_u2414_u24lambda_u2413$iv = this_$iv;
                            boolean bl3 = false;
                            exception$iv = new CompletionHandlerException("Exception in completion handler " + node$iv + " for " + $this$notifyHandlers_u24lambda_u2414_u24lambda_u2413$iv, ex$iv);
                            throwable = Unit.INSTANCE;
                        }
                    }
                }
                cur$iv$iv = cur$iv$iv.getNextNode();
            }
            Throwable throwable = exception$iv;
            if (throwable == null) break block6;
            Throwable it$iv = throwable;
            boolean bl = false;
            this_$iv.handleOnCompletionException$kotlinx_coroutines_core(it$iv);
        }
    }

    private final /* synthetic */ <T extends JobNode> void notifyHandlers(NodeList list, Throwable cause) {
        block6: {
            boolean $i$f$notifyHandlers = false;
            CompletionHandlerException exception = null;
            LockFreeLinkedListHead this_$iv = list;
            boolean $i$f$forEach = false;
            Object object = this_$iv.getNext();
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            LockFreeLinkedListNode cur$iv = (LockFreeLinkedListNode)object;
            while (!Intrinsics.areEqual((Object)cur$iv, (Object)this_$iv)) {
                block5: {
                    Intrinsics.reifiedOperationMarker((int)3, (String)"T");
                    if (cur$iv instanceof LockFreeLinkedListNode) {
                        JobNode node = (JobNode)cur$iv;
                        boolean bl = false;
                        try {
                            node.invoke(cause);
                        }
                        catch (Throwable ex) {
                            Throwable throwable = exception;
                            if (throwable != null) {
                                Throwable throwable2;
                                Throwable $this$notifyHandlers_u24lambda_u2414_u24lambda_u2412 = throwable2 = throwable;
                                boolean bl2 = false;
                                Throwable $this$addSuppressedThrowable$iv = $this$notifyHandlers_u24lambda_u2414_u24lambda_u2412;
                                boolean $i$f$addSuppressedThrowable = false;
                                ExceptionsKt.addSuppressed((Throwable)$this$addSuppressedThrowable$iv, (Throwable)ex);
                                throwable = throwable2;
                                if (throwable != null) break block5;
                            }
                            JobSupport $this$notifyHandlers_u24lambda_u2414_u24lambda_u2413 = this;
                            boolean bl3 = false;
                            exception = new CompletionHandlerException("Exception in completion handler " + node + " for " + $this$notifyHandlers_u24lambda_u2414_u24lambda_u2413, ex);
                            throwable = Unit.INSTANCE;
                        }
                    }
                }
                cur$iv = cur$iv.getNextNode();
            }
            Throwable throwable = exception;
            if (throwable == null) break block6;
            Throwable it = throwable;
            boolean bl = false;
            this.handleOnCompletionException$kotlinx_coroutines_core(it);
        }
    }

    @Override
    public final boolean start() {
        JobSupport this_$iv = this;
        boolean $i$f$loopOnState = false;
        while (true) {
            Object state = this_$iv.getState$kotlinx_coroutines_core();
            boolean bl = false;
            switch (this.startInternal(state)) {
                case 0: {
                    return false;
                }
                case 1: {
                    return true;
                }
            }
        }
    }

    private final int startInternal(Object state) {
        Object object = state;
        if (object instanceof Empty) {
            if (((Empty)state).isActive()) {
                return 0;
            }
            if (!_state$FU.compareAndSet(this, state, JobSupportKt.access$getEMPTY_ACTIVE$p())) {
                return -1;
            }
            this.onStart();
            return 1;
        }
        if (object instanceof InactiveNodeList) {
            if (!_state$FU.compareAndSet(this, state, ((InactiveNodeList)state).getList())) {
                return -1;
            }
            this.onStart();
            return 1;
        }
        return 0;
    }

    protected void onStart() {
    }

    @Override
    @NotNull
    public final CancellationException getCancellationException() {
        Throwable throwable;
        Object state = this.getState$kotlinx_coroutines_core();
        if (state instanceof Finishing) {
            throwable = ((Finishing)state).getRootCause();
            if (throwable == null || (throwable = this.toCancellationException(throwable, DebugStringsKt.getClassSimpleName(this) + " is cancelling")) == null) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
        } else {
            if (state instanceof Incomplete) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            throwable = state instanceof CompletedExceptionally ? JobSupport.toCancellationException$default(this, ((CompletedExceptionally)state).cause, null, 1, null) : (CancellationException)new JobCancellationException(DebugStringsKt.getClassSimpleName(this) + " has completed normally", null, this);
        }
        return throwable;
    }

    @NotNull
    protected final CancellationException toCancellationException(@NotNull Throwable $this$toCancellationException, @Nullable String message) {
        CancellationException cancellationException = $this$toCancellationException instanceof CancellationException ? (CancellationException)$this$toCancellationException : null;
        if (cancellationException == null) {
            JobSupport this_$iv = this;
            boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
            String string = message;
            if (string == null) {
                string = this_$iv.cancellationExceptionMessage();
            }
            cancellationException = new JobCancellationException(string, $this$toCancellationException, this_$iv);
        }
        return cancellationException;
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable throwable, String string, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((n2 & 1) != 0) {
            string = null;
        }
        return jobSupport.toCancellationException(throwable, string);
    }

    @Nullable
    protected final Throwable getCompletionCause() {
        Throwable throwable;
        Object state = this.getState$kotlinx_coroutines_core();
        if (state instanceof Finishing) {
            throwable = ((Finishing)state).getRootCause();
            if (throwable == null) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
        } else {
            if (state instanceof Incomplete) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            throwable = state instanceof CompletedExceptionally ? ((CompletedExceptionally)state).cause : null;
        }
        return throwable;
    }

    protected final boolean getCompletionCauseHandled() {
        Object it = this.getState$kotlinx_coroutines_core();
        boolean bl = false;
        return it instanceof CompletedExceptionally && ((CompletedExceptionally)it).getHandled();
    }

    @Override
    @NotNull
    public final DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> handler) {
        return this.invokeOnCompletion(false, true, handler);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    @NotNull
    public final DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, @NotNull Function1<? super Throwable, Unit> handler) {
        void $this$invokeIt$iv;
        Function1<? super Throwable, Unit> list;
        Object state;
        block12: {
            JobNode node = this.makeNode(handler, onCancelling);
            JobSupport this_$iv = this;
            boolean $i$f$loopOnState = false;
            while (true) {
                Throwable rootCause;
                block13: {
                    state = this_$iv.getState$kotlinx_coroutines_core();
                    boolean bl = false;
                    Object object = state;
                    if (object instanceof Empty) {
                        if (((Empty)state).isActive()) {
                            if (!_state$FU.compareAndSet(this, state, node)) continue;
                            return node;
                        }
                        this.promoteEmptyToNodeList((Empty)state);
                        continue;
                    }
                    if (!(object instanceof Incomplete)) break block12;
                    list = ((Incomplete)state).getList();
                    if (list == null) {
                        Intrinsics.checkNotNull((Object)state, (String)"null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        this.promoteSingleToNodeList((JobNode)state);
                        continue;
                    }
                    rootCause = null;
                    Object var12_13 = null;
                    NonDisposableHandle nonDisposableHandle = NonDisposableHandle.INSTANCE;
                    if (!onCancelling || !(state instanceof Finishing)) break block13;
                    boolean $i$f$synchronized = false;
                    boolean $i$f$synchronizedImpl = false;
                    Object object2 = state;
                    synchronized (object2) {
                        block15: {
                            block14: {
                                boolean bl2 = false;
                                rootCause = ((Finishing)state).getRootCause();
                                if (rootCause == null) break block14;
                                Function1<? super Throwable, Unit> $this$isHandlerOf$iv = handler;
                                boolean $i$f$isHandlerOf = false;
                                if (!($this$isHandlerOf$iv instanceof ChildHandleNode) || ((Finishing)state).isCompleting()) break block15;
                            }
                            if (!this.addLastAtomic(state, (NodeList)list, node)) {
                                continue;
                            }
                            if (rootCause == null) {
                                return node;
                            }
                            JobNode jobNode = node;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                if (rootCause != null) {
                    void $this$invokeIt$iv2;
                    void var12_12;
                    if (!invokeImmediately) return (DisposableHandle)var12_12;
                    Function1<? super Throwable, Unit> $i$f$synchronized = handler;
                    Throwable cause$iv = rootCause;
                    boolean $i$f$invokeIt = false;
                    $this$invokeIt$iv2.invoke(cause$iv);
                    return (DisposableHandle)var12_12;
                }
                if (this.addLastAtomic(state, (NodeList)list, node)) break;
            }
            return node;
        }
        if (!invokeImmediately) return NonDisposableHandle.INSTANCE;
        list = handler;
        CompletedExceptionally completedExceptionally = state instanceof CompletedExceptionally ? (CompletedExceptionally)state : null;
        Throwable cause$iv = completedExceptionally != null ? completedExceptionally.cause : null;
        boolean bl = false;
        $this$invokeIt$iv.invoke((Object)cause$iv);
        return NonDisposableHandle.INSTANCE;
    }

    private final JobNode makeNode(Function1<? super Throwable, Unit> handler, boolean onCancelling) {
        JobNode jobNode;
        if (onCancelling) {
            JobCancellingNode jobCancellingNode = handler instanceof JobCancellingNode ? (JobCancellingNode)handler : null;
            if (jobCancellingNode == null) {
                jobCancellingNode = new InvokeOnCancelling(handler);
            }
            jobNode = jobCancellingNode;
        } else {
            JobNode jobNode2;
            JobNode jobNode3 = jobNode2 = handler instanceof JobNode ? (JobNode)handler : null;
            if (jobNode2 != null) {
                JobNode jobNode4;
                JobNode it = jobNode4 = jobNode2;
                boolean bl = false;
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl2 = false;
                    if (!(!(it instanceof JobCancellingNode))) {
                        throw new AssertionError();
                    }
                }
                jobNode = jobNode4;
            } else {
                jobNode = new InvokeOnCompletion(handler);
            }
        }
        JobNode node = jobNode;
        node.setJob(this);
        return node;
    }

    private final boolean addLastAtomic(Object expect, NodeList list, JobNode node) {
        boolean bl;
        LockFreeLinkedListNode this_$iv = list;
        boolean $i$f$addLastIf = false;
        LockFreeLinkedListNode this_$iv$iv = this_$iv;
        boolean $i$f$makeCondAddOp = false;
        LockFreeLinkedListNode.CondAddOp condAdd$iv = new LockFreeLinkedListNode.CondAddOp(node, this, expect){
            final /* synthetic */ JobSupport this$0;
            final /* synthetic */ Object $expect$inlined;
            {
                this.this$0 = jobSupport;
                this.$expect$inlined = object;
                super($node);
            }

            @Nullable
            public Object prepare(@NotNull LockFreeLinkedListNode affected) {
                boolean bl = false;
                return this.this$0.getState$kotlinx_coroutines_core() == this.$expect$inlined ? null : LockFreeLinkedListKt.getCONDITION_FALSE();
            }
        };
        block4: while (true) {
            LockFreeLinkedListNode prev$iv = this_$iv.getPrevNode();
            switch (prev$iv.tryCondAddNext(node, this_$iv, condAdd$iv)) {
                case 1: {
                    bl = true;
                    break block4;
                }
                case 2: {
                    bl = false;
                    break block4;
                }
                default: {
                    continue block4;
                }
            }
            break;
        }
        return bl;
    }

    private final void promoteEmptyToNodeList(Empty state) {
        NodeList list = new NodeList();
        Incomplete update = state.isActive() ? (Incomplete)list : (Incomplete)new InactiveNodeList(list);
        _state$FU.compareAndSet(this, state, update);
    }

    private final void promoteSingleToNodeList(JobNode state) {
        state.addOneIfEmpty(new NodeList());
        LockFreeLinkedListNode list = state.getNextNode();
        _state$FU.compareAndSet(this, state, list);
    }

    @Override
    @Nullable
    public final Object join(@NotNull Continuation<? super Unit> $completion) {
        if (!this.joinInternal()) {
            JobKt.ensureActive($completion.getContext());
            return Unit.INSTANCE;
        }
        Object object = this.joinSuspend($completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final boolean joinInternal() {
        Object state;
        JobSupport this_$iv = this;
        boolean $i$f$loopOnState = false;
        do {
            state = this_$iv.getState$kotlinx_coroutines_core();
            boolean bl = false;
            if (state instanceof Incomplete) continue;
            return false;
        } while (this.startInternal(state) < 0);
        return true;
    }

    private final Object joinSuspend(Continuation<? super Unit> $completion) {
        boolean $i$f$suspendCancellableCoroutine = false;
        Continuation<? super Unit> uCont$iv = $completion;
        boolean bl = false;
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
        cancellable$iv.initCancellability();
        CancellableContinuation cont = cancellable$iv;
        boolean bl2 = false;
        CompletionHandlerBase $this$asHandler$iv = new ResumeOnCompletion((Continuation<? super Unit>)((Continuation)cont));
        boolean $i$f$getAsHandler = false;
        CancellableContinuationKt.disposeOnCancellation(cont, this.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)$this$asHandler$iv)));
        Object object = cancellable$iv.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    @NotNull
    public final SelectClause0 getOnJoin() {
        onJoin.1 v0 = onJoin.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v0), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new SelectClause0Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v0), (int)3), null, 4, null);
    }

    public static /* synthetic */ void getOnJoin$annotations() {
    }

    private final void registerSelectForOnJoin(SelectInstance<?> select, Object ignoredParam) {
        if (!this.joinInternal()) {
            select.selectInRegistrationPhase(Unit.INSTANCE);
            return;
        }
        CompletionHandlerBase $this$asHandler$iv = new SelectOnJoinCompletionHandler(select);
        boolean $i$f$getAsHandler = false;
        DisposableHandle disposableHandle = this.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)$this$asHandler$iv));
        select.disposeOnCompletion(disposableHandle);
    }

    public final void removeNode$kotlinx_coroutines_core(@NotNull JobNode node) {
        Object object;
        Object state;
        block3: {
            JobSupport this_$iv = this;
            boolean $i$f$loopOnState = false;
            do {
                state = this_$iv.getState$kotlinx_coroutines_core();
                boolean bl = false;
                object = state;
                if (!(object instanceof JobNode)) break block3;
                if (state == node) continue;
                return;
            } while (!_state$FU.compareAndSet(this, state, JobSupportKt.access$getEMPTY_ACTIVE$p()));
            return;
        }
        if (object instanceof Incomplete) {
            if (((Incomplete)state).getList() != null) {
                node.remove();
            }
            return;
        }
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    @Override
    public void cancel(@Nullable CancellationException cause) {
        CancellationException cancellationException = cause;
        if (cancellationException == null) {
            Object message$iv = null;
            Throwable cause$iv = null;
            boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
            cancellationException = new JobCancellationException(this.cancellationExceptionMessage(), cause$iv, this);
        }
        this.cancelInternal(cancellationException);
    }

    @NotNull
    protected String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    @Override
    @Deprecated(message="Added since 1.2.0 for binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ boolean cancel(Throwable cause) {
        Throwable throwable = cause;
        if (throwable == null || (throwable = JobSupport.toCancellationException$default(this, throwable, null, 1, null)) == null) {
            Object message$iv = null;
            Throwable cause$iv = null;
            boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
            throwable = new JobCancellationException(this.cancellationExceptionMessage(), cause$iv, this);
        }
        this.cancelInternal(throwable);
        return true;
    }

    public void cancelInternal(@NotNull Throwable cause) {
        this.cancelImpl$kotlinx_coroutines_core(cause);
    }

    @Override
    public final void parentCancelled(@NotNull ParentJob parentJob) {
        this.cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    public boolean childCancelled(@NotNull Throwable cause) {
        if (cause instanceof CancellationException) {
            return true;
        }
        return this.cancelImpl$kotlinx_coroutines_core(cause) && this.getHandlesException$kotlinx_coroutines_core();
    }

    public final boolean cancelCoroutine(@Nullable Throwable cause) {
        return this.cancelImpl$kotlinx_coroutines_core(cause);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(@Nullable Object cause) {
        boolean bl;
        Object finalState = JobSupportKt.access$getCOMPLETING_ALREADY$p();
        if (this.getOnCancelComplete$kotlinx_coroutines_core() && (finalState = this.cancelMakeCompleting(cause)) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        if (finalState == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            finalState = this.makeCancelling(cause);
        }
        if (finalState == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            bl = true;
        } else if (finalState == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            bl = true;
        } else if (finalState == JobSupportKt.access$getTOO_LATE_TO_CANCEL$p()) {
            bl = false;
        } else {
            this.afterCompletion(finalState);
            bl = true;
        }
        return bl;
    }

    private final Object cancelMakeCompleting(Object cause) {
        CompletedExceptionally proposedUpdate;
        Object state;
        Object finalState;
        JobSupport this_$iv = this;
        boolean $i$f$loopOnState = false;
        do {
            state = this_$iv.getState$kotlinx_coroutines_core();
            boolean bl = false;
            if (state instanceof Incomplete && (!(state instanceof Finishing) || !((Finishing)state).isCompleting())) continue;
            return JobSupportKt.access$getCOMPLETING_ALREADY$p();
        } while ((finalState = this.tryMakeCompleting(state, proposedUpdate = new CompletedExceptionally(this.createCauseException(cause), false, 2, null))) == JobSupportKt.access$getCOMPLETING_RETRY$p());
        return finalState;
    }

    @NotNull
    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(@Nullable String message, @Nullable Throwable cause) {
        boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
        String string = message;
        if (string == null) {
            string = this.cancellationExceptionMessage();
        }
        return new JobCancellationException(string, cause, this);
    }

    public static /* synthetic */ JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport $this, String message, Throwable cause, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
        }
        if ((n2 & 1) != 0) {
            message = null;
        }
        if ((n2 & 2) != 0) {
            cause = null;
        }
        boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
        String string = message;
        if (string == null) {
            string = $this.cancellationExceptionMessage();
        }
        return new JobCancellationException(string, cause, $this);
    }

    @Override
    @NotNull
    public CancellationException getChildJobCancellationCause() {
        CancellationException cancellationException;
        Throwable rootCause;
        Throwable throwable;
        Object state = this.getState$kotlinx_coroutines_core();
        Object object = state;
        if (object instanceof Finishing) {
            throwable = ((Finishing)state).getRootCause();
        } else if (object instanceof CompletedExceptionally) {
            throwable = ((CompletedExceptionally)state).cause;
        } else {
            if (object instanceof Incomplete) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + state).toString());
            }
            throwable = rootCause = null;
        }
        if ((cancellationException = rootCause instanceof CancellationException ? (CancellationException)rootCause : null) == null) {
            cancellationException = new JobCancellationException("Parent job is " + this.stateString(state), rootCause, this);
        }
        return cancellationException;
    }

    private final Throwable createCauseException(Object cause) {
        Throwable throwable;
        Object object = cause;
        if (object == null ? true : object instanceof Throwable) {
            throwable = (Throwable)cause;
            if (throwable == null) {
                Object message$iv = null;
                Throwable cause$iv = null;
                boolean $i$f$defaultCancellationException$kotlinx_coroutines_core = false;
                throwable = new JobCancellationException(this.cancellationExceptionMessage(), cause$iv, this);
            }
        } else {
            Intrinsics.checkNotNull((Object)cause, (String)"null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
            throwable = ((ParentJob)cause).getChildJobCancellationCause();
        }
        return throwable;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final Object makeCancelling(Object cause) {
        block13: {
            Object finalState;
            Throwable causeExceptionCache = null;
            JobSupport this_$iv = this;
            boolean $i$f$loopOnState = false;
            while (true) {
                Throwable causeException;
                Object state = this_$iv.getState$kotlinx_coroutines_core();
                boolean bl = false;
                Object object = state;
                if (object instanceof Finishing) {
                    Throwable notifyRootCause;
                    Throwable throwable;
                    boolean $i$f$synchronized = false;
                    boolean $i$f$synchronizedImpl = false;
                    Object object2 = state;
                    synchronized (object2) {
                        Throwable throwable2;
                        block12: {
                            boolean bl2 = false;
                            if (!((Finishing)state).isSealed()) break block12;
                            Symbol symbol = JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
                            return symbol;
                        }
                        boolean wasCancelling = ((Finishing)state).isCancelling();
                        if (cause != null || !wasCancelling) {
                            Throwable throwable3 = causeExceptionCache;
                            if (throwable3 == null) {
                                Throwable throwable4;
                                Throwable it = throwable4 = this.createCauseException(cause);
                                boolean bl3 = false;
                                causeExceptionCache = it;
                                throwable3 = throwable4;
                            }
                            Throwable causeException2 = throwable3;
                            ((Finishing)state).addExceptionLocked(causeException2);
                        }
                        Throwable it = throwable2 = ((Finishing)state).getRootCause();
                        boolean bl4 = false;
                        throwable = !wasCancelling ? throwable2 : null;
                    }
                    Throwable throwable5 = notifyRootCause = throwable;
                    if (throwable5 != null) {
                        Throwable it = throwable5;
                        boolean bl5 = false;
                        this.notifyCancelling(((Finishing)state).getList(), it);
                    }
                    return JobSupportKt.access$getCOMPLETING_ALREADY$p();
                }
                if (!(object instanceof Incomplete)) break block13;
                Throwable throwable = causeExceptionCache;
                if (throwable == null) {
                    Throwable throwable6;
                    Throwable it = throwable6 = this.createCauseException(cause);
                    boolean bl6 = false;
                    causeExceptionCache = it;
                    throwable = causeException = throwable6;
                }
                if (((Incomplete)state).isActive()) {
                    if (!this.tryMakeCancelling((Incomplete)state, causeException)) continue;
                    return JobSupportKt.access$getCOMPLETING_ALREADY$p();
                }
                finalState = this.tryMakeCompleting(state, new CompletedExceptionally(causeException, false, 2, null));
                if (finalState == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
                    throw new IllegalStateException(("Cannot happen in " + state).toString());
                }
                if (finalState != JobSupportKt.access$getCOMPLETING_RETRY$p()) break;
            }
            return finalState;
        }
        return JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
    }

    private final NodeList getOrPromoteCancellingList(Incomplete state) {
        NodeList nodeList = state.getList();
        if (nodeList == null) {
            Incomplete incomplete = state;
            if (incomplete instanceof Empty) {
                nodeList = new NodeList();
            } else if (incomplete instanceof JobNode) {
                this.promoteSingleToNodeList((JobNode)state);
                nodeList = null;
            } else {
                throw new IllegalStateException(("State should have list: " + state).toString());
            }
        }
        return nodeList;
    }

    private final boolean tryMakeCancelling(Incomplete state, Throwable rootCause) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(!(state instanceof Finishing))) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!state.isActive()) {
                throw new AssertionError();
            }
        }
        NodeList nodeList = this.getOrPromoteCancellingList(state);
        if (nodeList == null) {
            return false;
        }
        NodeList list = nodeList;
        Finishing cancelling = new Finishing(list, false, rootCause);
        if (!_state$FU.compareAndSet(this, state, cancelling)) {
            return false;
        }
        this.notifyCancelling(list, rootCause);
        return true;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(@Nullable Object proposedUpdate) {
        Object finalState;
        JobSupport this_$iv = this;
        boolean $i$f$loopOnState = false;
        do {
            Object state = this_$iv.getState$kotlinx_coroutines_core();
            boolean bl = false;
            finalState = this.tryMakeCompleting(state, proposedUpdate);
            if (finalState == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
                return false;
            }
            if (finalState != JobSupportKt.COMPLETING_WAITING_CHILDREN) continue;
            return true;
        } while (finalState == JobSupportKt.access$getCOMPLETING_RETRY$p());
        this.afterCompletion(finalState);
        return true;
    }

    @Nullable
    public final Object makeCompletingOnce$kotlinx_coroutines_core(@Nullable Object proposedUpdate) {
        Object finalState;
        JobSupport this_$iv = this;
        boolean $i$f$loopOnState = false;
        do {
            Object state = this_$iv.getState$kotlinx_coroutines_core();
            boolean bl = false;
            finalState = this.tryMakeCompleting(state, proposedUpdate);
            if (finalState != JobSupportKt.access$getCOMPLETING_ALREADY$p()) continue;
            throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + proposedUpdate, this.getExceptionOrNull(proposedUpdate));
        } while (finalState == JobSupportKt.access$getCOMPLETING_RETRY$p());
        return finalState;
    }

    private final Object tryMakeCompleting(Object state, Object proposedUpdate) {
        if (!(state instanceof Incomplete)) {
            return JobSupportKt.access$getCOMPLETING_ALREADY$p();
        }
        if ((state instanceof Empty || state instanceof JobNode) && !(state instanceof ChildHandleNode) && !(proposedUpdate instanceof CompletedExceptionally)) {
            if (this.tryFinalizeSimpleState((Incomplete)state, proposedUpdate)) {
                return proposedUpdate;
            }
            return JobSupportKt.access$getCOMPLETING_RETRY$p();
        }
        return this.tryMakeCompletingSlowPath((Incomplete)state, proposedUpdate);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final Object tryMakeCompletingSlowPath(Incomplete state, Object proposedUpdate) {
        NodeList nodeList = this.getOrPromoteCancellingList(state);
        if (nodeList == null) {
            return JobSupportKt.access$getCOMPLETING_RETRY$p();
        }
        NodeList list = nodeList;
        Finishing finishing = state instanceof Finishing ? (Finishing)state : null;
        if (finishing == null) {
            finishing = new Finishing(list, false, null);
        }
        Finishing finishing2 = finishing;
        Ref.ObjectRef notifyRootCause = new Ref.ObjectRef();
        boolean $i$f$synchronized = false;
        boolean $i$f$synchronizedImpl = false;
        Finishing finishing3 = finishing2;
        synchronized (finishing3) {
            Throwable throwable;
            block13: {
                block12: {
                    boolean bl = false;
                    if (!finishing2.isCompleting()) break block12;
                    Symbol symbol = JobSupportKt.access$getCOMPLETING_ALREADY$p();
                    return symbol;
                }
                finishing2.setCompleting(true);
                if (finishing2 == state || _state$FU.compareAndSet(this, state, finishing2)) break block13;
                Symbol symbol = JobSupportKt.access$getCOMPLETING_RETRY$p();
                return symbol;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl = false;
                if (!(!finishing2.isSealed())) {
                    throw new AssertionError();
                }
            }
            boolean wasCancelling = finishing2.isCancelling();
            CompletedExceptionally completedExceptionally = proposedUpdate instanceof CompletedExceptionally ? (CompletedExceptionally)proposedUpdate : null;
            if (completedExceptionally != null) {
                CompletedExceptionally it = completedExceptionally;
                boolean bl = false;
                finishing2.addExceptionLocked(it.cause);
            }
            Throwable throwable2 = throwable = finishing2.getRootCause();
            Ref.ObjectRef objectRef = notifyRootCause;
            boolean bl = false;
            objectRef.element = Boolean.valueOf(!wasCancelling) != false ? throwable : null;
            Unit unit = Unit.INSTANCE;
        }
        Throwable throwable = (Throwable)notifyRootCause.element;
        if (throwable != null) {
            Throwable it = throwable;
            boolean bl = false;
            this.notifyCancelling(list, it);
        }
        ChildHandleNode child = this.firstChild(state);
        if (child != null && this.tryWaitForChild(finishing2, child, proposedUpdate)) {
            return JobSupportKt.COMPLETING_WAITING_CHILDREN;
        }
        return this.finalizeFinishingState(finishing2, proposedUpdate);
    }

    private final Throwable getExceptionOrNull(Object $this$exceptionOrNull) {
        CompletedExceptionally completedExceptionally = $this$exceptionOrNull instanceof CompletedExceptionally ? (CompletedExceptionally)$this$exceptionOrNull : null;
        return completedExceptionally != null ? completedExceptionally.cause : null;
    }

    private final ChildHandleNode firstChild(Incomplete state) {
        ChildHandleNode childHandleNode = state instanceof ChildHandleNode ? (ChildHandleNode)state : null;
        if (childHandleNode == null) {
            NodeList nodeList = state.getList();
            childHandleNode = nodeList != null ? this.nextChild(nodeList) : null;
        }
        return childHandleNode;
    }

    private final boolean tryWaitForChild(Finishing state, ChildHandleNode child, Object proposedUpdate) {
        while (true) {
            ChildHandleNode nextChild;
            CompletionHandlerBase $this$asHandler$iv = new ChildCompletion(this_, state, child, proposedUpdate);
            boolean $i$f$getAsHandler = false;
            DisposableHandle handle = Job.DefaultImpls.invokeOnCompletion$default(child.childJob, false, false, $this$asHandler$iv, 1, null);
            if (handle != NonDisposableHandle.INSTANCE) {
                return true;
            }
            if (this_.nextChild(child) == null) {
                return false;
            }
            JobSupport jobSupport = this_;
            Finishing finishing = state;
            Object object = proposedUpdate;
            JobSupport this_ = jobSupport;
            state = finishing;
            child = nextChild;
            proposedUpdate = object;
        }
    }

    private final void continueCompleting(Finishing state, ChildHandleNode lastChild, Object proposedUpdate) {
        ChildHandleNode waitChild;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(this.getState$kotlinx_coroutines_core() == state)) {
                throw new AssertionError();
            }
        }
        if ((waitChild = this.nextChild(lastChild)) != null && this.tryWaitForChild(state, waitChild, proposedUpdate)) {
            return;
        }
        Object finalState = this.finalizeFinishingState(state, proposedUpdate);
        this.afterCompletion(finalState);
    }

    private final ChildHandleNode nextChild(LockFreeLinkedListNode $this$nextChild) {
        LockFreeLinkedListNode cur = $this$nextChild;
        while (cur.isRemoved()) {
            cur = cur.getPrevNode();
        }
        while (true) {
            if ((cur = cur.getNextNode()).isRemoved()) {
                continue;
            }
            if (cur instanceof ChildHandleNode) {
                return (ChildHandleNode)cur;
            }
            if (cur instanceof NodeList) break;
        }
        return null;
    }

    @Override
    @NotNull
    public final Sequence<Job> getChildren() {
        return SequencesKt.sequence((Function2)((Function2)new Function2<SequenceScope<? super Job>, Continuation<? super Unit>, Object>(this, null){
            Object L$1;
            Object L$2;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ JobSupport this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                block9: {
                    var11_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)var1_1);
                            $this$sequence = (SequenceScope)this.L$0;
                            state = this.this$0.getState$kotlinx_coroutines_core();
                            if (!(state instanceof ChildHandleNode)) break;
                            this.label = 1;
                            v0 = $this$sequence.yield((Object)((ChildHandleNode)state).childJob, (Continuation)this);
                            if (v0 == var11_2) {
                                return var11_2;
                            }
                            break;
                        }
                        case 1: {
                            ResultKt.throwOnFailure((Object)$result);
                            v0 = $result;
                            break;
                        }
                    }
                    if (!(state instanceof Incomplete)) break block9;
                    v1 = ((Incomplete)state).getList();
                    if (v1 == null) break block9;
                    list = v1;
                    $i$a$-let-JobSupport$children$1$1 = false;
                    this_$iv = list;
                    $i$f$forEach = false;
                    v2 = this_$iv.getNext();
                    Intrinsics.checkNotNull((Object)v2, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                    cur$iv = (LockFreeLinkedListNode)v2;
lbl27:
                    // 2 sources

                    while (!Intrinsics.areEqual((Object)cur$iv, (Object)this_$iv)) {
                        if (cur$iv instanceof ChildHandleNode) {
                            it = (ChildHandleNode)cur$iv;
                            $i$a$-forEach-JobSupport$children$1$1$1 = false;
                            this.L$0 = $this$sequence;
                            this.L$1 = this_$iv;
                            this.L$2 = cur$iv;
                            this.label = 2;
                            v3 = $this$sequence.yield((Object)it.childJob, (Continuation)this);
                            if (v3 == var11_2) {
                                return var11_2;
                            }
                        }
                        ** GOTO lbl49
                    }
                    {
                        break;
                        case 2: {
                            $i$a$-let-JobSupport$children$1$1 = false;
                            $i$f$forEach = false;
                            $i$a$-forEach-JobSupport$children$1$1$1 = false;
                            cur$iv = (LockFreeLinkedListNode)this.L$2;
                            this_$iv = (LockFreeLinkedListHead)this.L$1;
                            $this$sequence = (SequenceScope)this.L$0;
                            ResultKt.throwOnFailure((Object)$result);
                            v3 = $result;
lbl49:
                            // 2 sources

                            cur$iv = cur$iv.getNextNode();
                            ** GOTO lbl27
                        }
                    }
                }
                return Unit.INSTANCE;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<SequenceScope<? super Job>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull SequenceScope<? super Job> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }));
    }

    @Override
    @NotNull
    public final ChildHandle attachChild(@NotNull ChildJob child) {
        CompletionHandlerBase $this$asHandler$iv = new ChildHandleNode(child);
        boolean $i$f$getAsHandler = false;
        DisposableHandle disposableHandle = Job.DefaultImpls.invokeOnCompletion$default(this, true, false, $this$asHandler$iv, 2, null);
        Intrinsics.checkNotNull((Object)disposableHandle, (String)"null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (ChildHandle)disposableHandle;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable exception) {
        throw exception;
    }

    protected void onCancelling(@Nullable Throwable cause) {
    }

    protected boolean isScopedCoroutine() {
        return false;
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    protected boolean handleJobException(@NotNull Throwable exception) {
        return false;
    }

    protected void onCompletionInternal(@Nullable Object state) {
    }

    protected void afterCompletion(@Nullable Object state) {
    }

    @NotNull
    public String toString() {
        return this.toDebugString() + '@' + DebugStringsKt.getHexAddress(this);
    }

    @InternalCoroutinesApi
    @NotNull
    public final String toDebugString() {
        return this.nameString$kotlinx_coroutines_core() + '{' + this.stateString(this.getState$kotlinx_coroutines_core()) + '}';
    }

    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    private final String stateString(Object state) {
        Object object = state;
        return object instanceof Finishing ? (((Finishing)state).isCancelling() ? "Cancelling" : (((Finishing)state).isCompleting() ? "Completing" : "Active")) : (object instanceof Incomplete ? (((Incomplete)state).isActive() ? "Active" : "New") : (object instanceof CompletedExceptionally ? "Cancelled" : "Completed"));
    }

    private final boolean isCancelling(Incomplete $this$isCancelling) {
        return $this$isCancelling instanceof Finishing && ((Finishing)$this$isCancelling).isCancelling();
    }

    public final boolean isCompletedExceptionally() {
        return this.getState$kotlinx_coroutines_core() instanceof CompletedExceptionally;
    }

    @Nullable
    public final Throwable getCompletionExceptionOrNull() {
        Object state = this.getState$kotlinx_coroutines_core();
        if (!(!(state instanceof Incomplete))) {
            boolean bl = false;
            String string = "This job has not completed yet";
            throw new IllegalStateException(string.toString());
        }
        return this.getExceptionOrNull(state);
    }

    @Nullable
    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object state = this.getState$kotlinx_coroutines_core();
        if (!(!(state instanceof Incomplete))) {
            boolean bl = false;
            String string = "This job has not completed yet";
            throw new IllegalStateException(string.toString());
        }
        if (state instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally)state).cause;
        }
        return JobSupportKt.unboxState(state);
    }

    @Nullable
    protected final Object awaitInternal(@NotNull Continuation<Object> $completion) {
        Object state;
        do {
            if ((state = this.getState$kotlinx_coroutines_core()) instanceof Incomplete) continue;
            if (state instanceof CompletedExceptionally) {
                Throwable exception$iv = ((CompletedExceptionally)state).cause;
                boolean $i$f$recoverAndThrow = false;
                if (!DebugKt.getRECOVER_STACK_TRACES()) {
                    throw exception$iv;
                }
                Continuation<Object> it$iv = $completion;
                boolean bl = false;
                if (!(it$iv instanceof CoroutineStackFrame)) {
                    throw exception$iv;
                }
                throw StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv, (CoroutineStackFrame)it$iv);
            }
            return JobSupportKt.unboxState(state);
        } while (this.startInternal(state) < 0);
        return this.awaitSuspend($completion);
    }

    private final Object awaitSuspend(Continuation<Object> $completion) {
        Continuation<Object> uCont = $completion;
        boolean bl = false;
        AwaitContinuation cont = new AwaitContinuation(IntrinsicsKt.intercepted(uCont), this);
        cont.initCancellability();
        CompletionHandlerBase $this$asHandler$iv = new ResumeAwaitOnCompletion(cont);
        boolean $i$f$getAsHandler = false;
        CancellableContinuationKt.disposeOnCancellation(cont, this.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)$this$asHandler$iv)));
        Object object = cont.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    @NotNull
    protected final SelectClause1<?> getOnAwaitInternal() {
        onAwaitInternal.1 v0 = onAwaitInternal.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v0), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v0), (int)3);
        onAwaitInternal.2 v2 = onAwaitInternal.2.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v2), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, function3, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v2), (int)3), null, 8, null);
    }

    protected static /* synthetic */ void getOnAwaitInternal$annotations() {
    }

    private final void onAwaitInternalRegFunc(SelectInstance<?> select, Object ignoredParam) {
        Object state;
        do {
            if ((state = this.getState$kotlinx_coroutines_core()) instanceof Incomplete) continue;
            Object result2 = state instanceof CompletedExceptionally ? state : JobSupportKt.unboxState(state);
            select.selectInRegistrationPhase(result2);
            return;
        } while (this.startInternal(state) < 0);
        CompletionHandlerBase $this$asHandler$iv = new SelectOnAwaitCompletionHandler(select);
        boolean $i$f$getAsHandler = false;
        DisposableHandle disposableHandle = this.invokeOnCompletion((Function1<? super Throwable, Unit>)((Function1)$this$asHandler$iv));
        select.disposeOnCompletion(disposableHandle);
    }

    private final Object onAwaitInternalProcessResFunc(Object ignoredParam, Object result2) {
        if (result2 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally)result2).cause;
        }
        return result2;
    }

    @Override
    @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
    public /* synthetic */ void cancel() {
        Job.DefaultImpls.cancel(this);
    }

    @Override
    @Deprecated(message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.", level=DeprecationLevel.ERROR)
    @NotNull
    public Job plus(@NotNull Job other) {
        return Job.DefaultImpls.plus((Job)this, other);
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext context) {
        return Job.DefaultImpls.plus((Job)this, context);
    }

    public <R> R fold(R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        return Job.DefaultImpls.fold(this, initial, operation);
    }

    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return Job.DefaultImpls.get(this, key);
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.minusKey(this, key);
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicfu$handler, Function1<Object, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            atomicfu$action.invoke(atomicfu$handler.get(atomicfu$dispatchReceiver));
        }
    }

    public static final /* synthetic */ Object access$joinSuspend(JobSupport $this, Continuation $completion) {
        return $this.joinSuspend((Continuation<? super Unit>)$completion);
    }

    public static final /* synthetic */ void access$registerSelectForOnJoin(JobSupport $this, SelectInstance select, Object ignoredParam) {
        $this.registerSelectForOnJoin(select, ignoredParam);
    }

    public static final /* synthetic */ Object access$awaitSuspend(JobSupport $this, Continuation $completion) {
        return $this.awaitSuspend((Continuation<Object>)$completion);
    }

    public static final /* synthetic */ void access$onAwaitInternalRegFunc(JobSupport $this, SelectInstance select, Object ignoredParam) {
        $this.onAwaitInternalRegFunc(select, ignoredParam);
    }

    public static final /* synthetic */ Object access$onAwaitInternalProcessResFunc(JobSupport $this, Object ignoredParam, Object result2) {
        return $this.onAwaitInternalProcessResFunc(ignoredParam, result2);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2={"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlinx/coroutines/Job;", "parent", "", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "", "nameString", "()Ljava/lang/String;", "Lkotlinx/coroutines/JobSupport;", "job", "Lkotlinx/coroutines/JobSupport;", "Lkotlin/coroutines/Continuation;", "delegate", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$AwaitContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
    private static final class AwaitContinuation<T>
    extends CancellableContinuationImpl<T> {
        @NotNull
        private final JobSupport job;

        public AwaitContinuation(@NotNull Continuation<? super T> delegate, @NotNull JobSupport job) {
            super(delegate, 1);
            this.job = job;
        }

        @Override
        @NotNull
        public Throwable getContinuationCancellationCause(@NotNull Job parent) {
            Throwable throwable;
            Object state = this.job.getState$kotlinx_coroutines_core();
            if (state instanceof Finishing && (throwable = ((Finishing)state).getRootCause()) != null) {
                Throwable it = throwable;
                boolean bl = false;
                return it;
            }
            if (state instanceof CompletedExceptionally) {
                return ((CompletedExceptionally)state).cause;
            }
            return parent.getCancellationException();
        }

        @Override
        @NotNull
        protected String nameString() {
            return "AwaitContinuation";
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2={"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/ChildHandleNode;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobSupport;", "parent", "Lkotlinx/coroutines/JobSupport;", "", "proposedUpdate", "Ljava/lang/Object;", "Lkotlinx/coroutines/JobSupport$Finishing;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "kotlinx-coroutines-core"})
    private static final class ChildCompletion
    extends JobNode {
        @NotNull
        private final JobSupport parent;
        @NotNull
        private final Finishing state;
        @NotNull
        private final ChildHandleNode child;
        @Nullable
        private final Object proposedUpdate;

        public ChildCompletion(@NotNull JobSupport parent, @NotNull Finishing state, @NotNull ChildHandleNode child, @Nullable Object proposedUpdate) {
            this.parent = parent;
            this.state = state;
            this.child = child;
            this.proposedUpdate = proposedUpdate;
        }

        @Override
        public void invoke(@Nullable Throwable cause) {
            this.parent.continueCompleting(this.state, this.child, this.proposedUpdate);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010#\u001a\u00020\u001f\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b0\u00101J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\tj\b\u0012\u0004\u0012\u00020\u0004`\nH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00148\u0002X\u0082\u0004R\u000b\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004R\u0013\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00148\u0002X\u0082\u0004R(\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u001f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010!R$\u0010#\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b#\u0010!\"\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010!R\u001a\u0010(\u001a\u00020'8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R(\u0010/\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\b\u00a8\u00062"}, d2={"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/atomicfu/AtomicRef;", "_exceptionsHolder", "Lkotlinx/atomicfu/AtomicBoolean;", "_isCompleting", "_rootCause", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "", "isActive", "()Z", "isCancelling", "isCompleting", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "kotlinx-coroutines-core"})
    @SourceDebugExtension(value={"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$Finishing\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1454:1\n1#2:1455\n*E\n"})
    private static final class Finishing
    implements Incomplete {
        @NotNull
        private final NodeList list;
        @Volatile
        private volatile int _isCompleting;
        @Volatile
        @Nullable
        private volatile Object _rootCause;
        @Volatile
        @Nullable
        private volatile Object _exceptionsHolder;
        @NotNull
        private static final AtomicIntegerFieldUpdater _isCompleting$FU = AtomicIntegerFieldUpdater.newUpdater(Finishing.class, "_isCompleting");
        @NotNull
        private static final AtomicReferenceFieldUpdater _rootCause$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_rootCause");
        @NotNull
        private static final AtomicReferenceFieldUpdater _exceptionsHolder$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_exceptionsHolder");

        public Finishing(@NotNull NodeList list, boolean isCompleting, @Nullable Throwable rootCause) {
            this.list = list;
            this._isCompleting = isCompleting ? 1 : 0;
            this._rootCause = rootCause;
        }

        @Override
        @NotNull
        public NodeList getList() {
            return this.list;
        }

        public final boolean isCompleting() {
            return _isCompleting$FU.get(this) != 0;
        }

        public final void setCompleting(boolean value) {
            _isCompleting$FU.set(this, value ? 1 : 0);
        }

        @Nullable
        public final Throwable getRootCause() {
            return (Throwable)_rootCause$FU.get(this);
        }

        public final void setRootCause(@Nullable Throwable value) {
            _rootCause$FU.set(this, value);
        }

        private final Object getExceptionsHolder() {
            return _exceptionsHolder$FU.get(this);
        }

        private final void setExceptionsHolder(Object value) {
            _exceptionsHolder$FU.set(this, value);
        }

        public final boolean isSealed() {
            return this.getExceptionsHolder() == JobSupportKt.access$getSEALED$p();
        }

        public final boolean isCancelling() {
            return this.getRootCause() != null;
        }

        @Override
        public boolean isActive() {
            return this.getRootCause() == null;
        }

        @NotNull
        public final List<Throwable> sealLocked(@Nullable Throwable proposedException) {
            Throwable rootCause;
            Serializable it;
            ArrayList<Throwable> arrayList;
            Object eh = this.getExceptionsHolder();
            if (eh == null) {
                arrayList = this.allocateList();
            } else if (eh instanceof Throwable) {
                ArrayList<Throwable> arrayList2 = this.allocateList();
                it = arrayList2;
                boolean bl = false;
                ((ArrayList)it).add((Throwable)eh);
                arrayList = arrayList2;
            } else if (eh instanceof ArrayList) {
                arrayList = (ArrayList<Throwable>)eh;
            } else {
                throw new IllegalStateException(("State is " + eh).toString());
            }
            ArrayList<Throwable> list = arrayList;
            Throwable throwable = rootCause = this.getRootCause();
            if (throwable != null) {
                it = throwable;
                boolean bl = false;
                list.add(0, (Throwable)it);
            }
            if (proposedException != null && !Intrinsics.areEqual((Object)proposedException, (Object)rootCause)) {
                list.add(proposedException);
            }
            this.setExceptionsHolder(JobSupportKt.access$getSEALED$p());
            return list;
        }

        /*
         * WARNING - void declaration
         */
        public final void addExceptionLocked(@NotNull Throwable exception) {
            Throwable rootCause = this.getRootCause();
            if (rootCause == null) {
                this.setRootCause(exception);
                return;
            }
            if (exception == rootCause) {
                return;
            }
            Object eh = this.getExceptionsHolder();
            if (eh == null) {
                this.setExceptionsHolder(exception);
            } else if (eh instanceof Throwable) {
                void $this$addExceptionLocked_u24lambda_u242;
                ArrayList<Throwable> arrayList;
                if (exception == eh) {
                    return;
                }
                ArrayList<Throwable> arrayList2 = arrayList = this.allocateList();
                Finishing finishing = this;
                boolean bl = false;
                $this$addExceptionLocked_u24lambda_u242.add(eh);
                $this$addExceptionLocked_u24lambda_u242.add(exception);
                finishing.setExceptionsHolder(arrayList);
            } else if (eh instanceof ArrayList) {
                ((ArrayList)eh).add(exception);
            } else {
                throw new IllegalStateException(("State is " + eh).toString());
            }
        }

        private final ArrayList<Throwable> allocateList() {
            return new ArrayList<Throwable>(4);
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + this.isCancelling() + ", completing=" + this.isCompleting() + ", rootCause=" + this.getRootCause() + ", exceptions=" + this.getExceptionsHolder() + ", list=" + this.getList() + ']';
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2={"Lkotlinx/coroutines/JobSupport$SelectOnAwaitCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "kotlinx-coroutines-core"})
    private final class SelectOnAwaitCompletionHandler
    extends JobNode {
        @NotNull
        private final SelectInstance<?> select;

        public SelectOnAwaitCompletionHandler(SelectInstance<?> select) {
            this.select = select;
        }

        @Override
        public void invoke(@Nullable Throwable cause) {
            Object state = JobSupport.this.getState$kotlinx_coroutines_core();
            Object result2 = state instanceof CompletedExceptionally ? state : JobSupportKt.unboxState(state);
            this.select.trySelect(JobSupport.this, result2);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2={"Lkotlinx/coroutines/JobSupport$SelectOnJoinCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "kotlinx-coroutines-core"})
    private final class SelectOnJoinCompletionHandler
    extends JobNode {
        @NotNull
        private final SelectInstance<?> select;

        public SelectOnJoinCompletionHandler(SelectInstance<?> select) {
            this.select = select;
        }

        @Override
        public void invoke(@Nullable Throwable cause) {
            this.select.trySelect(JobSupport.this, Unit.INSTANCE);
        }
    }
}


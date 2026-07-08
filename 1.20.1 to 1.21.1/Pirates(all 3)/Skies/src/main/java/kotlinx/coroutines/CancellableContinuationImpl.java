/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.Volatile
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Active;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancelledContinuation;
import kotlinx.coroutines.ChildContinuation;
import kotlinx.coroutines.CompletedContinuation;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionHandlerBase;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.DispatchedTaskKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InvokeOnCancel;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u00052\u00020\u0006B!\u0012\u000e\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u008a\u0001\u0012\u0006\u0010a\u001a\u000201\u00a2\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0012JB\u0010\u0011\u001a\u00020\u00102'\u0010\r\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0013j\u0002`\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0017J\u001e\u0010\u001a\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018H\u0082\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ8\u0010\u001d\u001a\u00020\u00102!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u00132\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001d\u0010\u0017J%\u0010 \u001a\u00020\u00102\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002\u00a2\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u00020\"2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b#\u0010$J!\u0010(\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0010\u00a2\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b)\u0010$J\u0017\u0010+\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b+\u0010,J\u000f\u0010/\u001a\u00020\u0010H\u0000\u00a2\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020\u0010H\u0002\u00a2\u0006\u0004\b0\u0010.J\u0017\u00103\u001a\u00020\u00102\u0006\u00102\u001a\u000201H\u0002\u00a2\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u000e2\u0006\u00106\u001a\u000205H\u0016\u00a2\u0006\u0004\b7\u00108J\u001b\u0010<\u001a\u0004\u0018\u00010\u000e2\b\u00109\u001a\u0004\u0018\u00010\u0007H\u0010\u00a2\u0006\u0004\b:\u0010;J\u0011\u0010=\u001a\u0004\u0018\u00010\u0007H\u0001\u00a2\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\n\u0018\u00010?j\u0004\u0018\u0001`@H\u0016\u00a2\u0006\u0004\bA\u0010BJ\u001f\u0010E\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u00109\u001a\u0004\u0018\u00010\u0007H\u0010\u00a2\u0006\u0004\bC\u0010DJ\u000f\u0010F\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\bF\u0010.J\u0011\u0010H\u001a\u0004\u0018\u00010GH\u0002\u00a2\u0006\u0004\bH\u0010IJ8\u0010J\u001a\u00020\u00102'\u0010\r\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0013j\u0002`\u0016H\u0016\u00a2\u0006\u0004\bJ\u0010KJ#\u0010J\u001a\u00020\u00102\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010L\u001a\u000201H\u0016\u00a2\u0006\u0004\bJ\u0010MJ\u0017\u0010N\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\bN\u0010,J\u000f\u0010O\u001a\u00020\"H\u0002\u00a2\u0006\u0004\bO\u0010PJ8\u0010Q\u001a\u00020\f2'\u0010\r\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0013j\u0002`\u0016H\u0002\u00a2\u0006\u0004\bQ\u0010RJ!\u0010S\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00072\b\u00109\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\bS\u0010TJ\u000f\u0010V\u001a\u00020UH\u0014\u00a2\u0006\u0004\bV\u0010WJ\u0017\u0010Z\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0000\u00a2\u0006\u0004\bX\u0010YJ\u000f\u0010\\\u001a\u00020\u0010H\u0000\u00a2\u0006\u0004\b[\u0010.J\u000f\u0010]\u001a\u00020\"H\u0001\u00a2\u0006\u0004\b]\u0010PJ<\u0010_\u001a\u00020\u00102\u0006\u0010^\u001a\u00028\u00002#\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013H\u0016\u00a2\u0006\u0004\b_\u0010`JH\u0010b\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010a\u001a\u0002012%\b\u0002\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013H\u0002\u00a2\u0006\u0004\bb\u0010cJ \u0010f\u001a\u00020\u00102\f\u0010e\u001a\b\u0012\u0004\u0012\u00028\u00000dH\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\bf\u0010,JZ\u0010i\u001a\u0004\u0018\u00010\u00072\u0006\u00109\u001a\u00020g2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010a\u001a\u0002012#\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00132\b\u0010h\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\bi\u0010jJ\u0011\u0010l\u001a\u0004\u0018\u00010\u0007H\u0010\u00a2\u0006\u0004\bk\u0010>J\u000f\u0010m\u001a\u00020UH\u0016\u00a2\u0006\u0004\bm\u0010WJ\u000f\u0010n\u001a\u00020\"H\u0002\u00a2\u0006\u0004\bn\u0010PJ#\u0010n\u001a\u0004\u0018\u00010\u00072\u0006\u0010^\u001a\u00028\u00002\b\u0010h\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\bn\u0010oJH\u0010n\u001a\u0004\u0018\u00010\u00072\u0006\u0010^\u001a\u00028\u00002\b\u0010h\u001a\u0004\u0018\u00010\u00072#\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013H\u0016\u00a2\u0006\u0004\bn\u0010pJJ\u0010r\u001a\u0004\u0018\u00010q2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010h\u001a\u0004\u0018\u00010\u00072#\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013H\u0002\u00a2\u0006\u0004\br\u0010sJ\u0019\u0010u\u001a\u0004\u0018\u00010\u00072\u0006\u0010t\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\bu\u0010vJ\u000f\u0010w\u001a\u00020\"H\u0002\u00a2\u0006\u0004\bw\u0010PJ\u001b\u0010y\u001a\u00020\u0010*\u00020x2\u0006\u0010^\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\by\u0010zJ\u001b\u0010{\u001a\u00020\u0010*\u00020x2\u0006\u0010t\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b{\u0010|R\u000b\u0010~\u001a\u00020}8\u0002X\u0082\u0004R\u0014\u0010\u0080\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010G0\u007f8\u0002X\u0082\u0004R\u0014\u0010\u0081\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u007f8\u0002X\u0082\u0004R\u001f\u0010\u0084\u0001\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R \u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0016X\u0096\u0004\u00a2\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R&\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u008a\u00018\u0000X\u0080\u0004\u00a2\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0016\u0010\u008f\u0001\u001a\u00020\"8VX\u0096\u0004\u00a2\u0006\u0007\u001a\u0005\b\u008f\u0001\u0010PR\u0016\u0010\u0090\u0001\u001a\u00020\"8VX\u0096\u0004\u00a2\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010PR\u0016\u0010\u0091\u0001\u001a\u00020\"8VX\u0096\u0004\u00a2\u0006\u0007\u001a\u0005\b\u0091\u0001\u0010PR\u0018\u0010\u0093\u0001\u001a\u0004\u0018\u00010G8BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u0092\u0001\u0010IR\u0017\u00109\u001a\u0004\u0018\u00010\u00078@X\u0080\u0004\u00a2\u0006\u0007\u001a\u0005\b\u0094\u0001\u0010>R\u0016\u0010\u0096\u0001\u001a\u00020U8BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u0095\u0001\u0010W\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0099\u0001"}, d2={"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/Waiter;", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)Ljava/lang/Void;", "Lkotlinx/coroutines/CancelHandler;", "handler", "", "cause", "", "callCancelHandler", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "Lkotlin/Function0;", "block", "callCancelHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "onCancellation", "callOnCancellation", "Lkotlinx/coroutines/internal/Segment;", "segment", "callSegmentOnCancellation", "(Lkotlinx/coroutines/internal/Segment;Ljava/lang/Throwable;)V", "", "cancel", "(Ljava/lang/Throwable;)Z", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "cancelLater", "token", "completeResume", "(Ljava/lang/Object;)V", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "state", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlinx/coroutines/DisposableHandle;", "installParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "index", "(Lkotlinx/coroutines/internal/Segment;I)V", "invokeOnCancellationImpl", "isReusable", "()Z", "makeCancelHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Ljava/lang/Object;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "releaseClaimedReusableContinuation$kotlinx_coroutines_core", "releaseClaimedReusableContinuation", "resetStateReusable", "value", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeMode", "resumeImpl", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lkotlin/Result;", "result", "resumeWith", "Lkotlinx/coroutines/NotCompleted;", "idempotent", "resumedState", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/Symbol;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlinx/atomicfu/AtomicInt;", "_decisionAndIndex", "Lkotlinx/atomicfu/AtomicRef;", "_parentHandle", "_state", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "getParentHandle", "parentHandle", "getState$kotlinx_coroutines_core", "getStateDebugRepresentation", "stateDebugRepresentation", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "kotlinx-coroutines-core"})
@PublishedApi
@SourceDebugExtension(value={"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImplKt\n+ 4 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,662:1\n230#1,2:666\n232#1,8:669\n230#1,10:677\n230#1,10:688\n1#2:663\n24#3:664\n24#3:665\n22#3:687\n21#3:698\n22#3,3:699\n21#3:702\n22#3,3:703\n22#3:711\n21#3,4:712\n22#4:668\n13#4:710\n61#5,2:706\n61#5,2:708\n61#5,2:716\n*S KotlinDebug\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n*L\n246#1:666,2\n246#1:669,8\n249#1:677,10\n254#1:688,10\n72#1:664\n158#1:665\n252#1:687\n277#1:698\n278#1:699,3\n287#1:702\n288#1:703,3\n389#1:711\n392#1:712,4\n246#1:668\n350#1:710\n329#1:706,2\n339#1:708,2\n613#1:716,2\n*E\n"})
public class CancellableContinuationImpl<T>
extends DispatchedTask<T>
implements CancellableContinuation<T>,
CoroutineStackFrame,
Waiter {
    @NotNull
    private final Continuation<T> delegate;
    @NotNull
    private final CoroutineContext context;
    @Volatile
    private volatile int _decisionAndIndex;
    @Volatile
    @Nullable
    private volatile Object _state;
    @Volatile
    @Nullable
    private volatile Object _parentHandle;
    @NotNull
    private static final AtomicIntegerFieldUpdater _decisionAndIndex$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decisionAndIndex");
    @NotNull
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    @NotNull
    private static final AtomicReferenceFieldUpdater _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_parentHandle");

    /*
     * WARNING - void declaration
     */
    public CancellableContinuationImpl(@NotNull Continuation<? super T> delegate, int resumeMode) {
        super(resumeMode);
        void decision$iv;
        boolean bl;
        this.delegate = delegate;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            bl = false;
            if (!(resumeMode != -1)) {
                throw new AssertionError();
            }
        }
        this.context = this.delegate.getContext();
        bl = false;
        int index$iv = 0x1FFFFFFF;
        boolean $i$f$decisionAndIndex = false;
        this._decisionAndIndex = (decision$iv << 29) + index$iv;
        this._state = Active.INSTANCE;
    }

    @Override
    @NotNull
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @NotNull
    public CoroutineContext getContext() {
        return this.context;
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle)_parentHandle$FU.get(this);
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        return _state$FU.get(this);
    }

    @Override
    public boolean isActive() {
        return this.getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    @Override
    public boolean isCompleted() {
        return !(this.getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    @Override
    public boolean isCancelled() {
        return this.getState$kotlinx_coroutines_core() instanceof CancelledContinuation;
    }

    private final String getStateDebugRepresentation() {
        Object object = this.getState$kotlinx_coroutines_core();
        return object instanceof NotCompleted ? "Active" : (object instanceof CancelledContinuation ? "Cancelled" : "Completed");
    }

    @Override
    public void initCancellability() {
        DisposableHandle disposableHandle = this.installParentHandle();
        if (disposableHandle == null) {
            return;
        }
        DisposableHandle handle = disposableHandle;
        if (this.isCompleted()) {
            handle.dispose();
            _parentHandle$FU.set(this, NonDisposableHandle.INSTANCE);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean isReusable() {
        if (!DispatchedTaskKt.isReusableMode(this.resumeMode)) return false;
        Continuation<T> continuation = this.delegate;
        Intrinsics.checkNotNull(continuation, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        if (!((DispatchedContinuation)continuation).isReusable$kotlinx_coroutines_core()) return false;
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="resetStateReusable")
    public final boolean resetStateReusable() {
        void decision$iv;
        boolean bl;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl2 = false;
            if (!(this.resumeMode == 2)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl3 = false;
            if (!(this.getParentHandle() != NonDisposableHandle.INSTANCE)) {
                throw new AssertionError();
            }
        }
        Object state = _state$FU.get(this);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            bl = false;
            if (!(!(state instanceof NotCompleted))) {
                throw new AssertionError();
            }
        }
        if (state instanceof CompletedContinuation && ((CompletedContinuation)state).idempotentResume != null) {
            this.detachChild$kotlinx_coroutines_core();
            return false;
        }
        bl = false;
        int index$iv = 0x1FFFFFFF;
        boolean $i$f$decisionAndIndex = false;
        _decisionAndIndex$FU.set(this, (int)((decision$iv << 29) + index$iv));
        _state$FU.set(this, Active.INSTANCE);
        return true;
    }

    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        return continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame)continuation : null;
    }

    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override
    @Nullable
    public Object takeState$kotlinx_coroutines_core() {
        return this.getState$kotlinx_coroutines_core();
    }

    @Override
    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object takenState, @NotNull Throwable cause) {
        CancellableContinuationImpl cancellableContinuationImpl = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _state$FU;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            Object state = atomicfu$handler$iv.get(this);
            boolean bl = false;
            Object v = state;
            if (v instanceof NotCompleted) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (v instanceof CompletedExceptionally) {
                return;
            }
            if (v instanceof CompletedContinuation) {
                if (!(!((CompletedContinuation)state).getCancelled())) {
                    boolean bl2 = false;
                    String string = "Must be called at most once";
                    throw new IllegalStateException(string.toString());
                }
                CompletedContinuation update = CompletedContinuation.copy$default((CompletedContinuation)state, null, null, null, null, cause, 15, null);
                if (!_state$FU.compareAndSet(this, state, update)) continue;
                ((CompletedContinuation)state).invokeHandlers(this, cause);
                return;
            }
            if (_state$FU.compareAndSet(this, state, new CompletedContinuation(state, null, null, null, cause, 14, null))) break;
        }
    }

    private final boolean cancelLater(Throwable cause) {
        if (!this.isReusable()) {
            return false;
        }
        Continuation<T> continuation = this.delegate;
        Intrinsics.checkNotNull(continuation, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        DispatchedContinuation dispatched = (DispatchedContinuation)continuation;
        return dispatched.postponeCancellation$kotlinx_coroutines_core(cause);
    }

    @Override
    public boolean cancel(@Nullable Throwable cause) {
        CancelledContinuation update;
        Object state;
        CancellableContinuationImpl cancellableContinuationImpl = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _state$FU;
        boolean $i$f$loop$atomicfu = false;
        do {
            state = atomicfu$handler$iv.get(this);
            boolean bl = false;
            if (state instanceof NotCompleted) continue;
            return false;
        } while (!_state$FU.compareAndSet(this, state, update = new CancelledContinuation(this, cause, state instanceof CancelHandler || state instanceof Segment)));
        NotCompleted notCompleted = (NotCompleted)state;
        if (notCompleted instanceof CancelHandler) {
            this.callCancelHandler((CancelHandler)state, cause);
        } else if (notCompleted instanceof Segment) {
            this.callSegmentOnCancellation((Segment)state, cause);
        }
        this.detachChildIfNonResuable();
        this.dispatchResume(this.resumeMode);
        return true;
    }

    public final void parentCancelled$kotlinx_coroutines_core(@NotNull Throwable cause) {
        if (this.cancelLater(cause)) {
            return;
        }
        this.cancel(cause);
        this.detachChildIfNonResuable();
    }

    private final void callCancelHandlerSafely(Function0<Unit> block) {
        boolean $i$f$callCancelHandlerSafely = false;
        try {
            block.invoke();
        }
        catch (Throwable ex) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, ex));
        }
    }

    private final void callCancelHandler(Function1<? super Throwable, Unit> handler, Throwable cause) {
        CancellableContinuationImpl this_$iv = this;
        boolean $i$f$callCancelHandlerSafely = false;
        try {
            boolean bl = false;
            Function1<? super Throwable, Unit> $this$invokeIt$iv = handler;
            boolean $i$f$invokeIt = false;
            $this$invokeIt$iv.invoke((Object)cause);
        }
        catch (Throwable ex$iv) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this_$iv.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this_$iv, ex$iv));
        }
    }

    public final void callCancelHandler(@NotNull CancelHandler handler, @Nullable Throwable cause) {
        CancellableContinuationImpl this_$iv = this;
        boolean $i$f$callCancelHandlerSafely = false;
        try {
            boolean bl = false;
            handler.invoke(cause);
        }
        catch (Throwable ex$iv) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this_$iv.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this_$iv, ex$iv));
        }
    }

    private final void callSegmentOnCancellation(Segment<?> segment, Throwable cause) {
        int $this$index$iv = _decisionAndIndex$FU.get(this);
        boolean $i$f$getIndex = false;
        int index = $this$index$iv & 0x1FFFFFFF;
        if (!(index != 0x1FFFFFFF)) {
            boolean $i$a$-check-CancellableContinuationImpl$callSegmentOnCancellation$22 = false;
            String $i$a$-check-CancellableContinuationImpl$callSegmentOnCancellation$22 = "The index for Segment.onCancellation(..) is broken";
            throw new IllegalStateException($i$a$-check-CancellableContinuationImpl$callSegmentOnCancellation$22.toString());
        }
        CancellableContinuationImpl this_$iv = this;
        boolean $i$f$callCancelHandlerSafely = false;
        try {
            boolean bl = false;
            segment.onCancellation(index, cause, this.getContext());
        }
        catch (Throwable ex$iv) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this_$iv.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this_$iv, ex$iv));
        }
    }

    public final void callOnCancellation(@NotNull Function1<? super Throwable, Unit> onCancellation, @NotNull Throwable cause) {
        try {
            onCancellation.invoke((Object)cause);
        }
        catch (Throwable ex) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, ex));
        }
    }

    @NotNull
    public Throwable getContinuationCancellationCause(@NotNull Job parent) {
        return parent.getCancellationException();
    }

    /*
     * WARNING - void declaration
     */
    private final boolean trySuspend() {
        CancellableContinuationImpl cancellableContinuationImpl = this;
        AtomicIntegerFieldUpdater atomicfu$handler$iv = _decisionAndIndex$FU;
        boolean $i$f$loop$atomicfu = false;
        block4: while (true) {
            int cur = atomicfu$handler$iv.get(this);
            boolean bl = false;
            int $this$decision$iv = cur;
            boolean $i$f$getDecision = false;
            switch ($this$decision$iv >> 29) {
                case 0: {
                    void decision$iv;
                    $this$decision$iv = 1;
                    int $this$index$iv = cur;
                    boolean $i$f$getIndex = false;
                    int index$iv = $this$index$iv & 0x1FFFFFFF;
                    boolean $i$f$decisionAndIndex = false;
                    if (!_decisionAndIndex$FU.compareAndSet(this, cur, (int)((decision$iv << 29) + index$iv))) continue block4;
                    return true;
                }
                case 2: {
                    return false;
                }
                default: {
                    throw new IllegalStateException("Already suspended".toString());
                }
            }
            break;
        }
    }

    /*
     * WARNING - void declaration
     */
    private final boolean tryResume() {
        CancellableContinuationImpl cancellableContinuationImpl = this;
        AtomicIntegerFieldUpdater atomicfu$handler$iv = _decisionAndIndex$FU;
        boolean $i$f$loop$atomicfu = false;
        block4: while (true) {
            int cur = atomicfu$handler$iv.get(this);
            boolean bl = false;
            int $this$decision$iv = cur;
            boolean $i$f$getDecision = false;
            switch ($this$decision$iv >> 29) {
                case 0: {
                    void decision$iv;
                    $this$decision$iv = 2;
                    int $this$index$iv = cur;
                    boolean $i$f$getIndex = false;
                    int index$iv = $this$index$iv & 0x1FFFFFFF;
                    boolean $i$f$decisionAndIndex = false;
                    if (!_decisionAndIndex$FU.compareAndSet(this, cur, (int)((decision$iv << 29) + index$iv))) continue block4;
                    return true;
                }
                case 1: {
                    return false;
                }
                default: {
                    throw new IllegalStateException("Already resumed".toString());
                }
            }
            break;
        }
    }

    @PublishedApi
    @Nullable
    public final Object getResult() {
        Job job;
        Object state;
        boolean isReusable = this.isReusable();
        if (this.trySuspend()) {
            if (this.getParentHandle() == null) {
                this.installParentHandle();
            }
            if (isReusable) {
                this.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            }
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (isReusable) {
            this.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        }
        if ((state = this.getState$kotlinx_coroutines_core()) instanceof CompletedExceptionally) {
            Throwable exception$iv = ((CompletedExceptionally)state).cause;
            boolean $i$f$recoverStackTrace = false;
            throw !DebugKt.getRECOVER_STACK_TRACES() || !((Continuation)this instanceof CoroutineStackFrame) ? exception$iv : StackTraceRecoveryKt.access$recoverFromStackFrame(exception$iv, (CoroutineStackFrame)((Continuation)this));
        }
        if (DispatchedTaskKt.isCancellableMode(this.resumeMode) && (job = (Job)this.getContext().get((CoroutineContext.Key)Job.Key)) != null && !job.isActive()) {
            CancellationException cause = job.getCancellationException();
            this.cancelCompletedResult$kotlinx_coroutines_core(state, cause);
            boolean $i$f$recoverStackTrace = false;
            throw !DebugKt.getRECOVER_STACK_TRACES() || !((Continuation)this instanceof CoroutineStackFrame) ? (Throwable)cause : StackTraceRecoveryKt.access$recoverFromStackFrame(cause, (CoroutineStackFrame)((Continuation)this));
        }
        return this.getSuccessfulResult$kotlinx_coroutines_core(state);
    }

    private final DisposableHandle installParentHandle() {
        Job job = (Job)this.getContext().get((CoroutineContext.Key)Job.Key);
        if (job == null) {
            return null;
        }
        Job parent = job;
        CompletionHandlerBase $this$asHandler$iv = new ChildContinuation(this);
        boolean $i$f$getAsHandler = false;
        DisposableHandle handle = Job.DefaultImpls.invokeOnCompletion$default(parent, true, false, $this$asHandler$iv, 2, null);
        _parentHandle$FU.compareAndSet(this, null, handle);
        return handle;
    }

    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        Continuation<T> continuation = this.delegate;
        Object object = continuation instanceof DispatchedContinuation ? (DispatchedContinuation)continuation : null;
        if (object == null || (object = ((DispatchedContinuation)object).tryReleaseClaimedContinuation$kotlinx_coroutines_core(this)) == null) {
            return;
        }
        Object cancellationCause = object;
        this.detachChild$kotlinx_coroutines_core();
        this.cancel((Throwable)cancellationCause);
    }

    public void resumeWith(@NotNull Object result2) {
        CancellableContinuationImpl.resumeImpl$default(this, CompletionStateKt.toState(result2, this), this.resumeMode, null, 4, null);
    }

    @Override
    public void resume(T value, @Nullable Function1<? super Throwable, Unit> onCancellation) {
        this.resumeImpl(value, this.resumeMode, onCancellation);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
        void decision$iv;
        void var7_7;
        int n2;
        CancellableContinuationImpl cancellableContinuationImpl = this;
        AtomicIntegerFieldUpdater atomicfu$handler$iv = _decisionAndIndex$FU;
        boolean $i$f$update$atomicfu = false;
        do {
            int it = n2 = atomicfu$handler$iv.get(this);
            boolean bl = false;
            int $this$index$iv = it;
            boolean $i$f$getIndex = false;
            if (!(($this$index$iv & 0x1FFFFFFF) == 0x1FFFFFFF)) {
                boolean $i$a$-check-CancellableContinuationImpl$invokeOnCancellation$1$22 = false;
                String $i$a$-check-CancellableContinuationImpl$invokeOnCancellation$1$22 = "invokeOnCancellation should be called at most once";
                throw new IllegalStateException($i$a$-check-CancellableContinuationImpl$invokeOnCancellation$1$22.toString());
            }
            int $this$decision$iv = it;
            boolean $i$f$getDecision = false;
            $this$decision$iv >>= 29;
            boolean $i$f$decisionAndIndex = false;
        } while (!atomicfu$handler$iv.compareAndSet(this, n2, (int)(var7_7 = (decision$iv << 29) + index)));
        this.invokeOnCancellationImpl(segment);
    }

    @Override
    public void invokeOnCancellation(@NotNull Function1<? super Throwable, Unit> handler) {
        CancelHandler cancelHandler = this.makeCancelHandler(handler);
        this.invokeOnCancellationImpl(cancelHandler);
    }

    private final void invokeOnCancellationImpl(Object handler) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(handler instanceof CancelHandler || handler instanceof Segment)) {
                throw new AssertionError();
            }
        }
        CancellableContinuationImpl bl = this;
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _state$FU;
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            CompletedContinuation update;
            Object state = atomicfu$handler$iv.get(this);
            boolean bl2 = false;
            Object v = state;
            if (v instanceof Active) {
                if (!_state$FU.compareAndSet(this, state, handler)) continue;
                return;
            }
            if (v instanceof CancelHandler ? true : v instanceof Segment) {
                this.multipleHandlersError(handler, state);
                continue;
            }
            if (v instanceof CompletedExceptionally) {
                if (!((CompletedExceptionally)state).makeHandled()) {
                    this.multipleHandlersError(handler, state);
                }
                if (state instanceof CancelledContinuation) {
                    Throwable cause;
                    CompletedExceptionally completedExceptionally = state instanceof CompletedExceptionally ? (CompletedExceptionally)state : null;
                    Throwable throwable = cause = completedExceptionally != null ? completedExceptionally.cause : null;
                    if (handler instanceof CancelHandler) {
                        this.callCancelHandler((CancelHandler)handler, cause);
                    } else {
                        Intrinsics.checkNotNull((Object)handler, (String)"null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        Segment segment = (Segment)handler;
                        this.callSegmentOnCancellation(segment, cause);
                    }
                }
                return;
            }
            if (v instanceof CompletedContinuation) {
                if (((CompletedContinuation)state).cancelHandler != null) {
                    this.multipleHandlersError(handler, state);
                }
                if (handler instanceof Segment) {
                    return;
                }
                Intrinsics.checkNotNull((Object)handler, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                CancelHandler cfr_ignored_0 = (CancelHandler)handler;
                if (((CompletedContinuation)state).getCancelled()) {
                    this.callCancelHandler((CancelHandler)handler, ((CompletedContinuation)state).cancelCause);
                    return;
                }
                update = CompletedContinuation.copy$default((CompletedContinuation)state, null, (CancelHandler)handler, null, null, null, 29, null);
                if (!_state$FU.compareAndSet(this, state, update)) continue;
                return;
            }
            if (handler instanceof Segment) {
                return;
            }
            Intrinsics.checkNotNull((Object)handler, (String)"null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
            CancelHandler cfr_ignored_1 = (CancelHandler)handler;
            update = new CompletedContinuation(state, (CancelHandler)handler, null, null, null, 28, null);
            if (_state$FU.compareAndSet(this, state, update)) break;
        }
    }

    private final void multipleHandlersError(Object handler, Object state) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + handler + ", already has " + state).toString());
    }

    private final CancelHandler makeCancelHandler(Function1<? super Throwable, Unit> handler) {
        return handler instanceof CancelHandler ? (CancelHandler)handler : (CancelHandler)new InvokeOnCancel(handler);
    }

    private final void dispatchResume(int mode) {
        if (this.tryResume()) {
            return;
        }
        DispatchedTaskKt.dispatch(this, mode);
    }

    private final Object resumedState(NotCompleted state, Object proposedUpdate, int resumeMode, Function1<? super Throwable, Unit> onCancellation, Object idempotent) {
        Object object;
        if (proposedUpdate instanceof CompletedExceptionally) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl = false;
                if (!(idempotent == null)) {
                    throw new AssertionError();
                }
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                boolean bl = false;
                if (!(onCancellation == null)) {
                    throw new AssertionError();
                }
            }
            object = proposedUpdate;
        } else {
            object = !DispatchedTaskKt.isCancellableMode(resumeMode) && idempotent == null ? proposedUpdate : (onCancellation != null || state instanceof CancelHandler || idempotent != null ? new CompletedContinuation(proposedUpdate, state instanceof CancelHandler ? (CancelHandler)state : null, onCancellation, idempotent, null, 16, null) : proposedUpdate);
        }
        return object;
    }

    private final void resumeImpl(Object proposedUpdate, int resumeMode, Function1<? super Throwable, Unit> onCancellation) {
        Object v;
        Object state;
        block3: {
            Object update;
            CancellableContinuationImpl cancellableContinuationImpl = this;
            AtomicReferenceFieldUpdater atomicfu$handler$iv = _state$FU;
            boolean $i$f$loop$atomicfu = false;
            do {
                state = atomicfu$handler$iv.get(this);
                boolean bl = false;
                v = state;
                if (!(v instanceof NotCompleted)) break block3;
            } while (!_state$FU.compareAndSet(this, state, update = this.resumedState((NotCompleted)state, proposedUpdate, resumeMode, onCancellation, null)));
            this.detachChildIfNonResuable();
            this.dispatchResume(resumeMode);
            return;
        }
        if (v instanceof CancelledContinuation && ((CancelledContinuation)state).makeResumed()) {
            Function1<? super Throwable, Unit> function1 = onCancellation;
            if (function1 != null) {
                Function1<? super Throwable, Unit> it = function1;
                boolean bl = false;
                this.callOnCancellation(it, ((CancelledContinuation)state).cause);
            }
            return;
        }
        this.alreadyResumedError(proposedUpdate);
        throw new KotlinNothingValueException();
    }

    static /* synthetic */ void resumeImpl$default(CancellableContinuationImpl cancellableContinuationImpl, Object object, int n2, Function1 function1, int n3, Object object2) {
        if (object2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((n3 & 4) != 0) {
            function1 = null;
        }
        cancellableContinuationImpl.resumeImpl(object, n2, (Function1<Throwable, Unit>)function1);
    }

    private final Symbol tryResumeImpl(Object proposedUpdate, Object idempotent, Function1<? super Throwable, Unit> onCancellation) {
        Object v;
        Object state;
        block6: {
            Object update;
            CancellableContinuationImpl cancellableContinuationImpl = this;
            AtomicReferenceFieldUpdater atomicfu$handler$iv = _state$FU;
            boolean $i$f$loop$atomicfu = false;
            do {
                state = atomicfu$handler$iv.get(this);
                boolean bl = false;
                v = state;
                if (!(v instanceof NotCompleted)) break block6;
            } while (!_state$FU.compareAndSet(this, state, update = this.resumedState((NotCompleted)state, proposedUpdate, this.resumeMode, onCancellation, idempotent)));
            this.detachChildIfNonResuable();
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }
        if (v instanceof CompletedContinuation) {
            Symbol symbol;
            if (idempotent != null && ((CompletedContinuation)state).idempotentResume == idempotent) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    boolean bl = false;
                    if (!Intrinsics.areEqual((Object)((CompletedContinuation)state).result, (Object)proposedUpdate)) {
                        throw new AssertionError();
                    }
                }
                symbol = CancellableContinuationImplKt.RESUME_TOKEN;
            } else {
                symbol = null;
            }
            return symbol;
        }
        return null;
    }

    private final Void alreadyResumedError(Object proposedUpdate) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + proposedUpdate).toString());
    }

    private final void detachChildIfNonResuable() {
        if (!this.isReusable()) {
            this.detachChild$kotlinx_coroutines_core();
        }
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle disposableHandle = this.getParentHandle();
        if (disposableHandle == null) {
            return;
        }
        DisposableHandle handle = disposableHandle;
        handle.dispose();
        _parentHandle$FU.set(this, NonDisposableHandle.INSTANCE);
    }

    @Override
    @Nullable
    public Object tryResume(T value, @Nullable Object idempotent) {
        return this.tryResumeImpl(value, idempotent, null);
    }

    @Override
    @Nullable
    public Object tryResume(T value, @Nullable Object idempotent, @Nullable Function1<? super Throwable, Unit> onCancellation) {
        return this.tryResumeImpl(value, idempotent, onCancellation);
    }

    @Override
    @Nullable
    public Object tryResumeWithException(@NotNull Throwable exception) {
        return this.tryResumeImpl(new CompletedExceptionally(exception, false, 2, null), null, null);
    }

    @Override
    public void completeResume(@NotNull Object token2) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(token2 == CancellableContinuationImplKt.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        this.dispatchResume(this.resumeMode);
    }

    @Override
    public void resumeUndispatched(@NotNull CoroutineDispatcher $this$resumeUndispatched, T value) {
        DispatchedContinuation dc;
        Continuation<T> continuation = this.delegate;
        DispatchedContinuation dispatchedContinuation = dc = continuation instanceof DispatchedContinuation ? (DispatchedContinuation)continuation : null;
        CancellableContinuationImpl.resumeImpl$default(this, value, (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == $this$resumeUndispatched ? 4 : this.resumeMode, null, 4, null);
    }

    @Override
    public void resumeUndispatchedWithException(@NotNull CoroutineDispatcher $this$resumeUndispatchedWithException, @NotNull Throwable exception) {
        Continuation<T> continuation = this.delegate;
        DispatchedContinuation dc = continuation instanceof DispatchedContinuation ? (DispatchedContinuation)continuation : null;
        DispatchedContinuation dispatchedContinuation = dc;
        CancellableContinuationImpl.resumeImpl$default(this, new CompletedExceptionally(exception, false, 2, null), (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == $this$resumeUndispatchedWithException ? 4 : this.resumeMode, null, 4, null);
    }

    @Override
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object state) {
        return (T)(state instanceof CompletedContinuation ? ((CompletedContinuation)state).result : state);
    }

    @Override
    @Nullable
    public Throwable getExceptionalResult$kotlinx_coroutines_core(@Nullable Object state) {
        Throwable throwable;
        Throwable throwable2 = super.getExceptionalResult$kotlinx_coroutines_core(state);
        if (throwable2 != null) {
            Throwable it = throwable2;
            boolean bl = false;
            Continuation<T> continuation$iv = this.delegate;
            boolean $i$f$recoverStackTrace = false;
            throwable = !DebugKt.getRECOVER_STACK_TRACES() || !(continuation$iv instanceof CoroutineStackFrame) ? it : StackTraceRecoveryKt.access$recoverFromStackFrame(it, (CoroutineStackFrame)continuation$iv);
        } else {
            throwable = null;
        }
        return throwable;
    }

    @NotNull
    public String toString() {
        return this.nameString() + '(' + DebugStringsKt.toDebugString(this.delegate) + "){" + this.getStateDebugRepresentation() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    @NotNull
    protected String nameString() {
        return "CancellableContinuation";
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicfu$handler, Function1<Object, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            atomicfu$action.invoke(atomicfu$handler.get(atomicfu$dispatchReceiver));
        }
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater atomicfu$handler, Function1<? super Integer, Unit> atomicfu$action, Object atomicfu$dispatchReceiver) {
        boolean $i$f$loop$atomicfu = false;
        while (true) {
            int n2 = atomicfu$handler.get(atomicfu$dispatchReceiver);
            atomicfu$action.invoke((Object)n2);
        }
    }

    private final void update$atomicfu(AtomicIntegerFieldUpdater atomicfu$handler, Function1<? super Integer, Integer> atomicfu$action, Object atomicfu$dispatchReceiver) {
        Object object;
        int n2;
        boolean $i$f$update$atomicfu = false;
        while (!atomicfu$handler.compareAndSet(atomicfu$dispatchReceiver, n2 = atomicfu$handler.get(atomicfu$dispatchReceiver), ((Number)(object = atomicfu$action.invoke((Object)n2))).intValue())) {
        }
    }
}


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
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 */
package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFrames;
import _COROUTINE.CoroutineDebuggingKt;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ExceptionsConstructorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000`\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u001a;\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0004H\u0002\u00a2\u0006\u0004\b\b\u0010\t\u001a%\u0010\r\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00042\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000e\u001a3\u0010\u0012\u001a\u00020\u00112\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u000f2\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0004H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a\u001b\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0000H\u0080H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u0018\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0014\u001a\u00028\u00002\n\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a!\u0010\u001a\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a.\u0010\u001a\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0014\u001a\u00028\u00002\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0080\b\u00a2\u0006\u0004\b\u001a\u0010\u001d\u001a\"\u0010\u001e\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0081\b\u00a2\u0006\u0004\b\u001e\u0010\u001b\u001a!\u0010\u001f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0001\u00a2\u0006\u0004\b\u001f\u0010\u001b\u001a3\u0010!\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u000f0 \"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u0000H\u0002\u00a2\u0006\u0004\b!\u0010\"\u001a#\u0010%\u001a\u00020$*\u00060\u0005j\u0002`\u00062\n\u0010#\u001a\u00060\u0005j\u0002`\u0006H\u0002\u00a2\u0006\u0004\b%\u0010&\u001a%\u0010*\u001a\u00020)*\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u000f2\u0006\u0010(\u001a\u00020'H\u0002\u00a2\u0006\u0004\b*\u0010+\u001a\u001b\u0010,\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000\u00a2\u0006\u0004\b,\u0010-\u001a\u0017\u0010.\u001a\u00020$*\u00060\u0005j\u0002`\u0006H\u0000\u00a2\u0006\u0004\b.\u0010/\u001a\u001d\u00100\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u0000H\u0002\u00a2\u0006\u0004\b0\u0010\u001b\"\u0014\u00101\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\"\u0014\u00103\u001a\u00020'8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b3\u00104\"\u001c\u00106\u001a\n 5*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00104\"\u0014\u00107\u001a\u00020'8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b7\u00104\"\u001c\u00108\u001a\n 5*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00104*\f\b\u0000\u00109\"\u00020\n2\u00020\n*\f\b\u0000\u0010:\"\u00020\u00052\u00020\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006;"}, d2={"", "E", "cause", "result", "Ljava/util/ArrayDeque;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "resultStackTrace", "createFinalException", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "continuation", "createStackTrace", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/util/ArrayDeque;", "", "recoveredStacktrace", "", "mergeRecoveredTraces", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "exception", "", "recoverAndThrow", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "unwrap", "unwrapImpl", "Lkotlin/Pair;", "causeAndStacktrace", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "e", "", "elementWiseEquals", "(Ljava/lang/StackTraceElement;Ljava/lang/StackTraceElement;)Z", "", "methodName", "", "firstFrameIndex", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "isArtificial", "(Ljava/lang/StackTraceElement;)Z", "sanitizeStackTrace", "ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "baseContinuationImplClass", "Ljava/lang/String;", "kotlin.jvm.PlatformType", "baseContinuationImplClassName", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nStackTraceRecovery.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,216:1\n1735#2,6:217\n12744#2,2:225\n1627#2,6:229\n12744#2,2:235\n1627#2,6:238\n37#3,2:223\n26#4:227\n26#4:228\n1#5:237\n*S KotlinDebug\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n43#1:217,6\n131#1:225,2\n141#1:229,6\n173#1:235,2\n194#1:238,6\n106#1:223,2\n133#1:227\n135#1:228\n*E\n"})
public final class StackTraceRecoveryKt {
    @NotNull
    private static final String baseContinuationImplClass = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    @NotNull
    private static final String stackTraceRecoveryClass = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    @NotNull
    private static final StackTraceElement ARTIFICIAL_FRAME;
    private static final String baseContinuationImplClassName;
    private static final String stackTraceRecoveryClassName;

    @NotNull
    public static final <E extends Throwable> E recoverStackTrace(@NotNull E exception) {
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            return exception;
        }
        E e2 = ExceptionsConstructorKt.tryCopyException(exception);
        if (e2 == null) {
            return exception;
        }
        E copy = e2;
        return StackTraceRecoveryKt.sanitizeStackTrace(copy);
    }

    private static final <E extends Throwable> E sanitizeStackTrace(E $this$sanitizeStackTrace) {
        int n2;
        int size;
        StackTraceElement[] stackTrace;
        block3: {
            stackTrace = $this$sanitizeStackTrace.getStackTrace();
            size = stackTrace.length;
            StackTraceElement[] $this$indexOfLast$iv = stackTrace;
            boolean $i$f$indexOfLast = false;
            int n3 = $this$indexOfLast$iv.length + -1;
            if (0 <= n3) {
                do {
                    int index$iv = n3--;
                    StackTraceElement it = $this$indexOfLast$iv[index$iv];
                    boolean bl = false;
                    if (!Intrinsics.areEqual((Object)stackTraceRecoveryClassName, (Object)it.getClassName())) continue;
                    n2 = index$iv;
                    break block3;
                } while (0 <= n3);
            }
            n2 = -1;
        }
        int lastIntrinsic = n2;
        int startIndex = lastIntrinsic + 1;
        int endIndex = StackTraceRecoveryKt.firstFrameIndex(stackTrace, baseContinuationImplClassName);
        int adjustment = endIndex == -1 ? 0 : size - endIndex;
        int n4 = size - lastIntrinsic - adjustment;
        StackTraceElement[] stackTraceElementArray = new StackTraceElement[n4];
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2;
            stackTraceElementArray[n5] = n5 == 0 ? ARTIFICIAL_FRAME : stackTrace[startIndex + n5 - 1];
        }
        StackTraceElement[] trace = stackTraceElementArray;
        $this$sanitizeStackTrace.setStackTrace(trace);
        return $this$sanitizeStackTrace;
    }

    @NotNull
    public static final <E extends Throwable> E recoverStackTrace(@NotNull E exception, @NotNull Continuation<?> continuation) {
        boolean $i$f$recoverStackTrace = false;
        if (!DebugKt.getRECOVER_STACK_TRACES() || !(continuation instanceof CoroutineStackFrame)) {
            return exception;
        }
        return (E)StackTraceRecoveryKt.recoverFromStackFrame(exception, (CoroutineStackFrame)continuation);
    }

    private static final <E extends Throwable> E recoverFromStackFrame(E exception, CoroutineStackFrame continuation) {
        Pair<E, StackTraceElement[]> pair = StackTraceRecoveryKt.causeAndStacktrace(exception);
        Throwable cause = (Throwable)pair.component1();
        StackTraceElement[] recoveredStacktrace = (StackTraceElement[])pair.component2();
        Throwable throwable = ExceptionsConstructorKt.tryCopyException(cause);
        if (throwable == null) {
            return exception;
        }
        Throwable newException = throwable;
        ArrayDeque<StackTraceElement> stacktrace = StackTraceRecoveryKt.createStackTrace(continuation);
        if (stacktrace.isEmpty()) {
            return exception;
        }
        if (cause != exception) {
            StackTraceRecoveryKt.mergeRecoveredTraces(recoveredStacktrace, stacktrace);
        }
        return (E)StackTraceRecoveryKt.createFinalException(cause, newException, stacktrace);
    }

    private static final <E extends Throwable> E createFinalException(E cause, E result2, ArrayDeque<StackTraceElement> resultStackTrace) {
        resultStackTrace.addFirst(ARTIFICIAL_FRAME);
        StackTraceElement[] causeTrace = cause.getStackTrace();
        int size = StackTraceRecoveryKt.firstFrameIndex(causeTrace, baseContinuationImplClassName);
        if (size == -1) {
            Collection $this$toTypedArray$iv = resultStackTrace;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            result2.setStackTrace(thisCollection$iv.toArray(new StackTraceElement[0]));
            return result2;
        }
        StackTraceElement[] mergedStackTrace = new StackTraceElement[resultStackTrace.size() + size];
        for (int i2 = 0; i2 < size; ++i2) {
            mergedStackTrace[i2] = causeTrace[i2];
        }
        Iterator<StackTraceElement> iterator2 = resultStackTrace.iterator();
        int n2 = 0;
        while (iterator2.hasNext()) {
            StackTraceElement element;
            int index = n2++;
            mergedStackTrace[size + index] = element = iterator2.next();
        }
        result2.setStackTrace(mergedStackTrace);
        return result2;
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> causeAndStacktrace(E $this$causeAndStacktrace) {
        Pair pair;
        Throwable cause = $this$causeAndStacktrace.getCause();
        if (cause != null && Intrinsics.areEqual(cause.getClass(), $this$causeAndStacktrace.getClass())) {
            boolean bl;
            StackTraceElement[] currentTrace;
            block5: {
                StackTraceElement[] $this$any$iv = currentTrace = $this$causeAndStacktrace.getStackTrace();
                boolean $i$f$any = false;
                int n2 = $this$any$iv.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    StackTraceElement element$iv;
                    StackTraceElement it = element$iv = $this$any$iv[i2];
                    boolean bl2 = false;
                    if (!StackTraceRecoveryKt.isArtificial(it)) continue;
                    bl = true;
                    break block5;
                }
                bl = false;
            }
            if (bl) {
                pair = TuplesKt.to((Object)cause, (Object)currentTrace);
            } else {
                boolean $i$f$emptyArray = false;
                pair = TuplesKt.to($this$causeAndStacktrace, (Object)new StackTraceElement[0]);
            }
        } else {
            boolean $i$f$emptyArray = false;
            pair = TuplesKt.to($this$causeAndStacktrace, (Object)new StackTraceElement[0]);
        }
        return pair;
    }

    private static final void mergeRecoveredTraces(StackTraceElement[] recoveredStacktrace, ArrayDeque<StackTraceElement> result2) {
        int lastFrameIndex;
        int n2;
        block4: {
            StackTraceElement[] $this$indexOfFirst$iv = recoveredStacktrace;
            boolean $i$f$indexOfFirst = false;
            int n3 = $this$indexOfFirst$iv.length;
            for (int index$iv = 0; index$iv < n3; ++index$iv) {
                StackTraceElement it = $this$indexOfFirst$iv[index$iv];
                boolean bl = false;
                if (!StackTraceRecoveryKt.isArtificial(it)) continue;
                n2 = index$iv;
                break block4;
            }
            n2 = -1;
        }
        int startIndex = n2 + 1;
        int i2 = lastFrameIndex = recoveredStacktrace.length - 1;
        if (startIndex <= i2) {
            while (true) {
                StackTraceElement element;
                if (StackTraceRecoveryKt.elementWiseEquals(element = recoveredStacktrace[i2], result2.getLast())) {
                    result2.removeLast();
                }
                result2.addFirst(recoveredStacktrace[i2]);
                if (i2 == startIndex) break;
                --i2;
            }
        }
    }

    @Nullable
    public static final Object recoverAndThrow(@NotNull Throwable exception, @NotNull Continuation<?> $completion) {
        boolean $i$f$recoverAndThrow = false;
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            throw exception;
        }
        Continuation<?> it = $completion;
        boolean bl = false;
        if (!(it instanceof CoroutineStackFrame)) {
            throw exception;
        }
        throw StackTraceRecoveryKt.recoverFromStackFrame(exception, (CoroutineStackFrame)it);
    }

    private static final Object recoverAndThrow$$forInline(Throwable exception, Continuation<?> $completion) {
        boolean $i$f$recoverAndThrow = false;
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            throw exception;
        }
        InlineMarker.mark((int)0);
        Continuation<?> it = $completion;
        boolean bl = false;
        if (!(it instanceof CoroutineStackFrame)) {
            throw exception;
        }
        throw StackTraceRecoveryKt.recoverFromStackFrame(exception, (CoroutineStackFrame)it);
    }

    @PublishedApi
    @NotNull
    public static final <E extends Throwable> E unwrap(@NotNull E exception) {
        boolean $i$f$unwrap = false;
        return !DebugKt.getRECOVER_STACK_TRACES() ? exception : StackTraceRecoveryKt.unwrapImpl(exception);
    }

    @PublishedApi
    @NotNull
    public static final <E extends Throwable> E unwrapImpl(@NotNull E exception) {
        boolean bl;
        Throwable cause;
        block3: {
            cause = exception.getCause();
            if (cause == null || !Intrinsics.areEqual(cause.getClass(), exception.getClass())) {
                return exception;
            }
            StackTraceElement[] $this$any$iv = exception.getStackTrace();
            boolean $i$f$any = false;
            int n2 = $this$any$iv.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                StackTraceElement element$iv;
                StackTraceElement it = element$iv = $this$any$iv[i2];
                boolean bl2 = false;
                if (!StackTraceRecoveryKt.isArtificial(it)) continue;
                bl = true;
                break block3;
            }
            bl = false;
        }
        if (bl) {
            return (E)cause;
        }
        return exception;
    }

    private static final ArrayDeque<StackTraceElement> createStackTrace(CoroutineStackFrame continuation) {
        CoroutineStackFrame coroutineStackFrame;
        CoroutineStackFrame coroutineStackFrame2;
        ArrayDeque<StackTraceElement> stack = new ArrayDeque<StackTraceElement>();
        StackTraceElement stackTraceElement = continuation.getStackTraceElement();
        if (stackTraceElement != null) {
            StackTraceElement it = stackTraceElement;
            boolean bl = false;
            stack.add(it);
        }
        CoroutineStackFrame last2 = continuation;
        while ((coroutineStackFrame2 = (coroutineStackFrame = last2) instanceof CoroutineStackFrame ? coroutineStackFrame : null) != null && (coroutineStackFrame2 = coroutineStackFrame2.getCallerFrame()) != null) {
            StackTraceElement it;
            last2 = coroutineStackFrame2;
            if (last2.getStackTraceElement() == null) continue;
            boolean bl = false;
            stack.add(it);
        }
        return stack;
    }

    public static final boolean isArtificial(@NotNull StackTraceElement $this$isArtificial) {
        return StringsKt.startsWith$default((String)$this$isArtificial.getClassName(), (String)CoroutineDebuggingKt.getARTIFICIAL_FRAME_PACKAGE_NAME(), (boolean)false, (int)2, null);
    }

    private static final int firstFrameIndex(StackTraceElement[] $this$firstFrameIndex, String methodName) {
        int n2;
        block1: {
            StackTraceElement[] $this$indexOfFirst$iv = $this$firstFrameIndex;
            boolean $i$f$indexOfFirst = false;
            int n3 = $this$indexOfFirst$iv.length;
            for (int index$iv = 0; index$iv < n3; ++index$iv) {
                StackTraceElement it = $this$indexOfFirst$iv[index$iv];
                boolean bl = false;
                if (!Intrinsics.areEqual((Object)methodName, (Object)it.getClassName())) continue;
                n2 = index$iv;
                break block1;
            }
            n2 = -1;
        }
        return n2;
    }

    private static final boolean elementWiseEquals(StackTraceElement $this$elementWiseEquals, StackTraceElement e2) {
        return $this$elementWiseEquals.getLineNumber() == e2.getLineNumber() && Intrinsics.areEqual((Object)$this$elementWiseEquals.getMethodName(), (Object)e2.getMethodName()) && Intrinsics.areEqual((Object)$this$elementWiseEquals.getFileName(), (Object)e2.getFileName()) && Intrinsics.areEqual((Object)$this$elementWiseEquals.getClassName(), (Object)e2.getClassName());
    }

    public static final void initCause(@NotNull Throwable $this$initCause, @NotNull Throwable cause) {
        $this$initCause.initCause(cause);
    }

    public static /* synthetic */ void CoroutineStackFrame$annotations() {
    }

    public static /* synthetic */ void StackTraceElement$annotations() {
    }

    static {
        Object object;
        Object object2;
        Object object3;
        Object $i$a$-runCatching-StackTraceRecoveryKt$baseContinuationImplClassName$22;
        ARTIFICIAL_FRAME = new ArtificialStackFrames().coroutineBoundary();
        try {
            boolean $i$a$-runCatching-StackTraceRecoveryKt$baseContinuationImplClassName$22 = false;
            $i$a$-runCatching-StackTraceRecoveryKt$baseContinuationImplClassName$22 = Result.constructor-impl((Object)Class.forName(baseContinuationImplClass).getCanonicalName());
        }
        catch (Throwable throwable) {
            $i$a$-runCatching-StackTraceRecoveryKt$baseContinuationImplClassName$22 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        Throwable throwable = Result.exceptionOrNull-impl((Object)$i$a$-runCatching-StackTraceRecoveryKt$baseContinuationImplClassName$22);
        if (throwable == null) {
            object3 = $i$a$-runCatching-StackTraceRecoveryKt$baseContinuationImplClassName$22;
        } else {
            Throwable it = throwable;
            boolean bl = false;
            object3 = baseContinuationImplClass;
        }
        baseContinuationImplClassName = (String)object3;
        try {
            boolean bl = false;
            object2 = Result.constructor-impl((Object)Class.forName(stackTraceRecoveryClass).getCanonicalName());
        }
        catch (Throwable it) {
            object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)it));
        }
        Throwable throwable2 = Result.exceptionOrNull-impl((Object)object2);
        if (throwable2 == null) {
            object = object2;
        } else {
            it = throwable2;
            boolean bl = false;
            object = stackTraceRecoveryClass;
        }
        stackTraceRecoveryClassName = (String)object;
    }
}


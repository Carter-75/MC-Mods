/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 */
package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.DownstreamExceptionContext;
import kotlinx.coroutines.flow.internal.NoOpContinuation;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.flow.internal.SafeCollectorKt;
import kotlinx.coroutines.flow.internal.SafeCollector_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u00032\u00020\u0004B\u001d\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\"\u001a\u00020\u0005\u00a2\u0006\u0004\b/\u00100J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ'\u0010\f\u001a\u0004\u0018\u00010\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\b\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\f\u0010\u0011J!\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u0010H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\u001b\u001a\u00020\u00102\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0019H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020\u00058\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010#\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00061"}, d2={"Lkotlinx/coroutines/flow/internal/SafeCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlin/coroutines/CoroutineContext;", "currentContext", "previousContext", "value", "", "checkContext", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "uCont", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionContext;", "exception", "exceptionTransparencyViolated", "(Lkotlinx/coroutines/flow/internal/DownstreamExceptionContext;Ljava/lang/Object;)V", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "()V", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "collectContext", "Lkotlin/coroutines/CoroutineContext;", "", "collectContextSize", "I", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "completion", "Lkotlin/coroutines/Continuation;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "lastEmissionContext", "<init>", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nSafeCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.kt\nkotlinx/coroutines/flow/internal/SafeCollector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,156:1\n1#2:157\n*E\n"})
public final class SafeCollector<T>
extends ContinuationImpl
implements FlowCollector<T>,
CoroutineStackFrame {
    @JvmField
    @NotNull
    public final FlowCollector<T> collector;
    @JvmField
    @NotNull
    public final CoroutineContext collectContext;
    @JvmField
    public final int collectContextSize;
    @Nullable
    private CoroutineContext lastEmissionContext;
    @Nullable
    private Continuation<? super Unit> completion;

    public SafeCollector(@NotNull FlowCollector<? super T> collector2, @NotNull CoroutineContext collectContext) {
        super((Continuation)NoOpContinuation.INSTANCE, (CoroutineContext)EmptyCoroutineContext.INSTANCE);
        this.collector = collector2;
        this.collectContext = collectContext;
        this.collectContextSize = ((Number)this.collectContext.fold((Object)0, (Function2)collectContextSize.1.INSTANCE)).intValue();
    }

    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<? super Unit> continuation = this.completion;
        return continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame)continuation : null;
    }

    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @NotNull
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext == null) {
            coroutineContext = (CoroutineContext)EmptyCoroutineContext.INSTANCE;
        }
        return coroutineContext;
    }

    @NotNull
    public Object invokeSuspend(@NotNull Object result2) {
        block1: {
            Object object = result2;
            Throwable throwable = Result.exceptionOrNull-impl((Object)object);
            if (throwable != null) {
                Throwable throwable2;
                Throwable it = throwable2 = throwable;
                boolean bl = false;
                this.lastEmissionContext = new DownstreamExceptionContext(it, this.getContext());
            }
            Continuation<? super Unit> continuation = this.completion;
            if (continuation == null) break block1;
            continuation.resumeWith(result2);
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public void releaseIntercepted() {
        super.releaseIntercepted();
    }

    @Override
    @Nullable
    public Object emit(T value, @NotNull Continuation<? super Unit> $completion) {
        Object object;
        Continuation<? super Unit> uCont = $completion;
        boolean bl = false;
        try {
            object = this.emit(uCont, value);
        }
        catch (Throwable e2) {
            this.lastEmissionContext = new DownstreamExceptionContext(e2, uCont.getContext());
            throw e2;
        }
        Object object2 = object;
        if (object2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (object2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object2;
        }
        return Unit.INSTANCE;
    }

    private final Object emit(Continuation<? super Unit> uCont, T value) {
        CoroutineContext currentContext = uCont.getContext();
        JobKt.ensureActive(currentContext);
        CoroutineContext previousContext = this.lastEmissionContext;
        if (previousContext != currentContext) {
            this.checkContext(currentContext, previousContext, value);
            this.lastEmissionContext = currentContext;
        }
        this.completion = uCont;
        Function3 function3 = SafeCollectorKt.access$getEmitFun$p();
        FlowCollector<T> flowCollector = this.collector;
        Intrinsics.checkNotNull(flowCollector, (String)"null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object result2 = function3.invoke(flowCollector, value, (Object)((Continuation)this));
        if (!Intrinsics.areEqual((Object)result2, (Object)IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
            this.completion = null;
        }
        return result2;
    }

    private final void checkContext(CoroutineContext currentContext, CoroutineContext previousContext, T value) {
        if (previousContext instanceof DownstreamExceptionContext) {
            this.exceptionTransparencyViolated((DownstreamExceptionContext)previousContext, value);
        }
        SafeCollector_commonKt.checkContext(this, currentContext);
    }

    private final void exceptionTransparencyViolated(DownstreamExceptionContext exception, Object value) {
        throw new IllegalStateException(StringsKt.trimIndent((String)("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + exception.e + ", but then emission attempt of value '" + value + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ")).toString());
    }
}


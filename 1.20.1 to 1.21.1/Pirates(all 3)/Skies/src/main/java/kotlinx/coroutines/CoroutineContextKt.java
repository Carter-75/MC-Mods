/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.ContinuationInterceptor
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.coroutines.EmptyCoroutineContext
 *  kotlin.coroutines.jvm.internal.CoroutineStackFrame
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Ref$ObjectRef
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CopyableThreadContextElement;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchedCoroutine;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.UndispatchedCoroutine;
import kotlinx.coroutines.UndispatchedMarker;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a'\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a:\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0080\b\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a6\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u0010\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0080\b\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0013\u001a\u00020\u0003*\u00020\u0000H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a\u001b\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a\u001b\u0010\u0016\u001a\u00020\u0000*\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0000H\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0019\u001a\u001a\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b*\u00020\u001aH\u0080\u0010\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a/\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0010\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0000\u00a2\u0006\u0004\b\u001f\u0010 \"\u0014\u0010\"\u001a\u00020!8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010#\"\u001a\u0010&\u001a\u0004\u0018\u00010!*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2={"Lkotlin/coroutines/CoroutineContext;", "originalContext", "appendContext", "", "isNewCoroutine", "foldCopies", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Z)Lkotlin/coroutines/CoroutineContext;", "T", "Lkotlin/coroutines/Continuation;", "continuation", "", "countOrElement", "Lkotlin/Function0;", "block", "withContinuationContext", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "context", "withCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hasCopyableElements", "(Lkotlin/coroutines/CoroutineContext;)Z", "addedContext", "newCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/UndispatchedCoroutine;", "undispatchedCompletion", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlinx/coroutines/UndispatchedCoroutine;", "oldValue", "updateUndispatchedCompletion", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)Lkotlinx/coroutines/UndispatchedCoroutine;", "", "DEBUG_THREAD_NAME_SEPARATOR", "Ljava/lang/String;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "coroutineName", "kotlinx-coroutines-core"})
public final class CoroutineContextKt {
    @NotNull
    private static final String DEBUG_THREAD_NAME_SEPARATOR = " @";

    @ExperimentalCoroutinesApi
    @NotNull
    public static final CoroutineContext newCoroutineContext(@NotNull CoroutineScope $this$newCoroutineContext, @NotNull CoroutineContext context) {
        CoroutineContext combined = CoroutineContextKt.foldCopies($this$newCoroutineContext.getCoroutineContext(), context, true);
        CoroutineContext debug = DebugKt.getDEBUG() ? combined.plus((CoroutineContext)new CoroutineId(DebugKt.getCOROUTINE_ID().incrementAndGet())) : combined;
        return combined != Dispatchers.getDefault() && combined.get((CoroutineContext.Key)ContinuationInterceptor.Key) == null ? debug.plus((CoroutineContext)Dispatchers.getDefault()) : debug;
    }

    @InternalCoroutinesApi
    @NotNull
    public static final CoroutineContext newCoroutineContext(@NotNull CoroutineContext $this$newCoroutineContext, @NotNull CoroutineContext addedContext) {
        if (!CoroutineContextKt.hasCopyableElements(addedContext)) {
            return $this$newCoroutineContext.plus(addedContext);
        }
        return CoroutineContextKt.foldCopies($this$newCoroutineContext, addedContext, false);
    }

    private static final boolean hasCopyableElements(CoroutineContext $this$hasCopyableElements) {
        return (Boolean)$this$hasCopyableElements.fold((Object)false, (Function2)hasCopyableElements.1.INSTANCE);
    }

    private static final CoroutineContext foldCopies(CoroutineContext originalContext, CoroutineContext appendContext, boolean isNewCoroutine) {
        boolean hasElementsLeft = CoroutineContextKt.hasCopyableElements(originalContext);
        boolean hasElementsRight = CoroutineContextKt.hasCopyableElements(appendContext);
        if (!hasElementsLeft && !hasElementsRight) {
            return originalContext.plus(appendContext);
        }
        Ref.ObjectRef leftoverContext = new Ref.ObjectRef();
        leftoverContext.element = appendContext;
        CoroutineContext folded2 = (CoroutineContext)originalContext.fold((Object)EmptyCoroutineContext.INSTANCE, (Function2)new Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext>((Ref.ObjectRef<CoroutineContext>)leftoverContext, isNewCoroutine){
            final /* synthetic */ Ref.ObjectRef<CoroutineContext> $leftoverContext;
            final /* synthetic */ boolean $isNewCoroutine;
            {
                this.$leftoverContext = $leftoverContext;
                this.$isNewCoroutine = $isNewCoroutine;
                super(2);
            }

            @NotNull
            public final CoroutineContext invoke(@NotNull CoroutineContext result2, @NotNull CoroutineContext.Element element) {
                if (!(element instanceof CopyableThreadContextElement)) {
                    return result2.plus((CoroutineContext)element);
                }
                CoroutineContext.Element newElement = ((CoroutineContext)this.$leftoverContext.element).get(element.getKey());
                if (newElement == null) {
                    return result2.plus((CoroutineContext)(this.$isNewCoroutine ? ((CopyableThreadContextElement)element).copyForChild() : (CopyableThreadContextElement<S>)element));
                }
                this.$leftoverContext.element = ((CoroutineContext)this.$leftoverContext.element).minusKey(element.getKey());
                return result2.plus(((CopyableThreadContextElement)element).mergeForChild(newElement));
            }
        });
        if (hasElementsRight) {
            leftoverContext.element = ((CoroutineContext)leftoverContext.element).fold((Object)EmptyCoroutineContext.INSTANCE, (Function2)foldCopies.1.INSTANCE);
        }
        return folded2.plus((CoroutineContext)leftoverContext.element);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final <T> T withCoroutineContext(@NotNull CoroutineContext context, @Nullable Object countOrElement, @NotNull Function0<? extends T> block) {
        boolean $i$f$withCoroutineContext = false;
        Object oldValue = ThreadContextKt.updateThreadContext(context, countOrElement);
        try {
            Object object = block.invoke();
            return (T)object;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            ThreadContextKt.restoreThreadContext(context, oldValue);
            InlineMarker.finallyEnd((int)1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final <T> T withContinuationContext(@NotNull Continuation<?> continuation, @Nullable Object countOrElement, @NotNull Function0<? extends T> block) {
        boolean $i$f$withContinuationContext = false;
        CoroutineContext context = continuation.getContext();
        Object oldValue = ThreadContextKt.updateThreadContext(context, countOrElement);
        UndispatchedCoroutine<?> undispatchedCompletion = oldValue != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation, context, oldValue) : null;
        try {
            Object object = block.invoke();
            return (T)object;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            if (undispatchedCompletion == null || undispatchedCompletion.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, oldValue);
            }
            InlineMarker.finallyEnd((int)1);
        }
    }

    @Nullable
    public static final UndispatchedCoroutine<?> updateUndispatchedCompletion(@NotNull Continuation<?> $this$updateUndispatchedCompletion, @NotNull CoroutineContext context, @Nullable Object oldValue) {
        UndispatchedCoroutine<?> completion;
        block2: {
            boolean potentiallyHasUndispatchedCoroutine;
            if (!($this$updateUndispatchedCompletion instanceof CoroutineStackFrame)) {
                return null;
            }
            boolean bl = potentiallyHasUndispatchedCoroutine = context.get((CoroutineContext.Key)UndispatchedMarker.INSTANCE) != null;
            if (!potentiallyHasUndispatchedCoroutine) {
                return null;
            }
            UndispatchedCoroutine<?> undispatchedCoroutine = completion = CoroutineContextKt.undispatchedCompletion((CoroutineStackFrame)$this$updateUndispatchedCompletion);
            if (undispatchedCoroutine == null) break block2;
            undispatchedCoroutine.saveThreadContext(context, oldValue);
        }
        return completion;
    }

    @Nullable
    public static final UndispatchedCoroutine<?> undispatchedCompletion(@NotNull CoroutineStackFrame $this$undispatchedCompletion) {
        while (!($this$undispatchedCompletion instanceof DispatchedCoroutine)) {
            CoroutineStackFrame completion;
            if ($this$undispatchedCompletion.getCallerFrame() == null) {
                return null;
            }
            if (completion instanceof UndispatchedCoroutine) {
                return (UndispatchedCoroutine)completion;
            }
            $this$undispatchedCompletion = completion;
        }
        return null;
    }

    @Nullable
    public static final String getCoroutineName(@NotNull CoroutineContext $this$coroutineName) {
        if (!DebugKt.getDEBUG()) {
            return null;
        }
        CoroutineId coroutineId = (CoroutineId)$this$coroutineName.get((CoroutineContext.Key)CoroutineId.Key);
        if (coroutineId == null) {
            return null;
        }
        CoroutineId coroutineId2 = coroutineId;
        Object object = (CoroutineName)$this$coroutineName.get((CoroutineContext.Key)CoroutineName.Key);
        if (object == null || (object = object.getName()) == null) {
            object = "coroutine";
        }
        Object coroutineName = object;
        return (String)coroutineName + '#' + coroutineId2.getId();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.ContinuationInterceptor
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.UndispatchedMarker;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R(\u0010\u0014\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2={"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "", "state", "", "afterResume", "(Ljava/lang/Object;)V", "", "clearThreadContext", "()Z", "Lkotlin/coroutines/CoroutineContext;", "context", "oldValue", "saveThreadContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "threadLocalIsSet", "Z", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", "threadStateToRecover", "Ljava/lang/ThreadLocal;", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nCoroutineContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,314:1\n1#2:315\n107#3,13:316\n*S KotlinDebug\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n*L\n269#1:316,13\n*E\n"})
public final class UndispatchedCoroutine<T>
extends ScopeCoroutine<T> {
    @NotNull
    private final ThreadLocal<Pair<CoroutineContext, Object>> threadStateToRecover = new ThreadLocal();
    private volatile boolean threadLocalIsSet;

    public UndispatchedCoroutine(@NotNull CoroutineContext context, @NotNull Continuation<? super T> uCont) {
        super(context.get((CoroutineContext.Key)UndispatchedMarker.INSTANCE) == null ? context.plus((CoroutineContext)UndispatchedMarker.INSTANCE) : context, uCont);
        if (!(uCont.getContext().get((CoroutineContext.Key)ContinuationInterceptor.Key) instanceof CoroutineDispatcher)) {
            Object values2 = ThreadContextKt.updateThreadContext(context, null);
            ThreadContextKt.restoreThreadContext(context, values2);
            this.saveThreadContext(context, values2);
        }
    }

    public final void saveThreadContext(@NotNull CoroutineContext context, @Nullable Object oldValue) {
        this.threadLocalIsSet = true;
        this.threadStateToRecover.set((Pair<CoroutineContext, Object>)TuplesKt.to((Object)context, (Object)oldValue));
    }

    public final boolean clearThreadContext() {
        boolean bl;
        boolean it = bl = this.threadLocalIsSet && this.threadStateToRecover.get() == null;
        boolean bl2 = false;
        this.threadStateToRecover.remove();
        return !bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    @Override
    protected void afterResume(@Nullable Object state) {
        void continuation$iv;
        if (this.threadLocalIsSet) {
            Pair<CoroutineContext, Object> pair = this.threadStateToRecover.get();
            if (pair != null) {
                Pair<CoroutineContext, Object> pair2 = pair;
                boolean bl = false;
                CoroutineContext ctx = (CoroutineContext)pair2.component1();
                Object value = pair2.component2();
                ThreadContextKt.restoreThreadContext(ctx, value);
            }
            this.threadStateToRecover.remove();
        }
        Object result2 = CompletionStateKt.recoverResult(state, this.uCont);
        Continuation continuation = this.uCont;
        Object countOrElement$iv = null;
        boolean $i$f$withContinuationContext = false;
        CoroutineContext context$iv = continuation$iv.getContext();
        Object oldValue$iv = ThreadContextKt.updateThreadContext(context$iv, countOrElement$iv);
        UndispatchedCoroutine<?> undispatchedCompletion$iv = oldValue$iv != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation$iv, context$iv, oldValue$iv) : null;
        try {
            boolean bl = false;
            this.uCont.resumeWith(result2);
            Unit unit = Unit.INSTANCE;
        }
        finally {
            if (undispatchedCompletion$iv == null || undispatchedCompletion$iv.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context$iv, oldValue$iv);
            }
        }
    }
}


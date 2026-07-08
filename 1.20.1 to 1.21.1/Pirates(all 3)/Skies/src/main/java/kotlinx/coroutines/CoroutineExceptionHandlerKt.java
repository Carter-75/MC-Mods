/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.CoroutineExceptionHandlerImpl_commonKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a,\u0010\u0006\u001a\u00020\u00052\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\u0086\b\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "CoroutineExceptionHandler", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/CoroutineExceptionHandler;", "context", "exception", "handleCoroutineException", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "originalException", "thrownException", "handlerException", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n+ 2 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,110:1\n75#2:111\n*S KotlinDebug\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n38#1:111\n*E\n"})
public final class CoroutineExceptionHandlerKt {
    @InternalCoroutinesApi
    public static final void handleCoroutineException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler)context.get((CoroutineContext.Key)CoroutineExceptionHandler.Key);
            if (coroutineExceptionHandler != null) {
                CoroutineExceptionHandler it = coroutineExceptionHandler;
                boolean bl = false;
                it.handleException(context, exception);
                return;
            }
        }
        catch (Throwable t) {
            CoroutineExceptionHandlerImpl_commonKt.handleUncaughtCoroutineException(context, CoroutineExceptionHandlerKt.handlerException(exception, t));
            return;
        }
        CoroutineExceptionHandlerImpl_commonKt.handleUncaughtCoroutineException(context, exception);
    }

    @NotNull
    public static final Throwable handlerException(@NotNull Throwable originalException, @NotNull Throwable thrownException) {
        RuntimeException runtimeException;
        if (originalException == thrownException) {
            return originalException;
        }
        RuntimeException $this$handlerException_u24lambda_u241 = runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", thrownException);
        boolean bl = false;
        Throwable $this$addSuppressedThrowable$iv = $this$handlerException_u24lambda_u241;
        boolean $i$f$addSuppressedThrowable = false;
        ExceptionsKt.addSuppressed((Throwable)$this$addSuppressedThrowable$iv, (Throwable)originalException);
        return runtimeException;
    }

    @NotNull
    public static final CoroutineExceptionHandler CoroutineExceptionHandler(@NotNull Function2<? super CoroutineContext, ? super Throwable, Unit> handler) {
        boolean $i$f$CoroutineExceptionHandler = false;
        CoroutineExceptionHandler.Key key = CoroutineExceptionHandler.Key;
        return new CoroutineExceptionHandler(handler, key){
            final /* synthetic */ Function2<CoroutineContext, Throwable, Unit> $handler;
            {
                this.$handler = $handler;
                super((CoroutineContext.Key)$super_call_param$1);
            }

            public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
                this.$handler.invoke((Object)context, (Object)exception);
            }
        };
    }
}


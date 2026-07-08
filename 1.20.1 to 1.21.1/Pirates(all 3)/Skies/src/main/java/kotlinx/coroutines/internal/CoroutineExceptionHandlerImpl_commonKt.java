/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 */
package kotlinx.coroutines.internal;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.internal.CoroutineExceptionHandlerImplKt;
import kotlinx.coroutines.internal.DiagnosticCoroutineContextException;
import kotlinx.coroutines.internal.ExceptionSuccessfullyProcessed;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleUncaughtCoroutineException", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"})
public final class CoroutineExceptionHandlerImpl_commonKt {
    public static final void handleUncaughtCoroutineException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        for (CoroutineExceptionHandler handler : CoroutineExceptionHandlerImplKt.getPlatformExceptionHandlers()) {
            try {
                handler.handleException(context, exception);
            }
            catch (ExceptionSuccessfullyProcessed _) {
                return;
            }
            catch (Throwable t) {
                CoroutineExceptionHandlerImplKt.propagateExceptionFinalResort(CoroutineExceptionHandlerKt.handlerException(exception, t));
            }
        }
        try {
            ExceptionsKt.addSuppressed((Throwable)exception, (Throwable)new DiagnosticCoroutineContextException(context));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        CoroutineExceptionHandlerImplKt.propagateExceptionFinalResort(exception);
    }
}


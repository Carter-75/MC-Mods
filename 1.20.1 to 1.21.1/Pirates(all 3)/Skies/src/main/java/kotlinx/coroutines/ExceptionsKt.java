/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a%\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0080\b\u00a2\u0006\u0004\b\n\u0010\u000b*\n\u0010\u0006\"\u00020\u00042\u00020\u0004\u00a8\u0006\f"}, d2={"", "message", "", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "CancellationException", "(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/util/concurrent/CancellationException;", "other", "", "addSuppressedThrowable", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nExceptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,76:1\n1#2:77\n*E\n"})
public final class ExceptionsKt {
    @NotNull
    public static final CancellationException CancellationException(@Nullable String message, @Nullable Throwable cause) {
        CancellationException cancellationException;
        CancellationException $this$CancellationException_u24lambda_u240 = cancellationException = new CancellationException(message);
        boolean bl = false;
        $this$CancellationException_u24lambda_u240.initCause(cause);
        return cancellationException;
    }

    public static final void addSuppressedThrowable(@NotNull Throwable $this$addSuppressedThrowable, @NotNull Throwable other) {
        boolean $i$f$addSuppressedThrowable = false;
        kotlin.ExceptionsKt.addSuppressed((Throwable)$this$addSuppressedThrowable, (Throwable)other);
    }
}


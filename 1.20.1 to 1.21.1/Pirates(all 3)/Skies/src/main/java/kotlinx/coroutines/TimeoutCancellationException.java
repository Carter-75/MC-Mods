/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CopyableThrowable;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0011\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0000\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u000b\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "createCopy", "()Lkotlinx/coroutines/TimeoutCancellationException;", "Lkotlinx/coroutines/Job;", "coroutine", "Lkotlinx/coroutines/Job;", "", "message", "<init>", "(Ljava/lang/String;)V", "(Ljava/lang/String;Lkotlinx/coroutines/Job;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timeout.kt\nkotlinx/coroutines/TimeoutCancellationException\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,193:1\n1#2:194\n*E\n"})
public final class TimeoutCancellationException
extends CancellationException
implements CopyableThrowable<TimeoutCancellationException> {
    @JvmField
    @Nullable
    public final transient Job coroutine;

    public TimeoutCancellationException(@NotNull String message, @Nullable Job coroutine) {
        super(message);
        this.coroutine = coroutine;
    }

    public TimeoutCancellationException(@NotNull String message) {
        this(message, (Job)null);
    }

    @Override
    @NotNull
    public TimeoutCancellationException createCopy() {
        TimeoutCancellationException timeoutCancellationException;
        String string = this.getMessage();
        if (string == null) {
            string = "";
        }
        TimeoutCancellationException it = timeoutCancellationException = new TimeoutCancellationException(string, this.coroutine);
        boolean bl = false;
        it.initCause(this);
        return timeoutCancellationException;
    }
}


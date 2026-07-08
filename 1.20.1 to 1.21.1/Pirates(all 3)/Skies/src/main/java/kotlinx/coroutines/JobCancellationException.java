/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CopyableThrowable;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B!\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2={"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "createCopy", "()Lkotlinx/coroutines/JobCancellationException;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "fillInStackTrace", "()Ljava/lang/Throwable;", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/Job;", "message", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nExceptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Exceptions.kt\nkotlinx/coroutines/JobCancellationException\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,76:1\n26#2:77\n*S KotlinDebug\n*F\n+ 1 Exceptions.kt\nkotlinx/coroutines/JobCancellationException\n*L\n44#1:77\n*E\n"})
public final class JobCancellationException
extends CancellationException
implements CopyableThrowable<JobCancellationException> {
    @JvmField
    @NotNull
    public final transient Job job;

    public JobCancellationException(@NotNull String message, @Nullable Throwable cause, @NotNull Job job) {
        super(message);
        this.job = job;
        if (cause != null) {
            this.initCause(cause);
        }
    }

    @Override
    @NotNull
    public Throwable fillInStackTrace() {
        if (DebugKt.getDEBUG()) {
            return super.fillInStackTrace();
        }
        boolean $i$f$emptyArray = false;
        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override
    @Nullable
    public JobCancellationException createCopy() {
        if (DebugKt.getDEBUG()) {
            String string = this.getMessage();
            Intrinsics.checkNotNull((Object)string);
            return new JobCancellationException(string, this, this.job);
        }
        return null;
    }

    @Override
    @NotNull
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }

    public boolean equals(@Nullable Object other) {
        return other == this || other instanceof JobCancellationException && Intrinsics.areEqual((Object)((JobCancellationException)other).getMessage(), (Object)this.getMessage()) && Intrinsics.areEqual((Object)((JobCancellationException)other).job, (Object)this.job) && Intrinsics.areEqual((Object)((JobCancellationException)other).getCause(), (Object)this.getCause());
    }

    public int hashCode() {
        String string = this.getMessage();
        Intrinsics.checkNotNull((Object)string);
        Throwable throwable = this.getCause();
        return (string.hashCode() * 31 + this.job.hashCode()) * 31 + (throwable != null ? throwable.hashCode() : 0);
    }
}


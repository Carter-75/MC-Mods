/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/Job;", "", "complete", "()Z", "", "exception", "completeExceptionally", "(Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"})
public interface CompletableJob
extends Job {
    public boolean complete();

    public boolean completeExceptionally(@NotNull Throwable var1);

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
        public static /* synthetic */ void cancel(CompletableJob $this) {
            Job.DefaultImpls.cancel($this);
        }

        @Deprecated(message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.", level=DeprecationLevel.ERROR)
        @NotNull
        public static Job plus(@NotNull CompletableJob $this, @NotNull Job other) {
            return Job.DefaultImpls.plus((Job)$this, other);
        }

        @NotNull
        public static CoroutineContext plus(@NotNull CompletableJob $this, @NotNull CoroutineContext context) {
            return Job.DefaultImpls.plus((Job)$this, context);
        }

        public static <R> R fold(@NotNull CompletableJob $this, R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return Job.DefaultImpls.fold($this, initial, operation);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E get(@NotNull CompletableJob $this, @NotNull CoroutineContext.Key<E> key) {
            return Job.DefaultImpls.get($this, key);
        }

        @NotNull
        public static CoroutineContext minusKey(@NotNull CompletableJob $this, @NotNull CoroutineContext.Key<?> key) {
            return Job.DefaultImpls.minusKey($this, key);
        }
    }
}


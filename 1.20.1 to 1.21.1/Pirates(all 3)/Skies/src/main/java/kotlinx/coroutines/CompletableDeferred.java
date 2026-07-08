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
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lkotlinx/coroutines/CompletableDeferred;", "T", "Lkotlinx/coroutines/Deferred;", "value", "", "complete", "(Ljava/lang/Object;)Z", "", "exception", "completeExceptionally", "(Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"})
public interface CompletableDeferred<T>
extends Deferred<T> {
    public boolean complete(T var1);

    public boolean completeExceptionally(@NotNull Throwable var1);

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated(message="Since 1.2.0, binary compatibility with versions <= 1.1.x", level=DeprecationLevel.HIDDEN)
        public static /* synthetic */ void cancel(CompletableDeferred $this) {
            Deferred.DefaultImpls.cancel($this);
        }

        @Deprecated(message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.", level=DeprecationLevel.ERROR)
        @NotNull
        public static <T> Job plus(@NotNull CompletableDeferred<T> $this, @NotNull Job other) {
            return Deferred.DefaultImpls.plus((Deferred)$this, other);
        }

        @NotNull
        public static <T> CoroutineContext plus(@NotNull CompletableDeferred<T> $this, @NotNull CoroutineContext context) {
            return Deferred.DefaultImpls.plus((Deferred)$this, context);
        }

        public static <T, R> R fold(@NotNull CompletableDeferred<T> $this, R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return Deferred.DefaultImpls.fold((Deferred)$this, initial, operation);
        }

        @Nullable
        public static <T, E extends CoroutineContext.Element> E get(@NotNull CompletableDeferred<T> $this, @NotNull CoroutineContext.Key<E> key) {
            return Deferred.DefaultImpls.get((Deferred)$this, key);
        }

        @NotNull
        public static <T> CoroutineContext minusKey(@NotNull CompletableDeferred<T> $this, @NotNull CoroutineContext.Key<?> key) {
            return Deferred.DefaultImpls.minusKey((Deferred)$this, key);
        }
    }
}


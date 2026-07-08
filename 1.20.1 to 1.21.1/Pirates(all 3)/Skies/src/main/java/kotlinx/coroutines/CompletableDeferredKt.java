/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0003\u0010\u0007\u001a.\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2={"T", "value", "Lkotlinx/coroutines/CompletableDeferred;", "CompletableDeferred", "(Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/Job;", "parent", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/CompletableDeferred;", "Lkotlin/Result;", "result", "", "completeWith", "(Lkotlinx/coroutines/CompletableDeferred;Ljava/lang/Object;)Z", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nCompletableDeferred.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompletableDeferred.kt\nkotlinx/coroutines/CompletableDeferredKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,94:1\n1#2:95\n*E\n"})
public final class CompletableDeferredKt {
    public static final <T> boolean completeWith(@NotNull CompletableDeferred<T> $this$completeWith, @NotNull Object result2) {
        boolean bl;
        Object object = result2;
        Throwable throwable = Result.exceptionOrNull-impl((Object)object);
        if (throwable == null) {
            Object it = object;
            boolean bl2 = false;
            bl = $this$completeWith.complete(it);
        } else {
            Throwable it = throwable;
            boolean bl3 = false;
            bl = $this$completeWith.completeExceptionally(it);
        }
        return bl;
    }

    @NotNull
    public static final <T> CompletableDeferred<T> CompletableDeferred(@Nullable Job parent) {
        return new CompletableDeferredImpl(parent);
    }

    public static /* synthetic */ CompletableDeferred CompletableDeferred$default(Job job, int n2, Object object) {
        if ((n2 & 1) != 0) {
            job = null;
        }
        return CompletableDeferredKt.CompletableDeferred(job);
    }

    @NotNull
    public static final <T> CompletableDeferred<T> CompletableDeferred(T value) {
        CompletableDeferredImpl<T> completableDeferredImpl;
        CompletableDeferredImpl<T> $this$CompletableDeferred_u24lambda_u242 = completableDeferredImpl = new CompletableDeferredImpl<T>(null);
        boolean bl = false;
        $this$CompletableDeferred_u24lambda_u242.complete(value);
        return completableDeferredImpl;
    }
}


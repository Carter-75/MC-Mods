/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B4\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003\u00a2\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJA\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012#\b\u0002\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019R/\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001aR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001b\u00a8\u0006\u001e"}, d2={"Lkotlinx/coroutines/CompletedWithCancellation;", "", "component1", "()Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "component2", "()Lkotlin/jvm/functions/Function1;", "result", "onCancellation", "copy", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CompletedWithCancellation;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"})
public final class CompletedWithCancellation {
    @JvmField
    @Nullable
    public final Object result;
    @JvmField
    @NotNull
    public final Function1<Throwable, Unit> onCancellation;

    public CompletedWithCancellation(@Nullable Object result2, @NotNull Function1<? super Throwable, Unit> onCancellation) {
        this.result = result2;
        this.onCancellation = onCancellation;
    }

    @Nullable
    public final Object component1() {
        return this.result;
    }

    @NotNull
    public final Function1<Throwable, Unit> component2() {
        return this.onCancellation;
    }

    @NotNull
    public final CompletedWithCancellation copy(@Nullable Object result2, @NotNull Function1<? super Throwable, Unit> onCancellation) {
        return new CompletedWithCancellation(result2, onCancellation);
    }

    public static /* synthetic */ CompletedWithCancellation copy$default(CompletedWithCancellation completedWithCancellation, Object object, Function1 function1, int n2, Object object2) {
        if ((n2 & 1) != 0) {
            object = completedWithCancellation.result;
        }
        if ((n2 & 2) != 0) {
            function1 = completedWithCancellation.onCancellation;
        }
        return completedWithCancellation.copy(object, function1);
    }

    @NotNull
    public String toString() {
        return "CompletedWithCancellation(result=" + this.result + ", onCancellation=" + this.onCancellation + ')';
    }

    public int hashCode() {
        int result2 = this.result == null ? 0 : this.result.hashCode();
        result2 = result2 * 31 + this.onCancellation.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompletedWithCancellation)) {
            return false;
        }
        CompletedWithCancellation completedWithCancellation = (CompletedWithCancellation)other;
        if (!Intrinsics.areEqual((Object)this.result, (Object)completedWithCancellation.result)) {
            return false;
        }
        return Intrinsics.areEqual(this.onCancellation, completedWithCancellation.onCancellation);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000,\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001aD\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086H\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000e\"\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\"\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\"\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013\"\u0014\u0010\u0015\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000e\"\u0014\u0010\u0016\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000e\"\u0014\u0010\u0017\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2={"", "locked", "Lkotlinx/coroutines/sync/Mutex;", "Mutex", "(Z)Lkotlinx/coroutines/sync/Mutex;", "T", "", "owner", "Lkotlin/Function0;", "action", "withLock", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "HOLDS_LOCK_ANOTHER_OWNER", "I", "HOLDS_LOCK_UNLOCKED", "HOLDS_LOCK_YES", "Lkotlinx/coroutines/internal/Symbol;", "NO_OWNER", "Lkotlinx/coroutines/internal/Symbol;", "ON_LOCK_ALREADY_LOCKED_BY_OWNER", "TRY_LOCK_ALREADY_LOCKED_BY_OWNER", "TRY_LOCK_FAILED", "TRY_LOCK_SUCCESS", "kotlinx-coroutines-core"})
public final class MutexKt {
    @NotNull
    private static final Symbol NO_OWNER = new Symbol("NO_OWNER");
    @NotNull
    private static final Symbol ON_LOCK_ALREADY_LOCKED_BY_OWNER = new Symbol("ALREADY_LOCKED_BY_OWNER");
    private static final int TRY_LOCK_SUCCESS = 0;
    private static final int TRY_LOCK_FAILED = 1;
    private static final int TRY_LOCK_ALREADY_LOCKED_BY_OWNER = 2;
    private static final int HOLDS_LOCK_UNLOCKED = 0;
    private static final int HOLDS_LOCK_YES = 1;
    private static final int HOLDS_LOCK_ANOTHER_OWNER = 2;

    @NotNull
    public static final Mutex Mutex(boolean locked) {
        return new MutexImpl(locked);
    }

    public static /* synthetic */ Mutex Mutex$default(boolean bl, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl = false;
        }
        return MutexKt.Mutex(bl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Nullable
    public static final <T> Object withLock(@NotNull Mutex var0, @Nullable Object var1_1, @NotNull Function0<? extends T> var2_2, @NotNull Continuation<? super T> var3_3) {
        if (!(var3_3 instanceof withLock.1)) ** GOTO lbl-1000
        var7_4 = var3_3;
        if ((var7_4.label & -2147483648) != 0) {
            var7_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var3_3){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return MutexKt.withLock(null, null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var8_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $i$f$withLock = false;
                $continuation.L$0 = $this$withLock;
                $continuation.L$1 = owner;
                $continuation.L$2 = action;
                $continuation.label = 1;
                v0 = $this$withLock.lock(owner, (Continuation<? super Unit>)$continuation);
                if (v0 == var8_6) {
                    return var8_6;
                }
                ** GOTO lbl29
            }
            case 1: {
                $i$f$withLock = false;
                action = (Function0)$continuation.L$2;
                owner = $continuation.L$1;
                $this$withLock = (Mutex)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl29:
                // 2 sources

                try {
                    var5_9 = action.invoke();
                    return var5_9;
                }
                finally {
                    InlineMarker.finallyStart((int)1);
                    $this$withLock.unlock(owner);
                    InlineMarker.finallyEnd((int)1);
                }
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final <T> Object withLock$$forInline(Mutex $this$withLock, Object owner, Function0<? extends T> action, Continuation<? super T> $completion) {
        boolean $i$f$withLock = false;
        InlineMarker.mark((int)0);
        $this$withLock.lock(owner, $completion);
        InlineMarker.mark((int)1);
        try {
            Object object = action.invoke();
            return object;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            $this$withLock.unlock(owner);
            InlineMarker.finallyEnd((int)1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static /* synthetic */ Object withLock$default(Mutex $this$withLock_u24default, Object owner, Function0 action, Continuation $completion, int n2, Object object) {
        if ((n2 & 1) != 0) {
            owner = null;
        }
        boolean $i$f$withLock = false;
        InlineMarker.mark((int)0);
        $this$withLock_u24default.lock(owner, (Continuation<? super Unit>)$completion);
        InlineMarker.mark((int)1);
        try {
            object = action.invoke();
            return object;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            $this$withLock_u24default.unlock(owner);
            InlineMarker.finallyEnd((int)1);
        }
    }

    public static final /* synthetic */ Symbol access$getNO_OWNER$p() {
        return NO_OWNER;
    }

    public static final /* synthetic */ Symbol access$getON_LOCK_ALREADY_LOCKED_BY_OWNER$p() {
        return ON_LOCK_ALREADY_LOCKED_BY_OWNER;
    }
}


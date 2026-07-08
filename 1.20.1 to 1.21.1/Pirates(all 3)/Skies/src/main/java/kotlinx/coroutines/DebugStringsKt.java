/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0007\u001a\u00020\u0001*\u00020\u00048@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\t\u001a\u00020\u0001*\u00020\u00048@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\n"}, d2={"Lkotlin/coroutines/Continuation;", "", "toDebugString", "(Lkotlin/coroutines/Continuation;)Ljava/lang/String;", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "classSimpleName", "getHexAddress", "hexAddress", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nDebugStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugStrings.kt\nkotlinx/coroutines/DebugStringsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
public final class DebugStringsKt {
    @NotNull
    public static final String getHexAddress(@NotNull Object $this$hexAddress) {
        return Integer.toHexString(System.identityHashCode($this$hexAddress));
    }

    @NotNull
    public static final String toDebugString(@NotNull Continuation<?> $this$toDebugString) {
        String string;
        if ($this$toDebugString instanceof DispatchedContinuation) {
            string = $this$toDebugString.toString();
        } else {
            Object object;
            Object $this$toDebugString_u24lambda_u240;
            Continuation<?> continuation = $this$toDebugString;
            try {
                $this$toDebugString_u24lambda_u240 = continuation;
                boolean bl = false;
                $this$toDebugString_u24lambda_u240 = Result.constructor-impl((Object)($this$toDebugString_u24lambda_u240 + '@' + DebugStringsKt.getHexAddress($this$toDebugString_u24lambda_u240)));
            }
            catch (Throwable bl) {
                $this$toDebugString_u24lambda_u240 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl));
            }
            continuation = $this$toDebugString_u24lambda_u240;
            Throwable throwable = Result.exceptionOrNull-impl(continuation);
            if (throwable == null) {
                object = continuation;
            } else {
                Throwable it = throwable;
                boolean bl = false;
                object = $this$toDebugString.getClass().getName() + '@' + DebugStringsKt.getHexAddress($this$toDebugString);
            }
            string = (String)object;
        }
        return string;
    }

    @NotNull
    public static final String getClassSimpleName(@NotNull Object $this$classSimpleName) {
        return $this$classSimpleName.getClass().getSimpleName();
    }
}


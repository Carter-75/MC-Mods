/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.UnbiasedSelectImplementation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aG\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004H\u0086H\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2={"R", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builder", "selectUnbiased", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class SelectUnbiasedKt {
    @Nullable
    public static final <R> Object selectUnbiased(@NotNull Function1<? super SelectBuilder<? super R>, Unit> builder, @NotNull Continuation<? super R> $completion) {
        boolean $i$f$selectUnbiased = false;
        UnbiasedSelectImplementation<? super R> $this$selectUnbiased_u24lambda_u241 = new UnbiasedSelectImplementation<R>($completion.getContext());
        boolean bl = false;
        builder.invoke($this$selectUnbiased_u24lambda_u241);
        return $this$selectUnbiased_u24lambda_u241.doSelect($completion);
    }

    private static final <R> Object selectUnbiased$$forInline(Function1<? super SelectBuilder<? super R>, Unit> builder, Continuation<? super R> $completion) {
        boolean $i$f$selectUnbiased = false;
        InlineMarker.mark((int)3);
        UnbiasedSelectImplementation unbiasedSelectImplementation = new UnbiasedSelectImplementation(null.getContext());
        UnbiasedSelectImplementation $this$selectUnbiased_u24lambda_u241 = unbiasedSelectImplementation;
        boolean bl = false;
        builder.invoke($this$selectUnbiased_u24lambda_u241);
        InlineMarker.mark((int)3);
        InlineMarker.mark((int)0);
        Object object = $this$selectUnbiased_u24lambda_u241.doSelect(null);
        InlineMarker.mark((int)1);
        return object;
    }
}


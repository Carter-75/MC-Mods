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
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.WhileSelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a4\u0010\u0006\u001a\u00020\u00032\u001f\b\u0004\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0000\u00a2\u0006\u0002\b\u0004H\u0087H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2={"Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "", "Lkotlin/ExtensionFunctionType;", "builder", "whileSelect", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nWhileSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,33:1\n55#2,8:34\n*S KotlinDebug\n*F\n+ 1 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n*L\n31#1:34,8\n*E\n"})
public final class WhileSelectKt {
    /*
     * Unable to fully structure code
     */
    @ExperimentalCoroutinesApi
    @Nullable
    public static final Object whileSelect(@NotNull Function1<? super SelectBuilder<? super Boolean>, Unit> var0, @NotNull Continuation<? super Unit> var1_1) {
        if (!(var1_1 instanceof whileSelect.1)) ** GOTO lbl-1000
        var7_2 = var1_1;
        if ((var7_2.label & -2147483648) != 0) {
            var7_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(var1_1){
                Object L$0;
                /* synthetic */ Object result;
                int label;

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return WhileSelectKt.whileSelect(null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var8_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $i$f$whileSelect = false;
                while (true) {
                    $i$f$select = false;
                    $this$select_u24lambda_u241$iv = new SelectImplementation<R>($continuation.getContext());
                    $i$a$-run-SelectKt$select$3$iv = false;
                    builder.invoke($this$select_u24lambda_u241$iv);
                    $continuation.L$0 = builder;
                    $continuation.label = 1;
                    v0 = $this$select_u24lambda_u241$iv.doSelect($continuation);
                    if (v0 != var8_4) continue;
                    return var8_4;
                }
            }
            case 1: {
                $i$f$whileSelect = false;
                $i$f$select = false;
                $i$a$-run-SelectKt$select$3$iv = false;
                builder = (Function1)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
                if (((Boolean)v0).booleanValue()) ** continue;
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @ExperimentalCoroutinesApi
    private static final Object whileSelect$$forInline(Function1<? super SelectBuilder<? super Boolean>, Unit> builder, Continuation<? super Unit> $completion) {
        Object object;
        boolean $i$f$whileSelect = false;
        do {
            boolean $i$f$select = false;
            InlineMarker.mark((int)3);
            SelectImplementation selectImplementation = new SelectImplementation(null.getContext());
            SelectImplementation $this$select_u24lambda_u241$iv = selectImplementation;
            boolean bl = false;
            builder.invoke($this$select_u24lambda_u241$iv);
            InlineMarker.mark((int)3);
            InlineMarker.mark((int)0);
            object = $this$select_u24lambda_u241$iv.doSelect(null);
            InlineMarker.mark((int)1);
        } while (((Boolean)object).booleanValue());
        return Unit.INSTANCE;
    }
}


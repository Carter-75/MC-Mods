/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.InlineMarker
 */
package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectKt;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000d\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001aG\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052\u001f\b\u0004\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\b\tH\u0086H\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\u000b\u0010\f\u001a>\u0010\u0014\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\b0\r2#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015\"c\u0010\u001c\u001aQ\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016j\u0002`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\"\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \"\u001a\u0010!\u001a\u00020\u001e8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b!\u0010 \u001a\u0004\b\"\u0010#\"\u0014\u0010$\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010 \"\u0014\u0010%\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010 \"\u0014\u0010&\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010 \"\u0014\u0010'\u001a\u00020\u00008\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010(\"\u0014\u0010)\u001a\u00020\u00008\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b)\u0010(\"\u0014\u0010*\u001a\u00020\u00008\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010(\"\u0014\u0010+\u001a\u00020\u00008\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b+\u0010(*\u00c2\u0001\b\u0007\u0010/\"[\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030,\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\u00060\u00162[\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030,\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\u00060\u0016B\u0002\b.*\u00a6\u0001\b\u0007\u00100\"M\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162M\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016B\u0002\b.*\u00a6\u0001\b\u0007\u00101\"M\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030,\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\b0\u00162M\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030,\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\b0\u0016B\u0002\b.\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2={"", "trySelectInternalResult", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "TrySelectDetailedResult", "(I)Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "R", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builder", "select", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CancellableContinuation;", "", "Lkotlin/ParameterName;", "name", "cause", "onCancellation", "", "tryResume", "(Lkotlinx/coroutines/CancellableContinuation;Lkotlin/jvm/functions/Function1;)Z", "Lkotlin/Function3;", "", "clauseObject", "param", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "DUMMY_PROCESS_RESULT_FUNCTION", "Lkotlin/jvm/functions/Function3;", "Lkotlinx/coroutines/internal/Symbol;", "NO_RESULT", "Lkotlinx/coroutines/internal/Symbol;", "PARAM_CLAUSE_0", "getPARAM_CLAUSE_0", "()Lkotlinx/coroutines/internal/Symbol;", "STATE_CANCELLED", "STATE_COMPLETED", "STATE_REG", "TRY_SELECT_ALREADY_SELECTED", "I", "TRY_SELECT_CANCELLED", "TRY_SELECT_REREGISTER", "TRY_SELECT_SUCCESSFUL", "Lkotlinx/coroutines/selects/SelectInstance;", "internalResult", "Lkotlinx/coroutines/InternalCoroutinesApi;", "OnCancellationConstructor", "ProcessResultFunction", "RegistrationFunction", "kotlinx-coroutines-core"})
public final class SelectKt {
    @NotNull
    private static final Function3<Object, Object, Object, Object> DUMMY_PROCESS_RESULT_FUNCTION = DUMMY_PROCESS_RESULT_FUNCTION.1.INSTANCE;
    private static final int TRY_SELECT_SUCCESSFUL = 0;
    private static final int TRY_SELECT_REREGISTER = 1;
    private static final int TRY_SELECT_CANCELLED = 2;
    private static final int TRY_SELECT_ALREADY_SELECTED = 3;
    @NotNull
    private static final Symbol STATE_REG = new Symbol("STATE_REG");
    @NotNull
    private static final Symbol STATE_COMPLETED = new Symbol("STATE_COMPLETED");
    @NotNull
    private static final Symbol STATE_CANCELLED = new Symbol("STATE_CANCELLED");
    @NotNull
    private static final Symbol NO_RESULT = new Symbol("NO_RESULT");
    @NotNull
    private static final Symbol PARAM_CLAUSE_0 = new Symbol("PARAM_CLAUSE_0");

    @Nullable
    public static final <R> Object select(@NotNull Function1<? super SelectBuilder<? super R>, Unit> builder, @NotNull Continuation<? super R> $completion) {
        boolean $i$f$select = false;
        SelectImplementation<? super R> $this$select_u24lambda_u241 = new SelectImplementation<R>($completion.getContext());
        boolean bl = false;
        builder.invoke($this$select_u24lambda_u241);
        return $this$select_u24lambda_u241.doSelect($completion);
    }

    private static final <R> Object select$$forInline(Function1<? super SelectBuilder<? super R>, Unit> builder, Continuation<? super R> $completion) {
        boolean $i$f$select = false;
        InlineMarker.mark((int)3);
        SelectImplementation selectImplementation = new SelectImplementation(null.getContext());
        SelectImplementation $this$select_u24lambda_u241 = selectImplementation;
        boolean bl = false;
        builder.invoke($this$select_u24lambda_u241);
        InlineMarker.mark((int)3);
        InlineMarker.mark((int)0);
        Object object = $this$select_u24lambda_u241.doSelect(null);
        InlineMarker.mark((int)1);
        return object;
    }

    private static final boolean tryResume(CancellableContinuation<? super Unit> $this$tryResume, Function1<? super Throwable, Unit> onCancellation) {
        Object object = $this$tryResume.tryResume((Unit)Unit.INSTANCE, null, onCancellation);
        if (object == null) {
            return false;
        }
        Object token2 = object;
        $this$tryResume.completeResume(token2);
        return true;
    }

    private static final TrySelectDetailedResult TrySelectDetailedResult(int trySelectInternalResult) {
        TrySelectDetailedResult trySelectDetailedResult;
        switch (trySelectInternalResult) {
            case 0: {
                trySelectDetailedResult = TrySelectDetailedResult.SUCCESSFUL;
                break;
            }
            case 1: {
                trySelectDetailedResult = TrySelectDetailedResult.REREGISTER;
                break;
            }
            case 2: {
                trySelectDetailedResult = TrySelectDetailedResult.CANCELLED;
                break;
            }
            case 3: {
                trySelectDetailedResult = TrySelectDetailedResult.ALREADY_SELECTED;
                break;
            }
            default: {
                throw new IllegalStateException(("Unexpected internal result: " + trySelectInternalResult).toString());
            }
        }
        return trySelectDetailedResult;
    }

    @NotNull
    public static final Symbol getPARAM_CLAUSE_0() {
        return PARAM_CLAUSE_0;
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void RegistrationFunction$annotations() {
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void ProcessResultFunction$annotations() {
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void OnCancellationConstructor$annotations() {
    }

    public static final /* synthetic */ Function3 access$getDUMMY_PROCESS_RESULT_FUNCTION$p() {
        return DUMMY_PROCESS_RESULT_FUNCTION;
    }

    public static final /* synthetic */ Symbol access$getSTATE_REG$p() {
        return STATE_REG;
    }

    public static final /* synthetic */ Symbol access$getNO_RESULT$p() {
        return NO_RESULT;
    }

    public static final /* synthetic */ Symbol access$getSTATE_CANCELLED$p() {
        return STATE_CANCELLED;
    }

    public static final /* synthetic */ TrySelectDetailedResult access$TrySelectDetailedResult(int trySelectInternalResult) {
        return SelectKt.TrySelectDetailedResult(trySelectInternalResult);
    }

    public static final /* synthetic */ boolean access$tryResume(CancellableContinuation $receiver, Function1 onCancellation) {
        return SelectKt.tryResume($receiver, (Function1<? super Throwable, Unit>)onCancellation);
    }

    public static final /* synthetic */ Symbol access$getSTATE_COMPLETED$p() {
        return STATE_COMPLETED;
    }
}


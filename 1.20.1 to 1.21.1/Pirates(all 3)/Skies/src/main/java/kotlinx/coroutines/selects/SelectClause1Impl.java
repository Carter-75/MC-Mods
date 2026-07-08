/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u00a8\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012U\u0010\u001c\u001aQ\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00110\bj\u0002`\u001b\u0012U\u0010\u0019\u001aQ\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bj\u0002`\u0018\u0012i\b\u0002\u0010\u0013\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f\u0018\u00010\bj\u0004\u0018\u0001`\u0012\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R{\u0010\u0013\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f\u0018\u00010\bj\u0004\u0018\u0001`\u00128\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016Ri\u0010\u0019\u001aQ\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bj\u0002`\u00188\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016Ri\u0010\u001c\u001aQ\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00110\bj\u0002`\u001b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\u00a8\u0006 "}, d2={"Lkotlinx/coroutines/selects/SelectClause1Impl;", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "", "clauseObject", "Ljava/lang/Object;", "getClauseObject", "()Ljava/lang/Object;", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", "name", "select", "param", "internalResult", "Lkotlin/Function1;", "", "", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onCancellationConstructor", "Lkotlin/jvm/functions/Function3;", "getOnCancellationConstructor", "()Lkotlin/jvm/functions/Function3;", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "processResFunc", "getProcessResFunc", "Lkotlinx/coroutines/selects/RegistrationFunction;", "regFunc", "getRegFunc", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)V", "kotlinx-coroutines-core"})
public final class SelectClause1Impl<Q>
implements SelectClause1<Q> {
    @NotNull
    private final Object clauseObject;
    @NotNull
    private final Function3<Object, SelectInstance<?>, Object, Unit> regFunc;
    @NotNull
    private final Function3<Object, Object, Object, Object> processResFunc;
    @Nullable
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onCancellationConstructor;

    public SelectClause1Impl(@NotNull Object clauseObject, @NotNull Function3<Object, ? super SelectInstance<?>, Object, Unit> regFunc, @NotNull Function3<Object, Object, Object, ? extends Object> processResFunc, @Nullable Function3<? super SelectInstance<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> onCancellationConstructor) {
        this.clauseObject = clauseObject;
        this.regFunc = regFunc;
        this.processResFunc = processResFunc;
        this.onCancellationConstructor = onCancellationConstructor;
    }

    public /* synthetic */ SelectClause1Impl(Object object, Function3 function3, Function3 function32, Function3 function33, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 8) != 0) {
            function33 = null;
        }
        this(object, function3, (Function3<Object, Object, Object, ? extends Object>)function32, function33);
    }

    @Override
    @NotNull
    public Object getClauseObject() {
        return this.clauseObject;
    }

    @Override
    @NotNull
    public Function3<Object, SelectInstance<?>, Object, Unit> getRegFunc() {
        return this.regFunc;
    }

    @Override
    @NotNull
    public Function3<Object, Object, Object, Object> getProcessResFunc() {
        return this.processResFunc;
    }

    @Override
    @Nullable
    public Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> getOnCancellationConstructor() {
        return this.onCancellationConstructor;
    }
}


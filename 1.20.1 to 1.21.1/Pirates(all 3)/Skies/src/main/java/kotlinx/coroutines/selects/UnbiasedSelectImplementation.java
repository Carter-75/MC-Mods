/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.selects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u0003\u001a\u00028\u0000H\u0091@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J5\u0010\r\u001a\u00020\u0005*\u00020\b2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJG\u0010\r\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u000f*\b\u0012\u0004\u0012\u00028\u00010\u00102\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u0012J[\u0010\r\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u0013\"\u0004\b\u0002\u0010\u000f*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00012\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u0016R$\u0010\u0019\u001a\u0012\u0012\u000e\u0012\f0\u0018R\b\u0012\u0004\u0012\u00028\u00000\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2={"Lkotlinx/coroutines/selects/UnbiasedSelectImplementation;", "R", "Lkotlinx/coroutines/selects/SelectImplementation;", "doSelect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "shuffleAndRegisterClauses", "()V", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "clausesToRegister", "Ljava/util/List;", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"})
@PublishedApi
@SourceDebugExtension(value={"SMAP\nSelectUnbiased.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectUnbiased.kt\nkotlinx/coroutines/selects/UnbiasedSelectImplementation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n1855#2,2:69\n*S KotlinDebug\n*F\n+ 1 SelectUnbiased.kt\nkotlinx/coroutines/selects/UnbiasedSelectImplementation\n*L\n63#1:69,2\n*E\n"})
public class UnbiasedSelectImplementation<R>
extends SelectImplementation<R> {
    @NotNull
    private final List<SelectImplementation.ClauseData> clausesToRegister = new ArrayList();

    public UnbiasedSelectImplementation(@NotNull CoroutineContext context) {
        super(context);
    }

    @Override
    public void invoke(@NotNull SelectClause0 $this$invoke, @NotNull Function1<? super Continuation<? super R>, ? extends Object> block) {
        ((Collection)this.clausesToRegister).add(new SelectImplementation.ClauseData($this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), block, $this$invoke.getOnCancellationConstructor()));
    }

    @Override
    public <Q> void invoke(@NotNull SelectClause1<? extends Q> $this$invoke, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        ((Collection)this.clausesToRegister).add(new SelectImplementation.ClauseData($this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), null, block, $this$invoke.getOnCancellationConstructor()));
    }

    @Override
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> $this$invoke, P param, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
        ((Collection)this.clausesToRegister).add(new SelectImplementation.ClauseData($this$invoke.getClauseObject(), $this$invoke.getRegFunc(), $this$invoke.getProcessResFunc(), param, block, $this$invoke.getOnCancellationConstructor()));
    }

    @Override
    @PublishedApi
    @Nullable
    public Object doSelect(@NotNull Continuation<? super R> $completion) {
        return UnbiasedSelectImplementation.doSelect$suspendImpl(this, $completion);
    }

    @PublishedApi
    static /* synthetic */ <R> Object doSelect$suspendImpl(UnbiasedSelectImplementation<R> $this, Continuation<? super R> $completion) {
        super.shuffleAndRegisterClauses();
        return super.doSelect($completion);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void shuffleAndRegisterClauses() {
        try {
            Collections.shuffle(this.clausesToRegister);
            Iterable $this$forEach$iv = this.clausesToRegister;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                SelectImplementation.ClauseData it = (SelectImplementation.ClauseData)element$iv;
                boolean bl = false;
                SelectImplementation.register$default(this, it, false, 1, null);
            }
        }
        finally {
            this.clausesToRegister.clear();
        }
    }
}


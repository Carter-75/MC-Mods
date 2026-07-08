/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.selects.OnTimeout;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause0Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0006\u001a\u00020\u00052\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\b8F\u00a2\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2={"Lkotlinx/coroutines/selects/OnTimeout;", "", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "ignoredParam", "", "register", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "Lkotlinx/coroutines/selects/SelectClause0;", "getSelectClause", "()Lkotlinx/coroutines/selects/SelectClause0;", "getSelectClause$annotations", "()V", "selectClause", "", "timeMillis", "J", "<init>", "(J)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nOnTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n+ 2 Runnable.kt\nkotlinx/coroutines/RunnableKt\n*L\n1#1,66:1\n17#2:67\n*S KotlinDebug\n*F\n+ 1 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n*L\n56#1:67\n*E\n"})
final class OnTimeout {
    private final long timeMillis;

    public OnTimeout(long timeMillis) {
        this.timeMillis = timeMillis;
    }

    @NotNull
    public final SelectClause0 getSelectClause() {
        selectClause.1 v0 = selectClause.1.INSTANCE;
        Intrinsics.checkNotNull((Object)((Object)v0), (String)"null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new SelectClause0Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity((Object)((Object)v0), (int)3), null, 4, null);
    }

    public static /* synthetic */ void getSelectClause$annotations() {
    }

    private final void register(SelectInstance<?> select, Object ignoredParam) {
        if (this.timeMillis <= 0L) {
            select.selectInRegistrationPhase(Unit.INSTANCE);
            return;
        }
        boolean $i$f$Runnable = false;
        Runnable action = new Runnable(select, this){
            final /* synthetic */ SelectInstance $select$inlined;
            final /* synthetic */ OnTimeout this$0;
            {
                this.$select$inlined = selectInstance;
                this.this$0 = onTimeout;
            }

            public final void run() {
                boolean bl = false;
                this.$select$inlined.trySelect(this.this$0, Unit.INSTANCE);
            }
        };
        Intrinsics.checkNotNull(select, (String)"null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        SelectImplementation cfr_ignored_0 = (SelectImplementation)select;
        CoroutineContext context = select.getContext();
        DisposableHandle disposableHandle = DelayKt.getDelay(context).invokeOnTimeout(this.timeMillis, action, context);
        select.disposeOnCompletion(disposableHandle);
    }

    public static final /* synthetic */ void access$register(OnTimeout $this, SelectInstance select, Object ignoredParam) {
        $this.register(select, ignoredParam);
    }
}


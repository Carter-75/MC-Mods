/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.engine_room.flywheel.api.task.Plan
 *  dev.engine_room.flywheel.api.task.TaskExecutor
 *  dev.engine_room.flywheel.lib.task.SimplyComposedPlan
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.mod.compat.flywheel;

import dev.engine_room.flywheel.api.task.Plan;
import dev.engine_room.flywheel.api.task.TaskExecutor;
import dev.engine_room.flywheel.lib.task.SimplyComposedPlan;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B1\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\r\u0012\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fR\u001f\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R)\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2={"Lorg/valkyrienskies/mod/compat/flywheel/IfNotNullPlan;", "", "C", "V", "Ldev/engine_room/flywheel/lib/task/SimplyComposedPlan;", "Ldev/engine_room/flywheel/api/task/TaskExecutor;", "taskExecutor", "context", "Ljava/lang/Runnable;", "onCompletion", "", "execute", "(Ldev/engine_room/flywheel/api/task/TaskExecutor;Ljava/lang/Object;Ljava/lang/Runnable;)V", "Lkotlin/Function0;", "nullable", "Lkotlin/jvm/functions/Function0;", "getNullable", "()Lkotlin/jvm/functions/Function0;", "Lkotlin/Function1;", "Ldev/engine_room/flywheel/api/task/Plan;", "getPlan", "Lkotlin/jvm/functions/Function1;", "getGetPlan", "()Lkotlin/jvm/functions/Function1;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "valkyrienskies-120"})
public final class IfNotNullPlan<C, V>
implements SimplyComposedPlan<C> {
    @NotNull
    private final Function0<V> nullable;
    @NotNull
    private final Function1<V, Plan<C>> getPlan;

    public IfNotNullPlan(@NotNull Function0<? extends V> nullable, @NotNull Function1<? super V, ? extends Plan<C>> getPlan) {
        Intrinsics.checkNotNullParameter(nullable, (String)"nullable");
        Intrinsics.checkNotNullParameter(getPlan, (String)"getPlan");
        this.nullable = nullable;
        this.getPlan = getPlan;
    }

    @NotNull
    public final Function0<V> getNullable() {
        return this.nullable;
    }

    @NotNull
    public final Function1<V, Plan<C>> getGetPlan() {
        return this.getPlan;
    }

    public void execute(@NotNull TaskExecutor taskExecutor, @NotNull C context, @NotNull Runnable onCompletion) {
        Intrinsics.checkNotNullParameter((Object)taskExecutor, (String)"taskExecutor");
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)onCompletion, (String)"onCompletion");
        Object n2 = this.nullable.invoke();
        if (n2 != null) {
            ((Plan)this.getPlan.invoke(n2)).execute(taskExecutor, context, onCompletion);
        }
    }
}


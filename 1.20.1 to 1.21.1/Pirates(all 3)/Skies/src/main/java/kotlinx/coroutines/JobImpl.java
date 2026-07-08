/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.Unit
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildHandleNode;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobNode;
import kotlinx.coroutines.JobSupport;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0003\u00a2\u0006\u0004\b\n\u0010\u0005R\u001a\u0010\n\u001a\u00020\u00038\u0010X\u0090\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00038PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0005\u00a8\u0006\u0013"}, d2={"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "", "complete", "()Z", "", "exception", "completeExceptionally", "(Ljava/lang/Throwable;)Z", "handlesException", "Z", "getHandlesException$kotlinx_coroutines_core", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "kotlinx-coroutines-core"})
@PublishedApi
public class JobImpl
extends JobSupport
implements CompletableJob {
    private final boolean handlesException;

    public JobImpl(@Nullable Job parent) {
        super(true);
        this.initParentJob(parent);
        this.handlesException = this.handlesException();
    }

    @Override
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }

    @Override
    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.handlesException;
    }

    @Override
    public boolean complete() {
        return this.makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
    }

    @Override
    public boolean completeExceptionally(@NotNull Throwable exception) {
        return this.makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(exception, false, 2, null));
    }

    private final boolean handlesException() {
        ChildHandle childHandle = this.getParentHandle$kotlinx_coroutines_core();
        Object object = childHandle instanceof ChildHandleNode ? (ChildHandleNode)childHandle : null;
        if (object == null || (object = ((JobNode)object).getJob()) == null) {
            return false;
        }
        Object parentJob = object;
        while (!((JobSupport)parentJob).getHandlesException$kotlinx_coroutines_core()) {
            childHandle = ((JobSupport)parentJob).getParentHandle$kotlinx_coroutines_core();
            Object object2 = childHandle instanceof ChildHandleNode ? (ChildHandleNode)childHandle : null;
            if (object2 == null || (object2 = ((JobNode)object2).getJob()) == null) {
                return false;
            }
            parentJob = object2;
        }
        return true;
    }
}


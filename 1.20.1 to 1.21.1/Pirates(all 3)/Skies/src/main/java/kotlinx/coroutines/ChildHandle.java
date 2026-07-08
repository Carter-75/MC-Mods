/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 */
package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message="This is internal API and may be removed in the future releases", level=DeprecationLevel.ERROR)
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2={"Lkotlinx/coroutines/ChildHandle;", "Lkotlinx/coroutines/DisposableHandle;", "", "cause", "", "childCancelled", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/Job;", "getParent", "()Lkotlinx/coroutines/Job;", "getParent$annotations", "()V", "parent", "kotlinx-coroutines-core"})
@InternalCoroutinesApi
public interface ChildHandle
extends DisposableHandle {
    @Nullable
    public Job getParent();

    @InternalCoroutinesApi
    public boolean childCancelled(@NotNull Throwable var1);

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @InternalCoroutinesApi
        public static /* synthetic */ void getParent$annotations() {
        }
    }
}


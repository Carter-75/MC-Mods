/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SharingCommand;
import kotlinx.coroutines.flow.StartedEagerly;
import kotlinx.coroutines.flow.StartedLazily;
import kotlinx.coroutines.flow.StartedWhileSubscribed;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00e6\u0080\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\tJ#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2={"Lkotlinx/coroutines/flow/SharingStarted;", "", "Lkotlinx/coroutines/flow/StateFlow;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "command", "(Lkotlinx/coroutines/flow/StateFlow;)Lkotlinx/coroutines/flow/Flow;", "Companion", "kotlinx-coroutines-core"})
public interface SharingStarted {
    @NotNull
    public static final Companion Companion = kotlinx.coroutines.flow.SharingStarted$Companion.$$INSTANCE;

    @NotNull
    public Flow<SharingCommand> command(@NotNull StateFlow<Integer> var1);

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0010"}, d2={"Lkotlinx/coroutines/flow/SharingStarted$Companion;", "", "", "stopTimeoutMillis", "replayExpirationMillis", "Lkotlinx/coroutines/flow/SharingStarted;", "WhileSubscribed", "(JJ)Lkotlinx/coroutines/flow/SharingStarted;", "Eagerly", "Lkotlinx/coroutines/flow/SharingStarted;", "getEagerly", "()Lkotlinx/coroutines/flow/SharingStarted;", "Lazily", "getLazily", "<init>", "()V", "kotlinx-coroutines-core"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final SharingStarted Eagerly;
        @NotNull
        private static final SharingStarted Lazily;

        private Companion() {
        }

        @NotNull
        public final SharingStarted getEagerly() {
            return Eagerly;
        }

        @NotNull
        public final SharingStarted getLazily() {
            return Lazily;
        }

        @NotNull
        public final SharingStarted WhileSubscribed(long stopTimeoutMillis, long replayExpirationMillis) {
            return new StartedWhileSubscribed(stopTimeoutMillis, replayExpirationMillis);
        }

        public static /* synthetic */ SharingStarted WhileSubscribed$default(Companion companion, long l2, long l3, int n2, Object object) {
            if ((n2 & 1) != 0) {
                l2 = 0L;
            }
            if ((n2 & 2) != 0) {
                l3 = Long.MAX_VALUE;
            }
            return companion.WhileSubscribed(l2, l3);
        }

        static {
            $$INSTANCE = new Companion();
            Eagerly = new StartedEagerly();
            Lazily = new StartedLazily();
        }
    }
}


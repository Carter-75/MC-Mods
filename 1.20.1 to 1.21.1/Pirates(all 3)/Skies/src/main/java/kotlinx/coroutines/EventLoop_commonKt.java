/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000 \n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\"\u0014\u0010\n\u001a\u00020\u00008\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\u00020\u00008\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\"\u0014\u0010\r\u001a\u00020\u00008\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\"\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\"\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010*\u001e\b\u0002\u0010\u0015\u001a\u0004\b\u0000\u0010\u0013\"\b\u0012\u0004\u0012\u00028\u00000\u00142\b\u0012\u0004\u0012\u00028\u00000\u0014\u00a8\u0006\u0016"}, d2={"", "timeNanos", "delayNanosToMillis", "(J)J", "timeMillis", "delayToNanos", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED_EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "DISPOSED_TASK", "MAX_DELAY_NS", "J", "MAX_MS", "MS_TO_NS", "", "SCHEDULE_COMPLETED", "I", "SCHEDULE_DISPOSED", "SCHEDULE_OK", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Queue", "kotlinx-coroutines-core"})
public final class EventLoop_commonKt {
    @NotNull
    private static final Symbol DISPOSED_TASK = new Symbol("REMOVED_TASK");
    private static final int SCHEDULE_OK = 0;
    private static final int SCHEDULE_COMPLETED = 1;
    private static final int SCHEDULE_DISPOSED = 2;
    private static final long MS_TO_NS = 1000000L;
    private static final long MAX_MS = 9223372036854L;
    private static final long MAX_DELAY_NS = 0x3FFFFFFFFFFFFFFFL;
    @NotNull
    private static final Symbol CLOSED_EMPTY = new Symbol("CLOSED_EMPTY");

    public static final long delayToNanos(long timeMillis) {
        return timeMillis <= 0L ? 0L : (timeMillis >= 9223372036854L ? Long.MAX_VALUE : timeMillis * 1000000L);
    }

    public static final long delayNanosToMillis(long timeNanos) {
        return timeNanos / 1000000L;
    }

    public static final /* synthetic */ Symbol access$getCLOSED_EMPTY$p() {
        return CLOSED_EMPTY;
    }

    public static final /* synthetic */ Symbol access$getDISPOSED_TASK$p() {
        return DISPOSED_TASK;
    }
}


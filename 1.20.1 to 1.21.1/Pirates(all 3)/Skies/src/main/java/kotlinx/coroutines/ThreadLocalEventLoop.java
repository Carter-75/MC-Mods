/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.EventLoopKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadLocalKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\bJ\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\n\u001a\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004R(\u0010\u0011\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2={"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "Lkotlinx/coroutines/EventLoop;", "currentOrNull$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "currentOrNull", "", "resetEventLoop$kotlinx_coroutines_core", "()V", "resetEventLoop", "eventLoop", "setEventLoop$kotlinx_coroutines_core", "(Lkotlinx/coroutines/EventLoop;)V", "setEventLoop", "getEventLoop$kotlinx_coroutines_core", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "ref", "Ljava/lang/ThreadLocal;", "<init>", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/ThreadLocalEventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
public final class ThreadLocalEventLoop {
    @NotNull
    public static final ThreadLocalEventLoop INSTANCE = new ThreadLocalEventLoop();
    @NotNull
    private static final ThreadLocal<EventLoop> ref = ThreadLocalKt.commonThreadLocal(new Symbol("ThreadLocalEventLoop"));

    private ThreadLocalEventLoop() {
    }

    @NotNull
    public final EventLoop getEventLoop$kotlinx_coroutines_core() {
        EventLoop eventLoop = ref.get();
        if (eventLoop == null) {
            EventLoop eventLoop2;
            EventLoop it = eventLoop2 = EventLoopKt.createEventLoop();
            boolean bl = false;
            ref.set(it);
            eventLoop = eventLoop2;
        }
        return eventLoop;
    }

    @Nullable
    public final EventLoop currentOrNull$kotlinx_coroutines_core() {
        return ref.get();
    }

    public final void resetEventLoop$kotlinx_coroutines_core() {
        ref.set(null);
    }

    public final void setEventLoop$kotlinx_coroutines_core(@NotNull EventLoop eventLoop) {
        ref.set(eventLoop);
    }
}


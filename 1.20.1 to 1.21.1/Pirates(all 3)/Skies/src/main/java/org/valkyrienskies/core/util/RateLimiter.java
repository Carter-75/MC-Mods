/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.util;

import java.time.Duration;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2={"Lorg/valkyrienskies/core/util/RateLimiter;", "", "Ljava/lang/Runnable;", "block", "", "maybeRun", "(Ljava/lang/Runnable;)V", "Ljava/time/Instant;", "lastCall", "Ljava/time/Instant;", "Ljava/time/Duration;", "minTimeSincePrev", "Ljava/time/Duration;", "<init>", "(Ljava/time/Duration;)V", "util"})
public final class RateLimiter {
    @NotNull
    private final Duration minTimeSincePrev;
    @NotNull
    private Instant lastCall;

    public RateLimiter(@NotNull Duration minTimeSincePrev) {
        Intrinsics.checkNotNullParameter((Object)minTimeSincePrev, (String)"minTimeSincePrev");
        this.minTimeSincePrev = minTimeSincePrev;
        Instant instant = Instant.MIN;
        Intrinsics.checkNotNullExpressionValue((Object)instant, (String)"MIN");
        this.lastCall = instant;
    }

    public final void maybeRun(@NotNull Runnable block) {
        Intrinsics.checkNotNullParameter((Object)block, (String)"block");
        Instant now = Instant.now();
        if (Duration.between(this.lastCall, now).compareTo(this.minTimeSincePrev) > 0) {
            block.run();
            Intrinsics.checkNotNullExpressionValue((Object)now, (String)"now");
            this.lastCall = now;
        }
    }
}


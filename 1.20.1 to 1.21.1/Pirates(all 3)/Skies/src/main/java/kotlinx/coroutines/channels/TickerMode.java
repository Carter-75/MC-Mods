/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.ObsoleteCoroutinesApi;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lkotlinx/coroutines/channels/TickerMode;", "", "<init>", "(Ljava/lang/String;I)V", "FIXED_PERIOD", "FIXED_DELAY", "kotlinx-coroutines-core"})
@ObsoleteCoroutinesApi
public final class TickerMode
extends Enum<TickerMode> {
    public static final /* enum */ TickerMode FIXED_PERIOD = new TickerMode();
    public static final /* enum */ TickerMode FIXED_DELAY = new TickerMode();
    private static final /* synthetic */ TickerMode[] $VALUES;

    public static TickerMode[] values() {
        return (TickerMode[])$VALUES.clone();
    }

    public static TickerMode valueOf(String value) {
        return Enum.valueOf(TickerMode.class, value);
    }

    static {
        $VALUES = tickerModeArray = new TickerMode[]{TickerMode.FIXED_PERIOD, TickerMode.FIXED_DELAY};
    }
}


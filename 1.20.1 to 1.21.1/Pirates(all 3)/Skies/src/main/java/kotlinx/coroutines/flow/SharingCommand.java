/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines.flow;

import kotlin.Metadata;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lkotlinx/coroutines/flow/SharingCommand;", "", "<init>", "(Ljava/lang/String;I)V", "START", "STOP", "STOP_AND_RESET_REPLAY_CACHE", "kotlinx-coroutines-core"})
public final class SharingCommand
extends Enum<SharingCommand> {
    public static final /* enum */ SharingCommand START = new SharingCommand();
    public static final /* enum */ SharingCommand STOP = new SharingCommand();
    public static final /* enum */ SharingCommand STOP_AND_RESET_REPLAY_CACHE = new SharingCommand();
    private static final /* synthetic */ SharingCommand[] $VALUES;

    public static SharingCommand[] values() {
        return (SharingCommand[])$VALUES.clone();
    }

    public static SharingCommand valueOf(String value) {
        return Enum.valueOf(SharingCommand.class, value);
    }

    static {
        $VALUES = sharingCommandArray = new SharingCommand[]{SharingCommand.START, SharingCommand.STOP, SharingCommand.STOP_AND_RESET_REPLAY_CACHE};
    }
}


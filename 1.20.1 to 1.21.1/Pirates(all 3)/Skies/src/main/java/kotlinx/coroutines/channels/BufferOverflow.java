/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlinx.coroutines.channels;

import kotlin.Metadata;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lkotlinx/coroutines/channels/BufferOverflow;", "", "<init>", "(Ljava/lang/String;I)V", "SUSPEND", "DROP_OLDEST", "DROP_LATEST", "kotlinx-coroutines-core"})
public final class BufferOverflow
extends Enum<BufferOverflow> {
    public static final /* enum */ BufferOverflow SUSPEND = new BufferOverflow();
    public static final /* enum */ BufferOverflow DROP_OLDEST = new BufferOverflow();
    public static final /* enum */ BufferOverflow DROP_LATEST = new BufferOverflow();
    private static final /* synthetic */ BufferOverflow[] $VALUES;

    public static BufferOverflow[] values() {
        return (BufferOverflow[])$VALUES.clone();
    }

    public static BufferOverflow valueOf(String value) {
        return Enum.valueOf(BufferOverflow.class, value);
    }

    static {
        $VALUES = bufferOverflowArray = new BufferOverflow[]{BufferOverflow.SUSPEND, BufferOverflow.DROP_OLDEST, BufferOverflow.DROP_LATEST};
    }
}


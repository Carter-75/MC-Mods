/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.world.connectivity;

import kotlin.Metadata;
import org.jetbrains.annotations.ApiStatus;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTED", "DISCONNECTED", "UNKNOWN", "api"})
@ApiStatus.Experimental
public final class ConnectionStatus
extends Enum<ConnectionStatus> {
    public static final /* enum */ ConnectionStatus CONNECTED = new ConnectionStatus();
    public static final /* enum */ ConnectionStatus DISCONNECTED = new ConnectionStatus();
    public static final /* enum */ ConnectionStatus UNKNOWN = new ConnectionStatus();
    private static final /* synthetic */ ConnectionStatus[] $VALUES;

    public static ConnectionStatus[] values() {
        return (ConnectionStatus[])$VALUES.clone();
    }

    public static ConnectionStatus valueOf(String value) {
        return Enum.valueOf(ConnectionStatus.class, value);
    }

    static {
        $VALUES = connectionStatusArray = new ConnectionStatus[]{ConnectionStatus.CONNECTED, ConnectionStatus.DISCONNECTED, ConnectionStatus.UNKNOWN};
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.hooks;

import kotlin.Metadata;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2={"Lorg/valkyrienskies/core/internal/hooks/VsiPlayState;", "", "<init>", "(Ljava/lang/String;I)V", "SERVERSIDE", "CLIENT_SINGLEPLAYER", "CLIENT_TITLESCREEN", "CLIENT_MULTIPLAYER", "internal"})
public final class VsiPlayState
extends Enum<VsiPlayState> {
    public static final /* enum */ VsiPlayState SERVERSIDE = new VsiPlayState();
    public static final /* enum */ VsiPlayState CLIENT_SINGLEPLAYER = new VsiPlayState();
    public static final /* enum */ VsiPlayState CLIENT_TITLESCREEN = new VsiPlayState();
    public static final /* enum */ VsiPlayState CLIENT_MULTIPLAYER = new VsiPlayState();
    private static final /* synthetic */ VsiPlayState[] $VALUES;

    public static VsiPlayState[] values() {
        return (VsiPlayState[])$VALUES.clone();
    }

    public static VsiPlayState valueOf(String value) {
        return Enum.valueOf(VsiPlayState.class, value);
    }

    static {
        $VALUES = vsiPlayStateArray = new VsiPlayState[]{VsiPlayState.SERVERSIDE, VsiPlayState.CLIENT_SINGLEPLAYER, VsiPlayState.CLIENT_TITLESCREEN, VsiPlayState.CLIENT_MULTIPLAYER};
    }
}


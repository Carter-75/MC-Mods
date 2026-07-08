/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.networking.simple;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.internal.world.VsiPlayer;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\t\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;", "", "", "receivedByClient", "()V", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "player", "receivedByServer", "(Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "internal"})
public interface SimplePacket {
    default public void receivedByClient() {
    }

    default public void receivedByServer(@NotNull VsiPlayer player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
    }
}


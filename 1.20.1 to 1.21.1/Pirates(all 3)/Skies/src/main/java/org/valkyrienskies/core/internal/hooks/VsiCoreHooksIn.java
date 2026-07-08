/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.hooks;

import io.netty.buffer.ByteBuf;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.internal.world.VsiPlayer;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0010\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksIn;", "", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "player", "", "afterClientJoinServer", "(Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "afterDisconnect", "()V", "Lio/netty/buffer/ByteBuf;", "buf", "onReceiveClient", "(Lio/netty/buffer/ByteBuf;)V", "sender", "onReceiveServer", "(Lio/netty/buffer/ByteBuf;Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "internal"})
public interface VsiCoreHooksIn {
    public void onReceiveServer(@NotNull ByteBuf var1, @NotNull VsiPlayer var2);

    public void onReceiveClient(@NotNull ByteBuf var1);

    public void afterDisconnect();

    public void afterClientJoinServer(@NotNull VsiPlayer var1);
}


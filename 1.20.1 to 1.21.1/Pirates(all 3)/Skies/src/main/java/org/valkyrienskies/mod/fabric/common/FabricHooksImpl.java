/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.loader.api.FabricLoader
 */
package org.valkyrienskies.mod.fabric.common;

import io.netty.buffer.ByteBuf;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.mod.common.hooks.CommonHooksImpl;
import org.valkyrienskies.mod.fabric.common.VSFabricNetworking;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2={"Lorg/valkyrienskies/mod/fabric/common/FabricHooksImpl;", "Lorg/valkyrienskies/mod/common/hooks/CommonHooksImpl;", "Lio/netty/buffer/ByteBuf;", "buf", "", "sendToServer", "(Lio/netty/buffer/ByteBuf;)V", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "player", "sendToClient", "(Lio/netty/buffer/ByteBuf;Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "Lorg/valkyrienskies/mod/fabric/common/VSFabricNetworking;", "networking", "Lorg/valkyrienskies/mod/fabric/common/VSFabricNetworking;", "", "isPhysicalClient", "()Z", "Ljava/nio/file/Path;", "getConfigDir", "()Ljava/nio/file/Path;", "configDir", "<init>", "(Lorg/valkyrienskies/mod/fabric/common/VSFabricNetworking;)V", "valkyrienskies-120"})
public final class FabricHooksImpl
extends CommonHooksImpl {
    @NotNull
    private final VSFabricNetworking networking;

    public FabricHooksImpl(@NotNull VSFabricNetworking networking) {
        Intrinsics.checkNotNullParameter((Object)networking, (String)"networking");
        this.networking = networking;
    }

    @Override
    public boolean isPhysicalClient() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
    }

    @Override
    @NotNull
    public Path getConfigDir() {
        Path path = FabricLoader.getInstance().getConfigDir().resolve("valkyrienskies");
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"resolve(...)");
        return path;
    }

    @Override
    public void sendToServer(@NotNull ByteBuf buf) {
        Intrinsics.checkNotNullParameter((Object)buf, (String)"buf");
        this.networking.sendToServer(buf);
    }

    @Override
    public void sendToClient(@NotNull ByteBuf buf, @NotNull VsiPlayer player) {
        Intrinsics.checkNotNullParameter((Object)buf, (String)"buf");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        this.networking.sendToClient(buf, player);
    }
}


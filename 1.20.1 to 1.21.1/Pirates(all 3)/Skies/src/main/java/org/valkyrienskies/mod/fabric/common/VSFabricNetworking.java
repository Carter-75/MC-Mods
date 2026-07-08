/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
 *  net.fabricmc.fabric.api.networking.v1.PacketSender
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.minecraft.class_1657
 *  net.minecraft.class_2540
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_3222
 *  net.minecraft.class_3244
 *  net.minecraft.class_634
 *  net.minecraft.server.MinecraftServer
 */
package org.valkyrienskies.mod.fabric.common;

import io.netty.buffer.ByteBuf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_1657;
import net.minecraft.class_2540;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3222;
import net.minecraft.class_3244;
import net.minecraft.class_634;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.internal.hooks.VsiCoreHooksIn;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.MinecraftPlayer;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\u0006J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2={"Lorg/valkyrienskies/mod/fabric/common/VSFabricNetworking;", "", "Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksIn;", "hooks", "", "registerClientNetworking", "(Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksIn;)V", "register", "Lio/netty/buffer/ByteBuf;", "data", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "player", "sendToClient", "(Lio/netty/buffer/ByteBuf;Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "sendToServer", "(Lio/netty/buffer/ByteBuf;)V", "", "isClient", "Z", "Lnet/minecraft/class_2960;", "VS_PACKET_ID", "Lnet/minecraft/class_2960;", "<init>", "(Z)V", "valkyrienskies-120"})
public final class VSFabricNetworking {
    private final boolean isClient;
    @NotNull
    private final class_2960 VS_PACKET_ID;

    public VSFabricNetworking(boolean isClient) {
        this.isClient = isClient;
        this.VS_PACKET_ID = new class_2960("valkyrienskies", "vs_packet");
    }

    private final void registerClientNetworking(VsiCoreHooksIn hooks) {
        ClientPlayNetworking.registerGlobalReceiver((class_2960)this.VS_PACKET_ID, (arg_0, arg_1, arg_2, arg_3) -> VSFabricNetworking.registerClientNetworking$lambda$0(hooks, arg_0, arg_1, arg_2, arg_3));
    }

    public final void register(@NotNull VsiCoreHooksIn hooks) {
        Intrinsics.checkNotNullParameter((Object)hooks, (String)"hooks");
        if (this.isClient) {
            this.registerClientNetworking(hooks);
        }
        ServerPlayNetworking.registerGlobalReceiver((class_2960)this.VS_PACKET_ID, (arg_0, arg_1, arg_2, arg_3, arg_4) -> VSFabricNetworking.register$lambda$1(hooks, arg_0, arg_1, arg_2, arg_3, arg_4));
    }

    public final void sendToClient(@NotNull ByteBuf data, @NotNull VsiPlayer player) {
        Intrinsics.checkNotNullParameter((Object)data, (String)"data");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        class_1657 class_16572 = ((MinecraftPlayer)player).getPlayer();
        Intrinsics.checkNotNull((Object)class_16572, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
        class_3222 serverPlayer = (class_3222)class_16572;
        ServerPlayNetworking.send((class_3222)serverPlayer, (class_2960)this.VS_PACKET_ID, (class_2540)new class_2540(data));
    }

    public final void sendToServer(@NotNull ByteBuf data) {
        Intrinsics.checkNotNullParameter((Object)data, (String)"data");
        ClientPlayNetworking.send((class_2960)this.VS_PACKET_ID, (class_2540)new class_2540(data));
    }

    private static final void registerClientNetworking$lambda$0(VsiCoreHooksIn $hooks, class_310 class_3102, class_634 class_6342, class_2540 buf, PacketSender packetSender) {
        Intrinsics.checkNotNullParameter((Object)$hooks, (String)"$hooks");
        Intrinsics.checkNotNull((Object)buf);
        $hooks.onReceiveClient((ByteBuf)buf);
    }

    private static final void register$lambda$1(VsiCoreHooksIn $hooks, MinecraftServer minecraftServer, class_3222 player, class_3244 class_32442, class_2540 buf, PacketSender packetSender) {
        Intrinsics.checkNotNullParameter((Object)$hooks, (String)"$hooks");
        Intrinsics.checkNotNull((Object)buf);
        ByteBuf byteBuf = (ByteBuf)buf;
        Intrinsics.checkNotNull((Object)player);
        MinecraftPlayer minecraftPlayer = VSGameUtilsKt.getPlayerWrapper((class_1657)player);
        Intrinsics.checkNotNullExpressionValue((Object)minecraftPlayer, (String)"<get-playerWrapper>(...)");
        $hooks.onReceiveServer(byteBuf, minecraftPlayer);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 */
package org.valkyrienskies.core.impl.networking.simple;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.event.RegisteredListener;
import org.valkyrienskies.core.impl.networking.simple.SimplePacket;
import org.valkyrienskies.core.internal.world.VsiPlayer;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J;\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\tH&\u00a2\u0006\u0004\b\f\u0010\rJA\u0010\u0010\u001a\u00020\u000b\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000eH&\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000fH&\u00a2\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00032\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0018\"\u00020\u000fH&\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\u001c\u0010\u0014J\u001b\u0010\u0006\u001a\u00020\u0005*\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0017\u00a2\u0006\u0004\b\u001d\u0010\u0007J7\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\b*\u00020\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\tH\u0017\u00a2\u0006\u0004\b\u001e\u0010\rJ=\u0010\u0010\u001a\u00020\u000b\"\b\b\u0000\u0010\b*\u00020\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000eH\u0017\u00a2\u0006\u0004\b\u001f\u0010\u0011J\u0013\u0010\u0013\u001a\u00020\u0005*\u00020\u0003H\u0017\u00a2\u0006\u0004\b \u0010\u0014J\u001b\u0010\u0016\u001a\u00020\u0005*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000fH\u0017\u00a2\u0006\u0004\b!\u0010\u0017J'\u0010\u001a\u001a\u00020\u0005*\u00020\u00032\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0018\"\u00020\u000fH\u0017\u00a2\u0006\u0004\b\"\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u0005*\u00020\u0003H\u0017\u00a2\u0006\u0004\b#\u0010\u0014\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006$\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "", "Lkotlin/reflect/KClass;", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;", "klass", "", "register", "(Lkotlin/reflect/KClass;)V", "T", "Lkotlin/Function1;", "handler", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "registerClientHandler", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "Lkotlin/Function2;", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "registerServerHandler", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function2;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "packet", "sendToAllClients", "(Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;)V", "player", "sendToClient", "(Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "", "players", "sendToClients", "(Lorg/valkyrienskies/core/impl/networking/simple/SimplePacket;[Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "sendToServer", "register1", "registerClientHandler1", "registerServerHandler1", "sendToAllClients1", "sendToClient1", "sendToClients1", "sendToServer1", "internal"})
public interface SimplePacketNetworking {
    @NotNull
    public <T extends SimplePacket> RegisteredListener registerServerHandler(@NotNull KClass<T> var1, @NotNull Function2<? super T, ? super VsiPlayer, Unit> var2);

    @NotNull
    public <T extends SimplePacket> RegisteredListener registerClientHandler(@NotNull KClass<T> var1, @NotNull Function1<? super T, Unit> var2);

    public void sendToServer(@NotNull SimplePacket var1);

    public void sendToClient(@NotNull SimplePacket var1, @NotNull VsiPlayer var2);

    public void sendToClients(@NotNull SimplePacket var1, VsiPlayer ... var2);

    public void sendToAllClients(@NotNull SimplePacket var1);

    public void register(@NotNull KClass<? extends SimplePacket> var1);

    @JvmName(name="registerServerHandler1")
    default public /* synthetic */ RegisteredListener registerServerHandler1(KClass $this$registerServerHandler, Function2 handler) {
        Intrinsics.checkNotNullParameter((Object)$this$registerServerHandler, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)handler, (String)"handler");
        return this.registerServerHandler($this$registerServerHandler, handler);
    }

    @JvmName(name="registerClientHandler1")
    default public /* synthetic */ RegisteredListener registerClientHandler1(KClass $this$registerClientHandler, Function1 handler) {
        Intrinsics.checkNotNullParameter((Object)$this$registerClientHandler, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)handler, (String)"handler");
        return this.registerClientHandler($this$registerClientHandler, handler);
    }

    @JvmName(name="sendToServer1")
    default public /* synthetic */ void sendToServer1(SimplePacket $this$sendToServer) {
        Intrinsics.checkNotNullParameter((Object)$this$sendToServer, (String)"<this>");
        this.sendToServer($this$sendToServer);
    }

    @JvmName(name="sendToClient1")
    default public /* synthetic */ void sendToClient1(SimplePacket $this$sendToClient, VsiPlayer player) {
        Intrinsics.checkNotNullParameter((Object)$this$sendToClient, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        this.sendToClient($this$sendToClient, player);
    }

    @JvmName(name="sendToClients1")
    default public /* synthetic */ void sendToClients1(SimplePacket $this$sendToClients, VsiPlayer ... players) {
        Intrinsics.checkNotNullParameter((Object)$this$sendToClients, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)players, (String)"players");
        this.sendToClients($this$sendToClients, Arrays.copyOf(players, players.length));
    }

    @JvmName(name="sendToAllClients1")
    default public /* synthetic */ void sendToAllClients1(SimplePacket $this$sendToAllClients) {
        Intrinsics.checkNotNullParameter((Object)$this$sendToAllClients, (String)"<this>");
        this.sendToAllClients($this$sendToAllClients);
    }

    @JvmName(name="register1")
    default public /* synthetic */ void register1(KClass $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"<this>");
        this.register((KClass<? extends SimplePacket>)$this$register);
    }
}


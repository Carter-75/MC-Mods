/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2596
 *  net.minecraft.class_2626
 *  net.minecraft.class_2637
 *  net.minecraft.class_2672
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 */
package org.valkyrienskies.mod.common.assembly;

import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2596;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_2672;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_638;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2i;
import org.valkyrienskies.core.api.events.ShipLoadEventClient;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.mod.api.ValkyrienSkies;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.networking.PacketRestartChunkUpdates;
import org.valkyrienskies.mod.common.networking.PacketStopChunkUpdates;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.mixinducks.feature.seamless_copy.SeamlessCopyClientPacketListenerDuck;
import org.valkyrienskies.mod.util.ClassLogger;
import org.valkyrienskies.mod.util.LoggingKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b&\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\u00042\u0010\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J1\u0010\r\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\r\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR*\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020\u001d\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u001e0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R*\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020!\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u001e0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2={"Lorg/valkyrienskies/mod/common/assembly/SeamlessChunksManager;", "", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "ship", "", "onShipLoad", "(Lorg/valkyrienskies/core/api/ships/ClientShip;)V", "Lorg/valkyrienskies/mod/common/networking/PacketRestartChunkUpdates;", "packet", "onRestartUpdates", "(Lorg/valkyrienskies/mod/common/networking/PacketRestartChunkUpdates;)V", "Ljava/util/Queue;", "Lnet/minecraft/class_2596;", "queue", "dispatchQueuedPackets", "(Ljava/util/Queue;)V", "cleanup", "()V", "", "chunkX", "chunkZ", "Lnet/minecraft/class_638;", "level", "", "(IILnet/minecraft/class_2596;Lnet/minecraft/class_638;)Z", "Lnet/minecraft/class_634;", "listener", "Lnet/minecraft/class_634;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "shipQueuedUpdates", "Ljava/util/concurrent/ConcurrentHashMap;", "Lnet/minecraft/class_1923;", "queuedUpdates", "Lit/unimi/dsi/fastutil/longs/LongOpenHashSet;", "stalledChunks", "Lit/unimi/dsi/fastutil/longs/LongOpenHashSet;", "<init>", "(Lnet/minecraft/class_634;)V", "Companion", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nSeamlessChunksManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SeamlessChunksManager.kt\norg/valkyrienskies/mod/common/assembly/SeamlessChunksManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Util.kt\norg/valkyrienskies/core/util/UtilKt\n*L\n1#1,138:1\n1863#2,2:139\n1863#2,2:143\n42#3,2:141\n*S KotlinDebug\n*F\n+ 1 SeamlessChunksManager.kt\norg/valkyrienskies/mod/common/assembly/SeamlessChunksManager\n*L\n73#1:139,2\n48#1:143,2\n85#1:141,2\n*E\n"})
public final class SeamlessChunksManager {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final class_634 listener;
    @NotNull
    private final ConcurrentHashMap<ChunkClaim, ConcurrentLinkedQueue<class_2596<?>>> shipQueuedUpdates;
    @NotNull
    private final ConcurrentHashMap<class_1923, ConcurrentLinkedQueue<class_2596<?>>> queuedUpdates;
    @NotNull
    private final LongOpenHashSet stalledChunks;
    @NotNull
    private static final Logger logger$delegate = LoggingKt.logger().provideDelegate-j8jxBIw(Companion, org.valkyrienskies.mod.common.assembly.SeamlessChunksManager$Companion.$$delegatedProperties[0]);

    public SeamlessChunksManager(@NotNull class_634 listener) {
        Intrinsics.checkNotNullParameter((Object)listener, (String)"listener");
        this.listener = listener;
        this.shipQueuedUpdates = new ConcurrentHashMap();
        this.queuedUpdates = new ConcurrentHashMap();
        this.stalledChunks = new LongOpenHashSet();
        SimplePacketNetworking $this$_init__u24lambda_u244 = VSGameUtilsKt.getVsCore().getSimplePacketNetworking();
        boolean bl = false;
        $this$_init__u24lambda_u244.registerClientHandler1(Reflection.getOrCreateKotlinClass(PacketStopChunkUpdates.class), arg_0 -> SeamlessChunksManager.lambda$4$lambda$1(this, arg_0));
        $this$_init__u24lambda_u244.registerClientHandler1(Reflection.getOrCreateKotlinClass(PacketRestartChunkUpdates.class), arg_0 -> SeamlessChunksManager.lambda$4$lambda$3(this, arg_0));
        ValkyrienSkies.api().getShipLoadEventClient().on(arg_0 -> SeamlessChunksManager._init_$lambda$6(arg_0 -> SeamlessChunksManager._init_$lambda$5(this, arg_0), arg_0));
    }

    private final void onShipLoad(ClientShip ship) {
        ConcurrentLinkedQueue<class_2596<?>> packets = this.shipQueuedUpdates.remove(ship.getChunkClaim());
        Collection collection = packets;
        if (!(collection == null || collection.isEmpty())) {
            SeamlessChunksManager.Companion.getLogger().debug("Executing " + packets.size() + " deferred updates for ship ID=" + ship.getId() + " at " + ship.getChunkClaim());
            this.dispatchQueuedPackets((Queue)packets);
        }
    }

    private final void onRestartUpdates(PacketRestartChunkUpdates packet) {
        List<Vector2i> chunks = packet.component1();
        Iterable $this$forEach$iv = chunks;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Vector2i p = (Vector2i)element$iv;
            boolean bl = false;
            class_1923 pos = VectorConversionsMCKt.toMinecraft(p);
            this.stalledChunks.remove(pos.method_8324());
            ConcurrentLinkedQueue<class_2596<?>> packets = this.queuedUpdates.remove(pos);
            Collection collection = packets;
            if (collection == null || collection.isEmpty()) continue;
            SeamlessChunksManager.Companion.getLogger().debug("Executing " + packets.size() + " deferred updates at <" + pos.field_9181 + ", " + pos.field_9180 + ">");
            this.dispatchQueuedPackets((Queue)packets);
        }
    }

    private final void dispatchQueuedPackets(Queue<class_2596<?>> queue) {
        Queue<class_2596<?>> $this$pollUntilEmpty$iv = queue;
        boolean $i$f$pollUntilEmpty = false;
        while ($this$pollUntilEmpty$iv.poll() != null) {
            class_2596<?> packet;
            boolean bl = false;
            class_2596<?> class_25962 = packet;
            if (class_25962 instanceof class_2626) {
                this.listener.method_11136((class_2626)packet);
                continue;
            }
            if (class_25962 instanceof class_2637) {
                this.listener.method_11100((class_2637)packet);
                continue;
            }
            if (class_25962 instanceof class_2672) {
                this.listener.method_11128((class_2672)packet);
                continue;
            }
            throw new IllegalStateException("Didn't know how to dispatch packet: " + Reflection.getOrCreateKotlinClass(packet.getClass()));
        }
    }

    public final void cleanup() {
        this.stalledChunks.clear();
        this.queuedUpdates.clear();
        this.shipQueuedUpdates.clear();
    }

    public final boolean queue(int chunkX, int chunkZ, @NotNull class_2596<?> packet, @NotNull class_638 level) {
        Intrinsics.checkNotNullParameter(packet, (String)"packet");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        if (VSGameUtilsKt.isChunkInShipyard((class_1937)level, chunkX, chunkZ) && VSGameUtilsKt.getShipManagingPos((class_1937)level, chunkX, chunkZ) == null) {
            SeamlessChunksManager.Companion.getLogger().debug("Deferring ship update at <" + chunkX + ", " + chunkZ + "> for " + Reflection.getOrCreateKotlinClass(packet.getClass()));
            this.shipQueuedUpdates.computeIfAbsent(VSGameUtilsKt.getVsCore().newChunkClaimFromChunkPos(chunkX, chunkZ), arg_0 -> SeamlessChunksManager.queue$lambda$10(SeamlessChunksManager::queue$lambda$9, arg_0)).add(packet);
            return true;
        }
        if (this.stalledChunks.contains(class_1923.method_8331((int)chunkX, (int)chunkZ))) {
            SeamlessChunksManager.Companion.getLogger().debug("Deferring update at <" + chunkX + ", " + chunkZ + "> for " + Reflection.getOrCreateKotlinClass(packet.getClass()));
            this.queuedUpdates.computeIfAbsent(new class_1923(chunkX, chunkZ), arg_0 -> SeamlessChunksManager.queue$lambda$12(SeamlessChunksManager::queue$lambda$11, arg_0)).add(packet);
            return true;
        }
        SeamlessChunksManager.Companion.getLogger().trace("Received update at <" + chunkX + ", " + chunkZ + "> for " + Reflection.getOrCreateKotlinClass(packet.getClass()));
        return false;
    }

    private static final Unit lambda$4$lambda$1(SeamlessChunksManager this$0, PacketStopChunkUpdates packetStopChunkUpdates) {
        Intrinsics.checkNotNullParameter((Object)this$0, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)packetStopChunkUpdates, (String)"<destruct>");
        List<Vector2i> chunks = packetStopChunkUpdates.component1();
        Iterable $this$forEach$iv = chunks;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Vector2i it = (Vector2i)element$iv;
            boolean bl = false;
            this$0.stalledChunks.add(VectorConversionsMCKt.toMinecraft(it).method_8324());
        }
        return Unit.INSTANCE;
    }

    private static final void lambda$4$lambda$3$lambda$2(SeamlessChunksManager this$0, PacketRestartChunkUpdates $packet) {
        Intrinsics.checkNotNullParameter((Object)this$0, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)$packet, (String)"$packet");
        this$0.onRestartUpdates($packet);
    }

    private static final Unit lambda$4$lambda$3(SeamlessChunksManager this$0, PacketRestartChunkUpdates packet) {
        Intrinsics.checkNotNullParameter((Object)this$0, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
        class_310.method_1551().execute(() -> SeamlessChunksManager.lambda$4$lambda$3$lambda$2(this$0, packet));
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$5(SeamlessChunksManager this$0, ShipLoadEventClient ev) {
        Intrinsics.checkNotNullParameter((Object)this$0, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)ev, (String)"ev");
        this$0.onShipLoad(ev.getShip());
        return Unit.INSTANCE;
    }

    private static final void _init_$lambda$6(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        $tmp0.invoke(p0);
    }

    private static final ConcurrentLinkedQueue queue$lambda$9(ChunkClaim it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new ConcurrentLinkedQueue();
    }

    private static final ConcurrentLinkedQueue queue$lambda$10(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        return (ConcurrentLinkedQueue)$tmp0.invoke(p0);
    }

    private static final ConcurrentLinkedQueue queue$lambda$11(class_1923 it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new ConcurrentLinkedQueue();
    }

    private static final ConcurrentLinkedQueue queue$lambda$12(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        return (ConcurrentLinkedQueue)$tmp0.invoke(p0);
    }

    @JvmStatic
    @Nullable
    public static final SeamlessChunksManager get() {
        return Companion.get();
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2={"Lorg/valkyrienskies/mod/common/assembly/SeamlessChunksManager$Companion;", "", "Lorg/valkyrienskies/mod/common/assembly/SeamlessChunksManager;", "get", "()Lorg/valkyrienskies/mod/common/assembly/SeamlessChunksManager;", "Lorg/apache/logging/log4j/Logger;", "logger$delegate", "Lorg/apache/logging/log4j/Logger;", "getLogger", "()Lorg/apache/logging/log4j/Logger;", "logger", "<init>", "()V", "valkyrienskies-120"})
    public static final class Companion {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;

        private Companion() {
        }

        private final Logger getLogger() {
            return ClassLogger.getValue-impl(logger$delegate, this, $$delegatedProperties[0]);
        }

        @JvmStatic
        @Nullable
        public final SeamlessChunksManager get() {
            class_634 class_6342 = class_310.method_1551().method_1562();
            SeamlessCopyClientPacketListenerDuck seamlessCopyClientPacketListenerDuck = class_6342 instanceof SeamlessCopyClientPacketListenerDuck ? (SeamlessCopyClientPacketListenerDuck)class_6342 : null;
            return seamlessCopyClientPacketListenerDuck != null ? seamlessCopyClientPacketListenerDuck.vs_getChunks() : null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        static {
            KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(Companion.class, "logger", "getLogger()Lorg/apache/logging/log4j/Logger;", 0)))};
            $$delegatedProperties = kPropertyArray;
        }
    }
}


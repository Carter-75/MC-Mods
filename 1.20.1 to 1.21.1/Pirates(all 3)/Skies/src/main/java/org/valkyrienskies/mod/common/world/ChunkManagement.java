/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  net.minecraft.class_1657
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2672
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_3898
 *  net.minecraft.server.MinecraftServer
 *  org.apache.commons.lang3.mutable.MutableObject
 */
package org.valkyrienskies.mod.common.world;

import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import net.minecraft.class_1657;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2672;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3898;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.lang3.mutable.MutableObject;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkUnwatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTasks;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.MinecraftPlayer;
import org.valkyrienskies.mod.mixin.accessors.server.level.ChunkMapAccessor;
import org.valkyrienskies.mod.util.ClassLogger;
import org.valkyrienskies.mod.util.LoggingKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2={"Lorg/valkyrienskies/mod/common/world/ChunkManagement;", "", "Lorg/valkyrienskies/core/internal/world/VsiServerShipWorld;", "shipWorld", "Lnet/minecraft/server/MinecraftServer;", "server", "", "tickChunkLoading", "(Lorg/valkyrienskies/core/internal/world/VsiServerShipWorld;Lnet/minecraft/server/MinecraftServer;)V", "Lorg/apache/logging/log4j/Logger;", "logger$delegate", "Lorg/apache/logging/log4j/Logger;", "getLogger", "()Lorg/apache/logging/log4j/Logger;", "logger", "<init>", "()V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nChunkManagement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChunkManagement.kt\norg/valkyrienskies/mod/common/world/ChunkManagement\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,73:1\n1863#2,2:74\n1863#2,2:76\n*S KotlinDebug\n*F\n+ 1 ChunkManagement.kt\norg/valkyrienskies/mod/common/world/ChunkManagement\n*L\n25#1:74,2\n51#1:76,2\n*E\n"})
public final class ChunkManagement {
    @NotNull
    public static final ChunkManagement INSTANCE;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private static final Logger logger$delegate;

    private ChunkManagement() {
    }

    @JvmStatic
    public static final void tickChunkLoading(@NotNull VsiServerShipWorld shipWorld, @NotNull MinecraftServer server) {
        class_3218 level;
        class_1923 chunkPos;
        Intrinsics.checkNotNullParameter((Object)shipWorld, (String)"shipWorld");
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        VsiChunkWatchTasks vsiChunkWatchTasks = shipWorld.getChunkWatchTasks();
        SortedSet chunkWatchTasks = vsiChunkWatchTasks.component1();
        SortedSet chunkUnwatchTasks = vsiChunkWatchTasks.component2();
        Iterable $this$forEach$iv = chunkWatchTasks;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            VsiChunkWatchTask chunkWatchTask = (VsiChunkWatchTask)element$iv;
            boolean bl = false;
            INSTANCE.getLogger().debug("Watch task for dimension " + chunkWatchTask.getDimensionId() + ": " + chunkWatchTask.getChunkX() + " : " + chunkWatchTask.getChunkZ());
            chunkPos = new class_1923(chunkWatchTask.getChunkX(), chunkWatchTask.getChunkZ());
            Intrinsics.checkNotNull((Object)VSGameUtilsKt.getLevelFromDimensionId(server, chunkWatchTask.getDimensionId()));
            level.method_14178().method_12124(chunkPos, true);
            MinecraftServer minecraftServer = level.method_8503();
            Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
            VSGameUtilsKt.executeIf(minecraftServer, (Function0<Boolean>)((Function0)() -> ChunkManagement.tickChunkLoading$lambda$2$lambda$0(level, chunkPos)), () -> ChunkManagement.tickChunkLoading$lambda$2$lambda$1(chunkWatchTask, level, chunkPos));
        }
        $this$forEach$iv = chunkUnwatchTasks;
        $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            VsiChunkUnwatchTask chunkUnwatchTask = (VsiChunkUnwatchTask)element$iv;
            boolean bl = false;
            INSTANCE.getLogger().debug("Unwatch task for dimension " + chunkUnwatchTask.getDimensionId() + ": " + chunkUnwatchTask.getChunkX() + " : " + chunkUnwatchTask.getChunkZ());
            chunkPos = new class_1923(chunkUnwatchTask.getChunkX(), chunkUnwatchTask.getChunkZ());
            if (chunkUnwatchTask.getShouldUnload()) {
                Intrinsics.checkNotNull((Object)VSGameUtilsKt.getLevelFromDimensionId(server, chunkUnwatchTask.getDimensionId()));
                level.method_14178().method_12124(chunkPos, false);
            }
            for (VsiPlayer player : chunkUnwatchTask.getPlayersNeedUnwatching()) {
                class_1657 class_16572 = VSGameUtilsKt.getMcPlayer(player);
                Intrinsics.checkNotNull((Object)class_16572, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
                ((class_3222)class_16572).method_14246(chunkPos);
            }
        }
        shipWorld.setExecutedChunkWatchTasks(chunkWatchTasks, chunkUnwatchTasks);
    }

    private final Logger getLogger() {
        return ClassLogger.getValue-impl(logger$delegate, this, $$delegatedProperties[0]);
    }

    private static final boolean tickChunkLoading$lambda$2$lambda$0(class_3218 $level, class_1923 $chunkPos) {
        Intrinsics.checkNotNullParameter((Object)$level, (String)"$level");
        Intrinsics.checkNotNullParameter((Object)$chunkPos, (String)"$chunkPos");
        return VSGameUtilsKt.isTickingChunk((class_1937)$level, $chunkPos);
    }

    private static final void tickChunkLoading$lambda$2$lambda$1(VsiChunkWatchTask $chunkWatchTask, class_3218 $level, class_1923 $chunkPos) {
        Intrinsics.checkNotNullParameter((Object)$chunkWatchTask, (String)"$chunkWatchTask");
        Intrinsics.checkNotNullParameter((Object)$level, (String)"$level");
        Intrinsics.checkNotNullParameter((Object)$chunkPos, (String)"$chunkPos");
        for (VsiPlayer player : $chunkWatchTask.getPlayersNeedWatching()) {
            Intrinsics.checkNotNull((Object)player, (String)"null cannot be cast to non-null type org.valkyrienskies.mod.common.util.MinecraftPlayer");
            MinecraftPlayer minecraftPlayer = (MinecraftPlayer)player;
            class_3222 serverPlayer = (class_3222)minecraftPlayer.getPlayerEntityReference().get();
            if (serverPlayer == null) continue;
            if (!Intrinsics.areEqual((Object)$chunkWatchTask.getDimensionId(), (Object)((MinecraftPlayer)player).getDimension())) {
                INSTANCE.getLogger().warn("Player received watch task for chunk in dimension that they are not also in!");
            }
            class_3898 class_38982 = $level.method_14178().field_17254;
            Intrinsics.checkNotNull((Object)class_38982, (String)"null cannot be cast to non-null type org.valkyrienskies.mod.mixin.accessors.server.level.ChunkMapAccessor");
            ChunkMapAccessor map2 = (ChunkMapAccessor)class_38982;
            map2.callUpdateChunkTracking(serverPlayer, $chunkPos, (MutableObject<class_2672>)new MutableObject(), false, true);
        }
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(ChunkManagement.class, "logger", "getLogger()Lorg/apache/logging/log4j/Logger;", 0)))};
        $$delegatedProperties = kPropertyArray;
        INSTANCE = new ChunkManagement();
        logger$delegate = LoggingKt.logger().provideDelegate-j8jxBIw(INSTANCE, $$delegatedProperties[0]);
    }
}


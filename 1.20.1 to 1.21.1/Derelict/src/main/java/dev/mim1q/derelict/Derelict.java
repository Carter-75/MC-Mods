/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.owo.itemgroup.OwoItemGroup
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.api.ModInitializer
 *  net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents
 *  net.fabricmc.fabric.api.networking.v1.PacketSender
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
 *  net.minecraft.class_1309
 *  net.minecraft.class_2960
 *  net.minecraft.class_3222
 *  net.minecraft.class_3244
 *  net.minecraft.server.MinecraftServer
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict;

import dev.mim1q.derelict.config.DerelictConfig;
import dev.mim1q.derelict.config.DerelictConfigs;
import dev.mim1q.derelict.init.ModBlockEntities;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import dev.mim1q.derelict.init.ModEntities;
import dev.mim1q.derelict.init.ModItemGroups;
import dev.mim1q.derelict.init.ModParticles;
import dev.mim1q.derelict.init.ModSounds;
import dev.mim1q.derelict.init.ModStatusEffects;
import dev.mim1q.derelict.init.component.ModCardinalComponents;
import dev.mim1q.derelict.init.worldgen.ModFeatures;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.class_1309;
import net.minecraft.class_2960;
import net.minecraft.class_3222;
import net.minecraft.class_3244;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0003J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001d"}, d2={"Ldev/mim1q/derelict/Derelict;", "Lnet/fabricmc/api/ModInitializer;", "<init>", "()V", "", "onInitialize", "setupEventListeners", "", "value", "Lnet/minecraft/class_2960;", "id", "(Ljava/lang/String;)Lnet/minecraft/class_2960;", "MOD_ID", "Ljava/lang/String;", "Lorg/apache/logging/log4j/Logger;", "LOGGER", "Lorg/apache/logging/log4j/Logger;", "getLOGGER", "()Lorg/apache/logging/log4j/Logger;", "Ldev/mim1q/derelict/config/DerelictConfig;", "CONFIG", "Ldev/mim1q/derelict/config/DerelictConfig;", "getCONFIG", "()Ldev/mim1q/derelict/config/DerelictConfig;", "Lio/wispforest/owo/itemgroup/OwoItemGroup;", "ITEM_GROUP", "Lio/wispforest/owo/itemgroup/OwoItemGroup;", "getITEM_GROUP", "()Lio/wispforest/owo/itemgroup/OwoItemGroup;", "derelict"})
public final class Derelict
implements ModInitializer {
    @NotNull
    public static final Derelict INSTANCE = new Derelict();
    @NotNull
    public static final String MOD_ID = "derelict";
    @NotNull
    private static final Logger LOGGER;
    @NotNull
    private static final DerelictConfig CONFIG;
    @NotNull
    private static final OwoItemGroup ITEM_GROUP;

    private Derelict() {
    }

    @NotNull
    public final Logger getLOGGER() {
        return LOGGER;
    }

    @NotNull
    public final DerelictConfig getCONFIG() {
        return CONFIG;
    }

    @NotNull
    public final OwoItemGroup getITEM_GROUP() {
        return ITEM_GROUP;
    }

    public void onInitialize() {
        LOGGER.info("Derelict initializing");
        CONFIG.save();
        ModBlocksAndItems.INSTANCE.init();
        ModBlockEntities.INSTANCE.init();
        ModEntities.INSTANCE.init();
        ModStatusEffects.INSTANCE.init();
        ModParticles.INSTANCE.init();
        ModSounds.INSTANCE.init();
        ModFeatures.INSTANCE.init();
        ModBlocksAndItems.INSTANCE.setupWaxableAndAgeable();
        this.setupEventListeners();
    }

    private final void setupEventListeners() {
        ServerPlayConnectionEvents.JOIN.register(Derelict::setupEventListeners$lambda$0);
        ServerPlayerEvents.COPY_FROM.register(Derelict::setupEventListeners$lambda$1);
    }

    @NotNull
    public final class_2960 id(@NotNull String value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        return new class_2960(MOD_ID, value);
    }

    private static final void setupEventListeners$lambda$0(class_3244 handler, PacketSender packetSender, MinecraftServer minecraftServer) {
        class_3222 class_32222 = handler.field_14140;
        Intrinsics.checkNotNullExpressionValue((Object)class_32222, (String)"player");
        ModCardinalComponents.INSTANCE.updateClientSyncedEffects((class_1309)class_32222);
    }

    private static final void setupEventListeners$lambda$1(class_3222 player, class_3222 class_32222, boolean bl) {
        Intrinsics.checkNotNull((Object)player);
        ModCardinalComponents.INSTANCE.updateClientSyncedEffects((class_1309)player);
    }

    static {
        Logger logger = LogManager.getLogger((String)MOD_ID);
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(...)");
        LOGGER = logger;
        DerelictConfig derelictConfig = DerelictConfigs.CONFIG;
        Intrinsics.checkNotNullExpressionValue((Object)((Object)derelictConfig), (String)"CONFIG");
        CONFIG = derelictConfig;
        ITEM_GROUP = ModItemGroups.INSTANCE.getITEM_GROUP$derelict();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.BoolArgumentType
 *  com.mojang.brigadier.arguments.DoubleArgumentType
 *  com.mojang.brigadier.arguments.IntegerArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.builder.RequiredArgumentBuilder
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2168
 *  net.minecraft.class_2170
 *  net.minecraft.class_2172
 *  net.minecraft.class_2246
 *  net.minecraft.class_2277
 *  net.minecraft.class_2338
 *  net.minecraft.class_239
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_3218
 *  net.minecraft.class_3965
 *  net.minecraft.class_5250
 *  net.minecraftforge.common.ForgeConfigSpec$ConfigValue
 */
package org.valkyrienskies.mod.common.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2168;
import net.minecraft.class_2170;
import net.minecraft.class_2172;
import net.minecraft.class_2246;
import net.minecraft.class_2277;
import net.minecraft.class_2338;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_3218;
import net.minecraft.class_3965;
import net.minecraft.class_5250;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.world.ServerShipWorld;
import org.valkyrienskies.core.api.world.ShipWorld;
import org.valkyrienskies.core.impl.api_impl.config.ConfigPhysicsBackendType;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.internal.ShipTeleportData;
import org.valkyrienskies.core.internal.VsiCore;
import org.valkyrienskies.mod.common.BlockStateInfo;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.command.RelativeVector3;
import org.valkyrienskies.mod.common.command.RelativeVector3Argument;
import org.valkyrienskies.mod.common.command.ShipArgument;
import org.valkyrienskies.mod.common.command.VSCommandsKt;
import org.valkyrienskies.mod.common.config.VSConfigUpdater;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.util.ClassLogger;
import org.valkyrienskies.mod.util.LoggingKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J%\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0007R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u00168\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0018R\u0014\u0010!\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0018R\u0014\u0010\"\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0018\u00a8\u0006%"}, d2={"Lorg/valkyrienskies/mod/common/command/VSCommands;", "", "Lcom/mojang/brigadier/CommandDispatcher;", "Lnet/minecraft/class_2168;", "dispatcher", "", "registerServerCommands", "(Lcom/mojang/brigadier/CommandDispatcher;)V", "Lcom/mojang/brigadier/context/CommandContext;", "context", "", "deleteBlocks", "", "deleteShip", "(Lcom/mojang/brigadier/context/CommandContext;Z)I", "registerClientCommands", "Lorg/apache/logging/log4j/Logger;", "LOGGER$delegate", "Lorg/apache/logging/log4j/Logger;", "getLOGGER", "()Lorg/apache/logging/log4j/Logger;", "LOGGER", "", "DELETED_SHIPS_MESSAGE", "Ljava/lang/String;", "REMASSED_SHIPS_SUCCESS_MESSAGE", "REMASSED_SHIP_FAIL_MESSAGE", "SET_SHIP_STATIC_SUCCESS_MESSAGE", "TELEPORT_SHIP_SUCCESS_MESSAGE", "GET_SHIP_SUCCESS_MESSAGE", "GET_SHIP_FAIL_MESSAGE", "VECTOR_ARG_FAIL_MESSAGE", "GET_SHIP_ONLY_USABLE_BY_ENTITIES_MESSAGE", "TELEPORTED_MULTIPLE_SHIPS_SUCCESS", "TELEPORT_FIRST_ARG_CAN_ONLY_INPUT_1_SHIP", "<init>", "()V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nVSCommands.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VSCommands.kt\norg/valkyrienskies/mod/common/command/VSCommands\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,487:1\n1863#2,2:488\n1863#2,2:490\n1863#2,2:492\n1863#2,2:494\n1863#2,2:496\n1863#2,2:498\n*S KotlinDebug\n*F\n+ 1 VSCommands.kt\norg/valkyrienskies/mod/common/command/VSCommands\n*L\n160#1:488,2\n186#1:490,2\n231#1:492,2\n264#1:494,2\n303#1:496,2\n348#1:498,2\n*E\n"})
public final class VSCommands {
    @NotNull
    public static final VSCommands INSTANCE;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private static final Logger LOGGER$delegate;
    @NotNull
    private static final String DELETED_SHIPS_MESSAGE = "command.valkyrienskies.delete.success";
    @NotNull
    private static final String REMASSED_SHIPS_SUCCESS_MESSAGE = "command.valkyrienskies.remass.success";
    @NotNull
    private static final String REMASSED_SHIP_FAIL_MESSAGE = "command.valkyrienskies.remass.fail";
    @NotNull
    private static final String SET_SHIP_STATIC_SUCCESS_MESSAGE = "command.valkyrienskies.set_static.success";
    @NotNull
    private static final String TELEPORT_SHIP_SUCCESS_MESSAGE = "command.valkyrienskies.teleport.success";
    @NotNull
    private static final String GET_SHIP_SUCCESS_MESSAGE = "command.valkyrienskies.get_ship.success";
    @NotNull
    private static final String GET_SHIP_FAIL_MESSAGE = "command.valkyrienskies.get_ship.fail";
    @NotNull
    public static final String VECTOR_ARG_FAIL_MESSAGE = "command.valkyrienskies.vector_arg.fail";
    @NotNull
    private static final String GET_SHIP_ONLY_USABLE_BY_ENTITIES_MESSAGE = "command.valkyrienskies.get_ship.only_usable_by_entities";
    @NotNull
    private static final String TELEPORTED_MULTIPLE_SHIPS_SUCCESS = "command.valkyrienskies.teleport.multiple_ship_success";
    @NotNull
    private static final String TELEPORT_FIRST_ARG_CAN_ONLY_INPUT_1_SHIP = "command.valkyrienskies.mc_teleport.can_only_teleport_to_one_ship";

    private VSCommands() {
    }

    private final Logger getLOGGER() {
        return ClassLogger.getValue-impl(LOGGER$delegate, this, $$delegatedProperties[0]);
    }

    public final void registerServerCommands(@NotNull CommandDispatcher<class_2168> dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, (String)"dispatcher");
        dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247((String)"vs").then(((LiteralArgumentBuilder)class_2170.method_9247((String)"get-ship").requires(VSCommands::registerServerCommands$lambda$0)).executes(VSCommands::registerServerCommands$lambda$1))).then(((LiteralArgumentBuilder)class_2170.method_9247((String)"delete").requires(VSCommands::registerServerCommands$lambda$2)).then(((RequiredArgumentBuilder)class_2170.method_9244((String)"ships", (ArgumentType)ShipArgument.Companion.ships()).executes(VSCommands::registerServerCommands$lambda$3)).then(class_2170.method_9244((String)"deleteBlocks", (ArgumentType)((ArgumentType)BoolArgumentType.bool())).executes(VSCommands::registerServerCommands$lambda$4))))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247((String)"backend").requires(VSCommands::registerServerCommands$lambda$5)).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247((String)"engine").then(class_2170.method_9247((String)"krunch").executes(VSCommands::registerServerCommands$lambda$6))).then(class_2170.method_9247((String)"DEFAULT").executes(VSCommands::registerServerCommands$lambda$7))).then(class_2170.method_9247((String)"physx").executes(VSCommands::registerServerCommands$lambda$8)))).then(class_2170.method_9247((String)"lodDetail").then(class_2170.method_9244((String)"amount", (ArgumentType)((ArgumentType)IntegerArgumentType.integer((int)0))).executes(VSCommands::registerServerCommands$lambda$9))))).then(((LiteralArgumentBuilder)class_2170.method_9247((String)"rename").requires(VSCommands::registerServerCommands$lambda$10)).then(class_2170.method_9244((String)"ship", (ArgumentType)ShipArgument.Companion.ships()).then(class_2170.method_9244((String)"newName", (ArgumentType)((ArgumentType)StringArgumentType.string())).executes(VSCommands::registerServerCommands$lambda$11))))).then(((LiteralArgumentBuilder)class_2170.method_9247((String)"remass").requires(VSCommands::registerServerCommands$lambda$12)).then(class_2170.method_9244((String)"ships", (ArgumentType)ShipArgument.Companion.ships()).executes(VSCommands::registerServerCommands$lambda$14)))).then(((LiteralArgumentBuilder)class_2170.method_9247((String)"set-static").requires(VSCommands::registerServerCommands$lambda$15)).then(class_2170.method_9244((String)"ships", (ArgumentType)ShipArgument.Companion.ships()).then(class_2170.method_9244((String)"is-static", (ArgumentType)((ArgumentType)BoolArgumentType.bool())).executes(VSCommands::registerServerCommands$lambda$17))))).then(((LiteralArgumentBuilder)class_2170.method_9247((String)"scale").requires(VSCommands::registerServerCommands$lambda$18)).then(class_2170.method_9244((String)"ship", (ArgumentType)ShipArgument.Companion.ships()).then(class_2170.method_9244((String)"newScale", (ArgumentType)((ArgumentType)DoubleArgumentType.doubleArg((double)0.001))).executes(VSCommands::registerServerCommands$lambda$19))))).then(((LiteralArgumentBuilder)class_2170.method_9247((String)"teleport").requires(VSCommands::registerServerCommands$lambda$20)).then(class_2170.method_9244((String)"ships", (ArgumentType)ShipArgument.Companion.ships()).then(((RequiredArgumentBuilder)class_2170.method_9244((String)"position", (ArgumentType)((ArgumentType)class_2277.method_9737())).executes(VSCommands::registerServerCommands$lambda$22)).then(((RequiredArgumentBuilder)class_2170.method_9244((String)"euler-angles", (ArgumentType)RelativeVector3Argument.Companion.relativeVector3()).executes(VSCommands::registerServerCommands$lambda$24)).then(((RequiredArgumentBuilder)class_2170.method_9244((String)"velocity", (ArgumentType)RelativeVector3Argument.Companion.relativeVector3()).executes(VSCommands::registerServerCommands$lambda$26)).then(class_2170.method_9244((String)"angular-velocity", (ArgumentType)RelativeVector3Argument.Companion.relativeVector3()).executes(VSCommands::registerServerCommands$lambda$28))))))));
    }

    public final int deleteShip(@NotNull CommandContext<class_2168> context, boolean deleteBlocks) {
        Intrinsics.checkNotNullParameter(context, (String)"context");
        List list = CollectionsKt.toList((Iterable)ShipArgument.Companion.getShips(context, "ships"));
        Intrinsics.checkNotNull((Object)list, (String)"null cannot be cast to non-null type kotlin.collections.List<org.valkyrienskies.core.api.ships.ServerShip>");
        List r = list;
        if (deleteBlocks) {
            block0: for (ServerShip ship : r) {
                int n2;
                AABBic aabb;
                int x;
                class_3218 level = ((class_2168)context.getSource()).method_9225();
                if (level == null || ship.getShipAABB() == null || (x = aabb.minX()) > (n2 = aabb.maxX())) continue;
                while (true) {
                    int n3;
                    int y;
                    if ((y = aabb.minY()) <= (n3 = aabb.maxY())) {
                        while (true) {
                            int n4;
                            int z;
                            if ((z = aabb.minZ()) <= (n4 = aabb.maxZ())) {
                                while (true) {
                                    level.method_8652(new class_2338(x, y, z), class_2246.field_10124.method_9564(), 2);
                                    if (z == n4) break;
                                    ++z;
                                }
                            }
                            if (y == n3) break;
                            ++y;
                        }
                    }
                    if (x == n2) continue block0;
                    ++x;
                }
            }
        }
        VsiCore vsiCore = VSGameUtilsKt.getVsCore();
        Object object = context.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        ShipWorld shipWorld = VSCommandsKt.getShipWorld((class_2172)object);
        Intrinsics.checkNotNull((Object)shipWorld, (String)"null cannot be cast to non-null type org.valkyrienskies.core.api.world.ServerShipWorld");
        vsiCore.deleteShips((ServerShipWorld)shipWorld, r);
        Object object2 = context.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"getSource(...)");
        class_2172 class_21722 = (class_2172)object2;
        Object[] objectArray = new Object[]{r.size()};
        class_5250 class_52502 = class_2561.method_43469((String)DELETED_SHIPS_MESSAGE, (Object[])objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)class_52502, (String)"translatable(...)");
        VSCommandsKt.sendVSMessage(class_21722, (class_2561)class_52502);
        return r.size();
    }

    public static /* synthetic */ int deleteShip$default(VSCommands vSCommands, CommandContext commandContext, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        return vSCommands.deleteShip((CommandContext<class_2168>)commandContext, bl);
    }

    public final void registerClientCommands(@NotNull CommandDispatcher<class_2168> dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, (String)"dispatcher");
    }

    private static final boolean registerServerCommands$lambda$0(class_2168 it) {
        return it.method_9259(VSGameConfig.SERVER.getCommands().getGetShipCommandPerms());
    }

    private static final int registerServerCommands$lambda$1(CommandContext it) {
        int n2;
        CommandContext mcCommandContext = it;
        boolean success = false;
        class_1297 sourceEntity = ((class_2168)mcCommandContext.getSource()).method_9228();
        if (sourceEntity != null) {
            class_239 rayTrace = sourceEntity.method_5745(10.0, 1.0f, false);
            if (rayTrace instanceof class_3965) {
                class_1937 class_19372 = sourceEntity.method_37908();
                class_2338 class_23382 = ((class_3965)rayTrace).method_17777();
                Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"getBlockPos(...)");
                Ship ship = VSGameUtilsKt.getShipManagingPos(class_19372, class_23382);
                if (ship != null) {
                    Object object = it.getSource();
                    Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
                    class_2172 class_21722 = (class_2172)object;
                    Object[] objectArray = new Object[]{ship.getSlug(), ship.getId()};
                    class_5250 class_52502 = class_2561.method_43469((String)GET_SHIP_SUCCESS_MESSAGE, (Object[])objectArray);
                    Intrinsics.checkNotNullExpressionValue((Object)class_52502, (String)"translatable(...)");
                    VSCommandsKt.sendVSMessage(class_21722, (class_2561)class_52502);
                    success = true;
                }
            }
            if (success) {
                n2 = 1;
            } else {
                Object object = it.getSource();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
                class_2172 class_21723 = (class_2172)object;
                class_5250 class_52503 = class_2561.method_43471((String)GET_SHIP_FAIL_MESSAGE);
                Intrinsics.checkNotNullExpressionValue((Object)class_52503, (String)"translatable(...)");
                VSCommandsKt.sendVSMessage(class_21723, (class_2561)class_52503);
                n2 = 0;
            }
        } else {
            Object object = it.getSource();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
            class_2172 class_21724 = (class_2172)object;
            class_5250 class_52504 = class_2561.method_43471((String)GET_SHIP_ONLY_USABLE_BY_ENTITIES_MESSAGE);
            Intrinsics.checkNotNullExpressionValue((Object)class_52504, (String)"translatable(...)");
            VSCommandsKt.sendVSMessage(class_21724, (class_2561)class_52504);
            n2 = 0;
        }
        return n2;
    }

    private static final boolean registerServerCommands$lambda$2(class_2168 it) {
        return it.method_9259(VSGameConfig.SERVER.getCommands().getDeleteShipCommandPerms());
    }

    private static final int registerServerCommands$lambda$3(CommandContext it) {
        Intrinsics.checkNotNull((Object)it);
        return VSCommands.deleteShip$default(INSTANCE, it, false, 2, null);
    }

    private static final int registerServerCommands$lambda$4(CommandContext it) {
        Intrinsics.checkNotNull((Object)it);
        return INSTANCE.deleteShip((CommandContext<class_2168>)it, BoolArgumentType.getBool((CommandContext)it, (String)"deleteBlocks"));
    }

    private static final boolean registerServerCommands$lambda$5(class_2168 it) {
        return it.method_9259(VSGameConfig.SERVER.getCommands().getChangeBackendCommandPerms());
    }

    private static final int registerServerCommands$lambda$6(CommandContext it) {
        VSCoreConfig.SERVER.getPhysics().setPhysicsBackend(ConfigPhysicsBackendType.KRUNCH_CLASSIC);
        ForgeConfigSpec.ConfigValue<?> configValue = VSConfigUpdater.getForgeConfigValuesMap().get("physicsBackend");
        Intrinsics.checkNotNull(configValue, (String)"null cannot be cast to non-null type net.minecraftforge.common.ForgeConfigSpec.ConfigValue<kotlin.String>");
        configValue.set((Object)"KRUNCH_CLASSIC");
        return 1;
    }

    private static final int registerServerCommands$lambda$7(CommandContext it) {
        VSCoreConfig.SERVER.getPhysics().setPhysicsBackend(ConfigPhysicsBackendType.KRUNCH_CLASSIC);
        ForgeConfigSpec.ConfigValue<?> configValue = VSConfigUpdater.getForgeConfigValuesMap().get("physicsBackend");
        Intrinsics.checkNotNull(configValue, (String)"null cannot be cast to non-null type net.minecraftforge.common.ForgeConfigSpec.ConfigValue<kotlin.String>");
        configValue.set((Object)"KRUNCH_CLASSIC");
        return 1;
    }

    private static final int registerServerCommands$lambda$8(CommandContext it) {
        VSCoreConfig.SERVER.getPhysics().setPhysicsBackend(ConfigPhysicsBackendType.KRUNCH_PHYSX);
        ForgeConfigSpec.ConfigValue<?> configValue = VSConfigUpdater.getForgeConfigValuesMap().get("physicsBackend");
        Intrinsics.checkNotNull(configValue, (String)"null cannot be cast to non-null type net.minecraftforge.common.ForgeConfigSpec.ConfigValue<kotlin.String>");
        configValue.set((Object)"KRUNCH_PHYSX");
        return 1;
    }

    private static final int registerServerCommands$lambda$9(CommandContext it) {
        int amount = IntegerArgumentType.getInteger((CommandContext)it, (String)"amount");
        VSCoreConfig.SERVER.getPhysics().setLodDetail(amount);
        ForgeConfigSpec.ConfigValue<?> configValue = VSConfigUpdater.getForgeConfigValuesMap().get("lodDetail");
        Intrinsics.checkNotNull(configValue, (String)"null cannot be cast to non-null type net.minecraftforge.common.ForgeConfigSpec.ConfigValue<kotlin.Int>");
        configValue.set((Object)amount);
        return 1;
    }

    private static final boolean registerServerCommands$lambda$10(class_2168 it) {
        return it.method_9259(VSGameConfig.SERVER.getCommands().getRenameShipCommandPerms());
    }

    private static final int registerServerCommands$lambda$11(CommandContext it) {
        VsiCore vsiCore = VSGameUtilsKt.getVsCore();
        Intrinsics.checkNotNull((Object)it);
        Ship ship = ShipArgument.Companion.getShip((CommandContext<class_2168>)it, "ship");
        Intrinsics.checkNotNull((Object)ship, (String)"null cannot be cast to non-null type org.valkyrienskies.core.api.ships.ServerShip");
        ServerShip serverShip = (ServerShip)ship;
        String string = StringArgumentType.getString((CommandContext)it, (String)"newName");
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getString(...)");
        vsiCore.renameShip(serverShip, string);
        return 1;
    }

    private static final boolean registerServerCommands$lambda$12(class_2168 it) {
        return it.method_9259(VSGameConfig.SERVER.getCommands().getRemassShipCommandPerms());
    }

    private static final int registerServerCommands$lambda$14(CommandContext it) {
        Intrinsics.checkNotNull((Object)it);
        List list = CollectionsKt.toList((Iterable)ShipArgument.Companion.getShips((CommandContext<class_2168>)it, "ships"));
        Intrinsics.checkNotNull((Object)list, (String)"null cannot be cast to non-null type kotlin.collections.List<org.valkyrienskies.core.api.ships.ServerShip>");
        List r = list;
        int successful = 0;
        Iterable $this$forEach$iv = r;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerShip ship = (ServerShip)element$iv;
            boolean bl = false;
            class_3218 class_32182 = ((class_2168)it.getSource()).method_9225();
            Intrinsics.checkNotNullExpressionValue((Object)class_32182, (String)"getLevel(...)");
            if (BlockStateInfo.INSTANCE.remassShip((class_1937)class_32182, ship)) {
                ++successful;
                continue;
            }
            Object object = it.getSource();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
            class_2172 class_21722 = (class_2172)object;
            Object[] objectArray = new Object[]{ship.getSlug()};
            class_5250 class_52502 = class_2561.method_43469((String)REMASSED_SHIP_FAIL_MESSAGE, (Object[])objectArray);
            Intrinsics.checkNotNullExpressionValue((Object)class_52502, (String)"translatable(...)");
            VSCommandsKt.sendVSMessage(class_21722, (class_2561)class_52502);
        }
        Object object = it.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        class_2172 class_21723 = (class_2172)object;
        Object[] objectArray = new Object[]{successful};
        class_5250 class_52503 = class_2561.method_43469((String)REMASSED_SHIPS_SUCCESS_MESSAGE, (Object[])objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)class_52503, (String)"translatable(...)");
        VSCommandsKt.sendVSMessage(class_21723, (class_2561)class_52503);
        return successful;
    }

    private static final boolean registerServerCommands$lambda$15(class_2168 it) {
        return it.method_9259(VSGameConfig.SERVER.getCommands().getSetStaticShipCommandPerms());
    }

    private static final int registerServerCommands$lambda$17(CommandContext it) {
        Intrinsics.checkNotNull((Object)it);
        List list = CollectionsKt.toList((Iterable)ShipArgument.Companion.getShips((CommandContext<class_2168>)it, "ships"));
        Intrinsics.checkNotNull((Object)list, (String)"null cannot be cast to non-null type kotlin.collections.List<org.valkyrienskies.core.api.ships.ServerShip>");
        List r = list;
        boolean isStatic = BoolArgumentType.getBool((CommandContext)it, (String)"is-static");
        Iterable $this$forEach$iv = r;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerShip ship = (ServerShip)element$iv;
            boolean bl = false;
            ship.setStatic(isStatic);
        }
        Object object = it.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        class_2172 class_21722 = (class_2172)object;
        Object[] objectArray = new Object[]{r.size(), isStatic ? "true" : "false"};
        class_5250 class_52502 = class_2561.method_43469((String)SET_SHIP_STATIC_SUCCESS_MESSAGE, (Object[])objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)class_52502, (String)"translatable(...)");
        VSCommandsKt.sendVSMessage(class_21722, (class_2561)class_52502);
        return r.size();
    }

    private static final boolean registerServerCommands$lambda$18(class_2168 it) {
        return it.method_9259(VSGameConfig.SERVER.getCommands().getScaleShipCommandPerms());
    }

    private static final int registerServerCommands$lambda$19(CommandContext it) {
        VsiCore vsiCore = VSGameUtilsKt.getVsCore();
        Object object = it.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        ShipWorld shipWorld = VSCommandsKt.getShipWorld((class_2172)object);
        Intrinsics.checkNotNull((Object)shipWorld, (String)"null cannot be cast to non-null type org.valkyrienskies.core.api.world.ServerShipWorld");
        ServerShipWorld serverShipWorld = (ServerShipWorld)shipWorld;
        Intrinsics.checkNotNull((Object)it);
        Ship ship = ShipArgument.Companion.getShip((CommandContext<class_2168>)it, "ship");
        Intrinsics.checkNotNull((Object)ship, (String)"null cannot be cast to non-null type org.valkyrienskies.core.api.ships.ServerShip");
        vsiCore.scaleShip(serverShipWorld, (ServerShip)ship, DoubleArgumentType.getDouble((CommandContext)it, (String)"newScale"));
        return 1;
    }

    private static final boolean registerServerCommands$lambda$20(class_2168 it) {
        return it.method_9259(VSGameConfig.SERVER.getCommands().getTeleportShipCommandPerms());
    }

    private static final int registerServerCommands$lambda$22(CommandContext it) {
        Intrinsics.checkNotNull((Object)it);
        List list = CollectionsKt.toList((Iterable)ShipArgument.Companion.getShips((CommandContext<class_2168>)it, "ships"));
        Intrinsics.checkNotNull((Object)list, (String)"null cannot be cast to non-null type kotlin.collections.List<org.valkyrienskies.core.api.ships.ServerShip>");
        List r = list;
        class_243 position = class_2277.method_9736((CommandContext)it, (String)"position");
        class_3218 class_32182 = ((class_2168)it.getSource()).method_9225();
        Intrinsics.checkNotNullExpressionValue((Object)class_32182, (String)"getLevel(...)");
        String dimensionId = VSGameUtilsKt.getDimensionId((class_1937)class_32182);
        VsiCore vsiCore = VSGameUtilsKt.getVsCore();
        Intrinsics.checkNotNull((Object)position);
        ShipTeleportData shipTeleportData = VsiCore.newShipTeleportData$default(vsiCore, VectorConversionsMCKt.toJOML(position), null, null, null, dimensionId, null, null, 110, null);
        Iterable $this$forEach$iv = r;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerShip ship = (ServerShip)element$iv;
            boolean bl = false;
            VsiCore vsiCore2 = VSGameUtilsKt.getVsCore();
            Object object = it.getSource();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
            ShipWorld shipWorld = VSCommandsKt.getShipWorld((class_2172)object);
            Intrinsics.checkNotNull((Object)shipWorld, (String)"null cannot be cast to non-null type org.valkyrienskies.core.api.world.ServerShipWorld");
            vsiCore2.teleportShip((ServerShipWorld)shipWorld, ship, shipTeleportData);
        }
        Object object = it.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        class_2172 class_21722 = (class_2172)object;
        Object[] objectArray = new Object[]{r.size(), shipTeleportData.toString()};
        class_5250 class_52502 = class_2561.method_43469((String)TELEPORT_SHIP_SUCCESS_MESSAGE, (Object[])objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)class_52502, (String)"translatable(...)");
        VSCommandsKt.sendVSMessage(class_21722, (class_2561)class_52502);
        return r.size();
    }

    private static final int registerServerCommands$lambda$24(CommandContext it) {
        Intrinsics.checkNotNull((Object)it);
        List list = CollectionsKt.toList((Iterable)ShipArgument.Companion.getShips((CommandContext<class_2168>)it, "ships"));
        Intrinsics.checkNotNull((Object)list, (String)"null cannot be cast to non-null type kotlin.collections.List<org.valkyrienskies.core.api.ships.ServerShip>");
        List r = list;
        class_243 position = class_2277.method_9736((CommandContext)it, (String)"position");
        RelativeVector3 eulerAngles = RelativeVector3Argument.Companion.getRelativeVector3((CommandContext<class_2168>)it, "euler-angles");
        class_2168 source = (class_2168)it.getSource();
        class_3218 class_32182 = ((class_2168)it.getSource()).method_9225();
        Intrinsics.checkNotNullExpressionValue((Object)class_32182, (String)"getLevel(...)");
        String dimensionId = VSGameUtilsKt.getDimensionId((class_1937)class_32182);
        VsiCore vsiCore = VSGameUtilsKt.getVsCore();
        Intrinsics.checkNotNull((Object)position);
        ShipTeleportData shipTeleportData = VsiCore.newShipTeleportData$default(vsiCore, VectorConversionsMCKt.toJOML(position), eulerAngles.toEulerRotationFromMCEntity(source.method_9210().field_1343, source.method_9210().field_1342), null, null, dimensionId, null, null, 108, null);
        Iterable $this$forEach$iv = r;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerShip ship = (ServerShip)element$iv;
            boolean bl = false;
            VsiCore vsiCore2 = VSGameUtilsKt.getVsCore();
            Object object = it.getSource();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
            ShipWorld shipWorld = VSCommandsKt.getShipWorld((class_2172)object);
            Intrinsics.checkNotNull((Object)shipWorld, (String)"null cannot be cast to non-null type org.valkyrienskies.core.api.world.ServerShipWorld");
            vsiCore2.teleportShip((ServerShipWorld)shipWorld, ship, shipTeleportData);
        }
        Object object = it.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        class_2172 class_21722 = (class_2172)object;
        Object[] objectArray = new Object[]{r.size(), shipTeleportData.toString()};
        class_5250 class_52502 = class_2561.method_43469((String)TELEPORT_SHIP_SUCCESS_MESSAGE, (Object[])objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)class_52502, (String)"translatable(...)");
        VSCommandsKt.sendVSMessage(class_21722, (class_2561)class_52502);
        return r.size();
    }

    private static final int registerServerCommands$lambda$26(CommandContext it) {
        Intrinsics.checkNotNull((Object)it);
        List list = CollectionsKt.toList((Iterable)ShipArgument.Companion.getShips((CommandContext<class_2168>)it, "ships"));
        Intrinsics.checkNotNull((Object)list, (String)"null cannot be cast to non-null type kotlin.collections.List<org.valkyrienskies.core.api.ships.ServerShip>");
        List r = list;
        class_243 position = class_2277.method_9736((CommandContext)it, (String)"position");
        RelativeVector3 eulerAngles = RelativeVector3Argument.Companion.getRelativeVector3((CommandContext<class_2168>)it, "euler-angles");
        RelativeVector3 velocity = RelativeVector3Argument.Companion.getRelativeVector3((CommandContext<class_2168>)it, "velocity");
        class_2168 source = (class_2168)it.getSource();
        class_3218 class_32182 = ((class_2168)it.getSource()).method_9225();
        Intrinsics.checkNotNullExpressionValue((Object)class_32182, (String)"getLevel(...)");
        String dimensionId = VSGameUtilsKt.getDimensionId((class_1937)class_32182);
        VsiCore vsiCore = VSGameUtilsKt.getVsCore();
        Intrinsics.checkNotNull((Object)position);
        ShipTeleportData shipTeleportData = VsiCore.newShipTeleportData$default(vsiCore, VectorConversionsMCKt.toJOML(position), eulerAngles.toEulerRotationFromMCEntity(source.method_9210().field_1343, source.method_9210().field_1342), velocity.toVector3d(0.0, 0.0, 0.0), null, dimensionId, null, null, 104, null);
        Iterable $this$forEach$iv = r;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerShip ship = (ServerShip)element$iv;
            boolean bl = false;
            VsiCore vsiCore2 = VSGameUtilsKt.getVsCore();
            Object object = it.getSource();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
            ShipWorld shipWorld = VSCommandsKt.getShipWorld((class_2172)object);
            Intrinsics.checkNotNull((Object)shipWorld, (String)"null cannot be cast to non-null type org.valkyrienskies.core.api.world.ServerShipWorld");
            vsiCore2.teleportShip((ServerShipWorld)shipWorld, ship, shipTeleportData);
        }
        Object object = it.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        class_2172 class_21722 = (class_2172)object;
        Object[] objectArray = new Object[]{r.size(), shipTeleportData.toString()};
        class_5250 class_52502 = class_2561.method_43469((String)TELEPORT_SHIP_SUCCESS_MESSAGE, (Object[])objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)class_52502, (String)"translatable(...)");
        VSCommandsKt.sendVSMessage(class_21722, (class_2561)class_52502);
        return r.size();
    }

    private static final int registerServerCommands$lambda$28(CommandContext it) {
        Intrinsics.checkNotNull((Object)it);
        List list = CollectionsKt.toList((Iterable)ShipArgument.Companion.getShips((CommandContext<class_2168>)it, "ships"));
        Intrinsics.checkNotNull((Object)list, (String)"null cannot be cast to non-null type kotlin.collections.List<org.valkyrienskies.core.api.ships.ServerShip>");
        List r = list;
        class_243 position = class_2277.method_9736((CommandContext)it, (String)"position");
        RelativeVector3 eulerAngles = RelativeVector3Argument.Companion.getRelativeVector3((CommandContext<class_2168>)it, "euler-angles");
        RelativeVector3 velocity = RelativeVector3Argument.Companion.getRelativeVector3((CommandContext<class_2168>)it, "velocity");
        RelativeVector3 angularVelocity = RelativeVector3Argument.Companion.getRelativeVector3((CommandContext<class_2168>)it, "angular-velocity");
        class_2168 source = (class_2168)it.getSource();
        class_3218 class_32182 = ((class_2168)it.getSource()).method_9225();
        Intrinsics.checkNotNullExpressionValue((Object)class_32182, (String)"getLevel(...)");
        String dimensionId = VSGameUtilsKt.getDimensionId((class_1937)class_32182);
        VsiCore vsiCore = VSGameUtilsKt.getVsCore();
        Intrinsics.checkNotNull((Object)position);
        ShipTeleportData shipTeleportData = VsiCore.newShipTeleportData$default(vsiCore, VectorConversionsMCKt.toJOML(position), eulerAngles.toEulerRotationFromMCEntity(source.method_9210().field_1343, source.method_9210().field_1342), velocity.toVector3d(0.0, 0.0, 0.0), angularVelocity.toVector3d(0.0, 0.0, 0.0), dimensionId, null, null, 96, null);
        Iterable $this$forEach$iv = r;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerShip ship = (ServerShip)element$iv;
            boolean bl = false;
            VsiCore vsiCore2 = VSGameUtilsKt.getVsCore();
            Object object = it.getSource();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
            ShipWorld shipWorld = VSCommandsKt.getShipWorld((class_2172)object);
            Intrinsics.checkNotNull((Object)shipWorld, (String)"null cannot be cast to non-null type org.valkyrienskies.core.api.world.ServerShipWorld");
            vsiCore2.teleportShip((ServerShipWorld)shipWorld, ship, shipTeleportData);
        }
        Object object = it.getSource();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getSource(...)");
        class_2172 class_21722 = (class_2172)object;
        Object[] objectArray = new Object[]{r.size(), shipTeleportData.toString()};
        class_5250 class_52502 = class_2561.method_43469((String)TELEPORT_SHIP_SUCCESS_MESSAGE, (Object[])objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)class_52502, (String)"translatable(...)");
        VSCommandsKt.sendVSMessage(class_21722, (class_2561)class_52502);
        return r.size();
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(VSCommands.class, "LOGGER", "getLOGGER()Lorg/apache/logging/log4j/Logger;", 0)))};
        $$delegatedProperties = kPropertyArray;
        INSTANCE = new VSCommands();
        LOGGER$delegate = LoggingKt.logger().provideDelegate-j8jxBIw(INSTANCE, $$delegatedProperties[0]);
    }
}


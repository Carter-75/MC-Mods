/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_7923
 */
package org.valkyrienskies.mod.common.networking;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_7923;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.attachment.AttachmentHolder;
import org.valkyrienskies.core.api.event.RegisteredListener;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.mod.api.SeatedControllingPlayer;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.entity.ShipMountingEntity;
import org.valkyrienskies.mod.common.entity.handling.VSEntityHandler;
import org.valkyrienskies.mod.common.entity.handling.VSEntityManager;
import org.valkyrienskies.mod.common.networking.PacketEntityShipMotion;
import org.valkyrienskies.mod.common.networking.PacketMobShipRotation;
import org.valkyrienskies.mod.common.networking.PacketPlayerDriving;
import org.valkyrienskies.mod.common.networking.PacketPlayerShipMotion;
import org.valkyrienskies.mod.common.networking.PacketRestartChunkUpdates;
import org.valkyrienskies.mod.common.networking.PacketStopChunkUpdates;
import org.valkyrienskies.mod.common.networking.PacketSyncVSEntityTypes;
import org.valkyrienskies.mod.common.util.EntityLerper;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;
import org.valkyrienskies.mod.common.util.MinecraftPlayer;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.mixinducks.world.entity.PlayerDuck;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2={"Lorg/valkyrienskies/mod/common/networking/VSGamePackets;", "", "", "register", "()V", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "registerHandlers", "()Lorg/valkyrienskies/core/api/event/RegisteredListener;", "<init>", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nVSGamePackets.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VSGamePackets.kt\norg/valkyrienskies/mod/common/networking/VSGamePackets\n+ 2 AttachmentHolder.kt\norg/valkyrienskies/core/api/attachment/AttachmentHolderKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,256:1\n66#2:257\n1#3:258\n216#4,2:259\n*S KotlinDebug\n*F\n+ 1 VSGamePackets.kt\norg/valkyrienskies/mod/common/networking/VSGamePackets\n*L\n48#1:257\n61#1:259,2\n*E\n"})
public final class VSGamePackets {
    @NotNull
    public static final VSGamePackets INSTANCE = new VSGamePackets();

    private VSGamePackets() {
    }

    public final void register() {
        SimplePacketNetworking $this$register_u24lambda_u240 = VSGameUtilsKt.getVsCore().getSimplePacketNetworking();
        boolean bl = false;
        $this$register_u24lambda_u240.register1(Reflection.getOrCreateKotlinClass(PacketPlayerDriving.class));
        $this$register_u24lambda_u240.register1(Reflection.getOrCreateKotlinClass(PacketStopChunkUpdates.class));
        $this$register_u24lambda_u240.register1(Reflection.getOrCreateKotlinClass(PacketRestartChunkUpdates.class));
        $this$register_u24lambda_u240.register1(Reflection.getOrCreateKotlinClass(PacketSyncVSEntityTypes.class));
        $this$register_u24lambda_u240.register1(Reflection.getOrCreateKotlinClass(PacketEntityShipMotion.class));
        $this$register_u24lambda_u240.register1(Reflection.getOrCreateKotlinClass(PacketMobShipRotation.class));
        $this$register_u24lambda_u240.register1(Reflection.getOrCreateKotlinClass(PacketPlayerShipMotion.class));
    }

    @NotNull
    public final RegisteredListener registerHandlers() {
        SimplePacketNetworking $this$registerHandlers_u24lambda_u2410 = VSGameUtilsKt.getVsCore().getSimplePacketNetworking();
        boolean bl = false;
        $this$registerHandlers_u24lambda_u2410.registerServerHandler1(Reflection.getOrCreateKotlinClass(PacketPlayerDriving.class), VSGamePackets::registerHandlers$lambda$10$lambda$2);
        $this$registerHandlers_u24lambda_u2410.registerClientHandler1(Reflection.getOrCreateKotlinClass(PacketSyncVSEntityTypes.class), VSGamePackets::registerHandlers$lambda$10$lambda$5);
        $this$registerHandlers_u24lambda_u2410.registerClientHandler1(Reflection.getOrCreateKotlinClass(PacketEntityShipMotion.class), VSGamePackets::registerHandlers$lambda$10$lambda$6);
        $this$registerHandlers_u24lambda_u2410.registerClientHandler1(Reflection.getOrCreateKotlinClass(PacketMobShipRotation.class), VSGamePackets::registerHandlers$lambda$10$lambda$7);
        $this$registerHandlers_u24lambda_u2410.registerServerHandler1(Reflection.getOrCreateKotlinClass(PacketPlayerShipMotion.class), VSGamePackets::registerHandlers$lambda$10$lambda$8);
        return $this$registerHandlers_u24lambda_u2410.registerServerHandler1(Reflection.getOrCreateKotlinClass(PacketEntityShipMotion.class), VSGamePackets::registerHandlers$lambda$10$lambda$9);
    }

    private static final Unit registerHandlers$lambda$10$lambda$2(PacketPlayerDriving driving, VsiPlayer iPlayer) {
        Intrinsics.checkNotNullParameter((Object)driving, (String)"driving");
        Intrinsics.checkNotNullParameter((Object)iPlayer, (String)"iPlayer");
        class_1657 class_16572 = ((MinecraftPlayer)iPlayer).getPlayer();
        Intrinsics.checkNotNull((Object)class_16572, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
        class_3222 player = (class_3222)class_16572;
        class_1297 class_12972 = player.method_5854();
        ShipMountingEntity shipMountingEntity = class_12972 instanceof ShipMountingEntity ? (ShipMountingEntity)class_12972 : null;
        if (shipMountingEntity == null) {
            return Unit.INSTANCE;
        }
        ShipMountingEntity seat = shipMountingEntity;
        if (seat.isController()) {
            class_1937 class_19372 = seat.method_37908();
            class_2338 class_23382 = seat.method_24515();
            Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"blockPosition(...)");
            LoadedShip loadedShip = VSGameUtilsKt.getLoadedShipManagingPos(class_19372, (class_2382)class_23382);
            LoadedServerShip loadedServerShip = loadedShip instanceof LoadedServerShip ? (LoadedServerShip)loadedShip : null;
            if (loadedServerShip == null) {
                return Unit.INSTANCE;
            }
            LoadedServerShip ship = loadedServerShip;
            AttachmentHolder $this$getAttachment$iv = ship;
            boolean $i$f$getAttachment = false;
            SeatedControllingPlayer seatedControllingPlayer = $this$getAttachment$iv.getAttachment(SeatedControllingPlayer.class);
            if (seatedControllingPlayer == null) {
                SeatedControllingPlayer seatedControllingPlayer2;
                class_2350 class_23502 = seat.method_5735().method_10153();
                Intrinsics.checkNotNullExpressionValue((Object)class_23502, (String)"getOpposite(...)");
                SeatedControllingPlayer $this$registerHandlers_u24lambda_u2410_u24lambda_u242_u24lambda_u241 = seatedControllingPlayer2 = new SeatedControllingPlayer(class_23502);
                boolean bl = false;
                ship.setAttachment($this$registerHandlers_u24lambda_u2410_u24lambda_u242_u24lambda_u241);
                seatedControllingPlayer = seatedControllingPlayer2;
            }
            SeatedControllingPlayer attachment = seatedControllingPlayer;
            attachment.setForwardImpulse(driving.getImpulse().z);
            attachment.setLeftImpulse(driving.getImpulse().x);
            attachment.setUpImpulse(driving.getImpulse().y);
            attachment.setSprintOn(driving.getSprint());
            attachment.setCruise(driving.getCruise());
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit registerHandlers$lambda$10$lambda$5(PacketSyncVSEntityTypes syncEntities) {
        Intrinsics.checkNotNullParameter((Object)syncEntities, (String)"syncEntities");
        Map<Integer, String> $this$forEach$iv = syncEntities.getEntity2Handler();
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<Integer, String>> iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Object object;
            class_1299 class_12992;
            VSEntityManager vSEntityManager;
            block4: {
                String handler;
                block3: {
                    void it;
                    Map.Entry<Integer, String> element$iv;
                    Map.Entry<Integer, String> entry = element$iv = iterator2.next();
                    boolean bl = false;
                    int id = ((Number)entry.getKey()).intValue();
                    handler = entry.getValue();
                    vSEntityManager = VSEntityManager.INSTANCE;
                    Object object2 = class_7923.field_41177.method_10200(id);
                    Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"byId(...)");
                    class_12992 = (class_1299)object2;
                    object = class_2960.method_12829((String)handler);
                    if (object == null) break block3;
                    class_2960 class_29602 = object;
                    class_1299 class_12993 = class_12992;
                    VSEntityManager vSEntityManager2 = vSEntityManager;
                    boolean bl2 = false;
                    VSEntityHandler vSEntityHandler = VSEntityManager.INSTANCE.getHandler((class_2960)it);
                    vSEntityManager = vSEntityManager2;
                    class_12992 = class_12993;
                    VSEntityHandler vSEntityHandler2 = vSEntityHandler;
                    object = vSEntityHandler2;
                    if (vSEntityHandler2 != null) break block4;
                }
                throw new IllegalStateException("No handler: " + handler);
            }
            vSEntityManager.pair(class_12992, (VSEntityHandler)object);
        }
        return Unit.INSTANCE;
    }

    private static final Unit registerHandlers$lambda$10$lambda$6(PacketEntityShipMotion setMotion) {
        block14: {
            ClientShip ship;
            class_1297 entity;
            block16: {
                block15: {
                    class_638 level;
                    block13: {
                        block12: {
                            Intrinsics.checkNotNullParameter((Object)setMotion, (String)"setMotion");
                            class_310 mc = class_310.method_1551();
                            class_638 class_6382 = mc.field_1687;
                            if (class_6382 == null) {
                                return Unit.INSTANCE;
                            }
                            level = class_6382;
                            class_1297 class_12972 = level.method_8469(setMotion.getEntityID());
                            if (class_12972 == null) {
                                return Unit.INSTANCE;
                            }
                            entity = class_12972;
                            if (entity.method_5787()) break block12;
                            class_746 class_7462 = mc.field_1724;
                            boolean bl = class_7462 != null ? class_7462.method_5628() == entity.method_5628() : false;
                            if (!bl) break block13;
                        }
                        return Unit.INSTANCE;
                    }
                    if (entity instanceof IEntityDraggingInformationProvider) {
                        ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setLastShipStoodOnServerWriteOnly(setMotion.getShipID() != -1L ? Long.valueOf(setMotion.getShipID()) : null);
                    }
                    if ((ship = (ClientShip)VSGameUtilsKt.getShipObjectWorld(level).getAllShips().getById(setMotion.getShipID())) == null) {
                        if (entity instanceof IEntityDraggingInformationProvider) {
                            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setLastShipStoodOn(null);
                        }
                        return Unit.INSTANCE;
                    }
                    if (!(entity instanceof IEntityDraggingInformationProvider)) break block14;
                    if (((IEntityDraggingInformationProvider)entity).getDraggingInformation().getLastShipStoodOn() == null) break block15;
                    Long l2 = ((IEntityDraggingInformationProvider)entity).getDraggingInformation().getLastShipStoodOn();
                    long l3 = setMotion.getShipID();
                    if (l2 != null && l2 == l3) break block16;
                }
                ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setLastShipStoodOn(setMotion.getShipID() != -1L ? Long.valueOf(setMotion.getShipID()) : null);
                ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setIgnoreNextGroundStand(true);
            }
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setShouldImpulseMovement(false);
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setTicksSinceLastServerPacket(0);
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setRelativePositionOnShip(ship.getWorldToShip().transformPosition(new Vector3d(entity.method_23317(), entity.method_23318(), entity.method_23321())));
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setPreviousRelativeVelocityOnShip(((IEntityDraggingInformationProvider)entity).getDraggingInformation().getRelativeVelocityOnShip());
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setRelativeYawOnShip(EntityLerper.INSTANCE.yawToShip(ship, entity.method_36454()));
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setLerpPositionOnShip(new Vector3d(setMotion.getX(), setMotion.getY(), setMotion.getZ()));
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setRelativeVelocityOnShip(new Vector3d(setMotion.getXVel(), setMotion.getYVel(), setMotion.getZVel()));
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setLerpYawOnShip(setMotion.getYRot());
            Vector3d previousWorldPosition = ((IEntityDraggingInformationProvider)entity).getDraggingInformation().getRelativePositionOnShip() != null ? ship.getRenderTransform().getShipToWorld().transformPosition(new Vector3d(((IEntityDraggingInformationProvider)entity).getDraggingInformation().getRelativePositionOnShip())) : new Vector3d(entity.method_23317(), entity.method_23318(), entity.method_23321());
            Vector3d worldPosition = ship.getTransform().getShipToWorld().transformPosition(new Vector3d(setMotion.getX(), setMotion.getY(), setMotion.getZ()));
            entity.method_43391(worldPosition.x, worldPosition.y, worldPosition.z);
            Vector3d worldVelocity = ship.getTransform().getShipToWorld().transformDirection(new Vector3d(setMotion.getXVel(), setMotion.getYVel(), setMotion.getZVel()));
            entity.method_18800(worldVelocity.x, worldVelocity.y, worldVelocity.z);
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setLerpSteps(3);
            if (!(entity instanceof class_1309)) {
                entity.method_5814(previousWorldPosition.x, previousWorldPosition.y, previousWorldPosition.z);
                entity.method_5759(worldPosition.x, worldPosition.y, worldPosition.z, (float)Math.toDegrees(setMotion.getYRot()), (float)Math.toDegrees(setMotion.getXRot()), 3, true);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit registerHandlers$lambda$10$lambda$7(PacketMobShipRotation setRotation) {
        block9: {
            ClientShip ship;
            class_1297 entity;
            block11: {
                block10: {
                    Intrinsics.checkNotNullParameter((Object)setRotation, (String)"setRotation");
                    class_310 class_3102 = class_310.method_1551();
                    if (class_3102 == null) {
                        return Unit.INSTANCE;
                    }
                    class_310 mc = class_3102;
                    class_638 class_6382 = mc.field_1687;
                    if (class_6382 == null) {
                        return Unit.INSTANCE;
                    }
                    class_638 level = class_6382;
                    class_1297 class_12972 = level.method_8469(setRotation.getEntityID());
                    if (class_12972 == null) {
                        return Unit.INSTANCE;
                    }
                    entity = class_12972;
                    if (entity.method_5787() || entity instanceof class_746) {
                        return Unit.INSTANCE;
                    }
                    if (entity instanceof IEntityDraggingInformationProvider) {
                        ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setLastShipStoodOnServerWriteOnly(setRotation.getShipID() != -1L ? Long.valueOf(setRotation.getShipID()) : null);
                    }
                    ClientShip clientShip = (ClientShip)VSGameUtilsKt.getShipObjectWorld(level).getAllShips().getById(setRotation.getShipID());
                    if (clientShip == null) {
                        return Unit.INSTANCE;
                    }
                    ship = clientShip;
                    if (!(entity instanceof IEntityDraggingInformationProvider)) break block9;
                    if (((IEntityDraggingInformationProvider)entity).getDraggingInformation().getLastShipStoodOn() == null) break block10;
                    Long l2 = ((IEntityDraggingInformationProvider)entity).getDraggingInformation().getLastShipStoodOn();
                    long l3 = setRotation.getShipID();
                    if (l2 != null && l2 == l3) break block11;
                }
                ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setLastShipStoodOn(setRotation.getShipID() != -1L ? Long.valueOf(setRotation.getShipID()) : null);
                ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setIgnoreNextGroundStand(true);
            }
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setRelativeHeadYawOnShip(EntityLerper.INSTANCE.yawToShip(ship, entity.method_5791()));
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setLerpHeadYawOnShip(setRotation.getYaw());
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setRelativePitchOnShip(Double.valueOf(entity.method_36455()));
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setLerpPitchOnShip(setRotation.getPitch());
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setHeadLerpSteps(3);
        }
        return Unit.INSTANCE;
    }

    private static final Unit registerHandlers$lambda$10$lambda$8(PacketPlayerShipMotion motion, VsiPlayer iPlayer) {
        block8: {
            class_3222 player;
            block10: {
                block9: {
                    Intrinsics.checkNotNullParameter((Object)motion, (String)"motion");
                    Intrinsics.checkNotNullParameter((Object)iPlayer, (String)"iPlayer");
                    class_3222 class_32222 = (class_3222)((MinecraftPlayer)iPlayer).getPlayer();
                    if (class_32222 == null) {
                        return Unit.INSTANCE;
                    }
                    player = class_32222;
                    if (!(player instanceof IEntityDraggingInformationProvider)) break block8;
                    if (((IEntityDraggingInformationProvider)player).getDraggingInformation().getLastShipStoodOn() == null) break block9;
                    Long l2 = ((IEntityDraggingInformationProvider)player).getDraggingInformation().getLastShipStoodOn();
                    long l3 = motion.getShipID();
                    if (l2 != null && l2 == l3) break block10;
                }
                ((IEntityDraggingInformationProvider)player).getDraggingInformation().setLastShipStoodOn(motion.getShipID() != -1L ? Long.valueOf(motion.getShipID()) : null);
            }
            ((IEntityDraggingInformationProvider)player).getDraggingInformation().setServerRelativePlayerPosition(new Vector3d(motion.getX(), motion.getY(), motion.getZ()));
            if (player.method_37908() != null) {
                class_1937 class_19372 = player.method_37908();
                Intrinsics.checkNotNull((Object)class_19372, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerLevel");
                class_3218 sLevel = (class_3218)class_19372;
                ServerShip ship = (ServerShip)VSGameUtilsKt.getShipObjectWorld(sLevel).getAllShips().getById(motion.getShipID());
                if (ship != null) {
                    Vector3d vector3d = ship.getShipToWorld().transformPosition(new Vector3d(motion.getX(), motion.getY(), motion.getZ()), new Vector3d());
                    Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"transformPosition(...)");
                    class_243 posUpdate = VectorConversionsMCKt.toMinecraft(vector3d);
                    if (((PlayerDuck)player).vs_handledMovePacket()) {
                        player.method_5814(posUpdate.field_1352, posUpdate.field_1351, posUpdate.field_1350);
                        ((PlayerDuck)player).vs_setHandledMovePacket(false);
                    } else {
                        ((PlayerDuck)player).vs_setQueuedPositionUpdate(posUpdate);
                    }
                }
            }
            ((IEntityDraggingInformationProvider)player).getDraggingInformation().setServerRelativePlayerYaw(motion.getYRot());
        }
        return Unit.INSTANCE;
    }

    private static final Unit registerHandlers$lambda$10$lambda$9(PacketEntityShipMotion motion, VsiPlayer iPlayer) {
        block5: {
            class_1297 entity;
            class_3222 player;
            block7: {
                block6: {
                    Intrinsics.checkNotNullParameter((Object)motion, (String)"motion");
                    Intrinsics.checkNotNullParameter((Object)iPlayer, (String)"iPlayer");
                    class_1657 class_16572 = ((MinecraftPlayer)iPlayer).getPlayer();
                    Intrinsics.checkNotNull((Object)class_16572, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
                    player = (class_3222)class_16572;
                    class_1297 class_12972 = player.method_37908().method_8469(motion.getEntityID());
                    if (class_12972 == null) {
                        return Unit.INSTANCE;
                    }
                    entity = class_12972;
                    if (!(entity instanceof IEntityDraggingInformationProvider)) break block5;
                    if (((IEntityDraggingInformationProvider)entity).getDraggingInformation().getLastShipStoodOn() == null) break block6;
                    Long l2 = ((IEntityDraggingInformationProvider)entity).getDraggingInformation().getLastShipStoodOn();
                    long l3 = motion.getShipID();
                    if (l2 != null && l2 == l3) break block7;
                }
                ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setLastShipStoodOn(motion.getShipID() != -1L ? Long.valueOf(motion.getShipID()) : null);
                ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setIgnoreNextGroundStand(true);
            }
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setRelativePositionOnShip(new Vector3d(motion.getX(), motion.getY(), motion.getZ()));
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setRelativeYawOnShip(motion.getYRot());
            class_1937 class_19372 = player.method_37908();
            Intrinsics.checkNotNull((Object)class_19372, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerLevel");
            if (VSGameUtilsKt.getShipObjectWorld((class_3218)class_19372).getAllShips().getById(motion.getShipID()) != null) {
                entity.method_33574(VSGameUtilsKt.toWorldCoordinates(player.method_37908(), new class_243(motion.getX(), motion.getY(), motion.getZ())));
            }
        }
        return Unit.INSTANCE;
    }
}


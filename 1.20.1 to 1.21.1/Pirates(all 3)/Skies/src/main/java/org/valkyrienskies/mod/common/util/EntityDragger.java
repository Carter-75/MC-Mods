/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_3222
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_746
 */
package org.valkyrienskies.mod.common.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3222;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_746;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.mod.api.ValkyrienSkies;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.entity.handling.VSEntityManager;
import org.valkyrienskies.mod.common.util.EntityDraggingInformation;
import org.valkyrienskies.mod.common.util.EntityLerper;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u00020\n*\u00020\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\r*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\r*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ7\u0010$\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\r2\u0006\u0010#\u001a\u00020\"H\u0002\u00a2\u0006\u0004\b$\u0010%J9\u0010'\u001a\u00020&2\b\u0010 \u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\r2\u0006\u0010#\u001a\u00020\"H\u0002\u00a2\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0003H\u0007\u00a2\u0006\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00060"}, d2={"Lorg/valkyrienskies/mod/common/util/EntityDragger;", "", "", "Lnet/minecraft/class_1297;", "entities", "", "preTick", "", "dragEntitiesWithShips", "(Ljava/lang/Iterable;Z)V", "Lnet/minecraft/class_243;", "serversideEyePosition", "(Lnet/minecraft/class_1297;)Lnet/minecraft/class_243;", "", "serversideEyeRotation", "(Lnet/minecraft/class_1297;)D", "default", "serversideEyePositionOrDefault", "(Lnet/minecraft/class_1297;Lnet/minecraft/class_243;)Lnet/minecraft/class_243;", "serversideEyeRotationOrDefault", "(Lnet/minecraft/class_1297;D)D", "Lorg/valkyrienskies/core/api/ships/Ship;", "ship", "serversideWorldEyeRotationOrDefault", "(Lnet/minecraft/class_1297;Lorg/valkyrienskies/core/api/ships/Ship;D)D", "vec3", "Lnet/minecraft/class_1657;", "player", "Lnet/minecraft/class_1937;", "cLevel", "backOff", "(Lnet/minecraft/class_243;Lorg/valkyrienskies/core/api/ships/Ship;Lnet/minecraft/class_1657;Lnet/minecraft/class_1937;)Lnet/minecraft/class_243;", "level", "step", "Lnet/minecraft/class_2350;", "dir", "isValidWalkablePosition", "(Lnet/minecraft/class_1937;Lorg/valkyrienskies/core/api/ships/Ship;Lnet/minecraft/class_1657;DLnet/minecraft/class_2350;)Z", "Lnet/minecraft/class_3959;", "stepTowardsEdge", "(Lnet/minecraft/class_1937;Lorg/valkyrienskies/core/api/ships/Ship;Lnet/minecraft/class_1657;DLnet/minecraft/class_2350;)Lnet/minecraft/class_3959;", "entity", "isDraggable", "(Lnet/minecraft/class_1297;)Z", "ADDED_MOVEMENT_DECAY", "D", "<init>", "()V", "valkyrienskies-120"})
public final class EntityDragger {
    @NotNull
    public static final EntityDragger INSTANCE = new EntityDragger();
    private static final double ADDED_MOVEMENT_DECAY = 0.9;

    private EntityDragger() {
    }

    public final void dragEntitiesWithShips(@NotNull Iterable<? extends class_1297> entities, boolean preTick) {
        Intrinsics.checkNotNullParameter(entities, (String)"entities");
        for (class_1297 class_12972 : entities) {
            double shipData22;
            Intrinsics.checkNotNull((Object)class_12972, (String)"null cannot be cast to non-null type org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider");
            EntityDraggingInformation entityDraggingInformation = ((IEntityDraggingInformationProvider)class_12972).getDraggingInformation();
            boolean dragTheEntity = false;
            Vector3dc addedMovement = null;
            double addedYRot = 0.0;
            Long shipDraggingEntity = entityDraggingInformation.getLastShipStoodOn();
            if (shipDraggingEntity != null && class_12972.method_5854() == null && EntityDragger.isDraggable(class_12972)) {
                if (entityDraggingInformation.isEntityBeingDraggedByAShip()) {
                    Object shipData22 = VSGameUtilsKt.getShipObjectWorld(class_12972.method_37908()).getAllShips().getById(shipDraggingEntity);
                    if (shipData22 != null) {
                        double newYRotAsDegrees;
                        double addedYRotFromDragging;
                        dragTheEntity = true;
                        Vector3dc entityReferencePos = preTick ? (Vector3dc)new Vector3d(class_12972.method_23317(), class_12972.method_23318(), class_12972.method_23321()) : (Vector3dc)new Vector3d(class_12972.field_6014, class_12972.field_6036, class_12972.field_5969);
                        ShipTransform referenceTransform = shipData22 instanceof ClientShip ? ((ClientShip)shipData22).getTransform() : shipData22.getTransform();
                        Vector3d vector3d = referenceTransform.getShipToWorld().transformPosition(shipData22.getPrevTickTransform().getWorldToShip().transformPosition(new Vector3d(entityReferencePos)));
                        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"transformPosition(...)");
                        Vector3dc newPosIdeal = vector3d;
                        addedMovement = newPosIdeal.sub(entityReferencePos, new Vector3d());
                        double yViewRot = class_12972.method_36454();
                        Vector3d entityLookYawOnly = new Vector3d(Math.sin(-Math.toRadians(yViewRot)), 0.0, Math.cos(-Math.toRadians(yViewRot)));
                        Vector3d newLookIdeal = referenceTransform.getShipToWorld().transformDirection(shipData22.getPrevTickTransform().getWorldToShip().transformDirection(entityLookYawOnly));
                        double newXRot = Math.asin(-newLookIdeal.y());
                        double xRotCos = Math.cos(newXRot);
                        double newYRot = -Math.atan2(newLookIdeal.x() / xRotCos, newLookIdeal.z() / xRotCos);
                        double entityYRotCorrected = (double)class_12972.method_36454() % 360.0;
                        if (entityYRotCorrected <= -180.0) {
                            entityYRotCorrected += 360.0;
                        }
                        if (entityYRotCorrected >= 180.0) {
                            entityYRotCorrected -= 360.0;
                        }
                        if ((addedYRotFromDragging = (newYRotAsDegrees = Math.toDegrees(newYRot)) - entityYRotCorrected) <= -180.0) {
                            addedYRotFromDragging += 360.0;
                        }
                        if (addedYRotFromDragging >= 180.0) {
                            addedYRotFromDragging -= 360.0;
                        }
                        addedYRot = addedYRotFromDragging;
                    }
                } else {
                    addedMovement = new Vector3d(entityDraggingInformation.getAddedMovementLastTick());
                    addedYRot = 0.0;
                }
            }
            if (dragTheEntity && addedMovement != null && addedMovement.isFinite() && !Double.isInfinite(shipData22 = addedYRot) && !Double.isNaN(shipData22)) {
                class_238 newBB = class_12972.method_5829().method_997(ValkyrienSkies.toMinecraft(addedMovement));
                class_12972.method_5857(newBB);
                class_12972.method_5814(class_12972.method_23317() + addedMovement.x(), class_12972.method_23318() + addedMovement.y(), class_12972.method_23321() + addedMovement.z());
                if (entityDraggingInformation.getShouldImpulseMovement() && (!class_12972.method_37908().field_9236 || class_12972 instanceof class_746)) {
                    Vector3d acceleration = new Vector3d(entityDraggingInformation.getAddedMovementLastTick()).sub(addedMovement);
                    class_12972.method_5762(acceleration.x, acceleration.y, acceleration.z);
                }
                entityDraggingInformation.setAddedMovementLastTick(addedMovement);
                double d2 = addedYRot;
                if (!Double.isInfinite(d2) && !Double.isNaN(d2)) {
                    if (!class_12972.method_37908().method_8608()) {
                        if (!(class_12972 instanceof class_3222)) {
                            class_12972.method_36456((class_12972.method_36454() + (float)addedYRot + 360.0f) % 360.0f);
                            class_12972.method_5847((class_12972.method_5791() + (float)addedYRot + 360.0f) % 360.0f);
                            if (class_12972 instanceof class_1309) {
                                ((class_1309)class_12972).field_6283 = (((class_1309)class_12972).field_6283 + (float)addedYRot + 360.0f) % 360.0f;
                            }
                        } else {
                            class_12972.method_36456(class_3532.method_15393((float)(class_12972.method_36454() + (float)addedYRot)));
                            ((class_3222)class_12972).field_6241 = class_3532.method_15393((float)(((class_3222)class_12972).field_6241 + (float)addedYRot));
                            ((class_3222)class_12972).field_6283 = class_3532.method_15393((float)(((class_3222)class_12972).field_6283 + (float)addedYRot));
                        }
                    } else if (!class_12972.method_5787() && !(class_12972 instanceof class_1657)) {
                        class_12972.method_36456(class_3532.method_15393((float)(class_12972.method_36454() + (float)addedYRot)));
                        class_12972.method_5847(class_3532.method_15393((float)(class_12972.method_5791() + (float)addedYRot)));
                        if (class_12972 instanceof class_1309) {
                            ((class_1309)class_12972).field_6283 = class_3532.method_15393((float)(((class_1309)class_12972).field_6283 + (float)addedYRot));
                        }
                    } else {
                        class_12972.method_36456(class_12972.method_36454() + (float)addedYRot);
                        class_12972.method_5847(class_12972.method_5791() + (float)addedYRot);
                        if (class_12972 instanceof class_1309) {
                            ((class_1309)class_12972).field_6283 += (float)addedYRot;
                        }
                    }
                    entityDraggingInformation.setAddedYawRotLastTick(addedYRot);
                }
            } else if ((!class_12972.method_37908().field_9236 || class_12972 instanceof class_746) && entityDraggingInformation.getAddedMovementLastTick().length() > 0.001) {
                class_12972.method_5762(entityDraggingInformation.getAddedMovementLastTick().x(), entityDraggingInformation.getAddedMovementLastTick().y(), entityDraggingInformation.getAddedMovementLastTick().z());
                entityDraggingInformation.setAddedMovementLastTick(new Vector3d());
                entityDraggingInformation.setAddedYawRotLastTick(0.0);
            }
            int n2 = entityDraggingInformation.getTicksSinceStoodOnShip();
            entityDraggingInformation.setTicksSinceStoodOnShip(n2 + 1);
            entityDraggingInformation.setMountedToEntity(class_12972.method_5854() != null);
        }
    }

    public static /* synthetic */ void dragEntitiesWithShips$default(EntityDragger entityDragger, Iterable iterable, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        entityDragger.dragEntitiesWithShips(iterable, bl);
    }

    @NotNull
    public final class_243 serversideEyePosition(@NotNull class_1297 $this$serversideEyePosition) {
        Intrinsics.checkNotNullParameter((Object)$this$serversideEyePosition, (String)"<this>");
        if ($this$serversideEyePosition instanceof class_3222 && $this$serversideEyePosition instanceof IEntityDraggingInformationProvider && ((IEntityDraggingInformationProvider)$this$serversideEyePosition).getDraggingInformation().isEntityBeingDraggedByAShip() && ((IEntityDraggingInformationProvider)$this$serversideEyePosition).getDraggingInformation().getServerRelativePlayerPosition() != null) {
            Vector3dc vector3dc = ((IEntityDraggingInformationProvider)$this$serversideEyePosition).getDraggingInformation().getServerRelativePlayerPosition();
            Intrinsics.checkNotNull((Object)vector3dc);
            return ValkyrienSkies.toMinecraft(vector3dc);
        }
        class_243 class_2432 = $this$serversideEyePosition.method_33571();
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"getEyePosition(...)");
        return class_2432;
    }

    public final double serversideEyeRotation(@NotNull class_1297 $this$serversideEyeRotation) {
        Intrinsics.checkNotNullParameter((Object)$this$serversideEyeRotation, (String)"<this>");
        if ($this$serversideEyeRotation instanceof class_3222 && $this$serversideEyeRotation instanceof IEntityDraggingInformationProvider && ((IEntityDraggingInformationProvider)$this$serversideEyeRotation).getDraggingInformation().isEntityBeingDraggedByAShip() && ((IEntityDraggingInformationProvider)$this$serversideEyeRotation).getDraggingInformation().getServerRelativePlayerYaw() != null) {
            Double d2 = ((IEntityDraggingInformationProvider)$this$serversideEyeRotation).getDraggingInformation().getServerRelativePlayerYaw();
            Intrinsics.checkNotNull((Object)d2);
            return d2 * 180.0 / Math.PI;
        }
        return $this$serversideEyeRotation.method_36454();
    }

    @NotNull
    public final class_243 serversideEyePositionOrDefault(@NotNull class_1297 $this$serversideEyePositionOrDefault, @NotNull class_243 class_2432) {
        Intrinsics.checkNotNullParameter((Object)$this$serversideEyePositionOrDefault, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)class_2432, (String)"default");
        if ($this$serversideEyePositionOrDefault instanceof class_3222 && $this$serversideEyePositionOrDefault instanceof IEntityDraggingInformationProvider && ((IEntityDraggingInformationProvider)$this$serversideEyePositionOrDefault).getDraggingInformation().isEntityBeingDraggedByAShip() && ((IEntityDraggingInformationProvider)$this$serversideEyePositionOrDefault).getDraggingInformation().getServerRelativePlayerPosition() != null) {
            Vector3dc vector3dc = ((IEntityDraggingInformationProvider)$this$serversideEyePositionOrDefault).getDraggingInformation().getServerRelativePlayerPosition();
            Intrinsics.checkNotNull((Object)vector3dc);
            return ValkyrienSkies.toMinecraft(vector3dc);
        }
        return class_2432;
    }

    public final double serversideEyeRotationOrDefault(@NotNull class_1297 $this$serversideEyeRotationOrDefault, double d2) {
        Intrinsics.checkNotNullParameter((Object)$this$serversideEyeRotationOrDefault, (String)"<this>");
        if ($this$serversideEyeRotationOrDefault instanceof class_3222 && $this$serversideEyeRotationOrDefault instanceof IEntityDraggingInformationProvider && ((IEntityDraggingInformationProvider)$this$serversideEyeRotationOrDefault).getDraggingInformation().isEntityBeingDraggedByAShip() && ((IEntityDraggingInformationProvider)$this$serversideEyeRotationOrDefault).getDraggingInformation().getServerRelativePlayerYaw() != null) {
            Double d3 = ((IEntityDraggingInformationProvider)$this$serversideEyeRotationOrDefault).getDraggingInformation().getServerRelativePlayerYaw();
            Intrinsics.checkNotNull((Object)d3);
            return Math.toDegrees(d3);
        }
        return d2;
    }

    public final double serversideWorldEyeRotationOrDefault(@NotNull class_1297 $this$serversideWorldEyeRotationOrDefault, @NotNull Ship ship, double d2) {
        Intrinsics.checkNotNullParameter((Object)$this$serversideWorldEyeRotationOrDefault, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        if ($this$serversideWorldEyeRotationOrDefault instanceof class_3222 && $this$serversideWorldEyeRotationOrDefault instanceof IEntityDraggingInformationProvider && ((IEntityDraggingInformationProvider)$this$serversideWorldEyeRotationOrDefault).getDraggingInformation().isEntityBeingDraggedByAShip() && ((IEntityDraggingInformationProvider)$this$serversideWorldEyeRotationOrDefault).getDraggingInformation().getServerRelativePlayerYaw() != null) {
            Double d3 = ((IEntityDraggingInformationProvider)$this$serversideWorldEyeRotationOrDefault).getDraggingInformation().getServerRelativePlayerYaw();
            Intrinsics.checkNotNull((Object)d3);
            return EntityLerper.INSTANCE.yawToWorld(ship, d3);
        }
        return d2;
    }

    @JvmStatic
    @NotNull
    public static final class_243 backOff(@NotNull class_243 vec3, @NotNull Ship ship, @NotNull class_1657 player, @NotNull class_1937 cLevel) {
        Intrinsics.checkNotNullParameter((Object)vec3, (String)"vec3");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)cLevel, (String)"cLevel");
        Vector3d transformedVec = ship.getWorldToShip().transformDirection(ValkyrienSkies.toJOML(vec3), new Vector3d());
        double d2 = transformedVec.x;
        double e2 = transformedVec.y;
        double f2 = transformedVec.z;
        while (!(d2 == 0.0) && !INSTANCE.isValidWalkablePosition(cLevel, ship, player, d2, class_2350.field_11034)) {
            if (d2 < 0.025 && d2 >= -0.025) {
                d2 = 0.0;
                continue;
            }
            if (d2 > 0.0) {
                d2 -= 0.025;
                continue;
            }
            d2 += 0.025;
        }
        while (!(f2 == 0.0) && !INSTANCE.isValidWalkablePosition(cLevel, ship, player, f2, class_2350.field_11035)) {
            if (f2 < 0.025 && f2 >= -0.025) {
                f2 = 0.0;
                continue;
            }
            if (f2 > 0.0) {
                f2 -= 0.025;
                continue;
            }
            f2 += 0.025;
        }
        while (!(e2 == 0.0) && !INSTANCE.isValidWalkablePosition(cLevel, ship, player, e2, class_2350.field_11036)) {
            if (e2 < 0.025 && e2 >= -0.025) {
                e2 = 0.0;
                continue;
            }
            if (e2 > 0.0) {
                e2 -= 0.025;
                continue;
            }
            e2 += 0.025;
        }
        while (!(d2 == 0.0 || f2 == 0.0 || e2 == 0.0 || INSTANCE.isValidWalkablePosition(cLevel, ship, player, d2, class_2350.field_11034) || INSTANCE.isValidWalkablePosition(cLevel, ship, player, f2, class_2350.field_11035) || INSTANCE.isValidWalkablePosition(cLevel, ship, player, e2, class_2350.field_11036))) {
            d2 = d2 < 0.025 && d2 >= -0.025 ? 0.0 : (d2 > 0.0 ? (d2 -= 0.025) : (d2 += 0.025));
            f2 = f2 < 0.025 && f2 >= -0.025 ? 0.0 : (f2 > 0.0 ? (f2 -= 0.025) : (f2 += 0.025));
            if (e2 < 0.025 && e2 >= -0.025) {
                e2 = 0.0;
                continue;
            }
            if (e2 > 0.0) {
                e2 -= 0.025;
                continue;
            }
            e2 += 0.025;
        }
        double motionLength = Math.sqrt(d2 * d2 + e2 * e2 + f2 * f2);
        Vector3d vector3d = ship.getShipToWorld().transformDirection(new Vector3d(d2, e2, f2)).normalize().mul(motionLength);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"mul(...)");
        return ValkyrienSkies.toMinecraft(vector3d);
    }

    private final boolean isValidWalkablePosition(class_1937 level, Ship ship, class_1657 player, double step, class_2350 dir) {
        class_3959 clipContext = this.stepTowardsEdge(level, ship, player, step, dir);
        class_3965 result2 = level.method_17742(clipContext);
        if (result2.method_17783() != class_239.class_240.field_1332) {
            return false;
        }
        class_2338 class_23382 = result2.method_17777();
        Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"getBlockPos(...)");
        LoadedShip hitShip = VSGameUtilsKt.getLoadedShipManagingPos(level, (class_2382)class_23382);
        if (hitShip != null) {
            class_2382 class_23822 = result2.method_17780().method_10163();
            Intrinsics.checkNotNullExpressionValue((Object)class_23822, (String)"getNormal(...)");
            Vector3d hitSide = VectorConversionsMCKt.toJOMLD(class_23822);
            Vector3dc upDir = new Vector3d(0.0, 1.0, 0.0);
            Vector3d hitSideInWorld = hitShip.getShipToWorld().transformDirection(hitSide, new Vector3d()).normalize();
            double dot = hitSideInWorld.dot(upDir);
            if (dot < 0.5 && dot > 0.001) {
                return false;
            }
        }
        return true;
    }

    private final class_3959 stepTowardsEdge(class_1937 level, Ship ship, class_1657 player, double step, class_2350 dir) {
        class_243 class_2432 = player.method_19538();
        Vector3d vector3d = ship.getTransform().getShipToWorld().transformDirection(new Vector3d(dir.method_23955())).normalize().mul(step);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"mul(...)");
        class_243 potentialPosition = class_2432.method_1019(ValkyrienSkies.toMinecraft(vector3d));
        Vector3dc downDirInShip = ship.getWorldToShip().transformDirection(new Vector3d(0.0, -1.0, 0.0), new Vector3d()).normalize().mul(player.method_49476());
        Intrinsics.checkNotNull((Object)potentialPosition);
        Vector3d vector3d2 = ValkyrienSkies.toJOML(potentialPosition).add(downDirInShip, new Vector3d());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"add(...)");
        Vector3dc maxDistPos = vector3d2;
        return new class_3959(potentialPosition, ValkyrienSkies.toMinecraft(maxDistPos), class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)player);
    }

    @JvmStatic
    public static final boolean isDraggable(@NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        return !VSEntityManager.isShipyardEntity(entity) && entity instanceof IEntityDraggingInformationProvider && ((IEntityDraggingInformationProvider)entity).vs$shouldDrag();
    }
}


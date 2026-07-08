/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.logging.LogUtils
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1297
 *  net.minecraft.class_1665
 *  net.minecraft.class_1668
 *  net.minecraft.class_1675
 *  net.minecraft.class_243
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_897
 */
package org.valkyrienskies.mod.common.entity.handling;

import com.mojang.logging.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1297;
import net.minecraft.class_1665;
import net.minecraft.class_1668;
import net.minecraft.class_1675;
import net.minecraft.class_243;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_897;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4dc;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.mod.common.entity.handling.VSEntityHandler;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b-\u0010.J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\t\u0010\bJw\u0010\u001b\u001a\u00020\u0006\"\b\b\u0000\u0010\n*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00028\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0016\u00a2\u0006\u0004\b#\u0010$J7\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b&\u0010'J\u001d\u0010(\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b(\u0010\bJ5\u0010(\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000e\u00a2\u0006\u0004\b(\u0010,\u00a8\u0006/"}, d2={"Lorg/valkyrienskies/mod/common/entity/handling/AbstractShipyardEntityHandler;", "Lorg/valkyrienskies/mod/common/entity/handling/VSEntityHandler;", "Lnet/minecraft/class_1297;", "entity", "Lorg/valkyrienskies/core/api/ships/Ship;", "ship", "", "freshEntityInShipyard", "(Lnet/minecraft/class_1297;Lorg/valkyrienskies/core/api/ships/Ship;)V", "entityRemovedFromShipyard", "T", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "Lnet/minecraft/class_897;", "entityRenderer", "", "x", "y", "z", "", "rotationYaw", "partialTicks", "Lnet/minecraft/class_4587;", "matrixStack", "Lnet/minecraft/class_4597;", "buffer", "", "packedLight", "applyRenderTransform", "(Lorg/valkyrienskies/core/api/ships/ClientShip;Lnet/minecraft/class_1297;Lnet/minecraft/class_897;DDDFFLnet/minecraft/class_4587;Lnet/minecraft/class_4597;I)V", "self", "vehicle", "positionSetFromVehicle", "(Lnet/minecraft/class_1297;Lnet/minecraft/class_1297;DDD)V", "Lorg/joml/Vector3d;", "pos", "getTeleportPos", "(Lnet/minecraft/class_1297;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "passenger", "applyRenderOnMountedEntity", "(Lorg/valkyrienskies/core/api/ships/ClientShip;Lnet/minecraft/class_1297;Lnet/minecraft/class_1297;FLnet/minecraft/class_4587;)V", "moveEntityFromWorldToShipyard", "entityX", "entityY", "entityZ", "(Lnet/minecraft/class_1297;Lorg/valkyrienskies/core/api/ships/Ship;DDD)V", "<init>", "()V", "valkyrienskies-120"})
public abstract class AbstractShipyardEntityHandler
implements VSEntityHandler {
    @Override
    public void freshEntityInShipyard(@NotNull class_1297 entity, @NotNull Ship ship) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
    }

    @Override
    public void entityRemovedFromShipyard(@NotNull class_1297 entity, @NotNull Ship ship) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
    }

    @Override
    public <T extends class_1297> void applyRenderTransform(@NotNull ClientShip ship, @NotNull T entity, @NotNull class_897<T> entityRenderer, double x, double y, double z, float rotationYaw, float partialTicks, @NotNull class_4587 matrixStack, @NotNull class_4597 buffer, int packedLight) {
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Intrinsics.checkNotNullParameter(entityRenderer, (String)"entityRenderer");
        Intrinsics.checkNotNullParameter((Object)matrixStack, (String)"matrixStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        ShipTransform transform2 = ship.getRenderTransform();
        class_243 entityPosition = entity.method_30950(partialTicks);
        Matrix4dc matrix4dc = transform2.getShipToWorld();
        Intrinsics.checkNotNull((Object)entityPosition);
        Vector3d transformed = matrix4dc.transformPosition(VectorConversionsMCKt.toJOML(entityPosition));
        double camX = x - entityPosition.field_1352;
        double camY = y - entityPosition.field_1351;
        double camZ = z - entityPosition.field_1350;
        class_243 offset = entityRenderer.method_23169(entity, partialTicks);
        Vector3dc scale = transform2.getShipToWorldScaling();
        matrixStack.method_22904(transformed.x + camX, transformed.y + camY, transformed.z + camZ);
        matrixStack.method_22907(new Quaternionf(transform2.getShipToWorldRotation()));
        matrixStack.method_22905((float)scale.x(), (float)scale.y(), (float)scale.z());
        matrixStack.method_22904(offset.field_1352, offset.field_1351, offset.field_1350);
    }

    @Override
    public void positionSetFromVehicle(@NotNull class_1297 self, @NotNull class_1297 vehicle, double x, double y, double z) {
        Intrinsics.checkNotNullParameter((Object)self, (String)"self");
        Intrinsics.checkNotNullParameter((Object)vehicle, (String)"vehicle");
        self.method_5814(x, y, z);
    }

    @Override
    @NotNull
    public Vector3d getTeleportPos(@NotNull class_1297 self, @NotNull Vector3d pos) {
        Intrinsics.checkNotNullParameter((Object)self, (String)"self");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return pos;
    }

    @Override
    public void applyRenderOnMountedEntity(@NotNull ClientShip ship, @NotNull class_1297 self, @NotNull class_1297 passenger, float partialTicks, @NotNull class_4587 matrixStack) {
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        Intrinsics.checkNotNullParameter((Object)self, (String)"self");
        Intrinsics.checkNotNullParameter((Object)passenger, (String)"passenger");
        Intrinsics.checkNotNullParameter((Object)matrixStack, (String)"matrixStack");
        matrixStack.method_22907(new Quaternionf(ship.getRenderTransform().getShipToWorldRotation()));
    }

    public final void moveEntityFromWorldToShipyard(@NotNull class_1297 entity, @NotNull Ship ship) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        this.moveEntityFromWorldToShipyard(entity, ship, entity.method_23317(), entity.method_23318(), entity.method_23321());
    }

    public final void moveEntityFromWorldToShipyard(@NotNull class_1297 entity, @NotNull Ship ship, double entityX, double entityY, double entityZ) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        Vector3d shipyardPos = ship.getWorldToShip().transformPosition(entityX, entityY, entityZ, new Vector3d());
        class_243 class_2432 = entity.method_19538();
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"position(...)");
        Vector3d vector3d = VectorConversionsMCKt.toJOML(class_2432).sub(ship.getTransform().getPositionInWorld());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"sub(...)");
        Vector3d relativePos = vector3d;
        Vector3d shipPosVelocity = new Vector3d(ship.getVelocity()).add(new Vector3d(ship.getOmega()).cross(relativePos)).mul(0.05);
        class_243 class_2433 = entity.method_18798();
        Intrinsics.checkNotNullExpressionValue((Object)class_2433, (String)"getDeltaMovement(...)");
        Vector3d vector3d2 = VectorConversionsMCKt.toJOML(class_2433).sub(shipPosVelocity);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"sub(...)");
        Vector3d relativeDeltaOnShip = vector3d2;
        ship.getWorldToShip().transformDirection(relativeDeltaOnShip);
        entity.method_5814(shipyardPos.x, shipyardPos.y, shipyardPos.z);
        entity.method_18799(VectorConversionsMCKt.toMinecraft(relativeDeltaOnShip));
        entity.field_6014 = shipyardPos.x;
        entity.field_6036 = shipyardPos.y;
        entity.field_5969 = shipyardPos.z;
        Vector3d direction = null;
        double yaw = 0.0;
        double pitch = 0.0;
        if (entity instanceof class_1665) {
            class_243 class_2434 = ((class_1665)entity).method_18798();
            Intrinsics.checkNotNullExpressionValue((Object)class_2434, (String)"getDeltaMovement(...)");
            direction = VectorConversionsMCKt.toJOML(class_2434);
            yaw = Math.atan2(direction.x, direction.z);
            pitch = Math.atan2(direction.y, Math.sqrt(direction.x * direction.x + direction.z * direction.z));
        } else {
            Matrix4dc matrix4dc = ship.getWorldToShip();
            class_243 class_2435 = entity.method_5720();
            Intrinsics.checkNotNullExpressionValue((Object)class_2435, (String)"getLookAngle(...)");
            direction = matrix4dc.transformDirection(VectorConversionsMCKt.toJOML(class_2435));
            yaw = Math.atan2(-direction.x, direction.z);
            pitch = Math.atan2(-direction.y, Math.sqrt(direction.x * direction.x + direction.z * direction.z));
        }
        entity.method_36456((float)(yaw * 57.29577951308232));
        entity.method_36457((float)(pitch * 57.29577951308232));
        LogUtils.getLogger().info("Yaw {}, Pitch {}", (Object)Float.valueOf(entity.method_36454()), (Object)Float.valueOf(entity.method_36455()));
        entity.field_5982 = entity.method_36454();
        entity.field_6004 = entity.method_36455();
        if (entity instanceof class_1668) {
            Vector3d power = new Vector3d(((class_1668)entity).field_7601, ((class_1668)entity).field_7600, ((class_1668)entity).field_7599);
            ship.getWorldToShip().transformDirection(power);
            ((class_1668)entity).field_7601 = power.x;
            ((class_1668)entity).field_7600 = power.y;
            ((class_1668)entity).field_7599 = power.z;
            class_1675.method_7484((class_1297)entity, (float)1.0f);
        }
    }
}


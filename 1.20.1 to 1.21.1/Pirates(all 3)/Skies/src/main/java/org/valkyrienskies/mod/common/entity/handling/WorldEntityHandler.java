/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1297
 *  net.minecraft.class_1665
 *  net.minecraft.class_1668
 *  net.minecraft.class_1675
 *  net.minecraft.class_1676
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_897
 */
package org.valkyrienskies.mod.common.entity.handling;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1297;
import net.minecraft.class_1665;
import net.minecraft.class_1668;
import net.minecraft.class_1675;
import net.minecraft.class_1676;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_897;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4dc;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.util.VectorConversionsKt;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.entity.handling.VSEntityHandler;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\t\u0010\bJw\u0010\u001b\u001a\u00020\u0006\"\b\b\u0000\u0010\n*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00028\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0016\u00a2\u0006\u0004\b#\u0010$J7\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b&\u0010'J\u001d\u0010(\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b(\u0010\bJ5\u0010(\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000e\u00a2\u0006\u0004\b(\u0010,\u00a8\u0006/"}, d2={"Lorg/valkyrienskies/mod/common/entity/handling/WorldEntityHandler;", "Lorg/valkyrienskies/mod/common/entity/handling/VSEntityHandler;", "Lnet/minecraft/class_1297;", "entity", "Lorg/valkyrienskies/core/api/ships/Ship;", "ship", "", "freshEntityInShipyard", "(Lnet/minecraft/class_1297;Lorg/valkyrienskies/core/api/ships/Ship;)V", "entityRemovedFromShipyard", "T", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "Lnet/minecraft/class_897;", "entityRenderer", "", "x", "y", "z", "", "rotationYaw", "partialTicks", "Lnet/minecraft/class_4587;", "matrixStack", "Lnet/minecraft/class_4597;", "buffer", "", "packedLight", "applyRenderTransform", "(Lorg/valkyrienskies/core/api/ships/ClientShip;Lnet/minecraft/class_1297;Lnet/minecraft/class_897;DDDFFLnet/minecraft/class_4587;Lnet/minecraft/class_4597;I)V", "self", "vehicle", "positionSetFromVehicle", "(Lnet/minecraft/class_1297;Lnet/minecraft/class_1297;DDD)V", "Lorg/joml/Vector3d;", "pos", "getTeleportPos", "(Lnet/minecraft/class_1297;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "passenger", "applyRenderOnMountedEntity", "(Lorg/valkyrienskies/core/api/ships/ClientShip;Lnet/minecraft/class_1297;Lnet/minecraft/class_1297;FLnet/minecraft/class_4587;)V", "moveEntityFromShipyardToWorld", "entityX", "entityY", "entityZ", "(Lnet/minecraft/class_1297;Lorg/valkyrienskies/core/api/ships/Ship;DDD)V", "<init>", "()V", "valkyrienskies-120"})
public final class WorldEntityHandler
implements VSEntityHandler {
    @NotNull
    public static final WorldEntityHandler INSTANCE = new WorldEntityHandler();

    private WorldEntityHandler() {
    }

    @Override
    public void freshEntityInShipyard(@NotNull class_1297 entity, @NotNull Ship ship) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        this.moveEntityFromShipyardToWorld(entity, ship);
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
        class_243 offset = entityRenderer.method_23169(entity, partialTicks);
        matrixStack.method_22904(x + offset.field_1352, y + offset.field_1351, z + offset.field_1350);
    }

    @Override
    public void positionSetFromVehicle(@NotNull class_1297 self, @NotNull class_1297 vehicle, double x, double y, double z) {
        Intrinsics.checkNotNullParameter((Object)self, (String)"self");
        Intrinsics.checkNotNullParameter((Object)vehicle, (String)"vehicle");
        class_1937 class_19372 = self.method_37908();
        Intrinsics.checkNotNullExpressionValue((Object)class_19372, (String)"level(...)");
        class_243 class_2432 = vehicle.method_19538();
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"position(...)");
        if (VSGameUtilsKt.isBlockInShipyard(class_19372, class_2432) && VSGameUtilsKt.getShipManaging(vehicle) == null) {
            self.method_5848();
            return;
        }
        Vector3d vector3d = VSGameUtilsKt.toWorldCoordinates$default(self.method_37908(), x, y, z, null, 8, null);
        double wx = VectorConversionsKt.component1(vector3d);
        double wy = VectorConversionsKt.component2(vector3d);
        double wz = VectorConversionsKt.component3(vector3d);
        self.method_5814(wx, wy, wz);
    }

    @Override
    @NotNull
    public Vector3d getTeleportPos(@NotNull class_1297 self, @NotNull Vector3d pos) {
        Intrinsics.checkNotNullParameter((Object)self, (String)"self");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return VSGameUtilsKt.toWorldCoordinates(self.method_37908(), pos);
    }

    @Override
    public void applyRenderOnMountedEntity(@NotNull ClientShip ship, @NotNull class_1297 self, @NotNull class_1297 passenger, float partialTicks, @NotNull class_4587 matrixStack) {
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        Intrinsics.checkNotNullParameter((Object)self, (String)"self");
        Intrinsics.checkNotNullParameter((Object)passenger, (String)"passenger");
        Intrinsics.checkNotNullParameter((Object)matrixStack, (String)"matrixStack");
    }

    public final void moveEntityFromShipyardToWorld(@NotNull class_1297 entity, @NotNull Ship ship) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        this.moveEntityFromShipyardToWorld(entity, ship, entity.method_23317(), entity.method_23318(), entity.method_23321());
    }

    public final void moveEntityFromShipyardToWorld(@NotNull class_1297 entity, @NotNull Ship ship, double entityX, double entityY, double entityZ) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        Vector3d newPos = ship.getShipToWorld().transformPosition(new Vector3d(entityX, entityY, entityZ));
        entity.method_5814(newPos.x, newPos.y, newPos.z);
        entity.field_6014 = entity.method_23317();
        entity.field_6036 = entity.method_23318();
        entity.field_5969 = entity.method_23321();
        Quaterniondc quaterniondc = ship.getTransform().getShipToWorldRotation();
        class_243 class_2432 = entity.method_18798();
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"getDeltaMovement(...)");
        Vector3d entityVelocity = quaterniondc.transform(VectorConversionsMCKt.toJOML(class_2432));
        Intrinsics.checkNotNull((Object)entityVelocity);
        entity.method_18799(VectorConversionsMCKt.toMinecraft(entityVelocity));
        if (entity instanceof class_1676) {
            VSGameUtilsKt.applyShipVelocity(entity, ship);
        } else {
            ((IEntityDraggingInformationProvider)entity).vs$dragImmediately(ship);
        }
        Vector3d direction = null;
        double yaw = 0.0;
        double pitch = 0.0;
        if (entity instanceof class_1665) {
            class_243 class_2433 = ((class_1665)entity).method_18798();
            Intrinsics.checkNotNullExpressionValue((Object)class_2433, (String)"getDeltaMovement(...)");
            direction = VectorConversionsMCKt.toJOML(class_2433);
            yaw = Math.atan2(direction.x, direction.z);
            pitch = Math.atan2(direction.y, Math.sqrt(direction.x * direction.x + direction.z * direction.z));
        } else {
            Matrix4dc matrix4dc = ship.getShipToWorld();
            class_243 class_2434 = entity.method_5720();
            Intrinsics.checkNotNullExpressionValue((Object)class_2434, (String)"getLookAngle(...)");
            direction = matrix4dc.transformDirection(VectorConversionsMCKt.toJOML(class_2434));
            yaw = Math.atan2(-direction.x, direction.z);
            pitch = Math.atan2(-direction.y, Math.sqrt(direction.x * direction.x + direction.z * direction.z));
        }
        entity.method_36456((float)(yaw * 57.29577951308232));
        entity.method_36457((float)(pitch * 57.29577951308232));
        entity.field_5982 = entity.method_36454();
        entity.field_6004 = entity.method_36455();
        if (entity instanceof class_1668) {
            Vector3d power = new Vector3d(((class_1668)entity).field_7601, ((class_1668)entity).field_7600, ((class_1668)entity).field_7599);
            ship.getShipToWorld().transformDirection(power);
            ((class_1668)entity).field_7601 = power.x;
            ((class_1668)entity).field_7600 = power.y;
            ((class_1668)entity).field_7599 = power.z;
            class_1675.method_7484((class_1297)entity, (float)1.0f);
        }
    }
}


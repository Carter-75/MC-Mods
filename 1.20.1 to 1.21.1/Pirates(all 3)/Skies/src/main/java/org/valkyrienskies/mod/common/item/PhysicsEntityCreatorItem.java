/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1838
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 */
package org.valkyrienskies.mod.common.item;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1838;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4dc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.internal.VsiCore;
import org.valkyrienskies.core.internal.physics.PhysicsEntityData;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.entity.VSPhysicsEntity;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2={"Lorg/valkyrienskies/mod/common/item/PhysicsEntityCreatorItem;", "Lnet/minecraft/class_1792;", "Lnet/minecraft/class_1799;", "stack", "", "isFoil", "(Lnet/minecraft/class_1799;)Z", "Lnet/minecraft/class_1838;", "ctx", "Lnet/minecraft/class_1269;", "useOn", "(Lnet/minecraft/class_1838;)Lnet/minecraft/class_1269;", "Lnet/minecraft/class_1792$class_1793;", "properties", "<init>", "(Lnet/minecraft/class_1792$class_1793;)V", "valkyrienskies-120"})
public final class PhysicsEntityCreatorItem
extends class_1792 {
    public PhysicsEntityCreatorItem(@NotNull class_1792.class_1793 properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
    }

    public boolean method_7886(@NotNull class_1799 stack) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        return true;
    }

    @NotNull
    public class_1269 method_7884(@NotNull class_1838 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        class_1937 class_19372 = ctx.method_8045();
        class_3218 class_32182 = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
        if (class_32182 == null) {
            class_1269 class_12692 = super.method_7884(ctx);
            Intrinsics.checkNotNullExpressionValue((Object)class_12692, (String)"useOn(...)");
            return class_12692;
        }
        class_3218 level = class_32182;
        if (!level.field_9236) {
            Vector3dc vector3dc;
            Vector3dc offsetInGlobal;
            class_1297 class_12972 = ValkyrienSkiesMod.INSTANCE.getPHYSICS_ENTITY_TYPE().method_5883((class_1937)level);
            Intrinsics.checkNotNull((Object)class_12972);
            VSPhysicsEntity entity = (VSPhysicsEntity)class_12972;
            long shipId = VSGameUtilsKt.getShipObjectWorld(level).allocateShipId(VSGameUtilsKt.getDimensionId((class_1937)level));
            double sphereRadius = 0.5;
            class_2382 class_23822 = ctx.method_8038().method_10163();
            Intrinsics.checkNotNullExpressionValue((Object)class_23822, (String)"getNormal(...)");
            Vector3d vector3d = VectorConversionsMCKt.toJOMLD(class_23822).mul(sphereRadius);
            Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"mul(...)");
            Vector3dc offsetInLocal = vector3d;
            class_1937 class_19373 = ctx.method_8045();
            class_2338 class_23382 = ctx.method_8037();
            Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"getClickedPos(...)");
            Ship shipOn = VSGameUtilsKt.getShipManagingPos(class_19373, class_23382);
            Vector3dc vector3dc2 = offsetInGlobal = shipOn != null ? (Vector3dc)shipOn.getTransform().getShipToWorldRotation().transform(offsetInLocal, new Vector3d()) : offsetInLocal;
            if (shipOn != null) {
                Matrix4dc matrix4dc = shipOn.getTransform().getShipToWorld();
                class_243 class_2432 = ctx.method_17698();
                Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"getClickLocation(...)");
                var12_10 = matrix4dc.transformPosition(VectorConversionsMCKt.toJOML(class_2432)).add(offsetInGlobal);
                Intrinsics.checkNotNull((Object)var12_10);
                vector3dc = var12_10;
            } else {
                class_243 class_2433 = ctx.method_17698();
                Intrinsics.checkNotNullExpressionValue((Object)class_2433, (String)"getClickLocation(...)");
                var12_10 = VectorConversionsMCKt.toJOML(class_2433).add(offsetInGlobal);
                Intrinsics.checkNotNull((Object)var12_10);
                vector3dc = var12_10;
            }
            Vector3dc entityPos = vector3dc;
            ShipTransform transform2 = VsiCore.newShipTransform$default(VSGameUtilsKt.getVsCore(), entityPos, new Vector3d(), null, null, 12, null);
            PhysicsEntityData physicsEntityData = VSPhysicsEntity.Companion.createBasicSphereData$default(VSPhysicsEntity.Companion, shipId, transform2, sphereRadius, 0.0, 8, null);
            entity.setPhysicsEntityData(physicsEntityData);
            entity.method_5814(entityPos.x(), entityPos.y(), entityPos.z());
            level.method_8649((class_1297)entity);
            if (shipOn != null) {
                double attachCompliance = 1.0E-8;
                double d2 = 1.0E10;
            }
        }
        class_1269 class_12693 = super.method_7884(ctx);
        Intrinsics.checkNotNullExpressionValue((Object)class_12693, (String)"useOn(...)");
        return class_12693;
    }
}


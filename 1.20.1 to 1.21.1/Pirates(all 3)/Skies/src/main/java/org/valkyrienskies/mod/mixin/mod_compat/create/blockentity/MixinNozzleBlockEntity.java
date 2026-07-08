/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.kinetics.fan.NozzleBlockEntity
 *  com.simibubi.create.foundation.blockEntity.SmartBlockEntity
 *  net.minecraft.class_1297
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.kinetics.fan.NozzleBlockEntity;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import net.minecraft.class_1297;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.common.world.RaycastUtilsKt;

@Mixin(value={NozzleBlockEntity.class})
public abstract class MixinNozzleBlockEntity
extends SmartBlockEntity {
    @Shadow
    private float range;

    public MixinNozzleBlockEntity(class_2591<?> type, class_2338 pos, class_2680 state) {
        super(type, pos, state);
    }

    @WrapOperation(method={"tick", "lazyTick"}, at={@At(value="INVOKE", target="Lnet/createmod/catnip/math/VecHelper;getCenterOf(Lnet/minecraft/core/Vec3i;)Lnet/minecraft/world/phys/Vec3;")})
    private class_243 getCenterInWorld(class_2382 pos, Operation<class_243> original) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(this.field_11863, this.method_11016());
        if (ship != null) {
            Vector3d posJOML = VectorConversionsMCKt.toJOML((class_243)original.call(new Object[]{pos}));
            ship.getTransform().getShipToWorld().transformPosition(posJOML);
            return VectorConversionsMCKt.toMinecraft(posJOML);
        }
        return (class_243)original.call(new Object[]{pos});
    }

    @Inject(method={"canSee"}, at={@At(value="HEAD")}, cancellable=true)
    private void canSeeWithShip(class_1297 entity, CallbackInfoReturnable<Boolean> cir) {
        Vector3d worldPos;
        class_243 nozzlePosWorld = this.field_11867.method_46558();
        class_243 entityPosWorld = entity.method_19538();
        Ship nozzleShip = VSGameUtilsKt.getShipManagingPos(this.field_11863, this.field_11867);
        Ship entityShip = VSGameUtilsKt.getShipManaging(entity);
        if (nozzleShip != null) {
            worldPos = VectorConversionsMCKt.toJOML(this.field_11867.method_46558());
            nozzleShip.getShipToWorld().transformPosition(worldPos);
            nozzlePosWorld = VectorConversionsMCKt.toMinecraft(worldPos);
        }
        if (!VSGameUtilsKt.getShipsIntersecting(this.field_11863, new class_238(nozzlePosWorld, nozzlePosWorld).method_1014((double)(this.range / 2.0f))).iterator().hasNext()) {
            return;
        }
        if (entityShip != null) {
            worldPos = VectorConversionsMCKt.toJOML(entity.method_19538());
            nozzleShip.getShipToWorld().transformPosition(worldPos);
            entityPosWorld = VectorConversionsMCKt.toMinecraft(worldPos);
        }
        class_3959 context = new class_3959(entityPosWorld, nozzlePosWorld, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, entity);
        class_3965 result2 = RaycastUtilsKt.clipIncludeShips(this.field_11863, context);
        cir.setReturnValue((Object)result2.method_17777().equals((Object)this.field_11867));
    }
}


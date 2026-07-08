/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2586
 *  net.minecraft.class_4184
 *  net.minecraft.class_824
 *  net.minecraft.class_827
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.render_blockentity_distance_check;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2586;
import net.minecraft.class_4184;
import net.minecraft.class_824;
import net.minecraft.class_827;
import org.joml.Matrix4dc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_824.class})
public class MixinBlockEntityRenderDispatcher {
    @Shadow
    public class_1937 field_4348;
    @Shadow
    public class_4184 field_4344;

    @WrapOperation(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/blockentity/BlockEntityRenderer;shouldRender(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/phys/Vec3;)Z")})
    private <E extends class_2586> boolean isTileEntityInRenderRange(class_827<E> instance, E blockEntity, class_243 cameraPos, Operation<Boolean> operation) {
        if (((Boolean)operation.call(new Object[]{instance, blockEntity, cameraPos})).booleanValue()) {
            return true;
        }
        class_2338 bePos = blockEntity.method_11016();
        LoadedShip nullableShip = VSGameUtilsKt.getLoadedShipManagingPos(this.field_4348, (class_2382)bePos);
        if (nullableShip instanceof ClientShip) {
            ClientShip ship = (ClientShip)nullableShip;
            Matrix4dc m2 = ship.getRenderTransform().getShipToWorld();
            return new class_243(m2.m00() * (double)bePos.method_10263() + m2.m10() * (double)bePos.method_10264() + m2.m20() * (double)bePos.method_10260() + m2.m30(), m2.m01() * (double)bePos.method_10263() + m2.m11() * (double)bePos.method_10264() + m2.m21() * (double)bePos.method_10260() + m2.m31(), m2.m02() * (double)bePos.method_10263() + m2.m12() * (double)bePos.method_10264() + m2.m22() * (double)bePos.method_10260() + m2.m32()).method_24802((class_2374)this.field_4344.method_19326(), (double)instance.method_33893());
        }
        return false;
    }
}


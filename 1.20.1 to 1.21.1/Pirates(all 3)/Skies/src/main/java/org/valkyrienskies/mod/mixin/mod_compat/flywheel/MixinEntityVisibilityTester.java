/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.engine_room.flywheel.lib.math.MoreMath
 *  dev.engine_room.flywheel.lib.visual.EntityVisibilityTester
 *  net.minecraft.class_1297
 *  net.minecraft.class_238
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.flywheel;

import dev.engine_room.flywheel.lib.math.MoreMath;
import dev.engine_room.flywheel.lib.visual.EntityVisibilityTester;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import org.joml.FrustumIntersection;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={EntityVisibilityTester.class})
public class MixinEntityVisibilityTester {
    @Shadow
    @Final
    private class_1297 entity;
    @Shadow
    @Final
    private float scale;

    @Inject(method={"adjustAndTestAABB"}, at={@At(value="HEAD")}, cancellable=true)
    private void cullingOnShip(FrustumIntersection frustum, class_238 aabb, CallbackInfoReturnable<Boolean> cir) {
        Ship ship = VSGameUtilsKt.getShipManaging(this.entity);
        if (ship instanceof ClientShip) {
            ClientShip ship2 = (ClientShip)ship;
            Vector3f pos = ship2.getRenderTransform().getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(this.entity.method_19538())).get(new Vector3f());
            float maxSize = (float)Math.max(aabb.method_17939(), Math.max(aabb.method_17940(), aabb.method_17941()));
            if (frustum.testSphere(pos.x, pos.y, pos.z, maxSize * MoreMath.SQRT_3_OVER_2 * this.scale)) {
                cir.setReturnValue((Object)true);
            }
        }
    }
}


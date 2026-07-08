/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.kinetics.chainConveyor.ChainPackageInteractionHandler
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.kinetics.chainConveyor.ChainPackageInteractionHandler;
import java.util.Optional;
import net.minecraft.class_238;
import net.minecraft.class_243;
import org.joml.primitives.AABBd;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSClientGameUtils;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={ChainPackageInteractionHandler.class})
public abstract class MixinChainPackageInteractionHandler {
    @WrapOperation(method={"lambda$onUse$0"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/AABB;clip(Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)Ljava/util/Optional;")})
    private static Optional<class_243> wrapAABB(class_238 instance, class_243 from, class_243 to2, Operation<Optional<class_243>> original) {
        ClientShip ship = VSClientGameUtils.getClientShip(instance.method_1005().field_1352, instance.method_1005().field_1351, instance.method_1005().field_1350);
        if (ship != null) {
            AABBd aabBd = VectorConversionsMCKt.toJOML(instance);
            aabBd = aabBd.transform(ship.getTransform().getShipToWorld());
            return (Optional)original.call(new Object[]{VectorConversionsMCKt.toMinecraft(aabBd), from, to2});
        }
        return (Optional)original.call(new Object[]{instance, from, to2});
    }
}


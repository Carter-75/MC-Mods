/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.foundation.blockEntity.behaviour.edgeInteraction.EdgeInteractionHandler
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_3965
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.foundation.blockEntity.behaviour.edgeInteraction.EdgeInteractionHandler;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_3965;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={EdgeInteractionHandler.class})
public class MixinEdgeInteractionHandler {
    @WrapOperation(method={"Lcom/simibubi/create/foundation/blockEntity/behaviour/edgeInteraction/EdgeInteractionHandler;onBlockActivated(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/phys/BlockHitResult;)Lnet/minecraft/world/InteractionResult;", "Lcom/simibubi/create/foundation/blockEntity/behaviour/edgeInteraction/EdgeInteractionHandler;onBlockActivated(Lnet/minecraftforge/event/entity/player/PlayerInteractEvent$RightClickBlock;)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/BlockHitResult;getLocation()Lnet/minecraft/world/phys/Vec3;")})
    private static class_243 injectGetLocation(class_3965 instance, Operation<class_243> original, @Local(ordinal=0) class_1937 world) {
        class_243 originalResult = (class_243)original.call(new Object[]{instance});
        Ship ship = VSGameUtilsKt.getShipManagingPos(world, instance.method_17777());
        if (ship != null) {
            Vector3d resultJoml = VectorConversionsMCKt.toJOML(originalResult);
            ship.getTransform().getWorldToShip().transformPosition(resultJoml);
            return VectorConversionsMCKt.toMinecraft(resultJoml);
        }
        return originalResult;
    }
}


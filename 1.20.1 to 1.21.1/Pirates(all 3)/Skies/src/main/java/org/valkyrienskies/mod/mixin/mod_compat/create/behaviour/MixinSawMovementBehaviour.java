/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.simibubi.create.content.contraptions.behaviour.MovementContext
 *  com.simibubi.create.content.kinetics.base.BlockBreakingMovementBehaviour
 *  com.simibubi.create.content.kinetics.saw.SawMovementBehaviour
 *  net.minecraft.class_1799
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.behaviour;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import com.simibubi.create.content.kinetics.base.BlockBreakingMovementBehaviour;
import com.simibubi.create.content.kinetics.saw.SawMovementBehaviour;
import net.minecraft.class_1799;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={SawMovementBehaviour.class})
public abstract class MixinSawMovementBehaviour
extends BlockBreakingMovementBehaviour {
    @WrapMethod(method={"dropItemFromCutTree"})
    private void shipCutTree(MovementContext context, class_2338 pos, class_1799 stack, Operation<Void> original) {
        Ship cutTreeShip = VSGameUtilsKt.getShipManagingPos(context.world, pos);
        Ship sawShip = VSGameUtilsKt.getShipManagingPos(context.world, (class_2374)context.position);
        Vector3d treePos = VectorConversionsMCKt.toJOML(class_243.method_24953((class_2382)pos));
        if (cutTreeShip == null && sawShip == null) {
            original.call(new Object[]{context, pos, stack});
            return;
        }
        if (cutTreeShip != null) {
            cutTreeShip.getShipToWorld().transformPosition(treePos);
        }
        if (sawShip != null) {
            sawShip.getWorldToShip().transformPosition(treePos);
        }
        original.call(new Object[]{context, class_2338.method_49637((double)treePos.x, (double)treePos.y, (double)treePos.z), stack});
    }
}


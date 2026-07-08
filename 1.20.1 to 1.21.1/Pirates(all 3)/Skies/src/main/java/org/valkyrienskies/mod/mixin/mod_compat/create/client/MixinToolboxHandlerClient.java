/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.equipment.toolbox.ToolboxHandlerClient
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.equipment.toolbox.ToolboxHandlerClient;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.CompatUtil;

@Mixin(value={ToolboxHandlerClient.class})
public class MixinToolboxHandlerClient {
    @WrapOperation(method={"onKeyInput", "renderOverlay"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/equipment/toolbox/ToolboxHandler;distance(Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/core/BlockPos;)D")})
    private static double adjustToolboxPos(class_243 playerPos, class_2338 toolboxPos, Operation<Double> original) {
        return (Double)original.call(new Object[]{CompatUtil.INSTANCE.toSameSpaceAs(class_310.method_1551().field_1724.method_37908(), playerPos, toolboxPos), toolboxPos});
    }
}


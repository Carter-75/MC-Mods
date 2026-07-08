/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.simibubi.create.content.logistics.packagePort.PackagePortTargetSelectionHandler
 *  net.createmod.catnip.theme.Color
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.simibubi.create.content.logistics.packagePort.PackagePortTargetSelectionHandler;
import net.createmod.catnip.theme.Color;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.valkyrienskies.mod.common.CompatUtil;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={PackagePortTargetSelectionHandler.class})
public class MixinPackagePortTargetSelectionHandler {
    @WrapMethod(method={"animateConnection"})
    private static void animateConnectionInWorld(class_310 mc, class_243 source, class_243 target, Color color, Operation<Void> original) {
        original.call(new Object[]{mc, VSGameUtilsKt.toWorldCoordinates((class_1937)mc.field_1687, source), VSGameUtilsKt.toWorldCoordinates((class_1937)mc.field_1687, target), color});
    }

    @WrapMethod(method={"validateDiff"})
    private static String adjustPositions(class_243 target, class_2338 placedPos, Operation<String> original) {
        class_638 level = class_310.method_1551().field_1687;
        return (String)original.call(new Object[]{CompatUtil.INSTANCE.toSameSpaceAs((class_1937)level, target, placedPos), placedPos});
    }
}


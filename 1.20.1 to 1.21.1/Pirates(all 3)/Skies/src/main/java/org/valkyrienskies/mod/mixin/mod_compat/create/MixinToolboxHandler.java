/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.content.equipment.toolbox.ToolboxHandler
 *  net.minecraft.class_1657
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.equipment.toolbox.ToolboxHandler;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.mod.common.CompatUtil;

@Mixin(value={ToolboxHandler.class})
public abstract class MixinToolboxHandler {
    @Redirect(method={"getNearest"}, at=@At(value="INVOKE", target="Ljava/util/stream/Stream;filter(Ljava/util/function/Predicate;)Ljava/util/stream/Stream;", ordinal=0))
    private static Stream<class_2338> replaceFilteringLambda(Stream<class_2338> instance, Predicate<? super class_2338> predicate, @Local(argsOnly=true) class_1657 player, @Local class_243 location, @Local double maxRange) {
        return instance.filter(p -> ToolboxHandler.distance((class_243)CompatUtil.INSTANCE.toSameSpaceAs(player.method_37908(), location, (class_2338)p), (class_2338)p) < maxRange * maxRange);
    }

    @Redirect(method={"getNearest"}, at=@At(value="INVOKE", target="Ljava/util/stream/Stream;sorted(Ljava/util/Comparator;)Ljava/util/stream/Stream;"))
    private static Stream<class_2338> replaceSortingLambda(Stream<class_2338> instance, Comparator<? super class_2338> comparator, @Local(argsOnly=true) class_1657 player, @Local class_243 location) {
        return instance.sorted(Comparator.comparingDouble(p -> ToolboxHandler.distance((class_243)CompatUtil.INSTANCE.toSameSpaceAs(player.method_37908(), location, (class_2338)p), (class_2338)p)));
    }

    @WrapOperation(method={"withinRange"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/equipment/toolbox/ToolboxHandler;distance(Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/core/BlockPos;)D")})
    private static double adjustToolboxPos(class_243 playerPos, class_2338 toolboxPos, Operation<Double> original, @Local(argsOnly=true) class_1657 player) {
        return (Double)original.call(new Object[]{CompatUtil.INSTANCE.toSameSpaceAs(player.method_37908(), playerPos, toolboxPos), toolboxPos});
    }
}


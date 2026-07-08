/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_10
 *  net.minecraft.class_12
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_1950
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_3610
 *  net.minecraft.class_8
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.ai.node_evaluator;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.class_10;
import net.minecraft.class_12;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_1950;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_3610;
import net.minecraft.class_8;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.mixin.feature.ai.node_evaluator.PathNavigationRegionAccessor;

@Mixin(value={class_12.class})
public abstract class SwimNodeEvaluatorMixin
extends class_8 {
    @WrapOperation(at={@At(value="INVOKE", target="Lnet/minecraft/world/level/BlockGetter;getFluidState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/material/FluidState;")}, method={"getBlockPathType(Lnet/minecraft/world/level/BlockGetter;IIILnet/minecraft/world/entity/Mob;)Lnet/minecraft/world/level/pathfinder/BlockPathTypes;"})
    private class_3610 getFluidStateRedirectPathType(class_1922 instance, class_2338 blockPos, Operation<class_3610> original) {
        class_3610[] fluidState = new class_3610[]{(class_3610)original.call(new Object[]{instance, blockPos})};
        class_1937 level = null;
        if (!VSGameConfig.SERVER.getAiOnShips()) {
            if (instance instanceof class_1950) {
                level = ((PathNavigationRegionAccessor)instance).getLevel();
            } else if (instance instanceof class_1937) {
                level = (class_1937)instance;
            }
            if (level != null && fluidState[0].method_15769()) {
                double origX = blockPos.method_10263();
                double origY = blockPos.method_10264();
                double origZ = blockPos.method_10260();
                class_1937 finalLevel = level;
                VSGameUtilsKt.transformToNearbyShipsAndWorld(level, origX, origY, origZ, 2.0, (x, y, z) -> {
                    class_2338 groundPos = class_2338.method_49637((double)x, (double)y, (double)z);
                    class_3610 tempFluidState = (class_3610)original.call(new Object[]{finalLevel, groundPos});
                    if (!tempFluidState.method_15769()) {
                        fluidState[0] = tempFluidState;
                    }
                });
            }
        }
        return fluidState[0];
    }

    @WrapOperation(at={@At(value="INVOKE", target="Lnet/minecraft/world/level/BlockGetter;getBlockState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;")}, method={"getBlockPathType(Lnet/minecraft/world/level/BlockGetter;IIILnet/minecraft/world/entity/Mob;)Lnet/minecraft/world/level/pathfinder/BlockPathTypes;"})
    private class_2680 getBlockStateRedirectPathType(class_1922 instance, class_2338 blockPos, Operation<class_2680> original) {
        class_2680[] blockState = new class_2680[]{(class_2680)original.call(new Object[]{instance, blockPos})};
        if (instance instanceof class_1950 && blockState[0].method_26215() && VSGameConfig.SERVER.getAiOnShips()) {
            class_1937 level = ((PathNavigationRegionAccessor)instance).getLevel();
            double origX = blockPos.method_10263();
            double origY = blockPos.method_10264();
            double origZ = blockPos.method_10260();
            VSGameUtilsKt.transformToNearbyShipsAndWorld(level, origX, origY, origZ, 1.0, (x, y, z) -> {
                class_2338 groundPos = class_2338.method_49637((double)x, (double)y, (double)z);
                class_2680 tempBlockState = (class_2680)original.call(new Object[]{level, groundPos});
                if (!tempBlockState.method_26215()) {
                    blockState[0] = tempBlockState;
                }
            });
        }
        return blockState[0];
    }

    @WrapOperation(at={@At(value="INVOKE", target="Lnet/minecraft/world/level/block/state/BlockState;isPathfindable(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/pathfinder/PathComputationType;)Z")}, method={"getBlockPathType(Lnet/minecraft/world/level/BlockGetter;IIILnet/minecraft/world/entity/Mob;)Lnet/minecraft/world/level/pathfinder/BlockPathTypes;"})
    private boolean isPathFindableRedirectPathType(class_2680 instance, class_1922 blockGetter, class_2338 blockPos, class_10 pathComputationType, Operation<Boolean> original) {
        boolean[] isPathFindable = new boolean[]{(Boolean)original.call(new Object[]{instance, blockGetter, blockPos, pathComputationType})};
        if (!isPathFindable[0] && VSGameConfig.SERVER.getAiOnShips()) {
            class_1937 level = null;
            if (blockGetter instanceof class_1950) {
                level = ((PathNavigationRegionAccessor)blockGetter).getLevel();
            } else if (blockGetter instanceof class_1937) {
                level = (class_1937)blockGetter;
            }
            if (level != null) {
                double origX = blockPos.method_10263();
                double origY = blockPos.method_10264();
                double origZ = blockPos.method_10260();
                class_1937 finalLevel = level;
                VSGameUtilsKt.transformToNearbyShipsAndWorld(level, origX, origY, origZ, 1.0, (x, y, z) -> {
                    class_2338 groundPos = class_2338.method_49637((double)x, (double)y, (double)z);
                    boolean pathfindable = (Boolean)original.call(new Object[]{instance, finalLevel, groundPos, pathComputationType});
                    if (pathfindable) {
                        isPathFindable[0] = true;
                    }
                });
            }
        }
        return isPathFindable[0];
    }

    @WrapOperation(at={@At(value="INVOKE", target="Lnet/minecraft/world/level/PathNavigationRegion;getFluidState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/material/FluidState;")}, method={"findAcceptedNode"})
    private class_3610 getFluidStateRedirectGetNode(class_1950 instance, class_2338 blockPos, Operation<class_3610> getFluidState) {
        class_3610[] fluidState = new class_3610[]{(class_3610)getFluidState.call(new Object[]{instance, blockPos})};
        class_1937 level = ((PathNavigationRegionAccessor)instance).getLevel();
        if (!VSGameConfig.SERVER.getAiOnShips() && level != null && fluidState[0].method_15769()) {
            double origX = blockPos.method_10263();
            double origY = blockPos.method_10264();
            double origZ = blockPos.method_10260();
            VSGameUtilsKt.transformToNearbyShipsAndWorld(level, origX, origY, origZ, 1.0, (x, y, z) -> {
                class_2338 groundPos = class_2338.method_49637((double)x, (double)y, (double)z);
                class_3610 tempFluidState = (class_3610)getFluidState.call(new Object[]{instance, groundPos});
                if (!tempFluidState.method_15769()) {
                    fluidState[0] = tempFluidState;
                }
            });
        }
        return fluidState[0];
    }
}

